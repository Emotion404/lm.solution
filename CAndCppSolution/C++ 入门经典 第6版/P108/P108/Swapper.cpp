#include <iostream>

int main()
{
	int value1 = 125000;
	int value2 = 1700;
	int* pointer2 = nullptr;

	pointer2 = &value2;
	value1 = *pointer2;
	pointer2 = 0;

	std::cout << "value1 = " << value1 << "\n";

	return 0;
}