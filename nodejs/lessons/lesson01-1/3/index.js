console.log('Index start');

var User = require('./user');

var user1 = new User('Vasya');
var user2 = new User('Pupkin');

user1.printName();
user2.printName();
user2.setAge(20);

console.log('Index finish');

