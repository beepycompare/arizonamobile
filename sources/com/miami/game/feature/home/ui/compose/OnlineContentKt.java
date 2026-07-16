package com.miami.game.feature.home.ui.compose;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderKt;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
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
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.unit.Dp;
import androidx.media3.exoplayer.RendererCapabilities;
import com.google.firebase.messaging.Constants;
import com.miami.game.feature.home.ui.model.HomeUiState;
import com.miami.game.ui.classic.home.R;
import com.miami.game.ui.theme.TypeKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
/* compiled from: OnlineContent.kt */
@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a'\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0007b\u0002\b\u0005b\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b¢\u0006\u0002\u0010\u0004\u001aA\u0010\t\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u0010H\u0003b\u0002\b\u0005b\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b¢\u0006\u0002\u0010\u0011\u001a\f\u0010\u0012\u001a\u00020\u000b*\u00020\u000eH\u0002¨\u0006\u0013"}, d2 = {"OnlineContent", "", "uiState", "Lcom/miami/game/feature/home/ui/model/HomeUiState;", "(Lcom/miami/game/feature/home/ui/model/HomeUiState;Landroidx/compose/runtime/Composer;I)V", "Landroidx/compose/runtime/Composable;", "Landroidx/compose/runtime/ComposableTarget;", "applier", "androidx.compose.ui.UiComposable", "OnlineMetric", Constants.ScionAnalytics.PARAM_LABEL, "", "value", "iconRes", "", "modifier", "Landroidx/compose/ui/Modifier;", "(Ljava/lang/String;Ljava/lang/String;ILandroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "formatMetric", "home"}, k = 2, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class OnlineContentKt {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit OnlineContent$lambda$1(HomeUiState homeUiState, int i, Composer composer, int i2) {
        OnlineContent(homeUiState, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit OnlineMetric$lambda$1(String str, String str2, int i, Modifier modifier, int i2, int i3, Composer composer, int i4) {
        OnlineMetric(str, str2, i, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
        return Unit.INSTANCE;
    }

    public static final void OnlineContent(final HomeUiState uiState, Composer composer, final int i) {
        int i2;
        Intrinsics.checkNotNullParameter(uiState, "uiState");
        Composer startRestartGroup = composer.startRestartGroup(400238897);
        ComposerKt.sourceInformation(startRestartGroup, "C(OnlineContent)N(uiState)32@1299L1079:OnlineContent.kt#dswm0d");
        if ((i & 6) == 0) {
            i2 = (startRestartGroup.changed(uiState) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if (!startRestartGroup.shouldExecute((i2 & 3) != 2, i2 & 1)) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(400238897, i2, -1, "com.miami.game.feature.home.ui.compose.OnlineContent (OnlineContent.kt:29)");
            }
            ServerHomeShape serverHomeShape = new ServerHomeShape();
            Modifier m1051paddingVpY3zN4 = PaddingKt.m1051paddingVpY3zN4(BorderKt.m301borderziNgDLE(BackgroundKt.m287backgroundbw27NRU(SizeKt.m1103height3ABfNKs(SizeKt.wrapContentWidth$default(SizeKt.m1124widthInVpY3zN4$default(PaddingKt.m1054paddingqDBjuR0$default(Modifier.Companion, 0.0f, 0.0f, 0.0f, Dp.m8160constructorimpl(5.0f), 7, null), Dp.m8160constructorimpl(96.0f), 0.0f, 2, null), null, false, 3, null), Dp.m8160constructorimpl(36.0f)), Color.m5347copywmQWz5c$default(Color.Companion.m5374getBlack0d7_KjU(), 0.52f, 0.0f, 0.0f, 0.0f, 14, null), serverHomeShape), Dp.m8160constructorimpl(1.0f), Brush.Companion.m5303verticalGradient8A3gB4$default(Brush.Companion, CollectionsKt.listOf((Object[]) new Color[]{Color.m5338boximpl(Color.m5347copywmQWz5c$default(Color.Companion.m5385getWhite0d7_KjU(), 0.38f, 0.0f, 0.0f, 0.0f, 14, null)), Color.m5338boximpl(Color.Companion.m5383getTransparent0d7_KjU())}), 0.0f, 0.0f, 0, 14, (Object) null), serverHomeShape), Dp.m8160constructorimpl(9.0f), Dp.m8160constructorimpl(4.0f));
            Alignment.Vertical centerVertically = Alignment.Companion.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.m742spacedBy0680j_4(Dp.m8160constructorimpl(10.0f)), centerVertically, startRestartGroup, 54);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
            int hashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(startRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, m1051paddingVpY3zN4);
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
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 349471392, "C56@2070L146,61@2225L147:OnlineContent.kt#dswm0d");
            OnlineMetric("Очередь", formatMetric(uiState.getQueue()), R.drawable.queue_ic, null, startRestartGroup, 6, 8);
            OnlineMetric("Онлайн", formatMetric(uiState.getOnline()), R.drawable.online_ic, null, startRestartGroup, 6, 8);
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
            endRestartGroup.updateScope(new Function2() { // from class: com.miami.game.feature.home.ui.compose.OnlineContentKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return OnlineContentKt.OnlineContent$lambda$1(HomeUiState.this, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0314  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0320  */
    /* JADX WARN: Removed duplicated region for block: B:71:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static final void OnlineMetric(final String str, final String str2, final int i, Modifier modifier, Composer composer, final int i2, final int i3) {
        Object obj;
        int i4;
        Object obj2;
        Object obj3;
        Composer composer2;
        final Modifier modifier2;
        ScopeUpdateScope endRestartGroup;
        Composer startRestartGroup = composer.startRestartGroup(1079297358);
        ComposerKt.sourceInformation(startRestartGroup, "C(OnlineMetric)N(label,value,iconRes,modifier)76@2518L1051:OnlineContent.kt#dswm0d");
        if ((i2 & 6) == 0) {
            obj = str;
            i4 = (startRestartGroup.changed(obj) ? 4 : 2) | i2;
        } else {
            obj = str;
            i4 = i2;
        }
        if ((i2 & 48) == 0) {
            obj2 = str2;
            i4 |= startRestartGroup.changed(obj2) ? 32 : 16;
        } else {
            obj2 = str2;
        }
        if ((i2 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i4 |= startRestartGroup.changed(i) ? 256 : 128;
        }
        int i5 = i3 & 8;
        if (i5 != 0) {
            i4 |= 3072;
        } else if ((i2 & 3072) == 0) {
            obj3 = modifier;
            i4 |= startRestartGroup.changed(obj3) ? 2048 : 1024;
            if (startRestartGroup.shouldExecute((i4 & 1171) == 1170, i4 & 1)) {
                composer2 = startRestartGroup;
                composer2.skipToGroupEnd();
                modifier2 = obj3;
            } else {
                Modifier.Companion companion = i5 != 0 ? Modifier.Companion : obj3;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1079297358, i4, -1, "com.miami.game.feature.home.ui.compose.OnlineMetric (OnlineContent.kt:75)");
                }
                Alignment.Horizontal start = Alignment.Companion.getStart();
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), start, startRestartGroup, 48);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
                int hashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(startRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
                Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, companion);
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
                Updater.m4475setimpl(m4467constructorimpl, columnMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.m4475setimpl(m4467constructorimpl, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Updater.m4475setimpl(m4467constructorimpl, Integer.valueOf(hashCode), ComposeUiNode.Companion.getSetCompositeKeyHash());
                Updater.m4473reconcileimpl(m4467constructorimpl, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                Updater.m4475setimpl(m4467constructorimpl, materializeModifier, ComposeUiNode.Companion.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
                ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -216308211, "C83@2736L10,84@2781L12,85@2820L12,80@2617L251,88@2877L686:OnlineContent.kt#dswm0d");
                Modifier modifier3 = companion;
                int i6 = i4;
                TextKt.m3157TextNvy7gAk(obj, null, Color.m5347copywmQWz5c$default(Color.Companion.m5385getWhite0d7_KjU(), 0.88f, 0.0f, 0.0f, 0.0f, 14, null), null, TypeKt.m9847dpToSp8Feqmps(Dp.m8160constructorimpl(9.0f), startRestartGroup, 6), null, null, null, 0L, null, null, TypeKt.m9847dpToSp8Feqmps(Dp.m8160constructorimpl(9.0f), startRestartGroup, 6), 0, false, 1, 0, null, MaterialTheme.INSTANCE.getTypography(startRestartGroup, 6).getBodySmall(), startRestartGroup, (i4 & 14) | RendererCapabilities.DECODER_SUPPORT_MASK, 24576, 112618);
                Modifier m1054paddingqDBjuR0$default = PaddingKt.m1054paddingqDBjuR0$default(Modifier.Companion, 0.0f, Dp.m8160constructorimpl(3.0f), 0.0f, 0.0f, 13, null);
                Alignment.Vertical centerVertically = Alignment.Companion.getCenterVertically();
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.m742spacedBy0680j_4(Dp.m8160constructorimpl(4.0f)), centerVertically, startRestartGroup, 54);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
                int hashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(startRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
                Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(startRestartGroup, m1054paddingqDBjuR0$default);
                Function0<ComposeUiNode> constructor2 = ComposeUiNode.Companion.getConstructor();
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
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1295777640, "C94@3103L24,93@3070L163,101@3357L10,102@3406L13,103@3450L13,98@3246L307:OnlineContent.kt#dswm0d");
                ImageKt.Image(PainterResources_androidKt.painterResource(i, startRestartGroup, (i6 >> 6) & 14), (String) null, SizeKt.m1117size3ABfNKs(Modifier.Companion, Dp.m8160constructorimpl(12.0f)), (Alignment) null, (ContentScale) null, 0.0f, (ColorFilter) null, startRestartGroup, Painter.$stable | 432, 120);
                composer2 = startRestartGroup;
                String str3 = obj2;
                TextKt.m3157TextNvy7gAk(str3, null, Color.Companion.m5385getWhite0d7_KjU(), null, TypeKt.m9847dpToSp8Feqmps(Dp.m8160constructorimpl(11.0f), startRestartGroup, 6), null, FontWeight.Companion.getW700(), null, 0L, null, null, TypeKt.m9847dpToSp8Feqmps(Dp.m8160constructorimpl(11.0f), startRestartGroup, 6), 0, false, 1, 0, null, MaterialTheme.INSTANCE.getTypography(startRestartGroup, 6).getBodySmall(), composer2, ((i6 >> 3) & 14) | 1573248, 24576, 112554);
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
                modifier2 = modifier3;
            }
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup == null) {
                endRestartGroup.updateScope(new Function2() { // from class: com.miami.game.feature.home.ui.compose.OnlineContentKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj4, Object obj5) {
                        return OnlineContentKt.OnlineMetric$lambda$1(str, str2, i, modifier2, i2, i3, (Composer) obj4, ((Integer) obj5).intValue());
                    }
                });
                return;
            }
            return;
        }
        obj3 = modifier;
        if (startRestartGroup.shouldExecute((i4 & 1171) == 1170, i4 & 1)) {
        }
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    private static final String formatMetric(int i) {
        return StringsKt.reversed((CharSequence) CollectionsKt.joinToString$default(StringsKt.chunked(StringsKt.reversed((CharSequence) String.valueOf(i)).toString(), 3), " ", null, null, 0, null, null, 62, null)).toString();
    }
}
