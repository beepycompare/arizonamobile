package ru.mrlargha.event.data;

import androidx.core.app.NotificationCompat;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: EventData.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J1\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u0005HÆ\u0001J\u0014\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0018\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010\u0019\u001a\u00020\u0005HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\r¨\u0006\u001a"}, d2 = {"Lru/mrlargha/event/data/RatingData;", "", "id", "", "name", "", "points", "prize", "<init>", "(ILjava/lang/String;ILjava/lang/String;)V", "getId", "()I", "getName", "()Ljava/lang/String;", "getPoints", "getPrize", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", NotificationCompat.CATEGORY_EVENT}, k = 1, mv = {2, 3, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class RatingData {
    private final int id;
    private final String name;
    private final int points;
    private final String prize;

    public static /* synthetic */ RatingData copy$default(RatingData ratingData, int i, String str, int i2, String str2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = ratingData.id;
        }
        if ((i3 & 2) != 0) {
            str = ratingData.name;
        }
        if ((i3 & 4) != 0) {
            i2 = ratingData.points;
        }
        if ((i3 & 8) != 0) {
            str2 = ratingData.prize;
        }
        return ratingData.copy(i, str, i2, str2);
    }

    public final int component1() {
        return this.id;
    }

    public final String component2() {
        return this.name;
    }

    public final int component3() {
        return this.points;
    }

    public final String component4() {
        return this.prize;
    }

    public final RatingData copy(int i, String name, int i2, String prize) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(prize, "prize");
        return new RatingData(i, name, i2, prize);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof RatingData) {
            RatingData ratingData = (RatingData) obj;
            return this.id == ratingData.id && Intrinsics.areEqual(this.name, ratingData.name) && this.points == ratingData.points && Intrinsics.areEqual(this.prize, ratingData.prize);
        }
        return false;
    }

    public int hashCode() {
        return (((((Integer.hashCode(this.id) * 31) + this.name.hashCode()) * 31) + Integer.hashCode(this.points)) * 31) + this.prize.hashCode();
    }

    public String toString() {
        int i = this.id;
        String str = this.name;
        int i2 = this.points;
        return "RatingData(id=" + i + ", name=" + str + ", points=" + i2 + ", prize=" + this.prize + ")";
    }

    public RatingData(int i, String name, int i2, String prize) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(prize, "prize");
        this.id = i;
        this.name = name;
        this.points = i2;
        this.prize = prize;
    }

    public final int getId() {
        return this.id;
    }

    public final String getName() {
        return this.name;
    }

    public final int getPoints() {
        return this.points;
    }

    public final String getPrize() {
        return this.prize;
    }
}
