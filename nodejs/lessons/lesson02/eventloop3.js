/**
 * Created by mstislav.begunov on 1/17/17.
 */


for (var i = 0; i < 10; i++) {
    setTimeout(function timer(i) {
        console.log(i)
    }, 0, i);
}

console.log('Welcome to loop.');
