# pizzeria-shop
 A simple Point of Sales (POS) system developed for addressing the requirements of the family owned pizzeria restaurant Yummy Pizza. This application consists of the item selection, customer info, final amount calculation. Upon this the application transfers the data to a database system from which another application consisting of the payment gateway processing can pick it up and complete the order placement process. The application was developed using the following tools:
- The core focus was Java.
 - UI: Java Swing
 - Logic: Java
 - Persistance Storage: MySQL
 
# Functionalities:
- *Customer information:* The system takes customer information for order placement.
- *Items:* Sales Representatives can select specific items from a group of drop down lists (used to confine items specific to menu and not randoms) and add them tot he order. The items selected appear in a small list in the lower left corner of the same UI window.
- *Order Placement :* The sales representation can finally enter any special descriptions and the type of order. The total amount for the order automatically appears in a non editable field through internal calculations. Enums are used to contain informationr regarding order items. Prices are calculated based on the selections and finally upon clicking *"PAYMENT INFO"* button, the order is saved in the database.
- View orders: Orders can be view in a separate list, which queries all the orders from the database and allows sales reps to view.

# How to run:
- The application requires Eclipse IDE to run. Hence, installation of the IDE is necessary to run the application.
- MySQL Workbench can be used to run a server on port 3306 (default) and the sql script can be used to load the database information.
- Upon running the application from Eclipse IDE, it can be directly utilized. 
 
