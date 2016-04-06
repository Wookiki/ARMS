package arms.web.login.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import arms.action.Action;
import arms.vo.ActionForward;
import arms.web.login.svc.IdCheckService;

public class IdCheckAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		String id = request.getParameter("id");
		IdCheckService idCheckService = new IdCheckService();
		
		boolean idExists = idCheckService.existId(id);
		System.out.println("id =" + id);
		System.out.println("idExists = " + idExists);
		request.setAttribute("id", id);
		request.setAttribute("idExists", idExists);
		
		ActionForward forward = new ActionForward();
		forward.setUrl("/Login/idCheck.jsp");
		
		return forward;
	}

}
