package wangyi;
import java.util.Scanner;

import org.omg.CORBA.PUBLIC_MEMBER;

import sun.awt.AWTAccessor.SystemColorAccessor;

public class yanxuan {
	public static void main(String[] args) {
//		System.out.println("hello");
//		byte i1=1;
//		short i2=2;
//		int i3;
//		long i4=1000L;
//		char i5='c';
//		boolean i6=true;
//		float i7=3.14f;
//		double i8=3.14;
//		
//		String s="nihao";
		 System.out.print("请输入金字塔层数：");
	        Scanner scanner = new Scanner(System.in);
	        int count = scanner.nextInt();
	        System.out.print("1：金字塔；2：倒金字塔；3：九九乘法表；4：1000以内的偶数；5：青蛙跳井");
	        int mode = scanner.nextInt();
	        switch (mode) {
	        case 1:
	            function_1(count);
	            break;
	        case 2:
	            function_2(count);
	            break;
	        case 3:
	        	function_3();
	        case 4:
	        	function_4();
	        case 5:
	        	function_5();
	        case 6:
	        	function_6();
//	        default:
//	            System.out.println("输入有误！");
//	            break;
	        }
	        scanner.close();
	    }

	    // 金字塔
	    public static void function_1(int count) {
	        for (int i = 0; i < count; i++) {
	            for (int space = count - i - 1; space > 0; space--) {
	                System.out.print("   ");
	            }
	            for (int star = 0; star < (2 * i + 1); star++) {
	                System.out.print("☆");
	            }
	            System.out.println();
	        }
	    }

	    // 倒金字塔
	    public static void function_2(int count) {
	        for (int i = 0; i < count; i++) {
	            for (int space = 0; space < i; space++) {
	                System.out.print("    ");
	            }
	            for (int star = 0; star < (2 * (count - i) - 1); star++) {
	                System.out.print("☆");
	            }
	            System.out.println();
	        }
	    }
		public static void function_3() {
			for (int row = 1; row < 10; row++) {
	            for (int column = 1; column <= row; column++) {
	                System.out.print(row+"*"+column+"="+row*column);
	                System.out.print("    ");
	            }
	            System.out.println();
		}
	}
		public static void function_4() {
			for(int i=0;i<1000;i++) {
				if(i%2==0)
					System.out.println(i);
			}
		}
		public static void function_5(){
			int deep=20;
			int up=3;
			int down=2;
			int days=0;
			while(deep>=3){
				deep-=1;
				days++;
			}
			System.out.println("青蛙需用"+days+"天才能从井中爬出！");
		}
	    public static void function_6() {
	    	double [] l= {100,200,45,79,65,52,24};
	    	for(int i=0;i<l.length-1;i++) {
	    		for(int k=0;k<l.length-i-1;k++) {
	    			if(l[k+1]<l[k]) {
	    				double temp=l[k];
	    				l[k]=l[k+1];
	    				l[k+1]=temp;
	    			}
	    		}
	    	}
	    	for(int i=0;i<l.length;i++) {
	    		System.out.println(l[i]);
	    	}
	    }
}
