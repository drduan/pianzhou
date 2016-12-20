package cn.edu.neu.action;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import cn.edu.neu.model.Article;
import cn.edu.neu.model.Articlecomment;
import cn.edu.neu.model.User;
import cn.edu.neu.service.ArticleService;

@Controller
@RequestMapping("/article")
public class ArticleAction extends BaseAction{
	
	@Autowired
	private ArticleService ArticleService;
	
    @RequestMapping("/toaddarticle")
    public String toAddarticle() throws Exception{
    	
    	return"/self/add_article";
    }
	
        @RequestMapping("/addArticle")
	    public String addArticle(@RequestParam(required = false) String title,
		          @RequestParam(required = false) String content, 
			        HttpSession session,Map<String,List> m) {

		    System.out.println("title: " + title +"content: " + content);
		    User user = (User) session.getAttribute("user"); 
		    int authorId = user.getUserId();
		    
			ArticleService.addArticle(authorId, title, content);				
			List<Article> article = ArticleService.getArtlist(authorId);			
			System.out.println("my:"+article);			
			m.put("article", article);	
			System.out.println("m:"+m);
			return "/self/article";
		}
	
	    @RequestMapping("/clickart")
	    public String clickart(@RequestParam(required = false)int artid,Map<String,List> m,Map<String, List> c) {
	    	
	    	System.out.println(artid);	    	
			List<Article> artId = ArticleService.getnowArt(artid);			
			System.out.println("my:"+artId);			
			m.put("article", artId);
			List<Articlecomment> comment = ArticleService.getComment(artid);
			System.out.println("com:"+comment);	
			System.out.println("m:"+m);	
			c.put("comment",comment);
			c.put("articlecomment",comment);
			return "/self/click_article";
		}
	    
	    @RequestMapping("/to_editart")
	    public String to_editart(@RequestParam(required = false)int artid,Map<String,List> m) {
	    	System.out.println(artid);	    	
			List<Article> artId = ArticleService.getnowArt(artid);			
			System.out.println("my:"+artId);			
			m.put("article", artId);
			
			System.out.println("m:"+m);
			return "self/edit_article";	    	
	    }
	    
	    @RequestMapping("/do_editart")
	    public String editart(HttpSession session,@RequestParam(required = false)int artid,
	    		@RequestParam(required=false)String content,Map<String, List> m,Map<String, List> a){
	    	
	    	System.out.println(artid);
	    	ArticleService.editArt(artid, content);
	    	//返回列表
		    User user = (User) session.getAttribute("user"); 
		    int authorId = user.getUserId();	    
			List<Article> article = ArticleService.getArtlist(authorId);	
			System.out.println("my:"+article);			
			m.put("article", article);		
			System.out.println("m:"+m);
			// return "/self/addOrChoiceAlblum";
			return "/self/article";
	    }
	    @RequestMapping("/comment")
	    public String comment(HttpSession session,@RequestParam(required=false)int ac_articleId,
	    		@RequestParam(required=false)String ac_content,Map<String,List> m,Map<String, List> c,
	    		HttpServletRequest request){
	    	//添加评论
	    	User user = (User)session.getAttribute("user");
	    	int ac_authorId = user.getUserId();
	    	System.out.println(ac_articleId+ac_authorId+ac_content);
	    	ArticleService.addComment(ac_articleId,ac_authorId,ac_content);
	    	//返回页面
	    	
	    	int artid = Integer.parseInt(request.getParameter("ac_articleId"));	    	
	    	System.out.println(artid);	    	
			List<Article> artId = ArticleService.getnowArt(artid);			
			System.out.println("my:"+artId);			
			m.put("article", artId);
			List<Articlecomment> comment = ArticleService.getComment(artid);
			System.out.println("com:"+comment);	
			System.out.println("m:"+m);	
			c.put("comment",comment);
			c.put("articlecomment",comment);
	    	

	    	return "/self/click_article";    	
	    }
	    
	    @RequestMapping("/delart")
	    public String delart(HttpSession session,@RequestParam(required = false)int artid,Map<String, List> m){
	    	
	    	ArticleService.delarticle(artid);
	    	    	
		    User user = (User) session.getAttribute("user"); 
		    int authorId = user.getUserId();			
			List<Article> article = ArticleService.getArtlist(authorId);			
			System.out.println("my:"+article);			
			m.put("article", article);	
			System.out.println("m:"+m);
			return "/self/article";
	    }
	    
	    @RequestMapping("/delcomment")
	    public String delcomment(@RequestParam(required = false)int ac_Id,Map<String, List> m,Map<String, List> c,HttpServletRequest request,
	    		@RequestParam(required = false)int ac_articleId){
	    	System.out.println(ac_articleId);
	    	ArticleService.delcomment(ac_Id);
	    	
	    	System.out.println(ac_articleId);
	    	int artid = Integer.parseInt(request.getParameter("ac_articleId"));	    	
	    	System.out.println(artid);	    	
			List<Article> artId = ArticleService.getnowArt(artid);			
			System.out.println("my:"+artId);			
			m.put("article", artId);
			List<Articlecomment> comment = ArticleService.getComment(artid);
			System.out.println("com:"+comment);	
			System.out.println("m:"+m);	
			c.put("comment",comment);
			c.put("articlecomment",comment);
	    	

	    	return "/self/click_article";    
	    }

	    @RequestMapping("/return_list")
	    public String return_list(HttpSession session,Map<String,List> m){
		    User user = (User) session.getAttribute("user"); 
		    int authorId = user.getUserId();				
			List<Article> article = ArticleService.getArtlist(authorId);			
			System.out.println("my:"+article);			
			m.put("article", article);	
			System.out.println("m:"+m);
			return "/self/article";
	    }
	    
	    @RequestMapping("/return_article")
	    public String return_article(@RequestParam(required=false)int artid,
	    		Map<String, List> m,Map<String, List> c){    		    	
	    	System.out.println(artid);	    	
			List<Article> artId = ArticleService.getnowArt(artid);			
			System.out.println("my:"+artId);			
			m.put("article", artId);
			List<Articlecomment> comment = ArticleService.getComment(artid);
			System.out.println("com:"+comment);	
			System.out.println("m:"+m);	
			c.put("comment",comment);
			c.put("articlecomment",comment);
			return "/self/click_article";
	    	
	    }

}
	    	   
	 
	


