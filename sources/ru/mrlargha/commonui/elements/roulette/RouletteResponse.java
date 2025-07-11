package ru.mrlargha.commonui.elements.roulette;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: Roulette.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\b¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\u0019\u0010\u0012\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\bHÆ\u0003J7\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u0018\b\u0002\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\bHÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR!\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\b¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001a"}, d2 = {"Lru/mrlargha/commonui/elements/roulette/RouletteResponse;", "", "name", "", "sysName", FirebaseAnalytics.Param.ITEMS, "Ljava/util/ArrayList;", "Lru/mrlargha/commonui/elements/roulette/CaseAward;", "Lkotlin/collections/ArrayList;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/ArrayList;)V", "getName", "()Ljava/lang/String;", "getSysName", "getItems", "()Ljava/util/ArrayList;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "CommonUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class RouletteResponse {
    private final ArrayList<CaseAward> items;
    private final String name;
    private final String sysName;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ RouletteResponse copy$default(RouletteResponse rouletteResponse, String str, String str2, ArrayList arrayList, int i, Object obj) {
        if ((i & 1) != 0) {
            str = rouletteResponse.name;
        }
        if ((i & 2) != 0) {
            str2 = rouletteResponse.sysName;
        }
        if ((i & 4) != 0) {
            arrayList = rouletteResponse.items;
        }
        return rouletteResponse.copy(str, str2, arrayList);
    }

    public final String component1() {
        return this.name;
    }

    public final String component2() {
        return this.sysName;
    }

    public final ArrayList<CaseAward> component3() {
        return this.items;
    }

    public final RouletteResponse copy(String name, String sysName, ArrayList<CaseAward> items) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(sysName, "sysName");
        Intrinsics.checkNotNullParameter(items, "items");
        return new RouletteResponse(name, sysName, items);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof RouletteResponse) {
            RouletteResponse rouletteResponse = (RouletteResponse) obj;
            return Intrinsics.areEqual(this.name, rouletteResponse.name) && Intrinsics.areEqual(this.sysName, rouletteResponse.sysName) && Intrinsics.areEqual(this.items, rouletteResponse.items);
        }
        return false;
    }

    public int hashCode() {
        return (((this.name.hashCode() * 31) + this.sysName.hashCode()) * 31) + this.items.hashCode();
    }

    public String toString() {
        String str = this.name;
        String str2 = this.sysName;
        return "RouletteResponse(name=" + str + ", sysName=" + str2 + ", items=" + this.items + ")";
    }

    public RouletteResponse(String name, String sysName, ArrayList<CaseAward> items) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(sysName, "sysName");
        Intrinsics.checkNotNullParameter(items, "items");
        this.name = name;
        this.sysName = sysName;
        this.items = items;
    }

    public final String getName() {
        return this.name;
    }

    public final String getSysName() {
        return this.sysName;
    }

    public final ArrayList<CaseAward> getItems() {
        return this.items;
    }
}
