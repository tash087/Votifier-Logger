package jp.tash087.votifierlistener;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;

import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import com.vexsoftware.votifier.model.Vote;
import com.vexsoftware.votifier.model.VotifierEvent;

public class VotifierListener extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        // config.ymlが存在しない場合にデフォルトを生成
        saveDefaultConfig();
        
        getServer().getPluginManager().registerEvents(this, this);
        getLogger().info("VoteLogger by tash087 enabled with config support!");
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public void onVotifierEvent(VotifierEvent event) {
        Vote vote = event.getVote();
        if (vote == null) return; // Nullチェックを追加して安全に

        // Configから設定を取得
        String dateFormatStr = getConfig().getString("date-format", "yyyy-MM-dd HH:mm:ss");
        String logFormat = getConfig().getString("log-format", "[%time%] %player% - %service%");
        String fileName = getConfig().getString("log-file-name", "vote.log");
        boolean showConsole = getConfig().getBoolean("console-log", true);

        // 各項目の取得とNullガード
        String time = new SimpleDateFormat(dateFormatStr != null ? dateFormatStr : "yyyy-MM-dd HH:mm:ss").format(new Date());
        String username = vote.getUsername() != null ? vote.getUsername() : "Unknown";
        String service = vote.getServiceName() != null ? vote.getServiceName() : "Unknown";
        String address = vote.getAddress() != null ? vote.getAddress() : "0.0.0.0";

        // 変数の置換
        String logLine = (logFormat != null ? logFormat : "[%time%] %player% - %service%")
                .replace("%time%", time)
                .replace("%player%", username)
                .replace("%service%", service)
                .replace("%ip%", address);

        // ファイル保存
        if (fileName != null) {
            saveLog(fileName, logLine);
        }

        // コンソール表示（効率的な文字列連結に修正）
        if (showConsole) {
            getLogger().log(Level.INFO, "Log recorded: {0}", username);
        }
    }

    private void saveLog(String fileName, String message) {
        File logFile = new File(getDataFolder(), fileName);
        
        // フォルダがない場合は作成
        if (!getDataFolder().exists()) {
            getDataFolder().mkdirs();
        }

        try (FileWriter fw = new FileWriter(logFile, true);
             PrintWriter pw = new PrintWriter(fw)) {
            pw.println(message);
        } catch (IOException e) {
            getLogger().log(Level.SEVERE, "Could not write to " + fileName, e);
        }
    }
}