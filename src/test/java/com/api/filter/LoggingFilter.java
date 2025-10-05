package com.api.filter;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.api.listeners.TestListener;

import io.restassured.filter.Filter;
import io.restassured.filter.FilterContext;
import io.restassured.response.Response;
import io.restassured.specification.FilterableRequestSpecification;
import io.restassured.specification.FilterableResponseSpecification;

public class LoggingFilter implements Filter {
	private static final Logger logger = LogManager.getLogger(LoggingFilter.class);

	@Override
	public Response filter(FilterableRequestSpecification requestSpec, FilterableResponseSpecification responseSpec,
			FilterContext ctx) {
		
		logRequestDetails(requestSpec);
		Response response = ctx.next(requestSpec, responseSpec);//Request is going to the server and response is coming back from the server
        logResponseDetails(response);//Logging the response details
		return response;
	}
	
	public void logRequestDetails(FilterableRequestSpecification requestSpec) {
		logger.info("Request Method: " + requestSpec.getMethod());
		logger.info("Request URI: " + requestSpec.getURI());
		logger.info("Request Headers: " + requestSpec.getHeaders());
		logger.info("Request Body: " + requestSpec.getBody());
	}
	
	
	public void logResponseDetails(Response response) {
		logger.info("Response Status Code: " + response.getStatusCode());
		logger.info("Response Headers: " + response.getHeaders());
		logger.info("Response Body: " + response.getBody().asPrettyString());
	}

}
