#include <afxwin.h>  // 包含 MFC 头文件
#include "CMyWnd.h"

CMyWnd:: CMyWnd(LPCTSTR szTitle)
{
	Create(NULL,szTitle);  // 调用父类的 Create 函数创建窗体
}

void CMyWnd::OnClose()
{
	AfxMessageBox(_T("正在关闭窗口"));
	// 此处添加 消息处理程序代码或调用默认值 
	CFrameWnd::OnClose();
}
