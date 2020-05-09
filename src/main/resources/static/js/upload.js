// 文件切块大小为1MB
const chunkSize = 1024 * 1024;

// 格式化文件大小
function formatSize(b, times = 0) {
    if (b >= 1024) {
        return formatSize(b / 1024, times + 1);
    } else {
        let unit = '';
        switch (times) {
            case 0 : unit = 'B'; break;
            case 1 : unit = 'KB'; break;
            case 2 : unit = 'MB'; break;
            case 3 : unit = 'GB'; break;
            case 4 : unit = 'TB'; break;
            default: unit = '??';
        }
        return b.toFixed(2) + unit;
    }
}

// 从start字节处开始上传
function upload(start) {
    console.log("开始传输")
    let fileObj = document.getElementById('file').files[0];
    // 上传完成
    if (start >= fileObj.size) {
        $('#fileSize').text('上传完成').prepend($('<i></i>').addClass('fa fa-check fa-lg')).css('color', 'green');
        $('#file').val(null);
        return;
    }
    // 获取文件块的终止字节
    let end = (start + chunkSize > fileObj.size) ? fileObj.size : (start + chunkSize);
    // 将文件切块上传
    let fd = new FormData();
    fd.append('file', fileObj.slice(start, end), fileObj.name);
    // POST表单数据
    $.ajax({
        url: '/break/upload',
        type: 'post',
        data: fd,
        processData: false,
        contentType: false,
        success: function() {
            $('#progress-bar').css('width', Math.ceil(end * 100 / fileObj.size) + '%');
            $('#fileSize').text(`${formatSize(end)}/${formatSize(fileObj.size)}`);
            upload(end);
        }
    });
}

// 初始化上传大小
function init() {
    let fileObj = document.getElementById('file').files[0];
    let size = fileObj.size;
    $.post('/break/upload', {fileName: fileObj.name,size : size}, function(data) {
            console.log("返回信息"+data.toString())
            let start = parseInt(data);
            // 设置进度条
            $('.uploaded').css('display', 'none');
            $('.uploading').css('display', 'inline');
            $('.progress').css('display', 'flex');
            $('#fileName').text(fileObj.name);
            $('#progress-bar').css('width', Math.ceil(start * 100 / fileObj.size) + '%');
            $('#fileSize').text(`${formatSize(start)}/${formatSize(fileObj.size)}`).css('color', 'black');
            // 开始上传
            upload(start);
            if (start == fileObj.size) {
                toastr.success('秒传');
            }

    });
}

// 选择文件
function selectFile() {
    $('#file').click();
}

// 关闭进度条
function closeProgressBar() {
    $('.uploading').css('display', 'none');
    $('.uploaded').css('display', 'inline');
}

$(function() {
    toastr.options.positionClass = 'toast-top-center';
});
