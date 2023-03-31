import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;
import java.lang.Thread;

public class Main_page extends Thread
{
	static int x,t;
	public static void main(String[] args) throws Exception
	{
	
		int no;
		int price;
		String name;
		System.out.println("Welcome To Big Burger :)");
		Thread.sleep(2000);
		System.out.println("Here is Your Menu : ");
		Thread.sleep(3000);
		System.out.println("1.  Mac_Burger\r2.  Burger & Wraps\r3.  Cheese Burgers\r4.  Mcspicy Chicken Wings\r5.  Holi Special Sharing Meals\r6.  Burgers and Meals\r7.  Fried Chicken\r8.  Coffee and Tea\r9.  Desserts\r10. Meals");
		Scanner sc=new Scanner(System.in);
		System.out.println("\rChoose Your Favorite Food Id: ");
	    int m=sc.nextInt();
	    System.out.println("How Many Quantity You Want");
	    int n=sc.nextInt();
	    t=n;
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/burger_shop", "root", "Gopi@2001-07-20");
			Statement stmt=conn.createStatement();
			String s="select * from menu where sNo="+m;
			Thread.sleep(2000);
			Burger bb=new Burger();
			ResultSet rs=stmt.executeQuery(s);
			if(m<=10)
			{
			System.out.println("\rsNo\tPrice\tYour Item");
			
			while(rs.next()) 
			{
				no=rs.getInt(1);
				price=rs.getInt(3);
				name=rs.getString(2);
				System.out.println(no+"\t"+price+"\t"+name);
				x=price;
				//System.out.println("\r"+rs.getInt(1)+"\t"+rs.getInt(3)+"\t"+rs.getString(2));
			}
			Thread.sleep(2000);
			switch(m)
			{
			case 1:
				System.out.println("\rToppings : Tender and juicy chicken patty cooked to perfection,\rwith creamy mayonnaise and crunchy lettuce adding flavour to each bite.");
				break;
			    case 2:
				System.out.println("\rToppings : Tender and juicy chicken patty coated in spicy,\rcrispy batter topped with a creamy sauce and \rcrispy shredded lettuce will have you craving for more.");
				break;
			    case 3:
				System.out.println("\rToppings : Formerly known as Cheese Lava Veg, this is a burger with sinfully oozing cheesy Veg patty");
				break;
			    case 4:
			    System.out.println("\rToppings : Enjoy McSpicy Chicken Wings - 8 Pc + 2 Coke - perfect sharing meal for your cravings");
			    break;
			    case 5:
			  	System.out.println("\rToppings : Flat 15% Off on Corn & Cheese Burger + McVeggie Burger + Fries");
				break;
			    case 6:
				System.out.println("\rToppings : Enjoy a deliciously filling meal of Triple Cheese Chicken Burger\rFries\rBeverage of your choice in a new, delivery friendly,\rreusable bottle.");
				break;
			    case 7:
				System.out.println("\rToppings : Enjoy McSpicy Fried Chicken 2 Pc + McSpicy Chicken Wings- 4 Pc + 2 Coke - perfect sharing meal for your catchup");
				break;
			    case 8:
				System.out.println("\rToppings : When coffee and tea becomes ritual, it takes its place at the heart of our ability to see greatness in small things");
				break;
			    case 9:
				System.out.println("\rToppings : McFlurry Banana Caramel Oreo");
				break;
			    case 10:
				System.out.println("\rToppings : Peri Peri Rice with 1 PC McSpicy Fried Chicken");
				break;
			}
			}
			else
			{
				System.out.println("Enter Valid Number.");
				System.exit(m);
			}
			System.out.println("\r");
			System.out.println("Type any Number To Add More Toppings or 0 To Close : ");
			int t=sc.nextInt();
			bb.getprice();
			
			if(t!=0) 
			{
				while(true)
				{

					System.out.println("1. AddExtraCheese    Rs.30");
					System.out.println("2. AddExtraToppings  Rs.35");
					System.out.println("3. AddSoftDrinks     Rs.75");
					System.out.println("4. EXIT");
					int top=sc.nextInt();
					switch(top)
					{
					case 1:
						bb.addExtraCheese();
						break;
					case 2:
						bb.addExtraTToppings();
						break;
					case 3:
						bb.addSoftDrinks();
						break;
					case 4:
						bb.getBill();
						break;
					default:
						System.out.println("Enter valid option");
					}
					if(top==4)
					{
						break;
					}

				}
					
			}
			else if(t==0)
			{
				bb.getBill();
			}	
			sc.close();
    }

}