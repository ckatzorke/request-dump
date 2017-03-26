package io.katzorke.requestdump;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.Test;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletRequest;

public class RequestDumpTest {

	@Test
	public void requestDumpFromRequest() throws Exception {
		MockHttpServletRequest request = new MockHttpServletRequest();
		request.addHeader("Content-Type", MediaType.APPLICATION_JSON_UTF8_VALUE);
		request.addHeader("accept", MediaType.APPLICATION_JSON_UTF8_VALUE);
		request.addHeader("X-CSRF-TOKEN", "12345678-12345678");
		request.setMethod("GET");

		RequestDump fromRequest = RequestDump.fromRequest(request);
		assertEquals(HttpMethod.GET, fromRequest.getMethod());

		assertTrue(fromRequest	.getRequestHeaders()
								.containsKey("accept"));
		assertTrue(fromRequest	.getRequestHeaders()
								.get("Content-Type")
								.contains(MediaType.APPLICATION_JSON_UTF8_VALUE));

		assertTrue(fromRequest	.getRequestParameters()
								.isEmpty());

	}

	@Test
	public void requestDumpFromRequestPOST() throws Exception {
		MockHttpServletRequest request = new MockHttpServletRequest();
		request.addHeader("Content-Type", MediaType.APPLICATION_JSON_UTF8_VALUE);
		request.addParameter("test", "value");
		request.addParameter("alphabet", "a", "b", "c");
		request.setMethod("POST");

		RequestDump fromRequest = RequestDump.fromRequest(request);
		assertEquals(HttpMethod.POST, fromRequest.getMethod());

		assertTrue(fromRequest	.getRequestParameters()
								.containsKey("test"));
		assertTrue(fromRequest	.getRequestParameters()
								.containsKey("alphabet"));
		assertTrue(fromRequest	.getRequestParameters()
								.get("alphabet")
								.containsAll(Arrays.asList("a", "b", "c")));

	}

	@Test
	public void requestDumpFromRequestSecure() throws Exception {
		MockHttpServletRequest request = new MockHttpServletRequest();
		request.setMethod("GET");

		RequestDump fromRequest = RequestDump.fromRequest(request);
		assertFalse(fromRequest.isSecure());

		request.setSecure(true);
		fromRequest = RequestDump.fromRequest(request);
		assertTrue(fromRequest.isSecure());
	}

}
