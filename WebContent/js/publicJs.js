//这里我们的一个js函数库
function changeStatus(obj){
	//	window.alert("ok"+obj.value);
		if(obj.value=="worker"){
			$(".worker_sep").css("display","table-row");
			$(".gra_spe").css("display","none");
		}else if(obj.value=="graduate"){
			//jquery按照一个Id号去寻找一个控件。
//			$("#gra_type").css("display","block");
//			$("#gra_uni").css("display","block");
			$(".gra_spe").css("display","table-row");
			$(".worker_sep").css("display","none");
		}
	}