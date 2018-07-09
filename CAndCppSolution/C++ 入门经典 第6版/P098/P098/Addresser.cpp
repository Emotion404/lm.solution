#include <iostream>

int main()
{
	unsigned short shortVar = 5;
	unsigned long longVar = 65535;
	long sVar = -65535;

	std::cout << "shortVar : \t" << shortVar << "\tAdderess of shorVar : \t" << &shortVar << "\n";
	std::cout << "longVar : \t" << longVar << "\tAdderess of longVar \t" << &longVar << "\n";
	std::cout << "sVar :  \t" << sVar << "\tAddress of sVar \t" << &sVar << "\n";

	return 0;
}