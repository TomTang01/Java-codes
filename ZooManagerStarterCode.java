///////////////////////////////////////////////////////////////////////////////
//                   
// Title:              Assignment3
// Files:              Assignment3 starter code: ZooManager
// Quarter:            CSE8B Spring 2023
//
// Author:             Tom Tang
// Email:              zit008@ucsd.edu
// Instructor's Name:  Ben Ochoa
//
///////////////////////////////////////////////////////////////////////////////

/**
 * NOTE: YOU SHOULD NOT HAVE TO IMPORT ANY PACKAGES TO COMPLETE THIS
 * ASSIGNMENT. 
 * 
 * If you add extraneous packages (intentionally or not), then your
 * code might fail Gradescope compilation.
 */

/**
 * (Write a succinct description of this class here. You should avoid
 * wordiness and redundancy.)
 *
 * Bugs: none
 *
 * @author Tom Tang
 */
public class ZooManagerStarterCode {

    // Feel free to create extra variables if necessary.

    /* Variables used for all methods */
    // Days of the week
    private final static int MONDAY = 1;
    private final static int TUESDAY = 2;
    private final static int WEDNESDAY = 3;
    private final static int THURSDAY = 4;
    private final static int FRIDAY = 5;
    private final static int SATURDAY = 6;
    private final static int SUNDAY = 7;
    private final static String INVALID_DAY = "Invalid day of the week";

    /* Variables used for zooSchedule */
    // Useful strings
    private final static String EMERGENCY = "Zoo is closed due to emergency";
    private final static String SCHEDULE_HEADER = "Today's animals:";
    private final static String AMPHIBIANS = "amphibians";
    private final static String MAMMALS = "mammals";
    private final static String POLAR_BEARS = "polar bears";
    private final static String BIRDS = "birds";
    private final static String REPTILES = "reptiles";
    private final static String PENGUINS = "penguins";


    /* Variables used for feedAnimals */
    // Military time of the day
    private final static int ZERO = 0;
    private final static int EIGHT = 8;
    private final static int TEN = 10;
    private final static int TWELVE = 12;
    private final static int FOURTEEN = 14;
    private final static int TWENTY_THREE = 23;
    private final static int TWENTY_FOUR = 24;
    

    // Output messages
    private final static String FEED_AMPH_MAMM = 
        "Feeding the amphibians and mammals";
    private final static String FEED_BIRD_REPT = 
        "Feeding the birds and reptiles";
    private final static String NO_FEEDING = 
        "No feeding scheduled at this time";
    private final static String NO_FEED_SUNDAY = 
        "No feeding scheduled on Sundays";
    private final static String INVALID_INPUT =
        "Invalid input provided";


    /* Variables used for calcTicketPrice */
    // Ticket prices
    private final static double NO_COST = 0.0;
    private final static double CHILD_PRICE = 14.0;
    private final static double ADULT_PRICE = 20.0;
    private final static double SENIOR_PRICE = 12.0;
    private final static double PREMIUM_DISCOUNT = 0.60;
    private final static double WEEKEND_SURCHARGE = 3.0;

    // Age groups (feel free to add more)
    private final static int FIVE = 5;
    private final static int ELEVEN = 11;
    private final static int THIRTEEN = 13;
    private final static int SIXTY_FOUR = 64;


    /**
    * This method returns the animals that are available at the zoo
    * during any days of the week and for both normal people and premium.
    *
    * @param (int dayOfWeek) (what day of the week it is)
    * @param (boolean isPremium) (is premium or not)
    * @param (boolean emergency) (whther the zoo has an emergency or not)
    * @return (void)
    */
    public static void zooSchedule(int dayOfWeek, boolean isPremium,
                                   boolean emergency) {
        
    }


    /**
     * Tells what animals are to be fed at different times
     *
     * @param (int dayOfWeek) (Describe the first parameter here)
     * @param (int hourOfDay) (Do the same for each additional parameter)
     * @return (description of the return value)
     */
    public static String feedAnimals(int dayOfWeek, int hourOfDay) {
        String feedingResult = "";
        
        return feedingResult;
    }


    /**
     * This method calculates the price of a ticket based on 
     * several factors and returns the price
     *
     * @param (int dayOfWeek) (which day of the week)
     * @param (int age) (age of ticket buyer)
     * @param (boolean isPremium) (whether the ticket buyer has premium or not)
     * @return (the price of the ticket)
     */
    public static double calcTicketPrice(int dayOfWeek, int age,
                                         boolean isPremium) {
        double ticketPrice = 0.0;
        
        return ticketPrice;
    }


    // TODO: Add more unit tests to ensure correctness of methods.
    public static boolean unitTests() {
        System.out.println(); 

        // Test(s) for zooSchedule
        // Test case 1: dayOfWeek = 2, isPremium = true, emergency = false
        int zooSchedDay1 = 2;
        boolean zooSchedPremium1 = true;
        boolean emergency1 = false;
        String expectedSchedule = "Today's animals:\namphibians\n"
                                + "mammals\npolar bears\n";
        System.out.println("Expected zooSchedule Output 1:\n");
        System.out.println(expectedSchedule);
        System.out.println("-----------------");
        System.out.println("zooSchedule Output 1:\n");
        System.out.println();
        zooSchedule(zooSchedDay1,zooSchedPremium1,emergency1);
        System.out.println(); 

        // Test case 2: dayOfWeek = 0, isPremium = false, emergency = true
        int zooSchedDay2 = 0;
        boolean zooSchedPremium2 = false;
        boolean emergency2 = true;
        expectedSchedule = INVALID_DAY + "\n";
        System.out.println("Expected zooSchedule Output 2:\n");
        System.out.println(expectedSchedule);
        System.out.println("-----------------");
        System.out.println("zooSchedule Output 2:\n");
        System.out.println();
        zooSchedule(zooSchedDay2,zooSchedPremium2,emergency2);
        System.out.println();

        // Test case 3: dayOfWeek = 3, isPremium = false, emergency = false
        int zooSchedDay3 = 3;
        boolean zooSchedPremium3 = false;
        boolean emergency3 = false;
        expectedSchedule = "Today's animals:\nbirds\nreptiles\n";
        System.out.println("Expected zooSchedule Output 3:\n");
        System.out.println(expectedSchedule);
        System.out.println("-----------------");
        System.out.println("zooSchedule Output 3:\n");
        System.out.println();
        zooSchedule(zooSchedDay3,zooSchedPremium3,emergency3);
        System.out.println();


        // Test(s) for feedAnimals
        // Test case 1: dayOfWeek = 2, hourOfDay = 9
        int feedAnimalsDay1 = 2;
        int hourOfDay1 = 9;
        String expFeedMsg1 = FEED_AMPH_MAMM;
        String actFeedMsg1 = feedAnimals(feedAnimalsDay1,hourOfDay1);

        System.out.println("feedAnimals Output 1: " + actFeedMsg1); 
        System.out.println(); 

        if (!actFeedMsg1.equals(expFeedMsg1)) {
            System.out.println("FAILED: feedAnimals 1");
            return false;
        }

        // Test case 2: dayOfWeek = 3, hourOfDay = 24
        int feedAnimalsDay2 = 3;
        int hourOfDay2 = 24;
        String expFeedMsg2 = INVALID_INPUT;
        String actFeedMsg2 = feedAnimals(feedAnimalsDay2,hourOfDay2);

        System.out.println("feedAnimals Output 2: " + actFeedMsg2); 
        System.out.println(); 

        if (!actFeedMsg2.equals(expFeedMsg2)) {
            System.out.println("FAILED: feedAnimals 2");
            return false;
        }

        // Test case 3: dayOfWeek = 3, hourOfDay = 14
        int feedAnimalsDay3 = 3;
        int hourOfDay3 = 14;
        String expFeedMsg3 = FEED_BIRD_REPT;
        String actFeedMsg3 = feedAnimals(feedAnimalsDay3,hourOfDay3);

        System.out.println("feedAnimals Output 3: " + actFeedMsg3); 
        System.out.println(); 

        if (!actFeedMsg3.equals(expFeedMsg3)) {
            System.out.println("FAILED: feedAnimals 3");
            return false;
        }



        // Test(s) for calcTicketPrice
        // Test case 1: dayOfWeek = 2, age = 40, isPremium = true
        int ticketPriceDay1 = 2;
        int age1 = 40;
        boolean ticketPricePremium1 = true;
        double expectedPrice1 = 12.0;
        double actualPrice1 = calcTicketPrice(ticketPriceDay1,
                                              age1, ticketPricePremium1);

        System.out.println("calcTicketPrice Output 1: " + actualPrice1); 
        System.out.println(); 

        if (!(actualPrice1==expectedPrice1)) {
            System.out.println("FAILED: calcTicketPrice 1");
            return false;
        }

        // Test case 2: dayOfWeek = 6, age = 16, isPremium = true
        int ticketPriceDay2 = 6;
        int age2 = 16;
        boolean ticketPricePremium2 = true;
        double expectedPrice2 = 15.0;
        double actualPrice2 = calcTicketPrice(ticketPriceDay2,
                                              age2, ticketPricePremium2);

        System.out.println("calcTicketPrice Output 2: " + actualPrice2); 
        System.out.println(); 

        if (!(actualPrice2==expectedPrice2)) {
            System.out.println("FAILED: calcTicketPrice 2");
            return false;
        }

        // Test case 3: dayOfWeek = 7, age = 4, isPremium = false
        int ticketPriceDay3 = 7;
        int age3 = 4;
        boolean ticketPricePremium3 = false;
        double expectedPrice3 = 0.0;
        double actualPrice3 = calcTicketPrice(ticketPriceDay3,
                                              age3, ticketPricePremium3);

        System.out.println("calcTicketPrice Output 3: " + actualPrice3); 
        System.out.println(); 

        if (!(actualPrice3==expectedPrice3)) {
            System.out.println("FAILED: calcTicketPrice 3");
            return false;
        }

        // All test cases passed
        return true;
    }

    /**
     * The main method
     *
     * @return (void)
     */
    public static void main(String[] args) {

		if (unitTests()) {
			System.out.println("All unit tests passed.\n");
		} else {
			System.out.println("ERROR: Failed test.\n");
			return;
		}

    }
}