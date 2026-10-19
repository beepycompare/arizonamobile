package com.miami.game.feature.download.dialog.ui.connection;

import androidx.autofill.HintConstants;
import com.miami.game.core.settings.SettingsMenuDefaults;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: ConnectionHolder.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b%\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u007f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\u0006\u0012\b\b\u0002\u0010\n\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0006\u0012\b\b\u0002\u0010\f\u001a\u00020\u0006\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u000e¢\u0006\u0004\b\u0011\u0010\u0012J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\t\u0010$\u001a\u00020\u0006HÆ\u0003J\t\u0010%\u001a\u00020\u0006HÆ\u0003J\t\u0010&\u001a\u00020\u0006HÆ\u0003J\t\u0010'\u001a\u00020\u0006HÆ\u0003J\t\u0010(\u001a\u00020\u0006HÆ\u0003J\t\u0010)\u001a\u00020\u0006HÆ\u0003J\t\u0010*\u001a\u00020\u0006HÆ\u0003J\t\u0010+\u001a\u00020\u000eHÆ\u0003J\t\u0010,\u001a\u00020\u000eHÆ\u0003J\t\u0010-\u001a\u00020\u000eHÆ\u0003J\u0081\u0001\u0010.\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\u00062\b\b\u0002\u0010\n\u001a\u00020\u00062\b\b\u0002\u0010\u000b\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\u00062\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u000eHÆ\u0001J\u0014\u0010/\u001a\u00020\u00062\b\u00100\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u00101\u001a\u00020\u0003HÖ\u0081\u0004J\n\u00102\u001a\u00020\u000eHÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0017R\u0011\u0010\b\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0017R\u0011\u0010\t\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0017R\u0011\u0010\n\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0017R\u0011\u0010\u000b\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0017R\u0011\u0010\f\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0017R\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010\u000f\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001fR\u0011\u0010\u0010\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001fÊ\u0001\f\b4\u0012\b\b5\u0012\u0004\b\u0003\u0010\u0002¨\u00063"}, d2 = {"Lcom/miami/game/feature/download/dialog/ui/connection/SettingsData;", "", SettingsMenuDefaults.KEY_CHAT_FONT_SIZE, "", "pageSize", "customKeyBoard", "", "showChatTime", SettingsMenuDefaults.KEY_AMBIENT_SOUNDS, SettingsMenuDefaults.KEY_SHOW_FPS, "updatedGraphics", SettingsMenuDefaults.KEY_FULL_SCREEN, "streamerMode", "ip", "", "port", HintConstants.AUTOFILL_HINT_PASSWORD, "<init>", "(IIZZZZZZZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getChatFontSize", "()I", "getPageSize", "getCustomKeyBoard", "()Z", "getShowChatTime", "getAmbientSounds", "getShowFps", "getUpdatedGraphics", "getFullScreen", "getStreamerMode", "getIp", "()Ljava/lang/String;", "getPort", "getPassword", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "copy", "equals", "other", "hashCode", "toString", "dialogs", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SettingsData {
    public static final int $stable = 0;
    private final boolean ambientSounds;
    private final int chatFontSize;
    private final boolean customKeyBoard;
    private final boolean fullScreen;
    private final String ip;
    private final int pageSize;
    private final String password;
    private final String port;
    private final boolean showChatTime;
    private final boolean showFps;
    private final boolean streamerMode;
    private final boolean updatedGraphics;

    public SettingsData() {
        this(0, 0, false, false, false, false, false, false, false, null, null, null, 4095, null);
    }

    public static /* synthetic */ SettingsData copy$default(SettingsData settingsData, int i, int i2, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, String str, String str2, String str3, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = settingsData.chatFontSize;
        }
        if ((i3 & 2) != 0) {
            i2 = settingsData.pageSize;
        }
        if ((i3 & 4) != 0) {
            z = settingsData.customKeyBoard;
        }
        if ((i3 & 8) != 0) {
            z2 = settingsData.showChatTime;
        }
        if ((i3 & 16) != 0) {
            z3 = settingsData.ambientSounds;
        }
        if ((i3 & 32) != 0) {
            z4 = settingsData.showFps;
        }
        if ((i3 & 64) != 0) {
            z5 = settingsData.updatedGraphics;
        }
        if ((i3 & 128) != 0) {
            z6 = settingsData.fullScreen;
        }
        if ((i3 & 256) != 0) {
            z7 = settingsData.streamerMode;
        }
        if ((i3 & 512) != 0) {
            str = settingsData.ip;
        }
        if ((i3 & 1024) != 0) {
            str2 = settingsData.port;
        }
        if ((i3 & 2048) != 0) {
            str3 = settingsData.password;
        }
        String str4 = str2;
        String str5 = str3;
        boolean z8 = z7;
        String str6 = str;
        boolean z9 = z5;
        boolean z10 = z6;
        boolean z11 = z3;
        boolean z12 = z4;
        return settingsData.copy(i, i2, z, z2, z11, z12, z9, z10, z8, str6, str4, str5);
    }

    public final int component1() {
        return this.chatFontSize;
    }

    public final String component10() {
        return this.ip;
    }

    public final String component11() {
        return this.port;
    }

    public final String component12() {
        return this.password;
    }

    public final int component2() {
        return this.pageSize;
    }

    public final boolean component3() {
        return this.customKeyBoard;
    }

    public final boolean component4() {
        return this.showChatTime;
    }

    public final boolean component5() {
        return this.ambientSounds;
    }

    public final boolean component6() {
        return this.showFps;
    }

    public final boolean component7() {
        return this.updatedGraphics;
    }

    public final boolean component8() {
        return this.fullScreen;
    }

    public final boolean component9() {
        return this.streamerMode;
    }

    public final SettingsData copy(int i, int i2, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, String ip, String port, String password) {
        Intrinsics.checkNotNullParameter(ip, "ip");
        Intrinsics.checkNotNullParameter(port, "port");
        Intrinsics.checkNotNullParameter(password, "password");
        return new SettingsData(i, i2, z, z2, z3, z4, z5, z6, z7, ip, port, password);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof SettingsData) {
            SettingsData settingsData = (SettingsData) obj;
            return this.chatFontSize == settingsData.chatFontSize && this.pageSize == settingsData.pageSize && this.customKeyBoard == settingsData.customKeyBoard && this.showChatTime == settingsData.showChatTime && this.ambientSounds == settingsData.ambientSounds && this.showFps == settingsData.showFps && this.updatedGraphics == settingsData.updatedGraphics && this.fullScreen == settingsData.fullScreen && this.streamerMode == settingsData.streamerMode && Intrinsics.areEqual(this.ip, settingsData.ip) && Intrinsics.areEqual(this.port, settingsData.port) && Intrinsics.areEqual(this.password, settingsData.password);
        }
        return false;
    }

    public int hashCode() {
        return (((((((((((((((((((((Integer.hashCode(this.chatFontSize) * 31) + Integer.hashCode(this.pageSize)) * 31) + Boolean.hashCode(this.customKeyBoard)) * 31) + Boolean.hashCode(this.showChatTime)) * 31) + Boolean.hashCode(this.ambientSounds)) * 31) + Boolean.hashCode(this.showFps)) * 31) + Boolean.hashCode(this.updatedGraphics)) * 31) + Boolean.hashCode(this.fullScreen)) * 31) + Boolean.hashCode(this.streamerMode)) * 31) + this.ip.hashCode()) * 31) + this.port.hashCode()) * 31) + this.password.hashCode();
    }

    public String toString() {
        int i = this.chatFontSize;
        int i2 = this.pageSize;
        boolean z = this.customKeyBoard;
        boolean z2 = this.showChatTime;
        boolean z3 = this.ambientSounds;
        boolean z4 = this.showFps;
        boolean z5 = this.updatedGraphics;
        boolean z6 = this.fullScreen;
        boolean z7 = this.streamerMode;
        String str = this.ip;
        String str2 = this.port;
        return "SettingsData(chatFontSize=" + i + ", pageSize=" + i2 + ", customKeyBoard=" + z + ", showChatTime=" + z2 + ", ambientSounds=" + z3 + ", showFps=" + z4 + ", updatedGraphics=" + z5 + ", fullScreen=" + z6 + ", streamerMode=" + z7 + ", ip=" + str + ", port=" + str2 + ", password=" + this.password + ")";
    }

    public SettingsData(int i, int i2, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, String ip, String port, String password) {
        Intrinsics.checkNotNullParameter(ip, "ip");
        Intrinsics.checkNotNullParameter(port, "port");
        Intrinsics.checkNotNullParameter(password, "password");
        this.chatFontSize = i;
        this.pageSize = i2;
        this.customKeyBoard = z;
        this.showChatTime = z2;
        this.ambientSounds = z3;
        this.showFps = z4;
        this.updatedGraphics = z5;
        this.fullScreen = z6;
        this.streamerMode = z7;
        this.ip = ip;
        this.port = port;
        this.password = password;
    }

    public final int getChatFontSize() {
        return this.chatFontSize;
    }

    public final int getPageSize() {
        return this.pageSize;
    }

    public final boolean getCustomKeyBoard() {
        return this.customKeyBoard;
    }

    public final boolean getShowChatTime() {
        return this.showChatTime;
    }

    public final boolean getAmbientSounds() {
        return this.ambientSounds;
    }

    public final boolean getShowFps() {
        return this.showFps;
    }

    public final boolean getUpdatedGraphics() {
        return this.updatedGraphics;
    }

    public final boolean getFullScreen() {
        return this.fullScreen;
    }

    public final boolean getStreamerMode() {
        return this.streamerMode;
    }

    public /* synthetic */ SettingsData(int i, int i2, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, String str, String str2, String str3, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? 1 : i, (i3 & 2) != 0 ? 10 : i2, (i3 & 4) != 0 ? false : z, (i3 & 8) != 0 ? false : z2, (i3 & 16) != 0 ? true : z3, (i3 & 32) != 0 ? false : z4, (i3 & 64) != 0 ? true : z5, (i3 & 128) == 0 ? z6 : true, (i3 & 256) == 0 ? z7 : false, (i3 & 512) != 0 ? "192.168.0.133" : str, (i3 & 1024) != 0 ? "7777" : str2, (i3 & 2048) != 0 ? HintConstants.AUTOFILL_HINT_PASSWORD : str3);
    }

    public final String getIp() {
        return this.ip;
    }

    public final String getPort() {
        return this.port;
    }

    public final String getPassword() {
        return this.password;
    }
}
