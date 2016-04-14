package arms.web.board.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import arms.action.Action;
import arms.vo.ActionForward;

public class BoardDeleteFormAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		String num = request.getParameter("num");
		String pageNum = request.getParameter("pageNum");
		System.out.println(num);
		ActionForward forward = new ActionForward();
		request.setAttribute("num", num);
		request.setAttribute("pageNum", pageNum);
		forward.setUrl("deleteForm.jsp");
		
		return forward;
	}

}
