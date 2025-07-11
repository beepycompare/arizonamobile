package ru.mrlargha.commonui.elements.hud.presentation.api.obj;

import com.google.android.gms.actions.SearchIntents;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: HudApiRequest.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\u0018\b\u0002\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0019\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005HÆ\u0003J#\u0010\f\u001a\u00020\u00002\u0018\b\u0002\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R.\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u0007¨\u0006\u0014"}, d2 = {"Lru/mrlargha/commonui/elements/hud/presentation/api/obj/HudApiRequest;", "", SearchIntents.EXTRA_QUERY, "Ljava/util/ArrayList;", "Lru/mrlargha/commonui/elements/hud/presentation/api/obj/Query;", "Lkotlin/collections/ArrayList;", "<init>", "(Ljava/util/ArrayList;)V", "getQuery", "()Ljava/util/ArrayList;", "setQuery", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "CommonUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class HudApiRequest {
    @SerializedName(SearchIntents.EXTRA_QUERY)
    private ArrayList<Query> query;

    public HudApiRequest() {
        this(null, 1, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ HudApiRequest copy$default(HudApiRequest hudApiRequest, ArrayList arrayList, int i, Object obj) {
        if ((i & 1) != 0) {
            arrayList = hudApiRequest.query;
        }
        return hudApiRequest.copy(arrayList);
    }

    public final ArrayList<Query> component1() {
        return this.query;
    }

    public final HudApiRequest copy(ArrayList<Query> query) {
        Intrinsics.checkNotNullParameter(query, "query");
        return new HudApiRequest(query);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof HudApiRequest) && Intrinsics.areEqual(this.query, ((HudApiRequest) obj).query);
    }

    public int hashCode() {
        return this.query.hashCode();
    }

    public String toString() {
        return "HudApiRequest(query=" + this.query + ")";
    }

    public HudApiRequest(ArrayList<Query> query) {
        Intrinsics.checkNotNullParameter(query, "query");
        this.query = query;
    }

    public /* synthetic */ HudApiRequest(ArrayList arrayList, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new ArrayList() : arrayList);
    }

    public final ArrayList<Query> getQuery() {
        return this.query;
    }

    public final void setQuery(ArrayList<Query> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
        this.query = arrayList;
    }
}
