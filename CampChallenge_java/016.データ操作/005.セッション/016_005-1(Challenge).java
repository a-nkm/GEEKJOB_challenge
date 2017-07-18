/*
016.005-1
セッションに現在時刻を記録し、次にアクセスした際に、前回記録した日時を表示。
*/
package org.camp.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpSession;
import java.util.*;
import java.text.SimpleDateFormat;

/**
 *
 * @author a-nkm
 */
public class Challenge extends HttpServlet {
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Challenge</title>");            
            out.println("</head>");
            out.println("<body>");
            // セッションへ現在時刻を記録し、前回記録した日時を表示
            // セッションの場合は即更新のため実行順に注意
            Date now = new Date();
            SimpleDateFormat sdf= new SimpleDateFormat("yyyy/M/d H:mm:ss");
            HttpSession hs = request.getSession();
            // セッションから前回の情報を取得 
            String LastLogin = (String)hs.getAttribute("LastLogin");
            out.print("前回のログイン時間：" + LastLogin +"<br>");          
            // セッションへ今回の情報登録
            hs.setAttribute("LastLogin",sdf.format(now));
            LastLogin = (String)hs.getAttribute("LastLogin");
            out.print("今回のログイン時間：" + LastLogin +"<br>");
            
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}


