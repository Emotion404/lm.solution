// P029.cpp: 定义控制台应用程序的入口点。
//

#include "stdafx.h"
#include <iostream>

using namespace std;

int main()
{
	int x = 12, y = 42, z = 88;

	cout << "Before :" << "x=" << x << "y=" << y << "z=" << z << endl;

	z = x = y + 13;

	cout << "After:" << "x=" << x << "y=" << y << "z=" << z << endl;

    return 0;
}

