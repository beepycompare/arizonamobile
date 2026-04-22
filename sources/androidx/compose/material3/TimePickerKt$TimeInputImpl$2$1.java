package androidx.compose.material3;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.text.KeyboardActionScope;
import androidx.compose.foundation.text.KeyboardActions;
import androidx.compose.foundation.text.KeyboardOptions;
import androidx.compose.material3.tokens.TimeInputTokens;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.input.key.KeyEvent;
import androidx.compose.ui.input.key.KeyEvent_androidKt;
import androidx.compose.ui.input.key.KeyInputModifierKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.Ref;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.input.ImeAction;
import androidx.compose.ui.text.input.KeyboardType;
import androidx.compose.ui.text.input.PlatformImeOptions;
import androidx.compose.ui.text.input.TextFieldValue;
import androidx.compose.ui.text.intl.LocaleList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TimePicker.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class TimePickerKt$TimeInputImpl$2$1 implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ TimePickerColors $colors;
    final /* synthetic */ MutableState<TextFieldValue> $hourValue$delegate;
    final /* synthetic */ MutableState<TextFieldValue> $minuteValue$delegate;
    final /* synthetic */ TimePickerState $state;
    final /* synthetic */ Ref<Boolean> $userOverride;

    /* JADX INFO: Access modifiers changed from: package-private */
    public TimePickerKt$TimeInputImpl$2$1(MutableState<TextFieldValue> mutableState, TimePickerState timePickerState, Ref<Boolean> ref, TimePickerColors timePickerColors, MutableState<TextFieldValue> mutableState2) {
        this.$hourValue$delegate = mutableState;
        this.$state = timePickerState;
        this.$userOverride = ref;
        this.$colors = timePickerColors;
        this.$minuteValue$delegate = mutableState2;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
        invoke(composer, num.intValue());
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r25v0, types: [androidx.compose.runtime.Composer] */
    /* JADX WARN: Type inference failed for: r4v18 */
    /* JADX WARN: Type inference failed for: r6v10 */
    /* JADX WARN: Type inference failed for: r6v6 */
    public final void invoke(Composer composer, int i) {
        TextFieldValue TimeInputImpl$lambda$18;
        float f;
        TextFieldValue TimeInputImpl$lambda$22;
        ComposerKt.sourceInformation(composer, "C1032@43808L3645:TimePicker.kt#uh7d8r");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
            return;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1306700887, i, -1, "androidx.compose.material3.TimeInputImpl.<anonymous>.<anonymous> (TimePicker.kt:1032)");
        }
        final MutableState<TextFieldValue> mutableState = this.$hourValue$delegate;
        final TimePickerState timePickerState = this.$state;
        final Ref<Boolean> ref = this.$userOverride;
        TimePickerColors timePickerColors = this.$colors;
        final MutableState<TextFieldValue> mutableState2 = this.$minuteValue$delegate;
        ComposerKt.sourceInformationMarkerStart(composer, 693286680, "CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo");
        MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), Alignment.Companion.getTop(), composer, 0);
        ComposerKt.sourceInformationMarkerStart(composer, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
        CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
        Modifier materializeModifier = ComposedModifierKt.materializeModifier(composer, Modifier.Companion);
        Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
        ComposerKt.sourceInformationMarkerStart(composer, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
        if (!(composer.getApplier() instanceof Applier)) {
            ComposablesKt.invalidApplier();
        }
        composer.startReusableNode();
        if (composer.getInserting()) {
            composer.createNode(constructor);
        } else {
            composer.useNode();
        }
        Composer m4041constructorimpl = Updater.m4041constructorimpl(composer);
        Updater.m4049setimpl(m4041constructorimpl, rowMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
        Updater.m4049setimpl(m4041constructorimpl, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
        if (m4041constructorimpl.getInserting() || !Intrinsics.areEqual(m4041constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
            m4041constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
            m4041constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
        }
        Updater.m4049setimpl(m4041constructorimpl, materializeModifier, ComposeUiNode.Companion.getSetModifier());
        ComposerKt.sourceInformationMarkerStart(composer, -407735110, "C101@5232L9:Row.kt#2w3rfo");
        RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
        ComposerKt.sourceInformationMarkerStart(composer, 587485559, "C1035@43926L529,1049@44532L508,1070@45481L52,1033@43830L1785,1074@45632L123,1079@45875L422,1091@46376L486,1112@47305L52,1077@45772L1667:TimePicker.kt#uh7d8r");
        Modifier.Companion companion = Modifier.Companion;
        ComposerKt.sourceInformationMarkerStart(composer, 1127329796, "CC(remember):TimePicker.kt#9igjgp");
        boolean changed = composer.changed(mutableState) | composer.changedInstance(timePickerState);
        Object rememberedValue = composer.rememberedValue();
        if (changed || rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = (Function1) new Function1<KeyEvent, Boolean>() { // from class: androidx.compose.material3.TimePickerKt$TimeInputImpl$2$1$1$1$1
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Boolean invoke(KeyEvent keyEvent) {
                    return m2764invokeZmokQxo(keyEvent.m5917unboximpl());
                }

                /* renamed from: invoke-ZmokQxo  reason: not valid java name */
                public final Boolean m2764invokeZmokQxo(android.view.KeyEvent keyEvent) {
                    TextFieldValue TimeInputImpl$lambda$182;
                    TextFieldValue TimeInputImpl$lambda$183;
                    int m5930getUtf16CodePointZmokQxo = KeyEvent_androidKt.m5930getUtf16CodePointZmokQxo(keyEvent);
                    if (48 <= m5930getUtf16CodePointZmokQxo && m5930getUtf16CodePointZmokQxo < 58) {
                        TimeInputImpl$lambda$182 = TimePickerKt.TimeInputImpl$lambda$18(mutableState);
                        if (TextRange.m7003getStartimpl(TimeInputImpl$lambda$182.m7253getSelectiond9O1mEE()) == 2) {
                            TimeInputImpl$lambda$183 = TimePickerKt.TimeInputImpl$lambda$18(mutableState);
                            if (TimeInputImpl$lambda$183.getText().length() == 2) {
                                TimePickerState.this.mo1704setSelection6_8s6DQ(TimePickerSelectionMode.Companion.m2783getMinuteyecRtBI());
                            }
                        }
                    }
                    return false;
                }
            };
            composer.updateRememberedValue(rememberedValue);
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        Modifier onKeyEvent = KeyInputModifierKt.onKeyEvent(companion, (Function1) rememberedValue);
        TimeInputImpl$lambda$18 = TimePickerKt.TimeInputImpl$lambda$18(mutableState);
        ComposerKt.sourceInformationMarkerStart(composer, 1127349167, "CC(remember):TimePicker.kt#9igjgp");
        boolean changedInstance = composer.changedInstance(timePickerState) | composer.changed(mutableState) | composer.changedInstance(ref);
        Object rememberedValue2 = composer.rememberedValue();
        if (changedInstance || rememberedValue2 == Composer.Companion.getEmpty()) {
            rememberedValue2 = new Function1() { // from class: androidx.compose.material3.TimePickerKt$TimeInputImpl$2$1$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return TimePickerKt$TimeInputImpl$2$1.invoke$lambda$12$lambda$3$lambda$2(TimePickerState.this, ref, mutableState, (TextFieldValue) obj);
                }
            };
            composer.updateRememberedValue(rememberedValue2);
        }
        Function1 function1 = (Function1) rememberedValue2;
        ComposerKt.sourceInformationMarkerEnd(composer);
        int m2782getHouryecRtBI = TimePickerSelectionMode.Companion.m2782getHouryecRtBI();
        KeyboardOptions keyboardOptions = new KeyboardOptions(0, (Boolean) null, KeyboardType.Companion.m7241getNumberPjHm6EE(), ImeAction.Companion.m7187getNexteUduSuo(), (PlatformImeOptions) null, (Boolean) null, (LocaleList) null, 115, (DefaultConstructorMarker) null);
        ComposerKt.sourceInformationMarkerStart(composer, 1127379079, "CC(remember):TimePicker.kt#9igjgp");
        boolean changedInstance2 = composer.changedInstance(timePickerState);
        Object rememberedValue3 = composer.rememberedValue();
        if (changedInstance2 || rememberedValue3 == Composer.Companion.getEmpty()) {
            rememberedValue3 = new Function1() { // from class: androidx.compose.material3.TimePickerKt$TimeInputImpl$2$1$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return TimePickerKt$TimeInputImpl$2$1.invoke$lambda$12$lambda$5$lambda$4(TimePickerState.this, (KeyboardActionScope) obj);
                }
            };
            composer.updateRememberedValue(rememberedValue3);
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        TimePickerKt.m2753TimePickerTextField1vLObsk(onKeyEvent, TimeInputImpl$lambda$18, function1, timePickerState, m2782getHouryecRtBI, keyboardOptions, new KeyboardActions(null, null, rememberedValue3, null, null, null, 59, null), timePickerColors, composer, 24576, 0);
        f = TimePickerKt.DisplaySeparatorWidth;
        TimePickerKt.DisplaySeparator(SizeKt.m866sizeVpY3zN4(Modifier.Companion, f, TimeInputTokens.INSTANCE.m3806getPeriodSelectorContainerHeightD9Ej5fM()), composer, 6);
        Modifier.Companion companion2 = Modifier.Companion;
        ComposerKt.sourceInformationMarkerStart(composer, 1127392057, "CC(remember):TimePicker.kt#9igjgp");
        boolean changed2 = composer.changed(mutableState2) | composer.changedInstance(timePickerState);
        Object rememberedValue4 = composer.rememberedValue();
        if (changed2 || rememberedValue4 == Composer.Companion.getEmpty()) {
            rememberedValue4 = (Function1) new Function1<KeyEvent, Boolean>() { // from class: androidx.compose.material3.TimePickerKt$TimeInputImpl$2$1$1$4$1
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Boolean invoke(KeyEvent keyEvent) {
                    return m2765invokeZmokQxo(keyEvent.m5917unboximpl());
                }

                /* JADX WARN: Removed duplicated region for block: B:9:0x001b  */
                /* renamed from: invoke-ZmokQxo  reason: not valid java name */
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public final Boolean m2765invokeZmokQxo(android.view.KeyEvent keyEvent) {
                    boolean z;
                    TextFieldValue TimeInputImpl$lambda$222;
                    if (KeyEvent_androidKt.m5930getUtf16CodePointZmokQxo(keyEvent) == 0) {
                        TimeInputImpl$lambda$222 = TimePickerKt.TimeInputImpl$lambda$22(mutableState2);
                        if (TextRange.m7003getStartimpl(TimeInputImpl$lambda$222.m7253getSelectiond9O1mEE()) == 0) {
                            z = true;
                            if (z) {
                                TimePickerState.this.mo1704setSelection6_8s6DQ(TimePickerSelectionMode.Companion.m2782getHouryecRtBI());
                            }
                            return Boolean.valueOf(z);
                        }
                    }
                    z = false;
                    if (z) {
                    }
                    return Boolean.valueOf(z);
                }
            };
            composer.updateRememberedValue(rememberedValue4);
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        Modifier onPreviewKeyEvent = KeyInputModifierKt.onPreviewKeyEvent(companion2, (Function1) rememberedValue4);
        TimeInputImpl$lambda$22 = TimePickerKt.TimeInputImpl$lambda$22(mutableState2);
        ComposerKt.sourceInformationMarkerStart(composer, 1127408153, "CC(remember):TimePicker.kt#9igjgp");
        boolean changedInstance3 = composer.changedInstance(timePickerState) | composer.changed(mutableState2) | composer.changedInstance(ref);
        Object rememberedValue5 = composer.rememberedValue();
        if (changedInstance3 || rememberedValue5 == Composer.Companion.getEmpty()) {
            rememberedValue5 = new Function1() { // from class: androidx.compose.material3.TimePickerKt$TimeInputImpl$2$1$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return TimePickerKt$TimeInputImpl$2$1.invoke$lambda$12$lambda$9$lambda$8(TimePickerState.this, ref, mutableState2, (TextFieldValue) obj);
                }
            };
            composer.updateRememberedValue(rememberedValue5);
        }
        Function1 function12 = rememberedValue5;
        ComposerKt.sourceInformationMarkerEnd(composer);
        int m2783getMinuteyecRtBI = TimePickerSelectionMode.Companion.m2783getMinuteyecRtBI();
        KeyboardOptions keyboardOptions2 = new KeyboardOptions(0, (Boolean) null, KeyboardType.Companion.m7241getNumberPjHm6EE(), ImeAction.Companion.m7185getDoneeUduSuo(), (PlatformImeOptions) null, (Boolean) null, (LocaleList) null, 115, (DefaultConstructorMarker) null);
        ComposerKt.sourceInformationMarkerStart(composer, 1127437447, "CC(remember):TimePicker.kt#9igjgp");
        boolean changedInstance4 = composer.changedInstance(timePickerState);
        Object rememberedValue6 = composer.rememberedValue();
        if (changedInstance4 || rememberedValue6 == Composer.Companion.getEmpty()) {
            rememberedValue6 = new Function1() { // from class: androidx.compose.material3.TimePickerKt$TimeInputImpl$2$1$$ExternalSyntheticLambda5
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return TimePickerKt$TimeInputImpl$2$1.invoke$lambda$12$lambda$11$lambda$10(TimePickerState.this, (KeyboardActionScope) obj);
                }
            };
            composer.updateRememberedValue(rememberedValue6);
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        TimePickerKt.m2753TimePickerTextField1vLObsk(onPreviewKeyEvent, TimeInputImpl$lambda$22, function12, timePickerState, m2783getMinuteyecRtBI, keyboardOptions2, new KeyboardActions(null, null, rememberedValue6, null, null, null, 59, null), timePickerColors, composer, 24576, 0);
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerEnd(composer);
        composer.endNode();
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerEnd(composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit invoke$lambda$12$lambda$3$lambda$2(TimePickerState timePickerState, Ref ref, final MutableState mutableState, TextFieldValue textFieldValue) {
        TextFieldValue TimeInputImpl$lambda$18;
        int m2782getHouryecRtBI = TimePickerSelectionMode.Companion.m2782getHouryecRtBI();
        TimeInputImpl$lambda$18 = TimePickerKt.TimeInputImpl$lambda$18(mutableState);
        TimePickerKt.m2763timeInputOnChange_K77t0(m2782getHouryecRtBI, timePickerState, textFieldValue, TimeInputImpl$lambda$18, timePickerState.is24hour() ? 23 : 12, ref, new Function1() { // from class: androidx.compose.material3.TimePickerKt$TimeInputImpl$2$1$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return TimePickerKt$TimeInputImpl$2$1.invoke$lambda$12$lambda$3$lambda$2$lambda$1(MutableState.this, (TextFieldValue) obj);
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit invoke$lambda$12$lambda$3$lambda$2$lambda$1(MutableState mutableState, TextFieldValue textFieldValue) {
        mutableState.setValue(textFieldValue);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit invoke$lambda$12$lambda$5$lambda$4(TimePickerState timePickerState, KeyboardActionScope keyboardActionScope) {
        timePickerState.mo1704setSelection6_8s6DQ(TimePickerSelectionMode.Companion.m2783getMinuteyecRtBI());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit invoke$lambda$12$lambda$9$lambda$8(TimePickerState timePickerState, Ref ref, final MutableState mutableState, TextFieldValue textFieldValue) {
        TextFieldValue TimeInputImpl$lambda$22;
        int m2783getMinuteyecRtBI = TimePickerSelectionMode.Companion.m2783getMinuteyecRtBI();
        TimeInputImpl$lambda$22 = TimePickerKt.TimeInputImpl$lambda$22(mutableState);
        TimePickerKt.m2763timeInputOnChange_K77t0(m2783getMinuteyecRtBI, timePickerState, textFieldValue, TimeInputImpl$lambda$22, 59, ref, new Function1() { // from class: androidx.compose.material3.TimePickerKt$TimeInputImpl$2$1$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return TimePickerKt$TimeInputImpl$2$1.invoke$lambda$12$lambda$9$lambda$8$lambda$7(MutableState.this, (TextFieldValue) obj);
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit invoke$lambda$12$lambda$9$lambda$8$lambda$7(MutableState mutableState, TextFieldValue textFieldValue) {
        mutableState.setValue(textFieldValue);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit invoke$lambda$12$lambda$11$lambda$10(TimePickerState timePickerState, KeyboardActionScope keyboardActionScope) {
        timePickerState.mo1704setSelection6_8s6DQ(TimePickerSelectionMode.Companion.m2783getMinuteyecRtBI());
        return Unit.INSTANCE;
    }
}
