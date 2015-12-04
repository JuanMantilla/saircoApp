<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html ng-app="saircoApp">
    <head>
        <title>SaircoApp</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        
        
        <link href="assets/css/bootstrap.min.css" rel="stylesheet">
        <link href="assets/css/material-fullpalette.min.css" rel="stylesheet">
        <link href="assets/css/ripples.min.css" rel="stylesheet">
        <link href="assets/css/roboto.min.css" rel="stylesheet">
        <link href="assets/css/font-awesome.min.css" rel="stylesheet">
        <link href="assets/css/ui-grid.min.css" rel="stylesheet">
        <link href="assets/css/bootstrap-datetimepicker.css" rel="stylesheet" media="screen">
        
        <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
        <![endif]-->
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    </head>
    <body class="container-fluid">
        <div ng-controller="navbarController" class="navbar navbar-default">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-responsive-collapse">
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="#/">Sairco App</a>
            </div>
            <div class="navbar-collapse collapse navbar-responsive-collapse">
                <ul class="nav navbar-nav navbar-right">
                    <li class="active"><a href="#/">Home</a></li>
                    <li><a href="#/admin">Admin</a></li>
                    <li><a href="#/user">Reservar equipo</a></li>
                    <li ng-show="loggedIn"><a href="" ng-click="logout()">Logout</a></li>
                    <li ng-show="!loggedIn"><a href="" ng-click="login()">Login</a></li>
                </ul>
                <form class="navbar-form navbar-left">
                    <input type="text" class="form-control col-lg-8" placeholder="Search">
                </form>

            </div>
        </div>

        <div ng-view autoscroll>

        </div>
           <script type="text/javascript" src="assets/js/lib/bootstrap-datetimepicker.js" charset="UTF-8"></script>
            <script type="text/javascript" src="assets/js/lib/locales/bootstrap-datetimepicker.fr.js" charset="UTF-8"></script>
            <script type="text/javascript">
                $('.form_datetime').datetimepicker({
                    //language:  'fr',
                    weekStart: 1,
                    todayBtn:  1,
                    autoclose: 1,
                    todayHighlight: 1,
                    startView: 2,
                    forceParse: 0,
                    showMeridian: 1
                });
                </script>
    </body>
</html>





<script>
    apiUrl = "${apiUrl}";
</script>

<!--jQuery-->
<script src="assets/js/lib/jquery-1.8.3.min.js"></script>
<!--lodash-->
<script src="assets/js/lib/lodash.min.js"></script>
<!--Angular stuff-->
<script src="assets/js/lib/angular.min.js"></script>
<script src="assets/js/lib/angular-route.min.js"></script>
<script src="assets/js/lib/angular-currency-mask.js"></script>
<script src="assets/js/lib/ui-grid.min.js"></script>

<!--bootstrap and material design stuff-->
<script src="assets/js/lib/bootstrap.min.js"></script>
<script src="assets/js/lib/ripples.min.js"></script>
<script src="assets/js/lib/material.min.js"></script>

<!--angular - boostrap "interface"-->
<script src="assets/js/lib/ui-bootstrap-tpls-0.14.0.min.js"></script>

<!--my own stuff-->
<script src="assets/js/app/moduleRegistration.js"></script>
<script src="assets/js/app/services/salonService.js"></script>
<script src="assets/js/app/services/equipoService.js"></script>
<script src="assets/js/app/services/authService.js"></script>
<script src="assets/js/app/controllers/homeController.js"></script>
<script src="assets/js/app/controllers/salonController.js"></script>
<script src="assets/js/app/controllers/equipoController.js"></script>
<script src="assets/js/app/controllers/navbarController.js"></script>
<script src="assets/js/app/controllers/adminController.js"></script>
<script src="assets/js/app/controllers/userController.js"></script>
<script src="assets/js/app/controllers/loginController.js"></script>
<script src="assets/js/app/app.js"></script>

