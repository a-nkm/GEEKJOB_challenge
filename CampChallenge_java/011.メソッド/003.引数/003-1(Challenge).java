
/*
 引数1
1. 引数として数値を受け取り、その値が奇数か偶数か判別＆表示するメソッドを作成してください。
2. 作成したメソッドを利用して、適当な数値の奇数・偶数の判別を行ってください。
*/

package org.camp.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.Random;
/**
 *
 * @author a-nkm
 */
public class Challenge extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    void kisu(int num,PrintWriter pw){
        if(num%2==0){
            pw.print(num +"は偶数です。<br>");
        }else{
            pw.print(num + "は奇数です。<br>");
        }
    }
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Challenge</title>");            
            out.println("</head>");
            out.println("<body>");
            Random rand = new Random();
            Integer num1 = rand.nextInt(10000);
            kisu(num1,out);
            
            out.println("</body>");
            out.println("</html>");
        }
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
