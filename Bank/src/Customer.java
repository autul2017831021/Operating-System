public class Customer extends Thread {
    int amount;
    char trace;
    int n;
    Calculation calculation;
    public Customer(int amount,Calculation calculation)
    {
        this.amount=amount;
        this.calculation=calculation;
        //start();
    }
    @Override
    public void run(){
        //if(n==1)
        calculation.minus(amount);
    }
}
