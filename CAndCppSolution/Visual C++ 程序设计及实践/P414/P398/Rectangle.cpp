#include "stdafx.h"
#include "Rectangle.h"
#include <iostream>

using namespace std;

IMPLEMENT_SERIAL(CRectangle,CShape,1)

CRectangle::CRectangle()
{

}

CRectangle::CRectangle(CPoint ptStart,CPoint ptEnd)
:CShape(ptStart,ptEnd)
{
}

void CRectangle::Draw(CDC* pDC)
{
	pDC->Rectangle(m_ptStart.x,m_ptStart.y,m_ptEnd.x,m_ptEnd.y);
}

CRectangle::~CRectangle(void)
{
}
