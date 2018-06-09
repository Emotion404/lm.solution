#pragma once

#include <Windows.h>

class CShape
{
public:
	CShape(int x1,int y1,int x2,int y2,int color);
	virtual void Draw(HDC hDC)=0;
	void SetPos(int x1,int y1,int x2,int y2,int color);

	~CShape(void);
protected:
	int m_x1;
	int m_y1;

	int m_x2;
	int m_y2;

	int m_color;
};
