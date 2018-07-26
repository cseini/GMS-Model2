var router = (()=> {
	return {move: x=> {
		location.href = x[0] +"/"+ x[1] + ".do?action=" + x[2]
		+ "&page=" + x[3];
		},
		moveHome: x=> {
		location.href = x+"/";
		}
	};
})();
var service = (()=>{
	return{
		loginValidation : x=>{
			var ok = false;
			if (x.getUserid() === "") {
				alert("아이디를 입력하세요.");
				document.getElementById('login_form').userid.focus();
				return ok;
			} else if (x.getPassword() === "") {
				alert("비밀번호를 입력하세요.");
				document.getElementById('login_form').password.focus();
				return ok;
			} else {
				ok = true;
				return ok;
			}
		},
		joinValidation : x=>{
			var ok = false;
			if (x.getUserid() === "") {
				alert("아이디를 입력하세요.");
				document.getElementById('join_form').userid.focus();
			} else if (x.getPassword() === "") {
				alert("비밀번호를 입력하세요.");
				document.getElementById('join_form').password.focus();
				return ok;
			} else if (x.getName() === "") {
				alert("이름 입력하세요.");
				document.getElementById('join_form').name.focus();
				return ok;
			} else if (x.getSsn() === "") {
				alert("주민등록번호를 입력하세요.");
				document.getElementById('join_form').ssn.focus();
				return ok;
			} else {
				ok = true;
				return ok;
			}
		},
		deleteValidation : x=>{
			var ok = false;
			if (x.getUserid() === "") {
				alert("아이디를 입력하세요.");
				document.getElementById('delete_form').userid.focus();
				return ok;
			} else if (x.getPassword() === "") {
				alert("비밀번호를 입력하세요.");
				document.getElementById('delete_form').password.focus();
				return ok;
			} else {
				ok = true;
				return ok;
			}
		}
	};
})();
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
}

