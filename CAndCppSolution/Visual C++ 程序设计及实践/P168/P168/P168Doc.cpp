
// P168Doc.cpp : CP168Doc 类的实现
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


// CP168Doc 构造/析构

CP168Doc::CP168Doc()
{
	// TODO: 在此添加一次性构造代码

}

CP168Doc::~CP168Doc()
{
}

BOOL CP168Doc::OnNewDocument()
{
	if (!CDocument::OnNewDocument())
		return FALSE;

	// TODO: 在此添加重新初始化代码
	// (SDI 文档将重用该文档)

	return TRUE;
}




// CP168Doc 序列化

void CP168Doc::Serialize(CArchive& ar)
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


// CP168Doc 诊断

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


// CP168Doc 命令
