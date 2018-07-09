
// MainFrm.cpp : CMainFrame 类的实现
//

#include "stdafx.h"
#include "MyNotepad.h"

#include "MainFrm.h"

#ifdef _DEBUG
#define new DEBUG_NEW
#endif

// CMainFrame

IMPLEMENT_DYNCREATE(CMainFrame, CFrameWnd)

BEGIN_MESSAGE_MAP(CMainFrame, CFrameWnd)
	ON_WM_CREATE()
	ON_WM_TIMER()
END_MESSAGE_MAP()

static UINT indicators[] =
{
	ID_SEPARATOR,           // 状态行指示器
	ID_INDICATOR_CAPS,  // 显示 Caps Lock 键状态
	ID_INDICATOR_NUM,  // 显示 Num Lock 键状态
	ID_INDICATOR_SCRL,   // 显示 Scroll Lock 键状态
	ID_INDICATOR_CLOCK, // 用于显示时间
};

// CMainFrame 构造/析构

CMainFrame::CMainFrame()
{
	// TODO: 在此添加成员初始化代码


}

CMainFrame::~CMainFrame()
{
}

int CMainFrame::OnCreate(LPCREATESTRUCT lpCreateStruct)
{
	if (CFrameWnd::OnCreate(lpCreateStruct) == -1)
		return -1;

	if (!m_wndToolBar.CreateEx(this, TBSTYLE_FLAT, WS_CHILD | WS_VISIBLE | CBRS_TOP | CBRS_GRIPPER | CBRS_TOOLTIPS | CBRS_FLYBY | CBRS_SIZE_DYNAMIC) ||
		!m_wndToolBar.LoadToolBar(IDR_MAINFRAME))
	{
		TRACE0("未能创建工具栏\n");
		return -1;      // 未能创建
	}

	if (!m_wndStatusBar.Create(this))
	{
		TRACE0("未能创建状态栏\n");
		return -1;      // 未能创建
	}
	m_wndStatusBar.SetIndicators(indicators, sizeof(indicators)/sizeof(UINT));

	// TODO: 如果不需要可停靠工具栏，则删除这三行
	m_wndToolBar.EnableDocking(CBRS_ALIGN_ANY);
	EnableDocking(CBRS_ALIGN_ANY);
	DockControlBar(&m_wndToolBar);

	//
	GetMenu()  // 获得菜单
		->GetSubMenu(0)  // 获得子菜单
		->EnableMenuItem(0,MF_BYPOSITION|MF_DISABLED|MF_GRAYED);
	m_bitmap.LoadBitmap(IDB_BITMAP1);
	GetMenu()
		->GetSubMenu(0)
		->SetMenuItemBitmaps(1,MF_BYPOSITION,&m_bitmap,&m_bitmap);

	SetTimer(1,1000,NULL);  // 创建定时器

	return 0;
}

BOOL CMainFrame::PreCreateWindow(CREATESTRUCT& cs)
{
	if( !CFrameWnd::PreCreateWindow(cs) )
		return FALSE;
	// TODO: 在此处通过修改
	//  CREATESTRUCT cs 来修改窗口类或样式

	return TRUE;
}

// CMainFrame 诊断

#ifdef _DEBUG
void CMainFrame::AssertValid() const
{
	CFrameWnd::AssertValid();
}

void CMainFrame::Dump(CDumpContext& dc) const
{
	CFrameWnd::Dump(dc);
}
#endif //_DEBUG


// CMainFrame 消息处理程序

void CMainFrame::OnTimer(UINT_PTR nIDEvent)
{
	// TODO: 在此添加消息处理程序代码和/或调用默认值

	CTime t;
	t=CTime::GetCurrentTime();  // 获取系统当前时间
	CString s;
	s=t.Format(_T("%H:%M:%S"));  // 格式化字符串
	m_wndStatusBar.SetPaneText(3,s);  // 在事件窗格上显示时间

	CFrameWnd::OnTimer(nIDEvent);
}
