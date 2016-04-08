package arms.web.login.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import arms.action.Action;
import arms.vo.ActionForward;
import arms.web.login.svc.ModifyPasswdService;
import arms.web.login.vo.UserInfo;

public class ModifyPasswdAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		UserInfo userInfo = new UserInfo();
		userInfo.setU_passwd(request.getParameter("passwd"));
		
		ModifyPasswdService modifyPasswdService = new ModifyPasswdService();
		boolean modifyPasswdSuccess = modifyPasswdService.modifyPasswd(userInfo);
		
		ActionForward forward = new ActionForward();
		if(modifyPasswdSuccess){
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('��������')");
			out.println("history.back();");
			out.println("</script>");
			forward.setRedirect(true);
			forward.setUrl("UserInfoDetailView.jsp");
		}else{
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('��������')");
			out.println("history.back();");
			out.println("</script>");
		}
		
		return forward;
	}

}
