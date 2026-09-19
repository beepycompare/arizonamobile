package ru.mrlargha.commonui.elements.donate.presentation.models;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
/* compiled from: DonatePayPassState.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u001b\b\u0086\b\u0018\u00002\u00020\u0001B;\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\tHÆ\u0003J\t\u0010 \u001a\u00020\u000bHÆ\u0003JE\u0010!\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000bHÆ\u0001J\u0014\u0010\"\u001a\u00020\u000b2\b\u0010#\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010$\u001a\u00020\tHÖ\u0081\u0004J\n\u0010%\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000fR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0016R\u0011\u0010\u0017\u001a\u00020\u000b8F¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0016R\u0011\u0010\u0019\u001a\u00020\u000b8F¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u0016¨\u0006&"}, d2 = {"Lru/mrlargha/commonui/elements/donate/presentation/models/DonatePayPassPrize;", "", "image", "", "count", "", "title", "description", "imageId", "", "isGif", "", "<init>", "(Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;IZ)V", "getImage", "()Ljava/lang/String;", "getCount", "()J", "getTitle", "getDescription", "getImageId", "()I", "()Z", "canLoadHttpsImage", "getCanLoadHttpsImage", "canLoadCatalogImage", "getCanLoadCatalogImage", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "toString", "CommonUI"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class DonatePayPassPrize {
    private final long count;
    private final String description;
    private final String image;
    private final int imageId;
    private final boolean isGif;
    private final String title;

    public static /* synthetic */ DonatePayPassPrize copy$default(DonatePayPassPrize donatePayPassPrize, String str, long j, String str2, String str3, int i, boolean z, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = donatePayPassPrize.image;
        }
        if ((i2 & 2) != 0) {
            j = donatePayPassPrize.count;
        }
        if ((i2 & 4) != 0) {
            str2 = donatePayPassPrize.title;
        }
        if ((i2 & 8) != 0) {
            str3 = donatePayPassPrize.description;
        }
        if ((i2 & 16) != 0) {
            i = donatePayPassPrize.imageId;
        }
        if ((i2 & 32) != 0) {
            z = donatePayPassPrize.isGif;
        }
        return donatePayPassPrize.copy(str, j, str2, str3, i, z);
    }

    public final String component1() {
        return this.image;
    }

    public final long component2() {
        return this.count;
    }

    public final String component3() {
        return this.title;
    }

    public final String component4() {
        return this.description;
    }

    public final int component5() {
        return this.imageId;
    }

    public final boolean component6() {
        return this.isGif;
    }

    public final DonatePayPassPrize copy(String image, long j, String title, String description, int i, boolean z) {
        Intrinsics.checkNotNullParameter(image, "image");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(description, "description");
        return new DonatePayPassPrize(image, j, title, description, i, z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DonatePayPassPrize) {
            DonatePayPassPrize donatePayPassPrize = (DonatePayPassPrize) obj;
            return Intrinsics.areEqual(this.image, donatePayPassPrize.image) && this.count == donatePayPassPrize.count && Intrinsics.areEqual(this.title, donatePayPassPrize.title) && Intrinsics.areEqual(this.description, donatePayPassPrize.description) && this.imageId == donatePayPassPrize.imageId && this.isGif == donatePayPassPrize.isGif;
        }
        return false;
    }

    public int hashCode() {
        return (((((((((this.image.hashCode() * 31) + Long.hashCode(this.count)) * 31) + this.title.hashCode()) * 31) + this.description.hashCode()) * 31) + Integer.hashCode(this.imageId)) * 31) + Boolean.hashCode(this.isGif);
    }

    public String toString() {
        String str = this.image;
        long j = this.count;
        String str2 = this.title;
        String str3 = this.description;
        int i = this.imageId;
        return "DonatePayPassPrize(image=" + str + ", count=" + j + ", title=" + str2 + ", description=" + str3 + ", imageId=" + i + ", isGif=" + this.isGif + ")";
    }

    public DonatePayPassPrize(String image, long j, String title, String description, int i, boolean z) {
        Intrinsics.checkNotNullParameter(image, "image");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(description, "description");
        this.image = image;
        this.count = j;
        this.title = title;
        this.description = description;
        this.imageId = i;
        this.isGif = z;
    }

    public /* synthetic */ DonatePayPassPrize(String str, long j, String str2, String str3, int i, boolean z, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, j, str2, str3, (i2 & 16) != 0 ? -1 : i, (i2 & 32) != 0 ? false : z);
    }

    public final String getImage() {
        return this.image;
    }

    public final long getCount() {
        return this.count;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getDescription() {
        return this.description;
    }

    public final int getImageId() {
        return this.imageId;
    }

    public final boolean isGif() {
        return this.isGif;
    }

    public final boolean getCanLoadHttpsImage() {
        return StringsKt.startsWith$default(this.image, "https://", false, 2, (Object) null) || StringsKt.startsWith$default(this.image, "http://", false, 2, (Object) null);
    }

    public final boolean getCanLoadCatalogImage() {
        return this.imageId >= 0;
    }
}
