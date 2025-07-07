package ru.mrlargha.commonui.elements.streetFood;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: FoodInfo.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Lru/mrlargha/commonui/elements/streetFood/FoodAvailable;", "", "type", "", "available", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getType", "()Ljava/lang/String;", "getAvailable", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "CommonUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class FoodAvailable {
    private final String available;
    private final String type;

    public static /* synthetic */ FoodAvailable copy$default(FoodAvailable foodAvailable, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = foodAvailable.type;
        }
        if ((i & 2) != 0) {
            str2 = foodAvailable.available;
        }
        return foodAvailable.copy(str, str2);
    }

    public final String component1() {
        return this.type;
    }

    public final String component2() {
        return this.available;
    }

    public final FoodAvailable copy(String type, String available) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(available, "available");
        return new FoodAvailable(type, available);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof FoodAvailable) {
            FoodAvailable foodAvailable = (FoodAvailable) obj;
            return Intrinsics.areEqual(this.type, foodAvailable.type) && Intrinsics.areEqual(this.available, foodAvailable.available);
        }
        return false;
    }

    public int hashCode() {
        return (this.type.hashCode() * 31) + this.available.hashCode();
    }

    public String toString() {
        String str = this.type;
        return "FoodAvailable(type=" + str + ", available=" + this.available + ")";
    }

    public FoodAvailable(String type, String available) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(available, "available");
        this.type = type;
        this.available = available;
    }

    public final String getAvailable() {
        return this.available;
    }

    public final String getType() {
        return this.type;
    }
}
