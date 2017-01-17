/**
 * Created by mstislav.begunov on 1/17/17.
 */

var fs = require('fs');

fs.writeFile('1.txt', 'data', function (err) {
    if (err) {
        console.log('writeFile: ' + err);
    }
})

fs.rename('1.txt', '2.txt', function (err) {
    if (err) {
        console.log('rename: ' + err);
    }
});