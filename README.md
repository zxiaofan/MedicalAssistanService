# MedicalAssistanService
# **医疗助手之云端服务**    
项目简介：  
&emsp;&emsp;本项目是个人毕业设计【医疗小助手】中的【云端部分】，主要包含【数据打底服务】【疾病自诊及医疗资源推荐服务】两大模块。  
**系统架构如图**：  

![image](https://github.com/zxiaofan/MedicalAssistanService/blob/master/WebContent/WEB-INF/images/%E5%8C%BB%E7%96%97%E5%8A%A9%E6%89%8B%E7%B3%BB%E7%BB%9F%E6%80%BB%E4%BD%93%E6%9E%B6%E6%9E%84%E5%9B%BE.png)  

**云端主流程**：  

![image](https://github.com/zxiaofan/MedicalAssistanService/blob/master/WebContent/WEB-INF/images/%E4%BA%91%E7%AB%AF%E4%B8%BB%E6%B5%81%E7%A8%8B.png)  

   **更多图片详见**：  

(https://github.com/zxiaofan/MedicalAssistanService/blob/master/WebContent/WEB-INF/images 

1. __数据打底服务数据来源于第三方医疗网站：__  
   1.1 以Spring+Jsoup+MyBatis作为打底框架，爬取数据并筛选入库   
   1.2 诊疗基础数据来源于“医博士”<接口IDrmedService>；  
   1.3 医院、医生信息来源于“好大夫”<接口IHaodfService>。  
   1.4 \WebContent\WEB-INF\sql目录含有备份的sql，可直接用其还原数据；  
   1.5 test目录下含有数据打底的测试类，暂未加入定时框架定期打底数据库。  
2. __自诊及医疗资源推荐服务：__   
   2.1 相关接口 <IAPIService>：注册、登录、根据病症诊断疾病、根据疾病推荐医生、根据疾病推荐医院；  
   2.2 系统根据用户选择的病症情况筛选匹配度最高的疾病；  
   2.3 根据用户选择的意思疾病为用户推荐医疗资源（医生、医院等）。    
3. __其他说明：__   
   3.1 本项目及项目中从第三方网站获取的数据仅供学习测试使用，请勿用于非法用途,任何非法使用均与源作者无关；  
   3.2 医疗助手之移动端详见本人另一开源项目YunYiAPP ![YunYiAPP](https://github.com/zxiaofan/YunYiAPP)；  
