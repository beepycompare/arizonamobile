package ru.mrlargha.arizonaui.mobile.domain.obj;

import androidx.core.app.NotificationCompat;
import com.google.android.vending.expansion.downloader.Constants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import ru.mrlargha.commonui.domain.model.MessageStatus;
/* compiled from: MobilePhoneObject.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\t\n\u0002\bF\b\u0086\b\u0018\u00002\u00020\u0001BÕ\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u000f\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u000f\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0019\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0019¢\u0006\u0004\b\u001b\u0010\u001cJ\u0006\u0010C\u001a\u00020\u0006J\u0006\u0010\u0015\u001a\u00020\u000fJ\u0006\u0010D\u001a\u00020\u000fJ\b\u0010E\u001a\u00020\u000fH\u0002J\t\u0010F\u001a\u00020\u0003HÆ\u0003J\u0010\u0010G\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010 J\t\u0010H\u001a\u00020\u0006HÆ\u0003J\u000b\u0010I\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\t\u0010J\u001a\u00020\tHÆ\u0003J\t\u0010K\u001a\u00020\u0006HÆ\u0003J\u000b\u0010L\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\t\u0010M\u001a\u00020\rHÆ\u0003J\t\u0010N\u001a\u00020\u000fHÆ\u0003J\u0010\u0010O\u001a\u0004\u0018\u00010\u000fHÆ\u0003¢\u0006\u0002\u00100J\t\u0010P\u001a\u00020\u000fHÆ\u0003J\t\u0010Q\u001a\u00020\u000fHÆ\u0003J\t\u0010R\u001a\u00020\u000fHÆ\u0003J\u0010\u0010S\u001a\u0004\u0018\u00010\u000fHÆ\u0003¢\u0006\u0002\u00100J\u0010\u0010T\u001a\u0004\u0018\u00010\u000fHÆ\u0003¢\u0006\u0002\u00100J\t\u0010U\u001a\u00020\u0006HÆ\u0003J\t\u0010V\u001a\u00020\u0006HÆ\u0003J\u0010\u0010W\u001a\u0004\u0018\u00010\u0019HÆ\u0003¢\u0006\u0002\u0010=J\u0010\u0010X\u001a\u0004\u0018\u00010\u0019HÆ\u0003¢\u0006\u0002\u0010=JÜ\u0001\u0010Y\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u00062\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\u000f2\b\b\u0002\u0010\u0012\u001a\u00020\u000f2\b\b\u0002\u0010\u0013\u001a\u00020\u000f2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u000f2\b\b\u0002\u0010\u0016\u001a\u00020\u00062\b\b\u0002\u0010\u0017\u001a\u00020\u00062\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00192\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0019HÆ\u0001¢\u0006\u0002\u0010ZJ\u0013\u0010[\u001a\u00020\u000f2\b\u0010\\\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010]\u001a\u00020\u0003HÖ\u0001J\t\u0010^\u001a\u00020\u0006HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010!\u001a\u0004\b\u001f\u0010 R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b$\u0010#R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u001a\u0010\n\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010#\"\u0004\b(\u0010)R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b*\u0010#R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b+\u0010,R\u001a\u0010\u000e\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010-\"\u0004\b.\u0010/R\u001e\u0010\u0010\u001a\u0004\u0018\u00010\u000fX\u0086\u000e¢\u0006\u0010\n\u0002\u00103\u001a\u0004\b\u0010\u00100\"\u0004\b1\u00102R\u0011\u0010\u0011\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010-R\u001a\u0010\u0012\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010-\"\u0004\b4\u0010/R\u001a\u0010\u0013\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u0010-\"\u0004\b6\u0010/R\u0015\u0010\u0014\u001a\u0004\u0018\u00010\u000f¢\u0006\n\n\u0002\u00103\u001a\u0004\b\u0014\u00100R\u001e\u0010\u0015\u001a\u0004\u0018\u00010\u000fX\u0086\u000e¢\u0006\u0010\n\u0002\u00103\u001a\u0004\b\u0015\u00100\"\u0004\b7\u00102R\u001a\u0010\u0016\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u0010#\"\u0004\b9\u0010)R\u001a\u0010\u0017\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010#\"\u0004\b;\u0010)R\u001e\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0086\u000e¢\u0006\u0010\n\u0002\u0010@\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?R\u001e\u0010\u001a\u001a\u0004\u0018\u00010\u0019X\u0086\u000e¢\u0006\u0010\n\u0002\u0010@\u001a\u0004\bA\u0010=\"\u0004\bB\u0010?¨\u0006_"}, d2 = {"Lru/mrlargha/arizonaui/mobile/domain/obj/ContactInfo;", "", "id", "", "onlineId", "contactName", "", "avatarUrl", "contactBackground", "Lru/mrlargha/arizonaui/mobile/domain/obj/AvatarBackground;", "text", "phone", NotificationCompat.CATEGORY_STATUS, "Lru/mrlargha/commonui/domain/model/MessageStatus;", "isAttached", "", "isContact", "isMe", "isNotificationsAllowed", "hasRead", "isSendAvailable", "isBlocked", "formattedTime", "formattedLastLogin", "timestamp", "", "lastLogin", "<init>", "(ILjava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Lru/mrlargha/arizonaui/mobile/domain/obj/AvatarBackground;Ljava/lang/String;Ljava/lang/String;Lru/mrlargha/commonui/domain/model/MessageStatus;ZLjava/lang/Boolean;ZZZLjava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;)V", "getId", "()I", "getOnlineId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getContactName", "()Ljava/lang/String;", "getAvatarUrl", "getContactBackground", "()Lru/mrlargha/arizonaui/mobile/domain/obj/AvatarBackground;", "getText", "setText", "(Ljava/lang/String;)V", "getPhone", "getStatus", "()Lru/mrlargha/commonui/domain/model/MessageStatus;", "()Z", "setAttached", "(Z)V", "()Ljava/lang/Boolean;", "setContact", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "setNotificationsAllowed", "getHasRead", "setHasRead", "setBlocked", "getFormattedTime", "setFormattedTime", "getFormattedLastLogin", "setFormattedLastLogin", "getTimestamp", "()Ljava/lang/Long;", "setTimestamp", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getLastLogin", "setLastLogin", "getIdText", "isBlockedByMe", "isMeBlocked", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "copy", "(ILjava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Lru/mrlargha/arizonaui/mobile/domain/obj/AvatarBackground;Ljava/lang/String;Ljava/lang/String;Lru/mrlargha/commonui/domain/model/MessageStatus;ZLjava/lang/Boolean;ZZZLjava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;)Lru/mrlargha/arizonaui/mobile/domain/obj/ContactInfo;", "equals", "other", "hashCode", "toString", "ArizonaUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ContactInfo {
    private final String avatarUrl;
    private final AvatarBackground contactBackground;
    private final String contactName;
    private String formattedLastLogin;
    private String formattedTime;
    private boolean hasRead;
    private final int id;
    private boolean isAttached;
    private Boolean isBlocked;
    private Boolean isContact;
    private final boolean isMe;
    private boolean isNotificationsAllowed;
    private final Boolean isSendAvailable;
    private Long lastLogin;
    private final Integer onlineId;
    private final String phone;
    private final MessageStatus status;
    private String text;
    private Long timestamp;

    public ContactInfo() {
        this(0, null, null, null, null, null, null, null, false, null, false, false, false, null, null, null, null, null, null, 524287, null);
    }

    public static /* synthetic */ ContactInfo copy$default(ContactInfo contactInfo, int i, Integer num, String str, String str2, AvatarBackground avatarBackground, String str3, String str4, MessageStatus messageStatus, boolean z, Boolean bool, boolean z2, boolean z3, boolean z4, Boolean bool2, Boolean bool3, String str5, String str6, Long l, Long l2, int i2, Object obj) {
        Long l3;
        Long l4;
        int i3 = (i2 & 1) != 0 ? contactInfo.id : i;
        Integer num2 = (i2 & 2) != 0 ? contactInfo.onlineId : num;
        String str7 = (i2 & 4) != 0 ? contactInfo.contactName : str;
        String str8 = (i2 & 8) != 0 ? contactInfo.avatarUrl : str2;
        AvatarBackground avatarBackground2 = (i2 & 16) != 0 ? contactInfo.contactBackground : avatarBackground;
        String str9 = (i2 & 32) != 0 ? contactInfo.text : str3;
        String str10 = (i2 & 64) != 0 ? contactInfo.phone : str4;
        MessageStatus messageStatus2 = (i2 & 128) != 0 ? contactInfo.status : messageStatus;
        boolean z5 = (i2 & 256) != 0 ? contactInfo.isAttached : z;
        Boolean bool4 = (i2 & 512) != 0 ? contactInfo.isContact : bool;
        boolean z6 = (i2 & 1024) != 0 ? contactInfo.isMe : z2;
        boolean z7 = (i2 & 2048) != 0 ? contactInfo.isNotificationsAllowed : z3;
        boolean z8 = (i2 & 4096) != 0 ? contactInfo.hasRead : z4;
        Boolean bool5 = (i2 & 8192) != 0 ? contactInfo.isSendAvailable : bool2;
        int i4 = i3;
        Boolean bool6 = (i2 & 16384) != 0 ? contactInfo.isBlocked : bool3;
        String str11 = (i2 & 32768) != 0 ? contactInfo.formattedTime : str5;
        String str12 = (i2 & 65536) != 0 ? contactInfo.formattedLastLogin : str6;
        Long l5 = (i2 & 131072) != 0 ? contactInfo.timestamp : l;
        if ((i2 & 262144) != 0) {
            l4 = l5;
            l3 = contactInfo.lastLogin;
        } else {
            l3 = l2;
            l4 = l5;
        }
        return contactInfo.copy(i4, num2, str7, str8, avatarBackground2, str9, str10, messageStatus2, z5, bool4, z6, z7, z8, bool5, bool6, str11, str12, l4, l3);
    }

    public final int component1() {
        return this.id;
    }

    public final Boolean component10() {
        return this.isContact;
    }

    public final boolean component11() {
        return this.isMe;
    }

    public final boolean component12() {
        return this.isNotificationsAllowed;
    }

    public final boolean component13() {
        return this.hasRead;
    }

    public final Boolean component14() {
        return this.isSendAvailable;
    }

    public final Boolean component15() {
        return this.isBlocked;
    }

    public final String component16() {
        return this.formattedTime;
    }

    public final String component17() {
        return this.formattedLastLogin;
    }

    public final Long component18() {
        return this.timestamp;
    }

    public final Long component19() {
        return this.lastLogin;
    }

    public final Integer component2() {
        return this.onlineId;
    }

    public final String component3() {
        return this.contactName;
    }

    public final String component4() {
        return this.avatarUrl;
    }

    public final AvatarBackground component5() {
        return this.contactBackground;
    }

    public final String component6() {
        return this.text;
    }

    public final String component7() {
        return this.phone;
    }

    public final MessageStatus component8() {
        return this.status;
    }

    public final boolean component9() {
        return this.isAttached;
    }

    public final ContactInfo copy(int i, Integer num, String contactName, String str, AvatarBackground contactBackground, String text, String str2, MessageStatus status, boolean z, Boolean bool, boolean z2, boolean z3, boolean z4, Boolean bool2, Boolean bool3, String formattedTime, String formattedLastLogin, Long l, Long l2) {
        Intrinsics.checkNotNullParameter(contactName, "contactName");
        Intrinsics.checkNotNullParameter(contactBackground, "contactBackground");
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(status, "status");
        Intrinsics.checkNotNullParameter(formattedTime, "formattedTime");
        Intrinsics.checkNotNullParameter(formattedLastLogin, "formattedLastLogin");
        return new ContactInfo(i, num, contactName, str, contactBackground, text, str2, status, z, bool, z2, z3, z4, bool2, bool3, formattedTime, formattedLastLogin, l, l2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ContactInfo) {
            ContactInfo contactInfo = (ContactInfo) obj;
            return this.id == contactInfo.id && Intrinsics.areEqual(this.onlineId, contactInfo.onlineId) && Intrinsics.areEqual(this.contactName, contactInfo.contactName) && Intrinsics.areEqual(this.avatarUrl, contactInfo.avatarUrl) && this.contactBackground == contactInfo.contactBackground && Intrinsics.areEqual(this.text, contactInfo.text) && Intrinsics.areEqual(this.phone, contactInfo.phone) && this.status == contactInfo.status && this.isAttached == contactInfo.isAttached && Intrinsics.areEqual(this.isContact, contactInfo.isContact) && this.isMe == contactInfo.isMe && this.isNotificationsAllowed == contactInfo.isNotificationsAllowed && this.hasRead == contactInfo.hasRead && Intrinsics.areEqual(this.isSendAvailable, contactInfo.isSendAvailable) && Intrinsics.areEqual(this.isBlocked, contactInfo.isBlocked) && Intrinsics.areEqual(this.formattedTime, contactInfo.formattedTime) && Intrinsics.areEqual(this.formattedLastLogin, contactInfo.formattedLastLogin) && Intrinsics.areEqual(this.timestamp, contactInfo.timestamp) && Intrinsics.areEqual(this.lastLogin, contactInfo.lastLogin);
        }
        return false;
    }

    public int hashCode() {
        int hashCode = Integer.hashCode(this.id) * 31;
        Integer num = this.onlineId;
        int hashCode2 = (((hashCode + (num == null ? 0 : num.hashCode())) * 31) + this.contactName.hashCode()) * 31;
        String str = this.avatarUrl;
        int hashCode3 = (((((hashCode2 + (str == null ? 0 : str.hashCode())) * 31) + this.contactBackground.hashCode()) * 31) + this.text.hashCode()) * 31;
        String str2 = this.phone;
        int hashCode4 = (((((hashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31) + this.status.hashCode()) * 31) + Boolean.hashCode(this.isAttached)) * 31;
        Boolean bool = this.isContact;
        int hashCode5 = (((((((hashCode4 + (bool == null ? 0 : bool.hashCode())) * 31) + Boolean.hashCode(this.isMe)) * 31) + Boolean.hashCode(this.isNotificationsAllowed)) * 31) + Boolean.hashCode(this.hasRead)) * 31;
        Boolean bool2 = this.isSendAvailable;
        int hashCode6 = (hashCode5 + (bool2 == null ? 0 : bool2.hashCode())) * 31;
        Boolean bool3 = this.isBlocked;
        int hashCode7 = (((((hashCode6 + (bool3 == null ? 0 : bool3.hashCode())) * 31) + this.formattedTime.hashCode()) * 31) + this.formattedLastLogin.hashCode()) * 31;
        Long l = this.timestamp;
        int hashCode8 = (hashCode7 + (l == null ? 0 : l.hashCode())) * 31;
        Long l2 = this.lastLogin;
        return hashCode8 + (l2 != null ? l2.hashCode() : 0);
    }

    public String toString() {
        int i = this.id;
        Integer num = this.onlineId;
        String str = this.contactName;
        String str2 = this.avatarUrl;
        AvatarBackground avatarBackground = this.contactBackground;
        String str3 = this.text;
        String str4 = this.phone;
        MessageStatus messageStatus = this.status;
        boolean z = this.isAttached;
        Boolean bool = this.isContact;
        boolean z2 = this.isMe;
        boolean z3 = this.isNotificationsAllowed;
        boolean z4 = this.hasRead;
        Boolean bool2 = this.isSendAvailable;
        Boolean bool3 = this.isBlocked;
        String str5 = this.formattedTime;
        String str6 = this.formattedLastLogin;
        Long l = this.timestamp;
        return "ContactInfo(id=" + i + ", onlineId=" + num + ", contactName=" + str + ", avatarUrl=" + str2 + ", contactBackground=" + avatarBackground + ", text=" + str3 + ", phone=" + str4 + ", status=" + messageStatus + ", isAttached=" + z + ", isContact=" + bool + ", isMe=" + z2 + ", isNotificationsAllowed=" + z3 + ", hasRead=" + z4 + ", isSendAvailable=" + bool2 + ", isBlocked=" + bool3 + ", formattedTime=" + str5 + ", formattedLastLogin=" + str6 + ", timestamp=" + l + ", lastLogin=" + this.lastLogin + ")";
    }

    public ContactInfo(int i, Integer num, String contactName, String str, AvatarBackground contactBackground, String text, String str2, MessageStatus status, boolean z, Boolean bool, boolean z2, boolean z3, boolean z4, Boolean bool2, Boolean bool3, String formattedTime, String formattedLastLogin, Long l, Long l2) {
        Intrinsics.checkNotNullParameter(contactName, "contactName");
        Intrinsics.checkNotNullParameter(contactBackground, "contactBackground");
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(status, "status");
        Intrinsics.checkNotNullParameter(formattedTime, "formattedTime");
        Intrinsics.checkNotNullParameter(formattedLastLogin, "formattedLastLogin");
        this.id = i;
        this.onlineId = num;
        this.contactName = contactName;
        this.avatarUrl = str;
        this.contactBackground = contactBackground;
        this.text = text;
        this.phone = str2;
        this.status = status;
        this.isAttached = z;
        this.isContact = bool;
        this.isMe = z2;
        this.isNotificationsAllowed = z3;
        this.hasRead = z4;
        this.isSendAvailable = bool2;
        this.isBlocked = bool3;
        this.formattedTime = formattedTime;
        this.formattedLastLogin = formattedLastLogin;
        this.timestamp = l;
        this.lastLogin = l2;
    }

    public final int getId() {
        return this.id;
    }

    public final Integer getOnlineId() {
        return this.onlineId;
    }

    public final String getContactName() {
        return this.contactName;
    }

    public final String getAvatarUrl() {
        return this.avatarUrl;
    }

    public final AvatarBackground getContactBackground() {
        return this.contactBackground;
    }

    public final String getText() {
        return this.text;
    }

    public final void setText(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.text = str;
    }

    public final String getPhone() {
        return this.phone;
    }

    public final MessageStatus getStatus() {
        return this.status;
    }

    public final boolean isAttached() {
        return this.isAttached;
    }

    public final void setAttached(boolean z) {
        this.isAttached = z;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ ContactInfo(int i, Integer num, String str, String str2, AvatarBackground avatarBackground, String str3, String str4, MessageStatus messageStatus, boolean z, Boolean bool, boolean z2, boolean z3, boolean z4, Boolean bool2, Boolean bool3, String str5, String str6, Long l, Long l2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 0 : i, (i2 & 2) != 0 ? 0 : num, (i2 & 4) != 0 ? "" : str, (i2 & 8) != 0 ? null : str2, (i2 & 16) != 0 ? AvatarBackground.RED : avatarBackground, (i2 & 32) != 0 ? "" : str3, (i2 & 64) != 0 ? null : str4, (i2 & 128) != 0 ? MessageStatus.OFFLINE : messageStatus, (i2 & 256) != 0 ? false : z, (i2 & 512) != 0 ? r3 : bool, (i2 & 1024) != 0 ? false : z2, (i2 & 2048) != 0 ? false : z3, (i2 & 4096) != 0 ? true : z4, (i2 & 8192) != 0 ? true : bool2, (i2 & 16384) == 0 ? bool3 : false, (32768 & i2) != 0 ? "" : str5, (i2 & 65536) == 0 ? str6 : "", (i2 & 131072) != 0 ? null : l, (i2 & 262144) != 0 ? null : l2);
    }

    public final Boolean isContact() {
        return this.isContact;
    }

    public final void setContact(Boolean bool) {
        this.isContact = bool;
    }

    public final boolean isMe() {
        return this.isMe;
    }

    public final boolean isNotificationsAllowed() {
        return this.isNotificationsAllowed;
    }

    public final void setNotificationsAllowed(boolean z) {
        this.isNotificationsAllowed = z;
    }

    public final boolean getHasRead() {
        return this.hasRead;
    }

    public final void setHasRead(boolean z) {
        this.hasRead = z;
    }

    public final Boolean isSendAvailable() {
        return this.isSendAvailable;
    }

    public final Boolean isBlocked() {
        return this.isBlocked;
    }

    public final void setBlocked(Boolean bool) {
        this.isBlocked = bool;
    }

    public final String getFormattedTime() {
        return this.formattedTime;
    }

    public final void setFormattedTime(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.formattedTime = str;
    }

    public final String getFormattedLastLogin() {
        return this.formattedLastLogin;
    }

    public final void setFormattedLastLogin(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.formattedLastLogin = str;
    }

    public final Long getTimestamp() {
        return this.timestamp;
    }

    public final void setTimestamp(Long l) {
        this.timestamp = l;
    }

    public final Long getLastLogin() {
        return this.lastLogin;
    }

    public final void setLastLogin(Long l) {
        this.lastLogin = l;
    }

    public final String getIdText() {
        MessageStatus messageStatus = this.status;
        MessageStatus messageStatus2 = MessageStatus.ONLINE;
        Object obj = Constants.FILENAME_SEQUENCE_SEPARATOR;
        if (messageStatus == messageStatus2) {
            Object obj2 = this.onlineId;
            if (obj2 != null) {
                obj = obj2;
            }
            return "id: " + obj;
        }
        String str = this.formattedLastLogin;
        if (str.length() != 0) {
            obj = str;
        }
        return (String) obj;
    }

    /* renamed from: isBlocked  reason: collision with other method in class */
    public final boolean m10465isBlocked() {
        return isBlockedByMe() || isMeBlocked();
    }

    public final boolean isBlockedByMe() {
        return Intrinsics.areEqual((Object) this.isBlocked, (Object) true);
    }

    private final boolean isMeBlocked() {
        return Intrinsics.areEqual((Object) this.isSendAvailable, (Object) false);
    }
}
