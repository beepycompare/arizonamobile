package com.miami.game.feature.home.ui.compose;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderKt;
import androidx.compose.foundation.ImageKt;
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
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.DrawModifierKt;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.ClipOp;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawContext;
import androidx.compose.ui.graphics.vector.PathParser;
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
import androidx.compose.ui.unit.TextUnitKt;
import androidx.media3.exoplayer.RendererCapabilities;
import coil3.compose.SingletonAsyncImageKt;
import com.miami.game.core.design.system.component.other.AnimatedLoadingKt;
import com.miami.game.core.design.system.component.scaling_button.ScalingButtonKt;
import com.miami.game.feature.home.R;
import com.miami.game.feature.home.ui.model.HomeUiState;
import com.miami.game.ui.theme.TypeKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: ServerButton.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a#\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u0005H\u0007¢\u0006\u0002\u0010\u0006\"\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"ServerButton", "", "uiState", "Lcom/miami/game/feature/home/ui/model/HomeUiState;", "onClickServer", "Lkotlin/Function0;", "(Lcom/miami/game/feature/home/ui/model/HomeUiState;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "path", "Landroidx/compose/ui/graphics/Path;", "home_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ServerButtonKt {
    private static final Path path = PathParser.toPath$default(new PathParser().parsePathString("M 0.5768 25.1032 C -1.3113 11.8522 8.972 0 22.3568 0 H 500.912 C 511.864 0 521.148 8.0548 522.692 18.8967 L 529.423 66.1361 C 531.311 79.387 521.028 91.239 507.643 91.239 H 29.0876 C 18.1362 91.239 8.8523 83.184 7.3075 72.343 L 0.5768 25.1032 Z"), null, 1, null);

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ServerButton$lambda$8(HomeUiState homeUiState, Function0 function0, int i, Composer composer, int i2) {
        ServerButton(homeUiState, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final void ServerButton(final HomeUiState uiState, Function0<Unit> onClickServer, Composer composer, final int i) {
        int i2;
        final Function0<Unit> function0;
        Intrinsics.checkNotNullParameter(uiState, "uiState");
        Intrinsics.checkNotNullParameter(onClickServer, "onClickServer");
        Composer startRestartGroup = composer.startRestartGroup(-830128021);
        ComposerKt.sourceInformation(startRestartGroup, "C(ServerButton)N(uiState,onClickServer)45@2019L3449,45@1990L3478:ServerButton.kt#dswm0d");
        if ((i & 6) == 0) {
            i2 = (startRestartGroup.changed(uiState) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= startRestartGroup.changedInstance(onClickServer) ? 32 : 16;
        }
        if (!startRestartGroup.shouldExecute((i2 & 19) != 18, i2 & 1)) {
            function0 = onClickServer;
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-830128021, i2, -1, "com.miami.game.feature.home.ui.compose.ServerButton (ServerButton.kt:44)");
            }
            function0 = onClickServer;
            ScalingButtonKt.ScalingButton(function0, null, ComposableLambdaKt.rememberComposableLambda(-1603655072, true, new Function3() { // from class: com.miami.game.feature.home.ui.compose.ServerButtonKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    Unit ServerButton$lambda$7;
                    ServerButton$lambda$7 = ServerButtonKt.ServerButton$lambda$7(HomeUiState.this, (BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    return ServerButton$lambda$7;
                }
            }, startRestartGroup, 54), startRestartGroup, ((i2 >> 3) & 14) | RendererCapabilities.DECODER_SUPPORT_MASK, 2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: com.miami.game.feature.home.ui.compose.ServerButtonKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit ServerButton$lambda$8;
                    ServerButton$lambda$8 = ServerButtonKt.ServerButton$lambda$8(HomeUiState.this, function0, i, (Composer) obj, ((Integer) obj2).intValue());
                    return ServerButton$lambda$8;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ServerButton$lambda$7(HomeUiState homeUiState, BoxScope ScalingButton, Composer composer, int i) {
        Composer composer2;
        ContentScale fillHeight;
        Intrinsics.checkNotNullParameter(ScalingButton, "$this$ScalingButton");
        ComposerKt.sourceInformation(composer, "C61@2600L137,46@2029L3433:ServerButton.kt#dswm0d");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1603655072, i, -1, "com.miami.game.feature.home.ui.compose.ServerButton.<anonymous> (ServerButton.kt:46)");
            }
            Modifier m271borderziNgDLE = BorderKt.m271borderziNgDLE(BackgroundKt.m256backgroundbw27NRU(SizeKt.m889width3ABfNKs(SizeKt.m870height3ABfNKs(Modifier.Companion, Dp.m7251constructorimpl(32)), Dp.m7251constructorimpl(180)), Color.m4536copywmQWz5c$default(Color.Companion.m4563getBlack0d7_KjU(), 0.5f, 0.0f, 0.0f, 0.0f, 14, null), new ServerHomeShape()), Dp.m7251constructorimpl(2), Brush.Companion.m4493verticalGradient8A3gB4$default(Brush.Companion, CollectionsKt.listOf((Object[]) new Color[]{Color.m4527boximpl(Color.m4536copywmQWz5c$default(Color.Companion.m4569getLightGray0d7_KjU(), 0.5f, 0.0f, 0.0f, 0.0f, 14, null)), Color.m4527boximpl(Color.Companion.m4572getTransparent0d7_KjU())}), 0.0f, 0.0f, 0, 14, (Object) null), new ServerHomeShape());
            ComposerKt.sourceInformationMarkerStart(composer, 780753801, "CC(remember):ServerButton.kt#9igjgp");
            Object rememberedValue = composer.rememberedValue();
            if (rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new Function1() { // from class: com.miami.game.feature.home.ui.compose.ServerButtonKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit ServerButton$lambda$7$lambda$2$lambda$1;
                        ServerButton$lambda$7$lambda$2$lambda$1 = ServerButtonKt.ServerButton$lambda$7$lambda$2$lambda$1((ContentDrawScope) obj);
                        return ServerButton$lambda$7$lambda$2$lambda$1;
                    }
                };
                composer.updateRememberedValue(rememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            Modifier drawWithContent = DrawModifierKt.drawWithContent(m271borderziNgDLE, (Function1) rememberedValue);
            Alignment.Vertical centerVertically = Alignment.Companion.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart(composer, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getSpaceBetween(), centerVertically, composer, 54);
            ComposerKt.sourceInformationMarkerStart(composer, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
            int hashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(composer, drawWithContent);
            Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!(composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer.startReusableNode();
            if (composer.getInserting()) {
                composer.createNode(constructor);
            } else {
                composer.useNode();
            }
            Composer m3855constructorimpl = Updater.m3855constructorimpl(composer);
            Updater.m3862setimpl(m3855constructorimpl, rowMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m3862setimpl(m3855constructorimpl, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (m3855constructorimpl.getInserting() || !Intrinsics.areEqual(m3855constructorimpl.rememberedValue(), Integer.valueOf(hashCode))) {
                m3855constructorimpl.updateRememberedValue(Integer.valueOf(hashCode));
                m3855constructorimpl.apply(Integer.valueOf(hashCode), setCompositeKeyHash);
            }
            Updater.m3862setimpl(m3855constructorimpl, materializeModifier, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, 76644041, "C70@2901L2338,124@5275L47,123@5252L199:ServerButton.kt#dswm0d");
            Modifier fillMaxHeight$default = SizeKt.fillMaxHeight$default(Modifier.Companion, 0.0f, 1, null);
            Alignment.Vertical centerVertically2 = Alignment.Companion.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart(composer, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            MeasurePolicy rowMeasurePolicy2 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically2, composer, 48);
            ComposerKt.sourceInformationMarkerStart(composer, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
            int hashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap2 = composer.getCurrentCompositionLocalMap();
            Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(composer, fillMaxHeight$default);
            Function0<ComposeUiNode> constructor2 = ComposeUiNode.Companion.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!(composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer.startReusableNode();
            if (composer.getInserting()) {
                composer.createNode(constructor2);
            } else {
                composer.useNode();
            }
            Composer m3855constructorimpl2 = Updater.m3855constructorimpl(composer);
            Updater.m3862setimpl(m3855constructorimpl2, rowMeasurePolicy2, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m3862setimpl(m3855constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (m3855constructorimpl2.getInserting() || !Intrinsics.areEqual(m3855constructorimpl2.rememberedValue(), Integer.valueOf(hashCode2))) {
                m3855constructorimpl2.updateRememberedValue(Integer.valueOf(hashCode2));
                m3855constructorimpl2.apply(Integer.valueOf(hashCode2), setCompositeKeyHash2);
            }
            Updater.m3862setimpl(m3855constructorimpl2, materializeModifier2, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScopeInstance rowScopeInstance2 = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, 1173809505, "C:ServerButton.kt#dswm0d");
            if (homeUiState.getCurrentServer() != null) {
                composer.startReplaceGroup(1173830305);
                ComposerKt.sourceInformation(composer, "80@3331L462,90@3814L979");
                if (homeUiState.getCurrentServer().isArizona()) {
                    fillHeight = ContentScale.Companion.getCrop();
                } else {
                    fillHeight = ContentScale.Companion.getFillHeight();
                }
                ContentScale contentScale = fillHeight;
                float f = 70;
                Modifier m889width3ABfNKs = SizeKt.m889width3ABfNKs(Modifier.Companion, Dp.m7251constructorimpl(f));
                Alignment center = Alignment.Companion.getCenter();
                ComposerKt.sourceInformationMarkerStart(composer, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(center, false);
                ComposerKt.sourceInformationMarkerStart(composer, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
                int hashCode3 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
                CompositionLocalMap currentCompositionLocalMap3 = composer.getCurrentCompositionLocalMap();
                Modifier materializeModifier3 = ComposedModifierKt.materializeModifier(composer, m889width3ABfNKs);
                Function0<ComposeUiNode> constructor3 = ComposeUiNode.Companion.getConstructor();
                ComposerKt.sourceInformationMarkerStart(composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                if (!(composer.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composer.startReusableNode();
                if (composer.getInserting()) {
                    composer.createNode(constructor3);
                } else {
                    composer.useNode();
                }
                Composer m3855constructorimpl3 = Updater.m3855constructorimpl(composer);
                Updater.m3862setimpl(m3855constructorimpl3, maybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.m3862setimpl(m3855constructorimpl3, currentCompositionLocalMap3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = ComposeUiNode.Companion.getSetCompositeKeyHash();
                if (m3855constructorimpl3.getInserting() || !Intrinsics.areEqual(m3855constructorimpl3.rememberedValue(), Integer.valueOf(hashCode3))) {
                    m3855constructorimpl3.updateRememberedValue(Integer.valueOf(hashCode3));
                    m3855constructorimpl3.apply(Integer.valueOf(hashCode3), setCompositeKeyHash3);
                }
                Updater.m3862setimpl(m3855constructorimpl3, materializeModifier3, ComposeUiNode.Companion.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composer, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composer, 1583302100, "C82@3445L28,83@3498L273:ServerButton.kt#dswm0d");
                float f2 = 16;
                AnimatedLoadingKt.m8925AnimatedLoadinguFdPcIQ(true, Dp.m7251constructorimpl(f2), null, composer, 54, 4);
                SingletonAsyncImageKt.m8334AsyncImage10Xjiaw(homeUiState.getCurrentServer().getIcon(), null, SizeKt.m884size3ABfNKs(Modifier.Companion, Dp.m7251constructorimpl(f)), null, null, null, contentScale, 0.0f, null, 0, false, composer, 432, 0, 1976);
                ComposerKt.sourceInformationMarkerEnd(composer);
                ComposerKt.sourceInformationMarkerEnd(composer);
                composer.endNode();
                ComposerKt.sourceInformationMarkerEnd(composer);
                ComposerKt.sourceInformationMarkerEnd(composer);
                ComposerKt.sourceInformationMarkerEnd(composer);
                Modifier m787offsetVpY3zN4$default = OffsetKt.m787offsetVpY3zN4$default(SizeKt.fillMaxHeight$default(PaddingKt.m834paddingVpY3zN4$default(Modifier.Companion, Dp.m7251constructorimpl(8), 0.0f, 2, null), 0.0f, 1, null), 0.0f, Dp.m7251constructorimpl(-Dp.m7251constructorimpl(1)), 1, null);
                ComposerKt.sourceInformationMarkerStart(composer, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getSpaceAround(), Alignment.Companion.getStart(), composer, 6);
                ComposerKt.sourceInformationMarkerStart(composer, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
                int hashCode4 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
                CompositionLocalMap currentCompositionLocalMap4 = composer.getCurrentCompositionLocalMap();
                Modifier materializeModifier4 = ComposedModifierKt.materializeModifier(composer, m787offsetVpY3zN4$default);
                Function0<ComposeUiNode> constructor4 = ComposeUiNode.Companion.getConstructor();
                ComposerKt.sourceInformationMarkerStart(composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                if (!(composer.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composer.startReusableNode();
                if (composer.getInserting()) {
                    composer.createNode(constructor4);
                } else {
                    composer.useNode();
                }
                Composer m3855constructorimpl4 = Updater.m3855constructorimpl(composer);
                Updater.m3862setimpl(m3855constructorimpl4, columnMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.m3862setimpl(m3855constructorimpl4, currentCompositionLocalMap4, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash4 = ComposeUiNode.Companion.getSetCompositeKeyHash();
                if (m3855constructorimpl4.getInserting() || !Intrinsics.areEqual(m3855constructorimpl4.rememberedValue(), Integer.valueOf(hashCode4))) {
                    m3855constructorimpl4.updateRememberedValue(Integer.valueOf(hashCode4));
                    m3855constructorimpl4.apply(Integer.valueOf(hashCode4), setCompositeKeyHash4);
                }
                Updater.m3862setimpl(m3855constructorimpl4, materializeModifier4, ComposeUiNode.Companion.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composer, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
                ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composer, -1442354001, "C100@4318L10,101@4379L13,102@4435L13,96@4104L370,106@4601L11,107@4672L10,108@4733L12,104@4499L272:ServerButton.kt#dswm0d");
                TextKt.m2804Text4IGK_g(String.valueOf(homeUiState.getCurrentServer().getName()), (Modifier) null, Color.Companion.m4574getWhite0d7_KjU(), TypeKt.m9041dpToSp8Feqmps(Dp.m7251constructorimpl(f2), composer, 6), (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, TypeKt.m9041dpToSp8Feqmps(Dp.m7251constructorimpl(17), composer, 6), 0, false, 1, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography(composer, MaterialTheme.$stable).getBodySmall(), composer, (int) RendererCapabilities.DECODER_SUPPORT_MASK, 3072, 56306);
                TextKt.m2804Text4IGK_g("ВЫБРАТЬ СЕРВЕР", (Modifier) null, MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).m2021getPrimary0d7_KjU(), TypeKt.m9041dpToSp8Feqmps(Dp.m7251constructorimpl(9), composer, 6), (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography(composer, MaterialTheme.$stable).getBodySmall(), composer, 6, 0, 65522);
                composer2 = composer;
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                composer2.endNode();
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                composer2.endReplaceGroup();
            } else {
                composer.startReplaceGroup(1175502786);
                ComposerKt.sourceInformation(composer, "115@4980L10,112@4839L368");
                TextKt.m2804Text4IGK_g("СЕРВЕР НЕ ВЫБРАН", SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, null), Color.Companion.m4574getWhite0d7_KjU(), TextUnitKt.getSp(12), (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, TextAlign.m7128boximpl(TextAlign.Companion.m7135getCentere0LSkKk()), 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography(composer, MaterialTheme.$stable).getBodySmall(), composer, 3510, 0, 65008);
                composer2 = composer;
                composer2.endReplaceGroup();
            }
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ImageKt.Image(PainterResources_androidKt.painterResource(R.drawable.server_button_arrow, composer2, 0), (String) null, OffsetKt.m787offsetVpY3zN4$default(SizeKt.m884size3ABfNKs(Modifier.Companion, Dp.m7251constructorimpl(8)), Dp.m7251constructorimpl(-Dp.m7251constructorimpl(10)), 0.0f, 2, null), (Alignment) null, (ContentScale) null, 0.0f, (ColorFilter) null, composer, 432, (int) MenuKt.InTransitionDuration);
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
    public static final Unit ServerButton$lambda$7$lambda$2$lambda$1(ContentDrawScope drawWithContent) {
        Intrinsics.checkNotNullParameter(drawWithContent, "$this$drawWithContent");
        Path path2 = path;
        int m4526getIntersectrtfAjoo = ClipOp.Companion.m4526getIntersectrtfAjoo();
        DrawContext drawContext = drawWithContent.getDrawContext();
        long mo5037getSizeNHjbRc = drawContext.mo5037getSizeNHjbRc();
        drawContext.getCanvas().save();
        try {
            drawContext.getTransform().mo5039clipPathmtrdDE(path2, m4526getIntersectrtfAjoo);
            drawWithContent.drawContent();
            drawContext.getCanvas().restore();
            drawContext.mo5038setSizeuvyYCjk(mo5037getSizeNHjbRc);
            return Unit.INSTANCE;
        } catch (Throwable th) {
            drawContext.getCanvas().restore();
            drawContext.mo5038setSizeuvyYCjk(mo5037getSizeNHjbRc);
            throw th;
        }
    }
}
