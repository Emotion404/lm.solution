
#include <iostream>

using namespace std;

// ���庯�� -- ���������㷨
void Sort(int* ary,int nSize)
{
	/*
	* ѭ��Ԫ��,��̬���:
	* arr[1] �� arr[0] �Ƚ�
	* arr[2] �� arr[1],arr[0] �Ƚ�
	* arr[3] �� arr[2],arr[1],arr[0] �Ƚ�
	* �ȵ� ��������
	*/
	for(int i=1;i<nSize;i++)
	{
		int tmp=ary[i];
		int n=i-1;

		// ����λԪ��С��ǰλԪ���򽻻�λ��
		while (tmp<ary[n])
		{
			ary[n+1]=ary[n];

			// Ԫ��Ϊ��̬�ݼ�
			n--;

			// ����һλԪ�غ�,��ǰλԪ��,����
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
	// ��Ҫ���������
	int numArray[]={12,31,5,87,1,56};
	int nLength=sizeof(numArray)/sizeof(int);

	// ����
	Sort(numArray,nLength);

	// ��ʾ�����Ľ��
	for(int k=0;k<nLength;k++)
	{
		cout<<numArray[k]<<",";
	}
	cout<<endl;

	// �˳�
	return 0;
}


