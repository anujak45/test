#include<stdio.h>
int add(int a,int b)
{
	int c=o;
	c=a+b;
	return c;
}
int sub(int a,int b)
{
	int c=o;
	c=a-b;
	return c;
}
int div(int a,int b)
{
	int c=o;
	c=a/b;
	return c;
}
int mul(int a, int b)
{
	int c=o;
	c=a*b;
	return c;
}
int main()
{
	int ch,ch1,num1,num2,f;
	do{
	printf("\n1.Addition\n2.Subtraction\n3.Multiplication\n4.Devision :\n");
	scanf("%d",&ch);
	printf("\n Enter First Number : ")
	scanf("%d",&num1);
	printf("\n Enter Second Number : ")
	scanf("%d",&num2);
	switch(ch)
	{
		case 1:
			f=add(num1,num2);
			printf("\n Addition is : %d",f);
		case 2:
			f=sub(num1,num2);
			printf("\n Subtraction is : %d",f);
		case 3:
			f=mul(num1,num2);
			printf("\n Multiplication is : %d",f);
		case 4:
			f=div(num1,num2);
			printf("\n division is : %d",f);
			
	
	}
	printf("\n Do you want to continue ? Press '1' \n");
	scanf("%d",&ch1);
	}
	while(ch1==1);
	return 0;
}