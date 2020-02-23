create table student (
student_id number auto_increment,
student_name varchar2,
student_age integer,
PRIMARY KEY (student_id)
);


create table address (
--id number auto_increment,
address_id number auto_increment,
student_id number,
pincode varchar2,
city varchar2,
state varchar2,
address_type varchar2 not null,
foreign key (student_id) references student(student_id),
PRIMARY KEY (address_id)
);

create table users(
--id number auto_increment,
user_id number auto_increment,
user_name varchar2,
student_id number,
password varchar2 not null,
active_status boolean,
roles varchar2,
foreign key (student_id) references student(student_id),
PRIMARY KEY (user_id)
);