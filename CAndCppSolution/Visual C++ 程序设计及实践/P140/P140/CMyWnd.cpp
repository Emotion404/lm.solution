#include <afxwin.h>  // 包含 MFC 头文件
#include "CMyWnd.h"

CMyWnd:: CMyWnd(LPCTSTR szTitle)
{
	Create(NULL,szTitle);  // 调用父类的 Create 函数创建窗体
}
