## 简介
- 什么是倒排索引？
 
    倒排索引(inverted index),个人理解倒排的意思是说，普通的搜索算法是从文档里搜索某个关键词(文章——>关键词)，
    而倒排索引是首先知道了每个关键词都出现在哪些文档里，从关键词搜文档(关键词——>文档)，正好目的反过来。
- 好处
  
    如果对一个很大的文件搜索是否含有一个关键词，常规的做法是遍历整个文档，如果
    关键词在文档的最后，那么速度会很慢。倒排索引先记录了关键词出现在哪些文档中，需要哪个关键词，把含有的文档直接拎出来就好了，速度大大提高，主流的搜索工具，ElasticSearch都是基于倒排索引
- 相关介绍
    https://zhuanlan.zhihu.com/p/324378430
    
    

    