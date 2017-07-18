/*
004-2戻り値
1.戻り値：人物のID,名前,生年月日,住所を配列にして返却するメソッド作成
2.作成したメソッドを呼び出し、戻り値のID以外を表示

ArrayList<String> list = new ArrayList<String>();caution「新しい式の型引数が重複」 
        ダイアモンド演算子使用
id,生年月日ともにStringで記述後、変換方法を考える
・生年月日Dateで取り扱いたい
・Date→Calendar 日付入力などに対してDateが非推奨となったことを知り、Calendarを調べる。
・Calendarで入力
・yyyy/M/dの形にするため、SimpleDateFormat使用
・月が1ヶ月ずれる　＝　0=JANため、年月日別入力、-1月適用
*/
package org.camp.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.*;
import java.text.SimpleDateFormat;

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
    //戻り値：人物のID,名前,生年月日,住所を配列にして返却
    ArrayList listProfile(int id,String name,Calendar birthday,String address){
        ArrayList<String> list = new ArrayList<>();
        String Id = String.valueOf(id);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/M/d");
        String Birthday = sdf.format(birthday.getTime());
        
        list.add(Id);
        list.add(name);
        list.add(Birthday);
        list.add(address);
        return list;
    }
    
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
            //id,名前,誕生日,住所
            int id = 1;
            String name = "nakamura";
            Calendar birthday = Calendar.getInstance();
            int bYear = 1993;
            int bMonth = 11;
            int bDay = 24;
            birthday.set(bYear,bMonth-1,bDay);
            String address = "tokyo";
                       
            ArrayList<String> list;
            list = listProfile(id,name,birthday,address);
            for(int i=1;i<4;i++){
                out.println(list.get(i));
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


