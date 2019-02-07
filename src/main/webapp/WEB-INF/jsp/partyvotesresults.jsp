<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
							
							<c:choose>
    							<c:when test="${displayVotesResults == 'no'}">
        							<div id="404message"> Sorry!!!! <br>
        							The results will be available on March 31st 2019</div>
    							</c:when>
	    						<c:otherwise>
	    							<form class="contactForm">

								<br>
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
										<c:forEach items="${partyVotesResultsList}" var="p1" 	varStatus="tagStatus">
											<tr class="bgcolor_${p1.partyName}">
												<td>${p1.partyName}</td>
												<td>${p1.partyVotes}</td>
												<td>${p1.votesShare}%</td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
								</div>
							</form>
	    						</c:otherwise>
							</c:choose>
							
						</div>
					</div>
				</div>
			</div>
		</div>

	<%@ include file="footer.jsp"%>
</body>
</html>