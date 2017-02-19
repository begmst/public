/**
 * Created by mstislav.begunov on 1/17/17.
 */

function Request() {
    this.bigData = new Array(1e6).join('-');

    this.send = function (data) {
        console.log(data);
    }
}

setInterval(function() {
    var req = new Request;
    console.log(process.memoryUsage().heapUsed);
}, 200);
