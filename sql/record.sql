use examination_system;
go

/*
	׼��������������
*/

-- �ر����б���������Լ��
alter table college NOCHECK constraint all;
alter table course NOCHECK constraint all;
alter table [role] NOCHECK constraint all;
alter table student NOCHECK constraint all;
alter table teacher NOCHECK constraint all;
alter table userlogin NOCHECK constraint all;
alter table selectedcourse NOCHECK constraint all;

-- record of college
INSERT INTO college VALUES ('1', '�����ϵ');
INSERT INTO college VALUES ('2', '���ϵ');
INSERT INTO college VALUES ('3', '�ƾ�ϵ');

-- record of course
INSERT INTO course VALUES ('1', 'C���Գ������', '1001', '�ܶ�', '��401', '18', '���޿�', '1', '3');
INSERT INTO course VALUES ('2', 'Python���漼��', '1001', '����', 'X402', '18', '���޿�', '1', '3');
INSERT INTO course VALUES ('3', '���ݽṹ', '1001', '����', '��401', '18', '���޿�', '1', '2');
INSERT INTO course VALUES ('4', 'Java�������', '1002', '����', '��401', '18', '���޿�', '1', '2');
INSERT INTO course VALUES ('5', 'Ӣ��', '1002', '����', 'X302', '18', '���޿�', '2', '2');
INSERT INTO course VALUES ('6', '��װ���', '1003', '��һ', '��401', '18', 'ѡ�޿�', '2', '2');

-- record of role
INSERT INTO role VALUES ('0', 'admin', null);
INSERT INTO role VALUES ('1', 'teacher', null);
INSERT INTO role VALUES ('2', 'student', null);

-- record of selectedcourse
INSERT INTO selectedcourse VALUES ('2', '10001', '12');
INSERT INTO selectedcourse VALUES ('1', '10001', '95');
INSERT INTO selectedcourse VALUES ('1', '10002', '66');
INSERT INTO selectedcourse VALUES ('1', '10003', null);
INSERT INTO selectedcourse VALUES ('2', '10003', '99');
INSERT INTO selectedcourse VALUES ('5', '10001', null);
INSERT INTO selectedcourse VALUES ('3', '10001', null);

--record of student
INSERT INTO student VALUES ('10001', 'С��', '��', '1996-09-02', '2015-09-02', '1');
INSERT INTO student VALUES ('10002', 'С��', 'Ů', '1995-09-14', '2015-09-02', '3');
INSERT INTO student VALUES ('10003', 'С��', 'Ů', '1996-09-02', '2015-09-02', '2');
INSERT INTO student VALUES ('10004', 'С��', '��', '1996-09-02', '2015-09-02', '2');
INSERT INTO student VALUES ('10005', 'С��', 'Ů', '1996-09-02', '2015-09-02', '2');
INSERT INTO student VALUES ('10006', 'С��', 'Ů', '1996-09-02', '2015-09-02', '1');

--record of teacher
INSERT INTO teacher VALUES ('1001', '����ʦ', 'Ů', '1990-03-08', '˶ʿ', '������', '2015-09-02', '2');
INSERT INTO teacher VALUES ('1002', '����ʦ', '��', '1996-09-02', '����', '��ͨ��ʦ', '2015-09-02', '1');
INSERT INTO teacher VALUES ('1003', '����ʦ', '��', '1996-09-02', '˶ʿ', '����', '2017-07-07', '1');

--record of userlogin
INSERT INTO userlogin VALUES ('1', 'admin', '123', '0');
INSERT INTO userlogin VALUES ('8', '10001', '123', '2');
INSERT INTO userlogin VALUES ('9', '10002', '123', '2');
INSERT INTO userlogin VALUES ('10', '10003', '123', '2');
INSERT INTO userlogin VALUES ('11', '10005', '123', '2');
INSERT INTO userlogin VALUES ('12', '10004', '123', '2');
INSERT INTO userlogin VALUES ('13', '10006', '123', '2');
INSERT INTO userlogin VALUES ('14', '1001', '123', '1');
INSERT INTO userlogin VALUES ('15', '1002', '123', '1');
INSERT INTO userlogin VALUES ('16', '1003', '123', '1');



alter table college CHECK constraint all;
alter table course CHECK constraint all;
alter table [role] CHECK constraint all;
alter table student CHECK constraint all;
alter table teacher CHECK constraint all;
alter table userlogin CHECK constraint all;
alter table selectedcourse CHECK constraint all;




