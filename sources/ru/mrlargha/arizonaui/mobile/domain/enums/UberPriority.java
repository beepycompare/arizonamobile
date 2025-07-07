package ru.mrlargha.arizonaui.mobile.domain.enums;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.RangesKt;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: UberPriority.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000bB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\f"}, d2 = {"Lru/mrlargha/arizonaui/mobile/domain/enums/UberPriority;", "", "id", "", "<init>", "(Ljava/lang/String;II)V", "getId", "()I", "ECONOMY", "COMFORT", "BUSINESS", "Companion", "ArizonaUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class UberPriority {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ UberPriority[] $VALUES;
    public static final Companion Companion;
    private static final Map<Integer, UberPriority> map;
    private final int id;
    public static final UberPriority ECONOMY = new UberPriority("ECONOMY", 0, 0);
    public static final UberPriority COMFORT = new UberPriority("COMFORT", 1, 1);
    public static final UberPriority BUSINESS = new UberPriority("BUSINESS", 2, 2);

    private static final /* synthetic */ UberPriority[] $values() {
        return new UberPriority[]{ECONOMY, COMFORT, BUSINESS};
    }

    public static EnumEntries<UberPriority> getEntries() {
        return $ENTRIES;
    }

    private UberPriority(String str, int i, int i2) {
        this.id = i2;
    }

    public final int getId() {
        return this.id;
    }

    static {
        UberPriority[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
        Companion = new Companion(null);
        UberPriority[] values = values();
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(values.length), 16));
        for (UberPriority uberPriority : values) {
            linkedHashMap.put(Integer.valueOf(uberPriority.id), uberPriority);
        }
        map = linkedHashMap;
    }

    /* compiled from: UberPriority.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\t\u001a\u00020\u0006R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lru/mrlargha/arizonaui/mobile/domain/enums/UberPriority$Companion;", "", "<init>", "()V", "map", "", "", "Lru/mrlargha/arizonaui/mobile/domain/enums/UberPriority;", "fromInt", "type", "ArizonaUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final UberPriority fromInt(int i) {
            return (UberPriority) UberPriority.map.get(Integer.valueOf(i));
        }
    }

    public static UberPriority valueOf(String str) {
        return (UberPriority) Enum.valueOf(UberPriority.class, str);
    }

    public static UberPriority[] values() {
        return (UberPriority[]) $VALUES.clone();
    }
}
