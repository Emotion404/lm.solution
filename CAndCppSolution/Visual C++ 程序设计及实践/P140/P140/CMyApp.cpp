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

	// 连接字符串
	CString str1(_T("美丽的"));
	CString str2(_T("海滨城市"));
	CString str3=str1+str2;
	str3=str3+_T("青岛");
	AfxMessageBox(str3);

	// 查找字符串
	nRet=str3.Find(str2);
	if(nRet>=0)
	{
		AfxMessageBox(_T("找到字符串"));
	}
	else
	{
		AfxMessageBox(_T("没有匹配的字符串"));
	}

	// 提取字符串
	CString str4=str1.Left(2)+str3.Mid(3,2)+str2.Right(2);
	AfxMessageBox(_T("提取的字符串为:" )+str4);

	return TRUE;
}
