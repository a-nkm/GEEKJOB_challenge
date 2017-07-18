<%-- 
    Document   : challengejsp
    Created on : 2017/07/18, 14:40:14
    Author     : a-nkm
003-1
クエリストリングを利用して、以下の処理を実現してください。
○想定されるクエリストリング
http://localhost:8080/対象ファイル.jsp?total=総額&count=個数&type=商品種別
例）http://localhost:8080/対象ファイル.jsp?total=1500&count=10&type=2
　⇒総額1500円、10個、商品種別は2
1. 受け取った商品種別を以下の対応で日本語表示
　 1:雑貨、2：生鮮食品、3:その他 例)typeが2だったら、「生鮮食品」
2. 受け取った総額と個数から、１個当たりの値段を算出し、表示してください。
3. 総額に応じたポイントが付きます。ポイントを計算し、表示してください。
　 3000円以上で、4%
　 5000円以上で、5%
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>003-1</title>
    </head>
    <body>  
        <h6>
        1. 受け取った商品種別を以下の対応で日本語表示<br>
             1:雑貨、2：生鮮食品、3:その他 例)typeが2だったら、「生鮮食品」<br>
        2. 受け取った総額と個数から、１個当たりの値段を算出し、表示してください。<br>
        3. 総額に応じたポイントが付きます。ポイントを計算し、表示してください。<br>
            3000円以上で、4%<br>
            5000円以上で、5%<br>
            <br>
        </h6>
        <%
        // 受け取るパラメータの文字コード
        request.setCharacterEncoding("UTF-8");
        // テキストボックスの情報
        String[] str = {"雑貨","生鮮食品","その他"};
        int type = Integer.valueOf(request.getParameter("type"));
        int total = Integer.valueOf(request.getParameter("total"));
        int count = Integer.valueOf(request.getParameter("count"));
        int point = 0;
        
        out.print("商品種別：");
        out.print(str[type-1]+ "<br>");
        out.print("1個あたりの値段：") ;
        out.print(total/count +"円/個<br>");
        out.print("ポイント：");
        if(total>=5000){
            point = 5;
        }else{ 
            if(total>=3000)
              point = 4;
        }
        out.print(point +"%<br>");
        
         %>
    </body>
</html>
