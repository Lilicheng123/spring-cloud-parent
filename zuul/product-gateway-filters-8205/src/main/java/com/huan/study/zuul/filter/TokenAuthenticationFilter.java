package com.huan.study.zuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.apache.commons.lang.StringUtils;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.cloud.netflix.zuul.util.ZuulRuntimeException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * Token 认证前置过滤器
 *
 * @author huan.fu
 * @date 2018/6/12 - 16:34
 */
@Component
public class TokenAuthenticationFilter extends ZuulFilter {

	private static final String TOKEN_PARAMETER = "token";

	@Override
	public String filterType() {
		// pre 类型的过滤器
		return FilterConstants.PRE_TYPE;
	}

	@Override
	public int filterOrder() {
		// token 检验应该放在第一位来进行校验，因此需要放在最前面
		return FilterConstants.SERVLET_DETECTION_FILTER_ORDER - 1;
	}

	@Override
	public boolean shouldFilter() {
		// 过滤器是否应该执行， true:表示应该执行  false:表示跳过这个过滤器执行
		return true;
	}

	@Override
	public Object run() {
		RequestContext requestContext = RequestContext.getCurrentContext();
		// 获取到 request
		HttpServletRequest request = requestContext.getRequest();
		// 判断请求参数中是否存在  token  参数
		String token = request.getParameter(TOKEN_PARAMETER);
		if (StringUtils.isBlank(token)) {
			// 不进行路由 ===> 即 route 类型的过滤器不执行
			requestContext.setSendZuulResponse(false);
			throw new ZuulRuntimeException(new ZuulException(this.filterType() + ":" + this.getClass().getSimpleName(), HttpStatus.UNAUTHORIZED.value(), "token参数不可为空"));
		}
		return null;
	}
}
