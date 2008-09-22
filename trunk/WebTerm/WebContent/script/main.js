/*--
 resize management 
--*/
var screenWidth = 0;
var screenHeight = 0;

/*--
 resize window function
--*/
function resizeWindow() {

	if (document.all) {
		screenHeight = document.documentElement.clientHeight;
		screenWidth = document.documentElement.clientWidth;
	} else if (document.getElementById) {
		screenHeight = window.innerHeight;
		screenWidth = window.innerWidth;
	}
	
	var js__main_div = document.getElementById("mainDiv");
	var js__top_div  = document.getElementById("topDiv");
	var js__side_div = document.getElementById("sideDiv");
	var js__page_div = document.getElementById("pageDiv");

	if (js__main_div) {
		js__main_div.style.width = (screenWidth) + "px";
		js__main_div.style.height = (screenHeight) + "px";
	}
	
	if (js__top_div) {
		js__top_div.style.width = (screenWidth - 10) + "px";
	}
	
	if (js__side_div) {
		js__side_div.style.height = (screenHeight - 40) + "px";
	}
	
	if (js__page_div) {
		js__page_div.style.width = (screenWidth - 155) + "px";
		js__page_div.style.height = (screenHeight - 40) + "px";
	}
	
}

//YAHOO.util.Event.addListener(window, "resize", resizeWindow);

function Timer() {
	resizeWindow();
	setTimeout("Timer()",1000);
}
Timer();
