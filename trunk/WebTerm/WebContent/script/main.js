/**
 * This file is part of WebTerm.
 *
 * WebTerm is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * WebTerm is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with WebTerm. If not, see <http://www.gnu.org/licenses/>.
 *
 * (C) COPYRIGHT 2008 - Charles FENDT
 */




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
