<%--
  Created by IntelliJ IDEA.
  User: 15837
  Date: 2020/12/5
  Time: 10:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="JAVA" isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Welcome</title>
    <%
        //        项目当前路径
        pageContext.setAttribute("APP_PATH", request.getContextPath());
    %>
    <script type="text/javascript" src="${APP_PATH}/static/js/jquery.min.js"></script>
    <link
            href="${APP_PATH }/static/bootstrap-3.3.7-dist/css/bootstrap.min.css"
            rel="stylesheet">
    <script
            src="${APP_PATH }/static/bootstrap-3.3.7-dist/js/bootstrap.min.js" type="text/javascript"></script>
</head>
<body>

<!-- 新建物料的模态框 -->
<div class="modal fade" id="items_add_modal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <form class="form-horizontal" method="post">
                    <div class="form-group">
                        <label class="col-sm-3 control-label">物料描述</label>
                        <div class="col-sm-5">
                            <input type="text" name="itemDescription" class="form-control" id="des_add_input"
                                   placeholder="item_description">
                            <span class="help-block"></span>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label">物料单位</label>
                        <div class="col-sm-3">
                            <select class="form-control" id="uom_select2" name="itemUom">
                                <option value="米">米</option>
                                <option value="平方米">平方米</option>
                                <option value="立方米">立方米</option>
                                <option value="千克">千克</option>
                                <option value="个">个</option>
                                <option value="其他">其他</option>
                            </select>
                            <span class="help-block"></span>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label">生效日期从</label>
                        <div class="col-sm-9">
                            <input type="date" name="startActiveDate" id="start_date_add_input"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label">生效日期至</label>
                        <div class="col-sm-9">
                            <input type="date" name="endActiveDate" id="end_date_add_input"/>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-sm-3 control-label">是否启用</label>
                        <div class="col-sm-3">
                            <select class="form-control" name="enabledFlag" id="flag_add_select">
                                <option value="true">是</option>
                                <option value="false">否</option>
                            </select>
                        </div>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">返回</button>
                <button type="submit" class="btn btn-primary" id="item_save_btn1">保存</button>
            </div>
        </div>
    </div>
</div>

<%--编辑按钮的模态框--%>

<div class="modal fade" id="items_update_modal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span>
                </button>
                <h4 class="modal-title" id="myModalLabel">物料修改</h4>
            </div>
            <div class="modal-body">
                <form class="form-horizontal" method="post">
                    <div class="form-group">
                        <label class="col-sm-3 control-label">物料编码</label>
                        <div class="col-sm-5">
                            <p name="itemDescription" class="form-control-static" id="code_static_text">
                                <span class="help-block"></span>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label">物料描述</label>
                        <div class="col-sm-5">
                            <input type="text" name="itemDescription" class="form-control" id="des_update_input"
                                   placeholder="item_description">
                            <span class="help-block"></span>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label">物料单位</label>
                        <div class="col-sm-3">
                            <select class="form-control" id="uom_select1" name="itemUom">
                                <option value="米">米</option>
                                <option value="平方米">平方米</option>
                                <option value="立方米">立方米</option>
                                <option value="千克">千克</option>
                                <option value="个">个</option>
                                <option value="其他">其他</option>
                            </select>
                            <span class="help-block"></span>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label">生效日期从</label>
                        <div class="col-sm-9">
                            <input type="date" name="startActiveDate" id="start_date_update_input"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label">生效日期至</label>
                        <div class="col-sm-9">
                            <input type="date" name="endActiveDate" id="end_date_update_input"/>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-sm-3 control-label">是否启用</label>
                        <div class="col-sm-3">
                            <select class="form-control" name="enabledFlag" id="flag_update_select">
                                <option value="true">是</option>
                                <option value="false">否</option>
                            </select>
                        </div>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">返回</button>
                <button type="submit" class="btn btn-primary" id="item_update_btn">更新</button>
            </div>
        </div>
    </div>
</div>
<!-- 搭建显示页面 -->
<div class="container">
    <!-- 标题 -->
    <div class="row">
        <div class="col-md-6">
            <h2>物料管理</h2>
        </div>
        <div class="col-md-4 col-md-offset-1">
            <button class="btn" id="add_button" style="margin-top: 15px;margin-left: 100px">新建</button>
            <button class="btn btn-danger" id="delete_all" style="margin-top: 15px;margin-left: 20px">批量删除</button>
            <button class="btn" id="upload_all" style="margin-top: 15px;margin-left: 10px">批量导出</button>

        </div>
    </div>
    <div class="row">
        <div class="col-md-12" style="border-bottom: 3px solid black;margin-bottom: 10px"></div>
    </div>
    <!-- 按钮 -->
    <form id="query_form">
        <div class="row">
            <div class="col-md-1">
                物料代码
            </div>
            <div class="col-md-1">
                <input class="input-sm" id="code_input" name="itemCode">
            </div>
            <div class="col-md-1 col-md-offset-1">
                物料描述
            </div>
            <div class="col-md-1">
                <input class="input-sm" id="description_input" name="itemDescription">
            </div>
            <div class="col-md-1 col-md-offset-1">
                物料单位
            </div>
            <div class="col-md-2">
                <select class="form-control" id="uom_select" name="itemUom">
                    <option value="米">米</option>
                    <option value="平方米">平方米</option>
                    <option value="立方米">立方米</option>
                    <option value="千克">千克</option>
                    <option value="个">个</option>
                    <option value="其他">其他</option>
                </select>
            </div>
            <div class="col-md-1 col-md-offset-1">
                <button class="btn" id="ssmItems_clearAll_btn" type="button">重置</button>
            </div>
            <div>
                <button class="btn" id="ssmItems_query_btn" style="background-color: #2aabd2" type="button">查询</button>
            </div>

        </div>

        <div class="row">
            <div class="col-md-1">
                生效日期从
            </div>
            <div class="col-md-1">
                <input class="input-sm" id="start_active_input" type="date" name="startActiveDate">
            </div>
            <div class="col-md-1 col-md-offset-1">
                生效日期至
            </div>
            <div class="col-md-1">
                <input class="input-sm" id="end_active_input" type="date" name="endActiveDate">
            </div>
            <div class="col-md-1 col-md-offset-1">
                是否启用
            </div>
            <div class="col-md-2">
                <%--            <input class = "input-sm" id="flag_input">--%>
                <select class="form-control" id="flag_select" name="enabledFlag">
                    <option value="true">是</option>
                    <option value="false">否</option>
                </select>
            </div>
        </div>
    </form>
    <!-- 显示表格数据 -->
    <div class="row">
        <div class="col-md-12">
            <table class="table table-hover" id="ssmItems_table">
                <thead>
                <tr>
                    <th><input type=checkbox id="check_all"/></th>
                    <th>物料编码</th>
                    <th>物料描述</th>
                    <th>物料单位</th>
                    <th>生效时间从</th>
                    <th>生效时间至</th>
                    <th>是否启用</th>
                    <th>操作</th>
                </tr>
                </thead>
                <tbody>
                </tbody>
            </table>
        </div>
    </div>

    <!-- 显示分页信息 -->
    <div class="row">
        <!--分页文字信息  -->
        <div class="col-md-6" id="page_info_area"></div>
        <!-- 分页条信息 -->
        <div class="col-md-6" id="page_nav_area">
        </div>
    </div>
</div>
</body>
<script type="text/javascript">
    let totalPages, currentPageNumber, totalPages1, currentPageNumber1;
    // 页面加载完成之后，发送一个Ajax请求，得到分页数据
    $(function () {
        toPage(1);
    });

    // 跳转到指定的页码号
    function toPage(pageNumber) {
        $.ajax({
            url: "${APP_PATH}/items",
            data: "pageNumber=" + pageNumber,
            type: "GET",
            success: function (result) {
                build_ssmItems_table(result);
                build_page_info(result);
                build_page_nav(result);
            }
        });
    }

    /**
     * 解析json数据并添加到表格中
     * @param result
     */
    function build_ssmItems_table(result) {
        $("#ssmItems_table tbody").empty();
        let items = result.map.pageInfo.list;
        $.each(items, function (index, item) {
            let itemId = item.itemId;
            let checkBox = $("<td><input type='checkbox' class='check_item'/></td>");
            let itemCode = $("<td></td>").append(item.itemCode);
            let itemDescription = $("<td></td>").append(item.itemDescription);
            let itemUom = $("<td></td>").append(item.itemUom);
            let startActiveDate = $("<td></td>").append(item.startActiveDate);
            let endActiveDate = $("<td></td>").append(item.endActiveDate);
            let enabledFlag = $("<td></td>").append(item.enabledFlag == true ? "是" : "否");
            let editButton = $("<button></button>")
                .addClass("btn btn-primary btn-sm edit_btn")
                .append("编辑");
            // 为编辑按钮添加一个自定义属性，来表示当前物料的Id
            editButton.attr("editId", itemId);
            let deleteButton = $("<button></button>")
                .addClass("btn btn-danger btn-sm delete_btn")
                .append("删除");
            // 为删除按钮添加一个自定义属性
            deleteButton.attr("deleteId", itemId);
            let btnTd = $("<td></td>").append(editButton).append(" ").append(deleteButton);
            $("<tr></tr>").append(checkBox)
                .append(itemCode)
                .append(itemDescription)
                .append(itemUom)
                .append(startActiveDate)
                .append(endActiveDate)
                .append(enabledFlag)
                .append(btnTd)
                .appendTo("#ssmItems_table tbody");
        });
    }

    // 解析分页信息
    function build_page_info(result) {
        //清空当前区域的数据
        $("#page_info_area").empty();
        $("#page_info_area").append("当前第" + result.map.pageInfo.pageNum + " 页,总共" +
            result.map.pageInfo.pages + "页," + "共" + result.map.pageInfo.total + "条记录");
        totalPages = result.map.pageInfo.pages;
        currentPageNumber = result.map.pageInfo.pageNum;
    }


    /**
     * 构建分页条
     * @param result
     */
    function build_page_nav(result) {
        $("#page_nav_area").empty();
        var ul = $("<ul></ul>").addClass("pagination");

        //构建元素
        var firstPage = $("<li></li>").append($("<a></a>").append("首页").attr("href", "#"));
        var prevPage = $("<li></li>").append($("<a></a>").append("&laquo;"));
        if (result.map.pageInfo.hasPreviousPage == false) {
            firstPage.addClass("disabled");
            prevPage.addClass("disabled");
        } else {
            //为元素添加点击翻页的事件
            firstPage.click(function () {
                toPage(1);
            });
            prevPage.click(function () {
                toPage(result.map.pageInfo.pageNum - 1);
            });
        }

        var nestPage = $("<li></li>").append($("<a></a>").append("&raquo;"));
        var lastPage = $("<li></li>").append($("<a></a>").append("末页").attr("href", "#"));
        if (result.map.pageInfo.hasNextPage == false) {
            nestPage.addClass("disabled");
            lastPage.addClass("disabled");
        } else {
            nestPage.click(function () {
                toPage(result.map.pageInfo.pageNum + 1);
            });
            lastPage.click(function () {
                toPage(result.map.pageInfo.pages);
            });
        }

        //添加首页和前一页 的提示
        ul.append(firstPage).append(prevPage);
        //1,2，3遍历给ul中添加页码提示
        $.each(result.map.pageInfo.navigatepageNums, function (index, item) {

            var numLi = $("<li></li>").append($("<a></a>").append(item));
            if (result.map.pageInfo.pageNum == item) {
                numLi.addClass("active");
            }
            numLi.click(function () {
                toPage(item);
            });
            ul.append(numLi);
        });
        //添加下一页和末页 的提示
        ul.append(nestPage).append(lastPage);

        //把ul加入到nav
        var navEle = $("<nav></nav>").append(ul);
        navEle.appendTo("#page_nav_area");
    }


    // 点击新增，弹出模态框
    $("#add_button").click(function () {
        $("#items_add_modal").modal({
            backdrop: "static"
        })
    });

    function validate_add_form() {
        let des = $("#des_add_input").val();
        let regx = /^[\u4e00-\u9fffa-zA-Z]{0,60}$/;
        if (!regx.test(des)) {
            alert("描述不能超过60个字符...");
            return false;
        }
    }


    // 点击保存以后,新建物料
    $("#item_save_btn1").click(function () {
        // 将模态框的表单数据提交给服务器进行保存
        // 对数据进行校验
        let des = $("#des_add_input").val();
        let date1 = $("#start_date_add_input").val();
        let date2 = $("#end_date_add_input").val();
        let regx = /^[\u4e00-\u9fffa-zA-Z_`~·。，‘“”''']{0,60}$/;
        if (des == "") {
            alert("物料描述不能为空");
        } else if (!regx.test(des)) {
            alert("物料描述不能超过60个字符或包含特殊字符!");
        } else if (date1 == "") {
            alert("起始日期不能为空!");
        } else if (date2 == "") {
            alert("截止日期不能为空!");
        } else {
            // 发送ajax请求保存物料
            $.ajax({
                url: "${APP_PATH}/saveItems",
                type: "POST",
                data: $("#items_add_modal form").serialize(),
                success: function (result) {
                    alert(result.msg);
                    //保存成功之后，关闭模态框
                    $("#items_add_modal").modal('hide');
                    // 然后再执行一次查询,跳转到最后一页
                    toPage(totalPages + 1);
                }
            });
        }
    });


    // 因为edit_btn是后来添加上的元素所以使用on来为其绑定点击事件
    // 点击后会查询物料的相关信息，并展示在模态框上
    $(document).on("click", ".edit_btn", function () {
        getItemCode($(this).attr("editId"));
        // 将物料的id传递给模态框的更新按钮
        $("#item_update_btn").attr("editId", $(this).attr("editId"));
        $("#items_update_modal").modal({
            backdrop: "static"
        });
    });

    //为删除按钮绑定单击事件
    $(document).on("click", ".delete_btn", function () {
        //弹出确认删除的对话框
        //alert($(this).parents("tr").find("td:eq(0)").text());
        let itemCode = $(this).parents("tr").find("td:eq(1)").text();
        if (confirm("确认删除[" + itemCode + "]这条记录吗?")) {
            //点击确认之后，发送ajax请求
            $.ajax({
                url: "${APP_PATH}/delete/" + $(this).attr("deleteId"),
                type: "DELETE",
                success: function (result) {
                    toPage(currentPageNumber);
                }
            });
        }
    });

    //查询物料的相关信息
    function getItemCode(id) {
        $.ajax({
            url: "${APP_PATH}/getCode/" + id,
            type: "GET",
            success: function (result) {
                let itemData = result.map.ssmItem;
                $("#code_static_text").text(itemData.itemCode);
                $("#des_update_input").val(itemData.itemDescription);
                $("#uom_select1").val(itemData.itemUom);
                $("#start_date_update_input").val(itemData.startActiveDate);
                $("#end_date_update_input").val(itemData.endActiveDate);
                $("#flag_update_select").val(itemData.enabledFlag == "true" ? "是" : "否");
            }
        });
    }

    // 点击更新按钮，更新物料信息
    // 将提交方法改成PUT的时候，请求中有数据，但是SsmItem封装不上
    // 原因是Tomcat会将请求体中的数据封装到一个map中 request.getParameter就会从map中获取值
    // 而springMVC在封装POJO的时候，会将POJO中每个属性的值通过getParameter拿到。而tomcat一看是put请求，就不会封装数据，那么自然就拿不到数据
    $("#item_update_btn").click(function () {
        // alert($("#items_update_modal form").serialize());
        //let id = document.getElementById("code_static_text").innerHTML
        //alert($(this).attr("editId"));

        let des = $("#des_update_input").val();
        let date1 = $("#start_date_update_input").val();
        let date2 = $("#end_date_update_input").val();
        let regx = /^[\u4e00-\u9fffa-zA-Z_`~·。，‘“”''']{0,60}$/;
        if (des == "") {
            alert("物料描述不能为空");
        } else if (!regx.test(des)) {
            alert("物料描述不能超过60个字符或包含特殊字符!");
        } else if (date1 == "") {
            alert("起始日期不能为空!");
        } else if (date2 == "") {
            alert("截止日期不能为空!");
        } else {
            $.ajax({
                url: "${APP_PATH}/update/" + $(this).attr("editId"),
                type: "PUT",
                data: $("#items_update_modal form").serialize(),
                success: function (result) {
                    alert(result.msg);
                    $("#items_update_modal").modal('hide');
                    toPage(currentPageNumber);
                }
            });
        }
    });

    // 完成全选功能\全不选的功能
    $("#check_all").click(function () {
        // 获取checkbox的属性，使用attr用于获取自定义的属性的值
        // alert($(this).prop("checked"));
        $(".check_item").prop("checked", $(this).prop("checked"));
    });

    // 物料上的checkbox如果全选，那么check_all = true
    $(document).on("click", ".check_item", function () {
        let flag = $(".check_item:checked").length == $(".check_item").length;
        $("#check_all").prop("checked", flag);
    });

    //批量删除的按钮
    $("#delete_all").click(function () {
        let del_str = "";
        $.each($(".check_item:checked"), function () {
            del_str += $(this).parents("tr").find("td:eq(1)").text() + "-";
        });
        del_str = del_str.substring(0, del_str.length - 1);
        if (confirm("确认删除选中记录？")) {
            $.ajax({
                url: "${APP_PATH}/deleteAll/" + del_str,
                type: "DELETE",
                success: function (result) {
                    alert(result.msg);
                    toPage(currentPageNumber);
                }
            });
        }
    });
    //批量导出的按钮


    $("#upload_all").click(function () {
        let del_str = "";
        $.each($(".check_item:checked"), function () {
            del_str += $(this).parents("tr").find("td:eq(1)").text() + "-";
        });
        del_str = del_str.substring(0, del_str.length - 1);
        console.log(del_str);
        window.location.href = "http://localhost:8080/excle/" + del_str;
    });


    //重置按钮清除所有的值
    $("#ssmItems_clearAll_btn").click(function () {
        $("#code_input").val(null);
        $("#description_input").val(null);
        $("#uom_select").val(null);
        $("#start_active_input").val(null);
        $("#end_active_input").val(null);
        $("#flag_select").val(null);
    });


    function toNewPage(pageNumber) {
        $.ajax({
            url: "${APP_PATH}/select",
            data: "pageNumber=" + pageNumber + "&" + $("#query_form").serialize(),
            type: "GET",
            success: function (result) {
                build_ssmItems_table1(result);
                build_page_info1(result);
                build_page_nav1(result);
            }
        });
    }

    function build_ssmItems_table1(result) {
        $("#ssmItems_table tbody").empty();
        let items = result.map.pageInfo.list;
        $.each(items, function (index, item) {
            let itemId = item.itemId;
            let checkBox = $("<td><input type='checkbox' class='check_item'/></td>");
            let itemCode = $("<td></td>").append(item.itemCode);
            let itemDescription = $("<td></td>").append(item.itemDescription);
            let itemUom = $("<td></td>").append(item.itemUom);
            let startActiveDate = $("<td></td>").append(item.startActiveDate);
            let endActiveDate = $("<td></td>").append(item.endActiveDate);
            let enabledFlag = $("<td></td>").append(item.enabledFlag == true ? "是" : "否");
            let editButton = $("<button></button>")
                .addClass("btn btn-primary btn-sm edit_btn")
                .append("编辑");
            // 为编辑按钮添加一个自定义属性，来表示当前物料的Id
            editButton.attr("editId", itemId);
            let deleteButton = $("<button></button>")
                .addClass("btn btn-danger btn-sm delete_btn")
                .append("删除");
            // 为删除按钮添加一个自定义属性
            deleteButton.attr("deleteId", itemId);
            let btnTd = $("<td></td>").append(editButton).append(" ").append(deleteButton);
            $("<tr></tr>").append(checkBox)
                .append(itemCode)
                .append(itemDescription)
                .append(itemUom)
                .append(startActiveDate)
                .append(endActiveDate)
                .append(enabledFlag)
                .append(btnTd)
                .appendTo("#ssmItems_table tbody");
        });
    }

    function build_page_info1(result) {
        //清空当前区域的数据
        $("#page_info_area").empty();
        $("#page_info_area").append("当前第" + result.map.pageInfo.pageNum + " 页,总共" +
            result.map.pageInfo.pages + "页," + "共" + result.map.pageInfo.total + "条记录");
        totalPages1 = result.map.pageInfo.pages;
        currentPageNumber1 = result.map.pageInfo.pageNum;
    }

    function build_page_nav1(result) {
        $("#page_nav_area").empty();
        var ul = $("<ul></ul>").addClass("pagination");

        //构建元素
        var firstPage = $("<li></li>").append($("<a></a>").append("首页").attr("href", "#"));
        var prevPage = $("<li></li>").append($("<a></a>").append("&laquo;"));
        if (result.map.pageInfo.hasPreviousPage == false) {
            firstPage.addClass("disabled");
            prevPage.addClass("disabled");
        } else {
            //为元素添加点击翻页的事件
            firstPage.click(function () {
                toNewPage(1);
            });
            prevPage.click(function () {
                toNewPage(result.map.pageInfo.pageNum - 1);
            });
        }

        var nestPage = $("<li></li>").append($("<a></a>").append("&raquo;"));
        var lastPage = $("<li></li>").append($("<a></a>").append("末页").attr("href", "#"));
        if (result.map.pageInfo.hasNextPage == false) {
            nestPage.addClass("disabled");
            lastPage.addClass("disabled");
        } else {
            nestPage.click(function () {
                toNewPage(result.map.pageInfo.pageNum + 1);
            });
            lastPage.click(function () {
                toNewPage(result.map.pageInfo.pages);
            });
        }

        //添加首页和前一页 的提示
        ul.append(firstPage).append(prevPage);
        //1,2，3遍历给ul中添加页码提示
        $.each(result.map.pageInfo.navigatepageNums, function (index, item) {

            var numLi = $("<li></li>").append($("<a></a>").append(item));
            if (result.map.pageInfo.pageNum == item) {
                numLi.addClass("active");
            }
            numLi.click(function () {
                toNewPage(item);
            });
            ul.append(numLi);
        });
        //添加下一页和末页 的提示
        ul.append(nestPage).append(lastPage);

        //把ul加入到nav
        var navEle = $("<nav></nav>").append(ul);
        navEle.appendTo("#page_nav_area");
    }

    $("#ssmItems_query_btn").click(function () {
        toNewPage(1);
    });


</script>
</html>