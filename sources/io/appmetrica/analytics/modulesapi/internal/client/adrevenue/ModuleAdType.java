package io.appmetrica.analytics.modulesapi.internal.client.adrevenue;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lio/appmetrica/analytics/modulesapi/internal/client/adrevenue/ModuleAdType;", "", "NATIVE", "BANNER", "REWARDED", "INTERSTITIAL", "MREC", "APP_OPEN", "OTHER", "modules-api_release"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes5.dex */
public final class ModuleAdType {
    public static final ModuleAdType APP_OPEN;
    public static final ModuleAdType BANNER;
    public static final ModuleAdType INTERSTITIAL;
    public static final ModuleAdType MREC;
    public static final ModuleAdType NATIVE;
    public static final ModuleAdType OTHER;
    public static final ModuleAdType REWARDED;

    /* renamed from: a  reason: collision with root package name */
    private static final /* synthetic */ ModuleAdType[] f1356a;
    private static final /* synthetic */ EnumEntries b;

    static {
        ModuleAdType moduleAdType = new ModuleAdType("NATIVE", 0);
        NATIVE = moduleAdType;
        ModuleAdType moduleAdType2 = new ModuleAdType("BANNER", 1);
        BANNER = moduleAdType2;
        ModuleAdType moduleAdType3 = new ModuleAdType("REWARDED", 2);
        REWARDED = moduleAdType3;
        ModuleAdType moduleAdType4 = new ModuleAdType("INTERSTITIAL", 3);
        INTERSTITIAL = moduleAdType4;
        ModuleAdType moduleAdType5 = new ModuleAdType("MREC", 4);
        MREC = moduleAdType5;
        ModuleAdType moduleAdType6 = new ModuleAdType("APP_OPEN", 5);
        APP_OPEN = moduleAdType6;
        ModuleAdType moduleAdType7 = new ModuleAdType("OTHER", 6);
        OTHER = moduleAdType7;
        ModuleAdType[] moduleAdTypeArr = {moduleAdType, moduleAdType2, moduleAdType3, moduleAdType4, moduleAdType5, moduleAdType6, moduleAdType7};
        f1356a = moduleAdTypeArr;
        b = EnumEntriesKt.enumEntries(moduleAdTypeArr);
    }

    private ModuleAdType(String str, int i) {
    }

    public static EnumEntries<ModuleAdType> getEntries() {
        return b;
    }

    public static ModuleAdType valueOf(String str) {
        return (ModuleAdType) Enum.valueOf(ModuleAdType.class, str);
    }

    public static ModuleAdType[] values() {
        return (ModuleAdType[]) f1356a.clone();
    }
}
