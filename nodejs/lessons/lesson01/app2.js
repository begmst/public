/**
 * Created by mstislav.begunov on 12/27/16.
 */
function Post(title) {
    this.title = title;

    this.showTitle = function() {
        console.log('This title: ' + this.title);
    }
}

var post1 = new Post('Hello');
var post2 = new Post('Front-end');

post1.showTitle();
post2.showTitle();