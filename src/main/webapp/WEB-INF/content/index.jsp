<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
<title>文件加密与解密</title>
<!-- 收藏用logo图标 -->
<link rel="bookmark" type="image/x-icon" href="img/log128.ico" />
<!-- 网站显示页logo图标 -->
<link rel="shortcut icon" href="img/log128.ico">
<!-- Bootstrap -->
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">

<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
      <script src="https://cdn.bootcss.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
<style type="text/css">
.labelBox {
	min-height: 200px;
}

.progress {
	margin-top: 120px;
}
</style>
</head>
<body>
	<div class="container-fluid">
		<div class="row">
			<div class="col-md-12">
				<nav class="navbar navbar-default" role="navigation">
					<div class="navbar-header">

						<button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
							<span class="sr-only">Toggle navigation</span><span class="icon-bar"></span><span class="icon-bar"></span><span
								class="icon-bar"></span>
						</button>
						<a class="navbar-brand" href="#" style="padding: 0px 0px;">
							<img alt="Brand" src="img/log128.ico" height="50px">
						</a>
					</div>

					<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
						<ul class="nav navbar-nav">
							<li class="active"><a href="#">首页</a></li>

						</ul>

					</div>

				</nav>
				<div class="row">
					<div class="col-md-4">
						<div class="row">
							<div class="col-md-12 labelBox">
								<span class="label label-info">上传了什么</span>
								<div class="progress">
									<div class="progress-bar progress-bar-warning progress-bar-striped active" role="progressbar"
										aria-valuenow="20" aria-valuemin="0" aria-valuemax="100" style="width: 20%">
										<span class="sr-only">20% Complete</span>
									</div>
								</div>
							</div>
						</div>
						<button type="button" class="btn btn-primary btn-block btn-default">上传</button>
					</div>
					<div class="col-md-4">
						<div class="row">
							<div class="col-md-12 labelBox">
								<span class="label label-info">解密情况</span>
								<div class="progress">
									<div class="progress-bar progress-bar-warning progress-bar-striped active" role="progressbar"
										aria-valuenow="20" aria-valuemin="0" aria-valuemax="100" style="width: 20%">
										<span class="sr-only">20% Complete</span>
									</div>
								</div>
							</div>
						</div>
						<button type="button" class="btn btn-success btn-block">解密下载</button>
					</div>
					<div class="col-md-4">
						<div class="row">
							<div class="col-md-12 labelBox">
								<span class="label label-info">加密情况</span>
								<div class="progress">
									<div class="progress-bar progress-bar-warning progress-bar-striped active" role="progressbar"
										aria-valuenow="20" aria-valuemin="0" aria-valuemax="100" style="width: 20%">
										<span class="sr-only">20% Complete</span>
									</div>
								</div>
							</div>
						</div>
						<button type="button" class="btn btn-danger btn-block">加密下载</button>
					</div>
				</div>
			</div>
		</div>
	</div>

	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script src="bootstrap/js/jquery.min.js"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script src="bootstrap/js/bootstrap.min.js"></script>
</body>
</html>