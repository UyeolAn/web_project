/**
 * reply.js
 */

class Reply {
  showInfo() {
    console.log("test...")
  }

  replyList(noticeId, callback) {
    // let xhttp = new XMLHttpRequest();
    // xhttp.open('get', 'ajaxreplylist.do?nid=' + noticeId);
    // xhttp.send();

    // xhttp.onload = () => {
    //   let datas = JSON.parse(xhttp.responseText);
    //   console.log(datas);
    //   callback(datas);
    // }

    fetch("ajaxreplylist.do?nid=" + noticeId)
      .then(response => response.json())
      .then(result => callback(result))
      .catch(err => errcall(err));
  }

  replySearch(replyId, callback) {
    // let xhttp = new XMLHttpRequest();
    // xhttp.open('get', 'ajaxreplysearch.do?rid='+replyId);
    // xhttp.send();

    // xhttp.onload = () => {
    //   let data = JSON.parse(xhttp.responseText);
    //   console.log(data);
    //   callback(data);
    // }

    fetch('ajaxreplysearch.do?rid='+replyId)
      .then(response => response.json())
      .then(result => callback(result))
      .catch(err => errcall(err));
  }

  replyAdd(reply, callback) {
    // let xhttp = new XMLHttpRequest();
    // xhttp.open('post', 'ajaxreplyadd.do');
    // xhttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
    // xhttp.send('noticeId='+reply.noticeId+'&replySubject='+reply.replySubject+'&replyWriter='+reply.replyWriter);

    // xhttp.onload = () => {
    //   let datas = JSON.parse(xhttp.responseText);
    //   console.log(datas);
    //   callback(datas);
    // }

    fetch('ajaxreplyadd.do', {
      method: "POST",
      headers: {'Content-Type': 'application/x-www-form-urlencoded'},
      body: 'noticeId='+reply.noticeId+'&replySubject='+reply.replySubject+'&replyWriter='+reply.replyWriter
    }).then(response => response.json())
      .then(result => callback(result))
      .catch(err => errcall(err));
  }

  replyModify(updateData, callback) {
    // let xhttp = new XMLHttpRequest();
    // xhttp.open('post', 'ajaxreplymodify.do');
    // xhttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
    // xhttp.send('replyId='+updateData.replyId+'&replySubject='+updateData.replySubject);

    // xhttp.onload = () => {
    //   let datas = JSON.parse(xhttp.responseText);
    //   console.log(datas);
    //   callback(datas);
    // }

    fetch('ajaxreplymodify.do', {
      method: "POST",
      headers: {'Content-Type': 'application/x-www-form-urlencoded'},
      body: 'replyId='+updateData.replyId+'&replySubject='+updateData.replySubject
    }).then(response => response.json())
      .then(result => callback(result))
      .catch(err => errcall(err));
  }

  replyRemove(replyId, callback) {
    // let xhttp = new XMLHttpRequest();
    // xhttp.open('get', 'ajaxreplydelete.do?rid=' + replyId);
    // xhttp.send();

    // xhttp.onload = () => {
    //   let datas = JSON.parse(xhttp.responseText);
    //   console.log(datas);
    //   callback(datas);
    // }

    fetch('ajaxreplydelete.do?rid=' + replyId)
    .then(response => response.json())
    .then(result => callback(result))
    .catch(err => errcall(err));
  }
}