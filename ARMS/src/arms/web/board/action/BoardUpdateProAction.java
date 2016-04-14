package arms.web.board.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import arms.action.Action;
import arms.vo.ActionForward;
import arms.web.board.svc.BoardUpdateProService;
import arms.web.board.vo.Article;

public class BoardUpdateProAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		String bName = request.getParameter("bName");
		Article article = new Article();
		article.setContent(request.getParameter("content"));
		article.setNum(Integer.parseInt(request.getParameter("num")));
		article.setPasswd(Integer.parseInt(request.getParameter("passwd")));
		article.setSubject(request.getParameter("subject"));
		article.setWriteID(request.getParameter("writerid"));
		
		BoardUpdateProService boardUpdateService = new BoardUpdateProService();
		
		boolean modifySuccess = boardUpdateService.modifyArticle(article,bName);
		
		ActionForward forward = null;
		if(modifySuccess){
			forward = new ActionForward();
			forward.setRedirect(true);
			forward.setUrl("userListBoard.bo?bName="+bName);
		}
		else{
			response.setContentType("text/html);charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('수정실패')");
			out.println("history.back()");
			out.println("</script>");
		}
		return forward;
	}
	

}
