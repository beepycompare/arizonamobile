package ru.mrlargha.event.data;

import androidx.media3.extractor.text.ttml.TtmlNode;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: QuestData.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001Be\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u0005\u0012\u0006\u0010\u000e\u001a\u00020\u0005\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0011\u0010\u0012J\t\u0010&\u001a\u00020\u0003HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010(\u001a\u00020\u0005HÆ\u0003J\t\u0010)\u001a\u00020\u0005HÆ\u0003J\u000f\u0010*\u001a\b\u0012\u0004\u0012\u00020\n0\tHÆ\u0003J\t\u0010+\u001a\u00020\fHÆ\u0003J\t\u0010,\u001a\u00020\u0005HÆ\u0003J\t\u0010-\u001a\u00020\u0005HÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\u0005HÆ\u0003Jy\u00100\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u00052\b\b\u0002\u0010\u000e\u001a\u00020\u00052\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0014\u00101\u001a\u0002022\b\u00103\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u00104\u001a\u00020\u0003HÖ\u0081\u0004J\n\u00105\u001a\u00020\u0005HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016R\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0016R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR%\u0010\r\u001a\u00020\u00058\u0006X\u0087\u0004\u0092\u0002\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b( ¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0016R\u0011\u0010\u000e\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0016R'\u0010\u000f\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004\u0092\u0002\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b(#¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0016R'\u0010\u0010\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004\u0092\u0002\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b(%¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0016¨\u00066"}, d2 = {"Lru/mrlargha/event/data/QuestData;", "", TtmlNode.ATTR_ID, "", "type", "", "name", "description", "items", "", "Lru/mrlargha/event/data/EasterItem;", "progress", "Lru/mrlargha/event/data/CountedItem;", "buttonType", "image", "error", "timer", "<init>", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Lru/mrlargha/event/data/CountedItem;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getId", "()I", "getType", "()Ljava/lang/String;", "getName", "getDescription", "getItems", "()Ljava/util/List;", "getProgress", "()Lru/mrlargha/event/data/CountedItem;", "getButtonType", "Lcom/google/gson/annotations/SerializedName;", "value", "button_type", "getImage", "getError", "error_text", "getTimer", "available_after", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "copy", "equals", "", "other", "hashCode", "toString", "event"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class QuestData {
    @SerializedName("button_type")
    private final String buttonType;
    private final String description;
    @SerializedName("error_text")
    private final String error;
    private final int id;
    private final String image;
    private final List<EasterItem> items;
    private final String name;
    private final CountedItem progress;
    @SerializedName("available_after")
    private final String timer;
    private final String type;

    public static /* synthetic */ QuestData copy$default(QuestData questData, int i, String str, String str2, String str3, List list, CountedItem countedItem, String str4, String str5, String str6, String str7, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = questData.id;
        }
        if ((i2 & 2) != 0) {
            str = questData.type;
        }
        if ((i2 & 4) != 0) {
            str2 = questData.name;
        }
        if ((i2 & 8) != 0) {
            str3 = questData.description;
        }
        List<EasterItem> list2 = list;
        if ((i2 & 16) != 0) {
            list2 = questData.items;
        }
        if ((i2 & 32) != 0) {
            countedItem = questData.progress;
        }
        if ((i2 & 64) != 0) {
            str4 = questData.buttonType;
        }
        if ((i2 & 128) != 0) {
            str5 = questData.image;
        }
        if ((i2 & 256) != 0) {
            str6 = questData.error;
        }
        if ((i2 & 512) != 0) {
            str7 = questData.timer;
        }
        String str8 = str6;
        String str9 = str7;
        String str10 = str4;
        String str11 = str5;
        List list3 = list2;
        CountedItem countedItem2 = countedItem;
        return questData.copy(i, str, str2, str3, list3, countedItem2, str10, str11, str8, str9);
    }

    public final int component1() {
        return this.id;
    }

    public final String component10() {
        return this.timer;
    }

    public final String component2() {
        return this.type;
    }

    public final String component3() {
        return this.name;
    }

    public final String component4() {
        return this.description;
    }

    public final List<EasterItem> component5() {
        return this.items;
    }

    public final CountedItem component6() {
        return this.progress;
    }

    public final String component7() {
        return this.buttonType;
    }

    public final String component8() {
        return this.image;
    }

    public final String component9() {
        return this.error;
    }

    public final QuestData copy(int i, String str, String name, String description, List<EasterItem> items, CountedItem progress, String buttonType, String image, String str2, String str3) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(description, "description");
        Intrinsics.checkNotNullParameter(items, "items");
        Intrinsics.checkNotNullParameter(progress, "progress");
        Intrinsics.checkNotNullParameter(buttonType, "buttonType");
        Intrinsics.checkNotNullParameter(image, "image");
        return new QuestData(i, str, name, description, items, progress, buttonType, image, str2, str3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof QuestData) {
            QuestData questData = (QuestData) obj;
            return this.id == questData.id && Intrinsics.areEqual(this.type, questData.type) && Intrinsics.areEqual(this.name, questData.name) && Intrinsics.areEqual(this.description, questData.description) && Intrinsics.areEqual(this.items, questData.items) && Intrinsics.areEqual(this.progress, questData.progress) && Intrinsics.areEqual(this.buttonType, questData.buttonType) && Intrinsics.areEqual(this.image, questData.image) && Intrinsics.areEqual(this.error, questData.error) && Intrinsics.areEqual(this.timer, questData.timer);
        }
        return false;
    }

    public int hashCode() {
        int hashCode = Integer.hashCode(this.id) * 31;
        String str = this.type;
        int hashCode2 = (((((((((((((hashCode + (str == null ? 0 : str.hashCode())) * 31) + this.name.hashCode()) * 31) + this.description.hashCode()) * 31) + this.items.hashCode()) * 31) + this.progress.hashCode()) * 31) + this.buttonType.hashCode()) * 31) + this.image.hashCode()) * 31;
        String str2 = this.error;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.timer;
        return hashCode3 + (str3 != null ? str3.hashCode() : 0);
    }

    public String toString() {
        int i = this.id;
        String str = this.type;
        String str2 = this.name;
        String str3 = this.description;
        List<EasterItem> list = this.items;
        CountedItem countedItem = this.progress;
        String str4 = this.buttonType;
        String str5 = this.image;
        String str6 = this.error;
        return "QuestData(id=" + i + ", type=" + str + ", name=" + str2 + ", description=" + str3 + ", items=" + list + ", progress=" + countedItem + ", buttonType=" + str4 + ", image=" + str5 + ", error=" + str6 + ", timer=" + this.timer + ")";
    }

    public QuestData(int i, String str, String name, String description, List<EasterItem> items, CountedItem progress, String buttonType, String image, String str2, String str3) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(description, "description");
        Intrinsics.checkNotNullParameter(items, "items");
        Intrinsics.checkNotNullParameter(progress, "progress");
        Intrinsics.checkNotNullParameter(buttonType, "buttonType");
        Intrinsics.checkNotNullParameter(image, "image");
        this.id = i;
        this.type = str;
        this.name = name;
        this.description = description;
        this.items = items;
        this.progress = progress;
        this.buttonType = buttonType;
        this.image = image;
        this.error = str2;
        this.timer = str3;
    }

    public final int getId() {
        return this.id;
    }

    public /* synthetic */ QuestData(int i, String str, String str2, String str3, List list, CountedItem countedItem, String str4, String str5, String str6, String str7, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, (i2 & 2) != 0 ? "" : str, str2, str3, list, countedItem, str4, str5, str6, str7);
    }

    public final String getType() {
        return this.type;
    }

    public final String getName() {
        return this.name;
    }

    public final String getDescription() {
        return this.description;
    }

    public final List<EasterItem> getItems() {
        return this.items;
    }

    public final CountedItem getProgress() {
        return this.progress;
    }

    public final String getButtonType() {
        return this.buttonType;
    }

    public final String getImage() {
        return this.image;
    }

    public final String getError() {
        return this.error;
    }

    public final String getTimer() {
        return this.timer;
    }
}
