/**
 * Created by mstislav.begunov on 1/17/17.
 */

var events = require('events');

var EventEmitter = events.EventEmitter;

var server = new EventEmitter();

server.on('request', function (req) {
    req.approved = true;
});

server.on('request', function (req) {
    console.log(req);
});

server.emit('request', { from: "Vasya", type: "new"});
server.emit('request', { from: "Pupkin", type: "new"});

console.log(server.listenerCount('request'));
console.log(server.listeners('request'));