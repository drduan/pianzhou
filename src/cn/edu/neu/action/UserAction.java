package cn.edu.neu.action;

import java.lang.ProcessBuilder.Redirect;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.catalina.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.edu.neu.core.Constants;
import cn.edu.neu.model.Article;
import cn.edu.neu.model.Articlecomment;
import cn.edu.neu.model.User;
import cn.edu.neu.service.ArticleService;
import cn.edu.neu.service.UserService;

@Controller
@RequestMapping("/user")
public class UserAction extends BaseAction{

	@Autowired
	private UserService userService;

	@Autowired
	private ArticleService ArticleService;
	
	/**
	 * 用户登录
	 */

	@RequestMapping("/login")
	public String login(User user,HttpSession session,Map<String,List> g,Map<String,List> un,Model model){
		System.out.println("userlogin:"+user);
		User dbUser=userService.checkUser(user);
		System.out.println(user.getUserName()+","+user.getUserPass()+"--------"+user);
		Map<String,User> m=new HashMap<String,User>();
		if(dbUser!=null){	
			session.setAttribute("user", dbUser);			
			m.put("login", user);	
			System.out.println(dbUser);			
			//this.addMessage("登录成功");
			//this.addRedirURL("用户页面", "head");
			
			
			
			return "/self/home"; 
		}
		else{
			//this.addMessage(Constants.LOGIN_ERR);
			//this.addRedirURL("返回登录页面", INDEX_PAGE);
			System.out.println("========"+dbUser);
			m.put("login",user);	
			return "index"; 
		}
		
	}
	/*
	 * 首页面通过点击注册跳转到注册页面
	 * */
	@RequestMapping("/toreg")
	public String toReg() throws Exception{
		return "register";
	}
	
	
	
	
	/**
	 * 用户登出
	 */
	@ResponseBody
	@RequestMapping("/logout")
	public Map<String,String> logout() throws Exception {
		getSession().invalidate();
		Map<String,String> m=new HashMap<String,String>();
		m.put("logout", "yes");
		return m;
	}
	
	
	
	/**
	 * 用户注册
	 */
	/*@RequestMapping("/reg")
	public String reg(User user,@RequestParam(required=false) String techSch,HttpServletRequest request) throws Exception {		
		
		//System.out.println("@@@"+user.getId()+"university"+universityname);
		
		//因为university
//		if(universityname == null)
//		{
//			 universityname = "1";
//		   //return null;
//		   
//		}
		//System.out.println("@@@@dadasd"+request.getParameter("hvar"));
		if(request.getParameter("hvar").toString().equals("worker")){
			//System.out.println("homeCity:"+user.getHomeCity());
			//System.out.println("homePro:"+user.getHomePro());
			
			System.out.println("<DOCTYPE html>reg<html>");
			int text1 = Integer.parseInt(request.getParameter("selectp"));
			int text2 = Integer.parseInt(request.getParameter("selectc"));
			user.setHomeCity(text2);
			user.setHomePro(text1);
			boolean f = userService.regUser(user);
			
			//System.out.println(user.getUserName());
			//System.out.println(user.getUserPass());
			//System.out.println(user.getUserSex());
			//System.out.println(user.getUserEmail());

			
			//System.out.println("homePro:"+user.getHomePro());
			//System.out.println("homeCity:"+user.getHomeCity());
			
			
			
			//System.out.println("reg@@@@@@@@@@@@@"+"text: "+text1+" homePro:"+text2);
			Map<String,String> m=new HashMap<String,String>();
			if(f){
				m.put("reg", "yes");
			}else{
				m.put("reg", "no");
			}
			
			
		}else {
			// 存大学生数据
			boolean f= userService.university(user);
			user.setTechSch(techSch);
			//System.out.println("@@@@@@@@@@student "+f);
			
			//System.out.println(user.getName());
			//System.out.println(user.getPwd());
			//System.out.println(user.getSex());

			//System.out.println("un:"+universityname);
			
			Map<String,String> m=new HashMap<String,String>();
			if(f){
				m.put("reg", "yes");
			}else{
				m.put("reg", "no");
			}
			
		}
		return "index";
		
	}*/
	/**
	 * 检查用户是否重复
	 */
	@ResponseBody
	@RequestMapping("/checkUserName")
	public Map<String,Boolean> checkUserName(@RequestParam String userName) throws Exception {	
		return null;
	}
	
	/**
	 * 获取所有用户列表
	 * @param request
	 * @return
	 */
	@RequestMapping("/getAllUsers")
	public String getAllUsers(HttpServletRequest request){
		
		return "";
	}
	

	
	/**
	 * 管理员登录
	 */
	
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
			return "/self/home";
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
