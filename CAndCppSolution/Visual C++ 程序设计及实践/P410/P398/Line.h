#pragma once

#include "Shape.h"


class CLine:public CShape
{
public:
	CLine(CPoint ptStart,CPoint ptEnd);
	void Draw(CDC* pDC);

	~CLine(void);
};
