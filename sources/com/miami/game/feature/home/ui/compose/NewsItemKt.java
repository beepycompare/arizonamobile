package com.miami.game.feature.home.ui.compose;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.PaddingKt;
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
import androidx.compose.ui.draw.ClipKt;
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
import androidx.compose.ui.unit.TextUnitKt;
import coil3.compose.SingletonAsyncImageKt;
import com.miami.game.core.design.system.component.other.AnimatedLoadingKt;
import com.miami.game.core.design.system.theme.NewsShape;
import com.miami.game.core.news.domain.NewsModel;
import com.miami.game.feature.home.R;
import com.miami.game.ui.theme.TypeKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: NewsItem.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a)\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u0005H\u0007¢\u0006\u0002\u0010\u0007¨\u0006\b"}, d2 = {"NewsItem", "", "newsModel", "Lcom/miami/game/core/news/domain/NewsModel;", "onClickNews", "Lkotlin/Function1;", "", "(Lcom/miami/game/core/news/domain/NewsModel;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "home_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class NewsItemKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit NewsItem$lambda$2(NewsModel newsModel, Function1 function1, int i, Composer composer, int i2) {
        NewsItem(newsModel, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final void NewsItem(final NewsModel newsModel, final Function1<? super String, Unit> onClickNews, Composer composer, final int i) {
        int i2;
        Composer composer2;
        Intrinsics.checkNotNullParameter(newsModel, "newsModel");
        Intrinsics.checkNotNullParameter(onClickNews, "onClickNews");
        Composer startRestartGroup = composer.startRestartGroup(168788816);
        ComposerKt.sourceInformation(startRestartGroup, "C(NewsItem)N(newsModel,onClickNews)50@1956L41,45@1782L2416:NewsItem.kt#dswm0d");
        if ((i & 6) == 0) {
            i2 = (startRestartGroup.changedInstance(newsModel) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= startRestartGroup.changedInstance(onClickNews) ? 32 : 16;
        }
        if (!startRestartGroup.shouldExecute((i2 & 19) != 18, i2 & 1)) {
            composer2 = startRestartGroup;
            composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(168788816, i2, -1, "com.miami.game.feature.home.ui.compose.NewsItem (NewsItem.kt:44)");
            }
            Modifier m298backgroundbw27NRU = BackgroundKt.m298backgroundbw27NRU(SizeKt.m962height3ABfNKs(SizeKt.m981width3ABfNKs(Modifier.Companion, Dp.m8258constructorimpl(160)), Dp.m8258constructorimpl(97)), Color.Companion.m5459getTransparent0d7_KjU(), new NewsShape());
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1002696839, "CC(remember):NewsItem.kt#9igjgp");
            boolean changedInstance = ((i2 & 112) == 32) | startRestartGroup.changedInstance(newsModel);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (changedInstance || rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new Function0() { // from class: com.miami.game.feature.home.ui.compose.NewsItemKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit NewsItem$lambda$0$0;
                        NewsItem$lambda$0$0 = NewsItemKt.NewsItem$lambda$0$0(Function1.this, newsModel);
                        return NewsItem$lambda$0$0;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            Modifier clip = ClipKt.clip(ClickableKt.m342clickableoSLSa3U$default(m298backgroundbw27NRU, false, null, null, null, (Function0) rememberedValue, 15, null), new NewsShape());
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int hashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(startRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, clip);
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
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1443822074, "C54@2092L331,64@2437L161,70@2608L1334,109@3980L43,108@3951L240:NewsItem.kt#dswm0d");
            float f = 10;
            Modifier m885offsetVpY3zN4$default = OffsetKt.m885offsetVpY3zN4$default(BackgroundKt.m299backgroundbw27NRU$default(SizeKt.fillMaxSize$default(boxScopeInstance.align(Modifier.Companion, Alignment.Companion.getCenter()), 0.0f, 1, null), Color.m5423copywmQWz5c$default(Color.Companion.m5450getBlack0d7_KjU(), 0.3f, 0.0f, 0.0f, 0.0f, 14, null), null, 2, null), 0.0f, Dp.m8258constructorimpl(-Dp.m8258constructorimpl(f)), 1, null);
            Alignment center = Alignment.Companion.getCenter();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy maybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(center, false);
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
            Updater.m4681setimpl(m4673constructorimpl2, maybeCachedBoxMeasurePolicy2, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m4681setimpl(m4673constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.m4677initimpl(m4673constructorimpl2, Integer.valueOf(hashCode2), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.m4679reconcileimpl(m4673constructorimpl2, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.m4681setimpl(m4673constructorimpl2, materializeModifier2, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1397241035, "C61@2381L28:NewsItem.kt#dswm0d");
            AnimatedLoadingKt.m10064AnimatedLoadinguFdPcIQ(true, Dp.m8258constructorimpl(30), null, startRestartGroup, 54, 4);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            startRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            SingletonAsyncImageKt.m9410AsyncImage10Xjiaw(newsModel.getImageUrl(), null, null, null, null, null, ContentScale.Companion.getCrop(), 0.0f, null, 0, false, startRestartGroup, 1572912, 0, 1980);
            Modifier align = boxScopeInstance.align(PaddingKt.m932paddingqDBjuR0$default(BackgroundKt.background$default(SizeKt.fillMaxHeight(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, null), 0.4f), Brush.Companion.m5373linearGradientmHitzGk$default(Brush.Companion, CollectionsKt.listOf((Object[]) new Color[]{Color.m5414boximpl(Color.Companion.m5450getBlack0d7_KjU()), Color.m5414boximpl(Color.m5423copywmQWz5c$default(Color.Companion.m5450getBlack0d7_KjU(), 0.75f, 0.0f, 0.0f, 0.0f, 14, null))}), 0L, 0L, 0, 14, (Object) null), null, 0.0f, 6, null), Dp.m8258constructorimpl(13), 0.0f, 0.0f, 0.0f, 14, null), Alignment.Companion.getBottomStart());
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getCenter(), Alignment.Companion.getStart(), startRestartGroup, 6);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int hashCode3 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(startRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap3 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier3 = ComposedModifierKt.materializeModifier(startRestartGroup, align);
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
            Updater.m4681setimpl(m4673constructorimpl3, columnMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m4681setimpl(m4673constructorimpl3, currentCompositionLocalMap3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.m4677initimpl(m4673constructorimpl3, Integer.valueOf(hashCode3), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.m4679reconcileimpl(m4673constructorimpl3, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.m4681setimpl(m4673constructorimpl3, materializeModifier3, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 241766860, "C88@3248L10,90@3337L13,91@3381L13,86@3153L430,100@3690L10,102@3776L13,103@3820L13,98@3596L336:NewsItem.kt#dswm0d");
            float f2 = 16;
            float f3 = 2;
            TextKt.m3255TextNvy7gAk(String.valueOf(newsModel.getTitle()), OffsetKt.m885offsetVpY3zN4$default(Modifier.Companion, 0.0f, Dp.m8258constructorimpl(-Dp.m8258constructorimpl(f3)), 1, null), Color.Companion.m5461getWhite0d7_KjU(), null, TypeKt.m10184dpToSp8Feqmps(Dp.m8258constructorimpl(f2), startRestartGroup, 6), null, FontWeight.Companion.getBold(), null, TextUnitKt.getSp(-0.0d), null, null, TypeKt.m10184dpToSp8Feqmps(Dp.m8258constructorimpl(f2), startRestartGroup, 6), 0, false, 1, 0, null, MaterialTheme.INSTANCE.getTypography(startRestartGroup, MaterialTheme.$stable).getDisplaySmall(), startRestartGroup, 1573296, 24576, 112296);
            float f4 = 12;
            TextKt.m3255TextNvy7gAk(String.valueOf(newsModel.getDate()), OffsetKt.m885offsetVpY3zN4$default(Modifier.Companion, 0.0f, Dp.m8258constructorimpl(-Dp.m8258constructorimpl(f3)), 1, null), Color.Companion.m5454getGray0d7_KjU(), null, TypeKt.m10184dpToSp8Feqmps(Dp.m8258constructorimpl(f4), startRestartGroup, 6), null, null, null, 0L, null, null, TypeKt.m10184dpToSp8Feqmps(Dp.m8258constructorimpl(f4), startRestartGroup, 6), 0, false, 1, 0, null, MaterialTheme.INSTANCE.getTypography(startRestartGroup, MaterialTheme.$stable).getLabelSmall(), startRestartGroup, 432, 24576, 112616);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            startRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            float f5 = 8;
            ImageKt.Image(PainterResources_androidKt.painterResource(R.drawable.news_item_arrow, startRestartGroup, 0), (String) null, SizeKt.m976size3ABfNKs(OffsetKt.m884offsetVpY3zN4(boxScopeInstance.align(Modifier.Companion, Alignment.Companion.getBottomEnd()), Dp.m8258constructorimpl(-Dp.m8258constructorimpl(f5)), Dp.m8258constructorimpl(-Dp.m8258constructorimpl(f5))), Dp.m8258constructorimpl(f)), (Alignment) null, (ContentScale) null, 0.0f, (ColorFilter) null, startRestartGroup, Painter.$stable | 48, 120);
            composer2 = startRestartGroup;
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
            endRestartGroup.updateScope(new Function2() { // from class: com.miami.game.feature.home.ui.compose.NewsItemKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit NewsItem$lambda$2;
                    NewsItem$lambda$2 = NewsItemKt.NewsItem$lambda$2(NewsModel.this, onClickNews, i, (Composer) obj, ((Integer) obj2).intValue());
                    return NewsItem$lambda$2;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit NewsItem$lambda$0$0(Function1 function1, NewsModel newsModel) {
        function1.invoke(String.valueOf(newsModel.getUrl()));
        return Unit.INSTANCE;
    }
}
