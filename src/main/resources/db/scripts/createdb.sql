create table COURSES (
    ID uuid,
    NAME varchar(255),
    primary key (ID)
);

create table STUDENTS (
    ID uuid,
    NAME varchar(255),
    primary key (ID)
);

create table TEACHERS (
    ID uuid,
    NAME varchar(255),
    primary key (ID)
);

create table STUDENT_ENROLLMENTS (
    ID uuid,
    COURSE_ID uuid,
    STUDENT_ID uuid,
    primary key (ID)
);

alter table STUDENT_ENROLLMENTS add constraint FK_STUDENT_ENROLLMENTS_COURSE foreign key (COURSE_ID) references COURSES(ID);
create index IDX_STUDENT_ENROLLMENTS_COURSE on STUDENT_ENROLLMENTS (COURSE_ID);

alter table STUDENT_ENROLLMENTS add constraint FK_STUDENT_ENROLLMENTS_STUDENT foreign key (student_id) references STUDENTS(ID);
create index IDX_STUDENT_ENROLLMENTS_STUDENT on STUDENT_ENROLLMENTS (STUDENT_ID);

create table TEACHER_ENROLLMENTS (
    ID uuid,
    COURSE_ID uuid,
    TEACHER_ID uuid,
    primary key (ID)
);

alter table TEACHER_ENROLLMENTS add constraint FK_STUDENT_ENROLLMENTS_COURSE foreign key (COURSE_ID) references COURSES(ID);
create index IDX_COURSES_TEACHER_COURSE on TEACHER_ENROLLMENTS (COURSE_ID);

alter table TEACHER_ENROLLMENTS add constraint FK_COURSES_STUDENTS_TEACHER foreign key (TEACHER_ID) references TEACHERS(ID);
create index IDX_COURSES_TEACHER_TEACHER on TEACHER_ENROLLMENTS (TEACHER_ID);
