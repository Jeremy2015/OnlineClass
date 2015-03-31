<!DOCTYPE HTML>
<html>
<head>
<title>课程视频观看</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link href="../resource/css/video-js.css" rel="stylesheet" type="text/css">
<script src="../resource/js/video.js"></script>
<script>
    videojs.options.flash.swf = "../resource/others/video-js.swf";
</script>
</head>
<body>
<div id="main">
	<video id="example_video_1" class="video-js vjs-default-skin" controls preload="none" width="640" height="264"
      poster="http://video-js.zencoder.com/oceans-clip.png"
      data-setup="{}">
    <source src="../resource/video/java/java_01.mp4" type='video/mp4' />
    <track kind="captions" src="../resource/others/demo.captions.vtt" srclang="en" label="English"></track><!-- Tracks need an ending tag thanks to IE9 -->
    <track kind="subtitles" src="../resource/others/demo.captions.vtt" srclang="en" label="English"></track><!-- Tracks need an ending tag thanks to IE9 -->
	</video>
</div>
</body>
</html>

