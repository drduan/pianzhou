<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>  
<!DOCTYPE html>
<html>
<head>
<title>首页</title>
</head>
<body>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
<!-- 新 Bootstrap 核心 CSS 文件 -->
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap/css/default.css">
<!-- Custom styles for this template -->
<link href="${pageContext.request.contextPath}/css/carousel.css" rel="stylesheet">

<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="${pageContext.request.contextPath}/js/jquery-1.11.3.js"></script>
<script src="${pageContext.request.contextPath}/js/functions.js"></script>
<script src="${pageContext.request.contextPath}/js/cart.js"></script>

<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script	src="${pageContext.request.contextPath}/css/bootstrap/js/bootstrap.min.js"></script>

<script type="text/javascript">

	$(document).ready(
		function(){
			//验证用户名是否可用
			$("#regForm #userName").blur(function(){
				$.post(getContextPath()+"/user/checkUserName",{userName:$("#regForm #userName").val()},function(result){
					if(result.available){
						$("#checkNameResult").html("该用户名可用");
					}
					else{
						$("#checkNameResult").html("对不起，该用户名已被占用，请更换");
					}
				});
			});
			//修改导航菜单选中状态
			$("#nav li").click(function(){
				$(this).siblings().removeClass("active");
				$(this).addClass("active");
			});
			//显示购物车中商品数量
			
	);
	
	function login(){
		var userName=$("#userName").val();
		var userPass=$("#userPass").val();
		$.post(getContextPath()+"/appuser/login",{userName:userName,userPass:userPass},
				function(result){
					$('#loginFormModal').modal('hide');
					if(result.loginFlag=="1"){
						//alert("true");
						$("#info").html("<li id='li1'><span>"+userName.escapeHTML()+"您好，欢迎来到良品专卖店！</span>"+										
								 		
								  		"<li><a href='#' onclick='logout()'>退出登录</a></li>");
						
					}
					else{
						//alert("false");
						$("#msgTitle").html("登录失败");
						$("#msgBody").html("用户名或密码错误");
						$("#msgModal").modal();
		
					}
				});
	}
	function logout(){
		$.post(getContextPath()+"/user/logout",null,function(){
			$("#info").html("<li id='li1'><span>游客您好，欢迎来到扁舟旅游！</span>"+	
							"<a href='#loginFormModal' data-toggle='modal'>[登录]</a>&nbsp;<a href='#regFormModal' data-toggle='modal'>[新用户注册]</a></li>");
			
		});
	}
	function reg(){
		$.post(getContextPath()+"/user/reg",$('#regForm').serialize(),function(result){
			$('#regFormModal').modal('hide');
			if(result.reg=="yes"){
				$("#msgTitle").html("注册成功");
				$("#msgBody").html("恭喜您，注册成功");
				$("#msgModal").modal();
			}
			else{
				$("#msgTitle").html("注册失败");
				$("#msgBody").html("对不起，注册失败");
				$("#msgModal").modal();
			}
		});
	}
	function checkLogin(result){
		if(result.login){
			//$("#msgTitle").html(result.login);
			//$("#msgBody").html(result.login);
			//$("#msgModal").modal();
			$("#loginFormModal").modal();
			return false;
		}
		return true;
	}
	
	function changeCart(index){
		var newnum=$("#cartnum").val();
		cart.updateGoodsNum(index,newnum);
		showCart();
	}
/* 	function makesure(msg){
		$("#confirmTitle").html("请确认");
		$("#confirmBody").html(msg);
		$("#confirmModal").modal();
		return flag;
	} */
</script>
<div class="container-fluid">
<div class="row" style="background: #4ca0d2">
		
		<div class="col-md-12 text-right" >
			
			<ol class="breadcrumb" id="info" style="background: #4ca0d2">
				<c:if test="${sessionScope['_LOGIN_USER_']==null}" >
					<li id="li1"><span>游客您好，欢迎来到扁舟旅游！！</span>
					<a href="#loginFormModal" data-toggle="modal">[登录]</a>&nbsp;<a href="#regFormModal" data-toggle="modal">[新用户注册]</a></li>
					
				</c:if>
				<c:if test="${sessionScope['_LOGIN_USER_']!=null}">
					<li id="li1"><span>${fn:escapeXml(sessionScope['_LOGIN_USER_'].userName) }您好，欢迎来到扁舟旅游！</span>										
					
					<li><a href="#" onclick="logout()">退出登录</a></li>
				</c:if>
			</ol>
			
		</div>
		<div class="col-md-12">
		<div class="col-md-2">
		
		</div>
		
		<div class="col-md-8">
			<nav class="navbar navbar-default navbar-static-top" role="navigation">
					
				<div class="navbar-header">
				 
					<button class="navbar-toggle" type="button" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
						 <span class="sr-only">Toggle navigation</span><span class="icon-bar"></span><span class="icon-bar"></span><span class="icon-bar"></span>
					</button> <a class="navbar-brand" href="#">扁舟旅游</a>
				</div>
				
				<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
					<ul class="nav navbar-nav" id="nav">
						<li class="active">
							<a href="#">首页</a>
						</li>
						<li id="lvyouriji" onclick="li_click(this)">
							<a href="${pageContext.request.contextPath}/user/toArticle">驴友日记</a>
						</li>
						<li>
							<a href="#">图行天下</a>
						</li>
						<li>
						<a href="#">推荐专题</a>
						</li>
						<li>
                        <form class="navbar-form navbar-left form-inline " role="search" method="post" action="${pageContext.request.contextPath}/goods/searchGoods">
						<div class="form-group">
							<input class="form-control " type="text" name="keyword" value="${fn:escapeXml(param.keyword)}"/>
						</div> 
						
						<button class="btn btn-default" type="submit">
							景点搜索
						</button>
					    </form>
					    </li>
					    
					    

					   <ul class="nav navbar-nav navbar-right" id="navlist">
						
						<li class="dropdown" >
							<a class="dropdown-toggle" href="#" data-toggle="dropdown">排序<strong class="caret"></strong></a>
							<ul class="dropdown-menu">
						<li>
							<a href="#">操作</a>
						</li>
						<li>
							<a href="#">设置栏目</a>
						</li>
						<li>
							<a href="#">更多设置</a>
						</li>
						<li class="divider">
						</li>
						<li>
							<a href="#">分割线</a>
						</li>
						</li>
						</ul>
				
				
					</ul>
					</div>
				
			</nav>
		</div>
		<div class="col-md-2"></div>
		</div>
</div>
<div class="col-md-2">
		
		</div>
</div>
</body>
<script type="text/javascript">

function li_click(e)
{
	var li_click_i = e.getAttribute("id");
	document.getElementById(li_click_i).style.background = "yellow";
}
</script>
</html>