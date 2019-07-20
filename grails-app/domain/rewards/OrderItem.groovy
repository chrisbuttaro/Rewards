package rewards

class OrderItem {

    Integer quantity
    Float total

    static belongsTo = [order:OnlineOrder, product:Product]

    static constraints = {
    }
}
