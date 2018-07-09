#include <iostream>

int main()
{
	unsigned short int myAge = 5, yourAge = 10;
	unsigned short int* pAge = &myAge;

	std::cout << "myAge : " << myAge << " &myAge : " << &myAge << "\n";
	std::cout << "yourAge : "<<yourAge << " &yourAge : " << &yourAge << "\n";
	std::cout << "pAge : " << pAge << " *pAge : " << *pAge << " &pAge : " << &pAge << "\n";

	pAge = &yourAge;
	std::cout << "myAge : " << myAge << " &myAge : " << &myAge << "\n";
	std::cout << "yourAge : " << yourAge << " &yourAge : " << &yourAge << "\n";
	std::cout << "pAge : " << pAge << " *pAge : " << *pAge << " &pAge : " << &pAge << "\n";

	return 0;
}