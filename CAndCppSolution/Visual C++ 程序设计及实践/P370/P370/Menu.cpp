#include <iostream>

using namespace std;

int main (int argc,char* argv[])
{
	int num=0;
	cout<<"请输入数字(1-3)选择菜单项:"<<endl;

	do
	{
		cout<<"1.新建"<<endl;
		cout<<"2.打开"<<endl;
		cout<<"3.退出"<<endl;

		cin>>num;

		switch (num)
		{
		case 1:
			cout<<"您选择了新建!"<<endl;
			break;
		case 2:
			cout<<"您选择了打开!"<<endl;
			break;
		case 3:
			cout<<"您选择了退出!"<<endl;
			break;
		default:
			cout<<"无效操作!"<<endl;
		}
	}while(num!=3);

	return 0;
}