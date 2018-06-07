
#include <iostream>

using namespace std;

void Sort(int* ary,int nSize)
{
	for(int i=1;i<nSize;i++)
	{
		int tmp=ary[i];
		int n=i-1;

		while (tmp<ary[n])
		{
			ary[n+1]=ary[n];
			n--;
			if(n==-1)
			{
				break;
			}
		}

		ary[n+1]=tmp;
	}
}

int main(int argc, char* argv[])
{
	int numArray[]={12,31,5,87,1,56};
	int nLength=sizeof(numArray)/sizeof(int);

	Sort(numArray,nLength);

	for(int k=0;k<nLength;k++)
	{
		cout<<numArray[k]<<",";
	}
	cout<<endl;

	return 0;
}


