/**
 * Created by mstislav.begunov on 1/17/17.
 */

var http = require('http');

var server = http.createServer(function (req, res) {
    console.log('Server start');
    setTimeout(function() {
        req.on('read', function() {
            console.log('req on');
        })
    }, 0);
    console.log('Server stop');
}).listen(3000);

console.log('http://localhost:3000/');
console.log('EOF');
