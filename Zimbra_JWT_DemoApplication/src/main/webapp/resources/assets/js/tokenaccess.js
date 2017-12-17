var app=angular.module("tokenmodule",[]);
app.controller("tokenctrl",["$scope","$http",function($scope,$http){
	alert("inside controller");
	$scope.accesstoken="";
	$scope.emailid="rajanikanta.pradhan5@gmail.com";
	//var accesstoken="eyJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJSYWphbmlrYW50YSIsInN1YiI6IkFzY2Vzc2luZyBmb3IgU2VydmljZXMiLCJ1aWQiOiJyYWphbmlrYW50YS5wcmFkaGFuNUBnbWFpbC5jb20iLCJzY29wZSI6InVzZXIiLCJpYXQiOjE0NjY3OTY4MjIsImV4cCI6NDYyMjQ3MDQyMn0.z0LYq_mcjuojZfhXYOFotcniHoR1qvODWcJYa-10rxw";
	$scope.generateToken=function(emailid) {
		$http({
		    method: 'GET',
		    url: 'keygen.action',
		    headers: {'Content-Type': 'application/x-www-form-urlencoded','Accept' : 'text/plain'},
		    params: {email:emailid}
		}).then(function(response) {
		    alert(response.data)
		    $scope.accesstoken=response.data;
		}, function(error) {
			console.log(error);
		    alert("Eror occured")
		});
		
	}
	
	$scope.validateToken=function(accesstoken) {
	$http({
		    method: 'POST',
		    url: 'validatetoken.action',
		    headers: {'Content-Type': 'application/x-www-form-urlencoded','Accept' : 'text/plain'},
		    params: {token:accesstoken}
		}).then(function(response) {
		    alert(response.data)
		}, function(error) {
			console.log(error);
		    alert("Eror occured")
		});
	}
				
}])