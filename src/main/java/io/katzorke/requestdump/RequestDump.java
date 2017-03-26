package io.katzorke.requestdump;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpMethod;

public class RequestDump {

	private Map<String, List<String>> requestHeaders;
	private Map<String, List<String>> requestParameters;
	private boolean secure;
	private HttpMethod method;

	public RequestDump() {
		//
	}

	public static RequestDump fromRequest(HttpServletRequest request) {
		RequestDump requestDump = new RequestDump();
		requestDump.setRequestHeaders(getHeaders(request));
		requestDump.setRequestParameters(getRequestParameters(request));
		requestDump.setMethod(HttpMethod.valueOf(request.getMethod()));
		requestDump.setSecure(request.isSecure());
		return requestDump;
	}

	private static Map<String, List<String>> getHeaders(HttpServletRequest request) {
		Map<String, List<String>> result = new HashMap<>();
		Enumeration<String> headerNames = request.getHeaderNames();
		while (headerNames.hasMoreElements()) {
			String headerName = headerNames.nextElement();
			List<String> headerValues = new ArrayList<>();
			Enumeration<String> headers = request.getHeaders(headerName);
			while (headers.hasMoreElements()) {
				headerValues.add(headers.nextElement());
			}
			result.put(headerName, headerValues);
		}
		return result;
	}

	private static Map<String, List<String>> getRequestParameters(HttpServletRequest request) {
		Map<String, String[]> parameterMap = request.getParameterMap();
		Map<String, List<String>> result = new HashMap<>();
		for (Map.Entry<String, String[]> entry : parameterMap.entrySet()) {
			result.put(entry.getKey(), Arrays.asList(entry.getValue()));
		}
		return result;
	}

	public Map<String, List<String>> getRequestHeaders() {
		return requestHeaders;
	}

	public void setRequestHeaders(Map<String, List<String>> requestHeaders) {
		this.requestHeaders = requestHeaders;
	}

	public Map<String, List<String>> getRequestParameters() {
		return requestParameters;
	}

	public void setRequestParameters(Map<String, List<String>> requestParameters) {
		this.requestParameters = requestParameters;
	}

	/**
	 * @return the secure
	 */
	public boolean isSecure() {
		return secure;
	}

	/**
	 * @param secure
	 *            the secure to set
	 */
	public void setSecure(boolean secure) {
		this.secure = secure;
	}

	public HttpMethod getMethod() {
		return method;
	}

	public void setMethod(HttpMethod method) {
		this.method = method;
	}
}
