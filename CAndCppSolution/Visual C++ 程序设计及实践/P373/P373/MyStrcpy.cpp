
#include <iostream>

using namespace std;

char* mystrcpy(char* strDestination,const char* strSource);

int main(int argc,char* argv[])
{
	char *sDest=new char[100];
	char* str="hello C++";

	mystrcpy(sDest,str);

	cout<<sDest<<endl;

	delete []sDest;

	return 0;
}

char* mystrcpy(char *strDestination,const char *strSource)
{
	char* sDest=strDestination;

	while(true)
	{
		*strDestination=*strSource;

		if(*strSource==0)
		{
			break;
		}

		strDestination++;
		strSource++;
	}

	return sDest;
}
