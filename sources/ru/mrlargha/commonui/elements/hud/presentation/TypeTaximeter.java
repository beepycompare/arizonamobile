package ru.mrlargha.commonui.elements.hud.presentation;

import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: HudConstants.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0013\b\u0086\u0081\u0002\u0018\u0000 \u00152\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0015B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014¨\u0006\u0016"}, d2 = {"Lru/mrlargha/commonui/elements/hud/presentation/TypeTaximeter;", "", "id", "", "<init>", "(Ljava/lang/String;II)V", "getId", "()I", "TAXI", "BUS", "TRUCK", "DELIVERY", "DRIFT_POINT", "HALLOWEEN", "DEMORGAN", "ARMY_SECOND", "EASTER_RELAY", "FARMER_HEALTH", "SOCCER_GOALS", "EASTER_CHICKEN", "AIRPLANE", "Companion", "CommonUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class TypeTaximeter {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ TypeTaximeter[] $VALUES;
    public static final Companion Companion;
    private final int id;
    public static final TypeTaximeter TAXI = new TypeTaximeter("TAXI", 0, 0);
    public static final TypeTaximeter BUS = new TypeTaximeter("BUS", 1, 1);
    public static final TypeTaximeter TRUCK = new TypeTaximeter("TRUCK", 2, 2);
    public static final TypeTaximeter DELIVERY = new TypeTaximeter("DELIVERY", 3, 3);
    public static final TypeTaximeter DRIFT_POINT = new TypeTaximeter("DRIFT_POINT", 4, 4);
    public static final TypeTaximeter HALLOWEEN = new TypeTaximeter("HALLOWEEN", 5, 5);
    public static final TypeTaximeter DEMORGAN = new TypeTaximeter("DEMORGAN", 6, 6);
    public static final TypeTaximeter ARMY_SECOND = new TypeTaximeter("ARMY_SECOND", 7, 7);
    public static final TypeTaximeter EASTER_RELAY = new TypeTaximeter("EASTER_RELAY", 8, 8);
    public static final TypeTaximeter FARMER_HEALTH = new TypeTaximeter("FARMER_HEALTH", 9, 9);
    public static final TypeTaximeter SOCCER_GOALS = new TypeTaximeter("SOCCER_GOALS", 10, 10);
    public static final TypeTaximeter EASTER_CHICKEN = new TypeTaximeter("EASTER_CHICKEN", 11, 11);
    public static final TypeTaximeter AIRPLANE = new TypeTaximeter("AIRPLANE", 12, 12);

    private static final /* synthetic */ TypeTaximeter[] $values() {
        return new TypeTaximeter[]{TAXI, BUS, TRUCK, DELIVERY, DRIFT_POINT, HALLOWEEN, DEMORGAN, ARMY_SECOND, EASTER_RELAY, FARMER_HEALTH, SOCCER_GOALS, EASTER_CHICKEN, AIRPLANE};
    }

    public static EnumEntries<TypeTaximeter> getEntries() {
        return $ENTRIES;
    }

    public static TypeTaximeter valueOf(String str) {
        return (TypeTaximeter) Enum.valueOf(TypeTaximeter.class, str);
    }

    public static TypeTaximeter[] values() {
        return (TypeTaximeter[]) $VALUES.clone();
    }

    private TypeTaximeter(String str, int i, int i2) {
        this.id = i2;
    }

    public final int getId() {
        return this.id;
    }

    static {
        TypeTaximeter[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
        Companion = new Companion(null);
    }

    /* compiled from: HudConstants.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lru/mrlargha/commonui/elements/hud/presentation/TypeTaximeter$Companion;", "", "<init>", "()V", "valueOf", "Lru/mrlargha/commonui/elements/hud/presentation/TypeTaximeter;", "value", "", "CommonUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final TypeTaximeter valueOf(int i) {
            for (TypeTaximeter typeTaximeter : TypeTaximeter.getEntries()) {
                if (typeTaximeter.getId() == i) {
                    return typeTaximeter;
                }
            }
            throw new NoSuchElementException("Collection contains no element matching the predicate.");
        }
    }
}
