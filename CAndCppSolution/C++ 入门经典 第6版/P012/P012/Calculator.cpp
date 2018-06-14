#include <iostream>

int add(int x, int y)
{
	std::cout << "Running calculator ..." << std::endl;
	return (x + y);
}

int main()
{
	std::cout << "What is 867 + 5309 ?" << std::endl;
	std::cout << "The sum is " << add(867, 5309) << std::endl;

	std::cout << "What is 777 + 9311 ?" << std::endl;
	std::cout << "The sum is " << add(777, 9311) << std::endl;

	return 0;
}