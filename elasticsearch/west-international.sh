#!/bin/bash
curl -XGET 'https://frontapp_prod:j4rd7bBv2m9JpvLQ@280049b183451efdc5e6dca9a58c29f8.eu-west-1.aws.found.io:9243/rdey-content-bundle-14/company/_search?pretty' -H 'Content-Type: application/json' -d'
{
    "query": {
        "match" : {
            "nid" : "356"
        }
    }
}
'
