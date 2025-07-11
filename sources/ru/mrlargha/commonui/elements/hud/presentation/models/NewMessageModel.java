package ru.mrlargha.commonui.elements.hud.presentation.models;

import com.google.firebase.messaging.Constants;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: NewMessageModel.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0003¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J;\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u0006HÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0007\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0016\u0010\b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\f¨\u0006\u001d"}, d2 = {"Lru/mrlargha/commonui/elements/hud/presentation/models/NewMessageModel;", "", "title", "", "contactName", "userId", "", "messageId", "imageUrl", "<init>", "(Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;)V", "getTitle", "()Ljava/lang/String;", "getContactName", "getUserId", "()I", "getMessageId", "getImageUrl", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "CommonUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class NewMessageModel {
    private final String contactName;
    @SerializedName("image")
    private final String imageUrl;
    @SerializedName(Constants.MessagePayloadKeys.MSGID_SERVER)
    private final int messageId;
    private final String title;
    @SerializedName("user_id")
    private final int userId;

    public static /* synthetic */ NewMessageModel copy$default(NewMessageModel newMessageModel, String str, String str2, int i, int i2, String str3, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = newMessageModel.title;
        }
        if ((i3 & 2) != 0) {
            str2 = newMessageModel.contactName;
        }
        if ((i3 & 4) != 0) {
            i = newMessageModel.userId;
        }
        if ((i3 & 8) != 0) {
            i2 = newMessageModel.messageId;
        }
        if ((i3 & 16) != 0) {
            str3 = newMessageModel.imageUrl;
        }
        String str4 = str3;
        int i4 = i;
        return newMessageModel.copy(str, str2, i4, i2, str4);
    }

    public final String component1() {
        return this.title;
    }

    public final String component2() {
        return this.contactName;
    }

    public final int component3() {
        return this.userId;
    }

    public final int component4() {
        return this.messageId;
    }

    public final String component5() {
        return this.imageUrl;
    }

    public final NewMessageModel copy(String title, String contactName, int i, int i2, String imageUrl) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(contactName, "contactName");
        Intrinsics.checkNotNullParameter(imageUrl, "imageUrl");
        return new NewMessageModel(title, contactName, i, i2, imageUrl);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof NewMessageModel) {
            NewMessageModel newMessageModel = (NewMessageModel) obj;
            return Intrinsics.areEqual(this.title, newMessageModel.title) && Intrinsics.areEqual(this.contactName, newMessageModel.contactName) && this.userId == newMessageModel.userId && this.messageId == newMessageModel.messageId && Intrinsics.areEqual(this.imageUrl, newMessageModel.imageUrl);
        }
        return false;
    }

    public int hashCode() {
        return (((((((this.title.hashCode() * 31) + this.contactName.hashCode()) * 31) + Integer.hashCode(this.userId)) * 31) + Integer.hashCode(this.messageId)) * 31) + this.imageUrl.hashCode();
    }

    public String toString() {
        String str = this.title;
        String str2 = this.contactName;
        int i = this.userId;
        int i2 = this.messageId;
        return "NewMessageModel(title=" + str + ", contactName=" + str2 + ", userId=" + i + ", messageId=" + i2 + ", imageUrl=" + this.imageUrl + ")";
    }

    public NewMessageModel(String title, String contactName, int i, int i2, String imageUrl) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(contactName, "contactName");
        Intrinsics.checkNotNullParameter(imageUrl, "imageUrl");
        this.title = title;
        this.contactName = contactName;
        this.userId = i;
        this.messageId = i2;
        this.imageUrl = imageUrl;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getContactName() {
        return this.contactName;
    }

    public final int getUserId() {
        return this.userId;
    }

    public final int getMessageId() {
        return this.messageId;
    }

    public final String getImageUrl() {
        return this.imageUrl;
    }
}
