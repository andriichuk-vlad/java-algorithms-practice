SELECT s.product_id, s.year AS first_year, s.quantity, s.price FROM Sales s
INNER JOIN (SELECT sb.product_id, MIN(sb.year) AS first_year FROM Sales sb GROUP BY sb.product_id)
AS s2 ON s.product_id = s2.product_id AND first_year = s.year;