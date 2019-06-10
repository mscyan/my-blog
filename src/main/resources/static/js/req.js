function req_get_method(url, will_async, data_format, content_format){
    var xhr = new XMLHttpRequest();
    // var get_method = method.toUpperCase();
    //todo get请求后台获取数据
}
function req_post_method(){
    //todo post请求后台获取数据
}

function upload_file(url, method){
    var fileBtn = document.getElementById("file");

    console.log(fileBtn.files[0]);
    if(fileBtn.files[0] === undefined){
        alert("please select a file");
    }
    else{
        var totalName = fileBtn.files[0].name;
        if(totalName.lastIndexOf('.') === -1){
            alert("this file is not Suitable");
        }
        else{
            var tailName = totalName.substring(totalName.lastIndexOf('.') + 1, totalName.length);
            if(tailName === 'jpg' || tailName === 'png' || tailName === "jpeg" || tailName === "gif"){
                const fd = new FormData();
                fd.append('file', fileBtn.files[0]);
                const xhr = new XMLHttpRequest();
                xhr.open(method, url, true);
                xhr.send(fd);
                xhr.onreadystatechange = function(){
                    if(xhr.readyState === 4 && xhr.status === 200){
                        console.log("res is ", xhr.responseText);
                    }
                }
            }
            else{
                console.log("this file is not suitable");
            }
        }
    }
}

console.log("readY");
