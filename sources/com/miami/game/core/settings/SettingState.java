package com.miami.game.core.settings;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: SettingState.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001BW\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\u0007\u0012\b\b\u0002\u0010\n\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\f\u001a\u00020\r¢\u0006\u0004\b\u000e\u0010\u000fJ\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0007HÆ\u0003J\t\u0010 \u001a\u00020\u0007HÆ\u0003J\t\u0010!\u001a\u00020\u0007HÆ\u0003J\t\u0010\"\u001a\u00020\u0007HÆ\u0003J\t\u0010#\u001a\u00020\rHÆ\u0003JY\u0010$\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\u00072\b\b\u0002\u0010\u000b\u001a\u00020\u00072\b\b\u0002\u0010\f\u001a\u00020\rHÆ\u0001J\u0013\u0010%\u001a\u00020\u00072\b\u0010&\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010'\u001a\u00020\u0005HÖ\u0001J\t\u0010(\u001a\u00020)HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0015R\u0011\u0010\t\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0015R\u0011\u0010\n\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0015R\u0011\u0010\u000b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0015R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001b¨\u0006*"}, d2 = {"Lcom/miami/game/core/settings/SettingState;", "", "chatFontSize", "", "pageSize", "", "customKeyBoard", "", "showChatTime", "showFps", "fullScreen", "streamerMode", "connectionData", "Lcom/miami/game/core/settings/ConnectionData;", "<init>", "(FIZZZZZLcom/miami/game/core/settings/ConnectionData;)V", "getChatFontSize", "()F", "getPageSize", "()I", "getCustomKeyBoard", "()Z", "getShowChatTime", "getShowFps", "getFullScreen", "getStreamerMode", "getConnectionData", "()Lcom/miami/game/core/settings/ConnectionData;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "other", "hashCode", "toString", "", "settings_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class SettingState {
    private final float chatFontSize;
    private final ConnectionData connectionData;
    private final boolean customKeyBoard;
    private final boolean fullScreen;
    private final int pageSize;
    private final boolean showChatTime;
    private final boolean showFps;
    private final boolean streamerMode;

    public SettingState() {
        this(0.0f, 0, false, false, false, false, false, null, 255, null);
    }

    public static /* synthetic */ SettingState copy$default(SettingState settingState, float f, int i, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, ConnectionData connectionData, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            f = settingState.chatFontSize;
        }
        if ((i2 & 2) != 0) {
            i = settingState.pageSize;
        }
        if ((i2 & 4) != 0) {
            z = settingState.customKeyBoard;
        }
        if ((i2 & 8) != 0) {
            z2 = settingState.showChatTime;
        }
        if ((i2 & 16) != 0) {
            z3 = settingState.showFps;
        }
        if ((i2 & 32) != 0) {
            z4 = settingState.fullScreen;
        }
        if ((i2 & 64) != 0) {
            z5 = settingState.streamerMode;
        }
        if ((i2 & 128) != 0) {
            connectionData = settingState.connectionData;
        }
        boolean z6 = z5;
        ConnectionData connectionData2 = connectionData;
        boolean z7 = z3;
        boolean z8 = z4;
        return settingState.copy(f, i, z, z2, z7, z8, z6, connectionData2);
    }

    public final float component1() {
        return this.chatFontSize;
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
        return this.showFps;
    }

    public final boolean component6() {
        return this.fullScreen;
    }

    public final boolean component7() {
        return this.streamerMode;
    }

    public final ConnectionData component8() {
        return this.connectionData;
    }

    public final SettingState copy(float f, int i, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, ConnectionData connectionData) {
        Intrinsics.checkNotNullParameter(connectionData, "connectionData");
        return new SettingState(f, i, z, z2, z3, z4, z5, connectionData);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof SettingState) {
            SettingState settingState = (SettingState) obj;
            return Float.compare(this.chatFontSize, settingState.chatFontSize) == 0 && this.pageSize == settingState.pageSize && this.customKeyBoard == settingState.customKeyBoard && this.showChatTime == settingState.showChatTime && this.showFps == settingState.showFps && this.fullScreen == settingState.fullScreen && this.streamerMode == settingState.streamerMode && Intrinsics.areEqual(this.connectionData, settingState.connectionData);
        }
        return false;
    }

    public int hashCode() {
        return (((((((((((((Float.hashCode(this.chatFontSize) * 31) + Integer.hashCode(this.pageSize)) * 31) + Boolean.hashCode(this.customKeyBoard)) * 31) + Boolean.hashCode(this.showChatTime)) * 31) + Boolean.hashCode(this.showFps)) * 31) + Boolean.hashCode(this.fullScreen)) * 31) + Boolean.hashCode(this.streamerMode)) * 31) + this.connectionData.hashCode();
    }

    public String toString() {
        float f = this.chatFontSize;
        int i = this.pageSize;
        boolean z = this.customKeyBoard;
        boolean z2 = this.showChatTime;
        boolean z3 = this.showFps;
        boolean z4 = this.fullScreen;
        boolean z5 = this.streamerMode;
        return "SettingState(chatFontSize=" + f + ", pageSize=" + i + ", customKeyBoard=" + z + ", showChatTime=" + z2 + ", showFps=" + z3 + ", fullScreen=" + z4 + ", streamerMode=" + z5 + ", connectionData=" + this.connectionData + ")";
    }

    public SettingState(float f, int i, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, ConnectionData connectionData) {
        Intrinsics.checkNotNullParameter(connectionData, "connectionData");
        this.chatFontSize = f;
        this.pageSize = i;
        this.customKeyBoard = z;
        this.showChatTime = z2;
        this.showFps = z3;
        this.fullScreen = z4;
        this.streamerMode = z5;
        this.connectionData = connectionData;
    }

    public final float getChatFontSize() {
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

    public final boolean getShowFps() {
        return this.showFps;
    }

    public final boolean getFullScreen() {
        return this.fullScreen;
    }

    public final boolean getStreamerMode() {
        return this.streamerMode;
    }

    public /* synthetic */ SettingState(float f, int i, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, ConnectionData connectionData, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 1.0f : f, (i2 & 2) != 0 ? 10 : i, (i2 & 4) != 0 ? false : z, (i2 & 8) != 0 ? false : z2, (i2 & 16) != 0 ? false : z3, (i2 & 32) != 0 ? true : z4, (i2 & 64) == 0 ? z5 : false, (i2 & 128) != 0 ? new ConnectionData(null, null, null, 7, null) : connectionData);
    }

    public final ConnectionData getConnectionData() {
        return this.connectionData;
    }
}
