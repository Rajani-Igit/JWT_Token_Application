<html ng-app="tokenmodule">
<head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <script src="resources/assets/jquery-3.2.1.min.js">
        </script>
        <script src="resources/assets/js/framework/angular.js"></script>
        <script src="resources/assets/js/tokenaccess.js"></script>
      <!--  <script src="https://cdnjs.cloudflare.com/ajax/libs/xlsx/0.11.10/xlsx.js"></script>
       <script src="https://cdnjs.cloudflare.com/ajax/libs/alasql/0.4.3/alasql.min.js"></script> -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <title>Add Usesr</title>
    </head>
<body ng-controller="tokenctrl">
<h2 style="margin-left:518px;">Token Generation</h2>
<p style="margin-left:232px">Change your mail id in  server side code if(claims.get("uid").equals("rajanikanta.pradhan5@gmail.com")), then enter the same mail to generate token</p>
<div style="position: absolute;width: 1000px;left: 415px;">
 <form>
                    <div class="form-group">
                        <label for="usr">Email:</label>
                        <input type="text"  placeholder=" Email id" class="form-control" style="width: 50%;" ng-model="emailid">
                    </div>
                     <button class="btn btn-success" ng-click="generateToken(emailid)">Generate Token</button>
                    
                    <div class="form-group">
      <label for="comment">Comment:</label>
      <textarea class="form-control" rows="5" id="comment" style="width:50%;">{{accesstoken}}</textarea>
    </div>
    
    <div class="form-group">
                        <label for="usr">Token:</label>
                        <input type="text"  placeholder="Enter the token" class="form-control" style="width: 50%;" ng-model="token">
                    </div>
                     <button class="btn btn-success" ng-click="validateToken(token)">Validate Token</button>
                    
                    <div class="form-group">
                    </form>
</div>
</body>
</html>
