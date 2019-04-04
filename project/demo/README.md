# Demo

使用JavaFX + TornadoFX + Kotlin + Gradle构建的，**静态数据、只用于展现架构的**Demo应用。

# 已实现

- 通过RMI，客户端与服务器端交互
- 部分重要架构设计（例如网络模块ping-echo和重连机制，一些模块的缓存、请求队列机制）
- 部分模块的Log记录，可用来验证系统数据流和模块交互的情况

# 运行和开发

1. 保证**8888端口空闲**，**JDK 8已安装**以及**IDEA安装了Kotlin插件**
2. 使用Intellij IDEA打开本项目
3. 等待Gradle安装依赖
4. （可选，推荐）安装TornadoFX的Intellij IDEA插件：https://github.com/edvin/tornadofx-guide/blob/master/part1/12.%20TornadoFX%20IDEA%20Plugin.md
5. 运行Server子项目下的Server运行服务器，当服务器启动之后，再运行Client子项目下的Client的main方法启动客户端

# 登录预设账号

| 角色 | 用户名 | 密码 |
| -- | -- | -- |
| 教师 | teacher | teacher |
| 学生 | student | student |