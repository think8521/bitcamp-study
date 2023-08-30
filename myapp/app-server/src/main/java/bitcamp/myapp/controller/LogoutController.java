package bitcamp.myapp.controller;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/auth/logout")
public class LogoutController implements PageController {
  @Override
  public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
    request.getSession().invalidate();
    return "redirect:/";
  }
}
