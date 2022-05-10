package util;

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.HanyuPinyinVCharType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;

/**
 * 获取汉字的拼音和简拼
 * @author xujun
 * version: 1.1
 */
public class PinyinUtil {

	public static void main(String[] args) {
		System.out.println(getPinyin("张三"));
		System.out.println(getPinyinInitials("张三"));
	}

	/**
	 * 将汉字转换为全拼
	 *
	 * @param text 文本
	 * @return {@link String}
	 */
	public static String getPinyin(String text) {
		char[] chars = text.toCharArray();
		HanyuPinyinOutputFormat format = new HanyuPinyinOutputFormat();
		// 设置大小写
		format.setCaseType(HanyuPinyinCaseType.LOWERCASE);
		// 设置声调表示方法
		format.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
		// 设置字母u表示方法
		format.setVCharType(HanyuPinyinVCharType.WITH_V);
		String[] s;
		String rs = "";
		try {
			StringBuilder sb = new StringBuilder();
			for (char aChar : chars) {
				// 判断是否为汉字字符
				if (String.valueOf(aChar).matches("[\\u4E00-\\u9FA5]+")) {
					s = PinyinHelper.toHanyuPinyinStringArray(aChar, format);
					if (s != null) {
						sb.append(s[0]);
						continue;
					}
				}
				sb.append(aChar);
			}
			rs = sb.toString();
		} catch (BadHanyuPinyinOutputFormatCombination e) {
			e.printStackTrace();
		}
		return rs;
	}

	/**
	 * 获取汉字首字母
	 *
	 * @param text 文本
	 * @return {@link String}
	 */
	public static String getPinyinInitials(String text) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < text.length(); i++) {
			char ch = text.charAt(i);
			String[] s = PinyinHelper.toHanyuPinyinStringArray(ch);
			if (s != null) {
				sb.append(s[0].charAt(0));
			} else {
				sb.append(ch);
			}
		}
		return sb.toString();
	}
}
