package androidx.compose.material3;

import com.facebook.internal.AnalyticsEvents;
import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
/* compiled from: TimePickerDialog.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087@\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0011\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u0003HÖ\u0001R\u000e\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\u0002\n\u0000\u0088\u0001\u0002\u0092\u0001\u00020\u0003¨\u0006\u000f"}, d2 = {"Landroidx/compose/material3/TimePickerDisplayMode;", "", "value", "", "constructor-impl", "(I)I", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "equals", "", "other", "hashCode", "Companion", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
@JvmInline
/* loaded from: classes.dex */
public final class TimePickerDisplayMode {
    private final int value;
    public static final Companion Companion = new Companion(null);
    private static final int Picker = m2744constructorimpl(0);
    private static final int Input = m2744constructorimpl(1);

    /* renamed from: box-impl  reason: not valid java name */
    public static final /* synthetic */ TimePickerDisplayMode m2743boximpl(int i) {
        return new TimePickerDisplayMode(i);
    }

    /* renamed from: constructor-impl  reason: not valid java name */
    public static int m2744constructorimpl(int i) {
        return i;
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m2745equalsimpl(int i, Object obj) {
        return (obj instanceof TimePickerDisplayMode) && i == ((TimePickerDisplayMode) obj).m2749unboximpl();
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m2746equalsimpl0(int i, int i2) {
        return i == i2;
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m2747hashCodeimpl(int i) {
        return Integer.hashCode(i);
    }

    public boolean equals(Object obj) {
        return m2745equalsimpl(this.value, obj);
    }

    public int hashCode() {
        return m2747hashCodeimpl(this.value);
    }

    /* renamed from: unbox-impl  reason: not valid java name */
    public final /* synthetic */ int m2749unboximpl() {
        return this.value;
    }

    private /* synthetic */ TimePickerDisplayMode(int i) {
        this.value = i;
    }

    /* compiled from: TimePickerDialog.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0013\u0010\u0004\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\t\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\n\u0010\u0007¨\u0006\u000b"}, d2 = {"Landroidx/compose/material3/TimePickerDisplayMode$Companion;", "", "<init>", "()V", "Picker", "Landroidx/compose/material3/TimePickerDisplayMode;", "getPicker--ONbchU", "()I", "I", "Input", "getInput--ONbchU", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* renamed from: getPicker--ONbchU  reason: not valid java name */
        public final int m2751getPickerONbchU() {
            return TimePickerDisplayMode.Picker;
        }

        /* renamed from: getInput--ONbchU  reason: not valid java name */
        public final int m2750getInputONbchU() {
            return TimePickerDisplayMode.Input;
        }
    }

    public String toString() {
        return m2748toStringimpl(this.value);
    }

    /* renamed from: toString-impl  reason: not valid java name */
    public static String m2748toStringimpl(int i) {
        return m2746equalsimpl0(i, Picker) ? "Picker" : m2746equalsimpl0(i, Input) ? "Input" : AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN;
    }
}
