package ru.mrlargha.commonui.elements.easter.data;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: EventData.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b \n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001Bo\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b\u0012\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0011\u0010\u0012J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\bHÆ\u0003J\u0011\u0010&\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bHÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0085\u0001\u0010+\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010,\u001a\u00020-2\b\u0010.\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010/\u001a\u00020\u0003HÖ\u0001J\t\u00100\u001a\u00020\u0005HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0013\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0019R\u0019\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0018\u0010\r\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0016R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0016R\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0016R\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0016¨\u00061"}, d2 = {"Lru/mrlargha/commonui/elements/easter/data/EventData;", "", "id", "", "name", "", "description", "attempts", "Lru/mrlargha/commonui/elements/easter/data/CountedItem;", "players", FirebaseAnalytics.Param.ITEMS, "", "Lru/mrlargha/commonui/elements/easter/data/EasterItem;", "buttonType", "image", "error", "timer", "<init>", "(ILjava/lang/String;Ljava/lang/String;Lru/mrlargha/commonui/elements/easter/data/CountedItem;Lru/mrlargha/commonui/elements/easter/data/CountedItem;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getId", "()I", "getName", "()Ljava/lang/String;", "getDescription", "getAttempts", "()Lru/mrlargha/commonui/elements/easter/data/CountedItem;", "getPlayers", "getItems", "()Ljava/util/List;", "getButtonType", "getImage", "getError", "getTimer", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "copy", "equals", "", "other", "hashCode", "toString", "CommonUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class EventData {
    private final CountedItem attempts;
    @SerializedName("button_type")
    private final String buttonType;
    private final String description;
    @SerializedName("error_text")
    private final String error;
    @SerializedName("event_id")
    private final int id;
    private final String image;
    private final List<EasterItem> items;
    private final String name;
    private final CountedItem players;
    @SerializedName("available_after")
    private final String timer;

    public static /* synthetic */ EventData copy$default(EventData eventData, int i, String str, String str2, CountedItem countedItem, CountedItem countedItem2, List list, String str3, String str4, String str5, String str6, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = eventData.id;
        }
        if ((i2 & 2) != 0) {
            str = eventData.name;
        }
        if ((i2 & 4) != 0) {
            str2 = eventData.description;
        }
        if ((i2 & 8) != 0) {
            countedItem = eventData.attempts;
        }
        if ((i2 & 16) != 0) {
            countedItem2 = eventData.players;
        }
        List<EasterItem> list2 = list;
        if ((i2 & 32) != 0) {
            list2 = eventData.items;
        }
        if ((i2 & 64) != 0) {
            str3 = eventData.buttonType;
        }
        if ((i2 & 128) != 0) {
            str4 = eventData.image;
        }
        if ((i2 & 256) != 0) {
            str5 = eventData.error;
        }
        if ((i2 & 512) != 0) {
            str6 = eventData.timer;
        }
        String str7 = str5;
        String str8 = str6;
        String str9 = str3;
        String str10 = str4;
        CountedItem countedItem3 = countedItem2;
        List list3 = list2;
        return eventData.copy(i, str, str2, countedItem, countedItem3, list3, str9, str10, str7, str8);
    }

    public final int component1() {
        return this.id;
    }

    public final String component10() {
        return this.timer;
    }

    public final String component2() {
        return this.name;
    }

    public final String component3() {
        return this.description;
    }

    public final CountedItem component4() {
        return this.attempts;
    }

    public final CountedItem component5() {
        return this.players;
    }

    public final List<EasterItem> component6() {
        return this.items;
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

    public final EventData copy(int i, String str, String str2, CountedItem countedItem, CountedItem countedItem2, List<EasterItem> list, String str3, String str4, String str5, String str6) {
        return new EventData(i, str, str2, countedItem, countedItem2, list, str3, str4, str5, str6);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof EventData) {
            EventData eventData = (EventData) obj;
            return this.id == eventData.id && Intrinsics.areEqual(this.name, eventData.name) && Intrinsics.areEqual(this.description, eventData.description) && Intrinsics.areEqual(this.attempts, eventData.attempts) && Intrinsics.areEqual(this.players, eventData.players) && Intrinsics.areEqual(this.items, eventData.items) && Intrinsics.areEqual(this.buttonType, eventData.buttonType) && Intrinsics.areEqual(this.image, eventData.image) && Intrinsics.areEqual(this.error, eventData.error) && Intrinsics.areEqual(this.timer, eventData.timer);
        }
        return false;
    }

    public int hashCode() {
        int hashCode = Integer.hashCode(this.id) * 31;
        String str = this.name;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.description;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        CountedItem countedItem = this.attempts;
        int hashCode4 = (hashCode3 + (countedItem == null ? 0 : countedItem.hashCode())) * 31;
        CountedItem countedItem2 = this.players;
        int hashCode5 = (hashCode4 + (countedItem2 == null ? 0 : countedItem2.hashCode())) * 31;
        List<EasterItem> list = this.items;
        int hashCode6 = (hashCode5 + (list == null ? 0 : list.hashCode())) * 31;
        String str3 = this.buttonType;
        int hashCode7 = (hashCode6 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.image;
        int hashCode8 = (hashCode7 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.error;
        int hashCode9 = (hashCode8 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.timer;
        return hashCode9 + (str6 != null ? str6.hashCode() : 0);
    }

    public String toString() {
        int i = this.id;
        String str = this.name;
        String str2 = this.description;
        CountedItem countedItem = this.attempts;
        CountedItem countedItem2 = this.players;
        List<EasterItem> list = this.items;
        String str3 = this.buttonType;
        String str4 = this.image;
        String str5 = this.error;
        return "EventData(id=" + i + ", name=" + str + ", description=" + str2 + ", attempts=" + countedItem + ", players=" + countedItem2 + ", items=" + list + ", buttonType=" + str3 + ", image=" + str4 + ", error=" + str5 + ", timer=" + this.timer + ")";
    }

    public EventData(int i, String str, String str2, CountedItem countedItem, CountedItem countedItem2, List<EasterItem> list, String str3, String str4, String str5, String str6) {
        this.id = i;
        this.name = str;
        this.description = str2;
        this.attempts = countedItem;
        this.players = countedItem2;
        this.items = list;
        this.buttonType = str3;
        this.image = str4;
        this.error = str5;
        this.timer = str6;
    }

    public final int getId() {
        return this.id;
    }

    public final String getName() {
        return this.name;
    }

    public final String getDescription() {
        return this.description;
    }

    public final CountedItem getAttempts() {
        return this.attempts;
    }

    public final CountedItem getPlayers() {
        return this.players;
    }

    public final List<EasterItem> getItems() {
        return this.items;
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
