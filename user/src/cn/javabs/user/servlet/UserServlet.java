package cn.javabs.user.servlet;

import cn.javabs.user.entity.User;
import cn.javabs.user.service.UserService;
import cn.javabs.user.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        String username = request.getParameter("username");
        String password= request.getParameter("password");
        String sex = request.getParameter("sex");

        User user=new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setSex(sex);
        System.out.println("dfghj:"+user.getUsername());

        UserService userService = new UserServiceImpl();
       int rows = userService.addUser(user);

        if (rows>0){
            response.getWriter().write("添加用户成功");

        }else{
            response.getWriter().write("添加用户失败");

        }


    }
}
