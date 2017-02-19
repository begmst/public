var express = require('express');
var router = express.Router();
var path = require('path');
var fs = require('fs');

/* GET users listing. */
router.get('/*', function(req, res, next) {
//    console.log(req.path);
//    console.log(req.method.toLowerCase());

    //var filePath = req.path + '/' + req.method.toLowerCase() + '.json';
    var filePath = path.join(__dirname, 'api', req.path, req.method.toLowerCase() + '.json');
    console.log('filePath:' + filePath);

    var data = fs.readFileSync(filePath);
    //res.write(data);

    res.json(data);
    //res.send(data);
});

module.exports = router;
