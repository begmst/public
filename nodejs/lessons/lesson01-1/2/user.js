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

//console.log(module);

//global.User = User;
module.exports = User;
