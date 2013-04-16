import java.util.Calendar;
import java.text.SimpleDateFormat;

/**
 * This is a Teller class that has all the corresponding methods that associate
 * with the teller machines
 * 
 * @author Kosalan Balarajah
 */
public class Teller {
	private long APT;// average processing time
	private long T_Start_Time;// Start time in milliseconds
	private boolean Teller_Check;// teller availability check
	private int count;// counter for the teller machines
	private int Teller_ID;// assign ID for teller machines
	private String Start_T;// Start time in actual time format
	private String print;// print the teller availability
	private static final String DATE_FORMAT_NOW = "yyyy-MM-dd HH:mm:ss";// Time

	// Display
	// format
	// for
	// the
	// teller
	// machines

	/**
	 * Constructing a Teller Machine with the corresponding parameters
	 * 
	 * @param a
	 *            is the average processing time passed from the Bank Class
	 * @param b
	 *            is the Teller ID passed from the Bank Class
	 */
	public Teller(long a, int b) {
		this.APT = a;
		this.Teller_Check = true;
		this.T_Start_Time = 0;
		this.count = 0;
		this.Teller_ID = b;
	}

	/**
	 * This method display the time of the teller operations in actual time
	 * format
	 * 
	 * @return operational time format
	 */
	public String Extract_Time() {
		Calendar newCalendar = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_NOW);
		return sdf.format(newCalendar.getTime());
	}

	/**
	 * Assign a Customer to the Teller machine. When this machine is called, the
	 * availability of the teller machine will be set to zero and the current
	 * time will be stored in the Teller Machine (Customer assigned at that
	 * time) and the counter will be increased by one to measure how many
	 * customer this machine has served
	 */
	public void Assign_Customer() {
		Teller_Check = false;
		T_Start_Time = System.currentTimeMillis();
		Start_T = Extract_Time();
		count++;
	}

	/**
	 * CHeck if the machine is accessible for the customers waiting in the line
	 * This return true if the machine is free and false if the machine is busy
	 * 
	 * @return Teller_Check
	 */
	public boolean Teller_In_Use() {
		if ((System.currentTimeMillis() >= (T_Start_Time + APT))
				|| Teller_Check == true) {
			Teller_Check = true;
			print = "Availability: Available";
			return Teller_Check;
		} else {
			print = "Availability: Busy";
			return Teller_Check;
		}
	}

	/**
	 * to String returns all the corresponding values that are associated with
	 * the Teller Class
	 */
	public String toString() {
		int listTellerID = Teller_ID;
		String listStart_T = "was occupied at " + Start_T;
		String listTeller_Check = print;
		String listcount = "This Teller Machine has served " + count
				+ "customers";

		return "Teller(" + listTellerID + ") " + listStart_T + ". "
				+ listTeller_Check + ". " + listcount;
	}
}
