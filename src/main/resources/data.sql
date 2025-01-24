-- Categories
INSERT INTO category (id, name) VALUES
(1, 'Mobile Phones'),
(2, 'Mobile Accessories'),
(3, 'Electronics');

-- Products
INSERT INTO product (id, name, description, category_id) VALUES
(1, 'Samsung S9+', 'High-end smartphone', 1),
(2, 'Sony PlayStation 4', 'Gaming console', 3);

-- Product Variants
INSERT INTO product_variant (id, sku, name, price, quantity, product_id, image_url1, image_url2, image_url3) VALUES
(1, 'S9G64', 'Samsung S9+ 64GB Grey', 699.99, 10, 1, 'img1.jpg', 'img2.jpg', 'img3.jpg'),
(2, 'PS4W', 'Sony PlayStation 4 White', 299.99, 15, 2, 'img1.jpg', 'img2.jpg', 'img3.jpg');

-- Wishlist
INSERT INTO wishlist (id, product_id) VALUES
(1, 1);

-- Cart
INSERT INTO cart (id, product_variant_id, quantity) VALUES
(1, 1, 2),
(2, 2, 1);
