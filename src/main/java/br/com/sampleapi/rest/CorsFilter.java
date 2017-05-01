package br.com.sampleapi.rest;

import javax.ws.rs.ext.Provider;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;

@Provider
public class CorsFilter implements ContainerResponseFilter {

	@Override
	public void filter(ContainerRequestContext request, ContainerResponseContext response) {
		response.getHeaders().putSingle("Access-Control-Allow-Origin", "*");
		response.getHeaders().putSingle("Access-Control-Expose-Headers", "Location");
		response.getHeaders().putSingle("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, HEAD, OPTIONS");
		response.getHeaders().putSingle("Access-Control-Allow-Headers",
				"Content-Type, User-Agent, X-Requested-With, X-Requested-By, Cache-Control");
		response.getHeaders().putSingle("Access-Control-Allow-Credentials", "true");
	}
}