public class Rational
{
    // instance variables: every Rational object will have its own copy
    // of these variables
    public int numerator;
    public int denominator;
    
    /**
     * Constructor: the special method that will actually create a new Rational
     * object
     * Constructors are always public
     * Constructors have the same name as the class
     * Constructors have no return type
     */
    public Rational(int a, int b) {
        numerator = a;
        denominator = b;
    }

    // *****
    // You should go ahead and copy and paste the methods
    // from last class into here:
    // *****

    public static int greatestCommonFactor(int a, int b){
        int gcf = 1;
        for (int i = 1; i<=Math.min(a,b);i++){
            if (a % i == 0 && b % i == 0 && i>gcf){
                gcf = i;
            }
        }
        return gcf;
    }
    public static Rational simplify(Rational r) {
        //divide both numerator and denomenator by the gcf
        int new_num = r.numerator / greatestCommonFactor(r.denominator, r.numerator);
        int new_denum = r.denominator/ greatestCommonFactor(r.denominator, r.numerator);
        Rational simp = new Rational(new_num, new_denum);
        return simp;
    }


    // *****
    // Here are all of our NON-STATIC methods:
    // *****

    // Returns whether or not the numerator is greater than or equal
    // to the denominator
    // Example:
    // Rational r = new Rational(5,2);
    // System.out.println(r.isImproper()) // true
    public boolean isImproper() {

        return (this.numerator >= this.denominator);
    }
    // Returns whether or not the Rational is currently simplified
    // or not
    // Example:
    // Rational r = new Rational(6,12);
    // System.out.println(r.isSimplified()) // false
    public boolean isSimplified() {
        if (greatestCommonFactor(this.numerator, this.denominator) == 1){
            return true;
        }
        return false;
    }

    // Calculates the double value of our Rational
    // Example:
    // Rational r = new Rational(3,4);
    // System.out.println(r.calculateDecimalValue()) // 0.75
    public double calculateDecimalValue() {
        double new_num = (double) (this.numerator);
        double new_denum = (double) (this.denominator);
        return new_num/new_denum;
    }



    // Returns the Rational we get from raising the rational number to an integer power
    // Example:
    // Rational r = new Rational(2,5);
    // System.out.println(r.pow(2)) // 4/25
    public Rational pow(int exponent) {

        double new_numpow = Math.pow(this.numerator, exponent);
        double new_denumpow = Math.pow(this.denominator,exponent);
        Rational n = new Rational((int)new_numpow, (int)new_denumpow);
        return n;
    }
    // Checks to see if either the numerator or denominator match a given number
    // Example:
    // Rational r = new Rational(3,4);
    // System.out.println(r.contains(3)) // true
    public boolean contains(int x) {
        if (x == this.numerator || x == this.denominator) {
            return true;
        }
        return false; // YOUR CODE HERE
    }

    // This returns a string representation of a Rational (e.g. "1/2")
    // This method has already been written for you
    @Override
    public String toString() {
        return this.numerator + "/" + this.denominator;
    }

    // *********
    // Here are is an example of a void method that changes the original Rational:
    // *********

    // This is a non-static version of simplify that returns a Rational
    // Example usage:
    // Rational r = new Rational(2, 4);
    // Rational s = r.simplify2(); // s = 1/2
    public Rational simplify2() {
        int gcf = gcf(this.numerator, this.denominator);
        int nume = this.numerator/gcf;
        int denom = this.denominator/gcf;
        Rational x = new Rational(nume, denom);
        return x;
    }

    // This is a non-static version of simplify that **changes** the original Rational
    // Note that the method is **void** because it doesn't need to return anything
    // Example usage:
    // Rational r = new Rational(2, 4);
    // r.simplify3(); // r is now equal to 1/2
    public void simplify3() {
        int gcf = gcf(this.numerator, this.denominator);
        this.numerator = this.numerator/gcf;
        this.denominator = this.denominator/gcf;
    }

    // Finds the greatest common factor between a and b
    // To find the greatest common factor,
    public static int gcf(int a, int b){
        int maxNum = 1;
        for (int i = 1; i <= a; i++) {
            if (a % i == 0 && b % i == 0) {
                maxNum = i;
            }
        }
        return maxNum;
    }

    // *********
    // Here are some methods that you will write later in class:
    // *********
    // Increments the current value of our Rational (increases the value
    // of the current Rational by 1/1)
    // Example:
    // Rational r = new Rational(3, 5);
    // r.increment(); // r is now 8/5
    public void increment() {
        this.numerator = this.numerator + this.denominator;
    }

    // Decrements the current value of our Rational (decreases the value
    // of the current Rational by 1/1)
    // Example:
    // Rational r = new Rational(6, 5);
    // r.decrement(); // r is now 1/5
    public void decrement() {
        this.numerator = this.numerator - this.denominator;
    }

    // Given an int input representing the new denominator, changes the
    // current Rational to an equivalent fraction with that new denominator
    // You can assume that the numerator will always end up as a whole number
    // Rational r = new Rational(3, 8);
    // r.changeToEquivalentFraction(64); // r is now 24/64 (which is equivalent to 3/8)
    public void changeToEquivalentFraction(int newDenominator) {
        this.numerator *= (double)newDenominator/this.denominator;
        this.denominator = newDenominator;
    }

    // **********
    // Methods you'll write for homework:
    // **********
    // Returns whether or not the Rational is a negative number
    // Example:
    // Rational r = new Rational(-3,4);
    // System.out.println(r.isNegative()) // true
    public boolean isNegative() {
        if (this.denominator >= 0 && this.numerator<0 ||this.denominator <= 0 && this.numerator>0 ){
            return true;
        }
        return false; // YOUR CODE HERE
    }

    // Calculates the reciprocal of a Rational number.
    // The reciprocal of 3/4 is 4/3, the reciprocal of 1/2 is 2/1
    // Example:
    // Rational r = new Rational(5,2);
    // System.out.println(r.reciprocal()) // 2/5
    public Rational reciprocal() {
        Rational r = new Rational(this.denominator,this.numerator);
        return r;
    }

    // Checks whether the current Rational is the exactly the same as other
    // Example:
    // Rational r = new Rational(2,5);
    // Rational s = new Rational(2,4);
    // System.out.println(r.equals(s)) // false
    public boolean equals(Rational other) {
        if (this.numerator == other.numerator && this.denominator == other.denominator){
            return true;
        }
        return false;
    }

    // Rounds the current Rational to the nearest whole number value
    // Example:
    // Rational r = new Rational(3, 2);
    // r.round(); // r is now 2/1
    //3 / 2 = 2/1 bc 3%2 = 1
    //5 / 8 goes to 8 / 8  bc 5 is more than half of 8. final answer is 1 because 8/8 is simplified
    //7 / 3 goes to 2 / 1 bc 7%3 is 1 and one is less than half of 3. you get the 2 from 7/3
    //11 / 2 goes to 6/1 bc 11%2 is 1, and 1 is equal to or more than half of one, so it rounds up.
    // you get the 6 from adding the mod to 11/2 (5).
    //12/5 12 within two of 10(less than half of 5) which is a multiple of 5. so the answer is 2 bc
    // then 12 is changed to ten then is just divided by 5.
    //14/5 goes to 3 bc: 14 is within 1 of a multiple of 5 (15) so 14 just changes to 15 then is divided by 5
    // rounding up or down: if 14%5 is more than half of 5, then you add the mod to 14, otherwise
    // u subtract the mod of 14 to reach the closest multiple of 5. then divide that number by 5
    public void round() {
        if(this.numerator % this.denominator >= denominator/2){
            this.numerator += this.numerator % this.denominator;
        }
        else {
            this.numerator -= this.numerator % this.denominator;
        }
        numerator = numerator/denominator;
        denominator = 1;
    }
}













