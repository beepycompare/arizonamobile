package com.miami.game.feature.settings.ui.compose;

import android.net.Uri;
import androidx.activity.compose.ActivityResultRegistryKt;
import androidx.activity.compose.BackHandlerKt;
import androidx.activity.compose.ManagedActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
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
import androidx.compose.runtime.composer.linkbuffer.GroupFlagsKt;
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
import kotlin.text.StringsKt;
/* compiled from: SettingsScreen.kt */
@Metadata(d1 = {"\u0000<\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0010\u000e\n\u0002\b\t\u001ag\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\u0018\u0010\t\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u0005\u0012\u0004\u0012\u00020\u00010\nH\u0007¢\u0006\u0002\u0010\u000b\u001a\u0083\u0003\u0010\f\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00010\n2\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00010\n2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\u0012\u0010$\u001a\u000e\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020\u00010\n2\u0012\u0010&\u001a\u000e\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020\u00010\n2\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\u0012\u0010(\u001a\u000e\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020\u00010\nH\u0001¢\u0006\u0002\u0010)\u001a\u0015\u0010*\u001a\u00020\u00012\u0006\u0010+\u001a\u00020\u0013H\u0001¢\u0006\u0002\u0010,\"\u000e\u0010-\u001a\u00020%X\u0082T¢\u0006\u0002\n\u0000¨\u0006.²\u0006\n\u0010\r\u001a\u00020\u000eX\u008a\u0084\u0002"}, d2 = {"SettingsRoute", "", "component", "Lcom/miami/game/feature/settings/ui/SettingsComponent;", "onBackClick", "Lkotlin/Function0;", "onRepairGameSuccess", "onRepairGameError", "onNavigateDownload", "onRepairGameDialog", "Lkotlin/Function1;", "(Lcom/miami/game/feature/settings/ui/SettingsComponent;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "SettingsScreen", "uiState", "Lcom/miami/game/feature/settings/ui/model/SettingsUiState;", "onRepairGame", "onFontSize", "", "onPageSize", "", "onFullScreen", "onShowFPS", "onShowChatTime", "onAmbientSounds", "onBugsReport", "onShareLogs", "onLongShareLogs", "onPrivacyPolicy", "onTech", "onKeyboard", "onStreamer", "onNotification", "onDebugAutoConnectTestServer", "onDebugAutoRunTestScript", "onImportGameTestScript", "onUseBundledGameTestScript", "onSelectImportedGameTestScript", "", "onUpdateGameTestScreenshotPullPath", "onDebugScreenshotButton", "onUpdateGameTestScreenshotDeviceDir", "(Lcom/miami/game/feature/settings/ui/model/SettingsUiState;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;III)V", "BackgroundImage", "backGroundId", "(ILandroidx/compose/runtime/Composer;I)V", "DEFAULT_DEBUG_TEST_SCRIPT_NAME", "settings"}, k = 2, mv = {2, 3, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SettingsScreenKt {
    private static final String DEFAULT_DEBUG_TEST_SCRIPT_NAME = "default_game_test_script.json";

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit BackgroundImage$lambda$0(int i, int i2, Composer composer, int i3) {
        BackgroundImage(i, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit SettingsRoute$lambda$28(SettingsComponent settingsComponent, Function0 function0, Function0 function02, Function0 function03, Function0 function04, Function1 function1, int i, Composer composer, int i2) {
        SettingsRoute(settingsComponent, function0, function02, function03, function04, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit SettingsScreen$lambda$3(SettingsUiState settingsUiState, Function0 function0, Function0 function02, Function1 function1, Function1 function12, Function0 function03, Function0 function04, Function0 function05, Function0 function06, Function0 function07, Function0 function08, Function0 function09, Function0 function010, Function0 function011, Function0 function012, Function0 function013, Function0 function014, Function0 function015, Function0 function016, Function0 function017, Function0 function018, Function1 function13, Function1 function14, Function0 function019, Function1 function15, int i, int i2, int i3, Composer composer, int i4) {
        SettingsScreen(settingsUiState, function0, function02, function1, function12, function03, function04, function05, function06, function07, function08, function09, function010, function011, function012, function013, function014, function015, function016, function017, function018, function13, function14, function019, function15, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2), RecomposeScopeImplKt.updateChangedFlags(i3));
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:373:0x0609, code lost:
        if (r10 == androidx.compose.runtime.Composer.Companion.getEmpty()) goto L344;
     */
    /* JADX WARN: Code restructure failed: missing block: B:380:0x0672, code lost:
        if (r2 == androidx.compose.runtime.Composer.Companion.getEmpty()) goto L342;
     */
    /* JADX WARN: Code restructure failed: missing block: B:391:0x070d, code lost:
        if (r11.changedInstance(r3) != false) goto L338;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void SettingsRoute(final SettingsComponent component, final Function0<Unit> onBackClick, final Function0<Unit> onRepairGameSuccess, final Function0<Unit> onRepairGameError, final Function0<Unit> onNavigateDownload, final Function1<? super Function0<Unit>, Unit> onRepairGameDialog, Composer composer, final int i) {
        int i2;
        SettingsComponent settingsComponent;
        KFunction kFunction;
        Function0 function0;
        boolean z;
        SettingsScreenKt$SettingsRoute$25$1 rememberedValue;
        boolean z2;
        SettingsScreenKt$SettingsRoute$26$1 rememberedValue2;
        Intrinsics.checkNotNullParameter(component, "component");
        Intrinsics.checkNotNullParameter(onBackClick, "onBackClick");
        Intrinsics.checkNotNullParameter(onRepairGameSuccess, "onRepairGameSuccess");
        Intrinsics.checkNotNullParameter(onRepairGameError, "onRepairGameError");
        Intrinsics.checkNotNullParameter(onNavigateDownload, "onNavigateDownload");
        Intrinsics.checkNotNullParameter(onRepairGameDialog, "onRepairGameDialog");
        Composer startRestartGroup = composer.startRestartGroup(-681024813);
        ComposerKt.sourceInformation(startRestartGroup, "C(SettingsRoute)N(component,onBackClick,onRepairGameSuccess,onRepairGameError,onNavigateDownload,onRepairGameDialog)52@2459L33,54@2531L29,57@2687L101,55@2588L200,63@2850L227,63@2813L264,71@3117L34,75@3223L28,77@3309L25,78@3357L25,79@3407L23,80@3452L16,81@3495L21,82@3544L26,83@3595L23,84@3646L26,85@3696L22,86@3746L26,87@3791L17,88@3831L21,89@3875L21,90@3923L26,91@3990L39,92@4066L35,96@4261L37,97@4341L41,98@4429L45,99@4510L34,100@4592L46,93@4136L86,73@3157L1488:SettingsScreen.kt#1gr92h");
        if ((i & 6) == 0) {
            i2 = i | ((i & 8) == 0 ? startRestartGroup.changed(component) : startRestartGroup.changedInstance(component) ? 4 : 2);
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= startRestartGroup.changedInstance(onBackClick) ? 32 : 16;
        }
        if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
            i2 |= startRestartGroup.changedInstance(onRepairGameDialog) ? 131072 : 65536;
        }
        if (startRestartGroup.shouldExecute((65555 & i2) != 65554, i2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-681024813, i2, -1, "com.miami.game.feature.settings.ui.compose.SettingsRoute (SettingsScreen.kt:51)");
            }
            BackHandlerKt.BackHandler(false, onBackClick, startRestartGroup, i2 & 112, 1);
            int i3 = i2;
            State collectAsStateWithLifecycle = FlowExtKt.collectAsStateWithLifecycle(component.getUiState(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, startRestartGroup, 0, 7);
            ActivityResultContracts.OpenDocument openDocument = new ActivityResultContracts.OpenDocument();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1629801192, "CC(remember):SettingsScreen.kt#9igjgp");
            int i4 = i3 & 14;
            boolean z3 = i4 == 4 || ((i3 & 8) != 0 && startRestartGroup.changedInstance(component));
            Object rememberedValue3 = startRestartGroup.rememberedValue();
            if (z3 || rememberedValue3 == Composer.Companion.getEmpty()) {
                rememberedValue3 = new Function1() { // from class: com.miami.game.feature.settings.ui.compose.SettingsScreenKt$$ExternalSyntheticLambda5
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit SettingsRoute$lambda$1$0;
                        SettingsRoute$lambda$1$0 = SettingsScreenKt.SettingsRoute$lambda$1$0(SettingsComponent.this, (Uri) obj);
                        return SettingsRoute$lambda$1$0;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue3);
            }
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            final ManagedActivityResultLauncher rememberLauncherForActivityResult = ActivityResultRegistryKt.rememberLauncherForActivityResult(openDocument, (Function1) rememberedValue3, startRestartGroup, 0);
            SharedEventFlow<SettingsUiAction> uiAction = component.getUiAction();
            Object[] objArr = new Object[0];
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1629795850, "CC(remember):SettingsScreen.kt#9igjgp");
            boolean z4 = ((i3 & 458752) == 131072) | (i4 == 4 || ((i3 & 8) != 0 && startRestartGroup.changedInstance(component)));
            SettingsScreenKt$SettingsRoute$1$1 rememberedValue4 = startRestartGroup.rememberedValue();
            if (z4 || rememberedValue4 == Composer.Companion.getEmpty()) {
                rememberedValue4 = new SettingsScreenKt$SettingsRoute$1$1(onRepairGameDialog, component, null);
                startRestartGroup.updateRememberedValue(rememberedValue4);
            }
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            FlowExtensionsKt.collectInLaunchedEffectWithLifecycle(uiAction, objArr, null, null, (Function3) rememberedValue4, startRestartGroup, 0, 6);
            ObserveExternalNavigationActionsKt.observeExternalNavigationActions(component.getExternalNavigationAction(), startRestartGroup, 0);
            SettingsUiState SettingsRoute$lambda$0 = SettingsRoute$lambda$0(collectAsStateWithLifecycle);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1629784113, "CC(remember):SettingsScreen.kt#9igjgp");
            boolean z5 = i4 == 4 || ((i3 & 8) != 0 && startRestartGroup.changedInstance(component));
            SettingsScreenKt$SettingsRoute$2$1 rememberedValue5 = startRestartGroup.rememberedValue();
            if (z5 || rememberedValue5 == Composer.Companion.getEmpty()) {
                rememberedValue5 = new SettingsScreenKt$SettingsRoute$2$1(component);
                startRestartGroup.updateRememberedValue(rememberedValue5);
            }
            KFunction kFunction2 = (KFunction) rememberedValue5;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1629781364, "CC(remember):SettingsScreen.kt#9igjgp");
            boolean z6 = i4 == 4 || ((i3 & 8) != 0 && startRestartGroup.changedInstance(component));
            SettingsScreenKt$SettingsRoute$3$1 rememberedValue6 = startRestartGroup.rememberedValue();
            if (z6 || rememberedValue6 == Composer.Companion.getEmpty()) {
                rememberedValue6 = new SettingsScreenKt$SettingsRoute$3$1(component);
                startRestartGroup.updateRememberedValue(rememberedValue6);
            }
            KFunction kFunction3 = (KFunction) rememberedValue6;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1629779828, "CC(remember):SettingsScreen.kt#9igjgp");
            boolean z7 = i4 == 4 || ((i3 & 8) != 0 && startRestartGroup.changedInstance(component));
            SettingsScreenKt$SettingsRoute$4$1 rememberedValue7 = startRestartGroup.rememberedValue();
            if (z7 || rememberedValue7 == Composer.Companion.getEmpty()) {
                rememberedValue7 = new SettingsScreenKt$SettingsRoute$4$1(component);
                startRestartGroup.updateRememberedValue(rememberedValue7);
            }
            KFunction kFunction4 = (KFunction) rememberedValue7;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1629778230, "CC(remember):SettingsScreen.kt#9igjgp");
            boolean z8 = i4 == 4 || ((i3 & 8) != 0 && startRestartGroup.changedInstance(component));
            SettingsScreenKt$SettingsRoute$5$1 rememberedValue8 = startRestartGroup.rememberedValue();
            if (z8 || rememberedValue8 == Composer.Companion.getEmpty()) {
                rememberedValue8 = new SettingsScreenKt$SettingsRoute$5$1(component);
                startRestartGroup.updateRememberedValue(rememberedValue8);
            }
            KFunction kFunction5 = (KFunction) rememberedValue8;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1629776797, "CC(remember):SettingsScreen.kt#9igjgp");
            boolean z9 = i4 == 4 || ((i3 & 8) != 0 && startRestartGroup.changedInstance(component));
            SettingsScreenKt$SettingsRoute$6$1 rememberedValue9 = startRestartGroup.rememberedValue();
            if (z9 || rememberedValue9 == Composer.Companion.getEmpty()) {
                rememberedValue9 = new SettingsScreenKt$SettingsRoute$6$1(component);
                startRestartGroup.updateRememberedValue(rememberedValue9);
            }
            KFunction kFunction6 = (KFunction) rememberedValue9;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1629775416, "CC(remember):SettingsScreen.kt#9igjgp");
            boolean z10 = i4 == 4 || ((i3 & 8) != 0 && startRestartGroup.changedInstance(component));
            SettingsScreenKt$SettingsRoute$7$1 rememberedValue10 = startRestartGroup.rememberedValue();
            if (z10 || rememberedValue10 == Composer.Companion.getEmpty()) {
                rememberedValue10 = new SettingsScreenKt$SettingsRoute$7$1(component);
                startRestartGroup.updateRememberedValue(rememberedValue10);
            }
            KFunction kFunction7 = (KFunction) rememberedValue10;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1629773843, "CC(remember):SettingsScreen.kt#9igjgp");
            boolean z11 = i4 == 4 || ((i3 & 8) != 0 && startRestartGroup.changedInstance(component));
            SettingsScreenKt$SettingsRoute$8$1 rememberedValue11 = startRestartGroup.rememberedValue();
            if (z11 || rememberedValue11 == Composer.Companion.getEmpty()) {
                rememberedValue11 = new SettingsScreenKt$SettingsRoute$8$1(component);
                startRestartGroup.updateRememberedValue(rememberedValue11);
            }
            KFunction kFunction8 = (KFunction) rememberedValue11;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1629772214, "CC(remember):SettingsScreen.kt#9igjgp");
            boolean z12 = i4 == 4 || ((i3 & 8) != 0 && startRestartGroup.changedInstance(component));
            SettingsScreenKt$SettingsRoute$9$1 rememberedValue12 = startRestartGroup.rememberedValue();
            if (z12 || rememberedValue12 == Composer.Companion.getEmpty()) {
                rememberedValue12 = new SettingsScreenKt$SettingsRoute$9$1(component);
                startRestartGroup.updateRememberedValue(rememberedValue12);
            }
            KFunction kFunction9 = (KFunction) rememberedValue12;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1629770579, "CC(remember):SettingsScreen.kt#9igjgp");
            boolean z13 = i4 == 4 || ((i3 & 8) != 0 && startRestartGroup.changedInstance(component));
            SettingsScreenKt$SettingsRoute$10$1 rememberedValue13 = startRestartGroup.rememberedValue();
            if (z13 || rememberedValue13 == Composer.Companion.getEmpty()) {
                rememberedValue13 = new SettingsScreenKt$SettingsRoute$10$1(component);
                startRestartGroup.updateRememberedValue(rememberedValue13);
            }
            KFunction kFunction10 = (KFunction) rememberedValue13;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1629768983, "CC(remember):SettingsScreen.kt#9igjgp");
            boolean z14 = i4 == 4 || ((i3 & 8) != 0 && startRestartGroup.changedInstance(component));
            SettingsScreenKt$SettingsRoute$11$1 rememberedValue14 = startRestartGroup.rememberedValue();
            if (z14 || rememberedValue14 == Composer.Companion.getEmpty()) {
                rememberedValue14 = new SettingsScreenKt$SettingsRoute$11$1(component);
                startRestartGroup.updateRememberedValue(rememberedValue14);
            }
            KFunction kFunction11 = (KFunction) rememberedValue14;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1629767379, "CC(remember):SettingsScreen.kt#9igjgp");
            boolean z15 = i4 == 4 || ((i3 & 8) != 0 && startRestartGroup.changedInstance(component));
            SettingsScreenKt$SettingsRoute$12$1 rememberedValue15 = startRestartGroup.rememberedValue();
            if (z15 || rememberedValue15 == Composer.Companion.getEmpty()) {
                rememberedValue15 = new SettingsScreenKt$SettingsRoute$12$1(component);
                startRestartGroup.updateRememberedValue(rememberedValue15);
            }
            KFunction kFunction12 = (KFunction) rememberedValue15;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1629765948, "CC(remember):SettingsScreen.kt#9igjgp");
            boolean z16 = i4 == 4 || ((i3 & 8) != 0 && startRestartGroup.changedInstance(component));
            SettingsScreenKt$SettingsRoute$13$1 rememberedValue16 = startRestartGroup.rememberedValue();
            if (z16 || rememberedValue16 == Composer.Companion.getEmpty()) {
                rememberedValue16 = new SettingsScreenKt$SettingsRoute$13$1(component);
                startRestartGroup.updateRememberedValue(rememberedValue16);
            }
            KFunction kFunction13 = (KFunction) rememberedValue16;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1629764664, "CC(remember):SettingsScreen.kt#9igjgp");
            boolean z17 = i4 == 4 || ((i3 & 8) != 0 && startRestartGroup.changedInstance(component));
            SettingsScreenKt$SettingsRoute$14$1 rememberedValue17 = startRestartGroup.rememberedValue();
            if (z17 || rememberedValue17 == Composer.Companion.getEmpty()) {
                rememberedValue17 = new SettingsScreenKt$SettingsRoute$14$1(component);
                startRestartGroup.updateRememberedValue(rememberedValue17);
            }
            KFunction kFunction14 = (KFunction) rememberedValue17;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1629763256, "CC(remember):SettingsScreen.kt#9igjgp");
            boolean z18 = i4 == 4 || ((i3 & 8) != 0 && startRestartGroup.changedInstance(component));
            SettingsScreenKt$SettingsRoute$15$1 rememberedValue18 = startRestartGroup.rememberedValue();
            if (z18 || rememberedValue18 == Composer.Companion.getEmpty()) {
                rememberedValue18 = new SettingsScreenKt$SettingsRoute$15$1(component);
                startRestartGroup.updateRememberedValue(rememberedValue18);
            }
            KFunction kFunction15 = (KFunction) rememberedValue18;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1629761715, "CC(remember):SettingsScreen.kt#9igjgp");
            boolean z19 = i4 == 4 || ((i3 & 8) != 0 && startRestartGroup.changedInstance(component));
            SettingsScreenKt$SettingsRoute$16$1 rememberedValue19 = startRestartGroup.rememberedValue();
            if (z19 || rememberedValue19 == Composer.Companion.getEmpty()) {
                rememberedValue19 = new SettingsScreenKt$SettingsRoute$16$1(component);
                startRestartGroup.updateRememberedValue(rememberedValue19);
            }
            KFunction kFunction16 = (KFunction) rememberedValue19;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1629759558, "CC(remember):SettingsScreen.kt#9igjgp");
            boolean z20 = i4 == 4 || ((i3 & 8) != 0 && startRestartGroup.changedInstance(component));
            SettingsScreenKt$SettingsRoute$17$1 rememberedValue20 = startRestartGroup.rememberedValue();
            if (z20 || rememberedValue20 == Composer.Companion.getEmpty()) {
                rememberedValue20 = new SettingsScreenKt$SettingsRoute$17$1(component);
                startRestartGroup.updateRememberedValue(rememberedValue20);
            }
            KFunction kFunction17 = (KFunction) rememberedValue20;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1629757130, "CC(remember):SettingsScreen.kt#9igjgp");
            boolean z21 = i4 == 4 || ((i3 & 8) != 0 && startRestartGroup.changedInstance(component));
            SettingsScreenKt$SettingsRoute$18$1 rememberedValue21 = startRestartGroup.rememberedValue();
            if (z21 || rememberedValue21 == Composer.Companion.getEmpty()) {
                rememberedValue21 = new SettingsScreenKt$SettingsRoute$18$1(component);
                startRestartGroup.updateRememberedValue(rememberedValue21);
            }
            KFunction kFunction18 = (KFunction) rememberedValue21;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1629750888, "CC(remember):SettingsScreen.kt#9igjgp");
            boolean z22 = i4 == 4 || ((i3 & 8) != 0 && startRestartGroup.changedInstance(component));
            SettingsScreenKt$SettingsRoute$19$1 rememberedValue22 = startRestartGroup.rememberedValue();
            if (z22 || rememberedValue22 == Composer.Companion.getEmpty()) {
                rememberedValue22 = new SettingsScreenKt$SettingsRoute$19$1(component);
                startRestartGroup.updateRememberedValue(rememberedValue22);
            }
            KFunction kFunction19 = (KFunction) rememberedValue22;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1629748324, "CC(remember):SettingsScreen.kt#9igjgp");
            boolean z23 = i4 == 4 || ((i3 & 8) != 0 && startRestartGroup.changedInstance(component));
            SettingsScreenKt$SettingsRoute$20$1 rememberedValue23 = startRestartGroup.rememberedValue();
            if (z23 || rememberedValue23 == Composer.Companion.getEmpty()) {
                rememberedValue23 = new SettingsScreenKt$SettingsRoute$20$1(component);
                startRestartGroup.updateRememberedValue(rememberedValue23);
            }
            KFunction kFunction20 = (KFunction) rememberedValue23;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1629745504, "CC(remember):SettingsScreen.kt#9igjgp");
            boolean z24 = i4 == 4 || ((i3 & 8) != 0 && startRestartGroup.changedInstance(component));
            SettingsScreenKt$SettingsRoute$21$1 rememberedValue24 = startRestartGroup.rememberedValue();
            if (z24 || rememberedValue24 == Composer.Companion.getEmpty()) {
                rememberedValue24 = new SettingsScreenKt$SettingsRoute$21$1(component);
                startRestartGroup.updateRememberedValue(rememberedValue24);
            }
            KFunction kFunction21 = (KFunction) rememberedValue24;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1629742923, "CC(remember):SettingsScreen.kt#9igjgp");
            boolean z25 = i4 == 4 || ((i3 & 8) != 0 && startRestartGroup.changedInstance(component));
            SettingsScreenKt$SettingsRoute$22$1 rememberedValue25 = startRestartGroup.rememberedValue();
            if (z25 || rememberedValue25 == Composer.Companion.getEmpty()) {
                rememberedValue25 = new SettingsScreenKt$SettingsRoute$22$1(component);
                startRestartGroup.updateRememberedValue(rememberedValue25);
            }
            KFunction kFunction22 = (KFunction) rememberedValue25;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1629740287, "CC(remember):SettingsScreen.kt#9igjgp");
            boolean z26 = i4 == 4 || ((i3 & 8) != 0 && startRestartGroup.changedInstance(component));
            SettingsScreenKt$SettingsRoute$23$1 rememberedValue26 = startRestartGroup.rememberedValue();
            if (z26) {
                kFunction = kFunction22;
            } else {
                kFunction = kFunction22;
            }
            rememberedValue26 = new SettingsScreenKt$SettingsRoute$23$1(component);
            startRestartGroup.updateRememberedValue(rememberedValue26);
            KFunction kFunction23 = (KFunction) rememberedValue26;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            Function0 function02 = (Function0) kFunction2;
            Function1 function1 = (Function1) kFunction3;
            Function1 function12 = (Function1) kFunction4;
            Function0 function03 = (Function0) kFunction5;
            Function0 function04 = (Function0) kFunction6;
            Function0 function05 = (Function0) kFunction7;
            Function0 function06 = (Function0) kFunction8;
            Function0 function07 = (Function0) kFunction9;
            Function0 function08 = (Function0) kFunction11;
            Function0 function09 = (Function0) kFunction12;
            Function0 function010 = (Function0) kFunction10;
            Function0 function011 = (Function0) kFunction13;
            Function0 function012 = (Function0) kFunction14;
            Function0 function013 = (Function0) kFunction15;
            Function0 function014 = (Function0) kFunction16;
            Function0 function015 = (Function0) kFunction17;
            Function0 function016 = (Function0) kFunction18;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1629754839, "CC(remember):SettingsScreen.kt#9igjgp");
            boolean changedInstance = startRestartGroup.changedInstance(rememberLauncherForActivityResult);
            Object rememberedValue27 = startRestartGroup.rememberedValue();
            if (changedInstance) {
                function0 = function05;
            } else {
                function0 = function05;
            }
            rememberedValue27 = new Function0() { // from class: com.miami.game.feature.settings.ui.compose.SettingsScreenKt$$ExternalSyntheticLambda6
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit SettingsRoute$lambda$25$0;
                    SettingsRoute$lambda$25$0 = SettingsScreenKt.SettingsRoute$lambda$25$0(ManagedActivityResultLauncher.this);
                    return SettingsRoute$lambda$25$0;
                }
            };
            startRestartGroup.updateRememberedValue(rememberedValue27);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            SettingsScreen(SettingsRoute$lambda$0, function02, onBackClick, function1, function12, function03, function04, function0, function06, function07, function08, function09, function010, function011, function012, function013, function014, function015, function016, (Function0) rememberedValue27, (Function0) kFunction19, (Function1) kFunction20, (Function1) kFunction21, (Function0) kFunction, (Function1) kFunction23, startRestartGroup, (i3 << 3) & 896, 0, 0);
            startRestartGroup = startRestartGroup;
            if (SettingsRoute$lambda$0(collectAsStateWithLifecycle).isConnectionDialogVisible()) {
                startRestartGroup.startReplaceGroup(1017759314);
                ComposerKt.sourceInformation(startRestartGroup, "106@4792L20,107@4838L24,104@4699L173");
                ConnectionData connectionData = SettingsRoute$lambda$0(collectAsStateWithLifecycle).getConnectionData();
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1629733913, "CC(remember):SettingsScreen.kt#9igjgp");
                if (i4 != 4) {
                    if ((i3 & 8) != 0) {
                        settingsComponent = component;
                    } else {
                        settingsComponent = component;
                    }
                    z = false;
                    rememberedValue = startRestartGroup.rememberedValue();
                    if (!z || rememberedValue == Composer.Companion.getEmpty()) {
                        rememberedValue = new SettingsScreenKt$SettingsRoute$25$1(settingsComponent);
                        startRestartGroup.updateRememberedValue(rememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                    Function0 function017 = (Function0) ((KFunction) rememberedValue);
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1629732437, "CC(remember):SettingsScreen.kt#9igjgp");
                    z2 = i4 != 4 || ((i3 & 8) != 0 && startRestartGroup.changedInstance(settingsComponent));
                    rememberedValue2 = startRestartGroup.rememberedValue();
                    if (!z2 || rememberedValue2 == Composer.Companion.getEmpty()) {
                        rememberedValue2 = new SettingsScreenKt$SettingsRoute$26$1(settingsComponent);
                        startRestartGroup.updateRememberedValue(rememberedValue2);
                    }
                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                    ConnectionDialogKt.ConnectionDialog(connectionData, function017, (Function1) ((KFunction) rememberedValue2), startRestartGroup, ConnectionData.$stable);
                    startRestartGroup.endReplaceGroup();
                } else {
                    settingsComponent = component;
                }
                z = true;
                rememberedValue = startRestartGroup.rememberedValue();
                if (!z) {
                }
                rememberedValue = new SettingsScreenKt$SettingsRoute$25$1(settingsComponent);
                startRestartGroup.updateRememberedValue(rememberedValue);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                Function0 function0172 = (Function0) ((KFunction) rememberedValue);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1629732437, "CC(remember):SettingsScreen.kt#9igjgp");
                if (i4 != 4) {
                }
                rememberedValue2 = startRestartGroup.rememberedValue();
                if (!z2) {
                }
                rememberedValue2 = new SettingsScreenKt$SettingsRoute$26$1(settingsComponent);
                startRestartGroup.updateRememberedValue(rememberedValue2);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ConnectionDialogKt.ConnectionDialog(connectionData, function0172, (Function1) ((KFunction) rememberedValue2), startRestartGroup, ConnectionData.$stable);
                startRestartGroup.endReplaceGroup();
            } else {
                settingsComponent = component;
                startRestartGroup.startReplaceGroup(1017940943);
                startRestartGroup.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            settingsComponent = component;
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            final SettingsComponent settingsComponent2 = settingsComponent;
            endRestartGroup.updateScope(new Function2() { // from class: com.miami.game.feature.settings.ui.compose.SettingsScreenKt$$ExternalSyntheticLambda7
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return SettingsScreenKt.SettingsRoute$lambda$28(SettingsComponent.this, onBackClick, onRepairGameSuccess, onRepairGameError, onNavigateDownload, onRepairGameDialog, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SettingsRoute$lambda$1$0(SettingsComponent settingsComponent, Uri uri) {
        if (uri != null) {
            settingsComponent.onImportGameTestScript(uri);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SettingsRoute$lambda$25$0(ManagedActivityResultLauncher managedActivityResultLauncher) {
        managedActivityResultLauncher.launch(new String[]{"application/json", "text/*"});
        return Unit.INSTANCE;
    }

    public static final void SettingsScreen(final SettingsUiState uiState, final Function0<Unit> onRepairGame, final Function0<Unit> onBackClick, final Function1<? super Float, Unit> onFontSize, final Function1<? super Integer, Unit> onPageSize, final Function0<Unit> onFullScreen, final Function0<Unit> onShowFPS, final Function0<Unit> onShowChatTime, final Function0<Unit> onAmbientSounds, final Function0<Unit> onBugsReport, final Function0<Unit> onShareLogs, final Function0<Unit> onLongShareLogs, final Function0<Unit> onPrivacyPolicy, final Function0<Unit> onTech, final Function0<Unit> onKeyboard, final Function0<Unit> onStreamer, final Function0<Unit> onNotification, final Function0<Unit> onDebugAutoConnectTestServer, final Function0<Unit> onDebugAutoRunTestScript, final Function0<Unit> onImportGameTestScript, final Function0<Unit> onUseBundledGameTestScript, final Function1<? super String, Unit> onSelectImportedGameTestScript, final Function1<? super String, Unit> onUpdateGameTestScreenshotPullPath, final Function0<Unit> onDebugScreenshotButton, final Function1<? super String, Unit> onUpdateGameTestScreenshotDeviceDir, Composer composer, final int i, final int i2, final int i3) {
        int i4;
        int i5;
        int i6;
        Composer composer2;
        Intrinsics.checkNotNullParameter(uiState, "uiState");
        Intrinsics.checkNotNullParameter(onRepairGame, "onRepairGame");
        Intrinsics.checkNotNullParameter(onBackClick, "onBackClick");
        Intrinsics.checkNotNullParameter(onFontSize, "onFontSize");
        Intrinsics.checkNotNullParameter(onPageSize, "onPageSize");
        Intrinsics.checkNotNullParameter(onFullScreen, "onFullScreen");
        Intrinsics.checkNotNullParameter(onShowFPS, "onShowFPS");
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
        Intrinsics.checkNotNullParameter(onDebugAutoConnectTestServer, "onDebugAutoConnectTestServer");
        Intrinsics.checkNotNullParameter(onDebugAutoRunTestScript, "onDebugAutoRunTestScript");
        Intrinsics.checkNotNullParameter(onImportGameTestScript, "onImportGameTestScript");
        Intrinsics.checkNotNullParameter(onUseBundledGameTestScript, "onUseBundledGameTestScript");
        Intrinsics.checkNotNullParameter(onSelectImportedGameTestScript, "onSelectImportedGameTestScript");
        Intrinsics.checkNotNullParameter(onUpdateGameTestScreenshotPullPath, "onUpdateGameTestScreenshotPullPath");
        Intrinsics.checkNotNullParameter(onDebugScreenshotButton, "onDebugScreenshotButton");
        Intrinsics.checkNotNullParameter(onUpdateGameTestScreenshotDeviceDir, "onUpdateGameTestScreenshotDeviceDir");
        Composer startRestartGroup = composer.startRestartGroup(-904295930);
        ComposerKt.sourceInformation(startRestartGroup, "C(SettingsScreen)N(uiState,onRepairGame,onBackClick,onFontSize,onPageSize,onFullScreen,onShowFPS,onShowChatTime,onAmbientSounds,onBugsReport,onShareLogs,onLongShareLogs,onPrivacyPolicy,onTech,onKeyboard,onStreamer,onNotification,onDebugAutoConnectTestServer,onDebugAutoRunTestScript,onImportGameTestScript,onUseBundledGameTestScript,onSelectImportedGameTestScript,onUpdateGameTestScreenshotPullPath,onDebugScreenshotButton,onUpdateGameTestScreenshotDeviceDir)150@6058L282,300@13535L246,160@6360L7153,144@5891L7891:SettingsScreen.kt#1gr92h");
        if ((i & 6) == 0) {
            i4 = i | (startRestartGroup.changed(uiState) ? 4 : 2);
        } else {
            i4 = i;
        }
        if ((i & 48) == 0) {
            i4 |= startRestartGroup.changedInstance(onRepairGame) ? 32 : 16;
        }
        if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i4 |= startRestartGroup.changedInstance(onBackClick) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i4 |= startRestartGroup.changedInstance(onFontSize) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i4 |= startRestartGroup.changedInstance(onPageSize) ? 16384 : 8192;
        }
        if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
            i4 |= startRestartGroup.changedInstance(onFullScreen) ? 131072 : 65536;
        }
        if ((i & 1572864) == 0) {
            i4 |= startRestartGroup.changedInstance(onShowFPS) ? 1048576 : 524288;
        }
        if ((i & 12582912) == 0) {
            i4 |= startRestartGroup.changedInstance(onShowChatTime) ? 8388608 : 4194304;
        }
        if ((i & 100663296) == 0) {
            i4 |= startRestartGroup.changedInstance(onAmbientSounds) ? 67108864 : GroupFlagsKt.HasAuxSlotFlag;
        }
        if ((i & 805306368) == 0) {
            i4 |= startRestartGroup.changedInstance(onBugsReport) ? 536870912 : 268435456;
        }
        int i7 = i4;
        if ((i2 & 6) == 0) {
            i5 = i2 | (startRestartGroup.changedInstance(onShareLogs) ? 4 : 2);
        } else {
            i5 = i2;
        }
        if ((i2 & 48) == 0) {
            i5 |= startRestartGroup.changedInstance(onLongShareLogs) ? 32 : 16;
        }
        if ((i2 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i5 |= startRestartGroup.changedInstance(onPrivacyPolicy) ? 256 : 128;
        }
        if ((i2 & 3072) == 0) {
            i5 |= startRestartGroup.changedInstance(onTech) ? 2048 : 1024;
        }
        if ((i2 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
            i5 |= startRestartGroup.changedInstance(onStreamer) ? 131072 : 65536;
        }
        if ((i2 & 1572864) == 0) {
            i5 |= startRestartGroup.changedInstance(onNotification) ? 1048576 : 524288;
        }
        if ((i2 & 12582912) == 0) {
            i5 |= startRestartGroup.changedInstance(onDebugAutoConnectTestServer) ? 8388608 : 4194304;
        }
        if ((i2 & 100663296) == 0) {
            i5 |= startRestartGroup.changedInstance(onDebugAutoRunTestScript) ? 67108864 : GroupFlagsKt.HasAuxSlotFlag;
        }
        if ((i2 & 805306368) == 0) {
            i5 |= startRestartGroup.changedInstance(onImportGameTestScript) ? 536870912 : 268435456;
        }
        int i8 = i5;
        if ((i3 & 6) == 0) {
            i6 = i3 | (startRestartGroup.changedInstance(onUseBundledGameTestScript) ? 4 : 2);
        } else {
            i6 = i3;
        }
        if ((i3 & 48) == 0) {
            i6 |= startRestartGroup.changedInstance(onSelectImportedGameTestScript) ? 32 : 16;
        }
        if ((i3 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i6 |= startRestartGroup.changedInstance(onUpdateGameTestScreenshotPullPath) ? 256 : 128;
        }
        if ((i3 & 3072) == 0) {
            i6 |= startRestartGroup.changedInstance(onDebugScreenshotButton) ? 2048 : 1024;
        }
        if ((i3 & 24576) == 0) {
            i6 |= startRestartGroup.changedInstance(onUpdateGameTestScreenshotDeviceDir) ? 16384 : 8192;
        }
        if (!startRestartGroup.shouldExecute(((i7 & 306783379) == 306783378 && (306775187 & i8) == 306775186 && (i6 & 9363) == 9362) ? false : true, i7 & 1)) {
            composer2 = startRestartGroup;
            composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-904295930, i7, i8, "com.miami.game.feature.settings.ui.compose.SettingsScreen (SettingsScreen.kt:143)");
            }
            ScaffoldKt.m2850ScaffoldTvnljyQ(SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, null), ComposableLambdaKt.rememberComposableLambda(-845123382, true, new Function2() { // from class: com.miami.game.feature.settings.ui.compose.SettingsScreenKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return SettingsScreenKt.SettingsScreen$lambda$0(SettingsUiState.this, onRepairGame, onBackClick, onBugsReport, onTech, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, startRestartGroup, 54), ComposableLambdaKt.rememberComposableLambda(-623211701, true, new Function2() { // from class: com.miami.game.feature.settings.ui.compose.SettingsScreenKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return SettingsScreenKt.SettingsScreen$lambda$1(Function0.this, onShareLogs, onPrivacyPolicy, onLongShareLogs, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, startRestartGroup, 54), null, null, 0, Color.Companion.m5383getTransparent0d7_KjU(), 0L, null, ComposableLambdaKt.rememberComposableLambda(-1514866411, true, new Function3() { // from class: com.miami.game.feature.settings.ui.compose.SettingsScreenKt$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return SettingsScreenKt.SettingsScreen$lambda$2(SettingsUiState.this, onImportGameTestScript, onUseBundledGameTestScript, onSelectImportedGameTestScript, onUpdateGameTestScreenshotPullPath, onDebugScreenshotButton, onUpdateGameTestScreenshotDeviceDir, onFontSize, onPageSize, onStreamer, onFullScreen, onShowChatTime, onAmbientSounds, onDebugAutoConnectTestServer, onDebugAutoRunTestScript, onNotification, onShowFPS, (PaddingValues) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, startRestartGroup, 54), startRestartGroup, 806879670, 440);
            composer2 = startRestartGroup;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: com.miami.game.feature.settings.ui.compose.SettingsScreenKt$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return SettingsScreenKt.SettingsScreen$lambda$3(SettingsUiState.this, onRepairGame, onBackClick, onFontSize, onPageSize, onFullScreen, onShowFPS, onShowChatTime, onAmbientSounds, onBugsReport, onShareLogs, onLongShareLogs, onPrivacyPolicy, onTech, onKeyboard, onStreamer, onNotification, onDebugAutoConnectTestServer, onDebugAutoRunTestScript, onImportGameTestScript, onUseBundledGameTestScript, onSelectImportedGameTestScript, onUpdateGameTestScreenshotPullPath, onDebugScreenshotButton, onUpdateGameTestScreenshotDeviceDir, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit SettingsScreen$lambda$0(SettingsUiState settingsUiState, Function0 function0, Function0 function02, Function0 function03, Function0 function04, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C151@6072L258:SettingsScreen.kt#1gr92h");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-845123382, i, -1, "com.miami.game.feature.settings.ui.compose.SettingsScreen.<anonymous> (SettingsScreen.kt:151)");
            }
            SettingsTopBarKt.SettingsTopBar(settingsUiState, Modifier.Companion, function0, function02, function03, function04, composer, 48);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit SettingsScreen$lambda$2(SettingsUiState settingsUiState, Function0 function0, Function0 function02, Function1 function1, Function1 function12, Function0 function03, Function1 function13, Function1 function14, Function1 function15, Function0 function04, Function0 function05, Function0 function06, Function0 function07, Function0 function08, Function0 function09, Function0 function010, Function0 function011, PaddingValues padding, Composer composer, int i) {
        String str;
        String debugImportedTestScriptName;
        Intrinsics.checkNotNullParameter(padding, "padding");
        ComposerKt.sourceInformation(composer, "CN(padding)162@6386L189,170@6589L6914:SettingsScreen.kt#1gr92h");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1514866411, i, -1, "com.miami.game.feature.settings.ui.compose.SettingsScreen.<anonymous> (SettingsScreen.kt:162)");
            }
            Main_backgroundKt.BackgroundImage(settingsUiState.getBackGroundId(), true, settingsUiState.getImageBitmap(), settingsUiState.getFile(), settingsUiState.getVersion(), composer, 48);
            Modifier m288backgroundbw27NRU$default = BackgroundKt.m288backgroundbw27NRU$default(SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, null), ColorKt.Color(1711276032), null, 2, null);
            ComposerKt.sourceInformationMarkerStart(composer, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getSpaceBetween(), Alignment.Companion.getStart(), composer, 6);
            ComposerKt.sourceInformationMarkerStart(composer, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
            int hashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(composer, m288backgroundbw27NRU$default);
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
            Updater.m4475setimpl(m4467constructorimpl, columnMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m4475setimpl(m4467constructorimpl, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.m4475setimpl(m4467constructorimpl, Integer.valueOf(hashCode), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.m4473reconcileimpl(m4467constructorimpl, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.m4475setimpl(m4467constructorimpl, materializeModifier, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, 1549359338, "C178@6889L21,179@6927L6562:SettingsScreen.kt#1gr92h");
            ScrollState rememberScrollState = ScrollKt.rememberScrollState(0, composer, 0, 1);
            Modifier clipToBounds = ClipKt.clipToBounds(PaddingKt.m1053paddingqDBjuR0(SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, null), Dp.m8160constructorimpl(80.0f), Dp.m8160constructorimpl(68.0f), Dp.m8160constructorimpl(8.0f), Dp.m8160constructorimpl(68.0f)));
            Alignment center = Alignment.Companion.getCenter();
            ComposerKt.sourceInformationMarkerStart(composer, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(center, false);
            ComposerKt.sourceInformationMarkerStart(composer, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
            int hashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap2 = composer.getCurrentCompositionLocalMap();
            Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(composer, clipToBounds);
            Function0<ComposeUiNode> constructor2 = ComposeUiNode.Companion.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)410@16187L9:Composables.kt#9igjgp");
            if (!(composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer.startReusableNode();
            if (composer.getInserting()) {
                composer.createNode(constructor2);
            } else {
                composer.useNode();
            }
            Composer m4467constructorimpl2 = Updater.m4467constructorimpl(composer);
            Updater.m4475setimpl(m4467constructorimpl2, maybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m4475setimpl(m4467constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.m4475setimpl(m4467constructorimpl2, Integer.valueOf(hashCode2), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.m4473reconcileimpl(m4467constructorimpl2, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.m4475setimpl(m4467constructorimpl2, materializeModifier2, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, 1967466682, "C194@7500L36,191@7375L6096:SettingsScreen.kt#1gr92h");
            Modifier verticalScroll$default = ScrollKt.verticalScroll$default(ScrollBarKt.fadingTopBottomEdgesSimplified$default(ScrollBarKt.m9722verticalColumnScrollbarosbwsH8(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, null), rememberScrollState, 0.0f, false, 0.0f, 0.0f, composer, 6, 30), rememberScrollState, 0.0f, 0.0f, 6, null), rememberScrollState, false, null, false, 14, null);
            ComposerKt.sourceInformationMarkerStart(composer, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            MeasurePolicy columnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.m742spacedBy0680j_4(Dp.m8160constructorimpl(-Dp.m8160constructorimpl(4.0f))), Alignment.Companion.getStart(), composer, 6);
            ComposerKt.sourceInformationMarkerStart(composer, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
            int hashCode3 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap3 = composer.getCurrentCompositionLocalMap();
            Modifier materializeModifier3 = ComposedModifierKt.materializeModifier(composer, verticalScroll$default);
            Function0<ComposeUiNode> constructor3 = ComposeUiNode.Companion.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)410@16187L9:Composables.kt#9igjgp");
            if (!(composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer.startReusableNode();
            if (composer.getInserting()) {
                composer.createNode(constructor3);
            } else {
                composer.useNode();
            }
            Composer m4467constructorimpl3 = Updater.m4467constructorimpl(composer);
            Updater.m4475setimpl(m4467constructorimpl3, columnMeasurePolicy2, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m4475setimpl(m4467constructorimpl3, currentCompositionLocalMap3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.m4475setimpl(m4467constructorimpl3, Integer.valueOf(hashCode3), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.m4473reconcileimpl(m4467constructorimpl3, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.m4475setimpl(m4467constructorimpl3, materializeModifier3, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScopeInstance columnScopeInstance2 = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, -1860758393, "C200@7792L40,201@7857L802,218@8684L2828,295@13408L41:SettingsScreen.kt#1gr92h");
            SpacerKt.Spacer(SizeKt.m1103height3ABfNKs(Modifier.Companion, Dp.m8160constructorimpl(8.0f)), composer, 6);
            Modifier width = IntrinsicKt.width(Modifier.Companion, IntrinsicSize.Max);
            ComposerKt.sourceInformationMarkerStart(composer, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            MeasurePolicy columnMeasurePolicy3 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.m742spacedBy0680j_4(Dp.m8160constructorimpl(-Dp.m8160constructorimpl(12.0f))), Alignment.Companion.getStart(), composer, 6);
            ComposerKt.sourceInformationMarkerStart(composer, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
            int hashCode4 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap4 = composer.getCurrentCompositionLocalMap();
            Modifier materializeModifier4 = ComposedModifierKt.materializeModifier(composer, width);
            Function0<ComposeUiNode> constructor4 = ComposeUiNode.Companion.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)410@16187L9:Composables.kt#9igjgp");
            if (!(composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer.startReusableNode();
            if (composer.getInserting()) {
                composer.createNode(constructor4);
            } else {
                composer.useNode();
            }
            Composer m4467constructorimpl4 = Updater.m4467constructorimpl(composer);
            Updater.m4475setimpl(m4467constructorimpl4, columnMeasurePolicy3, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m4475setimpl(m4467constructorimpl4, currentCompositionLocalMap4, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.m4475setimpl(m4467constructorimpl4, Integer.valueOf(hashCode4), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.m4473reconcileimpl(m4467constructorimpl4, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.m4475setimpl(m4467constructorimpl4, materializeModifier4, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScopeInstance columnScopeInstance3 = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, -960619721, "C205@8090L163,209@8282L157,213@8468L165:SettingsScreen.kt#1gr92h");
            SettingsRowsKt.ChatFontSize(function14, settingsUiState.getSettingState().getChatFontSize(), null, composer, 0, 4);
            Composer composer2 = composer;
            SettingsRowsKt.FontsCount(function15, settingsUiState.getSettingState().getPageSize(), null, composer2, 0, 4);
            SettingsRowsKt.StreamerSwitch(function04, settingsUiState.getSettingState().getStreamerMode(), null, composer2, 0, 4);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerStart(composer2, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.m742spacedBy0680j_4(Dp.m8160constructorimpl(12.0f)), Alignment.Companion.getTop(), composer2, 6);
            ComposerKt.sourceInformationMarkerStart(composer2, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
            int hashCode5 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer2, 0));
            CompositionLocalMap currentCompositionLocalMap5 = composer2.getCurrentCompositionLocalMap();
            Modifier materializeModifier5 = ComposedModifierKt.materializeModifier(composer2, Modifier.Companion);
            Function0<ComposeUiNode> constructor5 = ComposeUiNode.Companion.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composer2, -553112988, "CC(ReusableComposeNode)N(factory,update,content)410@16187L9:Composables.kt#9igjgp");
            if (!(composer2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer2.startReusableNode();
            if (composer2.getInserting()) {
                composer2.createNode(constructor5);
            } else {
                composer2.useNode();
            }
            Composer m4467constructorimpl5 = Updater.m4467constructorimpl(composer2);
            Updater.m4475setimpl(m4467constructorimpl5, rowMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m4475setimpl(m4467constructorimpl5, currentCompositionLocalMap5, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.m4475setimpl(m4467constructorimpl5, Integer.valueOf(hashCode5), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.m4473reconcileimpl(m4467constructorimpl5, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.m4475setimpl(m4467constructorimpl5, materializeModifier5, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer2, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer2, -900216929, "C221@8825L1889,255@10743L743:SettingsScreen.kt#1gr92h");
            ComposerKt.sourceInformationMarkerStart(composer2, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            MeasurePolicy columnMeasurePolicy4 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.m742spacedBy0680j_4(Dp.m8160constructorimpl(8.0f)), Alignment.Companion.getStart(), composer2, 6);
            ComposerKt.sourceInformationMarkerStart(composer2, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
            int hashCode6 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer2, 0));
            CompositionLocalMap currentCompositionLocalMap6 = composer2.getCurrentCompositionLocalMap();
            Modifier materializeModifier6 = ComposedModifierKt.materializeModifier(composer2, Modifier.Companion);
            Function0<ComposeUiNode> constructor6 = ComposeUiNode.Companion.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composer2, -553112988, "CC(ReusableComposeNode)N(factory,update,content)410@16187L9:Composables.kt#9igjgp");
            if (!(composer2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer2.startReusableNode();
            if (composer2.getInserting()) {
                composer2.createNode(constructor6);
            } else {
                composer2.useNode();
            }
            Composer m4467constructorimpl6 = Updater.m4467constructorimpl(composer2);
            Updater.m4475setimpl(m4467constructorimpl6, columnMeasurePolicy4, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m4475setimpl(m4467constructorimpl6, currentCompositionLocalMap6, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.m4475setimpl(m4467constructorimpl6, Integer.valueOf(hashCode6), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.m4473reconcileimpl(m4467constructorimpl6, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.m4475setimpl(m4467constructorimpl6, materializeModifier6, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer2, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScopeInstance columnScopeInstance4 = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer2, 1764942085, "C225@9031L237,230@9301L248:SettingsScreen.kt#1gr92h");
            SwitchButtonKt.SwitchButton("ПОЛНЫЙ ЭКРАН", function05, settingsUiState.getSettingState().getFullScreen(), composer2, 6);
            SwitchButtonKt.SwitchButton("ДАТА И ВРЕМЯ В ЧАТЕ", function06, settingsUiState.getSettingState().getShowChatTime(), composer2, 6);
            if (settingsUiState.isArizona()) {
                composer2.startReplaceGroup(1765506067);
                ComposerKt.sourceInformation(composer2, "236@9643L262");
                SwitchButtonKt.SwitchButton("ЗВУКИ ОКРУЖЕНИЯ", function07, settingsUiState.getSettingState().getAmbientSounds(), composer2, 6);
                composer2.endReplaceGroup();
            } else {
                composer2.startReplaceGroup(1765791577);
                composer2.endReplaceGroup();
            }
            if (settingsUiState.isDebug()) {
                composer2.startReplaceGroup(1765866566);
                ComposerKt.sourceInformation(composer2, "243@10031L297,248@10365L285");
                SwitchButtonKt.SwitchButton("AUTO CONNECT TEST SERVER", function08, settingsUiState.getSettingState().getDebugAutoConnectTestServer(), composer2, 6);
                SwitchButtonKt.SwitchButton("AUTO RUN TEST SCRIPT", function09, settingsUiState.getSettingState().getDebugAutoRunTestScript(), composer2, 6);
                composer2.endReplaceGroup();
            } else {
                composer2.startReplaceGroup(1766530617);
                composer2.endReplaceGroup();
            }
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerStart(composer2, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            MeasurePolicy columnMeasurePolicy5 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.m742spacedBy0680j_4(Dp.m8160constructorimpl(8.0f)), Alignment.Companion.getStart(), composer2, 6);
            ComposerKt.sourceInformationMarkerStart(composer2, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
            int hashCode7 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer2, 0));
            CompositionLocalMap currentCompositionLocalMap7 = composer2.getCurrentCompositionLocalMap();
            Modifier materializeModifier7 = ComposedModifierKt.materializeModifier(composer2, Modifier.Companion);
            Function0<ComposeUiNode> constructor7 = ComposeUiNode.Companion.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composer2, -553112988, "CC(ReusableComposeNode)N(factory,update,content)410@16187L9:Composables.kt#9igjgp");
            if (!(composer2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer2.startReusableNode();
            if (composer2.getInserting()) {
                composer2.createNode(constructor7);
            } else {
                composer2.useNode();
            }
            Composer m4467constructorimpl7 = Updater.m4467constructorimpl(composer2);
            Updater.m4475setimpl(m4467constructorimpl7, columnMeasurePolicy5, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m4475setimpl(m4467constructorimpl7, currentCompositionLocalMap7, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.m4475setimpl(m4467constructorimpl7, Integer.valueOf(hashCode7), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.m4473reconcileimpl(m4467constructorimpl7, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.m4475setimpl(m4467constructorimpl7, materializeModifier7, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer2, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScopeInstance columnScopeInstance5 = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer2, 317370294, "C259@10949L241,264@11223L233:SettingsScreen.kt#1gr92h");
            SwitchButtonKt.SwitchButton("УВЕДОМЛЕНИЯ", function010, settingsUiState.getSettingState().getNotifications(), composer2, 6);
            SwitchButtonKt.SwitchButton("ОТОБРАЖАТЬ FPS", function011, settingsUiState.getSettingState().getShowFps(), composer2, 6);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            if (settingsUiState.isDebug()) {
                composer2.startReplaceGroup(-1857141314);
                ComposerKt.sourceInformation(composer2, "279@12040L1317");
                if (settingsUiState.getSettingState().getDebugUseImportedTestScript() && (debugImportedTestScriptName = settingsUiState.getSettingState().getDebugImportedTestScriptName()) != null) {
                    String str2 = !StringsKt.isBlank(debugImportedTestScriptName) ? debugImportedTestScriptName : null;
                    if (str2 != null) {
                        str = str2;
                        DebugGameTestScriptCardKt.DebugGameTestScriptCard(str, settingsUiState.getSettingState().getDebugUseImportedTestScript(), settingsUiState.getSettingState().getDebugImportedTestScripts(), settingsUiState.getSettingState().getDebugActiveImportedTestScriptFileName(), settingsUiState.getSettingState().getDebugGameTestScreenshotPullPath(), settingsUiState.getSettingState().getDebugGameTestScreenshotButtonEnabled(), settingsUiState.getSettingState().getDebugGameTestScreenshotDeviceDir(), function0, function02, function1, function12, function03, function13, composer2, 0, 0);
                        composer2 = composer2;
                        composer2.endReplaceGroup();
                    }
                }
                str = "default_game_test_script.json";
                DebugGameTestScriptCardKt.DebugGameTestScriptCard(str, settingsUiState.getSettingState().getDebugUseImportedTestScript(), settingsUiState.getSettingState().getDebugImportedTestScripts(), settingsUiState.getSettingState().getDebugActiveImportedTestScriptFileName(), settingsUiState.getSettingState().getDebugGameTestScreenshotPullPath(), settingsUiState.getSettingState().getDebugGameTestScreenshotButtonEnabled(), settingsUiState.getSettingState().getDebugGameTestScreenshotDeviceDir(), function0, function02, function1, function12, function03, function13, composer2, 0, 0);
                composer2 = composer2;
                composer2.endReplaceGroup();
            } else {
                composer2.startReplaceGroup(-1855387489);
                composer2.endReplaceGroup();
            }
            SpacerKt.Spacer(SizeKt.m1103height3ABfNKs(Modifier.Companion, Dp.m8160constructorimpl(20.0f)), composer2, 6);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit SettingsScreen$lambda$1(Function0 function0, Function0 function02, Function0 function03, Function0 function04, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C301@13549L222:SettingsScreen.kt#1gr92h");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-623211701, i, -1, "com.miami.game.feature.settings.ui.compose.SettingsScreen.<anonymous> (SettingsScreen.kt:301)");
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
        ComposerKt.sourceInformation(startRestartGroup, "C(BackgroundImage)N(backGroundId)314@13920L56,312@13852L208:SettingsScreen.kt#1gr92h");
        if ((i2 & 6) == 0) {
            i3 = (startRestartGroup.changed(i) ? 4 : 2) | i2;
        } else {
            i3 = i2;
        }
        if (!startRestartGroup.shouldExecute((i3 & 3) != 2, i3 & 1)) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1060762892, i3, -1, "com.miami.game.feature.settings.ui.compose.BackgroundImage (SettingsScreen.kt:311)");
            }
            ImageKt.Image(PainterResources_androidKt.painterResource(i, startRestartGroup, i3 & 14), (String) null, SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, null), (Alignment) null, ContentScale.Companion.getCrop(), 0.0f, (ColorFilter) null, startRestartGroup, Painter.$stable | 25008, 104);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: com.miami.game.feature.settings.ui.compose.SettingsScreenKt$$ExternalSyntheticLambda4
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
