-- Carga de datos Categorías
INSERT INTO categorias() VALUES 
(DEFAULT, "Hotel", "Establecimiento  capaz de alojar con comodidad a huéspedes o viajeros. Lugar perfecto para turistas",
"https://equipo10-digitalbooking-img.s3.us-east-2.amazonaws.com/img/The+Westing+Palace%2C+Madrid/PalaceHotel.jpg"),
(DEFAULT, "Hostel", "Un hostel es un tipo de alojamiento económico en el que poder compartir experiencias sociales.",
"https://images.unsplash.com/photo-1555854877-bab0e564b8d5?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=869&q=80"),
(DEFAULT, "Departamento", "Parte en que está dividido un recinto, local u otro espacio mediante paredes u otra separación.",
"https://images.unsplash.com/photo-1502672260266-1c1ef2d93688?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=780&q=80"),
(DEFAULT, "Bed and Breakfast", "Un bed and breakfast es un tipo de alojamiento sencillo en una casa o residencia privada, que ofrecen alojamiento barato y un desayuno.",
"https://images.unsplash.com/photo-1597776776684-61122dcf84e6?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=466&q=80"); 

INSERT INTO ubicaciones() VALUES
(DEFAULT, "Madrid", "España", "Europa"),
(DEFAULT, "Roma", "Italia", "Europa"),
(DEFAULT, "Miami", "Estados Unidos", "América"),
(DEFAULT, "Sao Paulo", "Brasil", "América"),
(DEFAULT, "Tokio", "Japón", "Asia"),
(DEFAULT, "Maule", "Chile", "America"),
(DEFAULT, "Palomino", "Colombia", "America"),
(DEFAULT, "Santo Domingo", "Republica Dominicana", "America"); 

INSERT INTO productos() VALUES 
(DEFAULT, "The Westin Palace", "Hotel con una hermoza cupula de cristal",
"El Westin Palace tiene sus instalaciones a sólo metros del Museo del Prado y del Reina Sofía",
1690, 1, 1, 1, 45.478593, 9.198967, "Plaza de las Cortes, 7, Madrid, España"),
(DEFAULT, "Exe International Palace", "Esta parte de Roma es su favorita",
"Un hermoso edificio del siglo XIX situado frente al Teatro de la Ópera de Roma",
1649.99, 1, 2, 1, 41.900060, 12.492290, "Via Nazionale, 46, Roma RM, Italia"),
(DEFAULT, "Tiki Hut Hostel", "Hostel muy cerca a pie de la playa de Palomino",
"Se pueden practicar gran variedad de actividades",
956.00, 2, 7, 1,11.253775282187135, -73.55686843150978, " Avenida Principal, 446009 Palomino, Colombia"),
(DEFAULT, "Enjoy", "Grandiosa estadía cercana a la playa",
"Este hostal, situado a 500 m de la playa, ofrece alojamiento social",
753.99, 2, 8, 1, 18.4801572,-70.0821728, "Av. Anacaona 101, Santo Domingo, Dominican Republic"),
(DEFAULT, "Oasis Garden", "Un lugar silencioso y natural ",
"Oasis Garden en Miami, el alojamiento cuenta con terraza y espectaculares vistas",
530.50, 3, 3, 0, 26.107660, -80.136321, "870 Northeast 82nd Street, Miami, Estados Unidos"),
(DEFAULT, "Novotel Sao Paulo Morumbi", "La búsqueda del hotel para familias ideal",
"Está cerca de la mayoría de los puntos de referencia de Sao Paulo. Acceso a playa",
1233.50, 3, 4, 1, -23.612995, -46.703499, "Nelson Hungria, 577 - Vila Tramontano, São Paulo, Brasil"),
(DEFAULT, "Shinjuku", "Zona residencial Tranquila y con gran aspecto cultural de Japón",
"Casa cómoda y familiar, los niños osn bienvenidos. Cuenta con balcon con vista a la capital",
599.99, 4, 5, 1, 35.687749, 139.698145, "160-0022 Tokio, Shinjuku-ku Shijuku, Japón"),
(DEFAULT, "NITRA-CAVIAHUE", "Hermoso hotel en la cordillera montañosa",
"Hotel situado en la cordillera de los andes, nevado casi todo el año",
6699.99, 4, 6, 1, -37.864645, -71.052088, "Los Ñires, Caviahue, Acceso cordillera Chile-Neuquen"),

(DEFAULT, "COPIA 1 The Westin Palace", "Hotel con una hermoza cupula de cristal",
"El Westin Palace tiene sus instalaciones a sólo  metros del Museo del Prado y del Reina Sofía",
1690, 1, 1, 1, 45.478593, 9.198967, "Plaza de las Cortes, 7, Madrid, España"),
(DEFAULT, "COPIA 1 Exe International Palace", "Esta parte de Roma es su favorita",
"Un hermoso edificio del siglo XIX situado frente al Teatro de la Ópera de Roma",
649.99, 1, 2, 1, 41.900060, 12.492290, "Via Nazionale, 46, Roma RM, Italia"),
(DEFAULT, "COPIA 1 Mood", "Ponte en mood",
"El establecimiento Mood esta muy bien situado en el centro de Palomino",
1500.00, 2, 7, 1,11.2270835,-73.5865292, "Cl. 2 #8-50, Palomino, Dibulla, La Guajira"),
(DEFAULT, "COPIA 1 Enjoy", "Grandiosa estadía cercana a la playa",
"Este hostal, situado a 500 m de la playa, ofrece alojamiento social",
753.99, 2, 8, 1, 18.4801572,-70.0821728, "Av. Anacaona 101, Santo Domingo, Dominican Republic"),
(DEFAULT, "COPIA 1 Oasis Garden", "Un lugar silencioso y natural ",
"Oasis Garden en Miami, el alojamiento cuenta con terraza y espectaculares vistas",
530.50, 3, 3, 0, 26.107660, -80.136321, "870 Northeast 82nd Street, Miami, Estados Unidos"),
(DEFAULT, "COPIA 1 Novotel Sao Paulo Morumbi", "La búsqueda del hotel para familias ideal",
"Está cerca de la mayoría de los puntos de referencia de Sao Paulo. Acceso a playa",
1233.50, 3, 4, 1, -23.612995, -46.703499, "Nelson Hungria, 577 - Vila Tramontano, São Paulo, Brasil"),
(DEFAULT, "COPIA 1 Shinjuku", "Zona residencial Tranquila y con gran aspecto cultural de Japón",
"Casa cómoda y familiar, los niños osn bienvenidos. Cuenta con balcon con vista a la capital",
599.99, 4, 5, 1, 35.687749, 139.698145, "160-0022 Tokio, Shinjuku-ku Shijuku, Japón"),
(DEFAULT, "COPIA 1 NITRA-CAVIAHUE", "Hermoso hotel en la cordillera montañosa",
"Hotel situado en la cordillera de los andes, nevado casi todo el año",
6699.99, 4, 6, 1, -37.864645, -71.052088, "Los Ñires, Caviahue, Acceso cordillera Chile-Neuquen"),

(DEFAULT, "COPIA 2 The Westin Palace", "Hotel con una hermoza cupula de cristal",
"El Westin Palace tiene sus instalaciones a sólo  metros del Museo del Prado y del Reina Sofía",
1690, 1, 1, 1, 45.478593, 9.198967, "Plaza de las Cortes, 7, Madrid, España"),
(DEFAULT, "COPIA 2 Exe International Palace", "Esta parte de Roma es su favorita",
"Un hermoso edificio del siglo XIX situado frente al Teatro de la Ópera de Roma",
649.99, 1, 2, 1, 41.900060, 12.492290, "Via Nazionale, 46, Roma RM, Italia"),
(DEFAULT, "COPIA 2 Mood", "Ponte en mood",
"El establecimiento Mood esta muy bien situado en el centro de Palomino",
1500.00, 2, 7, 1,11.2270835,-73.5865292, "Cl. 2 #8-50, Palomino, Dibulla, La Guajira"),
(DEFAULT, "COPIA 2 Enjoy", "Grandiosa estadía cercana a la playa",
"Este hostal, situado a 500 m de la playa, ofrece alojamiento social",
753.99, 2, 8, 1, 18.4801572,-70.0821728, "Av. Anacaona 101, Santo Domingo, Dominican Republic"),
(DEFAULT, "COPIA 2 Oasis Garden", "Un lugar silencioso y natural ",
"Oasis Garden en Miami, el alojamiento cuenta con terraza y espectaculares vistas",
530.50, 3, 3, 0, 26.107660, -80.136321, "870 Northeast 82nd Street, Miami, Estados Unidos"),
(DEFAULT, "COPIA 2 Novotel Sao Paulo Morumbi", "La búsqueda del hotel para familias ideal",
"Está cerca de la mayoría de los puntos de referencia de Sao Paulo. Acceso a playa",
1233.50, 3, 4, 1, -23.612995, -46.703499, "Nelson Hungria, 577 - Vila Tramontano, São Paulo, Brasil"),
(DEFAULT, "COPIA 2 Shinjuku", "Zona residencial Tranquila y con gran aspecto cultural de Japón",
"Casa cómoda y familiar, los niños osn bienvenidos. Cuenta con balcon con vista a la capital",
599.99, 4, 5, 1, 35.687749, 139.698145, "160-0022 Tokio, Shinjuku-ku Shijuku, Japón"),
(DEFAULT, "COPIA 2 NITRA-CAVIAHUE", "Hermoso hotel en la cordillera montañosa",
"Hotel situado en la cordillera de los andes, nevado casi todo el año",
6699.99, 4, 6, 1, -37.864645, -71.052088, "Los Ñires, Caviahue, Acceso cordillera Chile-Neuquen");



INSERT INTO caracteristicas() VALUES
(DEFAULT, "Aire-acondicionado", "https://cdn-icons-png.flaticon.com/512/1530/1530297.png"),
(DEFAULT, "Apto-mascotas", "https://cdn-icons-png.flaticon.com/512/1076/1076877.png"),
(DEFAULT, "Calefacción", "https://cdn-icons-png.flaticon.com/512/289/289759.png"),
(DEFAULT, "Bodega", "https://cdn-icons-png.flaticon.com/512/1832/1832506.png"),
(DEFAULT, "Cocina", "https://cdn-icons-png.flaticon.com/512/1698/1698640.png"),
(DEFAULT, "Estacionamiento", "https://cdn-icons-png.flaticon.com/512/708/708949.png"),
(DEFAULT, "Gimnasio", "https://cdn-icons-png.flaticon.com/512/1000/1000008.png"),
(DEFAULT, "Televisor", "https://cdn-icons-png.flaticon.com/512/942/942151.png"),
(DEFAULT, "Pileta", "https://cdn-icons-png.flaticon.com/512/2784/2784593.png"),
(DEFAULT, "Wifi", "https://cdn-icons-png.flaticon.com/512/2885/2885998.png");

INSERT INTO productos_caracteristicas() VALUES 
-- prod 1
(1,1),(1,2),(1,4),(1,6),(1,7),(1,8),(1,9),
-- prod 2
(2,1),(2,2),(2,3),(2,4),(2,5),(2,6),(2,7),(2,9),(2,10),
-- prod 3
(3,1),(3,3),(3,4),(3,6),(3,8),(3,10),
-- prod 4
(4,3),(4,4),(4,6),(4,7),(4,8),(4,9),(4,10),
-- prod 5
(5,1),(5,2),(5,4),(5,7),(5,9),(5,10),
-- prod 6
(6,2),(6,3),(6,5),(6,6),(6,7),(6,8),
-- prod 7
(7,2),(7,3),(7,4),(7,5),(7,6),(7,9),(7,10),
-- prod 8
(8,1),(8,2),(8,5),(8,6),(8,9),(8,10),

-- prod 9
(9,1),(9,2),(9,4),(9,6),(9,7),(9,8),(9,9),
-- prod 10
(10,1),(10,2),(10,3),(10,4),(10,5),(10,6),(10,7),(10,9),(10,10),
-- prod 11
(11,1),(11,3),(11,4),(11,6),(11,8),(11,10),
-- prod 12
(12,3),(12,4),(12,6),(12,7),(12,8),(12,9),(12,10),
-- prod 13
(13,1),(13,2),(13,4),(13,7),(13,9),(13,10),
-- prod 14
(14,2),(14,3),(14,5),(14,6),(14,7),(14,8),
-- prod 15
(15,2),(15,3),(15,4),(15,5),(15,6),(15,9),(15,10),
-- prod 16
(16,1),(16,2),(16,5),(16,6),(16,9),(16,10),

-- prod 17
(17,1),(17,2),(17,4),(17,6),(17,7),(17,8),(17,9),
-- prod 18
(18,1),(18,2),(18,3),(18,4),(18,5),(18,6),(18,7),(18,9),(18,10),
-- prod 19
(19,1),(19,3),(19,4),(19,6),(19,8),(19,10),
-- prod 20
(20,3),(20,4),(20,6),(20,7),(20,8),(20,9),(20,10),
-- prod 21
(21,1),(21,2),(21,4),(21,7),(21,9),(21,10),
-- prod 22
(22,2),(22,3),(22,5),(22,6),(22,7),(22,8),
-- prod 23
(23,2),(23,3),(23,4),(23,5),(23,6),(23,9),(23,10),
-- prod 24
(24,1),(24,2),(24,5),(24,6),(24,9),(24,10);

INSERT INTO tipoliticas() VALUES
(DEFAULT, "normas"),
(DEFAULT, "salud&seguridad"),
(DEFAULT, "cancelacion");


INSERT INTO politicas() VALUES
-- 1
(DEFAULT, "Fumar", "Se permite fumar en habitaciones asignadas", 1),
-- 2
(DEFAULT, "Fumar", "No se permite fumar", 1),
-- 3
(DEFAULT, "Check In", "Check-In: 10:00", 1),
-- 4
(DEFAULT, "Check In", "Check-In: 09:00", 1),
-- 5
(DEFAULT, "Check Out", "Check-Out: 12:00", 1),
-- 6
(DEFAULT, "Check Out", "Check-Out: 14:00", 1),
-- 7
(DEFAULT, "Fiestas", "No se permiten fiestas", 1),
-- 8
(DEFAULT, "Fiestas", "Se permiten fiestas solo en SUMs", 1),
-- 9
(DEFAULT, "Covid", "Se tienen en cuenta todas las medidas de salud dispuestas por el ministerio de salud de este pais", 2),
-- 10
(DEFAULT, "Detector Humo", "Habitaciones con detector de humo y sistemas anti incendios", 2),
-- 11
(DEFAULT, "Caja de Seguridad", "Cajas de seguridad en habitaciones asignadas", 2),
-- 12
(DEFAULT, "Caja de Seguridad", "Las habitaciones NO cuentan con cajas de seguridad", 2),
-- 13
(DEFAULT, "Cancelacion", "La cancelacion es sin costo con un aviso anticipado de 7 días como minimo, si esto no se cumple tiene un costo de $1500", 3),
-- 14
(DEFAULT, "Cancelacion", "La cancelacion será siempre del 50% del valor de la reserva, sin importar los días de previo aviso.", 3); 

INSERT INTO productos_politicas() VALUES
-- prod 1
(1, 1),(1, 3),(1, 5),(1, 7),(1, 9),(1, 10),(1, 11),(1, 13),
-- prod 2
(2, 2),(2, 4),(2, 6),(2, 8),(2, 12),(2, 14),
-- prod 3
(3, 1),(3, 3),(3, 5),(3, 7),(3, 9),(3, 11),(3, 13),
-- prod 4
(4, 2),(4, 4),(4, 6),(4, 8),(4, 10),(4, 12),(4, 14),
-- prod 5
(5, 1),(5, 3),(5, 5),(5, 7),(5, 11),(5, 13),
-- prod 6
(6, 2),(6, 4),(6, 6),(6, 8),(6, 9),(6, 12),(6, 14),
-- prod 7
(7, 1),(7, 3),(7, 5),(7, 7),(7, 10),(7, 11),(7, 13),
-- prod 8
(8, 2),(8, 4),(8, 6),(8, 8),(8, 9),(8, 10),(8, 12),(8, 14),

-- prod 9
(9, 1),(9, 3),(9, 5),(9, 7),(9, 9),(9, 10),(9, 11),(9, 13),
-- prod 10
(10, 2),(10, 4),(10, 6),(10, 8),(10, 12),(10, 14),
-- prod 11
(11, 1),(11, 3),(11, 5),(11, 7),(11, 9),(11, 11),(11, 13),
-- prod 12
(12, 2),(12, 4),(12, 6),(12, 8),(12, 10),(12, 12),(12, 14),
-- prod 13
(13, 1),(13, 3),(13, 5),(13, 7),(13, 11),(13, 13),
-- prod 14
(14, 2),(14, 4),(14, 6),(14, 8),(14, 9),(14, 12),(14, 14),
-- prod 15
(15, 1),(15, 3),(15, 5),(15, 7),(15, 10),(15, 11),(15, 13),
-- prod 16
(16, 2),(16, 4),(16, 6),(16, 8),(16, 9),(16, 10),(16, 12),(16, 14),

-- prod 17
(17, 1),(17, 3),(17, 5),(17, 7),(17, 9),(17, 10),(17, 11),(17, 13),
-- prod 18
(18, 2),(18, 4),(18, 6),(18, 8),(18, 12),(18, 14),
-- prod 19
(19, 1),(19, 3),(19, 5),(19, 7),(19, 9),(19, 11),(19, 13),
-- prod 20
(20, 2),(20, 4),(20, 6),(20, 8),(20, 10),(20, 12),(20, 14),
-- prod 21
(21, 1),(21, 3),(21, 5),(21, 7),(21, 11),(21, 13),
-- prod 22
(22, 2),(22, 4),(22, 6),(22, 8),(22, 9),(22, 12),(22, 14),
-- prod 23
(23, 1),(23, 3),(23, 5),(23, 7),(23, 10),(23, 11),(23, 13),
-- prod 24
(24, 2),(24, 4),(24, 6),(24, 8),(24, 9),(24, 10),(24, 12),(24, 14);


/*Ingreso imagenes de cada hotel*/
INSERT INTO imagenes() VALUES
-- Imagenes prod 1
(DEFAULT, "palaceHotel", "https://equipo10-digitalbooking-img.s3.us-east-2.amazonaws.com/img/The+Westing+Palace%2C+Madrid/PalaceHotel.jpg", 1),
(DEFAULT, "baño", "https://equipo10-digitalbooking-img.s3.us-east-2.amazonaws.com/img/The+Westing+Palace%2C+Madrid/Ba%C3%B1o.jpg", 1),
(DEFAULT, "habitacionSimple", "https://equipo10-digitalbooking-img.s3.us-east-2.amazonaws.com/img/The+Westing+Palace%2C+Madrid/HabitacionSimple.jpg", 1),
(DEFAULT, "suiteHotel", "https://equipo10-digitalbooking-img.s3.us-east-2.amazonaws.com/img/The+Westing+Palace%2C+Madrid/SuiteHotel.jpg", 1),
(DEFAULT, "livingSimple", "https://equipo10-digitalbooking-img.s3.us-east-2.amazonaws.com/img/The+Westing+Palace%2C+Madrid/LivingSimple.jpg", 1),
(DEFAULT, "livingSuite", "https://equipo10-digitalbooking-img.s3.us-east-2.amazonaws.com/img/The+Westing+Palace%2C+Madrid/LivingSuite.jpg", 1),
(DEFAULT, "lobby", "https://equipo10-digitalbooking-img.s3.us-east-2.amazonaws.com/img/The+Westing+Palace%2C+Madrid/Lobby.jpg", 1),
(DEFAULT, "restaurante", "https://equipo10-digitalbooking-img.s3.us-east-2.amazonaws.com/img/The+Westing+Palace%2C+Madrid/Restaurante.jpg", 1),

-- Imagenes prod 2
(DEFAULT, "internationalPalace", "https://equipo10-digitalbooking-img.s3.us-east-2.amazonaws.com/img/Exe+International+Palace%2C+Roma/InternationalPalace.jpg", 2),
(DEFAULT, "baño", "https://equipo10-digitalbooking-img.s3.us-east-2.amazonaws.com/img/Exe+International+Palace%2C+Roma/Ba%C3%B1o.jpg", 2),
(DEFAULT, "comidaRestaurante", "https://equipo10-digitalbooking-img.s3.us-east-2.amazonaws.com/img/Exe+International+Palace%2C+Roma/ComidaRestaurante.jpg", 2),
(DEFAULT, "habitacionSimple", "https://equipo10-digitalbooking-img.s3.us-east-2.amazonaws.com/img/Exe+International+Palace%2C+Roma/HabitacionSimple.jpg", 2),
(DEFAULT, "living", "https://equipo10-digitalbooking-img.s3.us-east-2.amazonaws.com/img/Exe+International+Palace%2C+Roma/Living.jpg", 2),
(DEFAULT, "recepcion", "https://equipo10-digitalbooking-img.s3.us-east-2.amazonaws.com/img/Exe+International+Palace%2C+Roma/Recepcion.jpg", 2),
(DEFAULT, "restaurante", "https://equipo10-digitalbooking-img.s3.us-east-2.amazonaws.com/img/Exe+International+Palace%2C+Roma/Restaurante.jpg", 2),
(DEFAULT, "terraza", "https://equipo10-digitalbooking-img.s3.us-east-2.amazonaws.com/img/Exe+International+Palace%2C+Roma/Terraza.jpg", 2),


-- Imagenes prod 3
(DEFAULT, "tukiHutHostel", "https://equipo10-digitalbooking-img.s3.us-east-2.amazonaws.com/img/Tuki+Hut+Hostel/TikiHutHostel.jpg", 3),
(DEFAULT, "entrada", "https://equipo10-digitalbooking-img.s3.us-east-2.amazonaws.com/img/Tuki+Hut+Hostel/Entrada.jpg", 3),
(DEFAULT, "baño", "https://equipo10-digitalbooking-img.s3.us-east-2.amazonaws.com/img/Tuki+Hut+Hostel/Ba%C3%B1o.jpg", 3),
(DEFAULT, "habitacionDoble", "https://equipo10-digitalbooking-img.s3.us-east-2.amazonaws.com/img/Tuki+Hut+Hostel/HabitacionDoble.jpg", 3),
(DEFAULT, "habitaciones", "https://equipo10-digitalbooking-img.s3.us-east-2.amazonaws.com/img/Tuki+Hut+Hostel/Habitaciones.jpg", 3),
(DEFAULT, "lobby", "https://equipo10-digitalbooking-img.s3.us-east-2.amazonaws.com/img/Tuki+Hut+Hostel/Lobby.jpg", 3),
(DEFAULT, "piscina", "https://equipo10-digitalbooking-img.s3.us-east-2.amazonaws.com/img/Tuki+Hut+Hostel/Piscina.jpg", 3),
(DEFAULT, "restaurante", "https://equipo10-digitalbooking-img.s3.us-east-2.amazonaws.com/img/Tuki+Hut+Hostel/Restaurante.jpg", 3),
-- Imagenes prod 4
(DEFAULT, "camarotes", "https://images.unsplash.com/photo-1520277739336-7bf67edfa768?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1032&q=80", 4),
(DEFAULT, "pileta", "https://images.unsplash.com/photo-1584132967334-10e028bd69f7?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=870&q=80", 4),
(DEFAULT, "ciudad colonial", "https://images.unsplash.com/photo-1615305211793-2b62059b8f27?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=870&q=80", 4),
(DEFAULT, "alcazar de colon", "https://images.unsplash.com/photo-1591879380423-7ea425d1024a?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1032&q=80", 4),
(DEFAULT, "ciudad colonial 2", "https://images.unsplash.com/photo-1588638260859-cf09d71423d8?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=387&q=80", 4),
(DEFAULT, "vista playa", "https://images.unsplash.com/photo-1612149328936-82e00c957816?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=774&q=80", 4),
(DEFAULT, "fray anton de montesinos", "https://images.unsplash.com/photo-1596397249129-c7a8f8718873?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=774&q=80", 4),
(DEFAULT, "frente", "https://images.unsplash.com/photo-1514600427175-13520b084fe3?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=435&q=80", 4),
-- Imagenes prod 5
(DEFAULT, "palmera", "https://images.unsplash.com/photo-1597535973747-951442d5dbc7?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=436&q=80", 5),
(DEFAULT, "calle", "https://images.unsplash.com/photo-1476984251899-8d7fdfc5c92c?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1032&q=80", 5),
(DEFAULT, "desde el agua", "https://images.unsplash.com/photo-1535498730771-e735b998cd64?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=387&q=80", 5),
(DEFAULT, "miami beach", "https://images.unsplash.com/photo-1603888613934-ee2f7d143dd0?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=387&q=80", 5),
(DEFAULT, "brickel", "https://images.unsplash.com/photo-1572875198816-5f48845774e4?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=426&q=80", 5),
(DEFAULT, "sala", "https://images.unsplash.com/photo-1616047006789-b7af5afb8c20?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=580&q=80", 5),
(DEFAULT, "vista", "https://images.unsplash.com/photo-1522195491553-dbda973beac4?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=774&q=80", 5),
(DEFAULT, "cocina", "https://images.unsplash.com/photo-1603072819161-e864800276cd?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=870&q=80", 5),
-- Imagenes prod 6
(DEFAULT, "avenida paulista", "https://images.unsplash.com/photo-1578002573559-689b0abc4148?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=435&q=80", 6),
(DEFAULT, "ciudad", "https://images.unsplash.com/photo-1554168848-228452c09d60?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1032&q=80", 6),
(DEFAULT, "edificios", "https://images.unsplash.com/photo-1585150841312-c833091e593d?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=435&q=80", 6),
(DEFAULT, "tren", "https://images.unsplash.com/photo-1578146189990-47cc6303db0d?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=347&q=80", 6),
(DEFAULT, "calle noche", "https://images.unsplash.com/photo-1643822264111-c715c9b6bf12?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=436&q=80", 6),
(DEFAULT, "correo", "https://images.unsplash.com/photo-1659783554222-24bb64cd9c00?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=812&q=80", 6),
(DEFAULT, "sala", "https://images.unsplash.com/photo-1615529179035-e760f6a2dcee?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=580&q=80", 6),
(DEFAULT, "habitacion", "https://images.unsplash.com/photo-1618220924273-338d82d6b886?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1032&q=80", 6),
-- Imagenes prod 7
(DEFAULT, "calle", "https://images.unsplash.com/photo-1570521462033-3015e76e7432?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=871&q=80", 7),
(DEFAULT, "sensoji temple", "https://images.unsplash.com/photo-1570543922355-c64a19ab2bc7?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=387&q=80", 7),
(DEFAULT, "nakano", "https://images.unsplash.com/photo-1584047959799-e457aef6f80f?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=387&q=80", 7),
(DEFAULT, "templo", "https://images.unsplash.com/photo-1583084647979-b53fbbc15e79?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=388&q=80", 7),
(DEFAULT, "japonia", "https://images.unsplash.com/photo-1610802752018-795027c7eca9?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=432&q=80", 7),
(DEFAULT, "ciudad", "https://images.unsplash.com/photo-1634110555127-12685786b487?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=870&q=80", 7),
(DEFAULT, "comedor", "https://images.unsplash.com/photo-1610375233775-6e0166927193?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=867&q=80", 7),
(DEFAULT, "cocina", "https://images.unsplash.com/photo-1639460942795-e6f65771998a?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=870&q=80", 7),
-- Imagenes prod 8
(DEFAULT, "caminata", "https://images.unsplash.com/photo-1660929543410-10e94b252d13?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=435&q=80", 8),
(DEFAULT, "goats", "https://images.unsplash.com/photo-1613443679338-679ba9799f15?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=327&q=80", 8),
(DEFAULT, "paisaje", "https://images.unsplash.com/photo-1623152108152-af30fd0c1738?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=870&q=80", 8),
(DEFAULT, "habitacion", "https://images.unsplash.com/photo-1551927411-95e412943b58?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=449&q=80", 8),
(DEFAULT, "frente", "https://images.unsplash.com/photo-1505322491781-b5b70b3f370c?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=387&q=80", 8),
(DEFAULT, "comedor", "https://images.unsplash.com/photo-1566662340221-f52df2e19ea4?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=435&q=80", 8),
(DEFAULT, "chimenea", "https://images.unsplash.com/photo-1585743792825-228b00d1f2b5?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=387&q=80", 8),
(DEFAULT, "sala", "https://images.unsplash.com/photo-1591825505254-45cf88639e38?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=387&q=80", 8),

-- Imagenes prod 9
(DEFAULT, "coliseo", "https://images.unsplash.com/photo-1604580864964-0462f5d5b1a8?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=870&q=80", 9),
(DEFAULT, "rio", "https://images.unsplash.com/photo-1529260830199-42c24126f198?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=876&q=80", 9),
(DEFAULT, "fuente", "https://images.unsplash.com/photo-1584999872814-569a6b02a2b4?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=327&q=80", 9),
(DEFAULT, "pizzeria", "https://images.unsplash.com/photo-1569230516306-5a8cb5586399?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=435&q=80", 9),
(DEFAULT, "foro", "https://images.unsplash.com/photo-1612271598100-5443d0095025?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=774&q=80", 9),
(DEFAULT, "callejon", "https://images.unsplash.com/photo-1614119075118-9cef9f9e61b9?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=387&q=80", 9),
(DEFAULT, "balcon", "https://images.unsplash.com/photo-1634633111558-e89fcca93333?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=387&q=80", 9),
(DEFAULT, "cama", "https://images.unsplash.com/photo-1444201983204-c43cbd584d93?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=870&q=80", 9),
-- Imagenes prod 10
(DEFAULT, "la gran via", "https://images.unsplash.com/photo-1539037116277-4db20889f2d4?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=870&q=80", 10),
(DEFAULT, "cibeles", "https://images.unsplash.com/photo-1578305698944-874fa44d04c9?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=388&q=80", 10),
(DEFAULT, "jeronimos", "https://images.unsplash.com/photo-1574556462575-eb106a5865a0?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=435&q=80", 10),
(DEFAULT, "calle", "https://images.unsplash.com/photo-1558370781-d6196949e317?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=879&q=80", 10),
(DEFAULT, "palacio de cristal", "https://images.unsplash.com/photo-1549310786-a634d453e653?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=436&q=80", 10),
(DEFAULT, "puerta del sol", "https://images.unsplash.com/photo-1562120679-3a7feddcb926?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=436&q=80", 10),
(DEFAULT, "balcon", "https://images.unsplash.com/photo-1559070656-ba1e87a7e61d?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=435&q=80", 10),
(DEFAULT, "cama", "https://images.unsplash.com/photo-1591088398332-8a7791972843?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=774&q=80", 10),
-- Imagenes prod 11
(DEFAULT, "yoga", "https://images.unsplash.com/photo-1506126613408-eca07ce68773?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=499&q=80", 11),
(DEFAULT, "palmera", "https://images.unsplash.com/photo-1626837540723-49f09996fde8?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=387&q=80", 11),
(DEFAULT, "bote", "https://images.unsplash.com/photo-1644849675855-b68e5370854c?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=872&q=80", 11),
(DEFAULT, "clase yoga", "https://images.unsplash.com/photo-1545205597-3d9d02c29597?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=870&q=80", 11),
(DEFAULT, "zona comun", "https://images.unsplash.com/photo-1661290597297-5897a3e1d03d?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1031&q=80", 11),
(DEFAULT, "camarotes", "https://images.unsplash.com/photo-1629794226066-349748040fb7?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=870&q=80", 11),
(DEFAULT, "camino", "https://images.unsplash.com/photo-1596796930385-0885a029049b?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=465&q=80", 11),
(DEFAULT, "pileta", "https://images.unsplash.com/photo-1506812428898-fe5a708f5359?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=387&q=80", 11),
-- Imagenes prod 12
(DEFAULT, "camarotes", "https://images.unsplash.com/photo-1520277739336-7bf67edfa768?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1032&q=80", 12),
(DEFAULT, "pileta", "https://images.unsplash.com/photo-1584132967334-10e028bd69f7?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=870&q=80", 12),
(DEFAULT, "ciudad colonial", "https://images.unsplash.com/photo-1615305211793-2b62059b8f27?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=870&q=80", 12),
(DEFAULT, "alcazar de colon", "https://images.unsplash.com/photo-1591879380423-7ea425d1024a?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1032&q=80", 12),
(DEFAULT, "ciudad colonial 2", "https://images.unsplash.com/photo-1588638260859-cf09d71423d8?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=387&q=80", 12),
(DEFAULT, "vista playa", "https://images.unsplash.com/photo-1612149328936-82e00c957816?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=774&q=80", 12),
(DEFAULT, "fray anton de montesinos", "https://images.unsplash.com/photo-1596397249129-c7a8f8718873?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=774&q=80", 12),
(DEFAULT, "frente", "https://images.unsplash.com/photo-1514600427175-13520b084fe3?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=435&q=80", 12),
-- Imagenes prod 13
(DEFAULT, "palmera", "https://images.unsplash.com/photo-1597535973747-951442d5dbc7?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=436&q=80", 13),
(DEFAULT, "calle", "https://images.unsplash.com/photo-1476984251899-8d7fdfc5c92c?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1032&q=80", 13),
(DEFAULT, "desde el agua", "https://images.unsplash.com/photo-1535498730771-e735b998cd64?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=387&q=80", 13),
(DEFAULT, "miami beach", "https://images.unsplash.com/photo-1603888613934-ee2f7d143dd0?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=387&q=80", 13),
(DEFAULT, "brickel", "https://images.unsplash.com/photo-1572875198816-5f48845774e4?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=426&q=80", 13),
(DEFAULT, "sala", "https://images.unsplash.com/photo-1616047006789-b7af5afb8c20?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=580&q=80", 13),
(DEFAULT, "vista", "https://images.unsplash.com/photo-1522195491553-dbda973beac4?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=774&q=80", 13),
(DEFAULT, "cocina", "https://images.unsplash.com/photo-1603072819161-e864800276cd?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=870&q=80", 13),
-- Imagenes prod 14
(DEFAULT, "avenida paulista", "https://images.unsplash.com/photo-1578002573559-689b0abc4148?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=435&q=80", 14),
(DEFAULT, "ciudad", "https://images.unsplash.com/photo-1554168848-228452c09d60?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1032&q=80", 14),
(DEFAULT, "edificios", "https://images.unsplash.com/photo-1585150841312-c833091e593d?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=435&q=80", 14),
(DEFAULT, "tren", "https://images.unsplash.com/photo-1578146189990-47cc6303db0d?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=347&q=80", 14),
(DEFAULT, "calle noche", "https://images.unsplash.com/photo-1643822264111-c715c9b6bf12?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=436&q=80", 14),
(DEFAULT, "correo", "https://images.unsplash.com/photo-1659783554222-24bb64cd9c00?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=812&q=80", 14),
(DEFAULT, "sala", "https://images.unsplash.com/photo-1615529179035-e760f6a2dcee?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=580&q=80", 14),
(DEFAULT, "habitacion", "https://images.unsplash.com/photo-1618220924273-338d82d6b886?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1032&q=80", 14),
-- Imagenes prod 15
(DEFAULT, "calle", "https://images.unsplash.com/photo-1570521462033-3015e76e7432?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=871&q=80", 15),
(DEFAULT, "sensoji temple", "https://images.unsplash.com/photo-1570543922355-c64a19ab2bc7?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=387&q=80", 15),
(DEFAULT, "nakano", "https://images.unsplash.com/photo-1584047959799-e457aef6f80f?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=387&q=80", 15),
(DEFAULT, "templo", "https://images.unsplash.com/photo-1583084647979-b53fbbc15e79?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=388&q=80", 15),
(DEFAULT, "japonia", "https://images.unsplash.com/photo-1610802752018-795027c7eca9?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=432&q=80", 15),
(DEFAULT, "ciudad", "https://images.unsplash.com/photo-1634110555127-12685786b487?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=870&q=80", 15),
(DEFAULT, "comedor", "https://images.unsplash.com/photo-1610375233775-6e0166927193?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=867&q=80", 15),
(DEFAULT, "cocina", "https://images.unsplash.com/photo-1639460942795-e6f65771998a?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=870&q=80", 15),
-- Imagenes prod 16
(DEFAULT, "caminata", "https://images.unsplash.com/photo-1660929543410-10e94b252d13?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=435&q=80", 16),
(DEFAULT, "goats", "https://images.unsplash.com/photo-1613443679338-679ba9799f15?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=327&q=80", 16),
(DEFAULT, "paisaje", "https://images.unsplash.com/photo-1623152108152-af30fd0c1738?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=870&q=80", 16),
(DEFAULT, "habitacion", "https://images.unsplash.com/photo-1551927411-95e412943b58?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=449&q=80", 16),
(DEFAULT, "frente", "https://images.unsplash.com/photo-1505322491781-b5b70b3f370c?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=387&q=80", 16),
(DEFAULT, "comedor", "https://images.unsplash.com/photo-1566662340221-f52df2e19ea4?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=435&q=80", 16),
(DEFAULT, "chimenea", "https://images.unsplash.com/photo-1585743792825-228b00d1f2b5?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=387&q=80", 16),
(DEFAULT, "sala", "https://images.unsplash.com/photo-1591825505254-45cf88639e38?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=387&q=80", 16),

-- Imagenes prod 17
(DEFAULT, "coliseo", "https://images.unsplash.com/photo-1604580864964-0462f5d5b1a8?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=870&q=80", 17),
(DEFAULT, "rio", "https://images.unsplash.com/photo-1529260830199-42c24126f198?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=876&q=80", 17),
(DEFAULT, "fuente", "https://images.unsplash.com/photo-1584999872814-569a6b02a2b4?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=327&q=80", 17),
(DEFAULT, "pizzeria", "https://images.unsplash.com/photo-1569230516306-5a8cb5586399?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=435&q=80", 17),
(DEFAULT, "foro", "https://images.unsplash.com/photo-1612271598100-5443d0095025?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=774&q=80", 17),
(DEFAULT, "callejon", "https://images.unsplash.com/photo-1614119075118-9cef9f9e61b9?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=387&q=80", 17),
(DEFAULT, "balcon", "https://images.unsplash.com/photo-1634633111558-e89fcca93333?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=387&q=80", 17),
(DEFAULT, "cama", "https://images.unsplash.com/photo-1444201983204-c43cbd584d93?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=870&q=80", 17),
-- Imagenes prod 18
(DEFAULT, "la gran via", "https://images.unsplash.com/photo-1539037116277-4db20889f2d4?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=870&q=80", 18),
(DEFAULT, "cibeles", "https://images.unsplash.com/photo-1578305698944-874fa44d04c9?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=388&q=80", 18),
(DEFAULT, "jeronimos", "https://images.unsplash.com/photo-1574556462575-eb106a5865a0?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=435&q=80", 18),
(DEFAULT, "calle", "https://images.unsplash.com/photo-1558370781-d6196949e317?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=879&q=80", 18),
(DEFAULT, "palacio de cristal", "https://images.unsplash.com/photo-1549310786-a634d453e653?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=436&q=80", 18),
(DEFAULT, "puerta del sol", "https://images.unsplash.com/photo-1562120679-3a7feddcb926?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=436&q=80", 18),
(DEFAULT, "balcon", "https://images.unsplash.com/photo-1559070656-ba1e87a7e61d?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=435&q=80", 18),
(DEFAULT, "cama", "https://images.unsplash.com/photo-1591088398332-8a7791972843?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=774&q=80", 18),
-- Imagenes prod 19
(DEFAULT, "yoga", "https://images.unsplash.com/photo-1506126613408-eca07ce68773?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=499&q=80", 19),
(DEFAULT, "palmera", "https://images.unsplash.com/photo-1626837540723-49f09996fde8?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=387&q=80", 19),
(DEFAULT, "bote", "https://images.unsplash.com/photo-1644849675855-b68e5370854c?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=872&q=80", 19),
(DEFAULT, "clase yoga", "https://images.unsplash.com/photo-1545205597-3d9d02c29597?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=870&q=80", 19),
(DEFAULT, "zona comun", "https://images.unsplash.com/photo-1661290597297-5897a3e1d03d?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1031&q=80", 19),
(DEFAULT, "camarotes", "https://images.unsplash.com/photo-1629794226066-349748040fb7?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=870&q=80", 19),
(DEFAULT, "camino", "https://images.unsplash.com/photo-1596796930385-0885a029049b?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=465&q=80", 19),
(DEFAULT, "pileta", "https://images.unsplash.com/photo-1506812428898-fe5a708f5359?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=387&q=80", 19),
-- Imagenes prod 20
(DEFAULT, "camarotes", "https://images.unsplash.com/photo-1520277739336-7bf67edfa768?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1032&q=80", 20),
(DEFAULT, "pileta", "https://images.unsplash.com/photo-1584132967334-10e028bd69f7?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=870&q=80", 20),
(DEFAULT, "ciudad colonial", "https://images.unsplash.com/photo-1615305211793-2b62059b8f27?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=870&q=80", 20),
(DEFAULT, "alcazar de colon", "https://images.unsplash.com/photo-1591879380423-7ea425d1024a?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1032&q=80", 20),
(DEFAULT, "ciudad colonial 2", "https://images.unsplash.com/photo-1588638260859-cf09d71423d8?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=387&q=80", 20),
(DEFAULT, "vista playa", "https://images.unsplash.com/photo-1612149328936-82e00c957816?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=774&q=80", 20),
(DEFAULT, "fray anton de montesinos", "https://images.unsplash.com/photo-1596397249129-c7a8f8718873?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=774&q=80", 20),
(DEFAULT, "frente", "https://images.unsplash.com/photo-1514600427175-13520b084fe3?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=435&q=80", 20),
-- Imagenes prod 21
(DEFAULT, "palmera", "https://images.unsplash.com/photo-1597535973747-951442d5dbc7?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=436&q=80", 21),
(DEFAULT, "calle", "https://images.unsplash.com/photo-1476984251899-8d7fdfc5c92c?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1032&q=80", 21),
(DEFAULT, "desde el agua", "https://images.unsplash.com/photo-1535498730771-e735b998cd64?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=387&q=80", 21),
(DEFAULT, "miami beach", "https://images.unsplash.com/photo-1603888613934-ee2f7d143dd0?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=387&q=80", 21),
(DEFAULT, "brickel", "https://images.unsplash.com/photo-1572875198816-5f48845774e4?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=426&q=80", 21),
(DEFAULT, "sala", "https://images.unsplash.com/photo-1616047006789-b7af5afb8c20?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=580&q=80", 21),
(DEFAULT, "vista", "https://images.unsplash.com/photo-1522195491553-dbda973beac4?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=774&q=80", 21),
(DEFAULT, "cocina", "https://images.unsplash.com/photo-1603072819161-e864800276cd?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=870&q=80", 21),
-- Imagenes prod 22
(DEFAULT, "avenida paulista", "https://images.unsplash.com/photo-1578002573559-689b0abc4148?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=435&q=80", 22),
(DEFAULT, "ciudad", "https://images.unsplash.com/photo-1554168848-228452c09d60?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1032&q=80", 22),
(DEFAULT, "edificios", "https://images.unsplash.com/photo-1585150841312-c833091e593d?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=435&q=80", 22),
(DEFAULT, "tren", "https://images.unsplash.com/photo-1578146189990-47cc6303db0d?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=347&q=80", 22),
(DEFAULT, "calle noche", "https://images.unsplash.com/photo-1643822264111-c715c9b6bf12?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=436&q=80", 22),
(DEFAULT, "correo", "https://images.unsplash.com/photo-1659783554222-24bb64cd9c00?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=812&q=80", 22),
(DEFAULT, "sala", "https://images.unsplash.com/photo-1615529179035-e760f6a2dcee?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=580&q=80", 22),
(DEFAULT, "habitacion", "https://images.unsplash.com/photo-1618220924273-338d82d6b886?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1032&q=80", 22),
-- Imagenes prod 23
(DEFAULT, "calle", "https://images.unsplash.com/photo-1570521462033-3015e76e7432?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=871&q=80", 23),
(DEFAULT, "sensoji temple", "https://images.unsplash.com/photo-1570543922355-c64a19ab2bc7?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=387&q=80", 23),
(DEFAULT, "nakano", "https://images.unsplash.com/photo-1584047959799-e457aef6f80f?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=387&q=80", 23),
(DEFAULT, "templo", "https://images.unsplash.com/photo-1583084647979-b53fbbc15e79?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=388&q=80", 23),
(DEFAULT, "japonia", "https://images.unsplash.com/photo-1610802752018-795027c7eca9?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=432&q=80", 23),
(DEFAULT, "ciudad", "https://images.unsplash.com/photo-1634110555127-12685786b487?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=870&q=80", 23),
(DEFAULT, "comedor", "https://images.unsplash.com/photo-1610375233775-6e0166927193?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=867&q=80", 23),
(DEFAULT, "cocina", "https://images.unsplash.com/photo-1639460942795-e6f65771998a?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=870&q=80", 23),
-- Imagenes prod 24
(DEFAULT, "caminata", "https://images.unsplash.com/photo-1660929543410-10e94b252d13?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=435&q=80", 24),
(DEFAULT, "goats", "https://images.unsplash.com/photo-1613443679338-679ba9799f15?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=327&q=80", 24),
(DEFAULT, "paisaje", "https://images.unsplash.com/photo-1623152108152-af30fd0c1738?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=870&q=80", 24),
(DEFAULT, "habitacion", "https://images.unsplash.com/photo-1551927411-95e412943b58?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=449&q=80", 24),
(DEFAULT, "frente", "https://images.unsplash.com/photo-1505322491781-b5b70b3f370c?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=387&q=80", 24),
(DEFAULT, "comedor", "https://images.unsplash.com/photo-1566662340221-f52df2e19ea4?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=435&q=80", 24),
(DEFAULT, "chimenea", "https://images.unsplash.com/photo-1585743792825-228b00d1f2b5?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=387&q=80", 24),
(DEFAULT, "sala", "https://images.unsplash.com/photo-1591825505254-45cf88639e38?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=387&q=80", 24);

INSERT INTO puntuaciones() VALUES
-- prod 1
(DEFAULT, 1, 5), (DEFAULT, 1, 4), (DEFAULT, 1, 5), (DEFAULT, 1, 4), (DEFAULT, 1, 5),
-- prod 2
(DEFAULT, 2, 4), (DEFAULT, 2, 3), (DEFAULT, 2, 5), (DEFAULT, 2, 4), (DEFAULT, 2, 4),
-- prod 3
(DEFAULT, 3, 3), (DEFAULT, 3, 4), (DEFAULT, 3, 5), (DEFAULT, 3, 2), (DEFAULT, 3, 5),
-- prod 4
(DEFAULT, 4, 2), (DEFAULT, 4, 3), (DEFAULT, 4, 4), (DEFAULT, 4, 5), (DEFAULT, 4, 5),
-- prod 5
(DEFAULT, 5, 1), (DEFAULT, 5, 2), (DEFAULT, 5, 4), (DEFAULT, 5, 4), (DEFAULT, 5, 3),
-- prod 6
(DEFAULT, 6, 4), (DEFAULT, 6, 3), (DEFAULT, 6, 4), (DEFAULT, 6, 3), (DEFAULT, 6, 4),
-- prod 7
(DEFAULT, 7, 5), (DEFAULT, 7, 4), (DEFAULT, 7, 4), (DEFAULT, 7, 3), (DEFAULT, 7, 4),
-- prod 8
(DEFAULT, 8, 3), (DEFAULT, 8, 4), (DEFAULT, 8, 4), (DEFAULT, 8, 4), (DEFAULT, 8, 5),

-- prod 9
(DEFAULT, 9, 5), (DEFAULT, 9, 4), (DEFAULT, 9, 5), (DEFAULT, 9, 4), (DEFAULT, 9, 5),
-- prod 10
(DEFAULT, 10, 4), (DEFAULT, 10, 3), (DEFAULT, 10, 5), (DEFAULT, 10, 4), (DEFAULT, 10, 4),
-- prod 11
(DEFAULT, 11, 3), (DEFAULT, 11, 4), (DEFAULT, 11, 5), (DEFAULT, 11, 2), (DEFAULT, 11, 5),
-- prod 12
(DEFAULT, 12, 2), (DEFAULT, 12, 3), (DEFAULT, 12, 4), (DEFAULT, 12, 5), (DEFAULT, 12, 5),
-- prod 13
(DEFAULT, 13, 1), (DEFAULT, 13, 2), (DEFAULT, 13, 4), (DEFAULT, 13, 4), (DEFAULT, 13, 3),
-- prod 14
(DEFAULT, 14, 4), (DEFAULT, 14, 3), (DEFAULT, 14, 4), (DEFAULT, 14, 3), (DEFAULT, 14, 4),
-- prod 15
(DEFAULT, 15, 5), (DEFAULT, 15, 4), (DEFAULT, 15, 4), (DEFAULT, 15, 3), (DEFAULT, 15, 4),
-- prod 16
(DEFAULT, 16, 3), (DEFAULT, 16, 4), (DEFAULT, 16, 4), (DEFAULT, 16, 4), (DEFAULT, 16, 5),

-- prod 17
(DEFAULT, 17, 5), (DEFAULT, 17, 4), (DEFAULT, 17, 5), (DEFAULT, 17, 4), (DEFAULT, 17, 5),
-- prod 18
(DEFAULT, 18, 4), (DEFAULT, 18, 3), (DEFAULT, 18, 5), (DEFAULT, 18, 4), (DEFAULT, 18, 4),
-- prod 19
(DEFAULT, 19, 3), (DEFAULT, 19, 4), (DEFAULT, 19, 5), (DEFAULT, 19, 2), (DEFAULT, 19, 5),
-- prod 20
(DEFAULT, 20, 2), (DEFAULT, 20, 3), (DEFAULT, 20, 4), (DEFAULT, 20, 5), (DEFAULT, 20, 5),
-- prod 21
(DEFAULT, 21, 1), (DEFAULT, 21, 2), (DEFAULT, 21, 4), (DEFAULT, 21, 4), (DEFAULT, 21, 3),
-- prod 22
(DEFAULT, 22, 4), (DEFAULT, 22, 3), (DEFAULT, 22, 4), (DEFAULT, 22, 3), (DEFAULT, 22, 4),
-- prod 23
(DEFAULT, 23, 5), (DEFAULT, 23, 4), (DEFAULT, 23, 4), (DEFAULT, 23, 3), (DEFAULT, 23, 4),
-- prod 24
(DEFAULT, 24, 3), (DEFAULT, 24, 4), (DEFAULT, 24, 4), (DEFAULT, 24, 4), (DEFAULT, 24, 5);