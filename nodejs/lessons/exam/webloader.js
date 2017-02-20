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
        this.visitedUrls = [];

        console.log(this);
    }

    run(url, element = this.element, level = this.level) {
        let promise = new Promise((resolve, reject) => {
            try {
                console.log('Run start.');
                console.log('Run params:', url, element, level);
                let result = [];
                let pageKey = this.generatePageKey(url, element, level);
                let record = redisClient.get(pageKey);
                console.log('Check redis page:', record);
                if (!record) {
                    console.log('No redis record.');
                    this.loadPage(url).then(response => {
                        console.log('LoadPage outer response:', response);
                        result.push({[pageKey]: response});
                        let r = redisClient.set(pageKey, JSON.stringify(result));
                        resolve(result);
                    });
                } else {
                    console.log('Redis record present.');
                    result = JSON.parse(result);
                }
                console.log('Run end.');
            } catch (error) {
                reject(error);
            }
        });
        return promise;
    }

    loadPage(url) {
        console.log('LoadPage start -', url);
        let promise = got(url)
        .then(response => {
            let self = this;
            console.log('Length:', response.body.length);
            let body = response.body;
            let $ = cheerio.load(body, { decodeEntities: false });
            let innerHtml = '';
            let result = [];
            $(this.element).each(function(i, elem) {
                let text = $(this).html().trim();
                console.log(self.element + ' #' + i + ':', text);
                result.push(text);
            });
            console.log('LoadPage result:', result);
            let promise = new Promise((resolve, reject) => {
                resolve(result);
            });
            return promise;
        })
        .catch(error => {
            console.log('LoadPage error:', error.response.body);
            process.exit(1);
        });
        console.log('LoadPage Promise:', promise);
        console.log('LoadPage end -', url);
        return promise;
    }

    generatePageKey(url, element, level) {
        let result = [url, element, level].join('_');
        console.log('generatePageKey:', result);
        return result;
    }
}
module.exports = WebLoader;
