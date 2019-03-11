import java.util.Scanner;
import java.util.InputMismatchException;
public class CCArray 
{
    public static void main(String[] args) 
    {
        Scanner n  = new Scanner(System.in);
        
        int numberArray[] = { 4, 3, 8, 8, 5, 7, 6, 0, 1, 8, 4, 1, 0, 7, 0, 7};//Textbook Visa
    
        while(true)
        {
            numberArray = readLongIntoIntArray(n);
            if(numberArray == null)
            {
               break;
            } 

            if (isValid(numberArray))
            { 
               System.out.println(asString(numberArray) + " is valid");
            }
             else
            { 
                  System.out.println(asString(numberArray) + " is invalid");
            }
        }
     }
 
     public static String asString(int[] numberArray)
     {
         // called to convert int array into a numeric String -
         // fully implemented

	      String result = "";
	      for (int n = 0; n < numberArray.length; n++)
         {
	         result = result + numberArray[n];
         }
         return result;
     }
	
     public static boolean isValid(int[] number) /** Return true if the card number is valid */
     {
         if(getSize(number) > 12 && getSize(number) < 20)
         { 
            if(prefixMatched(number, 4) == true||prefixMatched(number, 37) == true||prefixMatched(number, 5) == true||prefixMatched(number, 6) == true)//NEED TO BE FIX TO ALLOW FOR MORE THAN THE FIRST CHAR OF ARRAY
            {
               if((sumOfDoubleEvenPlace(number)+ sumOfOddPlace(number))%10 == 0)
               {
                  return true;
               }
            }  
         }
         return false;
     }
 
     public static int sumOfDoubleEvenPlace(int[] number) /** Get the result from Step 2 */
     {
         int output = 0;
         for(int i = getSize(number)-1; i > 0; i--)
         {
            output += getDigit(number[i-1]*2);
            
            i--;
         }
         return output;
     }
 
     public static int getDigit(int number) /** Return this number if it is a single digit, otherwise, return the sum of the two digits */
     {
         int output = 0;
         if(getSize(number) > 1)
         {
            int remainder = number % 10;
            output = remainder + 1;
         }
         else
         {
            return number;
         }
         return output; 
     }
 
     public static int sumOfOddPlace(int[] number) /** Return sum of odd-place digits in number */
     {
         int output = 0;
         for(int i = getSize(number)-1; i > -1; i--)
         {
            output += getDigit(number[i]);

            i--;
         }
         return output;
     }
 
     public static boolean prefixMatched(int[] number, int d)/** Return true if the digit d is a prefix for number */ 
     {
         if(getSize(d) > 1)
         {
            if(getPrefix(number,2) == 37 || getPrefix(number,2) == 34 || getPrefix(number,2) == 35 || getPrefix(number,2) == 36 || getPrefix(number,2) == 30)
            {
               return true;
            }
            else
            {
               return false;
            }
         }
         else
         {
            if(number[0] == d)
            {
               return true;
            }
         }
         return false;
     }
 
     public static int getSize(long d)      /** Return the number of digits in d *** NOTE - define both of these as a method overload *** if you find the first one is not needed, ignore */ 
     {
        int count = 0;
        while(d != 0)
        {
            d /= 10;
            ++count;
        }
        return count;
     }
 
     public static int getSize(int[] d) 
     {
         return d.length;
     }

     public static long getPrefix(int[] number, int k)  /** Return the first k number of digits from number. If the number of digits in number is less than k, return number.  */
     {
         String output = "";
         for(int j = 0; j < k; j++)
         { 
            output += number[j] + "";
         }
         return Integer.parseInt(output);
     }
     
     public static int[] readLongIntoIntArray(Scanner input)
     {
	     long val = 0;
	     try
	     {
	         if(! input.hasNext())
            {
		          return null;
            }
            val = input.nextLong();
	     }
 	     catch (InputMismatchException e)
        {
            System.err.println("Unexpected read error");
            System.exit(2);
        }

        if (val <= 0)
        {
            return null;
        }
        String str = "" + val;
        char[] charArray = str.toCharArray();
        int[] intArray = new int[charArray.length];
        for (int k = 0; k < intArray.length; k++)
        {
            intArray[k] = Character.getNumericValue(charArray[k]);
        }
        return intArray;
     }
}   
