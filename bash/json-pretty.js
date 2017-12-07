const util = require('util')


var stdin = process.openStdin();

stdin.addListener("data", function(d) {
    // note:  d is an object, and when converted to a string it will
    // end with a linefeed.  so we (rather crudely) account for that  
    // with toString() and then trim() 
    var s = d.toString().trim();
const object = JSON.parse(s);
console.log(util.inspect(object, {depth: null, colors: true}));
});
