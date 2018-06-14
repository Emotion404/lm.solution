#pragma once

#include "Shape.h"


class CLine:public CShape
{
DECLARE_SERIAL(CLine)

public:
	CLine();
	CLine(CPoint ptStart,CPoint ptEnd);
	void Draw(CDC* pDC);

	~CLine(void);
};
