<?php
session_start();
static $file = "direction.txt";

$sensorDirection = $_REQUEST['direction'];
if($sensorDirection == NULL){
  $sensorDirection = readFromFile($file);
  if (!isset($_SESSION['direction'])) {
    $_SESSION['direction'] = "right";
  }
} else {
  if ( ereg( "^([1-zA-Z0-1@.\s-]{1,255})$", $sensorDirection) ) {
    writeToFile($file,$sensorDirection);
    $_SESSION['direction'] = $sensorDirection; 
  } else {
    die("Unsafe input :'(");
  }
}

//$data = "45";
//writeToFile($file, $data);
//echo readFromFile($file) . "<br/>";

//returns all data from inputFile
function readFromFile($inputFile) {
  $fp = fopen($inputFile, 'r');
    $fileData = fread($fp, filesize($inputFile));
  fclose($fp);
  return $fileData;
}

//creates/clears inputFile and inserts inputData
function writeToFile($inputFile,$inputData) {
  $fp = fopen($inputFile, 'w');
  fwrite($fp,$inputData);
  fclose($fp);
}
?>

<html>
 <head>
  <title>
   Project Movaroomba Web Application
  </title>
  <style type="text/css" title="currentStyle" media="screen">
   @import "style.css";
  </style>
  <script type="text/javascript">
   function validateForm(inputForm) {
    with(inputForm) {
     if (validateTemperature(temperature) == false) {
      inputForm.temperature.focus();
      return false;
     } else {
      return true;
     }
    }
   }
   function validateTemperature(field) {
    with (field) {
     if ( (value.indexOf("@") != -1) || (value.indexOf(";") != -1) || (value.indexOf(" ") != -1) || (value.indexOf("'")) ) {
      return false;
     } else {
      return true;
     }
    }
   }
  </script>
 </head>

 <body>
<?php
print "Current time: " . strftime('%c');
?>
  <br/>
  <br/>
  <div class="formContent">
   Roomba, move <?php print $sensorDirection ?>!<br/>
   <br/>
   <form action="<?php echo $PHP_SELF; ?>" method="post" onsubmit="return validateForm(this)">
    Direction:
    <input type="text" size="5" name="direction" value="<?php print $sensorDirection?>"/>
    <input type="submit" value="Submit" />
   </form>
   <a href="index.php">home</a> <a href="<?php echo $PHP_SELF; ?>">refresh</a>
  </div>
 </body>
</html>
