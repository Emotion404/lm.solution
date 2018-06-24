#include <iostream>

using namespace std;

int main()
{
	int grade;

	cout << "Enter a grade (1--100): ";
	cin >> grade;

	if (grade >= 70)
	{
		cout << "you passed." << endl;
	}
	else
	{
		cout << "you failed." << endl;
	}

	return 0;
}