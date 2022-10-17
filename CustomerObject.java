package Shop.Account.Customer;

public class CustomerObject extends CustomerValue{
//    this.firstName,this.lastName,this.nickName,this.eMail,this.phoneNumber,"male"
//employee
    public CustomerObject(Integer id, String firstName, String lastName,String login, String password, String nickName, String eMail, int phoneNumber, Enum sex){
        if (firstName != "") {
            this.id = id;
            this.firstName = firstName;
            this.lastName = lastName;
            this.login = login;
            this.password = password;
            this.nickName = nickName;
            this.eMail = eMail;
            this.phoneNumber = phoneNumber;
            this.sex = sex;
        }
    }

    public CustomerObject returnCustomerObjectData(CustomerObject customerObject){
//        CustomerObject obj = new CustomerObject("karol","M","MK","L",1213,"male");
        CustomerObject obj = new CustomerObject(customerObject.id, customerObject.firstName, customerObject.login ,customerObject.password ,customerObject.lastName, customerObject.nickName, customerObject.eMail, customerObject.phoneNumber, customerObject.sex);
        return obj;
    }

//    public static void main(String[] args) {
//        CustomerObject obj = new CustomerObject("Brajan","Novar","Fey","dafbwg",223421,"male");
//        System.out.println(obj.sex);
//        System.out.println(obj.returnCustomerObjectData(obj).firstName);
//    }
}
