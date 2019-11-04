# Chrome Tools NetWork

## Chrome Tools Overview

![chrome-console-sources.png](https://raw.githubusercontent.com/BoomManPro/java-selenium-crawler/master/docs/stastic/images/chrome-console-sources.png)

## Chrome NetWork

![chrome-network.png](https://raw.githubusercontent.com/BoomManPro/java-selenium-crawler/master/docs/stastic/images/chrome-network.png)

① 记录按钮 处于打开状态时会在此面板进行网络连接的信息记录，关闭后则不会记录。

② 清除按钮 清除当前的网络连接记录信息。（点击一下就能清空）

③ 过滤器 能够自定义筛选条件，找到自己想要资源信息。

④ 一般情况下页面重新加载,log就会清空,比如页面跳转清空，如果需要阻止,则打开此按钮. 什么时候会用到? CAS抓包。

⑤ 强制关闭浏览器缓存,如果服务端对资源做了缓存,如nginx缓存等,用这个可以关闭。

⑥ 设置网络状态,可以设置限速 上行 下行 延时...

## Chrome Local Storage

![chrome-local-storage.png](https://raw.githubusercontent.com/BoomManPro/java-selenium-crawler/master/docs/stastic/images/chrome-local-storage.png)


## 一个请求我们关心的点

1. 抓包分析 请求和响应
2. View Source
3. HTTP中的关键参数
4. 查看cookie几种方式 


Query String Parameters 浏览器后面拼接 当发起一次GET请求时，参数会以url string的形式进行传递。即?后的字符串则为其请求参数，并以&作为分隔符。
 
Request payload 不会显式出现在url后 内容存放在报文主体 无固定格式

Form Data       不会显式出现在url后 内容存放在报文主体 有固定格式


### 特殊Header的妙用

Referer 统计跳转

![chrome-referer.png](https://raw.githubusercontent.com/BoomManPro/java-selenium-crawler/master/docs/stastic/images/chrome-referer.png)


## Links

图解HTTP http://pan.baidu.com/s/1jI64ar0 密码：cfft