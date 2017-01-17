/**
 * Created by mstislav.begunov on 1/17/17.
 */

var http = require('http');

var server = http.createServer(function (req, res) {
    console.log('Inside server');
}).listen(3000);

setTimeout(function () {
    server.close(function() {
        console.log('Process exit');
        process.exit();
    });
    console.log('Server close');
}, 3000);

setInterval(function() {
    console.log(process.memoryUsage())
}, 1000);

console.log('EOF');
