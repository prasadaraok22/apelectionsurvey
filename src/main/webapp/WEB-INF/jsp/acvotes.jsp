<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en" class="no-js">

<%@ include file="header.jsp"%>

<body ng-app="myApp">
	<%@ include file="menu.jsp"%>

	<br>
	
	<div id="contact-info">
			<div class="container">
				<div class="row">

					<div class="contact col-md-6 wow fadeIn delay-08s">
						<div class="col-md-10 col-md-offset-1">
							<div id="note"></div>
							<div id="sendmessage">Your message has been sent. Thank
								you!</div>
							<div id="errormessage"></div>
							<form class="contactForm" ng-controller="myCtrl2">

								<div ng-show="isResult">
									Your poll successfully saved!!! <br></br>
								</div>
								<div ng-show="isVoteDoneAlready">Your vote is already
									captured successfully. Please close browser and try again!!!!</div>

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
										ng-disabled="isDisabled" ng-click="loadPage('JSP')">JSP జనసేన</button>
								</div>
								<br>
								<div class="text-center">
									<button type="submit" class="contact-submit button_ysrcp"
										ng-disabled="isDisabled" ng-click="loadPage('YSRCP')">YSR
										CP వైయ‌స్ఆర్‌ కాంగ్రెస్ పార్టీ</button>
								</div>
								<br>
								<div class="text-center">
									<button type="submit" class="contact-submit button_tdp"
										ng-disabled="isDisabled" ng-click="loadPage('TDP')">TDP తెదేపా</button>
								</div>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>


	<%@ include file="footer.jsp"%>
</body>
</html>