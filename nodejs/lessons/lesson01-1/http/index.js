var http = require('http');

http.createServer(function (req, res) {
    res.writeHead(200, {'Content-type': 'text/plain'});
    res.write("Hello node.js!\n");
    console.log(req);
    res.end();
}).listen(3000);

