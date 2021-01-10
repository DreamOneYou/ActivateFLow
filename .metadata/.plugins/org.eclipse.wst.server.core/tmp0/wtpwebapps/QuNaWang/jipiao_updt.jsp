<%@ page language="java" import="dao.*" pageEncoding="UTF-8" %>
<%@ page language="java" import="java.util.*" %>
<%@page import="util.Info" %>
<%@ taglib prefix="ssm" uri="http://ssm" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ include file="head.jsp" %>
<script src="js/jquery.validate.js"></script>
<script src="js/datepicker/WdatePicker.js"></script>

<div style="padding: 10px">
	
	<!-- 后台管理员编辑机票 -->
    <div class="container">
        <div class="panel panel-default">
            <div class="panel-heading">
                编辑机票:
            </div>
            <div class="panel-body">
                <form action="jipiaoupdate.do" method="post" name="form1" id="form1"><!-- form 标签开始 -->
                    <div class="form-group">
                        <div class="row">
                            <label style="width: 120px;min-height:18px;text-align: right" class="col-sm-2">票务编号</label>
                            <div class="col-sm-8">
                                <input type="text" class="form-control" style="width:150px;" readonly="readonly"
                                       id="piaowubianhao" name="piaowubianhao" value="${Info.html(mmm.piaowubianhao)}"/>
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="row">
                            <label style="width: 120px;min-height:18px;text-align: right" class="col-sm-2">航班名称<span
                                    style="color: red;">*</span></label>
                            <div class="col-sm-8">
                                <input type="text" class="form-control" style="width:250px;" data-rule-required="true"
                                       data-msg-required="请填写航班名称" id="hangbanmingcheng" name="hangbanmingcheng"
                                       value="${Info.html(mmm.hangbanmingcheng)}"/></div>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="row">
                            <label style="width: 120px;min-height:18px;text-align: right" class="col-sm-2">出发地<span
                                    style="color: red;">*</span></label>
                            <div class="col-sm-8">
                                <input type="text" class="form-control" style="width:150px;" data-rule-required="true"
                                       data-msg-required="请填写出发地" id="chufadi" name="chufadi"
                                       value="${Info.html(mmm.chufadi)}"/></div>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="row">
                            <label style="width: 120px;min-height:18px;text-align: right" class="col-sm-2">目的地<span
                                    style="color: red;">*</span></label>
                            <div class="col-sm-8">
                                <input type="text" class="form-control" style="width:150px;" data-rule-required="true"
                                       data-msg-required="请填写目的地" id="mudidi" name="mudidi"
                                       value="${Info.html(mmm.mudidi)}"/></div>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="row">
                            <label style="width: 120px;min-height:18px;text-align: right" class="col-sm-2">起飞时间<span
                                    style="color: red;">*</span></label>
                            <div class="col-sm-8">
                                <input type="text" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',lang:'zh-cn'})"
                                       style="width:120px;" data-rule-required="true" data-msg-required="请填写起飞时间"
                                       id="qifeishijian" name="qifeishijian" readonly="readonly"
                                       value="${Info.html(mmm.qifeishijian)}"/></div>
                        </div>
                    </div>

                    <div class="form-group">
                        <div class="row">
                            <label style="width: 120px;min-height:18px;text-align: right" class="col-sm-2">票价<span
                                    style="color: red;">*</span></label>
                            <div class="col-sm-8">
                                <input type="number" class="form-control" style="width:150px;" step="0.01"
                                       data-rule-required="true" data-msg-required="请填写票价" number="true"
                                       data-msg-number="输入一个有效数字" id="piaojia" name="piaojia"
                                       value="${Info.html(mmm.piaojia)}"/></div>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="row">
                            <label style="width: 120px;min-height:18px;text-align: right" class="col-sm-2">剩余座位<span
                                    style="color: red;">*</span></label>
                            <div class="col-sm-8">
                                <input type="number" class="form-control" style="width:150px;" data-rule-required="true"
                                       data-msg-required="请填写剩余座位" number="true" data-msg-number="输入一个有效数字"
                                       id="shengyuzuowei" name="shengyuzuowei" value="${Info.html(mmm.shengyuzuowei)}"/>
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="row">
                            <label style="width: 120px;min-height:18px;text-align: right" class="col-sm-2">登机口<span
                                    style="color: red;">*</span></label>
                            <div class="col-sm-8">
                                <input type="text" class="form-control" style="width:150px;" data-rule-required="true"
                                       data-msg-required="请填写登机口" id="dengjikou" name="dengjikou"
                                       value="${Info.html(mmm.dengjikou)}"/></div>
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
