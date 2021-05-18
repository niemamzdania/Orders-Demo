# Orders-Demo

Local start of the application:
mvn spring-boot:run

Available REST endpoints:

POST /admin/products - add product to the database and returns it
Example JSON format for create product
{
  "name" : "name"
  "price" : 33.11
}

PUT /admin/products/{id} - update product with given id (or adding a new product when id is not given) 
                           and returns product. Changes do not affect the price of already approved orders
Example JSON format for update product
{
  "name" : "changed_name"
  "price" : 33.11
}

PATCH /admin/orders/recalculate/{id} - recalculates value of order with the given id, 
                                       based on current value of the products and returns actual version of the order


GET /products/{id} - returns product with the given id

GET /products - returns all products

POST /orders - approves the order based on products in the cart and returns message

GET /orders/date?startDate={start_date}&endDate={end_date} - returns the orders between given dates 

PUT /orders/bucket/{id} - add product with the given id to the bucket and returns message
