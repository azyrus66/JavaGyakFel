public class Main {
	public static void main(String[] args) {
		System.out.println(nagybetu("kutya, cica, máté, gábor"));
		System.out.println(tukorString("aefhfea"));
		System.out.println(nemBetu("doj3iOcO8, did3Gjdo."));
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
			}
			else if (j - i <= 1) {
				return true;
			}
			i++;
			j--;
		}
	}

	public static String nemBetu(String srg) {
		byte srgBytes[] = srg.getBytes();
		for (int i=0; i < srgBytes.length; i++) {
			if (!(((srgBytes[i] >= 'A') && (srgBytes[i] <= 'Z')) || ((srgBytes[i] >= 'a') && (srgBytes[i] <= 'z')))) {
				srgBytes[i] = ' ';
			}
		}
		String s = new String(srgBytes);
		return s;
	}

	public static String olvas() {
		String s = new String();
		return s;
	}
}
