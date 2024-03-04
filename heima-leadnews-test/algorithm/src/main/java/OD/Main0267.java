package OD;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Amos
 * @E-mail: amos@amoscloud.com
 * @Date: 2023/12/9
 * @Time: 11:01
 * @Description:
 */
public class Main0267 {
    public static void main(String[] args) {

      String s= "1.1.1.1";
      long lch = ipToIntcch(s);
      long l = ipToInt(s);
      System.out.println();
//        Scanner scanner = new Scanner(System.in);
//        String ipRanges = scanner.nextLine();
//        String ips = scanner.nextLine();
//        System.out.println(findCities(ipRanges, ips));
//        scanner.close();
    }

    private static long ipToInt(String ip) {
        String[] parts = ip.split("\\.");
        return (long) Integer.parseInt(parts[0]) << 24
                | Integer.parseInt(parts[1]) << 16
                | Integer.parseInt(parts[2]) << 8
                | Integer.parseInt(parts[3]);
    }

    private static long ipToIntcch(String ip) {
      String[] parts = ip.split("\\.");
      return (long) Integer.parseInt(parts[0]) * 256 * 256 * 256
              + Integer.parseInt(parts[1])  * 256 * 256
              + Integer.parseInt(parts[2])  * 256
              + Integer.parseInt(parts[3]) ;
    }

    private static Map<Long, String> parseIPRanges(String ipRangesStr) {
        Map<Long, String> ranges = new HashMap<>();
        for (String part : ipRangesStr.split(";")) {
            String[] cityAndRange = part.split("=");
            String city = cityAndRange[0];
            String[] startEnd = cityAndRange[1].split(",");
            long startIp = ipToInt(startEnd[0]);
            long endIp = ipToInt(startEnd[1]);
            ranges.put((startIp << 32) | endIp, city);
        }
        return ranges;
    }

    private static String findCity(String ip, Map<Long, String> ranges) {
        long ipInt = ipToInt(ip);
        String bestMatch = null;
        long bestRange = Long.MAX_VALUE;
        for (Map.Entry<Long, String> entry : ranges.entrySet()) {
            long range = entry.getKey();
            long startIp = range >> 32;
            long endIp = range & 0xFFFFFFFFL;
            if (startIp <= ipInt && ipInt <= endIp) {
                long currentRange = endIp - startIp;
                if (bestMatch == null || currentRange < bestRange) {
                    bestMatch = entry.getValue();
                    bestRange = currentRange;
                }
            }
        }
        return bestMatch;
    }

    public static String findCities(String ipRangesStr, String ipsStr) {
        Map<Long, String> ranges = parseIPRanges(ipRangesStr);
        String[] ips = ipsStr.split(",");
        StringBuilder result = new StringBuilder();
        for (String ip : ips) {
            if (result.length() > 0) result.append(",");
            result.append(findCity(ip, ranges));
        }
        return result.toString();
    }
}