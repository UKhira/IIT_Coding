import java.time.Clock;
import java.time.LocalDate;
import java.util.Date;

public class VariableQuiz {
    static int staticVar = 10;
    int instanceVar = 5;

    @SuppressWarnings("static-access")
    public static void main(String[] args) {
        VariableQuiz obj1 = new VariableQuiz();
        VariableQuiz obj2 = new VariableQuiz();

        obj1.staticVar = 20;
        obj1.instanceVar = 15;

        obj2.staticVar = 30;
        obj2.instanceVar = 25;

        System.out.println(obj1.staticVar+" "+obj1.instanceVar);
    }
}
