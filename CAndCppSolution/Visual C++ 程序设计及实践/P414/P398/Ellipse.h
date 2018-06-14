#pragma once

#include "Shape.h"

class CEllipse:public CShape
{
	DECLARE_SERIAL(CEllipse)

public:
	CEllipse();

	CEllipse(CPoint ptStart,CPoint ptEnd);
	void Draw(CDC* pDC);

	~CEllipse(void);
};
