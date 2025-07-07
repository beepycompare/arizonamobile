package ru.mrlargha.arizonaui.mobile.presentation.page.messenger.api.obj;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
/* compiled from: ContactApiResponse.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\b¨\u0006\u0012"}, d2 = {"Lru/mrlargha/arizonaui/mobile/presentation/page/messenger/api/obj/SettingsRequest;", "", "avatarBackground", "", "isNotificationsEnabled", "<init>", "(II)V", "getAvatarBackground", "()I", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "ArizonaUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SettingsRequest {
    @SerializedName("avatarColor")
    private final int avatarBackground;
    @SerializedName("notificationsEnabled")
    private final int isNotificationsEnabled;

    public SettingsRequest() {
        this(0, 0, 3, null);
    }

    public static /* synthetic */ SettingsRequest copy$default(SettingsRequest settingsRequest, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = settingsRequest.avatarBackground;
        }
        if ((i3 & 2) != 0) {
            i2 = settingsRequest.isNotificationsEnabled;
        }
        return settingsRequest.copy(i, i2);
    }

    public final int component1() {
        return this.avatarBackground;
    }

    public final int component2() {
        return this.isNotificationsEnabled;
    }

    public final SettingsRequest copy(int i, int i2) {
        return new SettingsRequest(i, i2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof SettingsRequest) {
            SettingsRequest settingsRequest = (SettingsRequest) obj;
            return this.avatarBackground == settingsRequest.avatarBackground && this.isNotificationsEnabled == settingsRequest.isNotificationsEnabled;
        }
        return false;
    }

    public int hashCode() {
        return (Integer.hashCode(this.avatarBackground) * 31) + Integer.hashCode(this.isNotificationsEnabled);
    }

    public String toString() {
        int i = this.avatarBackground;
        return "SettingsRequest(avatarBackground=" + i + ", isNotificationsEnabled=" + this.isNotificationsEnabled + ")";
    }

    public SettingsRequest(int i, int i2) {
        this.avatarBackground = i;
        this.isNotificationsEnabled = i2;
    }

    public /* synthetic */ SettingsRequest(int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? 0 : i, (i3 & 2) != 0 ? 0 : i2);
    }

    public final int getAvatarBackground() {
        return this.avatarBackground;
    }

    public final int isNotificationsEnabled() {
        return this.isNotificationsEnabled;
    }
}
