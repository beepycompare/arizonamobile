package coil3.size;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: Scale.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcoil3/size/Scale;", "", "<init>", "(Ljava/lang/String;I)V", "FILL", "FIT", "coil-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class Scale {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ Scale[] $VALUES;
    public static final Scale FILL = new Scale("FILL", 0);
    public static final Scale FIT = new Scale("FIT", 1);

    private static final /* synthetic */ Scale[] $values() {
        return new Scale[]{FILL, FIT};
    }

    public static EnumEntries<Scale> getEntries() {
        return $ENTRIES;
    }

    private Scale(String str, int i) {
    }

    static {
        Scale[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }

    public static Scale valueOf(String str) {
        return (Scale) Enum.valueOf(Scale.class, str);
    }

    public static Scale[] values() {
        return (Scale[]) $VALUES.clone();
    }
}
