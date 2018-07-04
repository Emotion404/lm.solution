#include <afxwin.h>  // 包含 MFC 头文件
#include "CMyWnd.h"

class CMyApp:public CWinApp  // 从 MFC 的应用程序派生用户程序类
{
public:
	virtual BOOL InitInstance();
};