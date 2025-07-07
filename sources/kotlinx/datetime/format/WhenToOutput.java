package kotlinx.datetime.format;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: UtcOffsetFormat.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lkotlinx/datetime/format/WhenToOutput;", "", "(Ljava/lang/String;I)V", "NEVER", "IF_NONZERO", "ALWAYS", "kotlinx-datetime"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class WhenToOutput {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ WhenToOutput[] $VALUES;
    public static final WhenToOutput NEVER = new WhenToOutput("NEVER", 0);
    public static final WhenToOutput IF_NONZERO = new WhenToOutput("IF_NONZERO", 1);
    public static final WhenToOutput ALWAYS = new WhenToOutput("ALWAYS", 2);

    private static final /* synthetic */ WhenToOutput[] $values() {
        return new WhenToOutput[]{NEVER, IF_NONZERO, ALWAYS};
    }

    public static EnumEntries<WhenToOutput> getEntries() {
        return $ENTRIES;
    }

    public static WhenToOutput valueOf(String str) {
        return (WhenToOutput) Enum.valueOf(WhenToOutput.class, str);
    }

    public static WhenToOutput[] values() {
        return (WhenToOutput[]) $VALUES.clone();
    }

    private WhenToOutput(String str, int i) {
    }

    static {
        WhenToOutput[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }
}
