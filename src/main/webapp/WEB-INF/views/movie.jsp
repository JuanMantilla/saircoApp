<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
        <title>Movie</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="../assets/css/bootstrap.min.css" rel="stylesheet">
        <link href="../assets/css/font-awesome.min.css" rel="stylesheet">
    </head>
    <body>
        
        <h2>Movie:</h2>
        <div id="movieDiv"></div>
        
        <h2>Add Actor:</h2>
        <form>
        <div id="addActorDiv"></div>
        <br/>
        <button type="button" id="addActorButton">Add Actor</button>
        </form>

</html>

<script>
    apiUrl = "${apiUrl}";
    console.log(apiUrl);
    movieId = "${movieId}";
</script>

<script src="../assets/js/lib/jquery-1.11.1.min.js"></script>
<script src="../assets/js/lib/lodash.min.js"></script>
<script src="../assets/js/movie.js"></script>
<script src="../assets/js/addactors.js"></script>
