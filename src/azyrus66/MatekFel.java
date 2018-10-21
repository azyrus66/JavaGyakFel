package azyrus66;

import java.util.Scanner;

public class MatekFel {
    public void MatekFel() {
        Scanner sc = new Scanner(System.in);

        // 1. feladat: -90-től 90 fokig a szögek szinusza
        System.out.println("1. feladat: -90-től 90 fokig a szögek szinusza.");
        szogekSin();
        System.out.println();

        // 2. feladat: -90-től 90 fokig a szögek kotangense
        System.out.println("2. feladat: -90-től 90 fokig a szögek kotangense.");
        szogekCtg();
        System.out.println();



        sc.close();
    }

    private static void szogekSin() {
        for (int i = -90; i <= 90; i++) {
            System.out.println(Math.sin(Math.toRadians(i)));
        }
    }

    private static void szogekCtg() {
        for (int i = -90; i < 90; i++) {
            System.out.printf("ctg(%+03d)=%+010.6f\n", i, (1.0 / Math.tan(Math.toRadians(i))));
        }
    }
}
