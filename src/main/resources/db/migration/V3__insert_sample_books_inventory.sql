-- SAMPLE BOOKS
INSERT INTO book (title, author, price, isbn) VALUES
('Clean Code', 'Robert C. Martin', 49.99, '9780132350884'),
('Domain-Driven Design', 'Eric Evans', 59.99, '9780321125217'),
('Spring in Action', 'Craig Walls', 39.99, '9781617294945');

-- SAMPLE INVENTORY (Initialized)
INSERT INTO inventory_item (book_id, quantity) VALUES
(1, 10),
(2, 5),
(3, 7);
