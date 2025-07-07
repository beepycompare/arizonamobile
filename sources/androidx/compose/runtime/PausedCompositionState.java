package androidx.compose.runtime;

import com.facebook.internal.AnalyticsEvents;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: PausableComposition.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Landroidx/compose/runtime/PausedCompositionState;", "", "(Ljava/lang/String;I)V", "Invalid", AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_CANCELLED, "InitialPending", "RecomposePending", "ApplyPending", "Applied", "runtime_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
public final class PausedCompositionState {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ PausedCompositionState[] $VALUES;
    public static final PausedCompositionState Invalid = new PausedCompositionState("Invalid", 0);
    public static final PausedCompositionState Cancelled = new PausedCompositionState(AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_CANCELLED, 1);
    public static final PausedCompositionState InitialPending = new PausedCompositionState("InitialPending", 2);
    public static final PausedCompositionState RecomposePending = new PausedCompositionState("RecomposePending", 3);
    public static final PausedCompositionState ApplyPending = new PausedCompositionState("ApplyPending", 4);
    public static final PausedCompositionState Applied = new PausedCompositionState("Applied", 5);

    private static final /* synthetic */ PausedCompositionState[] $values() {
        return new PausedCompositionState[]{Invalid, Cancelled, InitialPending, RecomposePending, ApplyPending, Applied};
    }

    public static EnumEntries<PausedCompositionState> getEntries() {
        return $ENTRIES;
    }

    public static PausedCompositionState valueOf(String str) {
        return (PausedCompositionState) Enum.valueOf(PausedCompositionState.class, str);
    }

    public static PausedCompositionState[] values() {
        return (PausedCompositionState[]) $VALUES.clone();
    }

    private PausedCompositionState(String str, int i) {
    }

    static {
        PausedCompositionState[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }
}
