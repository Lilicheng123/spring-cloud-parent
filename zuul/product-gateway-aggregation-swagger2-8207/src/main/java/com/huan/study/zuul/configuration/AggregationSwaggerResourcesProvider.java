package com.huan.study.zuul.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.zuul.filters.RouteLocator;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import springfox.documentation.swagger.web.SwaggerResource;
import springfox.documentation.swagger.web.SwaggerResourcesProvider;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 聚合 swagger ui
 *
 * @author huan.fu
 * @date 2018/7/9 - 15:44
 */
@Component
@Primary
public class AggregationSwaggerResourcesProvider implements SwaggerResourcesProvider {

	@Autowired
	private RouteLocator routeLocator;

	@Override
	public List<SwaggerResource> get() {
		return routeLocator.getRoutes()
				.stream()
				.map(route -> swaggerResource(route.getId(), route.getFullPath().replace("**", "v2/api-docs")))
				.collect(Collectors.toList());
	}

	private SwaggerResource swaggerResource(String name, String location) {
		SwaggerResource swaggerResource = new SwaggerResource();
		swaggerResource.setName(name);
		swaggerResource.setLocation(location);
		swaggerResource.setSwaggerVersion("2.0");
		return swaggerResource;
	}
}
