console.log("실습2 open");

const alarm = new WebSocket("/alarm");

alarm.onopen = (event) =>{
    alert("익명의 유저가 접속 했습니다.")
}//func end

alarm.onclose = (event) =>{
    alert("익명의 유저가 퇴장 했습니다.")
}//func end