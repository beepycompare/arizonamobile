package ru.mrlargha.arizonaui.container.domain.obj;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: Container.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u001f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001BO\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0003¢\u0006\u0004\b\r\u0010\u000eJ\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0005HÆ\u0003J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\u0003HÆ\u0003Jc\u0010#\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u0003HÆ\u0001J\u0013\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010'\u001a\u00020\u0003HÖ\u0001J\t\u0010(\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0010R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0010R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0010R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0010R\u0011\u0010\n\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0012R\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0010R\u0011\u0010\f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0010¨\u0006)"}, d2 = {"Lru/mrlargha/arizonaui/container/domain/obj/Container;", "", "id", "", "title", "", "image", "time", "startPrice", "currentBet", "currentBetUser", "typePrice", "hourStartTime", "<init>", "(ILjava/lang/String;IIIILjava/lang/String;II)V", "getId", "()I", "getTitle", "()Ljava/lang/String;", "getImage", "getTime", "getStartPrice", "getCurrentBet", "getCurrentBetUser", "getTypePrice", "getHourStartTime", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "toString", "ArizonaUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class Container {
    private final int currentBet;
    private final String currentBetUser;
    private final int hourStartTime;
    private final int id;
    private final int image;
    private final int startPrice;
    private final int time;
    private final String title;
    private final int typePrice;

    public static /* synthetic */ Container copy$default(Container container, int i, String str, int i2, int i3, int i4, int i5, String str2, int i6, int i7, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            i = container.id;
        }
        if ((i8 & 2) != 0) {
            str = container.title;
        }
        if ((i8 & 4) != 0) {
            i2 = container.image;
        }
        if ((i8 & 8) != 0) {
            i3 = container.time;
        }
        if ((i8 & 16) != 0) {
            i4 = container.startPrice;
        }
        if ((i8 & 32) != 0) {
            i5 = container.currentBet;
        }
        if ((i8 & 64) != 0) {
            str2 = container.currentBetUser;
        }
        if ((i8 & 128) != 0) {
            i6 = container.typePrice;
        }
        if ((i8 & 256) != 0) {
            i7 = container.hourStartTime;
        }
        int i9 = i6;
        int i10 = i7;
        int i11 = i5;
        String str3 = str2;
        int i12 = i4;
        int i13 = i2;
        return container.copy(i, str, i13, i3, i12, i11, str3, i9, i10);
    }

    public final int component1() {
        return this.id;
    }

    public final String component2() {
        return this.title;
    }

    public final int component3() {
        return this.image;
    }

    public final int component4() {
        return this.time;
    }

    public final int component5() {
        return this.startPrice;
    }

    public final int component6() {
        return this.currentBet;
    }

    public final String component7() {
        return this.currentBetUser;
    }

    public final int component8() {
        return this.typePrice;
    }

    public final int component9() {
        return this.hourStartTime;
    }

    public final Container copy(int i, String title, int i2, int i3, int i4, int i5, String currentBetUser, int i6, int i7) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(currentBetUser, "currentBetUser");
        return new Container(i, title, i2, i3, i4, i5, currentBetUser, i6, i7);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Container) {
            Container container = (Container) obj;
            return this.id == container.id && Intrinsics.areEqual(this.title, container.title) && this.image == container.image && this.time == container.time && this.startPrice == container.startPrice && this.currentBet == container.currentBet && Intrinsics.areEqual(this.currentBetUser, container.currentBetUser) && this.typePrice == container.typePrice && this.hourStartTime == container.hourStartTime;
        }
        return false;
    }

    public int hashCode() {
        return (((((((((((((((Integer.hashCode(this.id) * 31) + this.title.hashCode()) * 31) + Integer.hashCode(this.image)) * 31) + Integer.hashCode(this.time)) * 31) + Integer.hashCode(this.startPrice)) * 31) + Integer.hashCode(this.currentBet)) * 31) + this.currentBetUser.hashCode()) * 31) + Integer.hashCode(this.typePrice)) * 31) + Integer.hashCode(this.hourStartTime);
    }

    public String toString() {
        int i = this.id;
        String str = this.title;
        int i2 = this.image;
        int i3 = this.time;
        int i4 = this.startPrice;
        int i5 = this.currentBet;
        String str2 = this.currentBetUser;
        int i6 = this.typePrice;
        return "Container(id=" + i + ", title=" + str + ", image=" + i2 + ", time=" + i3 + ", startPrice=" + i4 + ", currentBet=" + i5 + ", currentBetUser=" + str2 + ", typePrice=" + i6 + ", hourStartTime=" + this.hourStartTime + ")";
    }

    public Container(int i, String title, int i2, int i3, int i4, int i5, String currentBetUser, int i6, int i7) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(currentBetUser, "currentBetUser");
        this.id = i;
        this.title = title;
        this.image = i2;
        this.time = i3;
        this.startPrice = i4;
        this.currentBet = i5;
        this.currentBetUser = currentBetUser;
        this.typePrice = i6;
        this.hourStartTime = i7;
    }

    public final int getId() {
        return this.id;
    }

    public final String getTitle() {
        return this.title;
    }

    public final int getImage() {
        return this.image;
    }

    public final int getTime() {
        return this.time;
    }

    public final int getStartPrice() {
        return this.startPrice;
    }

    public final int getCurrentBet() {
        return this.currentBet;
    }

    public final String getCurrentBetUser() {
        return this.currentBetUser;
    }

    public final int getTypePrice() {
        return this.typePrice;
    }

    public final int getHourStartTime() {
        return this.hourStartTime;
    }
}
