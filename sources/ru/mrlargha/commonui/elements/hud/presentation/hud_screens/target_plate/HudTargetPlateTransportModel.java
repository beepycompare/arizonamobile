package ru.mrlargha.commonui.elements.hud.presentation.hud_screens.target_plate;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: HudTargetPlateTransportModeItem.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001:\u000201Be\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u000e\u001a\u00020\b¢\u0006\u0004\b\u000f\u0010\u0010J\u0011\u0010\"\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010#\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003HÆ\u0003J\t\u0010$\u001a\u00020\bHÆ\u0003J\t\u0010%\u001a\u00020\bHÆ\u0003J\t\u0010&\u001a\u00020\u000bHÆ\u0003J\u000f\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\t\u0010)\u001a\u00020\bHÆ\u0003Jq\u0010*\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\u000b2\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u000e\u001a\u00020\bHÆ\u0001J\u0014\u0010+\u001a\u00020,2\b\u0010-\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010.\u001a\u00020\bHÖ\u0081\u0004J\n\u0010/\u001a\u00020\u000bHÖ\u0081\u0004R-\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u0092\u0002\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0002¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R-\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00038\u0006X\u0087\u0004\u0092\u0002\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0012R%\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004\u0092\u0002\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0018¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R%\u0010\t\u001a\u00020\b8\u0006X\u0087\u0004\u0092\u0002\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u001a¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0017R%\u0010\n\u001a\u00020\u000b8\u0006X\u0087\u0004\u0092\u0002\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u001d¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR+\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\u0006X\u0087\u0004\u0092\u0002\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\f¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0012R\u0013\u0010\r\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0011\u0010\u000e\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0017¨\u00062"}, d2 = {"Lru/mrlargha/commonui/elements/hud/presentation/hud_screens/target_plate/HudTargetPlateTransportModel;", "", "additionalTags", "", "Lru/mrlargha/commonui/elements/hud/presentation/hud_screens/target_plate/HudTargetPlateTransportModel$Tag;", "details", "Lru/mrlargha/commonui/elements/hud/presentation/hud_screens/target_plate/HudTargetPlateTransportModel$Detail;", "hp", "", "maxHp", "name", "", "tags", "mainTag", "userNumber", "<init>", "(Ljava/util/List;Ljava/util/List;IILjava/lang/String;Ljava/util/List;Lru/mrlargha/commonui/elements/hud/presentation/hud_screens/target_plate/HudTargetPlateTransportModel$Tag;I)V", "getAdditionalTags", "()Ljava/util/List;", "Lcom/google/gson/annotations/SerializedName;", "value", "getDetails", "getHp", "()I", "health", "getMaxHp", "maxHealth", "getName", "()Ljava/lang/String;", "userName", "getTags", "getMainTag", "()Lru/mrlargha/commonui/elements/hud/presentation/hud_screens/target_plate/HudTargetPlateTransportModel$Tag;", "getUserNumber", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "", "other", "hashCode", "toString", "Tag", "Detail", "CommonUI"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class HudTargetPlateTransportModel {
    @SerializedName("additionalTags")
    private final List<Tag> additionalTags;
    @SerializedName("details")
    private final List<Detail> details;
    @SerializedName("health")
    private final int hp;
    private final Tag mainTag;
    @SerializedName("maxHealth")
    private final int maxHp;
    @SerializedName("userName")
    private final String name;
    @SerializedName("tags")
    private final List<Tag> tags;
    private final int userNumber;

    public static /* synthetic */ HudTargetPlateTransportModel copy$default(HudTargetPlateTransportModel hudTargetPlateTransportModel, List list, List list2, int i, int i2, String str, List list3, Tag tag, int i3, int i4, Object obj) {
        List<Tag> list4 = list;
        if ((i4 & 1) != 0) {
            list4 = hudTargetPlateTransportModel.additionalTags;
        }
        List<Detail> list5 = list2;
        if ((i4 & 2) != 0) {
            list5 = hudTargetPlateTransportModel.details;
        }
        if ((i4 & 4) != 0) {
            i = hudTargetPlateTransportModel.hp;
        }
        if ((i4 & 8) != 0) {
            i2 = hudTargetPlateTransportModel.maxHp;
        }
        if ((i4 & 16) != 0) {
            str = hudTargetPlateTransportModel.name;
        }
        List<Tag> list6 = list3;
        if ((i4 & 32) != 0) {
            list6 = hudTargetPlateTransportModel.tags;
        }
        if ((i4 & 64) != 0) {
            tag = hudTargetPlateTransportModel.mainTag;
        }
        if ((i4 & 128) != 0) {
            i3 = hudTargetPlateTransportModel.userNumber;
        }
        Tag tag2 = tag;
        int i5 = i3;
        String str2 = str;
        List list7 = list6;
        return hudTargetPlateTransportModel.copy(list4, list5, i, i2, str2, list7, tag2, i5);
    }

    public final List<Tag> component1() {
        return this.additionalTags;
    }

    public final List<Detail> component2() {
        return this.details;
    }

    public final int component3() {
        return this.hp;
    }

    public final int component4() {
        return this.maxHp;
    }

    public final String component5() {
        return this.name;
    }

    public final List<Tag> component6() {
        return this.tags;
    }

    public final Tag component7() {
        return this.mainTag;
    }

    public final int component8() {
        return this.userNumber;
    }

    public final HudTargetPlateTransportModel copy(List<Tag> list, List<Detail> list2, int i, int i2, String name, List<Tag> tags, Tag tag, int i3) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(tags, "tags");
        return new HudTargetPlateTransportModel(list, list2, i, i2, name, tags, tag, i3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof HudTargetPlateTransportModel) {
            HudTargetPlateTransportModel hudTargetPlateTransportModel = (HudTargetPlateTransportModel) obj;
            return Intrinsics.areEqual(this.additionalTags, hudTargetPlateTransportModel.additionalTags) && Intrinsics.areEqual(this.details, hudTargetPlateTransportModel.details) && this.hp == hudTargetPlateTransportModel.hp && this.maxHp == hudTargetPlateTransportModel.maxHp && Intrinsics.areEqual(this.name, hudTargetPlateTransportModel.name) && Intrinsics.areEqual(this.tags, hudTargetPlateTransportModel.tags) && Intrinsics.areEqual(this.mainTag, hudTargetPlateTransportModel.mainTag) && this.userNumber == hudTargetPlateTransportModel.userNumber;
        }
        return false;
    }

    public int hashCode() {
        List<Tag> list = this.additionalTags;
        int hashCode = (list == null ? 0 : list.hashCode()) * 31;
        List<Detail> list2 = this.details;
        int hashCode2 = (((((((((hashCode + (list2 == null ? 0 : list2.hashCode())) * 31) + Integer.hashCode(this.hp)) * 31) + Integer.hashCode(this.maxHp)) * 31) + this.name.hashCode()) * 31) + this.tags.hashCode()) * 31;
        Tag tag = this.mainTag;
        return ((hashCode2 + (tag != null ? tag.hashCode() : 0)) * 31) + Integer.hashCode(this.userNumber);
    }

    public String toString() {
        List<Tag> list = this.additionalTags;
        List<Detail> list2 = this.details;
        int i = this.hp;
        int i2 = this.maxHp;
        String str = this.name;
        List<Tag> list3 = this.tags;
        Tag tag = this.mainTag;
        return "HudTargetPlateTransportModel(additionalTags=" + list + ", details=" + list2 + ", hp=" + i + ", maxHp=" + i2 + ", name=" + str + ", tags=" + list3 + ", mainTag=" + tag + ", userNumber=" + this.userNumber + ")";
    }

    public HudTargetPlateTransportModel(List<Tag> list, List<Detail> list2, int i, int i2, String name, List<Tag> tags, Tag tag, int i3) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(tags, "tags");
        this.additionalTags = list;
        this.details = list2;
        this.hp = i;
        this.maxHp = i2;
        this.name = name;
        this.tags = tags;
        this.mainTag = tag;
        this.userNumber = i3;
    }

    public /* synthetic */ HudTargetPlateTransportModel(List list, List list2, int i, int i2, String str, List list3, Tag tag, int i3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this((i4 & 1) != 0 ? null : list, (i4 & 2) != 0 ? null : list2, i, i2, str, list3, (i4 & 64) != 0 ? null : tag, i3);
    }

    public final List<Tag> getAdditionalTags() {
        return this.additionalTags;
    }

    public final List<Detail> getDetails() {
        return this.details;
    }

    public final int getHp() {
        return this.hp;
    }

    public final int getMaxHp() {
        return this.maxHp;
    }

    public final String getName() {
        return this.name;
    }

    public final List<Tag> getTags() {
        return this.tags;
    }

    public final Tag getMainTag() {
        return this.mainTag;
    }

    public final int getUserNumber() {
        return this.userNumber;
    }

    /* compiled from: HudTargetPlateTransportModeItem.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0004HÆ\u0003J#\u0010\u000f\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0004HÆ\u0001J\u0014\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0013\u001a\u00020\u0014HÖ\u0081\u0004J\n\u0010\u0015\u001a\u00020\u0004HÖ\u0081\u0004R+\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\u0006X\u0087\u0004\u0092\u0002\f\b\n\u0012\b\b\u0005\u0012\u0004\b\b(\u0002¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR%\u0010\u0005\u001a\u00020\u00048\u0006X\u0087\u0004\u0092\u0002\f\b\n\u0012\b\b\u0005\u0012\u0004\b\b(\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0016"}, d2 = {"Lru/mrlargha/commonui/elements/hud/presentation/hud_screens/target_plate/HudTargetPlateTransportModel$Tag;", "", "colors", "", "", "value", "<init>", "(Ljava/util/List;Ljava/lang/String;)V", "getColors", "()Ljava/util/List;", "Lcom/google/gson/annotations/SerializedName;", "getValue", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "CommonUI"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class Tag {
        @SerializedName("colors")
        private final List<String> colors;
        @SerializedName("value")
        private final String value;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Tag copy$default(Tag tag, List list, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                list = tag.colors;
            }
            if ((i & 2) != 0) {
                str = tag.value;
            }
            return tag.copy(list, str);
        }

        public final List<String> component1() {
            return this.colors;
        }

        public final String component2() {
            return this.value;
        }

        public final Tag copy(List<String> colors, String value) {
            Intrinsics.checkNotNullParameter(colors, "colors");
            Intrinsics.checkNotNullParameter(value, "value");
            return new Tag(colors, value);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Tag) {
                Tag tag = (Tag) obj;
                return Intrinsics.areEqual(this.colors, tag.colors) && Intrinsics.areEqual(this.value, tag.value);
            }
            return false;
        }

        public int hashCode() {
            return (this.colors.hashCode() * 31) + this.value.hashCode();
        }

        public String toString() {
            List<String> list = this.colors;
            return "Tag(colors=" + list + ", value=" + this.value + ")";
        }

        public Tag(List<String> colors, String value) {
            Intrinsics.checkNotNullParameter(colors, "colors");
            Intrinsics.checkNotNullParameter(value, "value");
            this.colors = colors;
            this.value = value;
        }

        public final List<String> getColors() {
            return this.colors;
        }

        public final String getValue() {
            return this.value;
        }
    }

    /* compiled from: HudTargetPlateTransportModeItem.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0011\u001a\u00020\u0012HÖ\u0081\u0004J\n\u0010\u0013\u001a\u00020\u0003HÖ\u0081\u0004R%\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u0092\u0002\f\b\t\u0012\b\b\u0004\u0012\u0004\b\b(\u0002¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR%\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004\u0092\u0002\f\b\t\u0012\b\b\u0004\u0012\u0004\b\b(\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u0014"}, d2 = {"Lru/mrlargha/commonui/elements/hud/presentation/hud_screens/target_plate/HudTargetPlateTransportModel$Detail;", "", "title", "", "value", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getTitle", "()Ljava/lang/String;", "Lcom/google/gson/annotations/SerializedName;", "getValue", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "CommonUI"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class Detail {
        @SerializedName("title")
        private final String title;
        @SerializedName("value")
        private final String value;

        public Detail() {
            this(null, null, 3, null);
        }

        public static /* synthetic */ Detail copy$default(Detail detail, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = detail.title;
            }
            if ((i & 2) != 0) {
                str2 = detail.value;
            }
            return detail.copy(str, str2);
        }

        public final String component1() {
            return this.title;
        }

        public final String component2() {
            return this.value;
        }

        public final Detail copy(String title, String value) {
            Intrinsics.checkNotNullParameter(title, "title");
            Intrinsics.checkNotNullParameter(value, "value");
            return new Detail(title, value);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Detail) {
                Detail detail = (Detail) obj;
                return Intrinsics.areEqual(this.title, detail.title) && Intrinsics.areEqual(this.value, detail.value);
            }
            return false;
        }

        public int hashCode() {
            return (this.title.hashCode() * 31) + this.value.hashCode();
        }

        public String toString() {
            String str = this.title;
            return "Detail(title=" + str + ", value=" + this.value + ")";
        }

        public Detail(String title, String value) {
            Intrinsics.checkNotNullParameter(title, "title");
            Intrinsics.checkNotNullParameter(value, "value");
            this.title = title;
            this.value = value;
        }

        public /* synthetic */ Detail(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2);
        }

        public final String getTitle() {
            return this.title;
        }

        public final String getValue() {
            return this.value;
        }
    }
}
