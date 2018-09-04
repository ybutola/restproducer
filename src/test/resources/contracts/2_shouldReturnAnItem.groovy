org.springframework.cloud.contract.spec.Contract.make {
    request {
        method 'GET'
        url $(regex('/restproducer/2'))

        headers {
            header('Content-Type', 'application/json')
        }
    }

    response {
        status 302
        body($(producer([
                itemDescription: "new description",
                itemID         : "2",
                itemName       : "newItem"
        ]), consumer([
                itemDescription: "new description",
                itemID         : "2",
                itemName       : "newItem"
        ])))
        headers {
            header('Content-Type': 'application/json')
        }
    }
}