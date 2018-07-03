#include <afxwin.h>  // 包含 MFC 头文件

class CMyWnd:public CFrameWnd  // 从 MFC 的主框架窗体派生用户窗体类
{
public:
	CMyWnd(LPCTSTR szTitle)
	{
		Create(NULL,szTitle);  // 调用父类的 Create 函数创建窗体
	}
};

class CMyApp:public CWinApp  // 从 MFC 的应用程序派生用户程序类
{
public:
	virtual BOOL InitInstance();
};
BOOL CMyApp:: InitInstance()  // 覆盖继承的应用程序初始化虚函数
{
	// 创建窗体并保存到 m_pMainWnd 中
	m_pMainWnd=new CMyWnd(_T("一个简单的 MFC 程序"));
	m_pMainWnd->ShowWindow(m_nCmdShow);

	return TRUE;
}

CMyApp myApp; // 定义用户程序全局对象
