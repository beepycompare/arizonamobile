package com.arizona.launcher.model.servers;

import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: NotificationHistoryData.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0017\b\u0087\b\u0018\u00002\u00020\u0001B=\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0007\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001c\u001a\u00020\u000bHÆ\u0003JG\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\u000bHÆ\u0001J\u0013\u0010\u001e\u001a\u00020\u000b2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020\u0003HÖ\u0001J\t\u0010!\u001a\u00020\u0007HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0011\u0010\t\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0013R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0016¨\u0006\""}, d2 = {"Lcom/arizona/launcher/model/servers/NotificationHistoryData;", "", "id", "", "date", "Ljava/util/Date;", "title", "", "text", "imageUrl", "isViewed", "", "<init>", "(ILjava/util/Date;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V", "getId", "()I", "getDate", "()Ljava/util/Date;", "getTitle", "()Ljava/lang/String;", "getText", "getImageUrl", "()Z", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "toString", "app_arizonaRelease_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class NotificationHistoryData {
    public static final int $stable = 8;
    private final Date date;
    private final int id;
    private final String imageUrl;
    private final boolean isViewed;
    private final String text;
    private final String title;

    public static /* synthetic */ NotificationHistoryData copy$default(NotificationHistoryData notificationHistoryData, int i, Date date, String str, String str2, String str3, boolean z, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = notificationHistoryData.id;
        }
        if ((i2 & 2) != 0) {
            date = notificationHistoryData.date;
        }
        if ((i2 & 4) != 0) {
            str = notificationHistoryData.title;
        }
        if ((i2 & 8) != 0) {
            str2 = notificationHistoryData.text;
        }
        if ((i2 & 16) != 0) {
            str3 = notificationHistoryData.imageUrl;
        }
        if ((i2 & 32) != 0) {
            z = notificationHistoryData.isViewed;
        }
        String str4 = str3;
        boolean z2 = z;
        return notificationHistoryData.copy(i, date, str, str2, str4, z2);
    }

    public final int component1() {
        return this.id;
    }

    public final Date component2() {
        return this.date;
    }

    public final String component3() {
        return this.title;
    }

    public final String component4() {
        return this.text;
    }

    public final String component5() {
        return this.imageUrl;
    }

    public final boolean component6() {
        return this.isViewed;
    }

    public final NotificationHistoryData copy(int i, Date date, String title, String text, String imageUrl, boolean z) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(imageUrl, "imageUrl");
        return new NotificationHistoryData(i, date, title, text, imageUrl, z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof NotificationHistoryData) {
            NotificationHistoryData notificationHistoryData = (NotificationHistoryData) obj;
            return this.id == notificationHistoryData.id && Intrinsics.areEqual(this.date, notificationHistoryData.date) && Intrinsics.areEqual(this.title, notificationHistoryData.title) && Intrinsics.areEqual(this.text, notificationHistoryData.text) && Intrinsics.areEqual(this.imageUrl, notificationHistoryData.imageUrl) && this.isViewed == notificationHistoryData.isViewed;
        }
        return false;
    }

    public int hashCode() {
        int hashCode = Integer.hashCode(this.id) * 31;
        Date date = this.date;
        return ((((((((hashCode + (date == null ? 0 : date.hashCode())) * 31) + this.title.hashCode()) * 31) + this.text.hashCode()) * 31) + this.imageUrl.hashCode()) * 31) + Boolean.hashCode(this.isViewed);
    }

    public String toString() {
        int i = this.id;
        Date date = this.date;
        String str = this.title;
        String str2 = this.text;
        String str3 = this.imageUrl;
        return "NotificationHistoryData(id=" + i + ", date=" + date + ", title=" + str + ", text=" + str2 + ", imageUrl=" + str3 + ", isViewed=" + this.isViewed + ")";
    }

    public NotificationHistoryData(int i, Date date, String title, String text, String imageUrl, boolean z) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(imageUrl, "imageUrl");
        this.id = i;
        this.date = date;
        this.title = title;
        this.text = text;
        this.imageUrl = imageUrl;
        this.isViewed = z;
    }

    public /* synthetic */ NotificationHistoryData(int i, Date date, String str, String str2, String str3, boolean z, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 0 : i, date, str, str2, str3, (i2 & 32) != 0 ? false : z);
    }

    public final int getId() {
        return this.id;
    }

    public final Date getDate() {
        return this.date;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getText() {
        return this.text;
    }

    public final String getImageUrl() {
        return this.imageUrl;
    }

    public final boolean isViewed() {
        return this.isViewed;
    }
}
