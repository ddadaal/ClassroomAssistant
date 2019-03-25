# 质量属性效用树
|质量属性|具体属性|场景|
|----|----|----|
|安全性|数据安全|A1：攻击者获得数据库数据后,无法解析加密后的数据[中, 中]|
|安全性|权限控制|A2：系统在2秒内拒绝未验证用户的购票操作[高, 中]|

# ATAM分析
<table>
	<tr>
		<th>场景A1</th>
		<th colspan='4'>攻击者获得数据库数据后,无法解析加密后的数据</th>
	</tr>
	<tr>
		<td>质量属性</td>
		<td colspan='4'>安全性</td>
	</tr>
	<tr>
		<td>环境</td>
		<td colspan='4'>系统运⾏环境，系统正常运行;或者系统整体测试时</td>
	</tr>
	<tr>
		<td>刺激</td>
		<td colspan='4'>数据库数据被窃取</td>
	</tr>
	<tr>
		<td>响应</td>
		<td colspan='4'>1. 系统发现用户断线时，记录断线信息<br>2. 当用户重连时恢复用户断线前的现场信息</td>
	</tr>
	<tr>
			<th>架构决策</th>
			<th>敏感点</th>
			<th>权衡点</th>
			<th>风险</th>
			<th>非风险</th>
	</tr>
	<tr>
		<td>ping/echo机制</td>
		<td>S4</td>
		<td></td>
		<td></td>
		<td>N4</td>
	</tr>
	<tr>
		<td>出错重试</td>
		<td></td>
		<td>T4</td>
		<td>R2</td>
		<td></td>
	</tr>
	<tr>
		<td>理由说明</td>
		<td colspan='4'>通过ping/echo的检测机制,系统能够尽早发现连接异常,并采取出错重试的恢复措施</td>
	</tr>
	<tr>
		<td>相关架构图</td>
		<td colspan='4'><img src='img/A4.png'></img></td>
	</tr>
</table>

<table>
	<tr>
		<th>场景A2</th>
		<th colspan='4'>系统在2秒内拒绝未验证用户的购票操作</th>
	</tr>
	<tr>
		<td>质量属性</td>
		<td colspan='4'>安全性</td>
	</tr>
	<tr>
		<td>环境</td>
		<td colspan='4'>整体系统正常运行</td>
	</tr>
	<tr>
		<td>刺激</td>
		<td colspan='4'>用户断线</td>
	</tr>
	<tr>
		<td>响应</td>
		<td colspan='4'>1. 系统发现用户断线时，记录断线信息<br/>2. 当用户重连时恢复用户断线前的现场信息</td>
	</tr>
	<tr>
			<th>架构决策</th>
			<th>敏感点</th>
			<th>权衡点</th>
			<th>风险</th>
			<th>非风险</th>
	</tr>
	<tr>
		<td>ping/echo机制</td>
		<td>S4</td>
		<td></td>
		<td></td>
		<td>N4</td>
	</tr>
	<tr>
		<td>出错重试</td>
		<td></td>
		<td>T4</td>
		<td>R2</td>
		<td></td>
	</tr>
	<tr>
		<td>理由说明</td>
		<td colspan='4'>通过ping/echo的检测机制,系统能够尽早发现连接异常,并采取出错重试的恢复措施</td>
	</tr>
	<tr>
		<td>相关架构图</td>
		<td colspan='4'><img src='img/A4.png'></img></td>
	</tr>
</table>