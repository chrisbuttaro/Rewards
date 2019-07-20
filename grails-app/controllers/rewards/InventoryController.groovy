package rewards

class InventoryController {

    def index() {
        render "index"
    }

    def edit() {
        // Sends this map to the view.
        [product: "Breakfast Blend", sku: "BB01"]
    }

    def list() {
        // Gets all entries from the product domain
        [allProducts: Product.list()]
    }

    def text() {

    }
}
