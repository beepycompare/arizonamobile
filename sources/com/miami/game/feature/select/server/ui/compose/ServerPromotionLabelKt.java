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
import androidx.compose.material3.MenuKt;
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
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.unit.Dp;
import androidx.core.app.NotificationCompat;
import androidx.media3.exoplayer.RendererCapabilities;
import com.miami.game.feature.select.server.R;
import com.miami.game.ui.theme.TypeKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: ServerPromotionLabel.kt */
@Metadata(d1 = {"\u0000(\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aM\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000bH\u0007¢\u0006\u0002\u0010\f\u001a\u001b\u0010\r\u001a\u00020\u000b*\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"ServerPromotion", "", "donate", "", "exp", "isTop", "", "isNew", "isMobile", "isArizona", "modifier", "Landroidx/compose/ui/Modifier;", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Boolean;ZZLandroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;I)V", NotificationCompat.CATEGORY_PROMO, "color", "Landroidx/compose/ui/graphics/Color;", "promo-4WTKRHQ", "(Landroidx/compose/ui/Modifier;J)Landroidx/compose/ui/Modifier;", "select-server_release_web"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ServerPromotionLabelKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ServerPromotion$lambda$9(Integer num, Integer num2, Boolean bool, Boolean bool2, boolean z, boolean z2, Modifier modifier, int i, Composer composer, int i2) {
        ServerPromotion(num, num2, bool, bool2, z, z2, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:73:0x00df, code lost:
        if (r43.intValue() <= 1) goto L131;
     */
    /* JADX WARN: Removed duplicated region for block: B:220:0x0b9d  */
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
        ComposerKt.sourceInformation(startRestartGroup, "C(ServerPromotion)P(!2,5,4,3):ServerPromotionLabel.kt#2ojkxh");
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
                startRestartGroup.startReplaceGroup(1527041798);
                ComposerKt.sourceInformation(startRestartGroup, "");
                if (bool2 == null && bool == null) {
                    startRestartGroup.startReplaceGroup(1527012658);
                    ComposerKt.sourceInformation(startRestartGroup, "33@1517L616");
                    Alignment center = Alignment.Companion.getCenter();
                    Modifier m246backgroundbw27NRU = BackgroundKt.m246backgroundbw27NRU(SizeKt.m787sizeVpY3zN4(modifier, Dp.m6684constructorimpl(140), Dp.m6684constructorimpl(23)), Color.m4077copywmQWz5c$default(Color.Companion.m4104getBlack0d7_KjU(), 0.2f, 0.0f, 0.0f, 0.0f, 14, null), new NoPromoShape());
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                    MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(center, false);
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                    int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                    CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
                    Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, m246backgroundbw27NRU);
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
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, 613549589, "C43@1976L10,44@2029L13,40@1842L277:ServerPromotionLabel.kt#2ojkxh");
                    TextKt.m2497Text4IGK_g(z ? "Mobile" : "PC & Mobile", OffsetKt.m698offsetVpY3zN4$default(Modifier.Companion, Dp.m6684constructorimpl(-Dp.m6684constructorimpl(4)), 0.0f, 2, null), Color.m4077copywmQWz5c$default(Color.Companion.m4115getWhite0d7_KjU(), 0.2f, 0.0f, 0.0f, 0.0f, 14, null), TypeKt.m8434dpToSp8Feqmps(Dp.m6684constructorimpl(16), startRestartGroup, 6), (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography(startRestartGroup, MaterialTheme.$stable).getBodySmall(), startRestartGroup, 432, 0, 65520);
                    startRestartGroup = startRestartGroup;
                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                    startRestartGroup.endNode();
                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                    startRestartGroup.endReplaceGroup();
                } else {
                    startRestartGroup.startReplaceGroup(1527706624);
                    ComposerKt.sourceInformation(startRestartGroup, "49@2163L2330");
                    float f2 = 0;
                    Modifier m698offsetVpY3zN4$default = OffsetKt.m698offsetVpY3zN4$default(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, null), Dp.m6684constructorimpl(f2), 0.0f, 2, null);
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, 693286680, "CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo");
                    MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.m619spacedBy0680j_4(Dp.m6684constructorimpl(f2)), Alignment.Companion.getTop(), startRestartGroup, 6);
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                    int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                    CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
                    Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(startRestartGroup, m698offsetVpY3zN4$default);
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
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, -787916575, "C:ServerPromotionLabel.kt#2ojkxh");
                    if (bool == null) {
                        str = "C101@5232L9:Row.kt#2w3rfo";
                        str2 = "CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo";
                        f = 0.0f;
                        startRestartGroup.startReplaceGroup(-790310923);
                    } else {
                        startRestartGroup.startReplaceGroup(-787931673);
                        ComposerKt.sourceInformation(startRestartGroup, "55@2387L998");
                        Alignment center2 = Alignment.Companion.getCenter();
                        Modifier m8413promo4WTKRHQ = m8413promo4WTKRHQ(modifier, ColorKt.Color(4294927670L));
                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                        MeasurePolicy maybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(center2, false);
                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                        int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                        CompositionLocalMap currentCompositionLocalMap3 = startRestartGroup.getCurrentCompositionLocalMap();
                        Modifier materializeModifier3 = ComposedModifierKt.materializeModifier(startRestartGroup, m8413promo4WTKRHQ);
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
                        Updater.m3527setimpl(m3520constructorimpl3, maybeCachedBoxMeasurePolicy2, ComposeUiNode.Companion.getSetMeasurePolicy());
                        Updater.m3527setimpl(m3520constructorimpl3, currentCompositionLocalMap3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = ComposeUiNode.Companion.getSetCompositeKeyHash();
                        if (m3520constructorimpl3.getInserting() || !Intrinsics.areEqual(m3520constructorimpl3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                            m3520constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                            m3520constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
                        }
                        Updater.m3527setimpl(m3520constructorimpl3, materializeModifier3, ComposeUiNode.Companion.getSetModifier());
                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
                        BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1286455813, "C60@2599L764:ServerPromotionLabel.kt#2ojkxh");
                        Alignment.Vertical centerVertically = Alignment.Companion.getCenterVertically();
                        float f3 = 4;
                        Modifier m698offsetVpY3zN4$default2 = OffsetKt.m698offsetVpY3zN4$default(Modifier.Companion, Dp.m6684constructorimpl(-Dp.m6684constructorimpl(f3)), 0.0f, 2, null);
                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 693286680, "CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo");
                        MeasurePolicy rowMeasurePolicy2 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically, startRestartGroup, 48);
                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                        int currentCompositeKeyHash4 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                        CompositionLocalMap currentCompositionLocalMap4 = startRestartGroup.getCurrentCompositionLocalMap();
                        Modifier materializeModifier4 = ComposedModifierKt.materializeModifier(startRestartGroup, m698offsetVpY3zN4$default2);
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
                        Updater.m3527setimpl(m3520constructorimpl4, rowMeasurePolicy2, ComposeUiNode.Companion.getSetMeasurePolicy());
                        Updater.m3527setimpl(m3520constructorimpl4, currentCompositionLocalMap4, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash4 = ComposeUiNode.Companion.getSetCompositeKeyHash();
                        if (m3520constructorimpl4.getInserting() || !Intrinsics.areEqual(m3520constructorimpl4.rememberedValue(), Integer.valueOf(currentCompositeKeyHash4))) {
                            m3520constructorimpl4.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash4));
                            m3520constructorimpl4.apply(Integer.valueOf(currentCompositeKeyHash4), setCompositeKeyHash4);
                        }
                        Updater.m3527setimpl(m3520constructorimpl4, materializeModifier4, ComposeUiNode.Companion.getSetModifier());
                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, -407735110, "C101@5232L9:Row.kt#2w3rfo");
                        RowScopeInstance rowScopeInstance2 = RowScopeInstance.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1402514499, "C64@2807L41,64@2801L107,66@2937L39,70@3158L10,71@3223L13,67@3005L332:ServerPromotionLabel.kt#2ojkxh");
                        str = "C101@5232L9:Row.kt#2w3rfo";
                        str2 = "CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo";
                        f = 0.0f;
                        ImageKt.Image(PainterResources_androidKt.painterResource(R.drawable.server_top_ic, startRestartGroup, 0), (String) null, SizeKt.m785size3ABfNKs(Modifier.Companion, Dp.m6684constructorimpl(12)), (Alignment) null, (ContentScale) null, 0.0f, (ColorFilter) null, startRestartGroup, 432, (int) MenuKt.InTransitionDuration);
                        SpacerKt.Spacer(SizeKt.m790width3ABfNKs(Modifier.Companion, Dp.m6684constructorimpl(f3)), startRestartGroup, 6);
                        TextKt.m2497Text4IGK_g(" TOP", OffsetKt.m698offsetVpY3zN4$default(Modifier.Companion, Dp.m6684constructorimpl(-Dp.m6684constructorimpl(f3)), 0.0f, 2, null), Color.Companion.m4115getWhite0d7_KjU(), TypeKt.m8434dpToSp8Feqmps(Dp.m6684constructorimpl(18), startRestartGroup, 6), (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography(startRestartGroup, MaterialTheme.$stable).getBodySmall(), startRestartGroup, 438, 0, 65520);
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
                        startRestartGroup.startReplaceGroup(-786866203);
                        ComposerKt.sourceInformation(startRestartGroup, "78@3461L1000");
                        Alignment center3 = Alignment.Companion.getCenter();
                        Modifier m8413promo4WTKRHQ2 = m8413promo4WTKRHQ(modifier, ColorKt.Color(4294945024L));
                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                        MeasurePolicy maybeCachedBoxMeasurePolicy3 = BoxKt.maybeCachedBoxMeasurePolicy(center3, false);
                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                        int currentCompositeKeyHash5 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                        CompositionLocalMap currentCompositionLocalMap5 = startRestartGroup.getCurrentCompositionLocalMap();
                        Modifier materializeModifier5 = ComposedModifierKt.materializeModifier(startRestartGroup, m8413promo4WTKRHQ2);
                        Function0<ComposeUiNode> constructor5 = ComposeUiNode.Companion.getConstructor();
                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
                        if (!(startRestartGroup.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        startRestartGroup.startReusableNode();
                        if (startRestartGroup.getInserting()) {
                            startRestartGroup.createNode(constructor5);
                        } else {
                            startRestartGroup.useNode();
                        }
                        Composer m3520constructorimpl5 = Updater.m3520constructorimpl(startRestartGroup);
                        Updater.m3527setimpl(m3520constructorimpl5, maybeCachedBoxMeasurePolicy3, ComposeUiNode.Companion.getSetMeasurePolicy());
                        Updater.m3527setimpl(m3520constructorimpl5, currentCompositionLocalMap5, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash5 = ComposeUiNode.Companion.getSetCompositeKeyHash();
                        if (m3520constructorimpl5.getInserting() || !Intrinsics.areEqual(m3520constructorimpl5.rememberedValue(), Integer.valueOf(currentCompositeKeyHash5))) {
                            m3520constructorimpl5.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash5));
                            m3520constructorimpl5.apply(Integer.valueOf(currentCompositeKeyHash5), setCompositeKeyHash5);
                        }
                        Updater.m3527setimpl(m3520constructorimpl5, materializeModifier5, ComposeUiNode.Companion.getSetModifier());
                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
                        BoxScopeInstance boxScopeInstance3 = BoxScopeInstance.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 556513072, "C83@3673L766:ServerPromotionLabel.kt#2ojkxh");
                        Alignment.Vertical centerVertically2 = Alignment.Companion.getCenterVertically();
                        Modifier m698offsetVpY3zN4$default3 = OffsetKt.m698offsetVpY3zN4$default(Modifier.Companion, Dp.m6684constructorimpl(-Dp.m6684constructorimpl(1)), f, 2, null);
                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 693286680, str2);
                        MeasurePolicy rowMeasurePolicy3 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically2, startRestartGroup, 48);
                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                        int currentCompositeKeyHash6 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                        CompositionLocalMap currentCompositionLocalMap6 = startRestartGroup.getCurrentCompositionLocalMap();
                        Modifier materializeModifier6 = ComposedModifierKt.materializeModifier(startRestartGroup, m698offsetVpY3zN4$default3);
                        Function0<ComposeUiNode> constructor6 = ComposeUiNode.Companion.getConstructor();
                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
                        if (!(startRestartGroup.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        startRestartGroup.startReusableNode();
                        if (startRestartGroup.getInserting()) {
                            startRestartGroup.createNode(constructor6);
                        } else {
                            startRestartGroup.useNode();
                        }
                        Composer m3520constructorimpl6 = Updater.m3520constructorimpl(startRestartGroup);
                        Updater.m3527setimpl(m3520constructorimpl6, rowMeasurePolicy3, ComposeUiNode.Companion.getSetMeasurePolicy());
                        Updater.m3527setimpl(m3520constructorimpl6, currentCompositionLocalMap6, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash6 = ComposeUiNode.Companion.getSetCompositeKeyHash();
                        if (m3520constructorimpl6.getInserting() || !Intrinsics.areEqual(m3520constructorimpl6.rememberedValue(), Integer.valueOf(currentCompositeKeyHash6))) {
                            m3520constructorimpl6.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash6));
                            m3520constructorimpl6.apply(Integer.valueOf(currentCompositeKeyHash6), setCompositeKeyHash6);
                        }
                        Updater.m3527setimpl(m3520constructorimpl6, materializeModifier6, ComposeUiNode.Companion.getSetModifier());
                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, -407735110, str);
                        RowScopeInstance rowScopeInstance3 = RowScopeInstance.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, -910353288, "C87@3881L41,87@3875L107,89@4011L39,93@4234L10,94@4299L13,90@4079L334:ServerPromotionLabel.kt#2ojkxh");
                        Composer composer2 = startRestartGroup;
                        ImageKt.Image(PainterResources_androidKt.painterResource(R.drawable.server_new_ic, startRestartGroup, 0), (String) null, SizeKt.m785size3ABfNKs(Modifier.Companion, Dp.m6684constructorimpl(12)), (Alignment) null, (ContentScale) null, 0.0f, (ColorFilter) null, composer2, 432, (int) MenuKt.InTransitionDuration);
                        float f4 = 4;
                        SpacerKt.Spacer(SizeKt.m790width3ABfNKs(Modifier.Companion, Dp.m6684constructorimpl(f4)), composer2, 6);
                        TextKt.m2497Text4IGK_g(" Новый", OffsetKt.m698offsetVpY3zN4$default(Modifier.Companion, Dp.m6684constructorimpl(-Dp.m6684constructorimpl(f4)), f, 2, null), Color.Companion.m4115getWhite0d7_KjU(), TypeKt.m8434dpToSp8Feqmps(Dp.m6684constructorimpl(18), composer2, 6), (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography(composer2, MaterialTheme.$stable).getBodySmall(), composer2, 438, 0, 65520);
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
            startRestartGroup.startReplaceGroup(1530023967);
            ComposerKt.sourceInformation(startRestartGroup, "103@4525L1379");
            float f5 = 0;
            Modifier m698offsetVpY3zN4$default4 = OffsetKt.m698offsetVpY3zN4$default(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, i3, null), Dp.m6684constructorimpl(f5), 0.0f, 2, null);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 693286680, "CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo");
            MeasurePolicy rowMeasurePolicy4 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.m619spacedBy0680j_4(Dp.m6684constructorimpl(f5)), Alignment.Companion.getTop(), startRestartGroup, 6);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash7 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap7 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier7 = ComposedModifierKt.materializeModifier(startRestartGroup, m698offsetVpY3zN4$default4);
            Function0<ComposeUiNode> constructor7 = ComposeUiNode.Companion.getConstructor();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
            if (!(startRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(constructor7);
            } else {
                startRestartGroup.useNode();
            }
            Composer m3520constructorimpl7 = Updater.m3520constructorimpl(startRestartGroup);
            Updater.m3527setimpl(m3520constructorimpl7, rowMeasurePolicy4, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m3527setimpl(m3520constructorimpl7, currentCompositionLocalMap7, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash7 = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (m3520constructorimpl7.getInserting() || !Intrinsics.areEqual(m3520constructorimpl7.rememberedValue(), Integer.valueOf(currentCompositeKeyHash7))) {
                m3520constructorimpl7.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash7));
                m3520constructorimpl7.apply(Integer.valueOf(currentCompositeKeyHash7), setCompositeKeyHash7);
            }
            Updater.m3527setimpl(m3520constructorimpl7, materializeModifier7, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -407735110, "C101@5232L9:Row.kt#2w3rfo");
            RowScopeInstance rowScopeInstance4 = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 703273413, "C:ServerPromotionLabel.kt#2ojkxh");
            if (num2 == null || num2.intValue() <= 1) {
                str3 = "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp";
                str4 = "C72@3468L9:Box.kt#2w3rfo";
                str5 = "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh";
                i4 = 733328855;
                i5 = 2;
                startRestartGroup.startReplaceGroup(698584538);
            } else {
                startRestartGroup.startReplaceGroup(703280294);
                ComposerKt.sourceInformation(startRestartGroup, "109@4734L500");
                Alignment center4 = Alignment.Companion.getCenter();
                Modifier m8413promo4WTKRHQ3 = m8413promo4WTKRHQ(modifier, ColorKt.Color(4289456127L));
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                MeasurePolicy maybeCachedBoxMeasurePolicy4 = BoxKt.maybeCachedBoxMeasurePolicy(center4, false);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                int currentCompositeKeyHash8 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap8 = startRestartGroup.getCurrentCompositionLocalMap();
                Modifier materializeModifier8 = ComposedModifierKt.materializeModifier(startRestartGroup, m8413promo4WTKRHQ3);
                Function0<ComposeUiNode> constructor8 = ComposeUiNode.Companion.getConstructor();
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
                if (!(startRestartGroup.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                startRestartGroup.startReusableNode();
                if (startRestartGroup.getInserting()) {
                    startRestartGroup.createNode(constructor8);
                } else {
                    startRestartGroup.useNode();
                }
                Composer m3520constructorimpl8 = Updater.m3520constructorimpl(startRestartGroup);
                Updater.m3527setimpl(m3520constructorimpl8, maybeCachedBoxMeasurePolicy4, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.m3527setimpl(m3520constructorimpl8, currentCompositionLocalMap8, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash8 = ComposeUiNode.Companion.getSetCompositeKeyHash();
                if (m3520constructorimpl8.getInserting() || !Intrinsics.areEqual(m3520constructorimpl8.rememberedValue(), Integer.valueOf(currentCompositeKeyHash8))) {
                    m3520constructorimpl8.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash8));
                    m3520constructorimpl8.apply(Integer.valueOf(currentCompositeKeyHash8), setCompositeKeyHash8);
                }
                Updater.m3527setimpl(m3520constructorimpl8, materializeModifier8, ComposeUiNode.Companion.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance4 = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1777440006, "C117@5061L10,118@5118L13,114@4926L290:ServerPromotionLabel.kt#2ojkxh");
                str3 = "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp";
                i4 = 733328855;
                str5 = "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh";
                i5 = 2;
                str4 = "C72@3468L9:Box.kt#2w3rfo";
                TextKt.m2497Text4IGK_g("X" + num2 + " Опыт", OffsetKt.m698offsetVpY3zN4$default(Modifier.Companion, Dp.m6684constructorimpl(-Dp.m6684constructorimpl(4)), 0.0f, 2, null), Color.Companion.m4115getWhite0d7_KjU(), TypeKt.m8434dpToSp8Feqmps(Dp.m6684constructorimpl(18), startRestartGroup, 6), (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography(startRestartGroup, MaterialTheme.$stable).getBodySmall(), startRestartGroup, 432, 0, 65520);
                startRestartGroup = startRestartGroup;
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                startRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            }
            startRestartGroup.endReplaceGroup();
            if (num == null || ((num.intValue() <= 3 || !z2) && (num.intValue() <= i5 || z2))) {
                startRestartGroup.startReplaceGroup(698584538);
            } else {
                startRestartGroup.startReplaceGroup(703901906);
                ComposerKt.sourceInformation(startRestartGroup, "127@5507L11,124@5360L520");
                Alignment center5 = Alignment.Companion.getCenter();
                Modifier m8413promo4WTKRHQ4 = m8413promo4WTKRHQ(modifier, MaterialTheme.INSTANCE.getColorScheme(startRestartGroup, MaterialTheme.$stable).m1714getPrimary0d7_KjU());
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, i4, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                MeasurePolicy maybeCachedBoxMeasurePolicy5 = BoxKt.maybeCachedBoxMeasurePolicy(center5, false);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1323940314, str5);
                int currentCompositeKeyHash9 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap9 = startRestartGroup.getCurrentCompositionLocalMap();
                Modifier materializeModifier9 = ComposedModifierKt.materializeModifier(startRestartGroup, m8413promo4WTKRHQ4);
                Function0<ComposeUiNode> constructor9 = ComposeUiNode.Companion.getConstructor();
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -692256719, str3);
                if (!(startRestartGroup.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                startRestartGroup.startReusableNode();
                if (startRestartGroup.getInserting()) {
                    startRestartGroup.createNode(constructor9);
                } else {
                    startRestartGroup.useNode();
                }
                Composer m3520constructorimpl9 = Updater.m3520constructorimpl(startRestartGroup);
                Updater.m3527setimpl(m3520constructorimpl9, maybeCachedBoxMeasurePolicy5, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.m3527setimpl(m3520constructorimpl9, currentCompositionLocalMap9, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash9 = ComposeUiNode.Companion.getSetCompositeKeyHash();
                if (m3520constructorimpl9.getInserting() || !Intrinsics.areEqual(m3520constructorimpl9.rememberedValue(), Integer.valueOf(currentCompositeKeyHash9))) {
                    m3520constructorimpl9.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash9));
                    m3520constructorimpl9.apply(Integer.valueOf(currentCompositeKeyHash9), setCompositeKeyHash9);
                }
                Updater.m3527setimpl(m3520constructorimpl9, materializeModifier9, ComposeUiNode.Companion.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -2146730711, str4);
                BoxScopeInstance boxScopeInstance5 = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -878355155, "C132@5707L10,133@5764L13,129@5568L294:ServerPromotionLabel.kt#2ojkxh");
                Composer composer3 = startRestartGroup;
                TextKt.m2497Text4IGK_g("X" + num + " Донат", OffsetKt.m698offsetVpY3zN4$default(Modifier.Companion, Dp.m6684constructorimpl(-Dp.m6684constructorimpl(4)), 0.0f, i5, null), Color.Companion.m4115getWhite0d7_KjU(), TypeKt.m8434dpToSp8Feqmps(Dp.m6684constructorimpl(18), startRestartGroup, 6), (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography(startRestartGroup, MaterialTheme.$stable).getBodySmall(), composer3, 432, 0, 65520);
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
                    Unit ServerPromotion$lambda$9;
                    ServerPromotion$lambda$9 = ServerPromotionLabelKt.ServerPromotion$lambda$9(num, num2, bool, bool2, z, z2, modifier, i, (Composer) obj, ((Integer) obj2).intValue());
                    return ServerPromotion$lambda$9;
                }
            });
        }
    }

    /* renamed from: promo-4WTKRHQ  reason: not valid java name */
    private static final Modifier m8413promo4WTKRHQ(Modifier modifier, long j) {
        Modifier m258borderxT4_qwU = BorderKt.m258borderxT4_qwU(BackgroundKt.m246backgroundbw27NRU(SizeKt.m790width3ABfNKs(SizeKt.m771height3ABfNKs(modifier, Dp.m6684constructorimpl(27)), Dp.m6684constructorimpl(80)), Color.m4077copywmQWz5c$default(Color.Companion.m4104getBlack0d7_KjU(), 0.2f, 0.0f, 0.0f, 0.0f, 14, null), new ExpShape()), Dp.m6684constructorimpl(2), j, new ExpShape());
        float f = 0;
        return PaddingKt.m739paddingVpY3zN4(m258borderxT4_qwU, Dp.m6684constructorimpl(f), Dp.m6684constructorimpl(f));
    }
}
