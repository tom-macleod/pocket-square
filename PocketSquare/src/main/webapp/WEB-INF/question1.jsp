<!DOCTYPE html>

<html>
	<head>
		<title>Main Page</title>
		<link type="text/css" rel="stylesheet" href="style.css" />
	</head>
	
	<body>
	
	<h1>What Pocket Square Are You?</h1>
	
	<br>
	
	<h3>Which of these animals do you identify with most closely?</h3>
		
	<form method="POST" action="pocket"  class="forms">
		
		<input type="hidden" name="page" value="1" />
		<input type="radio" name="question1" value="1" checked/> Cat <br>
		<input type="radio" name="question1" value="0" /> Sloth <br>
		<input type="radio" name="question1" value="2" /> Puma <br>
		<input type="radio" name="question1" value="3" /> Peacock <br>
		
		<br>
	
		<input type="submit" value="Submit" />
	
	</form>	
		
	</body>


</html>