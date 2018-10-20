package azyrus66;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 1. feladat: mineden szó első betűjét nagybetűre
        System.out.println("1. feladat: Minen szó első betűjét nagybetűre.\nSzöveg: ");
        System.out.println(nagybetu(sc.nextLine()));

        // 2. feladat: tükör szó vagy nem
        System.out.println("2. feladat: Tükör szó vagy sem?\nSzó: ");
        System.out.println(tukorString(sc.nextLine()));

        // 3. feladat: ha nem betü akkor legyen space
        System.out.println("3. feladat: Ha nem betű akkor legyen space.\nSzöveg: ");
        System.out.println(nemBetu(sc.nextLine()));

        // 4. feladat: csillagig olvas szavakat, első betűjét nagybetűre
        System.out.println("4. feladat: csillagig olvas, betűket nagyra.\nSzöveg: ");
        System.out.println(csillagNagybetu(sc.useDelimiter("\\*").next()));
        sc.nextLine();

        // 5. feladat: magán- vagy mássalhangzó
        System.out.println("5. feladat: magán- vagy mássalhangzóra végződik?\nSzó: ");
        System.out.println(magMasVege(sc.nextLine()));

        // 6. feladat: anagramma?
        System.out.println("6. feladat: anagramma?\nKét string enterrel elválasztva: ");
        System.out.println(anagramma(sc.nextLine(), sc.nextLine()));

        sc.close();

    }


    public static String nagybetu(String kis) {
        byte kisBytes[] = kis.getBytes();

        if ((kisBytes[0] >= 97) && (kisBytes[0] <= 122)) {
            kisBytes[0] -= 32;
        }
        for (int i = 1; i < kisBytes.length; i++) {
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

    public static String csillagNagybetu(String str) {
        byte strBytes[] = str.getBytes();
        for (int i = 0; i <= strBytes.length - 1; i++) {
            if ((strBytes[i] >= 97) && (strBytes[i] <= 122)) {
                strBytes[i] -= 32;
            }
        }
        String s = new String(strBytes);
        return s;
    }

    public static String magMasVege(String str) {
        byte strBytes[] = str.getBytes();
        String s;
        switch (strBytes[strBytes.length - 1]) {
            case 'a':
                s = "magánhangzó";
                break;
            case 'e':
                s = "magánhangzó";
                break;
            case 'i':
                s = "magánhangzó";
                break;
            case 'o':
                s = "magánhangzó";
                break;
            case 'u':
                s = "magánhangzó";
                break;
            default:
                s = "mássalhangzó";
        }
        return s;
    }

    private static boolean anagramma(String str1, String str2) {
        byte str1Bytes[] = str1.getBytes();
        byte str2Bytes[] = str2.getBytes();
        int str1n = 0, str2n = 0;
        if (str1Bytes.length == str2Bytes.length) {
            for (int i = 0; i < str1Bytes.length; i++) {
                str1n += str1Bytes[i];
                str2n += str2Bytes[i];
            }
            return str1n == str2n;
        } else return false;
    }
}