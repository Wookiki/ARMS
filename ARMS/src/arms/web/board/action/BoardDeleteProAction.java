package arms.web.board.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import arms.action.Action;
import arms.vo.ActionForward;
import arms.web.board.svc.BoardDeleteProService;

public class BoardDeleteProAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int num = Integer.parseInt(request.getParameter("num"));
		String bName = request.getParameter("bName");
		String pageNum = request.getParameter("pageNum");
		int passwd = Integer.parseInt(request.getParameter("passwd"));
		ActionForward forward = new ActionForward();
		BoardDeleteProService boardDeleteProService = new BoardDeleteProService();
		
		int deleteCount = boardDeleteProService.getDeleteArticle(num,passwd,bName);
		if(deleteCount > 0){			
			forward.setUrl("userListBoard.bo?bName="+bName);		
			
		}
		else{			
			response.setContentType("text/html);charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('등록실패')");
			out.println("history.back()");
			out.println("</script>");
		}
		return forward;
	}

}
