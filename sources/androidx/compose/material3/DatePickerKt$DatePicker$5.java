package androidx.compose.material3;

import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DatePicker.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class DatePickerKt$DatePicker$5 implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ DatePickerColors $colors;
    final /* synthetic */ DatePickerState $state;

    /* JADX INFO: Access modifiers changed from: package-private */
    public DatePickerKt$DatePicker$5(DatePickerState datePickerState, DatePickerColors datePickerColors) {
        this.$state = datePickerState;
        this.$colors = datePickerColors;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
        invoke(composer, num.intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C209@9650L50,206@9440L324:DatePicker.kt#uh7d8r");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
            return;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1483431603, i, -1, "androidx.compose.material3.DatePicker.<anonymous> (DatePicker.kt:206)");
        }
        Modifier padding = PaddingKt.padding(Modifier.Companion, DatePickerKt.getDatePickerModeTogglePadding());
        int mo1996getDisplayModejFl4v0 = this.$state.mo1996getDisplayModejFl4v0();
        ComposerKt.sourceInformationMarkerStart(composer, 351379263, "CC(remember):DatePicker.kt#9igjgp");
        boolean changed = composer.changed(this.$state);
        final DatePickerState datePickerState = this.$state;
        Object rememberedValue = composer.rememberedValue();
        if (changed || rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = new Function1() { // from class: androidx.compose.material3.DatePickerKt$DatePicker$5$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return DatePickerKt$DatePicker$5.invoke$lambda$1$lambda$0(DatePickerState.this, (DisplayMode) obj);
                }
            };
            composer.updateRememberedValue(rememberedValue);
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        DatePickerKt.m1991DisplayModeToggleButtoniUJLfQg(padding, mo1996getDisplayModejFl4v0, (Function1) rememberedValue, this.$colors, composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit invoke$lambda$1$lambda$0(DatePickerState datePickerState, DisplayMode displayMode) {
        datePickerState.mo1997setDisplayModevCnGnXg(displayMode.m2034unboximpl());
        return Unit.INSTANCE;
    }
}
