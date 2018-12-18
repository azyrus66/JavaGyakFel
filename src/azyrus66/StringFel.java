package azyrus66;


public class StringFel {

	final static String elsoNagybetuString = Main.guiBundle.getString("tasks_string_elsoNagybetu");
	final static String tukorString = Main.guiBundle.getString("tasks_string_tukor");
	final static String nemBetuString = Main.guiBundle.getString("tasks_string_nemBetu");
	final static String csillagNagybetuString = Main.guiBundle.getString("tasks_string_csillagNagybetu");
	final static String magMasVegString = Main.guiBundle.getString("tasks_string_magMasVeg");
	final static String anagrammaString = Main.guiBundle.getString("tasks_string_anagramma");
	final static String szoCsereString = Main.guiBundle.getString("tasks_string_szoCsere");
	final static String angolAbcString = Main.guiBundle.getString("tasks_string_angolAbc");
	final static String angolAbcHaromCiklusString = Main.guiBundle.getString("tasks_string_angolAbcHaromCiklus");
	final static String nHosszuSorString = Main.guiBundle.getString("tasks_string_nHosszuSor");
	final static String strForditString = Main.guiBundle.getString("tasks_string_strFordit");
	final static String strTorolString = Main.guiBundle.getString("tasks_string_strTorol");
	final static String strNagybetuString = Main.guiBundle.getString("tasks_string_strNagybetu");
	final static String strKeresString = Main.guiBundle.getString("tasks_string_strKeres");
	final static String szoEgyesitString = Main.guiBundle.getString("tasks_string_szoEgyesit");


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
