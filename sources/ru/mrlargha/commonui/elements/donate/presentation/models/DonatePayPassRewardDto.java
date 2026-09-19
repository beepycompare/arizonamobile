package ru.mrlargha.commonui.elements.donate.presentation.models;

import androidx.media3.extractor.text.ttml.TtmlNode;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: DonatePayPassState.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0082\b\u0018\u00002\u00020\u0001B=\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\rJ\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\rJ\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0011\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bHÆ\u0003JD\u0010\u001a\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bHÆ\u0001¢\u0006\u0002\u0010\u001bJ\u0014\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u001f\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010 \u001a\u00020\u0006HÖ\u0081\u0004R)\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u0092\u0002\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0002¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR)\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u0092\u0002\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0004¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\u0011\u0010\rR'\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004\u0092\u0002\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R-\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b8\u0006X\u0087\u0004\u0092\u0002\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006!"}, d2 = {"Lru/mrlargha/commonui/elements/donate/presentation/models/DonatePayPassRewardDto;", "", TtmlNode.ATTR_ID, "", FirebaseAnalytics.Param.LEVEL, "status", "", "prizes", "", "Lru/mrlargha/commonui/elements/donate/presentation/models/DonatePayPassPrizeDto;", "<init>", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/util/List;)V", "getId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "Lcom/google/gson/annotations/SerializedName;", "value", "getLevel", "getStatus", "()Ljava/lang/String;", "getPrizes", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/util/List;)Lru/mrlargha/commonui/elements/donate/presentation/models/DonatePayPassRewardDto;", "equals", "", "other", "hashCode", "toString", "CommonUI"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
final class DonatePayPassRewardDto {
    @SerializedName(TtmlNode.ATTR_ID)
    private final Integer id;
    @SerializedName(FirebaseAnalytics.Param.LEVEL)
    private final Integer level;
    @SerializedName("prizes")
    private final List<DonatePayPassPrizeDto> prizes;
    @SerializedName("status")
    private final String status;

    public DonatePayPassRewardDto() {
        this(null, null, null, null, 15, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ DonatePayPassRewardDto copy$default(DonatePayPassRewardDto donatePayPassRewardDto, Integer num, Integer num2, String str, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            num = donatePayPassRewardDto.id;
        }
        if ((i & 2) != 0) {
            num2 = donatePayPassRewardDto.level;
        }
        if ((i & 4) != 0) {
            str = donatePayPassRewardDto.status;
        }
        if ((i & 8) != 0) {
            list = donatePayPassRewardDto.prizes;
        }
        return donatePayPassRewardDto.copy(num, num2, str, list);
    }

    public final Integer component1() {
        return this.id;
    }

    public final Integer component2() {
        return this.level;
    }

    public final String component3() {
        return this.status;
    }

    public final List<DonatePayPassPrizeDto> component4() {
        return this.prizes;
    }

    public final DonatePayPassRewardDto copy(Integer num, Integer num2, String str, List<DonatePayPassPrizeDto> list) {
        return new DonatePayPassRewardDto(num, num2, str, list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DonatePayPassRewardDto) {
            DonatePayPassRewardDto donatePayPassRewardDto = (DonatePayPassRewardDto) obj;
            return Intrinsics.areEqual(this.id, donatePayPassRewardDto.id) && Intrinsics.areEqual(this.level, donatePayPassRewardDto.level) && Intrinsics.areEqual(this.status, donatePayPassRewardDto.status) && Intrinsics.areEqual(this.prizes, donatePayPassRewardDto.prizes);
        }
        return false;
    }

    public int hashCode() {
        Integer num = this.id;
        int hashCode = (num == null ? 0 : num.hashCode()) * 31;
        Integer num2 = this.level;
        int hashCode2 = (hashCode + (num2 == null ? 0 : num2.hashCode())) * 31;
        String str = this.status;
        int hashCode3 = (hashCode2 + (str == null ? 0 : str.hashCode())) * 31;
        List<DonatePayPassPrizeDto> list = this.prizes;
        return hashCode3 + (list != null ? list.hashCode() : 0);
    }

    public String toString() {
        Integer num = this.id;
        Integer num2 = this.level;
        String str = this.status;
        return "DonatePayPassRewardDto(id=" + num + ", level=" + num2 + ", status=" + str + ", prizes=" + this.prizes + ")";
    }

    public DonatePayPassRewardDto(Integer num, Integer num2, String str, List<DonatePayPassPrizeDto> list) {
        this.id = num;
        this.level = num2;
        this.status = str;
        this.prizes = list;
    }

    public /* synthetic */ DonatePayPassRewardDto(Integer num, Integer num2, String str, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : num, (i & 2) != 0 ? null : num2, (i & 4) != 0 ? null : str, (i & 8) != 0 ? null : list);
    }

    public final Integer getId() {
        return this.id;
    }

    public final Integer getLevel() {
        return this.level;
    }

    public final String getStatus() {
        return this.status;
    }

    public final List<DonatePayPassPrizeDto> getPrizes() {
        return this.prizes;
    }
}
