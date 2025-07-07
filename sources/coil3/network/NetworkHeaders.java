package coil3.network;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: NetworkHeaders.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010 \n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u0000 \u00152\u00020\u0001:\u0002\u0014\u0015B#\b\u0002\u0012\u0018\u0010\u0002\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00050\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0013\u0010\b\u001a\u0004\u0018\u00010\u00042\u0006\u0010\t\u001a\u00020\u0004H\u0086\u0002J\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00040\u00052\u0006\u0010\t\u001a\u00020\u0004J\u0018\u0010\u000b\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00050\u0003J\u0006\u0010\f\u001a\u00020\rJ\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0004H\u0016R \u0010\u0002\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00050\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcoil3/network/NetworkHeaders;", "", "data", "", "", "", "<init>", "(Ljava/util/Map;)V", "get", "key", "getAll", "asMap", "newBuilder", "Lcoil3/network/NetworkHeaders$Builder;", "equals", "", "other", "hashCode", "", "toString", "Builder", "Companion", "coil-network-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class NetworkHeaders {
    public static final Companion Companion = new Companion(null);
    public static final NetworkHeaders EMPTY = new Builder().build();
    private final Map<String, List<String>> data;

    public /* synthetic */ NetworkHeaders(Map map, DefaultConstructorMarker defaultConstructorMarker) {
        this(map);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof NetworkHeaders) && Intrinsics.areEqual(this.data, ((NetworkHeaders) obj).data);
    }

    public int hashCode() {
        return this.data.hashCode();
    }

    public String toString() {
        return "NetworkHeaders(data=" + this.data + ')';
    }

    /* JADX WARN: Multi-variable type inference failed */
    private NetworkHeaders(Map<String, ? extends List<String>> map) {
        this.data = map;
    }

    public final String get(String str) {
        Map<String, List<String>> map = this.data;
        String lowerCase = str.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        List<String> list = map.get(lowerCase);
        if (list != null) {
            return (String) CollectionsKt.lastOrNull((List<? extends Object>) list);
        }
        return null;
    }

    public final List<String> getAll(String str) {
        Map<String, List<String>> map = this.data;
        String lowerCase = str.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        List<String> list = map.get(lowerCase);
        return list == null ? CollectionsKt.emptyList() : list;
    }

    public final Map<String, List<String>> asMap() {
        return this.data;
    }

    public final Builder newBuilder() {
        return new Builder(this);
    }

    /* compiled from: NetworkHeaders.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010!\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0016¢\u0006\u0004\b\u0002\u0010\u0003B\u0011\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0002\u0010\u0006J\u0019\u0010\u000b\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\tH\u0086\u0002J\u001f\u0010\u000b\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\t2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\t0\u000fH\u0086\u0002J\u0016\u0010\u0010\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\tJ\u0006\u0010\u0011\u001a\u00020\u0005R \u0010\u0007\u001a\u0014\u0012\u0004\u0012\u00020\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\n0\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcoil3/network/NetworkHeaders$Builder;", "", "<init>", "()V", "headers", "Lcoil3/network/NetworkHeaders;", "(Lcoil3/network/NetworkHeaders;)V", "data", "", "", "", "set", "key", "value", "values", "", "add", "build", "coil-network-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Builder {
        private final Map<String, List<String>> data;

        public Builder() {
            this.data = new LinkedHashMap();
        }

        public Builder(NetworkHeaders networkHeaders) {
            Map map = networkHeaders.data;
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Map.Entry entry : map.entrySet()) {
                linkedHashMap.put(entry.getKey(), CollectionsKt.toMutableList((Collection) entry.getValue()));
            }
            this.data = linkedHashMap;
        }

        public final Builder set(String str, String str2) {
            Map<String, List<String>> map = this.data;
            String lowerCase = str.toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            map.put(lowerCase, CollectionsKt.mutableListOf(str2));
            return this;
        }

        public final Builder set(String str, List<String> list) {
            Map<String, List<String>> map = this.data;
            String lowerCase = str.toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            map.put(lowerCase, CollectionsKt.toMutableList((Collection) list));
            return this;
        }

        public final Builder add(String str, String str2) {
            Map<String, List<String>> map = this.data;
            String lowerCase = str.toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            ArrayList arrayList = map.get(lowerCase);
            if (arrayList == null) {
                arrayList = new ArrayList();
                map.put(lowerCase, arrayList);
            }
            arrayList.add(str2);
            return this;
        }

        public final NetworkHeaders build() {
            return new NetworkHeaders(MapsKt.toMap(this.data), null);
        }
    }

    /* compiled from: NetworkHeaders.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0010\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcoil3/network/NetworkHeaders$Companion;", "", "<init>", "()V", "EMPTY", "Lcoil3/network/NetworkHeaders;", "coil-network-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
