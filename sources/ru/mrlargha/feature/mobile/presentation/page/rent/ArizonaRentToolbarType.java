package ru.mrlargha.feature.mobile.presentation.page.rent;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: ArizonaRentResponse.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lru/mrlargha/feature/mobile/presentation/page/rent/ArizonaRentToolbarType;", "", "<init>", "(Ljava/lang/String;I)V", "ALL", "MY", "mobile"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class ArizonaRentToolbarType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ ArizonaRentToolbarType[] $VALUES;
    public static final ArizonaRentToolbarType ALL = new ArizonaRentToolbarType("ALL", 0);
    public static final ArizonaRentToolbarType MY = new ArizonaRentToolbarType("MY", 1);

    private static final /* synthetic */ ArizonaRentToolbarType[] $values() {
        return new ArizonaRentToolbarType[]{ALL, MY};
    }

    public static EnumEntries<ArizonaRentToolbarType> getEntries() {
        return $ENTRIES;
    }

    public static ArizonaRentToolbarType valueOf(String str) {
        return (ArizonaRentToolbarType) Enum.valueOf(ArizonaRentToolbarType.class, str);
    }

    public static ArizonaRentToolbarType[] values() {
        return (ArizonaRentToolbarType[]) $VALUES.clone();
    }

    private ArizonaRentToolbarType(String str, int i) {
    }

    static {
        ArizonaRentToolbarType[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }
}
