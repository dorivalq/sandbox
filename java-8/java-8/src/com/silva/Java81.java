package com.silva;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;


public class Java81 {
	public static void main(String[] args) {
		Arrays.asList("A", "B").forEach(l -> System.out.println(l));
		
//		Object d = (D) (C) new D();
//		D d = (D) new C(); //OK
		C c = (C) new D();
		System.out.println(c);
	}
	
}

class A{
	
	int x(){
		new RuntimeException();
		return 1;
	}
}
abstract class B{
	abstract int x();
}
class C extends B{

	@Override
	int x() {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
class D extends C{
	
	void e()throws IOException{
		int i = 10;
		System.out.println(i);
//		try {
//			int i1 = 10;
//			System.out.println(i1);
//			//new FileInputStream("file.txt");
//		} catch (IOException e) {
//			// TODO: handle exception
//		}
	}
}


////////////////////
