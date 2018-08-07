"use strict";
var router = (()=> {
	return {move: x=> {
		location.href = x.context +"/"+ x.domain + ".do?action=" + x.action
		+ "&page=" + x.page;
		},
		moveHome: x=> {
		location.href = x.context+"/";
		}
	};
})();
var admin = (()=>{
	return{
		check : x=>{
			var isAdmin = confirm('관리자입니까');
			router.move({
				context:x,
				domain:'admin',
				action:'list',
				page:'main'
			});
/*			if(isAdmin){
				var password = prompt('관리자 비번을 입력 바랍니다.');
				if(password == 1){
					router.move({
						context:x,
						domain:'admin',
						action:'list',
						page:'main'
					});
				}else{
					alert('비밀번호가 틀렸습니다.');
				}
			}else{
				alert('관리자만 접근이 허용됩니다');
			}*/
		},
		main : x=>{
			service.addClass(document.getElementById('search_box'),'width80pt center ');
			service.addClass(document.getElementById('search_word'),'width100px floatRight ');
			service.addClass(document.getElementById('search_option'),'floatRight ');
			service.addClass(document.getElementById('search_btn_style'),'cursor floatRight ');
			service.addClass(document.getElementById('content_box_table'),'width80pt center marginTop30px textCenter borderCollapse ');
			service.addClass(document.getElementById('content_box_meta'),'bgColorYellow ' );
			service.addClass(document.getElementById('content'),'marginBottom150px ' );
			for(var i of document.querySelectorAll('.username')){
				service.addClass(
					i,'cursor fontColorBlue '
				);
				i.addEventListener('click',function(){
				location.href = x+'/admin.do?action=retrieve&page=memberDetail&userid='+this.getAttribute('id');
				});
			};
			document.getElementById("search_btn").addEventListener('click',function(){
			     location.href = (document.getElementById('search_option').value==='id') ?
		        x+'/admin.do?action=retrieve&page=memberDetail&userid='+document.getElementById('search_word').value
		        :
		        x+'/admin.do?action=search&page=main&search_option='+document.getElementById('search_option').value+'&search_word='+document.getElementById('search_word').value;
			});
			for(var i of document.querySelectorAll('.pageNumber')){
				service.addClass(
						i,'cursor fontColorBlue '
					);
				i.addEventListener('click',function(){
				location.href=x+'/admin.do?action=list&page=main&pageNumber='+this.getAttribute('id');
				});
			};
			if(document.getElementById("nextBtn")!== null){
				service.addClass(document.getElementById('nextBtn'),'cursor fontColorBlue ' );
				document.getElementById("nextBtn").addEventListener('click',function(){
				location.href=x+'/admin.do?action=list&page=main&pageNumber='+document.getElementById('nextBtn').getAttribute('name');
			});
			}
			if(document.getElementById("prevBtn")!== null){
				service.addClass(document.getElementById('prevBtn'),'cursor fontColorBlue ' );
				document.getElementById("prevBtn").addEventListener('click',function(){
				location.href=x+'/admin.do?action=list&page=main&pageNumber='+document.getElementById('prevBtn').getAttribute('name');
			});
			}
		}
	};})();
var service = (()=>{
	return{
		nullChecker : x=>{
			var i = 0;
			var j = {
					checker : true,
					text : '필수 입력값이 없습니다.'
			};
			for (i in x){
				if(x[i]===''){
					j.checker = false;
				}
			}
			return j;
		},
		addClass : (dom,cName)=>{
			var arr = cName.split(" ");
				if(arr.indexOf(cName)==-1){
					dom.className += " " +cName;
				}
		}
	};
})();
// anonymous function
var member =(()=>{
	var _userid,_ssn,_password,_name,_age,_roll,_teamid,_gender,_subject;
	var setUserid = (userid)=>{this._userid = userid;}
	var setSsn = (ssn)=> {this._ssn = ssn;}
	var setPassword = (password)=> {this._password = password;}
	var setName = (name)=> {this._name =name;}
	var setAge = (x)=>{
		this._age= Number(new Date().getFullYear())-(Number(x.substring(0,2))+1900-1);
		}
	var setRoll = (roll)=>{this._roll=roll;}
	var setTeamid = (teamid)=>{this._teamid=teamid;}
	var setGender = (x)=>{
		switch (x.substring(7,8)) {
		case "1": case "3":
			this._gender= "남";
			break;
		case "2": case "4":
			this._gender= "여";
			break;
		case "5": case "6":
			this._gender= "외국인";
			break;
		default:
			alert("주민등록번호를 잘못입력하셨습니다.")
			break;
		};}
	var setSubject = (subject)=> {this._subject=subject;}	
	var getUserid = ()=> {return this._userid;}
	var getSsn = ()=> {return this._ssn;}
	var getPassword = ()=> {return this._password;}
	var getName = ()=> {return this._name;}
	var getAge = ()=>{return this._age;}
	var getRoll = ()=>{return this._roll;}
	var getTeamid = ()=>{return this._teamid;}
	var getGender = ()=>{return this._gender;}
	var getSubject = ()=> {return this._subject;}	
	return{
		setUserid : setUserid,
		setSsn : setSsn,
		setPassword : setPassword,
		setName : setName,
		setAge : setAge,
		setRoll : setRoll,
		setTeamid : setTeamid,
		setGender : setGender,
		getUserid : getUserid,
		getSsn : getSsn,
		getPassword : getPassword,
		getName : getName,
		getAge : getAge,
		getRoll : getRoll,
		getTeamid : getTeamid,
		getGender : getGender,
		join : x =>{
			member.setAge(x);
			member.setGender(x);
		},
		login : x=>{
			service.addClass(document.getElementById('content-box'),'textCenter ');
			service.addClass(document.getElementById('login_form'),'textCenter ');
			for(var i of document.querySelectorAll('input')){
				service.addClass(i,'width300px height50px textCenter ');
			}
			service.addClass(document.getElementById('login_form_btn_style'),'btnStyle padding13px115px ');
			document.getElementById('login_form_btn').addEventListener('click',function(){
				var z = service.nullChecker([document.login_form.userid.value,document.login_form.password.value]);
				if(z.checker){
					var form = document.getElementById('login_form');
					form.action = x+"/member.do";
					form.method = "post";
					var node = document.createElement('input');
					node.setAttribute("type","hidden");
					node.setAttribute("name","action");
					node.setAttribute("value","login");
					form.appendChild(node);
					form.submit();
				} else {
					alert(z.text);
				}
			})
		},
		update : x=>{
			service.addClass(document.getElementById('content-box'),'textCenter ');
			service.addClass(document.getElementById('update_member_btn_style'),'btnStyle padding13px115px ');
			var form = document.getElementById('update_member');
			var roll = document.getElementById('roll');
			for(var i=0;i<roll.options.length;i++){
				if(roll.options[i].value==='${user.roll}'){
					roll.options[i].setAttribute("selected","selected");
				}
			};
			var team = document.getElementsByName('teamid');
			for(var i=0;i<team.length;i++){
				if(team[i].value==='${user.teamId}'){
						team[i].checked=true;
				}
			};
			document.getElementById('update_member_btn').addEventListener('click',function(){
			var z = service.nullChecker([document.update_member.password.value,document.update_member.teamid.value,document.update_member.roll.value]);
				if(z.checker){
					form.action=x+"/member.do";
					form.method="post";
					var node = document.createElement('input');
					node.setAttribute("type","hidden");
					node.setAttribute("name","action");
					node.setAttribute("value","update");
					form.appendChild(node);
					alert("변경 완료");
					form.submit();
				} else {
					alert(z.text);
				}
			});
		}
	};
})();
