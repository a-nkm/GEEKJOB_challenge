/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/*
引数2 009.003-2
1. ３つの引数を持ち、渡された数値で掛け算をするメソッドを作成します。
メソッドは、１つ目の引数と２つ目の引数を掛け算し、３つ目の引数がtrueの場合は結果を２乗させてください。
また、２つ目の引数は5、３つ目の引数はfalseをデフォルト値として設定してください。
2. 作成したメソッドを呼び出し、結果を表示してください。
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
    int Multiplication(int num1,int num2, boolean flag){
        int ans = num1*num2;
        
        if(flag==true){
            return ans*ans;
        }else{
            return ans;
        }
    }
    int Multiplication(int num1,int num2){
        return Multiplication(num1,num2,false);
    }
    int Multiplication(int num1,boolean flag){
        return Multiplication(num1,5,flag);
    }
    int Multiplication(int num1){
        return Multiplication(num1,5);
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
            out.println("引数：a,b,c　　　　cが正なら(a*b)^2,cが負ならa*b<br>");
            out.println("デフォルト引数：b=5,c=false<br><br>");
            out.println("引数：3,3,true<br>");
            out.println(Multiplication(3,3,true)+"<br>");
            out.println("引数：3,true<br>");            
            out.println(Multiplication(3,true)+"<br>");
            out.println("引数：3,3<br>");
            out.println(Multiplication(3,3)+"<br>");
            out.println("引数：3<br>");
            out.print(Multiplication(3)+"<br>");
            
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
