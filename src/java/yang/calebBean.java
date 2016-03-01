/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yang;

/**
 *
 * @author Xun
 */
import java.io.Serializable;


    public class calebBean extends Object implements Serializable {

    public static final String ISTATUS = "Login";
    public static final String defaul = "Welcome back!";
    private String spring;
    private String yixian;
    private String status;
    private String id;
    private String name;
    private String reminder;
    private String reminder2;
    private String reminder3;
    public calebBean() {
        status = defaul;
        id=new String();
        name = new String();
        reminder=new String();
        reminder2=new String();
         reminder3=new String();
    }

    public String getStatus() {return status;}
    public void setStatus(String value) {status = value;}

    public String getId() {return id;}
    public void setId(String value) {id = value;}

    public String getName() {return name;}
    public void setName(String value) {name = value;}
    public String getReminder() {return reminder;}
    public void setReminder(String value) {reminder = value;}
    public String getReminder2() {return reminder2;}
    public void setReminder2(String value) {reminder2 = value;}
     public String getReminder3() {return reminder3;}
    public void setReminder3(String value) {reminder3 = value;}

}
