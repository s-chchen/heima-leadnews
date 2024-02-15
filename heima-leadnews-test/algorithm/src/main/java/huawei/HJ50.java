package huawei;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.util.Scanner;

public class HJ50 {

    public static void main(String[] args) throws ScriptException {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();

        s = s.replace("[", "(");
        s = s.replace("{", "(");
        s = s.replace("]", ")");
        s = s.replace("}", ")");

        ScriptEngine nashorn = new ScriptEngineManager().getEngineByName("nashorn");
        System.out.println(nashorn.eval(s));
    }

}
