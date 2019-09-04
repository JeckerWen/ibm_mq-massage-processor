## 1.项目介绍

* 本项目主要功能是实现从消息队列中定时获取消息(以烟草信息为例)，并按照约定好格式(格式可以根据自己的业务自定义)解析，存放至相应的表中；

## 2.技术栈

* 消息队列：IBM MQ(v8.0)
* 项目框架：Spring+SpringMVC+MyBatis
* 作业调度框架：quartz
* 数据库：MySQL

## 3.项目配置过程

* 首先配置IBM MQ的消息队列，配置过程可参照文档[IBM_MQ配置文档](<https://github.com/JeckerWen/ibm_mq-massage-processor/blob/master/doc/IBM_MQ%E6%96%87%E6%A1%A3.docx>)；
* 导入数据库[表SQL脚本](<https://github.com/JeckerWen/ibm_mq-massage-processor/blob/master/doc/%E8%A1%A8%E7%BB%93%E6%9E%84.sql>)；
* 本项目问Maven项目管理，直接导入项目即可。

## 4.接口规范

### 	4.1反馈状态描述

<table>
    <tr>
        <th>类型</th>
        <th>状态代码</th>
        <th>状态描述</th>
    </tr>
    <tr>
        <td rowspan=2 align="center">调用成功</td>
        <td>000</td>
        <td>调用成功</td>
    </tr>
    <tr>
        <td>201</td>
        <td>调用成功（业务系统不需要此类数据）</td>
    </tr>
    <tr>
        <td rowspan=4 align="center">调用过程中出错</td>
        <td>103</td>
        <td>调用失败（调用接口名错误)</td>
    </tr>
    <tr>
        <td>104</td>
        <td>调用失败（数据为空）</td>
    </tr>
    <tr>
        <td>105</td>
        <td>调用失败（应用系统错误）</td>
    </tr>
    <tr>
        <td>200</td>
        <td>200以上由用户自定义类型</td>
    </tr>
    <tr>
        <td align="center">其他</td>
        <td>999</td>
        <td>调用失败（未知类型错误）</td>
    </tr>
</table>

### 4.2反馈格式（xml格式）

````xml
<?xml version="1.0" encoding="gbk"?>
<dataset>
<head>
<msg_id>MDM_TOBACORIG_20110408102522551</msg_id>//保持原样反馈 
<state_code>000</state_code>//参考1.1反馈状态描述
<state_desc>成功导入数据!</state_desc>//根据实际情况反馈
<ws_mark>HNYC_MDM</ws_mark>//反馈本方系统服务标识
<ws_method>transBaseCode</ws_method>//保持原样反馈
<ws_param>transTobacOrigBaseCode</ws_param>//保持原样反馈
<curr_time>2011-04-01 11:25:25</curr_time>//系统当前时间
<curr_user>icss</curr_user>
</head>
</dataset>
````

### 4.3接收消息的格式(xml格式)

- 以烟叶品牌信息为例

  ````xml
  <?xml version="1.0" encoding="GBK"?>
  <dataset>
  <head>	//消息头部信息				
  <msg_id>MDM_TOBACORIG_201104</msg_id>
  <ws_mark>HNYC_MDM</ws_mark>
  <ws_method>transBaseCode</ws_method>
  <ws_param>t_b_c_cig_trademark</ws_param>
  <curr_time>2011-04-08 10:25:22</curr_time>
  <curr_user>icss</curr_user>
  </head>
      
  <datalist> //消息内容信息
  <data>
  <Trademark_code>021430104</Trademark_code>
  <Trademark_name>白沙</Trademark_name>
  <F_isinside>03001</F_isinside>
  <Producing_area>0141</ Producing_area>
  <Maker>001430000</ Maker>
  <F_senior></F_senior>
  <F_stress></F_stress>
  <F_trademark_hundreds></F_trademark_hundreds>
  <Province></Province>
  <status>1</status>
  </data>
  </datalist>
  </dataset>
  ````

> **常见错误可参考[文档](https://github.com/JeckerWen/ibm_mq-massage-processor/blob/master/%E4%BD%BF%E7%94%A8IBM_MQ%E5%B8%B8%E8%A7%81%E9%97%AE%E9%A2%98.md),后面逐步完善。同时欢迎任何人完善。^.^**

> **欢迎任何人参与和完善。欢迎交流:e-mail:：jeckerWen@gmail.com**



















​		

