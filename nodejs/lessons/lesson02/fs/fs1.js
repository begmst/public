/**
 * Created by mstislav.begunov on 1/17/17.
 */

var fs = require('fs');

fs.readFile(__filename, function (err, data) {
    if (err) {
        console.log('Error readfile: ' + err);
    }
    console.log(data.toString('utf-8'));
});

