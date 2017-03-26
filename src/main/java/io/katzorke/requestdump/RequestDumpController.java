package io.katzorke.requestdump;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RequestDumpController {

	@RequestMapping("/requestdump")
	public RequestDump dumpRequest(HttpServletRequest request) {
		return RequestDump.fromRequest(request);
	}

}
