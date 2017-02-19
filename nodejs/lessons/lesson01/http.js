/**
 * Created by mstislav.begunov on 12/27/16.
 */

var http = require('http');
var url = require('url');

var server = http.createServer(function (request, response) {
    var headers = request.headers;

    console.log('web server start');
    console.log(request.url);
    console.log(headers);

    var urlObj = url.parse(request.url);
    console.log(urlObj);

    response.setHeader('Content-Type', 'text/html');
    response.write('Hello, World!');
    response.end();
});

server.listen(3000);
