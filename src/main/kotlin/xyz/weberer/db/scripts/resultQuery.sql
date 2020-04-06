WITH prices AS (
    SELECT pr.product_id, MAX(p.original_retail_price) max_price, MIN(p.original_retail_price) min_price
    FROM part p,
         product pr
    WHERE p.product_id = pr.product_id
    GROUP BY pr.product_id
),

formated_prices AS (
    SELECT product_id, CASE WHEN max_price = min_price THEN '$' || max_price ELSE '$' || min_price || ' - ' || max_price END price_range
    FROM prices
),

asset_url AS (
    SELECT DISTINCT p.product_id, MIN(p.asset_url) as asset_url
    FROM part p
    GROUP BY product_id
)
SELECT DISTINCT pr.product_name, p.brand_name, fp.price_range, a.asset_url
FROM   asset_url a,
       formated_prices fp,
       part p,
       product pr
WHERE  p.product_id = pr.product_id
  AND p.product_id = fp.product_id
  AND p.product_id = a.product_id
ORDER BY p.brand_name, pr.product_name;
