<%@ page language="java" import="dao.*" pageEncoding="UTF-8" %>
<%@ page language="java" import="java.util.*" %>
<%@page import="util.Info" %>
<%@ taglib prefix="ssm" uri="http://ssm" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ include file="head.jsp" %>
<script src="js/jquery.validate.js"></script>

<div style="padding: 10px">
	<!-- 用户修改购票信息-->
    <div class="container">
        <div class="panel panel-default">
            <div class="panel-heading">
                编辑购票:
            </div>
            <div class="panel-body">
                <form action="goupiaoupdate.do" method="post" name="form1" id="form1"><!-- form 标签开始 -->
                    <div class="form-group">
                        <div class="row">
                            <label style="width: 120px;min-height:18px;text-align: right" class="col-sm-2">票务编号</label>
                            <div class="col-sm-8">

                                ${mmm.piaowubianhao}<input type="hidden" id="piaowubianhao" name="piaowubianhao"
                                                           value="${Info.html(mmm.piaowubianhao)}"/></div>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="row">
                            <label style="width: 120px;min-height:18px;text-align: right" class="col-sm-2">航班名称</label>
                            <div class="col-sm-8">

                                ${mmm.hangbanmingcheng}<input type="hidden" id="hangbanmingcheng"
                                                              name="hangbanmingcheng"
                                                              value="${Info.html(mmm.hangbanmingcheng)}"/></div>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="row">
                            <label style="width: 120px;min-height:18px;text-align: right" class="col-sm-2">出发地</label>
                            <div class="col-sm-8">

                                ${mmm.chufadi}<input type="hidden" id="chufadi" name="chufadi"
                                                     value="${Info.html(mmm.chufadi)}"/></div>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="row">
                            <label style="width: 120px;min-height:18px;text-align: right" class="col-sm-2">目的地</label>
                            <div class="col-sm-8">

                                ${mmm.mudidi}<input type="hidden" id="mudidi" name="mudidi"
                                                    value="${Info.html(mmm.mudidi)}"/></div>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="row">
                            <label style="width: 120px;min-height:18px;text-align: right" class="col-sm-2">起飞时间</label>
                            <div class="col-sm-8">

                                ${mmm.qifeishijian}<input type="hidden" id="qifeishijian" name="qifeishijian"
                                                          value="${Info.html(mmm.qifeishijian)}"/></div>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="row">
                            <label style="width: 120px;min-height:18px;text-align: right" class="col-sm-2">票价</label>
                            <div class="col-sm-8">

                                ${mmm.piaojia}<input type="hidden" id="piaojia" name="piaojia"
                                                     value="${Info.html(mmm.piaojia)}"/></div>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="row">
                            <label style="width: 120px;min-height:18px;text-align: right" class="col-sm-2">登机口</label>
                            <div class="col-sm-8">

                                ${mmm.dengjikou}<input type="hidden" id="dengjikou" name="dengjikou"
                                                       value="${Info.html(mmm.dengjikou)}"/></div>
                        </div>
                    </div>

                    <div class="form-group">
                        <div class="row">
                            <label style="width: 120px;min-height:18px;text-align: right" class="col-sm-2">购票人姓名<span
                                    style="color: red;">*</span></label>
                            <div class="col-sm-8">
                                <input type="text" class="form-control" style="width:150px;" data-rule-required="true"
                                       data-msg-required="请填写购票人姓名" id="goupiaorenxingming" name="goupiaorenxingming"
                                       value="${Info.html(mmm.goupiaorenxingming)}"/></div>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="row">
                            <label style="width: 120px;min-height:18px;text-align: right" class="col-sm-2">手机<span
                                    style="color: red;">*</span></label>
                            <div class="col-sm-8">
                                <input type="text" class="form-control" style="width:150px;" data-rule-required="true"
                                       data-msg-required="请填写手机" phone="true" data-msg-phone="请输入正确手机号码" id="shouji"
                                       name="shouji" value="${Info.html(mmm.shouji)}"/></div>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="row">
                            <label style="width: 120px;min-height:18px;text-align: right" class="col-sm-2">身份证号<span
                                    style="color: red;">*</span></label>
                            <div class="col-sm-8">
                                <input type="text" class="form-control" style="width:150px;" data-rule-required="true"
                                       data-msg-required="请填写身份证号" idcard="true" data-msg-email="请输入有效身份证号码"
                                       id="shenfenzhenghao" name="shenfenzhenghao"
                                       value="${Info.html(mmm.shenfenzhenghao)}"/></div>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="row">
                            <label style="width: 120px;min-height:18px;text-align: right" class="col-sm-2">购票人</label>
                            <div class="col-sm-8">
                                <input type="text" class="form-control" style="width:150px;" readonly="readonly"
                                       id="goupiaoren" name="goupiaoren" value="${mmm.goupiaoren}"/></div>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="row">
                            <label style="width: 120px;min-height:18px;text-align: right" class="col-sm-2"> </label>
                            <div class="col-sm-8">
                                <input name="id" value="${mmm.id}" type="hidden"/><input name="referer"
                                                                                         value="<%=request.getHeader("referer")%>"
                                                                                         type="hidden"/><input
                                    name="updtself" value="${updtself}" type="hidden"/>
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
