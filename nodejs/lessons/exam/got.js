const fs = require('fs');
const got = require('got');
 
got('http://todomvc.com')
    .then(response => {
        console.log(response.body);
        //=> '<!doctype html> ...' 
    })
;
// Streams
//got.stream('todomvc.com').pipe(fs.createWriteStream('index.html'));
 
// For POST, PUT and PATCH methods got.stream returns a WritableStream 
//fs.createReadStream('index.html').pipe(got.stream.post('todomvc.com'));
