package ru.mrlargha.commonui.elements.dice;

import androidx.core.app.NotificationCompat;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: Dice.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J=\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001J\t\u0010 \u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\f\"\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000e\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\b\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\f\"\u0004\b\u0015\u0010\u0011¨\u0006!"}, d2 = {"Lru/mrlargha/commonui/elements/dice/DicePlayerData;", "", "id", "", "name", "", FirebaseAnalytics.Param.SCORE, NotificationCompat.CATEGORY_STATUS, "isCurrent", "<init>", "(ILjava/lang/String;ILjava/lang/String;I)V", "getId", "()I", "getName", "()Ljava/lang/String;", "getScore", "setScore", "(I)V", "getStatus", "setStatus", "(Ljava/lang/String;)V", "setCurrent", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "CommonUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class DicePlayerData {
    private final int id;
    private int isCurrent;
    private final String name;
    private int score;
    private String status;

    public static /* synthetic */ DicePlayerData copy$default(DicePlayerData dicePlayerData, int i, String str, int i2, String str2, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i = dicePlayerData.id;
        }
        if ((i4 & 2) != 0) {
            str = dicePlayerData.name;
        }
        if ((i4 & 4) != 0) {
            i2 = dicePlayerData.score;
        }
        if ((i4 & 8) != 0) {
            str2 = dicePlayerData.status;
        }
        if ((i4 & 16) != 0) {
            i3 = dicePlayerData.isCurrent;
        }
        int i5 = i3;
        int i6 = i2;
        return dicePlayerData.copy(i, str, i6, str2, i5);
    }

    public final int component1() {
        return this.id;
    }

    public final String component2() {
        return this.name;
    }

    public final int component3() {
        return this.score;
    }

    public final String component4() {
        return this.status;
    }

    public final int component5() {
        return this.isCurrent;
    }

    public final DicePlayerData copy(int i, String name, int i2, String str, int i3) {
        Intrinsics.checkNotNullParameter(name, "name");
        return new DicePlayerData(i, name, i2, str, i3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DicePlayerData) {
            DicePlayerData dicePlayerData = (DicePlayerData) obj;
            return this.id == dicePlayerData.id && Intrinsics.areEqual(this.name, dicePlayerData.name) && this.score == dicePlayerData.score && Intrinsics.areEqual(this.status, dicePlayerData.status) && this.isCurrent == dicePlayerData.isCurrent;
        }
        return false;
    }

    public int hashCode() {
        int hashCode = ((((Integer.hashCode(this.id) * 31) + this.name.hashCode()) * 31) + Integer.hashCode(this.score)) * 31;
        String str = this.status;
        return ((hashCode + (str == null ? 0 : str.hashCode())) * 31) + Integer.hashCode(this.isCurrent);
    }

    public String toString() {
        int i = this.id;
        String str = this.name;
        int i2 = this.score;
        String str2 = this.status;
        return "DicePlayerData(id=" + i + ", name=" + str + ", score=" + i2 + ", status=" + str2 + ", isCurrent=" + this.isCurrent + ")";
    }

    public DicePlayerData(int i, String name, int i2, String str, int i3) {
        Intrinsics.checkNotNullParameter(name, "name");
        this.id = i;
        this.name = name;
        this.score = i2;
        this.status = str;
        this.isCurrent = i3;
    }

    public /* synthetic */ DicePlayerData(int i, String str, int i2, String str2, int i3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, str, i2, str2, (i4 & 16) != 0 ? 0 : i3);
    }

    public final int getId() {
        return this.id;
    }

    public final String getName() {
        return this.name;
    }

    public final int getScore() {
        return this.score;
    }

    public final String getStatus() {
        return this.status;
    }

    public final int isCurrent() {
        return this.isCurrent;
    }

    public final void setCurrent(int i) {
        this.isCurrent = i;
    }

    public final void setScore(int i) {
        this.score = i;
    }

    public final void setStatus(String str) {
        this.status = str;
    }
}
