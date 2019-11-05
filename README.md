# 测试驱动开发

## 测试驱动开发是什么

测试驱动开发以测试作为开发过程的中心，它要求在编写任何产品代码之前，首先编写用于定义产品代码行为的测试，而编写的产品代码又要以使测试通过为目标。
TDD 不是一种开发工具,也不是一种测试方法，它是一种编码之前进行单元测试的软件开发思想。
测试驱动开发要求测试可以完全自动化的运行，在对代码进行重构前后必须运行测试。

测试驱动开发主要包括两方面：测试先行和代码重构。
- 测试先行一改传统开发模式的单元测试在编写代码之后进行，而将单元测试的编写移至编写正式代码之前，有效地让程序开发人员开发出更高品质的、经过完整测试的程序。
- 重构是在不改变代码外在行为的条件下改进其内部的行为的一种软件系统改变的过程，使代码松耦合度(对外界代码依赖低)并且内聚度高(内部只完成一项功能) 。

## 测试驱动开发 & 传统开发模式

测试驱动开发在进行简单的概要设计后, 首先进行的是测试用例的编写,然后执行测试用例进行测试。测试失败, 则进行编码驱使测试通过, 这就是所谓的测试驱动。最终, 测试得到通过,再对代码进行重构,优化代码结构和性能。

传统开发模式则先进行概要设计, 然后在概要设计基础上进行详细设计,在详细设计阶段尽可能设想到全部问题和需求的解决方法, 然后才开始编码实现详细设计，开发完成后编写单元测试并完成测试。

两种开发模式流程图对比，如下图所示：

![对比流程图](https://github.com/GengRui01/Picture/blob/master/TestDrivenDevelopment/difference.png)

## 测试驱动开发Demo实践

1. 写好测试类

    假设被测试的类名是 HelloWorld，并且有一个方法 Say()，这个方法返回 String 的值 "Hello World"。根据上述要求写好测试类，如下图所示：

    ![HelloWorld测试类](https://github.com/GengRui01/Picture/blob/master/TestDrivenDevelopment/demoTest.png)

    该类有三个特点：

    1. TestHelloWorld 类是 junit.framework.TestCase 类的实例
    2. 类中有一个以“test”开头且返回值为“void”的方法（图中 testSay() 方法）
    3. testSay() 方法调用了 assertEquals() 函数，它用来比较预期的值和 HelloWorld.say() 返回的值

2. 编写被测试代码

    ![HelloWorld类](https://github.com/GengRui01/Picture/blob/master/TestDrivenDevelopment/demo.png)

## 测试驱动开发SpringBoot实践

1. 搭好结构

    ![SpringBoot代码结构](https://github.com/GengRui01/Picture/blob/master/TestDrivenDevelopment/structure.png)

2. Dao 层

    首先写好Dao层测试类

    ![Dao层测试类](https://github.com/GengRui01/Picture/blob/master/TestDrivenDevelopment/daoTest.png)

    接下来需要按照测试类要求编写Member和MemberDao两个类以驱使测试通过

    **tips：在Test中加事务注释可以随意更新表中的数据而不必担心对真实数据造成影响 使用方式如下图所示：**

    ![事务注释](https://github.com/GengRui01/Picture/blob/master/TestDrivenDevelopment/transactional.png)

    测试通过后需要去重构代码（这个功能点比较简单 这一步就可以省略啦）

3. Service 层

    Service 层和 Dao 层一样，首先写好测试类

    ![Service层测试类](https://github.com/GengRui01/Picture/blob/master/TestDrivenDevelopment/serviceTest.png)

    接下来编码以保证通过测试

    ![Service层实现类](https://github.com/GengRui01/Picture/blob/master/TestDrivenDevelopment/serviceImpl.png)

    测试通过后需要去重构代码，可以看到圈出来的部分可以复用，故抽出来一个方法，重构后代码如下：

    ![Service层实现类重构后](https://github.com/GengRui01/Picture/blob/master/TestDrivenDevelopment/serviceRefactor.png)

    重构后再次测试以保证重构不影响功能实现

4. Controller 层

    所有层级的测试步骤都和 Service 层以及 Dao 层一致，总结TDD的基本步骤如下：

    1. 首先写好测试类
    2. 接下来编码以保证通过测试
    3. 测试通过后需要去重构代码
    4. 重构后再次测试以保证重构不影响功能实现
