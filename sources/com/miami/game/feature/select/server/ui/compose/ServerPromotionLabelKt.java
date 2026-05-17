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
@Metadata(d1 = {"\u0000(\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aM\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000bH\u0007¢\u0006\u0002\u0010\f\u001a\u001b\u0010\r\u001a\u00020\u000b*\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"ServerPromotion", "", "donate", "", "exp", "isTop", "", "isNew", "isMobile", "isArizona", "modifier", "Landroidx/compose/ui/Modifier;", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Boolean;ZZLandroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;I)V", NotificationCompat.CATEGORY_PROMO, "color", "Landroidx/compose/ui/graphics/Color;", "promo-4WTKRHQ", "(Landroidx/compose/ui/Modifier;J)Landroidx/compose/ui/Modifier;", "select-server"}, k = 2, mv = {2, 3, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ServerPromotionLabelKt {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit ServerPromotion$lambda$3(Integer num, Integer num2, Boolean bool, Boolean bool2, boolean z, boolean z2, Modifier modifier, int i, Composer composer, int i2) {
        ServerPromotion(num, num2, bool, bool2, z, z2, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:73:0x00e3, code lost:
        if (r45.intValue() <= 1) goto L115;
     */
    /* JADX WARN: Removed duplicated region for block: B:173:0x0b1e  */
    /* JADX WARN: Type inference failed for: r3v64 */
    /* JADX WARN: Type inference failed for: r3v65, types: [int, boolean] */
    /* JADX WARN: Type inference failed for: r3v95 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void ServerPromotion(final Integer num, final Integer num2, final Boolean bool, final Boolean bool2, final boolean z, final boolean z2, final Modifier modifier, Composer composer, final int i) {
        int i2;
        String str;
        String str2;
        float f;
        int i3;
        String str3;
        String str4;
        String str5;
        ?? r3;
        int i4;
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
                    Modifier m263backgroundbw27NRU = BackgroundKt.m263backgroundbw27NRU(SizeKt.m866sizeVpY3zN4(modifier, Dp.m7555constructorimpl(140.0f), Dp.m7555constructorimpl(23.0f)), Color.m4771copywmQWz5c$default(Color.Companion.m4798getBlack0d7_KjU(), 0.2f, 0.0f, 0.0f, 0.0f, 14, null), new NoPromoShape());
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                    MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(center, false);
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                    int hashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(startRestartGroup, 0));
                    CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
                    Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, m263backgroundbw27NRU);
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
                    Composer m4041constructorimpl = Updater.m4041constructorimpl(startRestartGroup);
                    Updater.m4049setimpl(m4041constructorimpl, maybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                    Updater.m4049setimpl(m4041constructorimpl, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                    Updater.m4045initimpl(m4041constructorimpl, Integer.valueOf(hashCode), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    Updater.m4047reconcileimpl(m4041constructorimpl, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                    Updater.m4049setimpl(m4041constructorimpl, materializeModifier, ComposeUiNode.Companion.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                    BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, 613549589, "C43@1979L10,44@2032L13,40@1845L277:ServerPromotionLabel.kt#2ojkxh");
                    TextKt.m2712TextNvy7gAk(z ? "Mobile" : "PC & Mobile", OffsetKt.m778offsetVpY3zN4$default(Modifier.Companion, Dp.m7555constructorimpl(-Dp.m7555constructorimpl(4.0f)), 0.0f, 2, null), Color.m4771copywmQWz5c$default(Color.Companion.m4809getWhite0d7_KjU(), 0.2f, 0.0f, 0.0f, 0.0f, 14, null), null, TypeKt.m9154dpToSp8Feqmps(Dp.m7555constructorimpl(16.0f), startRestartGroup, 6), null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, MaterialTheme.INSTANCE.getTypography(startRestartGroup, MaterialTheme.$stable).getBodySmall(), startRestartGroup, 432, 0, 131048);
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
                    Modifier m778offsetVpY3zN4$default = OffsetKt.m778offsetVpY3zN4$default(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, null), Dp.m7555constructorimpl(0.0f), 0.0f, 2, null);
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                    MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.m688spacedBy0680j_4(Dp.m7555constructorimpl(0.0f)), Alignment.Companion.getTop(), startRestartGroup, 6);
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                    int hashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(startRestartGroup, 0));
                    CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
                    Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(startRestartGroup, m778offsetVpY3zN4$default);
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
                    Composer m4041constructorimpl2 = Updater.m4041constructorimpl(startRestartGroup);
                    Updater.m4049setimpl(m4041constructorimpl2, rowMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                    Updater.m4049setimpl(m4041constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                    Updater.m4045initimpl(m4041constructorimpl2, Integer.valueOf(hashCode2), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    Updater.m4047reconcileimpl(m4041constructorimpl2, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                    Updater.m4049setimpl(m4041constructorimpl2, materializeModifier2, ComposeUiNode.Companion.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                    RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, -787916575, "C:ServerPromotionLabel.kt#2ojkxh");
                    if (bool == null) {
                        str = "C101@5233L9:Row.kt#2w3rfo";
                        str2 = "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo";
                        f = 0.0f;
                        startRestartGroup.startReplaceGroup(-786934155);
                        startRestartGroup.endReplaceGroup();
                    } else {
                        startRestartGroup.startReplaceGroup(-787911089);
                        ComposerKt.sourceInformation(startRestartGroup, "55@2390L998");
                        Alignment center2 = Alignment.Companion.getCenter();
                        Modifier m9128promo4WTKRHQ = m9128promo4WTKRHQ(modifier, ColorKt.Color(4294927670L));
                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                        MeasurePolicy maybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(center2, false);
                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                        int hashCode3 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(startRestartGroup, 0));
                        CompositionLocalMap currentCompositionLocalMap3 = startRestartGroup.getCurrentCompositionLocalMap();
                        Modifier materializeModifier3 = ComposedModifierKt.materializeModifier(startRestartGroup, m9128promo4WTKRHQ);
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
                        Composer m4041constructorimpl3 = Updater.m4041constructorimpl(startRestartGroup);
                        Updater.m4049setimpl(m4041constructorimpl3, maybeCachedBoxMeasurePolicy2, ComposeUiNode.Companion.getSetMeasurePolicy());
                        Updater.m4049setimpl(m4041constructorimpl3, currentCompositionLocalMap3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                        Updater.m4045initimpl(m4041constructorimpl3, Integer.valueOf(hashCode3), ComposeUiNode.Companion.getSetCompositeKeyHash());
                        Updater.m4047reconcileimpl(m4041constructorimpl3, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                        Updater.m4049setimpl(m4041constructorimpl3, materializeModifier3, ComposeUiNode.Companion.getSetModifier());
                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                        BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1286455813, "C60@2602L764:ServerPromotionLabel.kt#2ojkxh");
                        Alignment.Vertical centerVertically = Alignment.Companion.getCenterVertically();
                        Modifier m778offsetVpY3zN4$default2 = OffsetKt.m778offsetVpY3zN4$default(Modifier.Companion, Dp.m7555constructorimpl(-Dp.m7555constructorimpl(4.0f)), 0.0f, 2, null);
                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                        MeasurePolicy rowMeasurePolicy2 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically, startRestartGroup, 48);
                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                        int hashCode4 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(startRestartGroup, 0));
                        CompositionLocalMap currentCompositionLocalMap4 = startRestartGroup.getCurrentCompositionLocalMap();
                        Modifier materializeModifier4 = ComposedModifierKt.materializeModifier(startRestartGroup, m778offsetVpY3zN4$default2);
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
                        Composer m4041constructorimpl4 = Updater.m4041constructorimpl(startRestartGroup);
                        Updater.m4049setimpl(m4041constructorimpl4, rowMeasurePolicy2, ComposeUiNode.Companion.getSetMeasurePolicy());
                        Updater.m4049setimpl(m4041constructorimpl4, currentCompositionLocalMap4, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                        Updater.m4045initimpl(m4041constructorimpl4, Integer.valueOf(hashCode4), ComposeUiNode.Companion.getSetCompositeKeyHash());
                        Updater.m4047reconcileimpl(m4041constructorimpl4, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                        Updater.m4049setimpl(m4041constructorimpl4, materializeModifier4, ComposeUiNode.Companion.getSetModifier());
                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                        RowScopeInstance rowScopeInstance2 = RowScopeInstance.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1402514499, "C64@2810L41,64@2804L107,66@2940L39,70@3161L10,71@3226L13,67@3008L332:ServerPromotionLabel.kt#2ojkxh");
                        str = "C101@5233L9:Row.kt#2w3rfo";
                        f = 0.0f;
                        str2 = "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo";
                        ImageKt.Image(PainterResources_androidKt.painterResource(R.drawable.server_top_ic, startRestartGroup, 0), (String) null, SizeKt.m864size3ABfNKs(Modifier.Companion, Dp.m7555constructorimpl(12.0f)), (Alignment) null, (ContentScale) null, 0.0f, (ColorFilter) null, startRestartGroup, Painter.$stable | 432, 120);
                        SpacerKt.Spacer(SizeKt.m869width3ABfNKs(Modifier.Companion, Dp.m7555constructorimpl(4.0f)), startRestartGroup, 6);
                        TextKt.m2712TextNvy7gAk(" TOP", OffsetKt.m778offsetVpY3zN4$default(Modifier.Companion, Dp.m7555constructorimpl(-Dp.m7555constructorimpl(4.0f)), 0.0f, 2, null), Color.Companion.m4809getWhite0d7_KjU(), null, TypeKt.m9154dpToSp8Feqmps(Dp.m7555constructorimpl(18.0f), startRestartGroup, 6), null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, MaterialTheme.INSTANCE.getTypography(startRestartGroup, MaterialTheme.$stable).getBodySmall(), startRestartGroup, 438, 0, 131048);
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
                        Modifier m9128promo4WTKRHQ2 = m9128promo4WTKRHQ(modifier, ColorKt.Color(4294945024L));
                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                        MeasurePolicy maybeCachedBoxMeasurePolicy3 = BoxKt.maybeCachedBoxMeasurePolicy(center3, false);
                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                        int hashCode5 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(startRestartGroup, 0));
                        CompositionLocalMap currentCompositionLocalMap5 = startRestartGroup.getCurrentCompositionLocalMap();
                        Modifier materializeModifier5 = ComposedModifierKt.materializeModifier(startRestartGroup, m9128promo4WTKRHQ2);
                        Function0<ComposeUiNode> constructor5 = ComposeUiNode.Companion.getConstructor();
                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                        if (!(startRestartGroup.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        startRestartGroup.startReusableNode();
                        if (startRestartGroup.getInserting()) {
                            startRestartGroup.createNode(constructor5);
                        } else {
                            startRestartGroup.useNode();
                        }
                        Composer m4041constructorimpl5 = Updater.m4041constructorimpl(startRestartGroup);
                        Updater.m4049setimpl(m4041constructorimpl5, maybeCachedBoxMeasurePolicy3, ComposeUiNode.Companion.getSetMeasurePolicy());
                        Updater.m4049setimpl(m4041constructorimpl5, currentCompositionLocalMap5, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                        Updater.m4045initimpl(m4041constructorimpl5, Integer.valueOf(hashCode5), ComposeUiNode.Companion.getSetCompositeKeyHash());
                        Updater.m4047reconcileimpl(m4041constructorimpl5, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                        Updater.m4049setimpl(m4041constructorimpl5, materializeModifier5, ComposeUiNode.Companion.getSetModifier());
                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                        BoxScopeInstance boxScopeInstance3 = BoxScopeInstance.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 556513072, "C83@3676L766:ServerPromotionLabel.kt#2ojkxh");
                        Alignment.Vertical centerVertically2 = Alignment.Companion.getCenterVertically();
                        Modifier m778offsetVpY3zN4$default3 = OffsetKt.m778offsetVpY3zN4$default(Modifier.Companion, Dp.m7555constructorimpl(-Dp.m7555constructorimpl(1.0f)), f, 2, null);
                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 844473419, str2);
                        MeasurePolicy rowMeasurePolicy3 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically2, startRestartGroup, 48);
                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                        int hashCode6 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(startRestartGroup, 0));
                        CompositionLocalMap currentCompositionLocalMap6 = startRestartGroup.getCurrentCompositionLocalMap();
                        Modifier materializeModifier6 = ComposedModifierKt.materializeModifier(startRestartGroup, m778offsetVpY3zN4$default3);
                        Function0<ComposeUiNode> constructor6 = ComposeUiNode.Companion.getConstructor();
                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                        if (!(startRestartGroup.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        startRestartGroup.startReusableNode();
                        if (startRestartGroup.getInserting()) {
                            startRestartGroup.createNode(constructor6);
                        } else {
                            startRestartGroup.useNode();
                        }
                        Composer m4041constructorimpl6 = Updater.m4041constructorimpl(startRestartGroup);
                        Updater.m4049setimpl(m4041constructorimpl6, rowMeasurePolicy3, ComposeUiNode.Companion.getSetMeasurePolicy());
                        Updater.m4049setimpl(m4041constructorimpl6, currentCompositionLocalMap6, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                        Updater.m4045initimpl(m4041constructorimpl6, Integer.valueOf(hashCode6), ComposeUiNode.Companion.getSetCompositeKeyHash());
                        Updater.m4047reconcileimpl(m4041constructorimpl6, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                        Updater.m4049setimpl(m4041constructorimpl6, materializeModifier6, ComposeUiNode.Companion.getSetModifier());
                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1456264949, str);
                        RowScopeInstance rowScopeInstance3 = RowScopeInstance.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, -910353288, "C87@3884L41,87@3878L107,89@4014L39,93@4237L10,94@4302L13,90@4082L334:ServerPromotionLabel.kt#2ojkxh");
                        Composer composer2 = startRestartGroup;
                        ImageKt.Image(PainterResources_androidKt.painterResource(R.drawable.server_new_ic, startRestartGroup, 0), (String) null, SizeKt.m864size3ABfNKs(Modifier.Companion, Dp.m7555constructorimpl(12.0f)), (Alignment) null, (ContentScale) null, 0.0f, (ColorFilter) null, composer2, Painter.$stable | 432, 120);
                        SpacerKt.Spacer(SizeKt.m869width3ABfNKs(Modifier.Companion, Dp.m7555constructorimpl(4.0f)), composer2, 6);
                        TextKt.m2712TextNvy7gAk(" Новый", OffsetKt.m778offsetVpY3zN4$default(Modifier.Companion, Dp.m7555constructorimpl(-Dp.m7555constructorimpl(4.0f)), f, 2, null), Color.Companion.m4809getWhite0d7_KjU(), null, TypeKt.m9154dpToSp8Feqmps(Dp.m7555constructorimpl(18.0f), composer2, 6), null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, MaterialTheme.INSTANCE.getTypography(composer2, MaterialTheme.$stable).getBodySmall(), composer2, 438, 0, 131048);
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
            Modifier m778offsetVpY3zN4$default4 = OffsetKt.m778offsetVpY3zN4$default(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, i3, null), Dp.m7555constructorimpl(0.0f), 0.0f, 2, null);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            MeasurePolicy rowMeasurePolicy4 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.m688spacedBy0680j_4(Dp.m7555constructorimpl(0.0f)), Alignment.Companion.getTop(), startRestartGroup, 6);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int hashCode7 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(startRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap7 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier7 = ComposedModifierKt.materializeModifier(startRestartGroup, m778offsetVpY3zN4$default4);
            Function0<ComposeUiNode> constructor7 = ComposeUiNode.Companion.getConstructor();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!(startRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(constructor7);
            } else {
                startRestartGroup.useNode();
            }
            Composer m4041constructorimpl7 = Updater.m4041constructorimpl(startRestartGroup);
            Updater.m4049setimpl(m4041constructorimpl7, rowMeasurePolicy4, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m4049setimpl(m4041constructorimpl7, currentCompositionLocalMap7, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.m4045initimpl(m4041constructorimpl7, Integer.valueOf(hashCode7), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.m4047reconcileimpl(m4041constructorimpl7, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.m4049setimpl(m4041constructorimpl7, materializeModifier7, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScopeInstance rowScopeInstance4 = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 703273413, "C:ServerPromotionLabel.kt#2ojkxh");
            if (num2 != null && num2.intValue() > 1) {
                startRestartGroup.startReplaceGroup(703297158);
                ComposerKt.sourceInformation(startRestartGroup, "109@4737L500");
                Alignment center4 = Alignment.Companion.getCenter();
                Modifier m9128promo4WTKRHQ3 = m9128promo4WTKRHQ(modifier, ColorKt.Color(4289456127L));
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                MeasurePolicy maybeCachedBoxMeasurePolicy4 = BoxKt.maybeCachedBoxMeasurePolicy(center4, false);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int hashCode8 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(startRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap8 = startRestartGroup.getCurrentCompositionLocalMap();
                Modifier materializeModifier8 = ComposedModifierKt.materializeModifier(startRestartGroup, m9128promo4WTKRHQ3);
                Function0<ComposeUiNode> constructor8 = ComposeUiNode.Companion.getConstructor();
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                if (!(startRestartGroup.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                startRestartGroup.startReusableNode();
                if (startRestartGroup.getInserting()) {
                    startRestartGroup.createNode(constructor8);
                } else {
                    startRestartGroup.useNode();
                }
                Composer m4041constructorimpl8 = Updater.m4041constructorimpl(startRestartGroup);
                Updater.m4049setimpl(m4041constructorimpl8, maybeCachedBoxMeasurePolicy4, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.m4049setimpl(m4041constructorimpl8, currentCompositionLocalMap8, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Updater.m4045initimpl(m4041constructorimpl8, Integer.valueOf(hashCode8), ComposeUiNode.Companion.getSetCompositeKeyHash());
                Updater.m4047reconcileimpl(m4041constructorimpl8, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                Updater.m4049setimpl(m4041constructorimpl8, materializeModifier8, ComposeUiNode.Companion.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance4 = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1777440006, "C117@5064L10,118@5121L13,114@4929L290:ServerPromotionLabel.kt#2ojkxh");
                str3 = "C72@3469L9:Box.kt#2w3rfo";
                str4 = "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh";
                i4 = 2;
                str5 = "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo";
                r3 = 0;
                TextKt.m2712TextNvy7gAk("X" + num2 + " Опыт", OffsetKt.m778offsetVpY3zN4$default(Modifier.Companion, Dp.m7555constructorimpl(-Dp.m7555constructorimpl(4.0f)), 0.0f, 2, null), Color.Companion.m4809getWhite0d7_KjU(), null, TypeKt.m9154dpToSp8Feqmps(Dp.m7555constructorimpl(18.0f), startRestartGroup, 6), null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, MaterialTheme.INSTANCE.getTypography(startRestartGroup, MaterialTheme.$stable).getBodySmall(), startRestartGroup, 432, 0, 131048);
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
                str4 = "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh";
                str5 = "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo";
                r3 = 0;
                i4 = 2;
                startRestartGroup.startReplaceGroup(703791546);
                startRestartGroup.endReplaceGroup();
            }
            if (num != null && ((num.intValue() > 3 && z2) || (num.intValue() > i4 && !z2))) {
                startRestartGroup.startReplaceGroup(703918770);
                ComposerKt.sourceInformation(startRestartGroup, "127@5510L11,124@5363L520");
                Alignment center5 = Alignment.Companion.getCenter();
                Modifier m9128promo4WTKRHQ4 = m9128promo4WTKRHQ(modifier, MaterialTheme.INSTANCE.getColorScheme(startRestartGroup, MaterialTheme.$stable).m1877getPrimary0d7_KjU());
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1042775818, str5);
                MeasurePolicy maybeCachedBoxMeasurePolicy5 = BoxKt.maybeCachedBoxMeasurePolicy(center5, r3);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1159599143, str4);
                int hashCode9 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(startRestartGroup, r3));
                CompositionLocalMap currentCompositionLocalMap9 = startRestartGroup.getCurrentCompositionLocalMap();
                Modifier materializeModifier9 = ComposedModifierKt.materializeModifier(startRestartGroup, m9128promo4WTKRHQ4);
                Function0<ComposeUiNode> constructor9 = ComposeUiNode.Companion.getConstructor();
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                if (!(startRestartGroup.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                startRestartGroup.startReusableNode();
                if (startRestartGroup.getInserting()) {
                    startRestartGroup.createNode(constructor9);
                } else {
                    startRestartGroup.useNode();
                }
                Composer m4041constructorimpl9 = Updater.m4041constructorimpl(startRestartGroup);
                Updater.m4049setimpl(m4041constructorimpl9, maybeCachedBoxMeasurePolicy5, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.m4049setimpl(m4041constructorimpl9, currentCompositionLocalMap9, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Updater.m4045initimpl(m4041constructorimpl9, Integer.valueOf(hashCode9), ComposeUiNode.Companion.getSetCompositeKeyHash());
                Updater.m4047reconcileimpl(m4041constructorimpl9, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                Updater.m4049setimpl(m4041constructorimpl9, materializeModifier9, ComposeUiNode.Companion.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1833054614, str3);
                BoxScopeInstance boxScopeInstance5 = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -878355155, "C132@5710L10,133@5767L13,129@5571L294:ServerPromotionLabel.kt#2ojkxh");
                Composer composer3 = startRestartGroup;
                TextKt.m2712TextNvy7gAk("X" + num + " Донат", OffsetKt.m778offsetVpY3zN4$default(Modifier.Companion, Dp.m7555constructorimpl(-Dp.m7555constructorimpl(4.0f)), 0.0f, i4, null), Color.Companion.m4809getWhite0d7_KjU(), null, TypeKt.m9154dpToSp8Feqmps(Dp.m7555constructorimpl(18.0f), startRestartGroup, 6), null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, MaterialTheme.INSTANCE.getTypography(startRestartGroup, MaterialTheme.$stable).getBodySmall(), composer3, 432, 0, 131048);
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
                public final Object invoke(Object obj, Object obj2) {
                    return ServerPromotionLabelKt.ServerPromotion$lambda$3(num, num2, bool, bool2, z, z2, modifier, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* renamed from: promo-4WTKRHQ  reason: not valid java name */
    private static final Modifier m9128promo4WTKRHQ(Modifier modifier, long j) {
        return PaddingKt.m819paddingVpY3zN4(BorderKt.m275borderxT4_qwU(BackgroundKt.m263backgroundbw27NRU(SizeKt.m869width3ABfNKs(SizeKt.m850height3ABfNKs(modifier, Dp.m7555constructorimpl(27.0f)), Dp.m7555constructorimpl(80.0f)), Color.m4771copywmQWz5c$default(Color.Companion.m4798getBlack0d7_KjU(), 0.2f, 0.0f, 0.0f, 0.0f, 14, null), new ExpShape()), Dp.m7555constructorimpl(2.0f), j, new ExpShape()), Dp.m7555constructorimpl(0.0f), Dp.m7555constructorimpl(0.0f));
    }
}
