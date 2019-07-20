package rewards

class OnlineOrder {

    Date orderDate
    Integer orderNumber
    Float orderTotal

    static hasMany = [orderItems: OrderItem]
    static belongsTo = [customer: Customer]

    static constraints = {
    }
}
