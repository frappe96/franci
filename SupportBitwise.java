package com.jsoniter;

/**
 * classe di supporto per risolvere il problema di affidabilità "Avoid using
 * bitwise operators to make comparisons"
 * 
 * @author Francesco
 */
public class SupportBitwise {
	/**
	 * costruttore privato, richiesto da kiuwan
	 */
	private SupportBitwise() {
	}

	/**
	 * 
	 */
	private final static char ZERO = '0';
	/**
	 * 
	 */
	private final static char UNO = '1';

	private final static int DUE = 2;

	/**
	 * Metodo per bitwise utilizzato negli if
	 * 
	 * @param bin1
	 * @param bin2
	 * @return
	 */
	public static boolean bitwise(String bin1, String bin2) {
		boolean flag = false;
		int l1 = bin1.length();
		int l2 = bin2.length();
		if (l1 <= l2) {
			for (int i = l1 - 1; i >= 0; i--) {
				l2--;
				if ((bin1.charAt(i) != bin2.charAt(l2)) || (Character.getNumericValue(bin1.charAt(i)) == 0)
						&& (Character.getNumericValue(bin2.charAt(l2)) == 0)) {
					flag = true;
				} else {
					flag = false;
					break;
				}
			}
		} else {
			for (int i = l2 - 1; i >= 0; i--) {
				l1--;
				if ((bin1.charAt(l1) != bin2.charAt(i)) || (Character.getNumericValue(bin1.charAt(l1)) == 0)
						&& (Character.getNumericValue(bin2.charAt(i)) == 0)) {
					flag = true;
				} else {
					flag = false;
					break;
				}
			}
		}
		return flag;
	}

	/**
	 * Metodo per eseguire bitwise senza errori kiuwan
	 * 
	 * @param long1
	 * @param long2
	 * @param c
	 * @return
	 */
	public static long bitwise(Long long1, Long long2, char c) {
		String newLong = "";
		long l = 0;
		String bin1 = Long.toBinaryString(long1);
		String bin2 = Long.toBinaryString(long2);
		int l1 = bin1.length();
		int l2 = bin2.length();
		if (l1 <= l2) {
			for (int i = l1 - 1; i >= 0; i--) {
				l2--;
				if (c == '&') {
					if ((Character.getNumericValue(bin1.charAt(i)) == 0
							&& Character.getNumericValue(bin2.charAt(l2)) == 1)
							|| (Character.getNumericValue(bin1.charAt(i)) == 1
									&& Character.getNumericValue(bin2.charAt(l2)) == 0)) {
						newLong = ZERO + newLong;
					}
				} else if (c == '|') {
					if ((Character.getNumericValue(bin1.charAt(i)) == 0
							&& Character.getNumericValue(bin2.charAt(l2)) == 1)
							|| (Character.getNumericValue(bin1.charAt(i)) == 1
									&& Character.getNumericValue(bin2.charAt(l2)) == 0)) {
						newLong = UNO + newLong;
					}
				} else {
					System.out.println(c + " operand not recognized");
				}

				if ((Character.getNumericValue(bin1.charAt(i)) == 0
						&& Character.getNumericValue(bin2.charAt(l2)) == 0)) {
					newLong = ZERO + newLong;
				}

				if ((Character.getNumericValue(bin1.charAt(i)) == 1
						&& Character.getNumericValue(bin2.charAt(l2)) == 1)) {
					newLong = UNO + newLong;
				}
			}
		} else {
			for (int i = l2 - 1; i >= 0; i--) {
				l1--;
				if (c == '&') {
					if ((Character.getNumericValue(bin1.charAt(l1)) == 0
							&& Character.getNumericValue(bin2.charAt(i)) == 1)
							|| (Character.getNumericValue(bin1.charAt(l1)) == 1
									&& Character.getNumericValue(bin2.charAt(i)) == 0)) {
						newLong = ZERO + newLong;
					}
				} else if (c == '|') {
					if ((Character.getNumericValue(bin1.charAt(l1)) == 0
							&& Character.getNumericValue(bin2.charAt(i)) == 1)
							|| (Character.getNumericValue(bin1.charAt(l1)) == 1
									&& Character.getNumericValue(bin2.charAt(i)) == 0)) {
						newLong = UNO + newLong;
					}
				} else {
					System.out.println(c + " operand not recognized");
				}

				if ((Character.getNumericValue(bin1.charAt(l1)) == 0
						&& Character.getNumericValue(bin2.charAt(i)) == 0)) {
					newLong = ZERO + newLong;
				}

				if ((Character.getNumericValue(bin1.charAt(l1)) == 1
						&& Character.getNumericValue(bin2.charAt(i)) == 1)) {
					newLong = UNO + newLong;
				}
			}
		}
		for (int i = newLong.length() - 1; i >= 0; i--) {
			if (newLong.charAt(i) == UNO) {
				Double d = Math.pow(DUE, (newLong.length() - 1) - i);
				l = Long.valueOf(d.longValue()) + l;
			}
		}
		return l;
	}
}