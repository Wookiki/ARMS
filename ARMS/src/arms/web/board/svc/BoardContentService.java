package arms.web.board.svc;

import java.sql.Connection;
import static arms.db.jdbcUtil.*;
import arms.web.board.dao.BoardDAO;
import arms.web.board.vo.Article;

public class BoardContentService {

	public Article getNoticeConArticle(int num) {
		Connection con = getConnection();
		BoardDAO boardDAO = BoardDAO.getInstance();
		boardDAO.setConnection(con);
		Article conArticle = boardDAO.selectNoticeArticle(num);
		close(con);
		return conArticle;
	}
	public Article getVolunteerConArticle(int num) {
		Connection con = getConnection();
		BoardDAO boardDAO = BoardDAO.getInstance();
		boardDAO.setConnection(con);
		Article conArticle = boardDAO.selectVolunteerArticle(num);
		close(con);
		return conArticle;
	}

}
