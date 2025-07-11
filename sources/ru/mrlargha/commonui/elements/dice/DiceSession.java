package ru.mrlargha.commonui.elements.dice;

import androidx.core.app.NotificationCompat;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: Dice.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u001a\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B[\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0010\u0010\u0007\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\u0010\u0010\u000b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\b¢\u0006\u0004\b\f\u0010\rJ\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0011J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u001c\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\bHÆ\u0003J\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0011J\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0011J\u0013\u0010\u001f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\bHÆ\u0003Jp\u0010 \u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\u0012\b\u0002\u0010\u0007\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00052\u0012\b\u0002\u0010\u000b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\bHÆ\u0001¢\u0006\u0002\u0010!J\u0013\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010%\u001a\u00020\u0005HÖ\u0001J\t\u0010&\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000fR\u001b\u0010\u0007\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0015\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0016\u0010\u0011R\u0015\u0010\n\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0017\u0010\u0011R\u001b\u0010\u000b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0015¨\u0006'"}, d2 = {"Lru/mrlargha/commonui/elements/dice/DiceSession;", "", NotificationCompat.CATEGORY_STATUS, "", "seconds", "", "buttonText", "readyBets", "", "bet", "sumBet", "cubes", "<init>", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/util/List;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/util/List;)V", "getStatus", "()Ljava/lang/String;", "getSeconds", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getButtonText", "getReadyBets", "()Ljava/util/List;", "getBet", "getSumBet", "getCubes", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/util/List;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/util/List;)Lru/mrlargha/commonui/elements/dice/DiceSession;", "equals", "", "other", "hashCode", "toString", "CommonUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class DiceSession {
    private final Integer bet;
    private final String buttonText;
    private final List<Integer> cubes;
    private final List<Integer> readyBets;
    private final Integer seconds;
    private final String status;
    private final Integer sumBet;

    public static /* synthetic */ DiceSession copy$default(DiceSession diceSession, String str, Integer num, String str2, List list, Integer num2, Integer num3, List list2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = diceSession.status;
        }
        if ((i & 2) != 0) {
            num = diceSession.seconds;
        }
        if ((i & 4) != 0) {
            str2 = diceSession.buttonText;
        }
        List<Integer> list3 = list;
        if ((i & 8) != 0) {
            list3 = diceSession.readyBets;
        }
        if ((i & 16) != 0) {
            num2 = diceSession.bet;
        }
        if ((i & 32) != 0) {
            num3 = diceSession.sumBet;
        }
        List<Integer> list4 = list2;
        if ((i & 64) != 0) {
            list4 = diceSession.cubes;
        }
        Integer num4 = num3;
        List list5 = list4;
        Integer num5 = num2;
        String str3 = str2;
        return diceSession.copy(str, num, str3, list3, num5, num4, list5);
    }

    public final String component1() {
        return this.status;
    }

    public final Integer component2() {
        return this.seconds;
    }

    public final String component3() {
        return this.buttonText;
    }

    public final List<Integer> component4() {
        return this.readyBets;
    }

    public final Integer component5() {
        return this.bet;
    }

    public final Integer component6() {
        return this.sumBet;
    }

    public final List<Integer> component7() {
        return this.cubes;
    }

    public final DiceSession copy(String str, Integer num, String buttonText, List<Integer> list, Integer num2, Integer num3, List<Integer> list2) {
        Intrinsics.checkNotNullParameter(buttonText, "buttonText");
        return new DiceSession(str, num, buttonText, list, num2, num3, list2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DiceSession) {
            DiceSession diceSession = (DiceSession) obj;
            return Intrinsics.areEqual(this.status, diceSession.status) && Intrinsics.areEqual(this.seconds, diceSession.seconds) && Intrinsics.areEqual(this.buttonText, diceSession.buttonText) && Intrinsics.areEqual(this.readyBets, diceSession.readyBets) && Intrinsics.areEqual(this.bet, diceSession.bet) && Intrinsics.areEqual(this.sumBet, diceSession.sumBet) && Intrinsics.areEqual(this.cubes, diceSession.cubes);
        }
        return false;
    }

    public int hashCode() {
        String str = this.status;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        Integer num = this.seconds;
        int hashCode2 = (((hashCode + (num == null ? 0 : num.hashCode())) * 31) + this.buttonText.hashCode()) * 31;
        List<Integer> list = this.readyBets;
        int hashCode3 = (hashCode2 + (list == null ? 0 : list.hashCode())) * 31;
        Integer num2 = this.bet;
        int hashCode4 = (hashCode3 + (num2 == null ? 0 : num2.hashCode())) * 31;
        Integer num3 = this.sumBet;
        int hashCode5 = (hashCode4 + (num3 == null ? 0 : num3.hashCode())) * 31;
        List<Integer> list2 = this.cubes;
        return hashCode5 + (list2 != null ? list2.hashCode() : 0);
    }

    public String toString() {
        String str = this.status;
        Integer num = this.seconds;
        String str2 = this.buttonText;
        List<Integer> list = this.readyBets;
        Integer num2 = this.bet;
        Integer num3 = this.sumBet;
        return "DiceSession(status=" + str + ", seconds=" + num + ", buttonText=" + str2 + ", readyBets=" + list + ", bet=" + num2 + ", sumBet=" + num3 + ", cubes=" + this.cubes + ")";
    }

    public DiceSession(String str, Integer num, String buttonText, List<Integer> list, Integer num2, Integer num3, List<Integer> list2) {
        Intrinsics.checkNotNullParameter(buttonText, "buttonText");
        this.status = str;
        this.seconds = num;
        this.buttonText = buttonText;
        this.readyBets = list;
        this.bet = num2;
        this.sumBet = num3;
        this.cubes = list2;
    }

    public final Integer getBet() {
        return this.bet;
    }

    public final String getButtonText() {
        return this.buttonText;
    }

    public final List<Integer> getCubes() {
        return this.cubes;
    }

    public final List<Integer> getReadyBets() {
        return this.readyBets;
    }

    public final Integer getSeconds() {
        return this.seconds;
    }

    public final String getStatus() {
        return this.status;
    }

    public final Integer getSumBet() {
        return this.sumBet;
    }
}
