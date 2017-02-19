'use strict';
var redis = require('redis');
const redisClient = redis.createClient();
const cheerio = require('cheerio');
const got = require('got');

class WebLoader {

    constructor(element ='h1', level = 3) {
        console.log('Web Loader start.');
        this.element = element;
        this.level = level;

        console.log(this);
    }

    run(url, element = this.element, level = this.level) {
        console.log('Run start.');
        console.log('Run params:', url, element, level);
        let result = {};
        let pageKey = this.generatePageKey(url, element, level);
        let record = redisClient.get(pageKey);
        console.log('Check redis page:', record);
        if (!record) {
            this.loadPage(url);
        } else {
            result = record;
        }
        return result;
        console.log('Run end.');
    }

    loadPage(url) {
        console.log('LoadPage start -', url);
        got(url)
        .then(response => {
            console.log('Length:', response.body.length);
            let $ = cheerio.load(response);
            var html = $(this.element).html();
            console.log('HTML:', this.element, html);
            process.exit(0);
        })
        .catch(error => {
            console.log('LoadPage error:', error.response.body);
            process.exit(1);
        });

        console.log('LoadPage end -', url);
    }

    generatePageKey(url, element, level) {
        let result = [url, element, level].join('_');
        console.log('generatePageKey:', result);
        return result;
    }
}
module.exports = WebLoader;
