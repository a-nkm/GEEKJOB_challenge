/*JavaBeans：リクエストスコープ
実施日付と運勢の結果を取り扱う
*/
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.camp.servlet;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author a-nkm
 */
public class ResultData implements Serializable {
    private Date d;
    private String luck;
    //コンストラクタ
    public ResultData(){}
    
    //dのgetter
    public Date getDate() { 
        return this.d;
    }
    //dのsetter
    public void setDate(Date D){ 
        this.d = D;
    }
    
    //luckのgetter
    public String getLuck(){
        return this.luck;
    }
    public void setLuck(String Luck){
        this.luck = Luck;
    }
}
