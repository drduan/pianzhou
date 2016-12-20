package cn.edu.neu.service.impl;

import java.util.List;

import javax.annotation.Resource;
import javax.xml.stream.events.Comment;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.edu.neu.mapper.ArticleMapper;
import cn.edu.neu.model.Article;
import cn.edu.neu.model.Articlecomment;
import cn.edu.neu.service.ArticleService;

@Service
@Transactional
public class ArticleServiceImpl implements ArticleService{

	@Resource
	private ArticleMapper mapper;
	
	@Override
	public List<Article> getArtlist(int authorId) {
		// TODO Auto-generated method stub
		return mapper.getArtlist(authorId);
	}

	@Override
	public void addArticle(int authorId, String title, String content) {
		// TODO Auto-generated method stub
		mapper.addArticle(authorId, title, content);
	}

	@Override
	public boolean checkArtcile(int authorId, String title) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Article> getnowArt(int artid) {
		// TODO Auto-generated method stub
		return mapper.getnowArt(artid);
	}

	@Override
	public void editArt(int artid, String content) {
		// TODO Auto-generated method stub
		mapper.editArt(artid,content);
	}

	@Override
	public List<Articlecomment> getComment(int artid) {
		// TODO Auto-generated method stub
		return mapper.getComment(artid);
	}
	
	@Override
	public void addComment(int ac_articleId,int ac_authorId, String ac_content) {
		// TODO Auto-generated method stub
		mapper.addComment(ac_articleId,ac_authorId,ac_content);
	}

	@Override
	public void delarticle(int artid) {
		mapper.delarticle(artid);
		
	}

	@Override
	public void delcomment(int ac_Id) {
		// TODO Auto-generated method stub
		mapper.delcomment(ac_Id);
	}




}
