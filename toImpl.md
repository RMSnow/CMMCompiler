## 完善语法

true/false: 0/1 ?

## 改lexer
（1）控制台输入 & 文件输入
（2）单行注释 & 多行注释
（3）标识符的合法问题

## 改parser
（1）变量声明语句：VarList
（2）条件语句：多个else的情况
（3）输入输出语句

## GUI
（1）目标：sublime
（2）监听空格：做一次词法分析，将关键字+特殊符号高亮
（3）监听回车：
    （1）行号
    （2）做一次语法（较为复杂）

## 错误处理与其他细节
（1）多次进行编辑edit时，compiler的静态变量重新初始化

----------

12-05   TODO
（1）学习JTextPane的详细用法：主要包括行号的获取、设置某个字符串的颜色
（2）使用监听事件：在edit中输入文本，点击tool中的按钮，能够调用编译器，使在console中输出解析后的结果

----------

12-06   TODO
（1）管道流，截获控制台输出至ConsolePanel
（2）学习JTextPane的详细用法：主要包括行号的获取、设置某个字符串的颜色
（3）再次规划：列出所有的compiler与gui需求，迭代开发计划

----------

12-07   TODO
Plan：
A. Compiler模块
（1）注释
（2）输入输出语句（也牵扯到了GUI的修改）
（3）声明语句：VarList
（4）条件语句：ElseStmt
（5）可权衡：中间代码改为四元式
B. GUI模块
（1）功能方面
    a. 添加token的高亮
    b. 添加行号
（2）外观方面：
    a. 控件添加：将Run按钮改为菜单栏；在编辑区添加滚动条
    b. 界面：设置widget的固定大小；设置颜色、字体、字号等
C. 综合
（1）设计测试用例
（2）根据结果进行小幅度修改
D. 展示准备
（1）电子版实验报告
（2）PPT
（3）纸质版实验报告

----------

12-08   TODO
（1）界面：设置widget的固定大小；设置颜色、字体、字号等
（2）控件添加：将Run按钮改为菜单栏；在编辑区添加滚动条
（3）功能方面
       a. 添加token的高亮
       b. 添加行号

----------

12-09   TODO
GUI外观设计：
（1）Running按钮 -> 菜单栏
（2）edit区：字号、字体设置
（3）行号区
（4）console区：字号、字体；设置为无法更改内容

（5）所有控件：颜色设置

----------

12-10   TODO
A. Compiler模块
（1）注释
（2）输入输出语句（也牵扯到了GUI的修改）
C. 综合
（1）设计测试用例
（2）根据结果进行小幅度修改
D. 展示准备
（1）电子版实验报告
（2）PPT
（3）纸质版实验报告