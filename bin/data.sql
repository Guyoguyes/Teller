insert into CATEGORY (CAT_ID, CATEGORY_NAME) values (1, 'Wrong Arm of the Law, The');
insert into CATEGORY (CAT_ID, CATEGORY_NAME) values (2, 'Next Best Thing, The');
insert into CATEGORY (CAT_ID, CATEGORY_NAME) values (3, 'At Any Price');
insert into CATEGORY (CAT_ID, CATEGORY_NAME) values (4, 'Haunted Palace, The');
insert into CATEGORY (CAT_ID, CATEGORY_NAME) values (5, 'Horse Feathers');
insert into CATEGORY (CAT_ID, CATEGORY_NAME) values (6, 'Come Undone (Cosa voglio di più)');
insert into CATEGORY (CAT_ID, CATEGORY_NAME) values (7, 'Chak De India!');
insert into CATEGORY (CAT_ID, CATEGORY_NAME) values (8, 'Garfield''s Fun Fest');
insert into CATEGORY (CAT_ID, CATEGORY_NAME) values (9, 'India (Indien)');
insert into CATEGORY (CAT_ID, CATEGORY_NAME) values (10, 'Nukes in Space');

insert into AUTHOR (AUTHOR_ID, FIRSTNAME, LASTNAME, TITLE) values (1, 'Rosmunda', 'Sanbroke', 'Administrative Officer');
insert into AUTHOR (AUTHOR_ID, FIRSTNAME, LASTNAME, TITLE) values (2, 'Leonore', 'Frew', 'Systems Administrator I');
insert into AUTHOR (AUTHOR_ID, FIRSTNAME, LASTNAME, TITLE) values (3, 'Hall', 'O''Moylane', 'Programmer Analyst IV');
insert into AUTHOR (AUTHOR_ID, FIRSTNAME, LASTNAME, TITLE) values (4, 'Hew', 'Storr', 'Chemical Engineer');
insert into AUTHOR (AUTHOR_ID, FIRSTNAME, LASTNAME, TITLE) values (5, 'Mickey', 'O''Farris', 'VP Marketing');
insert into AUTHOR (AUTHOR_ID, FIRSTNAME, LASTNAME, TITLE) values (6, 'Edi', 'Janisson', 'Research Associate');
insert into AUTHOR (AUTHOR_ID, FIRSTNAME, LASTNAME, TITLE) values (7, 'Sybil', 'Goldes', 'Systems Administrator II');
insert into AUTHOR (AUTHOR_ID, FIRSTNAME, LASTNAME, TITLE) values (8, 'Kimberlee', 'Sweetzer', 'Legal Assistant');
insert into AUTHOR (AUTHOR_ID, FIRSTNAME, LASTNAME, TITLE) values (9, 'Lizabeth', 'Etheridge', 'Developer IV');
insert into AUTHOR (AUTHOR_ID, FIRSTNAME, LASTNAME, TITLE) values (10, 'Briant', 'Steane', 'Social Worker');

insert into NEWS (NEWS_ID, AUTHOR_ID, CAT_ID, CONTENT, CREATED_AT) values (1, 10, 8, 'viverra diam vitae quam suspendisse potenti nullam porttitor lacus at turpis donec posuere metus', '2021-01-17');
insert into NEWS (NEWS_ID, AUTHOR_ID, CAT_ID, CONTENT, CREATED_AT) values (2, 9, 2, 'vel lectus in quam fringilla rhoncus mauris enim leo rhoncus sed vestibulum sit amet', '2020-10-20');
insert into NEWS (NEWS_ID, AUTHOR_ID, CAT_ID, CONTENT, CREATED_AT) values (3, 8, 3, 'vitae consectetuer eget rutrum at lorem integer tincidunt ante vel ipsum praesent blandit lacinia erat vestibulum', '2020-12-08');
insert into NEWS (NEWS_ID, AUTHOR_ID, CAT_ID, CONTENT, CREATED_AT) values (4, 7, 10, 'posuere cubilia curae nulla dapibus dolor vel est donec odio justo', '2020-08-13');
insert into NEWS (NEWS_ID, AUTHOR_ID, CAT_ID, CONTENT, CREATED_AT) values (5, 6, 7, 'purus eu magna vulputate luctus cum sociis natoque penatibus et', '2020-08-30');
insert into NEWS (NEWS_ID, AUTHOR_ID, CAT_ID, CONTENT, CREATED_AT) values (6, 5, 1, 'in lectus pellentesque at nulla suspendisse potenti cras in purus eu magna vulputate luctus cum sociis natoque penatibus', '2020-08-05');
insert into NEWS (NEWS_ID, AUTHOR_ID, CAT_ID, CONTENT, CREATED_AT) values (7, 4, 9, 'consequat nulla nisl nunc nisl duis bibendum felis sed interdum venenatis turpis enim blandit mi in porttitor pede', '2020-10-16');
insert into NEWS (NEWS_ID, AUTHOR_ID, CAT_ID, CONTENT, CREATED_AT) values (8, 3, 5, 'rhoncus dui vel sem sed sagittis nam congue risus semper', '2020-06-14');
insert into NEWS (NEWS_ID, AUTHOR_ID, CAT_ID, CONTENT, CREATED_AT) values (9, 2, 6, 'vehicula condimentum curabitur in libero ut massa volutpat convallis morbi odio odio elementum eu interdum eu tincidunt in leo maecenas', '2020-06-14');
insert into NEWS (NEWS_ID, AUTHOR_ID, CAT_ID, CONTENT, CREATED_AT) values (10, 1, 4, 'ipsum aliquam non mauris morbi non lectus aliquam sit amet diam', '2020-05-26');



insert into COMMENT (COMMENT_ID, NEWS_ID, CONTENT, COMMENT_DATE) values (1, 10, 'vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia curae donec pharetra magna vestibulum aliquet ultrices erat', '2020-12-23');
insert into COMMENT (COMMENT_ID, NEWS_ID, CONTENT, COMMENT_DATE) values (2, 9, 'ut suscipit a feugiat et eros vestibulum ac est lacinia nisi venenatis tristique fusce congue diam', '2021-01-11');
insert into COMMENT (COMMENT_ID, NEWS_ID, CONTENT, COMMENT_DATE) values (3, 8, 'ultrices vel augue vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia curae', '2020-06-23');
insert into COMMENT (COMMENT_ID, NEWS_ID, CONTENT, COMMENT_DATE) values (4, 7, 'quis lectus suspendisse potenti in eleifend quam a odio in hac habitasse platea dictumst maecenas ut', '2020-10-08');
insert into COMMENT (COMMENT_ID, NEWS_ID, CONTENT, COMMENT_DATE) values (5, 6, 'proin eu mi nulla ac enim in tempor turpis nec euismod scelerisque quam turpis adipiscing', '2020-09-10');
insert into COMMENT (COMMENT_ID, NEWS_ID, CONTENT, COMMENT_DATE) values (6, 5, 'elementum pellentesque quisque porta volutpat erat quisque erat eros viverra eget congue eget semper rutrum nulla nunc purus', '2020-06-29');
insert into COMMENT (COMMENT_ID, NEWS_ID, CONTENT, COMMENT_DATE) values (7, 4, 'dis parturient montes nascetur ridiculus mus etiam vel augue vestibulum rutrum rutrum neque aenean auctor', '2020-04-04');
insert into COMMENT (COMMENT_ID, NEWS_ID, CONTENT, COMMENT_DATE) values (8, 3, 'semper rutrum nulla nunc purus phasellus in felis donec semper sapien a libero nam dui proin', '2020-11-18');
insert into COMMENT (COMMENT_ID, NEWS_ID, CONTENT, COMMENT_DATE) values (9, 2, 'at turpis donec posuere metus vitae ipsum aliquam non mauris morbi non lectus aliquam sit amet', '2020-10-03');
insert into COMMENT (COMMENT_ID, NEWS_ID, CONTENT, COMMENT_DATE) values (10, 1, 'rhoncus aliquet pulvinar sed nisl nunc rhoncus dui vel sem sed sagittis nam congue risus semper', '2020-06-08');