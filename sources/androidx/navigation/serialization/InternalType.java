package androidx.navigation.serialization;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: NavTypeConverter.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0019\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019¨\u0006\u001a"}, d2 = {"Landroidx/navigation/serialization/InternalType;", "", "<init>", "(Ljava/lang/String;I)V", "INT", "INT_NULLABLE", "BOOL", "BOOL_NULLABLE", "DOUBLE", "DOUBLE_NULLABLE", "FLOAT", "FLOAT_NULLABLE", "LONG", "LONG_NULLABLE", "STRING", "STRING_NULLABLE", "INT_ARRAY", "BOOL_ARRAY", "DOUBLE_ARRAY", "FLOAT_ARRAY", "LONG_ARRAY", "ARRAY", "LIST", "ENUM", "ENUM_NULLABLE", "UNKNOWN", "navigation-common_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
final class InternalType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ InternalType[] $VALUES;
    public static final InternalType INT = new InternalType("INT", 0);
    public static final InternalType INT_NULLABLE = new InternalType("INT_NULLABLE", 1);
    public static final InternalType BOOL = new InternalType("BOOL", 2);
    public static final InternalType BOOL_NULLABLE = new InternalType("BOOL_NULLABLE", 3);
    public static final InternalType DOUBLE = new InternalType("DOUBLE", 4);
    public static final InternalType DOUBLE_NULLABLE = new InternalType("DOUBLE_NULLABLE", 5);
    public static final InternalType FLOAT = new InternalType("FLOAT", 6);
    public static final InternalType FLOAT_NULLABLE = new InternalType("FLOAT_NULLABLE", 7);
    public static final InternalType LONG = new InternalType("LONG", 8);
    public static final InternalType LONG_NULLABLE = new InternalType("LONG_NULLABLE", 9);
    public static final InternalType STRING = new InternalType("STRING", 10);
    public static final InternalType STRING_NULLABLE = new InternalType("STRING_NULLABLE", 11);
    public static final InternalType INT_ARRAY = new InternalType("INT_ARRAY", 12);
    public static final InternalType BOOL_ARRAY = new InternalType("BOOL_ARRAY", 13);
    public static final InternalType DOUBLE_ARRAY = new InternalType("DOUBLE_ARRAY", 14);
    public static final InternalType FLOAT_ARRAY = new InternalType("FLOAT_ARRAY", 15);
    public static final InternalType LONG_ARRAY = new InternalType("LONG_ARRAY", 16);
    public static final InternalType ARRAY = new InternalType("ARRAY", 17);
    public static final InternalType LIST = new InternalType("LIST", 18);
    public static final InternalType ENUM = new InternalType("ENUM", 19);
    public static final InternalType ENUM_NULLABLE = new InternalType("ENUM_NULLABLE", 20);
    public static final InternalType UNKNOWN = new InternalType("UNKNOWN", 21);

    private static final /* synthetic */ InternalType[] $values() {
        return new InternalType[]{INT, INT_NULLABLE, BOOL, BOOL_NULLABLE, DOUBLE, DOUBLE_NULLABLE, FLOAT, FLOAT_NULLABLE, LONG, LONG_NULLABLE, STRING, STRING_NULLABLE, INT_ARRAY, BOOL_ARRAY, DOUBLE_ARRAY, FLOAT_ARRAY, LONG_ARRAY, ARRAY, LIST, ENUM, ENUM_NULLABLE, UNKNOWN};
    }

    public static EnumEntries<InternalType> getEntries() {
        return $ENTRIES;
    }

    private InternalType(String str, int i) {
    }

    static {
        InternalType[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }

    public static InternalType valueOf(String str) {
        return (InternalType) Enum.valueOf(InternalType.class, str);
    }

    public static InternalType[] values() {
        return (InternalType[]) $VALUES.clone();
    }
}
