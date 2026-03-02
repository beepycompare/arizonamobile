package androidx.compose.material3;

import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
/* compiled from: DateRangePicker.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
final class DateRangePickerKt$DateRangePicker$5 implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ DatePickerColors $colors;
    final /* synthetic */ DateRangePickerState $state;

    /* JADX INFO: Access modifiers changed from: package-private */
    public DateRangePickerKt$DateRangePicker$5(DateRangePickerState dateRangePickerState, DatePickerColors datePickerColors) {
        this.$state = dateRangePickerState;
        this.$colors = datePickerColors;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
        invoke(composer, num.intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C142@6483L50,139@6273L324:DateRangePicker.kt#uh7d8r");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
            return;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1343236786, i, -1, "androidx.compose.material3.DateRangePicker.<anonymous> (DateRangePicker.kt:139)");
        }
        Modifier padding = PaddingKt.padding(Modifier.Companion, DatePickerKt.getDatePickerModeTogglePadding());
        int mo2014getDisplayModejFl4v0 = this.$state.mo2014getDisplayModejFl4v0();
        ComposerKt.sourceInformationMarkerStart(composer, -1934597276, "CC(remember):DateRangePicker.kt#9igjgp");
        boolean changed = composer.changed(this.$state);
        final DateRangePickerState dateRangePickerState = this.$state;
        Object rememberedValue = composer.rememberedValue();
        if (changed || rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = new Function1() { // from class: androidx.compose.material3.DateRangePickerKt$DateRangePicker$5$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return DateRangePickerKt$DateRangePicker$5.invoke$lambda$1$lambda$0(DateRangePickerState.this, (DisplayMode) obj);
                }
            };
            composer.updateRememberedValue(rememberedValue);
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        DatePickerKt.m1991DisplayModeToggleButtoniUJLfQg(padding, mo2014getDisplayModejFl4v0, (Function1) rememberedValue, this.$colors, composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit invoke$lambda$1$lambda$0(DateRangePickerState dateRangePickerState, DisplayMode displayMode) {
        dateRangePickerState.mo2015setDisplayModevCnGnXg(displayMode.m2034unboximpl());
        return Unit.INSTANCE;
    }
}
