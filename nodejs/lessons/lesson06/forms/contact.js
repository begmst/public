var Form = require('form-builder').Form;
 
// creates my form with some data for the inputs 
var myForm = Form.create({action: '/contact', class: 'myform-class'}, {
    name: "Name",
    email: "email",
    tel: "Tel"
});

myForm.open();
myForm.text().attr('name', 'name').render();
myForm.email().attr('email', 'email').render();
myForm.text().attr('tel', 'tel').render();
myForm.end(); // returns </form> 

module.exports = myForm;
