/**
 * Created by mstislav.begunov on 12/27/16.
 */

var Post = require('./post');

console.log(Post);

var post1 = new Post('Hello');
var post2 = new Post('Front-end');

post1.showTitle();
post2.showTitle();