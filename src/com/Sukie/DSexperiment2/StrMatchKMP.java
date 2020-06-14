package com.Sukie.DSexperiment2;

public class StrMatchKMP { //KMP匹配
	
	public static int[] getNextArray(String str) {
        if(str == null || str.length() <= 0)
            return null;

        int length = str.length();
        int[] nextArr = new int[length];
        int j = 0;
        int k = -1;
        nextArr[0] = -1;
        while(j < length - 1) {
            if(k == -1 || str.charAt(j) == str.charAt(k)) {
                j++; 
                k++;
                if(str.charAt(j) != str.charAt(k))
                    nextArr[j] = k;
                else 
                    nextArr[j] = nextArr[k];
            } else {
                k = nextArr[k];
            }
        }
        return nextArr;
    }

    public static int indexOfStr(String iniStr, String patternStr) {
        if(iniStr == null || iniStr.length() <= 0 ||
                patternStr == null || patternStr.length() <= 0)
            return -1;

        // 得到模式串的next数组
        int[] nextArr = getNextArray(patternStr);
        int iniLength = iniStr.length();
        int patternLength = patternStr.length();
        int i = 0;  // 目标串索引
        int j = 0;  // 模式串索引
        while(i < iniLength && j < patternLength) {
            if(j == -1 || iniStr.charAt(i) == patternStr.charAt(j)) {
                i++;
                j++;
            } else {
                j = nextArr[j];
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
		
		int i = indexOfStr(string1, string2);
		if (i == -1) {
			System.out.println("匹配失败");
		} else {
			System.out.println("第"+(i+1)+"次匹配，匹配成功");
		}
		
	}
}
