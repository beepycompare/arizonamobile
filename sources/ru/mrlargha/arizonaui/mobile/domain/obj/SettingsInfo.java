package ru.mrlargha.arizonaui.mobile.domain.obj;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: MobilePhoneObject.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\bHÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J?\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u00052\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u000eR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\r¨\u0006\u001e"}, d2 = {"Lru/mrlargha/arizonaui/mobile/domain/obj/SettingsInfo;", "", "name", "", "isNotificationsEnabled", "", "avatarUrl", "avatarBackground", "Lru/mrlargha/arizonaui/mobile/domain/obj/AvatarBackground;", "phone", "<init>", "(Ljava/lang/String;ZLjava/lang/String;Lru/mrlargha/arizonaui/mobile/domain/obj/AvatarBackground;Ljava/lang/String;)V", "getName", "()Ljava/lang/String;", "()Z", "getAvatarUrl", "getAvatarBackground", "()Lru/mrlargha/arizonaui/mobile/domain/obj/AvatarBackground;", "getPhone", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "", "toString", "ArizonaUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SettingsInfo {
    private final AvatarBackground avatarBackground;
    private final String avatarUrl;
    private final boolean isNotificationsEnabled;
    private final String name;
    private final String phone;

    public static /* synthetic */ SettingsInfo copy$default(SettingsInfo settingsInfo, String str, boolean z, String str2, AvatarBackground avatarBackground, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = settingsInfo.name;
        }
        if ((i & 2) != 0) {
            z = settingsInfo.isNotificationsEnabled;
        }
        if ((i & 4) != 0) {
            str2 = settingsInfo.avatarUrl;
        }
        if ((i & 8) != 0) {
            avatarBackground = settingsInfo.avatarBackground;
        }
        if ((i & 16) != 0) {
            str3 = settingsInfo.phone;
        }
        String str4 = str3;
        String str5 = str2;
        return settingsInfo.copy(str, z, str5, avatarBackground, str4);
    }

    public final String component1() {
        return this.name;
    }

    public final boolean component2() {
        return this.isNotificationsEnabled;
    }

    public final String component3() {
        return this.avatarUrl;
    }

    public final AvatarBackground component4() {
        return this.avatarBackground;
    }

    public final String component5() {
        return this.phone;
    }

    public final SettingsInfo copy(String name, boolean z, String str, AvatarBackground avatarBackground, String str2) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(avatarBackground, "avatarBackground");
        return new SettingsInfo(name, z, str, avatarBackground, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof SettingsInfo) {
            SettingsInfo settingsInfo = (SettingsInfo) obj;
            return Intrinsics.areEqual(this.name, settingsInfo.name) && this.isNotificationsEnabled == settingsInfo.isNotificationsEnabled && Intrinsics.areEqual(this.avatarUrl, settingsInfo.avatarUrl) && this.avatarBackground == settingsInfo.avatarBackground && Intrinsics.areEqual(this.phone, settingsInfo.phone);
        }
        return false;
    }

    public int hashCode() {
        int hashCode = ((this.name.hashCode() * 31) + Boolean.hashCode(this.isNotificationsEnabled)) * 31;
        String str = this.avatarUrl;
        int hashCode2 = (((hashCode + (str == null ? 0 : str.hashCode())) * 31) + this.avatarBackground.hashCode()) * 31;
        String str2 = this.phone;
        return hashCode2 + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        String str = this.name;
        boolean z = this.isNotificationsEnabled;
        String str2 = this.avatarUrl;
        AvatarBackground avatarBackground = this.avatarBackground;
        return "SettingsInfo(name=" + str + ", isNotificationsEnabled=" + z + ", avatarUrl=" + str2 + ", avatarBackground=" + avatarBackground + ", phone=" + this.phone + ")";
    }

    public SettingsInfo(String name, boolean z, String str, AvatarBackground avatarBackground, String str2) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(avatarBackground, "avatarBackground");
        this.name = name;
        this.isNotificationsEnabled = z;
        this.avatarUrl = str;
        this.avatarBackground = avatarBackground;
        this.phone = str2;
    }

    public final String getName() {
        return this.name;
    }

    public final boolean isNotificationsEnabled() {
        return this.isNotificationsEnabled;
    }

    public final String getAvatarUrl() {
        return this.avatarUrl;
    }

    public final AvatarBackground getAvatarBackground() {
        return this.avatarBackground;
    }

    public final String getPhone() {
        return this.phone;
    }
}
