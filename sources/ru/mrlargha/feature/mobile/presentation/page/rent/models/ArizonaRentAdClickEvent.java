package ru.mrlargha.feature.mobile.presentation.page.rent.models;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: ArizonaRentAdModel.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lru/mrlargha/feature/mobile/presentation/page/rent/models/ArizonaRentAdClickEvent;", "", "<init>", "(Ljava/lang/String;I)V", "RENT", "DELETE", "RAISE", "mobile"}, k = 1, mv = {2, 3, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class ArizonaRentAdClickEvent {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ ArizonaRentAdClickEvent[] $VALUES;
    public static final ArizonaRentAdClickEvent RENT = new ArizonaRentAdClickEvent("RENT", 0);
    public static final ArizonaRentAdClickEvent DELETE = new ArizonaRentAdClickEvent("DELETE", 1);
    public static final ArizonaRentAdClickEvent RAISE = new ArizonaRentAdClickEvent("RAISE", 2);

    private static final /* synthetic */ ArizonaRentAdClickEvent[] $values() {
        return new ArizonaRentAdClickEvent[]{RENT, DELETE, RAISE};
    }

    public static EnumEntries<ArizonaRentAdClickEvent> getEntries() {
        return $ENTRIES;
    }

    public static ArizonaRentAdClickEvent valueOf(String str) {
        return (ArizonaRentAdClickEvent) Enum.valueOf(ArizonaRentAdClickEvent.class, str);
    }

    public static ArizonaRentAdClickEvent[] values() {
        return (ArizonaRentAdClickEvent[]) $VALUES.clone();
    }

    private ArizonaRentAdClickEvent(String str, int i) {
    }

    static {
        ArizonaRentAdClickEvent[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }
}
