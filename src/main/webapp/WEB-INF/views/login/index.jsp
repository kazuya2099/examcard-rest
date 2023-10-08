<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
<jsp:include page="../common/head.jsp" flush="true" />
<link href="${pageContext.request.contextPath}/css/login/login.css"
	rel="stylesheet">
<title>exampleカード ログイン</title>
</head>
<body>

	<script>
	$(function() {
		$('#top').click(function() {
			$.ajax({
				type : "GET",
				url : "http://localhost:8080/examcard/top/0000001",
				data : {
					name : "John",
					location : "Boston"
				}
			}).done(function(res) {
				console.log(res);
				$("#info").text(res.information);
				$("#id").text(res.userDto.id);
				$("#sei").text(res.userDto.sei);
				$("#mei").text(res.userDto.mei);
				$("#seiKana").text(res.userDto.seiKana);
				$("#meiKana").text(res.userDto.meiKana);
				$("#depId").text(res.userDto.depId);
				$("#depName").text(res.userDto.depName);
			}).fail(function() {
				window.alert('正しい結果を得られませんでした。');
			});
		});
		$('#search').click(function() {
			var req = new Object();
			req.sei = "山田";
			req.mei = "太郎";
			$.ajax({
				type : "GET",
				url : "http://localhost:8080/examcard/application/search01/search",
				data : req,
			}).done(function(res) {
				console.log(res);
				$("#s-res").text(JSON.stringify(res, null, "  "));
			}).fail(function(data) {
				console.log(data);
				window.alert('正しい結果を得られませんでした。');
			});
		});
		$('#detail').click(function() {
			$.ajax({
				type : "GET",
				url : "http://localhost:8080/examcard/application/detail01/0000017",
			}).done(function(res) {
				console.log(res);
				$("#d-res").text(JSON.stringify(res, null, "  "));
			}).fail(function(data) {
				console.log(data);
				window.alert('正しい結果を得られませんでした。');
			});
		});
		$('#update').click(function() {
			var req = new Object();
			req.id = "0000017";
			req.addressPrefecture = "東京都";
			req.addressCity = "港区";
			req.addressOoaza = "六本木１丁目";
			req.addressAza = "１";
			req.addressOther = "森ビル";
			req.aplComment = "コメント";
			req.aplStatus = "1";
			req.companyAddressPrefecture = "東京都";
			req.companyAddressCity = "港区";
			req.companyAddressOoaza = "六本木１丁目";
			req.companyAddressAza = "１";
			req.companyAddressOther = "森ビル";
			req.companyDepartment = "1";
			req.companyIndustryType = "1";
			req.companyName = "アデコ株式会社";
			req.companyTel1 = "090";
			req.companyTel2 = "9999";
			req.companyTel3 = "9999";
			req.companyWorkYears = "";
			req.companyZip1 = "105";
			req.companyZip2 = "0001";
			req.email = "test@test.com";
			req.employmentStatus = "1";
			req.income = "100";
			req.sei = "山田";
			req.seiKana = "ヤマダ";
			req.mobileTel1 = "090";
			req.mobileTel2 = "9999";
			req.mobileTel3 = "9999";
			req.savings = "200";
			req.mei = "太郎";
			req.meiKana = "タロウ";
			req.setaiCount = "2";
			req.setaiFamily = "2";
			req.setaiLoan = "100";
			req.setaiStatus = "1";
			req.tel1 = "090";
			req.tel2 = "9999";
			req.tel3 = "9999";
			req.zip1 = "105";
			req.zip2 = "0001";
			$.ajax({
				type : "PUT",
				url : "http://localhost:8080/examcard/application/create01/update",
				data : req,
			}).done(function(res) {
				console.log(res);
			}).fail(function(data) {
				console.log(data);
				window.alert('正しい結果を得られませんでした。');
			});
		});
	});
	</script>
	<button id = "top">TOP</button>
	<div>
		<span id="id"></span>　<spanid="sei"></span>　<span id="mei"></span>
		<span id="seiKana"></span>　<span id="meiKana"></span>　<span id="depId"></span>　<span id="depName"></span><br>
		<span id="info"></span>
	</div>
	
	<button id = "search">検索</button>
	<div id="s-res"></div>
	<br>
	<button id = "detail">詳細</button>
	<div id="d-res"></div>
	<br>
	<button id = "update">更新</button>
	
</body>
</html>