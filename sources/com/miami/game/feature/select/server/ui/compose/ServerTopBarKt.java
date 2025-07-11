package com.miami.game.feature.select.server.ui.compose;

import androidx.compose.foundation.BorderKt;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.MaterialTheme;
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
import com.miami.game.core.design.system.component.other.CustomDividerKt;
import com.miami.game.core.design.system.component.scaling_button.ScalingButtonKt;
import com.miami.game.core.server.model.ServerStateCategory;
import com.miami.game.feature.select.server.R;
import com.miami.game.feature.select.server.ui.model.SelectServerUiState;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: ServerTopBar.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0004\u001aM\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00010\u0005H\u0007¢\u0006\u0002\u0010\t\u001a#\u0010\n\u001a\u00020\u00012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\u0006\u0010\f\u001a\u00020\rH\u0007¢\u0006\u0002\u0010\u000e\u001a#\u0010\u000f\u001a\u00020\u00012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\u0006\u0010\f\u001a\u00020\rH\u0007¢\u0006\u0002\u0010\u000e\u001a#\u0010\u0010\u001a\u00020\u00012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\u0006\u0010\f\u001a\u00020\rH\u0007¢\u0006\u0002\u0010\u000e¨\u0006\u0011"}, d2 = {"ServerTopBar", "", "uiState", "Lcom/miami/game/feature/select/server/ui/model/SelectServerUiState;", "onBack", "Lkotlin/Function0;", "onFavorite", "onMobile", "onDesktop", "(Lcom/miami/game/feature/select/server/ui/model/SelectServerUiState;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "FavoriteButtonTopBar", "onClick", "isSelected", "", "(Lkotlin/jvm/functions/Function0;ZLandroidx/compose/runtime/Composer;I)V", "MobileButtonTopBar", "DesktopButtonTopBar", "select-server_release_web"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ServerTopBarKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DesktopButtonTopBar$lambda$14(Function0 function0, boolean z, int i, Composer composer, int i2) {
        DesktopButtonTopBar(function0, z, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FavoriteButtonTopBar$lambda$8(Function0 function0, boolean z, int i, Composer composer, int i2) {
        FavoriteButtonTopBar(function0, z, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit MobileButtonTopBar$lambda$12(Function0 function0, boolean z, int i, Composer composer, int i2) {
        MobileButtonTopBar(function0, z, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ServerTopBar$lambda$6(SelectServerUiState selectServerUiState, Function0 function0, Function0 function02, Function0 function03, Function0 function04, int i, Composer composer, int i2) {
        ServerTopBar(selectServerUiState, function0, function02, function03, function04, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final void ServerTopBar(final SelectServerUiState uiState, final Function0<Unit> onBack, final Function0<Unit> onFavorite, final Function0<Unit> onMobile, final Function0<Unit> onDesktop, Composer composer, final int i) {
        int i2;
        Intrinsics.checkNotNullParameter(uiState, "uiState");
        Intrinsics.checkNotNullParameter(onBack, "onBack");
        Intrinsics.checkNotNullParameter(onFavorite, "onFavorite");
        Intrinsics.checkNotNullParameter(onMobile, "onMobile");
        Intrinsics.checkNotNullParameter(onDesktop, "onDesktop");
        Composer startRestartGroup = composer.startRestartGroup(872402305);
        ComposerKt.sourceInformation(startRestartGroup, "C(ServerTopBar)P(4!1,2,3)35@1377L2046:ServerTopBar.kt#2ojkxh");
        if ((i & 6) == 0) {
            i2 = (startRestartGroup.changed(uiState) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= startRestartGroup.changedInstance(onBack) ? 32 : 16;
        }
        if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i2 |= startRestartGroup.changedInstance(onFavorite) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= startRestartGroup.changedInstance(onMobile) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i2 |= startRestartGroup.changedInstance(onDesktop) ? 16384 : 8192;
        }
        int i3 = i2;
        if (!startRestartGroup.shouldExecute((i3 & 9363) != 9362, i3 & 1)) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(872402305, i3, -1, "com.miami.game.feature.select.server.ui.compose.ServerTopBar (ServerTopBar.kt:34)");
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
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 862334144, "C36@1393L1877,83@3279L138:ServerTopBar.kt#2ojkxh");
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
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -241657689, "C41@1591L838,63@2442L818:ServerTopBar.kt#2ojkxh");
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
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -164794852, "C45@1736L56,44@1691L450,57@2185L47,56@2158L257:ServerTopBar.kt#2ojkxh");
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -2083525173, "CC(remember):ServerTopBar.kt#9igjgp");
            boolean z = (i3 & 112) == 32;
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (z || rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new Function0() { // from class: com.miami.game.feature.select.server.ui.compose.ServerTopBarKt$$ExternalSyntheticLambda5
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit ServerTopBar$lambda$5$lambda$4$lambda$2$lambda$1$lambda$0;
                        ServerTopBar$lambda$5$lambda$4$lambda$2$lambda$1$lambda$0 = ServerTopBarKt.ServerTopBar$lambda$5$lambda$4$lambda$2$lambda$1$lambda$0(Function0.this);
                        return ServerTopBar$lambda$5$lambda$4$lambda$2$lambda$1$lambda$0;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ScalingButtonKt.ScalingButton((Function0) rememberedValue, null, ComposableSingletons$ServerTopBarKt.INSTANCE.getLambda$562847262$select_server_release_web(), startRestartGroup, RendererCapabilities.DECODER_SUPPORT_MASK, 2);
            float f = 30;
            float f2 = 12;
            ImageKt.Image(PainterResources_androidKt.painterResource(R.drawable.select_server_label, startRestartGroup, 0), (String) null, OffsetKt.m698offsetVpY3zN4$default(SizeKt.m771height3ABfNKs(Modifier.Companion, Dp.m6684constructorimpl(f)), Dp.m6684constructorimpl(-Dp.m6684constructorimpl(f2)), 0.0f, 2, null), (Alignment) null, ContentScale.Companion.getFillHeight(), 0.0f, (ColorFilter) null, startRestartGroup, 25008, 104);
            startRestartGroup = startRestartGroup;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            startRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            Modifier m742paddingqDBjuR0$default = PaddingKt.m742paddingqDBjuR0$default(SizeKt.m771height3ABfNKs(Modifier.Companion, Dp.m6684constructorimpl(f)), 0.0f, 0.0f, Dp.m6684constructorimpl(f2), 0.0f, 11, null);
            Alignment.Vertical centerVertically3 = Alignment.Companion.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 693286680, "CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo");
            MeasurePolicy rowMeasurePolicy3 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.m619spacedBy0680j_4(Dp.m6684constructorimpl(-Dp.m6684constructorimpl(f2))), centerVertically3, startRestartGroup, 54);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash4 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap4 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier4 = ComposedModifierKt.materializeModifier(startRestartGroup, m742paddingqDBjuR0$default);
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
            Updater.m3527setimpl(m3520constructorimpl4, rowMeasurePolicy3, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m3527setimpl(m3520constructorimpl4, currentCompositionLocalMap4, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash4 = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (m3520constructorimpl4.getInserting() || !Intrinsics.areEqual(m3520constructorimpl4.rememberedValue(), Integer.valueOf(currentCompositeKeyHash4))) {
                m3520constructorimpl4.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash4));
                m3520constructorimpl4.apply(Integer.valueOf(currentCompositeKeyHash4), setCompositeKeyHash4);
            }
            Updater.m3527setimpl(m3520constructorimpl4, materializeModifier4, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -407735110, "C101@5232L9:Row.kt#2w3rfo");
            RowScopeInstance rowScopeInstance3 = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1459989590, "C69@2705L172,73@2894L166,77@3077L169:ServerTopBar.kt#2ojkxh");
            FavoriteButtonTopBar(onFavorite, uiState.getSelectedCategory() == ServerStateCategory.Favorite, startRestartGroup, (i3 >> 6) & 14);
            MobileButtonTopBar(onMobile, uiState.getSelectedCategory() == ServerStateCategory.Mobile, startRestartGroup, (i3 >> 9) & 14);
            DesktopButtonTopBar(onDesktop, uiState.getSelectedCategory() == ServerStateCategory.Desktop, startRestartGroup, (i3 >> 12) & 14);
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
            endRestartGroup.updateScope(new Function2() { // from class: com.miami.game.feature.select.server.ui.compose.ServerTopBarKt$$ExternalSyntheticLambda6
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit ServerTopBar$lambda$6;
                    ServerTopBar$lambda$6 = ServerTopBarKt.ServerTopBar$lambda$6(SelectServerUiState.this, onBack, onFavorite, onMobile, onDesktop, i, (Composer) obj, ((Integer) obj2).intValue());
                    return ServerTopBar$lambda$6;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ServerTopBar$lambda$5$lambda$4$lambda$2$lambda$1$lambda$0(Function0 function0) {
        function0.invoke();
        return Unit.INSTANCE;
    }

    public static final void FavoriteButtonTopBar(Function0<Unit> onClick, final boolean z, Composer composer, final int i) {
        int i2;
        final Function0<Unit> function0;
        final long m4113getTransparent0d7_KjU;
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        Composer startRestartGroup = composer.startRestartGroup(-1283483726);
        ComposerKt.sourceInformation(startRestartGroup, "C(FavoriteButtonTopBar)P(1)94@3629L264,94@3596L297:ServerTopBar.kt#2ojkxh");
        if ((i & 6) == 0) {
            i2 = (startRestartGroup.changedInstance(onClick) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= startRestartGroup.changed(z) ? 32 : 16;
        }
        if (!startRestartGroup.shouldExecute((i2 & 19) != 18, i2 & 1)) {
            function0 = onClick;
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1283483726, i2, -1, "com.miami.game.feature.select.server.ui.compose.FavoriteButtonTopBar (ServerTopBar.kt:92)");
            }
            if (z) {
                startRestartGroup.startReplaceGroup(-772242439);
                ComposerKt.sourceInformation(startRestartGroup, "93@3549L11");
                m4113getTransparent0d7_KjU = MaterialTheme.INSTANCE.getColorScheme(startRestartGroup, MaterialTheme.$stable).m1714getPrimary0d7_KjU();
                startRestartGroup.endReplaceGroup();
            } else {
                startRestartGroup.startReplaceGroup(-772241827);
                startRestartGroup.endReplaceGroup();
                m4113getTransparent0d7_KjU = Color.Companion.m4113getTransparent0d7_KjU();
            }
            function0 = onClick;
            ScalingButtonKt.ScalingButton(function0, null, ComposableLambdaKt.rememberComposableLambda(434062301, true, new Function3() { // from class: com.miami.game.feature.select.server.ui.compose.ServerTopBarKt$$ExternalSyntheticLambda7
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    Unit FavoriteButtonTopBar$lambda$7;
                    FavoriteButtonTopBar$lambda$7 = ServerTopBarKt.FavoriteButtonTopBar$lambda$7(m4113getTransparent0d7_KjU, (BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    return FavoriteButtonTopBar$lambda$7;
                }
            }, startRestartGroup, 54), startRestartGroup, (i2 & 14) | RendererCapabilities.DECODER_SUPPORT_MASK, 2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: com.miami.game.feature.select.server.ui.compose.ServerTopBarKt$$ExternalSyntheticLambda8
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit FavoriteButtonTopBar$lambda$8;
                    FavoriteButtonTopBar$lambda$8 = ServerTopBarKt.FavoriteButtonTopBar$lambda$8(Function0.this, z, i, (Composer) obj, ((Integer) obj2).intValue());
                    return FavoriteButtonTopBar$lambda$8;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FavoriteButtonTopBar$lambda$7(long j, BoxScope ScalingButton, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(ScalingButton, "$this$ScalingButton");
        ComposerKt.sourceInformation(composer, "C95@3655L47,95@3639L248:ServerTopBar.kt#2ojkxh");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(434062301, i, -1, "com.miami.game.feature.select.server.ui.compose.FavoriteButtonTopBar.<anonymous> (ServerTopBar.kt:95)");
            }
            ImageKt.Image(PainterResources_androidKt.painterResource(R.drawable.btn_favorite_server, composer, 0), (String) null, BorderKt.m258borderxT4_qwU(SizeKt.fillMaxHeight$default(Modifier.Companion, 0.0f, 1, null), Dp.m6684constructorimpl(3), j, new TopBarBtnShape()), (Alignment) null, ContentScale.Companion.getFillHeight(), 0.0f, (ColorFilter) null, composer, 24624, 104);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    public static final void MobileButtonTopBar(final Function0<Unit> onClick, final boolean z, Composer composer, final int i) {
        int i2;
        final long m4113getTransparent0d7_KjU;
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        Composer startRestartGroup = composer.startRestartGroup(1063932216);
        ComposerKt.sourceInformation(startRestartGroup, "C(MobileButtonTopBar)P(1)106@4087L25,108@4114L296,106@4064L346:ServerTopBar.kt#2ojkxh");
        if ((i & 6) == 0) {
            i2 = (startRestartGroup.changedInstance(onClick) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= startRestartGroup.changed(z) ? 32 : 16;
        }
        if (startRestartGroup.shouldExecute((i2 & 19) != 18, i2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1063932216, i2, -1, "com.miami.game.feature.select.server.ui.compose.MobileButtonTopBar (ServerTopBar.kt:104)");
            }
            if (z) {
                startRestartGroup.startReplaceGroup(236647359);
                ComposerKt.sourceInformation(startRestartGroup, "105@4017L11");
                m4113getTransparent0d7_KjU = MaterialTheme.INSTANCE.getColorScheme(startRestartGroup, MaterialTheme.$stable).m1714getPrimary0d7_KjU();
                startRestartGroup.endReplaceGroup();
            } else {
                startRestartGroup.startReplaceGroup(236647971);
                startRestartGroup.endReplaceGroup();
                m4113getTransparent0d7_KjU = Color.Companion.m4113getTransparent0d7_KjU();
            }
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 236649233, "CC(remember):ServerTopBar.kt#9igjgp");
            boolean z2 = (i2 & 14) == 4;
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (z2 || rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new Function0() { // from class: com.miami.game.feature.select.server.ui.compose.ServerTopBarKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit MobileButtonTopBar$lambda$10$lambda$9;
                        MobileButtonTopBar$lambda$10$lambda$9 = ServerTopBarKt.MobileButtonTopBar$lambda$10$lambda$9(Function0.this);
                        return MobileButtonTopBar$lambda$10$lambda$9;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ScalingButtonKt.ScalingButton((Function0) rememberedValue, null, ComposableLambdaKt.rememberComposableLambda(596446243, true, new Function3() { // from class: com.miami.game.feature.select.server.ui.compose.ServerTopBarKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    Unit MobileButtonTopBar$lambda$11;
                    MobileButtonTopBar$lambda$11 = ServerTopBarKt.MobileButtonTopBar$lambda$11(m4113getTransparent0d7_KjU, (BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    return MobileButtonTopBar$lambda$11;
                }
            }, startRestartGroup, 54), startRestartGroup, RendererCapabilities.DECODER_SUPPORT_MASK, 2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: com.miami.game.feature.select.server.ui.compose.ServerTopBarKt$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit MobileButtonTopBar$lambda$12;
                    MobileButtonTopBar$lambda$12 = ServerTopBarKt.MobileButtonTopBar$lambda$12(Function0.this, z, i, (Composer) obj, ((Integer) obj2).intValue());
                    return MobileButtonTopBar$lambda$12;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit MobileButtonTopBar$lambda$10$lambda$9(Function0 function0) {
        function0.invoke();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit MobileButtonTopBar$lambda$11(long j, BoxScope ScalingButton, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(ScalingButton, "$this$ScalingButton");
        ComposerKt.sourceInformation(composer, "C111@4202L22,110@4173L231:ServerTopBar.kt#2ojkxh");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(596446243, i, -1, "com.miami.game.feature.select.server.ui.compose.MobileButtonTopBar.<anonymous> (ServerTopBar.kt:109)");
            }
            ImageKt.Image(PainterResources_androidKt.painterResource(R.drawable.btn_mobile_server, composer, 0), (String) null, BorderKt.m258borderxT4_qwU(SizeKt.fillMaxHeight$default(Modifier.Companion, 0.0f, 1, null), Dp.m6684constructorimpl(3), j, new TopBarBtnShape()), (Alignment) null, ContentScale.Companion.getFillHeight(), 0.0f, (ColorFilter) null, composer, 24624, 104);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    public static final void DesktopButtonTopBar(Function0<Unit> onClick, final boolean z, Composer composer, final int i) {
        int i2;
        final Function0<Unit> function0;
        final long m4113getTransparent0d7_KjU;
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        Composer startRestartGroup = composer.startRestartGroup(420788502);
        ComposerKt.sourceInformation(startRestartGroup, "C(DesktopButtonTopBar)P(1)123@4616L278,123@4583L311:ServerTopBar.kt#2ojkxh");
        if ((i & 6) == 0) {
            i2 = (startRestartGroup.changedInstance(onClick) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= startRestartGroup.changed(z) ? 32 : 16;
        }
        if (!startRestartGroup.shouldExecute((i2 & 19) != 18, i2 & 1)) {
            function0 = onClick;
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(420788502, i2, -1, "com.miami.game.feature.select.server.ui.compose.DesktopButtonTopBar (ServerTopBar.kt:121)");
            }
            if (z) {
                startRestartGroup.startReplaceGroup(650828861);
                ComposerKt.sourceInformation(startRestartGroup, "122@4536L11");
                m4113getTransparent0d7_KjU = MaterialTheme.INSTANCE.getColorScheme(startRestartGroup, MaterialTheme.$stable).m1714getPrimary0d7_KjU();
                startRestartGroup.endReplaceGroup();
            } else {
                startRestartGroup.startReplaceGroup(650829473);
                startRestartGroup.endReplaceGroup();
                m4113getTransparent0d7_KjU = Color.Companion.m4113getTransparent0d7_KjU();
            }
            function0 = onClick;
            ScalingButtonKt.ScalingButton(function0, null, ComposableLambdaKt.rememberComposableLambda(-1186374773, true, new Function3() { // from class: com.miami.game.feature.select.server.ui.compose.ServerTopBarKt$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    Unit DesktopButtonTopBar$lambda$13;
                    DesktopButtonTopBar$lambda$13 = ServerTopBarKt.DesktopButtonTopBar$lambda$13(m4113getTransparent0d7_KjU, (BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    return DesktopButtonTopBar$lambda$13;
                }
            }, startRestartGroup, 54), startRestartGroup, (i2 & 14) | RendererCapabilities.DECODER_SUPPORT_MASK, 2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: com.miami.game.feature.select.server.ui.compose.ServerTopBarKt$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit DesktopButtonTopBar$lambda$14;
                    DesktopButtonTopBar$lambda$14 = ServerTopBarKt.DesktopButtonTopBar$lambda$14(Function0.this, z, i, (Composer) obj, ((Integer) obj2).intValue());
                    return DesktopButtonTopBar$lambda$14;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DesktopButtonTopBar$lambda$13(long j, BoxScope ScalingButton, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(ScalingButton, "$this$ScalingButton");
        ComposerKt.sourceInformation(composer, "C125@4655L46,124@4626L262:ServerTopBar.kt#2ojkxh");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1186374773, i, -1, "com.miami.game.feature.select.server.ui.compose.DesktopButtonTopBar.<anonymous> (ServerTopBar.kt:124)");
            }
            ImageKt.Image(PainterResources_androidKt.painterResource(R.drawable.btn_desktop_server, composer, 0), (String) null, BorderKt.m258borderxT4_qwU(SizeKt.fillMaxHeight$default(Modifier.Companion, 0.0f, 1, null), Dp.m6684constructorimpl(3), j, new TopBarDesktopBtnShape()), (Alignment) null, ContentScale.Companion.getFillHeight(), 0.0f, (ColorFilter) null, composer, 24624, 104);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}
