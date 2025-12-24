package ru.mrlargha.commonui.elements.hud.presentation;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: HudConstants.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b+\b\u0086\u0081\u0002\u0018\u0000 -2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001-B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b j\u0002\b!j\u0002\b\"j\u0002\b#j\u0002\b$j\u0002\b%j\u0002\b&j\u0002\b'j\u0002\b(j\u0002\b)j\u0002\b*j\u0002\b+j\u0002\b,¨\u0006."}, d2 = {"Lru/mrlargha/commonui/elements/hud/presentation/TypeTaximeter;", "", "id", "", "<init>", "(Ljava/lang/String;II)V", "getId", "()I", "TAXI", "BUS", "TRUCK", "DELIVERY", "DRIFT_POINT", "HALLOWEEN", "DEMORGAN", "ARMY_SECOND", "EASTER_RELAY", "FARMER_HEALTH", "SOCCER_GOALS", "EASTER_CHICKEN", "AIRPLANE", "RECORDING", "INTERCEPTION_DATA", "KILLING_ALIENS", "SPACE_RACE_1", "SPACE_RACE_2", "HEIGHT", "NOISE_LEVEL", "ACCUMULATED_ENERGY", "DISTANCE_TO_HOME", "BUS_CONDITION", "KILLED_ZOMBIES", "ZOMBIE_MODE", "HALLOWEENS_COINS", "LORD_RINGS", "GHOSTS", "FRANCLIN_STEIN", "CONDITION_SLED", "BROKING_ICE", "DELIVERY_GIFTS", "NEW_YEAR_TAXI", "SEARCH_CRYSTALS", "ROLLING_SNOWBALL", "CONDITION_PACKAGE", "BASE_JUMPING", "Companion", "CommonUI_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes6.dex */
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
    public static final TypeTaximeter RECORDING = new TypeTaximeter("RECORDING", 13, 13);
    public static final TypeTaximeter INTERCEPTION_DATA = new TypeTaximeter("INTERCEPTION_DATA", 14, 14);
    public static final TypeTaximeter KILLING_ALIENS = new TypeTaximeter("KILLING_ALIENS", 15, 15);
    public static final TypeTaximeter SPACE_RACE_1 = new TypeTaximeter("SPACE_RACE_1", 16, 16);
    public static final TypeTaximeter SPACE_RACE_2 = new TypeTaximeter("SPACE_RACE_2", 17, 17);
    public static final TypeTaximeter HEIGHT = new TypeTaximeter("HEIGHT", 18, 18);
    public static final TypeTaximeter NOISE_LEVEL = new TypeTaximeter("NOISE_LEVEL", 19, 19);
    public static final TypeTaximeter ACCUMULATED_ENERGY = new TypeTaximeter("ACCUMULATED_ENERGY", 20, 20);
    public static final TypeTaximeter DISTANCE_TO_HOME = new TypeTaximeter("DISTANCE_TO_HOME", 21, 21);
    public static final TypeTaximeter BUS_CONDITION = new TypeTaximeter("BUS_CONDITION", 22, 22);
    public static final TypeTaximeter KILLED_ZOMBIES = new TypeTaximeter("KILLED_ZOMBIES", 23, 23);
    public static final TypeTaximeter ZOMBIE_MODE = new TypeTaximeter("ZOMBIE_MODE", 24, 24);
    public static final TypeTaximeter HALLOWEENS_COINS = new TypeTaximeter("HALLOWEENS_COINS", 25, 25);
    public static final TypeTaximeter LORD_RINGS = new TypeTaximeter("LORD_RINGS", 26, 26);
    public static final TypeTaximeter GHOSTS = new TypeTaximeter("GHOSTS", 27, 27);
    public static final TypeTaximeter FRANCLIN_STEIN = new TypeTaximeter("FRANCLIN_STEIN", 28, 28);
    public static final TypeTaximeter CONDITION_SLED = new TypeTaximeter("CONDITION_SLED", 29, 30);
    public static final TypeTaximeter BROKING_ICE = new TypeTaximeter("BROKING_ICE", 30, 31);
    public static final TypeTaximeter DELIVERY_GIFTS = new TypeTaximeter("DELIVERY_GIFTS", 31, 32);
    public static final TypeTaximeter NEW_YEAR_TAXI = new TypeTaximeter("NEW_YEAR_TAXI", 32, 33);
    public static final TypeTaximeter SEARCH_CRYSTALS = new TypeTaximeter("SEARCH_CRYSTALS", 33, 34);
    public static final TypeTaximeter ROLLING_SNOWBALL = new TypeTaximeter("ROLLING_SNOWBALL", 34, 35);
    public static final TypeTaximeter CONDITION_PACKAGE = new TypeTaximeter("CONDITION_PACKAGE", 35, 36);
    public static final TypeTaximeter BASE_JUMPING = new TypeTaximeter("BASE_JUMPING", 36, 37);

    private static final /* synthetic */ TypeTaximeter[] $values() {
        return new TypeTaximeter[]{TAXI, BUS, TRUCK, DELIVERY, DRIFT_POINT, HALLOWEEN, DEMORGAN, ARMY_SECOND, EASTER_RELAY, FARMER_HEALTH, SOCCER_GOALS, EASTER_CHICKEN, AIRPLANE, RECORDING, INTERCEPTION_DATA, KILLING_ALIENS, SPACE_RACE_1, SPACE_RACE_2, HEIGHT, NOISE_LEVEL, ACCUMULATED_ENERGY, DISTANCE_TO_HOME, BUS_CONDITION, KILLED_ZOMBIES, ZOMBIE_MODE, HALLOWEENS_COINS, LORD_RINGS, GHOSTS, FRANCLIN_STEIN, CONDITION_SLED, BROKING_ICE, DELIVERY_GIFTS, NEW_YEAR_TAXI, SEARCH_CRYSTALS, ROLLING_SNOWBALL, CONDITION_PACKAGE, BASE_JUMPING};
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
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lru/mrlargha/commonui/elements/hud/presentation/TypeTaximeter$Companion;", "", "<init>", "()V", "valueOf", "Lru/mrlargha/commonui/elements/hud/presentation/TypeTaximeter;", "value", "", "CommonUI_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final TypeTaximeter valueOf(int i) {
            Object obj;
            Iterator<E> it = TypeTaximeter.getEntries().iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                if (((TypeTaximeter) obj).getId() == i) {
                    break;
                }
            }
            TypeTaximeter typeTaximeter = (TypeTaximeter) obj;
            return typeTaximeter == null ? TypeTaximeter.TAXI : typeTaximeter;
        }
    }
}
