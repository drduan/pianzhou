<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/head.css" type="text/css" />
<script type="text/javascript">
<!--
	function changeBG(o) {
		o.style.backgroundColor = "#5C75AA";
	}

	function changeBG2(o) {
		o.style.backgroundColor = "";
	}
	-->
</script>

	<div class="head">
		<img class="img1" src="${pageContext.request.contextPath}/images/front/top1.gif" /> <img
			class="img2" src="${pageContext.request.contextPath}/images/front/top2.jpg" /> <img
			src="${pageContext.request.contextPath}/images/front/xnw3.jpg" style="float: left" />

		<ul class="navi1">
			<li onmouseover="changeBG(this)" onmouseout="changeBG2(this)"><a
				class="anavi" href="${pageContext.request.contextPath}/register.do?flag=regUI">注册</a></li>
			<li onmouseover="changeBG(this)" onmouseout="changeBG2(this)"><a
				class="anavi" href="#">设为首页</a></li>
			<li onmouseover="changeBG(this)" onmouseout="changeBG2(this)"><a
				class="anavi" href="#">加入收藏</a></li>
			<li onmouseover="changeBG(this)" onmouseout="changeBG2(this)"><a
				class="anavi" href="#">帮助</a></li>
		</ul>

	</div>
	