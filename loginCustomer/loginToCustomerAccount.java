package Shop.Account.Customer.loginCustomer;

public class loginToCustomerAccount extends  loginFromDatabase{
    public loginToCustomerAccount(String login, String password){
        super("","");
        loginFromDatabase obj = new loginFromDatabase(login,password);
        System.out.println(obj.firstName);
        System.out.println(obj+" "+obj.returnLoginDataFromDatabase(login, password));

    }

}
