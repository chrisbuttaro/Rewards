package rewards


class CustomerController {

    static scaffold = Customer

    def calculationsService

    def lookup() {
        //  def customerInstance = Customer.list(sort: "lastName", order: "desc", max: 5, offset: 5)

        // There is no method by this name, LastName is a field in our domain.
        // This could be done with any field i.e. findAllByLastName gets all with the passed in last name.
        // If you know you only want a single result use findBy.
        def customerInstance = Customer.findByPhone(params.id, [sort: "lastName"])

    }

    def checkin() {

    }

    def index() {
        // Define the query params and pass params to list().
        params.max = 10
        respond Customer.list(params), model: [customerCount: Customer.count()]
    }

    def create() {
        respond new Customer(params)
    }

    def save(Customer customerInstance) {
        customerInstance.save()
        redirect(action: "show", id: customerInstance.id)
    }

    def show(Long id) {
        respond calculationsService.getTotalPoints(Customer.get(id))
    }

    def edit(Long id) {
        def customerInstance = Customer.get(id)
        respond customerInstance
    }

    def update(Long id) {
        def customerInstance = Customer.get(id)
        customerInstance.properties = params
        customerInstance.save()
        redirect(action: "show", id: customerInstance.id)
    }

    def delete (Long id) {
        def customerInstance = Customer.get(id)
        customerInstance.delete()
        redirect(action: "index")
    }

    def customerLookup(Customer lookupInstance) {
        def (customerInstance, welcomeMessage) = calculationsService.processCheckin(lookupInstance)
        render(view: "checkin", model:[customerInstance: customerInstance, welcomeMessage:welcomeMessage])
    }

    def profile(params){
        def customerInstance = Customer.findByPhone(params.id)
        [customerInstance: customerInstance]
    }

    def updateProfile(Customer customerInstance) {
        // Grails knows to execute an update if the entry's id already exists.
        customerInstance.save(flush: true)
        render(view: "profile", model: [customerInstance: customerInstance])
    }

}