package com.huan.study.springcloud.config;

import de.codecentric.boot.admin.event.ClientApplicationEvent;
import de.codecentric.boot.admin.event.ClientApplicationStatusChangedEvent;
import de.codecentric.boot.admin.notify.AbstractEventNotifier;
import de.codecentric.boot.admin.notify.RemindingNotifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * @author huan.fu
 *         应用程序上下线通知
 */
@Configuration
@EnableScheduling
public class NotifierConfiguration {

	private static final Logger log = LoggerFactory.getLogger(NotifierConfiguration.class);

	@Autowired
	private JavaMailSender javaMailSender;

	@Autowired
	private RemindingNotifier remindingNotifier;

	@Bean
	@Primary
	public RemindingNotifier remindingNotifier() {
		RemindingNotifier notifier = new RemindingNotifier(new AbstractEventNotifier() {
			@Override
			protected void doNotify(ClientApplicationEvent event) throws Exception {
				if (event instanceof ClientApplicationStatusChangedEvent) {
					ClientApplicationStatusChangedEvent changedEvent = (ClientApplicationStatusChangedEvent) event;
					log.info("Application {} ({}) is {}", event.getApplication().getName(), event.getApplication().getId(), changedEvent.getTo().getStatus());
					String text = String.format("应用:%s 服务ID:%s,服务ip:%s 状态改变为：[%s ---> %s]，时间：%s"
							, event.getApplication().getName()
							, event.getApplication().getId()
							, event.getApplication().getHealthUrl()
							, ((ClientApplicationStatusChangedEvent) event).getFrom().getStatus()
							, ((ClientApplicationStatusChangedEvent) event).getTo().getStatus()
							, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(changedEvent.getTimestamp())));
					log.warn(text);
					SimpleMailMessage message = new SimpleMailMessage();
					message.setTo("1451578387@qq.com");
					message.setFrom("fuhuan@juxinli.com");
					message.setSubject("服务状态改变");
					message.setText(text);
					javaMailSender.send(message);
				} else {
					log.info("Application {} ({}) {}", event.getApplication().getName(), event.getApplication().getId(), event.getType());
				}
			}
		});
		// 每5分钟就需要提醒一次，并不一定会提醒，有RemindingNotifier里面的状态进行决定
		notifier.setReminderPeriod(TimeUnit.MINUTES.toMillis(5));
		return notifier;
	}

	/**
	 * 每隔一分钟检查还有那些需要进行提醒
	 */
	@Scheduled(fixedRate = 1_000L)
	public void remind() {
		remindingNotifier.sendReminders();
	}
}