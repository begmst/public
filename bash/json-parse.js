/*
console.log(JSON.parse('{}'));              // {}
console.log(JSON.parse('true'));            // true
console.log(JSON.parse('"foo"'));           // "foo"
console.log(JSON.parse('[1, 5, "false"]')); // [1, 5, "false"]
console.log(JSON.parse('null'));            // null
*/
var str = '{ a:1, b:2, c:3 }';
console.log(JSON.parse(str.substring(0, str.length-1)));            // null
//console.log(JSON.parse('{ a:1, b:2, c:3 }'));            // null
