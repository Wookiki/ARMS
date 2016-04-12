package arms.web.board.svc;

import arms.web.board.dao.BoardDAO;
import arms.web.board.vo.Article;
import static arms.db.jdbcUtil.*;

import java.sql.Connection;

public class BoardUpdateFormService {

	public Article getArticle(int num, String bName) {
		// TODO Auto-generated method stub
				Connection con = getConnection();
				BoardDAO boardDAO = BoardDAO.getInstance();
				boardDAO.setConnection(con);
				Article article = boardDAO.selectOldArticle(num,bName);
				
				close(con);
				
				return article;
	}
	
}
