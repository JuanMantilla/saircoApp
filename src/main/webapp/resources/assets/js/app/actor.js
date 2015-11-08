/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$.ajax({
    type: 'GET',
    url: apiUrl + 'actor/' + actorId
}).done(function (actor) {
    var html = '';

    html += "<div class='actor'>Name:<a href='actors/"+actor.id+"'>" + actor.name + " "+ actor.lastName+"</a><br/>";
    html += "Gender: " + actor.gender + "</div>";
    html += "Date of birth: " + actor.nacimiento + "</div>";
    html += "<br/> <h1>Movies:</h1> <div id='actorsDiv'>";
    _.each(actor.movies, function (movie) {
        html += "<div class='movie'>Name: <a href='"+apiUrl+"movies/"+movie.id+"'>" + movie.name + "</a><br/>";
        html += "Genre: " + movie.genre + "</div>";
        html += "Release Date: " + movie.releaseDate + "</div>";

    });
    html += "</div>";


    $('#actorDiv').html(html);
});

