#include "Line.h"

#include <iostream>

using namespace std;


CLine::CLine(int x1,int y1,int x2,int y2,int color)
:CShape(x1,y1,x2,y2,color)
{
}

void CLine::Draw(HDC hDC)
{
	HPEN hPen = CreatePen(PS_SOLID,1,m_color);
	HPEN hOldPen=(HPEN)SelectObject(hDC,hPen);
	MoveToEx(hDC,m_x1,m_y1,0);
	LineTo(hDC,m_x2,m_y2);
	SelectObject(hDC,hOldPen);
	DeleteObject(hPen);
}

CLine::~CLine(void)
{
}
