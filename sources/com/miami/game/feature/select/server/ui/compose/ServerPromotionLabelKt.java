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
import com.miami.game.feature.select.server.R;
import com.miami.game.ui.theme.TypeKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: ServerPromotionLabel.kt */
@Metadata(d1 = {"\u0000(\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aM\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000bH\u0007¢\u0006\u0002\u0010\f\u001a\u001b\u0010\r\u001a\u00020\u000b*\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"ServerPromotion", "", "donate", "", "exp", "isTop", "", "isNew", "isMobile", "isArizona", "modifier", "Landroidx/compose/ui/Modifier;", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Boolean;ZZLandroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;I)V", NotificationCompat.CATEGORY_PROMO, "color", "Landroidx/compose/ui/graphics/Color;", "promo-4WTKRHQ", "(Landroidx/compose/ui/Modifier;J)Landroidx/compose/ui/Modifier;", "select-server_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ServerPromotionLabelKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ServerPromotion$lambda$3(Integer num, Integer num2, Boolean bool, Boolean bool2, boolean z, boolean z2, Modifier modifier, int i, Composer composer, int i2) {
        ServerPromotion(num, num2, bool, bool2, z, z2, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:73:0x00df, code lost:
        if (r44.intValue() <= 1) goto L116;
     */
    /* JADX WARN: Removed duplicated region for block: B:175:0x0b32  */
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
                    ComposerKt.sourceInformation(startRestartGroup, "33@1517L616");
                    Alignment center = Alignment.Companion.getCenter();
                    Modifier m298backgroundbw27NRU = BackgroundKt.m298backgroundbw27NRU(SizeKt.m978sizeVpY3zN4(modifier, Dp.m8258constructorimpl(140), Dp.m8258constructorimpl(23)), Color.m5423copywmQWz5c$default(Color.Companion.m5450getBlack0d7_KjU(), 0.2f, 0.0f, 0.0f, 0.0f, 14, null), new NoPromoShape());
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                    MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(center, false);
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                    int hashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(startRestartGroup, 0));
                    CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
                    Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, m298backgroundbw27NRU);
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
                    Composer m4673constructorimpl = Updater.m4673constructorimpl(startRestartGroup);
                    Updater.m4681setimpl(m4673constructorimpl, maybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                    Updater.m4681setimpl(m4673constructorimpl, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                    Updater.m4677initimpl(m4673constructorimpl, Integer.valueOf(hashCode), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    Updater.m4679reconcileimpl(m4673constructorimpl, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                    Updater.m4681setimpl(m4673constructorimpl, materializeModifier, ComposeUiNode.Companion.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                    BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, 613549589, "C43@1976L10,44@2029L13,40@1842L277:ServerPromotionLabel.kt#2ojkxh");
                    TextKt.m3255TextNvy7gAk(z ? "Mobile" : "PC & Mobile", OffsetKt.m885offsetVpY3zN4$default(Modifier.Companion, Dp.m8258constructorimpl(-Dp.m8258constructorimpl(4)), 0.0f, 2, null), Color.m5423copywmQWz5c$default(Color.Companion.m5461getWhite0d7_KjU(), 0.2f, 0.0f, 0.0f, 0.0f, 14, null), null, TypeKt.m10169dpToSp8Feqmps(Dp.m8258constructorimpl(16), startRestartGroup, 6), null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, MaterialTheme.INSTANCE.getTypography(startRestartGroup, MaterialTheme.$stable).getBodySmall(), startRestartGroup, 432, 0, 131048);
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
                    ComposerKt.sourceInformation(startRestartGroup, "49@2163L2330");
                    float f2 = 0;
                    Modifier m885offsetVpY3zN4$default = OffsetKt.m885offsetVpY3zN4$default(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, null), Dp.m8258constructorimpl(f2), 0.0f, 2, null);
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                    MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.m783spacedBy0680j_4(Dp.m8258constructorimpl(f2)), Alignment.Companion.getTop(), startRestartGroup, 6);
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                    int hashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(startRestartGroup, 0));
                    CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
                    Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(startRestartGroup, m885offsetVpY3zN4$default);
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
                    Composer m4673constructorimpl2 = Updater.m4673constructorimpl(startRestartGroup);
                    Updater.m4681setimpl(m4673constructorimpl2, rowMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                    Updater.m4681setimpl(m4673constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                    Updater.m4677initimpl(m4673constructorimpl2, Integer.valueOf(hashCode2), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    Updater.m4679reconcileimpl(m4673constructorimpl2, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                    Updater.m4681setimpl(m4673constructorimpl2, materializeModifier2, ComposeUiNode.Companion.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                    RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, -787916575, "C:ServerPromotionLabel.kt#2ojkxh");
                    if (bool == null) {
                        str = "C101@5233L9:Row.kt#2w3rfo";
                        str2 = "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo";
                        f = 0.0f;
                        startRestartGroup.startReplaceGroup(-790310923);
                    } else {
                        startRestartGroup.startReplaceGroup(-787911089);
                        ComposerKt.sourceInformation(startRestartGroup, "55@2387L998");
                        Alignment center2 = Alignment.Companion.getCenter();
                        Modifier m10146promo4WTKRHQ = m10146promo4WTKRHQ(modifier, ColorKt.Color(4294927670L));
                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                        MeasurePolicy maybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(center2, false);
                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                        int hashCode3 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(startRestartGroup, 0));
                        CompositionLocalMap currentCompositionLocalMap3 = startRestartGroup.getCurrentCompositionLocalMap();
                        Modifier materializeModifier3 = ComposedModifierKt.materializeModifier(startRestartGroup, m10146promo4WTKRHQ);
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
                        Composer m4673constructorimpl3 = Updater.m4673constructorimpl(startRestartGroup);
                        Updater.m4681setimpl(m4673constructorimpl3, maybeCachedBoxMeasurePolicy2, ComposeUiNode.Companion.getSetMeasurePolicy());
                        Updater.m4681setimpl(m4673constructorimpl3, currentCompositionLocalMap3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                        Updater.m4677initimpl(m4673constructorimpl3, Integer.valueOf(hashCode3), ComposeUiNode.Companion.getSetCompositeKeyHash());
                        Updater.m4679reconcileimpl(m4673constructorimpl3, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                        Updater.m4681setimpl(m4673constructorimpl3, materializeModifier3, ComposeUiNode.Companion.getSetModifier());
                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                        BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1286455813, "C60@2599L764:ServerPromotionLabel.kt#2ojkxh");
                        Alignment.Vertical centerVertically = Alignment.Companion.getCenterVertically();
                        float f3 = 4;
                        Modifier m885offsetVpY3zN4$default2 = OffsetKt.m885offsetVpY3zN4$default(Modifier.Companion, Dp.m8258constructorimpl(-Dp.m8258constructorimpl(f3)), 0.0f, 2, null);
                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                        MeasurePolicy rowMeasurePolicy2 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically, startRestartGroup, 48);
                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                        int hashCode4 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(startRestartGroup, 0));
                        CompositionLocalMap currentCompositionLocalMap4 = startRestartGroup.getCurrentCompositionLocalMap();
                        Modifier materializeModifier4 = ComposedModifierKt.materializeModifier(startRestartGroup, m885offsetVpY3zN4$default2);
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
                        Composer m4673constructorimpl4 = Updater.m4673constructorimpl(startRestartGroup);
                        Updater.m4681setimpl(m4673constructorimpl4, rowMeasurePolicy2, ComposeUiNode.Companion.getSetMeasurePolicy());
                        Updater.m4681setimpl(m4673constructorimpl4, currentCompositionLocalMap4, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                        Updater.m4677initimpl(m4673constructorimpl4, Integer.valueOf(hashCode4), ComposeUiNode.Companion.getSetCompositeKeyHash());
                        Updater.m4679reconcileimpl(m4673constructorimpl4, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                        Updater.m4681setimpl(m4673constructorimpl4, materializeModifier4, ComposeUiNode.Companion.getSetModifier());
                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                        RowScopeInstance rowScopeInstance2 = RowScopeInstance.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1402514499, "C64@2807L41,64@2801L107,66@2937L39,70@3158L10,71@3223L13,67@3005L332:ServerPromotionLabel.kt#2ojkxh");
                        str2 = "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo";
                        str = "C101@5233L9:Row.kt#2w3rfo";
                        f = 0.0f;
                        ImageKt.Image(PainterResources_androidKt.painterResource(R.drawable.server_top_ic, startRestartGroup, 0), (String) null, SizeKt.m976size3ABfNKs(Modifier.Companion, Dp.m8258constructorimpl(12)), (Alignment) null, (ContentScale) null, 0.0f, (ColorFilter) null, startRestartGroup, Painter.$stable | 432, 120);
                        SpacerKt.Spacer(SizeKt.m981width3ABfNKs(Modifier.Companion, Dp.m8258constructorimpl(f3)), startRestartGroup, 6);
                        TextKt.m3255TextNvy7gAk(" TOP", OffsetKt.m885offsetVpY3zN4$default(Modifier.Companion, Dp.m8258constructorimpl(-Dp.m8258constructorimpl(f3)), 0.0f, 2, null), Color.Companion.m5461getWhite0d7_KjU(), null, TypeKt.m10169dpToSp8Feqmps(Dp.m8258constructorimpl(18), startRestartGroup, 6), null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, MaterialTheme.INSTANCE.getTypography(startRestartGroup, MaterialTheme.$stable).getBodySmall(), startRestartGroup, 438, 0, 131048);
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
                    }
                    startRestartGroup.endReplaceGroup();
                    if (bool2 != null) {
                        startRestartGroup.startReplaceGroup(-786845619);
                        ComposerKt.sourceInformation(startRestartGroup, "78@3461L1000");
                        Alignment center3 = Alignment.Companion.getCenter();
                        Modifier m10146promo4WTKRHQ2 = m10146promo4WTKRHQ(modifier, ColorKt.Color(4294945024L));
                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                        MeasurePolicy maybeCachedBoxMeasurePolicy3 = BoxKt.maybeCachedBoxMeasurePolicy(center3, false);
                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                        int hashCode5 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(startRestartGroup, 0));
                        CompositionLocalMap currentCompositionLocalMap5 = startRestartGroup.getCurrentCompositionLocalMap();
                        Modifier materializeModifier5 = ComposedModifierKt.materializeModifier(startRestartGroup, m10146promo4WTKRHQ2);
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
                        Composer m4673constructorimpl5 = Updater.m4673constructorimpl(startRestartGroup);
                        Updater.m4681setimpl(m4673constructorimpl5, maybeCachedBoxMeasurePolicy3, ComposeUiNode.Companion.getSetMeasurePolicy());
                        Updater.m4681setimpl(m4673constructorimpl5, currentCompositionLocalMap5, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                        Updater.m4677initimpl(m4673constructorimpl5, Integer.valueOf(hashCode5), ComposeUiNode.Companion.getSetCompositeKeyHash());
                        Updater.m4679reconcileimpl(m4673constructorimpl5, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                        Updater.m4681setimpl(m4673constructorimpl5, materializeModifier5, ComposeUiNode.Companion.getSetModifier());
                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                        BoxScopeInstance boxScopeInstance3 = BoxScopeInstance.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 556513072, "C83@3673L766:ServerPromotionLabel.kt#2ojkxh");
                        Alignment.Vertical centerVertically2 = Alignment.Companion.getCenterVertically();
                        Modifier m885offsetVpY3zN4$default3 = OffsetKt.m885offsetVpY3zN4$default(Modifier.Companion, Dp.m8258constructorimpl(-Dp.m8258constructorimpl(1)), f, 2, null);
                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 844473419, str2);
                        MeasurePolicy rowMeasurePolicy3 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically2, startRestartGroup, 48);
                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                        int hashCode6 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(startRestartGroup, 0));
                        CompositionLocalMap currentCompositionLocalMap6 = startRestartGroup.getCurrentCompositionLocalMap();
                        Modifier materializeModifier6 = ComposedModifierKt.materializeModifier(startRestartGroup, m885offsetVpY3zN4$default3);
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
                        Composer m4673constructorimpl6 = Updater.m4673constructorimpl(startRestartGroup);
                        Updater.m4681setimpl(m4673constructorimpl6, rowMeasurePolicy3, ComposeUiNode.Companion.getSetMeasurePolicy());
                        Updater.m4681setimpl(m4673constructorimpl6, currentCompositionLocalMap6, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                        Updater.m4677initimpl(m4673constructorimpl6, Integer.valueOf(hashCode6), ComposeUiNode.Companion.getSetCompositeKeyHash());
                        Updater.m4679reconcileimpl(m4673constructorimpl6, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                        Updater.m4681setimpl(m4673constructorimpl6, materializeModifier6, ComposeUiNode.Companion.getSetModifier());
                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1456264949, str);
                        RowScopeInstance rowScopeInstance3 = RowScopeInstance.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, -910353288, "C87@3881L41,87@3875L107,89@4011L39,93@4234L10,94@4299L13,90@4079L334:ServerPromotionLabel.kt#2ojkxh");
                        Composer composer2 = startRestartGroup;
                        ImageKt.Image(PainterResources_androidKt.painterResource(R.drawable.server_new_ic, startRestartGroup, 0), (String) null, SizeKt.m976size3ABfNKs(Modifier.Companion, Dp.m8258constructorimpl(12)), (Alignment) null, (ContentScale) null, 0.0f, (ColorFilter) null, composer2, Painter.$stable | 432, 120);
                        float f4 = 4;
                        SpacerKt.Spacer(SizeKt.m981width3ABfNKs(Modifier.Companion, Dp.m8258constructorimpl(f4)), composer2, 6);
                        TextKt.m3255TextNvy7gAk(" Новый", OffsetKt.m885offsetVpY3zN4$default(Modifier.Companion, Dp.m8258constructorimpl(-Dp.m8258constructorimpl(f4)), f, 2, null), Color.Companion.m5461getWhite0d7_KjU(), null, TypeKt.m10169dpToSp8Feqmps(Dp.m8258constructorimpl(18), composer2, 6), null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, MaterialTheme.INSTANCE.getTypography(composer2, MaterialTheme.$stable).getBodySmall(), composer2, 438, 0, 131048);
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
                    } else {
                        startRestartGroup.startReplaceGroup(-790310923);
                    }
                    startRestartGroup.endReplaceGroup();
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
            ComposerKt.sourceInformation(startRestartGroup, "103@4525L1379");
            float f5 = 0;
            Modifier m885offsetVpY3zN4$default4 = OffsetKt.m885offsetVpY3zN4$default(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, i3, null), Dp.m8258constructorimpl(f5), 0.0f, 2, null);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            MeasurePolicy rowMeasurePolicy4 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.m783spacedBy0680j_4(Dp.m8258constructorimpl(f5)), Alignment.Companion.getTop(), startRestartGroup, 6);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int hashCode7 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(startRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap7 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier7 = ComposedModifierKt.materializeModifier(startRestartGroup, m885offsetVpY3zN4$default4);
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
            Composer m4673constructorimpl7 = Updater.m4673constructorimpl(startRestartGroup);
            Updater.m4681setimpl(m4673constructorimpl7, rowMeasurePolicy4, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m4681setimpl(m4673constructorimpl7, currentCompositionLocalMap7, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.m4677initimpl(m4673constructorimpl7, Integer.valueOf(hashCode7), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.m4679reconcileimpl(m4673constructorimpl7, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.m4681setimpl(m4673constructorimpl7, materializeModifier7, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScopeInstance rowScopeInstance4 = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 703273413, "C:ServerPromotionLabel.kt#2ojkxh");
            if (num2 == null || num2.intValue() <= 1) {
                str3 = "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp";
                str4 = "C72@3469L9:Box.kt#2w3rfo";
                str5 = "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh";
                i4 = 2;
                i5 = 1042775818;
                startRestartGroup.startReplaceGroup(698584538);
            } else {
                startRestartGroup.startReplaceGroup(703297158);
                ComposerKt.sourceInformation(startRestartGroup, "109@4734L500");
                Alignment center4 = Alignment.Companion.getCenter();
                Modifier m10146promo4WTKRHQ3 = m10146promo4WTKRHQ(modifier, ColorKt.Color(4289456127L));
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                MeasurePolicy maybeCachedBoxMeasurePolicy4 = BoxKt.maybeCachedBoxMeasurePolicy(center4, false);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int hashCode8 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(startRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap8 = startRestartGroup.getCurrentCompositionLocalMap();
                Modifier materializeModifier8 = ComposedModifierKt.materializeModifier(startRestartGroup, m10146promo4WTKRHQ3);
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
                Composer m4673constructorimpl8 = Updater.m4673constructorimpl(startRestartGroup);
                Updater.m4681setimpl(m4673constructorimpl8, maybeCachedBoxMeasurePolicy4, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.m4681setimpl(m4673constructorimpl8, currentCompositionLocalMap8, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Updater.m4677initimpl(m4673constructorimpl8, Integer.valueOf(hashCode8), ComposeUiNode.Companion.getSetCompositeKeyHash());
                Updater.m4679reconcileimpl(m4673constructorimpl8, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                Updater.m4681setimpl(m4673constructorimpl8, materializeModifier8, ComposeUiNode.Companion.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance4 = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1777440006, "C117@5061L10,118@5118L13,114@4926L290:ServerPromotionLabel.kt#2ojkxh");
                str4 = "C72@3469L9:Box.kt#2w3rfo";
                str3 = "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp";
                i5 = 1042775818;
                i4 = 2;
                str5 = "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh";
                TextKt.m3255TextNvy7gAk("X" + num2 + " Опыт", OffsetKt.m885offsetVpY3zN4$default(Modifier.Companion, Dp.m8258constructorimpl(-Dp.m8258constructorimpl(4)), 0.0f, 2, null), Color.Companion.m5461getWhite0d7_KjU(), null, TypeKt.m10169dpToSp8Feqmps(Dp.m8258constructorimpl(18), startRestartGroup, 6), null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, MaterialTheme.INSTANCE.getTypography(startRestartGroup, MaterialTheme.$stable).getBodySmall(), startRestartGroup, 432, 0, 131048);
                startRestartGroup = startRestartGroup;
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                startRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            }
            startRestartGroup.endReplaceGroup();
            if (num == null || ((num.intValue() <= 3 || !z2) && (num.intValue() <= i4 || z2))) {
                startRestartGroup.startReplaceGroup(698584538);
            } else {
                startRestartGroup.startReplaceGroup(703918770);
                ComposerKt.sourceInformation(startRestartGroup, "127@5507L11,124@5360L520");
                Alignment center5 = Alignment.Companion.getCenter();
                Modifier m10146promo4WTKRHQ4 = m10146promo4WTKRHQ(modifier, MaterialTheme.INSTANCE.getColorScheme(startRestartGroup, MaterialTheme.$stable).m2189getPrimary0d7_KjU());
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, i5, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                MeasurePolicy maybeCachedBoxMeasurePolicy5 = BoxKt.maybeCachedBoxMeasurePolicy(center5, false);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1159599143, str5);
                int hashCode9 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(startRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap9 = startRestartGroup.getCurrentCompositionLocalMap();
                Modifier materializeModifier9 = ComposedModifierKt.materializeModifier(startRestartGroup, m10146promo4WTKRHQ4);
                Function0<ComposeUiNode> constructor9 = ComposeUiNode.Companion.getConstructor();
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -553112988, str3);
                if (!(startRestartGroup.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                startRestartGroup.startReusableNode();
                if (startRestartGroup.getInserting()) {
                    startRestartGroup.createNode(constructor9);
                } else {
                    startRestartGroup.useNode();
                }
                Composer m4673constructorimpl9 = Updater.m4673constructorimpl(startRestartGroup);
                Updater.m4681setimpl(m4673constructorimpl9, maybeCachedBoxMeasurePolicy5, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.m4681setimpl(m4673constructorimpl9, currentCompositionLocalMap9, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Updater.m4677initimpl(m4673constructorimpl9, Integer.valueOf(hashCode9), ComposeUiNode.Companion.getSetCompositeKeyHash());
                Updater.m4679reconcileimpl(m4673constructorimpl9, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                Updater.m4681setimpl(m4673constructorimpl9, materializeModifier9, ComposeUiNode.Companion.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1833054614, str4);
                BoxScopeInstance boxScopeInstance5 = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -878355155, "C132@5707L10,133@5764L13,129@5568L294:ServerPromotionLabel.kt#2ojkxh");
                Composer composer3 = startRestartGroup;
                TextKt.m3255TextNvy7gAk("X" + num + " Донат", OffsetKt.m885offsetVpY3zN4$default(Modifier.Companion, Dp.m8258constructorimpl(-Dp.m8258constructorimpl(4)), 0.0f, i4, null), Color.Companion.m5461getWhite0d7_KjU(), null, TypeKt.m10169dpToSp8Feqmps(Dp.m8258constructorimpl(18), startRestartGroup, 6), null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, MaterialTheme.INSTANCE.getTypography(startRestartGroup, MaterialTheme.$stable).getBodySmall(), composer3, 432, 0, 131048);
                startRestartGroup = composer3;
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                startRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            }
            startRestartGroup.endReplaceGroup();
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
                    Unit ServerPromotion$lambda$3;
                    ServerPromotion$lambda$3 = ServerPromotionLabelKt.ServerPromotion$lambda$3(num, num2, bool, bool2, z, z2, modifier, i, (Composer) obj, ((Integer) obj2).intValue());
                    return ServerPromotion$lambda$3;
                }
            });
        }
    }

    /* renamed from: promo-4WTKRHQ  reason: not valid java name */
    private static final Modifier m10146promo4WTKRHQ(Modifier modifier, long j) {
        Modifier m314borderxT4_qwU = BorderKt.m314borderxT4_qwU(BackgroundKt.m298backgroundbw27NRU(SizeKt.m981width3ABfNKs(SizeKt.m962height3ABfNKs(modifier, Dp.m8258constructorimpl(27)), Dp.m8258constructorimpl(80)), Color.m5423copywmQWz5c$default(Color.Companion.m5450getBlack0d7_KjU(), 0.2f, 0.0f, 0.0f, 0.0f, 14, null), new ExpShape()), Dp.m8258constructorimpl(2), j, new ExpShape());
        float f = 0;
        return PaddingKt.m929paddingVpY3zN4(m314borderxT4_qwU, Dp.m8258constructorimpl(f), Dp.m8258constructorimpl(f));
    }
}
