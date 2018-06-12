#include "stdafx.h"
#include "Line.h"

#include <iostream>

using namespace std;


CLine::CLine(CPoint ptStart,CPoint ptEnd)
:CShape(ptStart,ptEnd)
{
}

void CLine::Draw(CDC* pDC)
{
	pDC->MoveTo(m_ptStart);
	pDC->LineTo(m_ptEnd);
}

CLine::~CLine(void)
{
}
