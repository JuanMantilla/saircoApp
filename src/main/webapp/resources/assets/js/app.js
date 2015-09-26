/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//Muestra las peliculas agregadas exitosamente
$.ajax({
    type: 'GET',
    url: apiUrl + 'movie/'
}).done(function (response) {
    var html = '';
    _.each(response, function (movie) {

        html += "<div class='movie'>Name: " + movie.name + "<br/>";
        html += "Director: " + movie.director + "<br/>";
        html += "Genre: " + movie.genre + "</div>";

    });
    $('#moviesDiv').html(html);
});
//Muestra los actores agregados exitosamente
$.ajax({
    type: 'GET',
    url: apiUrl + 'actor/'
}).done(function (response) {
    var html = '';
    _.each(response, function (actor) {

        html += "<div class='actor'>Name: " + actor.name + "<br/>";
        html += "LastName: " + actor.lastName + "<br/>";
        html += "Gender: " + actor.gender + "</div>";
        html += "Date of birth: " + actor.nacimiento + "</div>";

    });
    $('#actorsDiv').html(html);
});
//Agrega la pelicula a la base de datos
$("#addMovieButton").click(function (e) {
    var movie = {
        name: $("#movieName").val(),
        director: $("#movieDirector").val(),
        genre: $("#movieGenre").val(),
        income: $("#movieIncome").val(),
        rating: $("#movieRating").val(),
        releaseDate: $("#movieReleaseDate").val()
    };
    $.ajax({
        type: 'PUT',
        contentType: "application/json",
        url: apiUrl + 'movie/',
        data: JSON.stringify(movie)
    }).done(function (response) {
        alert("Se creo la pel\xEDcula con nombre " + response.name);
    });
});
//Agrega el actor a la base de datos
$("#addActorButton").click(function (e) {
    var actor = {
        name: $("#actorName").val(),
        lastName: $("#lastName").val(),
        gender: $("#actorGender").val(),        
        nacimiento: $("#actorDateOfBirth").val()
    };
    $.ajax({
        type: 'PUT',
        contentType: "application/json",
        url: apiUrl + 'actor/',
        data: JSON.stringify(actor)
    }).done(function (response) {
        alert("Se anadio el actor con nombre " + response.name);
    });
});