package ru.mrlargha.commonui.elements.dialogs;

import android.util.Log;
import androidx.media3.common.C;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import kotlin.Metadata;
/* compiled from: DialogWithdrawLimitModel.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0013\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0006\u0010\u0011\u001a\u00020\u0003J\u0006\u0010\u0012\u001a\u00020\u0003J\u0006\u0010\u0013\u001a\u00020\u0003J\u0006\u0010\u0014\u001a\u00020\u0003J\u0006\u0010\u0015\u001a\u00020\u0003J\u0006\u0010\u0016\u001a\u00020\u0017J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u001e\u001a\u00020\u001fHÖ\u0081\u0004J\n\u0010 \u001a\u00020!HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u001a\u0010\n\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\b\"\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\b\"\u0004\b\u0010\u0010\r¨\u0006\""}, d2 = {"Lru/mrlargha/commonui/elements/dialogs/DialogWithdrawLimitModel;", "", "maxMoney", "", "minMoney", "<init>", "(JJ)V", "getMaxMoney", "()J", "getMinMoney", "currentM", "getCurrentM", "setCurrentM", "(J)V", "currentKK", "getCurrentKK", "setCurrentKK", "getMaxForM", "getMinForM", "getMaxForKK", "getMinForKK", "getMaxForK", "getMinForK", "", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "CommonUI"}, k = 1, mv = {2, 3, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class DialogWithdrawLimitModel {
    private long currentKK;
    private long currentM;
    private final long maxMoney;
    private final long minMoney;

    public static /* synthetic */ DialogWithdrawLimitModel copy$default(DialogWithdrawLimitModel dialogWithdrawLimitModel, long j, long j2, int i, Object obj) {
        if ((i & 1) != 0) {
            j = dialogWithdrawLimitModel.maxMoney;
        }
        if ((i & 2) != 0) {
            j2 = dialogWithdrawLimitModel.minMoney;
        }
        return dialogWithdrawLimitModel.copy(j, j2);
    }

    public final long component1() {
        return this.maxMoney;
    }

    public final long component2() {
        return this.minMoney;
    }

    public final DialogWithdrawLimitModel copy(long j, long j2) {
        return new DialogWithdrawLimitModel(j, j2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DialogWithdrawLimitModel) {
            DialogWithdrawLimitModel dialogWithdrawLimitModel = (DialogWithdrawLimitModel) obj;
            return this.maxMoney == dialogWithdrawLimitModel.maxMoney && this.minMoney == dialogWithdrawLimitModel.minMoney;
        }
        return false;
    }

    public int hashCode() {
        return (Long.hashCode(this.maxMoney) * 31) + Long.hashCode(this.minMoney);
    }

    public String toString() {
        long j = this.maxMoney;
        return "DialogWithdrawLimitModel(maxMoney=" + j + ", minMoney=" + this.minMoney + ")";
    }

    public DialogWithdrawLimitModel(long j, long j2) {
        this.maxMoney = j;
        this.minMoney = j2;
    }

    public final long getMaxMoney() {
        return this.maxMoney;
    }

    public final long getMinMoney() {
        return this.minMoney;
    }

    public final long getCurrentM() {
        return this.currentM;
    }

    public final void setCurrentM(long j) {
        this.currentM = j;
    }

    public final long getCurrentKK() {
        return this.currentKK;
    }

    public final void setCurrentKK(long j) {
        this.currentKK = j;
    }

    public final long getMaxForM() {
        return this.maxMoney / C.NANOS_PER_SECOND;
    }

    public final long getMinForM() {
        return this.minMoney / C.NANOS_PER_SECOND;
    }

    public final long getMaxForKK() {
        if (this.currentM < getMaxForM()) {
            return 999L;
        }
        return (this.maxMoney / 1000000) % 1000;
    }

    public final long getMinForKK() {
        long j = this.currentKK;
        Log.i("TAG", "getMinForK:" + j + " " + this.currentM + " ");
        if (this.currentM > getMinForM()) {
            return 0L;
        }
        return (this.minMoney / 1000000) % 1000;
    }

    public final long getMaxForK() {
        long maxForM = getMaxForM();
        long j = this.maxMoney;
        long j2 = (j / 1000000) % 1000;
        long j3 = this.currentM;
        if (j3 < maxForM) {
            return 999999L;
        }
        if (j3 > maxForM) {
            return 0L;
        }
        long j4 = this.currentKK;
        if (j4 < j2) {
            return 999999L;
        }
        if (j4 > j2) {
            return 0L;
        }
        return j % 1000000;
    }

    public final double getMinForK() {
        long minForM = getMinForM();
        long j = this.minMoney;
        long j2 = (j / 1000000) % 1000;
        long j3 = this.currentM;
        if (j3 > minForM) {
            return FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        }
        if (j3 < minForM) {
            return Double.MAX_VALUE;
        }
        long j4 = this.currentKK;
        if (j4 > j2) {
            return FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        }
        if (j4 < j2) {
            return Double.MAX_VALUE;
        }
        return (j % 1000000) / 1000.0d;
    }
}
