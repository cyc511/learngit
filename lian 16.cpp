#include<stdio.h>
int main()
{
	int x=10000,y=10000,z,i;
	z=x*0.1;
	for(i=0;x>=y;i++)
	{
		x=x+z;
		y=y*1.05;
	}
	printf("%d年后，黑夜的投资额超过小甲鱼！\n",i);
	printf("小甲鱼的投资额是：%d",x);
	printf("黑夜的投资额是：%f",y);
	return 0;
}
