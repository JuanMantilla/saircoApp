<!DOCTYPE html>
<!--
Autor: Juan Mantilla
-->
<html>
    <head>
        <title>Actores</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
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
            <br/>
            <button type="button" id="addActorButton">Add Actor</button>
            
        </form>
        <hr/>
        <h2>Actors:</h2>
        <div id="actorsDiv"></div>
    </body>
</html>

<script>
    apiUrl = "${apiUrl}";
</script>

<script src="assets/js/lib/jquery-1.11.1.min.js"></script>
<script src="assets/js/lib/lodash.min.js"></script>
<script src="assets/js/app.js"></script>
