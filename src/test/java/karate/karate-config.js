function fn(){
    var apphost = java.lang.System.getenv('APPHOST');
    karate.log('APPHOST BEFORE DEAFAULT: ' + apphost);
    if(apphost === undefined || apphost == null || apphost.length <= 0){
        apphost = "localhost"
    }

    karate.log('APPHOST: ' + apphost);

    var config = {
        apphost: apphost
    }
    return config;
}