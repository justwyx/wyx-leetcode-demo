package com.wyx.leetcode.B面试经典.B3URL化;

/**
 * @Description
 * URL化。编写一种方法，将字符串中的空格全部替换为%20。假定该字符串尾部有足够的空间存放新增字符，并且知道字符串的“真实”长度。（
 * 注：用Java实现的话，请使用字符数组实现，以便直接在数组上操作。）
 *
 * 示例1:
 *  输入："Mr John Smith    ", 13
 *  输出："Mr%20John%20Smith"
 *
 * 示例2:
 *  输入："               ", 5
 *  输出："%20%20%20%20%20"
 *
 * 提示：
 * 字符串长度在[0, 500000]范围内。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/string-to-url-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author : Just wyx
 * @Date : 2020/8/18
 */
public class ReplaceSpacesV4 {

	/**
	 * 之前没发现这句【假定该字符串尾部有足够的空间存放新增字符】
	 * 开始担心用char数组不知道长度，添加起来可能还需要扩容，所以改用的string[],这下不用担心了
	 */
//	public String replaceSpaces(String s, int length) {
//		char[] chars = s.toCharArray();
//
//		int j = 0, curIndex = 0;
//		while (curIndex < length -1) {
//			if (' ' == chars[curIndex]) {
//				chars[j++] = '%';
//				chars[j++] = '2';
//				chars[j++] = '0';
//			} else {
//				chars[j++] = chars[curIndex];
//			}
//			curIndex++;
//		}
//		// 截取掉多余的空格
//		return String.valueOf(chars, 0, j);
//	}

	public String replaceSpaces(String S, int length) {
		char[] chs = S.toCharArray();
		int i = length-1, j = S.length()-1;
		while(i>=0){
			if(chs[i]==' '){
				chs[j--] = '0';
				chs[j--] = '2';
				chs[j--] = '%';
			}else{
				chs[j--] = chs[i];
			}
			i--;
		}
		return String.valueOf(chs,j+1, S.length()-j-1);
	}

	public static void main(String[] args) {
		System.out.println(new ReplaceSpacesV4().replaceSpaces("Mr John Smith    ", 13));
//		System.out.println(new ReplaceSpacesV4().replaceSpaces("               ", 5));
	}
}

