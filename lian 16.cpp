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
	printf("%d��󣬺�ҹ��Ͷ�ʶ��С���㣡\n",i);
	printf("С�����Ͷ�ʶ��ǣ�%d",x);
	printf("��ҹ��Ͷ�ʶ��ǣ�%f",y);
	return 0;
}
