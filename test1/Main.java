package test1;

import java.util.Scanner;

public class Main {
public static void main(String[] args) {
	Scanner in = new Scanner(System.in);
	Fraction a = new Fraction(in.nextInt(),in.nextInt());
	Fraction b = new Fraction(in.nextInt(),in.nextInt());
	a.print();
	b.print();
	a.plus(b).print();
	a.multiply(b).plus(new Fraction(5,6)).print();
	a.print();
	b.print();
	in.close();
	}
}

class Fraction{
	int x;
	int y;
	
	Fraction(){
		
	}
	Fraction(int x,int y){
		this.x = x;
		this.y = y;
	}
	
	double toDouble() {
		return (double)x/y;
	}
	
	Fraction plus(Fraction r) {
		Fraction temp = new Fraction();
		temp.x = (this.x * r.y) + (r.x * this.y);
		temp.y = this.y * r.y;
		return temp;		
	}
	
	Fraction multiply(Fraction r) {
		Fraction temp = new Fraction();
		temp.x = this.x * r.x;
		temp.y = this.y * r.y;
		return temp;	
	}
	
	int getGcd(Fraction r) {
		int num1;
		int num2;
		int temp;
		num1 = r.x;
		num2 = r.y;
		for(;;) {
			temp = num1 % num2;
			num1 = num2 ;
			num2 = temp;
			if(num2 == 0) {
				break;
			}else if(num2 == 1) {
				return 0;
			}
		}
		
		return num1;
	}
	void print() {
		if(this.x%this.y == 0) {
			System.out.println(this.x/this.y);
		}else if(getGcd(this)!=0) {
			System.out.println(this.x/getGcd(this) + "/"+this.y/getGcd(this));
		}else {
			System.out.println(this.x + "/" + this.y);
		}
	}
}
