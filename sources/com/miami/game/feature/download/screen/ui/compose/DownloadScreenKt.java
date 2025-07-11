package com.miami.game.feature.download.screen.ui.compose;

import android.content.Context;
import androidx.activity.compose.BackHandlerKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.compose.FlowExtKt;
import com.miami.game.core.decompose.utils.SharedEventFlow;
import com.miami.game.core.ui.utils.extensions.FlowExtensionsKt;
import com.miami.game.feature.download.dialog.ui.error.fromactivity.ErrorDialogFromActivityKt;
import com.miami.game.feature.download.screen.ui.DownloadScreenComponent;
import com.miami.game.feature.download.screen.ui.model.DownloadScreenUiAction;
import com.miami.game.feature.download.screen.ui.model.DownloadScreenUiState;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KFunction;
import okhttp3.internal.ws.WebSocketProtocol;
/* compiled from: DownloadScreen.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0015\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0007¢\u0006\u0002\u0010\u0004\u001a#\u0010\u0005\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00010\tH\u0007¢\u0006\u0002\u0010\n¨\u0006\u000b²\u0006\n\u0010\u0006\u001a\u00020\u0007X\u008a\u0084\u0002"}, d2 = {"DownloadScreenRoute", "", "component", "Lcom/miami/game/feature/download/screen/ui/DownloadScreenComponent;", "(Lcom/miami/game/feature/download/screen/ui/DownloadScreenComponent;Landroidx/compose/runtime/Composer;I)V", "DownloadScreen", "uiState", "Lcom/miami/game/feature/download/screen/ui/model/DownloadScreenUiState;", "onSoundClick", "Lkotlin/Function0;", "(Lcom/miami/game/feature/download/screen/ui/model/DownloadScreenUiState;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "download-screen_release_web"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class DownloadScreenKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DownloadScreen$lambda$9(DownloadScreenUiState downloadScreenUiState, Function0 function0, int i, Composer composer, int i2) {
        DownloadScreen(downloadScreenUiState, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DownloadScreenRoute$lambda$8(DownloadScreenComponent downloadScreenComponent, int i, Composer composer, int i2) {
        DownloadScreenRoute(downloadScreenComponent, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final void DownloadScreenRoute(final DownloadScreenComponent component, Composer composer, final int i) {
        int i2;
        Composer composer2;
        Intrinsics.checkNotNullParameter(component, "component");
        Composer startRestartGroup = composer.startRestartGroup(-1785886338);
        ComposerKt.sourceInformation(startRestartGroup, "C(DownloadScreenRoute)26@1179L2,25@1148L39,29@1249L260,29@1212L297,35@1541L7,36@1574L192,36@1553L213,45@1805L29,51@1985L23,47@1840L174:DownloadScreen.kt#k3v2wi");
        if ((i & 6) == 0) {
            i2 = (startRestartGroup.changedInstance(component) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if (!startRestartGroup.shouldExecute((i2 & 3) != 2, i2 & 1)) {
            composer2 = startRestartGroup;
            composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1785886338, i2, -1, "com.miami.game.feature.download.screen.ui.compose.DownloadScreenRoute (DownloadScreen.kt:23)");
            }
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1750155456, "CC(remember):DownloadScreen.kt#9igjgp");
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new Function0() { // from class: com.miami.game.feature.download.screen.ui.compose.DownloadScreenKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit unit;
                        unit = Unit.INSTANCE;
                        return unit;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            BackHandlerKt.BackHandler(false, (Function0) rememberedValue, startRestartGroup, 48, 1);
            SharedEventFlow<DownloadScreenUiAction> uiAction = component.getUiAction();
            Object[] objArr = new Object[0];
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1750157954, "CC(remember):DownloadScreen.kt#9igjgp");
            DownloadScreenKt$DownloadScreenRoute$2$1 rememberedValue2 = startRestartGroup.rememberedValue();
            if (rememberedValue2 == Composer.Companion.getEmpty()) {
                rememberedValue2 = new DownloadScreenKt$DownloadScreenRoute$2$1(null);
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            FlowExtensionsKt.collectInLaunchedEffectWithLifecycle(uiAction, objArr, null, null, (Function3) rememberedValue2, startRestartGroup, 0, 6);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object consume = startRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            Context context = (Context) consume;
            Unit unit = Unit.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1750168286, "CC(remember):DownloadScreen.kt#9igjgp");
            DownloadScreenKt$DownloadScreenRoute$3$1 rememberedValue3 = startRestartGroup.rememberedValue();
            if (rememberedValue3 == Composer.Companion.getEmpty()) {
                rememberedValue3 = new DownloadScreenKt$DownloadScreenRoute$3$1(null);
                startRestartGroup.updateRememberedValue(rememberedValue3);
            }
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            EffectsKt.LaunchedEffect(unit, (Function2) rememberedValue3, startRestartGroup, 6);
            State collectAsStateWithLifecycle = FlowExtKt.collectAsStateWithLifecycle(component.getUiState(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, startRestartGroup, 0, 7);
            composer2 = startRestartGroup;
            DownloadScreenUiState DownloadScreenRoute$lambda$4 = DownloadScreenRoute$lambda$4(collectAsStateWithLifecycle);
            ComposerKt.sourceInformationMarkerStart(composer2, 1750181269, "CC(remember):DownloadScreen.kt#9igjgp");
            boolean changedInstance = composer2.changedInstance(component);
            DownloadScreenKt$DownloadScreenRoute$4$1 rememberedValue4 = composer2.rememberedValue();
            if (changedInstance || rememberedValue4 == Composer.Companion.getEmpty()) {
                rememberedValue4 = new DownloadScreenKt$DownloadScreenRoute$4$1(component);
                composer2.updateRememberedValue(rememberedValue4);
            }
            ComposerKt.sourceInformationMarkerEnd(composer2);
            DownloadScreen(DownloadScreenRoute$lambda$4, (Function0) ((KFunction) rememberedValue4), composer2, 0);
            if (!DownloadScreenRoute$lambda$4(collectAsStateWithLifecycle).isDialogVisible()) {
                composer2.startReplaceGroup(-1580926332);
            } else {
                composer2.startReplaceGroup(-1578892794);
                ComposerKt.sourceInformation(composer2, "54@2100L2,54@2057L46");
                ComposerKt.sourceInformationMarkerStart(composer2, 1750184928, "CC(remember):DownloadScreen.kt#9igjgp");
                Object rememberedValue5 = composer2.rememberedValue();
                if (rememberedValue5 == Composer.Companion.getEmpty()) {
                    rememberedValue5 = new Function0() { // from class: com.miami.game.feature.download.screen.ui.compose.DownloadScreenKt$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit unit2;
                            unit2 = Unit.INSTANCE;
                            return unit2;
                        }
                    };
                    composer2.updateRememberedValue(rememberedValue5);
                }
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ErrorDialogFromActivityKt.ErrorDialogFromActivityRoute(null, (Function0) rememberedValue5, null, composer2, 48, 5);
                composer2 = composer2;
            }
            composer2.endReplaceGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: com.miami.game.feature.download.screen.ui.compose.DownloadScreenKt$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit DownloadScreenRoute$lambda$8;
                    DownloadScreenRoute$lambda$8 = DownloadScreenKt.DownloadScreenRoute$lambda$8(DownloadScreenComponent.this, i, (Composer) obj, ((Integer) obj2).intValue());
                    return DownloadScreenRoute$lambda$8;
                }
            });
        }
    }

    public static final void DownloadScreen(final DownloadScreenUiState uiState, final Function0<Unit> onSoundClick, Composer composer, final int i) {
        int i2;
        Intrinsics.checkNotNullParameter(uiState, "uiState");
        Intrinsics.checkNotNullParameter(onSoundClick, "onSoundClick");
        Composer startRestartGroup = composer.startRestartGroup(1958056837);
        ComposerKt.sourceInformation(startRestartGroup, "C(DownloadScreen)P(1)62@2213L38:DownloadScreen.kt#k3v2wi");
        if ((i & 6) == 0) {
            i2 = (startRestartGroup.changed(uiState) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= startRestartGroup.changedInstance(onSoundClick) ? 32 : 16;
        }
        if (!startRestartGroup.shouldExecute((i2 & 19) != 18, i2 & 1)) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1958056837, i2, -1, "com.miami.game.feature.download.screen.ui.compose.DownloadScreen (DownloadScreen.kt:61)");
            }
            DownloadContentKt.DownloadContent(uiState, onSoundClick, startRestartGroup, i2 & WebSocketProtocol.PAYLOAD_SHORT);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: com.miami.game.feature.download.screen.ui.compose.DownloadScreenKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit DownloadScreen$lambda$9;
                    DownloadScreen$lambda$9 = DownloadScreenKt.DownloadScreen$lambda$9(DownloadScreenUiState.this, onSoundClick, i, (Composer) obj, ((Integer) obj2).intValue());
                    return DownloadScreen$lambda$9;
                }
            });
        }
    }

    private static final DownloadScreenUiState DownloadScreenRoute$lambda$4(State<DownloadScreenUiState> state) {
        return state.getValue();
    }
}
