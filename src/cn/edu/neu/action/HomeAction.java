package cn.edu.neu.action;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cn.edu.neu.model.Article;
import cn.edu.neu.model.User;
import cn.edu.neu.service.ArticleService;

@Controller
@RequestMapping("/home")

public class HomeAction extends BaseAction{
	@Autowired
	private ArticleService ArticleService;
	
	@RequestMapping("/toArticle")
	public String toArtlist(HttpSession session,Map<String,List<Article>> m) {
		User user = (User) session.getAttribute("user");
		int authorId = user.getUserId();
		System.out.println("getArtlist userId:"+authorId);
		List<Article> article = ArticleService.getArtlist(authorId);
		System.out.println("my:"+article);
		m.put("article", article);
		System.out.println("m:"+article);
        return "/self/article";
	}
	
}
