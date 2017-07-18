<%-- 
    Document   : challengejsp
    Created on : 2017/07/18, 14:40:14
    Author     : a-nkm
016-2
以下の機能を実装してください。
「入力フィールド」の課題で作成したHTMLの入力データを取得し、画面に表示する
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h2>【入力データ表示】</h2>
        <%
        // 受け取るパラメータの文字コード
        request.setCharacterEncoding("UTF-8");
        
        // テキストボックスの情報
        out.print("名前：" + request.getParameter("Name") +"<br>");       
        // ラジオボタンの情報
        out.print("性別：" + request.getParameter("Sex") +"<br>");
         // テキストエリアの情報
        out.print("趣味：" + request.getParameter("Hobby") + "<br>");
        %>
    </body>
</html>
