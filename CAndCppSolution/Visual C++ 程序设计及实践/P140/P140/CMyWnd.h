#include <afxwin.h>  // ���� MFC ͷ�ļ�

class CMyWnd:public CFrameWnd  // �� MFC ������ܴ��������û�������
{
public:
	CMyWnd(LPCTSTR szTitle);

	// �ඨ���е���Ϣӳ���
	DECLARE_MESSAGE_MAP()

	// ��Ϣӳ�亯������
	afx_msg void OnClose();
};