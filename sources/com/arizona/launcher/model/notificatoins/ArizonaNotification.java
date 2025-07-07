package com.arizona.launcher.model.notificatoins;

import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: ArizonaNotification.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B3\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0017\u001a\u00020\tHÆ\u0003J=\u0010\u0018\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010\u0019\u001a\u00020\t2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u0005HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0012¨\u0006\u001e"}, d2 = {"Lcom/arizona/launcher/model/notificatoins/ArizonaNotification;", "", "date", "Ljava/util/Date;", "title", "", "text", "imageUrl", "isViewed", "", "<init>", "(Ljava/util/Date;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V", "getDate", "()Ljava/util/Date;", "getTitle", "()Ljava/lang/String;", "getText", "getImageUrl", "()Z", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "", "toString", "app_arizonaRelease_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ArizonaNotification {
    public static final int $stable = 8;
    private final Date date;
    private final String imageUrl;
    private final boolean isViewed;
    private final String text;
    private final String title;

    public static /* synthetic */ ArizonaNotification copy$default(ArizonaNotification arizonaNotification, Date date, String str, String str2, String str3, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            date = arizonaNotification.date;
        }
        if ((i & 2) != 0) {
            str = arizonaNotification.title;
        }
        if ((i & 4) != 0) {
            str2 = arizonaNotification.text;
        }
        if ((i & 8) != 0) {
            str3 = arizonaNotification.imageUrl;
        }
        if ((i & 16) != 0) {
            z = arizonaNotification.isViewed;
        }
        boolean z2 = z;
        String str4 = str2;
        return arizonaNotification.copy(date, str, str4, str3, z2);
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

    public final ArizonaNotification copy(Date date, String title, String text, String imageUrl, boolean z) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(imageUrl, "imageUrl");
        return new ArizonaNotification(date, title, text, imageUrl, z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ArizonaNotification) {
            ArizonaNotification arizonaNotification = (ArizonaNotification) obj;
            return Intrinsics.areEqual(this.date, arizonaNotification.date) && Intrinsics.areEqual(this.title, arizonaNotification.title) && Intrinsics.areEqual(this.text, arizonaNotification.text) && Intrinsics.areEqual(this.imageUrl, arizonaNotification.imageUrl) && this.isViewed == arizonaNotification.isViewed;
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
        return "ArizonaNotification(date=" + date + ", title=" + str + ", text=" + str2 + ", imageUrl=" + str3 + ", isViewed=" + this.isViewed + ")";
    }

    public ArizonaNotification(Date date, String title, String text, String imageUrl, boolean z) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(imageUrl, "imageUrl");
        this.date = date;
        this.title = title;
        this.text = text;
        this.imageUrl = imageUrl;
        this.isViewed = z;
    }

    public /* synthetic */ ArizonaNotification(Date date, String str, String str2, String str3, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(date, str, str2, str3, (i & 16) != 0 ? false : z);
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
