
// P168Doc.h : CP168Doc ��Ľӿ�
//


#pragma once


class CP168Doc : public CDocument
{
protected: // �������л�����
	CP168Doc();
	DECLARE_DYNCREATE(CP168Doc)

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
	virtual ~CP168Doc();
#ifdef _DEBUG
	virtual void AssertValid() const;
	virtual void Dump(CDumpContext& dc) const;
#endif

protected:

// ���ɵ���Ϣӳ�亯��
protected:
	DECLARE_MESSAGE_MAP()
};


