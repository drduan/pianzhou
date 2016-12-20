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
textarea
{
width:100%;
height:100%;
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
			<form name="form1" method="post" action="${pageContext.request.contextPath}/user/do_editart?artid=${e.artid}" >

			<table width="80%" style="float: left;" cellspacing="0"
				cellpadding="10">


				<tr>
					<td width="80%" valign="top" colspan="2"
						style="border-top: 1px #D8DFEA solid; border-bottom: 1px #D8DFEA solid;">
						<table width="100%" border="0" cellspacing="5" cellpadding="5">
							<tr><td align="center">
                                 <h1>修改日志</h1></td>
							</tr>

				<tr>
					<td width="80%" valign="top" colspan="2"
						style="border-top: 1px #D8DFEA solid; border-bottom: 1px #D8DFEA solid;">
						<table width="100%" border="0" cellspacing="5" cellpadding="5">
						
                            <tr><td>
						   <table width="100%" border="0" cellspacing="5" cellpadding="5">
                            <tr><td align="center"><h2>${e.title}</h2>                         
                            </td></tr>
                            <tr><td align="right"><a href="${pageContext.request.contextPath}/user/return_article?artid=${e.artid}">返回日志</a></td></tr>
                            
						   </table></td></tr>
						   
						   
						   <tr><td>
						   <table width="100%" border="0" cellspacing="5" cellpadding="5">
                            <tr><td><h2>內容:</h2>
                           <textarea style="border: 1" name="content" rows="30" cols="80">${e.content}</textarea>
                            </td></tr>
						   </table></td></tr>
						   
						   
						   
						   
							   
						</table>
					</td>
				</tr>
					<tr>							
							<td align="center"><input style="width:120px;height:35px;" name="submit" type="submit" value="提交"/></td>

						</tr>
						</table>
					</td>
				</tr>

			</table>		
			
</form></c:forEach></c:if>
		</div>
	</div>

	
</body>
</html>
