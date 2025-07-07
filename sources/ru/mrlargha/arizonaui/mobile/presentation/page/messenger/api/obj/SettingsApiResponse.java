package ru.mrlargha.arizonaui.mobile.presentation.page.messenger.api.obj;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import ru.mrlargha.arizonaui.mobile.domain.obj.AvatarBackground;
import ru.mrlargha.arizonaui.mobile.domain.obj.SettingsInfo;
import ru.mrlargha.commonui.utils.NumberKt;
/* compiled from: ContactApiResponse.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001B?\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0006\u0010\u001c\u001a\u00020\u001dJ\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u001f\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0011J\t\u0010 \u001a\u00020\u0007HÆ\u0003J\u0010\u0010!\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0011J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0003HÆ\u0003JF\u0010#\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010$J\u0013\u0010%\u001a\u00020\u00072\b\u0010&\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010'\u001a\u00020\u0005HÖ\u0001J\t\u0010(\u001a\u00020\u0003HÖ\u0001R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0014\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001e\u0010\u0006\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\"\u0010\b\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0014\u001a\u0004\b\u0018\u0010\u0011\"\u0004\b\u0019\u0010\u0013R \u0010\t\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\r\"\u0004\b\u001b\u0010\u000f¨\u0006)"}, d2 = {"Lru/mrlargha/arizonaui/mobile/presentation/page/messenger/api/obj/SettingsApiResponse;", "", "name", "", "phone", "", "isNotificationsEnabled", "", "avatarColor", "userImage", "<init>", "(Ljava/lang/String;Ljava/lang/Integer;ZLjava/lang/Integer;Ljava/lang/String;)V", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "getPhone", "()Ljava/lang/Integer;", "setPhone", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "()Z", "setNotificationsEnabled", "(Z)V", "getAvatarColor", "setAvatarColor", "getUserImage", "setUserImage", "toModel", "Lru/mrlargha/arizonaui/mobile/domain/obj/SettingsInfo;", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/String;Ljava/lang/Integer;ZLjava/lang/Integer;Ljava/lang/String;)Lru/mrlargha/arizonaui/mobile/presentation/page/messenger/api/obj/SettingsApiResponse;", "equals", "other", "hashCode", "toString", "ArizonaUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SettingsApiResponse {
    @SerializedName("avatarColor")
    private Integer avatarColor;
    @SerializedName("notifications")
    private boolean isNotificationsEnabled;
    @SerializedName("title")
    private String name;
    @SerializedName("phone")
    private Integer phone;
    @SerializedName("userImage")
    private String userImage;

    public SettingsApiResponse() {
        this(null, null, false, null, null, 31, null);
    }

    public static /* synthetic */ SettingsApiResponse copy$default(SettingsApiResponse settingsApiResponse, String str, Integer num, boolean z, Integer num2, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = settingsApiResponse.name;
        }
        if ((i & 2) != 0) {
            num = settingsApiResponse.phone;
        }
        if ((i & 4) != 0) {
            z = settingsApiResponse.isNotificationsEnabled;
        }
        if ((i & 8) != 0) {
            num2 = settingsApiResponse.avatarColor;
        }
        if ((i & 16) != 0) {
            str2 = settingsApiResponse.userImage;
        }
        String str3 = str2;
        boolean z2 = z;
        return settingsApiResponse.copy(str, num, z2, num2, str3);
    }

    public final String component1() {
        return this.name;
    }

    public final Integer component2() {
        return this.phone;
    }

    public final boolean component3() {
        return this.isNotificationsEnabled;
    }

    public final Integer component4() {
        return this.avatarColor;
    }

    public final String component5() {
        return this.userImage;
    }

    public final SettingsApiResponse copy(String name, Integer num, boolean z, Integer num2, String str) {
        Intrinsics.checkNotNullParameter(name, "name");
        return new SettingsApiResponse(name, num, z, num2, str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof SettingsApiResponse) {
            SettingsApiResponse settingsApiResponse = (SettingsApiResponse) obj;
            return Intrinsics.areEqual(this.name, settingsApiResponse.name) && Intrinsics.areEqual(this.phone, settingsApiResponse.phone) && this.isNotificationsEnabled == settingsApiResponse.isNotificationsEnabled && Intrinsics.areEqual(this.avatarColor, settingsApiResponse.avatarColor) && Intrinsics.areEqual(this.userImage, settingsApiResponse.userImage);
        }
        return false;
    }

    public int hashCode() {
        int hashCode = this.name.hashCode() * 31;
        Integer num = this.phone;
        int hashCode2 = (((hashCode + (num == null ? 0 : num.hashCode())) * 31) + Boolean.hashCode(this.isNotificationsEnabled)) * 31;
        Integer num2 = this.avatarColor;
        int hashCode3 = (hashCode2 + (num2 == null ? 0 : num2.hashCode())) * 31;
        String str = this.userImage;
        return hashCode3 + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        String str = this.name;
        Integer num = this.phone;
        boolean z = this.isNotificationsEnabled;
        Integer num2 = this.avatarColor;
        return "SettingsApiResponse(name=" + str + ", phone=" + num + ", isNotificationsEnabled=" + z + ", avatarColor=" + num2 + ", userImage=" + this.userImage + ")";
    }

    public SettingsApiResponse(String name, Integer num, boolean z, Integer num2, String str) {
        Intrinsics.checkNotNullParameter(name, "name");
        this.name = name;
        this.phone = num;
        this.isNotificationsEnabled = z;
        this.avatarColor = num2;
        this.userImage = str;
    }

    public /* synthetic */ SettingsApiResponse(String str, Integer num, boolean z, Integer num2, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        String str3;
        Integer num3;
        Integer num4;
        boolean z2;
        SettingsApiResponse settingsApiResponse;
        String str4;
        str = (i & 1) != 0 ? "" : str;
        num = (i & 2) != 0 ? null : num;
        z = (i & 4) != 0 ? false : z;
        num2 = (i & 8) != 0 ? null : num2;
        if ((i & 16) != 0) {
            str3 = null;
            z2 = z;
            num3 = num2;
            str4 = str;
            num4 = num;
            settingsApiResponse = this;
        } else {
            str3 = str2;
            num3 = num2;
            num4 = num;
            z2 = z;
            settingsApiResponse = this;
            str4 = str;
        }
        new SettingsApiResponse(str4, num4, z2, num3, str3);
    }

    public final String getName() {
        return this.name;
    }

    public final void setName(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.name = str;
    }

    public final Integer getPhone() {
        return this.phone;
    }

    public final void setPhone(Integer num) {
        this.phone = num;
    }

    public final boolean isNotificationsEnabled() {
        return this.isNotificationsEnabled;
    }

    public final void setNotificationsEnabled(boolean z) {
        this.isNotificationsEnabled = z;
    }

    public final Integer getAvatarColor() {
        return this.avatarColor;
    }

    public final void setAvatarColor(Integer num) {
        this.avatarColor = num;
    }

    public final String getUserImage() {
        return this.userImage;
    }

    public final void setUserImage(String str) {
        this.userImage = str;
    }

    public final SettingsInfo toModel() {
        String str = this.name;
        Integer num = this.phone;
        return new SettingsInfo(str, this.isNotificationsEnabled, this.userImage, AvatarBackground.Companion.fromIndex(this.avatarColor), num != null ? NumberKt.formatPhoneNumber(num.intValue()) : null);
    }
}
