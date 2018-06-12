#include "stdafx.h"
#include "Shape.h"

CShape::CShape(CPoint ptStart,CPoint ptEnd)
{
	m_ptStart=ptStart;
	m_ptEnd=ptEnd;
}

void CShape::SetPos(CPoint ptStart,CPoint ptEnd)
{
	m_ptStart=ptStart;
	m_ptEnd=ptEnd;
}


CShape::~CShape(void)
{
}
