// P120.cpp : 定义控制台应用程序的入口点。
//

#include "stdafx.h"

#include <tchar.h>
#include <Windows.h>


int _tmain(int argc, _TCHAR* argv[])
{
	TCHAR sCity[]=_T("hello");
	MessageBox(0,sCity,_T("测试"),MB_OK);

	return 0;
}

