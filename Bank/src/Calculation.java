public class Calculation {
    private int b=100000;
    private boolean isFree =true;
    public void minus(int amount)
    {
        while (!isFree) {

            System.out.println("Busy");
        }
        isFree=false;
        if(b<amount)
            System.out.println("Insufficient Balance");

        else
        {
            b=b-amount;
            System.out.println("Current Balance after withdraw is:"+b);
        }
        isFree=true;
    }
}
