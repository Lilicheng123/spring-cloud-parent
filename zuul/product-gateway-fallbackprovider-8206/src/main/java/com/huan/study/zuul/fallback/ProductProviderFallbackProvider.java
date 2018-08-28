package com.huan.study.zuul.fallback;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.Maps;
import com.netflix.hystrix.exception.HystrixTimeoutException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.netflix.zuul.filters.route.FallbackProvider;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Map;

/**
 * <pre>
 * 服务回退
 * 	建议实现  FallbackProvider 接口，这个接口可以拿到发生回退的原因，可以根据具体的异常返回不同的信息到前台
 * 	         ZuulFallbackProvider 这个接口，已经被标记成过时了，不要在使用。
 * </pre>
 *
 * @author huan.fu
 * @date 2018/6/13 - 11:50
 */
@Component
@Slf4j
public class ProductProviderFallbackProvider implements FallbackProvider {

	@Override
	public String getRoute() {
		// 返回 null 或者 * 表示为所谓路由的服务提供一个默认的回退实现
		return "product-provider";
	}

	@Override
	public ClientHttpResponse fallbackResponse(final Throwable cause) {
		log.info("zuul error:", cause);
		if (cause instanceof HystrixTimeoutException) {
			return response(HttpStatus.GATEWAY_TIMEOUT);
		} else {
			return fallbackResponse();
		}
	}

	@Override
	public ClientHttpResponse fallbackResponse() {
		return response(HttpStatus.INTERNAL_SERVER_ERROR);
	}

	private ClientHttpResponse response(final HttpStatus status) {
		return new ClientHttpResponse() {
			@Override
			public HttpStatus getStatusCode() {
				return status;
			}

			@Override
			public int getRawStatusCode() {
				return status.value();
			}

			@Override
			public String getStatusText() {
				return status.getReasonPhrase();
			}

			@Override
			public void close() {
			}

			@Override
			public InputStream getBody() throws JsonProcessingException {
				Map<String, Object> ret = Maps.newHashMap();
				ret.put("msg", "商品服务不可用");
				ret.put("code", -999999);
				return new ByteArrayInputStream(new ObjectMapper().writeValueAsBytes(ret));
			}

			@Override
			public HttpHeaders getHeaders() {
				HttpHeaders headers = new HttpHeaders();
				headers.setContentType(MediaType.APPLICATION_JSON);
				return headers;
			}
		};
	}
}
