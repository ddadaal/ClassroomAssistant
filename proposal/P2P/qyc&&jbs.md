# 1. 设计图说明

1. 一共分为两种节点：服务器节点和客户端节点。

2. 服务端节点主要是服务注册模块，客户端则包含服务注册、学生功能、老师功能、权限检查模块

# 2. 场景说明

### 2.1 网络初始化

服务端节点建议跑在固定的服务器上，在网络开始建立时，客户端节点向服务端注册自己，同时可以发现其他已注册的节点，这样就可以在客户端节点间建立连接，网络逐步形成。

### 2.2 网络形成后客户端的交流

每个客户端都会维持一个连接列表，通信时先查询自己的列表中是否包含通信对象，若包含，则直接通信；若不包含，则会向自己的邻居节点查询，得到通信对象的信息后更新连接列表，通信。

# 3. 技术说明

1. NAT穿透

2. TCP Hole Punching

# 4. 优点&&缺点

### 4.1 优点

相对于基于蓝牙的P2P实现，本架构更加鲁棒，因为服务端节点挂掉的可能性较小。同时，可以服务于更大范围，比如跨教室、跨校区课程。

### 4.2 缺点

硬件成本、维护成本都要比基于蓝牙的实现要高。

# 5. 参考资料

1. [Peer-to-Peer Communication Across Network Address Translators](http://bford.info/pub/net/p2pnat/index.html)

2. [穿越防火牆技術](http://www.cs.nccu.edu.tw/~lien/Writing/NGN/firewall.htm)

3. [WebRTC and the Ocean of Acronyms](https://hacks.mozilla.org/2013/07/webrtc-and-the-ocean-of-acronyms/)