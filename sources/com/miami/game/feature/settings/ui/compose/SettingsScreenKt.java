package com.miami.game.feature.settings.ui.compose;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.text.format.Formatter;
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
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotIntStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
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
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.unit.Dp;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.compose.FlowExtKt;
import androidx.media3.exoplayer.RendererCapabilities;
import androidx.profileinstaller.ProfileVerifier;
import com.miami.game.core.decompose.utils.SharedEventFlow;
import com.miami.game.core.design.system.component.background.Main_backgroundKt;
import com.miami.game.core.design.system.component.button.DialogButtonKt;
import com.miami.game.core.design.system.component.dialog_frame.DialogDescriptionTextKt;
import com.miami.game.core.design.system.component.dialog_frame.DialogFrameKt;
import com.miami.game.core.design.system.component.other.ScrollBarKt;
import com.miami.game.core.external.navigation.ui.ObserveExternalNavigationActionsKt;
import com.miami.game.core.settings.SettingsMenuDefaults;
import com.miami.game.core.ui.utils.extensions.FlowExtensionsKt;
import com.miami.game.feature.download.dialog.ui.connection.ConnectionData;
import com.miami.game.feature.download.dialog.ui.connection.ConnectionDialogKt;
import com.miami.game.feature.settings.ui.SettingsComponent;
import com.miami.game.feature.settings.ui.model.SettingsUiAction;
import com.miami.game.feature.settings.ui.model.SettingsUiState;
import com.miami.game.ui.classic.settings.R;
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
@Metadata(d1 = {"\u0000p\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\u001a·\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\u0018\u0010\t\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u0005\u0012\u0004\u0012\u00020\u00010\n2-\u0010\u000b\u001a)\u0012\u001f\u0012\u001d\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00010\n¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u00010\n2/\u0010\u0010\u001a+\u0012!\u0012\u001f\u0012\u0006\u0012\u0004\u0018\u00010\u0011\u0012\u0004\u0012\u00020\u00010\n¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u00010\n2-\u0010\u0013\u001a)\u0012\u001f\u0012\u001d\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00010\n¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u00010\n2-\u0010\u0014\u001a)\u0012\u001f\u0012\u001d\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00010\n¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u00010\nH\u0007b\u0002\b\u0016b\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u0019¢\u0006\u0002\u0010\u0015\u001a\u0089\u0006\u0010\u001a\u001a\u00020\u00012\u0006\u0010\u001b\u001a\u00020\u001c2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052$\u0010\u001e\u001a \u0012\u0004\u0012\u00020 \u0012\n\u0012\b\u0012\u0004\u0012\u00020\"0!\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020\u00010\u001f2$\u0010#\u001a \u0012\u0004\u0012\u00020 \u0012\n\u0012\b\u0012\u0004\u0012\u00020\"0!\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020\u00010\u001f2\u001e\u0010$\u001a\u001a\u0012\u0004\u0012\u00020 \u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0!\u0012\u0004\u0012\u00020\u00010%2<\u0010&\u001a8\u0012\u0013\u0012\u00110 ¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b('\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\f0!¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b((\u0012\u0004\u0012\u00020\u00010%2-\u0010\u000b\u001a)\u0012\u001f\u0012\u001d\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00010\n¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u00010\n2/\u0010\u0010\u001a+\u0012!\u0012\u001f\u0012\u0006\u0012\u0004\u0018\u00010\u0011\u0012\u0004\u0012\u00020\u00010\n¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u00010\n2-\u0010\u0013\u001a)\u0012\u001f\u0012\u001d\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00010\n¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u00010\n2-\u0010\u0014\u001a)\u0012\u001f\u0012\u001d\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00010\n¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u00010\n2\u001e\u0010)\u001a\u001a\u0012\u0004\u0012\u00020 \u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0!\u0012\u0004\u0012\u00020\u00010%2\f\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\f\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\f\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\f\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\f\u0010.\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052$\u0010/\u001a \u0012\u0004\u0012\u00020 \u0012\n\u0012\b\u0012\u0004\u0012\u00020\"0!\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020\u00010\u001f2$\u00100\u001a \u0012\u0004\u0012\u00020 \u0012\n\u0012\b\u0012\u0004\u0012\u00020\"0!\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020\u00010\u001f2\f\u00101\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\f\u00102\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\f\u00103\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\f\u00104\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\f\u00105\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\u0012\u00106\u001a\u000e\u0012\u0004\u0012\u000207\u0012\u0004\u0012\u00020\u00010\n2\u0012\u00108\u001a\u000e\u0012\u0004\u0012\u000207\u0012\u0004\u0012\u00020\u00010\n2\f\u00109\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\f\u0010:\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\u0012\u0010;\u001a\u000e\u0012\u0004\u0012\u000207\u0012\u0004\u0012\u00020\u00010\nH\u0001b\f\b=\u0012\b\b>\u0012\u0004\b\u0003\u0010\u0004b\u0002\b\u0016b\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u0019¢\u0006\u0002\u0010<\u001aK\u0010?\u001a\u00020\u00012\u0006\u0010@\u001a\u00020\u00112\u0006\u0010A\u001a\u00020\f2\f\u0010B\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\f\u0010C\u001a\b\u0012\u0004\u0012\u00020\u00010\u0005H\u0003b\u0002\b\u0016b\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u0019¢\u0006\u0002\u0010D\u001a'\u0010E\u001a\u00020\u00012\u0006\u0010F\u001a\u00020\"H\u0001b\u0002\b\u0016b\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u0019¢\u0006\u0002\u0010G\"\u000e\u0010H\u001a\u000207X\u0082T¢\u0006\u0002\n\u0000¨\u0006I²\u0006\n\u0010\u001b\u001a\u00020\u001cX\u008a\u0084\u0002"}, d2 = {"SettingsRoute", "", "component", "Lcom/miami/game/feature/settings/ui/SettingsComponent;", "onBackClick", "Lkotlin/Function0;", "onRepairGameSuccess", "onRepairGameError", "onNavigateDownload", "onRepairGameDialog", "Lkotlin/Function1;", "onViceCityEnable", "", "Lkotlin/ParameterName;", "name", "onComplete", "onViceCityInspectBeforeDisable", "", "onResult", "onViceCityKeep", "onViceCityDelete", "(Lcom/miami/game/feature/settings/ui/SettingsComponent;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "Landroidx/compose/runtime/Composable;", "Landroidx/compose/runtime/ComposableTarget;", "applier", "androidx.compose.ui.UiComposable", "SettingsScreen", "uiState", "Lcom/miami/game/feature/settings/ui/model/SettingsUiState;", "onRepairGame", "onFontSize", "Lkotlin/Function3;", "Landroid/content/SharedPreferences;", "Landroidx/compose/runtime/MutableState;", "", "onPageSize", "onFullScreen", "Lkotlin/Function2;", "onShowFPS", "prefs", "value", "onShowChatTime", "onBugsReport", "onShareLogs", "onLongShareLogs", "onPrivacyPolicy", "onTech", "onKeyboard", "onStreamer", "onNotification", "onDebugAutoConnectTestServer", "onDebugAutoRunTestScript", "onImportGameTestScript", "onUseBundledGameTestScript", "onSelectImportedGameTestScript", "", "onUpdateGameTestScreenshotPullPath", "onDebugScreenshotButton", "onDebugLogShareButton", "onUpdateGameTestScreenshotDeviceDir", "(Lcom/miami/game/feature/settings/ui/model/SettingsUiState;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;III)V", "Landroidx/annotation/VisibleForTesting;", "otherwise", "ViceCityDisableDialog", "sizeBytes", "isProcessing", "onDelete", "onDismiss", "(JZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "BackgroundImage", "backGroundId", "(ILandroidx/compose/runtime/Composer;I)V", "DEFAULT_DEBUG_TEST_SCRIPT_NAME", "settings"}, k = 2, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SettingsScreenKt {
    private static final String DEFAULT_DEBUG_TEST_SCRIPT_NAME = "default_game_test_script.json";

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit BackgroundImage$lambda$0(int i, int i2, Composer composer, int i3) {
        BackgroundImage(i, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit SettingsRoute$lambda$28(SettingsComponent settingsComponent, Function0 function0, Function0 function02, Function0 function03, Function0 function04, Function1 function1, Function1 function12, Function1 function13, Function1 function14, Function1 function15, int i, Composer composer, int i2) {
        SettingsRoute(settingsComponent, function0, function02, function03, function04, function1, function12, function13, function14, function15, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit SettingsScreen$lambda$23(SettingsUiState settingsUiState, Function0 function0, Function0 function02, Function3 function3, Function3 function32, Function2 function2, Function2 function22, Function1 function1, Function1 function12, Function1 function13, Function1 function14, Function2 function23, Function0 function03, Function0 function04, Function0 function05, Function0 function06, Function0 function07, Function3 function33, Function3 function34, Function0 function08, Function0 function09, Function0 function010, Function0 function011, Function0 function012, Function1 function15, Function1 function16, Function0 function013, Function0 function014, Function1 function17, int i, int i2, int i3, Composer composer, int i4) {
        SettingsScreen(settingsUiState, function0, function02, function3, function32, function2, function22, function1, function12, function13, function14, function23, function03, function04, function05, function06, function07, function33, function34, function08, function09, function010, function011, function012, function15, function16, function013, function014, function17, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2), RecomposeScopeImplKt.updateChangedFlags(i3));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit ViceCityDisableDialog$lambda$1(long j, boolean z, Function0 function0, Function0 function02, int i, Composer composer, int i2) {
        ViceCityDisableDialog(j, z, function0, function02, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:402:0x0674, code lost:
        if (r14 == androidx.compose.runtime.Composer.Companion.getEmpty()) goto L373;
     */
    /* JADX WARN: Code restructure failed: missing block: B:409:0x06e0, code lost:
        if (r3 == androidx.compose.runtime.Composer.Companion.getEmpty()) goto L371;
     */
    /* JADX WARN: Code restructure failed: missing block: B:420:0x078a, code lost:
        if (r15.changedInstance(r3) != false) goto L367;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void SettingsRoute(final SettingsComponent component, final Function0<Unit> onBackClick, final Function0<Unit> onRepairGameSuccess, final Function0<Unit> onRepairGameError, final Function0<Unit> onNavigateDownload, final Function1<? super Function0<Unit>, Unit> onRepairGameDialog, final Function1<? super Function1<? super Boolean, Unit>, Unit> onViceCityEnable, final Function1<? super Function1<? super Long, Unit>, Unit> onViceCityInspectBeforeDisable, final Function1<? super Function1<? super Boolean, Unit>, Unit> onViceCityKeep, final Function1<? super Function1<? super Boolean, Unit>, Unit> onViceCityDelete, Composer composer, final int i) {
        int i2;
        SettingsComponent settingsComponent;
        int i3;
        KFunction kFunction;
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
        Intrinsics.checkNotNullParameter(onViceCityEnable, "onViceCityEnable");
        Intrinsics.checkNotNullParameter(onViceCityInspectBeforeDisable, "onViceCityInspectBeforeDisable");
        Intrinsics.checkNotNullParameter(onViceCityKeep, "onViceCityKeep");
        Intrinsics.checkNotNullParameter(onViceCityDelete, "onViceCityDelete");
        Composer startRestartGroup = composer.startRestartGroup(-1978358625);
        ComposerKt.sourceInformation(startRestartGroup, "C(SettingsRoute)N(component,onBackClick,onRepairGameSuccess,onRepairGameError,onNavigateDownload,onRepairGameDialog,onViceCityEnable,onViceCityInspectBeforeDisable,onViceCityKeep,onViceCityDelete)73@3622L33,75@3694L29,78@3850L101,76@3751L200,84@4013L227,84@3976L264,92@4280L34,96@4386L28,98@4472L21,99@4516L21,100@4562L23,101@4607L20,106@4858L25,107@4908L23,108@4959L26,109@5009L22,110@5059L26,111@5104L17,112@5144L21,113@5188L21,114@5236L26,115@5303L39,116@5379L35,120@5574L37,121@5654L41,122@5742L45,123@5823L34,124@5891L32,125@5971L46,117@5449L86,94@4320L1704:SettingsScreen.kt#1gr92h");
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
        if ((i & 1572864) == 0) {
            i2 |= startRestartGroup.changedInstance(onViceCityEnable) ? 1048576 : 524288;
        }
        if ((i & 12582912) == 0) {
            i2 |= startRestartGroup.changedInstance(onViceCityInspectBeforeDisable) ? 8388608 : 4194304;
        }
        if ((i & 100663296) == 0) {
            i2 |= startRestartGroup.changedInstance(onViceCityKeep) ? 67108864 : GroupFlagsKt.HasAuxSlotFlag;
        }
        if ((i & 805306368) == 0) {
            i2 |= startRestartGroup.changedInstance(onViceCityDelete) ? 536870912 : 268435456;
        }
        if (startRestartGroup.shouldExecute((306774035 & i2) != 306774034, i2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1978358625, i2, -1, "com.miami.game.feature.settings.ui.compose.SettingsRoute (SettingsScreen.kt:72)");
            }
            BackHandlerKt.BackHandler(false, onBackClick, startRestartGroup, i2 & 112, 1);
            int i4 = i2;
            State collectAsStateWithLifecycle = FlowExtKt.collectAsStateWithLifecycle(component.getUiState(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, startRestartGroup, 0, 7);
            ActivityResultContracts.OpenDocument openDocument = new ActivityResultContracts.OpenDocument();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1467896964, "CC(remember):SettingsScreen.kt#9igjgp");
            int i5 = i4 & 14;
            boolean z3 = i5 == 4 || ((i4 & 8) != 0 && startRestartGroup.changedInstance(component));
            Object rememberedValue3 = startRestartGroup.rememberedValue();
            if (z3 || rememberedValue3 == Composer.Companion.getEmpty()) {
                rememberedValue3 = new Function1() { // from class: com.miami.game.feature.settings.ui.compose.SettingsScreenKt$$ExternalSyntheticLambda14
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
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1467902306, "CC(remember):SettingsScreen.kt#9igjgp");
            boolean z4 = (i5 == 4 || ((i4 & 8) != 0 && startRestartGroup.changedInstance(component))) | ((i4 & 458752) == 131072);
            SettingsScreenKt$SettingsRoute$1$1 rememberedValue4 = startRestartGroup.rememberedValue();
            if (z4 || rememberedValue4 == Composer.Companion.getEmpty()) {
                rememberedValue4 = new SettingsScreenKt$SettingsRoute$1$1(onRepairGameDialog, component, null);
                startRestartGroup.updateRememberedValue(rememberedValue4);
            }
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            FlowExtensionsKt.collectInLaunchedEffectWithLifecycle(uiAction, objArr, null, null, (Function3) rememberedValue4, startRestartGroup, 0, 6);
            ObserveExternalNavigationActionsKt.observeExternalNavigationActions(component.getExternalNavigationAction(), startRestartGroup, 0);
            SettingsUiState SettingsRoute$lambda$0 = SettingsRoute$lambda$0(collectAsStateWithLifecycle);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1467914043, "CC(remember):SettingsScreen.kt#9igjgp");
            boolean z5 = i5 == 4 || ((i4 & 8) != 0 && startRestartGroup.changedInstance(component));
            SettingsScreenKt$SettingsRoute$2$1 rememberedValue5 = startRestartGroup.rememberedValue();
            if (z5 || rememberedValue5 == Composer.Companion.getEmpty()) {
                rememberedValue5 = new SettingsScreenKt$SettingsRoute$2$1(component);
                startRestartGroup.updateRememberedValue(rememberedValue5);
            }
            KFunction kFunction2 = (KFunction) rememberedValue5;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1467916788, "CC(remember):SettingsScreen.kt#9igjgp");
            boolean z6 = i5 == 4 || ((i4 & 8) != 0 && startRestartGroup.changedInstance(component));
            SettingsScreenKt$SettingsRoute$3$1 rememberedValue6 = startRestartGroup.rememberedValue();
            if (z6 || rememberedValue6 == Composer.Companion.getEmpty()) {
                rememberedValue6 = new SettingsScreenKt$SettingsRoute$3$1(component);
                startRestartGroup.updateRememberedValue(rememberedValue6);
            }
            KFunction kFunction3 = (KFunction) rememberedValue6;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1467918196, "CC(remember):SettingsScreen.kt#9igjgp");
            boolean z7 = i5 == 4 || ((i4 & 8) != 0 && startRestartGroup.changedInstance(component));
            SettingsScreenKt$SettingsRoute$4$1 rememberedValue7 = startRestartGroup.rememberedValue();
            if (z7 || rememberedValue7 == Composer.Companion.getEmpty()) {
                rememberedValue7 = new SettingsScreenKt$SettingsRoute$4$1(component);
                startRestartGroup.updateRememberedValue(rememberedValue7);
            }
            KFunction kFunction4 = (KFunction) rememberedValue7;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1467919670, "CC(remember):SettingsScreen.kt#9igjgp");
            boolean z8 = i5 == 4 || ((i4 & 8) != 0 && startRestartGroup.changedInstance(component));
            SettingsScreenKt$SettingsRoute$5$1 rememberedValue8 = startRestartGroup.rememberedValue();
            if (z8 || rememberedValue8 == Composer.Companion.getEmpty()) {
                rememberedValue8 = new SettingsScreenKt$SettingsRoute$5$1(component);
                startRestartGroup.updateRememberedValue(rememberedValue8);
            }
            KFunction kFunction5 = (KFunction) rememberedValue8;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1467921107, "CC(remember):SettingsScreen.kt#9igjgp");
            boolean z9 = i5 == 4 || ((i4 & 8) != 0 && startRestartGroup.changedInstance(component));
            SettingsScreenKt$SettingsRoute$6$1 rememberedValue9 = startRestartGroup.rememberedValue();
            if (z9 || rememberedValue9 == Composer.Companion.getEmpty()) {
                rememberedValue9 = new SettingsScreenKt$SettingsRoute$6$1(component);
                startRestartGroup.updateRememberedValue(rememberedValue9);
            }
            KFunction kFunction6 = (KFunction) rememberedValue9;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1467929144, "CC(remember):SettingsScreen.kt#9igjgp");
            boolean z10 = i5 == 4 || ((i4 & 8) != 0 && startRestartGroup.changedInstance(component));
            SettingsScreenKt$SettingsRoute$7$1 rememberedValue10 = startRestartGroup.rememberedValue();
            if (z10 || rememberedValue10 == Composer.Companion.getEmpty()) {
                rememberedValue10 = new SettingsScreenKt$SettingsRoute$7$1(component);
                startRestartGroup.updateRememberedValue(rememberedValue10);
            }
            KFunction kFunction7 = (KFunction) rememberedValue10;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1467930742, "CC(remember):SettingsScreen.kt#9igjgp");
            boolean z11 = i5 == 4 || ((i4 & 8) != 0 && startRestartGroup.changedInstance(component));
            SettingsScreenKt$SettingsRoute$8$1 rememberedValue11 = startRestartGroup.rememberedValue();
            if (z11 || rememberedValue11 == Composer.Companion.getEmpty()) {
                rememberedValue11 = new SettingsScreenKt$SettingsRoute$8$1(component);
                startRestartGroup.updateRememberedValue(rememberedValue11);
            }
            KFunction kFunction8 = (KFunction) rememberedValue11;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1467932377, "CC(remember):SettingsScreen.kt#9igjgp");
            boolean z12 = i5 == 4 || ((i4 & 8) != 0 && startRestartGroup.changedInstance(component));
            SettingsScreenKt$SettingsRoute$9$1 rememberedValue12 = startRestartGroup.rememberedValue();
            if (z12 || rememberedValue12 == Composer.Companion.getEmpty()) {
                rememberedValue12 = new SettingsScreenKt$SettingsRoute$9$1(component);
                startRestartGroup.updateRememberedValue(rememberedValue12);
            }
            KFunction kFunction9 = (KFunction) rememberedValue12;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1467933973, "CC(remember):SettingsScreen.kt#9igjgp");
            boolean z13 = i5 == 4 || ((i4 & 8) != 0 && startRestartGroup.changedInstance(component));
            SettingsScreenKt$SettingsRoute$10$1 rememberedValue13 = startRestartGroup.rememberedValue();
            if (z13 || rememberedValue13 == Composer.Companion.getEmpty()) {
                rememberedValue13 = new SettingsScreenKt$SettingsRoute$10$1(component);
                startRestartGroup.updateRememberedValue(rememberedValue13);
            }
            KFunction kFunction10 = (KFunction) rememberedValue13;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1467935577, "CC(remember):SettingsScreen.kt#9igjgp");
            boolean z14 = i5 == 4 || ((i4 & 8) != 0 && startRestartGroup.changedInstance(component));
            SettingsScreenKt$SettingsRoute$11$1 rememberedValue14 = startRestartGroup.rememberedValue();
            if (z14 || rememberedValue14 == Composer.Companion.getEmpty()) {
                rememberedValue14 = new SettingsScreenKt$SettingsRoute$11$1(component);
                startRestartGroup.updateRememberedValue(rememberedValue14);
            }
            KFunction kFunction11 = (KFunction) rememberedValue14;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1467937008, "CC(remember):SettingsScreen.kt#9igjgp");
            boolean z15 = i5 == 4 || ((i4 & 8) != 0 && startRestartGroup.changedInstance(component));
            SettingsScreenKt$SettingsRoute$12$1 rememberedValue15 = startRestartGroup.rememberedValue();
            if (z15 || rememberedValue15 == Composer.Companion.getEmpty()) {
                rememberedValue15 = new SettingsScreenKt$SettingsRoute$12$1(component);
                startRestartGroup.updateRememberedValue(rememberedValue15);
            }
            KFunction kFunction12 = (KFunction) rememberedValue15;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1467938292, "CC(remember):SettingsScreen.kt#9igjgp");
            boolean z16 = i5 == 4 || ((i4 & 8) != 0 && startRestartGroup.changedInstance(component));
            SettingsScreenKt$SettingsRoute$13$1 rememberedValue16 = startRestartGroup.rememberedValue();
            if (z16 || rememberedValue16 == Composer.Companion.getEmpty()) {
                rememberedValue16 = new SettingsScreenKt$SettingsRoute$13$1(component);
                startRestartGroup.updateRememberedValue(rememberedValue16);
            }
            KFunction kFunction13 = (KFunction) rememberedValue16;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1467939700, "CC(remember):SettingsScreen.kt#9igjgp");
            boolean z17 = i5 == 4 || ((i4 & 8) != 0 && startRestartGroup.changedInstance(component));
            SettingsScreenKt$SettingsRoute$14$1 rememberedValue17 = startRestartGroup.rememberedValue();
            if (z17 || rememberedValue17 == Composer.Companion.getEmpty()) {
                rememberedValue17 = new SettingsScreenKt$SettingsRoute$14$1(component);
                startRestartGroup.updateRememberedValue(rememberedValue17);
            }
            KFunction kFunction14 = (KFunction) rememberedValue17;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1467941241, "CC(remember):SettingsScreen.kt#9igjgp");
            boolean z18 = i5 == 4 || ((i4 & 8) != 0 && startRestartGroup.changedInstance(component));
            SettingsScreenKt$SettingsRoute$15$1 rememberedValue18 = startRestartGroup.rememberedValue();
            if (z18 || rememberedValue18 == Composer.Companion.getEmpty()) {
                rememberedValue18 = new SettingsScreenKt$SettingsRoute$15$1(component);
                startRestartGroup.updateRememberedValue(rememberedValue18);
            }
            KFunction kFunction15 = (KFunction) rememberedValue18;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1467943398, "CC(remember):SettingsScreen.kt#9igjgp");
            boolean z19 = i5 == 4 || ((i4 & 8) != 0 && startRestartGroup.changedInstance(component));
            SettingsScreenKt$SettingsRoute$16$1 rememberedValue19 = startRestartGroup.rememberedValue();
            if (z19 || rememberedValue19 == Composer.Companion.getEmpty()) {
                rememberedValue19 = new SettingsScreenKt$SettingsRoute$16$1(component);
                startRestartGroup.updateRememberedValue(rememberedValue19);
            }
            KFunction kFunction16 = (KFunction) rememberedValue19;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1467945826, "CC(remember):SettingsScreen.kt#9igjgp");
            boolean z20 = i5 == 4 || ((i4 & 8) != 0 && startRestartGroup.changedInstance(component));
            SettingsScreenKt$SettingsRoute$17$1 rememberedValue20 = startRestartGroup.rememberedValue();
            if (z20 || rememberedValue20 == Composer.Companion.getEmpty()) {
                rememberedValue20 = new SettingsScreenKt$SettingsRoute$17$1(component);
                startRestartGroup.updateRememberedValue(rememberedValue20);
            }
            KFunction kFunction17 = (KFunction) rememberedValue20;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1467952068, "CC(remember):SettingsScreen.kt#9igjgp");
            boolean z21 = i5 == 4 || ((i4 & 8) != 0 && startRestartGroup.changedInstance(component));
            SettingsScreenKt$SettingsRoute$18$1 rememberedValue21 = startRestartGroup.rememberedValue();
            if (z21 || rememberedValue21 == Composer.Companion.getEmpty()) {
                rememberedValue21 = new SettingsScreenKt$SettingsRoute$18$1(component);
                startRestartGroup.updateRememberedValue(rememberedValue21);
            }
            KFunction kFunction18 = (KFunction) rememberedValue21;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1467954632, "CC(remember):SettingsScreen.kt#9igjgp");
            boolean z22 = i5 == 4 || ((i4 & 8) != 0 && startRestartGroup.changedInstance(component));
            SettingsScreenKt$SettingsRoute$19$1 rememberedValue22 = startRestartGroup.rememberedValue();
            if (z22 || rememberedValue22 == Composer.Companion.getEmpty()) {
                rememberedValue22 = new SettingsScreenKt$SettingsRoute$19$1(component);
                startRestartGroup.updateRememberedValue(rememberedValue22);
            }
            KFunction kFunction19 = (KFunction) rememberedValue22;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1467957452, "CC(remember):SettingsScreen.kt#9igjgp");
            boolean z23 = i5 == 4 || ((i4 & 8) != 0 && startRestartGroup.changedInstance(component));
            SettingsScreenKt$SettingsRoute$20$1 rememberedValue23 = startRestartGroup.rememberedValue();
            if (z23 || rememberedValue23 == Composer.Companion.getEmpty()) {
                rememberedValue23 = new SettingsScreenKt$SettingsRoute$20$1(component);
                startRestartGroup.updateRememberedValue(rememberedValue23);
            }
            KFunction kFunction20 = (KFunction) rememberedValue23;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1467960033, "CC(remember):SettingsScreen.kt#9igjgp");
            boolean z24 = i5 == 4 || ((i4 & 8) != 0 && startRestartGroup.changedInstance(component));
            SettingsScreenKt$SettingsRoute$21$1 rememberedValue24 = startRestartGroup.rememberedValue();
            if (z24 || rememberedValue24 == Composer.Companion.getEmpty()) {
                rememberedValue24 = new SettingsScreenKt$SettingsRoute$21$1(component);
                startRestartGroup.updateRememberedValue(rememberedValue24);
            }
            KFunction kFunction21 = (KFunction) rememberedValue24;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1467962207, "CC(remember):SettingsScreen.kt#9igjgp");
            boolean z25 = i5 == 4 || ((i4 & 8) != 0 && startRestartGroup.changedInstance(component));
            SettingsScreenKt$SettingsRoute$22$1 rememberedValue25 = startRestartGroup.rememberedValue();
            if (z25 || rememberedValue25 == Composer.Companion.getEmpty()) {
                rememberedValue25 = new SettingsScreenKt$SettingsRoute$22$1(component);
                startRestartGroup.updateRememberedValue(rememberedValue25);
            }
            KFunction kFunction22 = (KFunction) rememberedValue25;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1467964781, "CC(remember):SettingsScreen.kt#9igjgp");
            boolean z26 = i5 == 4 || ((i4 & 8) != 0 && startRestartGroup.changedInstance(component));
            SettingsScreenKt$SettingsRoute$23$1 rememberedValue26 = startRestartGroup.rememberedValue();
            if (z26) {
                i3 = i5;
            } else {
                i3 = i5;
            }
            rememberedValue26 = new SettingsScreenKt$SettingsRoute$23$1(component);
            startRestartGroup.updateRememberedValue(rememberedValue26);
            KFunction kFunction23 = (KFunction) rememberedValue26;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            Function0 function0 = (Function0) kFunction2;
            Function3 function3 = (Function3) kFunction3;
            Function3 function32 = (Function3) kFunction4;
            Function2 function2 = (Function2) kFunction5;
            Function2 function22 = (Function2) kFunction6;
            Function2 function23 = (Function2) kFunction7;
            Function0 function02 = (Function0) kFunction8;
            Function0 function03 = (Function0) kFunction10;
            Function0 function04 = (Function0) kFunction11;
            Function0 function05 = (Function0) kFunction9;
            Function0 function06 = (Function0) kFunction12;
            Function3 function33 = (Function3) kFunction13;
            Function3 function34 = (Function3) kFunction14;
            Function0 function07 = (Function0) kFunction15;
            Function0 function08 = (Function0) kFunction16;
            Function0 function09 = (Function0) kFunction17;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1467948117, "CC(remember):SettingsScreen.kt#9igjgp");
            boolean changedInstance = startRestartGroup.changedInstance(rememberLauncherForActivityResult);
            Object rememberedValue27 = startRestartGroup.rememberedValue();
            if (changedInstance) {
                kFunction = kFunction22;
            } else {
                kFunction = kFunction22;
            }
            rememberedValue27 = new Function0() { // from class: com.miami.game.feature.settings.ui.compose.SettingsScreenKt$$ExternalSyntheticLambda15
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit SettingsRoute$lambda$25$0;
                    SettingsRoute$lambda$25$0 = SettingsScreenKt.SettingsRoute$lambda$25$0(ManagedActivityResultLauncher.this);
                    return SettingsRoute$lambda$25$0;
                }
            };
            startRestartGroup.updateRememberedValue(rememberedValue27);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            int i6 = i3;
            SettingsScreen(SettingsRoute$lambda$0, function0, onBackClick, function3, function32, function2, function22, onViceCityEnable, onViceCityInspectBeforeDisable, onViceCityKeep, onViceCityDelete, function23, function02, function03, function04, function05, function06, function33, function34, function07, function08, function09, (Function0) rememberedValue27, (Function0) kFunction18, (Function1) kFunction19, (Function1) kFunction20, (Function0) kFunction21, (Function0) kFunction, (Function1) kFunction23, startRestartGroup, (i4 << 3) & 2143290240, (i4 >> 27) & 14, 0);
            startRestartGroup = startRestartGroup;
            if (SettingsRoute$lambda$0(collectAsStateWithLifecycle).isConnectionDialogVisible()) {
                startRestartGroup.startReplaceGroup(-1737631386);
                ComposerKt.sourceInformation(startRestartGroup, "131@6171L20,132@6217L24,129@6078L173");
                ConnectionData connectionData = SettingsRoute$lambda$0(collectAsStateWithLifecycle).getConnectionData();
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1467971155, "CC(remember):SettingsScreen.kt#9igjgp");
                if (i6 != 4) {
                    if ((i4 & 8) != 0) {
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
                    Function0 function010 = (Function0) ((KFunction) rememberedValue);
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1467972631, "CC(remember):SettingsScreen.kt#9igjgp");
                    z2 = i6 != 4 || ((i4 & 8) != 0 && startRestartGroup.changedInstance(settingsComponent));
                    rememberedValue2 = startRestartGroup.rememberedValue();
                    if (!z2 || rememberedValue2 == Composer.Companion.getEmpty()) {
                        rememberedValue2 = new SettingsScreenKt$SettingsRoute$26$1(settingsComponent);
                        startRestartGroup.updateRememberedValue(rememberedValue2);
                    }
                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                    ConnectionDialogKt.ConnectionDialog(connectionData, function010, (Function1) ((KFunction) rememberedValue2), startRestartGroup, ConnectionData.$stable);
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
                Function0 function0102 = (Function0) ((KFunction) rememberedValue);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1467972631, "CC(remember):SettingsScreen.kt#9igjgp");
                if (i6 != 4) {
                }
                rememberedValue2 = startRestartGroup.rememberedValue();
                if (!z2) {
                }
                rememberedValue2 = new SettingsScreenKt$SettingsRoute$26$1(settingsComponent);
                startRestartGroup.updateRememberedValue(rememberedValue2);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ConnectionDialogKt.ConnectionDialog(connectionData, function0102, (Function1) ((KFunction) rememberedValue2), startRestartGroup, ConnectionData.$stable);
                startRestartGroup.endReplaceGroup();
            } else {
                settingsComponent = component;
                startRestartGroup.startReplaceGroup(-1737449757);
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
            endRestartGroup.updateScope(new Function2() { // from class: com.miami.game.feature.settings.ui.compose.SettingsScreenKt$$ExternalSyntheticLambda16
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return SettingsScreenKt.SettingsRoute$lambda$28(SettingsComponent.this, onBackClick, onRepairGameSuccess, onRepairGameError, onNavigateDownload, onRepairGameDialog, onViceCityEnable, onViceCityInspectBeforeDisable, onViceCityKeep, onViceCityDelete, i, (Composer) obj, ((Integer) obj2).intValue());
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

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v7 */
    /* JADX WARN: Type inference failed for: r8v13 */
    public static final void SettingsScreen(final SettingsUiState uiState, final Function0<Unit> onRepairGame, final Function0<Unit> onBackClick, final Function3<? super SharedPreferences, ? super MutableState<Integer>, ? super Integer, Unit> onFontSize, final Function3<? super SharedPreferences, ? super MutableState<Integer>, ? super Integer, Unit> onPageSize, final Function2<? super SharedPreferences, ? super MutableState<Boolean>, Unit> onFullScreen, final Function2<? super SharedPreferences, ? super MutableState<Boolean>, Unit> onShowFPS, final Function1<? super Function1<? super Boolean, Unit>, Unit> onViceCityEnable, final Function1<? super Function1<? super Long, Unit>, Unit> onViceCityInspectBeforeDisable, final Function1<? super Function1<? super Boolean, Unit>, Unit> onViceCityKeep, Function1<? super Function1<? super Boolean, Unit>, Unit> onViceCityDelete, final Function2<? super SharedPreferences, ? super MutableState<Boolean>, Unit> onShowChatTime, final Function0<Unit> onBugsReport, final Function0<Unit> onShareLogs, final Function0<Unit> onLongShareLogs, final Function0<Unit> onPrivacyPolicy, final Function0<Unit> onTech, final Function3<? super SharedPreferences, ? super MutableState<Integer>, ? super Integer, Unit> onKeyboard, final Function3<? super SharedPreferences, ? super MutableState<Integer>, ? super Integer, Unit> onStreamer, final Function0<Unit> onNotification, final Function0<Unit> onDebugAutoConnectTestServer, final Function0<Unit> onDebugAutoRunTestScript, final Function0<Unit> onImportGameTestScript, final Function0<Unit> onUseBundledGameTestScript, final Function1<? super String, Unit> onSelectImportedGameTestScript, final Function1<? super String, Unit> onUpdateGameTestScreenshotPullPath, final Function0<Unit> onDebugScreenshotButton, final Function0<Unit> onDebugLogShareButton, final Function1<? super String, Unit> onUpdateGameTestScreenshotDeviceDir, Composer composer, final int i, final int i2, final int i3) {
        int i4;
        int i5;
        int i6;
        Composer composer2;
        Function1<? super Function1<? super Boolean, Unit>, Unit> function1;
        String str;
        MutableState mutableStateOf$default;
        Intrinsics.checkNotNullParameter(uiState, "uiState");
        Intrinsics.checkNotNullParameter(onRepairGame, "onRepairGame");
        Intrinsics.checkNotNullParameter(onBackClick, "onBackClick");
        Intrinsics.checkNotNullParameter(onFontSize, "onFontSize");
        Intrinsics.checkNotNullParameter(onPageSize, "onPageSize");
        Intrinsics.checkNotNullParameter(onFullScreen, "onFullScreen");
        Intrinsics.checkNotNullParameter(onShowFPS, "onShowFPS");
        Intrinsics.checkNotNullParameter(onViceCityEnable, "onViceCityEnable");
        Intrinsics.checkNotNullParameter(onViceCityInspectBeforeDisable, "onViceCityInspectBeforeDisable");
        Intrinsics.checkNotNullParameter(onViceCityKeep, "onViceCityKeep");
        Intrinsics.checkNotNullParameter(onViceCityDelete, "onViceCityDelete");
        Intrinsics.checkNotNullParameter(onShowChatTime, "onShowChatTime");
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
        Intrinsics.checkNotNullParameter(onDebugLogShareButton, "onDebugLogShareButton");
        Intrinsics.checkNotNullParameter(onUpdateGameTestScreenshotDeviceDir, "onUpdateGameTestScreenshotDeviceDir");
        Composer startRestartGroup = composer.startRestartGroup(-1090170750);
        ComposerKt.sourceInformation(startRestartGroup, "C(SettingsScreen)N(uiState,onRepairGame,onBackClick,onFontSize,onPageSize,onFullScreen,onShowFPS,onViceCityEnable,onViceCityInspectBeforeDisable,onViceCityKeep,onViceCityDelete,onShowChatTime,onBugsReport,onShareLogs,onLongShareLogs,onPrivacyPolicy,onTech,onKeyboard,onStreamer,onNotification,onDebugAutoConnectTestServer,onDebugAutoRunTestScript,onImportGameTestScript,onUseBundledGameTestScript,onSelectImportedGameTestScript,onUpdateGameTestScreenshotPullPath,onDebugScreenshotButton,onDebugLogShareButton,onUpdateGameTestScreenshotDeviceDir)173@7854L7,174@7878L60,178@7966L137,182@8124L142,186@8287L136,190@8444L132,194@8601L140,198@8764L139,202@8923L131,206@9082L218,214@9330L40,215@9409L34,216@9478L59,218@9567L588,218@9543L612,233@10217L111,233@10161L167,315@12615L282,487@21281L246,325@12917L8342,309@12448L9080:SettingsScreen.kt#1gr92h");
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
            i4 |= startRestartGroup.changedInstance(onViceCityEnable) ? 8388608 : 4194304;
        }
        if ((i & 100663296) == 0) {
            i4 |= startRestartGroup.changedInstance(onViceCityInspectBeforeDisable) ? 67108864 : GroupFlagsKt.HasAuxSlotFlag;
        }
        if ((i & 805306368) == 0) {
            i4 |= startRestartGroup.changedInstance(onViceCityKeep) ? 536870912 : 268435456;
        }
        int i7 = i4;
        if ((i2 & 6) == 0) {
            i5 = i2 | (startRestartGroup.changedInstance(onViceCityDelete) ? 4 : 2);
        } else {
            i5 = i2;
        }
        if ((i2 & 48) == 0) {
            i5 |= startRestartGroup.changedInstance(onShowChatTime) ? 32 : 16;
        }
        if ((i2 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i5 |= startRestartGroup.changedInstance(onBugsReport) ? 256 : 128;
        }
        if ((i2 & 3072) == 0) {
            i5 |= startRestartGroup.changedInstance(onShareLogs) ? 2048 : 1024;
        }
        if ((i2 & 24576) == 0) {
            i5 |= startRestartGroup.changedInstance(onLongShareLogs) ? 16384 : 8192;
        }
        if ((i2 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
            i5 |= startRestartGroup.changedInstance(onPrivacyPolicy) ? 131072 : 65536;
        }
        if ((i2 & 1572864) == 0) {
            i5 |= startRestartGroup.changedInstance(onTech) ? 1048576 : 524288;
        }
        if ((i2 & 12582912) == 0) {
            i5 |= startRestartGroup.changedInstance(onKeyboard) ? 8388608 : 4194304;
        }
        if ((i2 & 100663296) == 0) {
            i5 |= startRestartGroup.changedInstance(onStreamer) ? 67108864 : GroupFlagsKt.HasAuxSlotFlag;
        }
        if ((i2 & 805306368) == 0) {
            i5 |= startRestartGroup.changedInstance(onNotification) ? 536870912 : 268435456;
        }
        int i8 = i5;
        if ((i3 & 6) == 0) {
            i6 = i3 | (startRestartGroup.changedInstance(onDebugAutoConnectTestServer) ? 4 : 2);
        } else {
            i6 = i3;
        }
        if ((i3 & 48) == 0) {
            i6 |= startRestartGroup.changedInstance(onDebugAutoRunTestScript) ? 32 : 16;
        }
        if ((i3 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i6 |= startRestartGroup.changedInstance(onImportGameTestScript) ? 256 : 128;
        }
        if ((i3 & 3072) == 0) {
            i6 |= startRestartGroup.changedInstance(onUseBundledGameTestScript) ? 2048 : 1024;
        }
        if ((i3 & 24576) == 0) {
            i6 |= startRestartGroup.changedInstance(onSelectImportedGameTestScript) ? 16384 : 8192;
        }
        if ((i3 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
            i6 |= startRestartGroup.changedInstance(onUpdateGameTestScreenshotPullPath) ? 131072 : 65536;
        }
        if ((i3 & 1572864) == 0) {
            i6 |= startRestartGroup.changedInstance(onDebugScreenshotButton) ? 1048576 : 524288;
        }
        if ((i3 & 12582912) == 0) {
            i6 |= startRestartGroup.changedInstance(onDebugLogShareButton) ? 8388608 : 4194304;
        }
        if ((i3 & 100663296) == 0) {
            i6 |= startRestartGroup.changedInstance(onUpdateGameTestScreenshotDeviceDir) ? 67108864 : GroupFlagsKt.HasAuxSlotFlag;
        }
        if (!startRestartGroup.shouldExecute(((i7 & 306783379) == 306783378 && (306783379 & i8) == 306783378 && (i6 & 38347923) == 38347922) ? false : true, i7 & 1)) {
            composer2 = startRestartGroup;
            function1 = onViceCityDelete;
            composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1090170750, i7, i8, "com.miami.game.feature.settings.ui.compose.SettingsScreen (SettingsScreen.kt:172)");
            }
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object consume = startRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            Context context = (Context) consume;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 317977726, "CC(remember):SettingsScreen.kt#9igjgp");
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = SettingsMenuDefaults.prefs(context);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            final SharedPreferences sharedPreferences = (SharedPreferences) rememberedValue;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 317980619, "CC(remember):SettingsScreen.kt#9igjgp");
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (rememberedValue2 == Composer.Companion.getEmpty()) {
                rememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(sharedPreferences.getBoolean(SettingsMenuDefaults.KEY_FULL_SCREEN, true)), null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            final MutableState mutableState = (MutableState) rememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 317985680, "CC(remember):SettingsScreen.kt#9igjgp");
            Object rememberedValue3 = startRestartGroup.rememberedValue();
            if (rememberedValue3 == Composer.Companion.getEmpty()) {
                rememberedValue3 = SnapshotIntStateKt.mutableIntStateOf(sharedPreferences.getInt(SettingsMenuDefaults.KEY_CHAT_FONT_SIZE, 1));
                startRestartGroup.updateRememberedValue(rememberedValue3);
            }
            final MutableIntState mutableIntState = (MutableIntState) rememberedValue3;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 317990890, "CC(remember):SettingsScreen.kt#9igjgp");
            Object rememberedValue4 = startRestartGroup.rememberedValue();
            if (rememberedValue4 == Composer.Companion.getEmpty()) {
                rememberedValue4 = SnapshotIntStateKt.mutableIntStateOf(sharedPreferences.getInt(SettingsMenuDefaults.KEY_CHAT_COUNTS, 2));
                startRestartGroup.updateRememberedValue(rememberedValue4);
            }
            final MutableIntState mutableIntState2 = (MutableIntState) rememberedValue4;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 317995910, "CC(remember):SettingsScreen.kt#9igjgp");
            Object rememberedValue5 = startRestartGroup.rememberedValue();
            if (rememberedValue5 == Composer.Companion.getEmpty()) {
                rememberedValue5 = SnapshotIntStateKt.mutableIntStateOf(sharedPreferences.getInt(SettingsMenuDefaults.KEY_GAME_MODE, 0));
                startRestartGroup.updateRememberedValue(rememberedValue5);
            }
            final MutableIntState mutableIntState3 = (MutableIntState) rememberedValue5;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 318000942, "CC(remember):SettingsScreen.kt#9igjgp");
            Object rememberedValue6 = startRestartGroup.rememberedValue();
            if (rememberedValue6 == Composer.Companion.getEmpty()) {
                rememberedValue6 = SnapshotIntStateKt.mutableIntStateOf(sharedPreferences.getInt(SettingsMenuDefaults.KEY_KEYBOARD_TYPE, 0));
                startRestartGroup.updateRememberedValue(rememberedValue6);
            }
            final MutableIntState mutableIntState4 = (MutableIntState) rememberedValue6;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 318006157, "CC(remember):SettingsScreen.kt#9igjgp");
            Object rememberedValue7 = startRestartGroup.rememberedValue();
            if (rememberedValue7 == Composer.Companion.getEmpty()) {
                rememberedValue7 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(sharedPreferences.getBoolean(SettingsMenuDefaults.KEY_TIME_IN_CHAT, false)), null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue7);
            }
            final MutableState mutableState2 = (MutableState) rememberedValue7;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 318011237, "CC(remember):SettingsScreen.kt#9igjgp");
            Object rememberedValue8 = startRestartGroup.rememberedValue();
            if (rememberedValue8 == Composer.Companion.getEmpty()) {
                rememberedValue8 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(sharedPreferences.getBoolean(SettingsMenuDefaults.KEY_SHOW_FPS, false)), null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue8);
            }
            final MutableState mutableState3 = (MutableState) rememberedValue8;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 318016412, "CC(remember):SettingsScreen.kt#9igjgp");
            Object rememberedValue9 = startRestartGroup.rememberedValue();
            if (rememberedValue9 == Composer.Companion.getEmpty()) {
                rememberedValue9 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(sharedPreferences.getBoolean(SettingsMenuDefaults.KEY_VICE_CITY_ENABLED, false)), null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue9);
            }
            final MutableState mutableState4 = (MutableState) rememberedValue9;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 318024170, "CC(remember):SettingsScreen.kt#9igjgp");
            Object rememberedValue10 = startRestartGroup.rememberedValue();
            if (rememberedValue10 == Composer.Companion.getEmpty()) {
                rememberedValue10 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue10);
            }
            final MutableState mutableState5 = (MutableState) rememberedValue10;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 318026692, "CC(remember):SettingsScreen.kt#9igjgp");
            Object rememberedValue11 = startRestartGroup.rememberedValue();
            if (rememberedValue11 == Composer.Companion.getEmpty()) {
                rememberedValue11 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue11);
            }
            final MutableState mutableState6 = (MutableState) rememberedValue11;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 318028925, "CC(remember):SettingsScreen.kt#9igjgp");
            Object rememberedValue12 = startRestartGroup.rememberedValue();
            if (rememberedValue12 == Composer.Companion.getEmpty()) {
                mutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                startRestartGroup.updateRememberedValue(mutableStateOf$default);
                rememberedValue12 = mutableStateOf$default;
            }
            final MutableState mutableState7 = (MutableState) rememberedValue12;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 318032302, "CC(remember):SettingsScreen.kt#9igjgp");
            boolean changedInstance = startRestartGroup.changedInstance(sharedPreferences);
            Object rememberedValue13 = startRestartGroup.rememberedValue();
            if (changedInstance || rememberedValue13 == Composer.Companion.getEmpty()) {
                rememberedValue13 = new Function1() { // from class: com.miami.game.feature.settings.ui.compose.SettingsScreenKt$$ExternalSyntheticLambda24
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        DisposableEffectResult SettingsScreen$lambda$12$0;
                        SettingsScreen$lambda$12$0 = SettingsScreenKt.SettingsScreen$lambda$12$0(sharedPreferences, mutableState4, (DisposableEffectScope) obj);
                        return SettingsScreen$lambda$12$0;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue13);
            }
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            EffectsKt.DisposableEffect(sharedPreferences, (Function1) rememberedValue13, startRestartGroup, 0);
            boolean z = mutableState5.getValue() != null;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 318052625, "CC(remember):SettingsScreen.kt#9igjgp");
            Object rememberedValue14 = startRestartGroup.rememberedValue();
            if (rememberedValue14 == Composer.Companion.getEmpty()) {
                rememberedValue14 = new Function0() { // from class: com.miami.game.feature.settings.ui.compose.SettingsScreenKt$$ExternalSyntheticLambda25
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit SettingsScreen$lambda$13$0;
                        SettingsScreen$lambda$13$0 = SettingsScreenKt.SettingsScreen$lambda$13$0(MutableState.this, mutableState5);
                        return SettingsScreen$lambda$13$0;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue14);
            }
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            BackHandlerKt.BackHandler(z, (Function0) rememberedValue14, startRestartGroup, 48, 0);
            Function0 function0 = null;
            boolean z2 = true;
            ScaffoldKt.m2850ScaffoldTvnljyQ(SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, null), ComposableLambdaKt.rememberComposableLambda(-707845306, true, new Function2() { // from class: com.miami.game.feature.settings.ui.compose.SettingsScreenKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return SettingsScreenKt.SettingsScreen$lambda$18(SettingsUiState.this, onRepairGame, onBackClick, onBugsReport, onTech, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, startRestartGroup, 54), ComposableLambdaKt.rememberComposableLambda(-1038292793, true, new Function2() { // from class: com.miami.game.feature.settings.ui.compose.SettingsScreenKt$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return SettingsScreenKt.SettingsScreen$lambda$19(Function0.this, onShareLogs, onPrivacyPolicy, onLongShareLogs, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, startRestartGroup, 54), null, null, 0, Color.Companion.m5383getTransparent0d7_KjU(), 0L, null, ComposableLambdaKt.rememberComposableLambda(1403536529, true, new Function3() { // from class: com.miami.game.feature.settings.ui.compose.SettingsScreenKt$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return SettingsScreenKt.SettingsScreen$lambda$20(SettingsUiState.this, onImportGameTestScript, onUseBundledGameTestScript, onSelectImportedGameTestScript, onUpdateGameTestScreenshotPullPath, onDebugScreenshotButton, onDebugLogShareButton, onUpdateGameTestScreenshotDeviceDir, onFontSize, mutableIntState, sharedPreferences, onPageSize, mutableIntState2, onStreamer, mutableIntState3, onKeyboard, mutableIntState4, mutableState, onFullScreen, mutableState2, onShowChatTime, onNotification, mutableState3, onShowFPS, mutableState7, mutableState4, onViceCityEnable, onViceCityInspectBeforeDisable, mutableState6, mutableState5, onDebugAutoConnectTestServer, onDebugAutoRunTestScript, (PaddingValues) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, startRestartGroup, 54), startRestartGroup, 806879670, 440);
            composer2 = startRestartGroup;
            final ModsInstructionsActions modsInstructionsActions = (ModsInstructionsActions) mutableState7.getValue();
            if (modsInstructionsActions != null) {
                composer2.startReplaceGroup(1280966525);
                ComposerKt.sourceInformation(composer2, "*499@21681L106,509@22023L40,497@21590L484");
                boolean isArizona = uiState.isArizona();
                final Function0<Unit> onDebugMode = modsInstructionsActions.getOnDebugMode();
                if (onDebugMode != null) {
                    composer2.startReplaceGroup(1589469341);
                    ComposerKt.sourceInformation(composer2, "*504@21873L110");
                    str = "CC(remember):SettingsScreen.kt#9igjgp";
                    ComposerKt.sourceInformationMarkerStart(composer2, -101548213, str);
                    boolean changed = composer2.changed(onDebugMode);
                    Object rememberedValue15 = composer2.rememberedValue();
                    if (changed || rememberedValue15 == Composer.Companion.getEmpty()) {
                        rememberedValue15 = new Function0() { // from class: com.miami.game.feature.settings.ui.compose.SettingsScreenKt$$ExternalSyntheticLambda4
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                Unit SettingsScreen$lambda$21$0$0$0;
                                SettingsScreen$lambda$21$0$0$0 = SettingsScreenKt.SettingsScreen$lambda$21$0$0$0(MutableState.this, onDebugMode);
                                return SettingsScreen$lambda$21$0$0$0;
                            }
                        };
                        composer2.updateRememberedValue(rememberedValue15);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    composer2.endReplaceGroup();
                    function0 = rememberedValue15;
                } else {
                    composer2.startReplaceGroup(1589469340);
                    composer2.endReplaceGroup();
                    str = "CC(remember):SettingsScreen.kt#9igjgp";
                }
                ComposerKt.sourceInformationMarkerStart(composer2, 605457518, str);
                boolean changedInstance2 = composer2.changedInstance(modsInstructionsActions);
                Object rememberedValue16 = composer2.rememberedValue();
                if (changedInstance2 || rememberedValue16 == Composer.Companion.getEmpty()) {
                    rememberedValue16 = new Function0() { // from class: com.miami.game.feature.settings.ui.compose.SettingsScreenKt$$ExternalSyntheticLambda5
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit SettingsScreen$lambda$21$1$0;
                            SettingsScreen$lambda$21$1$0 = SettingsScreenKt.SettingsScreen$lambda$21$1$0(MutableState.this, modsInstructionsActions);
                            return SettingsScreen$lambda$21$1$0;
                        }
                    };
                    composer2.updateRememberedValue(rememberedValue16);
                }
                Function0 function02 = rememberedValue16;
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerStart(composer2, 605468396, str);
                Object rememberedValue17 = composer2.rememberedValue();
                if (rememberedValue17 == Composer.Companion.getEmpty()) {
                    rememberedValue17 = new Function0() { // from class: com.miami.game.feature.settings.ui.compose.SettingsScreenKt$$ExternalSyntheticLambda6
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit SettingsScreen$lambda$21$2$0;
                            SettingsScreen$lambda$21$2$0 = SettingsScreenKt.SettingsScreen$lambda$21$2$0(MutableState.this);
                            return SettingsScreen$lambda$21$2$0;
                        }
                    };
                    composer2.updateRememberedValue(rememberedValue17);
                }
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ModsInstructionsDialogKt.ModsInstructionsDialog(isArizona, function02, (Function0) rememberedValue17, function0, composer2, RendererCapabilities.DECODER_SUPPORT_MASK, 0);
                composer2 = composer2;
                Unit unit = Unit.INSTANCE;
                composer2.endReplaceGroup();
                Unit unit2 = Unit.INSTANCE;
            } else {
                composer2.startReplaceGroup(1280966524);
                composer2.endReplaceGroup();
                str = "CC(remember):SettingsScreen.kt#9igjgp";
            }
            Long l = (Long) mutableState5.getValue();
            if (l != null) {
                composer2.startReplaceGroup(1281504592);
                ComposerKt.sourceInformation(composer2, "*517@22272L22,518@22320L143,514@22134L340");
                long longValue = l.longValue();
                boolean booleanValue = ((Boolean) mutableState6.getValue()).booleanValue();
                ComposerKt.sourceInformationMarkerStart(composer2, -1022207684, str);
                if ((i8 & 14) != 4) {
                    z2 = false;
                }
                SettingsScreenKt$SettingsScreen$7$1$1 rememberedValue18 = composer2.rememberedValue();
                if (z2 || rememberedValue18 == Composer.Companion.getEmpty()) {
                    function1 = onViceCityDelete;
                    rememberedValue18 = new SettingsScreenKt$SettingsScreen$7$1$1(mutableState6, function1, mutableState4, mutableState5);
                    composer2.updateRememberedValue(rememberedValue18);
                } else {
                    function1 = onViceCityDelete;
                }
                ComposerKt.sourceInformationMarkerEnd(composer2);
                Function0 function03 = (Function0) ((KFunction) rememberedValue18);
                ComposerKt.sourceInformationMarkerStart(composer2, -1022206027, str);
                Object rememberedValue19 = composer2.rememberedValue();
                if (rememberedValue19 == Composer.Companion.getEmpty()) {
                    rememberedValue19 = new Function0() { // from class: com.miami.game.feature.settings.ui.compose.SettingsScreenKt$$ExternalSyntheticLambda7
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit SettingsScreen$lambda$22$1$0;
                            SettingsScreen$lambda$22$1$0 = SettingsScreenKt.SettingsScreen$lambda$22$1$0(MutableState.this, mutableState5);
                            return SettingsScreen$lambda$22$1$0;
                        }
                    };
                    composer2.updateRememberedValue(rememberedValue19);
                }
                ComposerKt.sourceInformationMarkerEnd(composer2);
                Composer composer3 = composer2;
                ViceCityDisableDialog(longValue, booleanValue, function03, (Function0) rememberedValue19, composer3, 3072);
                composer2 = composer3;
                Unit unit3 = Unit.INSTANCE;
                composer2.endReplaceGroup();
                Unit unit4 = Unit.INSTANCE;
            } else {
                composer2.startReplaceGroup(1281504591);
                composer2.endReplaceGroup();
                function1 = onViceCityDelete;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Function1<? super Function1<? super Boolean, Unit>, Unit> function12 = function1;
            endRestartGroup.updateScope(new Function2() { // from class: com.miami.game.feature.settings.ui.compose.SettingsScreenKt$$ExternalSyntheticLambda8
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return SettingsScreenKt.SettingsScreen$lambda$23(SettingsUiState.this, onRepairGame, onBackClick, onFontSize, onPageSize, onFullScreen, onShowFPS, onViceCityEnable, onViceCityInspectBeforeDisable, onViceCityKeep, function12, onShowChatTime, onBugsReport, onShareLogs, onLongShareLogs, onPrivacyPolicy, onTech, onKeyboard, onStreamer, onNotification, onDebugAutoConnectTestServer, onDebugAutoRunTestScript, onImportGameTestScript, onUseBundledGameTestScript, onSelectImportedGameTestScript, onUpdateGameTestScreenshotPullPath, onDebugScreenshotButton, onDebugLogShareButton, onUpdateGameTestScreenshotDeviceDir, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DisposableEffectResult SettingsScreen$lambda$12$0(final SharedPreferences sharedPreferences, final MutableState mutableState, DisposableEffectScope DisposableEffect) {
        Intrinsics.checkNotNullParameter(DisposableEffect, "$this$DisposableEffect");
        final SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener = new SharedPreferences.OnSharedPreferenceChangeListener() { // from class: com.miami.game.feature.settings.ui.compose.SettingsScreenKt$$ExternalSyntheticLambda13
            @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
            public final void onSharedPreferenceChanged(SharedPreferences sharedPreferences2, String str) {
                SettingsScreenKt.SettingsScreen$lambda$12$0$0(MutableState.this, sharedPreferences2, str);
            }
        };
        sharedPreferences.registerOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
        return new DisposableEffectResult() { // from class: com.miami.game.feature.settings.ui.compose.SettingsScreenKt$SettingsScreen$lambda$12$0$$inlined$onDispose$1
            @Override // androidx.compose.runtime.DisposableEffectResult
            public void dispose() {
                sharedPreferences.unregisterOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void SettingsScreen$lambda$12$0$0(MutableState mutableState, SharedPreferences sharedPreferences, String str) {
        if (str != null && str.hashCode() == -896581183 && str.equals(SettingsMenuDefaults.KEY_VICE_CITY_ENABLED)) {
            mutableState.setValue(Boolean.valueOf(sharedPreferences.getBoolean(SettingsMenuDefaults.KEY_VICE_CITY_ENABLED, false)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SettingsScreen$lambda$13$0(MutableState mutableState, MutableState mutableState2) {
        if (!((Boolean) mutableState.getValue()).booleanValue()) {
            mutableState2.setValue(null);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void SettingsScreen$handleViceCitySwitchClick(final MutableState<Boolean> mutableState, final MutableState<Boolean> mutableState2, Function1<? super Function1<? super Boolean, Unit>, Unit> function1, Function1<? super Function1<? super Long, Unit>, Unit> function12, final MutableState<Long> mutableState3) {
        if (mutableState.getValue().booleanValue()) {
            return;
        }
        if (!mutableState2.getValue().booleanValue()) {
            mutableState.setValue(true);
            function1.invoke(new Function1() { // from class: com.miami.game.feature.settings.ui.compose.SettingsScreenKt$$ExternalSyntheticLambda10
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return SettingsScreenKt.SettingsScreen$handleViceCitySwitchClick$lambda$14(MutableState.this, mutableState2, ((Boolean) obj).booleanValue());
                }
            });
            return;
        }
        mutableState.setValue(true);
        function12.invoke(new Function1() { // from class: com.miami.game.feature.settings.ui.compose.SettingsScreenKt$$ExternalSyntheticLambda12
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return SettingsScreenKt.SettingsScreen$handleViceCitySwitchClick$lambda$15(MutableState.this, mutableState2, mutableState3, (Long) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit SettingsScreen$handleViceCitySwitchClick$lambda$14(MutableState mutableState, MutableState mutableState2, boolean z) {
        mutableState.setValue(false);
        if (z) {
            mutableState2.setValue(true);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit SettingsScreen$handleViceCitySwitchClick$lambda$15(MutableState mutableState, MutableState mutableState2, MutableState mutableState3, Long l) {
        if (l == null) {
            mutableState.setValue(false);
        } else if (l.longValue() == 0) {
            mutableState.setValue(false);
            mutableState2.setValue(false);
        } else if (l.longValue() > 0) {
            mutableState.setValue(false);
            mutableState3.setValue(l);
        } else {
            mutableState.setValue(false);
        }
        return Unit.INSTANCE;
    }

    private static final void SettingsScreen$handleViceCityKeep(final MutableState<Boolean> mutableState, Function1<? super Function1<? super Boolean, Unit>, Unit> function1, final MutableState<Boolean> mutableState2, final MutableState<Long> mutableState3) {
        if (mutableState.getValue().booleanValue()) {
            return;
        }
        mutableState.setValue(true);
        function1.invoke(new Function1() { // from class: com.miami.game.feature.settings.ui.compose.SettingsScreenKt$$ExternalSyntheticLambda17
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return SettingsScreenKt.SettingsScreen$handleViceCityKeep$lambda$16(MutableState.this, mutableState2, mutableState3, ((Boolean) obj).booleanValue());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit SettingsScreen$handleViceCityKeep$lambda$16(MutableState mutableState, MutableState mutableState2, MutableState mutableState3, boolean z) {
        mutableState.setValue(false);
        if (z) {
            mutableState2.setValue(false);
        }
        mutableState3.setValue(null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void SettingsScreen$handleViceCityDelete(final MutableState<Boolean> mutableState, Function1<? super Function1<? super Boolean, Unit>, Unit> function1, final MutableState<Boolean> mutableState2, final MutableState<Long> mutableState3) {
        if (mutableState.getValue().booleanValue()) {
            return;
        }
        mutableState.setValue(true);
        function1.invoke(new Function1() { // from class: com.miami.game.feature.settings.ui.compose.SettingsScreenKt$$ExternalSyntheticLambda9
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return SettingsScreenKt.SettingsScreen$handleViceCityDelete$lambda$17(MutableState.this, mutableState2, mutableState3, ((Boolean) obj).booleanValue());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit SettingsScreen$handleViceCityDelete$lambda$17(MutableState mutableState, MutableState mutableState2, MutableState mutableState3, boolean z) {
        mutableState.setValue(false);
        if (z) {
            mutableState2.setValue(false);
        }
        mutableState3.setValue(null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit SettingsScreen$lambda$18(SettingsUiState settingsUiState, Function0 function0, Function0 function02, Function0 function03, Function0 function04, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C316@12629L258:SettingsScreen.kt#1gr92h");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-707845306, i, -1, "com.miami.game.feature.settings.ui.compose.SettingsScreen.<anonymous> (SettingsScreen.kt:316)");
            }
            SettingsTopBarKt.SettingsTopBar(settingsUiState, Modifier.Companion, function0, function02, function03, function04, composer, 48);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit SettingsScreen$lambda$20(final SettingsUiState settingsUiState, Function0 function0, Function0 function02, Function1 function1, Function1 function12, Function0 function03, Function0 function04, Function1 function13, Function3 function3, MutableIntState mutableIntState, final SharedPreferences sharedPreferences, Function3 function32, MutableIntState mutableIntState2, Function3 function33, MutableIntState mutableIntState3, Function3 function34, MutableIntState mutableIntState4, final MutableState mutableState, final Function2 function2, final MutableState mutableState2, final Function2 function22, Function0 function05, final MutableState mutableState3, final Function2 function23, final MutableState mutableState4, final MutableState mutableState5, final Function1 function14, final Function1 function15, final MutableState mutableState6, final MutableState mutableState7, Function0 function06, Function0 function07, PaddingValues padding, Composer composer, int i) {
        String debugImportedTestScriptName;
        Intrinsics.checkNotNullParameter(padding, "padding");
        ComposerKt.sourceInformation(composer, "CN(padding)327@12943L189,335@13146L8103:SettingsScreen.kt#1gr92h");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1403536529, i, -1, "com.miami.game.feature.settings.ui.compose.SettingsScreen.<anonymous> (SettingsScreen.kt:327)");
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
            ComposerKt.sourceInformationMarkerStart(composer, 2037018089, "C343@13446L21,344@13484L7751:SettingsScreen.kt#1gr92h");
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
            ComposerKt.sourceInformationMarkerStart(composer, 838975417, "C359@14057L36,356@13932L7285:SettingsScreen.kt#1gr92h");
            Modifier verticalScroll$default = ScrollKt.verticalScroll$default(ScrollBarKt.fadingTopBottomEdgesSimplified$default(ScrollBarKt.m9837verticalColumnScrollbarosbwsH8(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, null), rememberScrollState, 0.0f, false, 0.0f, 0.0f, composer, 6, 30), rememberScrollState, 0.0f, 0.0f, 6, null), rememberScrollState, false, null, false, 14, null);
            ComposerKt.sourceInformationMarkerStart(composer, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            MeasurePolicy columnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.m742spacedBy0680j_4(Dp.m8160constructorimpl(8.0f)), Alignment.Companion.getStart(), composer, 6);
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
            ComposerKt.sourceInformationMarkerStart(composer, 142769573, "C365@14348L40,366@14413L1060,391@15498L2834,482@21154L41:SettingsScreen.kt#1gr92h");
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
            ComposerKt.sourceInformationMarkerStart(composer, -1015880327, "C370@14646L177,375@14852L175,380@15056L179,385@15264L183:SettingsScreen.kt#1gr92h");
            SettingsRowsKt.ChatFontSize(function3, mutableIntState, sharedPreferences, null, composer, 48, 8);
            SettingsRowsKt.FontsCount(function32, mutableIntState2, sharedPreferences, null, composer, 48, 8);
            SettingsRowsKt.StreamerSwitch(function33, mutableIntState3, sharedPreferences, null, composer, 48, 8);
            SettingsRowsKt.KeyboardSwitch(function34, mutableIntState4, sharedPreferences, null, composer, 48, 8);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            MeasurePolicy columnMeasurePolicy4 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.m742spacedBy0680j_4(Dp.m8160constructorimpl(8.0f)), Alignment.Companion.getStart(), composer, 6);
            ComposerKt.sourceInformationMarkerStart(composer, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
            int hashCode5 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap5 = composer.getCurrentCompositionLocalMap();
            Modifier materializeModifier5 = ComposedModifierKt.materializeModifier(composer, Modifier.Companion);
            Function0<ComposeUiNode> constructor5 = ComposeUiNode.Companion.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)410@16187L9:Composables.kt#9igjgp");
            if (!(composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer.startReusableNode();
            if (composer.getInserting()) {
                composer.createNode(constructor5);
            } else {
                composer.useNode();
            }
            Composer m4467constructorimpl5 = Updater.m4467constructorimpl(composer);
            Updater.m4475setimpl(m4467constructorimpl5, columnMeasurePolicy4, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m4475setimpl(m4467constructorimpl5, currentCompositionLocalMap5, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.m4475setimpl(m4467constructorimpl5, Integer.valueOf(hashCode5), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.m4473reconcileimpl(m4467constructorimpl5, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.m4475setimpl(m4467constructorimpl5, materializeModifier5, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScopeInstance columnScopeInstance4 = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, 1324240048, "C392@15585L2106,433@17791L38,434@17861L445,432@17720L586:SettingsScreen.kt#1gr92h");
            ComposerKt.sourceInformationMarkerStart(composer, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.m742spacedBy0680j_4(Dp.m8160constructorimpl(12.0f)), Alignment.Companion.getTop(), composer, 6);
            ComposerKt.sourceInformationMarkerStart(composer, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
            int hashCode6 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap6 = composer.getCurrentCompositionLocalMap();
            Modifier materializeModifier6 = ComposedModifierKt.materializeModifier(composer, Modifier.Companion);
            Function0<ComposeUiNode> constructor6 = ComposeUiNode.Companion.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)410@16187L9:Composables.kt#9igjgp");
            if (!(composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer.startReusableNode();
            if (composer.getInserting()) {
                composer.createNode(constructor6);
            } else {
                composer.useNode();
            }
            Composer m4467constructorimpl6 = Updater.m4467constructorimpl(composer);
            Updater.m4475setimpl(m4467constructorimpl6, rowMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m4475setimpl(m4467constructorimpl6, currentCompositionLocalMap6, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.m4475setimpl(m4467constructorimpl6, Integer.valueOf(hashCode6), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.m4473reconcileimpl(m4467constructorimpl6, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.m4475setimpl(m4467constructorimpl6, materializeModifier6, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, -341531918, "C395@15738L1002,414@16773L888:SettingsScreen.kt#1gr92h");
            ComposerKt.sourceInformationMarkerStart(composer, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            MeasurePolicy columnMeasurePolicy5 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.m742spacedBy0680j_4(Dp.m8160constructorimpl(8.0f)), Alignment.Companion.getStart(), composer, 6);
            ComposerKt.sourceInformationMarkerStart(composer, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
            int hashCode7 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap7 = composer.getCurrentCompositionLocalMap();
            Modifier materializeModifier7 = ComposedModifierKt.materializeModifier(composer, Modifier.Companion);
            Function0<ComposeUiNode> constructor7 = ComposeUiNode.Companion.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)410@16187L9:Composables.kt#9igjgp");
            if (!(composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer.startReusableNode();
            if (composer.getInserting()) {
                composer.createNode(constructor7);
            } else {
                composer.useNode();
            }
            Composer m4467constructorimpl7 = Updater.m4467constructorimpl(composer);
            Updater.m4475setimpl(m4467constructorimpl7, columnMeasurePolicy5, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m4475setimpl(m4467constructorimpl7, currentCompositionLocalMap7, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.m4475setimpl(m4467constructorimpl7, Integer.valueOf(hashCode7), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.m4473reconcileimpl(m4467constructorimpl7, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.m4475setimpl(m4467constructorimpl7, materializeModifier7, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScopeInstance columnScopeInstance5 = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, -1482545823, "C402@16153L124,399@15960L355,409@16547L121,406@16352L354:SettingsScreen.kt#1gr92h");
            boolean booleanValue = ((Boolean) mutableState.getValue()).booleanValue();
            ComposerKt.sourceInformationMarkerStart(composer, 922012820, "CC(remember):SettingsScreen.kt#9igjgp");
            boolean changed = composer.changed(function2) | composer.changedInstance(sharedPreferences);
            Object rememberedValue = composer.rememberedValue();
            if (changed || rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new Function0() { // from class: com.miami.game.feature.settings.ui.compose.SettingsScreenKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit SettingsScreen$lambda$20$0$0$0$1$0$0$0$0;
                        SettingsScreen$lambda$20$0$0$0$1$0$0$0$0 = SettingsScreenKt.SettingsScreen$lambda$20$0$0$0$1$0$0$0$0(Function2.this, sharedPreferences, mutableState);
                        return SettingsScreen$lambda$20$0$0$0$1$0$0$0$0;
                    }
                };
                composer.updateRememberedValue(rememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            SwitchButtonKt.SwitchButton("ПОЛНЫЙ ЭКРАН", (Function0) rememberedValue, booleanValue, composer, 6);
            boolean booleanValue2 = ((Boolean) mutableState2.getValue()).booleanValue();
            ComposerKt.sourceInformationMarkerStart(composer, 922025425, "CC(remember):SettingsScreen.kt#9igjgp");
            boolean changed2 = composer.changed(function22) | composer.changedInstance(sharedPreferences);
            Object rememberedValue2 = composer.rememberedValue();
            if (changed2 || rememberedValue2 == Composer.Companion.getEmpty()) {
                rememberedValue2 = new Function0() { // from class: com.miami.game.feature.settings.ui.compose.SettingsScreenKt$$ExternalSyntheticLambda11
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit SettingsScreen$lambda$20$0$0$0$1$0$0$1$0;
                        SettingsScreen$lambda$20$0$0$0$1$0$0$1$0 = SettingsScreenKt.SettingsScreen$lambda$20$0$0$0$1$0$0$1$0(Function2.this, sharedPreferences, mutableState2);
                        return SettingsScreen$lambda$20$0$0$0$1$0$0$1$0;
                    }
                };
                composer.updateRememberedValue(rememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            SwitchButtonKt.SwitchButton("ДАТА И ВРЕМЯ В ЧАТЕ", (Function0) rememberedValue2, booleanValue2, composer, 6);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            MeasurePolicy columnMeasurePolicy6 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.m742spacedBy0680j_4(Dp.m8160constructorimpl(8.0f)), Alignment.Companion.getStart(), composer, 6);
            ComposerKt.sourceInformationMarkerStart(composer, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
            int hashCode8 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap8 = composer.getCurrentCompositionLocalMap();
            Modifier materializeModifier8 = ComposedModifierKt.materializeModifier(composer, Modifier.Companion);
            Function0<ComposeUiNode> constructor8 = ComposeUiNode.Companion.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)410@16187L9:Composables.kt#9igjgp");
            if (!(composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer.startReusableNode();
            if (composer.getInserting()) {
                composer.createNode(constructor8);
            } else {
                composer.useNode();
            }
            Composer m4467constructorimpl8 = Updater.m4467constructorimpl(composer);
            Updater.m4475setimpl(m4467constructorimpl8, columnMeasurePolicy6, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m4475setimpl(m4467constructorimpl8, currentCompositionLocalMap8, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.m4475setimpl(m4467constructorimpl8, Integer.valueOf(hashCode8), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.m4473reconcileimpl(m4467constructorimpl8, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.m4475setimpl(m4467constructorimpl8, materializeModifier8, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScopeInstance columnScopeInstance6 = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, -463958326, "C418@16995L257,426@17476L113,423@17289L338:SettingsScreen.kt#1gr92h");
            SwitchButtonKt.SwitchButton("УВЕДОМЛЕНИЯ", function05, settingsUiState.getSettingState().getNotifications(), composer, 6);
            boolean booleanValue3 = ((Boolean) mutableState3.getValue()).booleanValue();
            ComposerKt.sourceInformationMarkerStart(composer, -1400424846, "CC(remember):SettingsScreen.kt#9igjgp");
            boolean changed3 = composer.changed(function23) | composer.changedInstance(sharedPreferences);
            Object rememberedValue3 = composer.rememberedValue();
            if (changed3 || rememberedValue3 == Composer.Companion.getEmpty()) {
                rememberedValue3 = new Function0() { // from class: com.miami.game.feature.settings.ui.compose.SettingsScreenKt$$ExternalSyntheticLambda18
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit SettingsScreen$lambda$20$0$0$0$1$0$1$0$0;
                        SettingsScreen$lambda$20$0$0$0$1$0$1$0$0 = SettingsScreenKt.SettingsScreen$lambda$20$0$0$0$1$0$1$0$0(Function2.this, sharedPreferences, mutableState3);
                        return SettingsScreen$lambda$20$0$0$0$1$0$1$0$0;
                    }
                };
                composer.updateRememberedValue(rememberedValue3);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            SwitchButtonKt.SwitchButton("ОТОБРАЖАТЬ FPS", (Function0) rememberedValue3, booleanValue3, composer, 6);
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
            ComposerKt.sourceInformationMarkerStart(composer, -1896877320, "CC(remember):SettingsScreen.kt#9igjgp");
            Object rememberedValue4 = composer.rememberedValue();
            if (rememberedValue4 == Composer.Companion.getEmpty()) {
                rememberedValue4 = new Function1() { // from class: com.miami.game.feature.settings.ui.compose.SettingsScreenKt$$ExternalSyntheticLambda19
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit SettingsScreen$lambda$20$0$0$0$1$1$0;
                        SettingsScreen$lambda$20$0$0$0$1$1$0 = SettingsScreenKt.SettingsScreen$lambda$20$0$0$0$1$1$0(MutableState.this, (ModsInstructionsActions) obj);
                        return SettingsScreen$lambda$20$0$0$0$1$1$0;
                    }
                };
                composer.updateRememberedValue(rememberedValue4);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            ModsSettingsKt.ModsSettings((Function1) rememberedValue4, false, ComposableLambdaKt.rememberComposableLambda(2073059631, true, new Function2() { // from class: com.miami.game.feature.settings.ui.compose.SettingsScreenKt$$ExternalSyntheticLambda20
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit SettingsScreen$lambda$20$0$0$0$1$2;
                    SettingsScreen$lambda$20$0$0$0$1$2 = SettingsScreenKt.SettingsScreen$lambda$20$0$0$0$1$2(SettingsUiState.this, mutableState5, function14, function15, mutableState6, mutableState7, (Composer) obj, ((Integer) obj2).intValue());
                    return SettingsScreen$lambda$20$0$0$0$1$2;
                }
            }, composer, 54), composer, 390, 2);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            if (!settingsUiState.isDebug()) {
                composer.startReplaceGroup(149284067);
                composer.endReplaceGroup();
            } else {
                composer.startReplaceGroup(146640356);
                ComposerKt.sourceInformation(composer, "445@18408L704,464@19593L1510");
                ComposerKt.sourceInformationMarkerStart(composer, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                MeasurePolicy columnMeasurePolicy7 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.m742spacedBy0680j_4(Dp.m8160constructorimpl(8.0f)), Alignment.Companion.getStart(), composer, 6);
                ComposerKt.sourceInformationMarkerStart(composer, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
                int hashCode9 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
                CompositionLocalMap currentCompositionLocalMap9 = composer.getCurrentCompositionLocalMap();
                Modifier materializeModifier9 = ComposedModifierKt.materializeModifier(composer, Modifier.Companion);
                Function0<ComposeUiNode> constructor9 = ComposeUiNode.Companion.getConstructor();
                ComposerKt.sourceInformationMarkerStart(composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)410@16187L9:Composables.kt#9igjgp");
                if (!(composer.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composer.startReusableNode();
                if (composer.getInserting()) {
                    composer.createNode(constructor9);
                } else {
                    composer.useNode();
                }
                Composer m4467constructorimpl9 = Updater.m4467constructorimpl(composer);
                Updater.m4475setimpl(m4467constructorimpl9, columnMeasurePolicy7, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.m4475setimpl(m4467constructorimpl9, currentCompositionLocalMap9, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Updater.m4475setimpl(m4467constructorimpl9, Integer.valueOf(hashCode9), ComposeUiNode.Companion.getSetCompositeKeyHash());
                Updater.m4473reconcileimpl(m4467constructorimpl9, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                Updater.m4475setimpl(m4467constructorimpl9, materializeModifier9, ComposeUiNode.Companion.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composer, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
                ColumnScopeInstance columnScopeInstance7 = ColumnScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composer, -1117369490, "C446@18499L281,451@18813L269:SettingsScreen.kt#1gr92h");
                SwitchButtonKt.SwitchButton("AUTO CONNECT TEST SERVER", function06, settingsUiState.getSettingState().getDebugAutoConnectTestServer(), composer, 6);
                SwitchButtonKt.SwitchButton("AUTO RUN TEST SCRIPT", function07, settingsUiState.getSettingState().getDebugAutoRunTestScript(), composer, 6);
                ComposerKt.sourceInformationMarkerEnd(composer);
                ComposerKt.sourceInformationMarkerEnd(composer);
                composer.endNode();
                ComposerKt.sourceInformationMarkerEnd(composer);
                ComposerKt.sourceInformationMarkerEnd(composer);
                ComposerKt.sourceInformationMarkerEnd(composer);
                String str = "default_game_test_script.json";
                if (settingsUiState.getSettingState().getDebugUseImportedTestScript() && (debugImportedTestScriptName = settingsUiState.getSettingState().getDebugImportedTestScriptName()) != null) {
                    if (StringsKt.isBlank(debugImportedTestScriptName)) {
                        debugImportedTestScriptName = null;
                    }
                    if (debugImportedTestScriptName != null) {
                        str = debugImportedTestScriptName;
                    }
                }
                DebugGameTestScriptCardKt.DebugGameTestScriptCard(str, settingsUiState.getSettingState().getDebugUseImportedTestScript(), settingsUiState.getSettingState().getDebugImportedTestScripts(), settingsUiState.getSettingState().getDebugActiveImportedTestScriptFileName(), settingsUiState.getSettingState().getDebugGameTestScreenshotPullPath(), settingsUiState.getSettingState().getDebugGameTestScreenshotButtonEnabled(), settingsUiState.getSettingState().getDebugGameTestLogShareButtonEnabled(), settingsUiState.getSettingState().getDebugGameTestScreenshotDeviceDir(), function0, function02, function1, function12, function03, function04, function13, composer, 0, 0);
                composer.endReplaceGroup();
            }
            SpacerKt.Spacer(SizeKt.m1103height3ABfNKs(Modifier.Companion, Dp.m8160constructorimpl(20.0f)), composer, 6);
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

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SettingsScreen$lambda$20$0$0$0$1$0$0$0$0(Function2 function2, SharedPreferences sharedPreferences, MutableState mutableState) {
        function2.invoke(sharedPreferences, mutableState);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SettingsScreen$lambda$20$0$0$0$1$0$0$1$0(Function2 function2, SharedPreferences sharedPreferences, MutableState mutableState) {
        function2.invoke(sharedPreferences, mutableState);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SettingsScreen$lambda$20$0$0$0$1$0$1$0$0(Function2 function2, SharedPreferences sharedPreferences, MutableState mutableState) {
        function2.invoke(sharedPreferences, mutableState);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SettingsScreen$lambda$20$0$0$0$1$1$0(MutableState mutableState, ModsInstructionsActions it) {
        Intrinsics.checkNotNullParameter(it, "it");
        mutableState.setValue(it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SettingsScreen$lambda$20$0$0$0$1$2(SettingsUiState settingsUiState, MutableState mutableState, Function1 function1, Function1 function12, MutableState mutableState2, MutableState mutableState3, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C:SettingsScreen.kt#1gr92h");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2073059631, i, -1, "com.miami.game.feature.settings.ui.compose.SettingsScreen.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (SettingsScreen.kt:435)");
            }
            if (settingsUiState.isArizona()) {
                composer.startReplaceGroup(1184821045);
                ComposerKt.sourceInformation(composer, "437@18010L41,439@18176L27,436@17956L286");
                String stringResource = StringResources_androidKt.stringResource(R.string.enable_vice_city, composer, 0);
                boolean booleanValue = ((Boolean) mutableState.getValue()).booleanValue();
                ComposerKt.sourceInformationMarkerStart(composer, -654509846, "CC(remember):SettingsScreen.kt#9igjgp");
                boolean changed = composer.changed(function1) | composer.changed(function12);
                SettingsScreenKt$SettingsScreen$5$1$1$1$2$3$1$1 rememberedValue = composer.rememberedValue();
                if (changed || rememberedValue == Composer.Companion.getEmpty()) {
                    rememberedValue = new SettingsScreenKt$SettingsScreen$5$1$1$1$2$3$1$1(mutableState2, mutableState, function1, function12, mutableState3);
                    composer.updateRememberedValue(rememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composer);
                SwitchButtonKt.SwitchButton(stringResource, (Function0) ((KFunction) rememberedValue), booleanValue, composer, 0);
                composer.endReplaceGroup();
            } else {
                composer.startReplaceGroup(1185129619);
                composer.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit SettingsScreen$lambda$19(Function0 function0, Function0 function02, Function0 function03, Function0 function04, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C488@21295L222:SettingsScreen.kt#1gr92h");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1038292793, i, -1, "com.miami.game.feature.settings.ui.compose.SettingsScreen.<anonymous> (SettingsScreen.kt:488)");
            }
            SettingsBottomBarKt.SettingsBottomBar(function0, function02, function03, function04, composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SettingsScreen$lambda$21$1$0(MutableState mutableState, ModsInstructionsActions modsInstructionsActions) {
        mutableState.setValue(null);
        modsInstructionsActions.getOnConfigure().invoke();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SettingsScreen$lambda$21$0$0$0(MutableState mutableState, Function0 function0) {
        mutableState.setValue(null);
        function0.invoke();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SettingsScreen$lambda$21$2$0(MutableState mutableState) {
        mutableState.setValue(null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SettingsScreen$lambda$22$1$0(MutableState mutableState, MutableState mutableState2) {
        if (!((Boolean) mutableState.getValue()).booleanValue()) {
            mutableState2.setValue(null);
        }
        return Unit.INSTANCE;
    }

    private static final void ViceCityDisableDialog(final long j, final boolean z, final Function0<Unit> function0, final Function0<Unit> function02, Composer composer, final int i) {
        int i2;
        Composer startRestartGroup = composer.startRestartGroup(-2050358300);
        ComposerKt.sourceInformation(startRestartGroup, "C(ViceCityDisableDialog)N(sizeBytes,isProcessing,onDelete,onDismiss)534@22667L7,538@22730L871,536@22680L921:SettingsScreen.kt#1gr92h");
        if ((i & 6) == 0) {
            i2 = (startRestartGroup.changed(j) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= startRestartGroup.changed(z) ? 32 : 16;
        }
        if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i2 |= startRestartGroup.changedInstance(function0) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= startRestartGroup.changedInstance(function02) ? 2048 : 1024;
        }
        if (!startRestartGroup.shouldExecute((i2 & 1171) != 1170, i2 & 1)) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2050358300, i2, -1, "com.miami.game.feature.settings.ui.compose.ViceCityDisableDialog (SettingsScreen.kt:533)");
            }
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object consume = startRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            final Context context = (Context) consume;
            DialogFrameKt.DialogFrame(null, function02, null, ComposableLambdaKt.rememberComposableLambda(464816347, true, new Function2() { // from class: com.miami.game.feature.settings.ui.compose.SettingsScreenKt$$ExternalSyntheticLambda21
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return SettingsScreenKt.ViceCityDisableDialog$lambda$0(context, j, function02, z, function0, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, startRestartGroup, 54), startRestartGroup, ((i2 >> 6) & 112) | 3072, 5);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: com.miami.game.feature.settings.ui.compose.SettingsScreenKt$$ExternalSyntheticLambda22
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return SettingsScreenKt.ViceCityDisableDialog$lambda$1(j, z, function0, function02, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit ViceCityDisableDialog$lambda$0(Context context, long j, Function0 function0, boolean z, Function0 function02, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C540@22782L147,539@22740L200,545@22949L646:SettingsScreen.kt#1gr92h");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(464816347, i, -1, "com.miami.game.feature.settings.ui.compose.ViceCityDisableDialog.<anonymous> (SettingsScreen.kt:539)");
            }
            int i2 = R.string.vice_city_disable_description;
            String formatFileSize = Formatter.formatFileSize(context, j);
            Intrinsics.checkNotNullExpressionValue(formatFileSize, "formatFileSize(...)");
            DialogDescriptionTextKt.DialogDescriptionText(StringResources_androidKt.stringResource(i2, new Object[]{formatFileSize}, composer, 0), composer, 0);
            ComposerKt.sourceInformationMarkerStart(composer, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), Alignment.Companion.getTop(), composer, 0);
            ComposerKt.sourceInformationMarkerStart(composer, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
            int hashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(composer, Modifier.Companion);
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
            Updater.m4475setimpl(m4467constructorimpl, rowMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m4475setimpl(m4467constructorimpl, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.m4475setimpl(m4467constructorimpl, Integer.valueOf(hashCode), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.m4473reconcileimpl(m4467constructorimpl, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.m4475setimpl(m4467constructorimpl, materializeModifier, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, -1406095166, "C546@22967L266,553@23246L339:SettingsScreen.kt#1gr92h");
            DialogButtonKt.DialogButtonNo(function0, ComposableSingletons$SettingsScreenKt.INSTANCE.m9895getLambda$1336153321$settings(), composer, 48);
            DialogButtonKt.DialogButtonYes(function02, !z, ComposableSingletons$SettingsScreenKt.INSTANCE.m9894getLambda$1302805746$settings(), composer, RendererCapabilities.DECODER_SUPPORT_MASK, 0);
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

    public static final void BackgroundImage(final int i, Composer composer, final int i2) {
        int i3;
        Composer startRestartGroup = composer.startRestartGroup(-1060762892);
        ComposerKt.sourceInformation(startRestartGroup, "C(BackgroundImage)N(backGroundId)571@23739L56,569@23671L208:SettingsScreen.kt#1gr92h");
        if ((i2 & 6) == 0) {
            i3 = (startRestartGroup.changed(i) ? 4 : 2) | i2;
        } else {
            i3 = i2;
        }
        if (!startRestartGroup.shouldExecute((i3 & 3) != 2, i3 & 1)) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1060762892, i3, -1, "com.miami.game.feature.settings.ui.compose.BackgroundImage (SettingsScreen.kt:568)");
            }
            ImageKt.Image(PainterResources_androidKt.painterResource(i, startRestartGroup, i3 & 14), (String) null, SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, null), (Alignment) null, ContentScale.Companion.getCrop(), 0.0f, (ColorFilter) null, startRestartGroup, Painter.$stable | 25008, 104);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: com.miami.game.feature.settings.ui.compose.SettingsScreenKt$$ExternalSyntheticLambda23
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
