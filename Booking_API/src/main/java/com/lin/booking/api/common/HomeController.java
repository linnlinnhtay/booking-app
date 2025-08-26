package com.lin.booking.api.common;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	@GetMapping("/")
	public void redirectToSwagger(HttpServletResponse response) throws IOException {
		response.sendRedirect("swagger-ui.html");
	}

}
