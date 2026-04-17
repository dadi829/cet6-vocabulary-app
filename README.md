📖 CET6 Vocabulary App - 六级词汇学习助手
一款基于 Jetpack Compose + Room Database 开发的六级词汇学习 App，专注于高效、科学的词汇记忆。
✨ 核心功能
📚 词汇管理：内置 CET6 词库，支持 CSV 文件导入、单词搜索与筛选
🎴 闪卡学习：艾宾浩斯遗忘曲线算法，智能安排复习计划
🔄 间隔重复：根据掌握度自动调整复习频率，告别死记硬背
📊 学习统计：掌握率、复习频率、学习时长可视化展示
📖 词汇列表：完整词库浏览，支持收藏与单词详情查看
🛠️ 技术栈
| 技术 | 用途 |
|:---:|:---|
| Kotlin | 💙 主力开发语言 |
| Jetpack Compose | 🎨 现代化声明式 UI |
| Room Database | 💾 本地数据持久化 |
| Kotlin Coroutines | ⚡ 异步数据处理 |
| Navigation Compose | 🧭 页面导航 |

📱 界面预览

| 🎴 学习界面 | 🔄 复习界面 | 📊 统计界面 |
|:---:|:---:|:---:|
| 闪卡式单词展示，支持左右滑动标记掌握状态 | 智能复习队列，优先复习高频遗忘单词 | 学习数据可视化，进度一目了然 |
| *沉浸式学习体验* | *科学记忆规划* | *直观数据反馈* |
🚀 快速开始
1. 克隆项目
bash
运行
git clone https://github.com/dadi829/cet6-vocabulary-app.git
cd cet6-vocabulary-app
2. 构建运行
使用 Android Studio / Trae 打开项目
等待 Gradle 同步完成
连接 Android 模拟器或真机
点击运行按钮，安装 App 到设备
3. 自定义词库
准备 CSV 格式词库文件，格式为：
csv
word,phonetic,partOfSpeech,definition,example
将文件放入 app/src/main/assets 目录
修改 VocabularyLoader.kt 中的文件名，重新构建即可
📂 项目结构
plaintext
app/
├── src/main/
│   ├── java/com/example/cet6vocabulary/
│   │   ├── data/          # 数据层（数据库、Repository）
│   │   ├── ui/            # 界面层（Compose页面、组件）
│   │   ├── viewmodel/     # 视图模型层
│   │   └── navigation/    # 导航配置
│   └── assets/            # 词库CSV文件
└── build.gradle.kts       # 项目构建配置

📈 版本历史
v1.0.0（当前版本）
核心架构实现：MVVM + Room + Compose
基础功能：词汇加载、学习、复习、统计
完整测试覆盖，支持后续功能扩展
🎯 未来计划
 新增单词发音功能
 深色模式与自定义主题
 错题本与专项练习
 云端数据同步与备份
 游戏化学习元素（打卡、成就）
📄 许可证
本项目仅供个人学习使用，未经许可禁止商用。