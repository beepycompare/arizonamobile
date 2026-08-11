package com.miami.game.feature.select.server.ui.compose;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderKt;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
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
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.unit.Dp;
import androidx.core.app.NotificationCompat;
import androidx.media3.exoplayer.RendererCapabilities;
import com.miami.game.ui.classic.select.server.R;
import com.miami.game.ui.theme.TypeKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: ServerPromotionLabel.kt */
@Metadata(d1 = {"\u00002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a_\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000bH\u0007b\u0002\b\rb\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010¢\u0006\u0002\u0010\f\u001a\u001b\u0010\u0011\u001a\u00020\u000b*\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"ServerPromotion", "", "donate", "", "exp", "isTop", "", "isNew", "isMobile", "isArizona", "modifier", "Landroidx/compose/ui/Modifier;", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Boolean;ZZLandroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;I)V", "Landroidx/compose/runtime/Composable;", "Landroidx/compose/runtime/ComposableTarget;", "applier", "androidx.compose.ui.UiComposable", NotificationCompat.CATEGORY_PROMO, "color", "Landroidx/compose/ui/graphics/Color;", "promo-4WTKRHQ", "(Landroidx/compose/ui/Modifier;J)Landroidx/compose/ui/Modifier;", "select-server"}, k = 2, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ServerPromotionLabelKt {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit ServerPromotion$lambda$3(Integer num, Integer num2, Boolean bool, Boolean bool2, boolean z, boolean z2, Modifier modifier, int i, Composer composer, int i2) {
        ServerPromotion(num, num2, bool, bool2, z, z2, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:73:0x00e3, code lost:
        if (r45.intValue() <= 1) goto L115;
     */
    /* JADX WARN: Removed duplicated region for block: B:173:0x0b14  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void ServerPromotion(final Integer num, final Integer num2, final Boolean bool, final Boolean bool2, final boolean z, final boolean z2, final Modifier modifier, Composer composer, final int i) {
        int i2;
        String str;
        String str2;
        Object obj;
        float f;
        int i3;
        String str3;
        String str4;
        String str5;
        int i4;
        int i5;
        Intrinsics.checkNotNullParameter(modifier, "modifier");
        Composer startRestartGroup = composer.startRestartGroup(-751650928);
        ComposerKt.sourceInformation(startRestartGroup, "C(ServerPromotion)N(donate,exp,isTop,isNew,isMobile,isArizona,modifier):ServerPromotionLabel.kt#2ojkxh");
        if ((i & 6) == 0) {
            i2 = (startRestartGroup.changed(num) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= startRestartGroup.changed(num2) ? 32 : 16;
        }
        if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i2 |= startRestartGroup.changed(bool) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= startRestartGroup.changed(bool2) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i2 |= startRestartGroup.changed(z) ? 16384 : 8192;
        }
        if ((196608 & i) == 0) {
            i2 |= startRestartGroup.changed(z2) ? 131072 : 65536;
        }
        if ((1572864 & i) == 0) {
            i2 |= startRestartGroup.changed(modifier) ? 1048576 : 524288;
        }
        if (!startRestartGroup.shouldExecute((599187 & i2) != 599186, i2 & 1)) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-751650928, i2, -1, "com.miami.game.feature.select.server.ui.compose.ServerPromotion (ServerPromotionLabel.kt:30)");
            }
            if (num == null || ((num.intValue() <= 3 && z2) || (num.intValue() <= 2 && !z2))) {
                i3 = num2 != null ? 1 : 1;
                startRestartGroup.startReplaceGroup(1527029894);
                ComposerKt.sourceInformation(startRestartGroup, "");
                if (bool2 == null && bool == null) {
                    startRestartGroup.startReplaceGroup(1527013898);
                    ComposerKt.sourceInformation(startRestartGroup, "33@1520L616");
                    Alignment center = Alignment.Companion.getCenter();
                    Modifier m287backgroundbw27NRU = BackgroundKt.m287backgroundbw27NRU(SizeKt.m1119sizeVpY3zN4(modifier, Dp.m8160constructorimpl(140.0f), Dp.m8160constructorimpl(23.0f)), Color.m5347copywmQWz5c$default(Color.Companion.m5374getBlack0d7_KjU(), 0.2f, 0.0f, 0.0f, 0.0f, 14, null), new NoPromoShape());
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                    MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(center, false);
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
                    int hashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(startRestartGroup, 0));
                    CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
                    Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, m287backgroundbw27NRU);
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
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, 613549589, "C43@1979L10,44@2032L13,40@1845L277:ServerPromotionLabel.kt#2ojkxh");
                    TextKt.m3157TextNvy7gAk(z ? "Mobile" : "PC & Mobile", OffsetKt.m1010offsetVpY3zN4$default(Modifier.Companion, Dp.m8160constructorimpl(-Dp.m8160constructorimpl(4.0f)), 0.0f, 2, null), Color.m5347copywmQWz5c$default(Color.Companion.m5385getWhite0d7_KjU(), 0.2f, 0.0f, 0.0f, 0.0f, 14, null), null, TypeKt.m9864dpToSp8Feqmps(Dp.m8160constructorimpl(16.0f), startRestartGroup, 6), null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, MaterialTheme.INSTANCE.getTypography(startRestartGroup, 6).getBodySmall(), startRestartGroup, 432, 0, 131048);
                    startRestartGroup = startRestartGroup;
                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                    startRestartGroup.endNode();
                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                    startRestartGroup.endReplaceGroup();
                } else {
                    startRestartGroup.startReplaceGroup(1527694720);
                    ComposerKt.sourceInformation(startRestartGroup, "49@2166L2330");
                    Modifier m1010offsetVpY3zN4$default = OffsetKt.m1010offsetVpY3zN4$default(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, null), Dp.m8160constructorimpl(0.0f), 0.0f, 2, null);
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                    MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.m742spacedBy0680j_4(Dp.m8160constructorimpl(0.0f)), Alignment.Companion.getTop(), startRestartGroup, 6);
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
                    int hashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(startRestartGroup, 0));
                    CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
                    Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(startRestartGroup, m1010offsetVpY3zN4$default);
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
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, -787916575, "C:ServerPromotionLabel.kt#2ojkxh");
                    if (bool == null) {
                        str = "C101@5233L9:Row.kt#2w3rfo";
                        str2 = "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo";
                        obj = null;
                        f = 0.0f;
                        startRestartGroup.startReplaceGroup(-786934155);
                        startRestartGroup.endReplaceGroup();
                    } else {
                        startRestartGroup.startReplaceGroup(-787911089);
                        ComposerKt.sourceInformation(startRestartGroup, "55@2390L998");
                        Alignment center2 = Alignment.Companion.getCenter();
                        Modifier m9836promo4WTKRHQ = m9836promo4WTKRHQ(modifier, ColorKt.Color(4294927670L));
                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                        MeasurePolicy maybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(center2, false);
                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
                        int hashCode3 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(startRestartGroup, 0));
                        CompositionLocalMap currentCompositionLocalMap3 = startRestartGroup.getCurrentCompositionLocalMap();
                        Modifier materializeModifier3 = ComposedModifierKt.materializeModifier(startRestartGroup, m9836promo4WTKRHQ);
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
                        Updater.m4475setimpl(m4467constructorimpl3, maybeCachedBoxMeasurePolicy2, ComposeUiNode.Companion.getSetMeasurePolicy());
                        Updater.m4475setimpl(m4467constructorimpl3, currentCompositionLocalMap3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                        Updater.m4475setimpl(m4467constructorimpl3, Integer.valueOf(hashCode3), ComposeUiNode.Companion.getSetCompositeKeyHash());
                        Updater.m4473reconcileimpl(m4467constructorimpl3, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                        Updater.m4475setimpl(m4467constructorimpl3, materializeModifier3, ComposeUiNode.Companion.getSetModifier());
                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                        BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1286455813, "C60@2602L764:ServerPromotionLabel.kt#2ojkxh");
                        Alignment.Vertical centerVertically = Alignment.Companion.getCenterVertically();
                        Modifier m1010offsetVpY3zN4$default2 = OffsetKt.m1010offsetVpY3zN4$default(Modifier.Companion, Dp.m8160constructorimpl(-Dp.m8160constructorimpl(4.0f)), 0.0f, 2, null);
                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                        MeasurePolicy rowMeasurePolicy2 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically, startRestartGroup, 48);
                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
                        int hashCode4 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(startRestartGroup, 0));
                        CompositionLocalMap currentCompositionLocalMap4 = startRestartGroup.getCurrentCompositionLocalMap();
                        Modifier materializeModifier4 = ComposedModifierKt.materializeModifier(startRestartGroup, m1010offsetVpY3zN4$default2);
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
                        Updater.m4475setimpl(m4467constructorimpl4, rowMeasurePolicy2, ComposeUiNode.Companion.getSetMeasurePolicy());
                        Updater.m4475setimpl(m4467constructorimpl4, currentCompositionLocalMap4, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                        Updater.m4475setimpl(m4467constructorimpl4, Integer.valueOf(hashCode4), ComposeUiNode.Companion.getSetCompositeKeyHash());
                        Updater.m4473reconcileimpl(m4467constructorimpl4, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                        Updater.m4475setimpl(m4467constructorimpl4, materializeModifier4, ComposeUiNode.Companion.getSetModifier());
                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                        RowScopeInstance rowScopeInstance2 = RowScopeInstance.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1402514499, "C64@2810L41,64@2804L107,66@2940L39,70@3161L10,71@3226L13,67@3008L332:ServerPromotionLabel.kt#2ojkxh");
                        str = "C101@5233L9:Row.kt#2w3rfo";
                        obj = null;
                        f = 0.0f;
                        str2 = "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo";
                        ImageKt.Image(PainterResources_androidKt.painterResource(R.drawable.server_top_ic, startRestartGroup, 0), (String) null, SizeKt.m1117size3ABfNKs(Modifier.Companion, Dp.m8160constructorimpl(12.0f)), (Alignment) null, (ContentScale) null, 0.0f, (ColorFilter) null, startRestartGroup, Painter.$stable | 432, 120);
                        SpacerKt.Spacer(SizeKt.m1122width3ABfNKs(Modifier.Companion, Dp.m8160constructorimpl(4.0f)), startRestartGroup, 6);
                        TextKt.m3157TextNvy7gAk(" TOP", OffsetKt.m1010offsetVpY3zN4$default(Modifier.Companion, Dp.m8160constructorimpl(-Dp.m8160constructorimpl(4.0f)), 0.0f, 2, null), Color.Companion.m5385getWhite0d7_KjU(), null, TypeKt.m9864dpToSp8Feqmps(Dp.m8160constructorimpl(18.0f), startRestartGroup, 6), null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, MaterialTheme.INSTANCE.getTypography(startRestartGroup, 6).getBodySmall(), startRestartGroup, 438, 0, 131048);
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
                        startRestartGroup.endReplaceGroup();
                    }
                    if (bool2 != null) {
                        startRestartGroup.startReplaceGroup(-786845619);
                        ComposerKt.sourceInformation(startRestartGroup, "78@3464L1000");
                        Alignment center3 = Alignment.Companion.getCenter();
                        Modifier m9836promo4WTKRHQ2 = m9836promo4WTKRHQ(modifier, ColorKt.Color(4294945024L));
                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                        MeasurePolicy maybeCachedBoxMeasurePolicy3 = BoxKt.maybeCachedBoxMeasurePolicy(center3, false);
                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
                        int hashCode5 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(startRestartGroup, 0));
                        CompositionLocalMap currentCompositionLocalMap5 = startRestartGroup.getCurrentCompositionLocalMap();
                        Modifier materializeModifier5 = ComposedModifierKt.materializeModifier(startRestartGroup, m9836promo4WTKRHQ2);
                        Function0<ComposeUiNode> constructor5 = ComposeUiNode.Companion.getConstructor();
                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)410@16187L9:Composables.kt#9igjgp");
                        if (!(startRestartGroup.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        startRestartGroup.startReusableNode();
                        if (startRestartGroup.getInserting()) {
                            startRestartGroup.createNode(constructor5);
                        } else {
                            startRestartGroup.useNode();
                        }
                        Composer m4467constructorimpl5 = Updater.m4467constructorimpl(startRestartGroup);
                        Updater.m4475setimpl(m4467constructorimpl5, maybeCachedBoxMeasurePolicy3, ComposeUiNode.Companion.getSetMeasurePolicy());
                        Updater.m4475setimpl(m4467constructorimpl5, currentCompositionLocalMap5, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                        Updater.m4475setimpl(m4467constructorimpl5, Integer.valueOf(hashCode5), ComposeUiNode.Companion.getSetCompositeKeyHash());
                        Updater.m4473reconcileimpl(m4467constructorimpl5, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                        Updater.m4475setimpl(m4467constructorimpl5, materializeModifier5, ComposeUiNode.Companion.getSetModifier());
                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                        BoxScopeInstance boxScopeInstance3 = BoxScopeInstance.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 556513072, "C83@3676L766:ServerPromotionLabel.kt#2ojkxh");
                        Alignment.Vertical centerVertically2 = Alignment.Companion.getCenterVertically();
                        Modifier m1010offsetVpY3zN4$default3 = OffsetKt.m1010offsetVpY3zN4$default(Modifier.Companion, Dp.m8160constructorimpl(-Dp.m8160constructorimpl(1.0f)), f, 2, obj);
                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 844473419, str2);
                        MeasurePolicy rowMeasurePolicy3 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically2, startRestartGroup, 48);
                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
                        int hashCode6 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(startRestartGroup, 0));
                        CompositionLocalMap currentCompositionLocalMap6 = startRestartGroup.getCurrentCompositionLocalMap();
                        Modifier materializeModifier6 = ComposedModifierKt.materializeModifier(startRestartGroup, m1010offsetVpY3zN4$default3);
                        Function0<ComposeUiNode> constructor6 = ComposeUiNode.Companion.getConstructor();
                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)410@16187L9:Composables.kt#9igjgp");
                        if (!(startRestartGroup.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        startRestartGroup.startReusableNode();
                        if (startRestartGroup.getInserting()) {
                            startRestartGroup.createNode(constructor6);
                        } else {
                            startRestartGroup.useNode();
                        }
                        Composer m4467constructorimpl6 = Updater.m4467constructorimpl(startRestartGroup);
                        Updater.m4475setimpl(m4467constructorimpl6, rowMeasurePolicy3, ComposeUiNode.Companion.getSetMeasurePolicy());
                        Updater.m4475setimpl(m4467constructorimpl6, currentCompositionLocalMap6, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                        Updater.m4475setimpl(m4467constructorimpl6, Integer.valueOf(hashCode6), ComposeUiNode.Companion.getSetCompositeKeyHash());
                        Updater.m4473reconcileimpl(m4467constructorimpl6, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                        Updater.m4475setimpl(m4467constructorimpl6, materializeModifier6, ComposeUiNode.Companion.getSetModifier());
                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1456264949, str);
                        RowScopeInstance rowScopeInstance3 = RowScopeInstance.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, -910353288, "C87@3884L41,87@3878L107,89@4014L39,93@4237L10,94@4302L13,90@4082L334:ServerPromotionLabel.kt#2ojkxh");
                        Composer composer2 = startRestartGroup;
                        ImageKt.Image(PainterResources_androidKt.painterResource(R.drawable.server_new_ic, startRestartGroup, 0), (String) null, SizeKt.m1117size3ABfNKs(Modifier.Companion, Dp.m8160constructorimpl(12.0f)), (Alignment) null, (ContentScale) null, 0.0f, (ColorFilter) null, composer2, Painter.$stable | 432, 120);
                        SpacerKt.Spacer(SizeKt.m1122width3ABfNKs(Modifier.Companion, Dp.m8160constructorimpl(4.0f)), composer2, 6);
                        TextKt.m3157TextNvy7gAk(" Новый", OffsetKt.m1010offsetVpY3zN4$default(Modifier.Companion, Dp.m8160constructorimpl(-Dp.m8160constructorimpl(4.0f)), f, 2, obj), Color.Companion.m5385getWhite0d7_KjU(), null, TypeKt.m9864dpToSp8Feqmps(Dp.m8160constructorimpl(18.0f), composer2, 6), null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, MaterialTheme.INSTANCE.getTypography(composer2, 6).getBodySmall(), composer2, 438, 0, 131048);
                        startRestartGroup = composer2;
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
                        startRestartGroup.endReplaceGroup();
                    } else {
                        startRestartGroup.startReplaceGroup(-785866763);
                        startRestartGroup.endReplaceGroup();
                    }
                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                    startRestartGroup.endNode();
                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                    startRestartGroup.endReplaceGroup();
                }
                startRestartGroup.endReplaceGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                i3 = 1;
            }
            startRestartGroup.startReplaceGroup(1530012063);
            ComposerKt.sourceInformation(startRestartGroup, "103@4528L1379");
            Modifier m1010offsetVpY3zN4$default4 = OffsetKt.m1010offsetVpY3zN4$default(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, i3, null), Dp.m8160constructorimpl(0.0f), 0.0f, 2, null);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            MeasurePolicy rowMeasurePolicy4 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.m742spacedBy0680j_4(Dp.m8160constructorimpl(0.0f)), Alignment.Companion.getTop(), startRestartGroup, 6);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
            int hashCode7 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(startRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap7 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier7 = ComposedModifierKt.materializeModifier(startRestartGroup, m1010offsetVpY3zN4$default4);
            Function0<ComposeUiNode> constructor7 = ComposeUiNode.Companion.getConstructor();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)410@16187L9:Composables.kt#9igjgp");
            if (!(startRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(constructor7);
            } else {
                startRestartGroup.useNode();
            }
            Composer m4467constructorimpl7 = Updater.m4467constructorimpl(startRestartGroup);
            Updater.m4475setimpl(m4467constructorimpl7, rowMeasurePolicy4, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m4475setimpl(m4467constructorimpl7, currentCompositionLocalMap7, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.m4475setimpl(m4467constructorimpl7, Integer.valueOf(hashCode7), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.m4473reconcileimpl(m4467constructorimpl7, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.m4475setimpl(m4467constructorimpl7, materializeModifier7, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScopeInstance rowScopeInstance4 = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 703273413, "C:ServerPromotionLabel.kt#2ojkxh");
            if (num2 != null && num2.intValue() > 1) {
                startRestartGroup.startReplaceGroup(703297158);
                ComposerKt.sourceInformation(startRestartGroup, "109@4737L500");
                Alignment center4 = Alignment.Companion.getCenter();
                Modifier m9836promo4WTKRHQ3 = m9836promo4WTKRHQ(modifier, ColorKt.Color(4289456127L));
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                MeasurePolicy maybeCachedBoxMeasurePolicy4 = BoxKt.maybeCachedBoxMeasurePolicy(center4, false);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
                int hashCode8 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(startRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap8 = startRestartGroup.getCurrentCompositionLocalMap();
                Modifier materializeModifier8 = ComposedModifierKt.materializeModifier(startRestartGroup, m9836promo4WTKRHQ3);
                Function0<ComposeUiNode> constructor8 = ComposeUiNode.Companion.getConstructor();
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)410@16187L9:Composables.kt#9igjgp");
                if (!(startRestartGroup.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                startRestartGroup.startReusableNode();
                if (startRestartGroup.getInserting()) {
                    startRestartGroup.createNode(constructor8);
                } else {
                    startRestartGroup.useNode();
                }
                Composer m4467constructorimpl8 = Updater.m4467constructorimpl(startRestartGroup);
                Updater.m4475setimpl(m4467constructorimpl8, maybeCachedBoxMeasurePolicy4, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.m4475setimpl(m4467constructorimpl8, currentCompositionLocalMap8, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Updater.m4475setimpl(m4467constructorimpl8, Integer.valueOf(hashCode8), ComposeUiNode.Companion.getSetCompositeKeyHash());
                Updater.m4473reconcileimpl(m4467constructorimpl8, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                Updater.m4475setimpl(m4467constructorimpl8, materializeModifier8, ComposeUiNode.Companion.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance4 = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1777440006, "C117@5064L10,118@5121L13,114@4929L290:ServerPromotionLabel.kt#2ojkxh");
                str3 = "C72@3469L9:Box.kt#2w3rfo";
                str4 = "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh";
                i5 = 2;
                i4 = 6;
                str5 = "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo";
                TextKt.m3157TextNvy7gAk("X" + num2 + " Опыт", OffsetKt.m1010offsetVpY3zN4$default(Modifier.Companion, Dp.m8160constructorimpl(-Dp.m8160constructorimpl(4.0f)), 0.0f, 2, null), Color.Companion.m5385getWhite0d7_KjU(), null, TypeKt.m9864dpToSp8Feqmps(Dp.m8160constructorimpl(18.0f), startRestartGroup, 6), null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, MaterialTheme.INSTANCE.getTypography(startRestartGroup, 6).getBodySmall(), startRestartGroup, 432, 0, 131048);
                startRestartGroup = startRestartGroup;
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                startRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                startRestartGroup.endReplaceGroup();
            } else {
                str3 = "C72@3469L9:Box.kt#2w3rfo";
                str4 = "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh";
                str5 = "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo";
                i4 = 6;
                i5 = 2;
                startRestartGroup.startReplaceGroup(703791546);
                startRestartGroup.endReplaceGroup();
            }
            if (num != null && ((num.intValue() > 3 && z2) || (num.intValue() > i5 && !z2))) {
                startRestartGroup.startReplaceGroup(703918770);
                ComposerKt.sourceInformation(startRestartGroup, "127@5510L11,124@5363L520");
                Alignment center5 = Alignment.Companion.getCenter();
                Modifier m9836promo4WTKRHQ4 = m9836promo4WTKRHQ(modifier, MaterialTheme.INSTANCE.getColorScheme(startRestartGroup, i4).m2322getPrimary0d7_KjU());
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1042775818, str5);
                MeasurePolicy maybeCachedBoxMeasurePolicy5 = BoxKt.maybeCachedBoxMeasurePolicy(center5, false);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1159599143, str4);
                int hashCode9 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(startRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap9 = startRestartGroup.getCurrentCompositionLocalMap();
                Modifier materializeModifier9 = ComposedModifierKt.materializeModifier(startRestartGroup, m9836promo4WTKRHQ4);
                Function0<ComposeUiNode> constructor9 = ComposeUiNode.Companion.getConstructor();
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)410@16187L9:Composables.kt#9igjgp");
                if (!(startRestartGroup.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                startRestartGroup.startReusableNode();
                if (startRestartGroup.getInserting()) {
                    startRestartGroup.createNode(constructor9);
                } else {
                    startRestartGroup.useNode();
                }
                Composer m4467constructorimpl9 = Updater.m4467constructorimpl(startRestartGroup);
                Updater.m4475setimpl(m4467constructorimpl9, maybeCachedBoxMeasurePolicy5, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.m4475setimpl(m4467constructorimpl9, currentCompositionLocalMap9, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Updater.m4475setimpl(m4467constructorimpl9, Integer.valueOf(hashCode9), ComposeUiNode.Companion.getSetCompositeKeyHash());
                Updater.m4473reconcileimpl(m4467constructorimpl9, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                Updater.m4475setimpl(m4467constructorimpl9, materializeModifier9, ComposeUiNode.Companion.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1833054614, str3);
                BoxScopeInstance boxScopeInstance5 = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -878355155, "C132@5710L10,133@5767L13,129@5571L294:ServerPromotionLabel.kt#2ojkxh");
                Composer composer3 = startRestartGroup;
                TextKt.m3157TextNvy7gAk("X" + num + " Донат", OffsetKt.m1010offsetVpY3zN4$default(Modifier.Companion, Dp.m8160constructorimpl(-Dp.m8160constructorimpl(4.0f)), 0.0f, i5, null), Color.Companion.m5385getWhite0d7_KjU(), null, TypeKt.m9864dpToSp8Feqmps(Dp.m8160constructorimpl(18.0f), startRestartGroup, i4), null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, MaterialTheme.INSTANCE.getTypography(startRestartGroup, i4).getBodySmall(), composer3, 432, 0, 131048);
                startRestartGroup = composer3;
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                startRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                startRestartGroup.endReplaceGroup();
            } else {
                startRestartGroup.startReplaceGroup(704432378);
                startRestartGroup.endReplaceGroup();
            }
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            startRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            startRestartGroup.endReplaceGroup();
            if (ComposerKt.isTraceInProgress()) {
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: com.miami.game.feature.select.server.ui.compose.ServerPromotionLabelKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj2, Object obj3) {
                    return ServerPromotionLabelKt.ServerPromotion$lambda$3(num, num2, bool, bool2, z, z2, modifier, i, (Composer) obj2, ((Integer) obj3).intValue());
                }
            });
        }
    }

    /* renamed from: promo-4WTKRHQ  reason: not valid java name */
    private static final Modifier m9836promo4WTKRHQ(Modifier modifier, long j) {
        return PaddingKt.m1051paddingVpY3zN4(BorderKt.m299borderxT4_qwU(BackgroundKt.m287backgroundbw27NRU(SizeKt.m1122width3ABfNKs(SizeKt.m1103height3ABfNKs(modifier, Dp.m8160constructorimpl(27.0f)), Dp.m8160constructorimpl(80.0f)), Color.m5347copywmQWz5c$default(Color.Companion.m5374getBlack0d7_KjU(), 0.2f, 0.0f, 0.0f, 0.0f, 14, null), new ExpShape()), Dp.m8160constructorimpl(2.0f), j, new ExpShape()), Dp.m8160constructorimpl(0.0f), Dp.m8160constructorimpl(0.0f));
    }
}
