#include "SimpleCat.h"
#include <iostream>

int main()
{
	std::cout << "Simplecat Frisky ..." << "\n";
	SimpleCat frisky;

	std::cout << "Simplecat* pRags ..." << "\n";
	SimpleCat* pRags = new SimpleCat;

	std::cout << "delete pRags ..." << "\n";
	delete pRags;

	std::cout << "exit ..."<<"\n";

	return 0;

}