package com.miami.game.feature.select.server.ui.compose;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.TextKt;
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
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.TextUnit;
import androidx.compose.ui.unit.TextUnitKt;
import androidx.media3.exoplayer.RendererCapabilities;
import coil3.compose.SingletonAsyncImageKt;
import com.miami.game.core.design.system.component.scaling_button.ScalingButtonKt;
import com.miami.game.core.design.system.theme.ServerShape;
import com.miami.game.core.server.model.ServerModel;
import com.miami.game.ui.theme.TypeKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: ServerItem.kt */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\u001aE\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u00052\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0007¢\u0006\u0002\u0010\t\u001a'\u0010\n\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000e\u001a\u00020\u000fH\u0003¢\u0006\u0002\u0010\u0010\u001a%\u0010\u0011\u001a\u00020\u00012\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u000e\u001a\u00020\u000fH\u0003¢\u0006\u0002\u0010\u0015¨\u0006\u0016"}, d2 = {"ServerItem", "", "serverModel", "Lcom/miami/game/core/server/model/ServerModel;", "onSelect", "Lkotlin/Function1;", "onFavorite", "isSelected", "", "(Lcom/miami/game/core/server/model/ServerModel;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;ZLandroidx/compose/runtime/Composer;I)V", "ServerName", "name", "", "imageUrl", "modifier", "Landroidx/compose/ui/Modifier;", "(Ljava/lang/String;Ljava/lang/String;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;I)V", "ServerOnline", "online", "", "max", "(IILandroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;I)V", "select-server"}, k = 2, mv = {2, 3, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ServerItemKt {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit ServerItem$lambda$2(ServerModel serverModel, Function1 function1, Function1 function12, boolean z, int i, Composer composer, int i2) {
        ServerItem(serverModel, function1, function12, z, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit ServerName$lambda$1(String str, String str2, Modifier modifier, int i, Composer composer, int i2) {
        ServerName(str, str2, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit ServerOnline$lambda$1(int i, int i2, Modifier modifier, int i3, Composer composer, int i4) {
        ServerOnline(i, i2, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i3 | 1));
        return Unit.INSTANCE;
    }

    public static final void ServerItem(final ServerModel serverModel, final Function1<? super ServerModel, Unit> onSelect, final Function1<? super ServerModel, Unit> onFavorite, final boolean z, Composer composer, final int i) {
        int i2;
        Composer composer2;
        long m5383getTransparent0d7_KjU;
        Intrinsics.checkNotNullParameter(serverModel, "serverModel");
        Intrinsics.checkNotNullParameter(onSelect, "onSelect");
        Intrinsics.checkNotNullParameter(onFavorite, "onFavorite");
        Composer startRestartGroup = composer.startRestartGroup(-2101834417);
        ComposerKt.sourceInformation(startRestartGroup, "C(ServerItem)N(serverModel,onSelect,onFavorite,isSelected)42@1866L23,42@1892L1543,42@1843L1592:ServerItem.kt#2ojkxh");
        if ((i & 6) == 0) {
            i2 = (startRestartGroup.changedInstance(serverModel) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= startRestartGroup.changedInstance(onSelect) ? 32 : 16;
        }
        if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i2 |= startRestartGroup.changedInstance(onFavorite) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= startRestartGroup.changed(z) ? 2048 : 1024;
        }
        if (!startRestartGroup.shouldExecute((i2 & 1171) != 1170, i2 & 1)) {
            composer2 = startRestartGroup;
            composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2101834417, i2, -1, "com.miami.game.feature.select.server.ui.compose.ServerItem (ServerItem.kt:38)");
            }
            if (z) {
                startRestartGroup.startReplaceGroup(-1228238186);
                ComposerKt.sourceInformation(startRestartGroup, "39@1690L11");
                m5383getTransparent0d7_KjU = MaterialTheme.INSTANCE.getColorScheme(startRestartGroup, MaterialTheme.$stable).m2322getPrimary0d7_KjU();
                startRestartGroup.endReplaceGroup();
            } else {
                startRestartGroup.startReplaceGroup(-1228237574);
                startRestartGroup.endReplaceGroup();
                m5383getTransparent0d7_KjU = Color.Companion.m5383getTransparent0d7_KjU();
            }
            final long m5347copywmQWz5c$default = Color.m5347copywmQWz5c$default(Color.Companion.m5374getBlack0d7_KjU(), z ? 0.58f : 0.41f, 0.0f, 0.0f, 0.0f, 14, null);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1228232922, "CC(remember):ServerItem.kt#9igjgp");
            boolean changedInstance = startRestartGroup.changedInstance(serverModel) | ((i2 & 112) == 32);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (changedInstance || rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new Function0() { // from class: com.miami.game.feature.select.server.ui.compose.ServerItemKt$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit ServerItem$lambda$0$0;
                        ServerItem$lambda$0$0 = ServerItemKt.ServerItem$lambda$0$0(Function1.this, serverModel);
                        return ServerItem$lambda$0$0;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            final long j = m5383getTransparent0d7_KjU;
            composer2 = startRestartGroup;
            ScalingButtonKt.ScalingButton((Function0) rememberedValue, null, ComposableLambdaKt.rememberComposableLambda(1759199162, true, new Function3() { // from class: com.miami.game.feature.select.server.ui.compose.ServerItemKt$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return ServerItemKt.ServerItem$lambda$1(m5347copywmQWz5c$default, j, serverModel, onFavorite, (BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, startRestartGroup, 54), composer2, RendererCapabilities.DECODER_SUPPORT_MASK, 2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: com.miami.game.feature.select.server.ui.compose.ServerItemKt$$ExternalSyntheticLambda5
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ServerItemKt.ServerItem$lambda$2(ServerModel.this, onSelect, onFavorite, z, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ServerItem$lambda$0$0(Function1 function1, ServerModel serverModel) {
        function1.invoke(serverModel);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit ServerItem$lambda$1(long j, long j2, final ServerModel serverModel, final Function1 function1, BoxScope ScalingButton, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(ScalingButton, "$this$ScalingButton");
        ComposerKt.sourceInformation(composer, "C43@1902L1527:ServerItem.kt#2ojkxh");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1759199162, i, -1, "com.miami.game.feature.select.server.ui.compose.ServerItem.<anonymous> (ServerItem.kt:43)");
            }
            Modifier m299borderxT4_qwU = BorderKt.m299borderxT4_qwU(SizeKt.m1119sizeVpY3zN4(BackgroundKt.m287backgroundbw27NRU(Modifier.Companion, j, new ServerShape()), Dp.m8160constructorimpl(200.0f), Dp.m8160constructorimpl(125.0f)), Dp.m8160constructorimpl(3.0f), j2, new ServerShape());
            ComposerKt.sourceInformationMarkerStart(composer, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(composer, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
            int hashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(composer, m299borderxT4_qwU);
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
            Updater.m4475setimpl(m4467constructorimpl, maybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m4475setimpl(m4467constructorimpl, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.m4475setimpl(m4467constructorimpl, Integer.valueOf(hashCode), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.m4473reconcileimpl(m4467constructorimpl, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.m4475setimpl(m4467constructorimpl, materializeModifier, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, 1740471911, "C50@2163L984,80@3350L27,76@3160L259:ServerItem.kt#2ojkxh");
            Modifier fillMaxHeight$default = SizeKt.fillMaxHeight$default(PaddingKt.m1051paddingVpY3zN4(Modifier.Companion, Dp.m8160constructorimpl(12.0f), Dp.m8160constructorimpl(8.0f)), 0.0f, 1, null);
            ComposerKt.sourceInformationMarkerStart(composer, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getSpaceAround(), Alignment.Companion.getStart(), composer, 6);
            ComposerKt.sourceInformationMarkerStart(composer, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
            int hashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap2 = composer.getCurrentCompositionLocalMap();
            Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(composer, fillMaxHeight$default);
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
            Updater.m4475setimpl(m4467constructorimpl2, columnMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m4475setimpl(m4467constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.m4475setimpl(m4467constructorimpl2, Integer.valueOf(hashCode2), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.m4473reconcileimpl(m4467constructorimpl2, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.m4475setimpl(m4467constructorimpl2, materializeModifier2, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, 89016130, "C56@2394L204,62@2615L152,66@2784L349:ServerItem.kt#2ojkxh");
            ServerName(String.valueOf(serverModel.getName()), serverModel.getIcon(), SizeKt.m1122width3ABfNKs(OffsetKt.m1010offsetVpY3zN4$default(Modifier.Companion, 0.0f, 0.0f, 3, null), Dp.m8160constructorimpl(140.0f)), composer, RendererCapabilities.DECODER_SUPPORT_MASK);
            Integer online = serverModel.getOnline();
            int intValue = online != null ? online.intValue() : 0;
            Integer maxplayers = serverModel.getMaxplayers();
            ServerOnline(intValue, maxplayers != null ? maxplayers.intValue() : 0, OffsetKt.m1010offsetVpY3zN4$default(Modifier.Companion, Dp.m8160constructorimpl(12.0f), 0.0f, 2, null), composer, RendererCapabilities.DECODER_SUPPORT_MASK);
            ServerPromotionLabelKt.ServerPromotion(serverModel.getXdonate(), serverModel.getXpayday(), serverModel.isTop(), serverModel.isNew(), serverModel.isMobile(), serverModel.isArizona(), OffsetKt.m1010offsetVpY3zN4$default(Modifier.Companion, Dp.m8160constructorimpl(12.0f), 0.0f, 2, null), composer, 1572864);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            boolean isFavorite = serverModel.isFavorite();
            Modifier.Companion companion = Modifier.Companion;
            ComposerKt.sourceInformationMarkerStart(composer, 1026012335, "CC(remember):ServerItem.kt#9igjgp");
            boolean changed = composer.changed(function1) | composer.changedInstance(serverModel);
            Object rememberedValue = composer.rememberedValue();
            if (changed || rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new Function0() { // from class: com.miami.game.feature.select.server.ui.compose.ServerItemKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit ServerItem$lambda$1$0$1$0;
                        ServerItem$lambda$1$0$1$0 = ServerItemKt.ServerItem$lambda$1$0$1$0(Function1.this, serverModel);
                        return ServerItem$lambda$1$0$1$0;
                    }
                };
                composer.updateRememberedValue(rememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            FavoriteButtonKt.FavoriteButton(isFavorite, boxScopeInstance.align(ClickableKt.m319clickableO2vRcR0$default(companion, null, null, false, null, null, (Function0) rememberedValue, 28, null), Alignment.Companion.getTopEnd()), composer, 0, 0);
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
    public static final Unit ServerItem$lambda$1$0$1$0(Function1 function1, ServerModel serverModel) {
        function1.invoke(serverModel);
        return Unit.INSTANCE;
    }

    private static final void ServerName(String str, final String str2, final Modifier modifier, Composer composer, final int i) {
        int i2;
        int i3;
        int i4;
        final String str3 = str;
        Composer startRestartGroup = composer.startRestartGroup(602257850);
        ComposerKt.sourceInformation(startRestartGroup, "C(ServerName)N(name,imageUrl,modifier)88@3532L700:ServerItem.kt#2ojkxh");
        if ((i & 6) == 0) {
            i2 = (startRestartGroup.changed(str3) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= startRestartGroup.changed(str2) ? 32 : 16;
        }
        if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i2 |= startRestartGroup.changed(modifier) ? 256 : 128;
        }
        if (!startRestartGroup.shouldExecute((i2 & 147) != 146, i2 & 1)) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(602257850, i2, -1, "com.miami.game.feature.select.server.ui.compose.ServerName (ServerItem.kt:87)");
            }
            Alignment.Vertical centerVertically = Alignment.Companion.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically, startRestartGroup, 48);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
            int hashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(startRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, modifier);
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
            Updater.m4475setimpl(m4467constructorimpl, rowMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m4475setimpl(m4467constructorimpl, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.m4475setimpl(m4467constructorimpl, Integer.valueOf(hashCode), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.m4473reconcileimpl(m4467constructorimpl, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.m4475setimpl(m4467constructorimpl, materializeModifier, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1129284374, "C101@3962L28,104@4077L10,106@4163L13,107@4203L13,102@3999L227:ServerItem.kt#2ojkxh");
            if (str2 != null) {
                startRestartGroup.startReplaceGroup(-1129263140);
                ComposerKt.sourceInformation(startRestartGroup, "91@3657L200");
                i3 = i2;
                i4 = 6;
                SingletonAsyncImageKt.m9167AsyncImage10Xjiaw(str2, null, SizeKt.m1117size3ABfNKs(Modifier.Companion, Dp.m8160constructorimpl(24.0f)), null, null, null, ContentScale.Companion.getCrop(), 0.0f, null, 0, false, startRestartGroup, ((i2 >> 3) & 14) | 1573296, 0, 1976);
                startRestartGroup.endReplaceGroup();
            } else {
                i3 = i2;
                i4 = 6;
                startRestartGroup.startReplaceGroup(-1129052588);
                ComposerKt.sourceInformation(startRestartGroup, "98@3887L56");
                SpacerKt.Spacer(SizeKt.m1117size3ABfNKs(Modifier.Companion, Dp.m8160constructorimpl(24.0f)), startRestartGroup, 6);
                startRestartGroup.endReplaceGroup();
            }
            SpacerKt.Spacer(SizeKt.m1122width3ABfNKs(Modifier.Companion, Dp.m8160constructorimpl(8.0f)), startRestartGroup, i4);
            long m5385getWhite0d7_KjU = Color.Companion.m5385getWhite0d7_KjU();
            TextStyle labelMedium = MaterialTheme.INSTANCE.getTypography(startRestartGroup, MaterialTheme.$stable).getLabelMedium();
            long sp = TextUnitKt.getSp(0.6d);
            TextUnitKt.m8367checkArithmeticR2X_6o(sp);
            str3 = str;
            TextKt.m3157TextNvy7gAk(str3, null, m5385getWhite0d7_KjU, null, TypeKt.m9793dpToSp8Feqmps(Dp.m8160constructorimpl(21.0f), startRestartGroup, i4), null, null, null, TextUnitKt.pack(TextUnit.m8352getRawTypeimpl(sp), -TextUnit.m8354getValueimpl(sp)), null, null, TypeKt.m9793dpToSp8Feqmps(Dp.m8160constructorimpl(22.0f), startRestartGroup, i4), 0, false, 0, 0, null, labelMedium, startRestartGroup, (i3 & 14) | RendererCapabilities.DECODER_SUPPORT_MASK, 0, 128746);
            startRestartGroup = startRestartGroup;
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
            endRestartGroup.updateScope(new Function2() { // from class: com.miami.game.feature.select.server.ui.compose.ServerItemKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ServerItemKt.ServerName$lambda$1(str3, str2, modifier, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final void ServerOnline(final int i, final int i2, final Modifier modifier, Composer composer, final int i3) {
        int i4;
        Composer composer2;
        Composer startRestartGroup = composer.startRestartGroup(-1971858036);
        ComposerKt.sourceInformation(startRestartGroup, "C(ServerOnline)N(online,max,modifier)114@4320L498:ServerItem.kt#2ojkxh");
        if ((i3 & 6) == 0) {
            i4 = (startRestartGroup.changed(i) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= startRestartGroup.changed(i2) ? 32 : 16;
        }
        if ((i3 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i4 |= startRestartGroup.changed(modifier) ? 256 : 128;
        }
        if (!startRestartGroup.shouldExecute((i4 & 147) != 146, i4 & 1)) {
            composer2 = startRestartGroup;
            composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1971858036, i4, -1, "com.miami.game.feature.select.server.ui.compose.ServerOnline (ServerItem.kt:113)");
            }
            Alignment.Vertical bottom = Alignment.Companion.getBottom();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), bottom, startRestartGroup, 48);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
            int hashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(startRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, modifier);
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
            Updater.m4475setimpl(m4467constructorimpl, rowMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m4475setimpl(m4467constructorimpl, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.m4475setimpl(m4467constructorimpl, Integer.valueOf(hashCode), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.m4473reconcileimpl(m4467constructorimpl, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.m4475setimpl(m4467constructorimpl, materializeModifier, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 129289880, "C118@4492L10,119@4537L13,120@4577L13,116@4401L190,123@4702L10,124@4747L13,121@4600L212:ServerItem.kt#2ojkxh");
            composer2 = startRestartGroup;
            TextKt.m3157TextNvy7gAk(String.valueOf(i), null, Color.Companion.m5385getWhite0d7_KjU(), null, TypeKt.m9793dpToSp8Feqmps(Dp.m8160constructorimpl(21.0f), startRestartGroup, 6), null, null, null, 0L, null, null, TypeKt.m9793dpToSp8Feqmps(Dp.m8160constructorimpl(21.0f), startRestartGroup, 6), 0, false, 0, 0, null, MaterialTheme.INSTANCE.getTypography(startRestartGroup, MaterialTheme.$stable).getBodySmall(), composer2, RendererCapabilities.DECODER_SUPPORT_MASK, 0, 129002);
            TextKt.m3157TextNvy7gAk(" / " + i2, OffsetKt.m1010offsetVpY3zN4$default(Modifier.Companion, 0.0f, Dp.m8160constructorimpl(-Dp.m8160constructorimpl(1.0f)), 1, null), Color.m5347copywmQWz5c$default(Color.Companion.m5385getWhite0d7_KjU(), 0.5f, 0.0f, 0.0f, 0.0f, 14, null), null, TypeKt.m9793dpToSp8Feqmps(Dp.m8160constructorimpl(15.0f), composer2, 6), null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, MaterialTheme.INSTANCE.getTypography(composer2, MaterialTheme.$stable).getBodySmall(), composer2, 432, 0, 131048);
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
            endRestartGroup.updateScope(new Function2() { // from class: com.miami.game.feature.select.server.ui.compose.ServerItemKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ServerItemKt.ServerOnline$lambda$1(i, i2, modifier, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }
}
