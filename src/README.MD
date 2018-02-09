##嵌入使用Jetty方案

对于处理http请求，如果不是一个存粹的web工程，部署在tomcat，或者jetty 服务下有时候比较的麻烦
- 对于api restful请求，我们可以选择netty + http 协议的方式处理，这种场景仅仅适合处理几个简单的http接口,如果拥有大量接口，甚至包括页面的渲染，netty有些不太给力了，
- jetty 对于http接口的支持远远大于netty，毕竟jetty 的handler支持 servlet Handler，和平时配置web.xml一样，支持添加servlet，filter方式，比较方便

如果我们想要写一个简单的管理系统，但是又不想要搭建tomcat，或者jetty容器，而是直接使用脚本的方式启动，jetty 简直是不能再给力了
- jetty的web支持，打包方式支持两种，支持jar包和war包。
- war 包，不必多说，目录结构就是一个存粹的web程序，适合独立的轻量级的管理后台
- jar包，有些程序里面可能不是重依赖http协议，但是希望支持restful接口，也可能支持内嵌页面。渲染页面可能还是需要模板的，比如vm，jsp，但是目录结构又不是一个纯粹的web目录，可以使用这种方式。Elstic-job的管理系统就是使用这种方式，
可以很完美的和spring结合，毕竟spring mvc 只是一个servlet 如此而已，这样的话后期 写http接口或者页面,简直爽歪歪

##War Demo
这里仅仅实现了war包的方式，包括打包，start.sh，更加方便

##Jar Demo
jar包的方式更加简单，和平时使用一样，仅仅需要 java -cp .*:lib/ ${JVM} ${MAIN_CLASS} 即可

##结论

