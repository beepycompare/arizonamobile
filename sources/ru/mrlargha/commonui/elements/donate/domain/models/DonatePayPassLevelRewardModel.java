package ru.mrlargha.commonui.elements.donate.domain.models;

import androidx.media3.extractor.text.ttml.TtmlNode;
import com.google.gson.JsonElement;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: DonatePayPassLevelModel.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B=\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0011\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007HÆ\u0003J\u0010\u0010\u001b\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010\u0016JD\u0010\u001c\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nHÆ\u0001¢\u0006\u0002\u0010\u001dJ\u0014\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010!\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010\"\u001a\u00020\bHÖ\u0081\u0004R)\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u0092\u0002\f\b\u0010\u0012\b\b\t\u0012\u0004\b\b(\u0002¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000eR'\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004\u0092\u0002\f\b\u0010\u0012\b\b\t\u0012\u0004\b\b(\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R-\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00078\u0006X\u0087\u0004\u0092\u0002\f\b\u0010\u0012\b\b\t\u0012\u0004\b\b(\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R)\u0010\t\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004\u0092\u0002\f\b\u0010\u0012\b\b\t\u0012\u0004\b\b(\t¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u0015\u0010\u0016¨\u0006#"}, d2 = {"Lru/mrlargha/commonui/elements/donate/domain/models/DonatePayPassLevelRewardModel;", "", TtmlNode.ATTR_ID, "", "img", "Lcom/google/gson/JsonElement;", "description", "", "", "value", "", "<init>", "(Ljava/lang/Integer;Lcom/google/gson/JsonElement;Ljava/util/List;Ljava/lang/Long;)V", "getId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "Lcom/google/gson/annotations/SerializedName;", "getImg", "()Lcom/google/gson/JsonElement;", "getDescription", "()Ljava/util/List;", "getValue", "()Ljava/lang/Long;", "Ljava/lang/Long;", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/Integer;Lcom/google/gson/JsonElement;Ljava/util/List;Ljava/lang/Long;)Lru/mrlargha/commonui/elements/donate/domain/models/DonatePayPassLevelRewardModel;", "equals", "", "other", "hashCode", "toString", "CommonUI"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class DonatePayPassLevelRewardModel {
    @SerializedName("description")
    private final List<String> description;
    @SerializedName(TtmlNode.ATTR_ID)
    private final Integer id;
    @SerializedName("img")
    private final JsonElement img;
    @SerializedName("value")
    private final Long value;

    public DonatePayPassLevelRewardModel() {
        this(null, null, null, null, 15, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ DonatePayPassLevelRewardModel copy$default(DonatePayPassLevelRewardModel donatePayPassLevelRewardModel, Integer num, JsonElement jsonElement, List list, Long l, int i, Object obj) {
        if ((i & 1) != 0) {
            num = donatePayPassLevelRewardModel.id;
        }
        if ((i & 2) != 0) {
            jsonElement = donatePayPassLevelRewardModel.img;
        }
        if ((i & 4) != 0) {
            list = donatePayPassLevelRewardModel.description;
        }
        if ((i & 8) != 0) {
            l = donatePayPassLevelRewardModel.value;
        }
        return donatePayPassLevelRewardModel.copy(num, jsonElement, list, l);
    }

    public final Integer component1() {
        return this.id;
    }

    public final JsonElement component2() {
        return this.img;
    }

    public final List<String> component3() {
        return this.description;
    }

    public final Long component4() {
        return this.value;
    }

    public final DonatePayPassLevelRewardModel copy(Integer num, JsonElement jsonElement, List<String> list, Long l) {
        return new DonatePayPassLevelRewardModel(num, jsonElement, list, l);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DonatePayPassLevelRewardModel) {
            DonatePayPassLevelRewardModel donatePayPassLevelRewardModel = (DonatePayPassLevelRewardModel) obj;
            return Intrinsics.areEqual(this.id, donatePayPassLevelRewardModel.id) && Intrinsics.areEqual(this.img, donatePayPassLevelRewardModel.img) && Intrinsics.areEqual(this.description, donatePayPassLevelRewardModel.description) && Intrinsics.areEqual(this.value, donatePayPassLevelRewardModel.value);
        }
        return false;
    }

    public int hashCode() {
        Integer num = this.id;
        int hashCode = (num == null ? 0 : num.hashCode()) * 31;
        JsonElement jsonElement = this.img;
        int hashCode2 = (hashCode + (jsonElement == null ? 0 : jsonElement.hashCode())) * 31;
        List<String> list = this.description;
        int hashCode3 = (hashCode2 + (list == null ? 0 : list.hashCode())) * 31;
        Long l = this.value;
        return hashCode3 + (l != null ? l.hashCode() : 0);
    }

    public String toString() {
        Integer num = this.id;
        JsonElement jsonElement = this.img;
        List<String> list = this.description;
        return "DonatePayPassLevelRewardModel(id=" + num + ", img=" + jsonElement + ", description=" + list + ", value=" + this.value + ")";
    }

    public DonatePayPassLevelRewardModel(Integer num, JsonElement jsonElement, List<String> list, Long l) {
        this.id = num;
        this.img = jsonElement;
        this.description = list;
        this.value = l;
    }

    public /* synthetic */ DonatePayPassLevelRewardModel(Integer num, JsonElement jsonElement, List list, Long l, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : num, (i & 2) != 0 ? null : jsonElement, (i & 4) != 0 ? null : list, (i & 8) != 0 ? null : l);
    }

    public final Integer getId() {
        return this.id;
    }

    public final JsonElement getImg() {
        return this.img;
    }

    public final List<String> getDescription() {
        return this.description;
    }

    public final Long getValue() {
        return this.value;
    }
}
