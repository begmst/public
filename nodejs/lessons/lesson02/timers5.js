/**
 * Created by mstislav.begunov on 1/17/17.
 */

var fs = require('fs');

console.log('1. Start ' + __filename);

fs.open(__filename, 'r', function (err, file) {
    console.log('2. I/O');
});

setImmediate(function() {
    console.log('3. Immediate');
})

process.nextTick(function() {
    console.log('4. Next Tick');
})

console.log('5. EOF');
