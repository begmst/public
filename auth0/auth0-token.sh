#!/bin/bash
curl --request POST \
  --url https://redeye.eu.auth0.com/oauth/token \
  --header 'content-type: application/json' \
  --data '{"client_id":"0h5K5VT0kJ6Zj5kBh5pF46YuPlBaziXR","client_secret":"nSCGmGBNvYtjDrkO0FZtq9m0EOh-pOqqidod0YQ7xZOYA1yOHpylosx4FmscJ956","audience":"https://redeye.eu.auth0.com/api/v2/","grant_type":"client_credentials"}'
