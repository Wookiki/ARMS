package arms.web.board.svc;

import java.sql.Connection;

import arms.web.board.dao.BoardDAO;
import arms.web.board.vo.Article;
import static arms.db.jdbcUtil.*;

public class BoardUpdateProService {

	public boolean modifyArticle(Article article, String bName) {
		// TODO Auto-generated method stub
		boolean modifySuccess = false;
		Connection con = getConnection();
		BoardDAO boardDAO = BoardDAO.getInstance();
		boardDAO.setConnection(con);		
		int updateCount = boardDAO.updateArticle(article,bName);
		if(updateCount > 0) {
			modifySuccess = true;
			commit(con);
		}
		else{
			rollback(con);
		}		
		return modifySuccess;
	}

}
