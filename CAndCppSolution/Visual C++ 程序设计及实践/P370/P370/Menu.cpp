#include <iostream>

using namespace std;

int main (int argc,char* argv[])
{
	int num=0;
	cout<<"����������(1-3)ѡ��˵���:"<<endl;

	do
	{
		cout<<"1.�½�"<<endl;
		cout<<"2.��"<<endl;
		cout<<"3.�˳�"<<endl;

		cin>>num;

		switch (num)
		{
		case 1:
			cout<<"��ѡ�����½�!"<<endl;
			break;
		case 2:
			cout<<"��ѡ���˴�!"<<endl;
			break;
		case 3:
			cout<<"��ѡ�����˳�!"<<endl;
			break;
		default:
			cout<<"��Ч����!"<<endl;
		}
	}while(num!=3);

	return 0;
}