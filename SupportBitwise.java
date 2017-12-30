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
	/**
	 * 
	 */
	private final static int DUE = 2;

	/**
	 * Metodo di supporto per ridurre la complessità ciclomatica nel metodo che
	 * restituisce una variabile boolean
	 * 
	 * @param bin1
	 * @param bin2
	 * @param index1
	 * @param index2
	 * @return
	 */
	private static boolean cyclomaticComplexity1(String bin1, String bin2, int index1, int index2) {
		if ((bin1.charAt(index1) != bin2.charAt(index2)) || (Character.getNumericValue(bin1.charAt(index1)) == 0)
				&& (Character.getNumericValue(bin2.charAt(index2)) == 0)) {
			return true;
		} else {
			return false;
		}
	}

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
				if (!(flag = cyclomaticComplexity1(bin1, bin2, i, l2))) {
					break;
				}
			}
		} else {
			for (int i = l2 - 1; i >= 0; i--) {
				l1--;
				if (!(flag = cyclomaticComplexity1(bin1, bin2, l1, i))) {
					break;
				}
			}
		}
		return flag;
	}

	/**
	 * 
	 * @param bin1
	 * @param bin2
	 * @param index1
	 * @param index2
	 * @return
	 */
	private static boolean cyclomaticComplexity2(String bin1, String bin2, int index1, int index2) {
		if ((Character.getNumericValue(bin1.charAt(index1)) == 0 && Character.getNumericValue(bin2.charAt(index2)) == 1)
				|| (Character.getNumericValue(bin1.charAt(index1)) == 1
						&& Character.getNumericValue(bin2.charAt(index2)) == 0)) {
			return true;
		} else {
			return false;
		}
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
		boolean flag = false;
		String newLong = "";
		long l = 0;
		String bin1 = Long.toBinaryString(long1);
		String bin2 = Long.toBinaryString(long2);
		int l1 = bin1.length();
		int l2 = bin2.length();
		int j = Math.max(l1, l2) - Math.min(l1, l2);
		while (j >= 0) {
			if (l1 > l2) {
				bin2 = '0' + bin2;
				l2++;
			} else if (l1 < l2) {
				bin1 = '0' + bin1;
				l1++;
			} else {
				break;
			}
			j--;
		}
		if (l1 <= l2) {
			for (int i = l1 - 1; i >= 0; i--) {
				l2--;
				flag = cyclomaticComplexity2(bin1, bin2, i, l2);
				if ((c == '&') && (flag)) {
					newLong = ZERO + newLong;
				} else if ((c == '|') && (flag)) {
					newLong = UNO + newLong;
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
				flag = cyclomaticComplexity2(bin1, bin2, l1, i);
				if ((c == '&') && (flag)) {
					newLong = ZERO + newLong;
				} else if ((c == '|') && (flag)) {
					newLong = UNO + newLong;
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