package com.miami.game.feature.notifications.presentation;

import android.content.Context;
import androidx.activity.compose.BackHandlerKt;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
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
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.livedata.LiveDataAdapterKt;
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
import com.miami.game.core.design.system.component.coil.blur.CoilBlurTransformation;
import com.miami.game.core.design.system.component.other.AnimatedLoadingKt;
import com.miami.game.core.design.system.component.other.CustomDividerKt;
import com.miami.game.core.design.system.component.scaling_button.ScalingButtonKt;
import com.miami.game.feature.notifications.NotificationModel;
import com.miami.game.feature.notifications.R;
import com.miami.game.ui.theme.TypeKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: NotificationsScreent.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\u001a#\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0007¢\u0006\u0002\u0010\u0006\u001a\u001b\u0010\u0007\u001a\u00020\u00012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003H\u0007¢\u0006\u0002\u0010\t¨\u0006\n²\u0006\n\u0010\u000b\u001a\u00020\fX\u008a\u0084\u0002"}, d2 = {"NotificationsScreent", "", "navigateHome", "Lkotlin/Function0;", "component", "Lcom/miami/game/feature/notifications/presentation/NotificationsComponent;", "(Lkotlin/jvm/functions/Function0;Lcom/miami/game/feature/notifications/presentation/NotificationsComponent;Landroidx/compose/runtime/Composer;I)V", "ServerTopBar", "onBack", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "notifications_release", "uiState", "Lcom/miami/game/feature/notifications/presentation/NotificationsUiState;"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class NotificationsScreentKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit NotificationsScreent$lambda$2(Function0 function0, NotificationsComponent notificationsComponent, int i, Composer composer, int i2) {
        NotificationsScreent(function0, notificationsComponent, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ServerTopBar$lambda$1(Function0 function0, int i, Composer composer, int i2) {
        ServerTopBar(function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v34 */
    public static final void NotificationsScreent(final Function0<Unit> navigateHome, final NotificationsComponent component, Composer composer, final int i) {
        int i2;
        Composer composer2;
        Intrinsics.checkNotNullParameter(navigateHome, "navigateHome");
        Intrinsics.checkNotNullParameter(component, "component");
        Composer startRestartGroup = composer.startRestartGroup(-666025695);
        ComposerKt.sourceInformation(startRestartGroup, "C(NotificationsScreent)N(navigateHome,component)45@2010L34,47@2083L29,49@2204L27,50@2309L18,55@2402L64,53@2334L211,61@2612L7,60@2550L332,69@2887L1934:NotificationsScreent.kt#21zkme");
        if ((i & 6) == 0) {
            i2 = i | (startRestartGroup.changedInstance(navigateHome) ? 4 : 2);
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= startRestartGroup.changedInstance(component) ? 32 : 16;
        }
        int i3 = i2;
        if (!startRestartGroup.shouldExecute((i3 & 19) != 18, i3 & 1)) {
            composer2 = startRestartGroup;
            composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-666025695, i3, -1, "com.miami.game.feature.notifications.presentation.NotificationsScreent (NotificationsScreent.kt:44)");
            }
            BackHandlerKt.BackHandler(false, navigateHome, startRestartGroup, (i3 << 3) & 112, 1);
            State collectAsStateWithLifecycle = FlowExtKt.collectAsStateWithLifecycle(component.getUiState(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, startRestartGroup, 0, 7);
            final State observeAsState = LiveDataAdapterKt.observeAsState(component.getHolder().getViewModel().getNotificationsLiveDataCompose(), CollectionsKt.emptyList(), startRestartGroup, 48);
            State observeAsState2 = LiveDataAdapterKt.observeAsState(component.getHolder().getViewModel().getNotificationsUnViewed(), -1, startRestartGroup, 48);
            ImageKt.Image(PainterResources_androidKt.painterResource(NotificationsScreent$lambda$0(collectAsStateWithLifecycle).getBackGroundId(), startRestartGroup, 0), (String) null, SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, null), (Alignment) null, ContentScale.Companion.getCrop(), 0.0f, (ColorFilter) null, startRestartGroup, 25008, 104);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object consume = startRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            SingletonAsyncImageKt.m9084AsyncImage10Xjiaw(ImageRequestsKt.transformations(new ImageRequest.Builder((Context) consume).data(Integer.valueOf(NotificationsScreent$lambda$0(collectAsStateWithLifecycle).getBackGroundId())), new CoilBlurTransformation(0, 0, 3, null)).build(), null, SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, null), null, null, null, ContentScale.Companion.getCrop(), 0.0f, null, 0, false, startRestartGroup, 1573296, 0, 1976);
            composer2 = startRestartGroup;
            Modifier m268backgroundbw27NRU$default = BackgroundKt.m268backgroundbw27NRU$default(SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, null), ColorKt.Color(1711276032), null, 2, null);
            ComposerKt.sourceInformationMarkerStart(composer2, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(composer2, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
            int hashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer2, 0));
            CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(composer2, m268backgroundbw27NRU$default);
            Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composer2, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!(composer2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer2.startReusableNode();
            if (composer2.getInserting()) {
                composer2.createNode(constructor);
            } else {
                composer2.useNode();
            }
            Composer m4598constructorimpl = Updater.m4598constructorimpl(composer2);
            Updater.m4605setimpl(m4598constructorimpl, maybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m4605setimpl(m4598constructorimpl, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (m4598constructorimpl.getInserting() || !Intrinsics.areEqual(m4598constructorimpl.rememberedValue(), Integer.valueOf(hashCode))) {
                m4598constructorimpl.updateRememberedValue(Integer.valueOf(hashCode));
                m4598constructorimpl.apply(Integer.valueOf(hashCode), setCompositeKeyHash);
            }
            Updater.m4605setimpl(m4598constructorimpl, materializeModifier, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer2, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer2, -545962870, "C75@3037L1778:NotificationsScreent.kt#21zkme");
            Modifier fillMaxSize$default = SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, null);
            ComposerKt.sourceInformationMarkerStart(composer2, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.Companion.getStart(), composer2, 0);
            ComposerKt.sourceInformationMarkerStart(composer2, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
            int hashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer2, 0));
            CompositionLocalMap currentCompositionLocalMap2 = composer2.getCurrentCompositionLocalMap();
            Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(composer2, fillMaxSize$default);
            Function0<ComposeUiNode> constructor2 = ComposeUiNode.Companion.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composer2, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!(composer2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer2.startReusableNode();
            if (composer2.getInserting()) {
                composer2.createNode(constructor2);
            } else {
                composer2.useNode();
            }
            Composer m4598constructorimpl2 = Updater.m4598constructorimpl(composer2);
            Updater.m4605setimpl(m4598constructorimpl2, columnMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m4605setimpl(m4598constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (m4598constructorimpl2.getInserting() || !Intrinsics.areEqual(m4598constructorimpl2.rememberedValue(), Integer.valueOf(hashCode2))) {
                m4598constructorimpl2.updateRememberedValue(Integer.valueOf(hashCode2));
                m4598constructorimpl2.apply(Integer.valueOf(hashCode2), setCompositeKeyHash2);
            }
            Updater.m4605setimpl(m4598constructorimpl2, materializeModifier2, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer2, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer2, 276628437, "C80@3188L36:NotificationsScreent.kt#21zkme");
            ServerTopBar(navigateHome, composer2, i3 & 14);
            if (((List) observeAsState.getValue()).isEmpty()) {
                composer2.startReplaceGroup(276693102);
                ComposerKt.sourceInformation(composer2, "");
                if (((Number) observeAsState2.getValue()).intValue() == 0) {
                    composer2.startReplaceGroup(276757117);
                    ComposerKt.sourceInformation(composer2, "84@3375L568");
                    Modifier fillMaxSize$default2 = SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, null);
                    Alignment center = Alignment.Companion.getCenter();
                    ComposerKt.sourceInformationMarkerStart(composer2, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                    MeasurePolicy maybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(center, false);
                    ComposerKt.sourceInformationMarkerStart(composer2, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
                    int hashCode3 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer2, 0));
                    CompositionLocalMap currentCompositionLocalMap3 = composer2.getCurrentCompositionLocalMap();
                    Modifier materializeModifier3 = ComposedModifierKt.materializeModifier(composer2, fillMaxSize$default2);
                    Function0<ComposeUiNode> constructor3 = ComposeUiNode.Companion.getConstructor();
                    ComposerKt.sourceInformationMarkerStart(composer2, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                    if (!(composer2.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composer2.startReusableNode();
                    if (composer2.getInserting()) {
                        composer2.createNode(constructor3);
                    } else {
                        composer2.useNode();
                    }
                    Composer m4598constructorimpl3 = Updater.m4598constructorimpl(composer2);
                    Updater.m4605setimpl(m4598constructorimpl3, maybeCachedBoxMeasurePolicy2, ComposeUiNode.Companion.getSetMeasurePolicy());
                    Updater.m4605setimpl(m4598constructorimpl3, currentCompositionLocalMap3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = ComposeUiNode.Companion.getSetCompositeKeyHash();
                    if (m4598constructorimpl3.getInserting() || !Intrinsics.areEqual(m4598constructorimpl3.rememberedValue(), Integer.valueOf(hashCode3))) {
                        m4598constructorimpl3.updateRememberedValue(Integer.valueOf(hashCode3));
                        m4598constructorimpl3.apply(Integer.valueOf(hashCode3), setCompositeKeyHash3);
                    }
                    Updater.m4605setimpl(m4598constructorimpl3, materializeModifier3, ComposeUiNode.Companion.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composer2, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                    BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composer2, -2088201931, "C89@3684L10,90@3750L13,91@3811L13,92@3875L12,86@3509L408:NotificationsScreent.kt#21zkme");
                    long m5279copywmQWz5c$default = Color.m5279copywmQWz5c$default(Color.Companion.m5317getWhite0d7_KjU(), 0.8f, 0.0f, 0.0f, 0.0f, 14, null);
                    TextStyle bodyMedium = MaterialTheme.INSTANCE.getTypography(composer2, MaterialTheme.$stable).getBodyMedium();
                    float f = 32;
                    long m9857dpToSp8Feqmps = TypeKt.m9857dpToSp8Feqmps(Dp.m7996constructorimpl(f), composer2, 6);
                    long m9857dpToSp8Feqmps2 = TypeKt.m9857dpToSp8Feqmps(Dp.m7996constructorimpl(f), composer2, 6);
                    long m9857dpToSp8Feqmps3 = TypeKt.m9857dpToSp8Feqmps(Dp.m7996constructorimpl(1), composer2, 6);
                    TextUnitKt.m8203checkArithmeticR2X_6o(m9857dpToSp8Feqmps3);
                    TextKt.m3169TextNvy7gAk("НЕТ УВЕДОМЛЕНИЙ", null, m5279copywmQWz5c$default, null, m9857dpToSp8Feqmps, null, null, null, TextUnitKt.pack(TextUnit.m8188getRawTypeimpl(m9857dpToSp8Feqmps3), -TextUnit.m8190getValueimpl(m9857dpToSp8Feqmps3)), null, null, m9857dpToSp8Feqmps2, 0, false, 0, 0, null, bodyMedium, composer2, 390, 0, 128746);
                    composer2 = composer2;
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    composer2.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    composer2.endReplaceGroup();
                } else {
                    composer2.startReplaceGroup(277384960);
                    ComposerKt.sourceInformation(composer2, "97@4020L181");
                    Modifier fillMaxSize$default3 = SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, null);
                    Alignment center2 = Alignment.Companion.getCenter();
                    ComposerKt.sourceInformationMarkerStart(composer2, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                    MeasurePolicy maybeCachedBoxMeasurePolicy3 = BoxKt.maybeCachedBoxMeasurePolicy(center2, false);
                    ComposerKt.sourceInformationMarkerStart(composer2, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
                    int hashCode4 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer2, 0));
                    CompositionLocalMap currentCompositionLocalMap4 = composer2.getCurrentCompositionLocalMap();
                    Modifier materializeModifier4 = ComposedModifierKt.materializeModifier(composer2, fillMaxSize$default3);
                    Function0<ComposeUiNode> constructor4 = ComposeUiNode.Companion.getConstructor();
                    ComposerKt.sourceInformationMarkerStart(composer2, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                    if (!(composer2.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composer2.startReusableNode();
                    if (composer2.getInserting()) {
                        composer2.createNode(constructor4);
                    } else {
                        composer2.useNode();
                    }
                    Composer m4598constructorimpl4 = Updater.m4598constructorimpl(composer2);
                    Updater.m4605setimpl(m4598constructorimpl4, maybeCachedBoxMeasurePolicy3, ComposeUiNode.Companion.getSetMeasurePolicy());
                    Updater.m4605setimpl(m4598constructorimpl4, currentCompositionLocalMap4, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash4 = ComposeUiNode.Companion.getSetCompositeKeyHash();
                    if (m4598constructorimpl4.getInserting() || !Intrinsics.areEqual(m4598constructorimpl4.rememberedValue(), Integer.valueOf(hashCode4))) {
                        m4598constructorimpl4.updateRememberedValue(Integer.valueOf(hashCode4));
                        m4598constructorimpl4.apply(Integer.valueOf(hashCode4), setCompositeKeyHash4);
                    }
                    Updater.m4605setimpl(m4598constructorimpl4, materializeModifier4, ComposeUiNode.Companion.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composer2, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                    BoxScopeInstance boxScopeInstance3 = BoxScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composer2, -1167154385, "C99@4154L21:NotificationsScreent.kt#21zkme");
                    AnimatedLoadingKt.m9737AnimatedLoadinguFdPcIQ(true, 0.0f, null, composer2, 6, 6);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    composer2.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    composer2.endReplaceGroup();
                }
                composer2.endReplaceGroup();
            } else {
                composer2.startReplaceGroup(277677414);
                ComposerKt.sourceInformation(composer2, "111@4653L138,105@4280L511");
                GridCells.FixedSize fixedSize = new GridCells.FixedSize(Dp.m7996constructorimpl(330), null);
                Arrangement.HorizontalOrVertical m702spacedBy0680j_4 = Arrangement.INSTANCE.m702spacedBy0680j_4(Dp.m7996constructorimpl(20));
                Arrangement.HorizontalOrVertical center3 = Arrangement.INSTANCE.getCenter();
                PaddingValues m840PaddingValuesa9UjIt4$default = PaddingKt.m840PaddingValuesa9UjIt4$default(0.0f, Dp.m7996constructorimpl(16), 0.0f, Dp.m7996constructorimpl(36), 5, null);
                Modifier fillMaxSize$default4 = SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, null);
                GridCells.FixedSize fixedSize2 = fixedSize;
                Arrangement.HorizontalOrVertical horizontalOrVertical = m702spacedBy0680j_4;
                Arrangement.HorizontalOrVertical horizontalOrVertical2 = center3;
                ComposerKt.sourceInformationMarkerStart(composer2, 147516231, "CC(remember):NotificationsScreent.kt#9igjgp");
                boolean changed = composer2.changed(observeAsState);
                Object rememberedValue = composer2.rememberedValue();
                if (changed || rememberedValue == Composer.Companion.getEmpty()) {
                    rememberedValue = new Function1() { // from class: com.miami.game.feature.notifications.presentation.NotificationsScreentKt$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            Unit NotificationsScreent$lambda$1$0$2$0;
                            NotificationsScreent$lambda$1$0$2$0 = NotificationsScreentKt.NotificationsScreent$lambda$1$0$2$0(State.this, (LazyGridScope) obj);
                            return NotificationsScreent$lambda$1$0$2$0;
                        }
                    };
                    composer2.updateRememberedValue(rememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composer2);
                LazyGridDslKt.LazyVerticalGrid(fixedSize2, fillMaxSize$default4, null, m840PaddingValuesa9UjIt4$default, false, horizontalOrVertical, horizontalOrVertical2, null, false, null, rememberedValue, composer2, 1772592, 0, 916);
                composer2 = composer2;
                composer2.endReplaceGroup();
            }
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
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: com.miami.game.feature.notifications.presentation.NotificationsScreentKt$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit NotificationsScreent$lambda$2;
                    NotificationsScreent$lambda$2 = NotificationsScreentKt.NotificationsScreent$lambda$2(Function0.this, component, i, (Composer) obj, ((Integer) obj2).intValue());
                    return NotificationsScreent$lambda$2;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit NotificationsScreent$lambda$1$0$2$0(State state, LazyGridScope LazyVerticalGrid) {
        Intrinsics.checkNotNullParameter(LazyVerticalGrid, "$this$LazyVerticalGrid");
        final List list = (List) state.getValue();
        final NotificationsScreentKt$NotificationsScreent$lambda$1$0$2$0$$inlined$items$default$1 notificationsScreentKt$NotificationsScreent$lambda$1$0$2$0$$inlined$items$default$1 = new Function1() { // from class: com.miami.game.feature.notifications.presentation.NotificationsScreentKt$NotificationsScreent$lambda$1$0$2$0$$inlined$items$default$1
            @Override // kotlin.jvm.functions.Function1
            public final Void invoke(NotificationModel notificationModel) {
                return null;
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                return invoke((NotificationModel) obj);
            }
        };
        LazyVerticalGrid.items(list.size(), null, null, new Function1<Integer, Object>() { // from class: com.miami.game.feature.notifications.presentation.NotificationsScreentKt$NotificationsScreent$lambda$1$0$2$0$$inlined$items$default$4
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                return invoke(num.intValue());
            }

            public final Object invoke(int i) {
                return Function1.this.invoke(list.get(i));
            }
        }, ComposableLambdaKt.composableLambdaInstance(-1117249557, true, new Function4<LazyGridItemScope, Integer, Composer, Integer, Unit>() { // from class: com.miami.game.feature.notifications.presentation.NotificationsScreentKt$NotificationsScreent$lambda$1$0$2$0$$inlined$items$default$5
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
                composer.startReplaceGroup(-1200147528);
                ComposerKt.sourceInformation(composer, "CN(it)*113@4731L20:NotificationsScreent.kt#21zkme");
                NotificationItemKt.NotificationItem((NotificationModel) list.get(i), composer, 0);
                composer.endReplaceGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }));
        return Unit.INSTANCE;
    }

    public static final void ServerTopBar(final Function0<Unit> onBack, Composer composer, final int i) {
        int i2;
        Intrinsics.checkNotNullParameter(onBack, "onBack");
        Composer startRestartGroup = composer.startRestartGroup(-1262971139);
        ComposerKt.sourceInformation(startRestartGroup, "C(ServerTopBar)N(onBack)126@4885L1246:NotificationsScreent.kt#21zkme");
        if ((i & 6) == 0) {
            i2 = (startRestartGroup.changedInstance(onBack) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if (!startRestartGroup.shouldExecute((i2 & 3) != 2, i2 & 1)) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1262971139, i2, -1, "com.miami.game.feature.notifications.presentation.ServerTopBar (NotificationsScreent.kt:125)");
            }
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
            int hashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(startRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, Modifier.Companion);
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
            Composer m4598constructorimpl = Updater.m4598constructorimpl(startRestartGroup);
            Updater.m4605setimpl(m4598constructorimpl, maybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m4605setimpl(m4598constructorimpl, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (m4598constructorimpl.getInserting() || !Intrinsics.areEqual(m4598constructorimpl.rememberedValue(), Integer.valueOf(hashCode))) {
                m4598constructorimpl.updateRememberedValue(Integer.valueOf(hashCode));
                m4598constructorimpl.apply(Integer.valueOf(hashCode), setCompositeKeyHash);
            }
            Updater.m4605setimpl(m4598constructorimpl, materializeModifier, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1757134564, "C127@4901L1077,156@5987L138:NotificationsScreent.kt#21zkme");
            Alignment.Vertical centerVertically = Alignment.Companion.getCenterVertically();
            Arrangement.HorizontalOrVertical spaceBetween = Arrangement.INSTANCE.getSpaceBetween();
            Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, null);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(spaceBetween, centerVertically, startRestartGroup, 54);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
            int hashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(startRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(startRestartGroup, fillMaxWidth$default);
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
            Composer m4598constructorimpl2 = Updater.m4598constructorimpl(startRestartGroup);
            Updater.m4605setimpl(m4598constructorimpl2, rowMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m4605setimpl(m4598constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (m4598constructorimpl2.getInserting() || !Intrinsics.areEqual(m4598constructorimpl2.rememberedValue(), Integer.valueOf(hashCode2))) {
                m4598constructorimpl2.updateRememberedValue(Integer.valueOf(hashCode2));
                m4598constructorimpl2.apply(Integer.valueOf(hashCode2), setCompositeKeyHash2);
            }
            Updater.m4605setimpl(m4598constructorimpl2, materializeModifier2, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -789291317, "C132@5099L869:NotificationsScreent.kt#21zkme");
            Alignment.Vertical centerVertically2 = Alignment.Companion.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            MeasurePolicy rowMeasurePolicy2 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically2, startRestartGroup, 48);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
            int hashCode3 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(startRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap3 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier3 = ComposedModifierKt.materializeModifier(startRestartGroup, Modifier.Companion);
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
            Composer m4598constructorimpl3 = Updater.m4598constructorimpl(startRestartGroup);
            Updater.m4605setimpl(m4598constructorimpl3, rowMeasurePolicy2, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m4605setimpl(m4598constructorimpl3, currentCompositionLocalMap3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (m4598constructorimpl3.getInserting() || !Intrinsics.areEqual(m4598constructorimpl3.rememberedValue(), Integer.valueOf(hashCode3))) {
                m4598constructorimpl3.updateRememberedValue(Integer.valueOf(hashCode3));
                m4598constructorimpl3.apply(Integer.valueOf(hashCode3), setCompositeKeyHash3);
            }
            Updater.m4605setimpl(m4598constructorimpl3, materializeModifier3, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScopeInstance rowScopeInstance2 = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1261122335, "C136@5244L56,135@5199L450,148@5693L53,147@5666L288:NotificationsScreent.kt#21zkme");
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -317775289, "CC(remember):NotificationsScreent.kt#9igjgp");
            boolean z = (i2 & 14) == 4;
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (z || rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new Function0() { // from class: com.miami.game.feature.notifications.presentation.NotificationsScreentKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit ServerTopBar$lambda$0$0$0$0$0;
                        ServerTopBar$lambda$0$0$0$0$0 = NotificationsScreentKt.ServerTopBar$lambda$0$0$0$0$0(Function0.this);
                        return ServerTopBar$lambda$0$0$0$0$0;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ScalingButtonKt.ScalingButton((Function0) rememberedValue, null, ComposableSingletons$NotificationsScreentKt.INSTANCE.m9822getLambda$556808038$notifications_release(), startRestartGroup, RendererCapabilities.DECODER_SUPPORT_MASK, 2);
            ImageKt.Image(PainterResources_androidKt.painterResource(R.drawable.notification_topbar_label, startRestartGroup, 0), (String) null, OffsetKt.m798offsetVpY3zN4$default(SizeKt.m881height3ABfNKs(Modifier.Companion, Dp.m7996constructorimpl(30)), Dp.m7996constructorimpl(-Dp.m7996constructorimpl(12)), 0.0f, 2, null), (Alignment) null, ContentScale.Companion.getFillHeight(), 0.0f, (ColorFilter) null, startRestartGroup, 25008, 104);
            startRestartGroup = startRestartGroup;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            startRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            startRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            CustomDividerKt.CustomDivider(OffsetKt.m798offsetVpY3zN4$default(boxScopeInstance.align(Modifier.Companion, Alignment.Companion.getBottomCenter()), 0.0f, Dp.m7996constructorimpl(-Dp.m7996constructorimpl(0)), 1, null), startRestartGroup, 0, 0);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            startRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: com.miami.game.feature.notifications.presentation.NotificationsScreentKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit ServerTopBar$lambda$1;
                    ServerTopBar$lambda$1 = NotificationsScreentKt.ServerTopBar$lambda$1(Function0.this, i, (Composer) obj, ((Integer) obj2).intValue());
                    return ServerTopBar$lambda$1;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ServerTopBar$lambda$0$0$0$0$0(Function0 function0) {
        function0.invoke();
        return Unit.INSTANCE;
    }

    private static final NotificationsUiState NotificationsScreent$lambda$0(State<NotificationsUiState> state) {
        return state.getValue();
    }
}
