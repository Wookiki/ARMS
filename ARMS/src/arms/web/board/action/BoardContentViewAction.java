package arms.web.board.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import arms.action.Action;
import arms.vo.ActionForward;
import arms.web.board.svc.BoardContentService;
import arms.web.board.vo.Article;

public class BoardContentViewAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		BoardContentService boardContentService = new BoardContentService();
		int num = Integer.parseInt(request.getParameter("num"));
		String pageNum = request.getParameter("pageNum");	
		String bName = request.getParameter("bName");
		System.out.println(bName);
		Article conArticle = boardContentService.getConArticle(num,bName);		
		request.setAttribute("conArticle", conArticle);
		request.setAttribute("pageNum", pageNum);
		ActionForward forward = new ActionForward();
		forward.setUrl("contentBoard.jsp");
		
		return forward;
	}

}
