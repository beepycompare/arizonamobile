package ru.mrlargha.arizonaui.mobile.domain.obj;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: MobilePhoneObject.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0018\b\u0086\b\u0018\u00002\u00020\u0001BC\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001a\u001a\u00020\bHÆ\u0003J\t\u0010\u001b\u001a\u00020\nHÆ\u0003J\t\u0010\u001c\u001a\u00020\nHÆ\u0003JE\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\nHÆ\u0001J\u0013\u0010\u001e\u001a\u00020\n2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020\u0003HÖ\u0001J\t\u0010!\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u000b\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u0016¨\u0006\""}, d2 = {"Lru/mrlargha/arizonaui/mobile/domain/obj/MessageInfo;", "", "id", "", "text", "", "formattedTime", "createAt", "", "sendByMe", "", "isLoader", "<init>", "(ILjava/lang/String;Ljava/lang/String;JZZ)V", "getId", "()I", "getText", "()Ljava/lang/String;", "getFormattedTime", "getCreateAt", "()J", "getSendByMe", "()Z", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "toString", "ArizonaUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class MessageInfo {
    private final long createAt;
    private final String formattedTime;
    private final int id;
    private final boolean isLoader;
    private final boolean sendByMe;
    private final String text;

    public MessageInfo() {
        this(0, null, null, 0L, false, false, 63, null);
    }

    public static /* synthetic */ MessageInfo copy$default(MessageInfo messageInfo, int i, String str, String str2, long j, boolean z, boolean z2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = messageInfo.id;
        }
        if ((i2 & 2) != 0) {
            str = messageInfo.text;
        }
        if ((i2 & 4) != 0) {
            str2 = messageInfo.formattedTime;
        }
        if ((i2 & 8) != 0) {
            j = messageInfo.createAt;
        }
        if ((i2 & 16) != 0) {
            z = messageInfo.sendByMe;
        }
        if ((i2 & 32) != 0) {
            z2 = messageInfo.isLoader;
        }
        long j2 = j;
        String str3 = str2;
        return messageInfo.copy(i, str, str3, j2, z, z2);
    }

    public final int component1() {
        return this.id;
    }

    public final String component2() {
        return this.text;
    }

    public final String component3() {
        return this.formattedTime;
    }

    public final long component4() {
        return this.createAt;
    }

    public final boolean component5() {
        return this.sendByMe;
    }

    public final boolean component6() {
        return this.isLoader;
    }

    public final MessageInfo copy(int i, String text, String formattedTime, long j, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(formattedTime, "formattedTime");
        return new MessageInfo(i, text, formattedTime, j, z, z2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof MessageInfo) {
            MessageInfo messageInfo = (MessageInfo) obj;
            return this.id == messageInfo.id && Intrinsics.areEqual(this.text, messageInfo.text) && Intrinsics.areEqual(this.formattedTime, messageInfo.formattedTime) && this.createAt == messageInfo.createAt && this.sendByMe == messageInfo.sendByMe && this.isLoader == messageInfo.isLoader;
        }
        return false;
    }

    public int hashCode() {
        return (((((((((Integer.hashCode(this.id) * 31) + this.text.hashCode()) * 31) + this.formattedTime.hashCode()) * 31) + Long.hashCode(this.createAt)) * 31) + Boolean.hashCode(this.sendByMe)) * 31) + Boolean.hashCode(this.isLoader);
    }

    public String toString() {
        int i = this.id;
        String str = this.text;
        String str2 = this.formattedTime;
        long j = this.createAt;
        boolean z = this.sendByMe;
        return "MessageInfo(id=" + i + ", text=" + str + ", formattedTime=" + str2 + ", createAt=" + j + ", sendByMe=" + z + ", isLoader=" + this.isLoader + ")";
    }

    public MessageInfo(int i, String text, String formattedTime, long j, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(formattedTime, "formattedTime");
        this.id = i;
        this.text = text;
        this.formattedTime = formattedTime;
        this.createAt = j;
        this.sendByMe = z;
        this.isLoader = z2;
    }

    public /* synthetic */ MessageInfo(int i, String str, String str2, long j, boolean z, boolean z2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 0 : i, (i2 & 2) != 0 ? "" : str, (i2 & 4) != 0 ? "" : str2, (i2 & 8) != 0 ? 0L : j, (i2 & 16) != 0 ? false : z, (i2 & 32) != 0 ? false : z2);
    }

    public final int getId() {
        return this.id;
    }

    public final String getText() {
        return this.text;
    }

    public final String getFormattedTime() {
        return this.formattedTime;
    }

    public final long getCreateAt() {
        return this.createAt;
    }

    public final boolean getSendByMe() {
        return this.sendByMe;
    }

    public final boolean isLoader() {
        return this.isLoader;
    }
}
