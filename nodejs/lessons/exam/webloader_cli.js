console.log('Webloader cli start.');

var config = require('./config');
console.log('Config: ', config);

var WebLoader = require('./webloader');

var params = process.argv;

params = params.slice(2);

console.log(params);

var url = params[0] ? params[0] : config.defaultUrl;
var element = params[1] ? params[1] : config.defaultElement;
var level = params[2] ? params[2] : config.defaultUrl;

console.log(url, element, level);

var webloader = new WebLoader(element, level);
console.log('Webloader: ', webloader);

var r = webloader.run(url).then(
    result => console.log('WebLoader promise result:', result),
    error => console.log('WebLoader promise error:', error)
);
console.log('Webloader result: ', r);
console.log('Webloader cli end.');
