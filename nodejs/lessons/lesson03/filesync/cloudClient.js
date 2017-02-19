var fs = require('fs');
var path = require('path');
var agent = require('superagent');
var ProgressBar = require('ascii-progress');

var CLOUD_URL = 'localhost:3000/upload';

module.exports = {
  upload: postFileToCloud
};

function postFileToCloud(filePath, username, password, cb) {
    console.log(111, filePath, username, password);
  fs.stat(filePath, function(err, stats){//TO-DO: bluebird promisify
    if (err) {
      return cb(err);
    }
    console.log('Trying to sync file', filePath, 'with size', stats.size);
    var bar = new ProgressBar({
        schema: 'uploading [:bar] :percent',
        total: 100,
        width: 20
    });
    var fileStream = fs.createReadStream(filePath);
    var uploadUrl = generateUploadUrl(filePath);
    agent
      .post(uploadUrl)
      .auth(username, password)
      .type('form')
      .on('progress', function(e) {
        var percentDone = Math.floor((e.loaded / e.total) * 100);
        bar.tick(percentDone);
      })
      .attach('syncfile', fileStream)
      .set('Accept', 'application/json')
      .end(cb);
  });
}

function generateUploadUrl(filePath) {
  var filePathQuery = encodeURI(path.resolve(filePath));
    console.log(filePath);
    console.log(path.resolve(filePath));
  return CLOUD_URL + '?filePath=' + filePathQuery;
}
