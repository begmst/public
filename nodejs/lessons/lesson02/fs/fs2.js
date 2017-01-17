/**
 * Created by mstislav.begunov on 1/17/17.
 */

var fs = require('fs');

fs.readFile('kolbasa', { encoding: 'utf-8'}, function (err, data) {
    if (err) {
        if (err.code = 'ENOENT') {}
        console.log('Error readfile: ' + err.message);
    } else {
        console.log(data.toString('utf-8'));
    }
});

