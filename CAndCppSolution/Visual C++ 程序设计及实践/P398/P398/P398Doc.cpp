
// P398Doc.cpp : CP398Doc ���ʵ��
//

#include "stdafx.h"
#include "P398.h"

#include "P398Doc.h"

#ifdef _DEBUG
#define new DEBUG_NEW
#endif


// CP398Doc

IMPLEMENT_DYNCREATE(CP398Doc, CDocument)

BEGIN_MESSAGE_MAP(CP398Doc, CDocument)
END_MESSAGE_MAP()


// CP398Doc ����/����

CP398Doc::CP398Doc()
{
	// TODO: �ڴ����һ���Թ������

}

CP398Doc::~CP398Doc()
{
}

BOOL CP398Doc::OnNewDocument()
{
	if (!CDocument::OnNewDocument())
		return FALSE;

	// TODO: �ڴ�������³�ʼ������
	// (SDI �ĵ������ø��ĵ�)

	return TRUE;
}




// CP398Doc ���л�

void CP398Doc::Serialize(CArchive& ar)
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
void CP398Doc::AssertValid() const
{
	CDocument::AssertValid();
}

void CP398Doc::Dump(CDumpContext& dc) const
{
	CDocument::Dump(dc);
}
#endif //_DEBUG


// CP398Doc ����
