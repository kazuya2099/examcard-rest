<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
<jsp:include page="/WEB-INF/views/common/head.jsp" flush="true" />
<link href="${pageContext.request.contextPath}/css/top/top.css"
	rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/customer/customer.css"
	rel="stylesheet">
<title>exampleカード お客様情報の新規申請</title>
<script type="text/javascript">
<!--
function back() {
	var form = document.confirm;
	form.action = "${pageContext.request.contextPath}/application/create01/input?back";
	form.submit();
	return true;
}
function submit() {
	var form = document.confirm;
	form.submit();
	return true;
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
							<form:form name="confirm" action="${pageContext.request.contextPath}/application/create01/confirm" modelAttribute="applicationCreate01Form">
								<div class="customer-info-body-base">
	カードに登録されているお客様情報の照会・変更をすることができます。<br>
	ご本人様情報・ご勤務先情報を変更する場合は、「変更する」ボタンを押し、変更ページにてお手続きください。<br>
	<h3>ご本人様情報</h3>
	<table class="customer">
		<tr>
			<th>氏名</th>
			<td>${customerApplicationDto.sei}　${customerApplicationDto.mei}</td>
		</tr>
		<tr>
			<th>氏名（カナ）</th>
			<td><c:out value="${customerApplicationDto.seiKana}" />　<c:out value="${customerApplicationDto.meiKana}" /></td>
		</tr>
		<tr>
			<th>郵便番号</th>
			<td><c:out value="${customerApplicationDto.zip1}" />-<c:out value="${customerApplicationDto.zip2}" /></td>
		</tr>
		<tr>
			<th>住所</th>
			<td>
				<c:out value="${customerApplicationDto.addressPrefecture}" /><br>
				<c:out value="${customerApplicationDto.addressCity}" /><br>
				<c:out value="${customerApplicationDto.addressOoaza}" /><br>
				<c:out value="${customerApplicationDto.addressAza}" /><br>
				<c:out value="${customerApplicationDto.addressOther}" />
			</td>
		</tr>
		<tr>
			<th>電話番号</th>
			<td class=""><c:out value="${customerApplicationDto.tel1}" />-<c:out value="${customerApplicationDto.tel2}" />-<c:out value="${customerApplicationDto.tel3}" /></td>
		</tr>
		<tr>
			<th>携帯電話番号</th>
			<td class=""><c:out value="${customerApplicationDto.mobileTel1}" />-<c:out value="${customerApplicationDto.mobileTel2}" />-<c:out value="${customerApplicationDto.mobileTel3}" /></td>
		</tr>
		<tr>
			<th>メールアドレス</th>
			<td class=""><c:out value="${customerApplicationDto.email}" /></td>
		</tr>
		<tr>
			<th>ご家族について</th>
			<td><c:out value="${customerApplicationDto.dispSetaiFamily}" /></td>
		</tr>
		<tr>
			<th>世帯人数(同一生計の人数)</th>
			<td><c:out value="${customerApplicationDto.setaiCount}" />人世帯</td>
		</tr>
		<tr>
			<th>居住状況</th>
			<td><c:out value="${customerApplicationDto.dispSetaiStatus}" /></td>
		</tr>
		<tr>
			<th>居住年数</th>
			<td><c:out value="${customerApplicationDto.setaiYear}" />年</td>
		</tr>
		<tr>
			<th>住宅ローンもしくは家賃のお支払い</th>
			<td><c:out value="${customerApplicationDto.dispSetaiLoan}" /></td>
		</tr>
		<tr>
			<th>本人年収</th>
			<td><c:out value="${customerApplicationDto.income}" />万円</td>
		</tr>
		<tr>
			<th>預貯金額</th>
			<td><c:out value="${customerApplicationDto.savings}" />万円</td>
		</tr>
	</table>
</div>
<div class="customer-info-body-office">
	<h3>ご勤務先情報</h3>
	<table>
		<tr>
			<th>職業</th>
			<td><c:out value="${customerApplicationDto.dispEmploymentStatus}" /></td>
		</tr>
		<tr>
			<th>勤務先</th>
			<td><c:out value="${customerApplicationDto.companyName}" /></td>
		</tr>
		<tr>
			<th>部署</th>
			<td><c:out value="${customerApplicationDto.companyDepartment}" /></td>
		</tr>
		<tr>
			<th>郵便番号</th>
			<td><c:out value="${customerApplicationDto.companyZip1}" />-<c:out value="${form.companyZip2}" /></td>
		</tr>
		<tr>
			<th>住所</th>
			<td>
				<c:out value="${customerApplicationDto.companyAddressPrefecture}" /><br>
				<c:out value="${customerApplicationDto.companyAddressCity}" /><br>
				<c:out value="${customerApplicationDto.companyAddressOoaza}" /><br>
				<c:out value="${customerApplicationDto.companyAddressAza}" /><br>
				<c:out value="${customerApplicationDto.companyAddressOther}" />
			</td>
		</tr>
		<tr>
			<th>電話番号</th>
			<td><c:out value="${customerApplicationDto.companyTel1}" />-<c:out value="${customerApplicationDto.companyTel2}" />-<c:out value="${customerApplicationDto.companyTel3}" /></td>
		</tr>
		<tr>
			<th>業種</th>
			<td><c:out value="${customerApplicationDto.dispCompanyIndustryType}" /></td>
		</tr>
		<tr>
			<th>勤続年数</th>
			<td><c:out value="${customerApplicationDto.companyWorkYears}" />年</td>
		</tr>
	</table>

	<form:hidden path="id" />
	<form:hidden path="sei" />
	<form:hidden path="mei" />
	<form:hidden path="meiKana" />
	<form:hidden path="seiKana" />
	<form:hidden path="zip1" />
	<form:hidden path="zip2" />
	<form:hidden path="addressPrefecture" />
	<form:hidden path="addressCity" />
	<form:hidden path="addressOoaza" />
	<form:hidden path="addressAza" />
	<form:hidden path="addressOther" />
	<form:hidden path="tel1" />
	<form:hidden path="tel2" />
	<form:hidden path="tel3" />
	<form:hidden path="mobileTel1" />
	<form:hidden path="mobileTel2" />
	<form:hidden path="mobileTel3" />
	<form:hidden path="email" />
	<form:hidden path="setaiFamily" />
	<form:hidden path="setaiCount" />
	<form:hidden path="setaiStatus" />
	<form:hidden path="setaiYear" />
	<form:hidden path="setaiLoan" />
	<form:hidden path="income" />
	<form:hidden path="savings" />
	<form:hidden path="employmentStatus" />
	<form:hidden path="companyName" />
	<form:hidden path="companyZip1" />
	<form:hidden path="companyZip2" />
	<form:hidden path="companyAddressPrefecture" />
	<form:hidden path="companyAddressCity" />
	<form:hidden path="companyAddressOoaza" />
	<form:hidden path="companyAddressAza" />
	<form:hidden path="companyAddressOther" />
	<form:hidden path="companyTel1" />
	<form:hidden path="companyTel2" />
	<form:hidden path="companyTel3" />
	<form:hidden path="companyDepartment" />
	<form:hidden path="companyIndustryType" />
	<form:hidden path="companyWorkYears" />
	<form:hidden path="updateDate" />
</div>

								<a onclick="back();" class="btn btn-primary">戻る</a>
								<a onclick="submit();" class="btn btn-primary">申請する</a>
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

	<div class="row">
		<div class="col-sm-12">
			<jsp:include page="/WEB-INF/views/common/footer.jsp" flush="true" />
		</div>
	</div>
</body>
</html>