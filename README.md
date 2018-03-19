# Shop
类似于淘宝，但是功能简单

   系统分为三层：表示层、业务逻辑层、数据持久层。
   
   Struts框架负责显示，即view
   
   hibernate框架负责数据持久层
   
   spring框架负责业务层，用面向对象的分析方法根据需求提出一些模型，
   
将这些模型变成为基本的Java对象，然后编写基本的dao接口，并给出Hibernate

的dao实现，采用 Hibernate架构实现的Dao类来实现Java类与数据库之间的转换

和访问，最后由Spring完成业务逻辑。

    这个系统的流程为统的基本业务流程是：在表示层中，首先通过JSP页面实现交
    
互界面，负责传送请求(Request)和接收响应(Response)，然后Struts根据配置文件

(struts-config.xml)将ActionServlet接收到的Request委派给相应的Action处理。

在业务层中，管理服务组件的 Spring IoC容器负责向Action提供业务模型(Model)

组件和该组件的协作对象数据处理(DAO)组件完成业务逻辑，并提供事务处理、缓冲池

等容器组件以提升系统性能和保证数据的完整性。而在持久层中，则依赖于Hibernate

的对象化映射和数据库交互，处理DAO组件请求的数据，并返回处理结果。

流程图如下

![Alt text](https://github.com/CaoJiabiao/Shop/raw/master/screenshots/流程.png)

截图：(只截了两张）

![Alt text](https://github.com/CaoJiabiao/Shop/raw/master/screenshots/shot1.png)

![Alt text](https://github.com/CaoJiabiao/Shop/raw/master/screenshots/shot2.png)
