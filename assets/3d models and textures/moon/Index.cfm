<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
	<html><head>
	<title>TurboSquid -- New Member Login</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />	
	
	
	
	
	<meta name="copyright" content="Turbo Squid, Inc." />
	<meta name="msvalidate.01" content="0ED5BA3ECC42A988A6A8D2509551C54D" />
	
	<link rel="publisher" href="google.com/+turbosquid">
	
		<link href="https://www.turbosquid.com/CSS/v75/Global.css" rel="stylesheet" type="text/css" title="styles">
		<link href="https://www.turbosquid.com/CSS/v75/jquery-ui/jquery-ui.css" rel="stylesheet" type="text/css" title="styles">
	
	<script type="text/javascript">
	var _gaq = _gaq || [];
	_gaq.push(['_setAccount', 'UA-227915-1']);
	_gaq.push(['_setDomainName', '.turbosquid.com']);
	_gaq.push(['_trackPageview']);
	(function() {
		var ga = document.createElement('script'); ga.type = 'text/javascript'; ga.async = true;
		ga.src = ('https:' == document.location.protocol ? 'https://ssl' : 'http://www') + '.google-analytics.com/ga.js';
		var s = document.getElementsByTagName('script')[0]; s.parentNode.insertBefore(ga, s);
	})();
	</script>
	</head>
	<body id="Login" >
	
		<div id="page-container" style="width:996px">
		<script src="https://www.turbosquid.com/JavaScript/v103/jquery/TS-jquery.min.js" type="text/javascript"></script>
		<script src="https://www.turbosquid.com/JavaScript/v103/jquery/jquery-ui.min.js" type="text/javascript"></script>
        <script src="https://www.turbosquid.com/JavaScript/v103/global.js" type="text/javascript"></script>
		
		
		<script type="text/javascript">$j(['https://www.turbosquid.com/CSS/v75/Display/PulldownBG.gif','https://www.turbosquid.com/CSS/v75/Display/NavSelectedPulldown.png']).preload();</script>
		<!-- Masthead-START -->
		<div id="NavBar" class="mast" style="width:973px">
		
			
			<a href="http://www.turbosquid.com/" id="TSLogo"> </a>
			<form action="https://www.turbosquid.com/Search/Index.cfm" name="SearchNav" method="get">
			<div class="HeaderInput"><input type="text" name="keyword" id="NavTextField" value="" placeholder="Search Stock 3D" /></div>
			<div style="float:left;"><input type="image" src="https://www.turbosquid.com/Images/v46/Global/clear_dot.gif" id="NavButton" /></div>
			<div style="float:left;margin:28px 0 0 5px;display:none;"><input type="checkbox" id="SearchAndRank" title="display keyword" /></div>
				<div class="NavItemSelectRight"></div><div class="NavItemSelect NavItem" id="nav-LoginDiv"><div class="NavItemText"><a href="https://www.turbosquid.com/Login/Index.cfm" id="nav-Login">Login/</a><a href="https://www.turbosquid.com/Login/Index.cfm" id="nav-LoginJoin">Join</a></div></div>
				<div class="NavItem" id="nav-SupportDiv"><div class="NavItemText"><a href="http://support.turbosquid.com/Home?locale=1" id="nav-Support">Support</a></div></div>
				<div class="NavItem" id="nav-AssetManagerDiv"><div class="NavItemText"><a href="http://www.turbosquid.com/AssetManager/Index.cfm" id="nav-AssetManager">My Files</a></div></div>
				<div class="NavItem" id="nav-CartDiv"><div class="NavItemText"><a href="https://www.turbosquid.com/ShoppingCart/Index.cfm" id="nav-Cart">Cart</a></div></div>
				
				
			</form>
		
			
		</div>
		<div class="mast mastright"><!-- --></div>
		<div class="clear"><!-- --></div>
	<script type="text/javascript" language="JavaScript">
	$j('#nav-SupportDiv').click(function() {
	  window.location = 'http://support.turbosquid.com/Home?locale=1';
	});
	$j('#nav-AssetManagerDiv').click(function() {
	  window.location = 'http://www.turbosquid.com/AssetManager/Index.cfm';
	});
	$j('#nav-CartDiv').click(function() {
	  window.location = 'https://www.turbosquid.com/ShoppingCart/Index.cfm';
	});
	
	$j('#nav-LoginJoin').click(function() {
		DisplayLogin(true);
		return false;
	});
	$j('#nav-LoginDiv').click(function() {
		DisplayLogin(false);
		return false;
	});
	$j('#NavOr').click(function() {return false;});
	
	var blLogin = false;
	function DisplayLogin(blSignup, strRedirect, intType) {
		
	}
	function PageRedirect(strRedirect) {
		if (strRedirect.length) {
			$j('#loginReturnUrl').val(strRedirect);
			$j('#createReturnUrl').val(strRedirect);
		}
	}
	function LoginPopup() {
		placePopup();
		$j('#pop_Login').show();
		$j('#backgroundPopup').fadeTo(0, 0.3);
		$j('#pop_Signup').hide();
		$j('#pop_ForgotPassword').hide();
	}
	function SignupPopup() {
		placePopup();
		$j('#pop_Signup').show();
		$j('#backgroundPopup').fadeTo(0, 0.3);
		$j('#pop_Login').hide();
		$j('#pop_ForgotPassword').hide();
	}
	function placePopup() {
		$j("#pop_ForgotPassword").css("left", document.documentElement.clientWidth/2 - 256);
		$j("#pop_Login").css("left", document.documentElement.clientWidth/2 - 256);
		$j("#pop_Signup").css("left", document.documentElement.clientWidth/2 - 256);
		
		var isIE  = !!window.ActiveXObject;
		var isIE6 = isIE && !window.XMLHttpRequest;	
		if(isIE6 == true){
			$j("#pop_ForgotPassword").css("top", document.documentElement.scrollTop + 160);
			$j("#pop_Login").css("top", document.documentElement.scrollTop + 160);
			$j("#pop_Signup").css("top", document.documentElement.scrollTop + 160);
		}
	}
	var coreapi = "http://www.turbosquid.com/CoreAPI/index.cfm";
	
		coreapi = "https://www.turbosquid.com/CoreAPI/index.cfm";
	

	
		
	</script>
	<!-- Masthead-END -->
	
		<table cellpadding="0" cellspacing="0" >
		<tr><td class="SiteLeft"></td><td class="SiteBox" style="width:980px">
		
		<div id="page-content-inner">	
        
	    <div id = 'siteFlashes'></div>
		
<style>
#page-content-inner{min-height:520px;}
.textinput {width:248px; color:#000;padding-left:8px;border:1px solid;border-top-color:#727272;border-bottom-color:#dadada;
		border-left-color:#b3b3b3;border-right-color:#b3b3b3;font-size:14px; padding: 6px 4px; line-height: 18px;}
.formLabel {padding-bottom:5px;font-weight:bold;font-size: 14px;}
.btnPopLogin {
	color: #3e3e3e; 
	font-size:16px; 
	font-weight: bold;
	text-align: center; 
	border: none;
	/*border-radius: 5px;*/
	margin: 0 0 0 0; 
	padding: 0 0 1px 0; 
	height: 28px;
	width: 100px;
	background: transparent url(https://www.turbosquid.com/CSS/v75/Display/login_button_green.png) no-repeat center;
	}
.forgotPassword{color:#006b9c;font-size:11px;font-weight:bold;margin:12px 0 15px 0;cursor:pointer;}
.smallLink {font-size:11px;font-weight:bold;margin:12px 0 15px 0; line-height:13px;}
.smallLink a {color:#006b9c;}
.AdditionalTitle {font-size:16px; font-weight:bold; margin-bottom:5px;}
.AdditionalLink {font-size:22px;color:#006b9c;font-weight:bold;cursor:pointer;}
.divInput{height:33px;}
.paddingLabel{
	padding-top:10px;
}
#PageBody {color:#919191;}
#LoginForm,#SignupForm { float:left; }
#AdditionalOptions { float:left; width:210px; margin:40px 0 0 36px; text-align:center; }
.AdditionalPopup { float:right; width:210px; text-align:center; padding-top:38px; }
.ErrorMessage {
	background-color:#fcf4ce; color:#cc6666; border-bottom:#cacacb 1px solid; border-top:#f7f7f7 1px solid; padding:6px 8px;
}
.Error {color:#e37272;font-size:11px;padding-top:3px;overflow:hidden;width:257px;text-align:right;}
.Chat { margin:80px 30px 0 30px;color:#006b9c;font-size:11px;font-weight:bold;}
.Chat hr { margin-bottom:18px; }
.Chat div {background-image:url('https://www.turbosquid.com/Images/v46/NewMemberLogin/pop_LoginChat.gif');background-repeat:no-repeat; width:90px; margin:0 35px;}
#PageBody { margin:16px 0 0 233px; }
h2 { font-size:24px; color:#000; padding-bottom:14px; }
.hidden {display:none;}
.SubscribeText {font-size:12px;color:#000; font-weight:bold; padding:6px 0;width: 275px;}
.btnPopCreate, .btnPopRetrieve {
	color: #3e3e3e; 
	font-size:16px; 
	font-weight: bold;
	text-align: center; 
	border: none;
	/*border-radius: 5px;*/
	margin: 0 0 0 0; 
	padding: 0 0 1px 0; 
	height: 28px;
	width: 200px;
	background: transparent url(https://www.turbosquid.com/CSS/v75/Display/login_button_green_large.png) no-repeat center;
	}
.errorInput{
  	background-image: url('https://www.turbosquid.com/Images/v46/NewMemberLogin/pop_LoginError_red.png');
  	background-position: 234px 8px;
	background-repeat: no-repeat; 
}
.errorLabel{color:#ed4b3c;}
.twiddleInput{
  	background-image: url('https://www.turbosquid.com/Images/v46/NewMemberLogin/pop_Twiddle.gif');
  	background-position: 234px 8px;
	background-repeat: no-repeat; 
}

.privateNote{background-image: url('https://www.turbosquid.com/Images/v46/NewMemberLogin/pop_PrivateNote.gif');
  	background-position: 0 0;
	background-repeat: no-repeat; 
	width:262px;
	height:76px;
	position:absolute;
	font-size:11px;
	padding:8px 10px 0 28px;
	line-height: 14px;
	color:#7F7F7F;
	top:-27px;
	left:170px;
	-webkit-text-size-adjust:none;
}


#EmailNote{background-image: url('https://www.turbosquid.com/Images/v46/NewMemberLogin/pop_LoginNote.gif');background-repeat: no-repeat; width:16px;height:16px; cursor: pointer; display:inline-block; margin:2px 86px 0 0;}

.popup{
	position:fixed;
	_position:absolute;	
	display:none;
	text-align:left;
	z-index:999;
	line-height:normal;
	border:none;
	background-color: transparent;
	color:#919191;
	top:160px;
	font-family:"Trebuchet MS", helvetica,sans-serif;
}

.popup .popheader{
  	background-image: url('https://www.turbosquid.com/Images/v46/NewMemberLogin/pop_LoginHeader.gif');
	background-repeat: no-repeat; 
	width:512px;
	height:60px;
}
.popup .popfooter{
  	background-image: url('https://www.turbosquid.com/Images/v46/NewMemberLogin/pop_LoginBottom.gif');
	background-repeat: no-repeat; 
	width:512px;
	height:6px;
}
.popup .popbody{
  	background-image: url('https://www.turbosquid.com/Images/v46/NewMemberLogin/pop_LoginBody.png');
	background-repeat: repeat-y;
	padding:0 24px;
	width:488px;
}
.popup .poptitle, .popmessagetitle{
	float:left;
	font-size: 25px;
    font-weight: bold;
    padding-left: 22px;
    padding-right: 0;
    padding-top: 18px;
	font-size:24px; color:#000;
}
.popup .popmessagetitle{
	font-size: 16px;
	color: #919191;	
}
.popup .popclose{
	float:right;
	width:28px; 
	height:28px;
	cursor: pointer;
    margin: 13px 13px 0 0;
}
.popup .popmessage{
	background-image: url('https://www.turbosquid.com/Images/v46/NewMemberLogin/pop_LoginMessage.gif');
	background-repeat: no-repeat; 
	width:512px;
	height:60px;
}
.popup .popheaderwithmessage{
	background-image: url('https://www.turbosquid.com/Images/v46/NewMemberLogin/pop_LoginHeaderMessage.gif');
	background-repeat: no-repeat; 
	width:512px;
	height:60px;
}

#backgroundPopup{
	background-color: #000000;
	display:none;	
	position:fixed;
	height:100%;
	width:100%;
	top:0;
	left:0;
	opacity:.6;
	z-index:998;	
}
form {margin:0;padding:0;}
p.informTip{ color:#006B9C;}
.LoginResult{
	background: #FCF4CE url("https://www.turbosquid.com/Images/v46/NewMemberLogin/pop_LoginError_red.png") no-repeat left;
	background-position:6px 6px;
	color: #C66;
	border-bottom: #CACACB 1px solid;
	border-top: #F7F7F7 1px solid;
	padding-left:26px;
	height:27px;
	line-height:29px;
}
.memberNameDiv{	
	background-color: #FBF8E6;
    margin-left: -10px;
    padding: 10px;
	width: 258px;
}
.memberNameDiv #lbJoinName{
	background-image: url("https://www.turbosquid.com/Images/v46/NewMemberLogin/pop_LoginError_orange.png");
    background-position: left 2px;
    background-repeat: no-repeat;
    text-indent: 20px;
}
.memberNameDiv .tipInfo{
	color: #919191;
	font-size: 12px;
    padding-bottom: 5px;
    text-align: left;
}
.memberNameDiv_nonBackground{
	background-color: transparent;
	margin-left: 0;
    padding: 0;
}
.memberNameDiv_nonBackground #lbJoinName{
	background-image: none;
    text-indent: 0;
}
.memberNameDiv_nonBackground .tipInfo{
	display: none;
}
.memberNameDiv_error{
	background-color: #F8E9E8;
	margin-left: -10px;
    padding: 10px;
}
.memberNameDiv_error #lbJoinName{
	background-image: url("https://www.turbosquid.com/Images/v46/NewMemberLogin/pop_LoginError_red.png");
	text-indent: 20px;
}
.memberNameDiv_error .errorInput{
	background-image: none;
}
.memberNameDiv_error .tipInfo{
	display: block;
}
</style>

<div id="pop_ForgotPassword" class="popup">
	<div class="popheader">
		<div class="poptitle">Forgot Login Info</div>
		<div class="popclose" id="closeRetrieve"></div>
		<div class="clear"></div>
	</div>
	<div class="popbody">
		
		<div class="AdditionalPopup" style="padding-top:26px;">
			<div class="AdditionalLink" id="btnBackToLogin">Back to Login</div>
		</div>
		
	
		<form action="https://www.turbosquid.com/Login/Index.cfm" id="formForgotName" method="post" name="ForgotNameForm">
		<div class="formLabel" id="lbForgotName">Member Name or Email Address</div>
		<div class="divInput"><input type="text" id="txtForgotName" name="ForgotName" class="textinput"></div>
		<div class="Error" id="errForgotName">&nbsp;</div>
		<div style="padding-top:12px;"></div>
		
		<input type="submit" value="Retrieve Login Info" class="btnPopRetrieve" id="btnPopRetrieve" />
			
		<div style="padding-top:12px;"></div>
		<input type="hidden" name="Action" value="Forgot" />
		<input type="hidden" name="Clnt" value="1" />
		</form>
		<div class="clear"></div>
	</div>
	<div class="popfooter"></div>
</div>


<div id="backgroundPopup"></div>  







	




<div id="PageBody">	
	
	<h2 id="LoginHeader">TurboSquid Login</h2>	
	<h2 id="SignupHeader" class="hidden">Join TurboSquid!</h2>	
	<div id="LoginForm">	
		<form action="https://www.turbosquid.com/Login/Index.cfm" id="formLogin" method="post" name="Join">
		<div class="formLabel" id="lbName">Member Name</div>
		<div class="divInput"><input type="text" id="txtName" name="LoginUsername" class="textinput" value=""></div>
		<div class="Error" id="errName">&nbsp;</div>
		<div class="formLabel" id="lbPassword">Password</div>
		<div class="divInput"><input type="password" id="txtPassword" class="textinput" name="LoginPassword"></div>
		<div class="Error" id="errPassword">&nbsp;</div>
		<div class="formLabel"><input id="LoginRemember" type="checkbox" name="LoginRemember" value="1" /> <label for="LoginRemember">Keep Me Logged In</label></div>
		
		<div style="padding-top:12px;"></div>
		<input type="submit" id="btnPopLogin" class="btnPopLogin" value="Login" />
	
		<div class="forgotPassword" id="btnInlineForgot">Forgot Password or Member Name?</div>
				
		<input type="hidden" name="Action" value="Login">
		<input type="hidden" name="stgRU" id="loginReturnUrl" value="http://storage2.turbosquid.com/Download/index.php?ID=553741_4039883">
		<input type="hidden" name="Clnt" value="1">
		
		</form>
	
	</div>
	
	<div id="SignupForm" class="hidden">
	
		<form action="https://www.turbosquid.com/Login/Index.cfm" id="formJoin" method="post" name="Login">
		<div style="position:relative;">
		<div id="divPrivateNote" class="privateNote hidden">Maintaining strict privacy is a high priority at TurboSquid. We do not share any personal information obtained online without permission from the submitting user, and we never will.</div>
		</div>
		<div class="formLabel" id="lbJoinEmail">Email Address (private) <div id="EmailNote"></div></div>
		<div class="divInput"><input type="text" id="txtJoinEmail" class="textinput" name="Email"></div>
		<div class="Error" id="errJoinEmail">&nbsp;</div>
		<div class="memberNameDiv memberNameDiv_nonBackground">
			<div class="formLabel" id="lbJoinName">Member Name</div>
			<div class="tipInfo">Please enter English characters only.</div>
			<div class="divInput"><input type="text" name="UserName" class="textinput" id="txtJoinName"></div>				
		</div>	
		<div class="Error" id="errJoinName">&nbsp;</div>
		<div class="formLabel" id="lbJoinPassword">Password</div>
		<div class="divInput"><input type="password" id="txtJoinPassword" class="textinput" name="Password1"></div>
		<div class="Error" id="errJoinPassword">&nbsp;</div>
		<div class="formLabel" id="lbJoinPassword2">Retype Password</div>
		<div class="divInput"><input type="password" id="txtJoinPassword2" class="textinput" name="Password2"></div>
		<div class="Error" id="errJoinPassword2">&nbsp;</div>
		<div class="SubscribeText"><input type="checkbox" id="cbSubscribe" name="subscribeToNewsLetter" checked="checked"><label for="cbSubscribe"> Subscribe to the TurboSquid newsletter</label></div>
		<div style="padding-top:12px;"></div>
			
			<input type="submit" id="btnPopCreate" class="btnPopCreate" value="Create Account" />
				
		<div class="smallLink">By creating an account you agree to the<br/>
			<a href="http://www.turbosquid.com/EULA" target="_blank">End User License Agreement</a> & <a href="http://support.turbosquid.com/entries/173395-our-privacy-policy?locale=1" target="_blank">Privacy Policy</a></div>
				
		<input type="hidden" name="Action" value="Signup">
		<input type="hidden" name="stgRU" id="createReturnUrl" value="http://storage2.turbosquid.com/Download/index.php?ID=553741_4039883">
		<input type="hidden" name="Clnt" value="1">
		</form>
	
	</div>
	
	
	<div id="AdditionalOptions">
		<div id="LoginAddition">
			<div class="AdditionalTitle">Need an account?</div>
			<div class="AdditionalLink" id="btnInlineJoin">Join TurboSquid!</div>
		</div>
		<div id="SignupAddition" class="hidden">
			<div class="AdditionalTitle">Have an account?</div>
			<div class="AdditionalLink" id="btnInlineLogin">Login now!</div>
		</div>
		
		<div class="Chat">
			<hr />
			<div><a href="#" onClick="window.open('http://a4.websitealive.com/155/rRouter.asp?groupid=155&websiteid=0&departmentid=6184&infocapture_ids=499,500,501&infocapture_values=||&dl='+escape(document.location.href),'','width=400,height=400'); return false;">Live Chat</a></div>
		</div>
	</div>
	
	<div class="clear"><!-- --></div>
</div>



<script language="javascript">
$j("body").click(function(e){
	var target = e.target ? e.target : e.srcElement;
	if( $j(target).attr("id")!='EmailNote' ) 
		$j("#divPrivateNote").hide();
});
function LoginPopup() {
	placePopup();
	$j('#pop_Login').show();
	$j('#backgroundPopup').fadeTo(0, 0.3);
	$j('#pop_Signup').hide();
	$j('#pop_ForgotPassword').hide();
}
function SignupPopup() {
	placePopup();
	$j('#pop_Signup').show();
	$j('#backgroundPopup').fadeTo(0, 0.3);
	$j('#pop_Login').hide();
	$j('#pop_ForgotPassword').hide();
}
function PageRedirect(strRedirect) {
	if (strRedirect.length) {
		$j('#loginReturnUrl').val(strRedirect);
		$j('#createReturnUrl').val(strRedirect);
	}
}
$j('#btnJoin').click(function() {SignupPopup()});
$j('#btnLogin').click(function() {LoginPopup()});
$j('#btnBackToLogin').click(function() {closePopups()});
$j('#btnInlineForgot').click(function() {
	placePopup();
	$j('#pop_ForgotPassword').show();
	$j('#backgroundPopup').fadeTo(0, 0.3);
	$j('#backgroundPopup').show();
	$j('#pop_Signup').hide();
	$j('#pop_Login').hide();
	$j("#txtForgotName").focus();
});
function closePopups() {
	$j('#ForgotResultMsg').hide();
	$j('#pop_ForgotPassword').hide();
	$j('#pop_Login').hide();
	$j('#pop_Signup').hide();
	$j('#backgroundPopup').hide();
	clearFields();
}
$j('#closeRetrieve').click(function() { closePopups() });
$j('#closeLogin').click(function() { closePopups() });
$j('#closeSignup').click(function() { closePopups() });
function clearFields() {
	setValidateItem('Name',true,'');
	setValidateItem('JoinName',true,'');
	setValidateItem('ForgotName',true,'');
	setValidateItem('Password',true,'');
	setValidateItem('JoinPassword',true,'');
	setValidateItem('JoinPassword2',true,'');
	setValidateItem('JoinEmail',true,'');
	$j('#txtName').val('');
	$j('#txtJoinName').val('');
	$j('#txtForgotName').val('');
	$j('#txtPassword').val('');
	$j('#txtJoinPassword').val('');
	$j('#txtJoinPassword2').val('');
	$j('#txtJoinEmail').val('');
}
$j('#btnInlineJoin').click(function() {

	$j('#SignupHeader').show();
	$j('#SignupAddition').show();
	$j('#SignupForm').show();

	$j('#LoginHeader').hide();
	$j('#LoginAddition').hide();
	$j('#LoginForm').hide();
});
$j('#btnInlineLogin').click(function() {

	$j('#LoginHeader').show();
	$j('#LoginAddition').show();
	$j('#LoginForm').show();

	$j('#SignupHeader').hide();
	$j('#SignupAddition').hide();
	$j('#SignupForm').hide();
});
function placePopup() {
	$j("#pop_ForgotPassword").css("left", document.documentElement.clientWidth/2 - 256);
	$j("#pop_Login").css("left", document.documentElement.clientWidth/2 - 256);
	$j("#pop_Signup").css("left", document.documentElement.clientWidth/2 - 256);
	
	var isIE  = !!window.ActiveXObject;
	var isIE6 = isIE && !window.XMLHttpRequest;	
	if(isIE6 == true){
		$j("#pop_ForgotPassword").css("top", document.documentElement.scrollTop + 160);
		$j("#pop_Login").css("top", document.documentElement.scrollTop + 160);
		$j("#pop_Signup").css("top", document.documentElement.scrollTop + 160);
	}
}
$j('#EmailNote').click(function() {
	$j('#divPrivateNote').show();	
	$j('#backgroundPopup').css("opacity", 0);
	$j('#backgroundPopup').show();
});
$j('#backgroundPopup').click(function() {	
	if($j('#divPrivateNote').css("display") != 'none'){
		$j('#backgroundPopup').hide();		
		$j('#backgroundPopup').css("opacity", 0.6);		
		$j('#divPrivateNote').hide();
	}	
});
function setValidateItem(key,blValid,text){
	if(blValid==true){
		$j('#err'+key).html('&nbsp;');
		$j('#txt'+key).removeClass('errorInput');
		$j('#lb'+key).removeClass('errorLabel');
		if(key=='JoinName'){
			$j('#txt'+key).removeClass('twiddleInput');
		}
	}
	else{
		$j('#err'+key).html(text);
		$j('#txt'+key).addClass('errorInput');
		$j('#lb'+key).addClass('errorLabel');
	}
	if(key == 'JoinName' && $j(".memberNameDiv_nonBackground").length == 0){
		if(blValid==true || $j("#txtJoinName").val() == ""){
			$j(".memberNameDiv").removeClass('memberNameDiv_error');
		}else{
			$j(".memberNameDiv").addClass('memberNameDiv_error');
		}
	}
}
function validateForgotName(){
	if ($j('#txtForgotName').val()==""){
		setValidateItem('ForgotName',false,'Please enter a member name or email address');
		return false;
	}
	setValidateItem('ForgotName',true,'');
	return true;
}
function validateName(name,blJoin){
	var errText = "Member Name";
	var key = 'Name';
	if(blJoin==true){
		key = 'JoinName';
	}
	
	if($j(".memberNameDiv_nonBackground").length > 0){
		$j(".memberNameDiv_nonBackground").removeClass("memberNameDiv_error");
	}
	
	name = name.replace(/(^\s*)|(\s*$)/g,''); //trim space
	var pattern = new RegExp("[^\\w\\s]");
	if (name==""){
		setValidateItem(key,false,'Please enter a member name');	
		return false;
	}
	else if (pattern.exec(name) && blJoin){
		if($j(".memberNameDiv_nonBackground").length > 0){
			$j(".memberNameDiv_nonBackground").addClass("memberNameDiv_error");
		}
		//setValidateItem(key,false,'Please enter English characters only.');
		setValidateItem(key,false,'');
		return false;
	}
	else if (name.length<3){
		setValidateItem(key,false,'Member Name must be at least 3 characters');
		return false;
	}
	else if(name.length>50){
		setValidateItem(key,false,'Member Name must be up to 50 characters');
		return false;
	}
	else if(name.substr(0,1)=='_'){
		setValidateItem(key,false,'The first character of the Member Name cannot be an underscore.');
		return false;
	} else if( existMemberName && blJoin)
		return false;
	setValidateItem(key,true,'');
	return true;	
}
function validatePassword(password,blJoin){
	var key = 'Password';
	if(blJoin==true){
		key = 'JoinPassword';
	}
	if (password==""){
		setValidateItem(key,false,'Please enter your password');
		return false;
	}
	else if(password.length<4){
		setValidateItem(key,false,'Password must be at least 4 characters');
		return false;
	}
	else if(password.length>30){
		setValidateItem(key,false,'Password can be up to 30 characters');
		return false;
	}
	setValidateItem(key,true,'');
	return true;
}
function validatePassword2(){
	var password2 = $j('#txtJoinPassword2').val();
	if (password2==""){
		setValidateItem('JoinPassword2',false,'Please re-enter your password');
		return false;
	}
	else if(password2 != $j('#txtJoinPassword').val()){
		setValidateItem('JoinPassword2',false,'Passwords must match');
		return false;
	}
	setValidateItem('JoinPassword2',true,'');
	return true;
}
function validateEmail(email,blJoin){
	var key = "JoinEmail";
	if(blJoin==false){
		key = "Name";
	}
	if (email==""){
		this.setValidateItem(key,false,'Please enter an email address');
		return false;
	}
	else{
		var patrn = new RegExp("^['_a-z0-9-]+(\\.['_a-z0-9-]+)*@[a-z0-9-]+(\\.[a-z0-9-]+)*\\.(([a-z]{2,3})|(aero|coop|info|museum|name))$");
		if(!patrn.exec(email.toLowerCase())){			
			setValidateItem(key,false,'Please enter a valid email address');
			return false;
		}
	}
	setValidateItem(key,true,'');
	return true;
}

existMemberName = false;
$j('#txtJoinName').blur(function() {
	var name = $j('#txtJoinName').val();
	name = name.replace(/(^\s*)|(\s*$)/g,''); //trim space
	if(!validateName(name,true)){
		//setValidateItem('JoinName',true,'');
		existMemberName = false;
		return; // invalid member name, no need to check availability...?
	}
	var url = 'https://www.turbosquid.com/Search/CoreAPI.cfm';
	$j('#txtJoinName').removeClass('errorInput');
	$j('#txtJoinName').addClass('twiddleInput');
	$j.post(url, { format: "json", afc: "Null",package:"Login",op:"CheckMemberName",MemberName:name}, function (data, textStatus){
		$j('#txtJoinName').removeClass('twiddleInput');
		if(data.LOGIN_CHECKMEMBERNAME_REPLY.ERROR==1){
			setValidateItem('JoinName',false,data.LOGIN_CHECKMEMBERNAME_REPLY.MSGERROR);
			existMemberName = true;
		}else{
			setValidateItem('JoinName',true,'');
			existMemberName = false;
		}
	},"json");
});


$j('#formForgotName').submit(function() {
	if(validateForgotName())
		return true;
	return false;
});
$j('#formLogin').submit(function() {
	blValid = validateName($j('#txtName').val(),false);
	if( validatePassword($j('#txtPassword').val(),false) && blValid )
		return true;
	return false;
});
$j('#formJoin').submit(function() {
	blValid = validateName($j('#txtJoinName').val(),true);
	if( !validatePassword($j('#txtJoinPassword').val(),true) )
		blValid = false;
	if( !validateEmail($j('#txtJoinEmail').val(),true) )
		blValid = false;
	if( validatePassword2() && blValid )
		return true;
	return false;
});


</script>

	</div>	<!-- End page-content-inner -->
		

	<div class="newFootSpacer"></div>
	<div class="newFootColumn">	
		<table border="0" width="100%" style="background:#EAEAEA;">
			<tr>
				<td valign="top" width="32.1%">
					<ul>
						<li><a class="ticket" href="http://support.turbosquid.com/requests/new?locale=1" onClick="return gaqFooterInterval(this, 'Open_Support_Ticket');">Open a Support Ticket now</a></li>
						<li><a class="chat" href="#" onclick="gaqFooterInterval(this, 'Support 24/7');false?window.open('http://www.turbosquid.com//supportchat', '_', 'resizable=no,scrollbars=yes,menubar=no,toolbar=no,location=no,width=336,height=387'):window.open('http://a4.websitealive.com/155/rRouter.asp?groupid=155&websiteid=0&departmentid=6184&infocapture_ids=499,500,501&infocapture_values=current_user.external_id|current_user.email|0&dl='+escape(document.location.href),'','width=400,height=400');">Chat with Support 24/7</a></li>
					
						
						














	
		
	


  






	






	













						
							
							
						<li class="icon_call" id="call"><a class="call" href="javascript:;" onclick="return false;">Call Us +1 (504) 525-0990</a><span></span>
							<div id="callTip" class="callTip"><div class="tipLeft"></div><div class="tipRight"><p class="tipText">Available weekdays 9am to 5pm CST</p></div></div>
						</li>	
						
						<li><a class="search" href="http://support.turbosquid.com/Home?locale=1" onClick="return gaqFooterInterval(this, 'Knowledge_Base');">Search Knowledge Base</a></li>
						<li class="none_border"><a class="faq" href="http://support.turbosquid.com/entries/170982-standard-royalty-free-license-faq?locale=1" onClick="return gaqFooterInterval(this, 'Licensing');">Licensing FAQ</a></li>
					</ul>
				</td>
				<td valign="top" width="35.2%" class="support">
					<ul>
						<li><a href="http://www.turbosquid.com/3d-expert" onClick="return gaqFooterInterval(this, '3D_Expert');">Are you a 3D Expert? Play now</a></li>
						<li><a href="http://www.turbosquid.com/CheckMate" onClick="return gaqFooterInterval(this, 'CheckMate');">CheckMate 3D Model Standard</a></li>
						<li><a href="http://www.turbosquid.com/3d" onClick="return gaqFooterInterval(this, 'Search_3DModels');">Search 3D Models</a></li>
						<li class="none_border"><a href="http://www.turbosquid.com/PublishYourStuff" onClick="return gaqFooterInterval(this, 'Become_Artist');">Become a TurboSquid Artist</a></li>
					</ul>
				</td>
				<td valign="top" class="companyInfo">
					<ul>
						<li class="companyInfo"><a href="http://www.turbosquid.com/AboutTurboSquid" onClick="return gaqFooterInterval(this, 'Company Info');">Company Info</a></li>
						<li class="blogLink"><a href="http://blog.turbosquid.com/" onClick="return gaqFooterInterval(this, 'Blog');">Read our Blog</a></li>
						<li class="share none_border"><img src="https://www.turbosquid.com/CSS/v75/Display/addthis.png" usemap="#sharemap" border="0" /></li>
					</ul>
					<map name="sharemap" id="sharemap">
					  <area shape="rect" coords="0,0,16,16" href="http://www.facebook.com/TurboSquid3DModels" alt="facebook" title="facebook" target="_blank" />
					  <area shape="rect" coords="29,0,44,16" href="http://twitter.com/#!/turbosquid" alt="twitter" title="twitter" target="_blank" />
					  <area shape="rect" coords="57,0,78,16" href="https://plus.google.com/u/0/112247945505399833563/posts" alt="google+" title="google+" target="_blank" />
					  <area shape="rect" coords="93,0,108,16" href="http://vimeo.com/turbosquid" alt="vimeo" title="vimeo" target="_blank" />
					  <area shape="rect" coords="121,0,136,16" href="http://www.youtube.com/user/TurboSquid/featured" alt="youtube" title="youtube" target="_blank" />
					</map>		
				</td>
			</tr>
		</table>
	</div>
	<script language="javascript">	
		$j("#call").hover(
			function(){ $j(".callTip").show();},
			function(){ $j(".callTip").hide();}
		);
		var footerTimeoutID = 0;
		function gaqFooterInterval(evt, gaqText){
			_gaq.push(['_trackEvent', 'Footer', 'Click', gaqText]);
			footerTimeoutID = setTimeout(function(){ location.href = $j(evt).attr("href");}, 250);			
			return false;
		}
	</script>
</div>	
	
<div class="newFooter">
	<a href="http://support.turbosquid.com/entries/170985-end-user-license-agreement-eula?locale=1">End User License Agreement</a>
	<a href="http://support.turbosquid.com/entries/173395-our-privacy-policy?locale=1">Privacy Policy</a>	
	
		 <a class="sitemap" href="http://www.turbosquid.com/Site-Map">Site Map</a>
	
	&copy; 2013 TurboSquid
</div>

	</div>
</td>
<td class="SiteRight"></td></tr></table>
</div>	<!-- End page-container -->
	

	
	    
	    <script type="text/javascript" src="https://www.turbosquid.com/JavaScript/v103/events.js"></script>
	    <script type="text/javascript">
	        TSEvents.setSessionId('16D649A4-6879-4BAC-BC79-9BADDF8D8202');
	    </script>
	
<script type ="text/html" id = "flashes">
	

	

	
</script> 
</body></html>
