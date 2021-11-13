# Electronic-online-store-console-

<h2> 💻Installation </h2>
To install and run the software use an IDE suitable for Java code (Eclipse <a href="https://www.eclipse.org/downloads/"> download </a>, NetBeans <a href = "https: // netbeans.apache.org/download/index.html">download </a>, IntelliJ <a href="https://www.jetbrains.com/idea/download/#section=windows"> download </a> , etc.). When you have installed the IDE you prefer, you can run the program inside it by opening the java project in this folder and clicking the "Run" button.

<h2> 👨‍💻Use </h2>
Once the program has been run, the console will welcome you to e-commerce and you will be asked to choose whether you want to log in or register.
  
```
WELCOME to my e-commerce
Do you want to Log in (key: l) or Sign Up (key: s)?
  ```

There are three accounts by default:
  * Administrator account: Federico Canali, username, <b>fede</b> and password <b>f</b>
  * Employee account: Alice Jones, username <b>ali</b> and password <b>jS</b>
  * User account: Bob Smith, username <b>bob</b> and password <b>b</b>
  
By choosing the registration and entering "s" you will be asked for your name, surname, username and password.
  
  ```
Insert your name ...
Freddy
Insert your lastname ...
Mercury
Insert username ...
fred
Insert password ...
FreD23 £
Registration was successful!
  ```
  
Choosing the login and entering "l" you will be asked for a username and password.
  
  ```
******* Log in *******
Insert username ...
bob
Insert password ...
b
######## TYPE OF OPERATIONS YOU CAN DO ########
Print products list: (key: p)
Search product: (key: search)
Buy one product (key: buy)
Logout: (key: o)
#####################
Welcome bob [type of user: Customer]
Insert key of operation you want to do ...
  ```
  
After logging in, you will be shown all the possible operations that can be performed with the type of account you are using.
  <h3> By user (customer): </h3>
  
  ```
 ######## TYPE OF OPERATIONS YOU CAN DO ########
Print products list: (key: p)
Search product: (key: search)
Buy one product (key: buy)
Logout: (key: o)
#####################
  ```
  
  <h3> By employee: </h3>
  
  ```
######## TYPE OF OPERATIONS YOU CAN DO ########
Print products list: (key: p)
Ship a product: (key: ship)
Update quantity of a product: (key: update)
Logout: (key: o)
#####################
  ```
  
  <h3> For administrator: </h3>
  
  ```
######## TYPE OF OPERATIONS YOU CAN DO ########
Print products list: (key: p)
Print all employee: (key: e)
Add new employee: (key: new)
Add new product: (key: newp)
Remove a product: (key: removep)
Logout: (key: o)
#####################
  ```
  
<h2> ⚒️Types of operations you can do based on your privileges: </h2>
  <h3> Print the product list </h3>
  
  ```
Insert key of operation you want to do ...
p
----- ALL PRODUCTS -----
Products [productName = HP computers, productCode = 0, producerName = HP, price = 556.0 €, quantity = 10]
Products [productName = Earphones, productCode = 1, producerName = AKG, price = 35.5 €, quantity = 2]
Products [productName = Mi LED TV, productCode = 2, producerName = Xiaomi, price = 279.0 €, quantity = 40]
Products [productName = iPad, productCode = 3, producerName = Apple, price = 999.99 €, quantity = 5]
Products [productName = iPhone X, productCode = 4, producerName = Apple, price = 1299.99 €, quantity = 2]
  ```
  
  <h3> Search for a product with one or more filters </h3>
  
  ```
Insert key of operation you want to do ...
search
Insert max price ... else insert 0
1000
Insert min price ... else insert 0
36
Insert product's name ... else insert 0
hp
Insert producer's name ... else insert 0
0
------- Result of the search -------
Products [productName = HP computers, productCode = 0, producerName = HP, price = 556.0 €, quantity = 10]
  ```
  
  <h3> Purchase a product </h3>
  
  ```
Insert key of operation you want to do ...
buy
Insert product's code ...
4
Insert product's quantity ...
5
The quantity that you want to buy is not avaiable ...
Insert key of operation you want to do ...
buy
Insert product's code ...
4
Insert product's quantity ...
1
Congratulation! You've buy this product => iPhone X qt = 1
  ```
  
  <h3> Order a product </h3>
  
  ```
Insert key of operation you want to do ...
ship
Insert product's code ...
2
Insert product's quantity ...
39
Congratulation! You've ship this product => Mi LED TV qt = 39
This product is out of stock ... Please reorder it .Products [productName = Mi TV LED, productCode = 2, producerName = Xiaomi, price = 279.0 €, quantity = 0]
  ```
  
  <h3> Update a quantity of a product </h3>
  
  ```
Insert key of operation you want to do ...
update
Insert product's code ...
2
Insert number of products arrived ...
5
The quantity of this product has been updated successfully! Products [productName = Mi LED TV, productCode = 2, producerName = Xiaomi, price = 279.0 €, quantity = 5]
  ```
  
  <h3> Print the employee list </h3>
  
  ```
Insert key of operation you want to do ...
And
----- ALL EMPLOYEES ----
Person [name = Alice, lastName = Jones, credentials = Credentials [username = ali, password = jS]]
  -----------------------
  ```
  
  <h3> Add a new employee </h3>
  
  ```
Insert key of operation you want to do ...
new
Insert employee's name ...
Anne
Insert employee's lastname ...
Watson
Insert employee's username ...
anne
Insert employee's password ...
anne45 $
New employee added correctly!
  ```
  
  <h3> Add a new product </h3>
  
  ```
Insert key of operation you want to do ...
newp
Insert product's name ...
Keyboard
Insert producer's name ...
HP
Insert product's price ...
34.69
Insert product's quantity ...
6
New product added successfully!
  ```
  
  <h3> Remove a product </h3>
  
  ```
Insert key of operation you want to do ...
removep
Insert product's code ...
5
This product has been removed! Products [productName = Keyboard, productCode = 5, producerName = HP, price = 34.68 €, quantity = 6]
  ```

  <h2>📃Documentation </h2>
To generate project documentation (<a href="https://docs.oracle.com/javase/8/docs/technotes/tools/windows/javadoc.html"> JavaDoc </a>) in eclipse Project-> Generate Javadoc ...
For more information <a href="https://idratherbewriting.com/learnapidoc/nativelibraryapis_create_javadoc.html"> here </a>
