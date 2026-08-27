package ru.mrlargha.commonui.elements.hud.presentation.hud_screens.faction_capture;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: FactionCaptureData.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0080\b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\u0003¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003JE\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u001e\u001a\u00020\u0006HÖ\u0081\u0004J\n\u0010\u001f\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0011\u0010\b\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\r¨\u0006 "}, d2 = {"Lru/mrlargha/commonui/elements/hud/presentation/hud_screens/faction_capture/FactionCaptureState;", "", "leftFaction", "", "rightFaction", "leftScore", "", "rightScore", "remainingSeconds", "status", "<init>", "(Ljava/lang/String;Ljava/lang/String;IIILjava/lang/String;)V", "getLeftFaction", "()Ljava/lang/String;", "getRightFaction", "getLeftScore", "()I", "getRightScore", "getRemainingSeconds", "getStatus", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "toString", "CommonUI"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class FactionCaptureState {
    private final String leftFaction;
    private final int leftScore;
    private final int remainingSeconds;
    private final String rightFaction;
    private final int rightScore;
    private final String status;

    public static /* synthetic */ FactionCaptureState copy$default(FactionCaptureState factionCaptureState, String str, String str2, int i, int i2, int i3, String str3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            str = factionCaptureState.leftFaction;
        }
        if ((i4 & 2) != 0) {
            str2 = factionCaptureState.rightFaction;
        }
        if ((i4 & 4) != 0) {
            i = factionCaptureState.leftScore;
        }
        if ((i4 & 8) != 0) {
            i2 = factionCaptureState.rightScore;
        }
        if ((i4 & 16) != 0) {
            i3 = factionCaptureState.remainingSeconds;
        }
        if ((i4 & 32) != 0) {
            str3 = factionCaptureState.status;
        }
        int i5 = i3;
        String str4 = str3;
        return factionCaptureState.copy(str, str2, i, i2, i5, str4);
    }

    public final String component1() {
        return this.leftFaction;
    }

    public final String component2() {
        return this.rightFaction;
    }

    public final int component3() {
        return this.leftScore;
    }

    public final int component4() {
        return this.rightScore;
    }

    public final int component5() {
        return this.remainingSeconds;
    }

    public final String component6() {
        return this.status;
    }

    public final FactionCaptureState copy(String leftFaction, String rightFaction, int i, int i2, int i3, String status) {
        Intrinsics.checkNotNullParameter(leftFaction, "leftFaction");
        Intrinsics.checkNotNullParameter(rightFaction, "rightFaction");
        Intrinsics.checkNotNullParameter(status, "status");
        return new FactionCaptureState(leftFaction, rightFaction, i, i2, i3, status);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof FactionCaptureState) {
            FactionCaptureState factionCaptureState = (FactionCaptureState) obj;
            return Intrinsics.areEqual(this.leftFaction, factionCaptureState.leftFaction) && Intrinsics.areEqual(this.rightFaction, factionCaptureState.rightFaction) && this.leftScore == factionCaptureState.leftScore && this.rightScore == factionCaptureState.rightScore && this.remainingSeconds == factionCaptureState.remainingSeconds && Intrinsics.areEqual(this.status, factionCaptureState.status);
        }
        return false;
    }

    public int hashCode() {
        return (((((((((this.leftFaction.hashCode() * 31) + this.rightFaction.hashCode()) * 31) + Integer.hashCode(this.leftScore)) * 31) + Integer.hashCode(this.rightScore)) * 31) + Integer.hashCode(this.remainingSeconds)) * 31) + this.status.hashCode();
    }

    public String toString() {
        String str = this.leftFaction;
        String str2 = this.rightFaction;
        int i = this.leftScore;
        int i2 = this.rightScore;
        int i3 = this.remainingSeconds;
        return "FactionCaptureState(leftFaction=" + str + ", rightFaction=" + str2 + ", leftScore=" + i + ", rightScore=" + i2 + ", remainingSeconds=" + i3 + ", status=" + this.status + ")";
    }

    public FactionCaptureState(String leftFaction, String rightFaction, int i, int i2, int i3, String status) {
        Intrinsics.checkNotNullParameter(leftFaction, "leftFaction");
        Intrinsics.checkNotNullParameter(rightFaction, "rightFaction");
        Intrinsics.checkNotNullParameter(status, "status");
        this.leftFaction = leftFaction;
        this.rightFaction = rightFaction;
        this.leftScore = i;
        this.rightScore = i2;
        this.remainingSeconds = i3;
        this.status = status;
    }

    public final String getLeftFaction() {
        return this.leftFaction;
    }

    public final String getRightFaction() {
        return this.rightFaction;
    }

    public final int getLeftScore() {
        return this.leftScore;
    }

    public final int getRightScore() {
        return this.rightScore;
    }

    public final int getRemainingSeconds() {
        return this.remainingSeconds;
    }

    public final String getStatus() {
        return this.status;
    }
}
