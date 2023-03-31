public class Burger extends Main_page
{	
	int choice=Main_page.t;
    int price;
	int addExtraCheese_price=30;
	int addExtraTToppings_price=35;
	int addSoftDrinks_price=75;
	int packing_price=20;
	int delivery_charge=60;
	void getprice()
	{
		 price=Main_page.x;
		 price=price*choice;
	}
	void addExtraCheese()
	{
		System.out.println("Extra Cheese added ");
		price+=addExtraCheese_price;
	}
	void addExtraTToppings()
	{
		System.out.println("Extra Toppings Added");
		price+=addExtraTToppings_price;
	}
	void addSoftDrinks()
	{
		System.out.println("Soft Drinks Added");
		price+=addSoftDrinks_price;
	}
	void getBill() throws Exception
	{
		System.out.println("----------------------------------");
		System.out.println("Your Order Is Ready To Take... ");
		Thread.sleep(2000);
		System.out.println("Quantity = "+t);
		System.out.println("\rprice : "+price);
		System.out.println("Packing Charges = Rs 20");
		price+=packing_price;
		System.out.println("Delivery Charge = Rs 60");
		price+=delivery_charge;
		System.out.println("Total : "+price);
		price+=price/5;
		System.out.println("Total Amount + 5% GST = "+price);
		System.out.println("----------------------------------");


	}
	
}

