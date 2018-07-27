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
		}
	};
})();
