package ru.mrlargha.arizonaui.mobile.presentation.page.messenger.api.obj;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import ru.mrlargha.arizonaui.mobile.domain.obj.AvatarBackground;
import ru.mrlargha.arizonaui.mobile.domain.obj.ContactInfo;
import ru.mrlargha.commonui.domain.model.MessageStatus;
import ru.mrlargha.commonui.utils.DateConverter;
import ru.mrlargha.commonui.utils.NumberKt;
import ru.mrlargha.commonui.utils.StringKt;
/* compiled from: ContactApiResponse.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\t\n\u0002\b0\n\u0002\u0018\u0002\n\u0002\b\u0019\b\u0086\b\u0018\u00002\u00020\u0001BÏ\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\u000b\u0012\b\b\u0002\u0010\r\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u000b\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0016\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0018\u0010\u0019J\u0006\u0010F\u001a\u00020GJ\t\u0010H\u001a\u00020\u0003HÆ\u0003J\u0010\u0010I\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001fJ\t\u0010J\u001a\u00020\u0006HÆ\u0003J\u0010\u0010K\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001fJ\u0010\u0010L\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001fJ\u000b\u0010M\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\t\u0010N\u001a\u00020\u000bHÆ\u0003J\t\u0010O\u001a\u00020\u000bHÆ\u0003J\t\u0010P\u001a\u00020\u0006HÆ\u0003J\t\u0010Q\u001a\u00020\u0006HÆ\u0003J\t\u0010R\u001a\u00020\u000bHÆ\u0003J\t\u0010S\u001a\u00020\u000bHÆ\u0003J\u0010\u0010T\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u00107J\u0010\u0010U\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u00107J\u0010\u0010V\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u00107J\u0010\u0010W\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u00107J\u0010\u0010X\u001a\u0004\u0018\u00010\u0016HÆ\u0003¢\u0006\u0002\u0010@J\u000b\u0010Y\u001a\u0004\u0018\u00010\u0006HÆ\u0003JÖ\u0001\u0010Z\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\r\u001a\u00020\u00062\b\b\u0002\u0010\u000e\u001a\u00020\u00062\b\b\u0002\u0010\u000f\u001a\u00020\u000b2\b\b\u0002\u0010\u0010\u001a\u00020\u000b2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u0010[J\u0013\u0010\\\u001a\u00020\u000b2\b\u0010]\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010^\u001a\u00020\u0003HÖ\u0001J\t\u0010_\u001a\u00020\u0006HÖ\u0001R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\"\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\"\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001e\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\"\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\"\u001a\u0004\b'\u0010\u001f\"\u0004\b(\u0010!R\"\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\"\u001a\u0004\b)\u0010\u001f\"\u0004\b*\u0010!R \u0010\t\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010$\"\u0004\b,\u0010&R\u001e\u0010\n\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010-\"\u0004\b.\u0010/R\u001e\u0010\f\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010-\"\u0004\b0\u0010/R\u001e\u0010\r\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010$\"\u0004\b2\u0010&R\u001e\u0010\u000e\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010$\"\u0004\b4\u0010&R\u001e\u0010\u000f\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010-\"\u0004\b5\u0010/R\u001e\u0010\u0010\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010-\"\u0004\b6\u0010/R\"\u0010\u0011\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010:\u001a\u0004\b\u0011\u00107\"\u0004\b8\u00109R\"\u0010\u0012\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010:\u001a\u0004\b\u0012\u00107\"\u0004\b;\u00109R\"\u0010\u0013\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010:\u001a\u0004\b\u0013\u00107\"\u0004\b<\u00109R\"\u0010\u0014\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010:\u001a\u0004\b=\u00107\"\u0004\b>\u00109R\"\u0010\u0015\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010C\u001a\u0004\b?\u0010@\"\u0004\bA\u0010BR \u0010\u0017\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bD\u0010$\"\u0004\bE\u0010&¨\u0006`"}, d2 = {"Lru/mrlargha/arizonaui/mobile/presentation/page/messenger/api/obj/ContactApiResponse;", "", "id", "", "onlineId", "title", "", "phone", "avatarColor", "userImage", "isPinned", "", "isOnline", "messageText", "text", "isMe", "isNotificationsAllowed", "isSendAvailable", "isBlocked", "isContact", "hasRead", "timestamp", "", "lastLogin", "<init>", "(ILjava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;ZZLjava/lang/String;Ljava/lang/String;ZZLjava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Long;Ljava/lang/String;)V", "getId", "()I", "setId", "(I)V", "getOnlineId", "()Ljava/lang/Integer;", "setOnlineId", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getTitle", "()Ljava/lang/String;", "setTitle", "(Ljava/lang/String;)V", "getPhone", "setPhone", "getAvatarColor", "setAvatarColor", "getUserImage", "setUserImage", "()Z", "setPinned", "(Z)V", "setOnline", "getMessageText", "setMessageText", "getText", "setText", "setMe", "setNotificationsAllowed", "()Ljava/lang/Boolean;", "setSendAvailable", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "setBlocked", "setContact", "getHasRead", "setHasRead", "getTimestamp", "()Ljava/lang/Long;", "setTimestamp", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getLastLogin", "setLastLogin", "toModel", "Lru/mrlargha/arizonaui/mobile/domain/obj/ContactInfo;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "copy", "(ILjava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;ZZLjava/lang/String;Ljava/lang/String;ZZLjava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Long;Ljava/lang/String;)Lru/mrlargha/arizonaui/mobile/presentation/page/messenger/api/obj/ContactApiResponse;", "equals", "other", "hashCode", "toString", "ArizonaUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ContactApiResponse {
    @SerializedName("avatarColor")
    private Integer avatarColor;
    @SerializedName("hasRead")
    private Boolean hasRead;
    @SerializedName("id")
    private int id;
    @SerializedName("blocked")
    private Boolean isBlocked;
    @SerializedName("isContact")
    private Boolean isContact;
    @SerializedName("sentByMe")
    private boolean isMe;
    @SerializedName("notificationsAllowed")
    private boolean isNotificationsAllowed;
    @SerializedName("online")
    private boolean isOnline;
    @SerializedName("pinned")
    private boolean isPinned;
    @SerializedName("sendAvailable")
    private Boolean isSendAvailable;
    @SerializedName("lastLogin")
    private String lastLogin;
    @SerializedName("message")
    private String messageText;
    @SerializedName("onlineId")
    private Integer onlineId;
    @SerializedName("phone")
    private Integer phone;
    @SerializedName("text")
    private String text;
    @SerializedName("createdAtTimestamp")
    private Long timestamp;
    @SerializedName("title")
    private String title;
    @SerializedName("userImage")
    private String userImage;

    public ContactApiResponse() {
        this(0, null, null, null, null, null, false, false, null, null, false, false, null, null, null, null, null, null, 262143, null);
    }

    public static /* synthetic */ ContactApiResponse copy$default(ContactApiResponse contactApiResponse, int i, Integer num, String str, Integer num2, Integer num3, String str2, boolean z, boolean z2, String str3, String str4, boolean z3, boolean z4, Boolean bool, Boolean bool2, Boolean bool3, Boolean bool4, Long l, String str5, int i2, Object obj) {
        String str6;
        Long l2;
        int i3 = (i2 & 1) != 0 ? contactApiResponse.id : i;
        Integer num4 = (i2 & 2) != 0 ? contactApiResponse.onlineId : num;
        String str7 = (i2 & 4) != 0 ? contactApiResponse.title : str;
        Integer num5 = (i2 & 8) != 0 ? contactApiResponse.phone : num2;
        Integer num6 = (i2 & 16) != 0 ? contactApiResponse.avatarColor : num3;
        String str8 = (i2 & 32) != 0 ? contactApiResponse.userImage : str2;
        boolean z5 = (i2 & 64) != 0 ? contactApiResponse.isPinned : z;
        boolean z6 = (i2 & 128) != 0 ? contactApiResponse.isOnline : z2;
        String str9 = (i2 & 256) != 0 ? contactApiResponse.messageText : str3;
        String str10 = (i2 & 512) != 0 ? contactApiResponse.text : str4;
        boolean z7 = (i2 & 1024) != 0 ? contactApiResponse.isMe : z3;
        boolean z8 = (i2 & 2048) != 0 ? contactApiResponse.isNotificationsAllowed : z4;
        Boolean bool5 = (i2 & 4096) != 0 ? contactApiResponse.isSendAvailable : bool;
        Boolean bool6 = (i2 & 8192) != 0 ? contactApiResponse.isBlocked : bool2;
        int i4 = i3;
        Boolean bool7 = (i2 & 16384) != 0 ? contactApiResponse.isContact : bool3;
        Boolean bool8 = (i2 & 32768) != 0 ? contactApiResponse.hasRead : bool4;
        Long l3 = (i2 & 65536) != 0 ? contactApiResponse.timestamp : l;
        if ((i2 & 131072) != 0) {
            l2 = l3;
            str6 = contactApiResponse.lastLogin;
        } else {
            str6 = str5;
            l2 = l3;
        }
        return contactApiResponse.copy(i4, num4, str7, num5, num6, str8, z5, z6, str9, str10, z7, z8, bool5, bool6, bool7, bool8, l2, str6);
    }

    public final int component1() {
        return this.id;
    }

    public final String component10() {
        return this.text;
    }

    public final boolean component11() {
        return this.isMe;
    }

    public final boolean component12() {
        return this.isNotificationsAllowed;
    }

    public final Boolean component13() {
        return this.isSendAvailable;
    }

    public final Boolean component14() {
        return this.isBlocked;
    }

    public final Boolean component15() {
        return this.isContact;
    }

    public final Boolean component16() {
        return this.hasRead;
    }

    public final Long component17() {
        return this.timestamp;
    }

    public final String component18() {
        return this.lastLogin;
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

    public final Integer component5() {
        return this.avatarColor;
    }

    public final String component6() {
        return this.userImage;
    }

    public final boolean component7() {
        return this.isPinned;
    }

    public final boolean component8() {
        return this.isOnline;
    }

    public final String component9() {
        return this.messageText;
    }

    public final ContactApiResponse copy(int i, Integer num, String title, Integer num2, Integer num3, String str, boolean z, boolean z2, String messageText, String text, boolean z3, boolean z4, Boolean bool, Boolean bool2, Boolean bool3, Boolean bool4, Long l, String str2) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(messageText, "messageText");
        Intrinsics.checkNotNullParameter(text, "text");
        return new ContactApiResponse(i, num, title, num2, num3, str, z, z2, messageText, text, z3, z4, bool, bool2, bool3, bool4, l, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ContactApiResponse) {
            ContactApiResponse contactApiResponse = (ContactApiResponse) obj;
            return this.id == contactApiResponse.id && Intrinsics.areEqual(this.onlineId, contactApiResponse.onlineId) && Intrinsics.areEqual(this.title, contactApiResponse.title) && Intrinsics.areEqual(this.phone, contactApiResponse.phone) && Intrinsics.areEqual(this.avatarColor, contactApiResponse.avatarColor) && Intrinsics.areEqual(this.userImage, contactApiResponse.userImage) && this.isPinned == contactApiResponse.isPinned && this.isOnline == contactApiResponse.isOnline && Intrinsics.areEqual(this.messageText, contactApiResponse.messageText) && Intrinsics.areEqual(this.text, contactApiResponse.text) && this.isMe == contactApiResponse.isMe && this.isNotificationsAllowed == contactApiResponse.isNotificationsAllowed && Intrinsics.areEqual(this.isSendAvailable, contactApiResponse.isSendAvailable) && Intrinsics.areEqual(this.isBlocked, contactApiResponse.isBlocked) && Intrinsics.areEqual(this.isContact, contactApiResponse.isContact) && Intrinsics.areEqual(this.hasRead, contactApiResponse.hasRead) && Intrinsics.areEqual(this.timestamp, contactApiResponse.timestamp) && Intrinsics.areEqual(this.lastLogin, contactApiResponse.lastLogin);
        }
        return false;
    }

    public int hashCode() {
        int hashCode = Integer.hashCode(this.id) * 31;
        Integer num = this.onlineId;
        int hashCode2 = (((hashCode + (num == null ? 0 : num.hashCode())) * 31) + this.title.hashCode()) * 31;
        Integer num2 = this.phone;
        int hashCode3 = (hashCode2 + (num2 == null ? 0 : num2.hashCode())) * 31;
        Integer num3 = this.avatarColor;
        int hashCode4 = (hashCode3 + (num3 == null ? 0 : num3.hashCode())) * 31;
        String str = this.userImage;
        int hashCode5 = (((((((((((((hashCode4 + (str == null ? 0 : str.hashCode())) * 31) + Boolean.hashCode(this.isPinned)) * 31) + Boolean.hashCode(this.isOnline)) * 31) + this.messageText.hashCode()) * 31) + this.text.hashCode()) * 31) + Boolean.hashCode(this.isMe)) * 31) + Boolean.hashCode(this.isNotificationsAllowed)) * 31;
        Boolean bool = this.isSendAvailable;
        int hashCode6 = (hashCode5 + (bool == null ? 0 : bool.hashCode())) * 31;
        Boolean bool2 = this.isBlocked;
        int hashCode7 = (hashCode6 + (bool2 == null ? 0 : bool2.hashCode())) * 31;
        Boolean bool3 = this.isContact;
        int hashCode8 = (hashCode7 + (bool3 == null ? 0 : bool3.hashCode())) * 31;
        Boolean bool4 = this.hasRead;
        int hashCode9 = (hashCode8 + (bool4 == null ? 0 : bool4.hashCode())) * 31;
        Long l = this.timestamp;
        int hashCode10 = (hashCode9 + (l == null ? 0 : l.hashCode())) * 31;
        String str2 = this.lastLogin;
        return hashCode10 + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        int i = this.id;
        Integer num = this.onlineId;
        String str = this.title;
        Integer num2 = this.phone;
        Integer num3 = this.avatarColor;
        String str2 = this.userImage;
        boolean z = this.isPinned;
        boolean z2 = this.isOnline;
        String str3 = this.messageText;
        String str4 = this.text;
        boolean z3 = this.isMe;
        boolean z4 = this.isNotificationsAllowed;
        Boolean bool = this.isSendAvailable;
        Boolean bool2 = this.isBlocked;
        Boolean bool3 = this.isContact;
        Boolean bool4 = this.hasRead;
        Long l = this.timestamp;
        return "ContactApiResponse(id=" + i + ", onlineId=" + num + ", title=" + str + ", phone=" + num2 + ", avatarColor=" + num3 + ", userImage=" + str2 + ", isPinned=" + z + ", isOnline=" + z2 + ", messageText=" + str3 + ", text=" + str4 + ", isMe=" + z3 + ", isNotificationsAllowed=" + z4 + ", isSendAvailable=" + bool + ", isBlocked=" + bool2 + ", isContact=" + bool3 + ", hasRead=" + bool4 + ", timestamp=" + l + ", lastLogin=" + this.lastLogin + ")";
    }

    public ContactApiResponse(int i, Integer num, String title, Integer num2, Integer num3, String str, boolean z, boolean z2, String messageText, String text, boolean z3, boolean z4, Boolean bool, Boolean bool2, Boolean bool3, Boolean bool4, Long l, String str2) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(messageText, "messageText");
        Intrinsics.checkNotNullParameter(text, "text");
        this.id = i;
        this.onlineId = num;
        this.title = title;
        this.phone = num2;
        this.avatarColor = num3;
        this.userImage = str;
        this.isPinned = z;
        this.isOnline = z2;
        this.messageText = messageText;
        this.text = text;
        this.isMe = z3;
        this.isNotificationsAllowed = z4;
        this.isSendAvailable = bool;
        this.isBlocked = bool2;
        this.isContact = bool3;
        this.hasRead = bool4;
        this.timestamp = l;
        this.lastLogin = str2;
    }

    public final int getId() {
        return this.id;
    }

    public final void setId(int i) {
        this.id = i;
    }

    public final Integer getOnlineId() {
        return this.onlineId;
    }

    public final void setOnlineId(Integer num) {
        this.onlineId = num;
    }

    public /* synthetic */ ContactApiResponse(int i, Integer num, String str, Integer num2, Integer num3, String str2, boolean z, boolean z2, String str3, String str4, boolean z3, boolean z4, Boolean bool, Boolean bool2, Boolean bool3, Boolean bool4, Long l, String str5, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? -1 : i, (i2 & 2) != 0 ? null : num, (i2 & 4) != 0 ? "unknown" : str, (i2 & 8) != 0 ? null : num2, (i2 & 16) != 0 ? null : num3, (i2 & 32) != 0 ? null : str2, (i2 & 64) != 0 ? false : z, (i2 & 128) != 0 ? false : z2, (i2 & 256) != 0 ? "" : str3, (i2 & 512) == 0 ? str4 : "", (i2 & 1024) != 0 ? false : z3, (i2 & 2048) == 0 ? z4 : false, (i2 & 4096) != 0 ? null : bool, (i2 & 8192) != 0 ? null : bool2, (i2 & 16384) != 0 ? null : bool3, (i2 & 32768) != 0 ? null : bool4, (i2 & 65536) != 0 ? null : l, (i2 & 131072) != 0 ? null : str5);
    }

    public final String getTitle() {
        return this.title;
    }

    public final void setTitle(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.title = str;
    }

    public final Integer getPhone() {
        return this.phone;
    }

    public final void setPhone(Integer num) {
        this.phone = num;
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

    public final boolean isPinned() {
        return this.isPinned;
    }

    public final void setPinned(boolean z) {
        this.isPinned = z;
    }

    public final boolean isOnline() {
        return this.isOnline;
    }

    public final void setOnline(boolean z) {
        this.isOnline = z;
    }

    public final String getMessageText() {
        return this.messageText;
    }

    public final void setMessageText(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.messageText = str;
    }

    public final String getText() {
        return this.text;
    }

    public final void setText(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.text = str;
    }

    public final boolean isMe() {
        return this.isMe;
    }

    public final void setMe(boolean z) {
        this.isMe = z;
    }

    public final boolean isNotificationsAllowed() {
        return this.isNotificationsAllowed;
    }

    public final void setNotificationsAllowed(boolean z) {
        this.isNotificationsAllowed = z;
    }

    public final Boolean isSendAvailable() {
        return this.isSendAvailable;
    }

    public final void setSendAvailable(Boolean bool) {
        this.isSendAvailable = bool;
    }

    public final Boolean isBlocked() {
        return this.isBlocked;
    }

    public final void setBlocked(Boolean bool) {
        this.isBlocked = bool;
    }

    public final Boolean isContact() {
        return this.isContact;
    }

    public final void setContact(Boolean bool) {
        this.isContact = bool;
    }

    public final Boolean getHasRead() {
        return this.hasRead;
    }

    public final void setHasRead(Boolean bool) {
        this.hasRead = bool;
    }

    public final Long getTimestamp() {
        return this.timestamp;
    }

    public final void setTimestamp(Long l) {
        this.timestamp = l;
    }

    public final String getLastLogin() {
        return this.lastLogin;
    }

    public final void setLastLogin(String str) {
        this.lastLogin = str;
    }

    public final ContactInfo toModel() {
        String formatTimestamp$default;
        Long longOrNull;
        int i = this.id;
        Integer num = this.onlineId;
        String str = this.title;
        AvatarBackground.Companion companion = AvatarBackground.Companion;
        Integer num2 = this.avatarColor;
        AvatarBackground fromIndex = companion.fromIndex(Integer.valueOf(num2 != null ? num2.intValue() : AvatarBackground.RED.ordinal() + 1));
        String unicodeFormatToEmoji = StringKt.unicodeFormatToEmoji(this.messageText);
        if (unicodeFormatToEmoji.length() == 0) {
            unicodeFormatToEmoji = StringKt.unicodeFormatToEmoji(this.text);
        }
        String str2 = unicodeFormatToEmoji;
        Integer num3 = this.phone;
        String formatPhoneNumber = num3 != null ? NumberKt.formatPhoneNumber(num3.intValue()) : null;
        String str3 = this.userImage;
        MessageStatus messageStatus = this.isOnline ? MessageStatus.ONLINE : MessageStatus.OFFLINE;
        boolean z = this.isPinned;
        boolean z2 = this.isMe;
        boolean z3 = this.isNotificationsAllowed;
        String str4 = "";
        if (this.timestamp == null) {
            formatTimestamp$default = "";
        } else {
            DateConverter.Companion companion2 = DateConverter.Companion;
            Long l = this.timestamp;
            Intrinsics.checkNotNull(l);
            formatTimestamp$default = DateConverter.Companion.formatTimestamp$default(companion2, l.longValue(), false, 2, null);
        }
        String str5 = this.lastLogin;
        if ((str5 != null ? StringsKt.toLongOrNull(str5) : null) != null) {
            DateConverter.Companion companion3 = DateConverter.Companion;
            String str6 = this.lastLogin;
            Intrinsics.checkNotNull(str6 != null ? StringsKt.toLongOrNull(str6) : null);
            str4 = "Был в сети " + DateConverter.Companion.formatTimestamp$default(companion3, longOrNull.longValue(), false, 2, null);
        }
        String str7 = str4;
        Long l2 = this.timestamp;
        String str8 = this.lastLogin;
        Long longOrNull2 = str8 != null ? StringsKt.toLongOrNull(str8) : null;
        Boolean bool = this.hasRead;
        return new ContactInfo(i, num, str, str3, fromIndex, str2, formatPhoneNumber, messageStatus, z, this.isContact, z2, z3, bool != null ? bool.booleanValue() : true, this.isSendAvailable, this.isBlocked, formatTimestamp$default, str7, l2, longOrNull2);
    }
}
