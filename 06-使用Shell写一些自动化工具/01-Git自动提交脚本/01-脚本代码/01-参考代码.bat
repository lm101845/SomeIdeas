@echo off #打开回显或关闭请求回显功能，off 可以改成 on。
@title bat execute git auto commit #运行时命令行窗口的 title
F:
cd D:/02-looking for job/00-Project/15-LearnWebpack5★/15-LearnWebpack5  #这里是要提交的项目目录，需要更改成自己的文件目录
git add .
git commit -m "Auto commit."
git push #git 命令
