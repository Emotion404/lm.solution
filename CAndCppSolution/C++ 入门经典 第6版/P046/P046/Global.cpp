#include <iostream>

using namespace std;

void convert();

float fahrenheit;
float celsius;

int main()
{
	cout << "Please enter the temperature in Fahrenheit:";
	cin >> fahrenheit;

	convert();

	cout << endl;
	cout << "Here's the temperature in Celsius :";
	cout << celsius;

	return 0;
}

void convert()
{
	celsius = ((fahrenheit - 32) * 5) / 9;
}