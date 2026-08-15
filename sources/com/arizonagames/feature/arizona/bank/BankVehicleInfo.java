package com.arizonagames.feature.arizona.bank;

import androidx.media3.extractor.text.ttml.TtmlNode;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: BankContract.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001B9\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001d\u001a\u00020\nHÆ\u0003J;\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\nHÆ\u0001J\u0014\u0010\u001f\u001a\u00020\n2\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010!\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010\"\u001a\u00020\u0005HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0010R%\u0010\t\u001a\u00020\n8\u0006X\u0087\u0004\u0092\u0002\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\t0\u0018¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006#"}, d2 = {"Lcom/arizonagames/feature/arizona/bank/BankVehicleInfo;", "", TtmlNode.ATTR_ID, "", "name", "", "cost", "", "reason", "stolen", "", "<init>", "(ILjava/lang/String;JLjava/lang/String;Z)V", "getId", "()I", "getName", "()Ljava/lang/String;", "getCost", "()J", "getReason", "getStolen", "()Z", "Lcom/google/gson/annotations/JsonAdapter;", "value", "Lcom/arizonagames/feature/arizona/bank/BankBooleanJsonAdapter;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "toString", "bank"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class BankVehicleInfo {
    private final long cost;
    private final int id;
    private final String name;
    private final String reason;
    @JsonAdapter(BankBooleanJsonAdapter.class)
    private final boolean stolen;

    public BankVehicleInfo() {
        this(0, null, 0L, null, false, 31, null);
    }

    public static /* synthetic */ BankVehicleInfo copy$default(BankVehicleInfo bankVehicleInfo, int i, String str, long j, String str2, boolean z, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = bankVehicleInfo.id;
        }
        if ((i2 & 2) != 0) {
            str = bankVehicleInfo.name;
        }
        if ((i2 & 4) != 0) {
            j = bankVehicleInfo.cost;
        }
        if ((i2 & 8) != 0) {
            str2 = bankVehicleInfo.reason;
        }
        if ((i2 & 16) != 0) {
            z = bankVehicleInfo.stolen;
        }
        long j2 = j;
        return bankVehicleInfo.copy(i, str, j2, str2, z);
    }

    public final int component1() {
        return this.id;
    }

    public final String component2() {
        return this.name;
    }

    public final long component3() {
        return this.cost;
    }

    public final String component4() {
        return this.reason;
    }

    public final boolean component5() {
        return this.stolen;
    }

    public final BankVehicleInfo copy(int i, String name, long j, String reason, boolean z) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(reason, "reason");
        return new BankVehicleInfo(i, name, j, reason, z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof BankVehicleInfo) {
            BankVehicleInfo bankVehicleInfo = (BankVehicleInfo) obj;
            return this.id == bankVehicleInfo.id && Intrinsics.areEqual(this.name, bankVehicleInfo.name) && this.cost == bankVehicleInfo.cost && Intrinsics.areEqual(this.reason, bankVehicleInfo.reason) && this.stolen == bankVehicleInfo.stolen;
        }
        return false;
    }

    public int hashCode() {
        return (((((((Integer.hashCode(this.id) * 31) + this.name.hashCode()) * 31) + Long.hashCode(this.cost)) * 31) + this.reason.hashCode()) * 31) + Boolean.hashCode(this.stolen);
    }

    public String toString() {
        int i = this.id;
        String str = this.name;
        long j = this.cost;
        String str2 = this.reason;
        return "BankVehicleInfo(id=" + i + ", name=" + str + ", cost=" + j + ", reason=" + str2 + ", stolen=" + this.stolen + ")";
    }

    public BankVehicleInfo(int i, String name, long j, String reason, boolean z) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(reason, "reason");
        this.id = i;
        this.name = name;
        this.cost = j;
        this.reason = reason;
        this.stolen = z;
    }

    public /* synthetic */ BankVehicleInfo(int i, String str, long j, String str2, boolean z, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 0 : i, (i2 & 2) != 0 ? "" : str, (i2 & 4) != 0 ? 0L : j, (i2 & 8) != 0 ? "" : str2, (i2 & 16) != 0 ? false : z);
    }

    public final int getId() {
        return this.id;
    }

    public final String getName() {
        return this.name;
    }

    public final long getCost() {
        return this.cost;
    }

    public final String getReason() {
        return this.reason;
    }

    public final boolean getStolen() {
        return this.stolen;
    }
}
