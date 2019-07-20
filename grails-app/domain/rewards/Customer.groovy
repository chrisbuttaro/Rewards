package rewards

class Customer {

    String firstName
    String lastName
    Long phone
    String email
    Integer totalPoints
    // Defines the one customer to many awards & orders relationships.
    static hasMany = [awards:Award, orders:OnlineOrder]


    static constraints = {
        phone(nullabe: true)
        firstName(nullable: true)
        lastName(nullable: true)
        email(nullable: true, email: true)
        totalPoints(nullable: true, max: 10)
    }
}
