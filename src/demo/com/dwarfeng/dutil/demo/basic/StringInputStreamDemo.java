package com.dwarfeng.dutil.demo.basic;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Scanner;

import com.dwarfeng.dutil.basic.io.CT;
import com.dwarfeng.dutil.basic.io.StringInputStream;

/**
 * {@link StringInputStream} ��ʾ����
 * @author DwArFeng
 * @since 0.0.2-beta
 */
public class StringInputStreamDemo {

	public static void main(String[] args) throws IOException {
		String testString = new StringBuilder()
				.append("���ǵ�һ��\n")
				.append("This is the second line\n")
				.append("���ǵ�����\n")
				.append("This is the forth line")
				.toString();
		StringInputStream in = new StringInputStream(testString, Charset.forName("UTF-8"));
		
		Scanner scanner = new Scanner(in, "UTF-8");
		
		try{
			while(scanner.hasNextLine()){
				CT.trace(scanner.nextLine());
			}
		}finally{
			scanner.close();
		}
	}
	
}
