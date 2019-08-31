import org.apache.log4j.Logger;

public class Log4jTest {
    public static void main(String[] args) {
        String str = "absdfd";
        String regex = "(ab|s)";
        String str2 = str.replaceFirst(regex, "");
        System.out.println(str2);
    }
}
