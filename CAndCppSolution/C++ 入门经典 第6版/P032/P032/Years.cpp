#include <iostream>

using namespace std;

int main()
{
	int year = 2016;

	cout << "the year : " << ++year << endl;
	cout << "the year : " << ++year << endl;
	cout << "the year : " << ++year << endl;

	cout << "-----------------------------------"<<endl;

	cout << "the year : " << year++ << endl;
	cout << "the year : " << year++ << endl;
	cout << "the year : " << year++ << endl;

	return 0;

}