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
		request.setCharacterEncoding("UTF-8");
		UserInfo userInfo = new UserInfo();
		userInfo.setU_id(request.getParameter("id"));
		userInfo.setU_passwd(request.getParameter("passwd"));
		
		ModifyPasswdService modifyPasswdService = new ModifyPasswdService();
		boolean modifyPasswdSuccess = modifyPasswdService.modifyPasswd(userInfo);
		
		ActionForward forward = new ActionForward();
		if(modifyPasswdSuccess){
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('수정성공')");
			out.println("history.back();");
			out.println("</script>");
			forward.setUrl("UserInfoDetailView.jsp");
		}else{
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('수정실패')");
			out.println("history.back();");
			out.println("</script>");
		}
		
		return forward;
	}

}
