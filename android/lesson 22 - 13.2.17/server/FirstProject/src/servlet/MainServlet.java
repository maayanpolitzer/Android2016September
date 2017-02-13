package servlet;





import org.json.JSONException;
import org.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

@WebServlet(name = "MainServlet", urlPatterns = "/MyServlet")
public class MainServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("doPost()");
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        System.out.println("Name: " + name + ", password: " + password);
        PrintWriter writer = response.getWriter();
        writer.write("<html><head></head><body><h1>Thank you " + name + "!</h1></body></html>");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*
        Enumeration<String> params = request.getParameterNames();
        while(params.hasMoreElements()){
            System.out.println(params.nextElement());
        }
        */
        /*
        String s = request.getParameter("name");
        int age = Integer.parseInt(request.getParameter("age"));
        System.out.println("doGet()");
        PrintWriter writer = response.getWriter();
        System.out.println(s + "");
        if (s == null || s.isEmpty()) {
            writer.write("Thanks man !!!");
        }else{
            writer.write("Thanks " + s + " you are " + (age < 30 ? "young" : "old" ) + "!!!");
        }
        */

        String name = request.getParameter("name");
        int age = Integer.parseInt(request.getParameter("age"));
        System.out.println("Name: " + name + ", age: " + age);

        JSONObject object = new JSONObject();
        try {
            object.put("name", name);
            object.put("age", age);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        String json = object.toString();
        response.setContentType("application/json");
        response.setCharacterEncoding("utf-8");
        PrintWriter writer = response.getWriter();
        writer.write(json);

    }




}
