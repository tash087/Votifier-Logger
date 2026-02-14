# Votifier-Logger
Advanced Vote Logging &amp; Administrator Notification Plugin for Minecraft Servers

# Votifier-Logger

A lightweight Minecraft plugin for logging NuVotifier votes and notifying administrators.

## 🌟 Features
- **Logging**: Detailed vote data saved to `vote.log`.
- **Notification**: Real-time alerts for online staff with `votifierlistener.admin` permission.
- **Customizable**: Change log formats and date styles via `config.yml`.

## ⚙️ Configuration
```yaml
date-format: "yyyy-MM-dd HH:mm:ss"
log-format: "[%time%] %player% - %service% (IP: %ip%)"
log-file-name: "vote.log"
console-log: true
notify-admins: true
```
📝 License
This project is licensed under the MIT License. See the LICENSE file for details.

Copyright (c) 2026 tash087

---
プラグインの詳細仕様説明

```text
## 技術仕様 (Technical Overview)

- **Event Priority**: MONITOR
  他のプラグインが投票イベントをキャンセルしていないかを確認した上で、最終的な結果を記録します。
  
- **Internal Processing**:
  Javaの `FileWriter` と `PrintWriter` を使用し、バッファを効率的に処理してファイルへの書き込みを行います。

- **Placeholders**:
  以下の変数が log-format 内で使用可能です。
  - %time% : 投票時刻
  - %player% : プレイヤー名
  - %service% : 投票サイト名
  - %ip% : プレイヤーのIPアドレス
