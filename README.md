# Votifier-Logger

[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](LICENSE)
[![Platform](https://img.shields.io/badge/Platform-Spigot%20%7C%20Paper-gold.svg)](https://papermc.io/)
[![Minecraft Version](https://img.shields.io/badge/Minecraft-1.21.4-blue.svg)](https://www.minecraft.net/)

**Votifier-Logger** は、Minecraftサーバーへの投票（NuVotifier経由）を詳細に記録し、管理業務を効率化するための軽量なプラグインです。

---

## 🌟 主な機能 (Features)

- **📊 詳細なロギング**: ユーザー名、日時、投票サービス名、IPアドレスを `vote.log` に自動保存。
- **⚙️ 柔軟なカスタマイズ**: `config.yml` からログフォーマットや日付形式を自由に変更可能。
- **💻 コンソール連携**: 投票の受理をリアルタイムでサーバーコンソールに表示。
- **⚡ 高いパフォーマンス**: 効率的なI/O処理により、サーバーのメインスレッドに負荷をかけません。

## 🛠 対応環境 (Requirement)

- **Software**: Spigot / Paper 1.21.x 以上
- **Dependency**: [NuVotifier](https://www.spigotmc.org/resources/nuvotifier.13449/) (必須)

## ⚙️ 設定ファイル (config.yml)

```yaml
# 日付の表示形式
date-format: "yyyy-MM-dd HH:mm:ss"

# ログファイルへの書き出し形式
# 使用可能な変数: %time%, %player%, %service%, %ip%
log-format: "[%time%] %player% - %service% (IP: %ip%)"

# 保存するファイル名
log-file-name: "vote.log"

# コンソールに記録を表示するか
console-log: true

```

## 📝 技術仕様 (Technical Overview)

* **Event Priority**: MONITOR
他のプラグインが投票イベントをキャンセルしていないかを確認した上で、最終的な結果を記録します。
* **Internal Processing**:
Javaの FileWriter と PrintWriter を使用し、追記モードで効率的にファイルへの書き込みを行います。
* **Placeholders**:
以下の変数が log-format 内で使用可能です。
* %time% : 投票時刻
* %player% : プレイヤー名
* %service% : 投票サイト名
* %ip% : プレイヤーのIPアドレス



## 📄 ライセンス (License)

This project is licensed under the MIT License. See the LICENSE file for details.

Copyright (c) 2026 tash087
---
Developed by tash087
