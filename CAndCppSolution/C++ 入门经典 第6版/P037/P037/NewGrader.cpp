#include <iostream>

using namespace std;

int main()
{
	int grade;

	cout << "enter a grade 1--100 :";
	cin >> grade;

	if (grade >= 70)
	{
		if (grade >= 90)
		{
			cout << "you got an A.";
			return 0;
		}
		if (grade >= 80)
		{
			cout << "you got a B.";
			return 0;
		}

		cout << "you got a C.";
		return 0;
	}
	else
	{
		cout << "you got an F.";
		return 0;
	}

	return 0;
}