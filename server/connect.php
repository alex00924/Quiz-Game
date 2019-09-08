<?php
$db_name="stylios";
//$mysql_user="stylios";
//$mysql_pass="hAZrQcDXPq5LUqGw";
$mysql_user="root";
$mysql_pass="";
$server_name="localhost";

$con=mysqli_connect($server_name,$mysql_user,$mysql_pass,$db_name);

if(!$con){
	//echo "Connection error";
}else{
	//echo "Connection stablish";
}
?>