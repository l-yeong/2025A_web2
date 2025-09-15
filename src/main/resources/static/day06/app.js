// ************ 다른 js 의 export 된 자료 가져오기 ************

// [1] math.js 자료 가져오기
import add from './math.js';
add(3,4);

// [2] config.js 자료 가져오기
import config from './config.js';
console.log(config);

// [3] util.js 자료 가져오기, default 아닌 자료는 {} 묶는다.
import hello,{PI,E}from './util.js';
hello("유재석");
console.log(PI);
console.log(E)
