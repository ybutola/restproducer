import static org.springframework.cloud.contract.spec.Contract.*

make {
    request {
        method 'PUT'
        url '/restproducer'

        body([
                itemDescription: "the description has been changed",
                itemID         : "1"
        ])

        headers {
            header('Content-Type', 'application/json')
        }
    }

    response {
        status 202
    }
}