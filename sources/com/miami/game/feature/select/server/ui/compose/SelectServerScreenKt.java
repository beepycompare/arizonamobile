package com.miami.game.feature.select.server.ui.compose;

import android.content.Context;
import androidx.activity.compose.BackHandlerKt;
import androidx.compose.foundation.BackgroundKt;
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
import androidx.compose.foundation.lazy.grid.LazyGridState;
import androidx.compose.foundation.lazy.grid.LazyGridStateKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
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
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.TextUnit;
import androidx.compose.ui.unit.TextUnitKt;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.compose.FlowExtKt;
import androidx.media3.exoplayer.RendererCapabilities;
import coil3.compose.SingletonAsyncImageKt;
import coil3.request.ImageRequest;
import coil3.request.ImageRequestsKt;
import com.miami.game.core.decompose.utils.SharedEventFlow;
import com.miami.game.core.design.system.component.coil.blur.CoilBlurTransformation;
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
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KFunction;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import okhttp3.internal.ws.WebSocketProtocol;
/* compiled from: SelectServerScreen.kt */
@Metadata(d1 = {"\u0000(\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a#\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0007¢\u0006\u0002\u0010\u0006\u001au\u0010\u0007\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\t2\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00010\u000b2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00010\u000b2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003H\u0001¢\u0006\u0002\u0010\u0011¨\u0006\u0012²\u0006\n\u0010\b\u001a\u00020\tX\u008a\u0084\u0002"}, d2 = {"SelectServerRoute", "", "navigateHome", "Lkotlin/Function0;", "component", "Lcom/miami/game/feature/select/server/ui/SelectServerComponent;", "(Lkotlin/jvm/functions/Function0;Lcom/miami/game/feature/select/server/ui/SelectServerComponent;Landroidx/compose/runtime/Composer;I)V", "SelectServerScreen", "uiState", "Lcom/miami/game/feature/select/server/ui/model/SelectServerUiState;", "onSelect", "Lkotlin/Function1;", "Lcom/miami/game/core/server/model/ServerModel;", "onFavorite", "onFavoriteList", "onMobileList", "onDesktopList", "(Lcom/miami/game/feature/select/server/ui/model/SelectServerUiState;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "select-server_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class SelectServerScreenKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SelectServerRoute$lambda$7(Function0 function0, SelectServerComponent selectServerComponent, int i, Composer composer, int i2) {
        SelectServerRoute(function0, selectServerComponent, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SelectServerScreen$lambda$2(SelectServerUiState selectServerUiState, Function0 function0, Function1 function1, Function1 function12, Function0 function02, Function0 function03, Function0 function04, int i, Composer composer, int i2) {
        SelectServerScreen(selectServerUiState, function0, function1, function12, function02, function03, function04, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final void SelectServerRoute(final Function0<Unit> navigateHome, final SelectServerComponent component, Composer composer, final int i) {
        int i2;
        Intrinsics.checkNotNullParameter(navigateHome, "navigateHome");
        Intrinsics.checkNotNullParameter(component, "component");
        Composer startRestartGroup = composer.startRestartGroup(-387912032);
        ComposerKt.sourceInformation(startRestartGroup, "C(SelectServerRoute)N(navigateHome,component)61@2839L34,62@2911L29,63@3001L115,63@2964L152,71@3224L19,72@3266L21,73@3312L23,74@3362L25,75@3413L24,68@3121L322:SelectServerScreen.kt#2ojkxh");
        if ((i & 6) == 0) {
            i2 = (startRestartGroup.changedInstance(navigateHome) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= (i & 64) == 0 ? startRestartGroup.changed(component) : startRestartGroup.changedInstance(component) ? 32 : 16;
        }
        int i3 = i2;
        if (startRestartGroup.shouldExecute((i3 & 19) != 18, i3 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-387912032, i3, -1, "com.miami.game.feature.select.server.ui.compose.SelectServerRoute (SelectServerScreen.kt:60)");
            }
            int i4 = (i3 << 3) & 112;
            BackHandlerKt.BackHandler(false, navigateHome, startRestartGroup, i4, 1);
            State collectAsStateWithLifecycle = FlowExtKt.collectAsStateWithLifecycle(component.getUiState(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, startRestartGroup, 0, 7);
            SharedEventFlow<ServerUiAction> uiAction = component.getUiAction();
            Object[] objArr = new Object[0];
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 878700467, "CC(remember):SelectServerScreen.kt#9igjgp");
            boolean z = (i3 & 14) == 4;
            SelectServerScreenKt$SelectServerRoute$1$1 rememberedValue = startRestartGroup.rememberedValue();
            if (z || rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new SelectServerScreenKt$SelectServerRoute$1$1(navigateHome, null);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            FlowExtensionsKt.collectInLaunchedEffectWithLifecycle(uiAction, objArr, null, null, (Function3) rememberedValue, startRestartGroup, 0, 6);
            SelectServerUiState SelectServerRoute$lambda$0 = SelectServerRoute$lambda$0(collectAsStateWithLifecycle);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 878707507, "CC(remember):SelectServerScreen.kt#9igjgp");
            int i5 = i3 & 112;
            boolean z2 = i5 == 32 || ((i3 & 64) != 0 && startRestartGroup.changedInstance(component));
            SelectServerScreenKt$SelectServerRoute$2$1 rememberedValue2 = startRestartGroup.rememberedValue();
            if (z2 || rememberedValue2 == Composer.Companion.getEmpty()) {
                rememberedValue2 = new SelectServerScreenKt$SelectServerRoute$2$1(component);
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            KFunction kFunction = (KFunction) rememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 878708853, "CC(remember):SelectServerScreen.kt#9igjgp");
            boolean z3 = i5 == 32 || ((i3 & 64) != 0 && startRestartGroup.changedInstance(component));
            SelectServerScreenKt$SelectServerRoute$3$1 rememberedValue3 = startRestartGroup.rememberedValue();
            if (z3 || rememberedValue3 == Composer.Companion.getEmpty()) {
                rememberedValue3 = new SelectServerScreenKt$SelectServerRoute$3$1(component);
                startRestartGroup.updateRememberedValue(rememberedValue3);
            }
            KFunction kFunction2 = (KFunction) rememberedValue3;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 878710327, "CC(remember):SelectServerScreen.kt#9igjgp");
            boolean z4 = i5 == 32 || ((i3 & 64) != 0 && startRestartGroup.changedInstance(component));
            SelectServerScreenKt$SelectServerRoute$4$1 rememberedValue4 = startRestartGroup.rememberedValue();
            if (z4 || rememberedValue4 == Composer.Companion.getEmpty()) {
                rememberedValue4 = new SelectServerScreenKt$SelectServerRoute$4$1(component);
                startRestartGroup.updateRememberedValue(rememberedValue4);
            }
            KFunction kFunction3 = (KFunction) rememberedValue4;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 878711929, "CC(remember):SelectServerScreen.kt#9igjgp");
            boolean z5 = i5 == 32 || ((i3 & 64) != 0 && startRestartGroup.changedInstance(component));
            SelectServerScreenKt$SelectServerRoute$5$1 rememberedValue5 = startRestartGroup.rememberedValue();
            if (z5 || rememberedValue5 == Composer.Companion.getEmpty()) {
                rememberedValue5 = new SelectServerScreenKt$SelectServerRoute$5$1(component);
                startRestartGroup.updateRememberedValue(rememberedValue5);
            }
            KFunction kFunction4 = (KFunction) rememberedValue5;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 878713560, "CC(remember):SelectServerScreen.kt#9igjgp");
            boolean z6 = i5 == 32 || ((i3 & 64) != 0 && startRestartGroup.changedInstance(component));
            SelectServerScreenKt$SelectServerRoute$6$1 rememberedValue6 = startRestartGroup.rememberedValue();
            if (z6 || rememberedValue6 == Composer.Companion.getEmpty()) {
                rememberedValue6 = new SelectServerScreenKt$SelectServerRoute$6$1(component);
                startRestartGroup.updateRememberedValue(rememberedValue6);
            }
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
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
            endRestartGroup.updateScope(new Function2() { // from class: com.miami.game.feature.select.server.ui.compose.SelectServerScreenKt$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit SelectServerRoute$lambda$7;
                    SelectServerRoute$lambda$7 = SelectServerScreenKt.SelectServerRoute$lambda$7(Function0.this, component, i, (Composer) obj, ((Integer) obj2).intValue());
                    return SelectServerRoute$lambda$7;
                }
            });
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r9v8 */
    public static final void SelectServerScreen(final SelectServerUiState uiState, final Function0<Unit> navigateHome, Function1<? super ServerModel, Unit> function1, Function1<? super ServerModel, Unit> onFavorite, final Function0<Unit> onFavoriteList, final Function0<Unit> onMobileList, final Function0<Unit> onDesktopList, Composer composer, final int i) {
        int i2;
        final Function1<? super ServerModel, Unit> function12;
        Object obj;
        BoxScopeInstance boxScopeInstance;
        boolean z;
        boolean z2;
        int i3;
        int i4;
        int i5;
        final MutableState mutableState;
        final MutableState mutableState2;
        final Function1<? super ServerModel, Unit> function13;
        Object onSelect = function1;
        Intrinsics.checkNotNullParameter(uiState, "uiState");
        Intrinsics.checkNotNullParameter(navigateHome, "navigateHome");
        Intrinsics.checkNotNullParameter(onSelect, "onSelect");
        Intrinsics.checkNotNullParameter(onFavorite, "onFavorite");
        Intrinsics.checkNotNullParameter(onFavoriteList, "onFavoriteList");
        Intrinsics.checkNotNullParameter(onMobileList, "onMobileList");
        Intrinsics.checkNotNullParameter(onDesktopList, "onDesktopList");
        Composer startRestartGroup = composer.startRestartGroup(1256713563);
        ComposerKt.sourceInformation(startRestartGroup, "C(SelectServerScreen)N(uiState,navigateHome,onSelect,onFavorite,onFavoriteList,onMobileList,onDesktopList)93@3841L60,94@3918L24,96@3966L23,100@4067L64,98@3999L211,107@4282L7,106@4220L312,115@4537L2819:SelectServerScreen.kt#2ojkxh");
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
        if (!startRestartGroup.shouldExecute((599187 & i2) != 599186, i2 & 1)) {
            function12 = onFavorite;
            startRestartGroup.skipToGroupEnd();
            obj = onSelect;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1256713563, i2, -1, "com.miami.game.feature.select.server.ui.compose.SelectServerScreen (SelectServerScreen.kt:92)");
            }
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 815932983, "CC(remember):SelectServerScreen.kt#9igjgp");
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (rememberedValue == Composer.Companion.getEmpty()) {
                ServerModel currentServer = uiState.getCurrentServer();
                rememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default((currentServer == null || (r4 = currentServer.getName()) == null) ? "" : "", null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            MutableState mutableState3 = (MutableState) rememberedValue;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 773894976, "CC(rememberCoroutineScope)N(getContext)608@27648L68:Effects.kt#9igjgp");
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 683737348, "CC(remember):Effects.kt#9igjgp");
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (rememberedValue2 == Composer.Companion.getEmpty()) {
                rememberedValue2 = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, startRestartGroup);
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            final CoroutineScope coroutineScope = (CoroutineScope) rememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            final LazyGridState rememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, startRestartGroup, 0, 3);
            ImageKt.Image(PainterResources_androidKt.painterResource(uiState.getBackGroundId(), startRestartGroup, 0), (String) null, SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, null), (Alignment) null, ContentScale.Companion.getCrop(), 0.0f, (ColorFilter) null, startRestartGroup, 25008, 104);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object consume = startRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            SingletonAsyncImageKt.m9076AsyncImage10Xjiaw(ImageRequestsKt.transformations(new ImageRequest.Builder((Context) consume).data(Integer.valueOf(uiState.getBackGroundId())), new CoilBlurTransformation(0, 0, 3, null)).build(), null, SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, null), null, null, null, ContentScale.Companion.getCrop(), 0.0f, null, 0, false, startRestartGroup, 1573296, 0, 1976);
            Modifier m267backgroundbw27NRU$default = BackgroundKt.m267backgroundbw27NRU$default(SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, null), ColorKt.Color(1711276032), null, 2, null);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
            int hashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(startRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, m267backgroundbw27NRU$default);
            Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!(startRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(constructor);
            } else {
                startRestartGroup.useNode();
            }
            Composer m4597constructorimpl = Updater.m4597constructorimpl(startRestartGroup);
            Updater.m4604setimpl(m4597constructorimpl, maybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m4604setimpl(m4597constructorimpl, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (m4597constructorimpl.getInserting() || !Intrinsics.areEqual(m4597constructorimpl.rememberedValue(), Integer.valueOf(hashCode))) {
                m4597constructorimpl.updateRememberedValue(Integer.valueOf(hashCode));
                m4597constructorimpl.apply(Integer.valueOf(hashCode), setCompositeKeyHash);
            }
            Updater.m4604setimpl(m4597constructorimpl, materializeModifier, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 153058187, "C121@4691L2134,173@6871L157,172@6834L516:SelectServerScreen.kt#2ojkxh");
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.Companion.getStart(), startRestartGroup, 0);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
            int hashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(startRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(startRestartGroup, Modifier.Companion);
            Function0<ComposeUiNode> constructor2 = ComposeUiNode.Companion.getConstructor();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!(startRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(constructor2);
            } else {
                startRestartGroup.useNode();
            }
            Composer m4597constructorimpl2 = Updater.m4597constructorimpl(startRestartGroup);
            Updater.m4604setimpl(m4597constructorimpl2, columnMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m4604setimpl(m4597constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (m4597constructorimpl2.getInserting() || !Intrinsics.areEqual(m4597constructorimpl2.rememberedValue(), Integer.valueOf(hashCode2))) {
                m4597constructorimpl2.updateRememberedValue(Integer.valueOf(hashCode2));
                m4597constructorimpl2.apply(Integer.valueOf(hashCode2), setCompositeKeyHash2);
            }
            Updater.m4604setimpl(m4597constructorimpl2, materializeModifier2, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1498398803, "C127@4937L132,122@4712L358:SelectServerScreen.kt#2ojkxh");
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -741066877, "CC(remember):SelectServerScreen.kt#9igjgp");
            boolean changedInstance = startRestartGroup.changedInstance(coroutineScope) | startRestartGroup.changed(rememberLazyGridState);
            Object rememberedValue3 = startRestartGroup.rememberedValue();
            if (changedInstance || rememberedValue3 == Composer.Companion.getEmpty()) {
                rememberedValue3 = new Function0() { // from class: com.miami.game.feature.select.server.ui.compose.SelectServerScreenKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit SelectServerScreen$lambda$1$0$0$0;
                        SelectServerScreen$lambda$1$0$0$0 = SelectServerScreenKt.SelectServerScreen$lambda$1$0$0$0(CoroutineScope.this, rememberLazyGridState);
                        return SelectServerScreen$lambda$1$0$0$0;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue3);
            }
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            int i6 = i2 & 14;
            int i7 = i2 >> 6;
            int i8 = i2;
            ServerTopBarKt.ServerTopBar(uiState, navigateHome, onFavoriteList, onMobileList, onDesktopList, (Function0) rememberedValue3, startRestartGroup, (i7 & 896) | (i2 & WebSocketProtocol.PAYLOAD_SHORT) | (i7 & 7168) | (57344 & i7));
            if (uiState.getSelectedCategory() == ServerStateCategory.Favorite && uiState.getServersList().isEmpty()) {
                startRestartGroup.startReplaceGroup(-1497984520);
                ComposerKt.sourceInformation(startRestartGroup, "133@5196L523");
                Modifier fillMaxSize$default = SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, null);
                Alignment center = Alignment.Companion.getCenter();
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                z2 = false;
                MeasurePolicy maybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(center, false);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
                int hashCode3 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(startRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap3 = startRestartGroup.getCurrentCompositionLocalMap();
                Modifier materializeModifier3 = ComposedModifierKt.materializeModifier(startRestartGroup, fillMaxSize$default);
                Function0<ComposeUiNode> constructor3 = ComposeUiNode.Companion.getConstructor();
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                if (!(startRestartGroup.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                startRestartGroup.startReusableNode();
                if (startRestartGroup.getInserting()) {
                    startRestartGroup.createNode(constructor3);
                } else {
                    startRestartGroup.useNode();
                }
                Composer m4597constructorimpl3 = Updater.m4597constructorimpl(startRestartGroup);
                Updater.m4604setimpl(m4597constructorimpl3, maybeCachedBoxMeasurePolicy2, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.m4604setimpl(m4597constructorimpl3, currentCompositionLocalMap3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = ComposeUiNode.Companion.getSetCompositeKeyHash();
                if (m4597constructorimpl3.getInserting() || !Intrinsics.areEqual(m4597constructorimpl3.rememberedValue(), Integer.valueOf(hashCode3))) {
                    m4597constructorimpl3.updateRememberedValue(Integer.valueOf(hashCode3));
                    m4597constructorimpl3.apply(Integer.valueOf(hashCode3), setCompositeKeyHash3);
                }
                Updater.m4604setimpl(m4597constructorimpl3, materializeModifier3, ComposeUiNode.Companion.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance3 = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1451227624, "C140@5501L10,141@5559L13,142@5611L13,143@5667L12,137@5352L349:SelectServerScreen.kt#2ojkxh");
                long m5278copywmQWz5c$default = Color.m5278copywmQWz5c$default(Color.Companion.m5316getWhite0d7_KjU(), 0.8f, 0.0f, 0.0f, 0.0f, 14, null);
                TextStyle bodyMedium = MaterialTheme.INSTANCE.getTypography(startRestartGroup, MaterialTheme.$stable).getBodyMedium();
                float f = 32;
                long m9801dpToSp8Feqmps = TypeKt.m9801dpToSp8Feqmps(Dp.m7995constructorimpl(f), startRestartGroup, 6);
                long m9801dpToSp8Feqmps2 = TypeKt.m9801dpToSp8Feqmps(Dp.m7995constructorimpl(f), startRestartGroup, 6);
                long m9801dpToSp8Feqmps3 = TypeKt.m9801dpToSp8Feqmps(Dp.m7995constructorimpl(1), startRestartGroup, 6);
                TextUnitKt.m8202checkArithmeticR2X_6o(m9801dpToSp8Feqmps3);
                z = true;
                boxScopeInstance = boxScopeInstance2;
                TextKt.m3168TextNvy7gAk("НЕТ ИЗБРАННЫХ", null, m5278copywmQWz5c$default, null, m9801dpToSp8Feqmps, null, null, null, TextUnitKt.pack(TextUnit.m8187getRawTypeimpl(m9801dpToSp8Feqmps3), -TextUnit.m8189getValueimpl(m9801dpToSp8Feqmps3)), null, null, m9801dpToSp8Feqmps2, 0, false, 0, 0, null, bodyMedium, startRestartGroup, 390, 0, 128746);
                startRestartGroup = startRestartGroup;
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                startRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                startRestartGroup.endReplaceGroup();
                function12 = onFavorite;
                i5 = i8;
                mutableState2 = mutableState3;
                i3 = i6;
                i4 = 4;
            } else {
                boxScopeInstance = boxScopeInstance2;
                z = true;
                z2 = false;
                startRestartGroup.startReplaceGroup(-1497411857);
                ComposerKt.sourceInformation(startRestartGroup, "147@5757L1044");
                Modifier fillMaxSize$default2 = SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, null);
                Alignment center2 = Alignment.Companion.getCenter();
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                MeasurePolicy maybeCachedBoxMeasurePolicy3 = BoxKt.maybeCachedBoxMeasurePolicy(center2, false);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
                int hashCode4 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(startRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap4 = startRestartGroup.getCurrentCompositionLocalMap();
                Modifier materializeModifier4 = ComposedModifierKt.materializeModifier(startRestartGroup, fillMaxSize$default2);
                Function0<ComposeUiNode> constructor4 = ComposeUiNode.Companion.getConstructor();
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                if (!(startRestartGroup.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                startRestartGroup.startReusableNode();
                if (startRestartGroup.getInserting()) {
                    startRestartGroup.createNode(constructor4);
                } else {
                    startRestartGroup.useNode();
                }
                Composer m4597constructorimpl4 = Updater.m4597constructorimpl(startRestartGroup);
                Updater.m4604setimpl(m4597constructorimpl4, maybeCachedBoxMeasurePolicy3, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.m4604setimpl(m4597constructorimpl4, currentCompositionLocalMap4, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash4 = ComposeUiNode.Companion.getSetCompositeKeyHash();
                if (m4597constructorimpl4.getInserting() || !Intrinsics.areEqual(m4597constructorimpl4.rememberedValue(), Integer.valueOf(hashCode4))) {
                    m4597constructorimpl4.updateRememberedValue(Integer.valueOf(hashCode4));
                    m4597constructorimpl4.apply(Integer.valueOf(hashCode4), setCompositeKeyHash4);
                }
                Updater.m4604setimpl(m4597constructorimpl4, materializeModifier4, ComposeUiNode.Companion.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance4 = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -851043448, "C157@6285L498,151@5913L870:SelectServerScreen.kt#2ojkxh");
                float f2 = 125;
                Modifier m881heightInVpY3zN4 = SizeKt.m881heightInVpY3zN4(Modifier.Companion, Dp.m7995constructorimpl(f2), Dp.m7995constructorimpl(300));
                GridCells.FixedSize fixedSize = new GridCells.FixedSize(Dp.m7995constructorimpl(f2), null);
                Arrangement.HorizontalOrVertical spaceEvenly = Arrangement.INSTANCE.getSpaceEvenly();
                PaddingValues m839PaddingValuesa9UjIt4$default = PaddingKt.m839PaddingValuesa9UjIt4$default(Dp.m7995constructorimpl(40), 0.0f, Dp.m7995constructorimpl(140), 0.0f, 10, null);
                GridCells.FixedSize fixedSize2 = fixedSize;
                Arrangement.HorizontalOrVertical horizontalOrVertical = spaceEvenly;
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1635126503, "CC(remember):SelectServerScreen.kt#9igjgp");
                i3 = i6;
                i4 = 4;
                i5 = i8;
                boolean z3 = (i3 == 4) | ((i5 & 7168) == 2048);
                Object rememberedValue4 = startRestartGroup.rememberedValue();
                if (z3 || rememberedValue4 == Composer.Companion.getEmpty()) {
                    function12 = onFavorite;
                    mutableState = mutableState3;
                    rememberedValue4 = new Function1() { // from class: com.miami.game.feature.select.server.ui.compose.SelectServerScreenKt$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj2) {
                            Unit SelectServerScreen$lambda$1$0$2$0$0;
                            SelectServerScreen$lambda$1$0$2$0$0 = SelectServerScreenKt.SelectServerScreen$lambda$1$0$2$0$0(SelectServerUiState.this, function12, mutableState, (LazyGridScope) obj2);
                            return SelectServerScreen$lambda$1$0$2$0$0;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue4);
                } else {
                    function12 = onFavorite;
                    mutableState = mutableState3;
                }
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                mutableState2 = mutableState;
                LazyGridDslKt.LazyHorizontalGrid(fixedSize2, m881heightInVpY3zN4, rememberLazyGridState, m839PaddingValuesa9UjIt4$default, false, null, horizontalOrVertical, null, false, null, rememberedValue4, startRestartGroup, 1575984, 0, 944);
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
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -826279374, "CC(remember):SelectServerScreen.kt#9igjgp");
            boolean z4 = i3 == i4 ? z : z2;
            if ((i5 & 896) != 256) {
                z = z2;
            }
            boolean z5 = z | z4;
            Object rememberedValue5 = startRestartGroup.rememberedValue();
            if (z5 || rememberedValue5 == Composer.Companion.getEmpty()) {
                function13 = function1;
                rememberedValue5 = new Function0() { // from class: com.miami.game.feature.select.server.ui.compose.SelectServerScreenKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit SelectServerScreen$lambda$1$1$0;
                        SelectServerScreen$lambda$1$1$0 = SelectServerScreenKt.SelectServerScreen$lambda$1$1$0(SelectServerUiState.this, mutableState2, function13);
                        return SelectServerScreen$lambda$1$1$0;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue5);
            } else {
                function13 = function1;
            }
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ScalingButtonKt.ScalingButton((Function0) rememberedValue5, boxScopeInstance.align(Modifier.Companion, Alignment.Companion.getBottomEnd()), ComposableSingletons$SelectServerScreenKt.INSTANCE.getLambda$22973248$select_server_release(), startRestartGroup, RendererCapabilities.DECODER_SUPPORT_MASK, 0);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            startRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            obj = function13;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
                obj = function13;
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            final Function1<? super ServerModel, Unit> function14 = function12;
            final Function1<? super ServerModel, Unit> function15 = obj;
            endRestartGroup.updateScope(new Function2() { // from class: com.miami.game.feature.select.server.ui.compose.SelectServerScreenKt$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj2, Object obj3) {
                    Unit SelectServerScreen$lambda$2;
                    SelectServerScreen$lambda$2 = SelectServerScreenKt.SelectServerScreen$lambda$2(SelectServerUiState.this, navigateHome, function15, function14, onFavoriteList, onMobileList, onDesktopList, i, (Composer) obj2, ((Integer) obj3).intValue());
                    return SelectServerScreen$lambda$2;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SelectServerScreen$lambda$1$0$0$0(CoroutineScope coroutineScope, LazyGridState lazyGridState) {
        BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new SelectServerScreenKt$SelectServerScreen$1$1$1$1$1(lazyGridState, null), 3, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SelectServerScreen$lambda$1$0$2$0$0(SelectServerUiState selectServerUiState, final Function1 function1, final MutableState mutableState, LazyGridScope LazyHorizontalGrid) {
        Intrinsics.checkNotNullParameter(LazyHorizontalGrid, "$this$LazyHorizontalGrid");
        final List<ServerModel> serversList = selectServerUiState.getServersList();
        final SelectServerScreenKt$SelectServerScreen$lambda$1$0$2$0$0$$inlined$items$default$1 selectServerScreenKt$SelectServerScreen$lambda$1$0$2$0$0$$inlined$items$default$1 = new Function1() { // from class: com.miami.game.feature.select.server.ui.compose.SelectServerScreenKt$SelectServerScreen$lambda$1$0$2$0$0$$inlined$items$default$1
            @Override // kotlin.jvm.functions.Function1
            public final Void invoke(ServerModel serverModel) {
                return null;
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                return invoke((ServerModel) obj);
            }
        };
        LazyHorizontalGrid.items(serversList.size(), null, null, new Function1<Integer, Object>() { // from class: com.miami.game.feature.select.server.ui.compose.SelectServerScreenKt$SelectServerScreen$lambda$1$0$2$0$0$$inlined$items$default$4
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                return invoke(num.intValue());
            }

            public final Object invoke(int i) {
                return Function1.this.invoke(serversList.get(i));
            }
        }, ComposableLambdaKt.composableLambdaInstance(-1117249557, true, new Function4<LazyGridItemScope, Integer, Composer, Integer, Unit>() { // from class: com.miami.game.feature.select.server.ui.compose.SelectServerScreenKt$SelectServerScreen$lambda$1$0$2$0$0$$inlined$items$default$5
            @Override // kotlin.jvm.functions.Function4
            public /* bridge */ /* synthetic */ Unit invoke(LazyGridItemScope lazyGridItemScope, Integer num, Composer composer, Integer num2) {
                invoke(lazyGridItemScope, num.intValue(), composer, num2.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(LazyGridItemScope lazyGridItemScope, int i, Composer composer, int i2) {
                int i3;
                ComposerKt.sourceInformation(composer, "CN(it)539@23988L22:LazyGridDsl.kt#7791vq");
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
                    ComposerKt.traceEventStart(-1117249557, i3, -1, "androidx.compose.foundation.lazy.grid.items.<anonymous> (LazyGridDsl.kt:539)");
                }
                ServerModel serverModel = (ServerModel) serversList.get(i);
                composer.startReplaceGroup(-1669064645);
                ComposerKt.sourceInformation(composer, "CN(it)*161@6473L109,159@6368L367:SelectServerScreen.kt#2ojkxh");
                ComposerKt.sourceInformationMarkerStart(composer, -1023669018, "CC(remember):SelectServerScreen.kt#9igjgp");
                Object rememberedValue = composer.rememberedValue();
                if (rememberedValue == Composer.Companion.getEmpty()) {
                    final MutableState mutableState2 = mutableState;
                    rememberedValue = (Function1) new Function1<ServerModel, Unit>() { // from class: com.miami.game.feature.select.server.ui.compose.SelectServerScreenKt$SelectServerScreen$1$1$3$1$1$1$1$1
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
                ComposerKt.sourceInformationMarkerEnd(composer);
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
    public static final Unit SelectServerScreen$lambda$1$1$0(SelectServerUiState selectServerUiState, MutableState mutableState, Function1 function1) {
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
