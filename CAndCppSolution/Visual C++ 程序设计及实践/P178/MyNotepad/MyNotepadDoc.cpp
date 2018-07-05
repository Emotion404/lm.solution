
// MyNotepadDoc.cpp : CMyNotepadDoc 类的实现
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


// CMyNotepadDoc 构造/析构

CMyNotepadDoc::CMyNotepadDoc()
{
	// TODO: 在此添加一次性构造代码

}

CMyNotepadDoc::~CMyNotepadDoc()
{
}

BOOL CMyNotepadDoc::OnNewDocument()
{
	if (!CDocument::OnNewDocument())
		return FALSE;

	// TODO: 在此添加重新初始化代码
	// (SDI 文档将重用该文档)

	return TRUE;
}




// CMyNotepadDoc 序列化

void CMyNotepadDoc::Serialize(CArchive& ar)
{
	if (ar.IsStoring())
	{
		// TODO: 在此添加存储代码
	}
	else
	{
		// TODO: 在此添加加载代码
	}
}


// CMyNotepadDoc 诊断

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


// CMyNotepadDoc 命令
