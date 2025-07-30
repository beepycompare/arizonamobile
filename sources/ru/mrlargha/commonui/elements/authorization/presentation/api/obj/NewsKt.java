package ru.mrlargha.commonui.elements.authorization.presentation.api.obj;

import com.miami.game.core.news.domain.NewsModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: News.kt */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002¨\u0006\u0003"}, d2 = {"toUi", "Lru/mrlargha/commonui/elements/authorization/presentation/api/obj/News;", "Lcom/miami/game/core/news/domain/NewsModel;", "CommonUI_release_web"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class NewsKt {
    public static final News toUi(NewsModel newsModel) {
        Intrinsics.checkNotNullParameter(newsModel, "<this>");
        return new News(newsModel.getTitle(), newsModel.getImageUrl(), newsModel.getUrl(), newsModel.getDate());
    }
}
