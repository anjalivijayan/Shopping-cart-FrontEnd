


<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html >
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>All Product Info</title>

<link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/bootswatch/3.2.0/sandstone/bootstrap.min.css">
<script	src="//ajax.googleapis.com/ajax/libs/jquery/2.2.2/jquery.min.js"></script>
<script	src="//netdna.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min.js"></script>
<script	src="http://ajax.googleapis.com/ajax/libs/angularjs/1.2.23/angular.min.js"></script>

<script>
 var app = angular.module('myApp', []);
function MyController($scope, $http) {

	  $scope.sortType     = 'name'; // set the default sort type
	  $scope.sortReverse  = false;  // set the default sort order
	  $scope.searchsubject   = '';     // set the default search/filter term

        $scope.getDataFromServer = function() {
        	
                $http({
                        method : 'GET',
                        url : '/p'
                }).success(function(data, status, headers, config) {
                        $scope.Blogs = data; alert(data);
                       
                        
                }).error(function(data, status, headers, config) {
                	///alert("ddderrr
                });

        };
        
}; 


</script>

<style>
body { padding-top:50px; }
</style>

<body>
<div class="container" ng-app="myApp" ng-controller="MyController" >
  <form>
    <div class="form-group">
      <div class="input-group">
        <div class="input-group-addon"><i class="fa fa-search"></i></div>
        <input type="text" class="form-control" ng-model="searchsubject" placeholder="Search Product Name" >
       	     </div>      
    </div>
  </form>
  
  <div ng-init="getDataFromServer()" >
  
     
		
	
		

       
<H2> PRODUCTS</H2>
<HR/>
  
  <div >
  <ul>
  	<li  ng-repeat="roll in Blogs | orderBy:sortType:sortReverse | filter:searchsubject">
  	<br/><br/>
  	Product id:{{ roll.id}}<br/><br/>
  	Product name:{{ roll.name }}<br/><br/>
  	{{ roll.description }}<br/><br/>
  	{{ roll.price}} <br><br>
  	{{ roll.category_id }} <br><br>
  	{{ roll.supplier_id }} <br><br>
  	
  	
  	</li>
  </ul>
  
 
 </div>
 </div>
 
  
</div>

</body>


</body>
</html>