/**
 * Created by kate on 19.02.17.
 */

var p = new Promise((resolve, reject) => {
    resolve('resolve');
});

p.then(result => {
    console.log('Then: ', result);
});
