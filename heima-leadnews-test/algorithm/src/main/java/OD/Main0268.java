package OD;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Amos
 * @E-mail: amos@amoscloud.com
 * @Date: 2023/12/9
 * @Time: 12:21
 * @Description:
 */
public class Main0268 {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(" ");
        List<Integer> coords = new ArrayList<>();
        for (String s : input) {
            coords.add(Integer.parseInt(s));
        }

        List<Integer> simplifiedCoords = simplifyLine(coords);
        for (int i = 0; i < simplifiedCoords.size(); i++) {
            System.out.print(simplifiedCoords.get(i));
            if (i < simplifiedCoords.size() - 1) {
                System.out.print(" ");
            }
        }

        scanner.close();
    }

    public static List<Integer> simplifyLine(List<Integer> coords) {
        List<Integer> simplifiedCoords = new ArrayList<>();

        for (int i = 0; i < coords.size() - 3; i += 2) {
            int x1 = coords.get(i);
            int y1 = coords.get(i + 1);
            int x2 = coords.get(i + 2);
            int y2 = coords.get(i + 3);

            if (i == 0 || i == coords.size() - 4 || (x1 - x2 != x2 - coords.get(i + 4)) || (y1 - y2 != y2 - coords.get(i + 5))) {
                simplifiedCoords.add(x1);
                simplifiedCoords.add(y1);
            }
        }

        simplifiedCoords.add(coords.get(coords.size() - 2));
        simplifiedCoords.add(coords.get(coords.size() - 1));

        return simplifiedCoords;
    }
}