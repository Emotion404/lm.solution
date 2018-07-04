#include <afxwin.h>  // 包含 MFC 头文件
#include "CMyApp.h"

BOOL CMyApp:: InitInstance()  // 覆盖继承的应用程序初始化虚函数
{
	// 创建窗体并保存到 m_pMainWnd 中
	m_pMainWnd=new CMyWnd(_T("一个简单的 MFC 程序"));
	m_pMainWnd->ShowWindow(m_nCmdShow);

	// 测试 AfxMessageBox() 函数的用法
	int nRet = AfxMessageBox(_T("测试"),MB_ABORTRETRYIGNORE );
	if(nRet==IDABORT)
	{
		AfxMessageBox(_T("用户单击了'终止'按钮"),MB_OK|MB_ICONINFORMATION);
	}
	else if(nRet==IDRETRY)
	{
		AfxMessageBox(_T("用户单击了'重试'按钮"),MB_OK|MB_ICONINFORMATION		  );
	}
	else if(nRet==IDIGNORE)
	{
		AfxMessageBox(_T("用户单击了'忽略'按钮"),MB_OK|MB_ICONINFORMATION		  );
	}

	// 

	return TRUE;
}
