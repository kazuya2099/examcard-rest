<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
<jsp:include page="/WEB-INF/views/common/head.jsp" flush="true" />
<link href="${pageContext.request.contextPath}/css/top/top.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/customer/customer.css" rel="stylesheet">
<title>exampleカード お客様情報の新規申請</title>
<script type="text/javascript">
<!--
	function submit() {
		var form = document.input;
		form.submit();
		return true;
	}

	function fill() {
		var form = document.input;
		form.sei.value = "山田";
		form.mei.value = "太郎";
		form.seiKana.value = "ヤマダ";
		form.meiKana.value = "タロウ";
		form.zip1.value = "300";
		form.zip2.value = "0001";
		form.addressPrefecture.value = "東京都";
		form.addressCity.value = "小平市";
		form.addressOoaza.value = "3";
		form.addressAza.value = "3-44-503";
		form.addressOther.value = "〇〇マンション";
		form.tel1.value = "090";
		form.tel2.value = "9999";
		form.tel3.value = "9999";
		form.mobileTel1.value = "090";
		form.mobileTel2.value = "9999";
		form.mobileTel3.value = "9999";
		form.email.value = "test@gmail.com";
		form.setaiFamily.options[1].selected  = true;
		form.setaiCount.value = "2";
		form.setaiStatus.options[1].selected  = true;
		form.setaiYear.value = "10";
		form.setaiLoan.options[1].selected  = true;
		form.income.value = "100";
		form.savings.value = "200";
		form.employmentStatus.options[1].selected  = true;
		form.companyName.value = "勤務先";
		form.companyZip1.value = "300";
		form.companyZip2.value = "0001";
		form.companyAddressPrefecture.value = "東京都";
		form.companyAddressCity.value = "小平市";
		form.companyAddressOoaza.value = "3";
		form.companyAddressAza.value = "3-44-503";
		form.companyAddressOther.value = "〇〇マンション";
		form.companyTel1.value = "090";
		form.companyTel2.value = "9999";
		form.companyTel3.value = "9999";
		form.companyDepartment.value = "1";
		form.companyIndustryType.options[1].selected  = true;
		form.companyWorkYears.value = "20";
	}
// -->
</script>
</head>
<body>
	<jsp:include page="/WEB-INF/views/common/header.jsp" flush="true" />
	<div class="row">
		<div class="contents">
			<div class="col-sm-2 content-block">
				<div class="contents-left"></div>
			</div>

			<div class="col-sm-8 content-block">
				<div class="main-contents">
					<div class="customer-info">
						<div class="customer-info-title">
							<img src="${pageContext.request.contextPath}/images/h1.gif">お客様情報の新規申請
						</div>
						<div class="customer-info-body">
							<form:form name="input" action="${pageContext.request.contextPath}/application/create01/input" modelAttribute="applicationCreate01Form">
								<div>
									お客様情報の新規登録を行います。<br> ご本人様情報・ご勤務先情報を入力し、「確認する」ボタンを押してください。<br>
									<h3>■お客様情報</h3>

									<c:if test="${error != null}">
										<div class="error">
											<c:out value="${error}" />
										</div>
									</c:if>
<button onclick="fill(); return false;">値埋め込み</button>
									<table class="customer-info">
										<tr>
											<th>氏名</th>
											<td><form:input path="sei" size="10" maxlength="10" /> <form:input path="mei" size="10" maxlength="10" /> <form:errors path="sei" class="validation-error" /> <form:errors
													path="mei" class="validation-error" /></td>
										</tr>
										<tr>
											<th>氏名（カナ）</th>
											<td><form:input path="seiKana" size="10" maxlength="10" /> <form:input path="meiKana" size="10" maxlength="10" /> <form:errors path="seiKana" class="validation-error" />
												<form:errors path="meiKana" class="validation-error" /></td>
										</tr>
										<tr>
											<th>郵便番号</th>
											<td><form:input path="zip1" size="3" maxlength="3" />-<form:input path="zip2" size="4" maxlength="4" /> <form:errors path="zip1" class="validation-error" /> <form:errors path="zip2"
													class="validation-error" /></td>
										</tr>
										<tr>
											<th>住所</th>
											<td><form:input path="addressPrefecture" placeholder="都道府県" /> <form:errors path="addressPrefecture" class="validation-error" /><br> <form:input path="addressCity"
													placeholder="市区郡" /> <form:errors path="addressCity" class="validation-error" /><br> <form:input path="addressOoaza" placeholder="丁目" /> <form:errors path="addressOoaza"
													class="validation-error" /><br> <form:input path="addressAza" placeholder="番地・号" /> <form:errors path="addressAza" class="validation-error" /><br> <form:input
													path="addressOther" placeholder="マンション名など" /> <form:errors path="addressOther" class="validation-error" /></td>
										</tr>
										<tr>
											<th>電話番号</th>
											<td><form:input path="tel1" size="4" maxlength="4" />-<form:input path="tel2" size="4" maxlength="4" />-<form:input path="tel3" size="4" maxlength="4" /> <form:errors path="tel1"
													class="validation-error" /> <form:errors path="tel2" class="validation-error" /> <form:errors path="tel3" class="validation-error" /></td>
										</tr>
										<tr>
											<th>携帯電話番号</th>
											<td><form:input path="mobileTel1" size="4" maxlength="4" />-<form:input path="mobileTel2" size="4" maxlength="4" />-<form:input path="mobileTel3" size="4" maxlength="4" /> <form:errors
													path="mobileTel1" class="validation-error" /> <form:errors path="mobileTel2" class="validation-error" /> <form:errors path="mobileTel3" class="validation-error" /></td>
										</tr>
										<tr>
											<th>メールアドレス</th>
											<td><form:input path="email" /> <form:errors path="email" class="validation-error" /></td>
										</tr>
										<tr>
											<th>ご家族について</th>
											<td><form:select path="setaiFamily">
													<form:options items="${outputDto.setaiFamily}" />
												</form:select> <form:errors path="setaiFamily" class="validation-error" /></td>
										</tr>
										<tr>
											<th>世帯人数(同一生計の人数)</th>
											<td><form:input path="setaiCount" size="2" maxlength="2" />人世帯 <form:errors path="setaiCount" class="validation-error" /></td>
										</tr>
										<tr>
											<th>居住状況</th>
											<td><form:select path="setaiStatus">
													<form:options items="${outputDto.setaiStatus}" />
												</form:select> <form:errors path="setaiStatus" class="validation-error" /></td>
										</tr>
										<tr>
											<th>居住年数</th>
											<td><form:input path="setaiYear" size="2" maxlength="2" />年 <form:errors path="setaiYear" class="validation-error" /></td>
										</tr>
										<tr>
											<th>住宅ローンもしくは家賃のお支払い</th>
											<td><form:select path="setaiLoan">
													<form:options items="${outputDto.setaiLoan}" />
												</form:select> <form:errors path="setaiLoan" class="validation-error" /></td>
										</tr>
										<tr>
											<th>本人年収</th>
											<td><form:input path="income" size="12" maxlength="12" />万円 <form:errors path="income" class="validation-error" /></td>
										</tr>
										<tr>
											<th>預貯金額</th>
											<td><form:input path="savings" size="12" maxlength="12" />万円 <form:errors path="savings" class="validation-error" /></td>
										</tr>
									</table>
								</div>
								<div>
									<h3>■ご勤務先情報</h3>
									<table class="customer-info-office">
										<tr>
											<th>職業</th>
											<td><form:select path="employmentStatus">
													<form:options items="${outputDto.employmentStatus}" />
												</form:select> <form:errors path="employmentStatus" class="validation-error" /></td>
										</tr>
										<tr>
											<th>勤務先</th>
											<td><form:input path="companyName" /> <form:errors path="companyName" class="validation-error" /></td>
										</tr>
										<tr>
											<th>部署</th>
											<td><form:input path="companyDepartment" /> <form:errors path="companyDepartment" class="validation-error" /></td>
										</tr>
										<tr>
											<th>郵便番号</th>
											<td>
												<form:input path="companyZip1" size="4" maxlength="3" />-<form:input path="companyZip2" size="4" maxlength="4" />
												<form:errors path="companyZip1" class="validation-error" /> <form:errors path="companyZip2" class="validation-error" />
											</td>
										</tr>
										<tr>
											<th>住所</th>
											<td>
												<form:input path="companyAddressPrefecture" placeholder="都道府県" />
												<form:errors path="companyAddressPrefecture" class="validation-error" /><br>
												<form:input	path="companyAddressCity" placeholder="市区郡" /> 
												<form:errors path="companyAddressCity" class="validation-error" /><br>
												<form:input path="companyAddressOoaza" placeholder="丁目" />
												<form:errors path="companyAddressOoaza" class="validation-error" /><br>
												<form:input path="companyAddressAza" placeholder="番地・号" />
												<form:errors path="companyAddressAza" class="validation-error" /><br>
												<form:input path="companyAddressOther" placeholder="マンション名など" />
												<form:errors path="companyAddressOther" class="validation-error" />
											</td>
										</tr>
										<tr>
											<th>電話番号</th>
											<td>
												<form:input path="companyTel1" size="4" maxlength="4" />-<form:input path="companyTel2" size="4" maxlength="4" />-<form:input path="companyTel3" size="4" maxlength="4" />
												<form:errors path="companyTel1" class="validation-error" /> <form:errors path="companyTel2" class="validation-error" /> <form:errors path="companyTel3" class="validation-error" />
											</td>
										</tr>
										<tr>
											<th>業種</th>
											<td>
												<form:select path="companyIndustryType">
													<form:options items="${outputDto.companyIndustryType}" />
												</form:select> <form:errors path="companyIndustryType" class="validation-error" />
											</td>
										</tr>
										<tr>
											<th>勤続年数</th>
											<td><form:input path="companyWorkYears" size="2" maxlength="2" />年 <form:errors path="companyWorkYears" class="validation-error" /></td>
										</tr>
									</table>
									<form:hidden path="id" />
									<form:hidden path="updateDate" />
								</div>
								<a href="${pageContext.request.contextPath}/customer/top" class="btn btn-primary">戻る</a>
								<a onclick="submit();" class="btn btn-primary">確認する</a>
							</form:form>
						</div>
					</div>
				</div>
			</div>
			<div class="col-sm-2 content-block">
				<div class="contents-right"></div>
			</div>
		</div>
	</div>

	<jsp:include page="/WEB-INF/views/common/footer.jsp" flush="true" />
</body>
</html>