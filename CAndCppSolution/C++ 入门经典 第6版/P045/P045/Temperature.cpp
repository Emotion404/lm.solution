#include <iostream>
using namespace std;

float convert(float);

int main()
{
	float fahrenheit;
	float celsius;

	cout << "Please enter the temperature in Fahrenheit:";
	cin >> fahrenheit;

	celsius = convert(fahrenheit);

	cout << endl;
	cout << "Here's the temperature in Celsius :";
	cout << celsius;

	return 0;
}

float convert(float fahrenheit)
{
	float celsius;
	celsius = ((fahrenheit - 32) * 5) / 9;
	return celsius;
}
