

INSERT INTO public.movies (id, name, genre, description, release_date, poster_url) VALUES (1, 'Матрица', ' фантастика, боевик', 'Жизнь Томаса Андерсона разделена на две части: днём он — самый обычный офисный работник, получающий нагоняи от начальства, а ночью превращается в хакера по имени Нео, и нет места в сети, куда он бы не смог проникнуть. Но однажды всё меняется. Томас узнаёт ужасающую правду о реальности.', '1999-03-24', 'posters/Matrix-DVD.jpg');
INSERT INTO public.movies (id, name, genre, description, release_date, poster_url) VALUES (2, 'Побег из Шоушенка', 'Драма', 'Бухгалтер Энди Дюфрейн обвинён в убийстве собственной жены и её любовника. Оказавшись в тюрьме под названием Шоушенк, он сталкивается с жестокостью и беззаконием, царящими по обе стороны решётки. Каждый, кто попадает в эти стены, становится их рабом до конца жизни. Но Энди, обладающий живым умом и доброй душой, находит подход как к заключённым, так и к охранникам, добиваясь их особого к себе расположения.', '1994-09-10', 'posters/Pobeg_iz_shoushenka.jpg');
INSERT INTO public.movies (id, name, genre, description, release_date, poster_url) VALUES (3, 'Hancock', 'фантастика, боевик, драма, комедия', e'Есть герои, есть супергерои, и есть Хэнкок. Обладание сверхспособностями предполагает ответственность, все знают это — кроме него. За любую задачу он берётся с душой и лучшими намерениями, спасает жизни людей — ценой нечеловеческих разрушений и неисчислимого ущерба. В конце концов, терпение общественности подходит к концу: люди благодарны своему местному герою, но иногда не понимают, чем заслужили такое наказание.

Хэнкок не из тех парней, кого волнует какое-то там общественное мнение, но однажды, после очередного подвига, спасая высокопоставленного пиарщика Рэя, он вдруг понимает, что в некотором смысле он может быть уязвим. С этим трудно смириться, особенно по мнению Мэри, жены Рэя, считающей, что Хэнкок попросту безнадежен.', '2008-06-16', 'posters/hancock.jpg');
INSERT INTO public.movies (id, name, genre, description, release_date, poster_url) VALUES (4, 'Alien', e'
ужасы, фантастика, триллер', 'В далеком будущем возвращающийся на Землю грузовой космический корабль перехватывает исходящий с неизвестной планеты сигнал. Экипаж, в соответствии с основными инструкциями, обязан найти и исследовать источник сигнала. Оказавшись на планете, астронавты повсюду обнаруживают предметы, по виду напоминающие гигантские коконы.', '1979-05-25', 'posters/alien.jpg');
INSERT INTO public.movies (id, name, genre, description, release_date, poster_url) VALUES (5, 'Не время умирать', e'
боевик, триллер, приключения', 'Джеймс Бонд оставил оперативную службу и наслаждается спокойной жизнью на Ямайке. Все меняется, когда на острове появляется его старый друг Феликс Лейтер из ЦРУ с просьбой о помощи. Миссия по спасению похищенного ученого оказывается опаснее, чем предполагалось изначально. Бонд попадает в ловушку таинственного злодея, вооруженного опасным биологическим оружием.', '2021-09-28', 'posters/No_Time_to_Die_poster.jpg');
INSERT INTO public.movies (id, name, genre, description, release_date, poster_url) VALUES (6, 'Легенда', e'
криминал, триллер, драма', 'Близнецы Реджи и Ронни Крэй — культовые фигуры преступного мира Великобритании 1960-х. Братья возглавляли самую влиятельную бандитскую группировку Ист-Энда. В их послужном списке были вооруженные грабежи, рэкет, поджоги, покушения, убийства и собственный ночной клуб, куда доезжали даже голливудские знаменитости. Среди их жертв — криминальные авторитеты Джек МакВитти и Джордж Корнелл.', '2015-09-03', 'posters/legenda.jpg');
INSERT INTO public.movies (id, name, genre, description, release_date, poster_url) VALUES (7, 'Inception', 'Sci-Fi', 'A mind-bending thriller.', '2010-07-16', 'posters/https://example.com/poster.jpg');



INSERT INTO public.users (id, name, username, image, password, role) VALUES (2, 'Ivan', 'Ivan@mail.ru', 'users/alien.jpg', '123123', 'ADMIN');
INSERT INTO public.users (id, name, username, image, password, role) VALUES (14, 'Test', 'test@mail.ru', 'users/legenda.jpg', '123123', 'ADMIN');
INSERT INTO public.users (id, name, username, image, password, role) VALUES (15, 'test2', 'test2@mail.ru', 'users/1+1.jpg', '123123', 'ADMIN');
INSERT INTO public.users (id, name, username, image, password, role) VALUES (16, 'Супер Критик', 'kritik@mail.com', 'users/Avatarka_raketa.jpg', '123123', 'ADMIN');
INSERT INTO public.users (id, name, username, image, password, role) VALUES (18, 'FFf', 'Fff@mail.com', 'users/Matrix-DVD.jpg', '123123', 'USER');
INSERT INTO public.users (id, name, username, image, password, role) VALUES (1, 'Daniil', 'daniilhelenka98@gmail.com', 'users/hancock.jpg', '$2a$10$GMyILxUVnXNnz5Qxfjprm.6Ptq.Lt5d9T7aTwqBMjpqEbTOWqkdEi', 'ROLE_ADMIN');
INSERT INTO public.users (id, name, username, image, password, role) VALUES (17, 'User', 'user@mail.com', 'users/Pobeg_iz_shoushenka.jpg', '$2a$10$GMyILxUVnXNnz5Qxfjprm.6Ptq.Lt5d9T7aTwqBMjpqEbTOWqkdEi', 'USER');




INSERT INTO public.reviews (id, user_id, movie_id, rating, comments, created_at) VALUES (15, 1, 2, 3, 'Bad film!(', '2024-12-09 17:05:31.924634');
INSERT INTO public.reviews (id, user_id, movie_id, rating, comments, created_at) VALUES (16, 1, 3, 10, 'adasdka psdjpa kd l[aksddk 1!', '2024-12-09 17:08:43.692534');
INSERT INTO public.reviews (id, user_id, movie_id, rating, comments, created_at) VALUES (17, 1, 2, 4, 'ЙЦуйцуйцу', '2024-12-12 11:00:07.694479');
INSERT INTO public.reviews (id, user_id, movie_id, rating, comments, created_at) VALUES (18, 1, 2, 10, e'Говоря про фильм «Побег из Шоушенка», то я всегда говорю себе, что главным героем здесь является Эллис Бойд Реддинг, которого сыграл талантливый Морган Фриман. Это точно история Реддинга, а не Энди Дюфрейна, потом что Энди не меняется на протяжении всего сюжета, он просто следует конкретной цели, просто чаще всего все действия, приводящие к конечной реализации, умело скрыты сценаристами и режиссером от наших глаз

Реддинг - заключенный на пожизненном сроке, который уже смирился со своей судьбой, но внутренне к настоящему времени давно принял себя таким, какой он есть, и все свои деяния искупил за решеткой ввиду длительной изоляции. Он действительно предстает перед нами, как зрелый умный мужчина, понимающий, что такое хорошо и что такое плохо, он помогает нуждающимся, обходит стороной опасность

Но в самом начале герой Фримана без толики надежды на какой-либо просвет уже по сути планирует в тюрьме и умереть, но именно Энди стал для него тем самым светом и дорогой в новый мир, в который не так страшно ступать, как кажется поначалу. Это точно история Эллиса Бойда Реддинга, тем более, что это его голос за кадром двигает сюжет в нужном направлении и общается со зрителем.', '2024-12-12 12:54:03.968645');
INSERT INTO public.reviews (id, user_id, movie_id, rating, comments, created_at) VALUES (19, 1, 1, 10, e'
\'Побег из Шоушенка\' – фильм о классической истории дружбы, надежде и борьбе за выживание в тяжелых условиях тюремной жизни.

Невозможно не говорить о прекрасном сюжете этого фильма. Энди Дюфрейн - банковский бухгалтер, который был незаслуженно приговорен к пожизненному заключению в тюрьме Шоушенк. Внутри тюрьмы Энди завоевывает уважение среди других заключенных своими финансовыми навыками и помогает им в различных финансовых и правовых вопросах.

Самый главный акцент делается на дружбе между Энди и Редом. Энди мечтает о побеге и тайно работает над своими планами, в то время как Ред становится его ближайшим другом и поддержкой.

После просмотра фильма ты понимаешь, насколько бывают разные люди. Некоторые себя только и видят в тюрьме, а выпускаясь в цивилизованный мир – они просто вешаются, и не знают, как себя вести и действовать в тех или иных ситуациях. Взяв того еже Реда, он даже в туалет просился, будучи на свободе.

Я не боюсь этого слова, но фильм действительно лучший их лучших не только в те года, а в принципе, учитывая даже современное кино. Заслуженный рейтинг.

Если говорить об актёрах, больше всего мне понравился Тим Роббинс, сыгравший роль Энди Дюфрейна, банкира, который был неправомерно приговорен к пожизненному заключению в тюрьме Шоушенк. Мне кажется, это одна из лучших его ролей. И конечно же, это Морган Фриман, сыгравший роль Эллиса \'Рэда\' Реддинга, заключенного, который был лидером в тюрьме и другом Анди.

Фильм безупречный, словами сложно передать те эмоции, которые испытываешь при просмотре.

10 из 10', '2024-12-12 12:54:30.147552');
INSERT INTO public.reviews (id, user_id, movie_id, rating, comments, created_at) VALUES (21, 16, 1, 5, 'asdasdasda', '2024-12-12 14:31:40.560970');
INSERT INTO public.reviews (id, user_id, movie_id, rating, comments, created_at) VALUES (22, 1, 1, 5, 'Оч понр! Лол!', '2025-01-15 11:05:23.611171');
INSERT INTO public.reviews (id, user_id, movie_id, rating, comments, created_at) VALUES (23, 1, 1, 7, 'Пересмотрел', '2025-01-15 12:43:56.642849');
INSERT INTO public.reviews (id, user_id, movie_id, rating, comments, created_at) VALUES (24, 1, 1, 1, '123', '2025-01-15 12:44:09.624287');
INSERT INTO public.reviews (id, user_id, movie_id, rating, comments, created_at) VALUES (25, 1, 1, 4, 'фывфывфывфыв', '2025-01-27 13:20:23.452668');
INSERT INTO public.reviews (id, user_id, movie_id, rating, comments, created_at) VALUES (26, 1, 1, 1, 'Гг', '2025-01-28 13:34:30.253021');
INSERT INTO public.reviews (id, user_id, movie_id, rating, comments, created_at) VALUES (27, 1, 1, 1, 'гггг', '2025-01-28 13:34:53.487702');
INSERT INTO public.reviews (id, user_id, movie_id, rating, comments, created_at) VALUES (28, 1, 1, 5, '123123122312312312331223123', '2025-02-03 12:48:01.548376');





INSERT INTO public.watchlist (id, user_id, movie_id, list_type) VALUES (44, 1, 1, 'watching');
INSERT INTO public.watchlist (id, user_id, movie_id, list_type) VALUES (47, 1, 2, 'watching');
INSERT INTO public.watchlist (id, user_id, movie_id, list_type) VALUES (16, 16, 3, 'watched');
INSERT INTO public.watchlist (id, user_id, movie_id, list_type) VALUES (15, 16, 4, 'watched');
INSERT INTO public.watchlist (id, user_id, movie_id, list_type) VALUES (13, 16, 5, 'watched');
