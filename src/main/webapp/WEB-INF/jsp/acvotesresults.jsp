<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Party Results</title>
<meta name="description"
	content="Free Bootstrap Theme by BootstrapMade.com">
<meta name="keywords"
	content="free website templates, free bootstrap themes, free template, free bootstrap, free website template">

<script src="../../js/lib/jquery.min.js"></script>
<script src="../../js/lib/bootstrap.min.js"></script>
<script src="../../js/lib/jquery.countdown.min.js"></script>
<script src="../../js/lib/wow.js"></script>
<script src="../../js/lib/angular.min.js"></script>
<script src="../../js/app/app.js"></script>
<link
	href='https://fonts.googleapis.com/css?family=Lobster|Open+Sans:400,400italic,300italic,300|Raleway:300,400,600'
	rel='stylesheet' type='text/css'>
<link rel="stylesheet" type="text/css"
	href="../../css/lib/font-awesome.min.css">
<link rel="stylesheet" type="text/css"
	href="../../css/lib/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="../../css/lib/animate.css">
<link rel="stylesheet" type="text/css" href="../../css/app/style.css">
<style type="text/css">
.bs-example {
	margin: 10px;
}
</style>
</head>
<body>

	<form class="contactForm" ng-app="myApp" ng-controller="myCtrl2">

		<div ng-show="isResult">
			Your poll successfully saved!!! <br></br>
		</div>
		<div ng-show="isVoteDoneAlready">Your vote is already captured
			successfully. Please close browser and try again!!!!</div>

		<div class="form-group">
			<select ng-change="assemblyConstituency(selectedDistrict)"
				ng-model="selectedDistrict" id="source" name="source"
				class="form-control ng-pristine ng-valid"
				ng-options="t.districtCode as t.districtName for t in distlist | orderBy:'districtName'"
				title="Select district">
				<option value="" id="district">Select District</option>
			</select>
			<div class="validation"></div>
		</div>
		<div class="form-group">
			<select ng-model="selectedAssemblyConstituency" id="source"
				name="source" class="form-control ng-pristine ng-valid"
				ng-options="tt.constituencyCode as tt.constituencyName for tt in aclist | orderBy:'constituencyName'"
				title="Select constituency">
				<option value="" id="district">Select Constituency</option>
			</select>
			<div class="validation"></div>
		</div>

		<div class="text-center">
			<button type="submit" class="contact-submit button_jsp"
				ng-disabled="isDisabled" ng-click="loadPage('JSP')">Go</button>
		</div>
		<br>
		
	</form>
	<div class="bs-example table-responsive">
		<table class="table table-bordred">
			<thead>
				<tr>
					<th>Party</th>
					<th>Total Votes</th>
					<th>Vote Share</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${partyVotesResultsList}" var="p1"
					varStatus="tagStatus">
					<tr class="bgcolor_${p1.partyName}">
						<td>${p1.partyName}</td>
						<td>${p1.partyVotes}</td>
						<td>${p1.votesShare}%</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>