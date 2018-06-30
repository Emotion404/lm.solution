#include <iostream>

using namespace std;

int findArea(int length, int width = 20, int height = 12);

int main()
{
	int length = 100;
	int width = 50;
	int height = 2;

	int area;

	area = findArea(length, width, height);
	cout << "First Area : " << area << endl;

	area = findArea(length, width);
	cout << "Second Area : " << area << endl;

	area = findArea(length);
	cout<< "Third Area : " << area << endl;
	
	return 0;

}

int findArea(int length, int width , int height )
{
	return (length*width*height);
}
