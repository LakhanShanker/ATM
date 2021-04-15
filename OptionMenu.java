public class OptionMenu {
    public double balance;
    String  myName;
    int myAccountNo;
    public void OpenAccount(String name,int accountNo){
        myName=name;
        myAccountNo=accountNo;
    }
    public double addFunds(double fund){
        balance+=fund;
        return balance;
    }
    public double seeBalance(){
        return balance;
    }
    public double withdrawBalance(double x){
        if(x<balance)
        {
            balance-=x;
            return balance;
        }
        else
            return -1;
    }
}
