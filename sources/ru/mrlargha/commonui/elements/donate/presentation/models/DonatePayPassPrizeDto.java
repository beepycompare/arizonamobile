package ru.mrlargha.commonui.elements.donate.presentation.models;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: DonatePayPassState.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00020\u0001B7\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\b\u0010\tJ\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u000fJ\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J>\u0010\u0017\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u0018J\u0014\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u001c\u001a\u00020\u001dHÖ\u0081\u0004J\n\u0010\u001e\u001a\u00020\u0003HÖ\u0081\u0004R'\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u0092\u0002\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0002¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR)\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004\u0092\u0002\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0004¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000fR'\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u0092\u0002\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000bR'\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u0092\u0002\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000b¨\u0006\u001f"}, d2 = {"Lru/mrlargha/commonui/elements/donate/presentation/models/DonatePayPassPrizeDto;", "", "image", "", "count", "", "title", "description", "<init>", "(Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;)V", "getImage", "()Ljava/lang/String;", "Lcom/google/gson/annotations/SerializedName;", "value", "getCount", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getTitle", "getDescription", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;)Lru/mrlargha/commonui/elements/donate/presentation/models/DonatePayPassPrizeDto;", "equals", "", "other", "hashCode", "", "toString", "CommonUI"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
final class DonatePayPassPrizeDto {
    @SerializedName("count")
    private final Long count;
    @SerializedName("description")
    private final String description;
    @SerializedName("image")
    private final String image;
    @SerializedName("title")
    private final String title;

    public DonatePayPassPrizeDto() {
        this(null, null, null, null, 15, null);
    }

    public static /* synthetic */ DonatePayPassPrizeDto copy$default(DonatePayPassPrizeDto donatePayPassPrizeDto, String str, Long l, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = donatePayPassPrizeDto.image;
        }
        if ((i & 2) != 0) {
            l = donatePayPassPrizeDto.count;
        }
        if ((i & 4) != 0) {
            str2 = donatePayPassPrizeDto.title;
        }
        if ((i & 8) != 0) {
            str3 = donatePayPassPrizeDto.description;
        }
        return donatePayPassPrizeDto.copy(str, l, str2, str3);
    }

    public final String component1() {
        return this.image;
    }

    public final Long component2() {
        return this.count;
    }

    public final String component3() {
        return this.title;
    }

    public final String component4() {
        return this.description;
    }

    public final DonatePayPassPrizeDto copy(String str, Long l, String str2, String str3) {
        return new DonatePayPassPrizeDto(str, l, str2, str3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DonatePayPassPrizeDto) {
            DonatePayPassPrizeDto donatePayPassPrizeDto = (DonatePayPassPrizeDto) obj;
            return Intrinsics.areEqual(this.image, donatePayPassPrizeDto.image) && Intrinsics.areEqual(this.count, donatePayPassPrizeDto.count) && Intrinsics.areEqual(this.title, donatePayPassPrizeDto.title) && Intrinsics.areEqual(this.description, donatePayPassPrizeDto.description);
        }
        return false;
    }

    public int hashCode() {
        String str = this.image;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        Long l = this.count;
        int hashCode2 = (hashCode + (l == null ? 0 : l.hashCode())) * 31;
        String str2 = this.title;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.description;
        return hashCode3 + (str3 != null ? str3.hashCode() : 0);
    }

    public String toString() {
        String str = this.image;
        Long l = this.count;
        String str2 = this.title;
        return "DonatePayPassPrizeDto(image=" + str + ", count=" + l + ", title=" + str2 + ", description=" + this.description + ")";
    }

    public DonatePayPassPrizeDto(String str, Long l, String str2, String str3) {
        this.image = str;
        this.count = l;
        this.title = str2;
        this.description = str3;
    }

    public /* synthetic */ DonatePayPassPrizeDto(String str, Long l, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : l, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? null : str3);
    }

    public final String getImage() {
        return this.image;
    }

    public final Long getCount() {
        return this.count;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getDescription() {
        return this.description;
    }
}
