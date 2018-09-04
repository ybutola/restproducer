org.springframework.cloud.contract.spec.Contract.make {
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
        body($(producer(execute("verifyThatRecordIsUpdated(2, 'the description has been changed')")), consumer([
                itemDescription: "the description has been changed",
                itemID         : "2",
                itemName       : "newItem"
        ])))
        headers {
            header('Content-Type': 'application/json')
        }
    }
}