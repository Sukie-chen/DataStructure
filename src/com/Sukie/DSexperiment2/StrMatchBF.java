package com.Sukie.DSexperiment2;

public class StrMatchBF {//����ƥ��
	
	  /**
     * ƥ���ַ���
     * @param targetStr    Ŀ�괮
     * @param patternStr    ģʽ��
     * @return  ���ģʽ�ַ�����ԭʼ�ַ����д��ڣ�����ģʽ�ַ�����ԭʼ�ַ����е�һ�γ��ֵ�������
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
                // ʧ�䣬����
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
			System.out.println("ƥ��ʧ��");
		} else {
			System.out.println("��"+(i+1)+"��ƥ�䣬ƥ��ɹ�");
		}
		
	}
}
