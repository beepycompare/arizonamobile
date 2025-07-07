package ru.mrlargha.commonui.elements.dice;

import androidx.core.app.NotificationCompat;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: Dice.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0005HÆ\u0003J3\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001b\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000b\"\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\r¨\u0006\u001c"}, d2 = {"Lru/mrlargha/commonui/elements/dice/DiceUpdatePlayerData;", "", "id", "", "name", "", FirebaseAnalytics.Param.SCORE, NotificationCompat.CATEGORY_STATUS, "<init>", "(ILjava/lang/String;ILjava/lang/String;)V", "getId", "()I", "getName", "()Ljava/lang/String;", "getScore", "setScore", "(I)V", "getStatus", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "CommonUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class DiceUpdatePlayerData {
    private final int id;
    private final String name;
    private int score;
    private final String status;

    public static /* synthetic */ DiceUpdatePlayerData copy$default(DiceUpdatePlayerData diceUpdatePlayerData, int i, String str, int i2, String str2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = diceUpdatePlayerData.id;
        }
        if ((i3 & 2) != 0) {
            str = diceUpdatePlayerData.name;
        }
        if ((i3 & 4) != 0) {
            i2 = diceUpdatePlayerData.score;
        }
        if ((i3 & 8) != 0) {
            str2 = diceUpdatePlayerData.status;
        }
        return diceUpdatePlayerData.copy(i, str, i2, str2);
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

    public final DiceUpdatePlayerData copy(int i, String name, int i2, String str) {
        Intrinsics.checkNotNullParameter(name, "name");
        return new DiceUpdatePlayerData(i, name, i2, str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DiceUpdatePlayerData) {
            DiceUpdatePlayerData diceUpdatePlayerData = (DiceUpdatePlayerData) obj;
            return this.id == diceUpdatePlayerData.id && Intrinsics.areEqual(this.name, diceUpdatePlayerData.name) && this.score == diceUpdatePlayerData.score && Intrinsics.areEqual(this.status, diceUpdatePlayerData.status);
        }
        return false;
    }

    public int hashCode() {
        int hashCode = ((((Integer.hashCode(this.id) * 31) + this.name.hashCode()) * 31) + Integer.hashCode(this.score)) * 31;
        String str = this.status;
        return hashCode + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        int i = this.id;
        String str = this.name;
        int i2 = this.score;
        return "DiceUpdatePlayerData(id=" + i + ", name=" + str + ", score=" + i2 + ", status=" + this.status + ")";
    }

    public DiceUpdatePlayerData(int i, String name, int i2, String str) {
        Intrinsics.checkNotNullParameter(name, "name");
        this.id = i;
        this.name = name;
        this.score = i2;
        this.status = str;
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

    public final void setScore(int i) {
        this.score = i;
    }
}
