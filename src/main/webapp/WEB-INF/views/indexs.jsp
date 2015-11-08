<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
        <title>TODO supply a title</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="assets/css/bootstrap.min.css" rel="stylesheet">
        <link href="assets/css/font-awesome.min.css" rel="stylesheet">
    </head>
    <body>
        <h2>Add a movie:</h2>
        <form>
            <label for="movieName">Name: </label>
            <input type="text" id="movieName"/>
            <label for="movieDirector">Director: </label>
            <input type="text" id="movieDirector"/>
            <label for="movieGenre">Genre: </label>
            <input type="text" id="movieGenre"/>
            <label for="movieIncome">Gross Income: </label>
            <input type="number" id="movieIncome"/>
            <label for="movieRating">Rating: </label>
            <input type="number" min="1" max="5" id="movieRating"/>
            <label for="movieReleaseDate">Release Date: </label>
            <input type="date" min="1900" max="2100" id="movieReleaseDate"/>
            <br/>
            <br/>
            <button type="button" id="addMovieButton">Add Movie</button>
            
        </form>
        <hr/>
        <h2>Movies:</h2>
        <hr>
        <div id="moviesDiv"></div>
        <h2>Actors:</h2>
        <hr>
        <div id="actorsDiv"></div>
    </body>
</html>

<script>
    apiUrl = "${apiUrl}";
</script>

<script src="assets/js/lib/jquery-1.11.1.min.js"></script>
<script src="assets/js/lib/lodash.min.js"></script>
<script src="assets/js/app.js"></script>


