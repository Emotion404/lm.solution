
// P398Doc.h : CP398Doc ��Ľӿ�
//


#pragma once


class CP410Doc : public CDocument
{
protected: // �������л�����
	CP410Doc();
	DECLARE_DYNCREATE(CP410Doc)

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
	virtual ~CP410Doc();
#ifdef _DEBUG
	virtual void AssertValid() const;
	virtual void Dump(CDumpContext& dc) const;
#endif

protected:

// ���ɵ���Ϣӳ�亯��
protected:
	DECLARE_MESSAGE_MAP()
};


