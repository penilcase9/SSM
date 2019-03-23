
var loggerAble = true;

function OALog(logInfo) {
    if(loggerAble = true){
        console.log("<<<<<<<<<" + logInfo + ">>>>>>>>>>>");
    }else {

    }
}

(function logoIfAble() {
   if(loggerAble){
       console.log("<<<<< logAble >>>>>>>>");
   }else {
       console.log("<<<<< logDisAble >>>>>>>>");

   }
})()