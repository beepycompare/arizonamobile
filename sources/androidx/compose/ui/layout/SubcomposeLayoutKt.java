package androidx.compose.ui.layout;

import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionContext;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.unit.Constraints;
import androidx.media3.exoplayer.RendererCapabilities;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
/* compiled from: SubcomposeLayout.kt */
@Metadata(d1 = {"\u0000M\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000*\u0001\u0013\u001a6\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u001d\u0010\u0004\u001a\u0019\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0005¢\u0006\u0002\b\tH\u0007¢\u0006\u0002\u0010\n\u001a>\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u001d\u0010\u0004\u001a\u0019\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0005¢\u0006\u0002\b\tH\u0007¢\u0006\u0002\u0010\r\u001a\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011\"\u0010\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0014\"\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0017\u001a\u00020\u0018X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"SubcomposeLayout", "", "modifier", "Landroidx/compose/ui/Modifier;", "measurePolicy", "Lkotlin/Function2;", "Landroidx/compose/ui/layout/SubcomposeMeasureScope;", "Landroidx/compose/ui/unit/Constraints;", "Landroidx/compose/ui/layout/MeasureResult;", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", RemoteConfigConstants.ResponseFieldKey.STATE, "Landroidx/compose/ui/layout/SubcomposeLayoutState;", "(Landroidx/compose/ui/layout/SubcomposeLayoutState;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "SubcomposeSlotReusePolicy", "Landroidx/compose/ui/layout/SubcomposeSlotReusePolicy;", "maxSlotsToRetainForReuse", "", "ReusedSlotId", "androidx/compose/ui/layout/SubcomposeLayoutKt$ReusedSlotId$1", "Landroidx/compose/ui/layout/SubcomposeLayoutKt$ReusedSlotId$1;", "UnspecifiedSlotId", "", "ExtraLoggingEnabled", "", "ui"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class SubcomposeLayoutKt {
    private static final boolean ExtraLoggingEnabled = false;
    private static final SubcomposeLayoutKt$ReusedSlotId$1 ReusedSlotId = new Object() { // from class: androidx.compose.ui.layout.SubcomposeLayoutKt$ReusedSlotId$1
        public String toString() {
            return "ReusedSlotId";
        }
    };
    private static final Object UnspecifiedSlotId = new Object();

    public static final /* synthetic */ SubcomposeLayoutKt$ReusedSlotId$1 access$getReusedSlotId$p() {
        return ReusedSlotId;
    }

    public static final /* synthetic */ Object access$getUnspecifiedSlotId$p() {
        return UnspecifiedSlotId;
    }

    public static final void SubcomposeLayout(final Modifier modifier, Function2<? super SubcomposeMeasureScope, ? super Constraints, ? extends MeasureResult> function2, Composer composer, final int i, final int i2) {
        int i3;
        final Function2<? super SubcomposeMeasureScope, ? super Constraints, ? extends MeasureResult> function22;
        Composer startRestartGroup = composer.startRestartGroup(-1298353104);
        ComposerKt.sourceInformation(startRestartGroup, "C(SubcomposeLayout)P(1)97@4796L36,96@4762L145:SubcomposeLayout.kt#80mrfh");
        int i4 = i2 & 1;
        if (i4 != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (startRestartGroup.changed(modifier) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= startRestartGroup.changedInstance(function2) ? 32 : 16;
        }
        if (!startRestartGroup.shouldExecute((i3 & 19) != 18, i3 & 1)) {
            function22 = function2;
            startRestartGroup.skipToGroupEnd();
        } else {
            if (i4 != 0) {
                modifier = Modifier.Companion;
            }
            Modifier modifier2 = modifier;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1298353104, i3, -1, "androidx.compose.ui.layout.SubcomposeLayout (SubcomposeLayout.kt:95)");
            }
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2118155764, "CC(remember):SubcomposeLayout.kt#9igjgp");
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new SubcomposeLayoutState();
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            function22 = function2;
            SubcomposeLayout((SubcomposeLayoutState) rememberedValue, modifier2, function22, startRestartGroup, (i3 << 3) & 1008, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier = modifier2;
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.ui.layout.SubcomposeLayoutKt$SubcomposeLayout$2
                /* JADX INFO: Access modifiers changed from: package-private */
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
                    SubcomposeLayoutKt.SubcomposeLayout(Modifier.this, function22, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                }
            });
        }
    }

    public static final void SubcomposeLayout(final SubcomposeLayoutState subcomposeLayoutState, Modifier modifier, final Function2<? super SubcomposeMeasureScope, ? super Constraints, ? extends MeasureResult> function2, Composer composer, final int i, final int i2) {
        int i3;
        Composer startRestartGroup = composer.startRestartGroup(-511989831);
        ComposerKt.sourceInformation(startRestartGroup, "C(SubcomposeLayout)P(2,1)129@6259L27,130@6327L28,133@6483L492:SubcomposeLayout.kt#80mrfh");
        if ((i & 6) == 0) {
            i3 = (startRestartGroup.changedInstance(subcomposeLayoutState) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i4 = i2 & 2;
        if (i4 != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            i3 |= startRestartGroup.changed(modifier) ? 32 : 16;
        }
        if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i3 |= startRestartGroup.changedInstance(function2) ? 256 : 128;
        }
        if (!startRestartGroup.shouldExecute((i3 & 147) != 146, i3 & 1)) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (i4 != 0) {
                modifier = Modifier.Companion;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-511989831, i3, -1, "androidx.compose.ui.layout.SubcomposeLayout (SubcomposeLayout.kt:128)");
            }
            int hashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(startRestartGroup, 0));
            CompositionContext rememberCompositionContext = ComposablesKt.rememberCompositionContext(startRestartGroup, 0);
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, modifier);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Function0<LayoutNode> constructor$ui = LayoutNode.Companion.getConstructor$ui();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1405779621, "CC(ReusableComposeNode)N(factory,update):Composables.kt#9igjgp");
            if (!(startRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(constructor$ui);
            } else {
                startRestartGroup.useNode();
            }
            Composer m4673constructorimpl = Updater.m4673constructorimpl(startRestartGroup);
            Updater.m4681setimpl(m4673constructorimpl, subcomposeLayoutState, subcomposeLayoutState.getSetRoot$ui());
            Updater.m4681setimpl(m4673constructorimpl, rememberCompositionContext, subcomposeLayoutState.getSetCompositionContext$ui());
            Updater.m4681setimpl(m4673constructorimpl, function2, subcomposeLayoutState.getSetMeasurePolicy$ui());
            Updater.m4681setimpl(m4673constructorimpl, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.m4679reconcileimpl(m4673constructorimpl, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.m4681setimpl(m4673constructorimpl, materializeModifier, ComposeUiNode.Companion.getSetModifier());
            Updater.m4677initimpl(m4673constructorimpl, Integer.valueOf(hashCode), ComposeUiNode.Companion.getSetCompositeKeyHash());
            startRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            if (startRestartGroup.getSkipping()) {
                startRestartGroup.startReplaceGroup(-1266202711);
            } else {
                startRestartGroup.startReplaceGroup(-1259244916);
                ComposerKt.sourceInformation(startRestartGroup, "146@7032L34,146@7021L45");
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1899042491, "CC(remember):SubcomposeLayout.kt#9igjgp");
                boolean changedInstance = startRestartGroup.changedInstance(subcomposeLayoutState);
                Object rememberedValue = startRestartGroup.rememberedValue();
                if (changedInstance || rememberedValue == Composer.Companion.getEmpty()) {
                    rememberedValue = (Function0) new Function0<Unit>() { // from class: androidx.compose.ui.layout.SubcomposeLayoutKt$SubcomposeLayout$4$1
                        /* JADX INFO: Access modifiers changed from: package-private */
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Unit invoke() {
                            invoke2();
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke  reason: avoid collision after fix types in other method */
                        public final void invoke2() {
                            SubcomposeLayoutState.this.forceRecomposeChildren$ui();
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                EffectsKt.SideEffect((Function0) rememberedValue, startRestartGroup, 0);
            }
            startRestartGroup.endReplaceGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        final Modifier modifier2 = modifier;
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.ui.layout.SubcomposeLayoutKt$SubcomposeLayout$5
                /* JADX INFO: Access modifiers changed from: package-private */
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
                    SubcomposeLayoutKt.SubcomposeLayout(SubcomposeLayoutState.this, modifier2, function2, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                }
            });
        }
    }

    public static final SubcomposeSlotReusePolicy SubcomposeSlotReusePolicy(int i) {
        return new FixedCountSubcomposeSlotReusePolicy(i);
    }
}
