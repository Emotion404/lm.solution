
// P398Doc.cpp : CP398Doc ���ʵ��
//

#include "stdafx.h"
#include "P414.h"

#include "P414Doc.h"

#ifdef _DEBUG
#define new DEBUG_NEW
#endif


// CP398Doc

IMPLEMENT_DYNCREATE(CP414Doc, CDocument)

BEGIN_MESSAGE_MAP(CP414Doc, CDocument)
END_MESSAGE_MAP()


// CP398Doc ����/����

CP414Doc::CP414Doc()
{
	// TODO: �ڴ����һ���Թ������

}

CP414Doc::~CP414Doc()
{
}

BOOL CP414Doc::OnNewDocument()
{
	if (!CDocument::OnNewDocument())
		return FALSE;

	// TODO: �ڴ�������³�ʼ������
	// (SDI �ĵ������ø��ĵ�)

	return TRUE;
}




// CP398Doc ���л�

void CP414Doc::Serialize(CArchive& ar)
{
	if (ar.IsStoring())
	{
		// TODO: �ڴ���Ӵ洢����
	}
	else
	{
		// TODO: �ڴ���Ӽ��ش���
	}
}


// CP398Doc ���

#ifdef _DEBUG
void CP414Doc::AssertValid() const
{
	CDocument::AssertValid();
}

void CP414Doc::Dump(CDumpContext& dc) const
{
	CDocument::Dump(dc);
}
#endif //_DEBUG


// CP398Doc ����
