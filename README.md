# Votifier-Logger

[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](LICENSE)
[![Platform](https://img.shields.io/badge/Platform-Spigot%20%7C%20Paper-gold.svg)](https://papermc.io/)
[![Minecraft Version](https://img.shields.io/badge/Minecraft-1.21.4-blue.svg)](https://www.minecraft.net/)

**Votifier-Logger** is a lightweight plugin designed to streamline server management by providing detailed logging for Minecraft server votes via NuVotifier.

---

## 🌟 Features

- **📊 Detailed Logging**: Automatically saves usernames, timestamps, voting service names, and IP addresses to `vote.log`.
- **⚙️ Flexible Customization**: Easily modify log formats and date styles directly through `config.yml`.
- **💻 Console Integration**: Real-time display of vote processing in the server console.
- **⚡ Optimized Performance**: Efficient I/O processing ensures minimal impact on the server's main thread.

## 🛠 Requirements

- **Software**: Spigot / Paper 1.21.x or higher
- **Dependency**: [NuVotifier](https://www.spigotmc.org/resources/nuvotifier.13449/) (Required)

## ⚙️ Configuration (config.yml)

```yaml
# ==========================================
# VotifierListener Config by tash087
# ==========================================

# ログファイルの名称
log-file-name: "vote.log"

# ログの記録形式
# 利用可能変数: %time%, %player%, %service%, %ip%
log-format: "[%time%] PLAYER: %player% | SERVICE: %service% | IP: %ip%"

# コンソールにもログを表示するか
console-log: true

# 日付の表示形式
date-format: "yyyy-MM-dd HH:mm:ss"
```

---

## 📝 Technical Overview

* **Event Priority**: `MONITOR`
The plugin monitors events at the final stage to ensure it records the definitive vote status after other plugins have processed or cancelled the event.
* **Internal Processing**:
Uses Java's `FileWriter` and `PrintWriter` in append mode for efficient and safe file writing.
* **Placeholders**:
The following variables can be used within the `log-format`:
* `%time%`: Time of the vote
* `%player%`: Player's username
* `%service%`: Voting site/service name
* `%ip%`: Player's IP address



---

## 📄 License

This project is licensed under the MIT License. See the LICENSE file for details.

Copyright (c) 2026 tash087

---

Developed by **tash087**


```
