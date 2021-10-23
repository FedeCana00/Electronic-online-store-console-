package assignment_1.managers;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import assignment_1.models.Product;

/**
 *  This class deals with the management of products for sale.
 *  
 *  @see Product
 *  @author Federico Canali
 **/
public class ProductsManager {
	/* CONSTANTS */
	private static final String ZERO = "0";
	/* VARIABLES */
	List<Product> products = null;
	int nextUniqueProductCode = 0;
	
	/*
    * The instance is static so it is shared among all instances of the class. It is also private
    * so it is accessible only within the class.
    */
   private static ProductsManager instance = null;

   /*
    * The constructor is private so it is accessible only within the class.
    */
   private ProductsManager() {
       this.products = new ArrayList<Product>();
   }

   /**
    * The constructor is called only if the static instance is null, so only the first time
    * that the getInstance() method is invoked.
    * All the other times the same instance object is returned.
    * @return the instance object is returned.
    **/
   public static ProductsManager getInstance() {
       if (instance == null)
           instance = new ProductsManager();
       return instance;
   }
   
   /**
    *  This method put a new product on sale.
    *  @param product Product that needs to be added.
    **/
   public void addProduct(Product product) {
	   if(product == null) {
		   System.out.println("Sorry but you've inserted a empty product...");
		   return;
	   }
	   
	   product.setProductCode(nextUniqueProductCode);
	   
	   this.products.add(product);
	   //increment unique int code for products
	   this.nextUniqueProductCode++;
   }
   
   /**
    *  This method prints all products for sale on the console. 
    **/
   public void printAllProducts() {
	   System.out.println("----- ALL PRODUCTS -----");
	   
	   for(Product p: this.products)
		   System.out.println(p.toString());
	   
	   System.out.println("------------------------");
   }
   
   /**
    *  This method is used to search for products by filter.
	*	The user will be prompted for each filter parameter and the user will
 	*	have to indicate the type of value required for each 
 	*	of them. If the user enters zero, then that parameter will not be used for the search.
    **/
   public void searcProducts() {
	   try {
		   
		   Scanner scannerFloat = new Scanner(System.in);
		   
		   System.out.println("Insert max price... else insert 0 ");
		   float maxPrice = scannerFloat.nextFloat();
		   
		   System.out.println("Insert min price... else insert 0 ");
		   float minPrice = scannerFloat.nextFloat();
		   
		   Scanner scannerString = new Scanner(System.in);
		   
		   System.out.println("Insert product's name ... else insert 0 ");
		   String productName = scannerString.nextLine();
		   
		   System.out.println("Insert producer's name ... else insert 0 ");
		   String producerName = scannerString.nextLine();
		   
		   filterSearch(maxPrice, minPrice, productName, producerName);
		   
	   } catch(Exception e) {
		   System.out.println("You have entered something invalid .. Try again!");
	   }
	   
   }
   
   /* used to filter the search */
   private void filterSearch(float maxPrice, float minPrice, String productName, String producerName) {
	   List<Product> mProductsFilter = new ArrayList<Product>();
	   
	   for(Product p: this.products) {
		   boolean isToInsert = true;
		   float price = p.getPrice()/100;
		   
		   if(maxPrice != 0 && price > maxPrice)
			   isToInsert = false;
		   
		   if(minPrice != 0 && price < minPrice)
			   isToInsert = false;
		   
		   String sProductName = p.getProductName().toLowerCase();
		   if(!productName.equals(ZERO) && !sProductName.contains(productName.toLowerCase()))
			   isToInsert = false;
		   
		   /*String sProducerName = p.getProducerName().toLowerCase();
		   if(!producerName.equals(ZERO) && !sProducerName.contains(producerName.toLowerCase()));
			   isToInsert = false;*/
		   
		   if(isToInsert)
			   mProductsFilter.add(p);
	   }
	   
	   System.out.println("------- Result of the search -------");
	   for(Product pr: mProductsFilter)
		   System.out.println(pr.toString());
   }
   
   /**
    *  This method is used to buy and ship products.
    *  @param operation This parameter indicates the type of operation, 
    *  i.e. whether we are buying or shipping a product.
    *  @return If true then the operation was successful, false otherwise.
    **/
   public boolean buySomeProducts(String operation) {
	   try {
		   
		   Scanner scanner = new Scanner(System.in);
		   
		   System.out.println("Insert product's code...");
		   int productCode = scanner.nextInt();
		   
		   System.out.println("Insert product's quantity...");
		   int productQuantity = scanner.nextInt();
		   
		   for(Product p: this.products) {
			   if(p.getProductCode() == productCode) {
				   if(p.getQuantity() >= productQuantity) {
					   int index = this.products.indexOf(p);
					   this.products.remove(p);
					   p.setQuantity(p.getQuantity() - productQuantity);
					   this.products.add(index,p);
					   System.out.println("Congratulation! You've " + operation + " this product => "
							   + p.getProductName() + " qt = " + productQuantity);
					   checkIfThisProductIsOutOfStock(p);
					   return true;
				   } else {
					   System.out.println("The quantity that you want to " + operation + " is not avaiable...");
					   return false;
				   }
			   }
		   }
		   
		   System.out.println("Product not found... Retry!");
		   
	   } catch(Exception e) {
		   System.out.println("You have entered something invalid .. Try again!");
	   }
	   return false;
   }
   
   /* used to check if this product is out of stock and print it */
   private void checkIfThisProductIsOutOfStock(Product product) {
	   if(product.getQuantity() == 0)
		   System.out.println("This product is out of stock... Please reorder it ." + product.toString());
   }
   
   /**
    *  This method is used to update a product.
    **/
   public void updateProduct() {
	   try {
		   
		   Scanner scanner = new Scanner(System.in);
		   
		   System.out.println("Insert product's code...");
		   int productCode = scanner.nextInt();
		   
		   System.out.println("Insert number of products arrived...");
		   int quantity = scanner.nextInt();
		   
		   for(Product p: this.products) {
			   if(p.getProductCode() == productCode) {
				   this.products.remove(p);
				   p.setQuantity(p.getQuantity() + quantity);
				   this.products.add(p);
				   
				   System.out.println("The quantity of this product has been updated successfully! "
				   		+ p.toString());
				   return;
			   }
		   }
		   
		   System.out.println("This product's code was not found... Retry!");
		   
	   } catch(Exception e) {
		   System.out.println("You have entered something invalid .. Try again!");
	   }
   }
   
   /**
    *  This method is used to add a new product.
    **/
   public void newProduct() {
	   Scanner scanner = new Scanner(System.in);
	   
	   System.out.println("Insert product's name...");
	   String productName = scanner.nextLine();
	   
	   System.out.println("Insert producer's name...");
	   String producerName = scanner.nextLine();
	   
	   try {
		   
		   System.out.println("Insert product's price...");
		   float price = scanner.nextFloat();
		   
		   System.out.println("Insert product's quantity...");
		   int quantity = scanner.nextInt();
		   
		   if(productName == null || producerName == null || price <= 0 || quantity < 0) {
			   System.out.println("One ore more fields files were not compiled correctly!");
			   return;
		   }
		   
		   //add new product
		   int iPrice = (int) (price*100); //used to convert float into integer
		   addProduct(new Product(productName, producerName, iPrice , quantity));
		   System.out.println("New product added successfully!");
		   
	   } catch(Exception e) {
		   System.out.println("You have entered something invalid .. Try again!");
	   }
   }
   
   /**
    *  This method is used to remove a product.
    **/
   public void removeProduct() {
	   try {
		   
		   Scanner scanner = new Scanner(System.in);
		   
		   System.out.println("Insert product's code...");
		   int code = scanner.nextInt();
		   
		   for(Product p: this.products)
			   if(p.getProductCode() == code) {
				   this.products.remove(p);
				   System.out.println("This product has been removed! " + p.toString());
				   return;
			   }
		   
		   System.out.println("Product was not not found... Retry!");
	   
	   } catch(Exception e) {
		   System.out.println("You have entered something invalid .. Try again!");
	   }
   }
   
}
