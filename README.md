# ssm_background

																										
																										
																										
	SSM																									
p配置文件																										
																										
	 在 resource文件夹中新建一个spring-mvc.xml																									
	  作用：主要用于配置Controller的组件扫描器和视图解析器																									
																										
																										
																										
																										
																										
	在 resource文件夹中新建一个jdbc.properties，这个文件是用于存储与mysql数据库连接的一些信息																									
																										
																										
																										
	同样的在resource文件夹中新建一个log4j.properties，用户存储log配置的信息																									
																										
																										
																										
																										
																										
	spring-mybatis.xml								  在 resource文件夹中新建一个spring-mybatis.xml，并同时新建一个mapper文件夹，这一步主要是将spring和mybatis进行整合，主要的就是自动扫描，自动注入和配置数据库。																	
																										
																										
	src->main->webapp->WEB-INF->web.xml								文件作用:web.xml文件是用来初始化配置信息，我将它理解为android中的AndroidManifest.xml，你只有在这里对spring-mybatis.xml以及spring-mvc.xml进行注册了，才能使其生效																	
