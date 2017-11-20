package com.silva;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;

public class Java82 {
	public static void main(String[] args) {
		Arrays.asList("A", "B").forEach(l -> System.out.println(l));

		// Object d = (D) (C) new D();
		// D d = (D) new C(); //OK
		C c = (C) new D();
		System.out.println(c);
	}

}

interface Z {
}

interface W {
}

interface Y extends Z, W {
}

class B {
}

class C extends B implements Y {
}

class D extends B implements Z, W {
}

class E extends C {
}

class A {
	public static void main(String[] args) {
		Y y = (Y) new D();
	}
}
