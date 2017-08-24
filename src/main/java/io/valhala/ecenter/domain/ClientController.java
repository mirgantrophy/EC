package io.valhala.ecenter.domain;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ClientController 
{
	
	@RequestMapping("/create")
	@ResponseBody
	public String create(String name)
	{
		return name;
		
	}

}
