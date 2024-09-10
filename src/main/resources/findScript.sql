SELECT name, surname, customer_id, date, product_name, amount
FROM clients.customers
         INNER JOIN clients.orders
                    ON customers.id = orders.customer_id
WHERE LOWER(name) = LOWER(:customer_name);