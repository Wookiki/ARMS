package arms.web.board.action;

import java.io.PrintWriter;
import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import arms.action.Action;
import arms.vo.ActionForward;
import arms.web.board.svc.BoardWriteService;
import arms.web.board.vo.Article;
import arms.web.board.vo.ReplyInfo;

public class BoardWriteProAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String bName = request.getParameter("bName");
		Article article = new Article();
		article.setContent(request.getParameter("content"));
		article.setNum(Integer.parseInt(request.getParameter("num")));
		article.setPasswd(Integer.parseInt(request.getParameter("passwd")));
		article.setRe_level(Integer.parseInt(request.getParameter("re_level")));
		article.setRe_step(Integer.parseInt(request.getParameter("re_step")));
		article.setRef(Integer.parseInt(request.getParameter("ref")));
		article.setReadcount(0);
//		article.setWriteDate(new Timestamp(System.currentTimeMillis()));
		article.setSubject(request.getParameter("subject"));
		article.setWriteID(request.getParameter("writerID"));
		
		BoardWriteService boardWriteService = new BoardWriteService();
		
		boolean registSuccess = boardWriteService.registArticle(article,bName);
		
		ActionForward forward = null;
		if(registSuccess){
			forward = new ActionForward();
			forward.setRedirect(true);
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
