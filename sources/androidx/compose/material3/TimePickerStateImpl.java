package androidx.compose.material3;

import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotIntStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.runtime.saveable.SaverKt;
import androidx.compose.runtime.saveable.SaverScope;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: TimePicker.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u0000 %2\u00020\u0001:\u0001%B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007R$\u0010\t\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u00038V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0006X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R+\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u00068V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u0017\u0010\u0013\"\u0004\b\u0018\u0010\u0015R$\u0010\u001b\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u00038V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u001c\u0010\u000b\"\u0004\b\u001d\u0010\rR\u0011\u0010\u001e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0011R1\u0010!\u001a\u00020 2\u0006\u0010\u0016\u001a\u00020 8V@VX\u0096\u008e\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0012\n\u0004\b$\u0010\u001a\u001a\u0004\b\"\u0010\u000b\"\u0004\b#\u0010\r\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006&"}, d2 = {"Landroidx/compose/material3/TimePickerStateImpl;", "Landroidx/compose/material3/TimePickerState;", "initialHour", "", "initialMinute", "is24Hour", "", "(IIZ)V", "value", "hour", "getHour", "()I", "setHour", "(I)V", "hourState", "Landroidx/compose/runtime/MutableIntState;", "getHourState", "()Landroidx/compose/runtime/MutableIntState;", "is24hour", "()Z", "set24hour", "(Z)V", "<set-?>", "isAfternoon", "setAfternoon", "isAfternoon$delegate", "Landroidx/compose/runtime/MutableState;", "minute", "getMinute", "setMinute", "minuteState", "getMinuteState", "Landroidx/compose/material3/TimePickerSelectionMode;", "selection", "getSelection-yecRtBI", "setSelection-6_8s6DQ", "selection$delegate", "Companion", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
final class TimePickerStateImpl implements TimePickerState {
    public static final Companion Companion = new Companion(null);
    private final MutableIntState hourState;
    private boolean is24hour;
    private final MutableState isAfternoon$delegate;
    private final MutableIntState minuteState;
    private final MutableState selection$delegate;

    public TimePickerStateImpl(int i, int i2, boolean z) {
        MutableState mutableStateOf$default;
        MutableState mutableStateOf$default2;
        if (i < 0 || i >= 24) {
            throw new IllegalArgumentException("initialHour should in [0..23] range".toString());
        }
        if (i2 < 0 || i2 >= 60) {
            throw new IllegalArgumentException("initialMinute should be in [0..59] range".toString());
        }
        this.is24hour = z;
        mutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(TimePickerSelectionMode.m2548boximpl(TimePickerSelectionMode.Companion.m2555getHouryecRtBI()), null, 2, null);
        this.selection$delegate = mutableStateOf$default;
        mutableStateOf$default2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(i >= 12), null, 2, null);
        this.isAfternoon$delegate = mutableStateOf$default2;
        this.hourState = SnapshotIntStateKt.mutableIntStateOf(i % 12);
        this.minuteState = SnapshotIntStateKt.mutableIntStateOf(i2);
    }

    @Override // androidx.compose.material3.TimePickerState
    public boolean is24hour() {
        return this.is24hour;
    }

    @Override // androidx.compose.material3.TimePickerState
    public void set24hour(boolean z) {
        this.is24hour = z;
    }

    @Override // androidx.compose.material3.TimePickerState
    /* renamed from: getSelection-yecRtBI */
    public int mo1562getSelectionyecRtBI() {
        return ((TimePickerSelectionMode) this.selection$delegate.getValue()).m2554unboximpl();
    }

    @Override // androidx.compose.material3.TimePickerState
    /* renamed from: setSelection-6_8s6DQ */
    public void mo1563setSelection6_8s6DQ(int i) {
        this.selection$delegate.setValue(TimePickerSelectionMode.m2548boximpl(i));
    }

    @Override // androidx.compose.material3.TimePickerState
    public boolean isAfternoon() {
        return ((Boolean) this.isAfternoon$delegate.getValue()).booleanValue();
    }

    @Override // androidx.compose.material3.TimePickerState
    public void setAfternoon(boolean z) {
        this.isAfternoon$delegate.setValue(Boolean.valueOf(z));
    }

    public final MutableIntState getHourState() {
        return this.hourState;
    }

    public final MutableIntState getMinuteState() {
        return this.minuteState;
    }

    @Override // androidx.compose.material3.TimePickerState
    public int getMinute() {
        return this.minuteState.getIntValue();
    }

    @Override // androidx.compose.material3.TimePickerState
    public void setMinute(int i) {
        this.minuteState.setIntValue(i);
    }

    @Override // androidx.compose.material3.TimePickerState
    public int getHour() {
        return this.hourState.getIntValue() + (isAfternoon() ? 12 : 0);
    }

    @Override // androidx.compose.material3.TimePickerState
    public void setHour(int i) {
        setAfternoon(i >= 12);
        this.hourState.setIntValue(i % 12);
    }

    /* compiled from: TimePicker.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\f\u0012\u0004\u0012\u00020\u0005\u0012\u0002\b\u00030\u0004¨\u0006\u0006"}, d2 = {"Landroidx/compose/material3/TimePickerStateImpl$Companion;", "", "()V", "Saver", "Landroidx/compose/runtime/saveable/Saver;", "Landroidx/compose/material3/TimePickerStateImpl;", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Saver<TimePickerStateImpl, ?> Saver() {
            return SaverKt.Saver(new Function2<SaverScope, TimePickerStateImpl, List<? extends Object>>() { // from class: androidx.compose.material3.TimePickerStateImpl$Companion$Saver$1
                @Override // kotlin.jvm.functions.Function2
                public final List<Object> invoke(SaverScope saverScope, TimePickerStateImpl timePickerStateImpl) {
                    return CollectionsKt.listOf(Integer.valueOf(timePickerStateImpl.getHour()), Integer.valueOf(timePickerStateImpl.getMinute()), Boolean.valueOf(timePickerStateImpl.is24hour()));
                }
            }, new Function1<List, TimePickerStateImpl>() { // from class: androidx.compose.material3.TimePickerStateImpl$Companion$Saver$2
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ TimePickerStateImpl invoke(List list) {
                    return invoke2((List<? extends Object>) list);
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final TimePickerStateImpl invoke2(List<? extends Object> list) {
                    Object obj = list.get(0);
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
                    int intValue = ((Integer) obj).intValue();
                    Object obj2 = list.get(1);
                    Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.Int");
                    int intValue2 = ((Integer) obj2).intValue();
                    Object obj3 = list.get(2);
                    Intrinsics.checkNotNull(obj3, "null cannot be cast to non-null type kotlin.Boolean");
                    return new TimePickerStateImpl(intValue, intValue2, ((Boolean) obj3).booleanValue());
                }
            });
        }
    }
}
