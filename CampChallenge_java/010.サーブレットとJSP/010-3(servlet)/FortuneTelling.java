package org.camp.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//日付と占い乱数
import java.util.Date;
import java.util.Random;
//JSP呼び出し(リクエストディスパッチャー)
import javax.servlet.RequestDispatcher;
//ResultData(JavaBeans)
import org.camp.servlet.ResultData;



public class FortuneTelling extends HttpServlet {

     protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        final String result = "WEB-INF/jsp/FortuneTellingResult.jsp";
        
       //運勢配列        
        String luckList[] = {"大吉", "中吉", "吉", "半吉", "末小吉", "凶", "小凶", "半凶", "末凶", "凶", "大凶"};
        //乱数取得
        Random rand = new Random();
        Integer index = rand.nextInt(luckList.length);
     
        //リクエストスコープへ結果登録
        ResultData data = new ResultData();
        data.setDate(new Date());
        data.setLuck(luckList[index]);
        request.setAttribute("DATA", data);
   
     
        RequestDispatcher rd = request.getRequestDispatcher(result); 
        rd.forward(request, response);
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
