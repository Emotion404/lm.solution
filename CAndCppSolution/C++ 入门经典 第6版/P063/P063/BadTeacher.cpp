#include <iostream>

int main()
{
	char grade;
	std::cout << "Enter your letter grade (ABCDF) :";
	std::cin >> grade;

	switch (grade)
	{
	case 'A':
		std::cout << "Finally!" << std::endl;
		break;
	case 'B':
	{
		std::cout << "You can do better!" << std::endl;
	}
	break;
	case 'C':
	{
		std::cout << "I'm disappointed in you!" << std::endl;
	}
		break;
	case 'D':
	{
		std::cout << "You're not smart!" << std::endl;
	}
		break;
	case 'F':
		std::cout << "Get out of my sight!" << std::endl;
		break;
	default:
		std::cout << "That't not even a grade!" << std::endl;
		break;
	}

	return 0;
}