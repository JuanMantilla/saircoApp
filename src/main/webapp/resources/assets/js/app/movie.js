/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$.ajax({
    type: 'GET',
    url: apiUrl + 'movie/' + movieId
}).done(function (movie) {
    var html = '';


    html += "<div class='movie'>Name:" + movie.name + "</a><br/>";
    html += "Director: " + movie.director + "<br/>";
    html += "Genre: " + movie.genre + "<br/>"+"</div>";
    html += "Gross income: " + movie.grossIncome +"<br/>"+ "</div>";
    html += "Gross rating: " + movie.rating +"<br/>"+ "</div>";
    html += "Release date: " + movie.releaseDate + "</div>";
    html += "<br/> <h1>Actors:</h1> <div id='actorsDiv'>";
    _.each(movie.actors, function (actor) {

        html += "<div class='movie'>First name: " + actor.firstName + "<br/>";
        html += "Last name: " + actor.lastName + "</div>";
        html += "Gender: " + actor.gender + "</div>";
        html += "Birth date: " + actor.birthdate + "</div>";

    });
    html += "</div>";


    $('#movieDiv').html(html);
});

