package com.miami.game.feature.settings.ui.compose;

import androidx.activity.compose.BackHandlerKt;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.ScrollState;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.IntrinsicKt;
import androidx.compose.foundation.layout.IntrinsicSize;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.material3.ScaffoldKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.unit.Dp;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.compose.FlowExtKt;
import androidx.media3.common.C;
import androidx.media3.exoplayer.RendererCapabilities;
import androidx.profileinstaller.ProfileVerifier;
import com.miami.game.core.decompose.utils.SharedEventFlow;
import com.miami.game.core.design.system.component.background.Main_backgroundKt;
import com.miami.game.core.design.system.component.other.ScrollBarKt;
import com.miami.game.core.external.navigation.ui.ObserveExternalNavigationActionsKt;
import com.miami.game.core.ui.utils.extensions.FlowExtensionsKt;
import com.miami.game.feature.download.dialog.ui.connection.ConnectionData;
import com.miami.game.feature.download.dialog.ui.connection.ConnectionDialogKt;
import com.miami.game.feature.settings.ui.SettingsComponent;
import com.miami.game.feature.settings.ui.model.SettingsUiAction;
import com.miami.game.feature.settings.ui.model.SettingsUiState;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KFunction;
/* compiled from: SettingsScreen.kt */
@Metadata(d1 = {"\u00004\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0012\u001ag\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\u0018\u0010\t\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u0005\u0012\u0004\u0012\u00020\u00010\nH\u0007¢\u0006\u0002\u0010\u000b\u001a\u008f\u0002\u0010\f\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00010\n2\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00010\n2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00010\u0005H\u0001¢\u0006\u0002\u0010!\u001a\u0015\u0010\"\u001a\u00020\u00012\u0006\u0010#\u001a\u00020\u0013H\u0001¢\u0006\u0002\u0010$¨\u0006%²\u0006\n\u0010\r\u001a\u00020\u000eX\u008a\u0084\u0002"}, d2 = {"SettingsRoute", "", "component", "Lcom/miami/game/feature/settings/ui/SettingsComponent;", "onBackClick", "Lkotlin/Function0;", "onRepairGameSuccess", "onRepairGameError", "onNavigateDownload", "onRepairGameDialog", "Lkotlin/Function1;", "(Lcom/miami/game/feature/settings/ui/SettingsComponent;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "SettingsScreen", "uiState", "Lcom/miami/game/feature/settings/ui/model/SettingsUiState;", "onRepairGame", "onFontSize", "", "onPageSize", "", "onFullScreen", "onShowFPS", "onUpdatedGraphics", "onShowChatTime", "onAmbientSounds", "onBugsReport", "onShareLogs", "onLongShareLogs", "onPrivacyPolicy", "onTech", "onKeyboard", "onStreamer", "onNotification", "(Lcom/miami/game/feature/settings/ui/model/SettingsUiState;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "BackgroundImage", "backGroundId", "(ILandroidx/compose/runtime/Composer;I)V", "settings"}, k = 2, mv = {2, 3, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class SettingsScreenKt {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit BackgroundImage$lambda$0(int i, int i2, Composer composer, int i3) {
        BackgroundImage(i, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit SettingsRoute$lambda$20(SettingsComponent settingsComponent, Function0 function0, Function0 function02, Function0 function03, Function0 function04, Function1 function1, int i, Composer composer, int i2) {
        SettingsRoute(settingsComponent, function0, function02, function03, function04, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit SettingsScreen$lambda$3(SettingsUiState settingsUiState, Function0 function0, Function0 function02, Function1 function1, Function1 function12, Function0 function03, Function0 function04, Function0 function05, Function0 function06, Function0 function07, Function0 function08, Function0 function09, Function0 function010, Function0 function011, Function0 function012, Function0 function013, Function0 function014, Function0 function015, int i, int i2, Composer composer, int i3) {
        SettingsScreen(settingsUiState, function0, function02, function1, function12, function03, function04, function05, function06, function07, function08, function09, function010, function011, function012, function013, function014, function015, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2));
        return Unit.INSTANCE;
    }

    public static final void SettingsRoute(final SettingsComponent component, final Function0<Unit> onBackClick, final Function0<Unit> onRepairGameSuccess, final Function0<Unit> onRepairGameError, final Function0<Unit> onNavigateDownload, final Function1<? super Function0<Unit>, Unit> onRepairGameDialog, Composer composer, final int i) {
        int i2;
        Intrinsics.checkNotNullParameter(component, "component");
        Intrinsics.checkNotNullParameter(onBackClick, "onBackClick");
        Intrinsics.checkNotNullParameter(onRepairGameSuccess, "onRepairGameSuccess");
        Intrinsics.checkNotNullParameter(onRepairGameError, "onRepairGameError");
        Intrinsics.checkNotNullParameter(onNavigateDownload, "onNavigateDownload");
        Intrinsics.checkNotNullParameter(onRepairGameDialog, "onRepairGameDialog");
        Composer startRestartGroup = composer.startRestartGroup(-681024813);
        ComposerKt.sourceInformation(startRestartGroup, "C(SettingsRoute)N(component,onBackClick,onRepairGameSuccess,onRepairGameError,onNavigateDownload,onRepairGameDialog)50@2327L33,52@2399L29,54@2490L227,54@2453L264,62@2757L34,66@2863L28,68@2949L25,69@2997L25,70@3047L23,71@3092L16,72@3138L28,73@3193L21,74@3242L26,75@3293L23,76@3344L26,77@3394L22,78@3444L26,79@3489L17,80@3529L21,81@3573L21,82@3621L26,64@2797L857:SettingsScreen.kt#1gr92h");
        if ((i & 6) == 0) {
            i2 = i | (startRestartGroup.changedInstance(component) ? 4 : 2);
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= startRestartGroup.changedInstance(onBackClick) ? 32 : 16;
        }
        if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
            i2 |= startRestartGroup.changedInstance(onRepairGameDialog) ? 131072 : 65536;
        }
        int i3 = i2;
        if (startRestartGroup.shouldExecute((65555 & i3) != 65554, i3 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-681024813, i3, -1, "com.miami.game.feature.settings.ui.compose.SettingsRoute (SettingsScreen.kt:49)");
            }
            BackHandlerKt.BackHandler(false, onBackClick, startRestartGroup, i3 & 112, 1);
            State collectAsStateWithLifecycle = FlowExtKt.collectAsStateWithLifecycle(component.getUiState(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, startRestartGroup, 0, 7);
            SharedEventFlow<SettingsUiAction> uiAction = component.getUiAction();
            Object[] objArr = new Object[0];
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1629803146, "CC(remember):SettingsScreen.kt#9igjgp");
            boolean changedInstance = ((458752 & i3) == 131072) | startRestartGroup.changedInstance(component);
            SettingsScreenKt$SettingsRoute$1$1 rememberedValue = startRestartGroup.rememberedValue();
            if (changedInstance || rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new SettingsScreenKt$SettingsRoute$1$1(onRepairGameDialog, component, null);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            FlowExtensionsKt.collectInLaunchedEffectWithLifecycle(uiAction, objArr, null, null, (Function3) rememberedValue, startRestartGroup, 0, 6);
            ObserveExternalNavigationActionsKt.observeExternalNavigationActions(component.getExternalNavigationAction(), startRestartGroup, 0);
            SettingsUiState SettingsRoute$lambda$0 = SettingsRoute$lambda$0(collectAsStateWithLifecycle);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1629791409, "CC(remember):SettingsScreen.kt#9igjgp");
            boolean changedInstance2 = startRestartGroup.changedInstance(component);
            SettingsScreenKt$SettingsRoute$2$1 rememberedValue2 = startRestartGroup.rememberedValue();
            if (changedInstance2 || rememberedValue2 == Composer.Companion.getEmpty()) {
                rememberedValue2 = new SettingsScreenKt$SettingsRoute$2$1(component);
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            KFunction kFunction = (KFunction) rememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1629788660, "CC(remember):SettingsScreen.kt#9igjgp");
            boolean changedInstance3 = startRestartGroup.changedInstance(component);
            SettingsScreenKt$SettingsRoute$3$1 rememberedValue3 = startRestartGroup.rememberedValue();
            if (changedInstance3 || rememberedValue3 == Composer.Companion.getEmpty()) {
                rememberedValue3 = new SettingsScreenKt$SettingsRoute$3$1(component);
                startRestartGroup.updateRememberedValue(rememberedValue3);
            }
            KFunction kFunction2 = (KFunction) rememberedValue3;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1629787124, "CC(remember):SettingsScreen.kt#9igjgp");
            boolean changedInstance4 = startRestartGroup.changedInstance(component);
            SettingsScreenKt$SettingsRoute$4$1 rememberedValue4 = startRestartGroup.rememberedValue();
            if (changedInstance4 || rememberedValue4 == Composer.Companion.getEmpty()) {
                rememberedValue4 = new SettingsScreenKt$SettingsRoute$4$1(component);
                startRestartGroup.updateRememberedValue(rememberedValue4);
            }
            KFunction kFunction3 = (KFunction) rememberedValue4;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1629785526, "CC(remember):SettingsScreen.kt#9igjgp");
            boolean changedInstance5 = startRestartGroup.changedInstance(component);
            SettingsScreenKt$SettingsRoute$5$1 rememberedValue5 = startRestartGroup.rememberedValue();
            if (changedInstance5 || rememberedValue5 == Composer.Companion.getEmpty()) {
                rememberedValue5 = new SettingsScreenKt$SettingsRoute$5$1(component);
                startRestartGroup.updateRememberedValue(rememberedValue5);
            }
            KFunction kFunction4 = (KFunction) rememberedValue5;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1629784093, "CC(remember):SettingsScreen.kt#9igjgp");
            boolean changedInstance6 = startRestartGroup.changedInstance(component);
            SettingsScreenKt$SettingsRoute$6$1 rememberedValue6 = startRestartGroup.rememberedValue();
            if (changedInstance6 || rememberedValue6 == Composer.Companion.getEmpty()) {
                rememberedValue6 = new SettingsScreenKt$SettingsRoute$6$1(component);
                startRestartGroup.updateRememberedValue(rememberedValue6);
            }
            KFunction kFunction5 = (KFunction) rememberedValue6;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1629782609, "CC(remember):SettingsScreen.kt#9igjgp");
            boolean changedInstance7 = startRestartGroup.changedInstance(component);
            SettingsScreenKt$SettingsRoute$7$1 rememberedValue7 = startRestartGroup.rememberedValue();
            if (changedInstance7 || rememberedValue7 == Composer.Companion.getEmpty()) {
                rememberedValue7 = new SettingsScreenKt$SettingsRoute$7$1(component);
                startRestartGroup.updateRememberedValue(rememberedValue7);
            }
            KFunction kFunction6 = (KFunction) rememberedValue7;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1629780856, "CC(remember):SettingsScreen.kt#9igjgp");
            boolean changedInstance8 = startRestartGroup.changedInstance(component);
            SettingsScreenKt$SettingsRoute$8$1 rememberedValue8 = startRestartGroup.rememberedValue();
            if (changedInstance8 || rememberedValue8 == Composer.Companion.getEmpty()) {
                rememberedValue8 = new SettingsScreenKt$SettingsRoute$8$1(component);
                startRestartGroup.updateRememberedValue(rememberedValue8);
            }
            KFunction kFunction7 = (KFunction) rememberedValue8;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1629779283, "CC(remember):SettingsScreen.kt#9igjgp");
            boolean changedInstance9 = startRestartGroup.changedInstance(component);
            SettingsScreenKt$SettingsRoute$9$1 rememberedValue9 = startRestartGroup.rememberedValue();
            if (changedInstance9 || rememberedValue9 == Composer.Companion.getEmpty()) {
                rememberedValue9 = new SettingsScreenKt$SettingsRoute$9$1(component);
                startRestartGroup.updateRememberedValue(rememberedValue9);
            }
            KFunction kFunction8 = (KFunction) rememberedValue9;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1629777654, "CC(remember):SettingsScreen.kt#9igjgp");
            boolean changedInstance10 = startRestartGroup.changedInstance(component);
            SettingsScreenKt$SettingsRoute$10$1 rememberedValue10 = startRestartGroup.rememberedValue();
            if (changedInstance10 || rememberedValue10 == Composer.Companion.getEmpty()) {
                rememberedValue10 = new SettingsScreenKt$SettingsRoute$10$1(component);
                startRestartGroup.updateRememberedValue(rememberedValue10);
            }
            KFunction kFunction9 = (KFunction) rememberedValue10;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1629776019, "CC(remember):SettingsScreen.kt#9igjgp");
            boolean changedInstance11 = startRestartGroup.changedInstance(component);
            SettingsScreenKt$SettingsRoute$11$1 rememberedValue11 = startRestartGroup.rememberedValue();
            if (changedInstance11 || rememberedValue11 == Composer.Companion.getEmpty()) {
                rememberedValue11 = new SettingsScreenKt$SettingsRoute$11$1(component);
                startRestartGroup.updateRememberedValue(rememberedValue11);
            }
            KFunction kFunction10 = (KFunction) rememberedValue11;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1629774423, "CC(remember):SettingsScreen.kt#9igjgp");
            boolean changedInstance12 = startRestartGroup.changedInstance(component);
            SettingsScreenKt$SettingsRoute$12$1 rememberedValue12 = startRestartGroup.rememberedValue();
            if (changedInstance12 || rememberedValue12 == Composer.Companion.getEmpty()) {
                rememberedValue12 = new SettingsScreenKt$SettingsRoute$12$1(component);
                startRestartGroup.updateRememberedValue(rememberedValue12);
            }
            KFunction kFunction11 = (KFunction) rememberedValue12;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1629772819, "CC(remember):SettingsScreen.kt#9igjgp");
            boolean changedInstance13 = startRestartGroup.changedInstance(component);
            SettingsScreenKt$SettingsRoute$13$1 rememberedValue13 = startRestartGroup.rememberedValue();
            if (changedInstance13 || rememberedValue13 == Composer.Companion.getEmpty()) {
                rememberedValue13 = new SettingsScreenKt$SettingsRoute$13$1(component);
                startRestartGroup.updateRememberedValue(rememberedValue13);
            }
            KFunction kFunction12 = (KFunction) rememberedValue13;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1629771388, "CC(remember):SettingsScreen.kt#9igjgp");
            boolean changedInstance14 = startRestartGroup.changedInstance(component);
            SettingsScreenKt$SettingsRoute$14$1 rememberedValue14 = startRestartGroup.rememberedValue();
            if (changedInstance14 || rememberedValue14 == Composer.Companion.getEmpty()) {
                rememberedValue14 = new SettingsScreenKt$SettingsRoute$14$1(component);
                startRestartGroup.updateRememberedValue(rememberedValue14);
            }
            KFunction kFunction13 = (KFunction) rememberedValue14;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1629770104, "CC(remember):SettingsScreen.kt#9igjgp");
            boolean changedInstance15 = startRestartGroup.changedInstance(component);
            SettingsScreenKt$SettingsRoute$15$1 rememberedValue15 = startRestartGroup.rememberedValue();
            if (changedInstance15 || rememberedValue15 == Composer.Companion.getEmpty()) {
                rememberedValue15 = new SettingsScreenKt$SettingsRoute$15$1(component);
                startRestartGroup.updateRememberedValue(rememberedValue15);
            }
            KFunction kFunction14 = (KFunction) rememberedValue15;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1629768696, "CC(remember):SettingsScreen.kt#9igjgp");
            boolean changedInstance16 = startRestartGroup.changedInstance(component);
            SettingsScreenKt$SettingsRoute$16$1 rememberedValue16 = startRestartGroup.rememberedValue();
            if (changedInstance16 || rememberedValue16 == Composer.Companion.getEmpty()) {
                rememberedValue16 = new SettingsScreenKt$SettingsRoute$16$1(component);
                startRestartGroup.updateRememberedValue(rememberedValue16);
            }
            KFunction kFunction15 = (KFunction) rememberedValue16;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1629767155, "CC(remember):SettingsScreen.kt#9igjgp");
            boolean changedInstance17 = startRestartGroup.changedInstance(component);
            SettingsScreenKt$SettingsRoute$17$1 rememberedValue17 = startRestartGroup.rememberedValue();
            if (changedInstance17 || rememberedValue17 == Composer.Companion.getEmpty()) {
                rememberedValue17 = new SettingsScreenKt$SettingsRoute$17$1(component);
                startRestartGroup.updateRememberedValue(rememberedValue17);
            }
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            SettingsScreen(SettingsRoute$lambda$0, (Function0) kFunction, onBackClick, (Function1) kFunction2, (Function1) kFunction3, (Function0) kFunction4, (Function0) kFunction5, (Function0) kFunction6, (Function0) kFunction7, (Function0) kFunction8, (Function0) kFunction9, (Function0) kFunction11, (Function0) kFunction12, (Function0) kFunction10, (Function0) kFunction13, (Function0) kFunction14, (Function0) kFunction15, (Function0) ((KFunction) rememberedValue17), startRestartGroup, (i3 << 3) & 896, 0);
            startRestartGroup = startRestartGroup;
            if (SettingsRoute$lambda$0(collectAsStateWithLifecycle).isConnectionDialogVisible()) {
                startRestartGroup.startReplaceGroup(1016907186);
                ComposerKt.sourceInformation(startRestartGroup, "88@3801L20,89@3847L24,86@3708L173");
                ConnectionData connectionData = SettingsRoute$lambda$0(collectAsStateWithLifecycle).getConnectionData();
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1629761401, "CC(remember):SettingsScreen.kt#9igjgp");
                boolean changedInstance18 = startRestartGroup.changedInstance(component);
                SettingsScreenKt$SettingsRoute$18$1 rememberedValue18 = startRestartGroup.rememberedValue();
                if (changedInstance18 || rememberedValue18 == Composer.Companion.getEmpty()) {
                    rememberedValue18 = new SettingsScreenKt$SettingsRoute$18$1(component);
                    startRestartGroup.updateRememberedValue(rememberedValue18);
                }
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                Function0 function0 = (Function0) ((KFunction) rememberedValue18);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1629759925, "CC(remember):SettingsScreen.kt#9igjgp");
                boolean changedInstance19 = startRestartGroup.changedInstance(component);
                SettingsScreenKt$SettingsRoute$19$1 rememberedValue19 = startRestartGroup.rememberedValue();
                if (changedInstance19 || rememberedValue19 == Composer.Companion.getEmpty()) {
                    rememberedValue19 = new SettingsScreenKt$SettingsRoute$19$1(component);
                    startRestartGroup.updateRememberedValue(rememberedValue19);
                }
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ConnectionDialogKt.ConnectionDialog(connectionData, function0, (Function1) ((KFunction) rememberedValue19), startRestartGroup, ConnectionData.$stable);
                startRestartGroup.endReplaceGroup();
            } else {
                startRestartGroup.startReplaceGroup(1017088815);
                startRestartGroup.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: com.miami.game.feature.settings.ui.compose.SettingsScreenKt$$ExternalSyntheticLambda5
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return SettingsScreenKt.SettingsRoute$lambda$20(SettingsComponent.this, onBackClick, onRepairGameSuccess, onRepairGameError, onNavigateDownload, onRepairGameDialog, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    public static final void SettingsScreen(final SettingsUiState uiState, final Function0<Unit> onRepairGame, final Function0<Unit> onBackClick, final Function1<? super Float, Unit> onFontSize, final Function1<? super Integer, Unit> onPageSize, final Function0<Unit> onFullScreen, final Function0<Unit> onShowFPS, final Function0<Unit> onUpdatedGraphics, final Function0<Unit> onShowChatTime, final Function0<Unit> onAmbientSounds, final Function0<Unit> onBugsReport, final Function0<Unit> onShareLogs, final Function0<Unit> onLongShareLogs, final Function0<Unit> onPrivacyPolicy, final Function0<Unit> onTech, final Function0<Unit> onKeyboard, final Function0<Unit> onStreamer, final Function0<Unit> onNotification, Composer composer, final int i, final int i2) {
        int i3;
        int i4;
        Composer composer2;
        Intrinsics.checkNotNullParameter(uiState, "uiState");
        Intrinsics.checkNotNullParameter(onRepairGame, "onRepairGame");
        Intrinsics.checkNotNullParameter(onBackClick, "onBackClick");
        Intrinsics.checkNotNullParameter(onFontSize, "onFontSize");
        Intrinsics.checkNotNullParameter(onPageSize, "onPageSize");
        Intrinsics.checkNotNullParameter(onFullScreen, "onFullScreen");
        Intrinsics.checkNotNullParameter(onShowFPS, "onShowFPS");
        Intrinsics.checkNotNullParameter(onUpdatedGraphics, "onUpdatedGraphics");
        Intrinsics.checkNotNullParameter(onShowChatTime, "onShowChatTime");
        Intrinsics.checkNotNullParameter(onAmbientSounds, "onAmbientSounds");
        Intrinsics.checkNotNullParameter(onBugsReport, "onBugsReport");
        Intrinsics.checkNotNullParameter(onShareLogs, "onShareLogs");
        Intrinsics.checkNotNullParameter(onLongShareLogs, "onLongShareLogs");
        Intrinsics.checkNotNullParameter(onPrivacyPolicy, "onPrivacyPolicy");
        Intrinsics.checkNotNullParameter(onTech, "onTech");
        Intrinsics.checkNotNullParameter(onKeyboard, "onKeyboard");
        Intrinsics.checkNotNullParameter(onStreamer, "onStreamer");
        Intrinsics.checkNotNullParameter(onNotification, "onNotification");
        Composer startRestartGroup = composer.startRestartGroup(2102340413);
        ComposerKt.sourceInformation(startRestartGroup, "C(SettingsScreen)N(uiState,onRepairGame,onBackClick,onFontSize,onPageSize,onFullScreen,onShowFPS,onUpdatedGraphics,onShowChatTime,onAmbientSounds,onBugsReport,onShareLogs,onLongShareLogs,onPrivacyPolicy,onTech,onKeyboard,onStreamer,onNotification)125@4718L282,242@9755L246,135@5020L4713,119@4551L5451:SettingsScreen.kt#1gr92h");
        if ((i & 6) == 0) {
            i3 = i | (startRestartGroup.changed(uiState) ? 4 : 2);
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= startRestartGroup.changedInstance(onRepairGame) ? 32 : 16;
        }
        if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i3 |= startRestartGroup.changedInstance(onBackClick) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i3 |= startRestartGroup.changedInstance(onFontSize) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i3 |= startRestartGroup.changedInstance(onPageSize) ? 16384 : 8192;
        }
        if ((196608 & i) == 0) {
            i3 |= startRestartGroup.changedInstance(onFullScreen) ? 131072 : 65536;
        }
        if ((i & 1572864) == 0) {
            i3 |= startRestartGroup.changedInstance(onShowFPS) ? 1048576 : 524288;
        }
        if ((i & 12582912) == 0) {
            i3 |= startRestartGroup.changedInstance(onUpdatedGraphics) ? 8388608 : 4194304;
        }
        if ((i & 100663296) == 0) {
            i3 |= startRestartGroup.changedInstance(onShowChatTime) ? 67108864 : 33554432;
        }
        if ((i & 805306368) == 0) {
            i3 |= startRestartGroup.changedInstance(onAmbientSounds) ? C.BUFFER_FLAG_LAST_SAMPLE : 268435456;
        }
        int i5 = i3;
        if ((i2 & 6) == 0) {
            i4 = i2 | (startRestartGroup.changedInstance(onBugsReport) ? 4 : 2);
        } else {
            i4 = i2;
        }
        if ((i2 & 48) == 0) {
            i4 |= startRestartGroup.changedInstance(onShareLogs) ? 32 : 16;
        }
        if ((i2 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i4 |= startRestartGroup.changedInstance(onLongShareLogs) ? 256 : 128;
        }
        if ((i2 & 3072) == 0) {
            i4 |= startRestartGroup.changedInstance(onPrivacyPolicy) ? 2048 : 1024;
        }
        if ((i2 & 24576) == 0) {
            i4 |= startRestartGroup.changedInstance(onTech) ? 16384 : 8192;
        }
        if ((i2 & 1572864) == 0) {
            i4 |= startRestartGroup.changedInstance(onStreamer) ? 1048576 : 524288;
        }
        if ((i2 & 12582912) == 0) {
            i4 |= startRestartGroup.changedInstance(onNotification) ? 8388608 : 4194304;
        }
        int i6 = i4;
        if (!startRestartGroup.shouldExecute(((i5 & 306783379) == 306783378 && (4727955 & i6) == 4727954) ? false : true, i5 & 1)) {
            composer2 = startRestartGroup;
            composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2102340413, i5, i6, "com.miami.game.feature.settings.ui.compose.SettingsScreen (SettingsScreen.kt:118)");
            }
            composer2 = startRestartGroup;
            ScaffoldKt.m2405ScaffoldTvnljyQ(SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, null), ComposableLambdaKt.rememberComposableLambda(534484225, true, new Function2() { // from class: com.miami.game.feature.settings.ui.compose.SettingsScreenKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return SettingsScreenKt.SettingsScreen$lambda$0(SettingsUiState.this, onRepairGame, onBackClick, onBugsReport, onTech, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer2, 54), ComposableLambdaKt.rememberComposableLambda(1676831810, true, new Function2() { // from class: com.miami.game.feature.settings.ui.compose.SettingsScreenKt$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return SettingsScreenKt.SettingsScreen$lambda$1(Function0.this, onShareLogs, onPrivacyPolicy, onLongShareLogs, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer2, 54), null, null, 0, Color.Companion.m4807getTransparent0d7_KjU(), 0L, null, ComposableLambdaKt.rememberComposableLambda(260884876, true, new Function3() { // from class: com.miami.game.feature.settings.ui.compose.SettingsScreenKt$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return SettingsScreenKt.SettingsScreen$lambda$2(SettingsUiState.this, onFontSize, onPageSize, onStreamer, onFullScreen, onShowChatTime, onAmbientSounds, onNotification, onShowFPS, onUpdatedGraphics, (PaddingValues) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composer2, 54), composer2, 806879670, 440);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: com.miami.game.feature.settings.ui.compose.SettingsScreenKt$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return SettingsScreenKt.SettingsScreen$lambda$3(SettingsUiState.this, onRepairGame, onBackClick, onFontSize, onPageSize, onFullScreen, onShowFPS, onUpdatedGraphics, onShowChatTime, onAmbientSounds, onBugsReport, onShareLogs, onLongShareLogs, onPrivacyPolicy, onTech, onKeyboard, onStreamer, onNotification, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit SettingsScreen$lambda$0(SettingsUiState settingsUiState, Function0 function0, Function0 function02, Function0 function03, Function0 function04, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C126@4732L258:SettingsScreen.kt#1gr92h");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(534484225, i, -1, "com.miami.game.feature.settings.ui.compose.SettingsScreen.<anonymous> (SettingsScreen.kt:126)");
            }
            SettingsTopBarKt.SettingsTopBar(settingsUiState, Modifier.Companion, function0, function02, function03, function04, composer, 48);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit SettingsScreen$lambda$2(SettingsUiState settingsUiState, Function1 function1, Function1 function12, Function0 function0, Function0 function02, Function0 function03, Function0 function04, Function0 function05, Function0 function06, Function0 function07, PaddingValues padding, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(padding, "padding");
        ComposerKt.sourceInformation(composer, "CN(padding)137@5046L189,145@5249L4474:SettingsScreen.kt#1gr92h");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(260884876, i, -1, "com.miami.game.feature.settings.ui.compose.SettingsScreen.<anonymous> (SettingsScreen.kt:137)");
            }
            Main_backgroundKt.BackgroundImage(settingsUiState.getBackGroundId(), true, settingsUiState.getImageBitmap(), settingsUiState.getFile(), settingsUiState.getVersion(), composer, 48);
            Modifier m264backgroundbw27NRU$default = BackgroundKt.m264backgroundbw27NRU$default(SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, null), ColorKt.Color(1711276032), null, 2, null);
            ComposerKt.sourceInformationMarkerStart(composer, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getSpaceBetween(), Alignment.Companion.getStart(), composer, 6);
            ComposerKt.sourceInformationMarkerStart(composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int hashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(composer, m264backgroundbw27NRU$default);
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
            Composer m4041constructorimpl = Updater.m4041constructorimpl(composer);
            Updater.m4049setimpl(m4041constructorimpl, columnMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m4049setimpl(m4041constructorimpl, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.m4045initimpl(m4041constructorimpl, Integer.valueOf(hashCode), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.m4047reconcileimpl(m4041constructorimpl, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.m4049setimpl(m4041constructorimpl, materializeModifier, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, -1679091173, "C153@5549L21,154@5587L4122:SettingsScreen.kt#1gr92h");
            ScrollState rememberScrollState = ScrollKt.rememberScrollState(0, composer, 0, 1);
            float f = 68;
            float f2 = 8;
            Modifier clipToBounds = ClipKt.clipToBounds(PaddingKt.m821paddingqDBjuR0(SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, null), Dp.m7555constructorimpl(80), Dp.m7555constructorimpl(f), Dp.m7555constructorimpl(f2), Dp.m7555constructorimpl(f)));
            Alignment center = Alignment.Companion.getCenter();
            ComposerKt.sourceInformationMarkerStart(composer, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(center, false);
            ComposerKt.sourceInformationMarkerStart(composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int hashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap2 = composer.getCurrentCompositionLocalMap();
            Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(composer, clipToBounds);
            Function0<ComposeUiNode> constructor2 = ComposeUiNode.Companion.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!(composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer.startReusableNode();
            if (composer.getInserting()) {
                composer.createNode(constructor2);
            } else {
                composer.useNode();
            }
            Composer m4041constructorimpl2 = Updater.m4041constructorimpl(composer);
            Updater.m4049setimpl(m4041constructorimpl2, maybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m4049setimpl(m4041constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.m4045initimpl(m4041constructorimpl2, Integer.valueOf(hashCode2), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.m4047reconcileimpl(m4041constructorimpl2, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.m4049setimpl(m4041constructorimpl2, materializeModifier2, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, -512117141, "C169@6160L36,166@6035L3656:SettingsScreen.kt#1gr92h");
            Modifier verticalScroll$default = ScrollKt.verticalScroll$default(ScrollBarKt.fadingTopBottomEdgesSimplified$default(ScrollBarKt.m9082verticalColumnScrollbarosbwsH8(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, null), rememberScrollState, 0.0f, false, 0.0f, 0.0f, composer, 6, 30), rememberScrollState, 0.0f, 0.0f, 6, null), rememberScrollState, false, null, false, 14, null);
            ComposerKt.sourceInformationMarkerStart(composer, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            MeasurePolicy columnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.m688spacedBy0680j_4(Dp.m7555constructorimpl(-Dp.m7555constructorimpl(4))), Alignment.Companion.getStart(), composer, 6);
            ComposerKt.sourceInformationMarkerStart(composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int hashCode3 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap3 = composer.getCurrentCompositionLocalMap();
            Modifier materializeModifier3 = ComposedModifierKt.materializeModifier(composer, verticalScroll$default);
            Function0<ComposeUiNode> constructor3 = ComposeUiNode.Companion.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!(composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer.startReusableNode();
            if (composer.getInserting()) {
                composer.createNode(constructor3);
            } else {
                composer.useNode();
            }
            Composer m4041constructorimpl3 = Updater.m4041constructorimpl(composer);
            Updater.m4049setimpl(m4041constructorimpl3, columnMeasurePolicy2, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m4049setimpl(m4041constructorimpl3, currentCompositionLocalMap3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.m4045initimpl(m4041constructorimpl3, Integer.valueOf(hashCode3), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.m4047reconcileimpl(m4041constructorimpl3, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.m4049setimpl(m4041constructorimpl3, materializeModifier3, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScopeInstance columnScopeInstance2 = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, -1178197320, "C175@6452L40,176@6517L802,193@7344L2259,237@9628L41:SettingsScreen.kt#1gr92h");
            SpacerKt.Spacer(SizeKt.m850height3ABfNKs(Modifier.Companion, Dp.m7555constructorimpl(f2)), composer, 6);
            Modifier width = IntrinsicKt.width(Modifier.Companion, IntrinsicSize.Max);
            float f3 = 12;
            ComposerKt.sourceInformationMarkerStart(composer, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            MeasurePolicy columnMeasurePolicy3 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.m688spacedBy0680j_4(Dp.m7555constructorimpl(-Dp.m7555constructorimpl(f3))), Alignment.Companion.getStart(), composer, 6);
            ComposerKt.sourceInformationMarkerStart(composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int hashCode4 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap4 = composer.getCurrentCompositionLocalMap();
            Modifier materializeModifier4 = ComposedModifierKt.materializeModifier(composer, width);
            Function0<ComposeUiNode> constructor4 = ComposeUiNode.Companion.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!(composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer.startReusableNode();
            if (composer.getInserting()) {
                composer.createNode(constructor4);
            } else {
                composer.useNode();
            }
            Composer m4041constructorimpl4 = Updater.m4041constructorimpl(composer);
            Updater.m4049setimpl(m4041constructorimpl4, columnMeasurePolicy3, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m4049setimpl(m4041constructorimpl4, currentCompositionLocalMap4, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.m4045initimpl(m4041constructorimpl4, Integer.valueOf(hashCode4), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.m4047reconcileimpl(m4041constructorimpl4, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.m4049setimpl(m4041constructorimpl4, materializeModifier4, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScopeInstance columnScopeInstance3 = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, 956404064, "C180@6750L163,184@6942L157,188@7128L165:SettingsScreen.kt#1gr92h");
            SettingsRowsKt.ChatFontSize(function1, settingsUiState.getSettingState().getChatFontSize(), null, composer, 0, 4);
            SettingsRowsKt.FontsCount(function12, settingsUiState.getSettingState().getPageSize(), null, composer, 0, 4);
            SettingsRowsKt.StreamerSwitch(function0, settingsUiState.getSettingState().getStreamerMode(), null, composer, 0, 4);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.m688spacedBy0680j_4(Dp.m7555constructorimpl(f3)), Alignment.Companion.getTop(), composer, 6);
            ComposerKt.sourceInformationMarkerStart(composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int hashCode5 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap5 = composer.getCurrentCompositionLocalMap();
            Modifier materializeModifier5 = ComposedModifierKt.materializeModifier(composer, Modifier.Companion);
            Function0<ComposeUiNode> constructor5 = ComposeUiNode.Companion.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!(composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer.startReusableNode();
            if (composer.getInserting()) {
                composer.createNode(constructor5);
            } else {
                composer.useNode();
            }
            Composer m4041constructorimpl5 = Updater.m4041constructorimpl(composer);
            Updater.m4049setimpl(m4041constructorimpl5, rowMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m4049setimpl(m4041constructorimpl5, currentCompositionLocalMap5, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.m4045initimpl(m4041constructorimpl5, Integer.valueOf(hashCode5), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.m4047reconcileimpl(m4041constructorimpl5, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.m4049setimpl(m4041constructorimpl5, materializeModifier5, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, 867726177, "C196@7485L1033,216@8547L1030:SettingsScreen.kt#1gr92h");
            ComposerKt.sourceInformationMarkerStart(composer, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            MeasurePolicy columnMeasurePolicy4 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.m688spacedBy0680j_4(Dp.m7555constructorimpl(f2)), Alignment.Companion.getStart(), composer, 6);
            ComposerKt.sourceInformationMarkerStart(composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int hashCode6 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap6 = composer.getCurrentCompositionLocalMap();
            Modifier materializeModifier6 = ComposedModifierKt.materializeModifier(composer, Modifier.Companion);
            Function0<ComposeUiNode> constructor6 = ComposeUiNode.Companion.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!(composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer.startReusableNode();
            if (composer.getInserting()) {
                composer.createNode(constructor6);
            } else {
                composer.useNode();
            }
            Composer m4041constructorimpl6 = Updater.m4041constructorimpl(composer);
            Updater.m4049setimpl(m4041constructorimpl6, columnMeasurePolicy4, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m4049setimpl(m4041constructorimpl6, currentCompositionLocalMap6, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.m4045initimpl(m4041constructorimpl6, Integer.valueOf(hashCode6), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.m4047reconcileimpl(m4041constructorimpl6, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.m4049setimpl(m4041constructorimpl6, materializeModifier6, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScopeInstance columnScopeInstance4 = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, -1719022970, "C200@7691L237,205@7961L248,210@8242L246:SettingsScreen.kt#1gr92h");
            SwitchButtonKt.SwitchButton("ПОЛНЫЙ ЭКРАН", function02, settingsUiState.getSettingState().getFullScreen(), composer, 6);
            SwitchButtonKt.SwitchButton("ДАТА И ВРЕМЯ В ЧАТЕ", function03, settingsUiState.getSettingState().getShowChatTime(), composer, 6);
            SwitchButtonKt.SwitchButton("ЗВУКИ ОКРУЖЕНИЯ", function04, settingsUiState.getSettingState().getAmbientSounds(), composer, 6);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            MeasurePolicy columnMeasurePolicy5 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.m688spacedBy0680j_4(Dp.m7555constructorimpl(f2)), Alignment.Companion.getStart(), composer, 6);
            ComposerKt.sourceInformationMarkerStart(composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int hashCode7 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap7 = composer.getCurrentCompositionLocalMap();
            Modifier materializeModifier7 = ComposedModifierKt.materializeModifier(composer, Modifier.Companion);
            Function0<ComposeUiNode> constructor7 = ComposeUiNode.Companion.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!(composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer.startReusableNode();
            if (composer.getInserting()) {
                composer.createNode(constructor7);
            } else {
                composer.useNode();
            }
            Composer m4041constructorimpl7 = Updater.m4041constructorimpl(composer);
            Updater.m4049setimpl(m4041constructorimpl7, columnMeasurePolicy5, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m4049setimpl(m4041constructorimpl7, currentCompositionLocalMap7, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.m4045initimpl(m4041constructorimpl7, Integer.valueOf(hashCode7), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.m4047reconcileimpl(m4041constructorimpl7, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.m4049setimpl(m4041constructorimpl7, materializeModifier7, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScopeInstance columnScopeInstance5 = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, 1238728928, "C220@8753L241,225@9027L233,230@9293L254:SettingsScreen.kt#1gr92h");
            SwitchButtonKt.SwitchButton("УВЕДОМЛЕНИЯ", function05, settingsUiState.getSettingState().getNotifications(), composer, 6);
            SwitchButtonKt.SwitchButton("ОТОБРАЖАТЬ FPS", function06, settingsUiState.getSettingState().getShowFps(), composer, 6);
            SwitchButtonKt.SwitchButton("ОБНОВЛЕННАЯ ГРАФИКА", function07, settingsUiState.getSettingState().getUpdatedGraphics(), composer, 6);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            SpacerKt.Spacer(SizeKt.m850height3ABfNKs(Modifier.Companion, Dp.m7555constructorimpl(20)), composer, 6);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
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

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit SettingsScreen$lambda$1(Function0 function0, Function0 function02, Function0 function03, Function0 function04, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C243@9769L222:SettingsScreen.kt#1gr92h");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1676831810, i, -1, "com.miami.game.feature.settings.ui.compose.SettingsScreen.<anonymous> (SettingsScreen.kt:243)");
            }
            SettingsBottomBarKt.SettingsBottomBar(function0, function02, function03, function04, composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    public static final void BackgroundImage(final int i, Composer composer, final int i2) {
        int i3;
        Composer startRestartGroup = composer.startRestartGroup(-1060762892);
        ComposerKt.sourceInformation(startRestartGroup, "C(BackgroundImage)N(backGroundId)256@10140L56,254@10072L208:SettingsScreen.kt#1gr92h");
        if ((i2 & 6) == 0) {
            i3 = (startRestartGroup.changed(i) ? 4 : 2) | i2;
        } else {
            i3 = i2;
        }
        if (!startRestartGroup.shouldExecute((i3 & 3) != 2, i3 & 1)) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1060762892, i3, -1, "com.miami.game.feature.settings.ui.compose.BackgroundImage (SettingsScreen.kt:253)");
            }
            ImageKt.Image(PainterResources_androidKt.painterResource(i, startRestartGroup, i3 & 14), (String) null, SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, null), (Alignment) null, ContentScale.Companion.getCrop(), 0.0f, (ColorFilter) null, startRestartGroup, Painter.$stable | 25008, 104);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: com.miami.game.feature.settings.ui.compose.SettingsScreenKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return SettingsScreenKt.BackgroundImage$lambda$0(i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final SettingsUiState SettingsRoute$lambda$0(State<SettingsUiState> state) {
        return state.getValue();
    }
}
