#include "Rectangle.h"
#include <iostream>

using namespace std;

CRectangle::CRectangle(int left,int top,int right,int bottom,int color)
:CShape(left,top,right,bottom,color)
{
}

void CRectangle::Draw(HDC hDC)
{
	HPEN hPen=CreatePen(PS_SOLID,1,m_color);
	HPEN hOldPen =(HPEN)SelectObject(hDC,hPen);
	HBRUSH hBrush=CreateSolidBrush(m_color);
	HBRUSH hOldBrush=(HBRUSH)SelectObject(hDC,hBrush);
	Rectangle(hDC,m_x1,m_y1,m_x2,m_y2);
	SelectObject(hDC,hOldPen);
	DeleteObject(hPen);
	SelectObject(hDC,hOldBrush);
	DeleteObject(hBrush);
}

CRectangle::~CRectangle(void)
{
}
