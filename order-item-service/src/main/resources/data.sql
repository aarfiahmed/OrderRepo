DROP TABLE IF EXISTS ORDERITEM;
 
CREATE TABLE ORDERITEM (
order_id VARCHAR(40)  NOT NULL,
  product_code VARCHAR(250)  NOT NULL,
  product_name VARCHAR(250) NOT NULL,
  quantity VARCHAR(10) NOT NULL  
);
 
INSERT INTO ORDERITEM (order_id,product_code, product_name, quantity) VALUES
  ('101','Prod101', 'laptop', '2');
  INSERT INTO ORDERITEM (order_id,product_code, product_name, quantity) VALUES
  ('101','Prod102', 'pc', '8');
  
  INSERT INTO ORDERITEM (order_id,product_code, product_name, quantity) VALUES
  ('102','Prod103', 'mobile', '10');
  
  