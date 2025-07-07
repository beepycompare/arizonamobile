package ru.mrlargha.arizonaui.mobile.presentation.page.messenger.api.obj;

import androidx.profileinstaller.ProfileVerifier;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import ru.mrlargha.arizonaui.mobile.domain.obj.AvatarBackground;
import ru.mrlargha.arizonaui.mobile.domain.obj.ContactInfo;
import ru.mrlargha.commonui.domain.model.MessageStatus;
import ru.mrlargha.commonui.utils.DateConverter;
import ru.mrlargha.commonui.utils.NumberKt;
/* compiled from: ContactApiResponse.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0002\b\u0016\b\u0086\b\u0018\u00002\u00020\u0001B¯\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\b\b\u0002\u0010\r\u001a\u00020\f\u0012\b\b\u0002\u0010\u000e\u001a\u00020\f\u0012\b\b\u0002\u0010\u000f\u001a\u00020\f\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014¢\u0006\u0004\b\u0015\u0010\u0016J\u0006\u0010-\u001a\u00020.J\t\u0010/\u001a\u00020\u0003HÆ\u0003J\u0010\u00100\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001aJ\u000b\u00101\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0010\u00102\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001aJ\u000b\u00103\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0010\u00104\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001aJ\u000b\u00105\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\t\u00106\u001a\u00020\fHÆ\u0003J\t\u00107\u001a\u00020\fHÆ\u0003J\t\u00108\u001a\u00020\fHÆ\u0003J\t\u00109\u001a\u00020\fHÆ\u0003J\u0010\u0010:\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010(J\u0010\u0010;\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010(J\u0010\u0010<\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010(J\u0010\u0010=\u001a\u0004\u0018\u00010\u0014HÆ\u0003¢\u0006\u0002\u0010+J¸\u0001\u0010>\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000e\u001a\u00020\f2\b\b\u0002\u0010\u000f\u001a\u00020\f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÆ\u0001¢\u0006\u0002\u0010?J\u0013\u0010@\u001a\u00020\f2\b\u0010A\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010B\u001a\u00020\u0003HÖ\u0001J\t\u0010C\u001a\u00020\u0006HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001d\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0015\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b \u0010\u001aR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001fR\u0015\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b\"\u0010\u001aR\u0013\u0010\n\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u001fR\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0011\u0010\r\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b&\u0010%R\u0011\u0010\u000e\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010%R\u0011\u0010\u000f\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b'\u0010%R\u0015\u0010\u0010\u001a\u0004\u0018\u00010\f¢\u0006\n\n\u0002\u0010)\u001a\u0004\b\u0010\u0010(R\u0015\u0010\u0011\u001a\u0004\u0018\u00010\f¢\u0006\n\n\u0002\u0010)\u001a\u0004\b\u0011\u0010(R\u0015\u0010\u0012\u001a\u0004\u0018\u00010\f¢\u0006\n\n\u0002\u0010)\u001a\u0004\b\u0012\u0010(R\u0015\u0010\u0013\u001a\u0004\u0018\u00010\u0014¢\u0006\n\n\u0002\u0010,\u001a\u0004\b*\u0010+¨\u0006D"}, d2 = {"Lru/mrlargha/arizonaui/mobile/presentation/page/messenger/api/obj/ContactModel;", "", "id", "", "onlineId", "title", "", "phone", "image", "avatarColor", "avatarUrl", "contact", "", "online", "isNotificationsAllowed", "hasRead", "isSendAvailable", "isBlocked", "isContact", "timestamp", "", "<init>", "(ILjava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;ZZZZLjava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Long;)V", "getId", "()I", "getOnlineId", "()Ljava/lang/Integer;", "setOnlineId", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getTitle", "()Ljava/lang/String;", "getPhone", "getImage", "getAvatarColor", "getAvatarUrl", "getContact", "()Z", "getOnline", "getHasRead", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getTimestamp", "()Ljava/lang/Long;", "Ljava/lang/Long;", "toModel", "Lru/mrlargha/arizonaui/mobile/domain/obj/ContactInfo;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "copy", "(ILjava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;ZZZZLjava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Long;)Lru/mrlargha/arizonaui/mobile/presentation/page/messenger/api/obj/ContactModel;", "equals", "other", "hashCode", "toString", "ArizonaUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ContactModel {
    private final Integer avatarColor;
    private final String avatarUrl;
    private final boolean contact;
    private final boolean hasRead;
    private final int id;
    private final String image;
    private final Boolean isBlocked;
    private final Boolean isContact;
    private final boolean isNotificationsAllowed;
    private final Boolean isSendAvailable;
    private final boolean online;
    private Integer onlineId;
    private final Integer phone;
    private final Long timestamp;
    private final String title;

    public final int component1() {
        return this.id;
    }

    public final boolean component10() {
        return this.isNotificationsAllowed;
    }

    public final boolean component11() {
        return this.hasRead;
    }

    public final Boolean component12() {
        return this.isSendAvailable;
    }

    public final Boolean component13() {
        return this.isBlocked;
    }

    public final Boolean component14() {
        return this.isContact;
    }

    public final Long component15() {
        return this.timestamp;
    }

    public final Integer component2() {
        return this.onlineId;
    }

    public final String component3() {
        return this.title;
    }

    public final Integer component4() {
        return this.phone;
    }

    public final String component5() {
        return this.image;
    }

    public final Integer component6() {
        return this.avatarColor;
    }

    public final String component7() {
        return this.avatarUrl;
    }

    public final boolean component8() {
        return this.contact;
    }

    public final boolean component9() {
        return this.online;
    }

    public final ContactModel copy(int i, Integer num, String str, Integer num2, String str2, Integer num3, String str3, boolean z, boolean z2, boolean z3, boolean z4, Boolean bool, Boolean bool2, Boolean bool3, Long l) {
        return new ContactModel(i, num, str, num2, str2, num3, str3, z, z2, z3, z4, bool, bool2, bool3, l);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ContactModel) {
            ContactModel contactModel = (ContactModel) obj;
            return this.id == contactModel.id && Intrinsics.areEqual(this.onlineId, contactModel.onlineId) && Intrinsics.areEqual(this.title, contactModel.title) && Intrinsics.areEqual(this.phone, contactModel.phone) && Intrinsics.areEqual(this.image, contactModel.image) && Intrinsics.areEqual(this.avatarColor, contactModel.avatarColor) && Intrinsics.areEqual(this.avatarUrl, contactModel.avatarUrl) && this.contact == contactModel.contact && this.online == contactModel.online && this.isNotificationsAllowed == contactModel.isNotificationsAllowed && this.hasRead == contactModel.hasRead && Intrinsics.areEqual(this.isSendAvailable, contactModel.isSendAvailable) && Intrinsics.areEqual(this.isBlocked, contactModel.isBlocked) && Intrinsics.areEqual(this.isContact, contactModel.isContact) && Intrinsics.areEqual(this.timestamp, contactModel.timestamp);
        }
        return false;
    }

    public int hashCode() {
        int hashCode = Integer.hashCode(this.id) * 31;
        Integer num = this.onlineId;
        int hashCode2 = (hashCode + (num == null ? 0 : num.hashCode())) * 31;
        String str = this.title;
        int hashCode3 = (hashCode2 + (str == null ? 0 : str.hashCode())) * 31;
        Integer num2 = this.phone;
        int hashCode4 = (hashCode3 + (num2 == null ? 0 : num2.hashCode())) * 31;
        String str2 = this.image;
        int hashCode5 = (hashCode4 + (str2 == null ? 0 : str2.hashCode())) * 31;
        Integer num3 = this.avatarColor;
        int hashCode6 = (hashCode5 + (num3 == null ? 0 : num3.hashCode())) * 31;
        String str3 = this.avatarUrl;
        int hashCode7 = (((((((((hashCode6 + (str3 == null ? 0 : str3.hashCode())) * 31) + Boolean.hashCode(this.contact)) * 31) + Boolean.hashCode(this.online)) * 31) + Boolean.hashCode(this.isNotificationsAllowed)) * 31) + Boolean.hashCode(this.hasRead)) * 31;
        Boolean bool = this.isSendAvailable;
        int hashCode8 = (hashCode7 + (bool == null ? 0 : bool.hashCode())) * 31;
        Boolean bool2 = this.isBlocked;
        int hashCode9 = (hashCode8 + (bool2 == null ? 0 : bool2.hashCode())) * 31;
        Boolean bool3 = this.isContact;
        int hashCode10 = (hashCode9 + (bool3 == null ? 0 : bool3.hashCode())) * 31;
        Long l = this.timestamp;
        return hashCode10 + (l != null ? l.hashCode() : 0);
    }

    public String toString() {
        int i = this.id;
        Integer num = this.onlineId;
        String str = this.title;
        Integer num2 = this.phone;
        String str2 = this.image;
        Integer num3 = this.avatarColor;
        String str3 = this.avatarUrl;
        boolean z = this.contact;
        boolean z2 = this.online;
        boolean z3 = this.isNotificationsAllowed;
        boolean z4 = this.hasRead;
        Boolean bool = this.isSendAvailable;
        Boolean bool2 = this.isBlocked;
        Boolean bool3 = this.isContact;
        return "ContactModel(id=" + i + ", onlineId=" + num + ", title=" + str + ", phone=" + num2 + ", image=" + str2 + ", avatarColor=" + num3 + ", avatarUrl=" + str3 + ", contact=" + z + ", online=" + z2 + ", isNotificationsAllowed=" + z3 + ", hasRead=" + z4 + ", isSendAvailable=" + bool + ", isBlocked=" + bool2 + ", isContact=" + bool3 + ", timestamp=" + this.timestamp + ")";
    }

    public ContactModel(int i, Integer num, String str, Integer num2, String str2, Integer num3, String str3, boolean z, boolean z2, boolean z3, boolean z4, Boolean bool, Boolean bool2, Boolean bool3, Long l) {
        this.id = i;
        this.onlineId = num;
        this.title = str;
        this.phone = num2;
        this.image = str2;
        this.avatarColor = num3;
        this.avatarUrl = str3;
        this.contact = z;
        this.online = z2;
        this.isNotificationsAllowed = z3;
        this.hasRead = z4;
        this.isSendAvailable = bool;
        this.isBlocked = bool2;
        this.isContact = bool3;
        this.timestamp = l;
    }

    public /* synthetic */ ContactModel(int i, Integer num, String str, Integer num2, String str2, Integer num3, String str3, boolean z, boolean z2, boolean z3, boolean z4, Boolean bool, Boolean bool2, Boolean bool3, Long l, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, (i2 & 2) != 0 ? null : num, (i2 & 4) != 0 ? null : str, (i2 & 8) != 0 ? null : num2, (i2 & 16) != 0 ? null : str2, (i2 & 32) != 0 ? null : num3, (i2 & 64) != 0 ? null : str3, (i2 & 128) != 0 ? true : z, (i2 & 256) != 0 ? false : z2, (i2 & 512) == 0 ? z3 : false, (i2 & 1024) == 0 ? z4 : true, (i2 & 2048) != 0 ? null : bool, (i2 & 4096) != 0 ? null : bool2, (i2 & 8192) != 0 ? null : bool3, (i2 & 16384) != 0 ? null : l);
    }

    public final int getId() {
        return this.id;
    }

    public final Integer getOnlineId() {
        return this.onlineId;
    }

    public final void setOnlineId(Integer num) {
        this.onlineId = num;
    }

    public final String getTitle() {
        return this.title;
    }

    public final Integer getPhone() {
        return this.phone;
    }

    public final String getImage() {
        return this.image;
    }

    public final Integer getAvatarColor() {
        return this.avatarColor;
    }

    public final String getAvatarUrl() {
        return this.avatarUrl;
    }

    public final boolean getContact() {
        return this.contact;
    }

    public final boolean getOnline() {
        return this.online;
    }

    public final boolean isNotificationsAllowed() {
        return this.isNotificationsAllowed;
    }

    public final boolean getHasRead() {
        return this.hasRead;
    }

    public final Boolean isSendAvailable() {
        return this.isSendAvailable;
    }

    public final Boolean isBlocked() {
        return this.isBlocked;
    }

    public final Boolean isContact() {
        return this.isContact;
    }

    public final Long getTimestamp() {
        return this.timestamp;
    }

    public final ContactInfo toModel() {
        int i = this.id;
        Integer num = this.onlineId;
        String str = this.title;
        if (str == null) {
            str = "unknown";
        }
        AvatarBackground.Companion companion = AvatarBackground.Companion;
        Integer num2 = this.avatarColor;
        AvatarBackground fromIndex = companion.fromIndex(Integer.valueOf(num2 != null ? num2.intValue() : AvatarBackground.RED.ordinal() + 1));
        String str2 = this.title;
        String str3 = str2 == null ? "unknown" : str2;
        String str4 = this.avatarUrl;
        Integer num3 = this.phone;
        String formatPhoneNumber = num3 != null ? NumberKt.formatPhoneNumber(num3.intValue()) : null;
        MessageStatus messageStatus = this.online ? MessageStatus.ONLINE : MessageStatus.OFFLINE;
        boolean z = this.isNotificationsAllowed;
        Long l = this.timestamp;
        return new ContactInfo(i, num, str, str4, fromIndex, str3, formatPhoneNumber, messageStatus, false, this.isContact, false, z, this.hasRead, this.isSendAvailable, this.isBlocked, l == null ? "" : DateConverter.Companion.formatTimestamp$default(DateConverter.Companion, this.timestamp.longValue(), false, 2, null), null, l, null, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_NO_PROFILE_EMBEDDED, null);
    }
}
