package arms.web.login.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import arms.action.Action;
import arms.vo.ActionForward;
import arms.web.login.svc.LoginMainService;
import arms.web.login.vo.UserInfo;

public class LoginMainAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		UserInfo loginUser = null;
		String id = request.getParameter("u_id");
		String passwd = request.getParameter("u_passwd");
		
		
		LoginMainService loginMainService = new LoginMainService();
		loginUser = loginMainService.checkLogin(id, passwd);
		System.out.println(loginUser);
		
		
		ActionForward forward = new ActionForward();
				
		if(loginUser !=null){
			forward.setRedirect(true);
			forward.setUrl("main.arms");
		}else {
	         response.setContentType("text/html;charset=UTF-8");
	         PrintWriter out = response.getWriter();
	         out.println("<script>");
	         out.println("alert('�α��� ����')");
	         out.println("history.back()");
	         out.println("</script>");
	      }
		return forward;
	}

}
