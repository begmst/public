var express = require('express');
var exphbs  = require('express-handlebars');
var app = express();

var formContact = require("./forms/contact");

app.engine('handlebars', exphbs({ defaultLayout: 'main' }));
app.set('view engine', 'handlebars');

app.get('/', function (req, res) {
    res.render('home', {
        title: 'This is TITLE!'
    });
});

app.get('/contact', function (req, res) {
    res.render('contact', {
        form: formContact.render()
    });
});

app.listen(5000, function () {
    console.log('listening on http://localhost:5000');
});
