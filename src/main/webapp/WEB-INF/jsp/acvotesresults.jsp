<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en" class="no-js">

<%@ include file="header.jsp"%>

<body>
	<%@ include file="menu.jsp"%>

	<br>
	
	<div id="contact-info">
			<div class="container">
				<div class="row">

					<div class="contact col-md-6 wow fadeIn delay-08s">
						<div class="col-md-10 col-md-offset-1">
							
							<div id="errormessage"></div>
							<form class="contactForm" ng-app="myApp" ng-controller="myCtrl2">

								<div class="form-group">
									<select ng-change="assemblyConstituencyVotesResults(selectedDistrict)"
										ng-model="selectedDistrict" id="source" name="source"
										class="form-control ng-pristine ng-valid"
										ng-options="t.districtCode as t.districtName for t in distlist | orderBy:'districtName'"
										title="Select district">
										<option value="" id="district">Select District</option>
									</select>
									<div class="validation"></div>
								</div>
								<br>
								<div id="showACresults" class="bs-example table-responsive">
								<table class="table table-bordred">
									<thead>
										<tr>
											<th>Constituency</th>
											<th>JSP</th>
											<th>TDP</th>
											<th>YSRCP</th>
											<th>Lead</th>
										</tr>
									</thead>
									<tbody>
										 <tr ng-repeat="p1 in records">
											<th scope="row">{{p1.constituencyName}}</th>
						            		<td class="bgcolor_JSP">{{p1.partyVotes.JSP}}</td>
						           			<td class="bgcolor_TDP">{{p1.partyVotes.TDP}}</td>
						            		<td class="bgcolor_YSRCP">{{p1.partyVotes.YSRCP}}</td>
						            		<td class="bgcolor_{{p1.leadParty}}">{{p1.leadParty}}</td>
										</tr> 
									</tbody>
								</table>
								</div>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>

	<%@ include file="footer.jsp"%>
</body>
</html>