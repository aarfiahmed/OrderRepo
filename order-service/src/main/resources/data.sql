DROP TABLE IF EXISTS ORDER_DETAILS;
 
CREATE TABLE ORDER_DETAILS (
  order_id VARCHAR(250)  NOT NULL,
  customer_name VARCHAR(250) NOT NULL,
  order_date VARCHAR(10) NOT NULL,
  shipping_address VARCHAR(50) NOT NULL,
  total varchar(10) NOT NULL
);
 
INSERT INTO ORDER_DETAILS (order_id, customer_name, order_date,shipping_address,total) VALUES
  ('101', 'raj', '16/08/2020','lko','4');

  INSERT INTO ORDER_DETAILS (order_id, customer_name, order_date,shipping_address,total) VALUES
  ('103', 'rahul', '16/08/2020','del','4');
  