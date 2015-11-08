/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$.ajax({
    type: 'GET',
    url: apiUrl + 'actor/'
}).done(function (response) {
    var html = '';
     html += "<div class='actor'>";
    html += "<select id=actorgender>";
    _.each(response, function (actor) {
        html += "<option value=\""+actor.id+"\">"+ actor.firstName+ " " + actor.lastName+"</option>";
    });
    html += "</select>";
    html +="</div>";
    $('#addActorDiv').html(html);
    
    $("#addActor").click(function () {
    var actor = {
        id: $("#actorgender").val()
    };
    $.ajax({
        type: 'POST',
        contentType: "application/json",
        url: apiUrl + 'movie/'+movieId+'/actors',
        data: JSON.stringify([actor])
    }).done(function (response) {
        alert("Se creo el actor " + response.name);
    });
});
});