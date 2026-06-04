package ru.mrlargha.commonui.elements.hud.presentation.hud_screens.payday;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: data.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0007HÆ\u0003J1\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0014\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u001a\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010\u001b\u001a\u00020\u0007HÖ\u0081\u0004R%\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u0092\u0002\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0002¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR%\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004\u0092\u0002\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR%\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004\u0092\u0002\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000bR%\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004\u0092\u0002\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001c"}, d2 = {"Lru/mrlargha/commonui/elements/hud/presentation/hud_screens/payday/PaydayLevel;", "", FirebaseAnalytics.Param.LEVEL, "", "currentExp", "maxExp", "lostProperty", "", "<init>", "(IIILjava/lang/String;)V", "getLevel", "()I", "Lcom/google/gson/annotations/SerializedName;", "value", "getCurrentExp", "getMaxExp", "getLostProperty", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "CommonUI"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class PaydayLevel {
    @SerializedName("currentExp")
    private final int currentExp;
    @SerializedName(FirebaseAnalytics.Param.LEVEL)
    private final int level;
    @SerializedName("lostProperty")
    private final String lostProperty;
    @SerializedName("maxExp")
    private final int maxExp;

    public PaydayLevel() {
        this(0, 0, 0, null, 15, null);
    }

    public static /* synthetic */ PaydayLevel copy$default(PaydayLevel paydayLevel, int i, int i2, int i3, String str, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i = paydayLevel.level;
        }
        if ((i4 & 2) != 0) {
            i2 = paydayLevel.currentExp;
        }
        if ((i4 & 4) != 0) {
            i3 = paydayLevel.maxExp;
        }
        if ((i4 & 8) != 0) {
            str = paydayLevel.lostProperty;
        }
        return paydayLevel.copy(i, i2, i3, str);
    }

    public final int component1() {
        return this.level;
    }

    public final int component2() {
        return this.currentExp;
    }

    public final int component3() {
        return this.maxExp;
    }

    public final String component4() {
        return this.lostProperty;
    }

    public final PaydayLevel copy(int i, int i2, int i3, String lostProperty) {
        Intrinsics.checkNotNullParameter(lostProperty, "lostProperty");
        return new PaydayLevel(i, i2, i3, lostProperty);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof PaydayLevel) {
            PaydayLevel paydayLevel = (PaydayLevel) obj;
            return this.level == paydayLevel.level && this.currentExp == paydayLevel.currentExp && this.maxExp == paydayLevel.maxExp && Intrinsics.areEqual(this.lostProperty, paydayLevel.lostProperty);
        }
        return false;
    }

    public int hashCode() {
        return (((((Integer.hashCode(this.level) * 31) + Integer.hashCode(this.currentExp)) * 31) + Integer.hashCode(this.maxExp)) * 31) + this.lostProperty.hashCode();
    }

    public String toString() {
        int i = this.level;
        int i2 = this.currentExp;
        int i3 = this.maxExp;
        return "PaydayLevel(level=" + i + ", currentExp=" + i2 + ", maxExp=" + i3 + ", lostProperty=" + this.lostProperty + ")";
    }

    public PaydayLevel(int i, int i2, int i3, String lostProperty) {
        Intrinsics.checkNotNullParameter(lostProperty, "lostProperty");
        this.level = i;
        this.currentExp = i2;
        this.maxExp = i3;
        this.lostProperty = lostProperty;
    }

    public final int getLevel() {
        return this.level;
    }

    public final int getCurrentExp() {
        return this.currentExp;
    }

    public final int getMaxExp() {
        return this.maxExp;
    }

    public /* synthetic */ PaydayLevel(int i, int i2, int i3, String str, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this((i4 & 1) != 0 ? 0 : i, (i4 & 2) != 0 ? 0 : i2, (i4 & 4) != 0 ? 0 : i3, (i4 & 8) != 0 ? "" : str);
    }

    public final String getLostProperty() {
        return this.lostProperty;
    }
}
