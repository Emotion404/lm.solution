
// P398Doc.h : CP398Doc ��Ľӿ�
//


#pragma once


class CP414Doc : public CDocument
{
protected: // �������л�����
	CP414Doc();
	DECLARE_DYNCREATE(CP414Doc)

// ����
public:

// ����
public:

// ��д
public:
	
	CObList m_obList;

	virtual BOOL OnNewDocument();
	virtual void Serialize(CArchive& ar);

// ʵ��
public:
	virtual ~CP414Doc();
#ifdef _DEBUG
	virtual void AssertValid() const;
	virtual void Dump(CDumpContext& dc) const;
#endif

protected:

// ���ɵ���Ϣӳ�亯��
protected:
	DECLARE_MESSAGE_MAP()
};


