<%@ page language="java" import="dao.*" pageEncoding="UTF-8" %>
<%@ page language="java" import="java.util.*" %>
<%@page import="util.Info" %>
<%@ taglib prefix="ssm" uri="http://ssm" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ include file="head.jsp" %>
<script src="js/datepicker/WdatePicker.js"></script>

<div style="padding: 10px">

	
    <div class="panel panel-default">
        <div class="panel-heading">
        <span class="module-name">
            机票        </span>
            <span>列表</span>
        </div>
        <div class="panel-body">
            <div class="pa10 bg-warning">
                <form class="form-inline" action="?"><!-- form 标签开始 -->
                    <div class="form-group">

                        <i class="glyphicon glyphicon-search"></i>
                    </div>


                    <div class="form-group">
                        出发地
                        <input type="text" class="form-control" style="" name="chufadi" value="${param.chufadi}"/></div>
                    <div class="form-group">
                        目的地
                        <input type="text" class="form-control" style="" name="mudidi" value="${param.mudidi}"/></div>




                    <script>$("#orderby").val("${orderby}");
                    $("#sort").val("${sort}");</script>
                    <button type="submit" class="btn btn-default">
                        搜索
                    </button><!--form标签结束--></form>
            </div>


            <div class="">
                <table width="100%" border="1" class="table table-list table-bordered table-hover">
                    <thead>
                    <tr align="center">
                        <th width="60" data-field="item">序号</th>
                        <th> 票务编号</th>
                        <th> 航班名称</th>
                        <th> 出发地</th>
                        <th> 目的地</th>
                        <th> 起飞时间</th>
                        <th> 票价</th>
                        <th> 剩余座位</th>
                        <th> 登机口</th>
                        <th width="180" data-field="addtime">添加时间</th>
                        <th width="180" data-field="handler">操作</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:set var="i" value="0"/><c:forEach items="${list}" var="map"><c:set var="i" value="${i+1}"/>
                        <tr id="${map.id}" pid="">
                            <td width="30" align="center">
                                <label>
                                        ${i}
                                </label>
                            </td>
                            <td> ${map.piaowubianhao} </td>
                            <td> ${map.hangbanmingcheng} </td>
                            <td> ${map.chufadi} </td>
                            <td> ${map.mudidi} </td>
                            <td> ${map.qifeishijian} </td>
                            <td> ${map.piaojia} </td>
                            <td> ${map.shengyuzuowei} </td>
                            <td> ${map.dengjikou} </td>
                            <td align="center">${map.addtime}</td>
                            <td align="center">


                                <c:choose>
                                    <c:when test="${'用户' == sessionScope.cx }">
                                        <c:choose>
                                            <c:when test="${map.shengyuzuowei != '0'}">
                                                <a href="goupiao_add.do?id=${map.id}">购票</a>
                                            </c:when>
                                        </c:choose>

                                    </c:when>
                                </c:choose>


                                <c:choose>
                                    <c:when test="${'管理员' == sessionScope.cx }">
                                        <a href="jipiao_updt.do?id=${map.id}">修改</a>
                                        <a href="jipiao_delete.do?id=${map.id}"
                                           onclick="return confirm('真的要删除？')">删除</a>
                                    </c:when>
                                </c:choose>


                                <!--qiatnalijne-->
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>

            ${page.info}


        </div>


    </div>


</div>
<%@ include file="foot.jsp" %>
