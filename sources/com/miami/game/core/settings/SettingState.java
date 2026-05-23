package com.miami.game.core.settings;

import com.miami.game.core.settings.game_test.GameTestSavedScript;
import com.miami.game.core.settings.game_test.GameTestScriptPreferences;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: SettingState.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b5\b\u0086\b\u0018\u0000 O2\u00020\u0001:\u0001OBË\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\u0007\u0012\b\b\u0002\u0010\n\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\f\u001a\u00020\u0007\u0012\b\b\u0002\u0010\r\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0007\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0012\u0012\u000e\b\u0002\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0012\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0012\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u001b¢\u0006\u0004\b\u001c\u0010\u001dJ\t\u00107\u001a\u00020\u0003HÆ\u0003J\t\u00108\u001a\u00020\u0005HÆ\u0003J\t\u00109\u001a\u00020\u0007HÆ\u0003J\t\u0010:\u001a\u00020\u0007HÆ\u0003J\t\u0010;\u001a\u00020\u0007HÆ\u0003J\t\u0010<\u001a\u00020\u0007HÆ\u0003J\t\u0010=\u001a\u00020\u0007HÆ\u0003J\t\u0010>\u001a\u00020\u0007HÆ\u0003J\t\u0010?\u001a\u00020\u0007HÆ\u0003J\t\u0010@\u001a\u00020\u0007HÆ\u0003J\t\u0010A\u001a\u00020\u0007HÆ\u0003J\t\u0010B\u001a\u00020\u0007HÆ\u0003J\u000b\u0010C\u001a\u0004\u0018\u00010\u0012HÆ\u0003J\u000b\u0010D\u001a\u0004\u0018\u00010\u0012HÆ\u0003J\u000f\u0010E\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015HÆ\u0003J\t\u0010F\u001a\u00020\u0012HÆ\u0003J\t\u0010G\u001a\u00020\u0007HÆ\u0003J\t\u0010H\u001a\u00020\u0012HÆ\u0003J\t\u0010I\u001a\u00020\u001bHÆ\u0003JÑ\u0001\u0010J\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\u00072\b\b\u0002\u0010\u000b\u001a\u00020\u00072\b\b\u0002\u0010\f\u001a\u00020\u00072\b\b\u0002\u0010\r\u001a\u00020\u00072\b\b\u0002\u0010\u000e\u001a\u00020\u00072\b\b\u0002\u0010\u000f\u001a\u00020\u00072\b\b\u0002\u0010\u0010\u001a\u00020\u00072\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00122\u000e\b\u0002\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u00152\b\b\u0002\u0010\u0017\u001a\u00020\u00122\b\b\u0002\u0010\u0018\u001a\u00020\u00072\b\b\u0002\u0010\u0019\u001a\u00020\u00122\b\b\u0002\u0010\u001a\u001a\u00020\u001bHÆ\u0001J\u0014\u0010K\u001a\u00020\u00072\b\u0010L\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010M\u001a\u00020\u0005HÖ\u0081\u0004J\n\u0010N\u001a\u00020\u0012HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b$\u0010#R\u0011\u0010\t\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b%\u0010#R\u0011\u0010\n\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b&\u0010#R\u0011\u0010\u000b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b'\u0010#R\u0011\u0010\f\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b(\u0010#R\u0011\u0010\r\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b)\u0010#R\u0011\u0010\u000e\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b*\u0010#R\u0011\u0010\u000f\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b+\u0010#R\u0011\u0010\u0010\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b,\u0010#R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0012¢\u0006\b\n\u0000\u001a\u0004\b-\u0010.R\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u0012¢\u0006\b\n\u0000\u001a\u0004\b/\u0010.R\u0017\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015¢\u0006\b\n\u0000\u001a\u0004\b0\u00101R\u0011\u0010\u0017\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b2\u0010.R\u0011\u0010\u0018\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b3\u0010#R\u0011\u0010\u0019\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b4\u0010.R\u0011\u0010\u001a\u001a\u00020\u001b¢\u0006\b\n\u0000\u001a\u0004\b5\u00106¨\u0006P"}, d2 = {"Lcom/miami/game/core/settings/SettingState;", "", "chatFontSize", "", "pageSize", "", "customKeyBoard", "", "showChatTime", "ambientSounds", "showFps", "fullScreen", "streamerMode", "notifications", "debugAutoConnectTestServer", "debugAutoRunTestScript", "debugUseImportedTestScript", "debugImportedTestScriptName", "", "debugActiveImportedTestScriptFileName", "debugImportedTestScripts", "", "Lcom/miami/game/core/settings/game_test/GameTestSavedScript;", "debugGameTestScreenshotPullPath", "debugGameTestScreenshotButtonEnabled", "debugGameTestScreenshotDeviceDir", "connectionData", "Lcom/miami/game/core/settings/ConnectionData;", "<init>", "(FIZZZZZZZZZZLjava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;ZLjava/lang/String;Lcom/miami/game/core/settings/ConnectionData;)V", "getChatFontSize", "()F", "getPageSize", "()I", "getCustomKeyBoard", "()Z", "getShowChatTime", "getAmbientSounds", "getShowFps", "getFullScreen", "getStreamerMode", "getNotifications", "getDebugAutoConnectTestServer", "getDebugAutoRunTestScript", "getDebugUseImportedTestScript", "getDebugImportedTestScriptName", "()Ljava/lang/String;", "getDebugActiveImportedTestScriptFileName", "getDebugImportedTestScripts", "()Ljava/util/List;", "getDebugGameTestScreenshotPullPath", "getDebugGameTestScreenshotButtonEnabled", "getDebugGameTestScreenshotDeviceDir", "getConnectionData", "()Lcom/miami/game/core/settings/ConnectionData;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "copy", "equals", "other", "hashCode", "toString", "Companion", "settings"}, k = 1, mv = {2, 3, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SettingState {
    public static final Companion Companion = new Companion(null);
    private final boolean ambientSounds;
    private final float chatFontSize;
    private final ConnectionData connectionData;
    private final boolean customKeyBoard;
    private final String debugActiveImportedTestScriptFileName;
    private final boolean debugAutoConnectTestServer;
    private final boolean debugAutoRunTestScript;
    private final boolean debugGameTestScreenshotButtonEnabled;
    private final String debugGameTestScreenshotDeviceDir;
    private final String debugGameTestScreenshotPullPath;
    private final String debugImportedTestScriptName;
    private final List<GameTestSavedScript> debugImportedTestScripts;
    private final boolean debugUseImportedTestScript;
    private final boolean fullScreen;
    private final boolean notifications;
    private final int pageSize;
    private final boolean showChatTime;
    private final boolean showFps;
    private final boolean streamerMode;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SettingState copy$default(SettingState settingState, float f, int i, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, boolean z8, boolean z9, boolean z10, String str, String str2, List list, String str3, boolean z11, String str4, ConnectionData connectionData, int i2, Object obj) {
        ConnectionData connectionData2;
        String str5;
        float f2 = (i2 & 1) != 0 ? settingState.chatFontSize : f;
        int i3 = (i2 & 2) != 0 ? settingState.pageSize : i;
        boolean z12 = (i2 & 4) != 0 ? settingState.customKeyBoard : z;
        boolean z13 = (i2 & 8) != 0 ? settingState.showChatTime : z2;
        boolean z14 = (i2 & 16) != 0 ? settingState.ambientSounds : z3;
        boolean z15 = (i2 & 32) != 0 ? settingState.showFps : z4;
        boolean z16 = (i2 & 64) != 0 ? settingState.fullScreen : z5;
        boolean z17 = (i2 & 128) != 0 ? settingState.streamerMode : z6;
        boolean z18 = (i2 & 256) != 0 ? settingState.notifications : z7;
        boolean z19 = (i2 & 512) != 0 ? settingState.debugAutoConnectTestServer : z8;
        boolean z20 = (i2 & 1024) != 0 ? settingState.debugAutoRunTestScript : z9;
        boolean z21 = (i2 & 2048) != 0 ? settingState.debugUseImportedTestScript : z10;
        String str6 = (i2 & 4096) != 0 ? settingState.debugImportedTestScriptName : str;
        String str7 = (i2 & 8192) != 0 ? settingState.debugActiveImportedTestScriptFileName : str2;
        float f3 = f2;
        List<GameTestSavedScript> list2 = (i2 & 16384) != 0 ? settingState.debugImportedTestScripts : list;
        String str8 = (i2 & 32768) != 0 ? settingState.debugGameTestScreenshotPullPath : str3;
        boolean z22 = (i2 & 65536) != 0 ? settingState.debugGameTestScreenshotButtonEnabled : z11;
        String str9 = (i2 & 131072) != 0 ? settingState.debugGameTestScreenshotDeviceDir : str4;
        if ((i2 & 262144) != 0) {
            str5 = str9;
            connectionData2 = settingState.connectionData;
        } else {
            connectionData2 = connectionData;
            str5 = str9;
        }
        return settingState.copy(f3, i3, z12, z13, z14, z15, z16, z17, z18, z19, z20, z21, str6, str7, list2, str8, z22, str5, connectionData2);
    }

    public final float component1() {
        return this.chatFontSize;
    }

    public final boolean component10() {
        return this.debugAutoConnectTestServer;
    }

    public final boolean component11() {
        return this.debugAutoRunTestScript;
    }

    public final boolean component12() {
        return this.debugUseImportedTestScript;
    }

    public final String component13() {
        return this.debugImportedTestScriptName;
    }

    public final String component14() {
        return this.debugActiveImportedTestScriptFileName;
    }

    public final List<GameTestSavedScript> component15() {
        return this.debugImportedTestScripts;
    }

    public final String component16() {
        return this.debugGameTestScreenshotPullPath;
    }

    public final boolean component17() {
        return this.debugGameTestScreenshotButtonEnabled;
    }

    public final String component18() {
        return this.debugGameTestScreenshotDeviceDir;
    }

    public final ConnectionData component19() {
        return this.connectionData;
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
        return this.fullScreen;
    }

    public final boolean component8() {
        return this.streamerMode;
    }

    public final boolean component9() {
        return this.notifications;
    }

    public final SettingState copy(float f, int i, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, boolean z8, boolean z9, boolean z10, String str, String str2, List<GameTestSavedScript> debugImportedTestScripts, String debugGameTestScreenshotPullPath, boolean z11, String debugGameTestScreenshotDeviceDir, ConnectionData connectionData) {
        Intrinsics.checkNotNullParameter(debugImportedTestScripts, "debugImportedTestScripts");
        Intrinsics.checkNotNullParameter(debugGameTestScreenshotPullPath, "debugGameTestScreenshotPullPath");
        Intrinsics.checkNotNullParameter(debugGameTestScreenshotDeviceDir, "debugGameTestScreenshotDeviceDir");
        Intrinsics.checkNotNullParameter(connectionData, "connectionData");
        return new SettingState(f, i, z, z2, z3, z4, z5, z6, z7, z8, z9, z10, str, str2, debugImportedTestScripts, debugGameTestScreenshotPullPath, z11, debugGameTestScreenshotDeviceDir, connectionData);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof SettingState) {
            SettingState settingState = (SettingState) obj;
            return Float.compare(this.chatFontSize, settingState.chatFontSize) == 0 && this.pageSize == settingState.pageSize && this.customKeyBoard == settingState.customKeyBoard && this.showChatTime == settingState.showChatTime && this.ambientSounds == settingState.ambientSounds && this.showFps == settingState.showFps && this.fullScreen == settingState.fullScreen && this.streamerMode == settingState.streamerMode && this.notifications == settingState.notifications && this.debugAutoConnectTestServer == settingState.debugAutoConnectTestServer && this.debugAutoRunTestScript == settingState.debugAutoRunTestScript && this.debugUseImportedTestScript == settingState.debugUseImportedTestScript && Intrinsics.areEqual(this.debugImportedTestScriptName, settingState.debugImportedTestScriptName) && Intrinsics.areEqual(this.debugActiveImportedTestScriptFileName, settingState.debugActiveImportedTestScriptFileName) && Intrinsics.areEqual(this.debugImportedTestScripts, settingState.debugImportedTestScripts) && Intrinsics.areEqual(this.debugGameTestScreenshotPullPath, settingState.debugGameTestScreenshotPullPath) && this.debugGameTestScreenshotButtonEnabled == settingState.debugGameTestScreenshotButtonEnabled && Intrinsics.areEqual(this.debugGameTestScreenshotDeviceDir, settingState.debugGameTestScreenshotDeviceDir) && Intrinsics.areEqual(this.connectionData, settingState.connectionData);
        }
        return false;
    }

    public int hashCode() {
        int hashCode = ((((((((((((((((((((((Float.hashCode(this.chatFontSize) * 31) + Integer.hashCode(this.pageSize)) * 31) + Boolean.hashCode(this.customKeyBoard)) * 31) + Boolean.hashCode(this.showChatTime)) * 31) + Boolean.hashCode(this.ambientSounds)) * 31) + Boolean.hashCode(this.showFps)) * 31) + Boolean.hashCode(this.fullScreen)) * 31) + Boolean.hashCode(this.streamerMode)) * 31) + Boolean.hashCode(this.notifications)) * 31) + Boolean.hashCode(this.debugAutoConnectTestServer)) * 31) + Boolean.hashCode(this.debugAutoRunTestScript)) * 31) + Boolean.hashCode(this.debugUseImportedTestScript)) * 31;
        String str = this.debugImportedTestScriptName;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.debugActiveImportedTestScriptFileName;
        return ((((((((((hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31) + this.debugImportedTestScripts.hashCode()) * 31) + this.debugGameTestScreenshotPullPath.hashCode()) * 31) + Boolean.hashCode(this.debugGameTestScreenshotButtonEnabled)) * 31) + this.debugGameTestScreenshotDeviceDir.hashCode()) * 31) + this.connectionData.hashCode();
    }

    public String toString() {
        float f = this.chatFontSize;
        int i = this.pageSize;
        boolean z = this.customKeyBoard;
        boolean z2 = this.showChatTime;
        boolean z3 = this.ambientSounds;
        boolean z4 = this.showFps;
        boolean z5 = this.fullScreen;
        boolean z6 = this.streamerMode;
        boolean z7 = this.notifications;
        boolean z8 = this.debugAutoConnectTestServer;
        boolean z9 = this.debugAutoRunTestScript;
        boolean z10 = this.debugUseImportedTestScript;
        String str = this.debugImportedTestScriptName;
        String str2 = this.debugActiveImportedTestScriptFileName;
        List<GameTestSavedScript> list = this.debugImportedTestScripts;
        String str3 = this.debugGameTestScreenshotPullPath;
        boolean z11 = this.debugGameTestScreenshotButtonEnabled;
        String str4 = this.debugGameTestScreenshotDeviceDir;
        return "SettingState(chatFontSize=" + f + ", pageSize=" + i + ", customKeyBoard=" + z + ", showChatTime=" + z2 + ", ambientSounds=" + z3 + ", showFps=" + z4 + ", fullScreen=" + z5 + ", streamerMode=" + z6 + ", notifications=" + z7 + ", debugAutoConnectTestServer=" + z8 + ", debugAutoRunTestScript=" + z9 + ", debugUseImportedTestScript=" + z10 + ", debugImportedTestScriptName=" + str + ", debugActiveImportedTestScriptFileName=" + str2 + ", debugImportedTestScripts=" + list + ", debugGameTestScreenshotPullPath=" + str3 + ", debugGameTestScreenshotButtonEnabled=" + z11 + ", debugGameTestScreenshotDeviceDir=" + str4 + ", connectionData=" + this.connectionData + ")";
    }

    public SettingState(float f, int i, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, boolean z8, boolean z9, boolean z10, String str, String str2, List<GameTestSavedScript> debugImportedTestScripts, String debugGameTestScreenshotPullPath, boolean z11, String debugGameTestScreenshotDeviceDir, ConnectionData connectionData) {
        Intrinsics.checkNotNullParameter(debugImportedTestScripts, "debugImportedTestScripts");
        Intrinsics.checkNotNullParameter(debugGameTestScreenshotPullPath, "debugGameTestScreenshotPullPath");
        Intrinsics.checkNotNullParameter(debugGameTestScreenshotDeviceDir, "debugGameTestScreenshotDeviceDir");
        Intrinsics.checkNotNullParameter(connectionData, "connectionData");
        this.chatFontSize = f;
        this.pageSize = i;
        this.customKeyBoard = z;
        this.showChatTime = z2;
        this.ambientSounds = z3;
        this.showFps = z4;
        this.fullScreen = z5;
        this.streamerMode = z6;
        this.notifications = z7;
        this.debugAutoConnectTestServer = z8;
        this.debugAutoRunTestScript = z9;
        this.debugUseImportedTestScript = z10;
        this.debugImportedTestScriptName = str;
        this.debugActiveImportedTestScriptFileName = str2;
        this.debugImportedTestScripts = debugImportedTestScripts;
        this.debugGameTestScreenshotPullPath = debugGameTestScreenshotPullPath;
        this.debugGameTestScreenshotButtonEnabled = z11;
        this.debugGameTestScreenshotDeviceDir = debugGameTestScreenshotDeviceDir;
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

    public final boolean getAmbientSounds() {
        return this.ambientSounds;
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

    public final boolean getNotifications() {
        return this.notifications;
    }

    public final boolean getDebugAutoConnectTestServer() {
        return this.debugAutoConnectTestServer;
    }

    public final boolean getDebugAutoRunTestScript() {
        return this.debugAutoRunTestScript;
    }

    public final boolean getDebugUseImportedTestScript() {
        return this.debugUseImportedTestScript;
    }

    public final String getDebugImportedTestScriptName() {
        return this.debugImportedTestScriptName;
    }

    public final String getDebugActiveImportedTestScriptFileName() {
        return this.debugActiveImportedTestScriptFileName;
    }

    public /* synthetic */ SettingState(float f, int i, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, boolean z8, boolean z9, boolean z10, String str, String str2, List list, String str3, boolean z11, String str4, ConnectionData connectionData, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(f, i, (i2 & 4) != 0 ? false : z, (i2 & 8) != 0 ? false : z2, (i2 & 16) != 0 ? true : z3, (i2 & 32) != 0 ? false : z4, (i2 & 64) != 0 ? true : z5, (i2 & 128) != 0 ? false : z6, (i2 & 256) != 0 ? false : z7, (i2 & 512) != 0 ? false : z8, (i2 & 1024) != 0 ? false : z9, (i2 & 2048) != 0 ? false : z10, (i2 & 4096) != 0 ? null : str, (i2 & 8192) != 0 ? null : str2, (i2 & 16384) != 0 ? CollectionsKt.emptyList() : list, (32768 & i2) != 0 ? GameTestScriptPreferences.DEFAULT_SCREENSHOT_PULL_PATH : str3, (65536 & i2) != 0 ? false : z11, (131072 & i2) != 0 ? "" : str4, (i2 & 262144) != 0 ? new ConnectionData(null, null, null, 7, null) : connectionData);
    }

    public final List<GameTestSavedScript> getDebugImportedTestScripts() {
        return this.debugImportedTestScripts;
    }

    public final String getDebugGameTestScreenshotPullPath() {
        return this.debugGameTestScreenshotPullPath;
    }

    public final boolean getDebugGameTestScreenshotButtonEnabled() {
        return this.debugGameTestScreenshotButtonEnabled;
    }

    public final String getDebugGameTestScreenshotDeviceDir() {
        return this.debugGameTestScreenshotDeviceDir;
    }

    public final ConnectionData getConnectionData() {
        return this.connectionData;
    }

    /* compiled from: SettingState.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lcom/miami/game/core/settings/SettingState$Companion;", "", "<init>", "()V", "init", "Lcom/miami/game/core/settings/SettingState;", "isTablet", "", "settings"}, k = 1, mv = {2, 3, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final SettingState init(boolean z) {
            return new SettingState(z ? 0.8f : 1.0f, z ? 12 : 10, false, false, false, false, false, false, false, false, false, false, null, null, null, null, false, null, null, 524284, null);
        }
    }
}
