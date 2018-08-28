package wangyi;

public class Person {
	String name;
	int age;
	double height;
	double weight;
	
	public void play() {
		System.out.println("我会玩游戏");
	}
	public void speak() {
		System.out.println("hello,我叫"+this.name);
	}
	public Person() {
		
	}
	public Person(String name,int age) {
		this.name=name;
		this.age=age;
	}
	public static double sum(double a,double b) {
		return a+b;
	}
	public static double cheng(double a,double b) {
		return a*b;
	}
	public static void main(String[] args) {
	
	Person p =new Person();
	p.age=1;
	p.name="baby";
	p.weight=45;
	p.height=163;
	p.speak();
	p.play();
	Person p2=new Person("Angelababy",18);
	p2.speak();
	double c=sum(100,200);
	System.out.println(c);
	double d=cheng(100,200);
	System.out.println(d);
	}
}
