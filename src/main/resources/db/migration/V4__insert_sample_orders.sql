-- SAMPLE ORDER FOR USER JOHN (id = 2)
INSERT INTO orders (customer_id) VALUES (2);

-- Order ID is usually 1 when empty, but using SELECT ensures correctness
INSERT INTO order_item (order_id, book_id, quantity) VALUES
((SELECT id FROM orders ORDER BY id DESC LIMIT 1), 1, 1),
((SELECT id FROM orders ORDER BY id DESC LIMIT 1), 3, 2);
