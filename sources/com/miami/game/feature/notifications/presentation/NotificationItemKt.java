package com.miami.game.feature.notifications.presentation;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.OffsetKt;
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
import androidx.compose.ui.draw.DrawModifierKt;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.ClipOp;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawContext;
import androidx.compose.ui.graphics.vector.PathParser;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.unit.Dp;
import androidx.media3.exoplayer.RendererCapabilities;
import coil3.compose.SingletonAsyncImageKt;
import com.miami.game.core.design.system.component.other.AnimatedLoadingKt;
import com.miami.game.feature.notifications.NotificationModel;
import com.miami.game.ui.theme.TypeKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: NotificationItem.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u0015\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0007¢\u0006\u0002\u0010\u0004\"\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"NotificationItem", "", "notificationModel", "Lcom/miami/game/feature/notifications/NotificationModel;", "(Lcom/miami/game/feature/notifications/NotificationModel;Landroidx/compose/runtime/Composer;I)V", "path", "Landroidx/compose/ui/graphics/Path;", "notifications_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class NotificationItemKt {
    private static final Path path = PathParser.toPath$default(new PathParser().parsePathString("M997.9,14.8C995.6,6.1 987.7,0 978.6,0H20.1C6.9,0 -2.6,12.5 0.8,25.2L92.1,364.2C94.4,372.9 102.3,379 111.4,379H1069.9C1083.1,379 1092.6,366.5 1089.2,353.8L997.9,14.8Z"), null, 1, null);

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit NotificationItem$lambda$2(NotificationModel notificationModel, int i, Composer composer, int i2) {
        NotificationItem(notificationModel, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final void NotificationItem(final NotificationModel notificationModel, Composer composer, final int i) {
        int i2;
        Composer composer2;
        Intrinsics.checkNotNullParameter(notificationModel, "notificationModel");
        Composer startRestartGroup = composer.startRestartGroup(-753000446);
        ComposerKt.sourceInformation(startRestartGroup, "C(NotificationItem)N(notificationModel)43@1811L32,44@1848L2433:NotificationItem.kt#21zkme");
        if ((i & 6) == 0) {
            i2 = (startRestartGroup.changedInstance(notificationModel) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if (startRestartGroup.shouldExecute((i2 & 3) != 2, i2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-753000446, i2, -1, "com.miami.game.feature.notifications.presentation.NotificationItem (NotificationItem.kt:42)");
            }
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -2078920190, "CC(remember):NotificationItem.kt#9igjgp");
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new NotificationShape();
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            NotificationShape notificationShape = (NotificationShape) rememberedValue;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
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
            Composer m4673constructorimpl = Updater.m4673constructorimpl(startRestartGroup);
            Updater.m4681setimpl(m4673constructorimpl, maybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m4681setimpl(m4673constructorimpl, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.m4677initimpl(m4673constructorimpl, Integer.valueOf(hashCode), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.m4679reconcileimpl(m4673constructorimpl, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.m4681setimpl(m4673constructorimpl, materializeModifier, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -498923172, "C49@1996L136,45@1863L667,66@2540L1734:NotificationItem.kt#21zkme");
            float f = 114;
            float f2 = 330;
            Modifier m981width3ABfNKs = SizeKt.m981width3ABfNKs(SizeKt.m962height3ABfNKs(Modifier.Companion, Dp.m8258constructorimpl(f)), Dp.m8258constructorimpl(f2));
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1124470972, "CC(remember):NotificationItem.kt#9igjgp");
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (rememberedValue2 == Composer.Companion.getEmpty()) {
                rememberedValue2 = new Function1() { // from class: com.miami.game.feature.notifications.presentation.NotificationItemKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit NotificationItem$lambda$1$0$0;
                        NotificationItem$lambda$1$0$0 = NotificationItemKt.NotificationItem$lambda$1$0$0((ContentDrawScope) obj);
                        return NotificationItem$lambda$1$0$0;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            Modifier drawWithContent = DrawModifierKt.drawWithContent(m981width3ABfNKs, (Function1) rememberedValue2);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy maybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int hashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(startRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(startRestartGroup, drawWithContent);
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
            Updater.m4681setimpl(m4673constructorimpl2, maybeCachedBoxMeasurePolicy2, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m4681setimpl(m4673constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.m4677initimpl(m4673constructorimpl2, Integer.valueOf(hashCode2), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.m4679reconcileimpl(m4673constructorimpl2, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.m4681setimpl(m4673constructorimpl2, materializeModifier2, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1889896846, "C56@2172L78,57@2264L255:NotificationItem.kt#21zkme");
            float f3 = 32;
            AnimatedLoadingKt.m10032AnimatedLoadinguFdPcIQ(true, Dp.m8258constructorimpl(40), OffsetKt.m884offsetVpY3zN4(Modifier.Companion, Dp.m8258constructorimpl(f3), Dp.m8258constructorimpl(f3)), startRestartGroup, 438, 0);
            SingletonAsyncImageKt.m9379AsyncImage10Xjiaw(notificationModel.getImageUrl(), null, SizeKt.m976size3ABfNKs(Modifier.Companion, Dp.m8258constructorimpl(160)), null, null, null, ContentScale.Companion.getCrop(), 0.0f, null, 0, false, startRestartGroup, 1573296, 0, 1976);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            startRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            Modifier m981width3ABfNKs2 = SizeKt.m981width3ABfNKs(SizeKt.m962height3ABfNKs(Modifier.Companion, Dp.m8258constructorimpl(f)), Dp.m8258constructorimpl(f2));
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy maybeCachedBoxMeasurePolicy3 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int hashCode3 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(startRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap3 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier3 = ComposedModifierKt.materializeModifier(startRestartGroup, m981width3ABfNKs2);
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
            Updater.m4681setimpl(m4673constructorimpl3, maybeCachedBoxMeasurePolicy3, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m4681setimpl(m4673constructorimpl3, currentCompositionLocalMap3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.m4677initimpl(m4673constructorimpl3, Integer.valueOf(hashCode3), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.m4679reconcileimpl(m4673constructorimpl3, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.m4681setimpl(m4673constructorimpl3, materializeModifier3, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance3 = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 531395107, "C73@2727L1537:NotificationItem.kt#21zkme");
            Modifier background$default = BackgroundKt.background$default(SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, null), Brush.Companion.m5371horizontalGradient8A3gB4$default(Brush.Companion, CollectionsKt.listOf((Object[]) new Color[]{Color.m5414boximpl(Color.m5423copywmQWz5c$default(Color.Companion.m5450getBlack0d7_KjU(), 0.25f, 0.0f, 0.0f, 0.0f, 14, null)), Color.m5414boximpl(ColorKt.Color(4279508784L)), Color.m5414boximpl(ColorKt.Color(4279508784L))}), 0.0f, 0.0f, 0, 14, (Object) null), new NotificationShape(), 0.0f, 4, null);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy maybeCachedBoxMeasurePolicy4 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int hashCode4 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(startRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap4 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier4 = ComposedModifierKt.materializeModifier(startRestartGroup, background$default);
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
            Updater.m4681setimpl(m4673constructorimpl4, maybeCachedBoxMeasurePolicy4, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m4681setimpl(m4673constructorimpl4, currentCompositionLocalMap4, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.m4677initimpl(m4673constructorimpl4, Integer.valueOf(hashCode4), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.m4679reconcileimpl(m4673constructorimpl4, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.m4681setimpl(m4673constructorimpl4, materializeModifier4, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1038013621, "C89@3322L927:NotificationItem.kt#21zkme");
            Modifier m885offsetVpY3zN4$default = OffsetKt.m885offsetVpY3zN4$default(SizeKt.m981width3ABfNKs(BoxScopeInstance.INSTANCE.align(Modifier.Companion, Alignment.Companion.getTopEnd()), Dp.m8258constructorimpl(200)), Dp.m8258constructorimpl(-Dp.m8258constructorimpl(f3)), 0.0f, 2, null);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.Companion.getStart(), startRestartGroup, 0);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int hashCode5 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(startRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap5 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier5 = ComposedModifierKt.materializeModifier(startRestartGroup, m885offsetVpY3zN4$default);
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
            Updater.m4681setimpl(m4673constructorimpl5, columnMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m4681setimpl(m4673constructorimpl5, currentCompositionLocalMap5, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.m4677initimpl(m4673constructorimpl5, Integer.valueOf(hashCode5), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.m4679reconcileimpl(m4673constructorimpl5, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.m4681setimpl(m4673constructorimpl5, materializeModifier5, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -191347082, "C94@3517L29,98@3719L10,99@3776L13,100@3828L13,95@3567L296,106@4087L10,107@4144L13,108@4196L13,103@3936L295:NotificationItem.kt#21zkme");
            SpacerKt.Spacer(SizeKt.m962height3ABfNKs(Modifier.Companion, Dp.m8258constructorimpl(2)), startRestartGroup, 6);
            float f4 = 24;
            composer2 = startRestartGroup;
            TextKt.m3255TextNvy7gAk(notificationModel.getTitle(), null, ColorKt.Color(4294046193L), null, TypeKt.m10152dpToSp8Feqmps(Dp.m8258constructorimpl(f4), startRestartGroup, 6), null, null, null, 0L, null, null, TypeKt.m10152dpToSp8Feqmps(Dp.m8258constructorimpl(f4), startRestartGroup, 6), 0, false, 0, 0, null, MaterialTheme.INSTANCE.getTypography(startRestartGroup, MaterialTheme.$stable).getBodySmall(), composer2, RendererCapabilities.DECODER_SUPPORT_MASK, 0, 129002);
            float f5 = 11;
            TextKt.m3255TextNvy7gAk(notificationModel.getText(), null, ColorKt.Color(4291150552L), null, TypeKt.m10152dpToSp8Feqmps(Dp.m8258constructorimpl(f5), composer2, 6), null, null, null, 0L, null, null, TypeKt.m10152dpToSp8Feqmps(Dp.m8258constructorimpl(f5), composer2, 6), 0, false, 0, 0, null, MaterialTheme.INSTANCE.getTypography(composer2, MaterialTheme.$stable).getBodySmall(), composer2, RendererCapabilities.DECODER_SUPPORT_MASK, 0, 129002);
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
        } else {
            composer2 = startRestartGroup;
            composer2.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: com.miami.game.feature.notifications.presentation.NotificationItemKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit NotificationItem$lambda$2;
                    NotificationItem$lambda$2 = NotificationItemKt.NotificationItem$lambda$2(NotificationModel.this, i, (Composer) obj, ((Integer) obj2).intValue());
                    return NotificationItem$lambda$2;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit NotificationItem$lambda$1$0$0(ContentDrawScope drawWithContent) {
        Intrinsics.checkNotNullParameter(drawWithContent, "$this$drawWithContent");
        Path path2 = path;
        int m5413getIntersectrtfAjoo = ClipOp.Companion.m5413getIntersectrtfAjoo();
        DrawContext drawContext = drawWithContent.getDrawContext();
        long mo5926getSizeNHjbRc = drawContext.mo5926getSizeNHjbRc();
        drawContext.getCanvas().save();
        try {
            drawContext.getTransform().mo5928clipPathmtrdDE(path2, m5413getIntersectrtfAjoo);
            drawWithContent.drawContent();
            drawContext.getCanvas().restore();
            drawContext.mo5927setSizeuvyYCjk(mo5926getSizeNHjbRc);
            return Unit.INSTANCE;
        } catch (Throwable th) {
            drawContext.getCanvas().restore();
            drawContext.mo5927setSizeuvyYCjk(mo5926getSizeNHjbRc);
            throw th;
        }
    }
}
