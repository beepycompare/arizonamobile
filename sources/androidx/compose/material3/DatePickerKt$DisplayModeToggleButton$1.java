package androidx.compose.material3;

import androidx.compose.material3.internal.Icons;
import androidx.compose.material3.internal.Strings;
import androidx.compose.material3.internal.Strings_androidKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.vector.ImageVector;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DatePicker.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class DatePickerKt$DisplayModeToggleButton$1 implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $displayMode;
    final /* synthetic */ Modifier $modifier;
    final /* synthetic */ Function1<DisplayMode, Unit> $onDisplayModeChange;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public DatePickerKt$DisplayModeToggleButton$1(int i, Function1<? super DisplayMode, Unit> function1, Modifier modifier) {
        this.$displayMode = i;
        this.$onDisplayModeChange = function1;
        this.$modifier = modifier;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
        invoke(composer, num.intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C:DatePicker.kt#uh7d8r");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
            return;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1734512197, i, -1, "androidx.compose.material3.DisplayModeToggleButton.<anonymous> (DatePicker.kt:1408)");
        }
        if (DisplayMode.m2031equalsimpl0(this.$displayMode, DisplayMode.Companion.m2036getPickerjFl4v0())) {
            composer.startReplaceGroup(-101264927);
            ComposerKt.sourceInformation(composer, "1413@65768L46,1410@65608L42,1409@65559L270");
            ImageVector edit$material3 = Icons.Filled.INSTANCE.getEdit$material3();
            Strings.Companion companion = Strings.Companion;
            String m3088getString2EP1pXo = Strings_androidKt.m3088getString2EP1pXo(Strings.m3009constructorimpl(R.string.m3c_date_picker_switch_to_input_mode), composer, 0);
            ComposerKt.sourceInformationMarkerStart(composer, -418906843, "CC(remember):DatePicker.kt#9igjgp");
            boolean changed = composer.changed(this.$onDisplayModeChange);
            final Function1<DisplayMode, Unit> function1 = this.$onDisplayModeChange;
            Object rememberedValue = composer.rememberedValue();
            if (changed || rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new Function0() { // from class: androidx.compose.material3.DatePickerKt$DisplayModeToggleButton$1$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return DatePickerKt$DisplayModeToggleButton$1.invoke$lambda$1$lambda$0(Function1.this);
                    }
                };
                composer.updateRememberedValue(rememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            DatePickerKt.IconButtonWithTooltip((Function0) rememberedValue, edit$material3, m3088getString2EP1pXo, this.$modifier, false, composer, 0, 16);
            composer.endReplaceGroup();
        } else {
            composer.startReplaceGroup(-100967048);
            ComposerKt.sourceInformation(composer, "1420@66074L49,1417@65908L43,1416@65859L279");
            ImageVector dateRange$material3 = Icons.Filled.INSTANCE.getDateRange$material3();
            Strings.Companion companion2 = Strings.Companion;
            String m3088getString2EP1pXo2 = Strings_androidKt.m3088getString2EP1pXo(Strings.m3009constructorimpl(R.string.m3c_date_picker_switch_to_calendar_mode), composer, 0);
            ComposerKt.sourceInformationMarkerStart(composer, -418897242, "CC(remember):DatePicker.kt#9igjgp");
            boolean changed2 = composer.changed(this.$onDisplayModeChange);
            final Function1<DisplayMode, Unit> function12 = this.$onDisplayModeChange;
            Object rememberedValue2 = composer.rememberedValue();
            if (changed2 || rememberedValue2 == Composer.Companion.getEmpty()) {
                rememberedValue2 = new Function0() { // from class: androidx.compose.material3.DatePickerKt$DisplayModeToggleButton$1$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return DatePickerKt$DisplayModeToggleButton$1.invoke$lambda$3$lambda$2(Function1.this);
                    }
                };
                composer.updateRememberedValue(rememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            DatePickerKt.IconButtonWithTooltip((Function0) rememberedValue2, dateRange$material3, m3088getString2EP1pXo2, this.$modifier, false, composer, 0, 16);
            composer.endReplaceGroup();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit invoke$lambda$1$lambda$0(Function1 function1) {
        function1.invoke(DisplayMode.m2028boximpl(DisplayMode.Companion.m2035getInputjFl4v0()));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit invoke$lambda$3$lambda$2(Function1 function1) {
        function1.invoke(DisplayMode.m2028boximpl(DisplayMode.Companion.m2036getPickerjFl4v0()));
        return Unit.INSTANCE;
    }
}
