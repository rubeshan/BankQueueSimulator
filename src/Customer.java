import java.util.LinkedList;
import java.util.Queue;

/**
 * The Customer Class has the methods relevent to the customer Queue that will
 * be called during the simulation
 * 
 * @author Kosalan Balarjah
 * 
 */
public class Customer {
	private static Queue<Customer> Customer_Queue = new LinkedList<Customer>();// Customer
	// Queue
	// (Customers
	// will
	// be
	// sent
	// and
	// received
	// through
	// the
	// group)
	private final long programstarttime = System.currentTimeMillis();// Program
	// Start
	// time
	// will
	// be
	// used
	// to
	// set
	// loop
	// condition
	private long chektime = programstarttime + 60000;// Customers will be added

	// to the queue every 1
	// minute checktime will
	// be used to monitor
	// the method call

	/**
	 * Creating a customer
	 * 
	 * @author Kosalan Balarajah
	 */
	public Customer() {
	}

	/**
	 * Creating a new customer queue with the appropriate customer arrival rate
	 * 
	 * @param AAR
	 *            is the customer arrival rate customer arrival rate will be
	 *            passed to the method and a new queue will be constructed
	 *            according to the arrival rate
	 */
	public void Construct_Customer_Queue(int AAR) {
		for (int i = 0; i < AAR; i++) {
			Customer newCustomer = new Customer();
			Customer_Queue.add(newCustomer);
		}
	}

	/**
	 * Adding new customer s to the queue according to the arrival rate passed
	 * to the method Every minute a relevant amount of customers will be added
	 * to the queue
	 * 
	 * @param AAR
	 *            // arrival rate of the customer
	 */
	public void add_customer(int AAR) {
		long looptime2 = System.currentTimeMillis();

		if (looptime2 >= chektime) {
			Construct_Customer_Queue(AAR);
			chektime += 60000;
		}
	}

	/**
	 * Check if there are any new customers waiting in the line This method will
	 * return true if there are any customers in the line and false if there are
	 * no customers in the line
	 * 
	 * @return true / false
	 */
	public boolean check_customer() {
		if (Customer_Queue.size() == 0) {
			return false;
		} else
			return true;
	}

	/**
	 * This method will remove the customers in the queue The customers will be
	 * removed from the queue tip of the queue
	 */
	public void remove_customer() {
		Customer_Queue.remove();
	}

	/**
	 * This method extract the customer queue information During the method call
	 * this method returns the number of customers waiting in the line
	 */
	public void get_cus_info() {
		Customer_Queue.size();

		GUI_frame.je.append("There are " + Customer_Queue.size()
				+ " waiting in the line\n");
		// System.out.println("There are " + Customer_Queue.size() +
		// " waiting in the line");
	}
}