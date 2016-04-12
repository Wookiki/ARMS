package arms.web.board.svc;

import java.sql.Connection;
import static arms.db.jdbcUtil.*;

import arms.web.board.dao.BoardDAO;
import arms.web.board.vo.Article;

public class BoardContentService {

	public Article getConArticle(int num, String bName) {
		Connection con = getConnection();
		BoardDAO boardDAO = BoardDAO.getInstance();
		boardDAO.setConnection(con);
		Article conArticle = boardDAO.selectArticle(num,bName);
		close(con);
		return conArticle;
	}

}
