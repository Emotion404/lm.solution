
// UserInfoRegSdiDoc.cpp : CUserInfoRegSdiDoc ���ʵ��
//

#include "stdafx.h"
#include "UserInfoRegSdi.h"

#include "UserInfoRegSdiDoc.h"

#ifdef _DEBUG
#define new DEBUG_NEW
#endif


// CUserInfoRegSdiDoc

IMPLEMENT_DYNCREATE(CUserInfoRegSdiDoc, CDocument)

BEGIN_MESSAGE_MAP(CUserInfoRegSdiDoc, CDocument)
END_MESSAGE_MAP()


// CUserInfoRegSdiDoc ����/����

CUserInfoRegSdiDoc::CUserInfoRegSdiDoc()
{
	// TODO: �ڴ����һ���Թ������

}

CUserInfoRegSdiDoc::~CUserInfoRegSdiDoc()
{
}

BOOL CUserInfoRegSdiDoc::OnNewDocument()
{
	if (!CDocument::OnNewDocument())
		return FALSE;

	// TODO: �ڴ�������³�ʼ������
	// (SDI �ĵ������ø��ĵ�)

	return TRUE;
}




// CUserInfoRegSdiDoc ���л�

void CUserInfoRegSdiDoc::Serialize(CArchive& ar)
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


// CUserInfoRegSdiDoc ���

#ifdef _DEBUG
void CUserInfoRegSdiDoc::AssertValid() const
{
	CDocument::AssertValid();
}

void CUserInfoRegSdiDoc::Dump(CDumpContext& dc) const
{
	CDocument::Dump(dc);
}
#endif //_DEBUG


// CUserInfoRegSdiDoc ����
