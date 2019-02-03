'use strict'

var demoApp = angular.module('demo', [ 'ui.bootstrap', 'demo.controllers',
		'demo.services' ]);
demoApp.constant("CONSTANTS", {
	getUserByIdUrl : "/user/getUser/",
	getAllUsers : "/user/getAllUsers",
	saveUser : "/user/saveUser"
});


var app = angular.module('myApp', []);

app.controller('myCtrl2', function($scope, $http) {
	$scope.isResult = false;
	$scope.showACresults = false;
        $scope.distlist = response.data;
        $http.get("/api/districts")
        .then(function(response) {
    });
    
    $scope.assemblyConstituency = function(selectedDistrict) {
    	$http.get("/api/assemblyconstituencies?stateID=S01&districtCode=" + selectedDistrict)
	    .then(function(response) {
	    	$scope.aclist = response.data;
	    });
    };
    
    $scope.assemblyConstituencyVotesResults = function(selectedDistrict) {
    	
    	// URL
		var url = "/api/acvotesresults?districtCode="+selectedDistrict;
		
		// Prepare headers for posting
		
		// Prepare data for post messages
    	
		// Do posting
   	 	$http.get(url)
        .then(function (response) {
        	$scope.records = response.data;
        	$scope.showACresults = true;
            
        })
        .catch(function(response) {
       	 	alert('error');
        })
    };
    
    $scope.loadPage = function(partyID) {
    	
    	// Disable buttons quickly after click and enable if there are any failures
    	$scope.isDisabled = true;
    	$scope.isLoading = true;
    	
    	if ($scope.selectedDistrict == null || $scope.selectedAssemblyConstituency == null || partyID == null) {
    		$scope.isDisabled = false;
            return;
        }
    	
    	// Post URL
		var url = "/api/assemblyconstituencyvote";
		
		// Prepare headers for posting
		var config = {
                headers : {
                	'Content-Type': 'application/json',
                    'Accept': 'text/plain'
                }
            }
		
		// Prepare data for post messages
    	var data = null;
    	data = { constituencyCode: $scope.selectedAssemblyConstituency, districtCode: $scope.selectedDistrict, stateID: 'S01', partyID: partyID };
   
		// Do posting
    	 $http.post(url, data, config)
         .then(function (response) {
        	 if("Success" == response.data) {
            	 $scope.isDisabled = true;
            	 $scope.isResult = true;
        	 }else if("DoneAlready" == response.data){
            	 $scope.isDisabled = true;
            	 $scope.isVoteDoneAlready = true;
        	 }
             
         })
         .catch(function(response) {
        	 $scope.isDisabled = false;
        	 alert('error');
         })
    };
    
});

app.controller('myCtrl3', function($scope, $http) {
    
    $scope.voteForParty = function(partyID) {
    	
    	// Disable buttons quickly after click and enable if there are any failures
    	$scope.isDisabled = true;
    	$scope.isLoading = true;
    	
    	// Post URL
		var url = "/api/voteforparty";
		
		// Prepare headers for posting
		var config = {
                headers : {
                	'Content-Type': 'application/json',
                    'Accept': 'text/plain'
                }
            }
		
		// Prepare data for post messages
    	var data = null;
    	data = { stateID: 'S01', partyID: partyID };
   
		// Do posting
    	 $http.post(url, data, config)
         .then(function (response) {
        	 if("Success" == response.data) {
            	 $scope.isDisabled = true;
            	 $scope.isResult = true;
        	 }else if("DoneAlready" == response.data){
            	 $scope.isDisabled = true;
            	 $scope.isVoteDoneAlready = true;
        	 }
         })
         .catch(function(response) {
        	 $scope.isDisabled = false;
        	 alert('error');
         })
    };
    
});

app.controller('myFooterCtrl', function($scope, $http) {

	$http.get("/api/totalpartyvotes")
    .then(function(response) {
        $scope.totalpartyvotes = response.data;
    });
	
	$http.get("/api/totalacvotes")
    .then(function(response) {
        $scope.totalacvotes = response.data;
    });
	
});

app.controller('myCtrl4', function($scope, $http) {
    
    $scope.voteForParty = function(districtcode) {
    	
    	// URL
		var url = "/api/acvotesresults";
		
		// Prepare headers for posting
		var config = {
                headers : {
                	'Content-Type': 'application/json',
                    'Accept': 'text/plain'
                }
            }
		
		// Prepare data for post messages
    	var data = null;
    	data = { stateID: 'S01', districtcode: districtcode };
   
		// Do posting
    	 $http.get(url, data, config)
         .then(function (response) {
        	 $scope.records = response.data;
         })
         .catch(function(response) {
        	 $scope.isDisabled = false;
        	 alert('error');
         })
    };
    
});

