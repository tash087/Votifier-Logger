# Votifier-Logger
Advanced Vote Logging &amp; Administrator Notification Plugin for Minecraft Servers

Markdown
# Votifier-Logger

[![Platform](https://img.shields.io/badge/Platform-Spigot%20%7C%20Paper-gold.svg)](https://papermc.io/)
[![Version](https://img.shields.io/badge/Version-1.21.4-blue.svg)](https://www.minecraft.net/)

**Votifier-Logger** は、Minecraftサーバーへの投票（NuVotifier経由）を詳細に記録し、管理者にリアルタイムで通知するための軽量プラグインです。

---

## 🌟 主な機能

- **📊 詳細なロギング**: ユーザー名、日時、投票サービス名、IPアドレスを `vote.log` に自動保存。
- **🔔 管理者通知**: 投票が行われた際、権限を持つプレイヤー（`votifierlistener.admin`）にチャットで通知。
- **⚙️ 柔軟なカスタマイズ**: `config.yml` からログフォーマットや日付形式を自由に変更可能。
- **⚡ 非同期処理**: サーバーのメインスレッドに負荷をかけない設計。

## 🛠 対応環境

- **Software**: Spigot / Paper 1.21.x 以上
- **Dependency**: [NuVotifier](https://www.spigotmc.org/resources/nuvotifier.13449/) (必須)

## 📦 インストール方法

1. [Releases](../../releases) から最新の `.jar` をダウンロード。
2. サーバーの `plugins` フォルダに配置。
3. サーバーを起動し、生成された `config.yml` を編集。
4. `/gmsreload` (またはサーバー再起動) で設定を反映。

## ⚙️ 設定ファイル (config.yml)

```yaml
# 日付の表示形式
date-format: "yyyy-MM-dd HH:mm:ss"

# ログファイルへの書き出し形式
log-format: "[%time%] %player% - %service% (IP: %ip%)"

# 保存するファイル名
log-file-name: "vote.log"

# コンソールに記録を表示するか
console-log: true

# 管理者(権限保持者)へのチャット通知
notify-admins: true
```

📝 ライセンス
このプロジェクトは MIT License の下で公開されています。

Developed by tash087


---

### 3. GitHub Wiki / Documentation 用の説明文
プラグインの詳細な仕様を説明する場合に使います。

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
