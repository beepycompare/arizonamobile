package com.miami.game.feature.notifications;

import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: notificationStateHolder.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B1\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0017\u001a\u00020\tHÆ\u0003J=\u0010\u0018\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010\u0019\u001a\u00020\t2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u0005HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0012¨\u0006\u001e"}, d2 = {"Lcom/miami/game/feature/notifications/NotificationModel;", "", "date", "Ljava/util/Date;", "title", "", "text", "imageUrl", "isViewed", "", "<init>", "(Ljava/util/Date;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V", "getDate", "()Ljava/util/Date;", "getTitle", "()Ljava/lang/String;", "getText", "getImageUrl", "()Z", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "", "toString", "notifications_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class NotificationModel {
    public static final int $stable = 8;
    private final Date date;
    private final String imageUrl;
    private final boolean isViewed;
    private final String text;
    private final String title;

    public static /* synthetic */ NotificationModel copy$default(NotificationModel notificationModel, Date date, String str, String str2, String str3, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            date = notificationModel.date;
        }
        if ((i & 2) != 0) {
            str = notificationModel.title;
        }
        if ((i & 4) != 0) {
            str2 = notificationModel.text;
        }
        if ((i & 8) != 0) {
            str3 = notificationModel.imageUrl;
        }
        if ((i & 16) != 0) {
            z = notificationModel.isViewed;
        }
        boolean z2 = z;
        String str4 = str2;
        return notificationModel.copy(date, str, str4, str3, z2);
    }

    public final Date component1() {
        return this.date;
    }

    public final String component2() {
        return this.title;
    }

    public final String component3() {
        return this.text;
    }

    public final String component4() {
        return this.imageUrl;
    }

    public final boolean component5() {
        return this.isViewed;
    }

    public final NotificationModel copy(Date date, String title, String text, String imageUrl, boolean z) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(imageUrl, "imageUrl");
        return new NotificationModel(date, title, text, imageUrl, z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof NotificationModel) {
            NotificationModel notificationModel = (NotificationModel) obj;
            return Intrinsics.areEqual(this.date, notificationModel.date) && Intrinsics.areEqual(this.title, notificationModel.title) && Intrinsics.areEqual(this.text, notificationModel.text) && Intrinsics.areEqual(this.imageUrl, notificationModel.imageUrl) && this.isViewed == notificationModel.isViewed;
        }
        return false;
    }

    public int hashCode() {
        Date date = this.date;
        return ((((((((date == null ? 0 : date.hashCode()) * 31) + this.title.hashCode()) * 31) + this.text.hashCode()) * 31) + this.imageUrl.hashCode()) * 31) + Boolean.hashCode(this.isViewed);
    }

    public String toString() {
        Date date = this.date;
        String str = this.title;
        String str2 = this.text;
        String str3 = this.imageUrl;
        return "NotificationModel(date=" + date + ", title=" + str + ", text=" + str2 + ", imageUrl=" + str3 + ", isViewed=" + this.isViewed + ")";
    }

    public NotificationModel(Date date, String title, String text, String imageUrl, boolean z) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(imageUrl, "imageUrl");
        this.date = date;
        this.title = title;
        this.text = text;
        this.imageUrl = imageUrl;
        this.isViewed = z;
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
