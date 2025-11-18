-- ---------------------------------------------------------
-- SAMPLE USERS (Ensure users with IDs 2,3,4 exist)
-- Admin = 1 (from previous migrations)
-- John  = 2
-- Add two more sample customers
-- ---------------------------------------------------------

INSERT INTO users (username, password, role) VALUES
('mary', '$2a$10$0Kcnnr5lTyBC0b.poSx28e6GHElBC2Bu/uTrgbOV31G5I0u9kDPKy', 'USER'),
('david', '$2a$10$0Kcnnr5lTyBC0b.poSx28e6GHElBC2Bu/uTrgbOV31G5I0u9kDPKy', 'USER');

-- ---------------------------------------------------------
-- SAMPLE MULTIPLE ORDERS FOR REALISTIC TESTING
-- ---------------------------------------------------------

-- ORDER 2 (Mary buys 2 books)
INSERT INTO orders (customer_id) VALUES (3);
INSERT INTO order_item (order_id, book_id, quantity) VALUES
((SELECT id FROM orders ORDER BY id DESC LIMIT 1), 1, 1),
((SELECT id FROM orders ORDER BY id DESC LIMIT 1), 2, 1);

-- ORDER 3 (David buys bulk quantities)
INSERT INTO orders (customer_id) VALUES (4);
INSERT INTO order_item (order_id, book_id, quantity) VALUES
((SELECT id FROM orders ORDER BY id DESC LIMIT 1), 3, 3),
((SELECT id FROM orders ORDER BY id DESC LIMIT 1), 1, 2);

-- ORDER 4 (John buys again, big purchase)
INSERT INTO orders (customer_id) VALUES (2);
INSERT INTO order_item (order_id, book_id, quantity) VALUES
((SELECT id FROM orders ORDER BY id DESC LIMIT 1), 2, 2),
((SELECT id FROM orders ORDER BY id DESC LIMIT 1), 3, 4);

-- ORDER 5 (Mary analytics sample)
INSERT INTO orders (customer_id) VALUES (3);
INSERT INTO order_item (order_id, book_id, quantity) VALUES
((SELECT id FROM orders ORDER BY id DESC LIMIT 1), 1, 5),
((SELECT id FROM orders ORDER BY id DESC LIMIT 1), 2, 3),
((SELECT id FROM orders ORDER BY id DESC LIMIT 1), 3, 2);

-- ORDER 6 (Admin)
INSERT INTO orders (customer_id) VALUES (1);
INSERT INTO order_item (order_id, book_id, quantity) VALUES
((SELECT id FROM orders ORDER BY id DESC LIMIT 1), 1, 1);
