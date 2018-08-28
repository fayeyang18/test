window.onload =
function () {
var oDiv = document.getElementById("nav-1"),
	H = 0,
	Y = oDiv
while (Y) {
	H += Y.offsetTop;
	Y = Y.offsetParent
}
window.onscroll = function () {
	var s = document.body.scrollTop || document.documentElement.scrollTop
	if (s > H) {
		oDiv.style = "position: fixed; top: 0px;z-index:2; width:100%; padding-left:9pc"

	} else {
		oDiv.style = "height: 60px; margin: 0 auto; background-color: white; "
	}
}
}