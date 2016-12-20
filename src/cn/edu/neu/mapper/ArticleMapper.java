package cn.edu.neu.mapper;

import java.util.List;

import javax.xml.stream.events.Comment;

import org.apache.ibatis.annotations.Param;

import cn.edu.neu.model.Article;
import cn.edu.neu.model.Articlecomment;

public interface ArticleMapper {

	public List<Article> getArtlist(int authorId);
	
	public void addArticle(int authorId, String title, String content);

	public boolean checkArtcile(int authorId, String title);

	public List<Article> getnowArt(@Param("artid")int artid);

	public void editArt(int artid, String content);

	public List<Articlecomment> getComment(@Param("artid")int artid);

	public void addComment(int ac_aricleId,@Param("ac_author")int ac_authorId, String ac_content);

	public void delarticle(int artid);

	public void delcomment(int ac_Id);


}
