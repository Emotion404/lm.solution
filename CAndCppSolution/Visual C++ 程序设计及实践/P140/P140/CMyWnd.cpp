#include <afxwin.h>  // ���� MFC ͷ�ļ�
#include "CMyWnd.h"

CMyWnd:: CMyWnd(LPCTSTR szTitle)
{
	Create(NULL,szTitle);  // ���ø���� Create ������������
}

void CMyWnd::OnClose()
{
	AfxMessageBox(_T("���ڹرմ���"));
	// �˴���� ��Ϣ��������������Ĭ��ֵ 
	CFrameWnd::OnClose();
}
