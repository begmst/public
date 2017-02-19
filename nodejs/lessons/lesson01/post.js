/**
 * Created by mstislav.begunov on 12/27/16.
 */
console.log('post start');
function Post(title) {
    this.title = title;
}

Post.prototype.showTitle = function() {
    console.log('This title: ' + this.title);
}

module.exports = Post;

console.log('post end');
