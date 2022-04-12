<%--
  Created by IntelliJ IDEA.
  User: 86138
  Date: 2022/4/1
  Time: 10:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    pageContext.setAttribute("APP_PATH",request.getContextPath());
%>
<html>
<head>
    <title>Title</title>
</head>
<link  rel="styleSheet" type="text/css" href="${APP_PATH}/dist/css/bootstrap.css"/>
<body>

<!-- Button trigger modal -->
<%--<button type="button" class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModal" id="modal">
    点击填写登录信息
</button>--%>
<div class="container">
<!-- Modal -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" <%--data-backdrop="static"--%>>
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="myModalLabel">app表单登录</h4>
            </div>
            <div class="modal-body">
                <form id="formz">
                    <div class="form-group">
                        <label for="exampleInputEmail1">账号</label>
                        <input type="email" class="form-control" id="exampleInputEmail1" placeholder="Email" name="name">
                    </div>
                    <div class="form-group">
                        <label for="exampleInputPassword1">密码</label>
                        <input type="password" class="form-control" id="exampleInputPassword1" placeholder="Password" name="pwd">
                    </div>

                    <div class="checkbox">
                        <label>
                            <input type="checkbox"> Check me out
                        </label>
                    </div>
                    <%--<button type="button" class="btn btn-default" id="login">登录</button>--%>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">返回</button>
                <button type="button" class="btn btn-primary" id="login">登录</button>
            </div>
        </div>
    </div>
</div>

</div>

<div>
    <h1>后台管理系统</h1>
    <button type="button" class="btn btn-primary btn-lg" data-toggle="modal"  id="modal">
        点击填写登录信息
    </button>
</div>

<script type="text/javascript" src="${APP_PATH}/dist/js/jquery-1.12.4(1).js"></script>
<%--bootstrap的插件是依赖于jquery的--%>

<script type="text/javascript" src="${APP_PATH}/dist/js/bootstrap.js"></script>
<script type="text/javascript">
    $("#modal").click(function () {

        $("#myModal").modal({
            backdrop:"static" ,//点击背景模态框不消失
            show:true
        });
    })


      $("#login").click(function () {
            console.log($("#formz").serialize())
            $.ajax({
                url:"${APP_PATH}/selectAppNP",
                type:"POST",
                data:$("#formz").serialize(),
                success:function (data) {
                    console.log(data)

                    alert(data.returnData.userInfo.gly)//判断是否是管理员
                    alert(data.returnData.userInfo.name)
                    if (data.returnData.userInfo.gly==1){
                        location.href="${APP_PATH}/administrators";

                    }else {
                        alert("你不是管理员或者账号密码不正确")
                        location.href="${APP_PATH}";
                    }

                }

            })
        })




</script>
</body>

</html>
