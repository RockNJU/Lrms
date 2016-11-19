<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!----Calender -------->
  <link rel="stylesheet" href="/maven-web-demo/css/clndr.css" type="text/css" />
  <script src="/maven-web-demo/js/underscore-min.js" type="text/javascript"></script>
  <script src= "/maven-web-demo/js/moment-2.2.1.js" type="text/javascript"></script>
  <script src="/maven-web-demo/js/clndr.js" type="text/javascript"></script>
  <script src="/maven-web-demo/js/site.js" type="text/javascript"></script>
<!----End Calender -------->

    <div class="col-md-3">
			<div class="courses_box1-left">
	       </div>
	       
	       	<div class="personBox">
              <div class="personBox_1">
              <h3>${sessionScope.user.username}</h3>
                 <div class="person_image_desc">
                   <p>${sessionScope.user.uid}</p>
                </div>
                <div class="clearfix"> </div>
             </div>
             <div class="person_description">
                <p>联系电话：${sessionScope.user.tel}</p>
                <p>电子邮箱：${sessionScope.user.email}</p>
             </div>
          </div>
	       		<br/><br/>
	       		
	             <div class="news">
                    <h3>备忘</h3>
                    <div class="section-content" id="notice-content">
                    </div>
                </div>
                
   		<div class="cal1 cal_2"><div class="clndr"><div class="clndr-controls"><div class="clndr-control-button"><p class="clndr-previous-button">previous</p></div><div class="month">September 2015</div><div class="clndr-control-button rightalign"><p class="clndr-next-button">next</p></div></div><table class="clndr-table" border="0" cellspacing="0" cellpadding="0"><thead><tr class="header-days"><td class="header-day">S</td><td class="header-day">M</td><td class="header-day">T</td><td class="header-day">W</td><td class="header-day">T</td><td class="header-day">F</td><td class="header-day">S</td></tr></thead><tbody><tr><td class="day past adjacent-month last-month calendar-day-2015-08-30"><div class="day-contents">30</div></td><td class="day past adjacent-month last-month calendar-day-2015-08-31"><div class="day-contents">31</div></td><td class="day today calendar-day-2015-09-01"><div class="day-contents">1</div></td><td class="day calendar-day-2015-09-02"><div class="day-contents">2</div></td><td class="day calendar-day-2015-09-03"><div class="day-contents">3</div></td><td class="day calendar-day-2015-09-04"><div class="day-contents">4</div></td><td class="day calendar-day-2015-09-05"><div class="day-contents">5</div></td></tr><tr><td class="day calendar-day-2015-09-06"><div class="day-contents">6</div></td><td class="day calendar-day-2015-09-07"><div class="day-contents">7</div></td><td class="day calendar-day-2015-09-08"><div class="day-contents">8</div></td><td class="day calendar-day-2015-09-09"><div class="day-contents">9</div></td><td class="day event calendar-day-2015-09-10"><div class="day-contents">10</div></td><td class="day event calendar-day-2015-09-11"><div class="day-contents">11</div></td><td class="day event calendar-day-2015-09-12"><div class="day-contents">12</div></td></tr><tr><td class="day event calendar-day-2015-09-13"><div class="day-contents">13</div></td><td class="day event calendar-day-2015-09-14"><div class="day-contents">14</div></td><td class="day calendar-day-2015-09-15"><div class="day-contents">15</div></td><td class="day calendar-day-2015-09-16"><div class="day-contents">16</div></td><td class="day calendar-day-2015-09-17"><div class="day-contents">17</div></td><td class="day calendar-day-2015-09-18"><div class="day-contents">18</div></td><td class="day calendar-day-2015-09-19"><div class="day-contents">19</div></td></tr><tr><td class="day calendar-day-2015-09-20"><div class="day-contents">20</div></td><td class="day event calendar-day-2015-09-21"><div class="day-contents">21</div></td><td class="day event calendar-day-2015-09-22"><div class="day-contents">22</div></td><td class="day event calendar-day-2015-09-23"><div class="day-contents">23</div></td><td class="day calendar-day-2015-09-24"><div class="day-contents">24</div></td><td class="day calendar-day-2015-09-25"><div class="day-contents">25</div></td><td class="day calendar-day-2015-09-26"><div class="day-contents">26</div></td></tr><tr><td class="day calendar-day-2015-09-27"><div class="day-contents">27</div></td><td class="day calendar-day-2015-09-28"><div class="day-contents">28</div></td><td class="day calendar-day-2015-09-29"><div class="day-contents">29</div></td><td class="day calendar-day-2015-09-30"><div class="day-contents">30</div></td><td class="day adjacent-month next-month calendar-day-2015-10-01"><div class="day-contents">1</div></td><td class="day adjacent-month next-month calendar-day-2015-10-02"><div class="day-contents">2</div></td><td class="day adjacent-month next-month calendar-day-2015-10-03"><div class="day-contents">3</div></td></tr></tbody></table></div></div>
	
         </div>
      <script>
      
		$.ajax({
			type : "get",
			url : "/maven-web-demo/notice/GetMyNotice",
			data : {},
			dataType : "json",
			success : function(data) {
				var contentDiv = document.getElementById("notice-content");
				if (data.length == 0) {
					var article = document.createElement("article");
					var a =document.createElement("a");
					a.innerHTML = "当前没有备忘。"
					article.appendChild(a);
					contentDiv.appendChild(article);
				}else {
					for (var i=0; i<data.length; i++) {
						var article = document.createElement("article");
						var figure = document.createElement("figure");
						figure.setAttribute("class", "date");
						var inode = document.createElement("i");
						inode.setAttribute("class", "fa fa-file-o");
						figure.appendChild(inode);
						figure.innerHTML=format(data[i].uptoDate);
						article.appendChild(figure);
						
						var a = document.createElement("a");
						a.setAttribute("href", "/maven-web-demo/coursedetail/CourseDetailPage.action?cid=" + data[i].cid);
						a.innerHTML = data[i].content;
						article.appendChild(a);
						
						contentDiv.appendChild(article);
					}
				}
			},
		});
		
		function format(date) {
			return date.substring(0,10) + "                     " + date.substring(11);
		}
      </script>
