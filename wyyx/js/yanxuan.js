// 限时购倒计时
function toDou(n) {
    return n < 10 ? '0' + n : '' + n;
}
var oH = document.getElementById('num-hour');
var oM = document.getElementById('num-minute');
var oS = document.getElementById('num-second');
var oDate = new Date();
var cur = new Date();
oDate.setFullYear(2018, 6, 25);
oDate.setHours(18, 0, 0, 0);
var tag =oDate.getTime();
function countDown() {
    var cur = new Date();
    var s = parseInt((tag-cur.getTime()) / 1000);
    if (s <= 0) {
        oH.innerHTML = oM.innerHTML = oS.innerHTML = 00;
    } else {
        var h = parseInt(s / 3600);
        s = s % 3600;
        var m = parseInt(s / 60);
        s = s % 60;

        oH.innerHTML = toDou(h);
        oM.innerHTML = toDou(m);
        oS.innerHTML = toDou(s);
    }
}
countDown();
setInterval(countDown, 1000);
oH.style.color='white';
oH.style.background='#615548';
oH.style.padding='5px';
oM.style.color='white';
oM.style.background='#615548';
oM.style.padding='5px';
oS.style.color='white';
oS.style.background='#615548';
oS.style.padding='5px';