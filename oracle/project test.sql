
SET DEFINE OFF;
set serverout on;

-- 개설 과정 조회
desc tblOpenSubject;
insert into tblOpenCourse values(seqopencourse.nextval, 'test', sysdate, sysdate+10, 3, 5);
select tblOpenCourse_id, count(*) from tblOpenSubject group by tblOpenCourse_id having tblOpenCourse_id = 1;
SELECT COUNT(*) FROM TBLOPENCOURSE;
SELECT
    oc.name AS 개설과정명, 
    oc.startDate || ' ~ ' || oc.endDate AS 개설과정기간, 
    c.name AS 강의실명,
    CASE
        WHEN os.id is not null THEN '등록'
        ELSE '미등록'
    END AS 개설과목등록여부,
    case
        when count(os.id) > 0 then count(cp.id)  / (select count(*) from tblopensubject group by tblOpenCourse_id having tblOpenCourse_id = oc.id )
        else count(cp.id)
    end AS 교육생등록인원,
    (select count(*) from tblopensubject WHERE tblOpenCourse_id = oc.id)
FROM tblOpenCourse oc
    INNER JOIN tblClassroom c
        ON c.id = oc.tblClassroom_id
            LEFT outer join tblopensubject os
                on oc.id = os.tblOpenCourse_id
                LEFT outer JOIN tblCompletion cp
                    ON oc.id = cp.tblOpenCourse_id
                        group by OC.ID, oc.name, oc.startDate, oc.endDate, c.name,
                        CASE
                            WHEN os.id is not null THEN '등록'
                            ELSE '미등록'
                        END;

SELECT
    oc.name AS 개설과정명, 
    oc.startDate || ' ~ ' || oc.endDate AS 개설과정기간, 
    c.name AS 강의실명,
    CASE
        WHEN os.id IS NOT NULL THEN '등록'
        ELSE '미등록'
    END AS 개설과목등록여부,
    CASE
        WHEN (SELECT COUNT(*) 
            FROM tblopensubject 
            WHERE tblOpenCourse_id = oc.id
        ) > 0 THEN COUNT(cp.id) / (SELECT COUNT(*) 
            FROM tblopensubject 
            WHERE tblOpenCourse_id = oc.id
        ) 
        ELSE 0
    END AS 수강생등록인원
FROM tblOpenCourse oc
    INNER JOIN tblClassroom c 
        ON c.id = oc.tblClassroom_id
            LEFT OUTER JOIN tblopensubject os 
                ON oc.id = os.tblOpenCourse_id
            LEFT OUTER JOIN tblCompletion cp 
                ON oc.id = cp.tblOpenCourse_id
                    GROUP BY oc.id, oc.name, oc.startDate, oc.endDate, c.name, 
                        CASE WHEN os.id IS NOT NULL THEN '등록' ELSE '미등록' END;

--– 특정 개설 과정 선택
--- 특정 개설 과정 선택시 개설 과정에 등록된 개설 과목 정보 및 교육생 정보를 출력한다.
--- 개설 과목 정보는 과목명, 과목기간, 교재명, 교사명을 포함한다.
--- 1. 시험 관리
-- 특정 개설 과정을 선택하는 경우 등록된 개설 과목 정보를 출력하고, 
-- 개설 과목 별로 성적 등록 여부, 시험 문제 파일 등록 여부를 확인할 수 있다.

SELECT
    DISTINCT
    os.name AS 개설과목명,
    os.startDate || ' ~ ' || os.endDate AS 과목기간,
    b.name AS 교재명,
    t.name AS 교사명,
    CASE
        WHEN count(*) > 0 THEN '등록'
        ELSE '미등록'
    END AS 성적등록여부,
    CASE
        WHEN a.filename IS NOT NULL THEN '등록'
        ELSE '미등록'
    END AS 시험문제파일등록여부
FROM tblOpenCourse oc
    INNER JOIN tblOpenSubject os
        ON oc.id = os.tblOpenCourse_id
            INNER JOIN tblBook b
                ON b.id = os.tblBook_id
                    INNER JOIN tblTeacher t
                        ON t.id = os.tblTeacher_id
                            INNER JOIN tblAllotment a
                                ON os.id = a.tblOpenSubject_id
                                    INNER JOIN tblCompletion c
                                        ON oc.id = c.tblOpenCourse_id
                                            INNER JOIN tblGrade g
                                                ON os.id = g.tblOpenSubject_id
                                                    WHERE oc.id = <개설과정번호>
                                                        GROUP BY os.name, os.startDate, os.endDate, b.name, t.name, a.filename 
                                                            ORDER BY 과목기간;

SELECT count(*) FROM TBLCOMPLETION where tblcompletion.tblopencourse_id = 2 and tblcompletion.completiondate >= '2023-04-12';
select count(*) from tblGrade where tblopensubject_id = 8;

-- 과목별교재 관리

-- 생성
INSERT INTO tblSubjectTextbook VALUES(seqSubjectTextbook.nextVal, <과목번호>, <교재번호>);

-- 조회
SELECT id AS 과목명, tblSubject_id AS 과목번호, tblBook_id AS 교재번호 FROM tblSubjectTextbook;

-- 수정
UPDATE tblSubjectTextbook SET tblSubject_id = <수정할 과목번호> WHERE id = <수정할 과목별교재번호>;
UPDATE tblSubjectTextbook SET tblBook_id = <수정할 교재번호> WHERE id = <수정할 과목별교재번호>;

-- 삭제
DELETE FROM tblSubjectTextbook WHERE id = <삭제할 과목별교재번호>;

select evaluationdate,count(*) from tblEvaluation group by evaluationdate order by evaluationdate;

-- - 교사 평가 출력 시 과정명, 평가일, 
-- 교육생들의 평가항목 5가지( 난이도, 전달력, 강의 속도, 종합만족도, 추천의사)를 포함한다

- 수강생들의 평가 현황을 과정별, 기간별(년, 월, 일) 조회할 수 있다.
SELECT TEACHERID FROM vwEvaluation;
- 이전 과정과 현재 과정의 평가점수 평균을 비교할 수 있다.

SELECT 
    CASE
        WHEN num = 1 THEN '현재 과정' 
        ELSE '이전 과정'
    END AS 과정,
    courseName AS 과정명,
    evaluationDate AS 평가일,
    difficulty AS 난이도,
    communicationSkills AS 전달력,
    lecturePace AS 강의속도,
    satisfaction AS 종합만족도,
    recommendation AS 추천의사
FROM
    (SELECT * FROM(SELECT rownum AS num, a.* FROM (
        SELECT
            courseName,
            evaluationDate,
            round(avg(difficulty), 2) AS difficulty,
            round(avg(communicationSkills), 2) AS communicationSkills,
            round(avg(lecturePace), 2) AS lecturePace,
            round(avg(satisfaction), 2) AS satisfaction,
            round(avg(recommendation), 2) AS recommendation
        FROM vwEvaluation
            WHERE teacherId = <교사번호>
                GROUP BY courseId, courseName, evaluationDate
                    ORDER BY evaluationDate DESC) a) b
        WHERE num <= 2);         

select * from tblopencourse;
CREATE OR REPLACE VIEW vwEvaluation 
AS;
SELECT 
--    t.id AS teacherId,
--    t.name AS teacherName,
--    oc.id AS courseId,
--    oc.name AS courseName,
--    e.evaluationDate AS evaluationDate,
--    e.difficulty AS difficulty,
--    e.communicationSkills AS communicationSkills,
--    e.lecturePace AS lecturePace,
--    e.satisfaction AS satisfaction,
--    e.recommendation AS recommendation
    oc.id, count(*)
FROM tblEvaluation e
    INNER JOIN tblTeacher t
        ON t.id = e.tblTeacher_id
            INNER JOIN tblStudent s
                ON s.id = e.tblStudent_id
                    INNER JOIN tblCompletion c
                        ON s.id = c.tblStudent_id
                            INNER JOIN tblOpenCourse oc
                                ON oc.id = c.tblOpenCourse_id
                                    group by oc.id
                                        ORDER BY oc.id;
-- 최서준이 과정번호 2를 듣는데 1과정에 있는 교사번호와 연결되어있기떄문에 1과정...
-- 과정명 생성
select * from vwClassroomList;


-- 과정명 생성 수정중ㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇ
CREATE OR REPLACE VIEW vwClassroomList
AS
SELECT 
    c.id AS classroomId,
    c.name AS classroomName,
    c.name AS classroomCapacity,
    oc.id AS openCourseId,
    oc.name AS openCourseName,
    oc.startDate AS startDate,
    oc.endDate AS endDate,
    oc.tblCourse_id AS courseId
FROM tblClassroom c
    INNER JOIN tblOpenCourse oc ON c.id= oc.tblClassroom_id
        ORDER BY c.id;

CREATE OR REPLACE VIEW vwCourseList
AS
SELECT 
    c.id AS courseId,
    c.name AS courseName,
    oc.id AS openCourseId,
    oc.name AS openCourseName,
    oc.startDate AS startDate,
    oc.endDate AS endDate,
    oc.tblClassroom_id AS classroomId
FROM tblCourse c
    INNER JOIN tblOpenCourse oc ON c.id= oc.tblCourse_id
        ORDER BY c.id;

SELECT * FROM vwCourseList;

CREATE OR REPLACE VIEW vwClassroomList
AS
SELECT 
    c.id AS classroomId,
    c.name AS classroomName,
    oc.id AS openCourseId,
    oc.name AS openCourseName,
    oc.startDate AS startDate,
    oc.endDate AS endDate,
    oc.tblCourse_id AS courseId
FROM tblClassroom c
    INNER JOIN tblOpenCourse oc ON c.id= oc.tblClassroom_id
        ORDER BY c.id;

SELECT * FROM vwClassroomList;
rollback;
INSERT INTO tblCourse values(seqcourse.nextVal, 'test코스');
insert into tblopencourse values(seqopencourse.nextval, 'test코스 - 1',sysdate,sysdate + 50, seqcourse.currval, 3); 
CREATE OR REPLACE PROCEDURE procDeleteCourse (
    vid NUMBER
)
is
    vcount NUMBER;
    vname tblCourse.name%type;
BEGIN
    SELECT count(*) INTO vcount FROM vwCourseList WHERE courseId = vid;
    IF vcount = 0 THEN
        SELECT name INTO vname FROM tblCourse WHERE id = vid;
        dbms_output.put_line('개설과정 미존재 > 과정 삭제');
        dbms_output.put_line('''' || vname || ''' 과정이 삭제되었습니다.');
    ELSE 
        SELECT count(*) INTO vcount
            FROM vwCourseList cl INNER JOIN tblOpenSubject os ON cl.openCourseId = os.tblOpenCourse_id
                WHERE courseId = vid; 
        IF vcount > 0 THEN 
            SELECT count(*) INTO vcount
                FROM vwCourseList cl INNER JOIN tblCompletion c ON cl.openCourseId = c.tblOpenCourse_id
                    WHERE courseId = vid; 
            IF vcount <> 0 THEN
                FOR subjectList IN (
                    SELECT os.id FROM vwCourseList cl 
                        INNER JOIN tblOpenSubject os ON cl.openCourseId = os.tblOpenCourse_id
                        WHERE courseId = vid; 
                ) LOOP
                    dbms_output.put_line('프로시저 삭제');
                END LOOP;
                
            END IF;
        ELSE 
            dbms_output.put_line('개설과정이 존재하나 개설 과목이 존재하지 않음 > 개설 과정 삭제 후 과정 삭제');
            dbms_output.put_line('개설과정과 과정을 삭제합니다.');
        END IF;
    END IF;
END;
/
SELECT * FROM tblCourse;
BEGIN
    procDeleteCourse(1);
    procDeleteCourse(2);
    procDeleteCourse(3);
    procDeleteCourse(4);
    procDeleteCourse(5);
    procDeleteCourse(62);
--    procDeleteCourse(1, '졸려');
--    procDeleteCourse(1, 'AWS와 Docker & Kubernetes를 활용한 Java Full-Stack 개발자 양성과정');
--    procDeleteCourse(2, '졸려');
--    procDeleteCourse(2, 'AWS 클라우드와 Elasticsearch를 활용한 Java(자바) Full-Stack 개발자 양성과정');
END;
/
-- ㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇ
-- 취업목록, 수료정보,교육생
select * from vwStudentEmployInfo;
-- 과목명 생성
CREATE OR REPLACE TRIGGER procDeleteSubject (
    pid NUMBER,
    pname VARCHAR
)
IS
    vnum NUMBER;
    vbeforename tblSubject.name%type;
BEGIN
    SELECT count(*) INTO vnum FROM tblSubject WHERE id = pid;
    IF vnum = 1 THEN
        SELECT name INTO vbeforename FROM tblSubject WHERE id = pid;
        IF vbeforename = pname THEN
            dbms_output.put_line('바꿀 과목명이 같습니다.');
        ELSE 
            UPDATE tblSubject SET name = pname WHERE id = pid;
            dbms_output.put_line('''' || vbeforename || ''' 과목명을 ' || '''' || pname || '''로 수정하셨습니다.');
        END IF;
    ELSIF vnum = 0 THEN
        dbms_output.put_line('해당 과목명이 없습니다. 다시 확인해주세요.');
    END IF;
END;
/

SELECT * FROM TBLSUBJECT;
ROLLBACK;
BEGIN
--    procUpdateSubject(1, '졸려');
    procUpdateSubject(1, 'Java');
--    procUpdateSubject(2, '졸려');
    procUpdateSubject(2, 'Oracle');
END;
/

-- 강의실명 생성
CREATE OR REPLACE TRIGGER procDeleteClassroom (
    pid NUMBER,
    pname VARCHAR,
    pcapacity NUMBER
)
IS
    vnum NUMBER;
    vrow tblClassroom%rowtype;
BEGIN
    SELECT count(*) INTO vnum FROM tblClassroom WHERE id = pid;
    IF vnum = 1 THEN
        SELECT * INTO vrow FROM tblClassroom WHERE id = pid;
        IF vrow.name = pname AND vrow.capacity = pcapacity THEN
            dbms_output.put_line('바꿀 강의실명의 내용이 같습니다.');
        ELSE 
            UPDATE tblClassroom SET name = pname, capacity = pcapacity WHERE id = pid;
            dbms_output.put_line('''' || vrow.name || '''(' || vrow.capacity || ') 강의실명을 ' 
                || '''' || pname || '''(' || pcapacity || ')로 수정하셨습니다.');
        END IF;
    ELSIF vnum = 0 THEN
        dbms_output.put_line('해당 강의실명이 없습니다. 다시 확인해주세요.');
    END IF;
END;
/

SELECT * FROM tblClassroom;
ROLLBACK;
BEGIN
--    procUpdateClassroom(1, '졸려' , 20);
    procUpdateClassroom(1, '1', 30);
--    procUpdateClassroom(2, '졸려', 32);
    procUpdateClassroom(2, '2', 30);
END;
/
CREATE OR REPLACE VIEW vwTeacherSubject
AS
SELECT 
    t.id AS teacherId,
    t.name AS teacherName,
    t.ssn AS teacherSSN,
    t.tel AS teacherTel,
    s.id AS subjectId,
    s.name AS subjectName
FROM tblTeacher t
    LEFT OUTER JOIN tblSubjectList sl ON t.id = sl.tblTeacher_id
    INNER JOIN tblSubject s ON s.id = sl.tblSubject_id
        ORDER BY t.id, s.id;
        
-- 교사, 개설과목, 개설과정, 수료정보, 교육생
select * from vwStudentCourseInfo;
select *
from user_procedures where lower(object_name) = 'procOpenCourseInfo' ;​

SELECT classroomid, startdate, enddate  FROM vwClassroomList WHERE endDate >= '2023-8-20' and startdate <= '2023-12-31'
    or startDate <= '2023-08-20' and endDate >= '2023-12-31' or '2023-08-20' <= startDate and endDate <= '2023-12-31';
    
SELECT classroomid, startdate, enddate  FROM vwClassroomList WHERE endDate >= '2023-8-20' or startdate <= '2023-12-31';
SELECT classroomid, startdate, enddate  FROM vwClassroomList WHERE endDate < '2023-8-20' or startdate > '2023-12-31';
-- 특정 개설 과정 선택시 개설 과목 정보 출력 및 개설 과목 신규 등록을 한다. 
개설 과목 정보 입력시 기초 정보 관리로 등록된 과목명과 교재명, 과목기간, 교사명을 입력한다

--- 교재는 미리 등록된 과목별 교재에서 선택적으로 추가한다. 

- 교사 명단은 현재 과목과 강의 가능 과목이 일치하는 교사 명단만 볼 수 있다.
select * from tblopencourse;
과목 선택 > 
CREATE OR REPLACE PROCEDURE procOpenCourseInfo (
    pid NUMBER
)
IS
    vsubjectName tblOpenSubject.name%type;
    vstartDate tblOpenSubject.startDate%type;
    vendDate tblOpenSubject.endDate%type;
    vbookName tblBook.name%type;
    vteacherName tblTeacher.name%type;
    
    vid tblStudent.id%type;
    vname tblStudent.name%type;
    vssn tblStudent.ssn%type;
    vtel tblStudent.tel%type;
    vregDate tblStudent.regDate%type;
    vstate tblCompletion.state%type;
    
    CURSOR vcursor
    IS
    SELECT DISTINCT openSubjectName, openSubjectStartDate, openSubjectEndDate, b.name, teacherName
        FROM vwStudentCourseInfo sci
        INNER JOIN tblBook b ON b.id = sci.bookId
        WHERE openCourseId = pid
        ORDER BY openSubjectStartDate;
        
    CURSOR vcursorStudent
    IS
    SELECT DISTINCT studentName, studentSSN, studentTel, studentRegDate, completionState
        FROM vwStudentCourseInfo 
        WHERE openCourseId = pid
        ORDER BY studentName;
BEGIN
    dbms_output.put_line('╔════════════════════════════════════════════════════════════════════════════════════════════╗');
    dbms_output.put_line('                                           과목 정보');
    dbms_output.put_line(' ════════════════════════════════════════════════════════════════════════════════════════════');
    dbms_output.put_line('   교사명          기간            과목명                      교재명');
    dbms_output.put_line(' ════════════════════════════════════════════════════════════════════════════════════════════');

    OPEN vcursor;
    LOOP 
        FETCH vcursor INTO vsubjectName, vstartDate, vendDate, vbookName, vteacherName;        
        EXIT WHEN vcursor%notfound;
        dbms_output.put_line( '   ' || vteacherName || '   ' || vstartDate || ' ~ ' || vendDate || '   ' ||  rpad(vsubjectName, 10, ' ') || '     ' || vbookName);
    END LOOP;
    CLOSE vcursor;
    dbms_output.put_line('╚════════════════════════════════════════════════════════════════════════════════════════════╝');

    dbms_output.put_line('╔════════════════════════════════════════════════════════════════════════════════════════════╗');
    dbms_output.put_line('                                          교육생 정보');
    dbms_output.put_line(' ════════════════════════════════════════════════════════════════════════════════════════════');
    dbms_output.put_line('      이름        주민번호            전화번호         등록일               수료상태');
    dbms_output.put_line(' ════════════════════════════════════════════════════════════════════════════════════════════');

    OPEN vcursorStudent;
    LOOP
        FETCH vcursorStudent INTO vname, vssn, vtel, vregDate, vstate;        
        EXIT WHEN vcursorStudent%notfound;
        dbms_output.put_line( '    ' || vname ||  '        ' || vssn || '           ' 
            || vtel ||  '      ' || vregDate ||  '               ' || vstate);
    END LOOP;
    CLOSE vcursorStudent;
    dbms_output.put_line('╚════════════════════════════════════════════════════════════════════════════════════════════╝');
END;
/


select * from vwStudentCourseInfo;
--    dbms_output.put_line('╔════════════════════════════════════════════════════════════════════════════════════════════╗');
--    dbms_output.put_line(' ════════════════════════════════════════════════════════════════════════════════════════════');
--    dbms_output.put_line('╚════════════════════════════════════════════════════════════════════════════════════════════╝');

BEGIN
--    procTeacherInfo(1);
--    procCreateOpenCourse('test', '2024-12-20', '2024-12-31', 1, 5 , 26);
    procOpenCourseInfo(13);
END;
/


SELECT 
    DISTINCT
    openCourseName,
    openCourseStartDate,
    openCourseEndDate,
    openSubjectId,
    openSubjectName,
    openSubjectStartDate,
    openSubjectEndDate,
    c.name AS classroomName,
    teacherName,
    b.name AS bookName
FROM vwStudentCourseInfo sci
    INNER JOIN tblClassroom c ON c.id = sci.classroomId
    INNER JOIN tblBook b ON b.id = sci.bookId
    INNER JOIN tblSubject s ON s.id = sci.subjectId
    INNER JOIN tblGrade g ON studentId = g.tblStudent_id AND openSubjectId = g.tblOpenSubject_Id
    WHERE s.id = 1;

SELECT * FROM tblSubject s
    INNER JOIN tblOpenSubject os ON s.id=os.tblSubject_id
    ORDER BY os.id;

--SELECT 
--    count(*)
--FROM
--(
select distinct attendancestate from vwstudentAttendDetail;

CREATE OR REPLACE FUNCTION fnReturnAttendScore (
    state VARCHAR2
) RETURN  NUMBER
IS
BEGIN
    RETURN CASE(state)
        WHEN '정상' THEN 3
        WHEN '지각' THEN 1
        WHEN '조퇴' THEN 1
        WHEN '결석' THEN 0
        WHEN '지각/조퇴' THEN 2
        WHEN '병가' THEN 3
    END;
END;
/
-- 수강생 + 수료정보 + 취업목록
select * from vwStudentEmployInfo;
EXEC procCourseAllot (1);
CREATE OR REPLACE PROCEDURE procSubjectGrade (
    pid NUMBER
)
IS
BEGIN
    FOR tbl IN (
        SELECT
            DISTINCT
            os.id,
            os.startDate
        FROM tblSubject s
            INNER JOIN tblOpenSubject os ON s.id = os.tblSubject_id
            INNER JOIN tblGrade g ON os.id = g.tblOpenSubject_id
            WHERE s.id = pid
            ORDER BY os.startDate
    ) LOOP
        procOpenSubjectGrade(tbl.id);
    END LOOP;
END;
/

    SELECT
        os.name AS subjectName,
        os.startDate AS subjectStartDate,
        os.endDate AS subjectEndDate,
        t.name AS teacherName,
        round((SELECT
            sum(fnReturnAttendScore(attendanceState))
            FROM vwstudentAttendDetail
            WHERE studentId = 78 AND attendanceDate BETWEEN os.startDate AND os.endDate)
        / ((SELECT count(*) FROM tblAttendance
            WHERE tblStudent_id = 78 AND attendanceDate BETWEEN os.startDate AND os.endDate) * 3) * a.attendance) AS attend,
        g.write AS write,
        g.practice AS practice
    FROM tblStudent s
        INNER JOIN tblGrade g ON s.id = g.tblStudent_id
        INNER JOIN tblOpenSubject os ON os.id = g.tblOpenSubject_id
        INNER JOIN tblCompletion c ON s.id = c.tblStudent_id 
        INNER JOIN tblAllotment a ON os.id = a.tblOpenSubject_id
        INNER JOIN tblTeacher t ON t.id = os.tblTeacher_id
        Where s.id = 78 AND os.tblOpenCourse_id = 3
        AND (c.state <> '중도탈락' OR (c.state = '중도탈락' AND c.completionDate > a.examDate))
        ORDER BY subjectStartDate;
exec procCourseAllot(1);
CREATE OR REPLACE PROCEDURE procCourseAllot (
    pid NUMBER
)
IS
    vcount NUMBER;
    vname tblSubject.name%type;
    vrow tblBook%rowtype;
    
    CURSOR vcursor
    IS
    SELECT
        b.id,
        b.name,
        b.author,
        b.publish,
        b.issueDate
    FROM tblSubject s
        INNER JOIN tblSubjectTextbook st ON s.id = st.tblSubject_id
        INNER JOIN tblBook b ON b.id = st.tblBook_id
        WHERE s.id = pid
        ORDER BY b.name;
BEGIN
    SELECT count(*) INTO vcount FROM tblOpenCourse oc
        INNER JOIN tblOpenSubject os ON oc.id = os.tblOpenCourse_id
        WHERE s.id = pid;

    IF vcount = 0 THEN
        dbms_output.put_line('해당 개설과정에 개설과목이 존재하지 않습니다.');
    ELSE 
        SELECT name INTO vname FROM tblSubject WHERE id = pid;
        dbms_output.put_line('╔══════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╗');
        dbms_output.put_line(' ' || vname);
        dbms_output.put_line(' ══════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════');
        dbms_output.put_line('             개설과목명            개설과목기간      배점 입력 여부                     교재명');
        dbms_output.put_line(' ══════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════');
        OPEN vcursor;
        LOOP 
            FETCH vcursor INTO vrow;        
            EXIT WHEN vcursor%notfound;
            dbms_output.put_line( '  ' || rpad(vrow.name, 50, ' ') || '     '
                || '   ' || rpad(vrow.author, 20, ' ') || '   ' || rpad(vrow.publish, 25, ' ')
                || '  ' || to_char(vrow.issueDate, 'yyyy-mm-dd'));
        END LOOP;
        CLOSE vcursor;
        dbms_output.put_line('╚══════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╝');
    END IF;
END;
/
commit;
-- 성적 
select * from vwstudentAttendDetail ;

BEGIN
--    procSubjectGrade(1);
--    procDateAttendance('2023-03-03');
--    procSubjectGrade(1);
--        procStudentGrade(1); 
    procBookList(6);
    procBookList(10);
    procBookList(20);
--    procStudentGradeInfo(1, 1);
--    procStudentGradeInfo(71, 3);
END;
/
select * from tblBook;

CREATE OR REPLACE PROCEDURE procTeacherGrade (
    pid NUMBER
)
IS
    vcourseId tblOpenCourse.id%type;
    vcourseName tblOpenCourse.name%type;
    vcourseStartDate tblOpenCourse.startDate%type;
    vcourseEndDate tblOpenCourse.endDate%type;
    
    vsubjectId tblOpenSubject.id%type;
    
    vsubjectName tblOpenSubject.name%type;
    vstartDate tblOpenSubject.startDate%type;
    vendDate tblOpenSubject.endDate%type;
    vattend tblAllotment.attendance%type;
    vwrite tblAllotment.write%type;
    vpractice tblAllotment.practice%type;
    vstate VARCHAR2(20);
    vbookName tblBook.name%type;
    
    CURSOR vcursor
    IS
    SELECT
        DISTINCT
        oc.id,
        oc.name,
        oc.startDate,
        oc.endDate
    FROM tblOpenSubject os
        INNER JOIN tblAllotment a ON os.id = a.tblOpenSubject_id
        INNER JOIN tblOpenCourse oc ON oc.id = os.tblOpenCourse_id
        WHERE os.tblTeacher_id = pid AND a.examDate < sysdate
        ORDER BY oc.startDate;
        
    CURSOR vcursorSubjectId
    IS
    SELECT
        DISTINCT
        os.id
    FROM tblOpenSubject os
        INNER JOIN tblAllotment a ON os.id = a.tblOpenSubject_id
        INNER JOIN tblOpenCourse oc ON oc.id = os.tblOpenCourse_id
        WHERE oc.id = vcourseId AND a.examDate < sysdate;
    
    CURSOR vcursorSubject
    IS
    SELECT
        os.name,
        os.startDate,
        os.endDate,
        a.attendance,
        a.write,
        a.practice,
        CASE
            WHEN (SELECT count(*) FROM tblGrade WHERE tblOpenSubject_id = os.id) > 0 THEN '등록'
            ELSE '미등록'
        END,
        b.name
    FROM tblOpenSubject os
        INNER JOIN tblAllotment a ON os.id = a.tblOpenSubject_id
        INNER JOIN tblBook b ON b.id = os.tblBook_id
        WHERE os.id = vsubjectId;
BEGIN
    OPEN vcursor;
    LOOP
        FETCH vcursor INTO vcourseId, vcourseName, vcourseStartDate, vcourseEndDate;
        EXIT WHEN vcursor%notfound;

        dbms_output.put_line('╔═══════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╗');
        dbms_output.put_line(' ' || vcourseName || '(' || to_char(vcourseStartDate, 'yyyy-mm-dd') || ' ~ ' 
            ||  to_char(vcourseEndDate, 'yyyy-mm-dd') || ')');
        dbms_output.put_line(' ═══════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════');
        dbms_output.put_line('       개설과목명             개설과목기간        배점(출결/필기/실기)    성적등록여부                   교재명');
        dbms_output.put_line(' ═══════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════');
        
        OPEN vcursorSubjectId;
        LOOP
            FETCH vcursorSubjectId INTO vsubjectId;  
            EXIT WHEN vcursorSubjectId%notfound;
            OPEN vcursorSubject;
            FETCH vcursorSubject INTO vsubjectName, vstartDate, vendDate, vattend, vwrite, vpractice, vstate, vbookName;  
            dbms_output.put_line( ' ' || rpad(vsubjectName, 20, ' ') || '    ' ||  to_char(vstartDate, 'yyyy-mm-dd') || ' ~ ' 
            ||  to_char(vendDate, 'yyyy-mm-dd') || '        ' || vattend || ' / ' 
            || vwrite || ' / ' || vpractice || '            ' || vstate || '          ' || rpad(vbookName, 40, ' '));
            CLOSE vcursorSubject;
        END LOOP;
        CLOSE vcursorSubjectId;
        dbms_output.put_line('╚═══════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╝');
    END LOOP;
    CLOSE vcursor;
END;
/
select * from vwstudentAttendDetail;
CREATE OR REPLACE PROCEDURE procTeacherGradeInfo (
    pid NUMBER
)
IS
    vstudentName tblStudent.name%type;
    vstudentTel tblStudent.tel%type;
    vattend NUMBER;
    vwrite tblAllotment.write%type;
    vpractice tblAllotment.practice%type;
    vstate tblCompletion.state%type;
    completionDate tblCompletion.completionDate%type;
    
    CURSOR vcursor
    IS
    SELECT
        DISTINCT
        s.name,
        s.tel,
        CASE
            WHEN g.id IS NULL THEN 0
            ELSE 
                round((SELECT
                    sum(fnReturnAttendScore(attendanceState))
                    FROM vwstudentAttendDetail
                    WHERE studentId = s.id AND attendanceDate BETWEEN os.startDate AND os.endDate)
                / ((SELECT count(*) FROM tblAttendance
                    WHERE tblStudent_id = s.id AND attendanceDate BETWEEN os.startDate AND os.endDate)
                    * (SELECT attendance FROM tblAllotment WHERE os.id = tblOpenSubject_id) * 3))
        END,
        CASE
            WHEN g.id IS NULL THEN 0
            ELSE g.write
        END,
        CASE
            WHEN g.id IS NULL THEN 0
            ELSE g.practice
        END,
        c.state,
        c.completionDate
--    FROM tblOpenSubject os
--        INNER JOIN tblGrade g ON os.id = g.tblOpenSubject_id 
--        INNER JOIN tblStudent s ON s.id = g.tblStudent_id
--        INNER JOIN tblCompletion c ON s.id = c.tblStudent_id
    FROM tblCompletion c
        INNER JOIN tblStudent s ON s.id = c.tblStudent_id
        INNER JOIN tblOpenCourse oc ON oc.id = c.tblOpenCourse_id
        INNER JOIN tblOpenSubject os ON oc.id = os.tblOpenCourse_id
        LEFT OUTER JOIN (SELECT * FROM tblGrade WHERE os.id = tblOpenSubject_id) g ON s.id = g.tblStudent_id
        WHERE os.id = pid
        ORDER BY s.name;
        
BEGIN
    dbms_output.put_line('╔════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╗');
    dbms_output.put_line('          이름              전화번호               출결     필기     실기            수료상태              비고');
    dbms_output.put_line(' ════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════');
        
    OPEN vcursor;
    LOOP
        FETCH vcursor INTO vstudentName, vstudentTel, vattend, vwrite, vpractice, vstate, completionDate;
        EXIT WHEN vcursor%notfound;
        IF vstate = '중도탈락' THEN
            dbms_output.put_line( '         ' || vstudentName || '           ' || vstudentTel || '             ' 
            || lpad(vattend, 2, ' ') || '        ' || lpad(vwrite, 2, ' ') || '       ' || lpad(vpractice, 2, ' ') 
            || '               ' || vstate || '             ' 
            || to_char(completionDate, 'yyyy-mm-dd'));
        ELSE
            dbms_output.put_line( '         ' || vstudentName || '           ' || vstudentTel || '             ' 
            || lpad(vattend, 2, ' ') || '        ' || lpad(vwrite, 2, ' ') || '       ' || lpad(vpractice, 2, ' ') 
            || '               ' || vstate);
        END IF;
    END LOOP;
    CLOSE vcursor;
    
    dbms_output.put_line('╚════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╝');
END;
/

--EXEC procStudentGradeInfo(1, 1);
EXEC procTeacherGradeInfo(1);
EXEC procTeacherGradeInfo(14);

SELECT
        DISTINCT
        s.name,
        s.tel,
--        CASE
--            WHEN g.id IS NULL THEN 0
--            ELSE round((SELECT
--                    sum(fnReturnAttendScore(attendanceState))
--                    FROM vwstudentAttendDetail
--                    WHERE studentId = s.id AND attendanceDate BETWEEN os.startDate AND os.endDate)
--                / ((SELECT count(*) FROM tblAttendance
--                    WHERE tblStudent_id = s.id AND attendanceDate BETWEEN os.startDate AND os.endDate)
--                    * (SELECT attendance FROM tblAllotment WHERE os.id = tblOpenSubject_id) * 3))
--        END,
        c.state,
        c.completionDate,
        os.name
    FROM tblCompletion c
        INNER JOIN tblStudent s ON s.id = c.tblStudent_id
        INNER JOIN tblOpenCourse oc ON oc.id = c.tblOpenCourse_id
        INNER JOIN tblOpenSubject os ON oc.id = os.tblOpenCourse_id
        LEFT OUTER JOIN tblGrade g ON s.id = g.tblStudent_id
        WHERE os.id = 1
        ORDER BY s.name;
        
exec procStudentGradeInfo(284, 13);
--exec procStudentGradeInfo(302, 13);
exec procStudentGradeInfo(289, 13);