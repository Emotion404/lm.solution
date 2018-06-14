#include <iostream>

using namespace std;

int main()
{
	typedef unsigned short USHORT;

	USHORT width = 26;
	USHORT length = 40;
	USHORT area = width * length;

	cout << "width:" << width << endl;
	cout << "length:" << length << endl;
	cout << "area:" << area << endl;

	return 0;
}