package com.miami.game.feature.settings.ui.compose;

import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.TextKt;
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
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.unit.Dp;
import androidx.media3.exoplayer.RendererCapabilities;
import com.miami.game.core.design.system.component.scaling_button.ScalingButtonKt;
import com.miami.game.ui.classic.settings.R;
import com.miami.game.ui.theme.TypeKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: NumberButton.kt */
@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aC\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007b\u0002\b\tb\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f¢\u0006\u0002\u0010\b\u001aC\u0010\r\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007b\u0002\b\tb\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f¢\u0006\u0002\u0010\b\u001a=\u0010\u000e\u001a\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u00102\u0006\u0010\u0006\u001a\u00020\u0007H\u0007b\u0002\b\tb\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f¢\u0006\u0002\u0010\u0011¨\u0006\u0012"}, d2 = {"NumberButtonText", "", "number", "", "onClick", "Lkotlin/Function1;", "isActive", "", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;ZLandroidx/compose/runtime/Composer;I)V", "Landroidx/compose/runtime/Composable;", "Landroidx/compose/runtime/ComposableTarget;", "applier", "androidx.compose.ui.UiComposable", "NumberButton", "KeyboardButton", "text", "Lkotlin/Function0;", "(Ljava/lang/String;Lkotlin/jvm/functions/Function0;ZLandroidx/compose/runtime/Composer;I)V", "settings"}, k = 2, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class NumberButtonKt {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit KeyboardButton$lambda$2(String str, Function0 function0, boolean z, int i, Composer composer, int i2) {
        KeyboardButton(str, function0, z, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit NumberButton$lambda$2(String str, Function1 function1, boolean z, int i, Composer composer, int i2) {
        NumberButton(str, function1, z, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit NumberButtonText$lambda$2(String str, Function1 function1, boolean z, int i, Composer composer, int i2) {
        NumberButtonText(str, function1, z, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final void NumberButtonText(final String number, final Function1<? super String, Unit> onClick, final boolean z, Composer composer, final int i) {
        int i2;
        Intrinsics.checkNotNullParameter(number, "number");
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        Composer startRestartGroup = composer.startRestartGroup(-1572625182);
        ComposerKt.sourceInformation(startRestartGroup, "C(NumberButtonText)N(number,onClick,isActive)25@1082L19,26@1108L493,24@1049L552:NumberButton.kt#1gr92h");
        if ((i & 6) == 0) {
            i2 = (startRestartGroup.changed(number) ? 4 : 2) | i;
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
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1572625182, i2, -1, "com.miami.game.feature.settings.ui.compose.NumberButtonText (NumberButton.kt:22)");
            }
            final int i3 = z ? R.drawable.keyboard_button_active : R.drawable.keyboard_button;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 535695189, "CC(remember):NumberButton.kt#9igjgp");
            boolean z2 = ((i2 & 112) == 32) | ((i2 & 14) == 4);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (z2 || rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new Function0() { // from class: com.miami.game.feature.settings.ui.compose.NumberButtonKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit NumberButtonText$lambda$0$0;
                        NumberButtonText$lambda$0$0 = NumberButtonKt.NumberButtonText$lambda$0$0(Function1.this, number);
                        return NumberButtonText$lambda$0$0;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ScalingButtonKt.ScalingButton((Function0) rememberedValue, null, ComposableLambdaKt.rememberComposableLambda(-2040111155, true, new Function3() { // from class: com.miami.game.feature.settings.ui.compose.NumberButtonKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return NumberButtonKt.NumberButtonText$lambda$1(number, i3, (BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, startRestartGroup, 54), startRestartGroup, RendererCapabilities.DECODER_SUPPORT_MASK, 2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: com.miami.game.feature.settings.ui.compose.NumberButtonKt$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return NumberButtonKt.NumberButtonText$lambda$2(number, onClick, z, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit NumberButtonText$lambda$0$0(Function1 function1, String str) {
        function1.invoke(str);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit NumberButtonText$lambda$1(String str, int i, BoxScope ScalingButton, Composer composer, int i2) {
        int i3;
        Intrinsics.checkNotNullParameter(ScalingButton, "$this$ScalingButton");
        ComposerKt.sourceInformation(composer, "C27@1118L271,38@1445L10,40@1524L13,37@1398L197:NumberButton.kt#1gr92h");
        if ((i2 & 6) == 0) {
            i3 = i2 | (composer.changed(ScalingButton) ? 4 : 2);
        } else {
            i3 = i2;
        }
        if (!composer.shouldExecute((i3 & 19) != 18, i3 & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2040111155, i3, -1, "com.miami.game.feature.settings.ui.compose.NumberButtonText.<anonymous> (NumberButton.kt:27)");
            }
            Modifier m1103height3ABfNKs = SizeKt.m1103height3ABfNKs(Modifier.Companion, Dp.m8160constructorimpl(54.0f));
            ComposerKt.sourceInformationMarkerStart(composer, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(composer, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
            int hashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(composer, m1103height3ABfNKs);
            Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)410@16187L9:Composables.kt#9igjgp");
            if (!(composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer.startReusableNode();
            if (composer.getInserting()) {
                composer.createNode(constructor);
            } else {
                composer.useNode();
            }
            Composer m4467constructorimpl = Updater.m4467constructorimpl(composer);
            Updater.m4475setimpl(m4467constructorimpl, maybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m4475setimpl(m4467constructorimpl, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.m4475setimpl(m4467constructorimpl, Integer.valueOf(hashCode), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.m4473reconcileimpl(m4467constructorimpl, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.m4475setimpl(m4467constructorimpl, materializeModifier, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, -1390094668, "C32@1244L22,31@1211L168:NumberButton.kt#1gr92h");
            ImageKt.Image(PainterResources_androidKt.painterResource(i, composer, 0), (String) null, Modifier.Companion, (Alignment) null, ContentScale.Companion.getFillHeight(), 0.0f, (ColorFilter) null, composer, Painter.$stable | 25008, 104);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            TextKt.m3157TextNvy7gAk(str, ScalingButton.align(Modifier.Companion, Alignment.Companion.getCenter()), Color.Companion.m5385getWhite0d7_KjU(), null, TypeKt.m9864dpToSp8Feqmps(Dp.m8160constructorimpl(16.0f), composer, 6), null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, MaterialTheme.INSTANCE.getTypography(composer, 6).getLabelSmall(), composer, RendererCapabilities.DECODER_SUPPORT_MASK, 0, 131048);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    public static final void NumberButton(final String number, final Function1<? super String, Unit> onClick, final boolean z, Composer composer, final int i) {
        int i2;
        Intrinsics.checkNotNullParameter(number, "number");
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        Composer startRestartGroup = composer.startRestartGroup(1369453397);
        ComposerKt.sourceInformation(startRestartGroup, "C(NumberButton)N(number,onClick,isActive)48@1828L19,49@1854L493,47@1795L552:NumberButton.kt#1gr92h");
        if ((i & 6) == 0) {
            i2 = (startRestartGroup.changed(number) ? 4 : 2) | i;
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
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1369453397, i2, -1, "com.miami.game.feature.settings.ui.compose.NumberButton (NumberButton.kt:45)");
            }
            final int i3 = z ? R.drawable.nubmer_button_active : R.drawable.number_button_png;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1784728744, "CC(remember):NumberButton.kt#9igjgp");
            boolean z2 = ((i2 & 112) == 32) | ((i2 & 14) == 4);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (z2 || rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new Function0() { // from class: com.miami.game.feature.settings.ui.compose.NumberButtonKt$$ExternalSyntheticLambda6
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit NumberButton$lambda$0$0;
                        NumberButton$lambda$0$0 = NumberButtonKt.NumberButton$lambda$0$0(Function1.this, number);
                        return NumberButton$lambda$0$0;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ScalingButtonKt.ScalingButton((Function0) rememberedValue, null, ComposableLambdaKt.rememberComposableLambda(-1282204736, true, new Function3() { // from class: com.miami.game.feature.settings.ui.compose.NumberButtonKt$$ExternalSyntheticLambda7
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return NumberButtonKt.NumberButton$lambda$1(number, i3, (BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, startRestartGroup, 54), startRestartGroup, RendererCapabilities.DECODER_SUPPORT_MASK, 2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: com.miami.game.feature.settings.ui.compose.NumberButtonKt$$ExternalSyntheticLambda8
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return NumberButtonKt.NumberButton$lambda$2(number, onClick, z, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit NumberButton$lambda$0$0(Function1 function1, String str) {
        function1.invoke(str);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit NumberButton$lambda$1(String str, int i, BoxScope ScalingButton, Composer composer, int i2) {
        int i3;
        Intrinsics.checkNotNullParameter(ScalingButton, "$this$ScalingButton");
        ComposerKt.sourceInformation(composer, "C50@1864L271,61@2191L10,63@2270L13,60@2144L197:NumberButton.kt#1gr92h");
        if ((i2 & 6) == 0) {
            i3 = i2 | (composer.changed(ScalingButton) ? 4 : 2);
        } else {
            i3 = i2;
        }
        if (!composer.shouldExecute((i3 & 19) != 18, i3 & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1282204736, i3, -1, "com.miami.game.feature.settings.ui.compose.NumberButton.<anonymous> (NumberButton.kt:50)");
            }
            Modifier m1103height3ABfNKs = SizeKt.m1103height3ABfNKs(Modifier.Companion, Dp.m8160constructorimpl(62.0f));
            ComposerKt.sourceInformationMarkerStart(composer, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(composer, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
            int hashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(composer, m1103height3ABfNKs);
            Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)410@16187L9:Composables.kt#9igjgp");
            if (!(composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer.startReusableNode();
            if (composer.getInserting()) {
                composer.createNode(constructor);
            } else {
                composer.useNode();
            }
            Composer m4467constructorimpl = Updater.m4467constructorimpl(composer);
            Updater.m4475setimpl(m4467constructorimpl, maybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m4475setimpl(m4467constructorimpl, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.m4475setimpl(m4467constructorimpl, Integer.valueOf(hashCode), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.m4473reconcileimpl(m4467constructorimpl, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.m4475setimpl(m4467constructorimpl, materializeModifier, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, 344663265, "C55@1990L22,54@1957L168:NumberButton.kt#1gr92h");
            ImageKt.Image(PainterResources_androidKt.painterResource(i, composer, 0), (String) null, Modifier.Companion, (Alignment) null, ContentScale.Companion.getFillHeight(), 0.0f, (ColorFilter) null, composer, Painter.$stable | 25008, 104);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            TextKt.m3157TextNvy7gAk(str, ScalingButton.align(Modifier.Companion, Alignment.Companion.getCenter()), Color.Companion.m5385getWhite0d7_KjU(), null, TypeKt.m9864dpToSp8Feqmps(Dp.m8160constructorimpl(16.0f), composer, 6), null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, MaterialTheme.INSTANCE.getTypography(composer, 6).getLabelSmall(), composer, RendererCapabilities.DECODER_SUPPORT_MASK, 0, 131048);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    public static final void KeyboardButton(final String text, final Function0<Unit> onClick, final boolean z, Composer composer, final int i) {
        int i2;
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        Composer startRestartGroup = composer.startRestartGroup(2013669460);
        ComposerKt.sourceInformation(startRestartGroup, "C(KeyboardButton)N(text,onClick,isActive)72@2568L30,73@2605L544,71@2535L614:NumberButton.kt#1gr92h");
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
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2013669460, i2, -1, "com.miami.game.feature.settings.ui.compose.KeyboardButton (NumberButton.kt:69)");
            }
            final int i3 = z ? R.drawable.keyboard_button_active : R.drawable.keyboard_button;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1893892846, "CC(remember):NumberButton.kt#9igjgp");
            boolean z2 = ((i2 & 896) == 256) | ((i2 & 112) == 32);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (z2 || rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new Function0() { // from class: com.miami.game.feature.settings.ui.compose.NumberButtonKt$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit KeyboardButton$lambda$0$0;
                        KeyboardButton$lambda$0$0 = NumberButtonKt.KeyboardButton$lambda$0$0(z, onClick);
                        return KeyboardButton$lambda$0$0;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ScalingButtonKt.ScalingButton((Function0) rememberedValue, null, ComposableLambdaKt.rememberComposableLambda(685810175, true, new Function3() { // from class: com.miami.game.feature.settings.ui.compose.NumberButtonKt$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return NumberButtonKt.KeyboardButton$lambda$1(text, i3, (BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, startRestartGroup, 54), startRestartGroup, RendererCapabilities.DECODER_SUPPORT_MASK, 2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: com.miami.game.feature.settings.ui.compose.NumberButtonKt$$ExternalSyntheticLambda5
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return NumberButtonKt.KeyboardButton$lambda$2(text, onClick, z, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit KeyboardButton$lambda$0$0(boolean z, Function0 function0) {
        if (!z) {
            function0.invoke();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit KeyboardButton$lambda$1(String str, int i, BoxScope ScalingButton, Composer composer, int i2) {
        int i3;
        Intrinsics.checkNotNullParameter(ScalingButton, "$this$ScalingButton");
        ComposerKt.sourceInformation(composer, "C74@2615L271,85@2940L10,87@3019L13,84@2895L248:NumberButton.kt#1gr92h");
        if ((i2 & 6) == 0) {
            i3 = i2 | (composer.changed(ScalingButton) ? 4 : 2);
        } else {
            i3 = i2;
        }
        if (!composer.shouldExecute((i3 & 19) != 18, i3 & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(685810175, i3, -1, "com.miami.game.feature.settings.ui.compose.KeyboardButton.<anonymous> (NumberButton.kt:74)");
            }
            Modifier m1103height3ABfNKs = SizeKt.m1103height3ABfNKs(Modifier.Companion, Dp.m8160constructorimpl(62.0f));
            ComposerKt.sourceInformationMarkerStart(composer, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(composer, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
            int hashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(composer, m1103height3ABfNKs);
            Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)410@16187L9:Composables.kt#9igjgp");
            if (!(composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer.startReusableNode();
            if (composer.getInserting()) {
                composer.createNode(constructor);
            } else {
                composer.useNode();
            }
            Composer m4467constructorimpl = Updater.m4467constructorimpl(composer);
            Updater.m4475setimpl(m4467constructorimpl, maybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m4475setimpl(m4467constructorimpl, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.m4475setimpl(m4467constructorimpl, Integer.valueOf(hashCode), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.m4473reconcileimpl(m4467constructorimpl, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.m4475setimpl(m4467constructorimpl, materializeModifier, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, 658053314, "C79@2741L22,78@2708L168:NumberButton.kt#1gr92h");
            ImageKt.Image(PainterResources_androidKt.painterResource(i, composer, 0), (String) null, Modifier.Companion, (Alignment) null, ContentScale.Companion.getFillHeight(), 0.0f, (ColorFilter) null, composer, Painter.$stable | 25008, 104);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            TextKt.m3157TextNvy7gAk(str, OffsetKt.m1010offsetVpY3zN4$default(ScalingButton.align(Modifier.Companion, Alignment.Companion.getCenter()), 0.0f, Dp.m8160constructorimpl(-Dp.m8160constructorimpl(2.0f)), 1, null), Color.Companion.m5385getWhite0d7_KjU(), null, TypeKt.m9864dpToSp8Feqmps(Dp.m8160constructorimpl(18.0f), composer, 6), null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, MaterialTheme.INSTANCE.getTypography(composer, 6).getLabelSmall(), composer, RendererCapabilities.DECODER_SUPPORT_MASK, 0, 131048);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}
