package ru.mrlargha.feature.battlepassWinter2025.data;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: BattlePassData.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000bJ\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0005HÆ\u0003J>\u0010\u0015\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0016J\u0014\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u001a\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010\u001b\u001a\u00020\u0005HÖ\u0081\u0004R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000e¨\u0006\u001c"}, d2 = {"Lru/mrlargha/feature/battlepassWinter2025/data/EventPreviewRewardData;", "", "id", "", "title", "", "img", "rarity", "<init>", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getTitle", "()Ljava/lang/String;", "getImg", "getRarity", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lru/mrlargha/feature/battlepassWinter2025/data/EventPreviewRewardData;", "equals", "", "other", "hashCode", "toString", "battle-pass"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class EventPreviewRewardData {
    private final Integer id;
    private final String img;
    private final String rarity;
    private final String title;

    public static /* synthetic */ EventPreviewRewardData copy$default(EventPreviewRewardData eventPreviewRewardData, Integer num, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            num = eventPreviewRewardData.id;
        }
        if ((i & 2) != 0) {
            str = eventPreviewRewardData.title;
        }
        if ((i & 4) != 0) {
            str2 = eventPreviewRewardData.img;
        }
        if ((i & 8) != 0) {
            str3 = eventPreviewRewardData.rarity;
        }
        return eventPreviewRewardData.copy(num, str, str2, str3);
    }

    public final Integer component1() {
        return this.id;
    }

    public final String component2() {
        return this.title;
    }

    public final String component3() {
        return this.img;
    }

    public final String component4() {
        return this.rarity;
    }

    public final EventPreviewRewardData copy(Integer num, String str, String str2, String str3) {
        return new EventPreviewRewardData(num, str, str2, str3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof EventPreviewRewardData) {
            EventPreviewRewardData eventPreviewRewardData = (EventPreviewRewardData) obj;
            return Intrinsics.areEqual(this.id, eventPreviewRewardData.id) && Intrinsics.areEqual(this.title, eventPreviewRewardData.title) && Intrinsics.areEqual(this.img, eventPreviewRewardData.img) && Intrinsics.areEqual(this.rarity, eventPreviewRewardData.rarity);
        }
        return false;
    }

    public int hashCode() {
        Integer num = this.id;
        int hashCode = (num == null ? 0 : num.hashCode()) * 31;
        String str = this.title;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.img;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.rarity;
        return hashCode3 + (str3 != null ? str3.hashCode() : 0);
    }

    public String toString() {
        Integer num = this.id;
        String str = this.title;
        String str2 = this.img;
        return "EventPreviewRewardData(id=" + num + ", title=" + str + ", img=" + str2 + ", rarity=" + this.rarity + ")";
    }

    public EventPreviewRewardData(Integer num, String str, String str2, String str3) {
        this.id = num;
        this.title = str;
        this.img = str2;
        this.rarity = str3;
    }

    public final Integer getId() {
        return this.id;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getImg() {
        return this.img;
    }

    public final String getRarity() {
        return this.rarity;
    }
}
