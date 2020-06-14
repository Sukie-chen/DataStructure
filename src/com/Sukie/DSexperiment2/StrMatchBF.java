package com.Sukie.DSexperiment2;

public class StrMatchBF {//暴力匹配
	
	  /**
     * 匹配字符串
     * @param targetStr    目标串
     * @param patternStr    模式串
     * @return  如果模式字符串在原始字符串中存在，返回模式字符串在原始字符串中第一次出现的索引。
     */
    public static int indexOfStr(String targetStr, String patternStr) {
        if(targetStr == null || targetStr.length() <= 0 || 
                patternStr == null || patternStr.length() <=0)
            return -1;

        int targetLength = targetStr.length();
        int patternLength = patternStr.length();
        int i = 0, j = 0;
        while(i < targetLength && j < patternLength) {
            if(targetStr.charAt(i) == patternStr.charAt(j)) {
                i++;
                j++;
            } else {
                // 失配，回退
                i = i - j + 1;
                j = 0;
            }
        }
        if(j == patternLength)
            return i - patternLength;
        else
            return -1;
    }
	
	public static void main(String[] args) {
		String string1 = "ABCBCDEFB";
		String string2 = "BCD";
		
		MyString targetString = new MyString(string1);
		MyString patternString = new MyString(string2);
		int i = targetString.indexOfBF(patternString);
		
//		int i = indexOfStr(string1, string2);
		if (i == -1) {
			System.out.println("匹配失败");
		} else {
			System.out.println("第"+(i+1)+"次匹配，匹配成功");
		}
		
	}
}
