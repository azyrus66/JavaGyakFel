package azyrus66;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // 1. feladat: mineden szó első betűjét nagybetűre
        System.out.println(nagybetu("kutya, cica, máté, gábor"));
        // 2. feladat: tükör szó vagy nem
        System.out.println(tukorString("aefhfea"));
        // 3. feladat: ha nem betü akkor legyen space
        System.out.println(nemBetu("doj3iOcO8, did3Gjdo."));
        // 4. feladat: csillagig olvas szavakat, első betűjét nagybetűre
        System.out.println(olvasNagybetu());
        // 5. feladat: magán- vagy mássalhangzó
        System.out.println(magMasVege("kecske"));
    }

    public static String nagybetu(String kis) {
        byte kisBytes[] = kis.getBytes();

        if ((kisBytes[0] >= 97) && (kisBytes[0] <= 122)) {
            kisBytes[0] -= 32;
        }
        for (int i = 1; i <= kisBytes.length - 1; i++) {
            if ((kisBytes[i] >= 97) && (kisBytes[i] <= 122) && (kisBytes[i - 1] == ' ')) {
                kisBytes[i] -= 32;
            }
        }
        String nagy = new String(kisBytes);
        return nagy;
    }

    public static boolean tukorString(String srg) {
        byte srgBytes[] = srg.getBytes();
        int i = 0, j = srgBytes.length - 1;
        while (true) {
            if (srgBytes[i] != srgBytes[j]) {
                return false;
            } else if (j - i <= 1) {
                return true;
            }
            i++;
            j--;
        }
    }

    public static String nemBetu(String srg) {
        byte srgBytes[] = srg.getBytes();
        for (int i = 0; i < srgBytes.length; i++) {
            if (!(((srgBytes[i] >= 'A') && (srgBytes[i] <= 'Z')) || ((srgBytes[i] >= 'a') && (srgBytes[i] <= 'z')))) {
                srgBytes[i] = ' ';
            }
        }
        String s = new String(srgBytes);
        return s;
    }

    public static String olvasNagybetu() {
        Scanner be = new Scanner(System.in).useDelimiter("\\*");
        System.out.println("Szavak: ");
        String s = be.next();
        be.close();
        return nagybetu(s);
    }

    public static String magMasVege(String str) {
        byte strBytes[] = str.getBytes();
        String s = new String();
        switch (strBytes[strBytes.length-1]) {
            case 'a': s = "magánhangzó"; break;
            case 'e': s = "magánhangzó"; break;
            case 'i': s = "magánhangzó"; break;
            case 'o': s = "magánhangzó"; break;
            case 'u': s = "magánhangzó"; break;
            default: s = "mássalhangzó";
        }
        return s;
    }


}