/*Prompt:  Create a budgeting program that calculates the user's loan principal, predicts when they should be able to pay off the debt, and determines if they are eligible for a loan relief
        - include the following variables:
            - loan_principal
            - loan_interest
            - new_principal
            - age
            - eligible_for_relief
            - loan_paid-off
 */

import kotlin.math.* //this line imports ALL math methods from the kotlin.math library
        // replace * with a specific method name to import only certain methods

fun main() {  //"fun" declares the function
    println("[Budgeting System]")
    print("Enter your name: ")
    val name = readln()

    print("Hello $name. Please enter your monthly salary: ")
    val monthly_salary = readln()

    println(" ") //space separation/break

    print("What is the total amount of your loan? ")
    val loan_principal = readln()

    print("What is the interest rate of your loan? ")
    val loan_interest = readln().toDouble() / 100   //.toDouble() specifies the variable's type as a double
    val new_principal = loan_principal.toInt() * (1 + (loan_interest / 12)).pow(12)  //format for exponentiation is: base.pow(exponent)

    println(" ") //space separation/break

    val yearly_salary = monthly_salary.toInt() * 12
    println("Your yearly salary is $" + yearly_salary + ".")
                val new_principal_rounded = String.format("%.2f", new_principal).toDouble()  //creates a variable to format the value of "new_principal" as having 2 decimal places behind it
    println("In 12 months, your loan's principal will be $" + new_principal_rounded + ".")

    println(" ") //space separation/break

    println("At the end of the year, you will have paid off your debt: " + (yearly_salary >= new_principal))  //if the user's new principal is less than or equal to their yearly salary, than the line prints "true." otherwise it prints "false"
    println("At the end of the year, you will still have some debt remaining: " + (yearly_salary < new_principal))  //line prints "true" if the yearly salary is less than the user's new principal. otherwise it prints "false"
    val remainder = String.format("%.2f", (yearly_salary - new_principal)).toDouble()  //creates a variable to format the value as having only 2 decimal places behind it
    println("At the end of the year, you will have $" + remainder + " of your salary left.")

    println(" ") //space separation/break

    println("The government is offering loan relief for person 25 and under, and for those 65 and over.")

    print("What is your age? ")
    val age = readln()

    val eligible_for_relief = (age.toInt() <= 25) || (age.toInt() >= 65)
    println("The relief is $10000. You are eligible for the relief: " + eligible_for_relief)

    val loan_paid_off = (new_principal <= yearly_salary) || (eligible_for_relief && ((yearly_salary + 10000) >= new_principal))
    print("With or without relief, you will be able to pay your loan in full: " + loan_paid_off)
}

