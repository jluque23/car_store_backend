/* creamos algunos usuarios */

INSERT INTO `usuarios` (username, password, enabled, nombre, apellido, email,create_at) VALUES ('jluque','$2a$10$Zri4Huh6KQHtir0Ud3xClOXQEdIzQ9cbaJf4HupoGFxDHz2Y/Kvp.',1,'Jesus','Luque','luque23@live.com.mx','2020-01-01');
INSERT INTO `usuarios` (username, password, enabled, nombre, apellido, email,create_at) VALUES ('admin','$2a$10$h5FDjzfoYpDnKvLi4YalmOOVMPyNyNgzvAWButHx/sX.o20ib9iN.',1,'admin','admin','admin@email.com','2010-01-01');

INSERT INTO `roles` (nombre) VALUES ('ROLE_USER');
INSERT INTO `roles` (nombre) VALUES ('ROLE_ADMIN');

INSERT INTO `usuarios_roles` (usuario_id, role_id) VALUES (1,1);
INSERT INTO `usuarios_roles` (usuario_id, role_id) VALUES (2,2);
INSERT INTO `usuarios_roles` (usuario_id, role_id) VALUES (2,1);

/* Creamos bugs */
insert into bugs (title,create_at,descripcion,usuario_id,enabled) values ('This is the first bug','2010-01-05','This is the description',1,1);
insert into bugs (title,create_at,descripcion,usuario_id,enabled) values ('Error en ventana login','2015-01-05','Error al iniciar un login no funciona',2,0);

/* Creamos comentarios en bugs */
insert into bug_comentarios(id, comentario, create_at, usuario, bug_id) values (1,'Verificare el bug de inmediato','2010-01-05','Andres Guzman','1');
insert into bug_comentarios(id, comentario, create_at, usuario, bug_id) values (2,'Verificare el bug de inmediato','2010-01-05','John Doe','1');
insert into bug_comentarios(id, comentario, create_at, usuario, bug_id) values (3,'Verificalo bien porfavor','2010-01-05','Jesus Luque','1');

/* creamos notificationes */
insert into notifications (id,create_at,description) values (1,'2020/10/10','This is the first notification');
insert into notifications (id,create_at,description) values (2,now(),'This is the second notification');

/* insertamos tipos de product lines */
insert into product_lines (id,create_at,product_line,description,image) values (1,now(),'Classic Cars','Attention car enthusiasts: Make your wildest car ownership dreams come true. Whether you are looking for classic muscle cars, dream sports cars or movie-inspired miniatures, you will find great choices in this category. These replicas feature superb attention to detail and craftsmanship and offer features such as working steering system, opening forward compartment, opening rear trunk with removable spare wheel, 4-wheel independent spring suspension, and so on. The models range in size from 1:10 to 1:24 scale and include numerous limited edition and several out-of-production vehicles. All models include a certificate of authenticity from their manufacturers and come fully assembled and ready for display in the home or office.',NULL);
insert into product_lines (id,create_at,product_line,description,image) values (2,now(),'Motorcycles','Our motorcycles are state of the art replicas of classic as well as contemporary motorcycle legends such as Harley Davidson, Ducati and Vespa. Models contain stunning details such as official logos, rotating wheels, working kickstand, front suspension, gear-shift lever, footbrake lever, and drive chain. Materials used include diecast and plastic. The models range in size from 1:10 to 1:50 scale and include numerous limited edition and several out-of-production vehicles. All models come fully assembled and ready for display in the home or office. Most include a certificate of authenticity.',NULL);
insert into product_lines (id,create_at,product_line,description,image) values (3,now(),'Planes','Unique, diecast airplane and helicopter replicas suitable for collections, as well as home, office or classroom decorations. Models contain stunning details such as official logos and insignias, rotating jet engines and propellers, retractable wheels, and so on. Most come fully assembled and with a certificate of authenticity from their manufacturers.',NULL);
insert into product_lines (id,create_at,product_line,description,image) values (4,now(),'Ships','The perfect holiday or anniversary gift for executives, clients, friends, and family. These handcrafted model ships are unique, stunning works of art that will be treasured for generations! They come fully assembled and ready for display in the home or office. We guarantee the highest quality, and best value.',NULL);
insert into product_lines (id,create_at,product_line,description,image) values (5,now(),'Trains','Model trains are a rewarding hobby for enthusiasts of all ages. Whether you\'re looking for collectible wooden trains, electric streetcars or locomotives, you\'ll find a number of great choices for any budget within this category. The interactive aspect of trains makes toy trains perfect for young children. The wooden train sets are ideal for children under the age of 5.',NULL);
insert into product_lines (id,create_at,product_line,description,image) values (6,now(),'Trucks and Buses','The Truck and Bus models are realistic replicas of buses and specialized trucks produced from the early 1920s to present. The models range in size from 1:12 to 1:50 scale and include numerous limited edition and several out-of-production vehicles. Materials used include tin, diecast and plastic. All models include a certificate of authenticity from their manufacturers and are a perfect ornament for the home and office.',NULL);
insert into product_lines (id,create_at,product_line,description,image) values (7,now(),'Vintage Cars','Our Vintage Car models realistically portray automobiles produced from the early 1900s through the 1940s. Materials used include Bakelite, diecast, plastic and wood. Most of the replicas are in the 1:18 and 1:24 scale sizes, which provide the optimum in detail and accuracy. Prices range from $30.00 up to $180.00 for some special limited edition replicas. All models include a certificate of authenticity from their manufacturers and come fully assembled and ready for display in the home or office.',NULL);

