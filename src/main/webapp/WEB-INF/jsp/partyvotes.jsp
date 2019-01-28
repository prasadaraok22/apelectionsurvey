<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html lang="en">

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Maundy | Comming Soon Page</title>
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

</head>

<body>
	<div class="content">
		<div class="container wow fadeInUp delay-03s">
			<div class="row">
				<div class="logo text-center">

					<h2>Andhra Pradesh Assembly Election 2019 Survey</h2>
				</div>

			</div>
		</div>

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
							<form class="contactForm" ng-app="myApp" ng-controller="myCtrl3">

								<div ng-show="isResult">
									Your poll successfully saved!!! <br></br>
								</div>
								<div ng-show="isVoteDoneAlready">Your vote is already
									captured successfully. Please close browser and try again!!!!</div>

								<div class="text-center">
									<button type="submit" class="contact-submit button_jsp"
										ng-disabled="isDisabled" ng-click="voteForParty('JSP')">JSP జనసేన</button>
								</div>
								<br>
								<div class="text-center">
									<button type="submit" class="contact-submit button_ysrcp"
										ng-disabled="isDisabled" ng-click="voteForParty('YSRCP')">YSR
										CP వైయ‌స్ఆర్‌ కాంగ్రెస్ పార్టీ</button>
								</div>
								<br>
								<div class="text-center">
									<button type="submit" class="contact-submit button_tdp"
										ng-disabled="isDisabled" ng-click="voteForParty('TDP')">TDP తెదేపా</button>
								</div>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<footer class="footer">
		<div class="container">
			<div class="row bort">

				<div class="copyright">
					Â© Copyright Maundy Theme. All rights reserved.
					<div class="credits">
						
						Designed by <a href="https://bootstrapmade.com/">BootstrapMade</a>
					</div>
				</div>

			</div>
		</div>
	</footer>

</body>

</html>
