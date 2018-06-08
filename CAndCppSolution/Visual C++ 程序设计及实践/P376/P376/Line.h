#pragma once

class CLine
{
public:
	CLine(int x1,int y1,int x2,int y2);
	void Draw();
	void SetPos(int x1,int y1,int x2,int y2);

	~CLine(void);
private:
	int m_x1;
	int m_y1;
	int m_x2;
	int m_y2;
};
