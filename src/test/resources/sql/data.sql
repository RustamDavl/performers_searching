INSERT INTO person (id,
                    first_name,
                    email,
                    password,
                    photo)
VALUES (1, 'Vera', 'neque.Nullam@ut.org',
        'pede.', 'C:/Desktop/someFolder'),
       (2, 'Xerxes', 'lacinia@velite.uk',
        'ipsum', 'C:/Desktop/someFolder'),
       (3, 'Remedios', 'natoque@Fusce.com',
        'enim', 'C:/Desktop/someFolder'),
       (4, 'Liberty', 'libero.mauris@vitaed.uk',
        'amet', 'C:/Desktop/someFolder'),
       (5, 'Perry', 'ipsum.primis.in@turpisntum.com',
        'Donec', 'C:/Desktop/someFolder'),
       (6, 'Tucker', 'vitae@semper.ega.org',
        'non,', 'C:/Desktop/someFolder'),
       (7, 'Bernard', 'Nulla@ametus.ca',
        'Mauris', 'C:/Desktop/someFolder'),
       (8, 'Sybill', 'habitant@nonummyFusce.net',
        'ligula', 'C:/Desktop/someFolder'),
       (9, 'Kuame', 'sed.libero@ullam.edu',
        'non,', 'C:/Desktop/someFolder'),
       (10, 'Tanisha', 'ue@nuncsed.ca',
        'penatibus', 'C:/Desktop/someFolder'),
       (11, 'Sloane', 'niat@euismod.net',
        'in', 'C:/Desktop/someFolder'),
       (12, 'Oliver', 't@metus.edu',
        'nec', 'C:/Desktop/someFolder'),
       (13, 'Melinda', 'ante@auctoc.edu',
        'Quisque', 'C:/Desktop/someFolder'),
       (14, 'Isaac', 'agittis@in.edu',
        'consequat', 'C:/Desktop/someFolder'),
       (15, 'Sydnee', 'at.pede@Mauriseuturpis.com',
        'luctus', 'C:/Desktop/someFolder'),
       (16, 'Malachi', 'turpis@risusaultricies.ca',
        'massa', 'C:/Desktop/someFolder'),
       (17, 'Quinn', 'accumsan.convallis.ante@ametmassa.edu',
        'malesuada', 'C:/Desktop/someFolder'),
       (18, 'Hadassah', 'libero.dui.nec@pharetrautpharetra.net',
        'accumsan', 'C:/Desktop/someFolder'),
       (19, 'Vance', 'adipiscing@nonummy.com',
        'pellentesque.', 'C:/Desktop/someFolder'),
       (20, 'Griffin', 'Aliquam.fringilla@maurisblanditmattis.ca',
        'consequat,', 'C:/Desktop/someFolder');

select setval('person_id_seq', (select max(id) from person));

insert into role(id, name)
values (1, 'CUSTOMER'),
       (2, 'EXECUTOR');
select setval('role_id_seq', (select max(id) from role));

insert into keyword(id, name)
values (1, 'прораб'),
       (2, 'каменщик'),
       (3, 'монтажник окон'),
       (4, 'маляр'),
       (5, 'плотник'),
       (6, 'монтажник'),
       (7, 'столяр'),
       (8, 'крановщик'),
       (9, 'сметчик'),
       (10, 'арматурщик'),
       (11, 'бондарь'),
       (12, 'бетонщик'),
       (13, 'отделочник'),
       (14, 'плиточник');
select setval('keyword_id_seq', (select max(id) from keyword));

insert into experience(id, name)
values (1, 'меньше года'),
       (2, '1 год'),
       (3, '2 года'),
       (4, '3 года'),
       (5, '4 года'),
       (6, '5 лет'),
       (7, '6 лет'),
       (8, '7 лет'),
       (9, '8 лет'),
       (10, '9 лет'),
       (11, '10 лет'),
       (12, 'более 10 лет');
select setval('experience_id_seq', (select max(id) from experience));

insert into measurement(id, name)
values (1, 'за час'),
       (2, 'за метр'),
       (3, 'за услугу'),
       (4, 'за кв метр'),
       (5, 'за куб метр'),
       (6, 'за единицу'),
       (7, 'за км'),
       (8, 'за день');
select setval('measurement_id_seq', (select max(id) from measurement));

INSERT INTO orders (id,
                    person_id,
                    city,
                    street,
                    house_number,
                    description,
                    keyword_id,
                    start_at,
                    end_at)
VALUES (1, 8, 'Freiberg', '691-165 Augue Road', '4067', 'Lorem ipsum dolor sit', 12, '2022-01-29', '2022-01-29'),
       (2, 9, 'Ferrere', 'Ap #543-3207 Mauris. Rd.', 'UK24 8PD', 'Lorem ipsum dolor sit', 12, '2023-01-29', '2022-01-29'),
       (3, 17, 'Scorrano', 'P.O. Box 751, 3771 Tellus Rd.', '1866', 'Lorem ipsum dolor sit', 2, '2023-01-29', '2022-01-29'),
       (4, 4, 'Vetlanda', '8663 Nec, Rd.', '16693', 'Lorem ipsum', 11, '2023-01-29', '2022-01-29'),
       (5, 1, 'Arlon', 'Ap #931-7835 Convallis Av.', '163178', 'Lorem ipsum dolor', 2, '2023-01-29', '2022-01-29'),
       (6, 2, 'Orlando', '793-1812 Id Av.', '10414', 'Lorem ipsum dolor', 4, '2023-01-29', '2022-01-29'),
       (7, 16, 'Gibsons', 'Ap #639-4278 Eget, St.', '9740', 'Lorem ipsum', 14, '2023-01-29', '2022-01-29'),
       (8, 10, 'Llanwrtwd Wells', 'Ap #361-9772 Ligula. Ave', '630521', 'Lorem ipsum dolor', 11, '2023-01-29', '2022-01-29'),
       (9, 5, 'Tiruchirapalli', 'P.O. Box 444, 170 Rutrum. St.', 'N6P 7E7', 'Lorem ipsum dolor sit', 6, '2023-01-29',
        '2022-01-29'),
       (10, 15, 'Whitehaven', 'Ap #268-3281 Mauris Road', '531508', 'Lorem ipsum', 3, '2023-01-29', '2022-01-29'),
       (11, 16, 'Retie', 'P.O. Box 603, 7639 Gravida. Rd.', '33719-133', 'Lorem ipsum dolor sit amet,', 1, '2023-01-29',
        '2022-01-29'),
       (12, 14, 'Casnate con Bernate', '8063 Placerat St.', '43350', 'Lorem ipsum dolor', 9, '2023-01-29', '2022-01-29'),
       (13, 18, 'Elingen', '1973 Orci, Avenue', '55155', 'Lorem ipsum dolor sit amet,', 5, '2023-01-29', '2022-01-29'),
       (14, 4, 'Wokingham', '783-8524 Viverra. Rd.', '61296', 'Lorem ipsum', 10, '2023-01-29', '2022-01-29'),
       (15, 20, 'Charleroi', '4083 Nullam Rd.', '15904', 'Lorem ipsum dolor sit amet,', 11, '2023-01-29', '2022-01-29'),
       (16, 18, 'Palayankottai', '431-7578 Sed St.', '40835', 'Lorem ipsum dolor sit', 11, '2023-01-29', '2022-01-29'),
       (17, 20, 'Waterbury', 'P.O. Box 520, 8665 Bibendum. St.', '74430', 'Lorem ipsum', 4, '2023-01-29', '2022-01-29'),
       (18, 20, 'Bauchi', 'P.O. Box 599, 1215 Metus St.', '14-676', 'Lorem ipsum dolor sit amet,', 8, '2023-01-29',
        '2022-01-29'),
       (19, 16, 'Chastre', 'Ap #140-581 Dolor Road', '30614', 'Lorem ipsum dolor sit amet,', 2, '2023-01-29', '2022-01-29'),
       (20, 17, 'Henstedt-Ulzburg', '197-2012 Nascetur Rd.', 'H7V 4A9', 'Lorem ipsum', 6, '2023-01-29','2022-01-29'),
       (21, 13, 'Cañete', '102-8562 Nam Street', '06425', 'Lorem', 14, '2023-01-29', '2022-01-29'),
       (22, 16, 'Calle Larga', '6053 Non, Avenue', '5408', 'Lorem ipsum dolor sit', 10, '2023-01-29', '2022-01-29'),
       (23, 17, 'Baarle-Hertog', '369-8892 Enim Rd.', '45166', 'Lorem ipsum', 10, '2023-01-29', '2022-01-29'),
       (24, 20, 'Montebello sul Sangro', '921-3568 Mauris Av.', '336534', 'Lorem ipsum dolor sit', 10, '2023-01-29',
        '2022-01-29'),
       (25, 10, 'Pichilemu', 'P.O. Box 212, 460 Euismod Avenue', '57728', 'Lorem ipsum dolor', 11, '2023-01-29',
        '2022-01-29'),
        (26, 19, 'Nocera Umbra', '149-2093 In, Avenue', '07241-913', 'Lorem', 4, '2023-01-29', '2022-01-29'),
        (27, 6, 'Sromness', '807-8812 Vel, Rd.', 'PJ0W 3TH', 'Lorem', 9, '2023-01-29', '2022-01-29'),
        (28, 16, 'Deurne', '5161 Non, Road', '67751', 'Lorem ipsum dolor', 1, '2023-01-29', '2022-01-29'),
        (29, 18, 'Badalona', 'Ap #879-1409 Duis Rd.', '3101', 'Lorem', 9, '2023-01-29', '2022-01-29'),
        (30, 2, 'Hinckley', 'P.O. Box 208, 2034 Sed, Ave', '37861', 'Lorem ipsum dolor', 8, '2023-01-29',  '2022-01-29');

select setval('orders_id_seq', (select max(id) from orders));

INSERT INTO resume (id,
                    person_id,
                    keyword_id,
                    price,
                    measurement_id,
                    mon,
                    tues,
                    wed,
                    thurs,
                    fri,
                    sat,
                    sun,
                    start_at,
                    end_at,
                    experience_id,
                    city,
                    street,
                    house_number,
                    team,
                    about_me)
VALUES (1, 13, 6, '260', 1, 'false', 'false', 'true', 'false', 'true', 'false', 'false', '22:00', '22:00', 1,
        'Lidköping', 'P.O. Box 293, 8279 Sapien, Avenue', 'Y4S 6N8', 'ALONE_TEAM', 'Lorem ipsum dolor'),
       (2, 17, 14, '145', 4, 'false', 'false', 'true', 'false', 'true', 'false', 'false', '22:00', '22:00', 2,
        'Lusevera', '649-5593 Amet Rd.', '144083', 'TEAM', 'Lorem ipsum dolor sit'),
       (3, 3, 3, '578', 4, 'true', 'true', 'false', 'false', 'false', 'false', 'false', '22:00', '22:00', 5,
        'Göppingen', '823-711 Ut, Rd.', '50910', 'ALONE_TEAM', 'Lorem ipsum dolor sit'),
       (4, 10, 13, '053', 6, 'false', 'false', 'false', 'false', 'false', 'true', 'true', '22:00', '22:00', 6,
        'Ilbono', 'Ap #624-4294 Fusce Av.', '74-022', 'TEAM', 'Lorem ipsum dolor'),
       (5, 11, 1, '895', 1, 'false', 'false', 'true', 'true', 'false', 'true', 'false', '22:00', '22:00', 7,
        'Middelkerke', '309-2785 Vel St.', '26-966', 'ALONE_TEAM', 'Lorem ipsum dolor sit'),
       (6, 4, 11, '189', 8, 'false', 'true', 'true', 'false', 'false', 'true', 'true', '22:00', '22:00', 5,
        'Montigny-lès-Metz', '187-7760 Ultrices. Ave', '1374', 'TEAM', 'Lorem ipsum'),
       (7, 16, 14, '178', 1, 'false', 'false', 'true', 'false', 'false', 'false', 'true', '22:00', '22:00',
        3, 'Yerbas Buenas', 'Ap #971-1221 Mollis. Av.', '7932', 'ALONE', 'Lorem ipsum'),
       (8, 15, 4, '064', 2, 'false', 'false', 'false', 'true', 'false', 'true', 'true', '22:00', '22:00', 10,
        'Outremont', '761-8092 Porttitor Ave', '9328', 'ALONE', 'Lorem ipsum dolor sit amet,'),
       (9, 12, 5, '794', 7, 'true', 'false', 'false', 'false', 'false', 'true', 'true', '22:00', '22:00', 3,
        'Maubeuge', '3254 Scelerisque, Rd.', '14451', 'ALONE', 'Lorem ipsum dolor'),
       (10, 14, 2, '229', 4, 'false', 'true', 'false', 'true', 'false', 'true', 'false', '22:00', '22:00', 5,
        'Erode', '461-6919 Luctus St.', '1280', 'TEAM', 'Lorem ipsum dolor sit'),
       (11, 1, 8, '884', 8, 'false', 'false', 'true', 'true', 'false', 'true', 'true', '22:00', '22:00', 3,
        'Cametá', 'Ap #836-4539 Dis St.', '07539', 'ALONE', 'Lorem ipsum dolor'),
       (12, 11, 4, '403', 2, 'false', 'false', 'true', 'false', 'true', 'true', 'true', '22:00', '22:00', 8,
        'Pelotas', 'P.O. Box 131, 4877 Netus Rd.', '90-969', 'ALONE_TEAM', 'Lorem ipsum'),
       (13, 19, 14, '062', 1, 'false', 'false', 'false', 'true', 'true', 'false', 'false', '22:00', '22:00',
        1, 'Arles', 'Ap #524-7499 Mi Road', '35152', 'TEAM', 'Lorem'),
       (14, 2, 3, '245', 7, 'false', 'true', 'false', 'false', 'true', 'true', 'false', '22:00', '22:00', 1,
        'Málaga', '423-2284 Luctus. Ave', '104180', 'ALONE_TEAM', 'Lorem ipsum dolor sit'),
       (15, 2, 13, '919', 6, 'false', 'false', 'false', 'false', 'false', 'false', 'true', '22:00', '22:00',
        3, 'Porto Cesareo', 'Ap #701-6306 Ultricies Ave', '99543', 'ALONE', 'Lorem ipsum dolor sit'),
       (16, 3, 4, '916', 3, 'true', 'true', 'true', 'true', 'false', 'false', 'false', '22:00', '22:00', 10,
        'Comblain-Fairon', 'Ap #587-340 Vel St.', '91632', 'TEAM', 'Lorem'),
       (17, 14, 13, '535', 6, 'false', 'false', 'false', 'true', 'false', 'true', 'false', '22:00', '22:00',
        9, 'Sesto Campano', '885 Libero Rd.', '51765', 'ALONE', 'Lorem ipsum dolor sit'),
       (18, 3, 11, '923', 2, 'true', 'true', 'true', 'false', 'false', 'true', 'false', '22:00', '22:00', 8,
        'Sovizzo', 'Ap #752-9687 Quisque Ave', 'V6 8QU', 'TEAM', 'Lorem'),
       (19, 20, 5, '793', 3, 'false', 'true', 'true', 'false', 'true', 'true', 'false', '22:00', '22:00', 6,
        'Profondeville', '5613 Magna, Street', '804194', 'TEAM', 'Lorem ipsum dolor'),
       (20, 20, 8, '857', 7, 'false', 'false', 'false', 'false', 'false', 'false', 'false', '22:00', '22:00',
        5, 'Malbaie', '876-1449 Tincidunt Rd.', 'C2E 3S9', 'ALONE', 'Lorem ipsum'),
       (21, 11, 10, '783', 4, 'true', 'false', 'true', 'true', 'false', 'false', 'true', '22:00', '22:00',
        7, 'Arica', 'P.O. Box 300, 7913 Eget, Road', '9676', 'TEAM', 'Lorem ipsum dolor'),
       (22, 1, 6, '780', 8, 'false', 'false', 'true', 'false', 'true', 'false', 'true', '22:00', '22:00', 2,
        'Bonnyville', 'P.O. Box 390, 5076 Rhoncus. Road', '81208', 'TEAM', 'Lorem'),
       (23, 12, 1, '193', 1, 'false', 'false', 'true', 'true', 'true', 'true', 'true', '22:00', '22:00',2,
        'Winterswijk', '9757 Turpis Avenue', '46964', 'TEAM', 'Lorem ipsum'),
       (24, 14, 5, '214', 1, 'true', 'true', 'false', 'false', 'true', 'false', 'true', '22:00', '22:00', 1,
        'Dillingen', '453-1540 Imperdiet Rd.', '369122', 'ALONE_TEAM', 'Lorem ipsum dolor'),
       (25, 19, 10, '473', 1, 'false', 'true', 'true', 'false', 'true', 'false', 'true', '22:00', '22:00', 5,
        'Ergani', 'P.O. Box 585, 5082 Integer St.', '1009 LA', 'ALONE', 'Lorem ipsum'),
       (26, 1, 10, '937', 3, 'false', 'true', 'false', 'false', 'false', 'false', 'false', '22:00', '22:00',
        2, 'Petorca', '429-2150 Dui. Ave', '00847', 'ALONE', 'Lorem ipsum dolor'),
       (27, 4, 3, '470', 2, 'false', 'false', 'false', 'false', 'false', 'false', 'false', '22:00', '22:00',
        9, 'Campofelice di Fitalia', '136-731 Metus. Rd.', '55101-519', 'TEAM', 'Lorem'),
       (28, 12, 4, '047', 2, 'false', 'false', 'true', 'false', 'false', 'true', 'false', '22:00', '22:00',
        3, 'Vlissegem', 'Ap #591-5254 Mauris Av.', '954996', 'ALONE_TEAM', 'Lorem ipsum'),
       (29, 19, 7, '289', 3, 'false', 'true', 'false', 'true', 'false', 'false', 'true', '22:00', '22:00', 5,
        'Criciúma', 'Ap #500-9828 Lobortis Avenue', '06751', 'ALONE', 'Lorem ipsum dolor sit amet,'),
       (30, 10, 2, '761', 2, 'false', 'true', 'false', 'false', 'true', 'true', 'true', '22:00', '22:00', 6,
        'San Polo d''Enza', 'P.O. Box 372, 7608 Molestie St.', '61497', 'ALONE_TEAM', 'Lorem'),
       (31, 6, 2, '630', 7, 'false', 'true', 'false', 'true', 'false', 'false', 'false', '22:00', '22:00', 2,
        'Castel Guelfo di Bologna', '5702 Facilisis Av.', '05941', 'ALONE', 'Lorem ipsum dolor sit'),
       (32, 12, 4, '171', 2, 'true', 'false', 'true', 'false', 'false', 'true', 'false', '22:00', '22:00', 5,
        'Ferrere', '1057 Luctus Av.', '06441', 'ALONE_TEAM', 'Lorem ipsum dolor sit'),
       (33, 4, 10, '468', 4, 'false', 'true', 'true', 'true', 'false', 'false', 'false', '22:00', '22:00', 1,
        'Landenne', 'P.O. Box 504, 4029 Iaculis Rd.', '50-127', 'ALONE_TEAM', 'Lorem ipsum dolor'),
       (34, 20, 7, '327', 8, 'true', 'true', 'true', 'false', 'false', 'false', 'false', '22:00', '22:00', 1,
        'Frankston', 'Ap #751-9623 Tortor Av.', '4872', 'ALONE_TEAM', 'Lorem'),
       (35, 17, 9, '712', 7, 'true', 'true', 'false', 'false', 'true', 'false', 'true', '22:00', '22:00', 1,
        'Villers-Perwin', '305-2753 Consectetuer St.', '90610', 'TEAM', 'Lorem ipsum dolor');

select setval('resume_id_seq', (select max(id) from resume));


INSERT INTO orders_resume (id,
                           order_id,
                           resume_id,
                           resume_status,
                           order_status)
VALUES (1, 3, 21, 'SENT', 'SENT'),
       (2, 22, 16, 'NOT_VIEWED', 'ACCEPTED'),
       (3, 9, 30, 'VIEWED', 'ACCEPTED'),
       (4, 3, 17, 'SENT', 'SENT'),
       (5, 29, 9, 'ACCEPTED', 'NOT_VIEWED'),
       (6, 8, 25, 'VIEWED', 'SENT'),
       (7, 6, 21, 'REFUSED', 'VIEWED'),
       (8, 14, 6, 'VIEWED', 'REFUSED'),
       (9, 30, 30, 'NOT_VIEWED', 'VIEWED'),
       (10, 27, 21, 'REFUSED', 'NOT_VIEWED'),
       (11, 14, 20, 'REFUSED', 'SENT'),
       (12, 4, 15, 'REFUSED', 'SENT'),
       (13, 13, 23, 'SENT', 'REFUSED'),
       (14, 13, 33, 'VIEWED', 'ACCEPTED'),
       (15, 24, 4, 'VIEWED', 'ACCEPTED'),
       (16, 14, 33, 'REFUSED', 'REFUSED'),
       (17, 27, 1, 'SENT', 'ACCEPTED'),
       (18, 2, 28, 'ACCEPTED', 'REFUSED'),
       (19, 3, 6, 'ACCEPTED', 'NOT_VIEWED'),
       (20, 8, 16, 'VIEWED', 'REFUSED'),
       (21, 4, 14, 'REFUSED', 'VIEWED'),
       (22, 11, 21, 'VIEWED', 'ACCEPTED'),
       (23, 28, 16, 'SENT', 'VIEWED'),
       (24, 4, 27, 'ACCEPTED', 'NOT_VIEWED'),
       (25, 10, 5, 'NOT_VIEWED', 'NOT_VIEWED'),
       (26, 8, 5, 'VIEWED', 'VIEWED'),
       (27, 23, 10, 'NOT_VIEWED', 'ACCEPTED'),
       (28, 3, 20, 'ACCEPTED', 'REFUSED'),
       (29, 11, 25, 'SENT', 'ACCEPTED'),
       (30, 30, 19, 'VIEWED', 'NOT_VIEWED'),
       (31, 19, 22, 'VIEWED', 'REFUSED'),
       (32, 23, 27, 'REFUSED', 'SENT'),
       (33, 17, 16, 'VIEWED', 'NOT_VIEWED'),
       (34, 22, 32, 'SENT', 'NOT_VIEWED'),
       (35, 20, 4, 'SENT', 'VIEWED'),
       (36, 25, 27, 'SENT', 'VIEWED'),
       (37, 8, 15, 'VIEWED', 'NOT_VIEWED'),
       (38, 10, 32, 'ACCEPTED', 'NOT_VIEWED'),
       (39, 8, 14, 'SENT', 'REFUSED'),
       (40, 30, 10, 'REFUSED', 'REFUSED'),
       (41, 13, 15, 'VIEWED', 'NOT_VIEWED'),
       (42, 9, 9, 'NOT_VIEWED', 'REFUSED'),
       (43, 18, 12, 'NOT_VIEWED', 'SENT'),
       (44, 12, 22, 'VIEWED', 'REFUSED'),
       (45, 26, 31, 'REFUSED', 'REFUSED'),
       (46, 29, 5, 'ACCEPTED', 'SENT'),
       (47, 16, 11, 'SENT', 'ACCEPTED'),
       (48, 16, 18, 'REFUSED', 'SENT'),
       (49, 17, 22, 'SENT', 'VIEWED'),
       (50, 3, 2, 'ACCEPTED', 'REFUSED'),
       (51, 28, 10, 'SENT', 'REFUSED'),
       (52, 5, 4, 'ACCEPTED', 'NOT_VIEWED'),
       (53, 9, 28, 'ACCEPTED', 'VIEWED'),
       (54, 3, 19, 'VIEWED', 'VIEWED'),
       (55, 12, 7, 'ACCEPTED', 'VIEWED'),
       (56, 20, 14, 'REFUSED', 'VIEWED'),
       (57, 6, 20, 'VIEWED', 'ACCEPTED'),
       (58, 26, 3, 'NOT_VIEWED', 'SENT'),
       (59, 29, 31, 'NOT_VIEWED', 'ACCEPTED'),
       (60, 2, 10, 'SENT', 'NOT_VIEWED'),
       (61, 12, 15, 'SENT', 'VIEWED'),
       (62, 29, 27, 'VIEWED', 'VIEWED'),
       (63, 3, 34, 'VIEWED', 'VIEWED'),
       (64, 27, 4, 'ACCEPTED', 'REFUSED'),
       (65, 15, 12, 'VIEWED', 'REFUSED'),
       (66, 21, 18, 'ACCEPTED', 'ACCEPTED'),
       (67, 6, 4, 'VIEWED', 'SENT'),
       (68, 16, 21, 'REFUSED', 'REFUSED'),
       (69, 11, 23, 'SENT', 'ACCEPTED'),
       (70, 20, 9, 'REFUSED', 'ACCEPTED'),
       (71, 17, 20, 'SENT', 'ACCEPTED'),
       (72, 5, 29, 'ACCEPTED', 'ACCEPTED');
select setval('orders_resume_id_seq', (select max(id) from orders_resume));


INSERT INTO person_role (id,
                         role_id,
                         person_id,
                         rating)
VALUES (1, 1, 1, '3.3'),
       (2, 2, 1, '2.9'),
       (3, 1, 2, '5.0'),
       (4, 2, 2, '3.8'),
       (5, 1, 3, '3.8'),
       (6, 2, 4, '3.5'),
       (7, 1, 5, '4.6'),
       (8, 2, 5, '4.8'),
       (9, 1, 6, '4.4'),
       (10, 2, 7, '3.3'),
       (11, 1, 7, '4.6'),
       (12, 2, 8, '4.4'),
       (13, 1, 9, '3.5'),
       (14, 2, 10, '4.6'),
       (15, 1, 10, '4.6');


select setval('person_role_id_seq', (select max(id) from person_role));

INSERT INTO photo_f_orders (id,
                            order_id,
                            photo)
VALUES (1, 8, 'C:/Desktop/someFolder'),
       (2, 30, 'C:/Desktop/someFolder'),
       (3, 20, 'C:/Desktop/someFolder'),
       (4, 30, 'C:/Desktop/someFolder'),
       (5, 16, 'C:/Desktop/someFolder'),
       (6, 24, 'C:/Desktop/someFolder'),
       (7, 29, 'C:/Desktop/someFolder'),
       (8, 19, 'C:/Desktop/someFolder'),
       (9, 8, 'C:/Desktop/someFolder'),
       (10, 19, 'C:/Desktop/someFolder'),
       (11, 3, 'C:/Desktop/someFolder'),
       (12, 26, 'C:/Desktop/someFolder'),
       (13, 27, 'C:/Desktop/someFolder'),
       (14, 13, 'C:/Desktop/someFolder'),
       (15, 3, 'C:/Desktop/someFolder'),
       (16, 25, 'C:/Desktop/someFolder'),
       (17, 3, 'C:/Desktop/someFolder'),
       (18, 2, 'C:/Desktop/someFolder'),
       (19, 7, 'C:/Desktop/someFolder'),
       (20, 4, 'C:/Desktop/someFolder'),
       (21, 7, 'C:/Desktop/someFolder'),
       (22, 24, 'C:/Desktop/someFolder'),
       (23, 19, 'C:/Desktop/someFolder'),
       (24, 14, 'C:/Desktop/someFolder'),
       (25, 12, 'C:/Desktop/someFolder'),
       (26, 9, 'C:/Desktop/someFolder'),
       (27, 25, 'C:/Desktop/someFolder'),
       (28, 21, 'C:/Desktop/someFolder'),
       (29, 21, 'C:/Desktop/someFolder'),
       (30, 11, 'C:/Desktop/someFolder'),
       (31, 1, 'C:/Desktop/someFolder'),
       (32, 2, 'C:/Desktop/someFolder'),
       (33, 12, 'C:/Desktop/someFolder'),
       (34, 19, 'C:/Desktop/someFolder'),
       (35, 21, 'C:/Desktop/someFolder'),
       (36, 10, 'C:/Desktop/someFolder'),
       (37, 18, 'C:/Desktop/someFolder'),
       (38, 29, 'C:/Desktop/someFolder'),
       (39, 29, 'C:/Desktop/someFolder'),
       (40, 15, 'C:/Desktop/someFolder'),
       (41, 4, 'C:/Desktop/someFolder'),
       (42, 23, 'C:/Desktop/someFolder'),
       (43, 1, 'C:/Desktop/someFolder'),
       (44, 19, 'C:/Desktop/someFolder'),
       (45, 20, 'C:/Desktop/someFolder'),
       (46, 18, 'C:/Desktop/someFolder'),
       (47, 28, 'C:/Desktop/someFolder'),
       (48, 15, 'C:/Desktop/someFolder'),
       (49, 6, 'C:/Desktop/someFolder'),
       (50, 22, 'C:/Desktop/someFolder');

select setval('photo_f_orders_id_seq', (select max(id) from photo_f_orders));



INSERT INTO photo_f_resume(id,
                           resume_id,
                           photo)
VALUES (1, 24, 'C:/Desktop/someFolder'),
       (2, 32, 'C:/Desktop/someFolder'),
       (3, 5, 'C:/Desktop/someFolder'),
       (4, 27, 'C:/Desktop/someFolder'),
       (5, 35, 'C:/Desktop/someFolder'),
       (6, 27, 'C:/Desktop/someFolder'),
       (7, 8, 'C:/Desktop/someFolder'),
       (8, 5, 'C:/Desktop/someFolder'),
       (9, 24, 'C:/Desktop/someFolder'),
       (10, 2, 'C:/Desktop/someFolder'),
       (11, 3, 'C:/Desktop/someFolder'),
       (12, 6, 'C:/Desktop/someFolder'),
       (13, 7, 'C:/Desktop/someFolder'),
       (14, 10, 'C:/Desktop/someFolder'),
       (15, 21, 'C:/Desktop/someFolder'),
       (16, 17, 'C:/Desktop/someFolder'),
       (17, 18, 'C:/Desktop/someFolder'),
       (18, 24, 'C:/Desktop/someFolder'),
       (19, 24, 'C:/Desktop/someFolder'),
       (20, 19, 'C:/Desktop/someFolder'),
       (21, 3, 'C:/Desktop/someFolder'),
       (22, 11, 'C:/Desktop/someFolder'),
       (23, 28, 'C:/Desktop/someFolder'),
       (24, 3, 'C:/Desktop/someFolder'),
       (25, 17, 'C:/Desktop/someFolder'),
       (26, 32, 'C:/Desktop/someFolder'),
       (27, 24, 'C:/Desktop/someFolder'),
       (28, 3, 'C:/Desktop/someFolder'),
       (29, 18, 'C:/Desktop/someFolder'),
       (30, 30, 'C:/Desktop/someFolder'),
       (31, 1, 'C:/Desktop/someFolder'),
       (32, 3, 'C:/Desktop/someFolder'),
       (33, 7, 'C:/Desktop/someFolder'),
       (34, 5, 'C:/Desktop/someFolder'),
       (35, 23, 'C:/Desktop/someFolder'),
       (36, 27, 'C:/Desktop/someFolder'),
       (37, 8, 'C:/Desktop/someFolder'),
       (38, 25, 'C:/Desktop/someFolder'),
       (39, 15, 'C:/Desktop/someFolder'),
       (40, 30, 'C:/Desktop/someFolder'),
       (41, 21, 'C:/Desktop/someFolder'),
       (42, 30, 'C:/Desktop/someFolder'),
       (43, 34, 'C:/Desktop/someFolder'),
       (44, 32, 'C:/Desktop/someFolder'),
       (45, 13, 'C:/Desktop/someFolder'),
       (46, 7, 'C:/Desktop/someFolder'),
       (47, 25, 'C:/Desktop/someFolder'),
       (48, 16, 'C:/Desktop/someFolder'),
       (49, 31, 'C:/Desktop/someFolder'),
       (50, 2, 'C:/Desktop/someFolder');

select setval('photo_f_resume_id_seq', (select max(id) from photo_f_resume));


