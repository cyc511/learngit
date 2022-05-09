#include<stdio.h>
#define N 8
struct stu
{
	int num;
	float score;
};
float ave;
int GetStu(stu st[])
{
	for(int i=0;i<N;i++)
	   scanf("%d %f",&st[i].num,&st[i].score);
	return 0; 
}
float AveStu(stu st[])
{
	float sum=0;
	for(int i=0;i<N;i++)
	    sum=+ st[i].score;
    printf("Ave is %f\n",sum/N);
    return(sum/N);
}

int PriStu(stu st[])
{
	for(int i=0;i<N;i++)
	    {
	    	if(st[i].score>ave)
	    	printf("%d %f\n",st[i].num,st[i].score);
	    }
	    return 0;
}

int main()
{
	stu st[N];
	GetStu(st);
	ave = AveStu(st);
	PriStu(st);
	return 0;
}
