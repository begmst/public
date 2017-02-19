/**
 * Created by mstislav.begunov on 1/17/17.
 */

var EventEmitter = require('events').EventEmitter;

var db = new EventEmitter()
db.setMaxListeners(0);

function Request() {
    var self = this;

    this.bigData = new Array(1e6).join('-');

    this.send = function(data) {
        console.log(data);
    }

    function onData(data) {
        console.log(data);
    }

    db.on('data', onData);

    this.end = function () {
        db.removeListener('data', onData);
    };
}

setInterval(function() {
    var req = new Request;
    console.log(process.memoryUsage().heapUsed);
    console.log(db);
}, 200);
