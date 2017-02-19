function User(name) {
    this.name = name;

    this.setAge = function(age) {
        this.age = age;
        console.log('Age: ' + this.age);
    }

    this.printName = function() {
        console.log(this.name);
    }
}

var user1 = new User('Vasya');
var user2 = new User('Pupkin');

user1.printName();
user2.printName();
user2.setAge(20);
