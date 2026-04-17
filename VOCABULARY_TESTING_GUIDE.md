# CET6 Vocabulary App - 词汇功能测试指南

## 测试概述

本文档提供了CET6词汇应用的词汇功能测试指南，包括单元测试、集成测试和手动测试步骤。

## 自动化测试

### 1. 词汇加载器测试 (VocabularyLoaderTest)

**测试文件位置**: `app/src/test/java/com/example/cet6vocabulary/data/utils/VocabularyLoaderTest.kt`

**测试用例**:
- `parseCSVLine should return Word object when line has valid format`: 验证CSV行解析功能
- `parseCSVLine should return null when line has insufficient parts`: 验证错误处理
- `validateVocabularyData should filter out invalid words`: 验证数据验证功能
- `validateVocabularyData should return failure when all words are invalid`: 验证错误情况处理
- `validateVocabularyData should preserve word properties`: 验证数据完整性

**运行测试**:
```bash
./gradlew test --tests VocabularyLoaderTest
```

### 2. 数据库集成测试 (AppDatabaseIntegrationTest)

**测试文件位置**: `app/src/test/java/com/example/cet6vocabulary/data/database/AppDatabaseIntegrationTest.kt`

**测试用例**:
- `database should be created successfully`: 验证数据库创建
- `insertWord should add word to database`: 验证单词插入
- `getAllWords should return all words in database`: 验证数据检索
- `updateWord should modify existing word`: 验证数据更新
- `deleteWord should remove word from database`: 验证数据删除
- `getWordsByMasteredStatus should filter by mastery status`: 验证状态过滤
- `searchWords should find words matching query`: 验证搜索功能
- `updateWordMasteryStatus should update word mastery information`: 验证掌握状态更新
- `getWordsForReview should return words due for review`: 验证复习功能
- `database should handle large number of words efficiently`: 验证性能

**运行测试**:
```bash
./gradlew test --tests AppDatabaseIntegrationTest
```

## 手动测试步骤

### 1. 应用启动测试

**步骤**:
1. 清除应用数据
2. 启动应用
3. 观察启动屏幕

**预期结果**:
- 应用显示启动屏幕
- 自动导航到主屏幕
- 数据库自动初始化并加载词汇数据

### 2. 词汇数据加载测试

**步骤**:
1. 启动应用
2. 进入"词汇列表"页面
3. 检查词汇数量

**预期结果**:
- 词汇列表显示所有加载的CET6词汇
- 每个词汇包含单词、音标、词性、释义和例句
- 词汇数量与CSV文件中的条目数一致

### 3. 单词学习功能测试

**步骤**:
1. 进入"开始学习"页面
2. 查看单词卡片
3. 向左滑动标记为"已掌握"
4. 向右滑动标记为"未掌握"

**预期结果**:
- 单词卡片正确显示单词信息
- 滑动手势响应正常
- 掌握状态正确更新
- 自动切换到下一个单词

### 4. 复习功能测试

**步骤**:
1. 学习一些单词
2. 等待一段时间或修改系统时间
3. 进入"复习单词"页面
4. 查看需要复习的单词

**预期结果**:
- 显示到期的复习单词
- 复习时间间隔符合艾宾浩斯遗忘曲线
- 复习后更新下次复习时间

### 5. 搜索功能测试

**步骤**:
1. 进入"词汇列表"页面
2. 输入搜索关键词
3. 查看搜索结果

**预期结果**:
- 搜索结果匹配关键词
- 搜索响应快速
- 支持模糊搜索

### 6. 统计功能测试

**步骤**:
1. 学习和复习一些单词
2. 进入"统计"页面
3. 查看学习数据

**预期结果**:
- 显示学习进度
- 显示掌握率
- 显示复习记录
- 数据可视化正确

## 性能测试

### 1. 大数据量测试

**测试场景**:
- 加载1000+词汇
- 搜索性能
- 列表滚动性能

**性能指标**:
- 应用启动时间 < 3秒
- 搜索响应时间 < 500ms
- 列表滚动流畅 (60fps)

### 2. 内存使用测试

**测试场景**:
- 长时间使用应用
- 多次切换页面
- 大量数据操作

**性能指标**:
- 内存使用稳定
- 无内存泄漏
- GC频率合理

## 数据验证测试

### 1. CSV数据格式验证

**验证项**:
- CSV文件格式正确
- 字段分隔符正确
- 特殊字符处理正确
- 编码格式正确 (UTF-8)

### 2. 数据完整性验证

**验证项**:
- 所有字段都有值
- 数据类型正确
- 无重复数据
- 无损坏数据

## 错误处理测试

### 1. 文件缺失测试

**测试场景**:
- 删除assets中的CSV文件
- 启动应用

**预期结果**:
- 应用正常启动
- 显示友好的错误提示
- 不崩溃

### 2. 数据损坏测试

**测试场景**:
- 修改CSV文件格式
- 添加错误数据行

**预期结果**:
- 跳过错误数据行
- 加载有效数据
- 记录错误日志

## 测试报告模板

### 测试执行记录

| 测试项 | 测试结果 | 备注 |
|--------|----------|------|
| 应用启动 | ✅ 通过 | |
| 词汇加载 | ✅ 通过 | 加载200个词汇 |
| 单词学习 | ✅ 通过 | 滑动功能正常 |
| 复习功能 | ✅ 通过 | 时间间隔正确 |
| 搜索功能 | ✅ 通过 | 响应快速 |
| 统计功能 | ✅ 通过 | 数据准确 |
| 性能测试 | ✅ 通过 | 满足性能要求 |
| 错误处理 | ✅ 通过 | 处理得当 |

### 发现的问题

1. **问题描述**: 
   - **严重程度**: 高/中/低
   - **重现步骤**: 
   - **预期结果**: 
   - **实际结果**: 
   - **解决方案**: 

## 测试环境要求

- Android设备或模拟器 (API 24+)
- Android Studio
- Gradle 8.0+
- Kotlin 1.9+
- 测试数据: cet6_words.csv

## 测试完成标准

- 所有单元测试通过
- 所有集成测试通过
- 所有手动测试用例通过
- 性能指标达标
- 无严重bug
- 用户体验良好