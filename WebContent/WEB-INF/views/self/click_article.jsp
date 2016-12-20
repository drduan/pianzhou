<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/css/updPersonInfo.css"
	type="text/css"></link>
<style type="text/css">
.textarea1
{
width:100%;
height:100%;
overflow-y:auto;
border:0;
font-size:15pt;
}
.textarea2
{
width:100%;
height:100%;
overflow-y:auto;
border:1;
font-size:14pt;
}
.button2{
width:50px;
height:35px;
}
</style>
</head>

<body>

	
	<div class="album_main">
			<div class="album_left">
					<div
				style="width: 20%; float: left; text-align: center; padding-top: 5px">
				<img
					src="${pageContext.request.contextPath}/images/front/selfright.jpg" />
			         </div>
            <c:if test="${!empty article}">
			<c:forEach items="${article}" var="e" varStatus="vs">
			<table width="80%" style="float: left;" cellspacing="0"
				cellpadding="10">


				<tr>
					<td width="80%" valign="top" colspan="2"
						style="border-top: 1px #D8DFEA solid; border-bottom: 1px #D8DFEA solid;">
				<table style="border-bottom:solid 1px #333333" width="100%" border="0" cellspacing="5" cellpadding="5">

				<tr>
					<td width="80%" valign="top" colspan="2"
						style="border-top: 1px #D8DFEA solid; border-bottom: 1px #D8DFEA solid;">
						

                         
						   <table width="100%" border="0" cellspacing="5" cellpadding="5">
                           <tr><td></td>
                           <td><h2 align="center">${e.title}</h2></td><td></td></tr>
                           <tr>
                           <td align="left"><a href="${pageContext.request.contextPath}/user/to_editart?artid=${e.artid}">编辑日志</a></td><td></td>
                           <td align="right"><a href="${pageContext.request.contextPath}/user/return_list">返回列表</a></td>
                           </tr>
						   </table>
						   <hr>
						   </td></tr>
						   
						   
						   <tr><td>
						   <table width="100%" border="0" cellspacing="5" cellpadding="5">
                            <tr><td>
                            <textarea class="textarea1" readonly="readonly"  name="content" rows="20" cols="80" >${e.content}</textarea>
                            </td></tr>
						   </table>
						  				   
		
					</td>
				</tr>
				</table><br />
				<table style="border-bottom:solid 1px #333333" width="100%" border="0" cellspacing="5" cellpadding="5">
                <tr><td>
				<h2><i>评论:</i></h2><br/>
				</td></tr>
				
				
                  <c:if test="${!empty comment}">
					<c:forEach items="${comment}" var="c" varStatus="vs">
					<tr>
					<td width=15% ><span style="font-size: 14pt">${c.name}:</span></td>
					<td ><span style="font-size: 12pt">${c.ac_content}</span></td>
					<td align="right"><fmt:formatDate value="${c.ac_indate}" pattern="yyyy-MM-dd"/>
					<span style="font-size:10pt"><a href="${pageContext.request.contextPath}/user/delcomment?ac_Id=${c.ac_Id}&ac_articleId=${c.ac_articleId}">×</a></span></td>
					</tr>
					</c:forEach></c:if>
				
				</table>
						<form name="form1" method="post" action="${pageContext.request.contextPath}/user/comment?ac_articleId=${e.artid}" >
						<table width="100%" border="0" cellspacing="5" cellpadding="5"><tr>
						<td width=10%><span style= "font-size:16px">发表评论:</span></td>
						<td width=70%>
						<textarea class="textarea2"  name="ac_content" rows="2" cols="20"></textarea></td>
						<td align="right">
						<input class="sub" name="submit" type="submit" value="发表评论"/>
						</td>

						</table>
						
						</form>
					</td>
				</tr>

			</table>		
			</c:forEach></c:if>
		</div>
	</div>

	
</body>
</html>
