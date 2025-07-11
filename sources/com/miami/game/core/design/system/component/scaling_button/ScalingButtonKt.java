package com.miami.game.core.design.system.component.scaling_button;

import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ScaleKt;
import androidx.compose.ui.input.pointer.PointerInputEventHandler;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.media3.exoplayer.RendererCapabilities;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.miami.game.core.ui.utils.extensions.ClickIndicationType;
import com.miami.game.core.ui.utils.extensions.ComposeExtensionsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: ScalingButton.kt */
@Metadata(d1 = {"\u00002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\u001aC\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u001c\u0010\u0006\u001a\u0018\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00010\u0007¢\u0006\u0002\b\t¢\u0006\u0002\b\nH\u0007¢\u0006\u0002\u0010\u000b\u001aQ\u0010\f\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u001c\u0010\u0006\u001a\u0018\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00010\u0007¢\u0006\u0002\b\t¢\u0006\u0002\b\nH\u0007¢\u0006\u0002\u0010\u000e¨\u0006\u000f²\u0006\n\u0010\u0010\u001a\u00020\u0011X\u008a\u008e\u0002²\u0006\n\u0010\u0012\u001a\u00020\u0013X\u008a\u0084\u0002²\u0006\n\u0010\u0010\u001a\u00020\u0011X\u008a\u008e\u0002²\u0006\n\u0010\u0012\u001a\u00020\u0013X\u008a\u0084\u0002"}, d2 = {"ScalingButton", "", "onClick", "Lkotlin/Function0;", "modifier", "Landroidx/compose/ui/Modifier;", FirebaseAnalytics.Param.CONTENT, "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/BoxScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "ScalingButtonLong", "onLongClick", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "design-system_release_web", "selected", "", "scale", ""}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ScalingButtonKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ScalingButton$lambda$8(Function0 function0, Modifier modifier, Function3 function3, int i, int i2, Composer composer, int i3) {
        ScalingButton(function0, modifier, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ScalingButtonLong$lambda$15(Function0 function0, Function0 function02, Modifier modifier, Function3 function3, int i, int i2, Composer composer, int i3) {
        ScalingButtonLong(function0, function02, modifier, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0206  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0210  */
    /* JADX WARN: Removed duplicated region for block: B:80:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void ScalingButton(final Function0<Unit> onClick, Modifier modifier, final Function3<? super BoxScope, ? super Composer, ? super Integer, Unit> content, Composer composer, final int i, final int i2) {
        int i3;
        Object obj;
        final Modifier modifier2;
        ScopeUpdateScope endRestartGroup;
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        Intrinsics.checkNotNullParameter(content, "content");
        Composer startRestartGroup = composer.startRestartGroup(-1580402014);
        ComposerKt.sourceInformation(startRestartGroup, "C(ScalingButton)P(2,1)21@1029L34,22@1081L59,27@1237L308,39@1656L48,24@1146L590:ScalingButton.kt#ghwacp");
        if ((i & 6) == 0) {
            i3 = (startRestartGroup.changedInstance(onClick) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i4 = i2 & 2;
        if (i4 != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            obj = modifier;
            i3 |= startRestartGroup.changed(obj) ? 32 : 16;
            if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
                i3 |= startRestartGroup.changedInstance(content) ? 256 : 128;
            }
            if (startRestartGroup.shouldExecute((i3 & 147) == 146, i3 & 1)) {
                startRestartGroup.skipToGroupEnd();
                modifier2 = obj;
            } else {
                Modifier.Companion companion = i4 != 0 ? Modifier.Companion : obj;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1580402014, i3, -1, "com.miami.game.core.design.system.component.scaling_button.ScalingButton (ScalingButton.kt:20)");
                }
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1652092004, "CC(remember):ScalingButton.kt#9igjgp");
                Object rememberedValue = startRestartGroup.rememberedValue();
                if (rememberedValue == Composer.Companion.getEmpty()) {
                    rememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                    startRestartGroup.updateRememberedValue(rememberedValue);
                }
                MutableState mutableState = (MutableState) rememberedValue;
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                Modifier modifier3 = companion;
                Modifier scale = ScaleKt.scale(modifier3, ScalingButton$lambda$3(AnimateAsStateKt.animateFloatAsState(ScalingButton$lambda$1(mutableState) ? 0.9f : 1.0f, null, 0.0f, "", null, startRestartGroup, 3072, 22)));
                Unit unit = Unit.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1652098934, "CC(remember):ScalingButton.kt#9igjgp");
                ScalingButtonKt$ScalingButton$1$1 rememberedValue2 = startRestartGroup.rememberedValue();
                if (rememberedValue2 == Composer.Companion.getEmpty()) {
                    rememberedValue2 = new ScalingButtonKt$ScalingButton$1$1(mutableState);
                    startRestartGroup.updateRememberedValue(rememberedValue2);
                }
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                Modifier pointerInput = SuspendingPointerInputFilterKt.pointerInput(scale, unit, (PointerInputEventHandler) rememberedValue2);
                ClickIndicationType clickIndicationType = ClickIndicationType.NO_INDICATION;
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1652112082, "CC(remember):ScalingButton.kt#9igjgp");
                boolean z = (i3 & 14) == 4;
                Object rememberedValue3 = startRestartGroup.rememberedValue();
                if (z || rememberedValue3 == Composer.Companion.getEmpty()) {
                    rememberedValue3 = new Function0() { // from class: com.miami.game.core.design.system.component.scaling_button.ScalingButtonKt$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit ScalingButton$lambda$6$lambda$5;
                            ScalingButton$lambda$6$lambda$5 = ScalingButtonKt.ScalingButton$lambda$6$lambda$5(Function0.this);
                            return ScalingButton$lambda$6$lambda$5;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue3);
                }
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                Modifier clickWithDelay$default = ComposeExtensionsKt.clickWithDelay$default(pointerInput, false, 0L, clickIndicationType, (Function0) rememberedValue3, 3, null);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
                Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, clickWithDelay$default);
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
                Composer m3520constructorimpl = Updater.m3520constructorimpl(startRestartGroup);
                Updater.m3527setimpl(m3520constructorimpl, maybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.m3527setimpl(m3520constructorimpl, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
                if (m3520constructorimpl.getInserting() || !Intrinsics.areEqual(m3520constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                    m3520constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    m3520constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                }
                Updater.m3527setimpl(m3520constructorimpl, materializeModifier, ComposeUiNode.Companion.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2082558462, "C43@1721L9:ScalingButton.kt#ghwacp");
                content.invoke(BoxScopeInstance.INSTANCE, startRestartGroup, Integer.valueOf(((i3 >> 3) & 112) | 6));
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                startRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier2 = modifier3;
            }
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup == null) {
                endRestartGroup.updateScope(new Function2() { // from class: com.miami.game.core.design.system.component.scaling_button.ScalingButtonKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj2, Object obj3) {
                        Unit ScalingButton$lambda$8;
                        ScalingButton$lambda$8 = ScalingButtonKt.ScalingButton$lambda$8(Function0.this, modifier2, content, i, i2, (Composer) obj2, ((Integer) obj3).intValue());
                        return ScalingButton$lambda$8;
                    }
                });
                return;
            }
            return;
        }
        obj = modifier;
        if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
        }
        if (startRestartGroup.shouldExecute((i3 & 147) == 146, i3 & 1)) {
        }
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    private static final boolean ScalingButton$lambda$1(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ScalingButton$lambda$2(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ScalingButton$lambda$6$lambda$5(Function0 function0) {
        function0.invoke();
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x01ff  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0209  */
    /* JADX WARN: Removed duplicated region for block: B:88:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void ScalingButtonLong(final Function0<Unit> onClick, final Function0<Unit> onLongClick, Modifier modifier, final Function3<? super BoxScope, ? super Composer, ? super Integer, Unit> content, Composer composer, final int i, final int i2) {
        int i3;
        Object obj;
        final Modifier modifier2;
        ScopeUpdateScope endRestartGroup;
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        Intrinsics.checkNotNullParameter(onLongClick, "onLongClick");
        Intrinsics.checkNotNullParameter(content, "content");
        Composer startRestartGroup = composer.startRestartGroup(-160934982);
        ComposerKt.sourceInformation(startRestartGroup, "C(ScalingButtonLong)P(2,3,1)49@1912L34,50@1964L59,55@2120L656,52@2029L779:ScalingButton.kt#ghwacp");
        if ((i & 6) == 0) {
            i3 = (startRestartGroup.changedInstance(onClick) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= startRestartGroup.changedInstance(onLongClick) ? 32 : 16;
        }
        int i4 = i2 & 4;
        if (i4 != 0) {
            i3 |= RendererCapabilities.DECODER_SUPPORT_MASK;
        } else if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            obj = modifier;
            i3 |= startRestartGroup.changed(obj) ? 256 : 128;
            if ((i & 3072) == 0) {
                i3 |= startRestartGroup.changedInstance(content) ? 2048 : 1024;
            }
            if (startRestartGroup.shouldExecute((i3 & 1171) == 1170, i3 & 1)) {
                startRestartGroup.skipToGroupEnd();
                modifier2 = obj;
            } else {
                Modifier.Companion companion = i4 != 0 ? Modifier.Companion : obj;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-160934982, i3, -1, "com.miami.game.core.design.system.component.scaling_button.ScalingButtonLong (ScalingButton.kt:48)");
                }
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -39689508, "CC(remember):ScalingButton.kt#9igjgp");
                Object rememberedValue = startRestartGroup.rememberedValue();
                if (rememberedValue == Composer.Companion.getEmpty()) {
                    rememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                    startRestartGroup.updateRememberedValue(rememberedValue);
                }
                MutableState mutableState = (MutableState) rememberedValue;
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                Modifier modifier3 = companion;
                Modifier scale = ScaleKt.scale(modifier3, ScalingButtonLong$lambda$12(AnimateAsStateKt.animateFloatAsState(ScalingButtonLong$lambda$10(mutableState) ? 0.9f : 1.0f, null, 0.0f, "", null, startRestartGroup, 3072, 22)));
                Unit unit = Unit.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -39682230, "CC(remember):ScalingButton.kt#9igjgp");
                boolean z = ((i3 & 112) == 32) | ((i3 & 14) == 4);
                ScalingButtonKt$ScalingButtonLong$1$1 rememberedValue2 = startRestartGroup.rememberedValue();
                if (z || rememberedValue2 == Composer.Companion.getEmpty()) {
                    rememberedValue2 = new ScalingButtonKt$ScalingButtonLong$1$1(onLongClick, mutableState, onClick);
                    startRestartGroup.updateRememberedValue(rememberedValue2);
                }
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                Modifier pointerInput = SuspendingPointerInputFilterKt.pointerInput(scale, unit, (PointerInputEventHandler) rememberedValue2);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
                Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, pointerInput);
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
                Composer m3520constructorimpl = Updater.m3520constructorimpl(startRestartGroup);
                Updater.m3527setimpl(m3520constructorimpl, maybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.m3527setimpl(m3520constructorimpl, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
                if (m3520constructorimpl.getInserting() || !Intrinsics.areEqual(m3520constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                    m3520constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    m3520constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                }
                Updater.m3527setimpl(m3520constructorimpl, materializeModifier, ComposeUiNode.Companion.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -59064474, "C76@2793L9:ScalingButton.kt#ghwacp");
                content.invoke(BoxScopeInstance.INSTANCE, startRestartGroup, Integer.valueOf(((i3 >> 6) & 112) | 6));
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                startRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier2 = modifier3;
            }
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup == null) {
                endRestartGroup.updateScope(new Function2() { // from class: com.miami.game.core.design.system.component.scaling_button.ScalingButtonKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj2, Object obj3) {
                        Unit ScalingButtonLong$lambda$15;
                        ScalingButtonLong$lambda$15 = ScalingButtonKt.ScalingButtonLong$lambda$15(Function0.this, onLongClick, modifier2, content, i, i2, (Composer) obj2, ((Integer) obj3).intValue());
                        return ScalingButtonLong$lambda$15;
                    }
                });
                return;
            }
            return;
        }
        obj = modifier;
        if ((i & 3072) == 0) {
        }
        if (startRestartGroup.shouldExecute((i3 & 1171) == 1170, i3 & 1)) {
        }
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    private static final boolean ScalingButtonLong$lambda$10(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ScalingButtonLong$lambda$11(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    private static final float ScalingButton$lambda$3(State<Float> state) {
        return state.getValue().floatValue();
    }

    private static final float ScalingButtonLong$lambda$12(State<Float> state) {
        return state.getValue().floatValue();
    }
}
