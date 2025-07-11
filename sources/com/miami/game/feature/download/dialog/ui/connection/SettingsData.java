package com.miami.game.feature.download.dialog.ui.connection;

import androidx.autofill.HintConstants;
import androidx.media3.exoplayer.analytics.AnalyticsListener;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: ConnectionHolder.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b!\b\u0087\b\u0018\u00002\u00020\u0001Bk\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\u0006\u0012\b\b\u0002\u0010\n\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\b\b\u0002\u0010\r\u001a\u00020\f\u0012\b\b\u0002\u0010\u000e\u001a\u00020\f¢\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0006HÆ\u0003J\t\u0010!\u001a\u00020\u0006HÆ\u0003J\t\u0010\"\u001a\u00020\u0006HÆ\u0003J\t\u0010#\u001a\u00020\u0006HÆ\u0003J\t\u0010$\u001a\u00020\u0006HÆ\u0003J\t\u0010%\u001a\u00020\fHÆ\u0003J\t\u0010&\u001a\u00020\fHÆ\u0003J\t\u0010'\u001a\u00020\fHÆ\u0003Jm\u0010(\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\u00062\b\b\u0002\u0010\n\u001a\u00020\u00062\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000e\u001a\u00020\fHÆ\u0001J\u0013\u0010)\u001a\u00020\u00062\b\u0010*\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010+\u001a\u00020\u0003HÖ\u0001J\t\u0010,\u001a\u00020\fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0015R\u0011\u0010\b\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0015R\u0011\u0010\t\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0015R\u0011\u0010\n\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0015R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\r\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001bR\u0011\u0010\u000e\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001b¨\u0006-"}, d2 = {"Lcom/miami/game/feature/download/dialog/ui/connection/SettingsData;", "", "pageSize", "", "chatFontSize", "customKeyBoard", "", "streamerMode", "showChatTime", "showFps", "fullScreen", "ip", "", "port", HintConstants.AUTOFILL_HINT_PASSWORD, "<init>", "(IIZZZZZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getPageSize", "()I", "getChatFontSize", "getCustomKeyBoard", "()Z", "getStreamerMode", "getShowChatTime", "getShowFps", "getFullScreen", "getIp", "()Ljava/lang/String;", "getPort", "getPassword", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "copy", "equals", "other", "hashCode", "toString", "dialogs_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class SettingsData {
    public static final int $stable = 0;
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

    public SettingsData() {
        this(0, 0, false, false, false, false, false, null, null, null, AnalyticsListener.EVENT_DRM_KEYS_LOADED, null);
    }

    public static /* synthetic */ SettingsData copy$default(SettingsData settingsData, int i, int i2, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, String str, String str2, String str3, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = settingsData.pageSize;
        }
        if ((i3 & 2) != 0) {
            i2 = settingsData.chatFontSize;
        }
        if ((i3 & 4) != 0) {
            z = settingsData.customKeyBoard;
        }
        if ((i3 & 8) != 0) {
            z2 = settingsData.streamerMode;
        }
        if ((i3 & 16) != 0) {
            z3 = settingsData.showChatTime;
        }
        if ((i3 & 32) != 0) {
            z4 = settingsData.showFps;
        }
        if ((i3 & 64) != 0) {
            z5 = settingsData.fullScreen;
        }
        if ((i3 & 128) != 0) {
            str = settingsData.ip;
        }
        if ((i3 & 256) != 0) {
            str2 = settingsData.port;
        }
        if ((i3 & 512) != 0) {
            str3 = settingsData.password;
        }
        String str4 = str2;
        String str5 = str3;
        boolean z6 = z5;
        String str6 = str;
        boolean z7 = z3;
        boolean z8 = z4;
        return settingsData.copy(i, i2, z, z2, z7, z8, z6, str6, str4, str5);
    }

    public final int component1() {
        return this.pageSize;
    }

    public final String component10() {
        return this.password;
    }

    public final int component2() {
        return this.chatFontSize;
    }

    public final boolean component3() {
        return this.customKeyBoard;
    }

    public final boolean component4() {
        return this.streamerMode;
    }

    public final boolean component5() {
        return this.showChatTime;
    }

    public final boolean component6() {
        return this.showFps;
    }

    public final boolean component7() {
        return this.fullScreen;
    }

    public final String component8() {
        return this.ip;
    }

    public final String component9() {
        return this.port;
    }

    public final SettingsData copy(int i, int i2, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, String ip, String port, String password) {
        Intrinsics.checkNotNullParameter(ip, "ip");
        Intrinsics.checkNotNullParameter(port, "port");
        Intrinsics.checkNotNullParameter(password, "password");
        return new SettingsData(i, i2, z, z2, z3, z4, z5, ip, port, password);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof SettingsData) {
            SettingsData settingsData = (SettingsData) obj;
            return this.pageSize == settingsData.pageSize && this.chatFontSize == settingsData.chatFontSize && this.customKeyBoard == settingsData.customKeyBoard && this.streamerMode == settingsData.streamerMode && this.showChatTime == settingsData.showChatTime && this.showFps == settingsData.showFps && this.fullScreen == settingsData.fullScreen && Intrinsics.areEqual(this.ip, settingsData.ip) && Intrinsics.areEqual(this.port, settingsData.port) && Intrinsics.areEqual(this.password, settingsData.password);
        }
        return false;
    }

    public int hashCode() {
        return (((((((((((((((((Integer.hashCode(this.pageSize) * 31) + Integer.hashCode(this.chatFontSize)) * 31) + Boolean.hashCode(this.customKeyBoard)) * 31) + Boolean.hashCode(this.streamerMode)) * 31) + Boolean.hashCode(this.showChatTime)) * 31) + Boolean.hashCode(this.showFps)) * 31) + Boolean.hashCode(this.fullScreen)) * 31) + this.ip.hashCode()) * 31) + this.port.hashCode()) * 31) + this.password.hashCode();
    }

    public String toString() {
        int i = this.pageSize;
        int i2 = this.chatFontSize;
        boolean z = this.customKeyBoard;
        boolean z2 = this.streamerMode;
        boolean z3 = this.showChatTime;
        boolean z4 = this.showFps;
        boolean z5 = this.fullScreen;
        String str = this.ip;
        String str2 = this.port;
        return "SettingsData(pageSize=" + i + ", chatFontSize=" + i2 + ", customKeyBoard=" + z + ", streamerMode=" + z2 + ", showChatTime=" + z3 + ", showFps=" + z4 + ", fullScreen=" + z5 + ", ip=" + str + ", port=" + str2 + ", password=" + this.password + ")";
    }

    public SettingsData(int i, int i2, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, String ip, String port, String password) {
        Intrinsics.checkNotNullParameter(ip, "ip");
        Intrinsics.checkNotNullParameter(port, "port");
        Intrinsics.checkNotNullParameter(password, "password");
        this.pageSize = i;
        this.chatFontSize = i2;
        this.customKeyBoard = z;
        this.streamerMode = z2;
        this.showChatTime = z3;
        this.showFps = z4;
        this.fullScreen = z5;
        this.ip = ip;
        this.port = port;
        this.password = password;
    }

    public final int getPageSize() {
        return this.pageSize;
    }

    public final int getChatFontSize() {
        return this.chatFontSize;
    }

    public final boolean getCustomKeyBoard() {
        return this.customKeyBoard;
    }

    public final boolean getStreamerMode() {
        return this.streamerMode;
    }

    public final boolean getShowChatTime() {
        return this.showChatTime;
    }

    public final boolean getShowFps() {
        return this.showFps;
    }

    public final boolean getFullScreen() {
        return this.fullScreen;
    }

    public /* synthetic */ SettingsData(int i, int i2, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, String str, String str2, String str3, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? 1 : i, (i3 & 2) != 0 ? 2 : i2, (i3 & 4) != 0 ? false : z, (i3 & 8) != 0 ? false : z2, (i3 & 16) != 0 ? false : z3, (i3 & 32) != 0 ? true : z4, (i3 & 64) != 0 ? true : z5, (i3 & 128) != 0 ? "192.168.0.133" : str, (i3 & 256) != 0 ? "7777" : str2, (i3 & 512) != 0 ? HintConstants.AUTOFILL_HINT_PASSWORD : str3);
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
