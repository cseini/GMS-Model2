<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<head>
	<meta charset="UTF-8" />
	<title>MAIN</title>
	<link rel="stylesheet" href="${css}/style.css" />
	<script>
	var common = new (function Common(){
		this.move = function (domain, action, page) {
			alert('common에서 move 테스트 성공!! ${context}');
			location.href = "${context}/"+domain+".do?action="+action+"&page="+page;
		}
		this.moveHome = function () {
			alert('common에서 moveHome 테스트 성공!! ${context}');
			location.href = "${context}/";
		}
	});

	// anonymous function
	var member = new (function Member() {
		var userId, ssn, password, name;
		this.setUserid = function(x){
			this.userId = x;
		}
		this.setSsn = function(x){
			this.ssn = x;
		}
		this.setPassword = function(x){
			this.password = x;
		}
		this.setName = function(x){
			this.name = x;
		}
		this.getUserid = function(){
			return this.userId;
		}
		this.getSsn = function(){
			return this.ssn;
		}
		this.getPassword = function(){
			return this.password;
		}
		this.getName = function(x){
			return this.name;
		}
		
		this.loginValidation = function () {
			if(this.userId==""){
				alert("아이디를 입력하세요.");
				document.getElementById('login_form').userid.focus();
				return false;
			} else if(this.password=="") {
				alert("비밀번호를 입력하세요.");
				document.getElementById('login_form').password.focus();
				return false;
			} else {
				return true;
			}
		}
		this.joinValidation = function(){
			if(this.getUserid()==""){
				
			}
		}
	});
	</script>
</head>