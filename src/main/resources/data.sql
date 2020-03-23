INSERT INTO user(name, email, password) VALUES('Developer', 'developer@gmail.com', '123456');

INSERT INTO course(name, category) VALUES('Spring Boot', 'Programming');
INSERT INTO course(name, category) VALUES('HTML 5', 'Front-end');

INSERT INTO topic(title, message, date_created, status, user_id, course_id) VALUES('Doubt 1', 'Error due create a project', '2019-05-05 18:00:00', 'NOT_ANSWERED', 1, 1);
INSERT INTO topic(title, message, date_created, status, user_id, course_id) VALUES('Doubt 2', 'Project does not compile', '2019-05-05 19:00:00', 'NOT_ANSWERED', 1, 1);
INSERT INTO topic(title, message, date_created, status, user_id, course_id) VALUES('Doubt 3', 'HTML Tag', '2019-05-05 20:00:00', 'NOT_ANSWERED', 1, 2);
