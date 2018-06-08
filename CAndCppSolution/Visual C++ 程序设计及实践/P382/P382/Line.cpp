#include "Line.h"

#include <iostream>

using namespace std;


CLine::CLine(int x1,int y1,int x2,int y2)
:CShape(x1,y1,x2,y2)
{
}

void CLine::Draw()
{
	cout<<"»æÖÆÖ±Ïß"<<endl;
}

CLine::~CLine(void)
{
}
