#include <iostream>
#include <string.h>

int main()
{
	char str1[] = "Free the bound periodicals!";
	char str2[80];

	strcpy_s(str2, str1);

	std::cout << "str1 : " << str1 << std::endl;
	std::cout << "str2 : " << str2 << std::endl;

	return 0;
}