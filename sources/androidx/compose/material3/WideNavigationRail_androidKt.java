package androidx.compose.material3;

import android.view.View;
import androidx.compose.foundation.DarkThemeKt;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionContext;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.media3.exoplayer.RendererCapabilities;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
/* compiled from: WideNavigationRail.android.kt */
@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\b\u0010\u0000\u001a\u00020\u0001H\u0000\u001a`\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00052\u0006\u0010\u0006\u001a\u00020\u00012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00030\b2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u00052\u0006\u0010\u000b\u001a\u00020\f2\u0011\u0010\r\u001a\r\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\u0002\b\u000eH\u0001¢\u0006\u0002\u0010\u000f¨\u0006\u0010²\u0006\u0015\u0010\u0011\u001a\r\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\u0002\b\u000eX\u008a\u0084\u0002"}, d2 = {"createDefaultModalWideNavigationRailProperties", "Landroidx/compose/material3/ModalWideNavigationRailProperties;", "ModalWideNavigationRailDialog", "", "onDismissRequest", "Lkotlin/Function0;", "properties", "onPredictiveBack", "Lkotlin/Function1;", "", "onPredictiveBackCancelled", "predictiveBackState", "Landroidx/compose/material3/RailPredictiveBackState;", FirebaseAnalytics.Param.CONTENT, "Landroidx/compose/runtime/Composable;", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/material3/ModalWideNavigationRailProperties;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Landroidx/compose/material3/RailPredictiveBackState;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "material3", "currentContent"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class WideNavigationRail_androidKt {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit ModalWideNavigationRailDialog$lambda$10(Function0 function0, ModalWideNavigationRailProperties modalWideNavigationRailProperties, Function1 function1, Function0 function02, RailPredictiveBackState railPredictiveBackState, Function2 function2, int i, Composer composer, int i2) {
        ModalWideNavigationRailDialog(function0, modalWideNavigationRailProperties, function1, function02, railPredictiveBackState, function2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final ModalWideNavigationRailProperties createDefaultModalWideNavigationRailProperties() {
        return new ModalWideNavigationRailProperties(false, 1, null);
    }

    public static final void ModalWideNavigationRailDialog(Function0<Unit> function0, final ModalWideNavigationRailProperties modalWideNavigationRailProperties, final Function1<? super Float, Unit> function1, final Function0<Unit> function02, final RailPredictiveBackState railPredictiveBackState, final Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i) {
        int i2;
        int i3;
        int i4;
        int i5;
        ModalWideNavigationRailDialogWrapper modalWideNavigationRailDialogWrapper;
        final Function0<Unit> function03 = function0;
        Composer startRestartGroup = composer.startRestartGroup(2015914411);
        ComposerKt.sourceInformation(startRestartGroup, "C(ModalWideNavigationRailDialog)N(onDismissRequest,properties,onPredictiveBack,onPredictiveBackCancelled,predictiveBackState,content)125@5147L7,126@5186L7,127@5241L7,128@5271L28,129@5326L29,130@5392L21,130@5375L38,131@5441L21,133@5488L652,153@6171L129,153@6146L154,162@6317L183,162@6306L194:WideNavigationRail.android.kt#uh7d8r");
        if ((i & 6) == 0) {
            i2 = (startRestartGroup.changedInstance(function03) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= startRestartGroup.changed(modalWideNavigationRailProperties) ? 32 : 16;
        }
        if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i2 |= startRestartGroup.changedInstance(function1) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= startRestartGroup.changedInstance(function02) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i2 |= startRestartGroup.changed(railPredictiveBackState) ? 16384 : 8192;
        }
        if ((196608 & i) == 0) {
            i2 |= startRestartGroup.changedInstance(function2) ? 131072 : 65536;
        }
        if (!startRestartGroup.shouldExecute((74899 & i2) != 74898, i2 & 1)) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2015914411, i2, -1, "androidx.compose.material3.ModalWideNavigationRailDialog (WideNavigationRail.android.kt:124)");
            }
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object consume = startRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalView());
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            View view = (View) consume;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object consume2 = startRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            Density density = (Density) consume2;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object consume3 = startRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            final LayoutDirection layoutDirection = (LayoutDirection) consume3;
            CompositionContext rememberCompositionContext = ComposablesKt.rememberCompositionContext(startRestartGroup, 0);
            State rememberUpdatedState = SnapshotStateKt.rememberUpdatedState(function2, startRestartGroup, (i2 >> 15) & 14);
            Object[] objArr = new Object[0];
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 263517408, "CC(remember):WideNavigationRail.android.kt#9igjgp");
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new Function0() { // from class: androidx.compose.material3.WideNavigationRail_androidKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        UUID randomUUID;
                        randomUUID = UUID.randomUUID();
                        return randomUUID;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            UUID uuid = (UUID) RememberSaveableKt.rememberSaveable(objArr, (Function0) rememberedValue, startRestartGroup, 48);
            boolean isSystemInDarkTheme = DarkThemeKt.isSystemInDarkTheme(startRestartGroup, 0);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 263521111, "CC(remember):WideNavigationRail.android.kt#9igjgp");
            boolean changed = startRestartGroup.changed(view) | startRestartGroup.changed(density);
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (changed || rememberedValue2 == Composer.Companion.getEmpty()) {
                i3 = 0;
                i4 = i2;
                function03 = function0;
                ModalWideNavigationRailDialogWrapper modalWideNavigationRailDialogWrapper2 = new ModalWideNavigationRailDialogWrapper(function03, modalWideNavigationRailProperties, view, layoutDirection, density, uuid, function1, function02, railPredictiveBackState, isSystemInDarkTheme);
                i5 = 1;
                modalWideNavigationRailDialogWrapper2.setContent(rememberCompositionContext, ComposableLambdaKt.composableLambdaInstance(-406777160, true, new WideNavigationRail_androidKt$ModalWideNavigationRailDialog$dialog$1$1$1(rememberUpdatedState)));
                startRestartGroup.updateRememberedValue(modalWideNavigationRailDialogWrapper2);
                modalWideNavigationRailDialogWrapper = modalWideNavigationRailDialogWrapper2;
            } else {
                i4 = i2;
                i5 = 1;
                i3 = 0;
                function03 = function0;
                modalWideNavigationRailDialogWrapper = rememberedValue2;
            }
            final ModalWideNavigationRailDialogWrapper modalWideNavigationRailDialogWrapper3 = (ModalWideNavigationRailDialogWrapper) modalWideNavigationRailDialogWrapper;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 263542444, "CC(remember):WideNavigationRail.android.kt#9igjgp");
            boolean changedInstance = startRestartGroup.changedInstance(modalWideNavigationRailDialogWrapper3);
            Object rememberedValue3 = startRestartGroup.rememberedValue();
            if (changedInstance || rememberedValue3 == Composer.Companion.getEmpty()) {
                rememberedValue3 = new Function1() { // from class: androidx.compose.material3.WideNavigationRail_androidKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return WideNavigationRail_androidKt.ModalWideNavigationRailDialog$lambda$7$lambda$6(ModalWideNavigationRailDialogWrapper.this, (DisposableEffectScope) obj);
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue3);
            }
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            EffectsKt.DisposableEffect(modalWideNavigationRailDialogWrapper3, (Function1) rememberedValue3, startRestartGroup, i3);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 263547170, "CC(remember):WideNavigationRail.android.kt#9igjgp");
            int i6 = (startRestartGroup.changedInstance(modalWideNavigationRailDialogWrapper3) ? 1 : 0) | ((i4 & 14) == 4 ? i5 : i3);
            if ((i4 & 112) != 32) {
                i5 = i3;
            }
            int i7 = i6 | i5 | (startRestartGroup.changed(layoutDirection.ordinal()) ? 1 : 0);
            Object rememberedValue4 = startRestartGroup.rememberedValue();
            if (i7 != 0 || rememberedValue4 == Composer.Companion.getEmpty()) {
                rememberedValue4 = new Function0() { // from class: androidx.compose.material3.WideNavigationRail_androidKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return WideNavigationRail_androidKt.ModalWideNavigationRailDialog$lambda$9$lambda$8(ModalWideNavigationRailDialogWrapper.this, function03, modalWideNavigationRailProperties, layoutDirection);
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue4);
            }
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            EffectsKt.SideEffect((Function0) rememberedValue4, startRestartGroup, i3);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.WideNavigationRail_androidKt$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return WideNavigationRail_androidKt.ModalWideNavigationRailDialog$lambda$10(Function0.this, modalWideNavigationRailProperties, function1, function02, railPredictiveBackState, function2, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final DisposableEffectResult ModalWideNavigationRailDialog$lambda$7$lambda$6(final ModalWideNavigationRailDialogWrapper modalWideNavigationRailDialogWrapper, DisposableEffectScope disposableEffectScope) {
        modalWideNavigationRailDialogWrapper.show();
        return new DisposableEffectResult() { // from class: androidx.compose.material3.WideNavigationRail_androidKt$ModalWideNavigationRailDialog$lambda$7$lambda$6$$inlined$onDispose$1
            @Override // androidx.compose.runtime.DisposableEffectResult
            public void dispose() {
                ModalWideNavigationRailDialogWrapper.this.dismiss();
                ModalWideNavigationRailDialogWrapper.this.disposeComposition();
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit ModalWideNavigationRailDialog$lambda$9$lambda$8(ModalWideNavigationRailDialogWrapper modalWideNavigationRailDialogWrapper, Function0 function0, ModalWideNavigationRailProperties modalWideNavigationRailProperties, LayoutDirection layoutDirection) {
        modalWideNavigationRailDialogWrapper.updateParameters(function0, modalWideNavigationRailProperties, layoutDirection);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Function2<Composer, Integer, Unit> ModalWideNavigationRailDialog$lambda$0(State<? extends Function2<? super Composer, ? super Integer, Unit>> state) {
        return (Function2) state.getValue();
    }
}
