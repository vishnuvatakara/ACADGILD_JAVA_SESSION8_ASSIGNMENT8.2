package threads;

import java.io.IOException;
import java.util.Scanner;

class Prime extends Thread //creating a class that extends the thread class
{	int num;
	Prime(int num)
	{
		this.num=num;	//reading input value
	}
	public void run() //thread run method that contain the prgm logic
	{	int flag=0;
		try
		{	Thread.sleep(1000);		//pause the execution for 100000 milliseconds so the other thread in the prgm start to exicute
			for(int i=2;i<num;i++)
			{	
				if(num%i==0)
				{
					flag=1;		//checking number is prime or not 
					break;
				}
			}
			if(flag==0)
			{
				System.out.println("number is prime :"+num);
			}													//checking number is prime or not 
			else
			{
				System.out.println("number is not prime :"+num);
			}
			
		}
		catch(Exception ae) {
			ae.printStackTrace();
		}
}
}
class PrimeRun implements Runnable{	//class primerun implements the runnable interface c
	//class is used to find prime number via runnable interface
	int num;
	PrimeRun(int num)
	{
		this.num=num;	//input reading
	}
	public void run()			//run method contain prgm logic
	{	int flag=0;
		try												//checking number is prime or not 
		{
			for(int i=2;i<num;i++)
			{	
				if(num%i==0)							//checking number is prime or not 
				{
					flag=1;
					break;
				}
			}
			if(flag==0)
			{
				System.out.println("number is prime :"+num);	//checking number is prime or not 
			}
			else
			{
				System.out.println("number is not prime :"+num);
			}
		}
		catch(Exception ae)
		{
			ae.printStackTrace();
		}
	}
	
}
public class Myclass {
	public static void main(String args[])
	{
		Prime obj=new Prime(20);	//creating thread via thread class following
		obj.start();
		Prime obj1=new Prime(21);
		obj1.start();
	
		PrimeRun obj2=new PrimeRun(22);	//creating thread via runnable interface class following
		Thread t1=new Thread(obj2);
		Thread t2=new Thread(obj2);
		t1.start();
		t2.start();
		
	}
}


