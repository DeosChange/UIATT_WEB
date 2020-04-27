# UIATT_WEB
author : change

UIATT_WEB:ui auto test tool for web.

利用pom思想，使用webdriver、java、testng、log4j、autoit3、ant、bat等进行web端的ui自动化测试框架

目录结构为：

|-cases:只引用pcWeb中的核心逻辑

|-listener:设置自定义异常的监听与什么时机截图的监听

|-pcPage:pom思想，抽象各个页面的元素（也可能会按场景抽取）

|-pcWeb:将抽取的页面元素转化为webElement，并定义各个业务逻辑

|-util:定义各个公共方法


本框架目前版本：V3.0.0
优势：
1、增加更丰富的utils包；
2、增加了对更多中间件的支持，比如kafka、redis、canssaandra；

V2.0.0
优势：

1、设置了灵活的监听，不再需要在代码中到处添加异常捕获和截图的语句；

2、解决了windows api与webdriver对于dom处理的api的交互问题；

3、调和了硬等待与自定义等待的分别应用场景，增强了脚本的稳定性，也缩短了脚本的运行时间；


待优化：

1、代码共用率不高，还可以将重复代码抽取成公共方法；

2、未完成不同环境不同suite的开关设置；

3、未完成运行错误的截图在报告中缩略和放大显示；

4、目前集成至jk上的版本没有实现参数化，不够灵活；

