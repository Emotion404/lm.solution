
// UserInfoRegSdiDoc.h : CUserInfoRegSdiDoc ��Ľӿ�
//


#pragma once


class CUserInfoRegSdiDoc : public CDocument
{
protected: // �������л�����
	CUserInfoRegSdiDoc();
	DECLARE_DYNCREATE(CUserInfoRegSdiDoc)

// ����
public:

// ����
public:

// ��д
public:
	virtual BOOL OnNewDocument();
	virtual void Serialize(CArchive& ar);

// ʵ��
public:
	virtual ~CUserInfoRegSdiDoc();
#ifdef _DEBUG
	virtual void AssertValid() const;
	virtual void Dump(CDumpContext& dc) const;
#endif

protected:

// ���ɵ���Ϣӳ�亯��
protected:
	DECLARE_MESSAGE_MAP()
};


