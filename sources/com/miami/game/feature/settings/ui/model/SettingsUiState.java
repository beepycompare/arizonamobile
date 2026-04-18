package com.miami.game.feature.settings.ui.model;

import androidx.compose.ui.graphics.ImageBitmap;
import com.facebook.internal.NativeProtocol;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import com.miami.game.core.drawable.resources.R;
import com.miami.game.core.settings.SettingState;
import com.miami.game.feature.download.dialog.ui.connection.ConnectionData;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: SettingsUiState.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b%\b\u0087\b\u0018\u0000 82\u00020\u0001:\u00018B{\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\b\b\u0002\u0010\r\u001a\u00020\n\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u000f\u001a\u00020\n\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014¢\u0006\u0004\b\u0015\u0010\u0016J\t\u0010'\u001a\u00020\u0003HÆ\u0003J\t\u0010(\u001a\u00020\u0005HÆ\u0003J\t\u0010)\u001a\u00020\u0007HÆ\u0003J\t\u0010*\u001a\u00020\u0007HÆ\u0003J\t\u0010+\u001a\u00020\nHÆ\u0003J\t\u0010,\u001a\u00020\fHÆ\u0003J\t\u0010-\u001a\u00020\nHÆ\u0003J\t\u0010.\u001a\u00020\u0007HÆ\u0003J\t\u0010/\u001a\u00020\nHÆ\u0003J\t\u00100\u001a\u00020\u0003HÆ\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\u0012HÆ\u0003J\u000b\u00102\u001a\u0004\u0018\u00010\u0014HÆ\u0003J\u0085\u0001\u00103\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\n2\b\b\u0002\u0010\u000e\u001a\u00020\u00072\b\b\u0002\u0010\u000f\u001a\u00020\n2\b\b\u0002\u0010\u0010\u001a\u00020\u00032\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÆ\u0001J\u0014\u00104\u001a\u00020\n2\b\u00105\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u00106\u001a\u00020\u0003HÖ\u0081\u0004J\n\u00107\u001a\u00020\u0007HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001cR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u001eR\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0011\u0010\r\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u001eR\u0011\u0010\u000e\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001cR\u0011\u0010\u000f\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u001eR\u0011\u0010\u0010\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0018R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0012¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u0014¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&¨\u00069"}, d2 = {"Lcom/miami/game/feature/settings/ui/model/SettingsUiState;", "", "backGroundId", "", "settingState", "Lcom/miami/game/core/settings/SettingState;", "supportLink", "", "privacyPolicyLink", "isConnectionDialogVisible", "", "connectionData", "Lcom/miami/game/feature/download/dialog/ui/connection/ConnectionData;", "isDebug", RemoteConfigConstants.RequestFieldKey.APP_VERSION, "isArizona", NativeProtocol.PLATFORM_PROVIDER_VERSION_COLUMN, "file", "Ljava/io/File;", "imageBitmap", "Landroidx/compose/ui/graphics/ImageBitmap;", "<init>", "(ILcom/miami/game/core/settings/SettingState;Ljava/lang/String;Ljava/lang/String;ZLcom/miami/game/feature/download/dialog/ui/connection/ConnectionData;ZLjava/lang/String;ZILjava/io/File;Landroidx/compose/ui/graphics/ImageBitmap;)V", "getBackGroundId", "()I", "getSettingState", "()Lcom/miami/game/core/settings/SettingState;", "getSupportLink", "()Ljava/lang/String;", "getPrivacyPolicyLink", "()Z", "getConnectionData", "()Lcom/miami/game/feature/download/dialog/ui/connection/ConnectionData;", "getAppVersion", "getVersion", "getFile", "()Ljava/io/File;", "getImageBitmap", "()Landroidx/compose/ui/graphics/ImageBitmap;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "copy", "equals", "other", "hashCode", "toString", "Companion", "settings"}, k = 1, mv = {2, 3, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class SettingsUiState {
    public static final int $stable = 0;
    public static final Companion Companion = new Companion(null);
    private final String appVersion;
    private final int backGroundId;
    private final ConnectionData connectionData;
    private final File file;
    private final ImageBitmap imageBitmap;
    private final boolean isArizona;
    private final boolean isConnectionDialogVisible;
    private final boolean isDebug;
    private final String privacyPolicyLink;
    private final SettingState settingState;
    private final String supportLink;
    private final int version;

    public static /* synthetic */ SettingsUiState copy$default(SettingsUiState settingsUiState, int i, SettingState settingState, String str, String str2, boolean z, ConnectionData connectionData, boolean z2, String str3, boolean z3, int i2, File file, ImageBitmap imageBitmap, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = settingsUiState.backGroundId;
        }
        if ((i3 & 2) != 0) {
            settingState = settingsUiState.settingState;
        }
        if ((i3 & 4) != 0) {
            str = settingsUiState.supportLink;
        }
        if ((i3 & 8) != 0) {
            str2 = settingsUiState.privacyPolicyLink;
        }
        if ((i3 & 16) != 0) {
            z = settingsUiState.isConnectionDialogVisible;
        }
        if ((i3 & 32) != 0) {
            connectionData = settingsUiState.connectionData;
        }
        if ((i3 & 64) != 0) {
            z2 = settingsUiState.isDebug;
        }
        if ((i3 & 128) != 0) {
            str3 = settingsUiState.appVersion;
        }
        if ((i3 & 256) != 0) {
            z3 = settingsUiState.isArizona;
        }
        if ((i3 & 512) != 0) {
            i2 = settingsUiState.version;
        }
        if ((i3 & 1024) != 0) {
            file = settingsUiState.file;
        }
        if ((i3 & 2048) != 0) {
            imageBitmap = settingsUiState.imageBitmap;
        }
        File file2 = file;
        ImageBitmap imageBitmap2 = imageBitmap;
        boolean z4 = z3;
        int i4 = i2;
        boolean z5 = z2;
        String str4 = str3;
        boolean z6 = z;
        ConnectionData connectionData2 = connectionData;
        return settingsUiState.copy(i, settingState, str, str2, z6, connectionData2, z5, str4, z4, i4, file2, imageBitmap2);
    }

    public final int component1() {
        return this.backGroundId;
    }

    public final int component10() {
        return this.version;
    }

    public final File component11() {
        return this.file;
    }

    public final ImageBitmap component12() {
        return this.imageBitmap;
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
        return this.appVersion;
    }

    public final boolean component9() {
        return this.isArizona;
    }

    public final SettingsUiState copy(int i, SettingState settingState, String supportLink, String privacyPolicyLink, boolean z, ConnectionData connectionData, boolean z2, String appVersion, boolean z3, int i2, File file, ImageBitmap imageBitmap) {
        Intrinsics.checkNotNullParameter(settingState, "settingState");
        Intrinsics.checkNotNullParameter(supportLink, "supportLink");
        Intrinsics.checkNotNullParameter(privacyPolicyLink, "privacyPolicyLink");
        Intrinsics.checkNotNullParameter(connectionData, "connectionData");
        Intrinsics.checkNotNullParameter(appVersion, "appVersion");
        return new SettingsUiState(i, settingState, supportLink, privacyPolicyLink, z, connectionData, z2, appVersion, z3, i2, file, imageBitmap);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof SettingsUiState) {
            SettingsUiState settingsUiState = (SettingsUiState) obj;
            return this.backGroundId == settingsUiState.backGroundId && Intrinsics.areEqual(this.settingState, settingsUiState.settingState) && Intrinsics.areEqual(this.supportLink, settingsUiState.supportLink) && Intrinsics.areEqual(this.privacyPolicyLink, settingsUiState.privacyPolicyLink) && this.isConnectionDialogVisible == settingsUiState.isConnectionDialogVisible && Intrinsics.areEqual(this.connectionData, settingsUiState.connectionData) && this.isDebug == settingsUiState.isDebug && Intrinsics.areEqual(this.appVersion, settingsUiState.appVersion) && this.isArizona == settingsUiState.isArizona && this.version == settingsUiState.version && Intrinsics.areEqual(this.file, settingsUiState.file) && Intrinsics.areEqual(this.imageBitmap, settingsUiState.imageBitmap);
        }
        return false;
    }

    public int hashCode() {
        int hashCode = ((((((((((((((((((Integer.hashCode(this.backGroundId) * 31) + this.settingState.hashCode()) * 31) + this.supportLink.hashCode()) * 31) + this.privacyPolicyLink.hashCode()) * 31) + Boolean.hashCode(this.isConnectionDialogVisible)) * 31) + this.connectionData.hashCode()) * 31) + Boolean.hashCode(this.isDebug)) * 31) + this.appVersion.hashCode()) * 31) + Boolean.hashCode(this.isArizona)) * 31) + Integer.hashCode(this.version)) * 31;
        File file = this.file;
        int hashCode2 = (hashCode + (file == null ? 0 : file.hashCode())) * 31;
        ImageBitmap imageBitmap = this.imageBitmap;
        return hashCode2 + (imageBitmap != null ? imageBitmap.hashCode() : 0);
    }

    public String toString() {
        int i = this.backGroundId;
        SettingState settingState = this.settingState;
        String str = this.supportLink;
        String str2 = this.privacyPolicyLink;
        boolean z = this.isConnectionDialogVisible;
        ConnectionData connectionData = this.connectionData;
        boolean z2 = this.isDebug;
        String str3 = this.appVersion;
        boolean z3 = this.isArizona;
        int i2 = this.version;
        File file = this.file;
        return "SettingsUiState(backGroundId=" + i + ", settingState=" + settingState + ", supportLink=" + str + ", privacyPolicyLink=" + str2 + ", isConnectionDialogVisible=" + z + ", connectionData=" + connectionData + ", isDebug=" + z2 + ", appVersion=" + str3 + ", isArizona=" + z3 + ", version=" + i2 + ", file=" + file + ", imageBitmap=" + this.imageBitmap + ")";
    }

    public SettingsUiState(int i, SettingState settingState, String supportLink, String privacyPolicyLink, boolean z, ConnectionData connectionData, boolean z2, String appVersion, boolean z3, int i2, File file, ImageBitmap imageBitmap) {
        Intrinsics.checkNotNullParameter(settingState, "settingState");
        Intrinsics.checkNotNullParameter(supportLink, "supportLink");
        Intrinsics.checkNotNullParameter(privacyPolicyLink, "privacyPolicyLink");
        Intrinsics.checkNotNullParameter(connectionData, "connectionData");
        Intrinsics.checkNotNullParameter(appVersion, "appVersion");
        this.backGroundId = i;
        this.settingState = settingState;
        this.supportLink = supportLink;
        this.privacyPolicyLink = privacyPolicyLink;
        this.isConnectionDialogVisible = z;
        this.connectionData = connectionData;
        this.isDebug = z2;
        this.appVersion = appVersion;
        this.isArizona = z3;
        this.version = i2;
        this.file = file;
        this.imageBitmap = imageBitmap;
    }

    public final int getBackGroundId() {
        return this.backGroundId;
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

    public /* synthetic */ SettingsUiState(int i, SettingState settingState, String str, String str2, boolean z, ConnectionData connectionData, boolean z2, String str3, boolean z3, int i2, File file, ImageBitmap imageBitmap, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, settingState, str, str2, (i3 & 16) != 0 ? false : z, (i3 & 32) != 0 ? new ConnectionData(null, null, null, 7, null) : connectionData, (i3 & 64) != 0 ? false : z2, (i3 & 128) != 0 ? "" : str3, (i3 & 256) != 0 ? true : z3, (i3 & 512) != 0 ? 0 : i2, (i3 & 1024) != 0 ? null : file, (i3 & 2048) != 0 ? null : imageBitmap);
    }

    public final ConnectionData getConnectionData() {
        return this.connectionData;
    }

    public final boolean isDebug() {
        return this.isDebug;
    }

    public final String getAppVersion() {
        return this.appVersion;
    }

    public final boolean isArizona() {
        return this.isArizona;
    }

    public final int getVersion() {
        return this.version;
    }

    public final File getFile() {
        return this.file;
    }

    public final ImageBitmap getImageBitmap() {
        return this.imageBitmap;
    }

    /* compiled from: SettingsUiState.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0007¨\u0006\f"}, d2 = {"Lcom/miami/game/feature/settings/ui/model/SettingsUiState$Companion;", "", "<init>", "()V", "initial", "Lcom/miami/game/feature/settings/ui/model/SettingsUiState;", "isArizona", "", "isDebug", NativeProtocol.PLATFORM_PROVIDER_VERSION_COLUMN, "", "isTablet", "settings"}, k = 1, mv = {2, 3, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final SettingsUiState initial(boolean z, boolean z2, String version, boolean z3) {
            Intrinsics.checkNotNullParameter(version, "version");
            return new SettingsUiState(z ? R.drawable.arizona_backgournd_home : R.drawable.rodina_backgournd_home, SettingState.Companion.init(z3), z ? "https://vk.com/agm_workshop" : "https://vk.com/rgm_workshop", z ? "https://arizona-rp.com/document/policy" : "https://rodina-rp.com/policy", false, null, z2, version, z, 0, null, null, 3632, null);
        }
    }
}
