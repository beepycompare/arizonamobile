package androidx.compose.foundation.layout;

import androidx.compose.foundation.layout.FlowLayoutOverflow;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.media3.exoplayer.RendererCapabilities;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
/* compiled from: FlowLayoutOverflow.kt */
@Deprecated(message = "FlowLayout overflow is no longer maintained")
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0087\u0001\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u00120\b\u0002\u0010\u0007\u001a*\u0012\u0013\u0012\u00110\t¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u000f\u0012\r\u0012\u0004\u0012\u00020\u000e0\r¢\u0006\u0002\b\u000f\u0018\u00010\b\u00120\b\u0002\u0010\u0010\u001a*\u0012\u0013\u0012\u00110\t¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u000f\u0012\r\u0012\u0004\u0012\u00020\u000e0\r¢\u0006\u0002\b\u000f\u0018\u00010\b¢\u0006\u0002\u0010\u0011¨\u0006\u0013"}, d2 = {"Landroidx/compose/foundation/layout/FlowRowOverflow;", "Landroidx/compose/foundation/layout/FlowLayoutOverflow;", "type", "Landroidx/compose/foundation/layout/FlowLayoutOverflow$OverflowType;", "minLinesToShowCollapse", "", "minCrossAxisSizeToShowCollapse", "seeMoreGetter", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/FlowLayoutOverflowState;", "Lkotlin/ParameterName;", "name", RemoteConfigConstants.ResponseFieldKey.STATE, "Lkotlin/Function0;", "", "Landroidx/compose/runtime/Composable;", "collapseGetter", "(Landroidx/compose/foundation/layout/FlowLayoutOverflow$OverflowType;IILkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "Companion", "foundation-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
public final class FlowRowOverflow extends FlowLayoutOverflow {
    public static final int $stable = 0;
    public static final Companion Companion = new Companion(null);
    private static final FlowRowOverflow Visible = new FlowRowOverflow(FlowLayoutOverflow.OverflowType.Visible, 0, 0, null, null, 30, null);
    private static final FlowRowOverflow Clip = new FlowRowOverflow(FlowLayoutOverflow.OverflowType.Clip, 0, 0, null, null, 30, null);

    public /* synthetic */ FlowRowOverflow(FlowLayoutOverflow.OverflowType overflowType, int i, int i2, Function1 function1, Function1 function12, DefaultConstructorMarker defaultConstructorMarker) {
        this(overflowType, i, i2, function1, function12);
    }

    /* synthetic */ FlowRowOverflow(FlowLayoutOverflow.OverflowType overflowType, int i, int i2, Function1 function1, Function1 function12, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(overflowType, (i3 & 2) != 0 ? 0 : i, (i3 & 4) != 0 ? 0 : i2, (i3 & 8) != 0 ? null : function1, (i3 & 16) != 0 ? null : function12);
    }

    private FlowRowOverflow(FlowLayoutOverflow.OverflowType overflowType, int i, int i2, Function1<? super FlowLayoutOverflowState, ? extends Function2<? super Composer, ? super Integer, Unit>> function1, Function1<? super FlowLayoutOverflowState, ? extends Function2<? super Composer, ? super Integer, Unit>> function12) {
        super(overflowType, i, i2, function1, function12, null);
    }

    /* compiled from: FlowLayoutOverflow.kt */
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J+\u0010\u000b\u001a\u00020\u00042\u001c\u0010\f\u001a\u0018\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\r¢\u0006\u0002\b\u0010¢\u0006\u0002\b\u0011H\u0007¢\u0006\u0002\u0010\u0012Jb\u0010\u0013\u001a\u00020\u00042\u001c\u0010\u000b\u001a\u0018\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\r¢\u0006\u0002\b\u0010¢\u0006\u0002\b\u00112\u001c\u0010\u0014\u001a\u0018\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\r¢\u0006\u0002\b\u0010¢\u0006\u0002\b\u00112\b\b\u0002\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u0018H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0019\u0010\u001aR\u001c\u0010\u0003\u001a\u00020\u00048GX\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0005\u0010\u0002\u001a\u0004\b\u0006\u0010\u0007R\u001c\u0010\b\u001a\u00020\u00048GX\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\t\u0010\u0002\u001a\u0004\b\n\u0010\u0007\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u001b"}, d2 = {"Landroidx/compose/foundation/layout/FlowRowOverflow$Companion;", "", "()V", "Clip", "Landroidx/compose/foundation/layout/FlowRowOverflow;", "getClip$annotations", "getClip", "()Landroidx/compose/foundation/layout/FlowRowOverflow;", "Visible", "getVisible$annotations", "getVisible", "expandIndicator", FirebaseAnalytics.Param.CONTENT, "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/FlowRowOverflowScope;", "", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function3;)Landroidx/compose/foundation/layout/FlowRowOverflow;", "expandOrCollapseIndicator", "collapseIndicator", "minRowsToShowCollapse", "", "minHeightToShowCollapse", "Landroidx/compose/ui/unit/Dp;", "expandOrCollapseIndicator--jt2gSs", "(Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function3;IFLandroidx/compose/runtime/Composer;II)Landroidx/compose/foundation/layout/FlowRowOverflow;", "foundation-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ void getClip$annotations() {
        }

        public static /* synthetic */ void getVisible$annotations() {
        }

        private Companion() {
        }

        public final FlowRowOverflow getVisible() {
            return FlowRowOverflow.Visible;
        }

        public final FlowRowOverflow getClip() {
            return FlowRowOverflow.Clip;
        }

        public final FlowRowOverflow expandIndicator(final Function3<? super FlowRowOverflowScope, ? super Composer, ? super Integer, Unit> function3) {
            return new FlowRowOverflow(FlowLayoutOverflow.OverflowType.ExpandIndicator, 0, 0, new Function1<FlowLayoutOverflowState, Function2<? super Composer, ? super Integer, ? extends Unit>>() { // from class: androidx.compose.foundation.layout.FlowRowOverflow$Companion$expandIndicator$seeMoreGetter$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Function2<Composer, Integer, Unit> invoke(final FlowLayoutOverflowState flowLayoutOverflowState) {
                    final Function3<FlowRowOverflowScope, Composer, Integer, Unit> function32 = function3;
                    return ComposableLambdaKt.composableLambdaInstance(263270381, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.layout.FlowRowOverflow$Companion$expandIndicator$seeMoreGetter$1.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                            invoke(composer, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer, int i) {
                            ComposerKt.sourceInformation(composer, "C105@4972L9:FlowLayoutOverflow.kt#2w3rfo");
                            if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
                                composer.skipToGroupEnd();
                                return;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(263270381, i, -1, "androidx.compose.foundation.layout.FlowRowOverflow.Companion.expandIndicator.<anonymous>.<anonymous> (FlowLayoutOverflow.kt:104)");
                            }
                            function32.invoke(new FlowRowOverflowScopeImpl(FlowLayoutOverflowState.this), composer, 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    });
                }
            }, null, 22, null);
        }

        /* renamed from: expandOrCollapseIndicator--jt2gSs  reason: not valid java name */
        public final FlowRowOverflow m686expandOrCollapseIndicatorjt2gSs(final Function3<? super FlowRowOverflowScope, ? super Composer, ? super Integer, Unit> function3, final Function3<? super FlowRowOverflowScope, ? super Composer, ? super Integer, Unit> function32, int i, float f, Composer composer, int i2, int i3) {
            ComposerKt.sourceInformationMarkerStart(composer, -58693346, "C(expandOrCollapseIndicator)P(1!1,3,2:c#ui.unit.Dp)*142@7021L7,143@7089L1079:FlowLayoutOverflow.kt#2w3rfo");
            boolean z = true;
            int i4 = (i3 & 4) != 0 ? 1 : i;
            float m6684constructorimpl = (i3 & 8) != 0 ? Dp.m6684constructorimpl(0) : f;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-58693346, i2, -1, "androidx.compose.foundation.layout.FlowRowOverflow.Companion.expandOrCollapseIndicator (FlowLayoutOverflow.kt:140)");
            }
            ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object consume = composer.consume(CompositionLocalsKt.getLocalDensity());
            ComposerKt.sourceInformationMarkerEnd(composer);
            int mo383roundToPx0680j_4 = ((Density) consume).mo383roundToPx0680j_4(m6684constructorimpl);
            ComposerKt.sourceInformationMarkerStart(composer, -132688784, "CC(remember):FlowLayoutOverflow.kt#9igjgp");
            boolean changed = ((((i2 & 896) ^ RendererCapabilities.DECODER_SUPPORT_MASK) > 256 && composer.changed(i4)) || (i2 & RendererCapabilities.DECODER_SUPPORT_MASK) == 256) | composer.changed(mo383roundToPx0680j_4) | ((((i2 & 14) ^ 6) > 4 && composer.changed(function3)) || (i2 & 6) == 4);
            if ((((i2 & 112) ^ 48) <= 32 || !composer.changed(function32)) && (i2 & 48) != 32) {
                z = false;
            }
            boolean z2 = changed | z;
            Object rememberedValue = composer.rememberedValue();
            if (z2 || rememberedValue == Composer.Companion.getEmpty()) {
                FlowRowOverflow flowRowOverflow = new FlowRowOverflow(FlowLayoutOverflow.OverflowType.ExpandOrCollapseIndicator, i4, mo383roundToPx0680j_4, new Function1<FlowLayoutOverflowState, Function2<? super Composer, ? super Integer, ? extends Unit>>() { // from class: androidx.compose.foundation.layout.FlowRowOverflow$Companion$expandOrCollapseIndicator$1$seeMoreGetter$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Function2<Composer, Integer, Unit> invoke(final FlowLayoutOverflowState flowLayoutOverflowState) {
                        final Function3<FlowRowOverflowScope, Composer, Integer, Unit> function33 = function3;
                        return ComposableLambdaKt.composableLambdaInstance(2094557836, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.layout.FlowRowOverflow$Companion$expandOrCollapseIndicator$1$seeMoreGetter$1.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                                invoke(composer2, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer2, int i5) {
                                ComposerKt.sourceInformation(composer2, "C152@7468L17:FlowLayoutOverflow.kt#2w3rfo");
                                if (!composer2.shouldExecute((i5 & 3) != 2, i5 & 1)) {
                                    composer2.skipToGroupEnd();
                                    return;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(2094557836, i5, -1, "androidx.compose.foundation.layout.FlowRowOverflow.Companion.expandOrCollapseIndicator.<anonymous>.<anonymous>.<anonymous> (FlowLayoutOverflow.kt:151)");
                                }
                                function33.invoke(new FlowRowOverflowScopeImpl(FlowLayoutOverflowState.this), composer2, 0);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        });
                    }
                }, new Function1<FlowLayoutOverflowState, Function2<? super Composer, ? super Integer, ? extends Unit>>() { // from class: androidx.compose.foundation.layout.FlowRowOverflow$Companion$expandOrCollapseIndicator$1$collapseGetter$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Function2<Composer, Integer, Unit> invoke(final FlowLayoutOverflowState flowLayoutOverflowState) {
                        final Function3<FlowRowOverflowScope, Composer, Integer, Unit> function33 = function32;
                        return ComposableLambdaKt.composableLambdaInstance(-972285589, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.layout.FlowRowOverflow$Companion$expandOrCollapseIndicator$1$collapseGetter$1.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                                invoke(composer2, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer2, int i5) {
                                ComposerKt.sourceInformation(composer2, "C159@7732L19:FlowLayoutOverflow.kt#2w3rfo");
                                if (!composer2.shouldExecute((i5 & 3) != 2, i5 & 1)) {
                                    composer2.skipToGroupEnd();
                                    return;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-972285589, i5, -1, "androidx.compose.foundation.layout.FlowRowOverflow.Companion.expandOrCollapseIndicator.<anonymous>.<anonymous>.<anonymous> (FlowLayoutOverflow.kt:158)");
                                }
                                function33.invoke(new FlowRowOverflowScopeImpl(FlowLayoutOverflowState.this), composer2, 0);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        });
                    }
                }, null);
                composer.updateRememberedValue(flowRowOverflow);
                rememberedValue = flowRowOverflow;
            }
            FlowRowOverflow flowRowOverflow2 = (FlowRowOverflow) rememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composer);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            return flowRowOverflow2;
        }
    }
}
