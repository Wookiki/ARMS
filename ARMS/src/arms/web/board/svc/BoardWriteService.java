package arms.web.board.svc;

import java.sql.Connection;

import arms.web.board.dao.BoardDAO;
import arms.web.board.vo.Article;
import static arms.db.jdbcUtil.*;

public class BoardWriteService {

	public boolean registArticle(Article article, String bName) {
		boolean registSuccess = false;
		Connection con = getConnection();
		BoardDAO boardDAO = BoardDAO.getInstance();
		boardDAO.setConnection(con);
		int insertCount = boardDAO.insertArticle(article,bName);
		if(insertCount>0){
			registSuccess = true;
			commit(con);			
		}
		else{
			rollback(con);
			
		}
		return registSuccess;
	}

}
