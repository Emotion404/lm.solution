#include "SimpleCat.h"
#include <iostream>

SimpleCat::SimpleCat()
{
	std::cout << "Constructor called " << "\n";
	itsAge = 1;
}

SimpleCat::~SimpleCat()
{
	std::cout << "Destructor called " << "\n";
}