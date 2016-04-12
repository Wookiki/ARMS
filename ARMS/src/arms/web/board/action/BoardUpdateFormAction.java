package arms.web.board.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import arms.action.Action;
import arms.vo.ActionForward;
import arms.web.board.svc.BoardUpdateFormService;
import arms.web.board.vo.Article;

public class BoardUpdateFormAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
				String bName = request.getParameter("bName");
				int num = Integer.parseInt(request.getParameter("num"));
				String pageNum = request.getParameter("pageNum");
				String user = request.getParameter("user");
				BoardUpdateFormService boardUpdateFormService = new BoardUpdateFormService();
				
				Article article = boardUpdateFormService.getArticle(num,bName);		
				request.setAttribute("article", article);
				request.setAttribute("pageNum", pageNum);
				ActionForward forward = new ActionForward();
				
				if(article.getWriteID().equals(user)){
				forward.setUrl("updateForm.jsp");
				}
				else{
					response.setContentType("text/html; charset=UTF-8");
					PrintWriter out = response.getWriter();
					out.println("<script>");
					out.println("alert('작성자와 일치하지 않습니다')");
					out.println("history.back()");
					out.println("</script>");
				}
				
				return forward;
	}

}
