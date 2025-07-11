package com.miami.game.feature.settings.ui.model;

import com.facebook.internal.NativeProtocol;
import com.miami.game.core.drawable.resources.R;
import com.miami.game.core.settings.SettingState;
import com.miami.game.feature.download.dialog.ui.connection.ConnectionData;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: SettingsUiState.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001e\b\u0087\b\u0018\u0000 )2\u00020\u0001:\u0001)BQ\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\b\b\u0002\u0010\r\u001a\u00020\n\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0007¢\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0007HÆ\u0003J\t\u0010 \u001a\u00020\nHÆ\u0003J\t\u0010!\u001a\u00020\fHÆ\u0003J\t\u0010\"\u001a\u00020\nHÆ\u0003J\t\u0010#\u001a\u00020\u0007HÆ\u0003JY\u0010$\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\n2\b\b\u0002\u0010\u000e\u001a\u00020\u0007HÆ\u0001J\u0013\u0010%\u001a\u00020\n2\b\u0010&\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010'\u001a\u00020\u0003HÖ\u0001J\t\u0010(\u001a\u00020\u0007HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0018R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\r\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u0018R\u0011\u0010\u000e\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0016¨\u0006*"}, d2 = {"Lcom/miami/game/feature/settings/ui/model/SettingsUiState;", "", "backGroundId", "", "settingState", "Lcom/miami/game/core/settings/SettingState;", "supportLink", "", "privacyPolicyLink", "isConnectionDialogVisible", "", "connectionData", "Lcom/miami/game/feature/download/dialog/ui/connection/ConnectionData;", "isDebug", NativeProtocol.PLATFORM_PROVIDER_VERSION_COLUMN, "<init>", "(ILcom/miami/game/core/settings/SettingState;Ljava/lang/String;Ljava/lang/String;ZLcom/miami/game/feature/download/dialog/ui/connection/ConnectionData;ZLjava/lang/String;)V", "getBackGroundId", "()I", "getSettingState", "()Lcom/miami/game/core/settings/SettingState;", "getSupportLink", "()Ljava/lang/String;", "getPrivacyPolicyLink", "()Z", "getConnectionData", "()Lcom/miami/game/feature/download/dialog/ui/connection/ConnectionData;", "getVersion", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "other", "hashCode", "toString", "Companion", "settings_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class SettingsUiState {
    public static final int $stable = 0;
    public static final Companion Companion = new Companion(null);
    private final int backGroundId;
    private final ConnectionData connectionData;
    private final boolean isConnectionDialogVisible;
    private final boolean isDebug;
    private final String privacyPolicyLink;
    private final SettingState settingState;
    private final String supportLink;
    private final String version;

    public static /* synthetic */ SettingsUiState copy$default(SettingsUiState settingsUiState, int i, SettingState settingState, String str, String str2, boolean z, ConnectionData connectionData, boolean z2, String str3, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = settingsUiState.backGroundId;
        }
        if ((i2 & 2) != 0) {
            settingState = settingsUiState.settingState;
        }
        if ((i2 & 4) != 0) {
            str = settingsUiState.supportLink;
        }
        if ((i2 & 8) != 0) {
            str2 = settingsUiState.privacyPolicyLink;
        }
        if ((i2 & 16) != 0) {
            z = settingsUiState.isConnectionDialogVisible;
        }
        if ((i2 & 32) != 0) {
            connectionData = settingsUiState.connectionData;
        }
        if ((i2 & 64) != 0) {
            z2 = settingsUiState.isDebug;
        }
        if ((i2 & 128) != 0) {
            str3 = settingsUiState.version;
        }
        boolean z3 = z2;
        String str4 = str3;
        boolean z4 = z;
        ConnectionData connectionData2 = connectionData;
        return settingsUiState.copy(i, settingState, str, str2, z4, connectionData2, z3, str4);
    }

    public final int component1() {
        return this.backGroundId;
    }

    public final SettingState component2() {
        return this.settingState;
    }

    public final String component3() {
        return this.supportLink;
    }

    public final String component4() {
        return this.privacyPolicyLink;
    }

    public final boolean component5() {
        return this.isConnectionDialogVisible;
    }

    public final ConnectionData component6() {
        return this.connectionData;
    }

    public final boolean component7() {
        return this.isDebug;
    }

    public final String component8() {
        return this.version;
    }

    public final SettingsUiState copy(int i, SettingState settingState, String supportLink, String privacyPolicyLink, boolean z, ConnectionData connectionData, boolean z2, String version) {
        Intrinsics.checkNotNullParameter(settingState, "settingState");
        Intrinsics.checkNotNullParameter(supportLink, "supportLink");
        Intrinsics.checkNotNullParameter(privacyPolicyLink, "privacyPolicyLink");
        Intrinsics.checkNotNullParameter(connectionData, "connectionData");
        Intrinsics.checkNotNullParameter(version, "version");
        return new SettingsUiState(i, settingState, supportLink, privacyPolicyLink, z, connectionData, z2, version);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof SettingsUiState) {
            SettingsUiState settingsUiState = (SettingsUiState) obj;
            return this.backGroundId == settingsUiState.backGroundId && Intrinsics.areEqual(this.settingState, settingsUiState.settingState) && Intrinsics.areEqual(this.supportLink, settingsUiState.supportLink) && Intrinsics.areEqual(this.privacyPolicyLink, settingsUiState.privacyPolicyLink) && this.isConnectionDialogVisible == settingsUiState.isConnectionDialogVisible && Intrinsics.areEqual(this.connectionData, settingsUiState.connectionData) && this.isDebug == settingsUiState.isDebug && Intrinsics.areEqual(this.version, settingsUiState.version);
        }
        return false;
    }

    public int hashCode() {
        return (((((((((((((Integer.hashCode(this.backGroundId) * 31) + this.settingState.hashCode()) * 31) + this.supportLink.hashCode()) * 31) + this.privacyPolicyLink.hashCode()) * 31) + Boolean.hashCode(this.isConnectionDialogVisible)) * 31) + this.connectionData.hashCode()) * 31) + Boolean.hashCode(this.isDebug)) * 31) + this.version.hashCode();
    }

    public String toString() {
        int i = this.backGroundId;
        SettingState settingState = this.settingState;
        String str = this.supportLink;
        String str2 = this.privacyPolicyLink;
        boolean z = this.isConnectionDialogVisible;
        ConnectionData connectionData = this.connectionData;
        boolean z2 = this.isDebug;
        return "SettingsUiState(backGroundId=" + i + ", settingState=" + settingState + ", supportLink=" + str + ", privacyPolicyLink=" + str2 + ", isConnectionDialogVisible=" + z + ", connectionData=" + connectionData + ", isDebug=" + z2 + ", version=" + this.version + ")";
    }

    public SettingsUiState(int i, SettingState settingState, String supportLink, String privacyPolicyLink, boolean z, ConnectionData connectionData, boolean z2, String version) {
        Intrinsics.checkNotNullParameter(settingState, "settingState");
        Intrinsics.checkNotNullParameter(supportLink, "supportLink");
        Intrinsics.checkNotNullParameter(privacyPolicyLink, "privacyPolicyLink");
        Intrinsics.checkNotNullParameter(connectionData, "connectionData");
        Intrinsics.checkNotNullParameter(version, "version");
        this.backGroundId = i;
        this.settingState = settingState;
        this.supportLink = supportLink;
        this.privacyPolicyLink = privacyPolicyLink;
        this.isConnectionDialogVisible = z;
        this.connectionData = connectionData;
        this.isDebug = z2;
        this.version = version;
    }

    public final int getBackGroundId() {
        return this.backGroundId;
    }

    public /* synthetic */ SettingsUiState(int i, SettingState settingState, String str, String str2, boolean z, ConnectionData connectionData, boolean z2, String str3, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, (i2 & 2) != 0 ? new SettingState(0.0f, 0, false, false, false, false, false, null, 255, null) : settingState, str, str2, (i2 & 16) != 0 ? false : z, (i2 & 32) != 0 ? new ConnectionData(null, null, null, 7, null) : connectionData, (i2 & 64) != 0 ? false : z2, (i2 & 128) != 0 ? "" : str3);
    }

    public final SettingState getSettingState() {
        return this.settingState;
    }

    public final String getSupportLink() {
        return this.supportLink;
    }

    public final String getPrivacyPolicyLink() {
        return this.privacyPolicyLink;
    }

    public final boolean isConnectionDialogVisible() {
        return this.isConnectionDialogVisible;
    }

    public final ConnectionData getConnectionData() {
        return this.connectionData;
    }

    public final boolean isDebug() {
        return this.isDebug;
    }

    public final String getVersion() {
        return this.version;
    }

    /* compiled from: SettingsUiState.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\n¨\u0006\u000b"}, d2 = {"Lcom/miami/game/feature/settings/ui/model/SettingsUiState$Companion;", "", "<init>", "()V", "initial", "Lcom/miami/game/feature/settings/ui/model/SettingsUiState;", "isArizona", "", "isDebug", NativeProtocol.PLATFORM_PROVIDER_VERSION_COLUMN, "", "settings_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final SettingsUiState initial(boolean z, boolean z2, String version) {
            Intrinsics.checkNotNullParameter(version, "version");
            return new SettingsUiState(z ? R.drawable.bg_arizona : R.drawable.bg_rodina, null, z ? "https://vk.com/agm_workshop" : "https://vk.com/rgm_workshop", z ? "https://arizona-rp.com/document/policy" : "https://rodina-rp.com/policy", false, null, z2, version, 50, null);
        }
    }
}
