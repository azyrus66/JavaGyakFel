package azyrus66;

import java.util.*;

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

		// 3. feladat: háromszög-e?
		System.out.println("3. feladat: háromszög-e?\nA háromszög 3 oldala enterrel elválasztva:");
		System.out.println(haromszog(sc.nextInt(), sc.nextInt(), sc.nextInt()) + "\n");
		sc.nextLine();
		
		// 4. feladat: max, min
		System.out.println("4. feladat: max, min\n10 darab egész szám szóközzel elválasztva:");
		int[] ered = maxMin(sc.nextLine());
		System.out.println("Max: " + ered[0] + "\nMin: " + ered[1] + "\n");
		
		// 5. feladat: másodfokú valós gyökök
		System.out.println("5. feladat: másodfokú valós gyökök\nA három tényező enterrel elválasztva:");
		double[] ered2 = gyokok(sc.nextInt(), sc.nextInt(), sc.nextInt());
		System.out.println("Első gyök: " + ered2[0] + "\nMásodik gyök: " + ered2[1] + "\n");
		
		// 6. feladat: 2 szám pegnagyobb közös osztója
		System.out.println("6. feladat: 2 szám legnagyobb közös osztója\nA két szám enterrel elválasztva:");
		System.out.println("Legnagyobb közös osztó: " + lkOszto(sc.nextInt(), sc.nextInt()) + "\n");
		
		// 7. feladat: kör kerülete, területe
		System.out.println("7. feladat: Kör kerülete, területe:");
		double[] kor = korKT(5);
		System.out.println("Kerület: " + kor[0] + "\nTerület: " + kor[1] + "\n");
		
		// 8. feladat:

	    // 9. feladat: [-1, 1], 0,1 lépésenként f(x)=x3
	    System.out.println("9. feladat: [-1, 1], 0,1 lépésenként f(x)=x3");
	    x3();
	    System.out.println();

	    // 10. feladat: Első 10 négyzetszám
	    System.out.println("10. feladat: Első 10 négyzetszám");
	    negyzetsz();
	    System.out.println();

        // 11. feladat: Első 10 természetes szám és négyzetük
	    System.out.println("11. feladat: Első 10 természetes szám és négyzetük");
	    termNegyzet();
	    System.out.println();

	    // 12. feladat: első 30 természetes szám össege
	    System.out.println("12. feladat: első 30 természetes szám össege");
	    System.out.println(nTermSzamOsszeg() + "\n");




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
	
	private static boolean haromszog(int a, int b, int c) {
		int max = Math.max(Math.max(a, b), c);
		if (((max == a) && (a < b+c)) || 
		((max == b) && (b < a+c)) || 
		((max ==c) && (c < a+b))) {
			return true;
		}
		else {
			return false;
		}
	}
	
	private static int[] maxMin(String str) {
		String[] strArray = str.split(" ");
		int[] array = new int[10];
		int[] ered = new int[2];
		for (int i = 0; i < 10; i++) {
			array[i] = Integer.parseInt(strArray[i]);
		}
		IntSummaryStatistics stat = Arrays.stream(array).summaryStatistics();
		ered[0] = stat.getMax();
		ered[1] = stat.getMin();
		return ered;
	}
	
	private static double[] gyokok(int a, int b, int c) {
		double[] ered = new double[2];
		ered[0] = ((-b+Math.sqrt(Math.pow(b, 2)-4*a*c))/(2*a));
		ered[1] = ((-b-Math.sqrt(Math.pow(b, 2)-4*a*c))/(2*a));
		return ered;
	}
	
	private static int lkOszto(int x, int y) {
		int tmp;
		if (x < y) {
			tmp = x;
			x = y;
			y = tmp;
		}
		while ((x % y) > 0) {
			y = x % y;
		}
		return y;
	}
	
	private static double[] korKT(double r) {
		double[] kor = {(2*r*Math.PI), (Math.pow(r, 2)*Math.PI)};
		return kor;
	}

	private static void x3() {
    	double x = -1;
    	while (x <= 1) {
		    System.out.printf("%+.1f\n", x*3);
		    x += 0.1;
	    }
	}

	private static void negyzetsz() {
		for (int i = 0; i < 10; i++) {
			System.out.printf("%d^2 = %d\n", i, (int)Math.pow(i, 2));
		}
	}

	private static void termNegyzet() {
		for (int i = 1; i < 10; i++) {
			System.out.printf("%d, %d\n", i, (int)Math.pow(i, 2));
		}
	}

	private static int nTermSzamOsszeg() {
		int sum = 0;
    	for (int i = 1; i < 30; i++) {
			sum += i;
		}
		return sum;
	}
}
