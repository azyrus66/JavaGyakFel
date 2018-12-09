package azyrus66;

import java.util.Scanner;

public class StringFel {

	final static String elsoNagybetuString = "Mineden szó első betűjét nagybetűre";
	final static String tukorString = "Tükör szó vagy nem";
	final static String nemBetuString = "Ha nem betü akkor legyen space";
	final static String csillagNagybetuString = "Csillagig olvas szavakat, nagybetűsen kíírja";
	final static String magMasVegString = "Magán- vagy mássalhangzóra végződik?";
	final static String anagrammaString = "Anagramma?";
	final static String szoCsereString = "Mondatban kicserél egy szót egy másikra";
	final static String angolAbcString = "Angol abc betűi:";
	final static String angolAbcHaromCiklusString = "Angol abc betűi három ciklussal:";
	final static String nHosszuSorString = "Sor N hosszúságú stringbe, hely szóközzel kitöltve:";
	final static String strForditString = "Megfordít egy stringet";
	final static String strTorolString = "Töröl minden 'a' karaktert a stringből";
	final static String strNagybetuString = "Legfeljebb 100 betűs mondatot nagybetűre";
	final static String strKeresString = "Megkeres egy stringet egy másik stringben";
	final static String szoEgyesitString = "Egyesít két szót";

    public void StringFel() {
        Scanner sc = new Scanner(System.in);

        // 4. feladat: csillagig olvas szavakat, nagybetűsen kíírja
        //System.out.println("4. feladat: csillagig olvas, betűket nagyra.\nSzöveg: ");
        //System.out.println(csillagNagybetu(sc.useDelimiter("\\*").next()) + "\n");
        //sc.nextLine();

        // 5. feladat: magán- vagy mássalhangzó
        //System.out.println("5. feladat: magán- vagy mássalhangzóra végződik?\nSzó: ");
        //System.out.println(magMasVege(sc.nextLine()) + "\n");

        // 6. feladat: anagramma?
        //System.out.println("6. feladat: anagramma?\nKét string enterrel elválasztva: ");
        //System.out.println(anagramma(sc.nextLine(), sc.nextLine()) + "\n");

        // 7. feladat: mondatban kicserél egy szót egy másikra
        //System.out.println("7. feladat: Mondatban kicserél egy szót egy másikra.\nMondat és két szó enterrel elválasztva: ");
        //System.out.println(szoCsere(sc.nextLine(), sc.nextLine(), sc.nextLine()) + "\n");

        // 8. feladat: angol abc betűi
        //System.out.println("8. feladat: Angol abc betűi:");
        //angolAbc();
        //System.out.println();

        // 9. feladat: angol abc betűi hármo fajta ciklussal
        //System.out.println("9. feladat: Angol abc betűi három ciklussal:");
        //angolAbcHaromCiklus();
        //System.out.println();

        // 10. feladat: sor N hosszúságú stringbe, helyet szóközzel kitölteni
        //System.out.println("10. feladat: Sor N hosszúságú stringbe, hely szóközzel kitöltve:\nHossz és Szöveg enterrel elválasztva: ");
        //System.out.println(nHosszuSor(Integer.parseInt(sc.nextLine()), sc.nextLine()) + "\n");

        // 11. feladat: megfordít egy stringet
        //System.out.println("11. feladat: Megfordít egy stringet.\nString: ");
        //System.out.println(strFordit(sc.nextLine()) + "\n");

        // 12. feladat: töröl minden a karaktert a stringből
        //System.out.println("12. feladat: Töröl minden 'a' karaktert a stringből.\nString: ");
        //System.out.println(strTorol(sc.nextLine()) + "\n");

        // 13. feladat: legfeljebb 100 betűs mondatot nagybetűre
        //System.out.println("13. feladat: Legfeljebb 100 betűs mondatot nagybetűre.\nMondat: ");
        //System.out.println(strNagybetu(sc.nextLine()) + "\n");

        // 14. feladat: megkeres egy stringet egy másik stringben
        //System.out.println("14. feladat: Megkeres egy stringet egy másik stringben.\nKeresett string és amiben keresünk enterrel elválasztva: ");
        //System.out.println(strKeres(sc.nextLine(), sc.nextLine()) + "\n");

        // 15. feladat: egyessít két szót
        //System.out.println("15. feladat: Egyesít két szót.\nSzavak szóközzel elválasztva: ");
        //System.out.println(szoEgyesit(sc.nextLine()) + "\n");

        sc.close();
    }

    public static String elsoNagybetu(String kis) {
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

    public static boolean tukor(String srg) {
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
        if (str.contains("*")) {
            return str.substring(0, str.indexOf("*")).toUpperCase();
        }
        else {
            return null;
        }
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

    public static boolean anagramma(String str1, String str2) {
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

    public static String szoCsere(String mondat, String szo1, String szo2) {
        return mondat.replaceAll(szo1, szo2);
    }

    public static String angolAbc() {
    	StringBuilder abc = new StringBuilder();
        for (int i = 97; i <= 122; i++) {
            abc.append((char)i).append(" ");
        }
        return abc.toString();
    }

    public static String angolAbcHaromCiklus() {
    	StringBuilder habc = new StringBuilder();
        habc.append("for ciklus:\n");
        habc.append(angolAbc()); // for ciklussal

	    habc.append("\nwhile ciklus:\n");
        int i = 97;
        while (i<=122) {
            habc.append((char)i).append(" ");
            i++;
        }

        habc.append("\ndo-while ciklus:\n");
        i = 97;
        do {
            habc.append((char)i).append(" ");
            i++;
        } while (i <= 122);
        habc.append("\n");
        return habc.toString();
    }

    public static String nHosszuSor(int n, String str) {
        while (str.length() < n) {
            str += ".";
        }
        return str.substring(0, n);
    }

    public static String strFordit(String str) {
        String rts = "";
        for (int i = str.length()-1; i >= 0; i--) {
            rts += str.substring(i, i+1);
        }
        return rts;
    }

    public static String strTorol(String str) {
        return str.replaceAll("a", "");
    }

    public static String strNagybetu(String str) {
        if (str.length() > 100) {
            return str.substring(0, 100).toUpperCase();
        }
        else {
            return str.toUpperCase();
        }
    }

    public static String strKeres(String str1, String str2) {
        return str2.substring(str2.indexOf(str1), str2.indexOf(str1) + str1.length());
    }

    public static String szoEgyesit(String str) {
        return str.replaceAll(" ", "");
    }
}
