package com.yucheng.util;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * ��������Ϸ�Ĺ�����
 * 
 * @author liufeng
 * @date 2013-11-21
 */
public class GameUtil {
	/**
	 * ��֤�Ƿ���4λ������
	 * 
	 * @param number
	 * @return
	 */
	public static boolean verifyNumber(String number) {
		boolean result = false;
		// ������ʽ����0-9֮��������������4��
		Pattern pattern = Pattern.compile("[0-9]{4}");
		Matcher matcher = pattern.matcher(number);
		// ƥ��ɹ��ͱ����Ǵ�����
		if (matcher.matches())
			result = true;

		return result;
	}

	/**
	 * ��֤�Ƿ����ظ��ַ�
	 * 
	 * @param number
	 * @return
	 */
	public static boolean verifyRepeat(String number) {
		boolean result = false;
		// �ӵ�2λ��ʼ��ÿλ������ǰ���������Ƚ�һ��
		for (int i = 1; i < number.length(); i++) {
			for (int j = 0; j < i; j++) {
				if (number.charAt(i) == number.charAt(j)) {
					result = true;
					break;
				}
			}
		}
		return result;
	}

	/**
	 * ��ɲ��ظ���4λ�����
	 * 
	 * @return String
	 */
	public static String generateRandNumber() {
		StringBuffer randBuffer = new StringBuffer();
		String scopeStr = "0123456789";
		Random random = new Random();
		for (int i = 0; i < 4; i++) {
			int num = random.nextInt(scopeStr.length());
			randBuffer.append(scopeStr.charAt(num));
			// ��ÿ�λ�ȡ����������scopeStr���Ƴ�
			scopeStr = scopeStr.replace(String.valueOf(scopeStr.charAt(num)), "");
		}
		return randBuffer.toString();
	}

	/**
	 * ����²���
	 * 
	 * @param answer ��ȷ��
	 * @param number �²������
	 * @return xAyB
	 */
	public static String guessResult(String answer, String number) {
		// λ�������־���ͬ
		int rightA = 0;
		// ���ִ��ڵ�λ�ò���
		int rightB = 0;

		// ���㡰A���ĸ���
		for (int i = 0; i < 4; i++) {
			// λ�������־���ͬ
			if (number.charAt(i) == answer.charAt(i)) {
				rightA++;
			}
		}

		// ���㡰B���ĸ���
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				// λ�ò���ͬ
				if (i != j) {
					if (number.charAt(i) == answer.charAt(j)) {
						rightB++;
					}
				}
			}
		}
		return String.format("%sA%sB", rightA, rightB);
	}

	/**
	 * ��ȡ��׼��ʽ��ʱ��
	 * 
	 * @return yyyy-MM-dd hh:mm:ss
	 */
	public static String getStdDateTime() {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return df.format(new Date());
	}
}
