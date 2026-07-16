package io.appmetrica.analytics.coreapi.internal.system;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u000f\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0010"}, d2 = {"Lio/appmetrica/analytics/coreapi/internal/system/NetworkType;", "", "WIFI", "CELL", "ETHERNET", "BLUETOOTH", "VPN", "LOWPAN", "WIFI_AWARE", "MOBILE_DUN", "MOBILE_HIPRI", "MOBILE_MMS", "MOBILE_SUPL", "WIMAX", "OFFLINE", "UNDEFINED", "core-api_release"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes5.dex */
public final class NetworkType {
    public static final NetworkType BLUETOOTH;
    public static final NetworkType CELL;
    public static final NetworkType ETHERNET;
    public static final NetworkType LOWPAN;
    public static final NetworkType MOBILE_DUN;
    public static final NetworkType MOBILE_HIPRI;
    public static final NetworkType MOBILE_MMS;
    public static final NetworkType MOBILE_SUPL;
    public static final NetworkType OFFLINE;
    public static final NetworkType UNDEFINED;
    public static final NetworkType VPN;
    public static final NetworkType WIFI;
    public static final NetworkType WIFI_AWARE;
    public static final NetworkType WIMAX;

    /* renamed from: a  reason: collision with root package name */
    private static final /* synthetic */ NetworkType[] f336a;
    private static final /* synthetic */ EnumEntries b;

    static {
        NetworkType networkType = new NetworkType("WIFI", 0);
        WIFI = networkType;
        NetworkType networkType2 = new NetworkType("CELL", 1);
        CELL = networkType2;
        NetworkType networkType3 = new NetworkType("ETHERNET", 2);
        ETHERNET = networkType3;
        NetworkType networkType4 = new NetworkType("BLUETOOTH", 3);
        BLUETOOTH = networkType4;
        NetworkType networkType5 = new NetworkType("VPN", 4);
        VPN = networkType5;
        NetworkType networkType6 = new NetworkType("LOWPAN", 5);
        LOWPAN = networkType6;
        NetworkType networkType7 = new NetworkType("WIFI_AWARE", 6);
        WIFI_AWARE = networkType7;
        NetworkType networkType8 = new NetworkType("MOBILE_DUN", 7);
        MOBILE_DUN = networkType8;
        NetworkType networkType9 = new NetworkType("MOBILE_HIPRI", 8);
        MOBILE_HIPRI = networkType9;
        NetworkType networkType10 = new NetworkType("MOBILE_MMS", 9);
        MOBILE_MMS = networkType10;
        NetworkType networkType11 = new NetworkType("MOBILE_SUPL", 10);
        MOBILE_SUPL = networkType11;
        NetworkType networkType12 = new NetworkType("WIMAX", 11);
        WIMAX = networkType12;
        NetworkType networkType13 = new NetworkType("OFFLINE", 12);
        OFFLINE = networkType13;
        NetworkType networkType14 = new NetworkType("UNDEFINED", 13);
        UNDEFINED = networkType14;
        NetworkType[] networkTypeArr = {networkType, networkType2, networkType3, networkType4, networkType5, networkType6, networkType7, networkType8, networkType9, networkType10, networkType11, networkType12, networkType13, networkType14};
        f336a = networkTypeArr;
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
        return (NetworkType[]) f336a.clone();
    }
}
