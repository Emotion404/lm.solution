
// P398Doc.cpp : CP398Doc 类的实现
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


// CP398Doc 构造/析构

CP410Doc::CP410Doc()
{
	// TODO: 在此添加一次性构造代码

}

CP410Doc::~CP410Doc()
{
}

BOOL CP410Doc::OnNewDocument()
{
	if (!CDocument::OnNewDocument())
		return FALSE;

	// TODO: 在此添加重新初始化代码
	// (SDI 文档将重用该文档)

	return TRUE;
}




// CP398Doc 序列化

void CP410Doc::Serialize(CArchive& ar)
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


// CP398Doc 诊断

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


// CP398Doc 命令
