package cn.edu.neu.service;

import java.util.List;

import javax.xml.stream.events.Comment;

import cn.edu.neu.model.Article;
import cn.edu.neu.model.Articlecomment;

public interface ArticleService {

	List<Article> getArtlist(int authorId);

	void addArticle(int authorId, String title, String content,String img_url);

	boolean checkArtcile(int authorId, String title);

	List<Article> getnowArt(int artid);

	void editArt(int artid, String content);

	List<Articlecomment> getComment(int artid);

	void addComment(int ac_articleIdint,int ac_authorId, String ac_content);

	void delarticle(int artid);

	void delcomment(int ac_Id);



}
