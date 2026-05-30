package com.miami.game.feature.select.server.ui.compose;

import androidx.compose.foundation.BorderKt;
import androidx.compose.foundation.ClickableKt;
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
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.unit.Dp;
import androidx.media3.exoplayer.RendererCapabilities;
import com.miami.game.core.design.system.component.other.CustomDividerKt;
import com.miami.game.core.design.system.component.scaling_button.ScalingButtonKt;
import com.miami.game.core.server.model.ServerStateCategory;
import com.miami.game.feature.select.server.ui.model.SelectServerUiState;
import com.miami.game.ui.classic.select.server.R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: ServerTopBar.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0004\u001a[\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00010\u0005H\u0007¢\u0006\u0002\u0010\n\u001a#\u0010\u000b\u001a\u00020\u00012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\u0006\u0010\r\u001a\u00020\u000eH\u0007¢\u0006\u0002\u0010\u000f\u001a#\u0010\u0010\u001a\u00020\u00012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\u0006\u0010\r\u001a\u00020\u000eH\u0007¢\u0006\u0002\u0010\u000f\u001a#\u0010\u0011\u001a\u00020\u00012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\u0006\u0010\r\u001a\u00020\u000eH\u0007¢\u0006\u0002\u0010\u000f¨\u0006\u0012"}, d2 = {"ServerTopBar", "", "uiState", "Lcom/miami/game/feature/select/server/ui/model/SelectServerUiState;", "onBack", "Lkotlin/Function0;", "onFavorite", "onMobile", "onDesktop", "onLogo", "(Lcom/miami/game/feature/select/server/ui/model/SelectServerUiState;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "FavoriteButtonTopBar", "onClick", "isSelected", "", "(Lkotlin/jvm/functions/Function0;ZLandroidx/compose/runtime/Composer;I)V", "MobileButtonTopBar", "DesktopButtonTopBar", "select-server"}, k = 2, mv = {2, 3, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ServerTopBarKt {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit DesktopButtonTopBar$lambda$1(Function0 function0, boolean z, int i, Composer composer, int i2) {
        DesktopButtonTopBar(function0, z, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit FavoriteButtonTopBar$lambda$1(Function0 function0, boolean z, int i, Composer composer, int i2) {
        FavoriteButtonTopBar(function0, z, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit MobileButtonTopBar$lambda$2(Function0 function0, boolean z, int i, Composer composer, int i2) {
        MobileButtonTopBar(function0, z, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit ServerTopBar$lambda$1(SelectServerUiState selectServerUiState, Function0 function0, Function0 function02, Function0 function03, Function0 function04, Function0 function05, int i, Composer composer, int i2) {
        ServerTopBar(selectServerUiState, function0, function02, function03, function04, function05, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final void ServerTopBar(final SelectServerUiState uiState, final Function0<Unit> onBack, final Function0<Unit> onFavorite, final Function0<Unit> onMobile, final Function0<Unit> onDesktop, final Function0<Unit> onLogo, Composer composer, final int i) {
        int i2;
        Intrinsics.checkNotNullParameter(uiState, "uiState");
        Intrinsics.checkNotNullParameter(onBack, "onBack");
        Intrinsics.checkNotNullParameter(onFavorite, "onFavorite");
        Intrinsics.checkNotNullParameter(onMobile, "onMobile");
        Intrinsics.checkNotNullParameter(onDesktop, "onDesktop");
        Intrinsics.checkNotNullParameter(onLogo, "onLogo");
        Composer startRestartGroup = composer.startRestartGroup(1143648973);
        ComposerKt.sourceInformation(startRestartGroup, "C(ServerTopBar)N(uiState,onBack,onFavorite,onMobile,onDesktop,onLogo)37@1447L2094:ServerTopBar.kt#2ojkxh");
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
        if ((196608 & i) == 0) {
            i2 |= startRestartGroup.changedInstance(onLogo) ? 131072 : 65536;
        }
        if (!startRestartGroup.shouldExecute((74899 & i2) != 74898, i2 & 1)) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1143648973, i2, -1, "com.miami.game.feature.select.server.ui.compose.ServerTopBar (ServerTopBar.kt:36)");
            }
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
            int hashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(startRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, Modifier.Companion);
            Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)410@16187L9:Composables.kt#9igjgp");
            if (!(startRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(constructor);
            } else {
                startRestartGroup.useNode();
            }
            Composer m4467constructorimpl = Updater.m4467constructorimpl(startRestartGroup);
            Updater.m4475setimpl(m4467constructorimpl, maybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m4475setimpl(m4467constructorimpl, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.m4475setimpl(m4467constructorimpl, Integer.valueOf(hashCode), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.m4473reconcileimpl(m4467constructorimpl, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.m4475setimpl(m4467constructorimpl, materializeModifier, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 741042756, "C38@1463L1925,86@3397L138:ServerTopBar.kt#2ojkxh");
            Alignment.Vertical centerVertically = Alignment.Companion.getCenterVertically();
            Arrangement.HorizontalOrVertical spaceBetween = Arrangement.INSTANCE.getSpaceBetween();
            Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, null);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(spaceBetween, centerVertically, startRestartGroup, 54);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
            int hashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(startRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(startRestartGroup, fillMaxWidth$default);
            Function0<ComposeUiNode> constructor2 = ComposeUiNode.Companion.getConstructor();
            int i3 = i2;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)410@16187L9:Composables.kt#9igjgp");
            if (!(startRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(constructor2);
            } else {
                startRestartGroup.useNode();
            }
            Composer m4467constructorimpl2 = Updater.m4467constructorimpl(startRestartGroup);
            Updater.m4475setimpl(m4467constructorimpl2, rowMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m4475setimpl(m4467constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.m4475setimpl(m4467constructorimpl2, Integer.valueOf(hashCode2), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.m4473reconcileimpl(m4467constructorimpl2, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.m4475setimpl(m4467constructorimpl2, materializeModifier2, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 393668907, "C43@1661L886,66@2560L818:ServerTopBar.kt#2ojkxh");
            Alignment.Vertical centerVertically2 = Alignment.Companion.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            MeasurePolicy rowMeasurePolicy2 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically2, startRestartGroup, 48);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
            int hashCode3 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(startRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap3 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier3 = ComposedModifierKt.materializeModifier(startRestartGroup, Modifier.Companion);
            Function0<ComposeUiNode> constructor3 = ComposeUiNode.Companion.getConstructor();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)410@16187L9:Composables.kt#9igjgp");
            if (!(startRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(constructor3);
            } else {
                startRestartGroup.useNode();
            }
            Composer m4467constructorimpl3 = Updater.m4467constructorimpl(startRestartGroup);
            Updater.m4475setimpl(m4467constructorimpl3, rowMeasurePolicy2, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m4475setimpl(m4467constructorimpl3, currentCompositionLocalMap3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.m4475setimpl(m4467constructorimpl3, Integer.valueOf(hashCode3), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.m4473reconcileimpl(m4467constructorimpl3, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.m4475setimpl(m4467constructorimpl3, materializeModifier3, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScopeInstance rowScopeInstance2 = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1446744480, "C47@1806L56,46@1761L450,59@2255L47,62@2443L12,58@2228L305:ServerTopBar.kt#2ojkxh");
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1754445417, "CC(remember):ServerTopBar.kt#9igjgp");
            boolean z = (i3 & 112) == 32;
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (z || rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new Function0() { // from class: com.miami.game.feature.select.server.ui.compose.ServerTopBarKt$$ExternalSyntheticLambda5
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit ServerTopBar$lambda$0$0$0$0$0;
                        ServerTopBar$lambda$0$0$0$0$0 = ServerTopBarKt.ServerTopBar$lambda$0$0$0$0$0(Function0.this);
                        return ServerTopBar$lambda$0$0$0$0$0;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ScalingButtonKt.ScalingButton((Function0) rememberedValue, null, ComposableSingletons$ServerTopBarKt.INSTANCE.m9764getLambda$1484463318$select_server(), startRestartGroup, RendererCapabilities.DECODER_SUPPORT_MASK, 2);
            Painter painterResource = PainterResources_androidKt.painterResource(R.drawable.select_server_label, startRestartGroup, 0);
            Modifier m1010offsetVpY3zN4$default = OffsetKt.m1010offsetVpY3zN4$default(SizeKt.m1103height3ABfNKs(Modifier.Companion, Dp.m8160constructorimpl(30.0f)), Dp.m8160constructorimpl(-Dp.m8160constructorimpl(12.0f)), 0.0f, 2, null);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1754425077, "CC(remember):ServerTopBar.kt#9igjgp");
            boolean z2 = (i3 & 458752) == 131072;
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (z2 || rememberedValue2 == Composer.Companion.getEmpty()) {
                rememberedValue2 = new Function0() { // from class: com.miami.game.feature.select.server.ui.compose.ServerTopBarKt$$ExternalSyntheticLambda6
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit ServerTopBar$lambda$0$0$0$1$0;
                        ServerTopBar$lambda$0$0$0$1$0 = ServerTopBarKt.ServerTopBar$lambda$0$0$0$1$0(Function0.this);
                        return ServerTopBar$lambda$0$0$0$1$0;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ImageKt.Image(painterResource, (String) null, ClickableKt.m323clickableoSLSa3U$default(m1010offsetVpY3zN4$default, false, null, null, null, (Function0) rememberedValue2, 15, null), (Alignment) null, ContentScale.Companion.getFillHeight(), 0.0f, (ColorFilter) null, startRestartGroup, Painter.$stable | 24624, 104);
            startRestartGroup = startRestartGroup;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            startRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            Modifier m1054paddingqDBjuR0$default = PaddingKt.m1054paddingqDBjuR0$default(SizeKt.m1103height3ABfNKs(Modifier.Companion, Dp.m8160constructorimpl(30.0f)), 0.0f, 0.0f, Dp.m8160constructorimpl(12.0f), 0.0f, 11, null);
            Alignment.Vertical centerVertically3 = Alignment.Companion.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            MeasurePolicy rowMeasurePolicy3 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.m742spacedBy0680j_4(Dp.m8160constructorimpl(-Dp.m8160constructorimpl(12.0f))), centerVertically3, startRestartGroup, 54);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
            int hashCode4 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(startRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap4 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier4 = ComposedModifierKt.materializeModifier(startRestartGroup, m1054paddingqDBjuR0$default);
            Function0<ComposeUiNode> constructor4 = ComposeUiNode.Companion.getConstructor();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)410@16187L9:Composables.kt#9igjgp");
            if (!(startRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(constructor4);
            } else {
                startRestartGroup.useNode();
            }
            Composer m4467constructorimpl4 = Updater.m4467constructorimpl(startRestartGroup);
            Updater.m4475setimpl(m4467constructorimpl4, rowMeasurePolicy3, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m4475setimpl(m4467constructorimpl4, currentCompositionLocalMap4, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.m4475setimpl(m4467constructorimpl4, Integer.valueOf(hashCode4), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.m4473reconcileimpl(m4467constructorimpl4, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.m4475setimpl(m4467constructorimpl4, materializeModifier4, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScopeInstance rowScopeInstance3 = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1530496866, "C72@2823L172,76@3012L166,80@3195L169:ServerTopBar.kt#2ojkxh");
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
            CustomDividerKt.CustomDivider(OffsetKt.m1010offsetVpY3zN4$default(boxScopeInstance.align(Modifier.Companion, Alignment.Companion.getBottomCenter()), 0.0f, Dp.m8160constructorimpl(-Dp.m8160constructorimpl(0.0f)), 1, null), startRestartGroup, 0, 0);
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
            endRestartGroup.updateScope(new Function2() { // from class: com.miami.game.feature.select.server.ui.compose.ServerTopBarKt$$ExternalSyntheticLambda7
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ServerTopBarKt.ServerTopBar$lambda$1(SelectServerUiState.this, onBack, onFavorite, onMobile, onDesktop, onLogo, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ServerTopBar$lambda$0$0$0$0$0(Function0 function0) {
        function0.invoke();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ServerTopBar$lambda$0$0$0$1$0(Function0 function0) {
        function0.invoke();
        return Unit.INSTANCE;
    }

    public static final void FavoriteButtonTopBar(Function0<Unit> onClick, final boolean z, Composer composer, final int i) {
        int i2;
        final Function0<Unit> function0;
        final long m5383getTransparent0d7_KjU;
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        Composer startRestartGroup = composer.startRestartGroup(-1283483726);
        ComposerKt.sourceInformation(startRestartGroup, "C(FavoriteButtonTopBar)N(onClick,isSelected)97@3747L264,97@3714L297:ServerTopBar.kt#2ojkxh");
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
                ComposerKt.traceEventStart(-1283483726, i2, -1, "com.miami.game.feature.select.server.ui.compose.FavoriteButtonTopBar (ServerTopBar.kt:95)");
            }
            if (z) {
                startRestartGroup.startReplaceGroup(-772242823);
                ComposerKt.sourceInformation(startRestartGroup, "96@3667L11");
                m5383getTransparent0d7_KjU = MaterialTheme.INSTANCE.getColorScheme(startRestartGroup, MaterialTheme.$stable).m2322getPrimary0d7_KjU();
                startRestartGroup.endReplaceGroup();
            } else {
                startRestartGroup.startReplaceGroup(-772242211);
                startRestartGroup.endReplaceGroup();
                m5383getTransparent0d7_KjU = Color.Companion.m5383getTransparent0d7_KjU();
            }
            function0 = onClick;
            ScalingButtonKt.ScalingButton(function0, null, ComposableLambdaKt.rememberComposableLambda(434062301, true, new Function3() { // from class: com.miami.game.feature.select.server.ui.compose.ServerTopBarKt$$ExternalSyntheticLambda8
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return ServerTopBarKt.FavoriteButtonTopBar$lambda$0(m5383getTransparent0d7_KjU, (BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, startRestartGroup, 54), startRestartGroup, (i2 & 14) | RendererCapabilities.DECODER_SUPPORT_MASK, 2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: com.miami.game.feature.select.server.ui.compose.ServerTopBarKt$$ExternalSyntheticLambda9
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ServerTopBarKt.FavoriteButtonTopBar$lambda$1(Function0.this, z, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit FavoriteButtonTopBar$lambda$0(long j, BoxScope ScalingButton, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(ScalingButton, "$this$ScalingButton");
        ComposerKt.sourceInformation(composer, "C98@3773L47,98@3757L248:ServerTopBar.kt#2ojkxh");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(434062301, i, -1, "com.miami.game.feature.select.server.ui.compose.FavoriteButtonTopBar.<anonymous> (ServerTopBar.kt:98)");
            }
            ImageKt.Image(PainterResources_androidKt.painterResource(R.drawable.btn_favorite_server, composer, 0), (String) null, BorderKt.m299borderxT4_qwU(SizeKt.fillMaxHeight$default(Modifier.Companion, 0.0f, 1, null), Dp.m8160constructorimpl(3.0f), j, new TopBarBtnShape()), (Alignment) null, ContentScale.Companion.getFillHeight(), 0.0f, (ColorFilter) null, composer, Painter.$stable | 24624, 104);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    public static final void MobileButtonTopBar(final Function0<Unit> onClick, final boolean z, Composer composer, final int i) {
        int i2;
        final long m5383getTransparent0d7_KjU;
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        Composer startRestartGroup = composer.startRestartGroup(1063932216);
        ComposerKt.sourceInformation(startRestartGroup, "C(MobileButtonTopBar)N(onClick,isSelected)109@4205L25,111@4232L296,109@4182L346:ServerTopBar.kt#2ojkxh");
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
                ComposerKt.traceEventStart(1063932216, i2, -1, "com.miami.game.feature.select.server.ui.compose.MobileButtonTopBar (ServerTopBar.kt:107)");
            }
            if (z) {
                startRestartGroup.startReplaceGroup(236646975);
                ComposerKt.sourceInformation(startRestartGroup, "108@4135L11");
                m5383getTransparent0d7_KjU = MaterialTheme.INSTANCE.getColorScheme(startRestartGroup, MaterialTheme.$stable).m2322getPrimary0d7_KjU();
                startRestartGroup.endReplaceGroup();
            } else {
                startRestartGroup.startReplaceGroup(236647587);
                startRestartGroup.endReplaceGroup();
                m5383getTransparent0d7_KjU = Color.Companion.m5383getTransparent0d7_KjU();
            }
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 236648849, "CC(remember):ServerTopBar.kt#9igjgp");
            boolean z2 = (i2 & 14) == 4;
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (z2 || rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new Function0() { // from class: com.miami.game.feature.select.server.ui.compose.ServerTopBarKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit MobileButtonTopBar$lambda$0$0;
                        MobileButtonTopBar$lambda$0$0 = ServerTopBarKt.MobileButtonTopBar$lambda$0$0(Function0.this);
                        return MobileButtonTopBar$lambda$0$0;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ScalingButtonKt.ScalingButton((Function0) rememberedValue, null, ComposableLambdaKt.rememberComposableLambda(596446243, true, new Function3() { // from class: com.miami.game.feature.select.server.ui.compose.ServerTopBarKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return ServerTopBarKt.MobileButtonTopBar$lambda$1(m5383getTransparent0d7_KjU, (BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
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
                    return ServerTopBarKt.MobileButtonTopBar$lambda$2(Function0.this, z, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit MobileButtonTopBar$lambda$0$0(Function0 function0) {
        function0.invoke();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit MobileButtonTopBar$lambda$1(long j, BoxScope ScalingButton, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(ScalingButton, "$this$ScalingButton");
        ComposerKt.sourceInformation(composer, "C114@4320L22,113@4291L231:ServerTopBar.kt#2ojkxh");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(596446243, i, -1, "com.miami.game.feature.select.server.ui.compose.MobileButtonTopBar.<anonymous> (ServerTopBar.kt:112)");
            }
            ImageKt.Image(PainterResources_androidKt.painterResource(R.drawable.btn_mobile_server, composer, 0), (String) null, BorderKt.m299borderxT4_qwU(SizeKt.fillMaxHeight$default(Modifier.Companion, 0.0f, 1, null), Dp.m8160constructorimpl(3.0f), j, new TopBarBtnShape()), (Alignment) null, ContentScale.Companion.getFillHeight(), 0.0f, (ColorFilter) null, composer, Painter.$stable | 24624, 104);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    public static final void DesktopButtonTopBar(Function0<Unit> onClick, final boolean z, Composer composer, final int i) {
        int i2;
        final Function0<Unit> function0;
        final long m5383getTransparent0d7_KjU;
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        Composer startRestartGroup = composer.startRestartGroup(420788502);
        ComposerKt.sourceInformation(startRestartGroup, "C(DesktopButtonTopBar)N(onClick,isSelected)126@4734L278,126@4701L311:ServerTopBar.kt#2ojkxh");
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
                ComposerKt.traceEventStart(420788502, i2, -1, "com.miami.game.feature.select.server.ui.compose.DesktopButtonTopBar (ServerTopBar.kt:124)");
            }
            if (z) {
                startRestartGroup.startReplaceGroup(650828477);
                ComposerKt.sourceInformation(startRestartGroup, "125@4654L11");
                m5383getTransparent0d7_KjU = MaterialTheme.INSTANCE.getColorScheme(startRestartGroup, MaterialTheme.$stable).m2322getPrimary0d7_KjU();
                startRestartGroup.endReplaceGroup();
            } else {
                startRestartGroup.startReplaceGroup(650829089);
                startRestartGroup.endReplaceGroup();
                m5383getTransparent0d7_KjU = Color.Companion.m5383getTransparent0d7_KjU();
            }
            function0 = onClick;
            ScalingButtonKt.ScalingButton(function0, null, ComposableLambdaKt.rememberComposableLambda(-1186374773, true, new Function3() { // from class: com.miami.game.feature.select.server.ui.compose.ServerTopBarKt$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return ServerTopBarKt.DesktopButtonTopBar$lambda$0(m5383getTransparent0d7_KjU, (BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
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
                    return ServerTopBarKt.DesktopButtonTopBar$lambda$1(Function0.this, z, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit DesktopButtonTopBar$lambda$0(long j, BoxScope ScalingButton, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(ScalingButton, "$this$ScalingButton");
        ComposerKt.sourceInformation(composer, "C128@4773L46,127@4744L262:ServerTopBar.kt#2ojkxh");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1186374773, i, -1, "com.miami.game.feature.select.server.ui.compose.DesktopButtonTopBar.<anonymous> (ServerTopBar.kt:127)");
            }
            ImageKt.Image(PainterResources_androidKt.painterResource(R.drawable.btn_desktop_server, composer, 0), (String) null, BorderKt.m299borderxT4_qwU(SizeKt.fillMaxHeight$default(Modifier.Companion, 0.0f, 1, null), Dp.m8160constructorimpl(3.0f), j, new TopBarDesktopBtnShape()), (Alignment) null, ContentScale.Companion.getFillHeight(), 0.0f, (ColorFilter) null, composer, Painter.$stable | 24624, 104);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}
