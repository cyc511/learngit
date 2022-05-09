#include<stdio.h>
#include<stdlib.h>
#include<math.h>
#include<string.h> 
#define N 501
int gender[N];
int n,e[N][N],k;
void floyd(){
	for(int k=n;k>=1;k--)
	for(int i=1;i<=n;i++)
	for(int j=1;j<=n;j++)
		e[i][j]=fmin(e[i][j],e[i][k]+e[k][j]);
}
int main(){
	memset(e,0x3f3f3f3f,sizeof(e));
	scanf("%d%d",&n,&k);
	for(int i=1;i<=k;i++){
		int a,b,c;
		scanf("%d%d%d",&a,&b,&c);
		e[a][b]=c;
		e[b][a]=c;
	}
	floyd();
	while(1){
		int a,b;
		scanf("%d%d",&a,&b);
		printf("%d\n",e[a][b]);
	}
	return 0;
}
