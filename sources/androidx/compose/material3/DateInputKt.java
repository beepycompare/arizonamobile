package androidx.compose.material3;

import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.text.KeyboardActions;
import androidx.compose.foundation.text.KeyboardOptions;
import androidx.compose.material3.internal.CalendarDate;
import androidx.compose.material3.internal.CalendarModel;
import androidx.compose.material3.internal.DateInputFormat;
import androidx.compose.material3.internal.Strings;
import androidx.compose.material3.internal.Strings_androidKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.focus.FocusRequester;
import androidx.compose.ui.focus.FocusRequesterModifierKt;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.input.ImeAction;
import androidx.compose.ui.text.input.KeyboardType;
import androidx.compose.ui.text.input.PlatformImeOptions;
import androidx.compose.ui.text.input.TextFieldValue;
import androidx.compose.ui.text.input.VisualTransformation;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.unit.Dp;
import androidx.media3.common.C;
import androidx.media3.exoplayer.RendererCapabilities;
import androidx.profileinstaller.ProfileVerifier;
import com.google.firebase.messaging.Constants;
import io.appmetrica.analytics.networktasks.internal.CommonUrlParts;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.text.StringsKt;
import okhttp3.internal.ws.WebSocketProtocol;
/* compiled from: DateInput.kt */
@Metadata(d1 = {"\u0000\u0086\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\u001an\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032#\u0010\u0004\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u0003¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\u00010\u00052\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0001¢\u0006\u0002\u0010\u0015\u001a\u009f\u0001\u0010\u0016\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u00032\u0014\u0010\u0004\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0004\u0012\u00020\u00010\u00052\u0006\u0010\t\u001a\u00020\n2\u0013\u0010\u001a\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u001b¢\u0006\u0002\b\u001c2\u0013\u0010\u001d\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u001b¢\u0006\u0002\b\u001c2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#2\n\u0010$\u001a\u00060%j\u0002`&2\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0001¢\u0006\u0004\b'\u0010(\"\u0014\u0010)\u001a\u00020*X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b+\u0010,\"\u0010\u0010-\u001a\u00020.X\u0082\u0004¢\u0006\u0004\n\u0002\u0010/¨\u00060²\u0006\n\u00101\u001a\u000202X\u008a\u008e\u0002"}, d2 = {"DateInputContent", "", "selectedDateMillis", "", "onDateSelectionChange", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "dateInMillis", "calendarModel", "Landroidx/compose/material3/internal/CalendarModel;", "yearRange", "Lkotlin/ranges/IntRange;", "dateFormatter", "Landroidx/compose/material3/DatePickerFormatter;", "selectableDates", "Landroidx/compose/material3/SelectableDates;", "colors", "Landroidx/compose/material3/DatePickerColors;", "focusRequester", "Landroidx/compose/ui/focus/FocusRequester;", "(Ljava/lang/Long;Lkotlin/jvm/functions/Function1;Landroidx/compose/material3/internal/CalendarModel;Lkotlin/ranges/IntRange;Landroidx/compose/material3/DatePickerFormatter;Landroidx/compose/material3/SelectableDates;Landroidx/compose/material3/DatePickerColors;Landroidx/compose/ui/focus/FocusRequester;Landroidx/compose/runtime/Composer;I)V", "DateInputTextField", "modifier", "Landroidx/compose/ui/Modifier;", "initialDateMillis", Constants.ScionAnalytics.PARAM_LABEL, "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "placeholder", "inputIdentifier", "Landroidx/compose/material3/InputIdentifier;", "dateInputValidator", "Landroidx/compose/material3/DateInputValidator;", "dateInputFormat", "Landroidx/compose/material3/internal/DateInputFormat;", CommonUrlParts.LOCALE, "Ljava/util/Locale;", "Landroidx/compose/material3/CalendarLocale;", "DateInputTextField-xJ3Ic0Y", "(Landroidx/compose/ui/Modifier;Ljava/lang/Long;Lkotlin/jvm/functions/Function1;Landroidx/compose/material3/internal/CalendarModel;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ILandroidx/compose/material3/DateInputValidator;Landroidx/compose/material3/internal/DateInputFormat;Ljava/util/Locale;Landroidx/compose/material3/DatePickerColors;Landroidx/compose/ui/focus/FocusRequester;Landroidx/compose/runtime/Composer;II)V", "InputTextFieldPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "getInputTextFieldPadding", "()Landroidx/compose/foundation/layout/PaddingValues;", "InputTextNonErroneousBottomPadding", "Landroidx/compose/ui/unit/Dp;", "F", "material3", "text", "Landroidx/compose/ui/text/input/TextFieldValue;"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class DateInputKt {
    private static final PaddingValues InputTextFieldPadding = PaddingKt.m815PaddingValuesa9UjIt4$default(Dp.m7555constructorimpl(24.0f), Dp.m7555constructorimpl(10.0f), Dp.m7555constructorimpl(24.0f), 0.0f, 8, null);
    private static final float InputTextNonErroneousBottomPadding = Dp.m7555constructorimpl(16.0f);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit DateInputContent$lambda$3(Long l, Function1 function1, CalendarModel calendarModel, IntRange intRange, DatePickerFormatter datePickerFormatter, SelectableDates selectableDates, DatePickerColors datePickerColors, FocusRequester focusRequester, int i, Composer composer, int i2) {
        DateInputContent(l, function1, calendarModel, intRange, datePickerFormatter, selectableDates, datePickerColors, focusRequester, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit DateInputTextField_xJ3Ic0Y$lambda$17(Modifier modifier, Long l, Function1 function1, CalendarModel calendarModel, Function2 function2, Function2 function22, int i, DateInputValidator dateInputValidator, DateInputFormat dateInputFormat, Locale locale, DatePickerColors datePickerColors, FocusRequester focusRequester, int i2, int i3, Composer composer, int i4) {
        m1954DateInputTextFieldxJ3Ic0Y(modifier, l, function1, calendarModel, function2, function22, i, dateInputValidator, dateInputFormat, locale, datePickerColors, focusRequester, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), RecomposeScopeImplKt.updateChangedFlags(i3));
        return Unit.INSTANCE;
    }

    /* JADX WARN: Type inference failed for: r3v4 */
    /* JADX WARN: Type inference failed for: r3v5, types: [int, boolean] */
    /* JADX WARN: Type inference failed for: r3v9 */
    public static final void DateInputContent(final Long l, final Function1<? super Long, Unit> function1, final CalendarModel calendarModel, final IntRange intRange, final DatePickerFormatter datePickerFormatter, final SelectableDates selectableDates, final DatePickerColors datePickerColors, final FocusRequester focusRequester, Composer composer, final int i) {
        int i2;
        IntRange intRange2;
        SelectableDates selectableDates2;
        Composer composer2;
        int i3;
        ?? r3;
        Composer startRestartGroup = composer.startRestartGroup(-432341251);
        ComposerKt.sourceInformation(startRestartGroup, "C(DateInputContent)N(selectedDateMillis,onDateSelectionChange,calendarModel,yearRange,dateFormatter,selectableDates,colors,focusRequester)70@2926L89,71@3043L45,72@3123L44,73@3201L45,75@3284L552,88@3925L42,92@4122L165,98@4311L62,89@3972L951:DateInput.kt#uh7d8r");
        if ((i & 6) == 0) {
            i2 = (startRestartGroup.changed(l) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= startRestartGroup.changedInstance(function1) ? 32 : 16;
        }
        if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i2 |= startRestartGroup.changedInstance(calendarModel) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            intRange2 = intRange;
            i2 |= startRestartGroup.changedInstance(intRange2) ? 2048 : 1024;
        } else {
            intRange2 = intRange;
        }
        if ((i & 24576) == 0) {
            i2 |= (i & 32768) == 0 ? startRestartGroup.changed(datePickerFormatter) : startRestartGroup.changedInstance(datePickerFormatter) ? 16384 : 8192;
        }
        if ((196608 & i) == 0) {
            selectableDates2 = selectableDates;
            i2 |= startRestartGroup.changed(selectableDates2) ? 131072 : 65536;
        } else {
            selectableDates2 = selectableDates;
        }
        if ((1572864 & i) == 0) {
            i2 |= startRestartGroup.changed(datePickerColors) ? 1048576 : 524288;
        }
        if ((12582912 & i) == 0) {
            i2 |= startRestartGroup.changed(focusRequester) ? 8388608 : 4194304;
        }
        if (!startRestartGroup.shouldExecute((4793491 & i2) != 4793490, i2 & 1)) {
            composer2 = startRestartGroup;
            composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-432341251, i2, -1, "androidx.compose.material3.DateInputContent (DateInput.kt:67)");
            }
            Locale locale = calendarModel.getLocale();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1131899414, "CC(remember):DateInput.kt#9igjgp");
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
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1131911333, "CC(remember):DateInput.kt#9igjgp");
            boolean changed2 = startRestartGroup.changed(dateInputFormat) | ((57344 & i2) == 16384 || ((i2 & 32768) != 0 && startRestartGroup.changed(datePickerFormatter)));
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (changed2 || rememberedValue2 == Composer.Companion.getEmpty()) {
                i3 = i2;
                r3 = 1;
                DateInputValidator dateInputValidator = new DateInputValidator(intRange2, selectableDates2, dateInputFormat, datePickerFormatter, m3088getString2EP1pXo, m3088getString2EP1pXo2, m3088getString2EP1pXo3, "");
                startRestartGroup.updateRememberedValue(dateInputValidator);
                rememberedValue2 = dateInputValidator;
            } else {
                i3 = i2;
                r3 = 1;
            }
            DateInputValidator dateInputValidator2 = (DateInputValidator) rememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            String upperCase = dateInputFormat.getPatternWithDelimiters().toUpperCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
            Strings.Companion companion4 = Strings.Companion;
            String m3088getString2EP1pXo4 = Strings_androidKt.m3088getString2EP1pXo(Strings.m3009constructorimpl(R.string.m3c_date_input_label), startRestartGroup, 0);
            Modifier padding = PaddingKt.padding(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, r3, null), InputTextFieldPadding);
            int m2191getSingleDateInputJ2x2o4M = InputIdentifier.Companion.m2191getSingleDateInputJ2x2o4M();
            dateInputValidator2.setCurrentStartDateMillis(l);
            int i4 = i3 << 3;
            composer2 = startRestartGroup;
            m1954DateInputTextFieldxJ3Ic0Y(padding, l, function1, calendarModel, ComposableLambdaKt.rememberComposableLambda(-752164549, r3, new DateInputKt$DateInputContent$2(m3088getString2EP1pXo4, upperCase), startRestartGroup, 54), ComposableLambdaKt.rememberComposableLambda(-1179434278, r3, new DateInputKt$DateInputContent$3(upperCase), startRestartGroup, 54), m2191getSingleDateInputJ2x2o4M, dateInputValidator2, dateInputFormat, calendarModel.getLocale(), datePickerColors, focusRequester, composer2, (i4 & 7168) | (i4 & 112) | 1794054 | (i4 & 896), (i3 >> 18) & WebSocketProtocol.PAYLOAD_SHORT);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.DateInputKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return DateInputKt.DateInputContent$lambda$3(l, function1, calendarModel, intRange, datePickerFormatter, selectableDates, datePickerColors, focusRequester, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* renamed from: DateInputTextField-xJ3Ic0Y  reason: not valid java name */
    public static final void m1954DateInputTextFieldxJ3Ic0Y(final Modifier modifier, Long l, final Function1<? super Long, Unit> function1, final CalendarModel calendarModel, final Function2<? super Composer, ? super Integer, Unit> function2, final Function2<? super Composer, ? super Integer, Unit> function22, final int i, final DateInputValidator dateInputValidator, final DateInputFormat dateInputFormat, final Locale locale, final DatePickerColors datePickerColors, final FocusRequester focusRequester, Composer composer, final int i2, final int i3) {
        int i4;
        int i5;
        Long l2;
        Composer composer2;
        int i6;
        int i7;
        MutableState mutableState;
        float m7555constructorimpl;
        boolean z;
        final DateInputFormat dateInputFormat2;
        int i8;
        Modifier.Companion companion;
        DateInputKt$DateInputTextField$5$1 dateInputKt$DateInputTextField$5$1;
        final CalendarModel calendarModel2 = calendarModel;
        final Locale locale2 = locale;
        Composer startRestartGroup = composer.startRestartGroup(1456309913);
        ComposerKt.sourceInformation(startRestartGroup, "C(DateInputTextField)N(modifier,initialDateMillis,onDateSelectionChange,calendarModel,label,placeholder,inputIdentifier:c#material3.InputIdentifier,dateInputValidator,dateInputFormat,locale,colors,focusRequester)130@5481L36,130@5429L88,132@5569L715,132@5546L738,164@6980L1604,205@8702L60,215@9086L59,162@6915L2641,228@9583L297,228@9562L318,237@9920L727,237@9886L761:DateInput.kt#uh7d8r");
        if ((i2 & 6) == 0) {
            i4 = (startRestartGroup.changed(modifier) ? 4 : 2) | i2;
        } else {
            i4 = i2;
        }
        if ((i2 & 48) == 0) {
            i4 |= startRestartGroup.changed(l) ? 32 : 16;
        }
        if ((i2 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i4 |= startRestartGroup.changedInstance(function1) ? 256 : 128;
        }
        if ((i2 & 3072) == 0) {
            i4 |= startRestartGroup.changedInstance(calendarModel2) ? 2048 : 1024;
        }
        if ((i2 & 24576) == 0) {
            i4 |= startRestartGroup.changedInstance(function2) ? 16384 : 8192;
        }
        if ((i2 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
            i4 |= startRestartGroup.changedInstance(function22) ? 131072 : 65536;
        }
        if ((i2 & 1572864) == 0) {
            i4 |= startRestartGroup.changed(i) ? 1048576 : 524288;
        }
        if ((i2 & 12582912) == 0) {
            i4 |= startRestartGroup.changed(dateInputValidator) ? 8388608 : 4194304;
        }
        if ((i2 & 100663296) == 0) {
            i4 |= startRestartGroup.changed(dateInputFormat) ? 67108864 : 33554432;
        }
        if ((i2 & 805306368) == 0) {
            i4 |= startRestartGroup.changedInstance(locale2) ? C.BUFFER_FLAG_LAST_SAMPLE : 268435456;
        }
        if ((i3 & 6) == 0) {
            i5 = i3 | (startRestartGroup.changed(datePickerColors) ? 4 : 2);
        } else {
            i5 = i3;
        }
        if ((i3 & 48) == 0) {
            i5 |= startRestartGroup.changed(focusRequester) ? 32 : 16;
        }
        int i9 = i5;
        if (!startRestartGroup.shouldExecute(((i4 & 306783379) == 306783378 && (i9 & 19) == 18) ? false : true, i4 & 1)) {
            l2 = l;
            composer2 = startRestartGroup;
            composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1456309913, i4, i9, "androidx.compose.material3.DateInputTextField (DateInput.kt:128)");
            }
            Object[] objArr = new Object[0];
            Saver<TextFieldValue, Object> saver = TextFieldValue.Companion.getSaver();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -645494339, "CC(remember):DateInput.kt#9igjgp");
            Object rememberedValue = startRestartGroup.rememberedValue();
            int i10 = i4;
            if (rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new Function0() { // from class: androidx.compose.material3.DateInputKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return DateInputKt.DateInputTextField_xJ3Ic0Y$lambda$5$lambda$4();
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            final MutableState rememberSaveable = RememberSaveableKt.rememberSaveable(objArr, (Saver) saver, (Function0) rememberedValue, startRestartGroup, (int) RendererCapabilities.DECODER_SUPPORT_MASK);
            Object[] objArr2 = {DateInputTextField_xJ3Ic0Y$lambda$6(rememberSaveable)};
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -645490844, "CC(remember):DateInput.kt#9igjgp");
            int i11 = i10 & 29360128;
            int i12 = i10 & 234881024;
            int i13 = i10 & 3670016;
            boolean changed = startRestartGroup.changed(rememberSaveable) | (i11 == 8388608) | startRestartGroup.changedInstance(calendarModel2) | (i12 == 67108864) | startRestartGroup.changedInstance(locale2) | (i13 == 1048576);
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (changed || rememberedValue2 == Composer.Companion.getEmpty()) {
                i6 = i11;
                i7 = i10;
                rememberedValue2 = new Function0() { // from class: androidx.compose.material3.DateInputKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return DateInputKt.DateInputTextField_xJ3Ic0Y$lambda$9$lambda$8(DateInputValidator.this, calendarModel2, dateInputFormat, locale2, i, rememberSaveable);
                    }
                };
                mutableState = rememberSaveable;
                startRestartGroup.updateRememberedValue(rememberedValue2);
            } else {
                mutableState = rememberSaveable;
                i6 = i11;
                i7 = i10;
            }
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            final MutableState mutableState2 = (MutableState) RememberSaveableKt.rememberSaveable(objArr2, (Function0) rememberedValue2, startRestartGroup, 0);
            if (StringsKt.isBlank((CharSequence) mutableState2.getValue())) {
                m7555constructorimpl = InputTextNonErroneousBottomPadding;
            } else {
                PaddingValues m2688supportingTextPaddinga9UjIt4$material3$default = TextFieldDefaults.m2688supportingTextPaddinga9UjIt4$material3$default(TextFieldDefaults.INSTANCE, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                m7555constructorimpl = Dp.m7555constructorimpl(InputTextNonErroneousBottomPadding - Dp.m7555constructorimpl(m2688supportingTextPaddinga9UjIt4$material3$default.mo767calculateBottomPaddingD9Ej5fM() + m2688supportingTextPaddinga9UjIt4$material3$default.mo770calculateTopPaddingD9Ej5fM()));
            }
            float f = m7555constructorimpl;
            TextFieldValue DateInputTextField_xJ3Ic0Y$lambda$6 = DateInputTextField_xJ3Ic0Y$lambda$6(mutableState);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -645444803, "CC(remember):DateInput.kt#9igjgp");
            boolean changed2 = (i12 == 67108864) | startRestartGroup.changed(mutableState) | startRestartGroup.changed(mutableState2) | ((i7 & 896) == 256) | startRestartGroup.changedInstance(calendarModel2) | startRestartGroup.changedInstance(locale2) | (i6 == 8388608) | (i13 == 1048576);
            Object rememberedValue3 = startRestartGroup.rememberedValue();
            if (changed2 || rememberedValue3 == Composer.Companion.getEmpty()) {
                z = true;
                dateInputFormat2 = dateInputFormat;
                i8 = i7;
                final MutableState mutableState3 = mutableState;
                Function1 function12 = new Function1() { // from class: androidx.compose.material3.DateInputKt$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return DateInputKt.DateInputTextField_xJ3Ic0Y$lambda$12$lambda$11(DateInputFormat.this, mutableState2, function1, calendarModel2, locale2, dateInputValidator, i, mutableState3, (TextFieldValue) obj);
                    }
                };
                calendarModel2 = calendarModel2;
                locale2 = locale2;
                mutableState = mutableState3;
                startRestartGroup.updateRememberedValue(function12);
                rememberedValue3 = function12;
            } else {
                dateInputFormat2 = dateInputFormat;
                z = true;
                i8 = i7;
            }
            Function1 function13 = (Function1) rememberedValue3;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            Modifier m822paddingqDBjuR0$default = PaddingKt.m822paddingqDBjuR0$default(modifier, 0.0f, 0.0f, 0.0f, f, 7, null);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -645391243, "CC(remember):DateInput.kt#9igjgp");
            boolean changed3 = startRestartGroup.changed(mutableState2);
            Object rememberedValue4 = startRestartGroup.rememberedValue();
            if (changed3 || rememberedValue4 == Composer.Companion.getEmpty()) {
                rememberedValue4 = new Function1() { // from class: androidx.compose.material3.DateInputKt$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return DateInputKt.DateInputTextField_xJ3Ic0Y$lambda$14$lambda$13(MutableState.this, (SemanticsPropertyReceiver) obj);
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue4);
            }
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            Modifier semantics$default = SemanticsModifierKt.semantics$default(m822paddingqDBjuR0$default, false, (Function1) rememberedValue4, 1, null);
            if (focusRequester != null) {
                companion = FocusRequesterModifierKt.focusRequester(Modifier.Companion, focusRequester);
            } else {
                companion = Modifier.Companion;
            }
            OutlinedTextFieldKt.OutlinedTextField(DateInputTextField_xJ3Ic0Y$lambda$6, (Function1<? super TextFieldValue, Unit>) function13, semantics$default.then(companion), false, false, (TextStyle) null, function2, function22, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) ComposableLambdaKt.rememberComposableLambda(-357881838, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.DateInputKt$DateInputTextField$3
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                    invoke(composer3, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer3, int i14) {
                    Composer composer4 = composer3;
                    ComposerKt.sourceInformation(composer4, "C:DateInput.kt#uh7d8r");
                    if (!composer4.shouldExecute((i14 & 3) != 2, i14 & 1)) {
                        composer4.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-357881838, i14, -1, "androidx.compose.material3.DateInputTextField.<anonymous> (DateInput.kt:215)");
                    }
                    if (StringsKt.isBlank(mutableState2.getValue())) {
                        composer4.startReplaceGroup(-1548950640);
                    } else {
                        composer4.startReplaceGroup(-327061465);
                        ComposerKt.sourceInformation(composer4, "215@9122L21");
                        TextKt.m2712TextNvy7gAk(mutableState2.getValue(), null, 0L, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer3, 0, 0, 262142);
                        composer4 = composer3;
                    }
                    composer4.endReplaceGroup();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, startRestartGroup, 54), !StringsKt.isBlank((CharSequence) mutableState2.getValue()), (VisualTransformation) new DateVisualTransformation(dateInputFormat2), new KeyboardOptions(0, (Boolean) false, KeyboardType.Companion.m7241getNumberPjHm6EE(), ImeAction.Companion.m7185getDoneeUduSuo(), (PlatformImeOptions) null, (Boolean) null, (LocaleList) null, 113, (DefaultConstructorMarker) null), (KeyboardActions) null, true, 0, 0, (MutableInteractionSource) null, (Shape) null, datePickerColors.getDateTextFieldColors(), startRestartGroup, (i8 << 6) & 33030144, 12779904, 0, 4001592);
            composer2 = startRestartGroup;
            Unit unit = Unit.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer2, -645362814, "CC(remember):DateInput.kt#9igjgp");
            boolean z2 = (i9 & 112) == 32;
            DateInputKt$DateInputTextField$4$1 rememberedValue5 = composer2.rememberedValue();
            if (z2 || rememberedValue5 == Composer.Companion.getEmpty()) {
                rememberedValue5 = new DateInputKt$DateInputTextField$4$1(focusRequester, null);
                composer2.updateRememberedValue(rememberedValue5);
            }
            ComposerKt.sourceInformationMarkerEnd(composer2);
            EffectsKt.LaunchedEffect(unit, (Function2) rememberedValue5, composer2, 6);
            ComposerKt.sourceInformationMarkerStart(composer2, -645351600, "CC(remember):DateInput.kt#9igjgp");
            boolean changedInstance = ((i8 & 112) == 32) | composer2.changedInstance(calendarModel2) | (i12 == 67108864) | composer2.changedInstance(locale2) | composer2.changed(mutableState);
            Object rememberedValue6 = composer2.rememberedValue();
            if (changedInstance || rememberedValue6 == Composer.Companion.getEmpty()) {
                l2 = l;
                dateInputKt$DateInputTextField$5$1 = new DateInputKt$DateInputTextField$5$1(l2, calendarModel2, dateInputFormat2, locale, mutableState, null);
                composer2.updateRememberedValue(dateInputKt$DateInputTextField$5$1);
            } else {
                dateInputKt$DateInputTextField$5$1 = rememberedValue6;
                l2 = l;
            }
            ComposerKt.sourceInformationMarkerEnd(composer2);
            EffectsKt.LaunchedEffect(l2, dateInputKt$DateInputTextField$5$1, composer2, (i8 >> 3) & 14);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Long l3 = l2;
            endRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.DateInputKt$$ExternalSyntheticLambda5
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return DateInputKt.DateInputTextField_xJ3Ic0Y$lambda$17(Modifier.this, l3, function1, calendarModel, function2, function22, i, dateInputValidator, dateInputFormat, locale, datePickerColors, focusRequester, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final MutableState DateInputTextField_xJ3Ic0Y$lambda$5$lambda$4() {
        MutableState mutableStateOf$default;
        mutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(new TextFieldValue((String) null, 0L, (TextRange) null, 7, (DefaultConstructorMarker) null), null, 2, null);
        return mutableStateOf$default;
    }

    private static final TextFieldValue DateInputTextField_xJ3Ic0Y$lambda$6(MutableState<TextFieldValue> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final MutableState DateInputTextField_xJ3Ic0Y$lambda$9$lambda$8(DateInputValidator dateInputValidator, CalendarModel calendarModel, DateInputFormat dateInputFormat, Locale locale, int i, MutableState mutableState) {
        String str;
        MutableState mutableStateOf$default;
        if (DateInputTextField_xJ3Ic0Y$lambda$6(mutableState).getText().length() <= 0) {
            str = "";
        } else {
            str = dateInputValidator.m1955validateXivgLIo(calendarModel.parse(DateInputTextField_xJ3Ic0Y$lambda$6(mutableState).getText(), dateInputFormat.getPatternWithoutDelimiters(), locale), i, locale);
        }
        mutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(str, null, 2, null);
        return mutableStateOf$default;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit DateInputTextField_xJ3Ic0Y$lambda$12$lambda$11(DateInputFormat dateInputFormat, MutableState mutableState, Function1 function1, CalendarModel calendarModel, Locale locale, DateInputValidator dateInputValidator, int i, MutableState mutableState2, TextFieldValue textFieldValue) {
        if (textFieldValue.getText().length() <= dateInputFormat.getPatternWithoutDelimiters().length()) {
            String text = textFieldValue.getText();
            int i2 = 0;
            while (true) {
                if (i2 < text.length()) {
                    if (!Character.isDigit(text.charAt(i2))) {
                        break;
                    }
                    i2++;
                } else {
                    mutableState2.setValue(textFieldValue);
                    String obj = StringsKt.trim((CharSequence) textFieldValue.getText()).toString();
                    Long l = null;
                    if (obj.length() == 0 || obj.length() < dateInputFormat.getPatternWithoutDelimiters().length()) {
                        mutableState.setValue("");
                        function1.invoke(null);
                    } else {
                        CalendarDate parse = calendarModel.parse(obj, dateInputFormat.getPatternWithoutDelimiters(), locale);
                        mutableState.setValue(dateInputValidator.m1955validateXivgLIo(parse, i, locale));
                        if (((CharSequence) mutableState.getValue()).length() == 0 && parse != null) {
                            l = Long.valueOf(parse.getUtcTimeMillis());
                        }
                        function1.invoke(l);
                    }
                }
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit DateInputTextField_xJ3Ic0Y$lambda$14$lambda$13(MutableState mutableState, SemanticsPropertyReceiver semanticsPropertyReceiver) {
        if (!StringsKt.isBlank((CharSequence) mutableState.getValue())) {
            SemanticsPropertiesKt.error(semanticsPropertyReceiver, (String) mutableState.getValue());
        }
        return Unit.INSTANCE;
    }

    public static final PaddingValues getInputTextFieldPadding() {
        return InputTextFieldPadding;
    }
}
