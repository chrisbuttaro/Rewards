package rewards

import grails.gorm.transactions.Transactional

@Transactional
class CalculationsService {

   /*
    * Creates a welcome message for the checkin view.
    */
    def welcome(customerInstance) {
        def firstName = customerInstance.firstName
        def totalPoints = customerInstance.totalPoints
        def welcomeMessage = ""

        switch (totalPoints) {
            case 5:
                welcomeMessage = "Welcome $firstName, your next drink is free."
                break
            case 6:
                welcomeMessage = "Welcome $firstName, this drink is on us."
                break
            default:
                welcomeMessage = "Welcome $firstName you now have $totalPoints points."
        }
        return welcomeMessage
    }

    /*
     * Sums the points of a customer.
     */
    def getTotalPoints(customerInstance) {
        def sumAwards = 1
        customerInstance.awards.each {
            sumAwards += it.points
        }
        customerInstance.totalPoints = sumAwards

        return customerInstance
    }

    /*
     *  Processes the checkin of a customer after they enter their phone number.
     */
    def processCheckin(Customer lookupInstance) {
        // Look up the customer by phone number.
        def customerInstance = Customer.findByPhone(lookupInstance.phone)

        if(!customerInstance) {
            // If customer was not in the db create a new customer instance.
            customerInstance = new Customer(phone: lookupInstance.phone)
            // Set a temporary name for the welcome message.
            customerInstance.firstName = "New Customer"
        }
        getTotalPoints(customerInstance)

        if (customerInstance.totalPoints < 6) {
            // Give the customer a point.
            customerInstance.addToAwards(new Award(awardDate: new Date(), type: "Purchase", points: 1))
        } else {
            // Zero out the customer's points.
            customerInstance.addToAwards(new Award(awardDate: new Date(), type: "Reward", points: -5))
        }
        // Save the customer.
        customerInstance.save()
        // Update the welcome message.
        def welcomeMessage = welcome(customerInstance)
        // Return the customer and the welcome message.
        return [customerInstance, welcomeMessage]
    }

}

