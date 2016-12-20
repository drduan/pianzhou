package cn.edu.neu.action;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class IndexAction extends BaseAction{
	
	@RequestMapping("/index")
	public String getIndexPage(Map<String,List> m){
		//System.out.println("indexaction");
		
		return "home";
	}
}
