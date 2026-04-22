package androidx.compose.material3;

import androidx.collection.IntList;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material3.TimePickerKt$ClockFace$1;
import androidx.compose.material3.tokens.TimePickerTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.layout.LayoutIdKt;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TimePicker.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class TimePickerKt$ClockFace$1 implements Function3<IntList, Composer, Integer, Unit> {
    final /* synthetic */ boolean $autoSwitchToMinute;
    final /* synthetic */ TimePickerColors $colors;
    final /* synthetic */ AnalogTimePickerState $state;

    /* JADX INFO: Access modifiers changed from: package-private */
    public TimePickerKt$ClockFace$1(TimePickerColors timePickerColors, AnalogTimePickerState analogTimePickerState, boolean z) {
        this.$colors = timePickerColors;
        this.$state = analogTimePickerState;
        this.$autoSwitchToMinute = z;
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Unit invoke(IntList intList, Composer composer, Integer num) {
        invoke(intList, composer, num.intValue());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit invoke$lambda$1$lambda$0(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        SemanticsPropertiesKt.selectableGroup(semanticsPropertyReceiver);
        return Unit.INSTANCE;
    }

    public final void invoke(final IntList intList, Composer composer, int i) {
        float f;
        ComposerKt.sourceInformation(composer, "CN(screen)1610@63493L21,1612@63582L1852,1609@63406L2028:TimePicker.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(747010833, i, -1, "androidx.compose.material3.ClockFace.<anonymous> (TimePicker.kt:1609)");
        }
        Modifier m864size3ABfNKs = SizeKt.m864size3ABfNKs(Modifier.Companion, TimePickerTokens.INSTANCE.m3812getClockDialContainerSizeD9Ej5fM());
        ComposerKt.sourceInformationMarkerStart(composer, 617875526, "CC(remember):TimePicker.kt#9igjgp");
        Object rememberedValue = composer.rememberedValue();
        if (rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = new Function1() { // from class: androidx.compose.material3.TimePickerKt$ClockFace$1$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return TimePickerKt$ClockFace$1.invoke$lambda$1$lambda$0((SemanticsPropertyReceiver) obj);
                }
            };
            composer.updateRememberedValue(rememberedValue);
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        Modifier semantics$default = SemanticsModifierKt.semantics$default(m864size3ABfNKs, false, (Function1) rememberedValue, 1, null);
        f = TimePickerKt.OuterCircleToSizeRatio;
        final TimePickerColors timePickerColors = this.$colors;
        final AnalogTimePickerState analogTimePickerState = this.$state;
        final boolean z = this.$autoSwitchToMinute;
        TimePickerKt.CircularLayout(semantics$default, f, ComposableLambdaKt.rememberComposableLambda(-99063847, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TimePickerKt$ClockFace$1.2
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                invoke(composer2, num.intValue());
                return Unit.INSTANCE;
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            /* compiled from: TimePicker.kt */
            @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
            /* renamed from: androidx.compose.material3.TimePickerKt$ClockFace$1$2$1  reason: invalid class name */
            /* loaded from: classes.dex */
            public static final class AnonymousClass1 implements Function2<Composer, Integer, Unit> {
                final /* synthetic */ boolean $autoSwitchToMinute;
                final /* synthetic */ IntList $screen;
                final /* synthetic */ AnalogTimePickerState $state;

                AnonymousClass1(IntList intList, AnalogTimePickerState analogTimePickerState, boolean z) {
                    this.$screen = intList;
                    this.$state = analogTimePickerState;
                    this.$autoSwitchToMinute = z;
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer, int i) {
                    float f;
                    int i2;
                    ComposerKt.sourceInformation(composer, "C:TimePicker.kt#uh7d8r");
                    if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
                        composer.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-596940007, i, -1, "androidx.compose.material3.ClockFace.<anonymous>.<anonymous>.<anonymous> (TimePicker.kt:1616)");
                    }
                    composer.startReplaceGroup(1866272144);
                    ComposerKt.sourceInformation(composer, "*1624@64134L41,1623@64069L277");
                    int i3 = this.$screen._size;
                    AnalogTimePickerState analogTimePickerState = this.$state;
                    IntList intList = this.$screen;
                    boolean z = this.$autoSwitchToMinute;
                    for (final int i4 = 0; i4 < i3; i4++) {
                        if (!analogTimePickerState.is24hour() || TimePickerSelectionMode.m2778equalsimpl0(analogTimePickerState.mo1702getSelectionyecRtBI(), TimePickerSelectionMode.Companion.m2783getMinuteyecRtBI())) {
                            i2 = intList.get(i4);
                        } else {
                            i2 = intList.get(i4) % 12;
                        }
                        Modifier.Companion companion = Modifier.Companion;
                        ComposerKt.sourceInformationMarkerStart(composer, -121641742, "CC(remember):TimePicker.kt#9igjgp");
                        boolean changed = composer.changed(i4);
                        Object rememberedValue = composer.rememberedValue();
                        if (changed || rememberedValue == Composer.Companion.getEmpty()) {
                            rememberedValue = new Function1() { // from class: androidx.compose.material3.TimePickerKt$ClockFace$1$2$1$$ExternalSyntheticLambda0
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return TimePickerKt$ClockFace$1.AnonymousClass2.AnonymousClass1.invoke$lambda$2$lambda$1$lambda$0(i4, (SemanticsPropertyReceiver) obj);
                                }
                            };
                            composer.updateRememberedValue(rememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composer);
                        TimePickerKt.ClockText(SemanticsModifierKt.semantics$default(companion, false, (Function1) rememberedValue, 1, null), analogTimePickerState, i2, z, composer, 0);
                    }
                    composer.endReplaceGroup();
                    if (TimePickerSelectionMode.m2778equalsimpl0(this.$state.mo1702getSelectionyecRtBI(), TimePickerSelectionMode.Companion.m2782getHouryecRtBI()) && this.$state.is24hour()) {
                        composer.startReplaceGroup(2020585964);
                        ComposerKt.sourceInformation(composer, "1638@64839L553,1632@64475L917");
                        Modifier m263backgroundbw27NRU = BackgroundKt.m263backgroundbw27NRU(SizeKt.m864size3ABfNKs(LayoutIdKt.layoutId(Modifier.Companion, LayoutId.InnerCircle), TimePickerTokens.INSTANCE.m3812getClockDialContainerSizeD9Ej5fM()), Color.Companion.m4807getTransparent0d7_KjU(), RoundedCornerShapeKt.getCircleShape());
                        f = TimePickerKt.InnerCircleToSizeRatio;
                        TimePickerKt.CircularLayout(m263backgroundbw27NRU, f, ComposableLambdaKt.rememberComposableLambda(-1385767514, true, new C00212(this.$state, this.$autoSwitchToMinute), composer, 54), composer, 432, 0);
                        composer.endReplaceGroup();
                    } else {
                        composer.startReplaceGroup(2021505641);
                        composer.endReplaceGroup();
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }

                /* JADX INFO: Access modifiers changed from: package-private */
                public static final Unit invoke$lambda$2$lambda$1$lambda$0(int i, SemanticsPropertyReceiver semanticsPropertyReceiver) {
                    SemanticsPropertiesKt.setTraversalIndex(semanticsPropertyReceiver, i + 1.0f);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: Access modifiers changed from: package-private */
                /* compiled from: TimePicker.kt */
                @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
                /* renamed from: androidx.compose.material3.TimePickerKt$ClockFace$1$2$1$2  reason: invalid class name and collision with other inner class name */
                /* loaded from: classes.dex */
                public static final class C00212 implements Function2<Composer, Integer, Unit> {
                    final /* synthetic */ boolean $autoSwitchToMinute;
                    final /* synthetic */ AnalogTimePickerState $state;

                    C00212(AnalogTimePickerState analogTimePickerState, boolean z) {
                        this.$state = analogTimePickerState;
                        this.$autoSwitchToMinute = z;
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                        invoke(composer, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer, int i) {
                        IntList intList;
                        IntList intList2;
                        ComposerKt.sourceInformation(composer, "C*1643@65100L41,1641@64991L353:TimePicker.kt#uh7d8r");
                        if (composer.shouldExecute((i & 3) != 2, i & 1)) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1385767514, i, -1, "androidx.compose.material3.ClockFace.<anonymous>.<anonymous>.<anonymous>.<anonymous> (TimePicker.kt:1639)");
                            }
                            intList = TimePickerKt.ExtraHours;
                            int i2 = intList._size;
                            AnalogTimePickerState analogTimePickerState = this.$state;
                            boolean z = this.$autoSwitchToMinute;
                            for (final int i3 = 0; i3 < i2; i3++) {
                                intList2 = TimePickerKt.ExtraHours;
                                int i4 = intList2.get(i3);
                                Modifier.Companion companion = Modifier.Companion;
                                ComposerKt.sourceInformationMarkerStart(composer, -1870016769, "CC(remember):TimePicker.kt#9igjgp");
                                boolean changed = composer.changed(i3);
                                Object rememberedValue = composer.rememberedValue();
                                if (changed || rememberedValue == Composer.Companion.getEmpty()) {
                                    rememberedValue = new Function1() { // from class: androidx.compose.material3.TimePickerKt$ClockFace$1$2$1$2$$ExternalSyntheticLambda0
                                        @Override // kotlin.jvm.functions.Function1
                                        public final Object invoke(Object obj) {
                                            return TimePickerKt$ClockFace$1.AnonymousClass2.AnonymousClass1.C00212.invoke$lambda$2$lambda$1$lambda$0(i3, (SemanticsPropertyReceiver) obj);
                                        }
                                    };
                                    composer.updateRememberedValue(rememberedValue);
                                }
                                ComposerKt.sourceInformationMarkerEnd(composer);
                                TimePickerKt.ClockText(SemanticsModifierKt.semantics$default(companion, false, (Function1) rememberedValue, 1, null), analogTimePickerState, i4, z, composer, 0);
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                                return;
                            }
                            return;
                        }
                        composer.skipToGroupEnd();
                    }

                    /* JADX INFO: Access modifiers changed from: package-private */
                    public static final Unit invoke$lambda$2$lambda$1$lambda$0(int i, SemanticsPropertyReceiver semanticsPropertyReceiver) {
                        SemanticsPropertiesKt.setTraversalIndex(semanticsPropertyReceiver, 12.0f + i);
                        return Unit.INSTANCE;
                    }
                }
            }

            public final void invoke(Composer composer2, int i2) {
                ComposerKt.sourceInformation(composer2, "C1615@63715L1709,1613@63596L1828:TimePicker.kt#uh7d8r");
                if (!composer2.shouldExecute((i2 & 3) != 2, i2 & 1)) {
                    composer2.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-99063847, i2, -1, "androidx.compose.material3.ClockFace.<anonymous>.<anonymous> (TimePicker.kt:1613)");
                }
                CompositionLocalKt.CompositionLocalProvider(ContentColorKt.getLocalContentColor().provides(Color.m4762boximpl(TimePickerColors.this.m2716clockDialContentColorvNxB06k$material3(false))), ComposableLambdaKt.rememberComposableLambda(-596940007, true, new AnonymousClass1(intList, analogTimePickerState, z), composer2, 54), composer2, ProvidedValue.$stable | 48);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }, composer, 54), composer, 432, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
    }
}
