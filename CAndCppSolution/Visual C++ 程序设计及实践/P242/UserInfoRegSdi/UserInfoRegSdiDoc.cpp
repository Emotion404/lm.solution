
// UserInfoRegSdiDoc.cpp : CUserInfoRegSdiDoc 类的实现
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


// CUserInfoRegSdiDoc 构造/析构

CUserInfoRegSdiDoc::CUserInfoRegSdiDoc()
{
	// TODO: 在此添加一次性构造代码

}

CUserInfoRegSdiDoc::~CUserInfoRegSdiDoc()
{
}

BOOL CUserInfoRegSdiDoc::OnNewDocument()
{
	if (!CDocument::OnNewDocument())
		return FALSE;

	// TODO: 在此添加重新初始化代码
	// (SDI 文档将重用该文档)

	return TRUE;
}




// CUserInfoRegSdiDoc 序列化

void CUserInfoRegSdiDoc::Serialize(CArchive& ar)
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


// CUserInfoRegSdiDoc 诊断

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


// CUserInfoRegSdiDoc 命令
