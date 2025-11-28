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
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.unit.Dp;
import androidx.media3.exoplayer.RendererCapabilities;
import com.miami.game.core.design.system.component.scaling_button.ScalingButtonKt;
import com.miami.game.feature.settings.R;
import com.miami.game.ui.theme.TypeKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: NumberButton.kt */
@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a1\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007¢\u0006\u0002\u0010\b\u001a+\u0010\t\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u000b2\u0006\u0010\u0006\u001a\u00020\u0007H\u0007¢\u0006\u0002\u0010\f¨\u0006\r"}, d2 = {"NumberButton", "", "number", "", "onClick", "Lkotlin/Function1;", "isActive", "", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;ZLandroidx/compose/runtime/Composer;I)V", "KeyboardButton", "text", "Lkotlin/Function0;", "(Ljava/lang/String;Lkotlin/jvm/functions/Function0;ZLandroidx/compose/runtime/Composer;I)V", "settings_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class NumberButtonKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit KeyboardButton$lambda$2(String str, Function0 function0, boolean z, int i, Composer composer, int i2) {
        KeyboardButton(str, function0, z, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit NumberButton$lambda$2(String str, Function1 function1, boolean z, int i, Composer composer, int i2) {
        NumberButton(str, function1, z, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final void NumberButton(final String number, final Function1<? super String, Unit> onClick, final boolean z, Composer composer, final int i) {
        int i2;
        Intrinsics.checkNotNullParameter(number, "number");
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        Composer startRestartGroup = composer.startRestartGroup(1369453397);
        ComposerKt.sourceInformation(startRestartGroup, "C(NumberButton)N(number,onClick,isActive)25@1075L19,26@1101L493,24@1042L552:NumberButton.kt#1gr92h");
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
                ComposerKt.traceEventStart(1369453397, i2, -1, "com.miami.game.feature.settings.ui.compose.NumberButton (NumberButton.kt:22)");
            }
            final int i3 = z ? R.drawable.nubmer_button_active : R.drawable.number_button_png;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1784728712, "CC(remember):NumberButton.kt#9igjgp");
            boolean z2 = ((i2 & 112) == 32) | ((i2 & 14) == 4);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (z2 || rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new Function0() { // from class: com.miami.game.feature.settings.ui.compose.NumberButtonKt$$ExternalSyntheticLambda3
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
            ScalingButtonKt.ScalingButton((Function0) rememberedValue, null, ComposableLambdaKt.rememberComposableLambda(-1282204736, true, new Function3() { // from class: com.miami.game.feature.settings.ui.compose.NumberButtonKt$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    Unit NumberButton$lambda$1;
                    NumberButton$lambda$1 = NumberButtonKt.NumberButton$lambda$1(number, i3, (BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    return NumberButton$lambda$1;
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
                    Unit NumberButton$lambda$2;
                    NumberButton$lambda$2 = NumberButtonKt.NumberButton$lambda$2(number, onClick, z, i, (Composer) obj, ((Integer) obj2).intValue());
                    return NumberButton$lambda$2;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit NumberButton$lambda$0$0(Function1 function1, String str) {
        function1.invoke(str);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit NumberButton$lambda$1(String str, int i, BoxScope ScalingButton, Composer composer, int i2) {
        int i3;
        Intrinsics.checkNotNullParameter(ScalingButton, "$this$ScalingButton");
        ComposerKt.sourceInformation(composer, "C27@1111L271,38@1438L10,40@1517L13,37@1391L197:NumberButton.kt#1gr92h");
        if ((i2 & 6) == 0) {
            i3 = i2 | (composer.changed(ScalingButton) ? 4 : 2);
        } else {
            i3 = i2;
        }
        if (!composer.shouldExecute((i3 & 19) != 18, i3 & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1282204736, i3, -1, "com.miami.game.feature.settings.ui.compose.NumberButton.<anonymous> (NumberButton.kt:27)");
            }
            Modifier m881height3ABfNKs = SizeKt.m881height3ABfNKs(Modifier.Companion, Dp.m7996constructorimpl(62));
            ComposerKt.sourceInformationMarkerStart(composer, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(composer, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
            int hashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(composer, m881height3ABfNKs);
            Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!(composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer.startReusableNode();
            if (composer.getInserting()) {
                composer.createNode(constructor);
            } else {
                composer.useNode();
            }
            Composer m4598constructorimpl = Updater.m4598constructorimpl(composer);
            Updater.m4605setimpl(m4598constructorimpl, maybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m4605setimpl(m4598constructorimpl, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (m4598constructorimpl.getInserting() || !Intrinsics.areEqual(m4598constructorimpl.rememberedValue(), Integer.valueOf(hashCode))) {
                m4598constructorimpl.updateRememberedValue(Integer.valueOf(hashCode));
                m4598constructorimpl.apply(Integer.valueOf(hashCode), setCompositeKeyHash);
            }
            Updater.m4605setimpl(m4598constructorimpl, materializeModifier, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, 344663265, "C32@1237L22,31@1204L168:NumberButton.kt#1gr92h");
            ImageKt.Image(PainterResources_androidKt.painterResource(i, composer, 0), (String) null, Modifier.Companion, (Alignment) null, ContentScale.Companion.getFillHeight(), 0.0f, (ColorFilter) null, composer, 25008, 104);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            TextKt.m3169TextNvy7gAk(str, ScalingButton.align(Modifier.Companion, Alignment.Companion.getCenter()), Color.Companion.m5317getWhite0d7_KjU(), null, TypeKt.m9855dpToSp8Feqmps(Dp.m7996constructorimpl(16), composer, 6), null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, MaterialTheme.INSTANCE.getTypography(composer, MaterialTheme.$stable).getLabelSmall(), composer, RendererCapabilities.DECODER_SUPPORT_MASK, 0, 131048);
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
        ComposerKt.sourceInformation(startRestartGroup, "C(KeyboardButton)N(text,onClick,isActive)49@1815L30,50@1852L544,48@1782L614:NumberButton.kt#1gr92h");
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
                ComposerKt.traceEventStart(2013669460, i2, -1, "com.miami.game.feature.settings.ui.compose.KeyboardButton (NumberButton.kt:46)");
            }
            final int i3 = z ? R.drawable.keyboard_button_active : R.drawable.keyboard_button;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1893892846, "CC(remember):NumberButton.kt#9igjgp");
            boolean z2 = ((i2 & 896) == 256) | ((i2 & 112) == 32);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (z2 || rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new Function0() { // from class: com.miami.game.feature.settings.ui.compose.NumberButtonKt$$ExternalSyntheticLambda0
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
            ScalingButtonKt.ScalingButton((Function0) rememberedValue, null, ComposableLambdaKt.rememberComposableLambda(685810175, true, new Function3() { // from class: com.miami.game.feature.settings.ui.compose.NumberButtonKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    Unit KeyboardButton$lambda$1;
                    KeyboardButton$lambda$1 = NumberButtonKt.KeyboardButton$lambda$1(text, i3, (BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    return KeyboardButton$lambda$1;
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
                    Unit KeyboardButton$lambda$2;
                    KeyboardButton$lambda$2 = NumberButtonKt.KeyboardButton$lambda$2(text, onClick, z, i, (Composer) obj, ((Integer) obj2).intValue());
                    return KeyboardButton$lambda$2;
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

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit KeyboardButton$lambda$1(String str, int i, BoxScope ScalingButton, Composer composer, int i2) {
        int i3;
        Intrinsics.checkNotNullParameter(ScalingButton, "$this$ScalingButton");
        ComposerKt.sourceInformation(composer, "C51@1862L271,62@2187L10,64@2266L13,61@2142L248:NumberButton.kt#1gr92h");
        if ((i2 & 6) == 0) {
            i3 = i2 | (composer.changed(ScalingButton) ? 4 : 2);
        } else {
            i3 = i2;
        }
        if (!composer.shouldExecute((i3 & 19) != 18, i3 & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(685810175, i3, -1, "com.miami.game.feature.settings.ui.compose.KeyboardButton.<anonymous> (NumberButton.kt:51)");
            }
            Modifier m881height3ABfNKs = SizeKt.m881height3ABfNKs(Modifier.Companion, Dp.m7996constructorimpl(62));
            ComposerKt.sourceInformationMarkerStart(composer, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(composer, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
            int hashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(composer, m881height3ABfNKs);
            Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!(composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer.startReusableNode();
            if (composer.getInserting()) {
                composer.createNode(constructor);
            } else {
                composer.useNode();
            }
            Composer m4598constructorimpl = Updater.m4598constructorimpl(composer);
            Updater.m4605setimpl(m4598constructorimpl, maybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m4605setimpl(m4598constructorimpl, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (m4598constructorimpl.getInserting() || !Intrinsics.areEqual(m4598constructorimpl.rememberedValue(), Integer.valueOf(hashCode))) {
                m4598constructorimpl.updateRememberedValue(Integer.valueOf(hashCode));
                m4598constructorimpl.apply(Integer.valueOf(hashCode), setCompositeKeyHash);
            }
            Updater.m4605setimpl(m4598constructorimpl, materializeModifier, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, 658053314, "C56@1988L22,55@1955L168:NumberButton.kt#1gr92h");
            ImageKt.Image(PainterResources_androidKt.painterResource(i, composer, 0), (String) null, Modifier.Companion, (Alignment) null, ContentScale.Companion.getFillHeight(), 0.0f, (ColorFilter) null, composer, 25008, 104);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            TextKt.m3169TextNvy7gAk(str, OffsetKt.m798offsetVpY3zN4$default(ScalingButton.align(Modifier.Companion, Alignment.Companion.getCenter()), 0.0f, Dp.m7996constructorimpl(-Dp.m7996constructorimpl(2)), 1, null), Color.Companion.m5317getWhite0d7_KjU(), null, TypeKt.m9855dpToSp8Feqmps(Dp.m7996constructorimpl(18), composer, 6), null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, MaterialTheme.INSTANCE.getTypography(composer, MaterialTheme.$stable).getLabelSmall(), composer, RendererCapabilities.DECODER_SUPPORT_MASK, 0, 131048);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}
