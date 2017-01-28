package com.dwarfeng.dutil.basic.str;

import java.util.Comparator;

/**
 * �ַ����Ƚ�����
 * <p> �����ַ���Ĭ�ϵ������㷨���ֵ����򣩽���������ַ����Ƚ�����
 * @author  DwArFeng
 * @since 0.0.3-beta
 */
public class StringComparator implements Comparator<String> {

	/*
	 * (non-Javadoc)
	 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
	 */
	@Override
	public int compare(String string1, String string2) {
		if(string1 == null && string2 == null){
			return 0;
		}else if(string1 == null){
			return -1;
		}else if(string2 == null){
			return 1;
		}
		
        int len1 = string1.length();
        int len2 = string2.length();
        int lim = Math.min(len1, len2);
        char v1[] = string1.toCharArray();
        char v2[] = string2.toCharArray();

        int k = 0;
        while (k < lim) {
            char c1 = v1[k];
            char c2 = v2[k];
            if (c1 != c2) {
                return Integer.signum(c1 - c2);
            }
            k++;
        }
        return Integer.signum(len1 - len2);
    }

}
