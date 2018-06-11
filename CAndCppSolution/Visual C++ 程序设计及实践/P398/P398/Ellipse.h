#pragma once

#include "Shape.h"

class CEllipse:public CShape
{
public:
	CEllipse(CPoint ptStart,CPoint ptEnd);
	void Draw(CDC* pDC);

	~CEllipse(void);
};
