var express = require('express');
var requestMw = require('./request-mw');;

var app = express();

var requestTime = function (req, res, next) {
    req.requestTime = Date.now();
    next();
};

app.use(requestTime);

app.get('/', function (req, res) {
    res.send('Hello World! Requested at: ' + req.requestTime);
});

/*
app.use('/user/:id', function(req, res, next) {
     console.log('Request URL:', req.originalUrl);
     next();
}, function (req, res, next) {
     console.log('Request Type:', req.method);
     next();
});
*/

app.use('/user/:id', requestMw.getRequestUrl, requestMw.getRequestMethod);

app.use('/', function (req, res) {
    res.send('END');
});


app.listen(5000, function () {
    console.log('listening on http://localhost:5000');
});

