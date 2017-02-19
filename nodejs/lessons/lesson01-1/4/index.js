console.log('Index start');

var User = require('./user');
var l10n = require('./l10n/en');

console.log(l10n);

var user1 = new User('Vasya');
var user2 = new User('Pupkin');

console.log(l10n.hello);
user1.printName();
console.log(l10n.welcome);
user2.printName();
user2.setAge(20);

console.log('Index finish');

