<%--
  Created by IntelliJ IDEA.
  User: 15837
  Date: 2020/12/8
  Time: 9:41
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ page isELIgnored="false" %>

<html>
<head>
    <title>ITEMS</title>
    <%
//        项目当前路径
        pageContext.setAttribute("APP_PATH",request.getContextPath());
    %>

    <style>

        #top{
            display: flex;
            margin-left: 50px;
            margin-right: 50px;
            justify-content: space-between;
            align-items: center;
            margin-top: 30px;
        }

        .button{
            height: 30px;
            width: 80px;
            background-color: white;
            border-radius: 5px;
        }
        #line{
            height: 10px;
            color: darkgrey;
        }
        .input-group{
            display: flex;
            margin-top: 25px;
        }
        #middle{
            display: flex;
            justify-content: space-between;
            margin-left: 50px;
            margin-right: 50px;
            margin-top: 20px;
            height: 150px;
        }
        #middle-input{

        }
        .textandbutton{
            display: flex;
        }
        #button-group{
            margin-top: 25px;
        }
        .form-control{
            margin-left: 20px;
            margin-right:50px;
        }
        .buttontext{
            width: 120px;
        }
        #remake{
            margin-right: 25px;
        }
        #wuliaodanwei {
            border-radius: 4px;
            border: 1px solid #ccc;
        }
        #shifouqiyong{
            border-radius: 4px;
            border: 1px solid #ccc;
        }
    </style>
    <!-- 新 Bootstrap 核心 CSS 文件 -->
    <link href="${APP_PATH}/static/bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
    <script src = "${APP_PATH}/static/js/jquery-1.12.4.min.js" type="javascript"></script>
    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script src="${APP_PATH}/static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
    <link href="list.css" rel="stylesheet" type="text/css"/>

</head>
<body>
<div>
    <%--    //shang ceng he zi (wu liao guan li ,xin jian)--%>
    <div id="top">
        <h2 style="font-weight: bold" id="toplaft">物料管理</h2>
        <button class="button" id="newbutton" >新建</button>
    </div>

    <hr id="line" style="height: 3px" >

    <%--    //zhong jian he zi(shu ru kuang)--%>
    <div id="middle">
        <%--        输入框组--%>
        <%--六个输入框--%>
        <div id="middle-input">
            <%--        上方三个--%>
            <div id="topgroup" class="input-group">
                <div class="textandbutton">
                    <div class="buttontext" >物料编码</div>
                    <input id="wuliaobianma" type="text" class="form-control" aria-describedby="basic-addon1">
                </div>
                <div class="textandbutton">
                    <div class="buttontext">物料描述</div>
                    <input id="wuliaomiaoshu" type="text" class="form-control" aria-describedby="basic-addon1">
                </div>
                <div class="textandbutton">
                    <div class="buttontext">物料单位</div>
                    <select id="wuliaodanwei" style="width: 233px">
                        <option value="mi">米</option>
                        <option value="qianke">千克</option>
                        <option value="ge">个</option>
                    </select>
                    <%--                    <div class="btn-group">--%>
                    <%--                        <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" style="width: 233.462px">--%>
                    <%--                            米 <span class="caret"></span>--%>
                    <%--                        </button>--%>
                    <%--                        <ul class="dropdown-menu">--%>
                    <%--                            <li><a href="#">千克</a></li>--%>
                    <%--                            <li><a href="#">个</a></li>--%>
                    <%--                        </ul>--%>
                    <%--                    </div>--%>
                    <%--                    <input id="wuliaowuliaodanwei" type="text" class="form-control" aria-describedby="basic-addon1">--%>
                </div>
            </div>
            <%--        下方三个--%>
            <div id="buttomgroup" class="input-group">
                <div class="textandbutton">
                    <div class="buttontext">生效时间从</div>
                    <input id="shengxiaoshijiancong" type="text" class="form-control" aria-describedby="basic-addon1">
                </div>
                <div class="textandbutton">
                    <div class="buttontext">生效时间至</div>
                    <input id="shengxiaoshijianzhi" type="text" class="form-control" aria-describedby="basic-addon1">
                </div>
                <div class="textandbutton">
                    <div class="buttontext">是否启用</div>
                    <select id="shifouqiyong" style="width: 233px">
                        <option value="shi">是</option>
                        <option value="fou">否</option>
                    </select>
                    <%--                    <input id="是否启用" type="text" class="form-control" aria-describedby="basic-addon1">--%>
                    <%--                    <div class="btn-group">--%>
                    <%--                        <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" style="width: 233.462px">--%>
                    <%--                            是 <span class="caret"></span>--%>
                    <%--                        </button>--%>
                    <%--                        <ul class="dropdown-menu">--%>
                    <%--                            <li><a href="#">否</a></li>--%>
                    <%--                        </ul>--%>
                    <%--                    </div>--%>
                </div>
            </div>
                   </div>
               <%--        重置，查询按钮组--%>
        <div id="button-group">
            <button class="button" id="remake" >重置</button>
            <button class="button" id="lookfor" >查询</button>
        </div>
           </div>

    <%--    //di ceng he zi(zhan shi kuang)--%>
    <div id="buttom">
        <div class="col-md-12 column">
            <table class="table table-hover table-striped">
                <thead>
                <tr>
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
                <c:forEach var="items" items="${pageInfo.list}">
                    <tr>
                        <td>${items.itemCode}</td>
                        <td>${items.itemDescription}</td>
                        <td>${items.itemUom}</td>
                        <td>${items.startActive_date}</td>
                        <td>${items.endActive_date}</td>
                        <c:if test="${items.enabledFlag==0}">
                            <td>否</td>
                        </c:if>
                        <c:if test="${items.enabledFlag==1}">
                            <td>否</td>
                        </c:if>
                        <td>
                            <button class="btn btn-primary">编辑</button>
                            <button class="btn btn-danger">删除</button>
                        </td>
                            <%--                        <td>${book.enabled_flag}</td>--%>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
    <div style="float: right">
        <div>显示${pageInfo.pageNum*pageInfo.pageSize-pageInfo.pageSize+1}-${pageInfo.pageNum*pageInfo.pageSize} 共${pageInfo.total}条</div>
        <div>
            <nav aria-label="Page navigation">
                <ul class="pagination">
                    <c:if test="${pageInfo.hasPreviousPage}">
                        <li>
                            <a href="${APP_PATH}/items?pageNumber=${pageInfo.pageNum-1}" aria-label="Previous">
                                <span aria-hidden="true">&laquo;</span>
                            </a>
                        </li>
                    </c:if>

                    <c:forEach items="${pageInfo.navigatepageNums}" var="pageNum">
                        <c:if test="${pageNum == pageInfo.pageNum}">
                            <li class="active"><a href="#">${pageNum}</a></li>
                        </c:if>
                        <c:if test="${pageNum != pageInfo.pageNum}">
                            <li><a href="${APP_PATH}/items?pageNumber=${pageNum}">${pageNum}</a></li>
                        </c:if>
                    </c:forEach>
                    <c:if test="${pageInfo.hasNextPage}">
                        <li>
                            <a href="${APP_PATH}/items?pageNumber=${pageInfo.pageNum-1}" aria-label="Next">
                                <span aria-hidden="true">&laquo;</span>
                            </a>
                        </li>
                    </c:if>

                </ul>
            </nav>
        </div>
    </div>
</div>
</body>
</html>
