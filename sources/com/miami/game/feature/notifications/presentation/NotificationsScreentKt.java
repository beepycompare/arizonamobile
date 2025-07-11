package com.miami.game.feature.notifications.presentation;

import androidx.activity.compose.BackHandlerKt;
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
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\u001a#\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0007¢\u0006\u0002\u0010\u0006\u001a\u001b\u0010\u0007\u001a\u00020\u00012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003H\u0007¢\u0006\u0002\u0010\t¨\u0006\n²\u0006\n\u0010\u000b\u001a\u00020\fX\u008a\u0084\u0002"}, d2 = {"NotificationsScreent", "", "navigateHome", "Lkotlin/Function0;", "component", "Lcom/miami/game/feature/notifications/presentation/NotificationsComponent;", "(Lkotlin/jvm/functions/Function0;Lcom/miami/game/feature/notifications/presentation/NotificationsComponent;Landroidx/compose/runtime/Composer;I)V", "ServerTopBar", "onBack", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "notifications_release_web", "uiState", "Lcom/miami/game/feature/notifications/presentation/NotificationsUiState;"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class NotificationsScreentKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit NotificationsScreent$lambda$8(Function0 function0, NotificationsComponent notificationsComponent, int i, Composer composer, int i2) {
        NotificationsScreent(function0, notificationsComponent, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ServerTopBar$lambda$14(Function0 function0, int i, Composer composer, int i2) {
        ServerTopBar(function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v6 */
    public static final void NotificationsScreent(final Function0<Unit> navigateHome, final NotificationsComponent component, Composer composer, final int i) {
        int i2;
        Composer composer2;
        Intrinsics.checkNotNullParameter(navigateHome, "navigateHome");
        Intrinsics.checkNotNullParameter(component, "component");
        Composer startRestartGroup = composer.startRestartGroup(-666025695);
        ComposerKt.sourceInformation(startRestartGroup, "C(NotificationsScreent)P(1)48@2193L34,50@2266L29,52@2387L27,53@2492L18,58@2585L64,56@2517L216,64@2738L1891:NotificationsScreent.kt#21zkme");
        if ((i & 6) == 0) {
            i2 = (startRestartGroup.changedInstance(navigateHome) ? 4 : 2) | i;
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
                ComposerKt.traceEventStart(-666025695, i3, -1, "com.miami.game.feature.notifications.presentation.NotificationsScreent (NotificationsScreent.kt:47)");
            }
            BackHandlerKt.BackHandler(false, navigateHome, startRestartGroup, (i3 << 3) & 112, 1);
            State collectAsStateWithLifecycle = FlowExtKt.collectAsStateWithLifecycle(component.getUiState(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, startRestartGroup, 0, 7);
            final State observeAsState = LiveDataAdapterKt.observeAsState(component.getHolder().getViewModel().getNotificationsLiveDataCompose(), CollectionsKt.emptyList(), startRestartGroup, 48);
            State observeAsState2 = LiveDataAdapterKt.observeAsState(component.getHolder().getViewModel().getNotificationsUnViewed(), -1, startRestartGroup, 48);
            ImageKt.Image(PainterResources_androidKt.painterResource(NotificationsScreent$lambda$0(collectAsStateWithLifecycle).getBackGroundId(), startRestartGroup, 0), (String) null, SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, null), (Alignment) null, ContentScale.Companion.getCrop(), 0.0f, (ColorFilter) null, startRestartGroup, 25008, 104);
            composer2 = startRestartGroup;
            Modifier fillMaxSize$default = SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, null);
            ComposerKt.sourceInformationMarkerStart(composer2, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
            MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(composer2, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
            CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(composer2, fillMaxSize$default);
            Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composer2, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
            if (!(composer2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer2.startReusableNode();
            if (composer2.getInserting()) {
                composer2.createNode(constructor);
            } else {
                composer2.useNode();
            }
            Composer m3520constructorimpl = Updater.m3520constructorimpl(composer2);
            Updater.m3527setimpl(m3520constructorimpl, maybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m3527setimpl(m3520constructorimpl, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (m3520constructorimpl.getInserting() || !Intrinsics.areEqual(m3520constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                m3520constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                m3520constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m3527setimpl(m3520constructorimpl, materializeModifier, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer2, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer2, -545962870, "C69@2845L1778:NotificationsScreent.kt#21zkme");
            Modifier fillMaxSize$default2 = SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, null);
            ComposerKt.sourceInformationMarkerStart(composer2, -483455358, "CC(Column)P(2,3,1)87@4442L61,88@4508L133:Column.kt#2w3rfo");
            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.Companion.getStart(), composer2, 0);
            ComposerKt.sourceInformationMarkerStart(composer2, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
            CompositionLocalMap currentCompositionLocalMap2 = composer2.getCurrentCompositionLocalMap();
            Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(composer2, fillMaxSize$default2);
            Function0<ComposeUiNode> constructor2 = ComposeUiNode.Companion.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composer2, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
            if (!(composer2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer2.startReusableNode();
            if (composer2.getInserting()) {
                composer2.createNode(constructor2);
            } else {
                composer2.useNode();
            }
            Composer m3520constructorimpl2 = Updater.m3520constructorimpl(composer2);
            Updater.m3527setimpl(m3520constructorimpl2, columnMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m3527setimpl(m3520constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (m3520constructorimpl2.getInserting() || !Intrinsics.areEqual(m3520constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                m3520constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                m3520constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
            }
            Updater.m3527setimpl(m3520constructorimpl2, materializeModifier2, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer2, -384672921, "C89@4556L9:Column.kt#2w3rfo");
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer2, 276628437, "C74@2996L36:NotificationsScreent.kt#21zkme");
            ServerTopBar(navigateHome, composer2, i3 & 14);
            if (((List) observeAsState.getValue()).isEmpty()) {
                composer2.startReplaceGroup(276693102);
                ComposerKt.sourceInformation(composer2, "");
                if (((Number) observeAsState2.getValue()).intValue() == 0) {
                    composer2.startReplaceGroup(276757117);
                    ComposerKt.sourceInformation(composer2, "78@3183L568");
                    Modifier fillMaxSize$default3 = SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, null);
                    Alignment center = Alignment.Companion.getCenter();
                    ComposerKt.sourceInformationMarkerStart(composer2, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                    MeasurePolicy maybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(center, false);
                    ComposerKt.sourceInformationMarkerStart(composer2, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                    int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                    CompositionLocalMap currentCompositionLocalMap3 = composer2.getCurrentCompositionLocalMap();
                    Modifier materializeModifier3 = ComposedModifierKt.materializeModifier(composer2, fillMaxSize$default3);
                    Function0<ComposeUiNode> constructor3 = ComposeUiNode.Companion.getConstructor();
                    ComposerKt.sourceInformationMarkerStart(composer2, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
                    if (!(composer2.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composer2.startReusableNode();
                    if (composer2.getInserting()) {
                        composer2.createNode(constructor3);
                    } else {
                        composer2.useNode();
                    }
                    Composer m3520constructorimpl3 = Updater.m3520constructorimpl(composer2);
                    Updater.m3527setimpl(m3520constructorimpl3, maybeCachedBoxMeasurePolicy2, ComposeUiNode.Companion.getSetMeasurePolicy());
                    Updater.m3527setimpl(m3520constructorimpl3, currentCompositionLocalMap3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = ComposeUiNode.Companion.getSetCompositeKeyHash();
                    if (m3520constructorimpl3.getInserting() || !Intrinsics.areEqual(m3520constructorimpl3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                        m3520constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                        m3520constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
                    }
                    Updater.m3527setimpl(m3520constructorimpl3, materializeModifier3, ComposeUiNode.Companion.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composer2, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
                    BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composer2, -2088201931, "C83@3492L10,84@3558L13,85@3619L13,86@3683L12,80@3317L408:NotificationsScreent.kt#21zkme");
                    long m4077copywmQWz5c$default = Color.m4077copywmQWz5c$default(Color.Companion.m4115getWhite0d7_KjU(), 0.8f, 0.0f, 0.0f, 0.0f, 14, null);
                    TextStyle bodyMedium = MaterialTheme.INSTANCE.getTypography(composer2, MaterialTheme.$stable).getBodyMedium();
                    float f = 32;
                    long m8428dpToSp8Feqmps = TypeKt.m8428dpToSp8Feqmps(Dp.m6684constructorimpl(f), composer2, 6);
                    long m8428dpToSp8Feqmps2 = TypeKt.m8428dpToSp8Feqmps(Dp.m6684constructorimpl(f), composer2, 6);
                    long m8428dpToSp8Feqmps3 = TypeKt.m8428dpToSp8Feqmps(Dp.m6684constructorimpl(1), composer2, 6);
                    TextUnitKt.m6891checkArithmeticR2X_6o(m8428dpToSp8Feqmps3);
                    TextKt.m2497Text4IGK_g("НЕТ УВЕДОМЛЕНИЙ", (Modifier) null, m4077copywmQWz5c$default, m8428dpToSp8Feqmps, (FontStyle) null, (FontWeight) null, (FontFamily) null, TextUnitKt.pack(TextUnit.m6876getRawTypeimpl(m8428dpToSp8Feqmps3), -TextUnit.m6878getValueimpl(m8428dpToSp8Feqmps3)), (TextDecoration) null, (TextAlign) null, m8428dpToSp8Feqmps2, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, bodyMedium, composer2, 390, 0, 64370);
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
                    ComposerKt.sourceInformation(composer2, "91@3828L181");
                    Modifier fillMaxSize$default4 = SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, null);
                    Alignment center2 = Alignment.Companion.getCenter();
                    ComposerKt.sourceInformationMarkerStart(composer2, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                    MeasurePolicy maybeCachedBoxMeasurePolicy3 = BoxKt.maybeCachedBoxMeasurePolicy(center2, false);
                    ComposerKt.sourceInformationMarkerStart(composer2, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                    int currentCompositeKeyHash4 = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                    CompositionLocalMap currentCompositionLocalMap4 = composer2.getCurrentCompositionLocalMap();
                    Modifier materializeModifier4 = ComposedModifierKt.materializeModifier(composer2, fillMaxSize$default4);
                    Function0<ComposeUiNode> constructor4 = ComposeUiNode.Companion.getConstructor();
                    ComposerKt.sourceInformationMarkerStart(composer2, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
                    if (!(composer2.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composer2.startReusableNode();
                    if (composer2.getInserting()) {
                        composer2.createNode(constructor4);
                    } else {
                        composer2.useNode();
                    }
                    Composer m3520constructorimpl4 = Updater.m3520constructorimpl(composer2);
                    Updater.m3527setimpl(m3520constructorimpl4, maybeCachedBoxMeasurePolicy3, ComposeUiNode.Companion.getSetMeasurePolicy());
                    Updater.m3527setimpl(m3520constructorimpl4, currentCompositionLocalMap4, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash4 = ComposeUiNode.Companion.getSetCompositeKeyHash();
                    if (m3520constructorimpl4.getInserting() || !Intrinsics.areEqual(m3520constructorimpl4.rememberedValue(), Integer.valueOf(currentCompositeKeyHash4))) {
                        m3520constructorimpl4.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash4));
                        m3520constructorimpl4.apply(Integer.valueOf(currentCompositeKeyHash4), setCompositeKeyHash4);
                    }
                    Updater.m3527setimpl(m3520constructorimpl4, materializeModifier4, ComposeUiNode.Companion.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composer2, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
                    BoxScopeInstance boxScopeInstance3 = BoxScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composer2, -1167154385, "C93@3962L21:NotificationsScreent.kt#21zkme");
                    AnimatedLoadingKt.m8316AnimatedLoadinguFdPcIQ(true, 0.0f, null, composer2, 6, 6);
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
                composer2.startReplaceGroup(277660550);
                ComposerKt.sourceInformation(composer2, "105@4461L138,99@4088L511");
                GridCells.FixedSize fixedSize = new GridCells.FixedSize(Dp.m6684constructorimpl(330), null);
                Arrangement.HorizontalOrVertical m619spacedBy0680j_4 = Arrangement.INSTANCE.m619spacedBy0680j_4(Dp.m6684constructorimpl(20));
                Arrangement.HorizontalOrVertical center3 = Arrangement.INSTANCE.getCenter();
                PaddingValues m735PaddingValuesa9UjIt4$default = PaddingKt.m735PaddingValuesa9UjIt4$default(0.0f, Dp.m6684constructorimpl(16), 0.0f, Dp.m6684constructorimpl(36), 5, null);
                Modifier fillMaxSize$default5 = SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, null);
                GridCells.FixedSize fixedSize2 = fixedSize;
                Arrangement.HorizontalOrVertical horizontalOrVertical = m619spacedBy0680j_4;
                Arrangement.HorizontalOrVertical horizontalOrVertical2 = center3;
                ComposerKt.sourceInformationMarkerStart(composer2, 147516231, "CC(remember):NotificationsScreent.kt#9igjgp");
                boolean changed = composer2.changed(observeAsState);
                Object rememberedValue = composer2.rememberedValue();
                if (changed || rememberedValue == Composer.Companion.getEmpty()) {
                    rememberedValue = new Function1() { // from class: com.miami.game.feature.notifications.presentation.NotificationsScreentKt$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            Unit NotificationsScreent$lambda$7$lambda$6$lambda$5$lambda$4;
                            NotificationsScreent$lambda$7$lambda$6$lambda$5$lambda$4 = NotificationsScreentKt.NotificationsScreent$lambda$7$lambda$6$lambda$5$lambda$4(State.this, (LazyGridScope) obj);
                            return NotificationsScreent$lambda$7$lambda$6$lambda$5$lambda$4;
                        }
                    };
                    composer2.updateRememberedValue(rememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composer2);
                LazyGridDslKt.LazyVerticalGrid(fixedSize2, fillMaxSize$default5, null, m735PaddingValuesa9UjIt4$default, false, horizontalOrVertical, horizontalOrVertical2, null, false, null, rememberedValue, composer2, 1772592, 0, 916);
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
                    Unit NotificationsScreent$lambda$8;
                    NotificationsScreent$lambda$8 = NotificationsScreentKt.NotificationsScreent$lambda$8(Function0.this, component, i, (Composer) obj, ((Integer) obj2).intValue());
                    return NotificationsScreent$lambda$8;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit NotificationsScreent$lambda$7$lambda$6$lambda$5$lambda$4(State state, LazyGridScope LazyVerticalGrid) {
        Intrinsics.checkNotNullParameter(LazyVerticalGrid, "$this$LazyVerticalGrid");
        final List list = (List) state.getValue();
        final NotificationsScreentKt$NotificationsScreent$lambda$7$lambda$6$lambda$5$lambda$4$$inlined$items$default$1 notificationsScreentKt$NotificationsScreent$lambda$7$lambda$6$lambda$5$lambda$4$$inlined$items$default$1 = new Function1() { // from class: com.miami.game.feature.notifications.presentation.NotificationsScreentKt$NotificationsScreent$lambda$7$lambda$6$lambda$5$lambda$4$$inlined$items$default$1
            @Override // kotlin.jvm.functions.Function1
            public final Void invoke(NotificationModel notificationModel) {
                return null;
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                return invoke((NotificationModel) obj);
            }
        };
        LazyVerticalGrid.items(list.size(), null, null, new Function1<Integer, Object>() { // from class: com.miami.game.feature.notifications.presentation.NotificationsScreentKt$NotificationsScreent$lambda$7$lambda$6$lambda$5$lambda$4$$inlined$items$default$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                return invoke(num.intValue());
            }

            public final Object invoke(int i) {
                return Function1.this.invoke(list.get(i));
            }
        }, ComposableLambdaKt.composableLambdaInstance(699646206, true, new Function4<LazyGridItemScope, Integer, Composer, Integer, Unit>() { // from class: com.miami.game.feature.notifications.presentation.NotificationsScreentKt$NotificationsScreent$lambda$7$lambda$6$lambda$5$lambda$4$$inlined$items$default$5
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
                composer.startReplaceGroup(-1200147528);
                ComposerKt.sourceInformation(composer, "C*107@4539L20:NotificationsScreent.kt#21zkme");
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
        ComposerKt.sourceInformation(startRestartGroup, "C(ServerTopBar)120@4693L1246:NotificationsScreent.kt#21zkme");
        if ((i & 6) == 0) {
            i2 = (startRestartGroup.changedInstance(onBack) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if (!startRestartGroup.shouldExecute((i2 & 3) != 2, i2 & 1)) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1262971139, i2, -1, "com.miami.game.feature.notifications.presentation.ServerTopBar (NotificationsScreent.kt:119)");
            }
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
            MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, Modifier.Companion);
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
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1757134564, "C121@4709L1077,150@5795L138:NotificationsScreent.kt#21zkme");
            Alignment.Vertical centerVertically = Alignment.Companion.getCenterVertically();
            Arrangement.HorizontalOrVertical spaceBetween = Arrangement.INSTANCE.getSpaceBetween();
            Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, null);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 693286680, "CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo");
            MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(spaceBetween, centerVertically, startRestartGroup, 54);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(startRestartGroup, fillMaxWidth$default);
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
            Updater.m3527setimpl(m3520constructorimpl2, rowMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m3527setimpl(m3520constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (m3520constructorimpl2.getInserting() || !Intrinsics.areEqual(m3520constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                m3520constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                m3520constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
            }
            Updater.m3527setimpl(m3520constructorimpl2, materializeModifier2, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -407735110, "C101@5232L9:Row.kt#2w3rfo");
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -789291317, "C126@4907L869:NotificationsScreent.kt#21zkme");
            Alignment.Vertical centerVertically2 = Alignment.Companion.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 693286680, "CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo");
            MeasurePolicy rowMeasurePolicy2 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically2, startRestartGroup, 48);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap3 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier3 = ComposedModifierKt.materializeModifier(startRestartGroup, Modifier.Companion);
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
            Updater.m3527setimpl(m3520constructorimpl3, rowMeasurePolicy2, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m3527setimpl(m3520constructorimpl3, currentCompositionLocalMap3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (m3520constructorimpl3.getInserting() || !Intrinsics.areEqual(m3520constructorimpl3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                m3520constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                m3520constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
            }
            Updater.m3527setimpl(m3520constructorimpl3, materializeModifier3, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -407735110, "C101@5232L9:Row.kt#2w3rfo");
            RowScopeInstance rowScopeInstance2 = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1261122335, "C130@5052L56,129@5007L450,142@5501L53,141@5474L288:NotificationsScreent.kt#21zkme");
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -317775289, "CC(remember):NotificationsScreent.kt#9igjgp");
            boolean z = (i2 & 14) == 4;
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (z || rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new Function0() { // from class: com.miami.game.feature.notifications.presentation.NotificationsScreentKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit ServerTopBar$lambda$13$lambda$12$lambda$11$lambda$10$lambda$9;
                        ServerTopBar$lambda$13$lambda$12$lambda$11$lambda$10$lambda$9 = NotificationsScreentKt.ServerTopBar$lambda$13$lambda$12$lambda$11$lambda$10$lambda$9(Function0.this);
                        return ServerTopBar$lambda$13$lambda$12$lambda$11$lambda$10$lambda$9;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ScalingButtonKt.ScalingButton((Function0) rememberedValue, null, ComposableSingletons$NotificationsScreentKt.INSTANCE.m8397getLambda$556808038$notifications_release_web(), startRestartGroup, RendererCapabilities.DECODER_SUPPORT_MASK, 2);
            ImageKt.Image(PainterResources_androidKt.painterResource(R.drawable.notification_topbar_label, startRestartGroup, 0), (String) null, OffsetKt.m698offsetVpY3zN4$default(SizeKt.m771height3ABfNKs(Modifier.Companion, Dp.m6684constructorimpl(30)), Dp.m6684constructorimpl(-Dp.m6684constructorimpl(12)), 0.0f, 2, null), (Alignment) null, ContentScale.Companion.getFillHeight(), 0.0f, (ColorFilter) null, startRestartGroup, 25008, 104);
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
            CustomDividerKt.CustomDivider(OffsetKt.m698offsetVpY3zN4$default(boxScopeInstance.align(Modifier.Companion, Alignment.Companion.getBottomCenter()), 0.0f, Dp.m6684constructorimpl(-Dp.m6684constructorimpl(0)), 1, null), startRestartGroup, 0, 0);
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
                    Unit ServerTopBar$lambda$14;
                    ServerTopBar$lambda$14 = NotificationsScreentKt.ServerTopBar$lambda$14(Function0.this, i, (Composer) obj, ((Integer) obj2).intValue());
                    return ServerTopBar$lambda$14;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ServerTopBar$lambda$13$lambda$12$lambda$11$lambda$10$lambda$9(Function0 function0) {
        function0.invoke();
        return Unit.INSTANCE;
    }

    private static final NotificationsUiState NotificationsScreent$lambda$0(State<NotificationsUiState> state) {
        return state.getValue();
    }
}
