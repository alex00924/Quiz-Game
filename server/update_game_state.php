<?php
require"connect.php";
$game=$_POST["game"];
$stage=$_POST["stage"];
$contents=$_POST["contents"];

$sql_query="insert into game_state(game,stage,contents) values('$game','$stage','$contents');";

if(mysqli_query($con,$sql_query)){
	echo "{response: sucess}";
}else{
	echo "{response: fail}";
}

?>