
// MyNotepadDoc.h : CMyNotepadDoc ��Ľӿ�
//


#pragma once


class CMyNotepadDoc : public CDocument
{
protected: // �������л�����
	CMyNotepadDoc();
	DECLARE_DYNCREATE(CMyNotepadDoc)

// ����
public:
	CString m_strText;  // ������������ַ�
	CPoint m_ptCaretPos;  // ��¼�������λ��

// ����
public:

// ��д
public:
	virtual BOOL OnNewDocument();
	virtual void Serialize(CArchive& ar);

// ʵ��
public:
	virtual ~CMyNotepadDoc();
#ifdef _DEBUG
	virtual void AssertValid() const;
	virtual void Dump(CDumpContext& dc) const;
#endif

protected:

// ���ɵ���Ϣӳ�亯��
protected:
	DECLARE_MESSAGE_MAP()
};


