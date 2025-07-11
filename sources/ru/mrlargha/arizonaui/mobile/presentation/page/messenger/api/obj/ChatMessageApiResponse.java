package ru.mrlargha.arizonaui.mobile.presentation.page.messenger.api.obj;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import ru.mrlargha.arizonaui.mobile.domain.obj.MessageInfo;
import ru.mrlargha.commonui.utils.DateConverter;
import ru.mrlargha.commonui.utils.StringKt;
/* compiled from: ContactApiResponse.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u0006\u0010\u0014\u001a\u00020\u0015J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0019\u001a\u00020\tHÆ\u0003J1\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010\u001b\u001a\u00020\t2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001e\u001a\u00020\u0005HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0016\u0010\b\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u001f"}, d2 = {"Lru/mrlargha/arizonaui/mobile/presentation/page/messenger/api/obj/ChatMessageApiResponse;", "", "id", "", "text", "", "createdAtTimestamp", "", "sentByMe", "", "<init>", "(ILjava/lang/String;JZ)V", "getId", "()I", "getText", "()Ljava/lang/String;", "getCreatedAtTimestamp", "()J", "getSentByMe", "()Z", "toModel", "Lru/mrlargha/arizonaui/mobile/domain/obj/MessageInfo;", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "toString", "ArizonaUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ChatMessageApiResponse {
    @SerializedName("createdAtTimestamp")
    private final long createdAtTimestamp;
    @SerializedName("id")
    private final int id;
    @SerializedName("sentByMe")
    private final boolean sentByMe;
    @SerializedName("text")
    private final String text;

    public ChatMessageApiResponse() {
        this(0, null, 0L, false, 15, null);
    }

    public static /* synthetic */ ChatMessageApiResponse copy$default(ChatMessageApiResponse chatMessageApiResponse, int i, String str, long j, boolean z, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = chatMessageApiResponse.id;
        }
        if ((i2 & 2) != 0) {
            str = chatMessageApiResponse.text;
        }
        if ((i2 & 4) != 0) {
            j = chatMessageApiResponse.createdAtTimestamp;
        }
        if ((i2 & 8) != 0) {
            z = chatMessageApiResponse.sentByMe;
        }
        boolean z2 = z;
        return chatMessageApiResponse.copy(i, str, j, z2);
    }

    public final int component1() {
        return this.id;
    }

    public final String component2() {
        return this.text;
    }

    public final long component3() {
        return this.createdAtTimestamp;
    }

    public final boolean component4() {
        return this.sentByMe;
    }

    public final ChatMessageApiResponse copy(int i, String text, long j, boolean z) {
        Intrinsics.checkNotNullParameter(text, "text");
        return new ChatMessageApiResponse(i, text, j, z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ChatMessageApiResponse) {
            ChatMessageApiResponse chatMessageApiResponse = (ChatMessageApiResponse) obj;
            return this.id == chatMessageApiResponse.id && Intrinsics.areEqual(this.text, chatMessageApiResponse.text) && this.createdAtTimestamp == chatMessageApiResponse.createdAtTimestamp && this.sentByMe == chatMessageApiResponse.sentByMe;
        }
        return false;
    }

    public int hashCode() {
        return (((((Integer.hashCode(this.id) * 31) + this.text.hashCode()) * 31) + Long.hashCode(this.createdAtTimestamp)) * 31) + Boolean.hashCode(this.sentByMe);
    }

    public String toString() {
        int i = this.id;
        String str = this.text;
        long j = this.createdAtTimestamp;
        return "ChatMessageApiResponse(id=" + i + ", text=" + str + ", createdAtTimestamp=" + j + ", sentByMe=" + this.sentByMe + ")";
    }

    public ChatMessageApiResponse(int i, String text, long j, boolean z) {
        Intrinsics.checkNotNullParameter(text, "text");
        this.id = i;
        this.text = text;
        this.createdAtTimestamp = j;
        this.sentByMe = z;
    }

    public final int getId() {
        return this.id;
    }

    public /* synthetic */ ChatMessageApiResponse(int i, String str, long j, boolean z, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? -1 : i, (i2 & 2) != 0 ? "" : str, (i2 & 4) != 0 ? 0L : j, (i2 & 8) != 0 ? false : z);
    }

    public final String getText() {
        return this.text;
    }

    public final long getCreatedAtTimestamp() {
        return this.createdAtTimestamp;
    }

    public final boolean getSentByMe() {
        return this.sentByMe;
    }

    public final MessageInfo toModel() {
        return new MessageInfo(this.id, StringKt.unicodeFormatToEmoji(this.text), DateConverter.Companion.formatTimestamp(this.createdAtTimestamp, true), this.createdAtTimestamp, this.sentByMe, true);
    }
}
