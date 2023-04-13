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
(DEFAULT, "Santo Domingo", "Republica Dominicana", "America"),
(DEFAULT, "Zúrich", "Suiza", "Europa"),
(DEFAULT, "Moscú", "Rusia", "Asia"),
(DEFAULT, "Rio de Janeiro", "Brasil", "América"),
(DEFAULT, "Queenstown", "Nueva Zelanda", "Oceanía"),
(DEFAULT, "Machu Picchu", "Perú", "América"),
(DEFAULT, "Mykonos", "Grecia", "Europa"),
(DEFAULT, "La Paz", "Bolivia", "América"),
(DEFAULT, "Cancún", "México", "América"),
(DEFAULT, "Punta del Este", "Uruguay", "América");


INSERT INTO productos() VALUES 
(DEFAULT, "The Westin Palace", "Hotel con una hermoza cupula de cristal",
"El Westin Palace tiene sus instalaciones a sólo metros del Museo del Prado y del Reina Sofía",
1690, 1, 1, 45.478593, 9.198967, "Plaza de las Cortes, 7, Madrid, España", 2.6),
(DEFAULT, "Exe International Palace", "Esta parte de Roma es su favorita",
"Un hermoso edificio del siglo XIX situado frente al Teatro de la Ópera de Roma",
1649.99, 1, 2, 41.900060, 12.492290, "Via Nazionale, 46, Roma RM, Italia", 27.5),
(DEFAULT, "Tiki Hut Hostel", "Hostel muy cerca a pie de la playa de Palomino",
"Se pueden practicar gran variedad de actividades",
956.00, 2, 7, 11.253775282187135, -73.55686843150978, " Avenida Principal, 446009 Palomino, Colombia", 8.8),
(DEFAULT, "Island Life Hostel", "Grandiosa estadía en un hermoso lugar",
"Situado a 200 metros de la plaza Alcázar de Colón y a 350 metros del Museo de las Casas Reales",
753.99, 2, 8, 18.479187783617366, -69.88466004467861, "356 Isabel La Catolica, 10210 Santo Domingo, República", 5.3),
(DEFAULT, "Oasis Garden", "Un lugar silencioso y natural ",
"Oasis Garden en Miami, el alojamiento cuenta con terraza y espectaculares vistas",
530.50, 3, 3, 26.107660, -80.136321, "870 Northeast 82nd Street, Miami, Estados Unidos", 8.5),
(DEFAULT, "Novotel Sao Paulo Morumbi", "La búsqueda del hotel para familias ideal",
"Está cerca de la mayoría de los puntos de referencia de Sao Paulo. Acceso a playa",
1233.50, 3, 4, -23.612995, -46.703499, "Nelson Hungria, 577 - Vila Tramontano, São Paulo, Brasil", 3.2),
(DEFAULT, "Shinjuku", "Zona residencial Tranquila y con gran aspecto cultural de Japón",
"Casa cómoda y familiar, los niños osn bienvenidos. Cuenta con balcon con vista a la capital",
599.99, 4, 5, 35.687749, 139.698145, "160-0022 Tokio, Shinjuku-ku Shijuku, Japón", 30.1),
(DEFAULT, "NITRA-CAVIAHUE", "Hermoso hotel en la cordillera montañosa",
"Hotel situado en la cordillera de los andes, nevado casi todo el año",
6699.99, 4, 6, -37.864645, -71.052088, "Los Ñires, Caviahue, Acceso cordillera Chile-Neuquen", 40.2),
(DEFAULT, "CITY STAY - Lindenstrasse", "Apartamento en Zúrich",
"A 900 metros de la Ópera de Zurich",
877.00, 3, 9, 45.478593, 9.198967, "Lindenstrasse 32, Seefeld, 8008 Zúrich, Suiza", 2.1),
(DEFAULT, "KIGO Moscow City", "Apartamento 3 estrellas en Moscow City",
"El KIGO Moscow City se encuentra en Moscú, a 3,5 km de la calle Arbat y a 3,9 km del estadio Luzhniki",
649.99, 3, 10, 55.75522228873323, 37.537045110423605, "12 Presnenskaya Naberezhnaya, Presnensky, 123317 Moscú, Rusia", 0.2),
(DEFAULT, "Américas Benidorm Hotel", "Goza de vistas panorámicas al Cristo Redentor y al Pan de Azúcar",
"Se encuentra a poca distancia de la playa de Copacabana",
1350.00, 1, 11, -22.970881315493333, -43.18883999574896, "Rua Barata Ribeiro, 547, Copacabana, Río de Janeiro, CEP 22040-001, Brasil", 1.4),
(DEFAULT, "Queenstown House Boutique B&B", "Queenstown House Boutique Hotel & Apartments!",
"El Queenstown House está a solo 200 metros del centro de Queenstown. El establecimiento se encuentra a 400 metros de la bahía de Queenstown",
9333.99, 4, 12, -45.0287208175578, 168.6642158785727, "69 Hallenstein St, 9300 Queenstown, Nueva Zelanda", 5.5),
(DEFAULT, "Hostel New Way", "Se encuentra en Sao Paulo, a 3,2 km del pabellón Ciccillo Matarazzo",
"Cuenta con cocina compartida, salón compartido y wifi gratis en todas las instalaciones.",
530.50, 2, 4, -23.58521252815353, -46.61973914482894, "Rua Cláudio Rossi casa, Vila Mariana, São Paulo, CEP 01547-000, Brasil", 6.3),
(DEFAULT, "YellowSquare Rome", "Se encuentra a solo 10 minutos a pie de la estación de tren y metro de Termini",
"Dispone de restaurante gourmet, patio compartido y animación con DJ todas las noches",
875.50, 2, 2, 41.90488019413594, 12.504297811455286, "Via Palestro 51, Estación de Termini, 00185 Roma, Italia", 6.8),
(DEFAULT, "Comfy Home Koiwa", "El Comfy Home Koiwa se encuentra en Tokio, a 500 metros del santuario Daiju-in y a 600 metros del templo Tousenji.",
"Todas las habitaciones están equipadas con escritorio, TV de pantalla plana, baño privado, ropa de cama y toallas.",
599.99, 4, 5, 35.74376757067986, 139.88400001418663, "Prefectura de Tokio, Edogawa-ku Kitakoiwa 6-24-2, Japón", 7.1),
(DEFAULT, "Morar Apartments Malasaña", "Se encuentra a 400 metros de la Gran Vía y a 600 metros del centro.",
"Los alojamientos disponen de cocina totalmente equipada con mesa de comedor, TV de pantalla plana por cable y baño privado con ducha",
6699.99, 3, 1, 40.42294429990775, -3.7035897586646525, "33 Corredera Baja de San Pablo, Centro de Madrid, 28004 Madrid, España", 9.9),
(DEFAULT, "AZIMUT Hotel Olympic Moscow", "Este hotel de negocios de servicio completo está situado a 5 minutos a pie del estadio Olimpiski",
"Este hotel cuenta con centro de fitness, pileta cubierta, varias saunas, bañera de hidromasaje y servicio de masajes tailandeses",
1690, 1, 10, 55.7852405676966, 37.62405021316286, "Olympiski Prospekt 18/1, Meshchansky, 129110 Moscú, Rusia", 3.4),
(DEFAULT, "Hostel Estação Maracanã", "Se encuentra cerca de lugares de interés como el estadio Maracaná",
"El alojamiento cuenta con cocina compartida y WiFi gratuito.",
649.99, 2, 11, -22.915195431739175, -43.23036194737313, "Rua Visconde de Itamarati, 25, Río de Janeiro, CEP 20550-140, Brasil", 4.8),
(DEFAULT, "Pvt Bdrm, Close to Airport & Cruise Terminal", "Se encuentra en Miami, a 3 km del Museo Vizcaya y a 3,1 km del parque Marlins.",
"Alojamientos están equipados con aire acondicionado y artículos de aseo gratuitos y armario",
1500.00, 4, 3, 25.75388172523497, -80.2244086186343, "1941 Southwest 18th Avenue, Miami, FL 33145, Estados Unidos", 6.2),
(DEFAULT, "Supertramp Hostel Machupicchu", "Se encuentra en la región de Cusco, a 300 metros de las aguas termales de Machu Picchu",
"El alojamiento ofrece entretenimiento nocturno y un salón compartido",
753.99, 2, 13, -13.153413901640187, -72.52331590341231, "AV. PACHACUTEC 806, Machu Picchu, Perú", 5.5),
(DEFAULT, "Honey Bee House", "se encuentra a 1,5 km de la playa de Korfos y a 1,3 km de la playa de Megali Ammos.",
"El apartamento dispone de aire acondicionado, 1 dormitorio independiente, baño y cocina totalmente equipada con nevera y horno",
530.50, 3, 14, 37.43484728681954, 25.33502760206879, "Λαγκάδα, Mykonos ciudad, 84600, Grecia", 1.4),
(DEFAULT, "Luxstone Executive & Suites", "Alojamiento de 3 estrellas en La Paz, a 1 km de la estación de teleférico de Sopocachi",
"Servicio de enlace con el aeropuerto, cocina compartida y WiFi gratuita en todas las instalaciones",
1233.50, 1, 15, -16.507758102963646, -68.12643623271758, "Avenida 6 de Agosto entre Rozendo Gutierrez Edificio Torre Nº 2255, Zona Sopochi", 8.6),
(DEFAULT, "Bed and Breakfast Pecarí", "Está en el centro de Cancún, a 1,1 km del palacio de gobierno de Cancún y a 3 km de la playa",
"Todas las habitaciones cuentan con aire acondicionado y aparcamiento gratuito",
599.99, 4, 16, 21.15374540363214, -86.82646786105977, "Calle Pecari #31, 77500 Cancún, México", 4.3),
(DEFAULT, "Bellagio Tower New Apartments", "Se encuentra a 700 metros de la playa Mansa y a 800 metros del centro comercial",
"Cuenta con piscina cubierta y sauna con vistas al bosque, dispone de zona de comedor y cocina",
6699.99, 3, 17, -34.9286740069819, -54.94516630835366, "Av. Roosevelt esquina Salt Lake parada 14 , 20100 Punta del Este, Uruguay", 2.2);



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
(DEFAULT, "islandLifeHostel", "https://equipo10-digitalbooking-img.s3.us-east-2.amazonaws.com/img/Island+Life+Hostel/IslandLifeHostel.jpg", 4),
(DEFAULT, "baño", "https://equipo10-digitalbooking-img.s3.us-east-2.amazonaws.com/img/Island+Life+Hostel/Ba%C3%B1o.jpg", 4),
(DEFAULT, "habitacion", "https://equipo10-digitalbooking-img.s3.us-east-2.amazonaws.com/img/Island+Life+Hostel/Habitacion.jpg", 4),
(DEFAULT, "lobby", "https://equipo10-digitalbooking-img.s3.us-east-2.amazonaws.com/img/Island+Life+Hostel/Lobby.jpg", 4),
(DEFAULT, "patio", "https://equipo10-digitalbooking-img.s3.us-east-2.amazonaws.com/img/Island+Life+Hostel/Patio.jpg", 4),
(DEFAULT, "piscina", "https://equipo10-digitalbooking-img.s3.us-east-2.amazonaws.com/img/Island+Life+Hostel/Piscina.jpg", 4),
(DEFAULT, "islandLifeHostel", "https://equipo10-digitalbooking-img.s3.us-east-2.amazonaws.com/img/Island+Life+Hostel/IslandLifeHostel.jpg", 4),
(DEFAULT, "islandLifeHostel", "https://equipo10-digitalbooking-img.s3.us-east-2.amazonaws.com/img/Island+Life+Hostel/IslandLifeHostel.jpg", 4),
-- Imagenes prod 5
(DEFAULT, "entrada", "https://equipo10-digitalbooking-img.s3.us-east-2.amazonaws.com/img/Oasis+Garden/Entrada.jpg", 5),
(DEFAULT, "baño", "https://equipo10-digitalbooking-img.s3.us-east-2.amazonaws.com/img/Oasis+Garden/Ba%C3%B1o.jpg", 5),
(DEFAULT, "comedor", "https://equipo10-digitalbooking-img.s3.us-east-2.amazonaws.com/img/Oasis+Garden/Comedor.jpg", 5),
(DEFAULT, "gym", "https://equipo10-digitalbooking-img.s3.us-east-2.amazonaws.com/img/Oasis+Garden/Gym.jpg", 5),
(DEFAULT, "habitacion", "https://equipo10-digitalbooking-img.s3.us-east-2.amazonaws.com/img/Oasis+Garden/Habitacion.jpg", 5),
(DEFAULT, "living", "https://equipo10-digitalbooking-img.s3.us-east-2.amazonaws.com/img/Oasis+Garden/Living.jpg", 5),
(DEFAULT, "patio", "https://equipo10-digitalbooking-img.s3.us-east-2.amazonaws.com/img/Oasis+Garden/Patio.jpg", 5),
(DEFAULT, "piscina", "https://equipo10-digitalbooking-img.s3.us-east-2.amazonaws.com/img/Oasis+Garden/Piscina.jpg", 5),
-- Imagenes prod 6
(DEFAULT, "novotelSaoPaulo", "https://equipo10-digitalbooking-img.s3.us-east-2.amazonaws.com/img/Novotel+Sao+Paulo/NovotelSaoPaulo.jpg", 6),
(DEFAULT, "habitacion", "https://equipo10-digitalbooking-img.s3.us-east-2.amazonaws.com/img/Novotel+Sao+Paulo/Habitacion.jpg", 6),
(DEFAULT, "habitacionDoble", "https://equipo10-digitalbooking-img.s3.us-east-2.amazonaws.com/img/Novotel+Sao+Paulo/HabitacionDoble.jpg", 6),
(DEFAULT, "lobby", "https://equipo10-digitalbooking-img.s3.us-east-2.amazonaws.com/img/Novotel+Sao+Paulo/Lobby.jpg", 6),
(DEFAULT, "outdoors", "https://equipo10-digitalbooking-img.s3.us-east-2.amazonaws.com/img/Novotel+Sao+Paulo/Outdoors.jpg", 6),
(DEFAULT, "piscina", "https://equipo10-digitalbooking-img.s3.us-east-2.amazonaws.com/img/Novotel+Sao+Paulo/Piscina.jpg", 6),
(DEFAULT, "baño", "https://equipo10-digitalbooking-img.s3.us-east-2.amazonaws.com/img/Novotel+Sao+Paulo/Ba%C3%B1o.jpg", 6),
(DEFAULT, "restaurante2", "https://equipo10-digitalbooking-img.s3.us-east-2.amazonaws.com/img/Novotel+Sao+Paulo/Restaurante2.jpg", 6),
-- Imagenes prod 7
(DEFAULT, "mimaruShinjukuWest", "https://equipo10-digitalbooking-img.s3.us-east-2.amazonaws.com/img/Mimaru+Tokyo+Shinjuku+West/MimaruShinjukuWest.jpg", 7),
(DEFAULT, "baño", "https://equipo10-digitalbooking-img.s3.us-east-2.amazonaws.com/img/Mimaru+Tokyo+Shinjuku+West/Ba%C3%B1o.jpg", 7),
(DEFAULT, "breakfast", "https://equipo10-digitalbooking-img.s3.us-east-2.amazonaws.com/img/Mimaru+Tokyo+Shinjuku+West/Breakfast.jpg", 7),
(DEFAULT, "habitacion", "https://equipo10-digitalbooking-img.s3.us-east-2.amazonaws.com/img/Mimaru+Tokyo+Shinjuku+West/Habitacion.jpg", 7),
(DEFAULT, "living", "https://equipo10-digitalbooking-img.s3.us-east-2.amazonaws.com/img/Mimaru+Tokyo+Shinjuku+West/Living.jpg", 7),
(DEFAULT, "lobby", "https://equipo10-digitalbooking-img.s3.us-east-2.amazonaws.com/img/Mimaru+Tokyo+Shinjuku+West/Lobby.jpg", 7),
(DEFAULT, "recepcion", "https://equipo10-digitalbooking-img.s3.us-east-2.amazonaws.com/img/Mimaru+Tokyo+Shinjuku+West/Recepcion.jpg", 7),
(DEFAULT, "terraza", "https://equipo10-digitalbooking-img.s3.us-east-2.amazonaws.com/img/Mimaru+Tokyo+Shinjuku+West/Terraza.jpg", 7),
-- Imagenes prod 8
(DEFAULT, "nitraCaviahue", "https://equipo10-digitalbooking-img.s3.us-east-2.amazonaws.com/img/Nitra+Caviahue%2C+Neuquen/NitraCaviahue.jpg", 8),
(DEFAULT, "baño", "https://equipo10-digitalbooking-img.s3.us-east-2.amazonaws.com/img/Nitra+Caviahue%2C+Neuquen/Ba%C3%B1o.jpg", 8),
(DEFAULT, "habitacion", "https://equipo10-digitalbooking-img.s3.us-east-2.amazonaws.com/img/Nitra+Caviahue%2C+Neuquen/Habitacion.jpg", 8),
(DEFAULT, "habitacion2", "https://equipo10-digitalbooking-img.s3.us-east-2.amazonaws.com/img/Nitra+Caviahue%2C+Neuquen/Habitacion2.jpg", 8),
(DEFAULT, "lobby", "https://equipo10-digitalbooking-img.s3.us-east-2.amazonaws.com/img/Nitra+Caviahue%2C+Neuquen/Lobby.jpg", 8),
(DEFAULT, "sala", "https://equipo10-digitalbooking-img.s3.us-east-2.amazonaws.com/img/Nitra+Caviahue%2C+Neuquen/Sala.jpg", 8),
(DEFAULT, "vista", "https://equipo10-digitalbooking-img.s3.us-east-2.amazonaws.com/img/Nitra+Caviahue%2C+Neuquen/Vista.jpg", 8),
(DEFAULT, "vista2", "https://equipo10-digitalbooking-img.s3.us-east-2.amazonaws.com/img/Nitra+Caviahue%2C+Neuquen/Vista2.jpg", 8),
-- Imagenes prod 9
(DEFAULT, "apartmentLindenstrasse", "https://equipo10-digitalbooking-img.s3.us-east-2.amazonaws.com/img/City+Stay+Lindenstrasse/ApartmentLindenstrasse.jpg", 9),
(DEFAULT, "baño", "https://equipo10-digitalbooking-img.s3.us-east-2.amazonaws.com/img/City+Stay+Lindenstrasse/Ba%C3%B1o.jpg", 9),
(DEFAULT, "cocina", "https://equipo10-digitalbooking-img.s3.us-east-2.amazonaws.com/img/City+Stay+Lindenstrasse/Cocina.jpg", 9),
(DEFAULT, "cocina2", "https://equipo10-digitalbooking-img.s3.us-east-2.amazonaws.com/img/City+Stay+Lindenstrasse/Cocina2.jpg", 9),
(DEFAULT, "habitacion", "https://equipo10-digitalbooking-img.s3.us-east-2.amazonaws.com/img/City+Stay+Lindenstrasse/Habitacion.jpg", 9),
(DEFAULT, "habitacion2", "https://equipo10-digitalbooking-img.s3.us-east-2.amazonaws.com/img/City+Stay+Lindenstrasse/Habitacion2.jpg", 9),
(DEFAULT, "living", "https://equipo10-digitalbooking-img.s3.us-east-2.amazonaws.com/img/City+Stay+Lindenstrasse/Living.jpg", 9),
(DEFAULT, "living2", "https://equipo10-digitalbooking-img.s3.us-east-2.amazonaws.com/img/City+Stay+Lindenstrasse/Living2.jpg", 9),
-- Imagenes prod 10
(DEFAULT, "Kigo", "https://equipo10-digitalbooking-img.s3.us-east-2.amazonaws.com/img/KIGO+Moscow+City/Kigo.jpg", 10),
(DEFAULT, "baño", "https://equipo10-digitalbooking-img.s3.us-east-2.amazonaws.com/img/KIGO+Moscow+City/Ba%C3%B1o.jpg", 10),
(DEFAULT, "cocina", "https://equipo10-digitalbooking-img.s3.us-east-2.amazonaws.com/img/KIGO+Moscow+City/Cocina.jpg", 10),
(DEFAULT, "comedor", "https://equipo10-digitalbooking-img.s3.us-east-2.amazonaws.com/img/KIGO+Moscow+City/Comedor.jpg", 10),
(DEFAULT, "comedor2", "https://equipo10-digitalbooking-img.s3.us-east-2.amazonaws.com/img/KIGO+Moscow+City/Comedor2.jpg", 10),
(DEFAULT, "comedorLiving", "https://equipo10-digitalbooking-img.s3.us-east-2.amazonaws.com/img/KIGO+Moscow+City/HabitacionLiving.jpg", 10),
(DEFAULT, "living", "https://equipo10-digitalbooking-img.s3.us-east-2.amazonaws.com/img/KIGO+Moscow+City/Living.jpg", 10),
(DEFAULT, "salaEstar", "https://equipo10-digitalbooking-img.s3.us-east-2.amazonaws.com/img/KIGO+Moscow+City/SalaEstar.jpg", 10),
-- Imagenes prod 11
(DEFAULT, "benidormHotel", "https://equipo10-digitalbooking-img.s3.us-east-2.amazonaws.com/img/Am%C3%A9ricas+Benidorm+Hotel/BenidormHotel.jpg", 11),
(DEFAULT, "baño", "https://equipo10-digitalbooking-img.s3.us-east-2.amazonaws.com/img/Am%C3%A9ricas+Benidorm+Hotel/Ba%C3%B1o.jpg", 11),
(DEFAULT, "gym", "https://equipo10-digitalbooking-img.s3.us-east-2.amazonaws.com/img/Am%C3%A9ricas+Benidorm+Hotel/Gym.jpg", 11),
(DEFAULT, "habitacion", "https://equipo10-digitalbooking-img.s3.us-east-2.amazonaws.com/img/Am%C3%A9ricas+Benidorm+Hotel/Habitacion.jpg", 11),
(DEFAULT, "terraza", "https://equipo10-digitalbooking-img.s3.us-east-2.amazonaws.com/img/Queenstown+House+Boutique+Hotel+%26+Apartments/Terraza.jpg", 11),
(DEFAULT, "restaurante", "https://equipo10-digitalbooking-img.s3.us-east-2.amazonaws.com/img/Am%C3%A9ricas+Benidorm+Hotel/Restaurante.jpg", 11),
(DEFAULT, "salaEstar", "https://equipo10-digitalbooking-img.s3.us-east-2.amazonaws.com/img/Am%C3%A9ricas+Benidorm+Hotel/SalaEstar.jpg", 11),
(DEFAULT, "terraza", "https://equipo10-digitalbooking-img.s3.us-east-2.amazonaws.com/img/Am%C3%A9ricas+Benidorm+Hotel/Terraza.jpg", 11),
-- Imagenes prod 12
(DEFAULT, "QueenstownB&B", "https://equipo10-digitalbooking-img.s3.us-east-2.amazonaws.com/img/Queenstown+House+Boutique+Hotel+%26+Apartments/QueenstownB%26B.jpg", 12),
(DEFAULT, "baño", "https://equipo10-digitalbooking-img.s3.us-east-2.amazonaws.com/img/Queenstown+House+Boutique+Hotel+%26+Apartments/Ba%C3%B1o.jpg", 12),
(DEFAULT, "habitacion", "https://equipo10-digitalbooking-img.s3.us-east-2.amazonaws.com/img/Queenstown+House+Boutique+Hotel+%26+Apartments/Habitacion.jpg", 12),
(DEFAULT, "habitacion2", "https://equipo10-digitalbooking-img.s3.us-east-2.amazonaws.com/img/Queenstown+House+Boutique+Hotel+%26+Apartments/Habitacion2.jpg", 12),
(DEFAULT, "living", "https://equipo10-digitalbooking-img.s3.us-east-2.amazonaws.com/img/Queenstown+House+Boutique+Hotel+%26+Apartments/Living.jpg", 12),
(DEFAULT, "living2", "https://equipo10-digitalbooking-img.s3.us-east-2.amazonaws.com/img/Queenstown+House+Boutique+Hotel+%26+Apartments/Living2.jpg", 12),
(DEFAULT, "terraza", "https://equipo10-digitalbooking-img.s3.us-east-2.amazonaws.com/img/Queenstown+House+Boutique+Hotel+%26+Apartments/Terraza.jpg", 12),
(DEFAULT, "patio", "https://equipo10-digitalbooking-img.s3.us-east-2.amazonaws.com/img/Queenstown+House+Boutique+Hotel+%26+Apartments/Patio.jpg", 12),
-- Imagenes prod 13
(DEFAULT, "hostelNewWay", "https://equipo10-digitalbooking-img.s3.us-east-2.amazonaws.com/img/Hostel+New+Way/HostelNewWay.jpg", 13),
(DEFAULT, "baño", "https://equipo10-digitalbooking-img.s3.us-east-2.amazonaws.com/img/Hostel+New+Way/Ba%C3%B1o.jpg", 13),
(DEFAULT, "entrada", "https://equipo10-digitalbooking-img.s3.us-east-2.amazonaws.com/img/Hostel+New+Way/Entrada.jpg", 13),
(DEFAULT, "habitaciones", "https://equipo10-digitalbooking-img.s3.us-east-2.amazonaws.com/img/Hostel+New+Way/Habitaciones.jpg", 13),
(DEFAULT, "living", "https://equipo10-digitalbooking-img.s3.us-east-2.amazonaws.com/img/Hostel+New+Way/Living.jpg", 13),
(DEFAULT, "lobby", "https://equipo10-digitalbooking-img.s3.us-east-2.amazonaws.com/img/Hostel+New+Way/Lobby.jpg", 13),
(DEFAULT, "patio2", "https://equipo10-digitalbooking-img.s3.us-east-2.amazonaws.com/img/Hostel+New+Way/Patio2.jpg", 13),
(DEFAULT, "patioInterno", "https://equipo10-digitalbooking-img.s3.us-east-2.amazonaws.com/img/Hostel+New+Way/PatioInterno.jpg", 13),
-- Imagenes prod 14
(DEFAULT, "yellowSquareRome", "https://equipo10-digitalbooking-img.s3.us-east-2.amazonaws.com/img/YellowSquare+Rome/YellowSquareRome.jpg", 14),
(DEFAULT, "animacionDj", "https://equipo10-digitalbooking-img.s3.us-east-2.amazonaws.com/img/YellowSquare+Rome/AnimacionDj.jpg", 14),
(DEFAULT, "entrada", "https://equipo10-digitalbooking-img.s3.us-east-2.amazonaws.com/img/YellowSquare+Rome/Entrada.jpg", 14),
(DEFAULT, "habitacion", "https://equipo10-digitalbooking-img.s3.us-east-2.amazonaws.com/img/YellowSquare+Rome/Habitacion.jpg", 14),
(DEFAULT, "habitacion2", "https://equipo10-digitalbooking-img.s3.us-east-2.amazonaws.com/img/YellowSquare+Rome/Habitacion2.jpg", 14),
(DEFAULT, "patioInterno", "https://equipo10-digitalbooking-img.s3.us-east-2.amazonaws.com/img/YellowSquare+Rome/PatioInterno.jpg", 14),
(DEFAULT, "recepcion", "https://equipo10-digitalbooking-img.s3.us-east-2.amazonaws.com/img/YellowSquare+Rome/Recepcion.jpg", 14),
(DEFAULT, "restaurante", "https://equipo10-digitalbooking-img.s3.us-east-2.amazonaws.com/img/YellowSquare+Rome/Restaurante.jpg", 14),
-- Imagenes prod 15
(DEFAULT, "comfyHomeKoiwa", "https://equipo10-digitalbooking-img.s3.us-east-2.amazonaws.com/img/Comfy+Home+Koiwa/Comfy+Home+Koiwa.jpg", 15),
(DEFAULT, "baño", "https://equipo10-digitalbooking-img.s3.us-east-2.amazonaws.com/img/Comfy+Home+Koiwa/Ba%C3%B1o.jpg", 15),
(DEFAULT, "baño2", "https://equipo10-digitalbooking-img.s3.us-east-2.amazonaws.com/img/Comfy+Home+Koiwa/Ba%C3%B1o2.jpg", 15),
(DEFAULT, "cocina", "https://equipo10-digitalbooking-img.s3.us-east-2.amazonaws.com/img/Comfy+Home+Koiwa/Cocina.jpg", 15),
(DEFAULT, "habitacion", "https://equipo10-digitalbooking-img.s3.us-east-2.amazonaws.com/img/Comfy+Home+Koiwa/Habitacion.jpg", 15),
(DEFAULT, "living", "https://equipo10-digitalbooking-img.s3.us-east-2.amazonaws.com/img/Comfy+Home+Koiwa/Living.jpg", 15),
(DEFAULT, "planoDpto", "https://equipo10-digitalbooking-img.s3.us-east-2.amazonaws.com/img/Comfy+Home+Koiwa/PlanoDpto.jpg", 15),
(DEFAULT, "salaEstar", "https://equipo10-digitalbooking-img.s3.us-east-2.amazonaws.com/img/Comfy+Home+Koiwa/SalaDeEstar.jpg", 15),
-- Imagenes prod 16
(DEFAULT, "MorarApartments", "https://equipo10-digitalbooking-img.s3.us-east-2.amazonaws.com/img/Morar+Apartments+Malasa%C3%B1a/MorarApartmentsMalasa%C3%B1a.jpg", 16),
(DEFAULT, "baño", "https://equipo10-digitalbooking-img.s3.us-east-2.amazonaws.com/img/Morar+Apartments+Malasa%C3%B1a/Ba%C3%B1o.jpg", 16),
(DEFAULT, "cocina", "https://equipo10-digitalbooking-img.s3.us-east-2.amazonaws.com/img/Morar+Apartments+Malasa%C3%B1a/Cocina.jpg", 16),
(DEFAULT, "comedor", "https://equipo10-digitalbooking-img.s3.us-east-2.amazonaws.com/img/Morar+Apartments+Malasa%C3%B1a/Comedor.jpg", 16),
(DEFAULT, "habitacion", "https://equipo10-digitalbooking-img.s3.us-east-2.amazonaws.com/img/Morar+Apartments+Malasa%C3%B1a/Habitacion.jpg", 16),
(DEFAULT, "habitacion2", "https://equipo10-digitalbooking-img.s3.us-east-2.amazonaws.com/img/Morar+Apartments+Malasa%C3%B1a/Habitacion2.jpg", 16),
(DEFAULT, "living", "https://equipo10-digitalbooking-img.s3.us-east-2.amazonaws.com/img/Morar+Apartments+Malasa%C3%B1a/Living.jpg", 16),
(DEFAULT, "living2", "https://equipo10-digitalbooking-img.s3.us-east-2.amazonaws.com/img/Morar+Apartments+Malasa%C3%B1a/Living2.jpg", 16),
-- Imagenes prod 17
(DEFAULT, "azimutHotelOlympicMoscow", "https://equipo10-digitalbooking-img.s3.us-east-2.amazonaws.com/img/AZIMUT+Hotel+Olympic+Moscow/AZIMUTHotelOlympicMoscow.jpg", 17),
(DEFAULT, "baño", "https://equipo10-digitalbooking-img.s3.us-east-2.amazonaws.com/img/AZIMUT+Hotel+Olympic+Moscow/Ba%C3%B1o.jpg", 17),
(DEFAULT, "comedor", "https://equipo10-digitalbooking-img.s3.us-east-2.amazonaws.com/img/AZIMUT+Hotel+Olympic+Moscow/Comedor.jpg", 17),
(DEFAULT, "gym", "https://equipo10-digitalbooking-img.s3.us-east-2.amazonaws.com/img/AZIMUT+Hotel+Olympic+Moscow/Gym.jpg", 17),
(DEFAULT, "habitacion", "https://equipo10-digitalbooking-img.s3.us-east-2.amazonaws.com/img/AZIMUT+Hotel+Olympic+Moscow/Habitacion.jpg", 17),
(DEFAULT, "living", "https://equipo10-digitalbooking-img.s3.us-east-2.amazonaws.com/img/AZIMUT+Hotel+Olympic+Moscow/Living.jpg", 17),
(DEFAULT, "piscina", "https://equipo10-digitalbooking-img.s3.us-east-2.amazonaws.com/img/AZIMUT+Hotel+Olympic+Moscow/Piscina.jpg", 17),
(DEFAULT, "restaurante", "https://equipo10-digitalbooking-img.s3.us-east-2.amazonaws.com/img/AZIMUT+Hotel+Olympic+Moscow/Restaurante.jpg", 17),
-- Imagenes prod 18
(DEFAULT, "hostelEstacaoMaracana", "https://equipo10-digitalbooking-img.s3.us-east-2.amazonaws.com/img/Hostel+Esta%C3%A7%C3%A3o+Maracan%C3%A3/HostelEsta%C3%A7%C3%A3oMaracan%C3%A3.jpg", 18),
(DEFAULT, "cocina", "https://equipo10-digitalbooking-img.s3.us-east-2.amazonaws.com/img/Hostel+Esta%C3%A7%C3%A3o+Maracan%C3%A3/Cocina.jpg", 18),
(DEFAULT, "habitacion", "https://equipo10-digitalbooking-img.s3.us-east-2.amazonaws.com/img/Hostel+Esta%C3%A7%C3%A3o+Maracan%C3%A3/Habitacion.jpg", 18),
(DEFAULT, "habitacion2", "https://equipo10-digitalbooking-img.s3.us-east-2.amazonaws.com/img/Hostel+Esta%C3%A7%C3%A3o+Maracan%C3%A3/Habitacion2.jpg", 18),
(DEFAULT, "living", "https://equipo10-digitalbooking-img.s3.us-east-2.amazonaws.com/img/Hostel+Esta%C3%A7%C3%A3o+Maracan%C3%A3/Living.jpg", 18),
(DEFAULT, "piscina", "https://equipo10-digitalbooking-img.s3.us-east-2.amazonaws.com/img/Hostel+Esta%C3%A7%C3%A3o+Maracan%C3%A3/Piscina.jpg", 18),
(DEFAULT, "piscina2", "https://equipo10-digitalbooking-img.s3.us-east-2.amazonaws.com/img/Hostel+Esta%C3%A7%C3%A3o+Maracan%C3%A3/Piscina2.jpg", 18),
(DEFAULT, "comedor", "https://equipo10-digitalbooking-img.s3.us-east-2.amazonaws.com/img/Hostel+Esta%C3%A7%C3%A3o+Maracan%C3%A3/Comedor.jpg", 18),
-- Imagenes prod 19
(DEFAULT, "pvtBdrm", "https://equipo10-digitalbooking-img.s3.us-east-2.amazonaws.com/img/Pvt+Bdrm%2C+Close+to+Airport+%26+Cruise+Terminal/PvtBdrm.jpg", 19),
(DEFAULT, "baño", "https://equipo10-digitalbooking-img.s3.us-east-2.amazonaws.com/img/Pvt+Bdrm%2C+Close+to+Airport+%26+Cruise+Terminal/Ba%C3%B1o.jpg", 19),
(DEFAULT, "baño2", "https://equipo10-digitalbooking-img.s3.us-east-2.amazonaws.com/img/Pvt+Bdrm%2C+Close+to+Airport+%26+Cruise+Terminal/Ba%C3%B1o2.jpg", 19),
(DEFAULT, "cocina", "https://equipo10-digitalbooking-img.s3.us-east-2.amazonaws.com/img/Pvt+Bdrm%2C+Close+to+Airport+%26+Cruise+Terminal/Cocina.jpg", 19),
(DEFAULT, "cocina2", "https://equipo10-digitalbooking-img.s3.us-east-2.amazonaws.com/img/Pvt+Bdrm%2C+Close+to+Airport+%26+Cruise+Terminal/Cocina2.jpg", 19),
(DEFAULT, "habitacion", "https://equipo10-digitalbooking-img.s3.us-east-2.amazonaws.com/img/Pvt+Bdrm%2C+Close+to+Airport+%26+Cruise+Terminal/Habitacion.jpg", 19),
(DEFAULT, "habitacion2", "https://equipo10-digitalbooking-img.s3.us-east-2.amazonaws.com/img/Pvt+Bdrm%2C+Close+to+Airport+%26+Cruise+Terminal/Habitacion2.jpg", 19),
(DEFAULT, "habitacion3", "https://equipo10-digitalbooking-img.s3.us-east-2.amazonaws.com/img/Pvt+Bdrm%2C+Close+to+Airport+%26+Cruise+Terminal/Habitacion3.jpg", 19),
-- Imagenes prod 20
(DEFAULT, "supertrampHostelMachupicchu", "https://equipo10-digitalbooking-img.s3.us-east-2.amazonaws.com/img/Supertramp+Hostel+Machupicchu/SupertrampHostelMachupicchu.jpg", 20),
(DEFAULT, "baño", "https://equipo10-digitalbooking-img.s3.us-east-2.amazonaws.com/img/Supertramp+Hostel+Machupicchu/Ba%C3%B1o.jpg", 20),
(DEFAULT, "baño2", "https://equipo10-digitalbooking-img.s3.us-east-2.amazonaws.com/img/Supertramp+Hostel+Machupicchu/Ba%C3%B1o2.jpg", 20),
(DEFAULT, "comedor", "https://equipo10-digitalbooking-img.s3.us-east-2.amazonaws.com/img/Supertramp+Hostel+Machupicchu/Comedor.jpg", 20),
(DEFAULT, "habitacion", "https://equipo10-digitalbooking-img.s3.us-east-2.amazonaws.com/img/Supertramp+Hostel+Machupicchu/Habitacion.jpg", 20),
(DEFAULT, "habitacion2", "https://equipo10-digitalbooking-img.s3.us-east-2.amazonaws.com/img/Supertramp+Hostel+Machupicchu/Habitacion2.jpg", 20),
(DEFAULT, "living", "https://equipo10-digitalbooking-img.s3.us-east-2.amazonaws.com/img/Supertramp+Hostel+Machupicchu/Living.jpg", 20),
(DEFAULT, "salaEstar", "https://equipo10-digitalbooking-img.s3.us-east-2.amazonaws.com/img/Supertramp+Hostel+Machupicchu/SalaEstar.jpg", 20),
-- Imagenes prod 21
(DEFAULT, "honeyBeeHouse", "https://equipo10-digitalbooking-img.s3.us-east-2.amazonaws.com/img/Honey+Bee+House/HoneyBeeHouse.jpg", 21),
(DEFAULT, "baño", "https://equipo10-digitalbooking-img.s3.us-east-2.amazonaws.com/img/Honey+Bee+House/Ba%C3%B1o.jpg", 21),
(DEFAULT, "baño2", "https://equipo10-digitalbooking-img.s3.us-east-2.amazonaws.com/img/Honey+Bee+House/Ba%C3%B1o2.jpg", 21),
(DEFAULT, "cocina", "https://equipo10-digitalbooking-img.s3.us-east-2.amazonaws.com/img/Honey+Bee+House/Cocina.jpg", 21),
(DEFAULT, "habitacion", "https://equipo10-digitalbooking-img.s3.us-east-2.amazonaws.com/img/Honey+Bee+House/Habitacion.jpg", 21),
(DEFAULT, "living", "https://equipo10-digitalbooking-img.s3.us-east-2.amazonaws.com/img/Honey+Bee+House/Living.jpg", 21),
(DEFAULT, "living2", "https://equipo10-digitalbooking-img.s3.us-east-2.amazonaws.com/img/Honey+Bee+House/Living2.jpg", 21),
(DEFAULT, "patio", "https://equipo10-digitalbooking-img.s3.us-east-2.amazonaws.com/img/Honey+Bee+House/Patio.jpg", 21),
-- Imagenes prod 22
(DEFAULT, "luxstoneExecutive", "https://equipo10-digitalbooking-img.s3.us-east-2.amazonaws.com/img/Luxstone+Executive+%26+Suites/LuxstoneExecutive%26Suites.jpg", 22),
(DEFAULT, "baño", "https://equipo10-digitalbooking-img.s3.us-east-2.amazonaws.com/img/Luxstone+Executive+%26+Suites/Ba%C3%B1o.jpg", 22),
(DEFAULT, "baño2", "https://equipo10-digitalbooking-img.s3.us-east-2.amazonaws.com/img/Luxstone+Executive+%26+Suites/Ba%C3%B1o2.jpg", 22),
(DEFAULT, "cocina", "https://equipo10-digitalbooking-img.s3.us-east-2.amazonaws.com/img/Luxstone+Executive+%26+Suites/Cocina.jpg", 22),
(DEFAULT, "comedor", "https://equipo10-digitalbooking-img.s3.us-east-2.amazonaws.com/img/Luxstone+Executive+%26+Suites/Comedor.jpg", 22),
(DEFAULT, "habitacion", "https://equipo10-digitalbooking-img.s3.us-east-2.amazonaws.com/img/Luxstone+Executive+%26+Suites/Habitacion.jpg", 22),
(DEFAULT, "living", "https://equipo10-digitalbooking-img.s3.us-east-2.amazonaws.com/img/Luxstone+Executive+%26+Suites/Living.jpg", 22),
(DEFAULT, "patio", "https://equipo10-digitalbooking-img.s3.us-east-2.amazonaws.com/img/Luxstone+Executive+%26+Suites/Patio.jpg", 22),
-- Imagenes prod 23
(DEFAULT, "b&bPecari", "https://equipo10-digitalbooking-img.s3.us-east-2.amazonaws.com/img/Bed+and+Breakfast+Pecar%C3%AD/B%26BPecar%C3%AD.jpg", 23),
(DEFAULT, "baño", "https://equipo10-digitalbooking-img.s3.us-east-2.amazonaws.com/img/Bed+and+Breakfast+Pecar%C3%AD/Ba%C3%B1o.jpg", 23),
(DEFAULT, "baño2", "https://equipo10-digitalbooking-img.s3.us-east-2.amazonaws.com/img/Bed+and+Breakfast+Pecar%C3%AD/Ba%C3%B1o2.jpg", 23),
(DEFAULT, "comedor", "https://equipo10-digitalbooking-img.s3.us-east-2.amazonaws.com/img/Bed+and+Breakfast+Pecar%C3%AD/Comedor.jpg", 23),
(DEFAULT, "habitacion", "https://equipo10-digitalbooking-img.s3.us-east-2.amazonaws.com/img/Bed+and+Breakfast+Pecar%C3%AD/Habitacion.jpg", 23),
(DEFAULT, "habitacion2", "https://equipo10-digitalbooking-img.s3.us-east-2.amazonaws.com/img/Bed+and+Breakfast+Pecar%C3%AD/Habitacion2.jpg", 23),
(DEFAULT, "patio", "https://equipo10-digitalbooking-img.s3.us-east-2.amazonaws.com/img/Bed+and+Breakfast+Pecar%C3%AD/Patio.jpg", 23),
(DEFAULT, "piscina", "https://equipo10-digitalbooking-img.s3.us-east-2.amazonaws.com/img/Bed+and+Breakfast+Pecar%C3%AD/Piscina.jpg", 23),
-- Imagenes prod 24
(DEFAULT, "bellagioTowerNewApartments", "https://equipo10-digitalbooking-img.s3.us-east-2.amazonaws.com/img/Bellagio+Tower+New+Apartments/BellagioTowerNewApartments.jpg", 24),
(DEFAULT, "balcon", "https://equipo10-digitalbooking-img.s3.us-east-2.amazonaws.com/img/Bellagio+Tower+New+Apartments/Balcon.jpg", 24),
(DEFAULT, "comedor", "https://equipo10-digitalbooking-img.s3.us-east-2.amazonaws.com/img/Bellagio+Tower+New+Apartments/Comedor.jpg", 24),
(DEFAULT, "habitacion", "https://equipo10-digitalbooking-img.s3.us-east-2.amazonaws.com/img/Bellagio+Tower+New+Apartments/Habitacion.jpg", 24),
(DEFAULT, "habitacion2", "https://equipo10-digitalbooking-img.s3.us-east-2.amazonaws.com/img/Bellagio+Tower+New+Apartments/Habitacion2.jpg", 24),
(DEFAULT, "living", "https://equipo10-digitalbooking-img.s3.us-east-2.amazonaws.com/img/Bellagio+Tower+New+Apartments/Living.jpg", 24),
(DEFAULT, "piscina", "https://equipo10-digitalbooking-img.s3.us-east-2.amazonaws.com/img/Bellagio+Tower+New+Apartments/Piscina.jpg", 24),
(DEFAULT, "piscina2", "https://equipo10-digitalbooking-img.s3.us-east-2.amazonaws.com/img/Bellagio+Tower+New+Apartments/Piscina2.jpg", 24);

INSERT INTO roles() VALUES
(DEFAULT, "ROLE_ADMIN"),
(DEFAULT, "ROLE_USER");

INSERT INTO usuarios() VALUES
(DEFAULT, "Rodrigo", "Calvo", "rodri@gmail.com", "Rodirman", false, null, true, "Cipolletti", 1),
(DEFAULT, "Gaston", "Innamorato", "gas@gmail.com", "Gastoni", false, null, true, "Canelones", 2),
(DEFAULT, "Jorge", "Sierra", "jorge@gmail.com", "Jorgito", false, null, true, "Bogota", 1),
(DEFAULT, "Victor", "Valencia", "victor@gmail.com", "Victor123", false, null, true, "Cali", 2),
(DEFAULT, "Braian", "Redmond", "braian@gmail.com", "Redmond", false, null, true, "Buenos Aires", 1),
(DEFAULT, "Monica", "Muñoz", "monica@gmail.com", "MoniViolin", false, null, true, "Medellin", 2);

INSERT INTO puntuaciones() VALUES
-- prod 1
(DEFAULT, 1, 5, 1), (DEFAULT, 1, 4, 2), (DEFAULT, 1, 5, 3), (DEFAULT, 1, 4, 4), (DEFAULT, 1, 5, 5),
-- prod 2
(DEFAULT, 2, 4, 6), (DEFAULT, 2, 3, 1), (DEFAULT, 2, 5, 2), (DEFAULT, 2, 4, 3), (DEFAULT, 2, 4, 4),
-- prod 3
(DEFAULT, 3, 3, 5), (DEFAULT, 3, 4, 6), (DEFAULT, 3, 5, 1), (DEFAULT, 3, 2, 2), (DEFAULT, 3, 5, 3),
-- prod 4
(DEFAULT, 4, 2, 4), (DEFAULT, 4, 3, 5), (DEFAULT, 4, 4, 6), (DEFAULT, 4, 5, 1), (DEFAULT, 4, 5, 2),
-- prod 5
(DEFAULT, 5, 1, 3), (DEFAULT, 5, 2, 4), (DEFAULT, 5, 4, 5), (DEFAULT, 5, 4, 6), (DEFAULT, 5, 3, 1),
-- prod 6
(DEFAULT, 6, 4, 2), (DEFAULT, 6, 3, 3), (DEFAULT, 6, 4, 4), (DEFAULT, 6, 3, 5), (DEFAULT, 6, 4, 6),
-- prod 7
(DEFAULT, 7, 5, 1), (DEFAULT, 7, 4, 2), (DEFAULT, 7, 4, 3), (DEFAULT, 7, 3, 4), (DEFAULT, 7, 4, 5),
-- prod 8
(DEFAULT, 8, 3, 6), (DEFAULT, 8, 4, 1), (DEFAULT, 8, 4, 2), (DEFAULT, 8, 4, 3), (DEFAULT, 8, 5, 4),

-- prod 9
(DEFAULT, 9, 5, 5), (DEFAULT, 9, 4, 6), (DEFAULT, 9, 5, 1), (DEFAULT, 9, 4, 2), (DEFAULT, 9, 5, 3),
-- prod 10
(DEFAULT, 10, 4, 4), (DEFAULT, 10, 3, 5), (DEFAULT, 10, 5, 6), (DEFAULT, 10, 4, 1), (DEFAULT, 10, 4, 2),
-- prod 11
(DEFAULT, 11, 3, 3), (DEFAULT, 11, 4, 4), (DEFAULT, 11, 5, 5), (DEFAULT, 11, 2, 6), (DEFAULT, 11, 5, 1),
-- prod 12
(DEFAULT, 12, 2, 2), (DEFAULT, 12, 3, 3), (DEFAULT, 12, 4, 4), (DEFAULT, 12, 5, 5), (DEFAULT, 12, 5, 6),
-- prod 13
(DEFAULT, 13, 1, 1), (DEFAULT, 13, 2, 2), (DEFAULT, 13, 4, 3), (DEFAULT, 13, 4, 4), (DEFAULT, 13, 3, 5),
-- prod 14
(DEFAULT, 14, 4, 6), (DEFAULT, 14, 3, 1), (DEFAULT, 14, 4, 2), (DEFAULT, 14, 3, 3), (DEFAULT, 14, 4, 4),
-- prod 15
(DEFAULT, 15, 5, 5), (DEFAULT, 15, 4, 6), (DEFAULT, 15, 4, 1), (DEFAULT, 15, 3, 2), (DEFAULT, 15, 4, 3),
-- prod 16
(DEFAULT, 16, 3, 4), (DEFAULT, 16, 4, 5), (DEFAULT, 16, 4, 6), (DEFAULT, 16, 4, 1), (DEFAULT, 16, 5, 2),

-- prod 17
(DEFAULT, 17, 5, 3), (DEFAULT, 17, 4, 4), (DEFAULT, 17, 5, 5), (DEFAULT, 17, 4, 6), (DEFAULT, 17, 5, 1),
-- prod 18
(DEFAULT, 18, 4, 2), (DEFAULT, 18, 3, 3), (DEFAULT, 18, 5, 4), (DEFAULT, 18, 4, 5), (DEFAULT, 18, 4, 6),
-- prod 19
(DEFAULT, 19, 3, 1), (DEFAULT, 19, 4, 2), (DEFAULT, 19, 5, 3), (DEFAULT, 19, 2, 4), (DEFAULT, 19, 5, 5),
-- prod 20
(DEFAULT, 20, 2, 6), (DEFAULT, 20, 3, 1), (DEFAULT, 20, 4, 2), (DEFAULT, 20, 5, 3), (DEFAULT, 20, 5, 4),
-- prod 21
(DEFAULT, 21, 1, 5), (DEFAULT, 21, 2, 6), (DEFAULT, 21, 4, 1), (DEFAULT, 21, 4, 2), (DEFAULT, 21, 3, 3),
-- prod 22
(DEFAULT, 22, 4, 4), (DEFAULT, 22, 3, 5), (DEFAULT, 22, 4, 6), (DEFAULT, 22, 3, 1), (DEFAULT, 22, 4, 2),
-- prod 23
(DEFAULT, 23, 5, 3), (DEFAULT, 23, 4, 4), (DEFAULT, 23, 4, 5), (DEFAULT, 23, 3, 6), (DEFAULT, 23, 4, 1),
-- prod 24
(DEFAULT, 24, 3, 2), (DEFAULT, 24, 4, 3), (DEFAULT, 24, 4, 4), (DEFAULT, 24, 4, 5), (DEFAULT, 24, 5, 6);

INSERT INTO likes() VALUES
(DEFAULT,1,1),(DEFAULT,1,2),(DEFAULT,1,3),(DEFAULT,1,4),
(DEFAULT,2,5),(DEFAULT,2,6),(DEFAULT,2,7),(DEFAULT,2,8),
(DEFAULT,3,9),(DEFAULT,3,10),(DEFAULT,3,11),(DEFAULT,3,12),
(DEFAULT,4,13),(DEFAULT,4,14),(DEFAULT,4,15),(DEFAULT,4,16),
(DEFAULT,5,17),(DEFAULT,5,18),(DEFAULT,5,19),(DEFAULT,5,20),
(DEFAULT,6,21),(DEFAULT,6,22),(DEFAULT,6,23),(DEFAULT,6,24);

INSERT INTO reservas() VALUES
(DEFAULT, 	'09:00:00', '2023-04-02', '2023-04-08', 'Vendedor 1', 1, 1, 1),
(DEFAULT, 	'10:00:00', '2023-04-16', '2023-04-22', 'Vendedor 2', 0, 1, 2),
(DEFAULT, 	'11:00:00', '2023-04-09', '2023-04-15', 'Vendedor 3', 1, 2, 3),
(DEFAULT, 	'12:00:00', '2023-04-23', '2023-04-29', 'Vendedor 4', 0, 2, 4),
(DEFAULT, 	'13:00:00', '2023-04-02', '2023-04-08', 'Vendedor 1', 1, 3, 4),
(DEFAULT, 	'14:00:00', '2023-04-16', '2023-04-22', 'Vendedor 2', 0, 3, 3),
(DEFAULT, 	'15:00:00', '2023-04-09', '2023-04-15', 'Vendedor 3', 1, 4, 2),
(DEFAULT, 	'16:00:00', '2023-04-23', '2023-04-29', 'Vendedor 4', 0, 4, 1),
(DEFAULT, 	'09:00:00', '2023-04-02', '2023-04-08', 'Vendedor 1', 1, 5, 1),
(DEFAULT, 	'10:00:00', '2023-04-16', '2023-04-22', 'Vendedor 2', 0, 5, 2),
(DEFAULT, 	'11:00:00', '2023-04-09', '2023-04-15', 'Vendedor 3', 1, 6, 3),
(DEFAULT, 	'12:00:00', '2023-04-23', '2023-04-29', 'Vendedor 4', 0, 6, 4),
(DEFAULT, 	'13:00:00', '2023-04-02', '2023-04-08', 'Vendedor 1', 1, 7, 4),
(DEFAULT, 	'14:00:00', '2023-04-16', '2023-04-22', 'Vendedor 2', 0, 7, 3),
(DEFAULT, 	'15:00:00', '2023-04-09', '2023-04-15', 'Vendedor 3', 1, 8, 2),
(DEFAULT, 	'16:00:00', '2023-04-23', '2023-04-29', 'Vendedor 4', 0, 8, 1),
(DEFAULT, 	'09:00:00', '2023-04-02', '2023-04-08', 'Vendedor 1', 1, 9, 1),
(DEFAULT, 	'10:00:00', '2023-04-16', '2023-04-22', 'Vendedor 2', 0, 9, 2),
(DEFAULT, 	'11:00:00', '2023-04-09', '2023-04-15', 'Vendedor 3', 1, 10, 3),
(DEFAULT, 	'12:00:00', '2023-04-23', '2023-04-29', 'Vendedor 4', 0, 10, 4),
(DEFAULT, 	'13:00:00', '2023-04-02', '2023-04-08', 'Vendedor 1', 1, 11, 4),
(DEFAULT, 	'14:00:00', '2023-04-16', '2023-04-22', 'Vendedor 2', 0, 11, 3),
(DEFAULT, 	'15:00:00', '2023-04-09', '2023-04-15', 'Vendedor 3', 1, 12, 2),
(DEFAULT, 	'16:00:00', '2023-04-23', '2023-04-29', 'Vendedor 4', 0, 12, 1),
(DEFAULT, 	'09:00:00', '2023-04-02', '2023-04-08', 'Vendedor 1', 1, 13, 1),
(DEFAULT, 	'10:00:00', '2023-04-16', '2023-04-22', 'Vendedor 2', 0, 13, 2),
(DEFAULT, 	'11:00:00', '2023-04-09', '2023-04-15', 'Vendedor 3', 1, 14, 3),
(DEFAULT, 	'12:00:00', '2023-04-23', '2023-04-29', 'Vendedor 4', 0, 14, 4),
(DEFAULT, 	'13:00:00', '2023-04-02', '2023-04-08', 'Vendedor 1', 1, 15, 4),
(DEFAULT, 	'14:00:00', '2023-04-16', '2023-04-22', 'Vendedor 2', 0, 15, 3),
(DEFAULT, 	'15:00:00', '2023-04-09', '2023-04-15', 'Vendedor 3', 1, 16, 2),
(DEFAULT, 	'16:00:00', '2023-04-23', '2023-04-29', 'Vendedor 4', 0, 16, 1),
(DEFAULT, 	'09:00:00', '2023-04-02', '2023-04-08', 'Vendedor 1', 1, 17, 1),
(DEFAULT, 	'10:00:00', '2023-04-16', '2023-04-22', 'Vendedor 2', 0, 17, 2),
(DEFAULT, 	'11:00:00', '2023-04-09', '2023-04-15', 'Vendedor 3', 1, 18, 3),
(DEFAULT, 	'12:00:00', '2023-04-23', '2023-04-29', 'Vendedor 4', 0, 18, 4),
(DEFAULT, 	'13:00:00', '2023-04-02', '2023-04-08', 'Vendedor 1', 1, 19, 4),
(DEFAULT, 	'14:00:00', '2023-04-16', '2023-04-22', 'Vendedor 2', 0, 19, 3),
(DEFAULT, 	'15:00:00', '2023-04-09', '2023-04-15', 'Vendedor 3', 1, 20, 2),
(DEFAULT, 	'16:00:00', '2023-04-23', '2023-04-29', 'Vendedor 4', 0, 20, 1),
(DEFAULT, 	'09:00:00', '2023-04-02', '2023-04-08', 'Vendedor 1', 1, 21, 1),
(DEFAULT, 	'10:00:00', '2023-04-16', '2023-04-22', 'Vendedor 2', 0, 21, 2),
(DEFAULT, 	'11:00:00', '2023-04-09', '2023-04-15', 'Vendedor 3', 1, 22, 3),
(DEFAULT, 	'12:00:00', '2023-04-23', '2023-04-29', 'Vendedor 4', 0, 22, 4),
(DEFAULT, 	'13:00:00', '2023-04-02', '2023-04-08', 'Vendedor 1', 1, 23, 4),
(DEFAULT, 	'14:00:00', '2023-04-16', '2023-04-22', 'Vendedor 2', 0, 23, 3),
(DEFAULT, 	'15:00:00', '2023-04-09', '2023-04-15', 'Vendedor 3', 1, 24, 2),
(DEFAULT, 	'16:00:00', '2023-04-23', '2023-04-29', 'Vendedor 4', 0, 24, 1);