import javax.lang.model.util.ElementScanner6;

///////////////////////////////////////////////////////////////////////////////
//                   
// Title:              Assignment3
// Files:              Assignment3 starter code: Sections.java
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
 * This class contains three methods:
 * LetterGradeCalculator, accountcreation, and sortThreeStrings
 * 
 *
 * Bugs: none
 *
 * @author Tom Tang
 */

public class Selections {

    // Feel free to create extra variables if necessary.

    /* Variables used for letterGradeCalculator */
    // Useful numbers
    private final static int NUM_SCORES = 4;
    private final static int FULL_SCORE = 100;
    private final static int FAIL_CUTOFF = 60;
    private final static int A_MIN = 90;
    private final static int B_MIN = 80;
    private final static int C_MIN = 70;
    private final static int D_MIN = 60;
    private final static int F_MIN = 0;

    // Useful strings
    private final static String INVALID_SCORES = "Invalid set of scores";
    private final static String GRADE_A = "A";
    private final static String GRADE_B = "B";
    private final static String GRADE_C = "C";
    private final static String GRADE_D = "D";
    private final static String GRADE_F = "F";


    /* Variables used for accountCreation */
    // Domains
    private final static String GMAIL = "@gmail.com";
    private final static String YAHOO = "@yahoo.com";
    private final static String OUTLOOK = "@outlook.com";
    private final static String UCSD = "@ucsd.edu";

    // Output messages
    private final static String INVALID_DOMAIN = "Invalid email domain";
    private final static String ERROR_LENGTH = 
        "Password must be longer than 8 characters";
    private final static String ERROR_CAPITAL = 
        "Password must begin with a capital letter";
    private final static String ERROR_SIMILAR = 
        "Password must not contain the username";
    private final static String ERROR_DIGIT = 
        "Password must end with a digit";
    private final static String SUCCESS = "Account created successfully";
    

    /* Variables used for sortThreeStrings */
    private final static String COMMA_SEP = ", ";


    /**
    * Calculates the average of the highest 3 scores and the final score 
    * then gives out the corresponding letter grade
    *
    * @param (double score1) (first score)
    * @param (double score2) (second score)
    * @param (double score3) (third score)
    * @param (double score4) (fourth score)
    * @param (double finalScore) (score of final)
    * @return (the letter grade of the corresponding average score)
    */
    public static String letterGradeCalculator(double score1, double score2,
                                               double score3, double score4, 
                                               double finalScore) {
        String letterGrade = "";
        double averageScore = 0;
        //checks if the scores are valid then calculate the average score of the top 3
        if(score1<0||score1>100||score2<0||score2>100||score3<0||score3>100||
            score4<0||score4>100||finalScore<0||finalScore>100)
        {
            return INVALID_SCORES;
        }
        else if(finalScore<D_MIN)
        {
            return GRADE_F;
        }
        else if(score1<=score2&&score1<=score3&&score1<=score4)
        {
            averageScore = (score2 + score3 + score4 + finalScore)/NUM_SCORES;
        }
        else if(score2<=score1&&score2<=score3&&score2<=score4)
        {
            averageScore = (score1 + score3 + score4 + finalScore)/NUM_SCORES;
        }
        else if(score3<=score1&&score3<=score2&&score3<=score4)
        {
            averageScore = (score1 + score2 + score4 + finalScore)/NUM_SCORES;
        }
        else
        {
            averageScore = (score1 + score2 + score3 + finalScore)/NUM_SCORES;
        }
        
        if(averageScore>=A_MIN)
        {
            letterGrade = GRADE_A;
        }
        else if(averageScore>=B_MIN)
        {
            letterGrade = GRADE_B;
        }
        else if(averageScore>=C_MIN)
        {
            letterGrade = GRADE_C;
        }
        else if(averageScore>=D_MIN)
        {
            letterGrade = GRADE_D;
        }
        else
        {
            letterGrade = GRADE_F;
        }
        return letterGrade;
    }


    /**
    * Tells the user whther if the email and password is valid or not 
    * for creating an account
    *
    * @param (String email) (the string for email)
    * @param (String password) (the string for password)
    * @return (a string telling whether the email and password is valid or not)
    */
    public static String accountCreation(String email, String password) {
        String message = "";
        String emailName = "";
        boolean similar = false;

        //check if email is valid
        if(email.substring(email.length()-9,email.length()).equals(UCSD))
        {
            emailName = email.substring(0,email.length()-9);
        }
        else if(email.substring(email.length()-10,email.length()).equals(GMAIL)
            ||email.substring(email.length()-10,email.length()).equals(YAHOO))
        {
            emailName = email.substring(0,email.length()-10);
        }
        else if(email.substring(email.length()-12,email.length()).equals(OUTLOOK))
        {
            emailName = email.substring(0,email.length()-12);
        }
        else
        {
            return INVALID_DOMAIN;
        }
        //check if the password contains the name of email
        if(emailName.length()<=password.length())
        {
            for(int i=0; i<=password.length()-emailName.length(); i++)
            {
                if(emailName.equalsIgnoreCase(
                        password.substring(i,i+emailName.length())))
                {
                    similar = true;
                    break;
                }
            }
        }
        //check if password is valid
        if(password.length()<9)
        {
            return(ERROR_LENGTH);
        }
        else if(Character.isLowerCase(password.charAt(0)))
        {
            return(ERROR_CAPITAL);
        }
        else if(!Character.isDigit(password.charAt(password.length()-1)))
        {
            return(ERROR_DIGIT);
        }
        else if(similar)
        {
            return(ERROR_SIMILAR);
        }
        else
        {
            message = SUCCESS;
        }
        return message; 
    }


    // Reminder: you do not need to keep starter code provided,
    //           it is just a guide for you in case you would like to use it.
    /**
    * Sorts three strings in lexicographical order
    *
    * @param (String str1) (First string)
    * @param (String str1) (Second string)
    * @param (String str1) (Third string)
    * @return (the strings in lexicographical order)
    */
    public static String sortThreeStrings(String str1, String str2,
                                          String str3) {
        String first = "", second = "", third = "";
        //Cases with str1 coming before str2
        if(str1.compareTo(str2)<=0)
        {
            first = str1;
            //str1 <= str2 <= str3
            if(str2.compareTo(str3)<=0)
            {
                second = str2;
                third = str3;
            }
            //str1 <= str3 <= str2
            else if(str2.compareTo(str3)>=0
                &&str1.compareTo(str3)<=0)
            {
                second = str3;
                third = str2;
            }
            //str3 <= str1 <= str2
            else
            {
                first = str3;
                second = str1;
                third = str2;
            }
        }
        //Cases with str2 coming before str1
        else if(str1.compareToIgnoreCase(str2)>=0)
        {
            third = str1;
            //str3 <= str2 <= str1
            if(str2.compareToIgnoreCase(str3)>=0)
            {
                second = str2;
                first = str3;
            }
            //str2 <= str3 <=str1
            else if(str2.compareToIgnoreCase(str3)<=0
                &&str1.compareToIgnoreCase(str3)>=0)
            {
                second = str3;
                first = str2;
            }
            //str2 <= str1 <= str3
            else if(str1.compareToIgnoreCase(str3)<=0)
            {
                first = str2;
                second = str1;
                third = str3;
            }
        }
        return first + COMMA_SEP + second + COMMA_SEP + third;
    }


    public static boolean unitTests() {
        System.out.println(); 

        // Test(s) for letterGradeCalculator
        // Test case 1: score1 = 63.2, score2 = 86.4, score3 = 94, score4 = 74.2,
        //              finalScore = 82.3
        double score1Test1 = 63.2, score2Test1 = 86.4, score3Test1 = 94,
               score4Test1 = 74.2, finalScoreTest1 = 82.3;
        String expectedGrade1 = "B"; 
        String actualGrade1 = letterGradeCalculator(score1Test1, score2Test1,
                                                   score3Test1, score4Test1,
                                                   finalScoreTest1);

        System.out.println("letterGradeCalculator Output 1: " 
                           + actualGrade1); 
        System.out.println(); 

        if (!(actualGrade1).equals(expectedGrade1)) {
            System.out.println("FAILED: letterGradeCalculator 1");
            return false;
        }

        // Test case 2: score1 = 90, score2 = 89.5, score3 = 89.5, score4 = 90,
        //              finalScore = 90.5
        double score1Test2 = 60, score2Test2 = 0, score3Test2 = 60,
               score4Test2 = 60, finalScoreTest2 = 59.5;
        String expectedGrade2 = "F"; 
        String actualGrade2 = letterGradeCalculator(score1Test2, score2Test2,
                                                   score3Test2, score4Test2,
                                                   finalScoreTest2);

        System.out.println("letterGradeCalculator Output 2: " 
                           + actualGrade2); 
        System.out.println(); 

        if (!(actualGrade2).equals(expectedGrade2)) {
            System.out.println("FAILED: letterGradeCalculator 2");
            return false;
        }

        // Test case 3: score1 = 0, score2 = -89.5, score3 = 89.5, score4 = 90,
        //              finalScore = 90.5
        double score1Test3 = 0, score2Test3 = -89.5, score3Test3 = 89.5,
               score4Test3 = 90, finalScoreTest3 = 90.5;
        String expectedGrade3 = "Invalid set of scores"; 
        String actualGrade3 = letterGradeCalculator(score1Test3, score2Test3,
                                                   score3Test3, score4Test3,
                                                   finalScoreTest3);

        System.out.println("letterGradeCalculator Output 3: " 
                           + actualGrade3); 
        System.out.println(); 

        if (!(actualGrade3).equals(expectedGrade3)) {
            System.out.println("FAILED: letterGradeCalculator 3");
            return false;
        }

        // Test(s) for accountCreation
        // Test case 1: email = "spiderman@ucsd.edu", password = "spidermanrox"
        String emailTest1 = "spiderman@ucsd.edu"; 
        String passwordTest1 = "Spidermanrox1"; 
        String expMsg1 = ERROR_SIMILAR;
        String actMsg1 = accountCreation(emailTest1,passwordTest1);

        System.out.println("accountCreation Output 1: " + actMsg1); 
        System.out.println(); 

        if (!actMsg1.equals(expMsg1)) {
            System.out.println("FAILED: accountCreation 1");
            return false;
        }

        // Test case 2: email = "apple@outlook.com", password = "Pinapple1"
        String emailTest2 = "apple@outlook.com"; 
        String passwordTest2 = "Pinapple1"; 
        String expMsg2 = ERROR_SIMILAR;
        String actMsg2 = accountCreation(emailTest2,passwordTest2);

        System.out.println("accountCreation Output 2: " + actMsg2); 
        System.out.println(); 

        if (!actMsg2.equals(expMsg2)) {
            System.out.println("FAILED: accountCreation 2");
            return false;
        }

        // Test case 3: email = "apple@outlook.com", password = "PinapPple1"
        String emailTest3 = "apple@outlook.com"; 
        String passwordTest3 = "PinapPple1"; 
        String expMsg3 = SUCCESS;
        String actMsg3 = accountCreation(emailTest3,passwordTest3);

        System.out.println("accountCreation Output 3: " + actMsg3); 
        System.out.println(); 

        if (!actMsg3.equals(expMsg3)) {
            System.out.println("FAILED: accountCreation 3");
            return false;
        }

        // Test case 4: email = "giantsuperbowl@yahoo.com", password = "Superbowl"
        String emailTest4 = "superbowl@yahoo.com"; 
        String passwordTest4 = "Superbowl"; 
        String expMsg4 = ERROR_DIGIT;
        String actMsg4 = accountCreation(emailTest4,passwordTest4);

        System.out.println("accountCreation Output 4: " + actMsg4); 
        System.out.println(); 

        if (!actMsg4.equals(expMsg4)) {
            System.out.println("FAILED: accountCreation 4");
            return false;
        }

        // Test(s) for sortThreeStrings
        // Test case 1: "hello" "ello" "bell"
        String string1 = "hello", string2 = "ello", string3 = "bell";
        String expectedOrder = "bell, ello, hello";
        String actualOrder = sortThreeStrings(string1, string2, string3);

        System.out.println("sortThreeStrings Output 1: " + actualOrder); 
        System.out.println(); 

        if (!actualOrder.equals(expectedOrder)) {
            System.out.println("FAILED: sortThreeStrings 1");
            return false;
        }

        // Test case 2: "hello" "hello" "Hello"
        string1 = "hello"; string2 = "hello"; string3 = "Hello";
        expectedOrder = "Hello, hello, hello";
        actualOrder = sortThreeStrings(string1, string2, string3);

        System.out.println("sortThreeStrings Output 2: " + actualOrder); 
        System.out.println(); 

        if (!actualOrder.equals(expectedOrder)) {
            System.out.println("FAILED: sortThreeStrings 2");
            return false;
        }

        // Test case 3: "baNana" "bananA" "apple"
        string1 = "baNana"; string2 = "bananA"; string3 = "apple";
        expectedOrder = "apple, baNana, bananA";
        actualOrder = sortThreeStrings(string1, string2, string3);

        System.out.println("sortThreeStrings Output 3: " + actualOrder); 
        System.out.println(); 

        if (!actualOrder.equals(expectedOrder)) {
            System.out.println("FAILED: sortThreeStrings 3");
            return false;
        }

        // All test cases passed
        return true;
    }

    /**
    * the main method
    *
    * @return void
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