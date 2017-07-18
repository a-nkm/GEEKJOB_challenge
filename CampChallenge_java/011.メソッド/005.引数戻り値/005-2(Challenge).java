/*
005-2
課題「引数、戻り値1」の3人分のプロフィールのうち、1人だけ住所の値をnullで定義し、
ループ処理で全員分のプロフィールをid以外表示する処理を作成してください。
この際、nullになっているデータはcontinueで飛ばしながら表示してください。
005-1引数・戻り値
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
    //プロフィールの作成
    ArrayList listProfile(){
        int[] id = {1,2,3};
        String[] name = {"a","b","c"};
        Calendar[] birthday = new Calendar[3];
            birthday[0] = Calendar.getInstance();
            birthday[1] = Calendar.getInstance();
            birthday[2] = Calendar.getInstance();
            
            birthday[0].set(1993, 11-1, 24);
            birthday[1].set(2013, 1-1, 11);
            birthday[2].set(2017, 6-1, 16);     
        String[] address ={"tokyo",null,"saitama"};
        ArrayList<ArrayList> List = new ArrayList<>();
        for(int i=0;i<3;i++){
            List.add(makeProfile(id[i],name[i],birthday[i],address[i]));
        }
        return List;
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
            //List作成
            ArrayList<ArrayList> List = new ArrayList<>();
            List = listProfile();
            String p;

            for(int i=0;i<3;i++){
                for(int j=1;j<4;j++){
                    p = (String)List.get(i).get(j);
                    if(p==null)
                        continue;
                    out.println(p);
                }
                out.println("<br>");
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


