# Selenium

## Selenium介绍

[Selenium官网](https://docs.seleniumhq.org/)

[Selenium For Github](https://github.com/SeleniumHQ/selenium)

>Selenium automates browsers. That's it! What you do with that power is entirely up to you. Primarily, it is for automating web applications for testing purposes, but is certainly not limited to just that. Boring web-based administration tasks can (and should!) be automated as well.
 Selenium has the support of some of the largest browser vendors who have taken (or are taking) steps to make Selenium a native part of their browser. It is also the core technology in countless other browser automation tools, APIs and frameworks.



**Selenium测试 直接运行在浏览器中，就像真正的用户在操作一样**


## 自动化测试举例

### Java实现Selenium自动化测试举例

1. 查询baidu搜索明略科技第一次词条的地址是否为 https://www.mininglamp.com/
2. 复杂信息校验 之前的项目
3. 手动编写项目的登录自动化测试



## 如何进行一个自动化测试

1. 你想测试什么
2. 测试成功的标准是什么


## Selenium优点

- 多平台: Windows、Linux、MAC

- 多浏览器: Ie、ff、safari、opera、chrome

- 多语言: C、 java、ruby、python、C#  || Golang等语言有各自作者在维护...

- 免费开源、分布式、社区支持

- Google维护


## Selenium用来做什么?

1. 自动化测试 -> Tools -> Selenium IDE  浏览器兼容 页面兼容 版本兼容...
2. 爬虫 -> 我们可以爬取任何数据

## Selenium有哪些功能?

### 控制浏览器的生命周期

- 浏览器打开网址 
 
- 浏览器最大化 
 
- 设置浏览器的高度为800像素，宽度为480像素
 
- 浏览器后退 
 
- 浏览器前进 
 
- 浏览器关闭 
 
- 浏览器退出 

### 页面操作

#### 元素定位

- id (element id)
- name
- class name
- tag
- link text
- partial link text
- xpath
- css selector

#### 页面事件

##### 鼠标事件

- context_click() # 右击
- double_click() # 双击
- drag_and_drop() # 拖拽
- move_to_element() # 鼠标停在一个元素上
- click_and_hold() # 按下鼠标左键在一个元素上

##### 键盘事件

- send_keys(Keys.BACKSPACE)	删除键(BackSpace)
- send_keys(Keys.SPACE)	空格键(Space)
- send_keys(Keys.TAB)	制表键(Tab)
- send_keys(Keys.ESCAPE)	回退键(Esc)
- send_keys(Keys.ENTER)	回车键(Enter)
- send_keys(Keys.CONTROL,'a')	全选（Ctrl+A）
- send_keys(Keys.CONTROL,'c')	复制（Ctrl+C）


### 其他特性


#### 使用浏览器的特性 (需要使用具体driver 不能使用抽象)
- 增加代理 
- 设置cookie `addCookie`(先有页面再添加cookie)
- 截图 `Screenshot` 
- 是否启用插件 `add_extension`
- 浏览器无头 `--headless`
- 加载图片 `profile.managed_default_content_settings.images 2`
- 设置分辨率 `DeviceMetrics`
- 自动打开tools `--auto-open-devtools-for-tabs`
- 运行js


### Tips

1. Java加载Chrome驱动
2. Selenium缺点解决 js selenium标识
3. Selenium -> Linux

Example: `Linux VM_25_43_centos 3.10.0-862.el7.x86_64`

1. 项目运行环境
   Chrome环境 OS需要安装浏览器
   WebDriver
2. 字体乱码 本质是服务器的问题，不是浏览器的问题

#### 页面跳转

WindowHandles

#### 点击不可用

可能是网页不支持点击动作,可以通过js等操作执行




## 缺点

无法对 NetWork抓包




## 相关资料及链接

[Selenium官网](https://docs.seleniumhq.org/)

[Chrome WebDriver For Google](http://chromedriver.storage.googleapis.com/index.html)

[Chrome WebDriver For China](http://npm.taobao.org/mirrors/chromedriver/)

[github For Selenium](https://github.com/SeleniumHQ/selenium)

[Chrome Environment For Centos7.x](https://intoli.com/blog/installing-google-chrome-on-centos/)


### 相关参考

[CSDN Selenium](https://blog.csdn.net/TestingGDR/article/details/81950593)