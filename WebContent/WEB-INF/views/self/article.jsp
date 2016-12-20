<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<link rel="stylesheet"
	href="../views/css/css/updPersonInfo.css"
	type="text/css"></link>
<link rel="stylesheet"
	href="/css/css/homePage.css"
	type="text/css"></link>
<link rel="stylesheet"
	href="/css/css/common.css"
	type="text/css"></link>
	

</head>
<body>

	<jsp:include page="head.jsp"></jsp:include>
	<!-- 内部导航 -->
	<div class="row">
		<div class="col-md-12" align="center">
		
		adasdas</div>
		<!-- 内容布局 -->
		<div class="col-md-12">
			<div class="row">
				<div class="col-md-12">
					<div class="col-md-3">
						<div
							style="width: 20%; float: left; text-align: center; padding-top: 5px">
						</div>
					</div>
					<div class="col-md-7">
						<table align="center" width="100%">
							<tr>
								<td align="right"><a
									href="${pageContext.request.contextPath}/user/toaddarticle">发表</a>
								</td>
							</tr>

							<tr>
								<td width="80%" valign="top" colspan="2"
									style="border-top: 1px #D8DFEA solid; border-bottom: 1px #D8DFEA solid;">
									<c:if test="${!empty article}">
										<c:forEach items="${article}" var="e" varStatus="vs">
											<table width="100%" border="0" cellpadding="5">
												<c:if test="${vs.count<21 }">
													<tr>
														<td style="border-bottom: 1px #D8DFEA solid;" width=5%><img
															src="${pageContext.request.contextPath}/images/front/blog.gif " />
														</td>
														<td style="border-bottom: 1px #D8DFEA solid;" align="left">
															<a
															href="${pageContext.request.contextPath}/user/clickart?artid=${e.artid}"
															style="font-weight: bold; font-size: 15pt">${e.title}</a>
														</td>
														<td align="right"
															style="border-bottom: 1px #D8DFEA solid;"><span
															style="font-size: 10pt"><fmt:formatDate
																	value="${e.indate}" pattern="yyyy-MM-dd" /></span></td>
													</tr>
												</c:if>
											</table>
										</c:forEach>
									</c:if>

								</td>
							</tr>
							<tr>
							<td align="right">
								<ul class="pagination" >
				<li>
					<a href="#">Prev</a>
				</li>
				<li>
					<a href="#">1</a>
				</li>
				<li>
					<a href="#">2</a>
				</li>
				<li>
					<a href="#">3</a>
				</li>
				
			</ul>
			</td>
			</tr>
						</table>
					</div>

					<div class="col-md-2"></div>
				</div>

			</div>
		</div>
		</div>
</body>
</html>
