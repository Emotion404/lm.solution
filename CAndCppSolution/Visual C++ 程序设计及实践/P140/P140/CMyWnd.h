#include <afxwin.h>  // 包含 MFC 头文件

class CMyWnd:public CFrameWnd  // 从 MFC 的主框架窗体派生用户窗体类
{
public:
	CMyWnd(LPCTSTR szTitle);
};