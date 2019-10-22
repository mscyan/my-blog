function upload_file(url, method){
    var fileBtn = document.getElementById("file");

    // console.log(fileBtn.files[0]);
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
                var fd = new FormData();
                fd.append('file', fileBtn.files[0]);
                var xhr = new XMLHttpRequest();
                xhr.open(method, url, true);
                xhr.send(fd);
                xhr.onreadystatechange = function(){
                    if(xhr.readyState === 4 && xhr.status === 200){
                        var response  = JSON.parse(xhr.responseText);
                        var link = response.response_data;
                        document.getElementById('review').src = '/pic/getpic/' + link;
                        document.getElementById("short_link").innerText = '/pic/getpic/' + link;
                    }
                }
            }
            else{
                console.log("this file is not suitable");
            }
        }
    }
}

function upload_blog(url, method){
    var fileBtn = document.getElementById('blog_html_file');
    if(fileBtn.files[0] === undefined){
        alert('please select a markdown file');
        return;
    }
    else{
        var title = document.getElementById('title').value;
        var abstract = document.getElementById('content-abstract').value;
        var theme_id = document.getElementById('theme_selection').options[document.getElementById('theme_selection').selectedIndex].value;
        console.log(theme_id);
        var fileTotalName = fileBtn.files[0].name;
        if(fileTotalName.lastIndexOf('.') === -1){
            alert("this file is not Suitable");
        }
        else{
            var suffixName = fileTotalName.substring(fileTotalName.lastIndexOf('.') + 1, fileTotalName.length);
            if(suffixName === 'html'){
                var fd = new FormData();
                fd.append('file', fileBtn.files[0]);
                fd.append("title", title);
                fd.append("content_abstract", abstract);
                fd.append("theme_id", theme_id);
                // console.log(title);
                // console.log(abstract);
                var xhr = new XMLHttpRequest();
                xhr.open(method, url, true);
                xhr.send(fd);
                xhr.onreadystatechange = function(){
                    if(xhr.readyState === 4 && xhr.status === 200){
                        var response  = JSON.parse(xhr.responseText);
                        var link = response.response_data;
                        alert(link);
                    }
                }
            }
            else{
                console.log("this file is not suitable");
            }
        }
    }
}

function tweak(){
    var param1 = document.getElementById("un").value;
    var param2 = document.getElementById("pwd").value;
    if(param1 !== undefined && param1 !== ''){
        if(param2 !== undefined && param2 !== ''){
            var xhr = new XMLHttpRequest();
            var tempInfo = {
                "username" : param1,
                "key" : param2
            };
            xhr.open('POST', '/door/login', true);
            xhr.setRequestHeader('content-type', 'application/json');
            xhr.send(JSON.stringify(tempInfo));
            xhr.onreadystatechange = function(){
                if(xhr.readyState === 4 && xhr.status === 200){
                    var response  = JSON.parse(xhr.responseText);
                    console.log(response.response_data);
                    if(response.response_data === 'success'){
                        window.location.href = "/";
                    }
                }
            };
        }
    }
}

//提交博客
function commit_blog(markdownData, htmlPrevData){
    var title = document.getElementById('title').value;
    var theme_id = document.getElementById('theme_selection').options[document.getElementById('theme_selection').selectedIndex].value;
    var abstract = document.getElementById("content-abstract").value;
    var id = -1;
    var readable = 1;

    var form = new FormData();
    form.append('title', title);
    form.append('markdown', markdownData);
    form.append('html', htmlPrevData);
    form.append('theme_id', theme_id);
    form.append('content_abstract', abstract);
    form.append('readable', readable);
    var xhr = new XMLHttpRequest();
    xhr.open('POST', '/blog/commit_blog', true);
    xhr.send(form);
    xhr.onreadystatechange = function(){
        if(xhr.readyState === 4 && xhr.status === 200){
            var response  = JSON.parse(xhr.responseText);
            var message = response.response_data;
            alert(message);
        }
    }
}