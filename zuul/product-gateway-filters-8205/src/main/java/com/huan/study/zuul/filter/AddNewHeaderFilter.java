package com.huan.study.zuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletResponse;

/**
 * 添加一个新的相应头
 *
 * @author huan.fu
 * @date 2018/6/12 - 18:01
 */
@Component
public class AddNewHeaderFilter extends ZuulFilter {

	@Override
	public String filterType() {
		return FilterConstants.POST_TYPE;
	}

	@Override
	public int filterOrder() {
		return FilterConstants.SEND_RESPONSE_FILTER_ORDER - 1;
	}

	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public Object run() {
		RequestContext requestContext = RequestContext.getCurrentContext();
		HttpServletResponse response = requestContext.getResponse();
		response.addHeader("new-header", "new-header");

		return null;
	}
}
