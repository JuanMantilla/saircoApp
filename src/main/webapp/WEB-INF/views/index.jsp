<!DOCTYPE html>
    <html ng-app="springMoviesApp">
    <head>


        <meta http-equiv="content-type" content="text/html; charset=UTF-8">
        <meta charset="utf-8">
        <title>Spring Movies App</title>
        <meta name="generator" content="Bootply" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="assets/css/bootstrap.min.css" rel="stylesheet">
        <link href="assets/css/font-awesome.min.css" rel="stylesheet">
        <!--[if lt IE 9]>
                <script src="//html5shim.googlecode.com/svn/trunk/html5.js"></script>
        <![endif]-->
        <!--link href="css/styles.css" rel="stylesheet"-->
    </head>
    <body>
        <div ng-controller="navbarController"class="navbar navbar-inverse navbar-fixed-top" role="navigation">

            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" rel="home" href="/SpringMoviesApp">Spring Movies App</a>
            </div>

            <div class="collapse navbar-collapse">

                <ul class="nav navbar-nav">                   
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">Menu <b class="caret"></b></a>
                        <ul class="dropdown-menu">
                            <li><a href="" ng-click="addMovie()">Add Movie</a></li>
                            <li class="divider"></li>
                            <li><a href="" ng-click="addActor()">Add Actor</a></li>
                        </ul>
                    </li>
                </ul>               
                <div class="col-sm-3 col-md-3 pull-right">
                    
                    <form class="navbar-form" role="search">
                        <div class="input-group">
                            <input type="text" class="form-control" placeholder="Search" name="srch-term" id="srch-term">
                            <div class="input-group-btn">
                                <button class="btn btn-default" type="submit"><i class="glyphicon glyphicon-search"></i></button>
                            </div>
                        </div>
                    </form>
                </div>

            </div>
        </div>

        <br/>
        <br/>
        <br/>
        <div ng-view autoscroll>

        </div>
        <!-- script references -->
<script>
    apiUrl = "${apiUrl}";
</script>

<script src="assets/js/lib/jquery-1.11.1.min.js"></script>
<script src="assets/js/lib/bootstrap.min.js"></script>
<script src="assets/js/lib/lodash.min.js"></script>
<script src="assets/js/lib/angular.min.js"></script>
<script src="assets/js/lib/angular-route.min.js"></script>
<script src="assets/js/lib/angular-currency-mask.js"></script>
<script src="assets/js/lib/ui-bootstrap-tpls-0.14.0.min.js"></script>
<script src="assets/js/app/moduleRegistration.js"></script>
<script src="assets/js/app/services/movieService.js"></script>
<script src="assets/js/app/services/actorService.js"></script>
<script src="assets/js/app/controllers/homeController.js"></script>
<script src="assets/js/app/controllers/movieController.js"></script>
<script src="assets/js/app/controllers/actorController.js"></script>
<script src="assets/js/app/controllers/navbarController.js"></script>
<script src="assets/js/app/app.js"></script>

    </body>
    
</html>
<script type="text/ng-template" id="addMovieModal">
    <div class="modal-header">
    <button type="button" class="close" ng-click="cancel();" aria-hidden="true">&times;</button>
    <h4 class="modal-title">Add a movie</h4>
    </div>
    <div class="modal-body">
    <form name="movieForm" novalidate>

    <div class="row">
    <div class="col-md-5">
    <div class="form-group">
    <label for="name" class="control-label">Name: </label>
    <input id="name" class="form-control" type="text" ng-model="movie.name" required/>
    </div>
    </div>
    </div>
    <div class="row">
    <div class="col-md-5">
    <div class="form-group">
    <label for="director" class="control-label">Director: </label>
    <input id="director" class="form-control" type="text" ng-model="movie.director" required/>
    </div>
    </div>
    </div>
    <div class="row">
    <div class="col-md-5">
    <div class="form-group">
    <label for="genre" class="control-label">Genre: </label>
    <input id="genre" class="form-control" type="text" ng-model="movie.genre" required/>
    </div>
    </div>
    </div>
    <div class="row">
    <div class="col-md-5">
    <div class="form-group">
    <label for="income" class="control-label">Gross Income: </label>
    <input id="income" class="form-control" type="number" ng-model="movie.grossIncome" required/>
    </div>
    </div>
    </div>
    <div class="row">
    <div class="col-md-5">
    <div class="form-group">
    <label for="rating" class="control-label">Rating: </label>
    <input id="rating" class="form-control" type="number" ng-model="movie.rating" required/>
    </div>
    </div>
    </div>
    <div class="row">
    <div class="col-md-5">
    <div class="form-group">
    <label for="releaseDate" class="control-label">Release Date: </label>
    <input id="releaseDate" class="form-control" type="date" ng-model="movie.releaseDate" required/>
    </div>
    </div>
    </div>


    </form>
    </div>
    <div class="modal-footer">
    <button type="button" class="btn btn-primary" ng-disabled="movieForm.$invalid" ng-click="ok()">Add</button>
    <button class="btn btn-warning" type="button" ng-click="cancel()">Cancel</button>
    </div>
</script>

<script type="text/ng-template" id="addActorModal">
    <div class="modal-header">
    <button type="button" class="close" ng-click="cancel();" aria-hidden="true">&times;</button>
    <h4 class="modal-title">Add an actor</h4>
    </div>
    <div class="modal-body">
    <div class="modal-body">
        <form name="actorForm" class="my-form" novalidate>
                    

                    <div class="row">
                        <div class="col-md-6">

                            <div class="form-group">
                                <label for="firstName" class="control-label">First Name</label>
                                <input ng-model="actor.firstName" type="text" class="form-control" id="firstName" required>
                            </div>

                        </div>
                        <div class="col-md-6">

                            <div class="form-group">
                                <label for="lastName" class="control-label">Last Name</label>
                                <input ng-model="actor.lastName" type="text" class="form-control" id="lastName" required>
                            </div>

                        </div>
                    </div>

                    <div class="row">
                        <div class="col-md-6">
                            <div class="form-group">
                                <label for="gender" class="control-label">Gender</label>
                                <select id="gender" class="form-control" ng-model="actor.gender" required>
                                    <option>Male</option>
                                    <option>Female</option>
                                </select>
                            </div>
                        </div>
                
                        <!--div class="col-md-6">
                            <div class="form-group">
                                <label for="actorPhoto" class="control-label">Photo</label>
                                <input ng-model="actor.photo" fileread="photo" type="file" class="form-control" id="actorPhoto">
                            </div>
                        </div-->
                    </div>
            
                    <div class="row">
                        <div class="col-md-6">
                        <label for="birth" class="control-label">Birth Date</label>
                        <input id="birth" class="form-control" type="date" ng-model="actor.birthDate" required/>
                            
                        </div>
                    </div>
            
                    
                    
                </form>
    </div>
    <div class="modal-footer">
    <button type="button" class="btn btn-primary" ng-disabled="movieForm.$invalid" ng-click="ok()">Add</button>
    <button class="btn btn-warning" type="button" ng-click="cancel()">Cancel</button>
    </div>
</script>