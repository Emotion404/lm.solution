
// P168Doc.cpp : CP168Doc ���ʵ��
//

#include "stdafx.h"
#include "P168.h"

#include "P168Doc.h"

#ifdef _DEBUG
#define new DEBUG_NEW
#endif


// CP168Doc

IMPLEMENT_DYNCREATE(CP168Doc, CDocument)

BEGIN_MESSAGE_MAP(CP168Doc, CDocument)
END_MESSAGE_MAP()


// CP168Doc ����/����

CP168Doc::CP168Doc()
{
	// TODO: �ڴ����һ���Թ������

}

CP168Doc::~CP168Doc()
{
}

BOOL CP168Doc::OnNewDocument()
{
	if (!CDocument::OnNewDocument())
		return FALSE;

	// TODO: �ڴ�������³�ʼ������
	// (SDI �ĵ������ø��ĵ�)

	return TRUE;
}




// CP168Doc ���л�

void CP168Doc::Serialize(CArchive& ar)
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


// CP168Doc ���

#ifdef _DEBUG
void CP168Doc::AssertValid() const
{
	CDocument::AssertValid();
}

void CP168Doc::Dump(CDumpContext& dc) const
{
	CDocument::Dump(dc);
}
#endif //_DEBUG


// CP168Doc ����
