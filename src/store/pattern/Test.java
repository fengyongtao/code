package store.pattern;

import store.pattern.impl.Beauty;
import store.pattern.impl.NobugPrint;

public class Test {
	public static void main(String[] args) {
		Print nobugPrint = new NobugPrint();
		nobugPrint.doPrint();
		
		Print beautyPrint = new Beauty();
		beautyPrint.doPrint();
	}
}
