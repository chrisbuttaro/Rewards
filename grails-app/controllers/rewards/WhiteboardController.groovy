package rewards

class WhiteboardController {

    def calculationsService

    def index() { }

    def variables () {
        def myTotal = 1
        render("Total: " + myTotal)

        def firstName = "Chris"
        render("</br>Name: " + firstName)

        def today = new Date()
        render("</br>Today is: " + today)

    }

    def strings () {
        def firstName = "Chris"
        def lastName = "Buttaro"
        def points = 1000000
        render("Welcome back $firstName $lastName you have $points points")

    }

    def conditions() {
        def welcomeMessage = calculationsService.welcome(params)
        render welcomeMessage
    }
}
