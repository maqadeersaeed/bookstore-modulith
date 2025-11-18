-- =============== USERS (Auth Module) ===============
CREATE TABLE users (
    id BIGSERIAL PRIMARY KEY,
    username VARCHAR(100) NOT NULL UNIQUE,
    password VARCHAR(200) NOT NULL,
    role VARCHAR(20) NOT NULL
);

-- =============== BOOK (Catalog Module) ===============
CREATE TABLE book (
    id BIGSERIAL PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    author VARCHAR(255) NOT NULL,
    price DECIMAL(10,2) NOT NULL,
    isbn VARCHAR(50)
);

-- =============== INVENTORY (Inventory Module) ===============
CREATE TABLE inventory_item (
    id BIGSERIAL PRIMARY KEY,
    book_id BIGINT NOT NULL,
    quantity INT NOT NULL DEFAULT 0,
    CONSTRAINT fk_inventory_book FOREIGN KEY (book_id)
        REFERENCES book(id)
        ON DELETE CASCADE
);

CREATE INDEX idx_inventory_book ON inventory_item(book_id);

-- =============== ORDER (Orders Module) ===============
CREATE TABLE orders (
    id BIGSERIAL PRIMARY KEY,
    customer_id BIGINT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE order_item (
    id BIGSERIAL PRIMARY KEY,
    order_id BIGINT NOT NULL,
    book_id BIGINT NOT NULL,
    quantity INT NOT NULL,
    CONSTRAINT fk_order_item_order FOREIGN KEY (order_id)
        REFERENCES orders(id)
        ON DELETE CASCADE,
    CONSTRAINT fk_order_item_book FOREIGN KEY (book_id)
        REFERENCES book(id)
        ON DELETE CASCADE
);

CREATE INDEX idx_orderitem_order ON order_item(order_id);

-- =============== AUDIT MODULE ===============
CREATE TABLE audit_record (
    id BIGSERIAL PRIMARY KEY,
    action VARCHAR(50) NOT NULL,
    module_name VARCHAR(50) NOT NULL,
    entity_id BIGINT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
