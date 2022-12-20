create database if not exists student_data_management ;
use student_data_management;

-- Hiển thị tất cả các thông tin môn học (bảng subject) có credit lớn nhất.
select * from subject where credit = (select max(credit) from subject);

-- Hiển thị các thông tin môn học có điểm thi lớn nhất.
SELECT 
    sub.sub_id, sub.sub_name, sub.credit, sub.status, mark.mark
FROM
    subject sub
        JOIN
    mark mark ON sub.sub_id = mark.sub_id
WHERE
    mark.mark = (SELECT 
            MAX(mark)
        FROM
            mark);

-- Hiển thị các thông tin sinh viên và điểm trung bình của mỗi sinh viên, xếp hạng theo thứ tự điểm giảm dần.
SELECT 
    s.student_id,
    s.student_name,
    s.address,
    s.phone,
    s.status,
    s.class_id,
    AVG(m.mark) AS avg_mark
FROM
    student s
        JOIN
    mark m ON s.student_id = m.student_id
GROUP BY s.student_id , s.student_name , s.address , s.phone , s.status , s.class_id;

