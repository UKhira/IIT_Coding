public class Child extends AccessModifier{
    protected void check(){
        defaultVar = 11;
        proVar = 10;
        pubVar = 11;

        System.out.println("proVar is not accessible");
    }
}
