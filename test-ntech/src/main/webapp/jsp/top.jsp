<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href= "css/common.css">
<title>TOPページ</title>
</head>
<body>


<ul class="midashi">
  <li>
    <div class="widgettitle">
      <strong>ようこそ　<%= request.getAttribute("mailaddress") %>　さん</strong>
    </div>
  </li>
</ul>
<ul style="font-size:20px;">
  <li class="widget_post_list clearfix">
    <a href="https://nakayama-tech.com/2024/02/17/vmware-centos-construction/">VMWare Workstation Player×CentOSで自PCに仮想環境を構築する</a>
  </li><br>
  <li class="widget_post_list clearfix" >
    <a href="https://nakayama-tech.com/2024/02/17/vmware-centos-ssh-terminal/">VMWare × CentOSの環境にSSH通信する</a>
  </li><br>
  <li class="widget_post_list clearfix" >
    <a href="https://nakayama-tech.com/2024/02/18/centos-postgresql-15/">CentOSにPostgreSQL(15)をインストールする</a>
  </li><br>
  <li class="widget_post_list clearfix" >
    <a href="https://nakayama-tech.com/2024/02/19/pgpool-construction/">pgpoolでPostgreSQLをレプリケーション＆フェイルオーバー</a>
  </li><br>
  <li class="widget_post_list clearfix" >
    <a href="https://nakayama-tech.com/2024/02/20/vmware-process-cant-access/">VMWareを立ち上げたら別のプロセス使用中エラーが出た</a>
  </li><br>
  <li class="widget_post_list clearfix" >
    <a href="https://nakayama-tech.com/2024/02/21/nginx-digest-auth/">NginxにDigest認証を組み込む方法</a>
  </li><br>
  <li class="widget_post_list clearfix" >
    <a href="https://nakayama-tech.com/2024/02/22/nginx-tomcat-keepalived/">NginxをKeepAliveで冗長化＆Tomcatへロードバランス</a>
  </li>
</ul><br>
<img src="https://nakayama-tech.com/wp-content/uploads/2023/12/a8net-koukokuyou-neko4.jpg" width="300px" style="padding-left:30px;margin-bottom:0;left:0;"><br>

<div id="benkyoStudyPC" class="pc" style="padding-left:30px;width:80%;font-size:16px;color:red;font-weight:bold;font-family: 'メイリオ', 'Meiryo', sans-serif;">
  <div style="width:500px;">
    <a href="https://px.a8.net/svt/ejp?a8mat=3NP4BC+BIZ5F6+45VU+BXYE9" rel="nofollow">
    <img border="0" width="300" height="250" alt="" src="https://www21.a8.net/svt/bgt?aid=221201688697&wid=001&eno=01&mid=s00000019425002006000&mc=1"><br>高単価フリーランス募集してます！</a>
    <img border="0" width="1" height="1" src="https://www10.a8.net/0.gif?a8mat=3NP4BC+BIZ5F6+45VU+BXYE9" alt="">
  </div>
</div>

</body>
</html>