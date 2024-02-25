package Q4C;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Q38 {

    public static void main(String[] args) throws ScriptException {
        /*Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();*/
        String s = "1-2asdasda3-2";

        Pattern pattern = Pattern.compile("\\d+[\\+\\-]\\d");
        Matcher matcher = pattern.matcher(s);

        while (matcher.find()) {
            String group = matcher.group();
            System.out.println(group);
            ScriptEngine nashorn = new ScriptEngineManager().getEngineByName("nashorn");
            int num = (int) nashorn.eval(group);
            System.out.println(num);
        }

        boolean matches = s.matches(".*\\d+[\\+\\-]\\d.*");
        String replace = "";
        if (matches) {
            replace = s.replace("^\\d+[\\+\\-]\\d+]", "");
        }
        ScriptEngine nashorn = new ScriptEngineManager().getEngineByName("nashorn");
        nashorn.eval(replace);
    }

}
