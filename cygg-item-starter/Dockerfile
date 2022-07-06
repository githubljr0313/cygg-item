##FROM命令用于指定Docker基础镜像，如是从java8镜像开始
FROM java:8
##MAINTAINER命令用于说明谁在维护这个Dockerfile文件
MAINTAINER 17616232565@163.com
##ENV命令是在Docker镜像中设置环境变量，此环境变量可用于CMD命令在Docker镜像内部启动应用程序
ENV TZ=Asia/Shanghai
##RUN可以在Docker镜像中执行命令行指令，执行时机是Docker镜像构建过程中，
##所以RUN命令只会执行一次。RUN命令可用于在Docker镜像中安装应用程序、
##提取文件或其他命令行功能，这些操作只需要执行一次，以供Docker镜像后续使用

RUN mkdir -p /app/project
##WORKDIR命令指明了Docker镜像中的工作目录，工作目录将对WORKDIR指令之后的所有命令生效
WORKDIR /app/project
##EXPOSE命令将对外开放Docker容器中的网络端口
EXPOSE 8081
##ADD命令可以复制并提取JAR文件到Docker镜像中
ADD ./target/cygg-item-runtime.jar /app/project/
##ENTRYPOINT命令为从该Docker镜像启动Docker容器提供入口点，入口点是Docker容器启动时执行的应用程序或命令，如下是执行java命令启动jar
ENTRYPOINT ["java", "-jar", "cygg-item-runtime.jar"]