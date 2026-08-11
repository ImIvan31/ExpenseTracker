import java.util.Scanner;
import java.util.ArrayList;


public class expenseTracker
{
	// show all
	public static void printName_Amount(ArrayList<Expense> expenses) {
		for(Expense expense : expenses) {
			System.out.println( expense.getName() + " Amount: " + expense.getAmount());
		}
		if(expenses.isEmpty()) {
			System.out.println(" No added expenses");
		}

	}

	// show recent 10 expenses
	public static void recentlyExpenses(ArrayList<Expense> expenses) {
		int start = Math.max(0, expenses.size() - 10);

		for(int i = start; i < expenses.size(); i++ ) {

			Expense expense = expenses.get(i);

			System.out.println(expense.getName()+ " " + expense.getAmount());
		}

    if(expenses.isEmpty()) {
      System.out.println(" No added expenses");}




	}

	//search expense
	public static void searchExpense(ArrayList<Expense>expenses, String search) {
		boolean found = false;

		for(Expense expense : expenses) {
			if(expense.getName().equalsIgnoreCase(search)) {
				System.out.println("Found");
				System.out.println(expense.getName() + " Amount " +  expense.getAmount());

				found = true;
				break;
			}
		}

		if(!found) {
			System.out.println("Not Found");
		}

	}
	// Delete specific Expense
	public static void deleteExpense(ArrayList<Expense>expenses, String delete) {
		boolean canDelete = false;

		for(int i = 0; i < expenses.size(); i++) {
			Expense expense = expenses.get(i);

			if(expense.getName().equalsIgnoreCase(delete)) {
				expenses.remove(i);

				System.out.print("Succesfully Removed");
				canDelete = true;
				break;
			}
		}

		if(!canDelete) {
			System.out.println("Not in the list");
		}

	}

	// track expense
	public static double trackExpense(double cBudget, double allExpenses) {

		double remaining = cBudget - allExpenses;


		if(cBudget < allExpenses) {
			System.out.println("You are over budget" );
		} else if (cBudget > allExpenses) {
			System.out.println("You are under budget with a remaining amount of "+ remaining);
		} else if(cBudget == allExpenses) {
			System.out.println("Your budget is exactly your expenses with amount of zero remaining");
		}
		return remaining;

	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		ArrayList<Expense> expenses = new ArrayList<>();
		System.out.println("");
		System.out.println("Welcome this is Van Expense Tracker");
		System.out.println(" ");
		System.out.println("This program will help you to track your expenses by simply entering the current budget and the amount of expenses you want to track");
		System.out.println(" ");

		System.out.println("Do you want to start tracking your expenses?");
		String choise = "";

		while(!choise.equalsIgnoreCase("yes")&&!choise.equalsIgnoreCase("no")) {
			System.out.println(" ");
			System.out.println("Please enter a valid input, Yes or No");
			System.out.print(": ");
			choise = scan.nextLine();

			if(choise.equalsIgnoreCase("yes")) {
				System.out.println(" ");
				System.out.println("Okay, Let's begin tracking your expenses");
			} else if (choise.equalsIgnoreCase("no")) {
				System.out.println("allright, see you later");
				return;

			}
		}


		String exit ="";

		do {
		    
			String choises = "";
			while(!choises.equals("1")&& !choises.equals("2")&& !choises.equals("3") && !choises.equals("4") && !choises.equals("5") && !choises.equals("6")) {
				System.out.println(" ");
				System.out.println("Type 1: to Track expense | Type 2: To show all recent expenses  | Type 3: Search expenses | Type 4: Delete expenses| Type 5: Show new recent expenses | Type 6: Exit");
				System.out.print(": ");
				choises = scan.nextLine();
			}

			double B;
			if(choises.equals("1")) {
				double total = 0;
				int nV = 0;


				String cH =" ";
				System.out.print("Enter your budget: ");

				while(!scan.hasNextDouble()) {
					System.out.println(" ");
					System.out.println("Enter numbers only ");
					System.out.print("Budget: ");
					scan.nextLine();
				}

				B = scan.nextDouble();
				scan.nextLine();
				System.out.println("Your current budget is: " + B);

				String name = "";
				do {
					while(true) {

						System.out.println(" ");
						System.out.println("Enter the name of your expense: ");
						System.out.print(": ");
						name = scan.nextLine();
						if(name.matches("[a-z A-Z]+")) {
							break;
						}
						System.out.println(" ");
						System.out.println("Invalid input characters only");
					}
					double amount;
					System.out.println(" ");
					System.out.print("Enter the amount of your expense: ");
					while(!scan.hasNextDouble()) {
						System.out.println(" ");
						System.out.println("Enter numbers only ");
						System.out.print("Amount: ");
						scan.nextLine();

					}

					amount = scan.nextDouble();
					scan.nextLine();
					expenses.add(new Expense(name,amount));
					nV -= 1;

					int preSize = Math.max(0, expenses.size() + nV);
					for(int i = preSize; i < expenses.size(); i++ ) {
						Expense expense = expenses.get(i);
						System.out.println(expense.getName()+ " " + expense.getAmount());
					}
					total += amount;

					while (true) {
						System.out.println(" ");
						System.out.print("Do you want to add another expense? Yes or no: ");
						cH = scan.nextLine();
						System.out.println(" ");
						if (cH.equalsIgnoreCase("yes") || cH.equalsIgnoreCase("no")) {

							break;
						}
						System.out.println(" ");
						System.out.println("Invalid input! Please enter Yes or No.");
					}

					if(cH.equalsIgnoreCase("no")) {
						trackExpense(B,total);
					}

				} while(cH.equalsIgnoreCase("yes"));
			}// if 1 track

			if(choises.equals("2")) {
				printName_Amount(expenses);
			} // if 2 show all

			String cH = "";
			if (choises.equals("3")) {
				String name = " ";
				do {
					System.out.println(" ");
					System.out.println("Enter the expenses you want to search: ");
					System.out.print(": ");
					name = scan.nextLine();

					while(true) {
						if(name.matches("[a-z A-Z]+")) {
							break;
						}
						System.out.println(" ");
						System.out.println("Invalid input characters only");
						System.out.print(": ");
						name = scan.nextLine();
					}

					searchExpense(expenses,name);

					while (true) {
						System.out.println(" ");
						System.out.print("Continue searching? Yes or no: ");
						cH = scan.nextLine();
						System.out.println(" ");
						if (cH.equalsIgnoreCase("yes") || cH.equalsIgnoreCase("no")) {

							break;
						}
						System.out.println(" ");
						System.out.println("Invalid input! Please enter Yes or No.");
					}

				} while(cH.equalsIgnoreCase("yes"));
			} // if 3 search

			String Ch = " ";
			if (choises.equals("4")) {
				String name = " ";
				do {
					System.out.println(" ");
					System.out.println("Enter the expenses you want to delete: ");
					System.out.print(": ");
					name = scan.nextLine();

					while(true) {
						if(name.matches("[a-z A-Z]+")) {
							break;
						}
						System.out.println(" ");
						System.out.println("Invalid input characters only");
						System.out.print(": ");
						name = scan.nextLine();
					}

					deleteExpense(expenses,name);
					while (true) {
						System.out.println(" ");
						System.out.print("Continue deleting? Yes or no: ");
						Ch = scan.nextLine();
						System.out.println(" ");
						if (Ch.equalsIgnoreCase("yes") || Ch.equalsIgnoreCase("no")) {

							break;
						}
						System.out.println(" ");
						System.out.println("Invalid input! Please enter Yes or No.");
					}

				} while(Ch.equalsIgnoreCase("Yes"));

			} // if 4 delete

			else if(choises.equals("5")) {
        System.out.println(" ");
				recentlyExpenses(expenses);
			} // if 5 recent

			else if (choises.equals("6")) {
				System.out.println("allright, see you later");
				return;
			}

			while(true) {
				System.out.println(" ");
				System.out.println("Do you want to exit? Yes | No");
				exit = scan.nextLine();
				if(exit.equalsIgnoreCase("yes") || exit.equalsIgnoreCase("no")) {
					break;
				}
				System.out.println(" ");
				System.out.println("Please choose Yes | No");
			}

		}
		while(!exit.equalsIgnoreCase("Yes"));

	}//main
}// class