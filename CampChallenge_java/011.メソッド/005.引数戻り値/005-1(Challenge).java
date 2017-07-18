/*
005-2引数・戻り値
引数が１つのメソッドを作成してください。
メソッドの中の処理は、３人分のプロフィール（項目は戻り値2と同様）を作成し、引数として渡された値と
同じIDを持つ人物のプロフィールを返却する様にしてください。
それ以降は課題「戻り値2」と同じ処理にしてください。
004-2戻り値
1.戻り値：人物のID,名前,生年月日,住所を配列にして返却するメソッド作成
2.作成したメソッドを呼び出し、戻り値のID以外を表示
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

    //戻り値：人物のID,名前,生年月日,住所を配列にして返却
    ArrayList makeProfile(int id,String name,Calendar birthday,String address){
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
    ArrayList findProfile(int num){
        //プロフィール3つ作成
        int[] id = {1,2,3};
        String[] name = {"a","b","c"};
        Calendar[] birthday = new Calendar[3];
            birthday[0] = Calendar.getInstance();
            birthday[1] = Calendar.getInstance();
            birthday[2] = Calendar.getInstance();
            
            birthday[0].set(1993, 11-1, 24);
            birthday[1].set(2013, 1-1, 11);
            birthday[2].set(2017, 6-1, 16);     
        String[] address ={"tokyo","mie","saitama"};
        ArrayList<ArrayList> List = new ArrayList<>();
        for(int i=0;i<3;i++){
            List.add(makeProfile(id[i],name[i],birthday[i],address[i]));
        }
        if(num<=3&&num>0){
            return List.get(num-1);
        } else{
        return null;
        }       
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
            //探すid番号（1~3)
            int fid = 3;
            ArrayList<String> list;
            list = findProfile(fid);
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


