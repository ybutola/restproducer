import static org.springframework.cloud.contract.spec.Contract.*

make {
    request {
        method 'GET'
        url ('/restproducer/1')
        headers {
            header('Accept', 'text/plain, application/json, application/*+json, */*')
        }
    }

    response {
        status 302
        body($(producer([
                itemDescription: "new description",
                itemID         : "1",
                itemName       : "newItem"
        ]), consumer([
                itemDescription: "new description",
                itemID         : "1",
                itemName       : "newItem"
        ])))

        headers {
            header('Content-Type': 'application/json;charset=UTF-8')
        }
    }
}