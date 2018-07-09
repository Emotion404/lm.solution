#include <iostream>

int main()
{
	int myAge;
	int* pAage = nullptr;

	myAge = 5;
	pAage = &myAge;
	std::cout << "myAge : " << myAge << std::endl;
	std::cout << "*pAge : " << *pAage << std::endl;

	std::cout << "*pAge = 7" << std::endl;
	*pAage = 7;
	std::cout << "myAge : " << myAge << std::endl;
	std::cout << "*pAge : " << *pAage << std::endl;

	std::cout << "myAge = 9" << std::endl;
	myAge = 9;
	std::cout << "myAge : " << myAge << std::endl;
	std::cout << "*pAge : " << *pAage << std::endl;

	return 0;
}