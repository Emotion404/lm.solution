
// UserInfoRegSdiView.cpp : CUserInfoRegSdiView 类的实现
//

#include "stdafx.h"
#include "UserInfoRegSdi.h"

#include "UserInfoRegSdiDoc.h"
#include "UserInfoRegSdiView.h"

#ifdef _DEBUG
#define new DEBUG_NEW
#endif


// CUserInfoRegSdiView

IMPLEMENT_DYNCREATE(CUserInfoRegSdiView, CView)

BEGIN_MESSAGE_MAP(CUserInfoRegSdiView, CView)
	// 标准打印命令
	ON_COMMAND(ID_FILE_PRINT, &CView::OnFilePrint)
	ON_COMMAND(ID_FILE_PRINT_DIRECT, &CView::OnFilePrint)
	ON_COMMAND(ID_FILE_PRINT_PREVIEW, &CView::OnFilePrintPreview)
END_MESSAGE_MAP()

// CUserInfoRegSdiView 构造/析构

CUserInfoRegSdiView::CUserInfoRegSdiView()
{
	// TODO: 在此处添加构造代码

}

CUserInfoRegSdiView::~CUserInfoRegSdiView()
{
}

BOOL CUserInfoRegSdiView::PreCreateWindow(CREATESTRUCT& cs)
{
	// TODO: 在此处通过修改
	//  CREATESTRUCT cs 来修改窗口类或样式

	return CView::PreCreateWindow(cs);
}

// CUserInfoRegSdiView 绘制

void CUserInfoRegSdiView::OnDraw(CDC* /*pDC*/)
{
	CUserInfoRegSdiDoc* pDoc = GetDocument();
	ASSERT_VALID(pDoc);
	if (!pDoc)
		return;

	// TODO: 在此处为本机数据添加绘制代码
}


// CUserInfoRegSdiView 打印

BOOL CUserInfoRegSdiView::OnPreparePrinting(CPrintInfo* pInfo)
{
	// 默认准备
	return DoPreparePrinting(pInfo);
}

void CUserInfoRegSdiView::OnBeginPrinting(CDC* /*pDC*/, CPrintInfo* /*pInfo*/)
{
	// TODO: 添加额外的打印前进行的初始化过程
}

void CUserInfoRegSdiView::OnEndPrinting(CDC* /*pDC*/, CPrintInfo* /*pInfo*/)
{
	// TODO: 添加打印后进行的清理过程
}


// CUserInfoRegSdiView 诊断

#ifdef _DEBUG
void CUserInfoRegSdiView::AssertValid() const
{
	CView::AssertValid();
}

void CUserInfoRegSdiView::Dump(CDumpContext& dc) const
{
	CView::Dump(dc);
}

CUserInfoRegSdiDoc* CUserInfoRegSdiView::GetDocument() const // 非调试版本是内联的
{
	ASSERT(m_pDocument->IsKindOf(RUNTIME_CLASS(CUserInfoRegSdiDoc)));
	return (CUserInfoRegSdiDoc*)m_pDocument;
}
#endif //_DEBUG


// CUserInfoRegSdiView 消息处理程序
