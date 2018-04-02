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
                    这是TopJUI免费版静态演示，免费版功能组件不完整，不提供软件升级及技术支持服务，商用软件请使用全功能授权版，了解授权版更多组件功能请与我们联系。
                </p>
            </blockquote>
        </div>
        <div class="layui-col-md12">
            <blockquote class="layui-elem-quote explain">
                <p>
                    致力于打造既美观实用又能快速开发的后台管理前端框架，解决传统EasyUI的性能和功能问题！
                    纯HTML调用功能组件，不用写JS代码的EasyUI，专注你的后端业务开发！
                </p>
                <p>
                    基于成熟稳定的EasyUI框架开发，集丰富组件+强大功能+优异性能+精美界面+便捷开发于一身，适用于企业级信息管理系统或Web后台管理系统
                </p>
                <p>
                    <span style="font-weight: bold;">下载TopJUI：</span><a href="http://www.topjui.com/download.html"
                                                                    target="_blank"
                                                                    onclick="_hmt.push(['_trackEvent', '门户', '点击', 'TopJUI下载'])">http://www.topjui.com/download.html</a>
                    <span style="font-weight: bold;">动态演示：</span><a href="http://demo.ewsd.cn/login" target="_blank"
                                                                    onclick="_hmt.push(['_trackEvent', '门户', '点击', 'EMIS演示'])">http://demo.ewsd.cn/login</a>（整合JAVA
                    SSHM，<a href="http://www.ewsd.cn/emis.html" target="_blank"
                            onclick="_hmt.push(['_trackEvent', '门户', '点击', 'EMIS介绍'])">查看详细介绍</a>）

                </p>
                <p>
                    <span style="font-weight: bold;">联系我们：</span>
                    <i class="fa fa-qq"></i> 251122361
                    <i class="fa fa-fax"></i> 0755-33942020
                    <i class="fa fa fa-envelope"></i> service@ewsd.cn
                    <a target=blank href=tencent://message/?uin=251122361&Site=TopJUI前端框架&Menu=yes>
                        <img border="0" SRC=http://wpa.qq.com/pa?p=1:251122361:1 alt="点击这里给我发消息">
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
                        <a href="javascript:window.parent.addParentTab({href:'./html/article/detail.html',title:'强化党内监督是全面从严治党重要保障'})">强化党内监督是全面从严治党重要保障</a>
                    </td>
                </tr>
                <tr>
                    <td align="left">
                        <a href="javascript:window.parent.addParentTab({href:'./html/article/detail.html',title:'李克强：地方和部门主要负责同志要带头...'})">李克强：地方和部门主要负责同志要带头...</a>
                    </td>
                </tr>
                <tr>
                    <td align="left">
                        <a href="javascript:window.parent.addParentTab({href:'./html/article/detail.html',title:'李克强：政务公开是常态不公开是例外'})">李克强：政务公开是常态不公开是例外</a>
                    </td>
                </tr>
                <tr>
                    <td align="left">
                        <a href="javascript:window.parent.addParentTab({href:'./html/article/detail.html',title:'军委机关将总体实行“部—局—处”三级体制'})">军委机关将总体实行“部—局—处”三级体制</a>
                    </td>
                </tr>
                <tr>
                    <td align="left">
                        <a href="javascript:window.parent.addParentTab({href:'./html/article/detail.html',title:'蔡奇就任北京代市长 王安顺因工作调动请辞'})">蔡奇就任北京代市长王安顺因工作调动请辞</a>
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
                        <a href="javascript:window.parent.addParentTab({href:'./html/article/detail.html',title:'强化党内监督是全面从严治党重要保障'})">强化党内监督是全面从严治党重要保障</a>
                    </td>
                </tr>
                <tr>
                    <td align="left">
                        <a href="javascript:window.parent.addParentTab({href:'./html/article/detail.html',title:'李克强：地方和部门主要负责同志要带头...'})">李克强：地方和部门主要负责同志要带头...</a>
                    </td>
                </tr>
                <tr>
                    <td align="left">
                        <a href="javascript:window.parent.addParentTab({href:'./html/article/detail.html',title:'李克强：政务公开是常态不公开是例外'})">李克强：政务公开是常态不公开是例外</a>
                    </td>
                </tr>
                <tr>
                    <td align="left">
                        <a href="javascript:window.parent.addParentTab({href:'./html/article/detail.html',title:'军委机关将总体实行“部—局—处”三级体制'})">军委机关将总体实行“部—局—处”三级体制</a>
                    </td>
                </tr>
                <tr>
                    <td align="left">
                        <a href="javascript:window.parent.addParentTab({href:'./html/article/detail.html',title:'蔡奇就任北京代市长 王安顺因工作调动请辞'})">蔡奇就任北京代市长王安顺因工作调动请辞</a>
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
                        <a href="javascript:window.parent.addParentTab({href:'./html/article/detail.html',title:'强化党内监督是全面从严治党重要保障'})">强化党内监督是全面从严治党重要保障</a>
                    </td>
                </tr>
                <tr>
                    <td align="left">
                        <a href="javascript:window.parent.addParentTab({href:'./html/article/detail.html',title:'李克强：地方和部门主要负责同志要带头...'})">李克强：地方和部门主要负责同志要带头...</a>
                    </td>
                </tr>
                <tr>
                    <td align="left">
                        <a href="javascript:window.parent.addParentTab({href:'./html/article/detail.html',title:'李克强：政务公开是常态不公开是例外'})">李克强：政务公开是常态不公开是例外</a>
                    </td>
                </tr>
                <tr>
                    <td align="left">
                        <a href="javascript:window.parent.addParentTab({href:'./html/article/detail.html',title:'军委机关将总体实行“部—局—处”三级体制'})">军委机关将总体实行“部—局—处”三级体制</a>
                    </td>
                </tr>
                <tr>
                    <td align="left">
                        <a href="javascript:window.parent.addParentTab({href:'./html/article/detail.html',title:'蔡奇就任北京代市长 王安顺因工作调动请辞'})">蔡奇就任北京代市长王安顺因工作调动请辞</a>
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
                        <a href="javascript:window.parent.addParentTab({href:'http://www.topjui.com/document/question/fullscreen.html',title:'TopJUI前端框架'})">静态演示系统中首页初始化为什么有时不能全屏？</a>
                    </td>
                </tr>
                <tr>
                    <td align="left">
                        <a href="javascript:window.parent.addParentTab({href:'http://www.topjui.com/document/question/fullscreen.html',title:'TopJUI前端框架'})">静态演示系统中部分组件（如对话框）风格和整体风格不一致？</a>
                    </td>
                </tr>
                <tr>
                    <td align="left">
                        <a href="javascript:window.parent.addParentTab({href:'http://www.topjui.com/document/question/fullscreen.html',title:'TopJUI前端框架'})">静态演示系统中首页初始化为什么有时不能全屏？</a>
                    </td>
                </tr>
                <tr>
                    <td align="left">
                        <a href="javascript:window.parent.addParentTab({href:'http://www.topjui.com/document/question/fullscreen.html',title:'TopJUI前端框架'})">静态演示系统中部分组件（如对话框）风格和整体风格不一致？</a>
                    </td>
                </tr>
                <tr>
                    <td align="left">
                        <a href="javascript:window.parent.addParentTab({href:'http://www.topjui.com/document/question/fullscreen.html',title:'TopJUI前端框架'})">静态演示系统中部分组件（如对话框）风格和整体风格不一致？</a>
                    </td>
                </tr>
                </tbody>
            </table>
        </div>
        <div class="layui-col-md4">
            <blockquote class="layui-elem-quote title">客商管理</blockquote>
            <table class="layui-table" lay-skin="line">
                <colgroup>
                    <col>
                    <col width="110">
                </colgroup>
                <tbody class="hot_news">
                <tr>
                    <td align="left">
                        <a href="javascript:window.parent.addParentTab({href:'./html/article/detail.html',title:'强化党内监督是全面从严治党重要保障'})">强化党内监督是全面从严治党重要保障</a>
                    </td>
                </tr>
                <tr>
                    <td align="left">
                        <a href="javascript:window.parent.addParentTab({href:'./html/article/detail.html',title:'李克强：地方和部门主要负责同志要带头...'})">李克强：地方和部门主要负责同志要带头...</a>
                    </td>
                </tr>
                <tr>
                    <td align="left">
                        <a href="javascript:window.parent.addParentTab({href:'./html/article/detail.html',title:'李克强：政务公开是常态不公开是例外'})">李克强：政务公开是常态不公开是例外</a>
                    </td>
                </tr>
                <tr>
                    <td align="left">
                        <a href="javascript:window.parent.addParentTab({href:'./html/article/detail.html',title:'军委机关将总体实行“部—局—处”三级体制'})">军委机关将总体实行“部—局—处”三级体制</a>
                    </td>
                </tr>
                <tr>
                    <td align="left">
                        <a href="javascript:window.parent.addParentTab({href:'./html/article/detail.html',title:'蔡奇就任北京代市长 王安顺因工作调动请辞'})">蔡奇就任北京代市长王安顺因工作调动请辞</a>
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
                        <a href="javascript:window.parent.addParentTab({href:'./html/article/detail.html',title:'强化党内监督是全面从严治党重要保障'})">强化党内监督是全面从严治党重要保障</a>
                    </td>
                </tr>
                <tr>
                    <td align="left">
                        <a href="javascript:window.parent.addParentTab({href:'./html/article/detail.html',title:'李克强：地方和部门主要负责同志要带头...'})">李克强：地方和部门主要负责同志要带头...</a>
                    </td>
                </tr>
                <tr>
                    <td align="left">
                        <a href="javascript:window.parent.addParentTab({href:'./html/article/detail.html',title:'李克强：政务公开是常态不公开是例外'})">李克强：政务公开是常态不公开是例外</a>
                    </td>
                </tr>
                <tr>
                    <td align="left">
                        <a href="javascript:window.parent.addParentTab({href:'./html/article/detail.html',title:'军委机关将总体实行“部—局—处”三级体制'})">军委机关将总体实行“部—局—处”三级体制</a>
                    </td>
                </tr>
                <tr>
                    <td align="left">
                        <a href="javascript:window.parent.addParentTab({href:'./html/article/detail.html',title:'蔡奇就任北京代市长 王安顺因工作调动请辞'})">蔡奇就任北京代市长王安顺因工作调动请辞</a>
                    </td>
                </tr>
                </tbody>
            </table>
        </div>
    </div>

</div>
</body>
</html>