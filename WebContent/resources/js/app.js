function Common() {
	this.move = function(t, domain, action, page) {
		alert('common에서 move 테스트 성공!! + t');
		location.href = t +"/"+ domain + ".do?action=" + action
				+ "&page=" + page;
	}
	this.moveHome = function() {
		alert('common에서 moveHome 테스트 성공!! ${context}');
		location.href = t+"/";
	}
};

// anonymous function
function Member() {
	var userId, ssn, password, name;
	this.setUserid = function(x) {
		this.userId = x;
	}
	this.setSsn = function(x) {
		this.ssn = x;
	}
	this.setPassword = function(x) {
		this.password = x;
	}
	this.setName = function(x) {
		this.name = x;
	}
	this.getUserid = function() {
		return this.userId;
	}
	this.getSsn = function() {
		return this.ssn;
	}
	this.getPassword = function() {
		return this.password;
	}
	this.getName = function(x) {
		return this.name;
	}

	this.loginValidation = function() {
		if (this.userId === "") {
			alert("아이디를 입력하세요.");
			document.getElementById('login_form').userid.focus();
			return false;
		} else if (this.password === "") {
			alert("비밀번호를 입력하세요.");
			document.getElementById('login_form').password.focus();
			return false;
		} else {
			return true;
		}
	}
	this.joinValidation = function() {
		if (this.userId === "") {
			alert("아이디를 입력하세요.");
			document.getElementById('join_form').userid.focus();
		} else if (this.password == "") {
			alert("비밀번호를 입력하세요.");
			document.getElementById('join_form').password.focus();
			return false;
		} else if (this.name == "") {
			alert("이름 입력하세요.");
			document.getElementById('join_form').name.focus();
			return false;
		} else if (this.ssn == "") {
			alert("주민등록번호를 입력하세요.");
			document.getElementById('join_form').ssn.focus();
			return false;
		} else {
			return true;
		}
	}
	this.deleteValidation = function() {
		if (this.userId === "") {
			alert("아이디를 입력하세요.");
			document.getElementById('delete_form').userid.focus();
			return false;
		} else if (this.password === "") {
			alert("비밀번호를 입력하세요.");
			document.getElementById('delete_form').password.focus();
			return false;
		} else {
			return true;
		}
	}
};