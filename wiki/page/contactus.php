<?php
 require_once('PHPMailer/class.phpmailer.php');
 
 define('GUSER', 'sinosofttpg.com'); // GMail username
 define('GPWD', '1q2w#E$R'); // GMail password

 function smtpmailer($to, $from, $from_name, $subject, $body) { 
	global $error;
	$mail = new PHPMailer();  // create a new object
	$mail->IsSMTP(); // enable SMTP
	$mail->SMTPDebug = 0;  // debugging: 1 = errors and messages, 2 = messages only
	$mail->SMTPAuth = true;  // authentication enabled
	//$mail->SMTPSecure = 'ssl'; // secure transfer enabled REQUIRED for GMail
	$mail->Host = 'mail.59iwine.com';
	$mail->Port = 26; 
	$mail->Username = GUSER;  
	$mail->Password = GPWD;           
	$mail->SetFrom($from, $from_name);
	$mail->Subject = $subject;
	$mail->Body = $body;
	$mail->AddAddress($to);
	if(!$mail->Send()) {
		$error = 'Mail error: '.$mail->ErrorInfo; 
		echo($error);
		return false;
	} else {
		$error = 'Message sent!';
		echo($error);
		return true;
	}
}

smtpmailer('yanglei2010@gmail.com', 'notification+59iwine.com', 'notification+59iwine.com', 'test mail message', 'Hello World!');

 ?>