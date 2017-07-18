/*
016.004-1
クッキーに現在時刻を記録し、次にアクセスした際に、前回記録した日時を表示。
*/
package org.camp.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.servlet.http.Cookie;
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
            // cookieへ現在時刻を記録し、次にアクセスした際に、前回記録した日時を表示してください。
            Date now = new Date();
            SimpleDateFormat sdf= new SimpleDateFormat();
            Cookie c = new Cookie("LastLogin",sdf.format(now));
            //Cookie反映
            response.addCookie(c);
            
            // cookie情報を取得し、"LastLogin"を探す
            Cookie[] cs = request.getCookies();
            if (cs != null) {
               for (int i = 0; i < cs.length; i++) {
                    if (cs[i].getName().equals("LastLogin")) {
                        out.print("前回のログイン日時：" + cs[i].getValue());
                        break;
                    }
               }
            }

            
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


