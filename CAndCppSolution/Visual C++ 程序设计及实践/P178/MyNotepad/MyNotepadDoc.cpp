
// MyNotepadDoc.cpp : CMyNotepadDoc ���ʵ��
//

#include "stdafx.h"
#include "MyNotepad.h"

#include "MyNotepadDoc.h"

#ifdef _DEBUG
#define new DEBUG_NEW
#endif


// CMyNotepadDoc

IMPLEMENT_DYNCREATE(CMyNotepadDoc, CDocument)

BEGIN_MESSAGE_MAP(CMyNotepadDoc, CDocument)
END_MESSAGE_MAP()


// CMyNotepadDoc ����/����

CMyNotepadDoc::CMyNotepadDoc()
{
	// TODO: �ڴ����һ���Թ������

}

CMyNotepadDoc::~CMyNotepadDoc()
{
}

BOOL CMyNotepadDoc::OnNewDocument()
{
	if (!CDocument::OnNewDocument())
		return FALSE;

	// TODO: �ڴ�������³�ʼ������
	// (SDI �ĵ������ø��ĵ�)

	return TRUE;
}




// CMyNotepadDoc ���л�

void CMyNotepadDoc::Serialize(CArchive& ar)
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


// CMyNotepadDoc ���

#ifdef _DEBUG
void CMyNotepadDoc::AssertValid() const
{
	CDocument::AssertValid();
}

void CMyNotepadDoc::Dump(CDumpContext& dc) const
{
	CDocument::Dump(dc);
}
#endif //_DEBUG


// CMyNotepadDoc ����
