## 0、简介

### 1.功能需求：简单的`CRUD`

1. 分页 - 使用开源组件`PageHelper`
2. 数据校验
   - `Jquery`前端校验+`JSR303`后端校验
3. `ajax`进行前后端数据交互
4. `Rest`风格的`URL`;使用`HTTP`协议请求方法的动词，来表示对资源的操作[`GET`(查询)、`POST`(新增)、`PUT`(修改)、`DELETE`(删除)]

### 2.技术点

1. 基础框架 - `ssm`
2. 数据库 - `MySQL`
3. 前端框架 - `BootStrap`快速搭建简介美观的界面
4. 项目的依赖管理 - `Maven`
5. 分页 - `pagehelper`
6. **逆向工程 - `MyBatis Generator`(之前未学过)**

### 3.环境搭建

1. 创建一个`Maven`工程

2. 引入项目依赖的`jar`包

   - Spring

   - SpringMVC
   - SpringJDBC
   - Aspect -- 面向切面

   ```xml
   <!-- spring -->
   <!-- 切入点表达式 -->
   <dependency>
       <groupId>org.aspectj</groupId>
       <artifactId>aspectjweaver</artifactId>
       <version>1.6.8</version>
   </dependency>
   <!-- springAOP  AOP核心功能，例如代理工厂等 -->
   <dependency>
       <groupId>org.springframework</groupId>
       <artifactId>spring-aop</artifactId>
       <version>${spring.version}</version>
   </dependency>
   <!-- springIOC -->
   <dependency>
       <groupId>org.springframework</groupId>
       <artifactId>spring-context</artifactId>
       <version>${spring.version}</version>
   </dependency>
   <dependency>
       <groupId>org.springframework</groupId>
       <artifactId>spring-web</artifactId>
       <version>${spring.version}</version>
   </dependency>
   <dependency>
       <groupId>org.springframework</groupId>
       <artifactId>spring-webmvc</artifactId>
       <version>${spring.version}</version>
   </dependency>
   <!-- spring整合junit -->
   <dependency>
       <groupId>org.springframework</groupId>
       <artifactId>spring-test</artifactId>
       <version>${spring.version}</version>
   </dependency>
   <!-- 事务控制 -->
   <dependency>
       <groupId>org.springframework</groupId>
       <artifactId>spring-tx</artifactId>
       <version>${spring.version}</version>
   </dependency>
   <!-- SpringJDBC -->
   <dependency>
       <groupId>org.springframework</groupId>
       <artifactId>spring-jdbc</artifactId>
       <version>${spring.version}</version>
   </dependency>
   ```

   - Mybatis
   - Mybatis整合入Spring的适配包

   ```xml
   <!-- Mybatis -->
   <dependency>
       <groupId>org.mybatis</groupId>
       <artifactId>mybatis</artifactId>
       <version>${mybatis.version}</version>
   </dependency>
   <dependency>
       <groupId>org.mybatis</groupId>
       <artifactId>mybatis-spring</artifactId>
       <version>1.3.0</version>
   </dependency>
   ```

   - 数据库连接池-c3p0

   ```xml
   <!-- 数据库连接池 -->
   <dependency>
       <groupId>c3p0</groupId>
       <artifactId>c3p0</artifactId>
       <version>0.9.1.2</version>
       <type>jar</type>
       <scope>compile</scope>
   </dependency>
   ```

   - 数据库驱动

   ```xml
   <!-- mysql驱动 -->
   <dependency>
       <groupId>mysql</groupId>
       <artifactId>mysql-connector-java</artifactId>
       <version>${mysql.version}</version>
   </dependency>
   ```

   - 其他(jstl,junit,servlet,json,JSR303,MBG,pageHelper,log,junit)
   
   ```xml
   <!-- servlet、jsp、jstl表达式 -->
   <dependency>
       <groupId>javax.servlet</groupId>
       <artifactId>javax.servlet-api</artifactId>
       <version>3.0.1</version>
       <scope>provided</scope>
   </dependency>
   <dependency>
       <groupId>javax.servlet.jsp</groupId>
       <artifactId>jsp-api</artifactId>
       <version>2.0</version>
       <scope>provided</scope>
   </dependency>
   <dependency>
       <groupId>jstl</groupId>
       <artifactId>jstl</artifactId>
       <version>1.2</version>
   </dependency>
   
   <!-- log start -->
   <dependency>
       <groupId>log4j</groupId>
       <artifactId>log4j</artifactId>
       <version>${log4j.version}</version>
   </dependency>
   <dependency>
       <groupId>org.slf4j</groupId>
       <artifactId>slf4j-api</artifactId>
       <version>${slf4j.version}</version>
   </dependency>
   <dependency>
       <groupId>org.slf4j</groupId>
       <artifactId>slf4j-log4j12</artifactId>
       <version>${slf4j.version}</version>
   </dependency>
   <!-- log end -->
   
   <!--引入pageHelper分页插件 -->
   <dependency>
       <groupId>com.github.pagehelper</groupId>
       <artifactId>pagehelper</artifactId>
       <version>5.0.0</version>
   </dependency>
   
   <!-- MBG -->
   <!-- https://mvnrepository.com/artifact/org.mybatis.generator/mybatis-generator-core -->
   <dependency>
       <groupId>org.mybatis.generator</groupId>
       <artifactId>mybatis-generator-core</artifactId>
       <version>1.3.5</version>
   </dependency>
   
   <!--JSR303数据校验支持；tomcat7及以上的服务器，
     tomcat7以下的服务器：el表达式。额外给服务器的lib包中替换新的标准的el
     -->
   <!-- https://mvnrepository.com/artifact/org.hibernate/hibernate-validator -->
   <dependency>
       <groupId>org.hibernate</groupId>
       <artifactId>hibernate-validator</artifactId>
       <version>5.4.1.Final</version>
   </dependency>
   
   <!-- 对json处理的包，即能够使用@ResponseBody -->
   <dependency>
       <groupId>com.fasterxml.jackson.core</groupId>
       <artifactId>jackson-databind</artifactId>
       <version>2.9.0</version>
   </dependency>
   <dependency>
       <groupId>com.fasterxml.jackson.core</groupId>
       <artifactId>jackson-core</artifactId>
       <version>2.9.0</version>
   </dependency>
   <dependency>
       <groupId>com.fasterxml.jackson.core</groupId>
       <artifactId>jackson-annotations</artifactId>
       <version>2.9.0</version>
   </dependency>
   ```

3. 引入`BootStrap`前端框架

   - 引入样式

     在`webapp`下创建`static`静态文件夹，将下载好的样式放入此文件夹。

   - 引入`Jquery`

   ```javascript
   <link href="${APP_PATH}/static/bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet">
   <!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
       <script src="${APP_PATH}/static/js/jquery-1.12.4.min.js"></script>
       <!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
       <script src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js"></script> 
   ```

4. 编写`ssm`整合的关键配置文件

   - `web.xml` - `SpringMVC`相关
- 需要配置加载`Spring`的配置文件，故需配置监听器。
     - 配置`SpringMVC`的前端控制器，以及`SpringMVC`的配置文件
     - 过滤器，字符编码过滤器，一定能要放在其他过滤器之前。
     - 使用`Rest`风格`URI`，配置`filter`，将页面普通的`post`请求转为指定的`delete`或者`put`请求。
       - 配置`HiddenHttpMethodFilter`
     


```xml
<!DOCTYPE web-app PUBLIC
           "-//Sun Microsystems, Inc.//DTD Web Application 2.3//EN"
        "http://java.sun.com/dtd/web-app_2_3.dtd" >
<web-app>
    <display-name>Archetype Created Web Application</display-name><!DOCTYPE web-app PUBLIC
           "-//Sun Microsystems, Inc.//DTD Web Application 2.3//EN"
        "http://java.sun.com/dtd/web-app_2_3.dtd" >
    <web-app>
        <display-name>Archetype Created Web Application</display-name>
        <!-- 配置前端控制器：服务器启动必须加载，需要加载springmvc.xml配置文件 -->
        <servlet>
            <servlet-name>dispatcherServlet</servlet-name>
            <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
            <!-- 配置初始化参数，创建完DispatcherServlet对象，加载springmvc.xml配置文件 -->
            <init-param>
                <param-name>contextConfigLocation</param-name>
                <param-value>classpath:springmvc.xml</param-value>
            </init-param> <!-- 服务器启动的时候，让DispatcherServlet对象创建 -->
            <load-on-startup>1</load-on-startup>
        </servlet>
        <servlet-mapping>
            <servlet-name>dispatcherServlet</servlet-name>
            <url-pattern>/</url-pattern>
        </servlet-mapping>

        <!-- 配置解决中文乱码的过滤器 -->
        <filter>
            <filter-name>characterEncodingFilter</filter-name>
            <filter-class>org.springframework.web.filter.CharacterEncodingFilter</filter-class>
            <init-param>
                <param-name>encoding</param-name>
                <param-value>UTF-8</param-value>
            </init-param>
            <init-param>
                <param-name>forceEncoding</param-name>
                <param-value>true</param-value>
            </init-param>
        </filter>
        <filter-mapping>
            <filter-name>characterEncodingFilter</filter-name>
            <url-pattern>/*</url-pattern>
        </filter-mapping>

        <!-- 配置Spring的监听器 -->
        <listener>
            <listener-class>org.springframework.web.context.ContextLoaderListener</listener-class>
        </listener>
        <!-- 配置加载类路径的配置文件 -->
        <context-param>
            <param-name>contextConfigLocation</param-name>
            <param-value>classpath:applicationContext.xml</param-value>
        </context-param>

        <!-- 4、使用Rest风格的URI，将页面普通的post请求转为指定的delete或者put请求 -->
        <filter>
            <filter-name>HiddenHttpMethodFilter</filter-name>
            <filter-class>org.springframework.web.filter.HiddenHttpMethodFilter</filter-class>
        </filter>
        <filter-mapping>
            <filter-name>HiddenHttpMethodFilter</filter-name>
            <url-pattern>/*</url-pattern>
        </filter-mapping>
        <filter>
            <filter-name>HttpPutFormContentFilter</filter-name>
            <filter-class>org.springframework.web.filter.HttpPutFormContentFilter</filter-class>
        </filter>
        <filter-mapping>
            <filter-name>HttpPutFormContentFilter</filter-name>
            <url-pattern>/*</url-pattern>
        </filter-mapping>
    </web-app>
```

在启动`tomcat`服务器时，需要借助`web.xml`将`Spring`等相关配置文件进行加载。即类路径下的配置文件需要配置在`web.xml`中。

- `SpringMVC` -- 包含网站跳转逻辑的控制，配置
  
  - 开启扫描，只扫描控制器
  
     ```xml
     <!--SpringMVC的配置文件，包含网站跳转逻辑的控制，配置  -->
     <context:component-scan base-package="cn.lizhi" use-default-filters="false">
         <!--只扫描控制器 -->
         <context:include-filter type="annotation" expression="org.springframework.stereotype.Controller"/>
     </context:component-scan>
     ```

- 配置视图解析器，方便页面返回

 ```xml
<!--配置视图解析器，方便页面返回  -->
<bean> class="org.springframework.web.servlet.view.InternalResourceViewResolver">
    <property name="prefix" value="/WEB-INF/views/"></property>
    <property name="suffix" value=".jsp"></property>
</bean>
 ```

 - 两个标准配置

   - 将`springMVC`不能处理的请求交给`tomcat`

     ```xml
    <mvc:default-servlet-handler/>
     ```

   - 能支持`springMVC`更高级的一些功能，`JSR303`校验，快捷的`ajax`...注解支持开启，自动开启`SpringMVC`两大组件

     ```xml
    <mvc:annotation-driven/>
     ```

   - `Spring` -- 数据源、事务控制

     - 数据源
       
       - 数据源的配置文件，引入配置文件

         ```xml
     <!-- 引入数据源配置文件 -->
         <context:property-placeholder location="classpath:dbconfig.propertiese"/>
         <!-- 数据源配置 -->
         <bean id="pooledDataSource" class="com.mchange.v2.c3p0.ComboPooledDataSource">
             <property name="jdbcUrl" value="${jdbc.jdbcUrl}"></property>
             <property name="driverClass" value="${jdbc.driverClass}"></property>
             <property name="user" value="${jdbc.user}"></property>
             <property name="password" value="${jdbc.password}"></property>
         </bean>
         ```

     - 开启注解扫描 - 除了控制器外，其它的都包含在内。(即将控制器排除在外)

       ```xml
       <!-- 注解扫描，不扫描controller层，controller层交给SpringMVC进行管理 -->
       <context:component-scan base-package="cn.lizhi">
           <context:exclude-filter type="annotation" expression="org.springframework.stereotype.Controller" />
       </context:component-scan>
       ```
       
     - 配置同`Mybatis`的整合

       - 配置工厂类

         - 指定`Mybatis`全局配置文件

           ```xml
           <property name="configLocation" value="classpath:mybatis-config.xml"/>
           ```

         - 配置数据源 - 与`Spring`相同

         - 指定`Mybatis`，`mapper`文件的位置。即`resources`文件夹下创建`mapper`文件夹，用于存放`mapper`相关文件。

           ```xml
           <property name="mapperLocations" value="classpath:mapper/*.xml">
           ```

         - 整合以上三步

           ```xml
           <bean id="sqlSessionFactory" class="org.mybatis.spring.SqlSessionFactoryBean">
               <!-- 指定mybatis全局配置文件的位置 -->
               <property name="configLocation" value="classpath:mybatis-config.xml"></property>
               <property name="dataSource" ref="pooledDataSource"></property>
               <!-- 指定mybatis，mapper文件的位置 -->
               <property name="mapperLocations" value="classpath:mapper/*.xml"></property>
           </bean>
           ```
           
       
     - 配置扫描器，将`Mybatis`接口的实现加入到`IoC`容器中
       
       ```xml
         <bean class="org.mybatis.spring.mapper.MapperScannerConfigurer">
             <!-- 扫描所有dao接口的实现，加入到ioc容器中 -->
             <property name="basePackage" value="cn.lizhi.crud.dao"></property>
         </bean>
       ```
       
         - 配置一个可以执行批量的`sqlSession`
         
           ```xml
           <bean id="sqlSession" class="org.mybatis.spring.SqlSessionTemplate">
               <constructor-arg name="sqlSessionFactory" ref="sqlSessionFactory"></constructor-arg>
               <constructor-arg name="executorType" value="BATCH"></constructor-arg>
           </bean>
           ```
         
         - 事务控制管理器的配置
         
           - `transactionManager`
             - 配置数据源 -- 同`Spring`的数据源
           
           ```xml
           <bean id="transactionManager" class="org.springframework.jdbc.datasource.DataSourceTransactionManager">
               <!--控制住数据源  -->
               <property name="dataSource" ref="pooledDataSource"></property>
           </bean>
           ```
         
         - 开启基于注解的事务或使用`xml`配置形式的事务(主要使用`xml`配置) `..service..*(..)`
         
           ```xml
           <!--开启基于注解的事务，使用xml配置形式的事务（必要主要的都是使用配置式）  -->
           <aop:config>
               <!-- 切入点表达式 对业务层进行事务控制 -->
               <aop:pointcut expression="execution(* cn.lizhi.service..*(..))" id="txPoint"/>
               <!-- 配置事务增强 -->
               <aop:advisor advice-ref="txAdvice" pointcut-ref="txPoint"/>
           </aop:config>
           ```
         
         - 配置事务的增强，事务如何切入
         
           ```xml
           <!--配置事务增强，事务如何切入  -->
           <tx:advice id="txAdvice" transaction-manager="transactionManager">
               <tx:attributes>
                   <!-- 所有方法都是事务方法 -->
                   <tx:method name="*" propagation="REQUIRED" read-only="false"/>
                   <!-- 以get开始的所有方法 -->
                   <tx:method name="get*" propagation="SUPPORTS" read-only="true"/>
               </tx:attributes>
           </tx:advice>
           ```
         
         - `Spring`配置文件的核心点(数据源、与`Mybatis`的整合，事务控制)

   - `Mybatis`配置文件的编写
   
     - 全局配置文件的编写 -- `Mybatis-config.xml`
     
       ```xml
     <?xml version="1.0" encoding="UTF-8"?>
       <!DOCTYPE configuration
             PUBLIC "-//mybatis.org//DTD Config 3.0//EN"
               "http://mybatis.org/dtd/mybatis-3-config.dtd">
     <configuration>
           <settings>
               <setting name="mapUnderscoreToCamelCase" value="true"/>
           </settings>
       
         <typeAliases>
               <package name="cn.lizhi.bean"/>
         </typeAliases>
       
           <!-- 分页插件 -->
         <plugins>
               <plugin interceptor="com.github.pagehelper.PageInterceptor">
                 <!--分页参数合理化  -->
                   <property name="reasonable" value="true"/>
             </plugin>
           </plugins>
       </configuration>
       ```
     ```
       
     - `mapper`文件
     
       - 首先创建一张员工表
     
         - `emp_id;int;11`
       - `emp_name;varchar;255`
         - `gender;char;1`
       - `email;varchar;255`
         - `d_id;int;11 外键关联`
     
       - 部门表
     
         - `dept_id;int;11`
       - `dept_name;varchar;255`
     
     
     ​```sql
       CREATE TABLE tbl_dept(
           dept_id INTEGER(11) PRIMARY KEY auto_increment,
           dept_name VARCHAR(255) NOT NULL
       );
     
     CREATE TABLE tbl_emp(
         emp_id INTEGER(11) PRIMARY KEY auto_increment,
         emp_name VARCHAR(255) NOT NULL,
         gender CHAR(1),
         email VARCHAR(255),
         d_id INTEGER(11),
         CONSTRAINT emp_dept_fk FOREIGN KEY (d_id) references tbl_dept(dept_id)
     );
     ```
     
     - 使用`mybatis`的逆向工程生成对应的`bean`以及`mapper`
     
       - `Maven`导入依赖 -- `Mybatis generator`
     
       - `pom.xml`同级目录下创建`mbg.xml`配置文件
       
         - 配置数据库连接
       
           ```xml
           <!-- 配置数据库连接 -->
           <jdbcConnection driverClass="com.mysql.jdbc.Driver"
                           connectionURL="jdbc:mysql://106.15.65.210:3306/ssm?useUnicode=true&amp;characterEncoding=utf8"
                           userId="remote_mysql"
                           password="lz061017">
           </jdbcConnection>
           ```
          - `javaModelGenerator`标签下，指定`bean`文件生成的地址
            
             ```xml
             <!-- 指定javaBean生成的位置 targetPackage为包的路径，targetProject为项目路径，即两个能够连接在一起 -->
             <javaModelGenerator targetPackage="cn.lizhi.bean" targetProject="./src/main/java">
                 <property name="enableSubPackages" value="true" />
                 <property name="trimStrings" value="true" />
             </javaModelGenerator>
             ```
       
       - `sqlMapGenerator`标签下，指定`sql`映射文件生成的位置
         
         ```xml
         <!-- 指定sql映射文件生成的位置 -->
         <sqlMapGenerator targetPackage="mapper"  targetProject="./src/main/resources">
             <property name="enableSubPackages" value="true" />
         </sqlMapGenerator>
         ```
       
           - `javaClientGenerator`，指定`dao`接口生成的位置，`mapper`接口
       
             ```xml
             <!-- 指定dao接口生成的位置，mapper接口 -->
             <javaClientGenerator type="XMLMAPPER" targetPackage="cn.lizhi.dao"  targetProject="./src/main/java">
                 <property name="enableSubPackages" value="true" />
             </javaClientGenerator>
             ```
          - `table`指定每个表的生成策略
           
             ```xml
             <!-- table指定每个表的生成策略 -->
             <table tableName="tbl_emp" domainObjectName="Employee"></table>
             <table tableName="tbl_dept" domainObjectName="Department"></table>
             ```
         
           - 总配置文件
           
             ```xml
             <?xml version="1.0" encoding="UTF-8"?>
             <!DOCTYPE generatorConfiguration
                     PUBLIC "-//mybatis.org//DTD MyBatis Generator Configuration 1.0//EN"
                     "http://mybatis.org/dtd/mybatis-generator-config_1_0.dtd">
             
             <generatorConfiguration>
                 <!--    <classPathEntry location="/Program Files/IBM/SQLLIB/java/db2java.zip" />-->
             
                 <context id="DB2Tables" targetRuntime="MyBatis3">
                     <!-- 关闭注释 -->
                     <commentGenerator>
                         <property name="suppressAllComments" value="true" />
                     </commentGenerator>
             
                     <!-- 配置数据库连接 -->
                     <jdbcConnection driverClass="com.mysql.jdbc.Driver"
                                     connectionURL="jdbc:mysql://106.15.65.210:3306/ssm?useUnicode=true&amp;characterEncoding=utf8"
                                     userId="remote_mysql"
                                     password="lz061017">
                     </jdbcConnection>
             
                     <javaTypeResolver >
                         <property name="forceBigDecimals" value="false" />
                     </javaTypeResolver>
             
                     <!-- 指定javaBean生成的位置 targetPackage为包的路径，targetProject为项目路径，即两个能够连接在一起 -->
                     <javaModelGenerator targetPackage="cn.lizhi.bean" targetProject="./src/main/java">
                         <property name="enableSubPackages" value="true" />
                         <property name="trimStrings" value="true" />
                     </javaModelGenerator>
             
                     <!-- 指定sql映射文件生成的位置 -->
                     <sqlMapGenerator targetPackage="mapper"  targetProject="./src/main/resources">
                         <property name="enableSubPackages" value="true" />
                     </sqlMapGenerator>
             
                     <!-- 指定dao接口生成的位置，mapper接口 -->
                     <javaClientGenerator type="XMLMAPPER" targetPackage="cn.lizhi.dao"  targetProject="./src/main/java">
                         <property name="enableSubPackages" value="true" />
                     </javaClientGenerator>
             
                     <!-- table指定每个表的生成策略 -->
                     <table tableName="tbl_emp" domainObjectName="Employee"></table>
                     <table tableName="tbl_dept" domainObjectName="Department"></table>
                 </context>
             </generatorConfiguration>
             ```
             
           - 测试`dao`类 -- `Spring`的项目就可以使用`Spring`的单元测试，可以自动注入我们需要的组件
           
             1. 导入`SpringTest`模块
             
                ```java
                @RunWith(SpringJunit4ClassRunner.class)
                ```
             
             2. `@ContextConfiguration`指定`Spring`配置文件的位置
             
                ```java
                @ContextConfiguration(locations={"classpath:applicationContext.xml"})
                ```
             
             3. 直接`@Autowired`原生开发
             
             4. 测试
             
                - 部门的插入测试
                
                - 员工插入
                
                  - 批量插入
                
                ```java
                @RunWith(SpringJUnit4ClassRunner.class)
                @ContextConfiguration(locations = {"classpath:applicationContext.xml"})
                public class MapperTest {
                
                    @Autowired
                    private DepartmentMapper departmentMapper;
                
                    @Autowired
                    private EmployeeMapper employeeMapper;
                
                    @Autowired
                    private SqlSession sqlSession;
                
                    @Test
                    public void testCRUD() {
                
                //        测试部门插入数据
                //        departmentMapper.insert(new Department(null, "开发部"));
                //        departmentMapper.insert(new Department(null, "测试部"));
                
                //         先单独插入一条数据,进行测试
                        employeeMapper.insert(new Employee(null, "Jerry", "M", "Jerry@163.com", 1));
                        // 批量插入员工信息,员工的员工名采用uuid。批量，使用可以执行批量操作的sqlSession
                        // 代理对象
                        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
                        // 批量插入1000条sql数据
                        for (int i = 0; i < 1000; i++) {
                            String name = UUID.randomUUID().toString().replaceAll("-", "").substring(0, 5);
                            mapper.insert(new Employee(null, name, "M", name + "@163.com", 1));
                        }
                        System.out.println("批量插入完成");
                    }
                }
                ```

## 一、模块搭建

### 1.1 查询模块

主要步骤：

1. 访问`index.jsp`页面
2. `index.jsp`页面发送出查询员工列表请求
3. `EmployeeController`来接收请求，查出员工数据
4. 来到`list.jsp`页面进行展示

规定：查询的`URI`为`emps`

`web`路径问题：

不以`/`开始的相对路径，找资源，是以当前资源的路径为基准，经常容易出现问题。

以`/`开始的相对路径，找资源，以服务器的路径为标准(`http://localhost:3306`)，需要加上项目名称，例如`ssm_crud --> http://localhost:3306/ssm_crud`

在`jsp`页面中，首先取出项目名称：

![image-20201020142357302](/Users/liz/Library/Application Support/typora-user-images/image-20201020142357302.png)

部署到`tomcat`的项目中,`ssm_crud`即为项目名称。

```java
<% pageContext.setAttribute("APP_PATH",request.getContextPath()) %> // 路径以斜杠开头，不以斜杠结尾
```

取值时的使用：

```java
src="${APP_PATH}/static/js/.."
```

#### 1.1.1 index.jsp页面的搭建

搭建采用`bootstrap`布局样式。

#### 1.1.2 显示分页数据

配合`JSTL和EL表达式`取出数据。

注意点有：当在第一页和最后一页时，分页栏的上一页和下一页置为不可用。

后端分页查询，我们采用`pageHelper`插件。

1. 在`pom.xml`中引入`pageHelper`依赖

```xml
<!--引入pageHelper分页插件 -->
<dependency>
    <groupId>com.github.pagehelper</groupId>
    <artifactId>pagehelper</artifactId>
    <version>5.0.0</version>
</dependency>
```

2. 在`mybatis-config`配置文件中添加`pageHelper`插件

```xml
<!-- 分页插件 -->
<plugins>
    <plugin interceptor="com.github.pagehelper.PageInterceptor">
        <!--分页参数合理化  -->
        <property name="reasonable" value="true"/>
    </plugin>
</plugins>
```

3. 后端代码

```java
@RequestMapping("/emps")
@ResponseBody // 返回值为json格式的数据
public Msg getEmps(@RequestParam(value = "pn", defaultValue = "1") Integer pn) {
    // 引入PageHelper分页插件
    // 在查询之前只需要调用,传入页码，以及分页的大小
    PageHelper.startPage(pn, 5);
    // starPage紧跟查询就是分页查询
    List<Employee> employees = employeeService.getAll();
    // 使用PageInfo 包装查询后的结果，只需要将pageInfo交给页面就行
    // 封装了详细的分页信息，包括有我们查询出来的数据,连续显示的页数5页
    PageInfo page = new PageInfo(employees, 5);
    Msg msg = Msg.success().add("pageInfo", page);
    return msg;
}
```

> [@RequestParam()和@PathVariable()的区别](https://blog.csdn.net/exodus3/article/details/92762215)

#### 1.1.3 返回Json数据的分页查询

原因：`Json`数据传输速度快，无论是浏览器还是手机移动端，服务器解析的压力都较小。

手段：纯`Ajax`请求，进行查询。

1. `Index.jsp`页面直接发送`ajax`请求进行员工分页数据的查询
2. 服务器将查出的数据，以`json`字符串的形式返回给浏览器
3. 浏览器收到`js`字符串。可以使用`js`对`json`进行解析，使用`js`通过`dom`增删改改变页面。
4. 返回`json`。实现客户端的无关性。

实现步骤：

1. 自定义一个`msg`类，不仅存放`pageInfo`信息，还要存放是否操作成功的状态码(自定义)。最终将`msg`类进行返回，通过`@ResponseBody`注解，将`bean`对象转换为`json`数据格式进行返回。目的：就是自定义一个`pageInfo`类，在原有的基础上添加操作状态。

2. 改造首页 -- 即通过`json`数据获取员工数据

   通过`js`代码，即`Jquery`的`ajax`请求获取到后端传递到`json`数据，然后再向前端中填充数据。

3. 分页信息和分页条

   `ajax`做分页的关键在于，当点击页面时，我们再一次发送`ajax`请求，请求的参数中就带有当前请求的页面数，即添加`onclick`事件。
   
4. 新增的员工`ID`值没有正确的排列的原因

```sql
FROM tbl_emp e left join tbl_dept d on e.`d_id`=d.`dept_id`
```

原因：**左外连接查询会根据主表向从表一个一个的查，导致从表的dept_id等于1的先查出来。**

解决办法：在`service`层修改代码

```java
public List<Employee> getAll() {
    EmployeeExample example = new EmployeeExample();
    example.setOrderByClause("emp_id"); // 自定义设置排序的条件为emp_id的值进行排序
    return employeeMapper.selectByExampleWithDept(example);
}
```

为了将后端的数据统一化传给前端，我们定义一个`Msg`类，用于统一向前端传递数据(将`Msg`类`json`化给前端)。

```java
public class Msg implements Serializable {

    // 200表示操作成功；500表示操作失败
    private Integer code;
    // 存储信息 成功/失败
    private String msg;
    // 存用来存后端数据
    private Map<String, Object> extend = new HashMap<String, Object>();

    public static Msg success() {
        Msg msg = new Msg();
        msg.setCode(200);
        msg.setMsg("成功");
        return msg;
    }

    public static Msg fail() {
        Msg msg = new Msg();
        msg.setCode(500);
        msg.setMsg("失败");
        return msg;
    }

    public Msg add(String key, Object object) {
        this.getExtend().put(key, object); // this表示当前对象,目的是为了可以链式操作，同一对象多次操作统一对象将对象放在Map容器中。
        return this;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Map<String, Object> getExtend() {
        return extend;
    }

    public void setExtend(Map<String, Object> extend) {
        this.extend = extend;
    }
}
```

### 1.2 新增模块

逻辑：

1. 在`index.jsp`页面点击"新增"
2. 弹出新增对话框
3. 去数据库查询部门列表，显示在对话框中
4. 用户输入数据完成保存

#### 1.2.1 模态框的添加

采用`bootstrap`提供的模板

- 模态框
- 表单
- 单选框
- 下拉列表

#### 1.2.2 部门下拉框中填充数据

当点击`新增`按钮时，前端通过发送`ajax`请求到后端获取到所有的部门信息。

创建部门的`controller`，继而通过`service`和`dao`层将查询到部门数据进行封装到`msg`对象中返回`json`数据格式给前端。

#### 1.2.3 保存员工数据

思路：当点击`保存`按钮以后，通过发送`ajax`请求，将填入的表单数据，传递给后端，继而后端将数据保存到数据库中。

规定：采用`Restful`风格的`URI`请求。

- `/emp/{id}`  -- `GET`查询员工
- `/emp` -- `POST`保存员工
- `/emp/{id}` -- `PUT`修改员工
- `/emp/{id}` -- `DELETE` 删除员工

技巧：

1. 取表单中的数据时，采用`jQuery`提供的序列化方法。

细节点：

- 当员工保存成功时
  - 关闭模态框
    - 调用`JQuery`提供的方法,`BootStrap`对模态框的关闭。
  - 跳转到最后一页查看新增的数据
    - 发送`ajax`请求，请求最后一页数据(将总记录数当做总页数传入的页数)

#### 1.2.4 表单数据的校验

当数据合法时，才能够保存成功。即先对要提交给服务器的数据进行校验。

思路：在发送`ajax`请求之前调用核验数据的方法，当返回`true`时继续执行；返回`false`时，`reture false`结束。

校验手段：正则表达式

校验美化：采用`JQuery`中提供的校验模板进行美化。

校验数据：

- 名称

  ```js
  var regex_name = /(^[a-z0-9_-]{3,16}$)|(^[\u2E80-\u9FFF]{2,5}$)/;
  ```

- 邮箱

  ```js
  var regex_email = /^([a-z0-9_\.-]+)@([\da-z\.-]+)\.([a-z\.]{2,6})$/;
  ```

最后分别对名称和邮箱绑定离焦事件，在未提交表单时就对文本框进行校验。

细节：由于发送的是`ajax`请求，所以提交前(离焦事件发生前)，都需要对原来的属性内容进行清空，重新添加。

#### 1.2.5 对用户名进行后端校验

目的：对相同的用户名不再进行入库，保证用户的唯一性。

思路：前端进行表单提交时，后台获取到数据，首先判断用户名是否已经在库中。如果不存在，将表单数据进行入库；如果已经存在，则向前台发送添加失败的错误信息。`ajax`请求后，判断用户名是否可用，可以在标签内自定义一个属性，用于前端的判断，是否可以提交表单(是否禁用保存按钮)。在后端控制器判断用户名是否可用之间，先进行后端校验用户名是否合法，如果不合法就直接返回，不必再做后面的可用操作。

难点在于前端代码的编写。

思路：对用户名输入框绑定事件(给输入框绑定`change`事件，当文本内容发送改变时，给后端发送`ajax`请求，进行校验)，当输入框内容改变时，发送`ajax`请求到后台，对数据进行验证。而对表单提交时，还要再多一层判断，即判断用户名是否重复。

细节：

- 当再次点击`新增`按钮时，表单内容项的清空(重置)
- 表单中状态的重置(验证是否通过的状态)

既要完成前端验证，也要完成后端的验证。其中后端的验证是能够从根本上起到验证的效果。

#### 1.2.6 后端校验-JSR303

后端校验采用`SpringMVC`提供的`JSR303`校验规则。

首先导入`maven`依赖：

```xml
<!--JSR303数据校验支持；tomcat7及以上的服务器，
  tomcat7以下的服务器：el表达式。额外给服务器的lib包中替换新的标准的el
  -->
<!-- https://mvnrepository.com/artifact/org.hibernate/hibernate-validator -->
<dependency>
    <groupId>org.hibernate</groupId>
    <artifactId>hibernate-validator</artifactId>
    <version>5.4.1.Final</version>
</dependency>
```

使用方式：

1. 首先在需要验证的字段上加入相应的注解(自定义验证`@Pattern`或是已经封装好的验证，如邮箱验证`@Email`等)
2. 在控制器中给实体类加上`@Valid`注解，并给对应方法填上形参`BindingResult`对象。

实体类(`Employee`)绑定验证：

```java
@Pattern(regexp = "(^[a-z0-9_-]{3,16}$)|(^[\\u2E80-\\u9FFF]{2,5}$)", message = "请输入3-16位英文数字用户名或2-5位中文用户名_backward")
@NotNull(message = "请输入用户名")
private String empName;

@Pattern(regexp = "^([a-z0-9_\\.-]+)@([\\da-z\\.-]+)\\.([a-z\\.]{2,6})$", message = "请输入正确的邮箱格式")
@NotNull(message = "请输入邮箱内容")
private String email;
```

对实体类属性绑定自定义规则和非空验证。

控制器方法：

```java
/**
     * 新增 -- 保存用户信息
     * @param employee
     * @return
     */
@RequestMapping(value = "/saveEmps", method = {RequestMethod.POST})
@ResponseBody
public Msg saveEmps(@Valid Employee employee, BindingResult result) {

    if (result.hasErrors()) { // 验证不通过
        // 将错误信息返回给前端进行展示
        Map<String, String> map = new HashMap<>();
        List<FieldError> fieldErrors = result.getFieldErrors(); // 获取所有错误信息的字段和message -- 即FieldError对象的集合
        // 取出全部的错误信息，保存到HashMap中，后续将错误交给前端展示
        for (FieldError fieldError : fieldErrors) {
            String error_name = fieldError.getField();
            String error_message = fieldError.getDefaultMessage();
            map.put(error_name, error_message);
        }
        // 将错误一并进行返回
        return Msg.fail().add("errorFields", map);
    } else { // 验证通过_继续后续的操作(保存)
        employeeService.saveEmp(employee);
        return Msg.success();
    }
}
```

给实体类绑定`@Valid`注解，验证的信息全部绑定在`BindingResult`对象中。

前端接收后端错误信息：

```javascript
/**
     * 保存用户信息
     */
function save_emp() {

    // 通过前端进行数据核验 -- 当用户名和邮箱都校验成功时，才发送ajax请求
    if (!valid_all()) {
        return false;
    }

    // 提交表单数据
    $.ajax({
        url: "${APP_PATH}/saveEmps",
        type: "POST",
        data: $('#dept_form').serialize(),
        success: function (result) {
            // 进行后端数据校验
            var code = result.code;
            if (code == 500) { // 后端校验不通过
                var empName_error_msg = result.extend.errorFields.empName;
                var email_error_msg = result.extend.errorFields.email;
                if (undefined != empName) {
                    abstract_valid("#empName", "fail", empName_error_msg);
                }

                if (undefined != email) {
                    abstract_valid("#email", "fail", email_error_msg);
                }
            } else { // 校验通过
                // 新增完毕后，跳转到最后一页，查看数据
                $('#myModal').modal('hide');
                // 跳转到最后一页
                ajax_index(totalCount);
            }
        }
    });
}
```

### 1.2 修改模块

1. 点击编辑
2. 弹出用户修改的模态框（显示用户信息）
3. 点击更新，完成用户修改

具体步骤：

1. 再定义一个模态框(复制修改之间的模态框)

2. 点击`编辑`按钮时，弹出模态框，并让用户信息进行回显。

   **注意:**因为页面的**员工信息**以及**编辑**按钮是经过发送`ajax`请求获取到的，即在绑定事件之后获取到的。**绑定事件是在页面加载时就进行的**，而**员工信息**及**编辑按钮**是在发送`ajax`请求之后获取到的，所以并不能在编辑按钮上绑定上单击事件。简而言之，在绑定单击事件时，按钮都还不存在，所以没有绑定成功。

   解决办法：

   1. 可以在创建按钮之后绑定事件。易耦合，不建议。

   2. 采用`JQuery`的`.live()`方法，新版的`JQuery`提供的是`on`进行替代。

      ```js
      // 给编辑按钮绑定单机事件 -- 在ajax请求之后。
      // on 可以给多个标签绑定事件。这里通过document进行委派对全文档中class属性中存在.update_btn的标签绑定单击事件
      $(document).on('click', '.update_btn', function () {
          alert("aaa");
      });
      ```

      `on`实行的是委派处理，不能平级所有标签进行处理。

3. 查出部门信息，并显示部门列表。

4. 查出员工信息，并显示员工信息。

   发送`ajax`信息，到后端请求数据，将数据库中的数据进行回显。

   1. 员工姓名置为不可修改。
   2. 处理请求的控制器编写
   3. 使用`Restful`风格请求

综合以上代码：

```javascript
// 给编辑按钮绑定单机事件 -- 在ajax请求之后。
// on 可以给多个标签绑定事件。这里通过document进行委派对全文档中class属性中存在.update_btn的标签绑定单击事件
$(document).on('click', '.update_btn', function () {
    $('#myModalLabel_update').html("信息修改");
    // 弹出模态框
    $('#myModal_update').modal({
        keyboard: true
    });
    // 采用ajax请求向后端进行数据的请求
    // 1.1 获取员工的empId,即数据库中的id
    var empId = $(this).attr('empId');
    // 部门信息回显
    dept_get('#dept_select_update',empId); //
    // 传入id值，获取员工信息
    // get_emp(empId,);


});

/**
     * 异步请求员工信息方法的抽取
     */
function get_emp(id) {
    $.ajax({
        type: "GET",
        data: id,
        url: '${APP_PATH}/searchEmp/' + id,
        success: function (result) {
            $('#empName_update').val(result.extend.employee.empName); // 姓名的回显
            $('#email_update').val(result.extend.employee.email); // 邮箱地址的回显
            var dId = result.extend.employee.dId;
            // alert(dId);
            // 通过选择器的方式 -- 选中当前模态框下属性为value="gender"的input输入框
            $('#myModal_update input[name=gender]').val([result.extend.employee.gender]);
            // 下拉列表的回显
            $('#myModal_update select').val([dId]);
        }

    });
}

/**
     *
     * 部门内容回显抽取
     * */
function dept_get(id,eId) {
    $(id).empty(); // 再次加载下拉框时，内容清空，用于重新加载内容
    $.ajax({
        type: "POST",
        url: '${APP_PATH}/deps',
        success: function (result) {
            $(result.extend.departments).each(function (index, item) {
                var option = $('<option></option>').append(item.deptName).attr('value', item.deptId);
                $(id).append(option);
            });
        },
        complete: function () {
            get_emp(eId);

        }

    });
}
```

在`document.on()`函数中，调用了两个`ajax`异步请求函数。这里会出现一个问题，在`get_emp`函数中需要对显示的部门进行判断(判断哪个部门在点开窗口时被默认显示)，由于是发送的`ajax`异步请求，可能会出现`dept_get`函数中部门还未回显完毕，`get_emp`函数就执行完毕，导致并没有将数据库中员工的部门信息正确显示在前台。所以首先需要我们保证两个异步函数的先后顺序，这里需要在部门内容显示在表单中后，再对员工部门进行判断显示。故需要在`dept_get`函数执行完毕后，对`get_emp`函数进行回调，这样就能保证其中一个`ajax`执行完毕以后，再执行另一个`ajax`请求的函数。

5. 修改模态框中，员工的信息，再提交表单内容到后台。

需要注意：重新修改的内容依然需要做表单验证，内容合法才能被提交到数据库中。

1. 邮箱验证
2. 发送`ajax`请求 -- 指定为`PUT`请求，在`data`参数后拼接`&_method=PUT`，或者直接用`JQuery`提供的`type:"PUT"`

**注意：**如果直接发送`ajax=PUT`形式的请求，数据在后台封装不上。

**问题：**请求体中有数据，但是对象封装不上，导致`SQL`语句在拼装时会出现错误。

**原因：**

1. `Tomcat`将请求体中的数据，封装一个`map`。
2. `request.getParameter("empName")`就会从这个`map`中取值。
3. `SpringMVC`封装`POJO`对象的时候，会取`POJO`中每个属性的值，`request.getParameter()`;

`Ajax`发送`PUT`请求产生的问题：

1. `PUT`请求，请求体中的数据，`request.getParameter()`拿不到
2. `Tomcat`接收到`PUT`请求不会封装请求体中数据为`map`，只有`POST`形式的请求才封装请求体为`map`

**解决方法：**我们要能支持直接发送`PUT`之类的请求还要封装请求体中的数据，使用`SpringMVC`提供的过滤器，配置上`HttpPutFormContentFilter`。它的作用是将请求体中的数据解析包装成一个`map`，`request`被重新包装，`request.getParameter()`被重写，就会从自己封装的`map`中取数据。

### 1.3 删除模块

首先删除时，需要弹出确认栏，是否确认删除。删除功能分为单个删除和批量删除。

#### 1.3.1 单个删除

- `URI:/emp/{id}`

根据用户的`id`主键通过`ajax`请求删除用户。

思路：当点击删除按钮时，发送`ajax`请求，将用户的主键`id`发送到后台，后台继而根据主键`id`删除数据库中对应的用户信息。

#### 1.3.2 批量删除

##### 1.3.2.1 前端页面的完善

设置总的`checkAll`按钮。当点击此按钮时，满足全选/全不选状态。

1. 由`checkAll`复选框设定下面的复选框。设置`checkAll`按钮的单击事件，保持下面所有复选框中的选中状态`checked`和`checkAll`复选框的选中状态一致，这样就能保证所设定的复选框`全选\全不选`的状态。

   ```js
   /**
        * 给checkAll绑定单机事件 -- 全选/全不选
        */
   $('#checkAll').click(function () {
       var flag = $(this).prop("checked"); // 获取checkAll的选中状态 true/false
       $('.checkbox_item').prop("checked", flag); //设定所有属性为.checkbox_item的复选框选中状态同checkAll的状态
   });
   ```

2. 由下方的复选框设定`checkAll`复选框。即，当下方复选框被全部选中时，`checkAll`复选框也应该被选中;当下面复选框只要有一样没有被选中，那么`checkAll`复选框就不应该被选中。

   ```js
   /**
        * 由.checkbox_item的复选框决定checkAll复选框的选中状态
        */
   $(document).on('click', '.checkbox_item', function () {
       // 获取.checkbox_item复选框的全部个数
       var length = $('.checkbox_item').length;
       var selected_length = $('.checkbox_item:checked').length;
       if (length == selected_length) {
           $('#checkAll').prop('checked', true);
       } else {
           $('#checkAll').prop('checked', false);
       }
   });
   ```

3. 传递数据，批量删除

   给`删除`按钮绑定单击事件，弹出确认删除的提示框，确认删除后，发送`ajax`请求。将批量删除的用户`id`以`-`连接，发送`String`字符串到后台，后台再通过字符串分割，取出每个`id`值做批量删除。在`dao`层的批量删除，做以下的`SQL`语句：

   ```sql
   delete from emp_table where id in [id1,id2,id3,...]
   ```

   批量删除的前端逻辑如下：

   ```js
   	/**
        * 批量删除
        */
   $('#delete_btn').click(function () {
       // 获取选中状态的复选框
       var checkboxs = $('.checkbox_item:checked');
       var names = ""; // 被删除用户的名称
       var empIds = ""; // 被删除用户的id字符串
       $.each(checkboxs, function () {
           var name = $(this).parents('tr').find('td:eq(2)').html();
           names += name+",";
           var empId = $(this).parents('tr').attr('empid');
           empIds += empId + "-";
       });
       names = names.substring(0, names.length - 1);
       empIds = empIds.substring(0, empIds.length - 1);
   
       if (confirm("您确认删除以下用户" + names + "吗？") == false) { // 确认是否删除用户
           return false;
       }
       $.ajax({
           type: "delete",
           url: "${APP_PATH}/emp/" + empIds,
           success: function (result) {
               ajax_index(page);
           }
       });
   });
   ```

   后端整合单个删除和批量删除的方法。

   `controller`层：

   ```java
   /**
        * 删除用户，批量与单个删除的整合
        * @param s_id 前端传递id
        * @return
        */
   @ResponseBody
   @RequestMapping(value = "/emp/{s_id}",method = RequestMethod.DELETE)
   public Msg deleteEmp(@PathVariable("s_id") String s_id) {
       if (s_id.contains("-")) { // 批量删除用户
           employeeService.deleteBatch(s_id);
   
       } else { // 单个用户的删除
           int id = Integer.parseInt(s_id);
           employeeService.delete(id);
       }
       return Msg.success();
   }
   ```

   `service`层：

   ```java
   /**
        * 删除用户
        * @param id
        */
   @Override
   public void delete(Integer id) {
       employeeMapper.deleteByPrimaryKey(id);
   }
   
   /**
        * 批量用户的删除
        * @param s_ids
        */
   @Override
   public void deleteBatch(String s_ids) {
       List<Integer> ids = new ArrayList<Integer>();
       String[] sids = s_ids.split("-");
       for (String id : sids) {
           ids.add(Integer.parseInt(id));
       }
       EmployeeExample employeeExample = new EmployeeExample();
       EmployeeExample.Criteria criteria = employeeExample.createCriteria();
       criteria.andEmpIdIn(ids);
       employeeMapper.deleteByExample(employeeExample);
   }
   ```

   