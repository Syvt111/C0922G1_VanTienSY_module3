create database if not exists student_data_management;
        use student_data_management;

        create table class(
        class_id   int         not null auto_increment primary key,
        class_name varchar(60) not null,
        start_date datetime    not null,
        status    bit
        );

        create table student(
        student_id   int         not null auto_increment primary key,
        student_name varchar(30) not null,
        address     varchar(50),
        phone       varchar(20),
        status      bit,
        class_id     int         not null,
        foreign key (class_id) references class (class_id)
        );

        create table subject(
        sub_id   int         not null auto_increment primary key,
        sub_name varchar(30) not null,
        credit  tinyint     not null default 1 check ( credit >= 1 ),
        status  bit                  default 1
        );

        create table mark (
        mark_id int not null auto_increment primary key,
        sub_id int not null,
        student_id int not null,
        mark float default 0 check (mark between 0 and 100),
        exam_times tinyint default 1,
        unique (sub_id , student_id),
        foreign key (sub_id)
        references subject (sub_id),
        foreign key (student_id)
        references student (student_id)
        );

        insert into class
        values (1, 'a1', '2008-12-20', 1);
        insert into class
        values (2, 'a2', '2008-12-22', 1);
        insert into class
        values (3, 'b3', current_date, 0);

        insert into student (student_name, address, phone, status, class_id)
        values ('hung', 'ha noi', '0912113113', 1, 1);
        insert into student (student_name, address, status, class_id)
        values ('hoa', 'hai phong', 1, 1);
        insert into student (student_name, address, phone, status, class_id)
        values ('manh', 'hcm', '0123123123', 0, 2);

        insert into subject
        values (1, 'cf', 5, 1),
        (2, 'c', 6, 1),
        (3, 'hdj', 5, 1),
        (4, 'rdbms', 10, 1);

        insert into mark (sub_id, student_id, mark, exam_times)
        values (1, 1, 8, 1),
        (1, 2, 10, 2),
        (2, 1, 12, 1);

-- Hiển thị tất cả các sinh viên có tên bắt đầu bảng ký tự ‘h’
        select * from student where student_name like 'h%';

-- Hiển thị các thông tin lớp học có thời gian bắt đầu vào tháng 12
        select * from class where start_date like '%12%';

-- Hiển thị tất cả các thông tin môn học có credit trong khoảng từ 3-5
        select * from subject where credit in (3,4,5);

-- Thay đổi mã lớp(ClassID) của sinh viên có tên ‘Hung’ là 2
        set sql_safe_updates = 0 ;
        update student set class_id = '2' where student_name = 'hùng';
        select * from student ;

-- Hiển thị các thông tin: StudentName, SubName, Mark. Dữ liệu sắp xếp theo điểm thi (mark) giảm dần. nếu trùng sắp theo tên tăng dần
        select
        s.student_name, sub.sub_name, mark.mark
        from
        ((mark
        join
        student s
        on s.student_id = mark.student_id)
        join subject sub on mark.sub_id = sub.sub_id)
        order by
        mark.mark desc, s.student_name asc  ;
    