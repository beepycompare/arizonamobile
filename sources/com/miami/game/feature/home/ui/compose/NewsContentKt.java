package com.miami.game.feature.home.ui.compose;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.lazy.LazyDslKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.foundation.lazy.LazyListStateKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.unit.Dp;
import com.miami.game.core.news.domain.NewsModel;
import com.miami.game.feature.home.ui.model.HomeUiState;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: NewsContent.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a)\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u0005H\u0001¢\u0006\u0002\u0010\u0007¨\u0006\b"}, d2 = {"NewsContent", "", "uiState", "Lcom/miami/game/feature/home/ui/model/HomeUiState;", "onClickNews", "Lkotlin/Function1;", "", "(Lcom/miami/game/feature/home/ui/model/HomeUiState;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "home_release_web"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class NewsContentKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit NewsContent$lambda$3(HomeUiState homeUiState, Function1 function1, int i, Composer composer, int i2) {
        NewsContent(homeUiState, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final void NewsContent(final HomeUiState uiState, final Function1<? super String, Unit> onClickNews, Composer composer, final int i) {
        int i2;
        Intrinsics.checkNotNullParameter(uiState, "uiState");
        Intrinsics.checkNotNullParameter(onClickNews, "onClickNews");
        Composer startRestartGroup = composer.startRestartGroup(1833928254);
        ComposerKt.sourceInformation(startRestartGroup, "C(NewsContent)P(1)21@797L23,27@974L111,23@826L259:NewsContent.kt#dswm0d");
        if ((i & 6) == 0) {
            i2 = (startRestartGroup.changed(uiState) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= startRestartGroup.changedInstance(onClickNews) ? 32 : 16;
        }
        if (!startRestartGroup.shouldExecute((i2 & 19) != 18, i2 & 1)) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1833928254, i2, -1, "com.miami.game.feature.home.ui.compose.NewsContent (NewsContent.kt:20)");
            }
            LazyListState rememberLazyListState = LazyListStateKt.rememberLazyListState(0, 0, startRestartGroup, 0, 3);
            Arrangement.HorizontalOrVertical m619spacedBy0680j_4 = Arrangement.INSTANCE.m619spacedBy0680j_4(Dp.m6684constructorimpl(8));
            Modifier m698offsetVpY3zN4$default = OffsetKt.m698offsetVpY3zN4$default(Modifier.Companion, 0.0f, Dp.m6684constructorimpl(-Dp.m6684constructorimpl(4)), 1, null);
            Arrangement.HorizontalOrVertical horizontalOrVertical = m619spacedBy0680j_4;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1468470925, "CC(remember):NewsContent.kt#9igjgp");
            boolean z = ((i2 & 14) == 4) | ((i2 & 112) == 32);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (z || rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new Function1() { // from class: com.miami.game.feature.home.ui.compose.NewsContentKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit NewsContent$lambda$2$lambda$1;
                        NewsContent$lambda$2$lambda$1 = NewsContentKt.NewsContent$lambda$2$lambda$1(HomeUiState.this, onClickNews, (LazyListScope) obj);
                        return NewsContent$lambda$2$lambda$1;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            LazyDslKt.LazyColumn(m698offsetVpY3zN4$default, rememberLazyListState, null, false, horizontalOrVertical, null, null, false, null, (Function1) rememberedValue, startRestartGroup, 24582, 492);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: com.miami.game.feature.home.ui.compose.NewsContentKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit NewsContent$lambda$3;
                    NewsContent$lambda$3 = NewsContentKt.NewsContent$lambda$3(HomeUiState.this, onClickNews, i, (Composer) obj, ((Integer) obj2).intValue());
                    return NewsContent$lambda$3;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit NewsContent$lambda$2$lambda$1(HomeUiState homeUiState, final Function1 function1, LazyListScope LazyColumn) {
        Intrinsics.checkNotNullParameter(LazyColumn, "$this$LazyColumn");
        final List<NewsModel> newsList = homeUiState.getNewsList();
        final NewsContentKt$NewsContent$lambda$2$lambda$1$$inlined$items$default$1 newsContentKt$NewsContent$lambda$2$lambda$1$$inlined$items$default$1 = new Function1() { // from class: com.miami.game.feature.home.ui.compose.NewsContentKt$NewsContent$lambda$2$lambda$1$$inlined$items$default$1
            @Override // kotlin.jvm.functions.Function1
            public final Void invoke(NewsModel newsModel) {
                return null;
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                return invoke((NewsModel) obj);
            }
        };
        LazyColumn.items(newsList.size(), null, new Function1<Integer, Object>() { // from class: com.miami.game.feature.home.ui.compose.NewsContentKt$NewsContent$lambda$2$lambda$1$$inlined$items$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                return invoke(num.intValue());
            }

            public final Object invoke(int i) {
                return Function1.this.invoke(newsList.get(i));
            }
        }, ComposableLambdaKt.composableLambdaInstance(-632812321, true, new Function4<LazyItemScope, Integer, Composer, Integer, Unit>() { // from class: com.miami.game.feature.home.ui.compose.NewsContentKt$NewsContent$lambda$2$lambda$1$$inlined$items$default$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(4);
            }

            @Override // kotlin.jvm.functions.Function4
            public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Integer num, Composer composer, Integer num2) {
                invoke(lazyItemScope, num.intValue(), composer, num2.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(LazyItemScope lazyItemScope, int i, Composer composer, int i2) {
                int i3;
                ComposerKt.sourceInformation(composer, "C178@8826L22:LazyDsl.kt#428nma");
                if ((i2 & 6) == 0) {
                    i3 = (composer.changed(lazyItemScope) ? 4 : 2) | i2;
                } else {
                    i3 = i2;
                }
                if ((i2 & 48) == 0) {
                    i3 |= composer.changed(i) ? 32 : 16;
                }
                if (!composer.shouldExecute((i3 & 147) != 146, i3 & 1)) {
                    composer.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-632812321, i3, -1, "androidx.compose.foundation.lazy.items.<anonymous> (LazyDsl.kt:178)");
                }
                composer.startReplaceGroup(708230311);
                ComposerKt.sourceInformation(composer, "C*31@1044L25:NewsContent.kt#dswm0d");
                NewsItemKt.NewsItem((NewsModel) newsList.get(i), function1, composer, 0);
                composer.endReplaceGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }));
        return Unit.INSTANCE;
    }
}
