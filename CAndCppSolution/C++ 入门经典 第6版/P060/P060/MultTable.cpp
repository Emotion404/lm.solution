#include <iostream>

int main()
{
	int number;
	std::cout << "Enter a number:";
	std::cin >> number;

	std::cout << "\n First 10 multiples of " << number << "\n";

	for (int counter = 1; counter < 11; counter++)
	{
		std::cout << number * counter << std::endl;
	}

	return 0;
}