
// P398Doc.cpp : CP398Doc ���ʵ��
//

#include "stdafx.h"
#include "P410.h"

#include "P410Doc.h"

#ifdef _DEBUG
#define new DEBUG_NEW
#endif


// CP398Doc

IMPLEMENT_DYNCREATE(CP410Doc, CDocument)

BEGIN_MESSAGE_MAP(CP410Doc, CDocument)
END_MESSAGE_MAP()


// CP398Doc ����/����

CP410Doc::CP410Doc()
{
	// TODO: �ڴ����һ���Թ������

}

CP410Doc::~CP410Doc()
{
}

BOOL CP410Doc::OnNewDocument()
{
	if (!CDocument::OnNewDocument())
		return FALSE;

	// TODO: �ڴ�������³�ʼ������
	// (SDI �ĵ������ø��ĵ�)

	return TRUE;
}




// CP398Doc ���л�

void CP410Doc::Serialize(CArchive& ar)
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
void CP410Doc::AssertValid() const
{
	CDocument::AssertValid();
}

void CP410Doc::Dump(CDumpContext& dc) const
{
	CDocument::Dump(dc);
}
#endif //_DEBUG


// CP398Doc ����
