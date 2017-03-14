# mybatis-demo
###1. mybatis-example
+ 使用JDBC操作数据库
+ 只使用 MyBatis核心配置文件、SQL映射文件、POJO 实现MyBatis的数据库操作。

###2. mybatis-dao
+ 原始DAO开发方式：手写接口（Dao）和实现类（DaoImpl），将原先的数据库操作，以DaoImpl方法的形式暴露给Service层

###3. mybatis-mapper
+ 仅编写 mapper接口 和 SQL映射文件，由MyBatis框架自动生成接口的动态代理对象（实现了接口定义的方法）

###4. mybatis-exercise
+ 输入类型、输出类型、动态SQL拼接（cn.it.*）
+ 联表查询（一对一，一对多；自动映射，手动映射）（cn.manual.*）

###5. mybatis-spring
+ 输入类型、输出类型、动态SQL拼接
+ 联表查询（一对一，一对多；自动映射，手动映射）