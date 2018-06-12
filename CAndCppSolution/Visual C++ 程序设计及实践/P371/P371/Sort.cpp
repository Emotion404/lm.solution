
#include <iostream>

using namespace std;

// 定义函数 -- 插入排序算法
void Sort(int* ary,int nSize)
{
	/*
	* 循环元素,动态理解:
	* arr[1] 与 arr[0] 比较
	* arr[2] 与 arr[1],arr[0] 比较
	* arr[3] 与 arr[2],arr[1],arr[0] 比较
	* 等等 依次类推
	*/
	for(int i=1;i<nSize;i++)
	{
		int tmp=ary[i];
		int n=i-1;

		// 若后位元素小于前位元素则交换位置
		while (tmp<ary[n])
		{
			ary[n+1]=ary[n];

			// 元素为动态递减
			n--;

			// 到第一位元素后,无前位元素,跳出
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
	// 需要排序的数组
	int numArray[]={12,31,5,87,1,56};
	int nLength=sizeof(numArray)/sizeof(int);

	// 排序
	Sort(numArray,nLength);

	// 显示排序后的结果
	for(int k=0;k<nLength;k++)
	{
		cout<<numArray[k]<<",";
	}
	cout<<endl;

	// 退出
	return 0;
}


