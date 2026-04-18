package com.miami.game.feature.download.dialog.ui.connection;

import androidx.autofill.HintConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: ConnectionHolder.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b&\b\u0087\b\u0018\u00002\u00020\u0001B\u007f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\u0007\u0012\b\b\u0002\u0010\n\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\f\u001a\u00020\u0007\u0012\b\b\u0002\u0010\r\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u000f¢\u0006\u0004\b\u0012\u0010\u0013J\t\u0010$\u001a\u00020\u0003HÆ\u0003J\t\u0010%\u001a\u00020\u0005HÆ\u0003J\t\u0010&\u001a\u00020\u0007HÆ\u0003J\t\u0010'\u001a\u00020\u0007HÆ\u0003J\t\u0010(\u001a\u00020\u0007HÆ\u0003J\t\u0010)\u001a\u00020\u0007HÆ\u0003J\t\u0010*\u001a\u00020\u0007HÆ\u0003J\t\u0010+\u001a\u00020\u0007HÆ\u0003J\t\u0010,\u001a\u00020\u0007HÆ\u0003J\t\u0010-\u001a\u00020\u000fHÆ\u0003J\t\u0010.\u001a\u00020\u000fHÆ\u0003J\t\u0010/\u001a\u00020\u000fHÆ\u0003J\u0081\u0001\u00100\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\u00072\b\b\u0002\u0010\u000b\u001a\u00020\u00072\b\b\u0002\u0010\f\u001a\u00020\u00072\b\b\u0002\u0010\r\u001a\u00020\u00072\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\u000fHÆ\u0001J\u0014\u00101\u001a\u00020\u00072\b\u00102\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u00103\u001a\u00020\u0003HÖ\u0081\u0004J\n\u00104\u001a\u00020\u000fHÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0019R\u0011\u0010\t\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0019R\u0011\u0010\n\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0019R\u0011\u0010\u000b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0019R\u0011\u0010\f\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0019R\u0011\u0010\r\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0019R\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0011\u0010\u0010\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010!R\u0011\u0010\u0011\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b#\u0010!¨\u00065"}, d2 = {"Lcom/miami/game/feature/download/dialog/ui/connection/SettingsData;", "", "pageSize", "", "chatFontSize", "", "customKeyBoard", "", "streamerMode", "showChatTime", "ambientSounds", "showFps", "updatedGraphics", "fullScreen", "ip", "", "port", HintConstants.AUTOFILL_HINT_PASSWORD, "<init>", "(IFZZZZZZZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getPageSize", "()I", "getChatFontSize", "()F", "getCustomKeyBoard", "()Z", "getStreamerMode", "getShowChatTime", "getAmbientSounds", "getShowFps", "getUpdatedGraphics", "getFullScreen", "getIp", "()Ljava/lang/String;", "getPort", "getPassword", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "copy", "equals", "other", "hashCode", "toString", "dialogs"}, k = 1, mv = {2, 3, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class SettingsData {
    public static final int $stable = 0;
    private final boolean ambientSounds;
    private final float chatFontSize;
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
        this(0, 0.0f, false, false, false, false, false, false, false, null, null, null, 4095, null);
    }

    public static /* synthetic */ SettingsData copy$default(SettingsData settingsData, int i, float f, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, String str, String str2, String str3, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = settingsData.pageSize;
        }
        if ((i2 & 2) != 0) {
            f = settingsData.chatFontSize;
        }
        if ((i2 & 4) != 0) {
            z = settingsData.customKeyBoard;
        }
        if ((i2 & 8) != 0) {
            z2 = settingsData.streamerMode;
        }
        if ((i2 & 16) != 0) {
            z3 = settingsData.showChatTime;
        }
        if ((i2 & 32) != 0) {
            z4 = settingsData.ambientSounds;
        }
        if ((i2 & 64) != 0) {
            z5 = settingsData.showFps;
        }
        if ((i2 & 128) != 0) {
            z6 = settingsData.updatedGraphics;
        }
        if ((i2 & 256) != 0) {
            z7 = settingsData.fullScreen;
        }
        if ((i2 & 512) != 0) {
            str = settingsData.ip;
        }
        if ((i2 & 1024) != 0) {
            str2 = settingsData.port;
        }
        if ((i2 & 2048) != 0) {
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
        return settingsData.copy(i, f, z, z2, z11, z12, z9, z10, z8, str6, str4, str5);
    }

    public final int component1() {
        return this.pageSize;
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

    public final float component2() {
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
        return this.ambientSounds;
    }

    public final boolean component7() {
        return this.showFps;
    }

    public final boolean component8() {
        return this.updatedGraphics;
    }

    public final boolean component9() {
        return this.fullScreen;
    }

    public final SettingsData copy(int i, float f, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, String ip, String port, String password) {
        Intrinsics.checkNotNullParameter(ip, "ip");
        Intrinsics.checkNotNullParameter(port, "port");
        Intrinsics.checkNotNullParameter(password, "password");
        return new SettingsData(i, f, z, z2, z3, z4, z5, z6, z7, ip, port, password);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof SettingsData) {
            SettingsData settingsData = (SettingsData) obj;
            return this.pageSize == settingsData.pageSize && Float.compare(this.chatFontSize, settingsData.chatFontSize) == 0 && this.customKeyBoard == settingsData.customKeyBoard && this.streamerMode == settingsData.streamerMode && this.showChatTime == settingsData.showChatTime && this.ambientSounds == settingsData.ambientSounds && this.showFps == settingsData.showFps && this.updatedGraphics == settingsData.updatedGraphics && this.fullScreen == settingsData.fullScreen && Intrinsics.areEqual(this.ip, settingsData.ip) && Intrinsics.areEqual(this.port, settingsData.port) && Intrinsics.areEqual(this.password, settingsData.password);
        }
        return false;
    }

    public int hashCode() {
        return (((((((((((((((((((((Integer.hashCode(this.pageSize) * 31) + Float.hashCode(this.chatFontSize)) * 31) + Boolean.hashCode(this.customKeyBoard)) * 31) + Boolean.hashCode(this.streamerMode)) * 31) + Boolean.hashCode(this.showChatTime)) * 31) + Boolean.hashCode(this.ambientSounds)) * 31) + Boolean.hashCode(this.showFps)) * 31) + Boolean.hashCode(this.updatedGraphics)) * 31) + Boolean.hashCode(this.fullScreen)) * 31) + this.ip.hashCode()) * 31) + this.port.hashCode()) * 31) + this.password.hashCode();
    }

    public String toString() {
        int i = this.pageSize;
        float f = this.chatFontSize;
        boolean z = this.customKeyBoard;
        boolean z2 = this.streamerMode;
        boolean z3 = this.showChatTime;
        boolean z4 = this.ambientSounds;
        boolean z5 = this.showFps;
        boolean z6 = this.updatedGraphics;
        boolean z7 = this.fullScreen;
        String str = this.ip;
        String str2 = this.port;
        return "SettingsData(pageSize=" + i + ", chatFontSize=" + f + ", customKeyBoard=" + z + ", streamerMode=" + z2 + ", showChatTime=" + z3 + ", ambientSounds=" + z4 + ", showFps=" + z5 + ", updatedGraphics=" + z6 + ", fullScreen=" + z7 + ", ip=" + str + ", port=" + str2 + ", password=" + this.password + ")";
    }

    public SettingsData(int i, float f, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, String ip, String port, String password) {
        Intrinsics.checkNotNullParameter(ip, "ip");
        Intrinsics.checkNotNullParameter(port, "port");
        Intrinsics.checkNotNullParameter(password, "password");
        this.pageSize = i;
        this.chatFontSize = f;
        this.customKeyBoard = z;
        this.streamerMode = z2;
        this.showChatTime = z3;
        this.ambientSounds = z4;
        this.showFps = z5;
        this.updatedGraphics = z6;
        this.fullScreen = z7;
        this.ip = ip;
        this.port = port;
        this.password = password;
    }

    public final int getPageSize() {
        return this.pageSize;
    }

    public final float getChatFontSize() {
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

    public /* synthetic */ SettingsData(int i, float f, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, String str, String str2, String str3, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 1 : i, (i2 & 2) != 0 ? 1.0f : f, (i2 & 4) != 0 ? false : z, (i2 & 8) != 0 ? false : z2, (i2 & 16) == 0 ? z3 : false, (i2 & 32) != 0 ? true : z4, (i2 & 64) != 0 ? true : z5, (i2 & 128) != 0 ? true : z6, (i2 & 256) == 0 ? z7 : true, (i2 & 512) != 0 ? "192.168.0.133" : str, (i2 & 1024) != 0 ? "7777" : str2, (i2 & 2048) != 0 ? HintConstants.AUTOFILL_HINT_PASSWORD : str3);
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
