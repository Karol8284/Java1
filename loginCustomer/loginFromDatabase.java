package Shop.Account.Customer.loginCustomer;

import Shop.Account.Customer.CustomerObject;
import Shop.Account.Customer.sexOption;

import java.sql.*;

public class loginFromDatabase extends CustomerObject {
    loginFromDatabase(String login,String password){
        super(0,"","","","","","",0, null);
        String select = "select * from customer";
        if (!(login == "")&& !(password == "")){
            try {
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/shop","root","");
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery(select);
                while (rs.next()){
                    System.out.println( rs.getString(4).length()+" "+rs.getString(4) +" : "+ login);
                    System.out.println(rs.getString(5) == password);
//rs.getString(4) == login && rs.getString(5) == password

                    if(rs.getString(4) == login && rs.getString(5) == password){
//                    login != login wtf czemu? jak to porównywać? Co do ...?
                            this.id = rs.getInt(1);
                            this.firstName = rs.getString(2);
                            this.lastName = rs.getString(3);
                            this.login = rs.getString(4);
                            this.password = rs.getString(5);
                            this.nickName = rs.getString(6);
                            this.eMail = rs.getString(7);
                            this.phoneNumber = rs.getInt(8);
                            if(rs.getString(9) == "male") this.sex = sexOption.male;
                            else if (rs.getString(9) == "female") this.sex = sexOption.female;
                            else this.sex = null;
                    }
                }
            }catch (Exception e){
                System.out.println(e);
            }
        }
    }
    public loginFromDatabase returnLoginDataFromDatabase(String login, String password){
        loginFromDatabase obj = new loginFromDatabase(login,password);
        return obj;
    }
}
