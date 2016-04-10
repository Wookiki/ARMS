package arms.web.board.svc;
import static arms.db.jdbcUtil.*;

import java.sql.Connection;
import java.util.ArrayList;

import arms.web.board.dao.BoardDAO;
import arms.web.board.vo.Article;

public class BoardListService {
	
	public int getNoticeArticleCount() {
		// TODO Auto-generated method stub
		Connection con = getConnection();
		BoardDAO boardDAO = BoardDAO.getInstance();
		boardDAO.setConnection(con);
		int articleCount = boardDAO.selectNoticeArticleCount();
		close(con);
		return articleCount;
	}

	public ArrayList<Article> getNoticeArticleList(int startRow, int pageSize) {
		// TODO Auto-generated method stub
		Connection con = getConnection();
		BoardDAO boardDAO = BoardDAO.getInstance();
		boardDAO.setConnection(con);
		ArrayList<Article> articleList = boardDAO.selectNoticeArticleList(startRow, pageSize);
		
		close(con);
		return articleList;
	}
	
	public int getVolunteerArticleCount() {
		// TODO Auto-generated method stub
		Connection con = getConnection();
		BoardDAO boardDAO = BoardDAO.getInstance();
		boardDAO.setConnection(con);
		int articleCount = boardDAO.selectVolunteerArticleCount();
		close(con);
		return articleCount;
	}
	public ArrayList<Article> getVolunteerArticleList(int startRow, int pageSize) {
		// TODO Auto-generated method stub
		Connection con = getConnection();
		BoardDAO boardDAO = BoardDAO.getInstance();
		boardDAO.setConnection(con);
		ArrayList<Article> articleList = boardDAO.selectVolunteerArticleList(startRow, pageSize);		
		close(con);
		return articleList;
	}
	public int getFacilityArticleCount() {
		// TODO Auto-generated method stub
		Connection con = getConnection();
		BoardDAO boardDAO = BoardDAO.getInstance();
		boardDAO.setConnection(con);
		int articleCount = boardDAO.selectFacilityArticleCount();
		close(con);
		return articleCount;
	}
	public ArrayList<Article> getFacilityArticleList(int startRow, int pageSize) {
		// TODO Auto-generated method stub
		Connection con = getConnection();
		BoardDAO boardDAO = BoardDAO.getInstance();
		boardDAO.setConnection(con);
		ArrayList<Article> articleList = boardDAO.selectFacilityArticleList(startRow, pageSize);		
		close(con);
		return articleList;
	}

	

}
