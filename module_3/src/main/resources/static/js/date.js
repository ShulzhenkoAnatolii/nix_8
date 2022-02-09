function showCurrentDate(){
	    var d = new Date(),
	      new_value=d.toISOString().slice(0,10);

	        document.getElementById("calendarForTasks").value=new_value;
	}
	showCurrentDate();