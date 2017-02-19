/**
 * Created by mstislav.begunov on 12/27/16.
 */

var Post = require('./post');
var enL10N = require('./en');

var fs = require('fs');

console.log(Post);
console.log(enL10N);

var post1 = new Post(enL10N["title1"]);
var post2 = new Post(enL10N["title2"]);

post1.showTitle();
post2.showTitle();