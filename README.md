## ssm_framework
整合Spring、SpringMVC、Mybatis、MySQL、Redis、MEMCached等！

### 模块分层说明

> 最外层 [pom.xml](https://github.com/hyblogs/ssm_framework/blob/master/pom.xml) 按照maven继承的特征引入jar包进行管理，可在子模块单独继承使用。

#### main

> 此模块包含数据库对应实体及操作数据库的mapper接口及mapper.xml文件，集成了generator反向生成数据库对应实体文件及mapper相关文件，可直接在test测试包下面修改数据库连接地址及需要反向生成的数据库表信息，然后运行测试包下面的[com.ssm.generator.GeneratorMain.java](https://github.com/hyblogs/ssm_framework/blob/master/main/src/test/java/com/ssm/generator/GeneratorMain.java)

#### service

> 此模块包含Spring配置文件及业务处理的Biz及Service服务类，Biz主要用于业务处理逻辑并抛出异常信息，service主要用于业务之间调用及异常处理！  
> 主要配置文件[applicationContext.xml](https://github.com/hyblogs/ssm_framework/blob/master/service/src/main/resources/applicationContext.xml)集成了其他操作配置，如数据库操作配置application-datasource.xml、application-mybatis.xml等。  
> **数据库、缓存等链接地址按照不同的运行环境分环境存放，当前区分了三种运行环境，及：dev(开发环境)、test(测试环境)、prod(生产环境)，打包时可根据不同的环境打入不同的链接信息配置文件**  

> Build时可以根据所需环境进行打包，如：dev、test、prod三种运行环境，对应的环境有对应的不同的数据连接配置文件，根据不同环境打包即可；或者在pom.xml中对应环境节点下加入激活节点的配置信息，如：  

    <!-- 环境变量 -->
    <profiles>
        <!-- 开发环境 -->
        <profile>
            <id>dev</id>
            <properties>
                <env>dev</env>
            </properties>
            <activation>
                <activeByDefault>true</activeByDefault>
            </activation>
        </profile>

        <!-- 测试环境 -->
        <profile>
            <id>test</id>
            <properties>
                <env>test</env>
            </properties>
        </profile>

        <!-- 生产环境 -->
        <profile>
            <id>prod</id>
            <properties>
                <env>prod</env>
            </properties>
        </profile>
    </profiles>
    
#### web

> 此模块包含了对页面的操作，主要有web.xml的配置及MVC的配置信息  

### 运行条件
> JDK1.8以上  
> 需安装MySQL、Redis、MemCached等环境！  
> 同时需要修改项目中的配置文件指向地址为自己的地址后方可直接运行！  
