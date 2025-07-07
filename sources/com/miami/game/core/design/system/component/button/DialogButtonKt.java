package com.miami.game.core.design.system.component.button;

import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.MaterialTheme;
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
import androidx.compose.ui.draw.CacheDrawScope;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.draw.DrawModifierKt;
import androidx.compose.ui.draw.DrawResult;
import androidx.compose.ui.draw.ScaleKt;
import androidx.compose.ui.geometry.CornerRadius;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.vector.PathParser;
import androidx.compose.ui.input.pointer.PointerInputEventHandler;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.unit.Dp;
import androidx.media3.exoplayer.RendererCapabilities;
import androidx.media3.extractor.ts.TsExtractor;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.miami.game.core.design.system.theme.RoundedParallelogramLeftShape;
import com.miami.game.core.ui.utils.extensions.ClickIndicationType;
import com.miami.game.core.ui.utils.extensions.ComposeExtensionsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: DialogButton.kt */
@Metadata(d1 = {"\u00004\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\u001aC\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u001c\u0010\u0006\u001a\u0018\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00010\u0007¢\u0006\u0002\b\t¢\u0006\u0002\b\nH\u0007¢\u0006\u0002\u0010\u000b\u001a9\u0010\f\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\u001c\u0010\u0006\u001a\u0018\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00010\u0007¢\u0006\u0002\b\t¢\u0006\u0002\b\nH\u0007¢\u0006\u0002\u0010\r\"\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010²\u0006\n\u0010\u0011\u001a\u00020\u0005X\u008a\u008e\u0002²\u0006\n\u0010\u0012\u001a\u00020\u0013X\u008a\u0084\u0002²\u0006\n\u0010\u0011\u001a\u00020\u0005X\u008a\u008e\u0002²\u0006\n\u0010\u0012\u001a\u00020\u0013X\u008a\u0084\u0002"}, d2 = {"DialogButtonYes", "", "onClick", "Lkotlin/Function0;", "isActive", "", FirebaseAnalytics.Param.CONTENT, "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/BoxScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function0;ZLkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "DialogButtonNo", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;I)V", "path", "Landroidx/compose/ui/graphics/Path;", "design-system_release_web", "selected", "scale", ""}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class DialogButtonKt {
    private static final Path path = PathParser.toPath$default(new PathParser().parsePathString("M 56.01 125.71 L 5.52 49.71 C -8.61 28.44 6.64 0 32.17 0 H 419.34 C 430.06 0 440.06 5.37 445.99 14.29 L 496.48 90.29 C 510.61 111.56 495.36 140 469.83 140 H 82.66 C 71.94 140 61.94 134.63 56.01 125.71 Z"), null, 1, null);

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DialogButtonNo$lambda$23(Function0 function0, Function3 function3, int i, Composer composer, int i2) {
        DialogButtonNo(function0, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DialogButtonYes$lambda$11(Function0 function0, boolean z, Function3 function3, int i, int i2, Composer composer, int i3) {
        DialogButtonYes(function0, z, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x014c  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x014f  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x01d7  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x01f9  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x01fc  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0204  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x026f  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x027b  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x027f  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0302  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x030c  */
    /* JADX WARN: Removed duplicated region for block: B:98:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void DialogButtonYes(final Function0<Unit> onClick, boolean z, final Function3<? super BoxScope, ? super Composer, ? super Integer, Unit> content, Composer composer, final int i, final int i2) {
        int i3;
        boolean z2;
        Object rememberedValue;
        boolean z3;
        Object rememberedValue2;
        DialogButtonKt$DialogButtonYes$2$1 rememberedValue3;
        boolean z4;
        Object rememberedValue4;
        int currentCompositeKeyHash;
        Composer m3520constructorimpl;
        final boolean z5;
        ScopeUpdateScope endRestartGroup;
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        Intrinsics.checkNotNullParameter(content, "content");
        Composer startRestartGroup = composer.startRestartGroup(1422888430);
        ComposerKt.sourceInformation(startRestartGroup, "C(DialogButtonYes)P(2,1)45@2136L34,46@2188L59,55@2472L11,59@2641L487,83@3498L308,95@3917L102,49@2296L1800:DialogButton.kt#x0o0f5");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (startRestartGroup.changedInstance(onClick) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i4 = i2 & 2;
        if (i4 != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            z2 = z;
            i3 |= startRestartGroup.changed(z2) ? 32 : 16;
            if ((i2 & 4) == 0) {
                i3 |= RendererCapabilities.DECODER_SUPPORT_MASK;
            } else if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
                i3 |= startRestartGroup.changedInstance(content) ? 256 : 128;
            }
            if ((i3 & 147) == 146 || !startRestartGroup.getSkipping()) {
                if (i4 != 0) {
                    z2 = true;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1422888430, i3, -1, "com.miami.game.core.design.system.component.button.DialogButtonYes (DialogButton.kt:44)");
                }
                startRestartGroup.startReplaceGroup(1849434622);
                ComposerKt.sourceInformation(startRestartGroup, "CC(remember):DialogButton.kt#9igjgp");
                rememberedValue = startRestartGroup.rememberedValue();
                if (rememberedValue == Composer.Companion.getEmpty()) {
                    rememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                    startRestartGroup.updateRememberedValue(rememberedValue);
                }
                MutableState mutableState = (MutableState) rememberedValue;
                startRestartGroup.endReplaceGroup();
                final boolean z6 = z2;
                State<Float> animateFloatAsState = AnimateAsStateKt.animateFloatAsState(!DialogButtonYes$lambda$1(mutableState) ? 0.9f : 1.0f, null, 0.0f, "", null, startRestartGroup, 3072, 22);
                final long m4077copywmQWz5c$default = Color.m4077copywmQWz5c$default(Color.Companion.m4104getBlack0d7_KjU(), 0.5f, 0.0f, 0.0f, 0.0f, 14, null);
                int i5 = i3;
                Modifier clip = ClipKt.clip(BackgroundKt.m246backgroundbw27NRU(SizeKt.m771height3ABfNKs(SizeKt.m790width3ABfNKs(ScaleKt.scale(Modifier.Companion, DialogButtonYes$lambda$3(animateFloatAsState)), Dp.m6684constructorimpl((float) TsExtractor.TS_STREAM_TYPE_AC4)), Dp.m6684constructorimpl(45)), MaterialTheme.INSTANCE.getColorScheme(startRestartGroup, MaterialTheme.$stable).m1714getPrimary0d7_KjU(), new RoundedParallelogramLeftShape(0.0f, 0.0f, 3, null)), new RoundedParallelogramLeftShape(0.0f, 0.0f, 3, null));
                startRestartGroup.startReplaceGroup(-1633490746);
                ComposerKt.sourceInformation(startRestartGroup, "CC(remember):DialogButton.kt#9igjgp");
                int i6 = i5 & 112;
                z3 = i6 != 32;
                rememberedValue2 = startRestartGroup.rememberedValue();
                if (!z3 || rememberedValue2 == Composer.Companion.getEmpty()) {
                    rememberedValue2 = new Function1() { // from class: com.miami.game.core.design.system.component.button.DialogButtonKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            DrawResult DialogButtonYes$lambda$6$lambda$5;
                            DialogButtonYes$lambda$6$lambda$5 = DialogButtonKt.DialogButtonYes$lambda$6$lambda$5(z6, m4077copywmQWz5c$default, (CacheDrawScope) obj);
                            return DialogButtonYes$lambda$6$lambda$5;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue2);
                }
                startRestartGroup.endReplaceGroup();
                Modifier m260borderziNgDLE = BorderKt.m260borderziNgDLE(DrawModifierKt.drawWithCache(clip, (Function1) rememberedValue2), Dp.m6684constructorimpl(2), Brush.Companion.m4035verticalGradient8A3gB4$default(Brush.Companion, CollectionsKt.listOf((Object[]) new Color[]{Color.m4068boximpl(Color.m4077copywmQWz5c$default(Color.Companion.m4115getWhite0d7_KjU(), 0.35f, 0.0f, 0.0f, 0.0f, 14, null)), Color.m4068boximpl(Color.Companion.m4113getTransparent0d7_KjU())}), 0.0f, 0.0f, 0, 14, (Object) null), new RoundedParallelogramLeftShape(0.0f, 0.0f, 3, null));
                Unit unit = Unit.INSTANCE;
                startRestartGroup.startReplaceGroup(5004770);
                ComposerKt.sourceInformation(startRestartGroup, "CC(remember):DialogButton.kt#9igjgp");
                rememberedValue3 = startRestartGroup.rememberedValue();
                if (rememberedValue3 == Composer.Companion.getEmpty()) {
                    rememberedValue3 = new DialogButtonKt$DialogButtonYes$2$1(mutableState);
                    startRestartGroup.updateRememberedValue(rememberedValue3);
                }
                startRestartGroup.endReplaceGroup();
                Modifier pointerInput = SuspendingPointerInputFilterKt.pointerInput(m260borderziNgDLE, unit, (PointerInputEventHandler) rememberedValue3);
                ClickIndicationType clickIndicationType = ClickIndicationType.NO_INDICATION;
                startRestartGroup.startReplaceGroup(-1633490746);
                ComposerKt.sourceInformation(startRestartGroup, "CC(remember):DialogButton.kt#9igjgp");
                z4 = (i6 != 32) | ((i5 & 14) == 4);
                rememberedValue4 = startRestartGroup.rememberedValue();
                if (!z4 || rememberedValue4 == Composer.Companion.getEmpty()) {
                    rememberedValue4 = new Function0() { // from class: com.miami.game.core.design.system.component.button.DialogButtonKt$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit DialogButtonYes$lambda$9$lambda$8;
                            DialogButtonYes$lambda$9$lambda$8 = DialogButtonKt.DialogButtonYes$lambda$9$lambda$8(z6, onClick);
                            return DialogButtonYes$lambda$9$lambda$8;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue4);
                }
                startRestartGroup.endReplaceGroup();
                Modifier clickWithDelay$default = ComposeExtensionsKt.clickWithDelay$default(pointerInput, false, 0L, clickIndicationType, (Function0) rememberedValue4, 3, null);
                Alignment center = Alignment.Companion.getCenter();
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(center, false);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
                Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, clickWithDelay$default);
                Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
                if (!(startRestartGroup.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                startRestartGroup.startReusableNode();
                if (!startRestartGroup.getInserting()) {
                    startRestartGroup.createNode(constructor);
                } else {
                    startRestartGroup.useNode();
                }
                m3520constructorimpl = Updater.m3520constructorimpl(startRestartGroup);
                Updater.m3527setimpl(m3520constructorimpl, maybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.m3527setimpl(m3520constructorimpl, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
                if (!m3520constructorimpl.getInserting() || !Intrinsics.areEqual(m3520constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                    m3520constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    m3520constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                }
                Updater.m3527setimpl(m3520constructorimpl, materializeModifier, ComposeUiNode.Companion.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2092945714, "C102@4081L9:DialogButton.kt#x0o0f5");
                content.invoke(BoxScopeInstance.INSTANCE, startRestartGroup, Integer.valueOf(((i5 >> 3) & 112) | 6));
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                startRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                z5 = z6;
            } else {
                startRestartGroup.skipToGroupEnd();
                z5 = z2;
            }
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup == null) {
                endRestartGroup.updateScope(new Function2() { // from class: com.miami.game.core.design.system.component.button.DialogButtonKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        Unit DialogButtonYes$lambda$11;
                        DialogButtonYes$lambda$11 = DialogButtonKt.DialogButtonYes$lambda$11(Function0.this, z5, content, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        return DialogButtonYes$lambda$11;
                    }
                });
                return;
            }
            return;
        }
        z2 = z;
        if ((i2 & 4) == 0) {
        }
        if ((i3 & 147) == 146) {
        }
        if (i4 != 0) {
        }
        if (ComposerKt.isTraceInProgress()) {
        }
        startRestartGroup.startReplaceGroup(1849434622);
        ComposerKt.sourceInformation(startRestartGroup, "CC(remember):DialogButton.kt#9igjgp");
        rememberedValue = startRestartGroup.rememberedValue();
        if (rememberedValue == Composer.Companion.getEmpty()) {
        }
        MutableState mutableState2 = (MutableState) rememberedValue;
        startRestartGroup.endReplaceGroup();
        final boolean z62 = z2;
        State<Float> animateFloatAsState2 = AnimateAsStateKt.animateFloatAsState(!DialogButtonYes$lambda$1(mutableState2) ? 0.9f : 1.0f, null, 0.0f, "", null, startRestartGroup, 3072, 22);
        final long m4077copywmQWz5c$default2 = Color.m4077copywmQWz5c$default(Color.Companion.m4104getBlack0d7_KjU(), 0.5f, 0.0f, 0.0f, 0.0f, 14, null);
        int i52 = i3;
        Modifier clip2 = ClipKt.clip(BackgroundKt.m246backgroundbw27NRU(SizeKt.m771height3ABfNKs(SizeKt.m790width3ABfNKs(ScaleKt.scale(Modifier.Companion, DialogButtonYes$lambda$3(animateFloatAsState2)), Dp.m6684constructorimpl((float) TsExtractor.TS_STREAM_TYPE_AC4)), Dp.m6684constructorimpl(45)), MaterialTheme.INSTANCE.getColorScheme(startRestartGroup, MaterialTheme.$stable).m1714getPrimary0d7_KjU(), new RoundedParallelogramLeftShape(0.0f, 0.0f, 3, null)), new RoundedParallelogramLeftShape(0.0f, 0.0f, 3, null));
        startRestartGroup.startReplaceGroup(-1633490746);
        ComposerKt.sourceInformation(startRestartGroup, "CC(remember):DialogButton.kt#9igjgp");
        int i62 = i52 & 112;
        if (i62 != 32) {
        }
        rememberedValue2 = startRestartGroup.rememberedValue();
        if (!z3) {
        }
        rememberedValue2 = new Function1() { // from class: com.miami.game.core.design.system.component.button.DialogButtonKt$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                DrawResult DialogButtonYes$lambda$6$lambda$5;
                DialogButtonYes$lambda$6$lambda$5 = DialogButtonKt.DialogButtonYes$lambda$6$lambda$5(z62, m4077copywmQWz5c$default2, (CacheDrawScope) obj);
                return DialogButtonYes$lambda$6$lambda$5;
            }
        };
        startRestartGroup.updateRememberedValue(rememberedValue2);
        startRestartGroup.endReplaceGroup();
        Modifier m260borderziNgDLE2 = BorderKt.m260borderziNgDLE(DrawModifierKt.drawWithCache(clip2, (Function1) rememberedValue2), Dp.m6684constructorimpl(2), Brush.Companion.m4035verticalGradient8A3gB4$default(Brush.Companion, CollectionsKt.listOf((Object[]) new Color[]{Color.m4068boximpl(Color.m4077copywmQWz5c$default(Color.Companion.m4115getWhite0d7_KjU(), 0.35f, 0.0f, 0.0f, 0.0f, 14, null)), Color.m4068boximpl(Color.Companion.m4113getTransparent0d7_KjU())}), 0.0f, 0.0f, 0, 14, (Object) null), new RoundedParallelogramLeftShape(0.0f, 0.0f, 3, null));
        Unit unit2 = Unit.INSTANCE;
        startRestartGroup.startReplaceGroup(5004770);
        ComposerKt.sourceInformation(startRestartGroup, "CC(remember):DialogButton.kt#9igjgp");
        rememberedValue3 = startRestartGroup.rememberedValue();
        if (rememberedValue3 == Composer.Companion.getEmpty()) {
        }
        startRestartGroup.endReplaceGroup();
        Modifier pointerInput2 = SuspendingPointerInputFilterKt.pointerInput(m260borderziNgDLE2, unit2, (PointerInputEventHandler) rememberedValue3);
        ClickIndicationType clickIndicationType2 = ClickIndicationType.NO_INDICATION;
        startRestartGroup.startReplaceGroup(-1633490746);
        ComposerKt.sourceInformation(startRestartGroup, "CC(remember):DialogButton.kt#9igjgp");
        z4 = (i62 != 32) | ((i52 & 14) == 4);
        rememberedValue4 = startRestartGroup.rememberedValue();
        if (!z4) {
        }
        rememberedValue4 = new Function0() { // from class: com.miami.game.core.design.system.component.button.DialogButtonKt$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit DialogButtonYes$lambda$9$lambda$8;
                DialogButtonYes$lambda$9$lambda$8 = DialogButtonKt.DialogButtonYes$lambda$9$lambda$8(z62, onClick);
                return DialogButtonYes$lambda$9$lambda$8;
            }
        };
        startRestartGroup.updateRememberedValue(rememberedValue4);
        startRestartGroup.endReplaceGroup();
        Modifier clickWithDelay$default2 = ComposeExtensionsKt.clickWithDelay$default(pointerInput2, false, 0L, clickIndicationType2, (Function0) rememberedValue4, 3, null);
        Alignment center2 = Alignment.Companion.getCenter();
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
        MeasurePolicy maybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(center2, false);
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
        currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
        CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
        Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(startRestartGroup, clickWithDelay$default2);
        Function0<ComposeUiNode> constructor2 = ComposeUiNode.Companion.getConstructor();
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
        if (!(startRestartGroup.getApplier() instanceof Applier)) {
        }
        startRestartGroup.startReusableNode();
        if (!startRestartGroup.getInserting()) {
        }
        m3520constructorimpl = Updater.m3520constructorimpl(startRestartGroup);
        Updater.m3527setimpl(m3520constructorimpl, maybeCachedBoxMeasurePolicy2, ComposeUiNode.Companion.getSetMeasurePolicy());
        Updater.m3527setimpl(m3520constructorimpl, currentCompositionLocalMap2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.Companion.getSetCompositeKeyHash();
        if (!m3520constructorimpl.getInserting()) {
        }
        m3520constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
        m3520constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash2);
        Updater.m3527setimpl(m3520constructorimpl, materializeModifier2, ComposeUiNode.Companion.getSetModifier());
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2092945714, "C102@4081L9:DialogButton.kt#x0o0f5");
        content.invoke(BoxScopeInstance.INSTANCE, startRestartGroup, Integer.valueOf(((i52 >> 3) & 112) | 6));
        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
        startRestartGroup.endNode();
        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
        if (ComposerKt.isTraceInProgress()) {
        }
        z5 = z62;
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    private static final boolean DialogButtonYes$lambda$1(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void DialogButtonYes$lambda$2(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DrawResult DialogButtonYes$lambda$6$lambda$5(final boolean z, final long j, CacheDrawScope drawWithCache) {
        Intrinsics.checkNotNullParameter(drawWithCache, "$this$drawWithCache");
        final Brush m4029linearGradientmHitzGk$default = Brush.Companion.m4029linearGradientmHitzGk$default(Brush.Companion, CollectionsKt.listOf((Object[]) new Color[]{Color.m4068boximpl(Color.m4077copywmQWz5c$default(Color.Companion.m4115getWhite0d7_KjU(), 0.2f, 0.0f, 0.0f, 0.0f, 14, null)), Color.m4068boximpl(Color.Companion.m4113getTransparent0d7_KjU())}), 0L, 0L, 0, 14, (Object) null);
        return drawWithCache.onDrawBehind(new Function1() { // from class: com.miami.game.core.design.system.component.button.DialogButtonKt$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit DialogButtonYes$lambda$6$lambda$5$lambda$4;
                DialogButtonYes$lambda$6$lambda$5$lambda$4 = DialogButtonKt.DialogButtonYes$lambda$6$lambda$5$lambda$4(Brush.this, z, j, (DrawScope) obj);
                return DialogButtonYes$lambda$6$lambda$5$lambda$4;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DialogButtonYes$lambda$9$lambda$8(boolean z, Function0 function0) {
        if (z) {
            function0.invoke();
        }
        return Unit.INSTANCE;
    }

    public static final void DialogButtonNo(final Function0<Unit> onClick, final Function3<? super BoxScope, ? super Composer, ? super Integer, Unit> content, Composer composer, final int i) {
        int i2;
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        Intrinsics.checkNotNullParameter(content, "content");
        Composer startRestartGroup = composer.startRestartGroup(1649800160);
        ComposerKt.sourceInformation(startRestartGroup, "C(DialogButtonNo)P(1)108@4216L34,109@4268L59,117@4509L11,121@4679L372,142@5421L308,154@5840L48,111@4333L1633:DialogButton.kt#x0o0f5");
        if ((i & 6) == 0) {
            i2 = (startRestartGroup.changedInstance(onClick) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= startRestartGroup.changedInstance(content) ? 32 : 16;
        }
        int i3 = i2;
        if ((i3 & 19) != 18 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1649800160, i3, -1, "com.miami.game.core.design.system.component.button.DialogButtonNo (DialogButton.kt:107)");
            }
            startRestartGroup.startReplaceGroup(1849434622);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):DialogButton.kt#9igjgp");
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            MutableState mutableState = (MutableState) rememberedValue;
            startRestartGroup.endReplaceGroup();
            Modifier clip = ClipKt.clip(BackgroundKt.m246backgroundbw27NRU(SizeKt.m771height3ABfNKs(SizeKt.m790width3ABfNKs(ScaleKt.scale(Modifier.Companion, DialogButtonNo$lambda$15(AnimateAsStateKt.animateFloatAsState(DialogButtonNo$lambda$13(mutableState) ? 0.9f : 1.0f, null, 0.0f, "", null, startRestartGroup, 3072, 22))), Dp.m6684constructorimpl((float) TsExtractor.TS_STREAM_TYPE_AC4)), Dp.m6684constructorimpl(45)), MaterialTheme.INSTANCE.getColorScheme(startRestartGroup, MaterialTheme.$stable).m1729getTertiary0d7_KjU(), new RoundedParallelogramLeftShape(0.0f, 0.0f, 3, null)), new RoundedParallelogramLeftShape(0.0f, 0.0f, 3, null));
            startRestartGroup.startReplaceGroup(1849434622);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):DialogButton.kt#9igjgp");
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (rememberedValue2 == Composer.Companion.getEmpty()) {
                rememberedValue2 = new Function1() { // from class: com.miami.game.core.design.system.component.button.DialogButtonKt$$ExternalSyntheticLambda5
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        DrawResult DialogButtonNo$lambda$18$lambda$17;
                        DialogButtonNo$lambda$18$lambda$17 = DialogButtonKt.DialogButtonNo$lambda$18$lambda$17((CacheDrawScope) obj);
                        return DialogButtonNo$lambda$18$lambda$17;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            startRestartGroup.endReplaceGroup();
            Modifier m260borderziNgDLE = BorderKt.m260borderziNgDLE(DrawModifierKt.drawWithCache(clip, (Function1) rememberedValue2), Dp.m6684constructorimpl(2), Brush.Companion.m4035verticalGradient8A3gB4$default(Brush.Companion, CollectionsKt.listOf((Object[]) new Color[]{Color.m4068boximpl(Color.m4077copywmQWz5c$default(Color.Companion.m4115getWhite0d7_KjU(), 0.35f, 0.0f, 0.0f, 0.0f, 14, null)), Color.m4068boximpl(Color.Companion.m4113getTransparent0d7_KjU())}), 0.0f, 0.0f, 0, 14, (Object) null), new RoundedParallelogramLeftShape(0.0f, 0.0f, 3, null));
            Unit unit = Unit.INSTANCE;
            startRestartGroup.startReplaceGroup(5004770);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):DialogButton.kt#9igjgp");
            DialogButtonKt$DialogButtonNo$2$1 rememberedValue3 = startRestartGroup.rememberedValue();
            if (rememberedValue3 == Composer.Companion.getEmpty()) {
                rememberedValue3 = new DialogButtonKt$DialogButtonNo$2$1(mutableState);
                startRestartGroup.updateRememberedValue(rememberedValue3);
            }
            startRestartGroup.endReplaceGroup();
            Modifier pointerInput = SuspendingPointerInputFilterKt.pointerInput(m260borderziNgDLE, unit, (PointerInputEventHandler) rememberedValue3);
            ClickIndicationType clickIndicationType = ClickIndicationType.NO_INDICATION;
            startRestartGroup.startReplaceGroup(5004770);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):DialogButton.kt#9igjgp");
            boolean z = (i3 & 14) == 4;
            Object rememberedValue4 = startRestartGroup.rememberedValue();
            if (z || rememberedValue4 == Composer.Companion.getEmpty()) {
                rememberedValue4 = new Function0() { // from class: com.miami.game.core.design.system.component.button.DialogButtonKt$$ExternalSyntheticLambda6
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit DialogButtonNo$lambda$21$lambda$20;
                        DialogButtonNo$lambda$21$lambda$20 = DialogButtonKt.DialogButtonNo$lambda$21$lambda$20(Function0.this);
                        return DialogButtonNo$lambda$21$lambda$20;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue4);
            }
            startRestartGroup.endReplaceGroup();
            Modifier clickWithDelay$default = ComposeExtensionsKt.clickWithDelay$default(pointerInput, false, 0L, clickIndicationType, (Function0) rememberedValue4, 3, null);
            Alignment center = Alignment.Companion.getCenter();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
            MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(center, false);
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
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 273090324, "C160@5951L9:DialogButton.kt#x0o0f5");
            content.invoke(BoxScopeInstance.INSTANCE, startRestartGroup, Integer.valueOf((i3 & 112) | 6));
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            startRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: com.miami.game.core.design.system.component.button.DialogButtonKt$$ExternalSyntheticLambda7
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit DialogButtonNo$lambda$23;
                    DialogButtonNo$lambda$23 = DialogButtonKt.DialogButtonNo$lambda$23(Function0.this, content, i, (Composer) obj, ((Integer) obj2).intValue());
                    return DialogButtonNo$lambda$23;
                }
            });
        }
    }

    private static final boolean DialogButtonNo$lambda$13(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void DialogButtonNo$lambda$14(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DrawResult DialogButtonNo$lambda$18$lambda$17(CacheDrawScope drawWithCache) {
        Intrinsics.checkNotNullParameter(drawWithCache, "$this$drawWithCache");
        final Brush m4029linearGradientmHitzGk$default = Brush.Companion.m4029linearGradientmHitzGk$default(Brush.Companion, CollectionsKt.listOf((Object[]) new Color[]{Color.m4068boximpl(Color.m4077copywmQWz5c$default(Color.Companion.m4115getWhite0d7_KjU(), 0.2f, 0.0f, 0.0f, 0.0f, 14, null)), Color.m4068boximpl(Color.Companion.m4113getTransparent0d7_KjU())}), 0L, 0L, 0, 14, (Object) null);
        return drawWithCache.onDrawBehind(new Function1() { // from class: com.miami.game.core.design.system.component.button.DialogButtonKt$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit DialogButtonNo$lambda$18$lambda$17$lambda$16;
                DialogButtonNo$lambda$18$lambda$17$lambda$16 = DialogButtonKt.DialogButtonNo$lambda$18$lambda$17$lambda$16(Brush.this, (DrawScope) obj);
                return DialogButtonNo$lambda$18$lambda$17$lambda$16;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DialogButtonNo$lambda$21$lambda$20(Function0 function0) {
        function0.invoke();
        return Unit.INSTANCE;
    }

    private static final float DialogButtonYes$lambda$3(State<Float> state) {
        return state.getValue().floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DialogButtonYes$lambda$6$lambda$5$lambda$4(Brush brush, boolean z, long j, DrawScope onDrawBehind) {
        Intrinsics.checkNotNullParameter(onDrawBehind, "$this$onDrawBehind");
        float f = onDrawBehind.mo389toPx0680j_4(Dp.m6684constructorimpl(10));
        DrawScope.m4635drawRoundRectZuiqVtQ$default(onDrawBehind, brush, 0L, 0L, CornerRadius.m3791constructorimpl((Float.floatToRawIntBits(f) << 32) | (Float.floatToRawIntBits(f) & 4294967295L)), 0.0f, null, null, 0, 246, null);
        if (!z) {
            DrawScope.m4636drawRoundRectuAw5IA$default(onDrawBehind, j, 0L, 0L, 0L, null, 0.0f, null, 0, 254, null);
        }
        return Unit.INSTANCE;
    }

    private static final float DialogButtonNo$lambda$15(State<Float> state) {
        return state.getValue().floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DialogButtonNo$lambda$18$lambda$17$lambda$16(Brush brush, DrawScope onDrawBehind) {
        Intrinsics.checkNotNullParameter(onDrawBehind, "$this$onDrawBehind");
        float f = onDrawBehind.mo389toPx0680j_4(Dp.m6684constructorimpl(10));
        DrawScope.m4635drawRoundRectZuiqVtQ$default(onDrawBehind, brush, 0L, 0L, CornerRadius.m3791constructorimpl((Float.floatToRawIntBits(f) << 32) | (Float.floatToRawIntBits(f) & 4294967295L)), 0.0f, null, null, 0, 246, null);
        return Unit.INSTANCE;
    }
}
