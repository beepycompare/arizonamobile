package io.appmetrica.analytics.idsync.internal.model;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lio/appmetrica/analytics/idsync/internal/model/NetworkType;", "", "ANY", "CELL", "id-sync_release"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes5.dex */
public final class NetworkType {
    public static final NetworkType ANY;
    public static final NetworkType CELL;

    /* renamed from: a  reason: collision with root package name */
    private static final /* synthetic */ NetworkType[] f442a;
    private static final /* synthetic */ EnumEntries b;

    static {
        NetworkType networkType = new NetworkType("ANY", 0);
        ANY = networkType;
        NetworkType networkType2 = new NetworkType("CELL", 1);
        CELL = networkType2;
        NetworkType[] networkTypeArr = {networkType, networkType2};
        f442a = networkTypeArr;
        b = EnumEntriesKt.enumEntries(networkTypeArr);
    }

    private NetworkType(String str, int i) {
    }

    public static EnumEntries<NetworkType> getEntries() {
        return b;
    }

    public static NetworkType valueOf(String str) {
        return (NetworkType) Enum.valueOf(NetworkType.class, str);
    }

    public static NetworkType[] values() {
        return (NetworkType[]) f442a.clone();
    }
}
