<script>
    apiUrl = "${apiUrl}";
</script>
<!DOCTYPE html>
<html lang="en">
    <head>


        <meta http-equiv="content-type" content="text/html; charset=UTF-8">
        <meta charset="utf-8">
        <title>Spring Movies App</title>
        <meta name="generator" content="Bootply" />
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
        <link href="assets/css/bootstrap.min.css" rel="stylesheet">
        <link href="assets/css/font-awesome.min.css" rel="stylesheet">
        <!--[if lt IE 9]>
                <script src="//html5shim.googlecode.com/svn/trunk/html5.js"></script>
        <![endif]-->
        <!--link href="css/styles.css" rel="stylesheet"-->
    </head>
    <body>
        <div class="navbar navbar-inverse navbar-fixed-top" role="navigation">

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
                            <li><a href="addActor/">Add actor</a></li>
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


        <div class="container">

            <div class="text-center">
                <h2>Add an actor:</h2>
        <form>
            <label for="actorName">Name: </label>
            <input type="text" id="actorName"/>
            <label for="lastName">Last name: </label>
            <input type="text" id="lastName"/>
            <label for="actorGender">Gender: </label>
            <input type="text" id="actorGender"/>            
            <label for="actorDateOfBirth">Date of birth: </label>
            <input type="date" min="1900" max="2100" id="actorDateOfBirth"/>
            <br/>
            <label for="movies">Movie this actor played in</label>
            <input type="text" id="movie"/> 
            <br/>
            <button type="button" id="addActorButton">Add Actor</button>           
        </form>
        <hr/>
        </div>
        <h2>Actors:</h2>
        <div id="actorsDiv"></div>
            </div>

        </div><!-- /.container -->
        <!-- script references -->


    </body>
</html>
<script>
    apiUrl = "${apiUrl}";
</script>

<script src="assets/js/lib/jquery-1.11.1.min.js"></script>
<script src="assets/js/lib/lodash.min.js"></script>
<script src="assets/js/app.js"></script>
<script src="assets/js/lib/bootstrap.min.js"></script>