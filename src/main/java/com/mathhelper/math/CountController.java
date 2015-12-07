package com.mathhelper.math;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("gameSite/count")
public class CountController {
	
	@RequestMapping(value="/", method=RequestMethod.POST)
	public String chooseNumber(@RequestParam(required=true, value="tableNumber") String tabelNumber){
		System.out.println(tabelNumber);
		return "gameSite";
	}

}
