/**
 * Created by mstislav.begunov on 1/31/17.
 */

module.exports = {
    getRequestUrl: function(req, res, next) {
        console.log('Request URL:', req.originalUrl);
        next();
    },
    getRequestMethod: function(req, res, next) {
        console.log('Request Type:', req.method);
        next();
    }
}