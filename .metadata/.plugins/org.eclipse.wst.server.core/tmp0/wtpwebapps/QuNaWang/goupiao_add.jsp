<%@ page language="java" import="dao.*" pageEncoding="UTF-8" %>
<%@ page language="java" import="java.util.*" %>
<%@page import="util.Info" %>
<%@ taglib prefix="ssm" uri="http://ssm" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ include file="head.jsp" %>
<script src="js/jquery.validate.js"></script>

<div style="padding: 10px">


    <div class="container"><!-- 当你点击购买机票时，就会跳转到这个界面 -->
        <div class="panel panel-default">
            <div class="panel-heading">
                添加购票:
            </div>
            <div class="panel-body">
                <form action="goupiaoinsert.do" method="post" name="form1" id="form1"><!-- form 标签开始 -->
                    <div class="form-group">
                        <div class="row">
                            <label style="width: 120px;min-height:18px;text-align: right" class="col-sm-2">票务编号</label>
                            <div class="col-sm-8">

                                ${readMap.piaowubianhao}<input type="hidden" id="piaowubianhao" name="piaowubianhao"
                                                               value="${Info.html(readMap.piaowubianhao)}"/></div>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="row">
                            <label style="width: 120px;min-height:18px;text-align: right" class="col-sm-2">航班名称</label>
                            <div class="col-sm-8">

                                ${readMap.hangbanmingcheng}<input type="hidden" id="hangbanmingcheng"
                                                                  name="hangbanmingcheng"
                                                                  value="${Info.html(readMap.hangbanmingcheng)}"/></div>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="row">
                            <label style="width: 120px;min-height:18px;text-align: right" class="col-sm-2">出发地</label>
                            <div class="col-sm-8">

                                ${readMap.chufadi}<input type="hidden" id="chufadi" name="chufadi"
                                                         value="${Info.html(readMap.chufadi)}"/></div>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="row">
                            <label style="width: 120px;min-height:18px;text-align: right" class="col-sm-2">目的地</label>
                            <div class="col-sm-8">

                                ${readMap.mudidi}<input type="hidden" id="mudidi" name="mudidi"
                                                        value="${Info.html(readMap.mudidi)}"/></div>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="row">
                            <label style="width: 120px;min-height:18px;text-align: right" class="col-sm-2">起飞时间</label>
                            <div class="col-sm-8">

                                ${readMap.qifeishijian}<input type="hidden" id="qifeishijian" name="qifeishijian"
                                                              value="${Info.html(readMap.qifeishijian)}"/></div>
                        </div>
                    </div>

                    <div class="form-group">
                        <div class="row">
                            <label style="width: 120px;min-height:18px;text-align: right" class="col-sm-2">票价</label>
                            <div class="col-sm-8">

                                ${readMap.piaojia}<input type="hidden" id="piaojia" name="piaojia"
                                                         value="${Info.html(readMap.piaojia)}"/></div>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="row">
                            <label style="width: 120px;min-height:18px;text-align: right" class="col-sm-2">登机口</label>
                            <div class="col-sm-8">

                                ${readMap.dengjikou}<input type="hidden" id="dengjikou" name="dengjikou"
                                                           value="${Info.html(readMap.dengjikou)}"/></div>
                        </div>
                    </div>

                    <div class="form-group">
                        <div class="row">
                            <label style="width: 120px;min-height:18px;text-align: right" class="col-sm-2">购票人姓名<span
                                    style="color: red;">*</span></label>
                            <div class="col-sm-8">
                                <input type="text" class="form-control" style="width:150px;" data-rule-required="true"
                                       data-msg-required="请填写购票人姓名" id="goupiaorenxingming" name="goupiaorenxingming"
                                       value=""/></div>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="row">
                            <label style="width: 120px;min-height:18px;text-align: right" class="col-sm-2">手机<span
                                    style="color: red;">*</span></label>
                            <div class="col-sm-8">
                                <input type="text" class="form-control" style="width:150px;" data-rule-required="true"
                                       data-msg-required="请填写手机" phone="true" data-msg-phone="请输入正确手机号码" id="shouji"
                                       name="shouji" value=""/></div>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="row">
                            <label style="width: 120px;min-height:18px;text-align: right" class="col-sm-2">身份证号<span
                                    style="color: red;">*</span></label>
                            <div class="col-sm-8">
                                <input type="text" class="form-control" style="width:150px;" data-rule-required="true"
                                       data-msg-required="请填写身份证号" idcard="true" data-msg-email="请输入有效身份证号码"
                                       id="shenfenzhenghao" name="shenfenzhenghao" value=""/></div>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="row">
                            <label style="width: 120px;min-height:18px;text-align: right" class="col-sm-2">购票人</label>
                            <div class="col-sm-8">
                                <input type="text" class="form-control" style="width:150px;" readonly="readonly"
                                       id="goupiaoren" name="goupiaoren" value="${sessionScope.username}"/></div>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="row">
                            <label style="width: 120px;min-height:18px;text-align: right" class="col-sm-2"> </label>
                            <div class="col-sm-8">
                                <input type="hidden" name="jipiaoid" value="${param.id}"/><input name="referer"
                                                                                                 value="<%=request.getHeader("referer")%>"
                                                                                                 type="hidden"/><input
                                    type="hidden" name="iszf" value="否"/>
                                <button type="submit" class="btn btn-primary" name="Submit">
                                    提交
                                </button>
                                <button type="reset" class="btn btn-default" name="Submit2">
                                    重置
                                </button>
                            </div>
                        </div>
                    </div><!--form标签结束--></form>
            </div>
        </div>
        <!-- container定宽，并剧中结束 --></div>
        
    <script>
        $(function () {
            $('#form1').validate();
        });
    </script>
</div>
<%@ include file="foot.jsp" %>
