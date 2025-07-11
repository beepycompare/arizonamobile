package com.miami.game.feature.settings.ui.compose;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderKt;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
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
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.unit.Dp;
import androidx.media3.exoplayer.RendererCapabilities;
import com.miami.game.core.design.system.component.scaling_button.ScalingButtonKt;
import com.miami.game.feature.settings.R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: SwitchButton.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u001a+\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007¢\u0006\u0002\u0010\b\u001a\u0015\u0010\t\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u0007H\u0007¢\u0006\u0002\u0010\n¨\u0006\u000b"}, d2 = {"SwitchButton", "", "text", "", "onClick", "Lkotlin/Function0;", "checked", "", "(Ljava/lang/String;Lkotlin/jvm/functions/Function0;ZLandroidx/compose/runtime/Composer;I)V", "CustomToggleSwitch", "(ZLandroidx/compose/runtime/Composer;I)V", "settings_release_web"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class SwitchButtonKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CustomToggleSwitch$lambda$4(boolean z, int i, Composer composer, int i2) {
        CustomToggleSwitch(z, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SwitchButton$lambda$2(String str, Function0 function0, boolean z, int i, Composer composer, int i2) {
        SwitchButton(str, function0, z, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final void SwitchButton(final String text, Function0<Unit> onClick, final boolean z, Composer composer, final int i) {
        int i2;
        final Function0<Unit> function0;
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        Composer startRestartGroup = composer.startRestartGroup(945005206);
        ComposerKt.sourceInformation(startRestartGroup, "C(SwitchButton)P(2,1)33@1441L898,33@1418L921:SwitchButton.kt#1gr92h");
        if ((i & 6) == 0) {
            i2 = (startRestartGroup.changed(text) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= startRestartGroup.changedInstance(onClick) ? 32 : 16;
        }
        if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i2 |= startRestartGroup.changed(z) ? 256 : 128;
        }
        if (!startRestartGroup.shouldExecute((i2 & 147) != 146, i2 & 1)) {
            function0 = onClick;
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(945005206, i2, -1, "com.miami.game.feature.settings.ui.compose.SwitchButton (SwitchButton.kt:32)");
            }
            function0 = onClick;
            ScalingButtonKt.ScalingButton(function0, null, ComposableLambdaKt.rememberComposableLambda(-1706652927, true, new Function3() { // from class: com.miami.game.feature.settings.ui.compose.SwitchButtonKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    Unit SwitchButton$lambda$1;
                    SwitchButton$lambda$1 = SwitchButtonKt.SwitchButton$lambda$1(text, z, (BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    return SwitchButton$lambda$1;
                }
            }, startRestartGroup, 54), startRestartGroup, ((i2 >> 3) & 14) | RendererCapabilities.DECODER_SUPPORT_MASK, 2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: com.miami.game.feature.settings.ui.compose.SwitchButtonKt$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit SwitchButton$lambda$2;
                    SwitchButton$lambda$2 = SwitchButtonKt.SwitchButton$lambda$2(text, function0, z, i, (Composer) obj, ((Integer) obj2).intValue());
                    return SwitchButton$lambda$2;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SwitchButton$lambda$1(String str, boolean z, BoxScope ScalingButton, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(ScalingButton, "$this$ScalingButton");
        ComposerKt.sourceInformation(composer, "C34@1451L882:SwitchButton.kt#1gr92h");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1706652927, i, -1, "com.miami.game.feature.settings.ui.compose.SwitchButton.<anonymous> (SwitchButton.kt:34)");
            }
            float f = 8;
            Modifier m739paddingVpY3zN4 = PaddingKt.m739paddingVpY3zN4(BorderKt.m260borderziNgDLE(BackgroundKt.m246backgroundbw27NRU(Modifier.Companion, ColorKt.Color(3205437478L), RoundedCornerShapeKt.m1032RoundedCornerShape0680j_4(Dp.m6684constructorimpl(f))), Dp.m6684constructorimpl(1), Brush.Companion.m4029linearGradientmHitzGk$default(Brush.Companion, CollectionsKt.listOf((Object[]) new Color[]{Color.m4068boximpl(Color.m4077copywmQWz5c$default(Color.Companion.m4115getWhite0d7_KjU(), 0.1f, 0.0f, 0.0f, 0.0f, 14, null)), Color.m4068boximpl(Color.m4077copywmQWz5c$default(Color.Companion.m4115getWhite0d7_KjU(), 0.1f, 0.0f, 0.0f, 0.0f, 14, null)), Color.m4068boximpl(Color.m4077copywmQWz5c$default(Color.Companion.m4104getBlack0d7_KjU(), 0.2f, 0.0f, 0.0f, 0.0f, 14, null))}), 0L, 0L, 0, 14, (Object) null), RoundedCornerShapeKt.m1032RoundedCornerShape0680j_4(Dp.m6684constructorimpl(f))), Dp.m6684constructorimpl(20), Dp.m6684constructorimpl(16));
            Alignment.Vertical centerVertically = Alignment.Companion.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart(composer, 693286680, "CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo");
            MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically, composer, 48);
            ComposerKt.sourceInformationMarkerStart(composer, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(composer, m739paddingVpY3zN4);
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
            Composer m3520constructorimpl = Updater.m3520constructorimpl(composer);
            Updater.m3527setimpl(m3520constructorimpl, rowMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m3527setimpl(m3520constructorimpl, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (m3520constructorimpl.getInserting() || !Intrinsics.areEqual(m3520constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                m3520constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                m3520constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m3527setimpl(m3520constructorimpl, materializeModifier, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, -407735110, "C101@5232L9:Row.kt#2w3rfo");
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, -246735606, "C54@2199L42,56@2254L29,57@2296L27:SwitchButton.kt#1gr92h");
            TextSettingsKt.TextSettings(str, null, composer, 0, 2);
            SpacerKt.Spacer(SizeKt.m790width3ABfNKs(Modifier.Companion, Dp.m6684constructorimpl(12)), composer, 6);
            CustomToggleSwitch(z, composer, 0);
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
        return Unit.INSTANCE;
    }

    public static final void CustomToggleSwitch(final boolean z, Composer composer, final int i) {
        int i2;
        Composer startRestartGroup = composer.startRestartGroup(2052617564);
        ComposerKt.sourceInformation(startRestartGroup, "C(CustomToggleSwitch)79@2788L475:SwitchButton.kt#1gr92h");
        if ((i & 6) == 0) {
            i2 = (startRestartGroup.changed(z) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if (!startRestartGroup.shouldExecute((i2 & 3) != 2, i2 & 1)) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2052617564, i2, -1, "com.miami.game.feature.settings.ui.compose.CustomToggleSwitch (SwitchButton.kt:73)");
            }
            Color.Companion companion = Color.Companion;
            if (z) {
                companion.m4104getBlack0d7_KjU();
            } else {
                companion.m4106getCyan0d7_KjU();
            }
            Color.Companion companion2 = Color.Companion;
            if (z) {
                companion2.m4105getBlue0d7_KjU();
            } else {
                companion2.m4109getGreen0d7_KjU();
            }
            int i3 = z ? R.drawable.thumb_active : R.drawable.thumb_not_active;
            Alignment.Companion companion3 = Alignment.Companion;
            Alignment centerEnd = z ? companion3.getCenterEnd() : companion3.getCenterStart();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
            MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, Modifier.Companion);
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
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -935852450, "C82@2854L37,82@2838L217,87@3080L24,87@3064L193:SwitchButton.kt#1gr92h");
            ImageKt.Image(PainterResources_androidKt.painterResource(R.drawable.switch_bg, startRestartGroup, 0), (String) null, boxScopeInstance.align(SizeKt.m771height3ABfNKs(Modifier.Companion, Dp.m6684constructorimpl(12)), Alignment.Companion.getCenter()), (Alignment) null, ContentScale.Companion.getFillHeight(), 0.0f, (ColorFilter) null, startRestartGroup, 24624, 104);
            ImageKt.Image(PainterResources_androidKt.painterResource(i3, startRestartGroup, 0), (String) null, boxScopeInstance.align(SizeKt.m771height3ABfNKs(Modifier.Companion, Dp.m6684constructorimpl(20)), centerEnd), (Alignment) null, ContentScale.Companion.getFillHeight(), 0.0f, (ColorFilter) null, startRestartGroup, 24624, 104);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            startRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: com.miami.game.feature.settings.ui.compose.SwitchButtonKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit CustomToggleSwitch$lambda$4;
                    CustomToggleSwitch$lambda$4 = SwitchButtonKt.CustomToggleSwitch$lambda$4(z, i, (Composer) obj, ((Integer) obj2).intValue());
                    return CustomToggleSwitch$lambda$4;
                }
            });
        }
    }
}
