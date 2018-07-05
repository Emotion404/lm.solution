
// P168View.cpp : CP168View 类的实现
//

#include "stdafx.h"
#include "P168.h"

#include "P168Doc.h"
#include "P168View.h"

#ifdef _DEBUG
#define new DEBUG_NEW
#endif


// CP168View

IMPLEMENT_DYNCREATE(CP168View, CView)

BEGIN_MESSAGE_MAP(CP168View, CView)
	// 标准打印命令
	ON_COMMAND(ID_FILE_PRINT, &CView::OnFilePrint)
	ON_COMMAND(ID_FILE_PRINT_DIRECT, &CView::OnFilePrint)
	ON_COMMAND(ID_FILE_PRINT_PREVIEW, &CP168View::OnFilePrintPreview)
END_MESSAGE_MAP()

// CP168View 构造/析构

CP168View::CP168View()
{
	// TODO: 在此处添加构造代码

}

CP168View::~CP168View()
{
}

BOOL CP168View::PreCreateWindow(CREATESTRUCT& cs)
{
	// TODO: 在此处通过修改
	//  CREATESTRUCT cs 来修改窗口类或样式

	return CView::PreCreateWindow(cs);
}

// CP168View 绘制

void CP168View::OnDraw(CDC* pDC)
{
	CP168Doc* pDoc = GetDocument();
	ASSERT_VALID(pDoc);
	if (!pDoc)
		return;

	// TODO: 在此处为本机数据添加绘制代码

	// 演示绘图对象的使用
	pDC->Rectangle(90,90,300,200);
	CPen pen1,pen2;  // 构造画笔对象
	pen1.CreatePen(PS_SOLID,2,RGB(128,128,128));  // 创建对象
	pen2.CreatePen(PS_SOLID,2,RGB(128,128,0));
	CPen* pOldPen=pDC->SelectObject(&pen1);  // 选择对象进 DC ,保存最早的旧对象
	pDC->LineTo(100,100);  // 绘图
	pDC->SelectObject(&pen2);
	pDC->Ellipse(200,200,300,300);
	pDC->SelectObject(pOldPen);  // 最后恢复原来的对象

}


// CP168View 打印


void CP168View::OnFilePrintPreview()
{
	AFXPrintPreview(this);
}

BOOL CP168View::OnPreparePrinting(CPrintInfo* pInfo)
{
	// 默认准备
	return DoPreparePrinting(pInfo);
}

void CP168View::OnBeginPrinting(CDC* /*pDC*/, CPrintInfo* /*pInfo*/)
{
	// TODO: 添加额外的打印前进行的初始化过程
}

void CP168View::OnEndPrinting(CDC* /*pDC*/, CPrintInfo* /*pInfo*/)
{
	// TODO: 添加打印后进行的清理过程
}

void CP168View::OnRButtonUp(UINT nFlags, CPoint point)
{
	ClientToScreen(&point);
	OnContextMenu(this, point);
}

void CP168View::OnContextMenu(CWnd* pWnd, CPoint point)
{
	theApp.GetContextMenuManager()->ShowPopupMenu(IDR_POPUP_EDIT, point.x, point.y, this, TRUE);
}


// CP168View 诊断

#ifdef _DEBUG
void CP168View::AssertValid() const
{
	CView::AssertValid();
}

void CP168View::Dump(CDumpContext& dc) const
{
	CView::Dump(dc);
}

CP168Doc* CP168View::GetDocument() const // 非调试版本是内联的
{
	ASSERT(m_pDocument->IsKindOf(RUNTIME_CLASS(CP168Doc)));
	return (CP168Doc*)m_pDocument;
}
#endif //_DEBUG


// CP168View 消息处理程序
