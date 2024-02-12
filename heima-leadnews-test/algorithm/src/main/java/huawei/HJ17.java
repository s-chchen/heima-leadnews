package huawei;

import java.util.Scanner;

public class HJ17 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String inStr = in.nextLine();
        String[] split = inStr.split(";");

        int x = 0, y = 0;
        for (String s : split) {
            if (s.matches("[AWSD][0-9]{1,2}")) {
                String direct = s.substring(0, 1);

                String numStr = s.substring(1);
                Integer num = Integer.valueOf(numStr);
                
                switch (direct){
                    case "A":
                        x = x - num;
                        break;
                    case "D":
                        x = x + num;
                        break;
                    case "W":
                        y = y + num;
                        break;
                    case "S":
                        y = y - num;
                        break;
                }
                
            } else {
                continue;
            }
        }
        System.out.println(x+","+y);
    }
    
}
