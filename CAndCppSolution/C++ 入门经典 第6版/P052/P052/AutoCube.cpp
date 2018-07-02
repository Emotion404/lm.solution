#include <iostream>

using namespace std;

auto findArea(int length, int width = 20, int height = 12);
auto findArea(int length, int width, int height)
{
	return (length*width*height);
}


int main()
{
	int length = 100;
	int width = 50;
	int height = 2;
	int area;

	area = findArea(length, width, height);
	cout << "First area : " << area << endl;

	area = findArea(length, width);
	cout << "Second area : " << area << endl;

	area = findArea(length);
	cout << "Third area : " << area << endl;

	return 0;
}


