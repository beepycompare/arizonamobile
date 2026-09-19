package ru.mrlargha.commonui.elements.donate.presentation.models;

import androidx.media3.extractor.text.ttml.TtmlNode;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: DonatePayPassState.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0082\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\tJ\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0003J&\u0010\u0011\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0012J\u0014\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0016\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010\u0017\u001a\u00020\u0005HÖ\u0081\u0004R)\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u0092\u0002\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u0002¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\tR'\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004\u0092\u0002\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0018"}, d2 = {"Lru/mrlargha/commonui/elements/donate/presentation/models/DonatePayPassStatusDto;", "", TtmlNode.ATTR_ID, "", "status", "", "<init>", "(Ljava/lang/Integer;Ljava/lang/String;)V", "getId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "Lcom/google/gson/annotations/SerializedName;", "value", "getStatus", "()Ljava/lang/String;", "component1", "component2", "copy", "(Ljava/lang/Integer;Ljava/lang/String;)Lru/mrlargha/commonui/elements/donate/presentation/models/DonatePayPassStatusDto;", "equals", "", "other", "hashCode", "toString", "CommonUI"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
final class DonatePayPassStatusDto {
    @SerializedName(TtmlNode.ATTR_ID)
    private final Integer id;
    @SerializedName("status")
    private final String status;

    public DonatePayPassStatusDto() {
        this(null, null, 3, null);
    }

    public static /* synthetic */ DonatePayPassStatusDto copy$default(DonatePayPassStatusDto donatePayPassStatusDto, Integer num, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            num = donatePayPassStatusDto.id;
        }
        if ((i & 2) != 0) {
            str = donatePayPassStatusDto.status;
        }
        return donatePayPassStatusDto.copy(num, str);
    }

    public final Integer component1() {
        return this.id;
    }

    public final String component2() {
        return this.status;
    }

    public final DonatePayPassStatusDto copy(Integer num, String str) {
        return new DonatePayPassStatusDto(num, str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DonatePayPassStatusDto) {
            DonatePayPassStatusDto donatePayPassStatusDto = (DonatePayPassStatusDto) obj;
            return Intrinsics.areEqual(this.id, donatePayPassStatusDto.id) && Intrinsics.areEqual(this.status, donatePayPassStatusDto.status);
        }
        return false;
    }

    public int hashCode() {
        Integer num = this.id;
        int hashCode = (num == null ? 0 : num.hashCode()) * 31;
        String str = this.status;
        return hashCode + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        Integer num = this.id;
        return "DonatePayPassStatusDto(id=" + num + ", status=" + this.status + ")";
    }

    public DonatePayPassStatusDto(Integer num, String str) {
        this.id = num;
        this.status = str;
    }

    public /* synthetic */ DonatePayPassStatusDto(Integer num, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : num, (i & 2) != 0 ? null : str);
    }

    public final Integer getId() {
        return this.id;
    }

    public final String getStatus() {
        return this.status;
    }
}
