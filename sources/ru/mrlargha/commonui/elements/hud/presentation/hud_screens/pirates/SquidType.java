package ru.mrlargha.commonui.elements.hud.presentation.hud_screens.pirates;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: SquidHpModel.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u0000 \n2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\u000b"}, d2 = {"Lru/mrlargha/commonui/elements/hud/presentation/hud_screens/pirates/SquidType;", "", "type", "", "<init>", "(Ljava/lang/String;II)V", "getType", "()I", "SHIP", "FRANKLIN_STEIN", "Companion", "CommonUI_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class SquidType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ SquidType[] $VALUES;
    public static final Companion Companion;
    private final int type;
    public static final SquidType SHIP = new SquidType("SHIP", 0, 0);
    public static final SquidType FRANKLIN_STEIN = new SquidType("FRANKLIN_STEIN", 1, 1);

    private static final /* synthetic */ SquidType[] $values() {
        return new SquidType[]{SHIP, FRANKLIN_STEIN};
    }

    public static EnumEntries<SquidType> getEntries() {
        return $ENTRIES;
    }

    public static SquidType valueOf(String str) {
        return (SquidType) Enum.valueOf(SquidType.class, str);
    }

    public static SquidType[] values() {
        return (SquidType[]) $VALUES.clone();
    }

    private SquidType(String str, int i, int i2) {
        this.type = i2;
    }

    public final int getType() {
        return this.type;
    }

    static {
        SquidType[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
        Companion = new Companion(null);
    }

    /* compiled from: SquidHpModel.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lru/mrlargha/commonui/elements/hud/presentation/hud_screens/pirates/SquidType$Companion;", "", "<init>", "()V", "getType", "Lru/mrlargha/commonui/elements/hud/presentation/hud_screens/pirates/SquidType;", "typeInt", "", "CommonUI_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final SquidType getType(int i) {
            Object obj;
            Iterator<E> it = SquidType.getEntries().iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                if (((SquidType) obj).getType() == i) {
                    break;
                }
            }
            SquidType squidType = (SquidType) obj;
            return squidType == null ? SquidType.SHIP : squidType;
        }
    }
}
