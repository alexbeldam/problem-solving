SELECT p.product_name, s.year, s.price
FROM sales s
NATURAL JOIN product p