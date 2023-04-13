-- Carga de datos Categorías
 INSERT INTO categorias()
VALUES (DEFAULT, "Hotel",
"Establecimiento  capaz de alojar con comodidad a huéspedes o viajeros. Lugar perfecto para turistas",
"https://images.unsplash.com/photo-1517840901100-8179e982acb7?crop=entropy&cs=tinysrgb&fm=jpg&ixlib=rb-1.2.1&q=80&raw_url=true&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=870%27"),
(DEFAULT, "Hostel", "Un hostel es un tipo de alojamiento económico en el que poder compartir experiencias sociales.",
"https://images.unsplash.com/photo-1555854877-bab0e564b8d5?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=869&q=80"),
(DEFAULT, "Departamento", "Parte en que está dividido un recinto, local u otro espacio mediante paredes u otra separación.",
"https://images.unsplash.com/photo-1502672260266-1c1ef2d93688?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=780&q=80"),
(DEFAULT, "Bed and Breakfast", "Un bed and breakfast es un tipo de alojamiento sencillo en una casa o residencia privada, que ofrecen alojamiento barato y un desayuno.",
"https://images.unsplash.com/photo-1597776776684-61122dcf84e6?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=466&q=80"); 

 INSERT INTO ubicaciones()
VALUES
(DEFAULT, "Madrid", "España", "Europa"),
(DEFAULT, "Roma", "Italia", "Europa"),
(DEFAULT, "Miami", "Estados Unidos", "América"),
(DEFAULT, "Sao Paulo", "Brasil", "América"),
(DEFAULT, "Tokio", "Japón", "Asia"),
(DEFAULT, "Maule", "Chile", "America"),
(DEFAULT, "Palomino", "Colombia", "America"),
(DEFAULT, "Santo Domingo", "Republica Dominicana", "America"); 

INSERT INTO productos()
VALUES 
(DEFAULT, "The Westin Palace", "Hotel con una hermoza cupula de cristal",
"El Westin Palace tiene sus instalaciones a sólo  metros del Museo del Prado y del Reina Sofía",
1690, 1, 1, 1, 45.478593, 9.198967, "Plaza de las Cortes, 7, Madrid, España"),
(DEFAULT, "Exe International Palace", "Esta parte de Roma es su favorita",
"Un hermoso edificio del siglo XIX situado frente al Teatro de la Ópera de Roma",
649.99, 1, 2, 1, 41.900060, 12.492290, "Via Nazionale, 46, Roma RM, Italia"),
(DEFAULT, "Mood", "Ponte en mood",
"El establecimiento Mood esta muy bien situado en el centro de Palomino",
1500.00, 2, 7, 1,11.2270835,-73.5865292, "Cl. 2 #8-50, Palomino, Dibulla, La Guajira"),
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
6699.99, 4, 6, 1, -37.864645, -71.052088, "Los Ñires, Caviahue, Acceso cordillera Chile-Neuquen");

INSERT INTO caracteristicas()
VALUES
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

INSERT INTO productos_caracteristicas()
VALUES 
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
(8,1),(8,2),(8,5),(8,6),(8,9),(8,10);

INSERT INTO politicas()
VALUES
(DEFAULT, "fumar", "Se permite fumar en habitaciones asignadas"),
(DEFAULT, "nofumar", "No se permite fumar"),
(DEFAULT, "checkIn", "10:00"),
(DEFAULT, "checkIn", "09:00"),
(DEFAULT, "fiestas", "No se permiten fiestas"),
(DEFAULT, "fiestas", "Se permiten fiestas solo en SUMs"),
(DEFAULT, "covid", "Se tienen en cuenta todas las medidas de salud dispuestas por el ministerio de salud de este pais"),
(DEFAULT, "humo", "Habitaciones con detector de humo y sistemas anti incendios"),
(DEFAULT, "cajaDeSeguridad", "Cajas de seguridad en habitaciones asignadas"),
(DEFAULT, "noCajaDeSeguridad", "Las habitaciones NO cuentan con cajas de seguridad"),
(DEFAULT, "cancelacion1", "La cancelacion es sin costo con un aviso anticipado de 7 días como minimo, si esto no se cumple tiene un costo de $1500"),
(DEFAULT, "cancelacion2", "La cancelacion será siempre del 50% del valor de la reserva, sin importar los días de previo aviso."); 

INSERT INTO productos_politicas()
VALUES
-- prod 1
(1, 1),(1, 4),(1, 5),(1, 7),(1, 8),(1, 9),(1, 11),
-- prod 2
(2, 2),(2, 4),(2, 5),(2, 7),(2, 8),(2, 9),(2, 11),
-- prod 3
(3, 1),(3, 3),(3, 5),(3, 7),(3, 8),(3, 9),(3, 11),
-- prod 4
(4, 1),(4, 4),(4, 5),(4, 7),(4, 8),(4, 9),(4, 11),
-- prod 5
(5, 2),(5, 3),(5, 5),(5, 7),(5, 8),(5, 9),(5, 11),
-- prod 6
(6, 1),(6, 4),(6, 5),(6, 7),(6, 8),(6, 9),(6, 11),
-- prod 7
(7, 2),(7, 3),(7, 5),(7, 7),(7, 8),(7, 9),(7, 11),
-- prod 8
(8, 1),(8, 4),(8, 5),(8, 7),(8, 8),(8, 9),(8, 11);


/*Ingreso imagenes de cada hotel*/
-- Imagenes prod 1
INSERT INTO imagenes()
VALUES
(DEFAULT, "coliseo", "https://images.unsplash.com/photo-1604580864964-0462f5d5b1a8?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=870&q=80", 1),
(DEFAULT, "rio", "https://images.unsplash.com/photo-1529260830199-42c24126f198?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=876&q=80", 1),
(DEFAULT, "fuente", "https://images.unsplash.com/photo-1584999872814-569a6b02a2b4?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=327&q=80", 1),
(DEFAULT, "pizzeria", "https://images.unsplash.com/photo-1569230516306-5a8cb5586399?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=435&q=80", 1),
(DEFAULT, "foro", "https://images.unsplash.com/photo-1612271598100-5443d0095025?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=774&q=80", 1),
(DEFAULT, "callejon", "https://images.unsplash.com/photo-1614119075118-9cef9f9e61b9?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=387&q=80", 1),
(DEFAULT, "balcon", "https://images.unsplash.com/photo-1634633111558-e89fcca93333?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=387&q=80", 1),
(DEFAULT, "cama", "https://images.unsplash.com/photo-1444201983204-c43cbd584d93?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=870&q=80", 1);
-- Imagenes prod 2
INSERT INTO imagenes()
VALUES
(DEFAULT, "la gran via", "https://images.unsplash.com/photo-1539037116277-4db20889f2d4?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=870&q=80", 2),
(DEFAULT, "cibeles", "https://images.unsplash.com/photo-1578305698944-874fa44d04c9?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=388&q=80", 2),
(DEFAULT, "jeronimos", "https://images.unsplash.com/photo-1574556462575-eb106a5865a0?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=435&q=80", 2),
(DEFAULT, "calle", "https://images.unsplash.com/photo-1558370781-d6196949e317?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=879&q=80", 2),
(DEFAULT, "palacio de cristal", "https://images.unsplash.com/photo-1549310786-a634d453e653?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=436&q=80", 2),
(DEFAULT, "puerta del sol", "https://images.unsplash.com/photo-1562120679-3a7feddcb926?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=436&q=80", 2),
(DEFAULT, "balcon", "https://images.unsplash.com/photo-1559070656-ba1e87a7e61d?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=435&q=80", 2),
(DEFAULT, "cama", "https://images.unsplash.com/photo-1591088398332-8a7791972843?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=774&q=80", 2);
-- Imagenes prod 3
INSERT INTO imagenes()
VALUES
(DEFAULT, "yoga", "https://images.unsplash.com/photo-1506126613408-eca07ce68773?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=499&q=80", 3),
(DEFAULT, "palmera", "https://images.unsplash.com/photo-1626837540723-49f09996fde8?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=387&q=80", 3),
(DEFAULT, "bote", "https://images.unsplash.com/photo-1644849675855-b68e5370854c?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=872&q=80", 3),
(DEFAULT, "clase yoga", "https://images.unsplash.com/photo-1545205597-3d9d02c29597?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=870&q=80", 3),
(DEFAULT, "zona comun", "https://images.unsplash.com/photo-1661290597297-5897a3e1d03d?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1031&q=80", 3),
(DEFAULT, "camarotes", "https://images.unsplash.com/photo-1629794226066-349748040fb7?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=870&q=80", 3),
(DEFAULT, "camino", "https://images.unsplash.com/photo-1596796930385-0885a029049b?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=465&q=80", 3),
(DEFAULT, "pileta", "https://images.unsplash.com/photo-1506812428898-fe5a708f5359?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=387&q=80", 3);
-- Imagenes prod 4
INSERT INTO imagenes()
VALUES
(DEFAULT, "camarotes", "https://images.unsplash.com/photo-1520277739336-7bf67edfa768?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1032&q=80", 4),
(DEFAULT, "pileta", "https://images.unsplash.com/photo-1584132967334-10e028bd69f7?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=870&q=80", 4),
(DEFAULT, "ciudad colonial", "https://images.unsplash.com/photo-1615305211793-2b62059b8f27?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=870&q=80", 4),
(DEFAULT, "alcazar de colon", "https://images.unsplash.com/photo-1591879380423-7ea425d1024a?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1032&q=80", 4),
(DEFAULT, "ciudad colonial 2", "https://images.unsplash.com/photo-1588638260859-cf09d71423d8?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=387&q=80", 4),
(DEFAULT, "vista playa", "https://images.unsplash.com/photo-1612149328936-82e00c957816?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=774&q=80", 4),
(DEFAULT, "fray anton de montesinos", "https://images.unsplash.com/photo-1596397249129-c7a8f8718873?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=774&q=80", 4),
(DEFAULT, "frente", "https://images.unsplash.com/photo-1514600427175-13520b084fe3?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=435&q=80", 4);
-- Imagenes prod 5
INSERT INTO imagenes()
VALUES
(DEFAULT, "palmera", "https://images.unsplash.com/photo-1597535973747-951442d5dbc7?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=436&q=80", 5),
(DEFAULT, "calle", "https://images.unsplash.com/photo-1476984251899-8d7fdfc5c92c?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1032&q=80", 5),
(DEFAULT, "desde el agua", "https://images.unsplash.com/photo-1535498730771-e735b998cd64?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=387&q=80", 5),
(DEFAULT, "miami beach", "https://images.unsplash.com/photo-1603888613934-ee2f7d143dd0?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=387&q=80", 5),
(DEFAULT, "brickel", "https://images.unsplash.com/photo-1572875198816-5f48845774e4?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=426&q=80", 5),
(DEFAULT, "sala", "https://images.unsplash.com/photo-1616047006789-b7af5afb8c20?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=580&q=80", 5),
(DEFAULT, "vista", "https://images.unsplash.com/photo-1522195491553-dbda973beac4?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=774&q=80", 5),
(DEFAULT, "cocina", "https://images.unsplash.com/photo-1603072819161-e864800276cd?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=870&q=80", 5);
-- Imagenes prod 6
INSERT INTO imagenes()
VALUES
(DEFAULT, "avenida paulista", "https://images.unsplash.com/photo-1578002573559-689b0abc4148?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=435&q=80", 6),
(DEFAULT, "ciudad", "https://images.unsplash.com/photo-1554168848-228452c09d60?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1032&q=80", 6),
(DEFAULT, "edificios", "https://images.unsplash.com/photo-1585150841312-c833091e593d?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=435&q=80", 6),
(DEFAULT, "tren", "https://images.unsplash.com/photo-1578146189990-47cc6303db0d?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=347&q=80", 6),
(DEFAULT, "calle noche", "https://images.unsplash.com/photo-1643822264111-c715c9b6bf12?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=436&q=80", 6),
(DEFAULT, "correo", "https://images.unsplash.com/photo-1659783554222-24bb64cd9c00?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=812&q=80", 6),
(DEFAULT, "sala", "https://images.unsplash.com/photo-1615529179035-e760f6a2dcee?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=580&q=80", 6),
(DEFAULT, "habitacion", "https://images.unsplash.com/photo-1618220924273-338d82d6b886?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1032&q=80", 6);
-- Imagenes prod 7
INSERT INTO imagenes()
VALUES
(DEFAULT, "calle", "https://images.unsplash.com/photo-1570521462033-3015e76e7432?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=871&q=80", 7),
(DEFAULT, "sensoji temple", "https://images.unsplash.com/photo-1570543922355-c64a19ab2bc7?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=387&q=80", 7),
(DEFAULT, "nakano", "https://images.unsplash.com/photo-1584047959799-e457aef6f80f?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=387&q=80", 7),
(DEFAULT, "templo", "https://images.unsplash.com/photo-1583084647979-b53fbbc15e79?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=388&q=80", 7),
(DEFAULT, "japonia", "https://images.unsplash.com/photo-1610802752018-795027c7eca9?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=432&q=80", 7),
(DEFAULT, "ciudad", "https://images.unsplash.com/photo-1634110555127-12685786b487?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=870&q=80", 7),
(DEFAULT, "comedor", "https://images.unsplash.com/photo-1610375233775-6e0166927193?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=867&q=80", 7),
(DEFAULT, "cocina", "https://images.unsplash.com/photo-1639460942795-e6f65771998a?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=870&q=80", 7);
-- Imagenes prod 8
INSERT INTO imagenes()
VALUES
(DEFAULT, "caminata", "https://images.unsplash.com/photo-1660929543410-10e94b252d13?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=435&q=80", 8),
(DEFAULT, "goats", "https://images.unsplash.com/photo-1613443679338-679ba9799f15?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=327&q=80", 8),
(DEFAULT, "paisaje", "https://images.unsplash.com/photo-1623152108152-af30fd0c1738?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=870&q=80", 8),
(DEFAULT, "habitacion", "https://images.unsplash.com/photo-1551927411-95e412943b58?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=449&q=80", 8),
(DEFAULT, "frente", "https://images.unsplash.com/photo-1505322491781-b5b70b3f370c?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=387&q=80", 8),
(DEFAULT, "comedor", "https://images.unsplash.com/photo-1566662340221-f52df2e19ea4?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=435&q=80", 8),
(DEFAULT, "chimenea", "https://images.unsplash.com/photo-1585743792825-228b00d1f2b5?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=387&q=80", 8),
(DEFAULT, "sala", "https://images.unsplash.com/photo-1591825505254-45cf88639e38?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=387&q=80", 8);

INSERT INTO puntuaciones()
VALUES
/*Prod 1*/(DEFAULT, 1, 5), (DEFAULT, 1, 4), (DEFAULT, 1, 5), (DEFAULT, 1, 4), (DEFAULT, 1, 5),
/*Prod 2*/(DEFAULT, 2, 4), (DEFAULT, 2, 3), (DEFAULT, 2, 5), (DEFAULT, 2, 4), (DEFAULT, 2, 4),
/*Prod 3*/(DEFAULT, 3, 3), (DEFAULT, 3, 4), (DEFAULT, 3, 5), (DEFAULT, 3, 2), (DEFAULT, 3, 5),
/*Prod 4*/(DEFAULT, 4, 2), (DEFAULT, 4, 3), (DEFAULT, 4, 4), (DEFAULT, 4, 5), (DEFAULT, 4, 5),
/*Prod 5*/(DEFAULT, 5, 1), (DEFAULT, 5, 2), (DEFAULT, 5, 4), (DEFAULT, 5, 4), (DEFAULT, 5, 3),
/*Prod 6*/(DEFAULT, 6, 4), (DEFAULT, 6, 3), (DEFAULT, 6, 4), (DEFAULT, 6, 3), (DEFAULT, 6, 4),
/*Prod 7*/(DEFAULT, 7, 5), (DEFAULT, 7, 4), (DEFAULT, 7, 4), (DEFAULT, 7, 3), (DEFAULT, 7, 4),
/*Prod 8*/(DEFAULT, 8, 3), (DEFAULT, 8, 4), (DEFAULT, 8, 4), (DEFAULT, 8, 4), (DEFAULT, 8, 5);