package androidx.compose.material3;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.material3.internal.CalendarModel;
import androidx.compose.material3.internal.DateInputFormat;
import androidx.compose.material3.internal.Strings;
import androidx.compose.material3.internal.Strings_androidKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.focus.FocusRequester;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.unit.Dp;
import androidx.media3.exoplayer.RendererCapabilities;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import okhttp3.internal.ws.WebSocketProtocol;
/* compiled from: DateRangeInput.kt */
@Metadata(d1 = {"\u0000J\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u008f\u0001\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032:\u0010\u0005\u001a6\u0012\u0015\u0012\u0013\u0018\u00010\u0003¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0015\u0012\u0013\u0018\u00010\u0003¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u00010\u00062\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0001¢\u0006\u0002\u0010\u0017\"\u0010\u0010\u0018\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001a¨\u0006\u001b"}, d2 = {"DateRangeInputContent", "", "selectedStartDateMillis", "", "selectedEndDateMillis", "onDatesSelectionChange", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "startDateMillis", "endDateMillis", "calendarModel", "Landroidx/compose/material3/internal/CalendarModel;", "yearRange", "Lkotlin/ranges/IntRange;", "dateFormatter", "Landroidx/compose/material3/DatePickerFormatter;", "selectableDates", "Landroidx/compose/material3/SelectableDates;", "colors", "Landroidx/compose/material3/DatePickerColors;", "focusRequester", "Landroidx/compose/ui/focus/FocusRequester;", "(Ljava/lang/Long;Ljava/lang/Long;Lkotlin/jvm/functions/Function2;Landroidx/compose/material3/internal/CalendarModel;Lkotlin/ranges/IntRange;Landroidx/compose/material3/DatePickerFormatter;Landroidx/compose/material3/SelectableDates;Landroidx/compose/material3/DatePickerColors;Landroidx/compose/ui/focus/FocusRequester;Landroidx/compose/runtime/Composer;I)V", "TextFieldSpacing", "Landroidx/compose/ui/unit/Dp;", "F", "material3"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class DateRangeInputKt {
    private static final float TextFieldSpacing = Dp.m7555constructorimpl(8.0f);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit DateRangeInputContent$lambda$8(Long l, Long l2, Function2 function2, CalendarModel calendarModel, IntRange intRange, DatePickerFormatter datePickerFormatter, SelectableDates selectableDates, DatePickerColors datePickerColors, FocusRequester focusRequester, int i, Composer composer, int i2) {
        DateRangeInputContent(l, l2, function2, calendarModel, intRange, datePickerFormatter, selectableDates, datePickerColors, focusRequester, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final void DateRangeInputContent(final Long l, final Long l2, final Function2<? super Long, ? super Long, Unit> function2, final CalendarModel calendarModel, final IntRange intRange, final DatePickerFormatter datePickerFormatter, final SelectableDates selectableDates, final DatePickerColors datePickerColors, final FocusRequester focusRequester, Composer composer, final int i) {
        int i2;
        IntRange intRange2;
        SelectableDates selectableDates2;
        final Function2<? super Long, ? super Long, Unit> function22;
        Composer composer2;
        String str;
        DateInputValidator dateInputValidator;
        int i3;
        Composer startRestartGroup = composer.startRestartGroup(1372713366);
        ComposerKt.sourceInformation(startRestartGroup, "C(DateRangeInputContent)N(selectedStartDateMillis,selectedEndDateMillis,onDatesSelectionChange,calendarModel,yearRange,dateFormatter,selectableDates,colors,focusRequester)47@1831L89,48@1948L45,49@2028L44,50@2106L45,51@2180L50,53@2268L531,70@3012L2615:DateRangeInput.kt#uh7d8r");
        if ((i & 6) == 0) {
            i2 = (startRestartGroup.changed(l) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= startRestartGroup.changed(l2) ? 32 : 16;
        }
        if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i2 |= startRestartGroup.changedInstance(function2) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= startRestartGroup.changedInstance(calendarModel) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            intRange2 = intRange;
            i2 |= startRestartGroup.changedInstance(intRange2) ? 16384 : 8192;
        } else {
            intRange2 = intRange;
        }
        if ((196608 & i) == 0) {
            i2 |= (i & 262144) == 0 ? startRestartGroup.changed(datePickerFormatter) : startRestartGroup.changedInstance(datePickerFormatter) ? 131072 : 65536;
        }
        if ((1572864 & i) == 0) {
            selectableDates2 = selectableDates;
            i2 |= startRestartGroup.changed(selectableDates2) ? 1048576 : 524288;
        } else {
            selectableDates2 = selectableDates;
        }
        if ((i & 12582912) == 0) {
            i2 |= startRestartGroup.changed(datePickerColors) ? 8388608 : 4194304;
        }
        if ((i & 100663296) == 0) {
            i2 |= startRestartGroup.changed(focusRequester) ? 67108864 : 33554432;
        }
        if (!startRestartGroup.shouldExecute((i2 & 38347923) != 38347922, i2 & 1)) {
            function22 = function2;
            composer2 = startRestartGroup;
            composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1372713366, i2, -1, "androidx.compose.material3.DateRangeInputContent (DateRangeInput.kt:44)");
            }
            Locale locale = calendarModel.getLocale();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 622601007, "CC(remember):DateRangeInput.kt#9igjgp");
            boolean changed = startRestartGroup.changed(locale);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (changed || rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = calendarModel.getDateInputFormat(calendarModel.getLocale());
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            DateInputFormat dateInputFormat = (DateInputFormat) rememberedValue;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            Strings.Companion companion = Strings.Companion;
            String m3088getString2EP1pXo = Strings_androidKt.m3088getString2EP1pXo(Strings.m3009constructorimpl(R.string.m3c_date_input_invalid_for_pattern), startRestartGroup, 0);
            Strings.Companion companion2 = Strings.Companion;
            String m3088getString2EP1pXo2 = Strings_androidKt.m3088getString2EP1pXo(Strings.m3009constructorimpl(R.string.m3c_date_input_invalid_year_range), startRestartGroup, 0);
            Strings.Companion companion3 = Strings.Companion;
            String m3088getString2EP1pXo3 = Strings_androidKt.m3088getString2EP1pXo(Strings.m3009constructorimpl(R.string.m3c_date_input_invalid_not_allowed), startRestartGroup, 0);
            Strings.Companion companion4 = Strings.Companion;
            String m3088getString2EP1pXo4 = Strings_androidKt.m3088getString2EP1pXo(Strings.m3009constructorimpl(R.string.m3c_date_range_input_invalid_range_input), startRestartGroup, 0);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 622615433, "CC(remember):DateRangeInput.kt#9igjgp");
            boolean changed2 = startRestartGroup.changed(dateInputFormat) | ((i2 & 458752) == 131072 || ((i2 & 262144) != 0 && startRestartGroup.changed(datePickerFormatter)));
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (changed2 || rememberedValue2 == Composer.Companion.getEmpty()) {
                str = "CC(remember):DateRangeInput.kt#9igjgp";
                i3 = i2;
                dateInputValidator = new DateInputValidator(intRange2, selectableDates2, dateInputFormat, datePickerFormatter, m3088getString2EP1pXo, m3088getString2EP1pXo2, m3088getString2EP1pXo3, m3088getString2EP1pXo4);
                dateInputFormat = dateInputFormat;
                startRestartGroup.updateRememberedValue(dateInputValidator);
            } else {
                dateInputValidator = rememberedValue2;
                i3 = i2;
                str = "CC(remember):DateRangeInput.kt#9igjgp";
            }
            DateInputValidator dateInputValidator2 = dateInputValidator;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            dateInputValidator2.setCurrentStartDateMillis(l);
            dateInputValidator2.setCurrentEndDateMillis(l2);
            Modifier padding = PaddingKt.padding(Modifier.Companion, DateInputKt.getInputTextFieldPadding());
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 693286680, "CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo");
            MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.m688spacedBy0680j_4(TextFieldSpacing), Alignment.Companion.getTop(), startRestartGroup, 6);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, padding);
            Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
            if (!(startRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(constructor);
            } else {
                startRestartGroup.useNode();
            }
            Composer m4041constructorimpl = Updater.m4041constructorimpl(startRestartGroup);
            Updater.m4049setimpl(m4041constructorimpl, rowMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m4049setimpl(m4041constructorimpl, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (m4041constructorimpl.getInserting() || !Intrinsics.areEqual(m4041constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                m4041constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                m4041constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m4049setimpl(m4041constructorimpl, materializeModifier, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -407735110, "C101@5232L9:Row.kt#2w3rfo");
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 34166529, "C75@3274L56,88@3872L203,79@3468L219,86@3715L62,76@3339L1026,99@4393L54,111@4959L199,103@4585L191,109@4804L62,100@4456L1165:DateRangeInput.kt#uh7d8r");
            String upperCase = dateInputFormat.getPatternWithDelimiters().toUpperCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
            Strings.Companion companion5 = Strings.Companion;
            String m3088getString2EP1pXo5 = Strings_androidKt.m3088getString2EP1pXo(Strings.m3009constructorimpl(R.string.m3c_date_range_picker_start_headline), startRestartGroup, 0);
            Modifier weight$default = RowScope.weight$default(rowScopeInstance, Modifier.Companion, 0.5f, false, 2, null);
            int m2192getStartDateInputJ2x2o4M = InputIdentifier.Companion.m2192getStartDateInputJ2x2o4M();
            Locale locale2 = calendarModel.getLocale();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1122021, str);
            int i4 = i3 & 896;
            int i5 = i3 & 112;
            boolean z = (i4 == 256) | (i5 == 32);
            Object rememberedValue3 = startRestartGroup.rememberedValue();
            if (z || rememberedValue3 == Composer.Companion.getEmpty()) {
                rememberedValue3 = new Function1() { // from class: androidx.compose.material3.DateRangeInputKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return DateRangeInputKt.DateRangeInputContent$lambda$7$lambda$4$lambda$3(Function2.this, l2, (Long) obj);
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue3);
            }
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            int i6 = i3 & 7168;
            int i7 = i3 >> 21;
            int i8 = i7 & 14;
            String str2 = str;
            int i9 = i3;
            composer2 = startRestartGroup;
            DateInputKt.m1954DateInputTextFieldxJ3Ic0Y(weight$default, l, (Function1) rememberedValue3, calendarModel, ComposableLambdaKt.rememberComposableLambda(1740538748, true, new DateRangeInputKt$DateRangeInputContent$2$2(m3088getString2EP1pXo5, upperCase), startRestartGroup, 54), ComposableLambdaKt.rememberComposableLambda(1229526589, true, new DateRangeInputKt$DateRangeInputContent$2$3(upperCase), startRestartGroup, 54), m2192getStartDateInputJ2x2o4M, dateInputValidator2, dateInputFormat, locale2, datePickerColors, focusRequester, composer2, ((i3 << 3) & 112) | 1794048 | i6, i7 & WebSocketProtocol.PAYLOAD_SHORT);
            Strings.Companion companion6 = Strings.Companion;
            String m3088getString2EP1pXo6 = Strings_androidKt.m3088getString2EP1pXo(Strings.m3009constructorimpl(R.string.m3c_date_range_picker_end_headline), composer2, 0);
            Modifier weight$default2 = RowScope.weight$default(rowScopeInstance, Modifier.Companion, 0.5f, false, 2, null);
            int m2190getEndDateInputJ2x2o4M = InputIdentifier.Companion.m2190getEndDateInputJ2x2o4M();
            Locale locale3 = calendarModel.getLocale();
            ComposerKt.sourceInformationMarkerStart(composer2, 1156801, str2);
            boolean z2 = (i4 == 256) | ((i9 & 14) == 4);
            Object rememberedValue4 = composer2.rememberedValue();
            if (z2 || rememberedValue4 == Composer.Companion.getEmpty()) {
                function22 = function2;
                rememberedValue4 = new Function1() { // from class: androidx.compose.material3.DateRangeInputKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return DateRangeInputKt.DateRangeInputContent$lambda$7$lambda$6$lambda$5(Function2.this, l, (Long) obj);
                    }
                };
                composer2.updateRememberedValue(rememberedValue4);
            } else {
                function22 = function2;
            }
            ComposerKt.sourceInformationMarkerEnd(composer2);
            DateInputKt.m1954DateInputTextFieldxJ3Ic0Y(weight$default2, l2, (Function1) rememberedValue4, calendarModel, ComposableLambdaKt.rememberComposableLambda(-882370893, true, new DateRangeInputKt$DateRangeInputContent$2$5(m3088getString2EP1pXo6, upperCase), composer2, 54), ComposableLambdaKt.rememberComposableLambda(1956183348, true, new DateRangeInputKt$DateRangeInputContent$2$6(upperCase), composer2, 54), m2190getEndDateInputJ2x2o4M, dateInputValidator2, dateInputFormat, locale3, datePickerColors, null, composer2, i5 | 1794048 | i6, i8 | 48);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Function2<? super Long, ? super Long, Unit> function23 = function22;
            endRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.DateRangeInputKt$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return DateRangeInputKt.DateRangeInputContent$lambda$8(l, l2, function23, calendarModel, intRange, datePickerFormatter, selectableDates, datePickerColors, focusRequester, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit DateRangeInputContent$lambda$7$lambda$4$lambda$3(Function2 function2, Long l, Long l2) {
        function2.invoke(l2, l);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit DateRangeInputContent$lambda$7$lambda$6$lambda$5(Function2 function2, Long l, Long l2) {
        function2.invoke(l, l2);
        return Unit.INSTANCE;
    }
}
