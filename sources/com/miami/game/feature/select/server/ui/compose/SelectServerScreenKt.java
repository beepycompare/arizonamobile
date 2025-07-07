package com.miami.game.feature.select.server.ui.compose;

import androidx.activity.compose.BackHandlerKt;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.lazy.grid.GridCells;
import androidx.compose.foundation.lazy.grid.LazyGridDslKt;
import androidx.compose.foundation.lazy.grid.LazyGridItemScope;
import androidx.compose.foundation.lazy.grid.LazyGridScope;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.TextKt;
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
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.TextUnit;
import androidx.compose.ui.unit.TextUnitKt;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.compose.FlowExtKt;
import androidx.media3.exoplayer.RendererCapabilities;
import com.miami.game.core.decompose.utils.SharedEventFlow;
import com.miami.game.core.design.system.component.scaling_button.ScalingButtonKt;
import com.miami.game.core.server.model.ServerModel;
import com.miami.game.core.server.model.ServerStateCategory;
import com.miami.game.core.ui.utils.extensions.FlowExtensionsKt;
import com.miami.game.feature.select.server.ui.SelectServerComponent;
import com.miami.game.feature.select.server.ui.model.SelectServerUiState;
import com.miami.game.feature.select.server.ui.model.ServerUiAction;
import com.miami.game.ui.theme.TypeKt;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KFunction;
import okhttp3.internal.ws.WebSocketProtocol;
/* compiled from: SelectServerScreen.kt */
@Metadata(d1 = {"\u0000(\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a#\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0007¢\u0006\u0002\u0010\u0006\u001au\u0010\u0007\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\t2\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00010\u000b2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00010\u000b2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003H\u0001¢\u0006\u0002\u0010\u0011¨\u0006\u0012²\u0006\n\u0010\b\u001a\u00020\tX\u008a\u0084\u0002"}, d2 = {"SelectServerRoute", "", "navigateHome", "Lkotlin/Function0;", "component", "Lcom/miami/game/feature/select/server/ui/SelectServerComponent;", "(Lkotlin/jvm/functions/Function0;Lcom/miami/game/feature/select/server/ui/SelectServerComponent;Landroidx/compose/runtime/Composer;I)V", "SelectServerScreen", "uiState", "Lcom/miami/game/feature/select/server/ui/model/SelectServerUiState;", "onSelect", "Lkotlin/Function1;", "Lcom/miami/game/core/server/model/ServerModel;", "onFavorite", "onFavoriteList", "onMobileList", "onDesktopList", "(Lcom/miami/game/feature/select/server/ui/model/SelectServerUiState;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "select-server_release_web"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class SelectServerScreenKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SelectServerRoute$lambda$7(Function0 function0, SelectServerComponent selectServerComponent, int i, Composer composer, int i2) {
        SelectServerRoute(function0, selectServerComponent, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SelectServerScreen$lambda$21(SelectServerUiState selectServerUiState, Function0 function0, Function1 function1, Function1 function12, Function0 function02, Function0 function03, Function0 function04, int i, Composer composer, int i2) {
        SelectServerScreen(selectServerUiState, function0, function1, function12, function02, function03, function04, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final void SelectServerRoute(final Function0<Unit> navigateHome, final SelectServerComponent component, Composer composer, final int i) {
        int i2;
        Intrinsics.checkNotNullParameter(navigateHome, "navigateHome");
        Intrinsics.checkNotNullParameter(component, "component");
        Composer startRestartGroup = composer.startRestartGroup(-387912032);
        ComposerKt.sourceInformation(startRestartGroup, "C(SelectServerRoute)P(1)49@2258L34,50@2330L29,51@2420L115,51@2383L152,59@2643L19,60@2685L21,61@2731L23,62@2781L25,63@2832L24,56@2540L322:SelectServerScreen.kt#2ojkxh");
        if ((i & 6) == 0) {
            i2 = (startRestartGroup.changedInstance(navigateHome) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= startRestartGroup.changedInstance(component) ? 32 : 16;
        }
        int i3 = i2;
        if ((i3 & 19) != 18 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-387912032, i3, -1, "com.miami.game.feature.select.server.ui.compose.SelectServerRoute (SelectServerScreen.kt:48)");
            }
            int i4 = (i3 << 3) & 112;
            BackHandlerKt.BackHandler(false, navigateHome, startRestartGroup, i4, 1);
            State collectAsStateWithLifecycle = FlowExtKt.collectAsStateWithLifecycle(component.getUiState(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, startRestartGroup, 0, 7);
            SharedEventFlow<ServerUiAction> uiAction = component.getUiAction();
            Object[] objArr = new Object[0];
            startRestartGroup.startReplaceGroup(5004770);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):SelectServerScreen.kt#9igjgp");
            boolean z = (i3 & 14) == 4;
            SelectServerScreenKt$SelectServerRoute$1$1 rememberedValue = startRestartGroup.rememberedValue();
            if (z || rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new SelectServerScreenKt$SelectServerRoute$1$1(navigateHome, null);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceGroup();
            FlowExtensionsKt.collectInLaunchedEffectWithLifecycle(uiAction, objArr, null, null, (Function3) rememberedValue, startRestartGroup, 0, 6);
            SelectServerUiState SelectServerRoute$lambda$0 = SelectServerRoute$lambda$0(collectAsStateWithLifecycle);
            startRestartGroup.startReplaceGroup(5004770);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):SelectServerScreen.kt#9igjgp");
            boolean changedInstance = startRestartGroup.changedInstance(component);
            SelectServerScreenKt$SelectServerRoute$2$1 rememberedValue2 = startRestartGroup.rememberedValue();
            if (changedInstance || rememberedValue2 == Composer.Companion.getEmpty()) {
                rememberedValue2 = new SelectServerScreenKt$SelectServerRoute$2$1(component);
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            KFunction kFunction = (KFunction) rememberedValue2;
            startRestartGroup.endReplaceGroup();
            startRestartGroup.startReplaceGroup(5004770);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):SelectServerScreen.kt#9igjgp");
            boolean changedInstance2 = startRestartGroup.changedInstance(component);
            SelectServerScreenKt$SelectServerRoute$3$1 rememberedValue3 = startRestartGroup.rememberedValue();
            if (changedInstance2 || rememberedValue3 == Composer.Companion.getEmpty()) {
                rememberedValue3 = new SelectServerScreenKt$SelectServerRoute$3$1(component);
                startRestartGroup.updateRememberedValue(rememberedValue3);
            }
            KFunction kFunction2 = (KFunction) rememberedValue3;
            startRestartGroup.endReplaceGroup();
            startRestartGroup.startReplaceGroup(5004770);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):SelectServerScreen.kt#9igjgp");
            boolean changedInstance3 = startRestartGroup.changedInstance(component);
            SelectServerScreenKt$SelectServerRoute$4$1 rememberedValue4 = startRestartGroup.rememberedValue();
            if (changedInstance3 || rememberedValue4 == Composer.Companion.getEmpty()) {
                rememberedValue4 = new SelectServerScreenKt$SelectServerRoute$4$1(component);
                startRestartGroup.updateRememberedValue(rememberedValue4);
            }
            KFunction kFunction3 = (KFunction) rememberedValue4;
            startRestartGroup.endReplaceGroup();
            startRestartGroup.startReplaceGroup(5004770);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):SelectServerScreen.kt#9igjgp");
            boolean changedInstance4 = startRestartGroup.changedInstance(component);
            SelectServerScreenKt$SelectServerRoute$5$1 rememberedValue5 = startRestartGroup.rememberedValue();
            if (changedInstance4 || rememberedValue5 == Composer.Companion.getEmpty()) {
                rememberedValue5 = new SelectServerScreenKt$SelectServerRoute$5$1(component);
                startRestartGroup.updateRememberedValue(rememberedValue5);
            }
            KFunction kFunction4 = (KFunction) rememberedValue5;
            startRestartGroup.endReplaceGroup();
            startRestartGroup.startReplaceGroup(5004770);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):SelectServerScreen.kt#9igjgp");
            boolean changedInstance5 = startRestartGroup.changedInstance(component);
            SelectServerScreenKt$SelectServerRoute$6$1 rememberedValue6 = startRestartGroup.rememberedValue();
            if (changedInstance5 || rememberedValue6 == Composer.Companion.getEmpty()) {
                rememberedValue6 = new SelectServerScreenKt$SelectServerRoute$6$1(component);
                startRestartGroup.updateRememberedValue(rememberedValue6);
            }
            startRestartGroup.endReplaceGroup();
            SelectServerScreen(SelectServerRoute$lambda$0, navigateHome, (Function1) kFunction, (Function1) kFunction2, (Function0) kFunction4, (Function0) kFunction3, (Function0) ((KFunction) rememberedValue6), startRestartGroup, i4);
            startRestartGroup = startRestartGroup;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: com.miami.game.feature.select.server.ui.compose.SelectServerScreenKt$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit SelectServerRoute$lambda$7;
                    SelectServerRoute$lambda$7 = SelectServerScreenKt.SelectServerRoute$lambda$7(Function0.this, component, i, (Composer) obj, ((Integer) obj2).intValue());
                    return SelectServerRoute$lambda$7;
                }
            });
        }
    }

    public static final void SelectServerScreen(final SelectServerUiState uiState, final Function0<Unit> navigateHome, Function1<? super ServerModel, Unit> onSelect, Function1<? super ServerModel, Unit> onFavorite, final Function0<Unit> onFavoriteList, final Function0<Unit> onMobileList, final Function0<Unit> onDesktopList, Composer composer, final int i) {
        int i2;
        BoxScopeInstance boxScopeInstance;
        int i3;
        String str;
        boolean z;
        int i4;
        final Function1<? super ServerModel, Unit> function1;
        final MutableState mutableState;
        boolean z2;
        final MutableState mutableState2;
        final Function1<? super ServerModel, Unit> function12;
        Intrinsics.checkNotNullParameter(uiState, "uiState");
        Intrinsics.checkNotNullParameter(navigateHome, "navigateHome");
        Intrinsics.checkNotNullParameter(onSelect, "onSelect");
        Intrinsics.checkNotNullParameter(onFavorite, "onFavorite");
        Intrinsics.checkNotNullParameter(onFavoriteList, "onFavoriteList");
        Intrinsics.checkNotNullParameter(onMobileList, "onMobileList");
        Intrinsics.checkNotNullParameter(onDesktopList, "onDesktopList");
        Composer startRestartGroup = composer.startRestartGroup(1256713563);
        ComposerKt.sourceInformation(startRestartGroup, "C(SelectServerScreen)P(6!1,5,2,3,4)81@3260L60,84@3393L64,82@3325L216,90@3546L2572:SelectServerScreen.kt#2ojkxh");
        if ((i & 6) == 0) {
            i2 = (startRestartGroup.changed(uiState) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= startRestartGroup.changedInstance(navigateHome) ? 32 : 16;
        }
        if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i2 |= startRestartGroup.changedInstance(onSelect) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= startRestartGroup.changedInstance(onFavorite) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i2 |= startRestartGroup.changedInstance(onFavoriteList) ? 16384 : 8192;
        }
        if ((196608 & i) == 0) {
            i2 |= startRestartGroup.changedInstance(onMobileList) ? 131072 : 65536;
        }
        if ((1572864 & i) == 0) {
            i2 |= startRestartGroup.changedInstance(onDesktopList) ? 1048576 : 524288;
        }
        if ((599187 & i2) != 599186 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1256713563, i2, -1, "com.miami.game.feature.select.server.ui.compose.SelectServerScreen (SelectServerScreen.kt:80)");
            }
            startRestartGroup.startReplaceGroup(1849434622);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):SelectServerScreen.kt#9igjgp");
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (rememberedValue == Composer.Companion.getEmpty()) {
                ServerModel currentServer = uiState.getCurrentServer();
                rememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default((currentServer == null || (r11 = currentServer.getName()) == null) ? "" : "", null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            MutableState mutableState3 = (MutableState) rememberedValue;
            startRestartGroup.endReplaceGroup();
            ImageKt.Image(PainterResources_androidKt.painterResource(uiState.getBackGroundId(), startRestartGroup, 0), (String) null, SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, null), (Alignment) null, ContentScale.Companion.getCrop(), 0.0f, (ColorFilter) null, startRestartGroup, 25008, 104);
            Modifier fillMaxSize$default = SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, null);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
            MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, fillMaxSize$default);
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
            BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 153051863, "C95@3657L1930,141@5633L157,140@5596L516:SelectServerScreen.kt#2ojkxh");
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -483455358, "CC(Column)P(2,3,1)87@4442L61,88@4508L133:Column.kt#2w3rfo");
            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.Companion.getStart(), startRestartGroup, 0);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(startRestartGroup, Modifier.Companion);
            Function0<ComposeUiNode> constructor2 = ComposeUiNode.Companion.getConstructor();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
            if (!(startRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(constructor2);
            } else {
                startRestartGroup.useNode();
            }
            Composer m3520constructorimpl2 = Updater.m3520constructorimpl(startRestartGroup);
            Updater.m3527setimpl(m3520constructorimpl2, columnMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m3527setimpl(m3520constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (m3520constructorimpl2.getInserting() || !Intrinsics.areEqual(m3520constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                m3520constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                m3520constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
            }
            Updater.m3527setimpl(m3520constructorimpl2, materializeModifier2, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -384672921, "C89@4556L9:Column.kt#2w3rfo");
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1498405127, "C96@3678L199:SelectServerScreen.kt#2ojkxh");
            int i5 = i2 & 14;
            int i6 = i2 >> 6;
            int i7 = i2;
            ServerTopBarKt.ServerTopBar(uiState, navigateHome, onFavoriteList, onMobileList, onDesktopList, startRestartGroup, (i2 & WebSocketProtocol.PAYLOAD_SHORT) | (i6 & 896) | (i6 & 7168) | (i6 & 57344));
            if (uiState.getSelectedCategory() == ServerStateCategory.Favorite && uiState.getServersList().isEmpty()) {
                startRestartGroup.startReplaceGroup(-1498142248);
                ComposerKt.sourceInformation(startRestartGroup, "102@4003L523");
                Modifier fillMaxSize$default2 = SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, null);
                Alignment center = Alignment.Companion.getCenter();
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                MeasurePolicy maybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(center, false);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap3 = startRestartGroup.getCurrentCompositionLocalMap();
                Modifier materializeModifier3 = ComposedModifierKt.materializeModifier(startRestartGroup, fillMaxSize$default2);
                Function0<ComposeUiNode> constructor3 = ComposeUiNode.Companion.getConstructor();
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
                if (!(startRestartGroup.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                startRestartGroup.startReusableNode();
                if (startRestartGroup.getInserting()) {
                    startRestartGroup.createNode(constructor3);
                } else {
                    startRestartGroup.useNode();
                }
                Composer m3520constructorimpl3 = Updater.m3520constructorimpl(startRestartGroup);
                Updater.m3527setimpl(m3520constructorimpl3, maybeCachedBoxMeasurePolicy2, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.m3527setimpl(m3520constructorimpl3, currentCompositionLocalMap3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = ComposeUiNode.Companion.getSetCompositeKeyHash();
                if (m3520constructorimpl3.getInserting() || !Intrinsics.areEqual(m3520constructorimpl3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                    m3520constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                    m3520constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
                }
                Updater.m3527setimpl(m3520constructorimpl3, materializeModifier3, ComposeUiNode.Companion.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance3 = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1451227624, "C109@4308L10,110@4366L13,111@4418L13,112@4474L12,106@4159L349:SelectServerScreen.kt#2ojkxh");
                long m4077copywmQWz5c$default = Color.m4077copywmQWz5c$default(Color.Companion.m4115getWhite0d7_KjU(), 0.8f, 0.0f, 0.0f, 0.0f, 14, null);
                TextStyle bodyMedium = MaterialTheme.INSTANCE.getTypography(startRestartGroup, MaterialTheme.$stable).getBodyMedium();
                float f = 32;
                long m8401dpToSp8Feqmps = TypeKt.m8401dpToSp8Feqmps(Dp.m6684constructorimpl(f), startRestartGroup, 6);
                long m8401dpToSp8Feqmps2 = TypeKt.m8401dpToSp8Feqmps(Dp.m6684constructorimpl(f), startRestartGroup, 6);
                long m8401dpToSp8Feqmps3 = TypeKt.m8401dpToSp8Feqmps(Dp.m6684constructorimpl(1), startRestartGroup, 6);
                TextUnitKt.m6891checkArithmeticR2X_6o(m8401dpToSp8Feqmps3);
                long pack = TextUnitKt.pack(TextUnit.m6876getRawTypeimpl(m8401dpToSp8Feqmps3), -TextUnit.m6878getValueimpl(m8401dpToSp8Feqmps3));
                boxScopeInstance = boxScopeInstance2;
                i3 = i7;
                z = false;
                str = "CC(remember):SelectServerScreen.kt#9igjgp";
                TextKt.m2497Text4IGK_g("НЕТ ИЗБРАННЫХ", (Modifier) null, m4077copywmQWz5c$default, m8401dpToSp8Feqmps, (FontStyle) null, (FontWeight) null, (FontFamily) null, pack, (TextDecoration) null, (TextAlign) null, m8401dpToSp8Feqmps2, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, bodyMedium, startRestartGroup, 390, 0, 64370);
                startRestartGroup = startRestartGroup;
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                startRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                startRestartGroup.endReplaceGroup();
                function1 = onFavorite;
                mutableState2 = mutableState3;
                i4 = 4;
                z2 = true;
            } else {
                boxScopeInstance = boxScopeInstance2;
                i3 = i7;
                str = "CC(remember):SelectServerScreen.kt#9igjgp";
                z = false;
                startRestartGroup.startReplaceGroup(-1497570980);
                ComposerKt.sourceInformation(startRestartGroup, "116@4564L999");
                Modifier fillMaxSize$default3 = SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, null);
                Alignment center2 = Alignment.Companion.getCenter();
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                MeasurePolicy maybeCachedBoxMeasurePolicy3 = BoxKt.maybeCachedBoxMeasurePolicy(center2, false);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                int currentCompositeKeyHash4 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap4 = startRestartGroup.getCurrentCompositionLocalMap();
                Modifier materializeModifier4 = ComposedModifierKt.materializeModifier(startRestartGroup, fillMaxSize$default3);
                Function0<ComposeUiNode> constructor4 = ComposeUiNode.Companion.getConstructor();
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
                if (!(startRestartGroup.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                startRestartGroup.startReusableNode();
                if (startRestartGroup.getInserting()) {
                    startRestartGroup.createNode(constructor4);
                } else {
                    startRestartGroup.useNode();
                }
                Composer m3520constructorimpl4 = Updater.m3520constructorimpl(startRestartGroup);
                Updater.m3527setimpl(m3520constructorimpl4, maybeCachedBoxMeasurePolicy3, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.m3527setimpl(m3520constructorimpl4, currentCompositionLocalMap4, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash4 = ComposeUiNode.Companion.getSetCompositeKeyHash();
                if (m3520constructorimpl4.getInserting() || !Intrinsics.areEqual(m3520constructorimpl4.rememberedValue(), Integer.valueOf(currentCompositeKeyHash4))) {
                    m3520constructorimpl4.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash4));
                    m3520constructorimpl4.apply(Integer.valueOf(currentCompositeKeyHash4), setCompositeKeyHash4);
                }
                Updater.m3527setimpl(m3520constructorimpl4, materializeModifier4, ComposeUiNode.Companion.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance4 = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -851044843, "C125@5047L498,120@4720L825:SelectServerScreen.kt#2ojkxh");
                float f2 = 125;
                Modifier m772heightInVpY3zN4 = SizeKt.m772heightInVpY3zN4(Modifier.Companion, Dp.m6684constructorimpl(f2), Dp.m6684constructorimpl(300));
                GridCells.FixedSize fixedSize = new GridCells.FixedSize(Dp.m6684constructorimpl(f2), null);
                Arrangement.HorizontalOrVertical spaceEvenly = Arrangement.INSTANCE.getSpaceEvenly();
                PaddingValues m735PaddingValuesa9UjIt4$default = PaddingKt.m735PaddingValuesa9UjIt4$default(Dp.m6684constructorimpl(40), 0.0f, Dp.m6684constructorimpl(140), 0.0f, 10, null);
                GridCells.FixedSize fixedSize2 = fixedSize;
                Arrangement.HorizontalOrVertical horizontalOrVertical = spaceEvenly;
                startRestartGroup.startReplaceGroup(-1746271574);
                ComposerKt.sourceInformation(startRestartGroup, str);
                i4 = 4;
                boolean z3 = (i5 == 4) | ((i3 & 7168) == 2048);
                Object rememberedValue2 = startRestartGroup.rememberedValue();
                if (z3 || rememberedValue2 == Composer.Companion.getEmpty()) {
                    function1 = onFavorite;
                    mutableState = mutableState3;
                    rememberedValue2 = new Function1() { // from class: com.miami.game.feature.select.server.ui.compose.SelectServerScreenKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            Unit SelectServerScreen$lambda$20$lambda$15$lambda$14$lambda$13$lambda$12;
                            SelectServerScreen$lambda$20$lambda$15$lambda$14$lambda$13$lambda$12 = SelectServerScreenKt.SelectServerScreen$lambda$20$lambda$15$lambda$14$lambda$13$lambda$12(SelectServerUiState.this, function1, mutableState, (LazyGridScope) obj);
                            return SelectServerScreen$lambda$20$lambda$15$lambda$14$lambda$13$lambda$12;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue2);
                } else {
                    function1 = onFavorite;
                    mutableState = mutableState3;
                }
                startRestartGroup.endReplaceGroup();
                z2 = true;
                mutableState2 = mutableState;
                LazyGridDslKt.LazyHorizontalGrid(fixedSize2, m772heightInVpY3zN4, null, m735PaddingValuesa9UjIt4$default, false, null, horizontalOrVertical, null, false, null, (Function1) rememberedValue2, startRestartGroup, 1575984, 0, 948);
                startRestartGroup = startRestartGroup;
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                startRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                startRestartGroup.endReplaceGroup();
            }
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            startRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            startRestartGroup.startReplaceGroup(-1746271574);
            ComposerKt.sourceInformation(startRestartGroup, str);
            boolean z4 = i5 == i4 ? z2 : z;
            if ((i3 & 896) != 256) {
                z2 = z;
            }
            boolean z5 = z4 | z2;
            Object rememberedValue3 = startRestartGroup.rememberedValue();
            if (z5 || rememberedValue3 == Composer.Companion.getEmpty()) {
                function12 = onSelect;
                rememberedValue3 = new Function0() { // from class: com.miami.game.feature.select.server.ui.compose.SelectServerScreenKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit SelectServerScreen$lambda$20$lambda$19$lambda$18;
                        SelectServerScreen$lambda$20$lambda$19$lambda$18 = SelectServerScreenKt.SelectServerScreen$lambda$20$lambda$19$lambda$18(SelectServerUiState.this, mutableState2, function12);
                        return SelectServerScreen$lambda$20$lambda$19$lambda$18;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue3);
            } else {
                function12 = onSelect;
            }
            startRestartGroup.endReplaceGroup();
            ScalingButtonKt.ScalingButton((Function0) rememberedValue3, boxScopeInstance.align(Modifier.Companion, Alignment.Companion.getBottomEnd()), ComposableSingletons$SelectServerScreenKt.INSTANCE.getLambda$22973248$select_server_release_web(), startRestartGroup, RendererCapabilities.DECODER_SUPPORT_MASK, 0);
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
            function12 = onSelect;
            function1 = onFavorite;
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            final Function1<? super ServerModel, Unit> function13 = function12;
            final Function1<? super ServerModel, Unit> function14 = function1;
            endRestartGroup.updateScope(new Function2() { // from class: com.miami.game.feature.select.server.ui.compose.SelectServerScreenKt$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit SelectServerScreen$lambda$21;
                    SelectServerScreen$lambda$21 = SelectServerScreenKt.SelectServerScreen$lambda$21(SelectServerUiState.this, navigateHome, function13, function14, onFavoriteList, onMobileList, onDesktopList, i, (Composer) obj, ((Integer) obj2).intValue());
                    return SelectServerScreen$lambda$21;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SelectServerScreen$lambda$20$lambda$15$lambda$14$lambda$13$lambda$12(SelectServerUiState selectServerUiState, final Function1 function1, final MutableState mutableState, LazyGridScope LazyHorizontalGrid) {
        Intrinsics.checkNotNullParameter(LazyHorizontalGrid, "$this$LazyHorizontalGrid");
        final List<ServerModel> serversList = selectServerUiState.getServersList();
        final SelectServerScreenKt$SelectServerScreen$lambda$20$lambda$15$lambda$14$lambda$13$lambda$12$$inlined$items$default$1 selectServerScreenKt$SelectServerScreen$lambda$20$lambda$15$lambda$14$lambda$13$lambda$12$$inlined$items$default$1 = new Function1() { // from class: com.miami.game.feature.select.server.ui.compose.SelectServerScreenKt$SelectServerScreen$lambda$20$lambda$15$lambda$14$lambda$13$lambda$12$$inlined$items$default$1
            @Override // kotlin.jvm.functions.Function1
            public final Void invoke(ServerModel serverModel) {
                return null;
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                return invoke((ServerModel) obj);
            }
        };
        LazyHorizontalGrid.items(serversList.size(), null, null, new Function1<Integer, Object>() { // from class: com.miami.game.feature.select.server.ui.compose.SelectServerScreenKt$SelectServerScreen$lambda$20$lambda$15$lambda$14$lambda$13$lambda$12$$inlined$items$default$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                return invoke(num.intValue());
            }

            public final Object invoke(int i) {
                return Function1.this.invoke(serversList.get(i));
            }
        }, ComposableLambdaKt.composableLambdaInstance(699646206, true, new Function4<LazyGridItemScope, Integer, Composer, Integer, Unit>() { // from class: com.miami.game.feature.select.server.ui.compose.SelectServerScreenKt$SelectServerScreen$lambda$20$lambda$15$lambda$14$lambda$13$lambda$12$$inlined$items$default$5
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(4);
            }

            @Override // kotlin.jvm.functions.Function4
            public /* bridge */ /* synthetic */ Unit invoke(LazyGridItemScope lazyGridItemScope, Integer num, Composer composer, Integer num2) {
                invoke(lazyGridItemScope, num.intValue(), composer, num2.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(LazyGridItemScope lazyGridItemScope, int i, Composer composer, int i2) {
                int i3;
                ComposerKt.sourceInformation(composer, "C542@23993L22:LazyGridDsl.kt#7791vq");
                if ((i2 & 6) == 0) {
                    i3 = (composer.changed(lazyGridItemScope) ? 4 : 2) | i2;
                } else {
                    i3 = i2;
                }
                if ((i2 & 48) == 0) {
                    i3 |= composer.changed(i) ? 32 : 16;
                }
                if (!composer.shouldExecute((i3 & 147) != 146, i3 & 1)) {
                    composer.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(699646206, i3, -1, "androidx.compose.foundation.lazy.grid.items.<anonymous> (LazyGridDsl.kt:542)");
                }
                ServerModel serverModel = (ServerModel) serversList.get(i);
                composer.startReplaceGroup(-1669064645);
                ComposerKt.sourceInformation(composer, "C*129@5235L109,127@5130L367:SelectServerScreen.kt#2ojkxh");
                composer.startReplaceGroup(5004770);
                ComposerKt.sourceInformation(composer, "CC(remember):SelectServerScreen.kt#9igjgp");
                Object rememberedValue = composer.rememberedValue();
                if (rememberedValue == Composer.Companion.getEmpty()) {
                    final MutableState mutableState2 = mutableState;
                    rememberedValue = (Function1) new Function1<ServerModel, Unit>() { // from class: com.miami.game.feature.select.server.ui.compose.SelectServerScreenKt$SelectServerScreen$1$1$2$1$1$1$1$1
                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(ServerModel serverModel2) {
                            invoke2(serverModel2);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke  reason: avoid collision after fix types in other method */
                        public final void invoke2(ServerModel it) {
                            Intrinsics.checkNotNullParameter(it, "it");
                            MutableState<String> mutableState3 = mutableState2;
                            String name = it.getName();
                            if (name == null) {
                                name = "";
                            }
                            mutableState3.setValue(name);
                        }
                    };
                    composer.updateRememberedValue(rememberedValue);
                }
                composer.endReplaceGroup();
                ServerItemKt.ServerItem(serverModel, (Function1) rememberedValue, function1, Intrinsics.areEqual(serverModel.getName(), mutableState.getValue()), composer, 48);
                composer.endReplaceGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SelectServerScreen$lambda$20$lambda$19$lambda$18(SelectServerUiState selectServerUiState, MutableState mutableState, Function1 function1) {
        Object obj;
        Iterator<T> it = selectServerUiState.getServersList().iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (Intrinsics.areEqual(((ServerModel) obj).getName(), mutableState.getValue())) {
                break;
            }
        }
        ServerModel serverModel = (ServerModel) obj;
        if (serverModel != null) {
            function1.invoke(serverModel);
        }
        return Unit.INSTANCE;
    }

    private static final SelectServerUiState SelectServerRoute$lambda$0(State<SelectServerUiState> state) {
        return state.getValue();
    }
}
