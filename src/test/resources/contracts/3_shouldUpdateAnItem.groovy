org.springframework.cloud.contract.spec.Contract.make {
    ignored()

    request {
        method 'PUT'
        url '/restproducer'

        body([
                itemDescription: "the description has been changed",
                itemID         : "2"
        ])

        headers {
            header('Content-Type', 'application/json')
        }
    }

    response {
        status 200
    }
}