<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <!-- 避免IE使用兼容模式 -->
    <meta http-equiv="X-UA-Compatible" content="IE=edge, chrome=1">
    <meta name="renderer" content="webkit">
    <link type="text/css" href="../../static/public/css/font.css" rel="stylesheet"/>
    <link type="text/css" href="../../static/public/css/main.css" rel="stylesheet"/>
    <!-- TopJUI框架样式 -->
    <!--<link type="text/css" href="../../topjui/themes/default/topjui.core.min.css" rel="stylesheet">
    <link type="text/css" href="../../topjui/themes/default/topjui.blue.css" rel="stylesheet" id="dynamicTheme"/>-->
    <!-- FontAwesome字体图标 -->
    <link type="text/css" href="../../static/plugins/font-awesome/css/font-awesome.min.css" rel="stylesheet"/>
    <!-- layui框架样式 -->
    <link type="text/css" href="../../static/plugins/layui/css/layui.css" rel="stylesheet"/>
    <!-- jQuery相关引用 -->
    <script type="text/javascript" src="../../static/plugins/jquery/jquery.min.js"></script>
    <script type="text/javascript" src="../../static/plugins/jquery/jquery.cookie.js"></script>
    <!-- TopJUI框架配置 -->
    <script type="text/javascript" src="../../static/public/js/topjui.config.js"></script>
    <!-- TopJUI框架核心-->
    <script type="text/javascript" src="../../topjui/js/topjui.core.min.js"></script>
    <!-- TopJUI中文支持 -->
    <script type="text/javascript" src="../../topjui/js/locale/topjui.lang.zh_CN.js"></script>
    <!-- layui框架js -->
    <script src="../../static/plugins/layui/layui.js" charset="utf-8"></script>
    <style>
        body {
            margin: 10px;
        }

        blockquote p {
            padding: 5px;
        }

        .layui-table {
            margin-top: 0 !important;
        }

        .layui-elem-quote {
            margin-bottom: 0 !important;
        }

        .layui-table {
            margin-top: 0;
            border-left: 5px solid #e2e2e2 !important;
        }

        .title .icon-new1 {
            margin-left: 10px;
            color: #f00;
        }
    </style>
</head>
<body>
<div class="layui-container-fluid">
    <div class="panel_box row">
        <div class="panel col">
            <a href="javascript:;" data-url="page/message/message.html">
                <div class="panel_icon">
                    <i class="layui-icon" data-icon=""></i>
                </div>
                <div class="panel_word newMessage">
                    <span>5</span>
                    <cite>新消息</cite>
                </div>
            </a>
        </div>
        <div class="panel col">
            <a href="javascript:;" data-url="page/user/allUsers.html">
                <div class="panel_icon" style="background-color:#FF5722;">
                    <i class="iconfont icon-dongtaifensishu" data-icon="icon-dongtaifensishu"></i>
                </div>
                <div class="panel_word userAll">
                    <span>3</span>
                    <cite>新增人数</cite>
                </div>
            </a>
        </div>
        <div class="panel col">
            <a href="javascript:;" data-url="page/user/allUsers.html">
                <div class="panel_icon" style="background-color:#009688;">
                    <i class="layui-icon" data-icon=""></i>
                </div>
                <div class="panel_word userAll">
                    <span>3</span>
                    <cite>用户总数</cite>
                </div>
            </a>
        </div>
        <div class="panel col">
            <a href="javascript:;" data-url="page/img/images.html">
                <div class="panel_icon" style="background-color:#5FB878;">
                    <i class="layui-icon" data-icon=""></i>
                </div>
                <div class="panel_word imgAll">
                    <span>31</span>
                    <cite>图片总数</cite>
                </div>
            </a>
        </div>
        <div class="panel col">
            <a href="javascript:;" data-url="page/news/newsList.html">
                <div class="panel_icon" style="background-color:#F7B824;">
                    <i class="iconfont icon-wenben" data-icon="icon-wenben"></i>
                </div>
                <div class="panel_word waitNews">
                    <span>13</span>
                    <cite>待审核文章</cite>
                </div>
            </a>
        </div>
        <div class="panel col max_panel">
            <a href="javascript:;" data-url="page/news/newsList.html">
                <div class="panel_icon" style="background-color:#2F4056;">
                    <i class="iconfont icon-text" data-icon="icon-text"></i>
                </div>
                <div class="panel_word allNews">
                    <span>30</span>
                    <em>文章总数</em>
                    <cite>文章列表</cite>
                </div>
            </a>
        </div>
    </div>

    <div class="layui-row layui-col-space10">
        <div class="layui-col-md12">
            <blockquote class="layui-elem-quote explain">
                <p style="color: red;font-weight: bold;font-size: 16px;">
                    这是"仲园物业管理系统",使用SpringMVC+Spring+Mybatis+JSP+Mysql+Vsftp+Redis+EasyUI开发,了解更多请与本人联系!
                </p>
            </blockquote>
        </div>
        <div class="layui-col-md12">
            <blockquote class="layui-elem-quote explain">
                <p>
                   页面主体框架使用TopUI,功能页面框架使用EasyUI,致力于打造既美观实用又能快速开发的后台管理前端框架,使用SpringMVC来作为后台Web框架,
                   使用MySQL关系数据库来存储数据,使用Mybatis来作为持久化框架,JSP来作为页面,vsftp服务器作为文件管理服务器,使用Redis数据库作为缓存数据库.
                </p>
                <p>
        "仲园物业管理系统"是一款专注于高校物业业务的电子管理系统,物业管理系统是一种将计算机网络和现代化物业管理相结合的一个管理系统，
		使用计算机的强大的处理能力处理各种信息，通过互联网来传递处理的信息，使管理做到有序的实时管理.
                </p>
                <p>
                    <span style="font-weight: bold;">下载系统：</span><a href="#"
                                                                    target="_blank"
                                                                    onclick="_hmt.push(['_trackEvent', '门户', '点击', '系统下载'])">http://www.888888.com/download.html</a>
                    <span style="font-weight: bold;">动态演示：</span><a href="#" target="_blank"
                                                                    onclick="_hmt.push(['_trackEvent', '门户', '点击', '演示'])">http://demo.88888.cn/login</a>
                    <a href="#" target="_blank"
                            onclick="_hmt.push(['_trackEvent', '门户', '点击', '介绍'])">查看详细介绍</a>
                </p>
                <p>
                    <span style="font-weight: bold;">联系我们：</span>
                    <i class="fa fa-qq"></i> 8888888888
                    <i class="fa fa-fax"></i> 0888-8888888
                    <i class="fa fa fa-envelope"></i> 8888888@888.com
                    <a target=blank href=tencent://message/?Menu=yes>
                        <img border="0" src="../../static/image/button_old_11.gif" alt="点击这里给我发消息">
                    </a>
                </p>
            </blockquote>
        </div>
    </div>

    <div class="layui-row layui-col-space10">
        <div class="layui-col-md4">
            <blockquote class="layui-elem-quote title">最新文章<i class="iconfont icon-new1"></i></blockquote>
            <table class="layui-table" lay-skin="line">
                <colgroup>
                    <col>
                    <col width="110">
                </colgroup>
                <tbody class="hot_news">
                <tr>
                    <td align="left">
                        <a href="javascript:window.parent.addParentTab({href:'./html/article/detail.html',title:'仲恺高校物业管理系统成功上线'})">仲恺高校物业管理系统成功上线...</a>
                    </td>
                </tr>
                <tr>
                    <td align="left">
                        <a href="javascript:window.parent.addParentTab({href:'./html/article/detail.html',title:'仲园物管系统评为十大杰出应用系统'})">仲园物管系统评为十大杰出应用系统...</a>
                    </td>
                </tr>
                <tr>
                    <td align="left">
                        <a href="javascript:window.parent.addParentTab({href:'./html/article/detail.html',title:'仲园物管系统使用了Vsftp服务器'})">仲园物管系统使用了Vsftp服务器...</a>
                    </td>
                </tr>
                <tr>
                    <td align="left">
                        <a href="javascript:window.parent.addParentTab({href:'./html/article/detail.html',title:'仲园物管系统使用了SpringSecurity'})">仲园物管系统使用了SpringSecurity...</a>
                    </td>
                </tr>
                <tr>
                    <td align="left">
                        <a href="javascript:window.parent.addParentTab({href:'./html/article/detail.html',title:'仲园物管系统使用了Redis缓存'})">仲园物管系统使用了Redis缓存...</a>
                    </td>
                </tr>
                </tbody>
            </table>
        </div>
        <div class="layui-col-md4">
            <blockquote class="layui-elem-quote title">热门文章<i class="iconfont icon-new1"></i></blockquote>
            <table class="layui-table" lay-skin="line">
                <colgroup>
                    <col>
                    <col width="110">
                </colgroup>
                <tbody class="hot_news">
                <tr>
                    <td align="left">
                        <a href="javascript:window.parent.addParentTab({href:'./html/article/detail.html',title:'仲园物管系统的开发技术'})">仲园物管系统的所用的开发技术...</a>
                    </td>
                </tr>
                <tr>
                    <td align="left">
                        <a href="javascript:window.parent.addParentTab({href:'./html/article/detail.html',title:'仲园物管系统开发人员的秘密'})">震惊:仲园物管系统开发人员鲜为人知的秘密...</a>
                    </td>
                </tr>
                <tr>
                    <td align="left">
                        <a href="javascript:window.parent.addParentTab({href:'./html/article/detail.html',title:'用了仲园物管系统,仲恺变得更好了'})">用了仲园物管系统,仲恺变得更好了...</a>
                    </td>
                </tr>
                <tr>
                    <td align="left">
                        <a href="javascript:window.parent.addParentTab({href:'./html/article/detail.html',title:'仲园物管系统解放了物管工作人员'})">仲园物管系统解放了物管工作人员...</a>
                    </td>
                </tr>
                <tr>
                    <td align="left">
                        <a href="javascript:window.parent.addParentTab({href:'./html/article/detail.html',title:'仲园物管系统使世界更加美好'})">仲园物管系统使世界更加美好...</a>
                    </td>
                </tr>
                </tbody>
            </table>
        </div>
        <div class="layui-col-md4">
            <blockquote class="layui-elem-quote title">通知公告</blockquote>
            <table class="layui-table" lay-skin="line">
                <colgroup>
                    <col>
                    <col width="110">
                </colgroup>
                <tbody class="hot_news">
                <tr>
                    <td align="left">
                        <a href="javascript:window.parent.addParentTab({href:'./html/article/detail.html',title:'校园网停网公告'})">校园网停网公告:于XXXX.XX.XX停网全日,带来不便敬请原谅...</a>
                    </td>
                </tr>
                <tr>
                    <td align="left">
                        <a href="javascript:window.parent.addParentTab({href:'./html/article/detail.html',title:'白云校区停水公告'})">白云校区停水公告:于XXXX.XX.XX停水全日,带来不便敬请原谅...</a>
                    </td>
                </tr>
                <tr>
                    <td align="left">
                        <a href="javascript:window.parent.addParentTab({href:'./html/article/detail.html',title:'海珠校区停电公告'})">海珠校区停水公告:于XXXX.XX.XX停电全日,带来不便敬请原谅...</a>
                    </td>
                </tr>
                <tr>
                    <td align="left">
                        <a href="javascript:window.parent.addParentTab({href:'./html/article/detail.html',title:'关于停放共享单车'})">从XXXX.XX.XX起,禁止校园内停放共享单车...</a>
                    </td>
                </tr>
                <tr>
                    <td align="left">
                        <a href="javascript:window.parent.addParentTab({href:'./html/article/detail.html',title:'出入登记'})">学校规定,带非本校人员进校必须进行身份证登记...</a>
                    </td>
                </tr>
                </tbody>
            </table>
        </div>
    </div>

    <div class="layui-row layui-col-space10">
        <div class="layui-col-md4">
            <blockquote class="layui-elem-quote title">常见问题</blockquote>
            <table class="layui-table" lay-skin="line">
                <colgroup>
                    <col>
                    <col width="110">
                </colgroup>
                <tbody class="hot_news">
                <tr>
                    <td align="left">
                        <a href="javascript:window.parent.addParentTab({href:'http://www.topjui.com/document/question/fullscreen.html',title:'系统首页问题'})">系统中首页初始化为什么有时不能全屏？</a>
                    </td>
                </tr>
                <tr>
                    <td align="left">
                        <a href="javascript:window.parent.addParentTab({href:'http://www.topjui.com/document/question/fullscreen.html',title:'个人文件导出问题'})">个人文件不能导出Excel？</a>
                    </td>
                </tr>
                <tr>
                    <td align="left">
                        <a href="javascript:window.parent.addParentTab({href:'http://www.topjui.com/document/question/fullscreen.html',title:'上传头像没有反应'})">上传头像后,没有反应,不知是否上传成功？</a>
                    </td>
                </tr>
                <tr>
                    <td align="left">
                        <a href="javascript:window.parent.addParentTab({href:'http://www.topjui.com/document/question/fullscreen.html',title:'教室预约问题'})">教室预约出现预约失败,能否人工预约？</a>
                    </td>
                </tr>
                <tr>
                    <td align="left">
                        <a href="javascript:window.parent.addParentTab({href:'http://www.topjui.com/document/question/fullscreen.html',title:'宿舍管理,不能查看个人详细信息'})">宿舍管理,不能查看个人详细信息？</a>
                    </td>
                </tr>
                </tbody>
            </table>
        </div>
        <div class="layui-col-md4">
            <blockquote class="layui-elem-quote title">系统特性</blockquote>
            <table class="layui-table" lay-skin="line">
                <colgroup>
                    <col>
                    <col width="110">
                </colgroup>
                <tbody class="hot_news">
                <tr>
                    <td align="left">
                        <a href="javascript:window.parent.addParentTab({href:'./html/article/detail.html',title:'自动化管理'})">实现了电子计算机的自动化管理...</a>
                    </td>
                </tr>
                <tr>
                    <td align="left">
                        <a href="javascript:window.parent.addParentTab({href:'./html/article/detail.html',title:'文件管理,方便又快捷'})">文件管理,方便又快捷...</a>
                    </td>
                </tr>
                <tr>
                    <td align="left">
                        <a href="javascript:window.parent.addParentTab({href:'./html/article/detail.html',title:'缓存策略'})">使用了缓存策略,减轻了服务器的压力...</a>
                    </td>
                </tr>
                <tr>
                    <td align="left">
                        <a href="javascript:window.parent.addParentTab({href:'./html/article/detail.html',title:'局部加载'})">使用ajax局部加载信息,缩短了服务器的相应时间...</a>
                    </td>
                </tr>
                <tr>
                    <td align="left">
                        <a href="javascript:window.parent.addParentTab({href:'./html/article/detail.html',title:'系统安全'})">使用了url级别的拦截和局部视图渲染,增强系统安全...</a>
                    </td>
                </tr>
                </tbody>
            </table>
        </div>
        <div class="layui-col-md4">
            <blockquote class="layui-elem-quote title">公司新闻</blockquote>
            <table class="layui-table" lay-skin="line">
                <colgroup>
                    <col>
                    <col width="110">
                </colgroup>
                <tbody class="hot_news">
                <tr>
                    <td align="left">
                        <a href="javascript:window.parent.addParentTab({href:'./html/article/detail.html',title:'仲园物管系统公司上市'})">仲园物业管理系统技术有限公司正式上市...</a>
                    </td>
                </tr>
                <tr>
                    <td align="left">
                        <a href="javascript:window.parent.addParentTab({href:'./html/article/detail.html',title:'仲园物业管理系统有限公司更名'})">仲园物业管理系统技术有限公司更名为仲园物业管理系统股份有限公司</a>
                    </td>
                </tr>
                <tr>
                    <td align="left">
                        <a href="javascript:window.parent.addParentTab({href:'./html/article/detail.html',title:'仲园物业管理系统更新'})">仲园物业管理系统更新公告...</a>
                    </td>
                </tr>
                <tr>
                    <td align="left">
                        <a href="javascript:window.parent.addParentTab({href:'./html/article/detail.html',title:'仲园系统管理公司融资'})">仲园物业管理系统股份有限公司融资2亿成功...</a>
                    </td>
                </tr>
                <tr>
                    <td align="left">
                        <a href="javascript:window.parent.addParentTab({href:'./html/article/detail.html',title:'仲园物管系统公司CEO评选十大杰出青年'})">仲园物管系统公司CEO评选十大杰出青年...</a>
                    </td>
                </tr>
                </tbody>
            </table>
        </div>
    </div>

</div>
</body>
</html>