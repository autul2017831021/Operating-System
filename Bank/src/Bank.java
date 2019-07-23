public class Bank {
    public static void main(String  args[]) throws InterruptedException {
        Calculation calculation = new Calculation();
        Customer c1=new Customer(10000,calculation);
        Customer c2=new Customer(1,calculation);
        Customer c3=new Customer(100,calculation);
        Customer c4=new Customer(100000,calculation);
        c1.start();
        c2.start();
        c3.start();
        c4.start();
    }
}
