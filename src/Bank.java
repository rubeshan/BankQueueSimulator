/**
 * This Bank Class creates the customer queue and teller machines for the
 * simulation process
 * 
 * @author Kosalan Balarjah
 * 
 */
public class Bank {
	private static int NOFT;// Number of Teller Machines
	private long APT;// Average processing time
	private int AAR;// average arrival rate
	private int Teller_ID;// Teller will be given an ID

	/**
	 * Creating a Bank with all the parameters
	 * 
	 * @param tellers
	 *            //Number of tellers is passed to the Bank Constructor
	 * @param teller_time
	 *            //Average processing time is passed to the Bank Constructor
	 * @param arrival_rate
	 *            //Average arrival rate is passed to the Bank constructor
	 */
	public Bank(int tellers, long teller_time, int arrival_rate) {
		NOFT = tellers;
		this.APT = teller_time;
		this.AAR = arrival_rate;
		this.Teller_ID = 1;
	}

	/**
	 * Create the array of teller machine for the desired number of tellers
	 * Create a new customer queue
	 */
	private static Teller[] ATM = new Teller[100];
	Customer simulationcustomer = new Customer();

	/**
	 * This method constructs the teller machine for the given number of teller
	 * machines A teller will be given a ID and assigned in a ATM array
	 */
	public void Construct_Teller() {
		for (int i = 0; i < NOFT; i++) {
			Teller NewTeller = new Teller(APT, Teller_ID);
			ATM[i] = NewTeller;
			Teller_ID++;
		}
	}

	/**
	 * This method pass a customer from the customer queue to a available teller
	 * machine This machine checks the teller availability and if there is a
	 * available machine it passes the customer to the machine or keeps on
	 * checking the other machine for availability If there is a customer is
	 * assigned the method returns true or else return false
	 * 
	 * @return true / false
	 */
	public boolean pass_customer() {
		int i = 0;
		boolean hh = false;
		while (i < NOFT) {
			if (ATM[i].Teller_In_Use() == true) {
				ATM[i].Assign_Customer();
				i = NOFT + 1;
				hh = true;
			} else {
				i++;
			}
		}
		return hh;
	}

	/**
	 * This method prints the entire teller machine information during the
	 * method call
	 */

	public void Get_Info() {
		for (int i = 0; i < NOFT; i++) {
			GUI_frame.je.append(ATM[i].toString() + "\n");
			// System.out.println(ATM[i]);
		}
	}

	/**
	 * This method runs the entire simulation this constructs a teller and
	 * constructs the customer Queue This simulate the program and print the
	 * teller and customer information
	 */
	public void simulation() {
		Construct_Teller();
		simulationcustomer.Construct_Customer_Queue(AAR);
		int i = 0;
		while (i == 0) {
			if (simulationcustomer.check_customer() == true) {
				boolean value = pass_customer();
				simulationcustomer.add_customer(AAR);
				if (value == true) {
					simulationcustomer.remove_customer();
					simulationcustomer.get_cus_info();
					Get_Info();
					simulationcustomer.add_customer(AAR);
				}
			}
			simulationcustomer.add_customer(AAR);
		}
	}
}
