org.springframework.cloud.contract.spec.Contract.make {
    request {
        method 'POST'
        url '/restproducer'

        body([
                itemDescription: "new description",
                itemID         : "2",
                itemName       : "newItem"
        ])

        headers {
            header('Content-Type', 'application/json')
        }
    }
    response {
        status 201
        body(
                $(
                    producer(execute('verifyThatRecordIsCreated(2)')),
                    consumer([
                            itemDescription: "new description",
                            itemID         : "2",
                            itemName       : "newItem"
                    ])
                 )
        )
        headers {
            header('Content-Type': 'application/json;charset=UTF-8')
        }
    }
}