<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/register.css"
	type="text/css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/common.css"
	type="text/css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.3.1.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/publicJs.js"></script>
</head>
<body>
	<jsp:include page="head.jsp" />

	<div class="reg_main_frame">
		<!-- 加入校内后，可以选择。 -->
		<div class="play_item">
			<img alt="#" src="${pageContext.request.contextPath}/images/front/jiaru.jpg" />
		</div>
		<div>
			<!-- 注册用的表格！  -->
			<div class="reg_table1">
				<span class="font6">简单一步，快速注册</span><br />
				<table >
					<tr>
						<td class="tab_td1">真实姓名：</td>
						<td class="tab_td2"><input type="text" name="??" /></td>
						<td><span class="spanVal">请输入真实姓名,方便朋友查找</span></td>
					</tr>
					<tr>
						<td class="tab_td1">性别:</td>
						<td><input type="radio" name="sex" />男<input type="radio"
							name="sex" />女</td>

					</tr>
					<tr>
						<td class="tab_td1">身份：</td>
						<td><select size="4" onchange="changeStatus(this)">
								<option value="worker">已工作</option>
								<option value="graduate">大学生</option>
								<option value="midstu">中学生/中专技校</option>
								<option value="nothing">以上都不是</option>
						</select></td>
					</tr>
					<!-- 考虑已经工作的情况   start -->
					<tr class="worker_sep">
						<td class="tab_td1">居住地：</td>
						<td><select>
								<option>-省份-</option>
								<option>四川省</option>
								<option>广东省</option>
						</select></td>

					</tr>
					
					<tr>
						<td></td>
						<td><select>
								<option>-选择城市-</option>
								<option>成都市</option>
						</select></td>

					</tr>
					
					<tr class="worker_sep">
						<td class="tab_td1">公司：</td>
						<td><input type="text" name="" /></td>

					</tr>
					
					<!-- 考虑已经工作的情况   end -->
					<!-- 考虑大学生要输入的特别信息 start -->
					<tr class="gra_spe">
						<td class="tab_td1">类型：</td>
						<td  class="tab_td2"><select>
								<option>大学生</option>
								<option>硕士</option>
								<option>博士</option>
								<option>大专</option>
						</select></td>
						
					</tr>
					
					<tr class="gra_spe">
						<td class="tab_td1">大学：</td>
						<td class="tab_td2"><input type="text" name="" /></td>
						
					</tr>
					
					<!-- 考虑大学生要输入的特别信息 end -->
					<tr>
						<td class="tab_td1">电子邮件：<br />&nbsp;
						</td>
						<td ><input type="text" name="" /><br /> <img alt=""
							src="${pageContext.request.contextPath}/images/front/tanhao.png" />如果没有邮箱请使用<a
							href="#">Hotmail</a>邮箱</td>
					</tr>

					<tr>
						<td class="tab_td1">设置密码：</td>
						<td><input type="password" name="" /></td>
					</tr>
					<tr>
						<td class="tab_td1">确认密码：</td>
						<td><input type="password" name="" /></td>
					</tr>
					<tr>
						<td class="tab_td1">验证码：</td>
						<td>请输入以下验证码，看不清换一张？</td>
						<td>[1234]</td>
						
					</tr>
					<tr>
						<td></td>
						<td><input name="submit" type="submit" value=""
							class="button1" /></td>

					</tr>
					<tr>
						<td></td>
						<td><input type="checkbox" name="??" /><span class="font3">&nbsp;我已阅读并同意遵守</span>
							<a href="#">校内网服务条款</a></td>

					</tr>
				</table>

			</div>
		</div>
	</div>
	<br />


	<jsp:include page="foot.jsp" />
</body>
</html>