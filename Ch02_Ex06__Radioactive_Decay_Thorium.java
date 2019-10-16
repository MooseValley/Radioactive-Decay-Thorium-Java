/*
   Author: Mike O'Malley
   Description: InterferencePattern
   My solution 2.6 Application - Radioactive Decay, p34.

   Structured Fortran 77 for Engineers and Scientists,
   D. M. Etter.
   (C) 1983.  ISBN: 0-8053-2520-4

My old QIT (Uni) textbook from my uni days 1983-1987 - VERY weather beaten and worn now (almost 30 years later).

From page 34:

2.6 Application - Radioactive Decay
The rate of decomposition of a radioactive substance is dependent on the amount of radioactive material present.
:::
Example 2-2 Radioactive Decay of Thorium

The radioactive decay of thorium is given by:

    N = No * e ^ (-0.693 * t / 1.650E16)

where No is the initial amount of thorium and t represents the time elapsed (in seconds).
When t = 0, N = No and no decay has occured.
As t increases, the amount of thorium is decreased.

// Years:        Proportion of Thorium remaining
// 523,400,000 - 0.499948802501335

-------------------------------------

Ahhh, I just loved doing problems like these (and I still do).
So much fun, so much to learn and explore, so interesting.

Mike "Moose" O'Malley
Mon, 2-Nov-2015

*/

/*
Sample Output:

Years     Pct Thorium Remaining
   100,000   0.999868
   200,000   0.999735
   300,000   0.999603
   400,000   0.999470
   500,000   0.999338
   600,000   0.999206
   700,000   0.999073
   800,000   0.998941
   900,000   0.998809
 1,000,000   0.998676
 1,100,000   0.998544

:::::::
522,200,000 -   0.500744
522,300,000 -   0.500678
522,400,000 -   0.500611
522,500,000 -   0.500545
522,600,000 -   0.500479
522,700,000 -   0.500413
522,800,000 -   0.500346
522,900,000 -   0.500280
523,000,000 -   0.500214
523,100,000 -   0.500147
523,200,000 -   0.500081
523,300,000 -   0.500015
523,400,000 -   0.499949

*/

public class Ch02_Ex06__Radioactive_Decay_Thorium
{
   // Constants:
   private static double E                = 2.7182818284590452353603; // Euler's number E to 25 decimal places.
   private static double Seconds_Per_Year = 1.0 * 60 * 60 * 24 * 365; // 1 year.
   private static double Year_Increment   = 100000; // Had to keep increasing this until I saw some reasonably fast decay !!!

   public static void Radioactive_Decay_Thorium ()
   {
      double Time_Sec;
      double Exponent;
      double Thor_Start = 1.0;  // Kg.
      double Thor_Resid = Thor_Start;
      double Years      = 0;
      int count = 0;

      System.out.println (String.format ("%-10s", "Years") +
                          String.format ("%-10s", "Pct Thorium Remaining"));

      while (Thor_Resid > 0.5)
      {
         Years = Years + Year_Increment;

         Time_Sec = 1.0 * Years * Seconds_Per_Year;

         Exponent = -0.693 * Time_Sec / 1.650E16;

         Thor_Resid = Thor_Start * Math.pow (E, Exponent);

         System.out.println (String.format ("%,10.0f", Years) + " " +
                             String.format ("%,10.6f", Thor_Resid));
         count++;

         if (count > 10)
            System.exit(0);
      }
   }


   public static void main (String[] args)
   {
      Radioactive_Decay_Thorium ();
   }
} // public class Ch02_Ex06__Radioactive_Decay_Thorium
