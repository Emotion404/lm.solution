#include <iostream>

using namespace std;

int findArea(int length, int width);

int main()
{
	int length;
	int width;
	int area;

	cout << "how wide is your yard?";
	cin >> width;

	cout << "how long is your yard?";
	cin >> length;

	area = findArea(length, width);

	cout << "your yard is " << area << " square feet" << endl;

	return 0;
}

int findArea(int l, int w)
{
	return l * w;
}