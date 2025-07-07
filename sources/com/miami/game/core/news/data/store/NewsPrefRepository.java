package com.miami.game.core.news.data.store;

import com.miami.game.core.api.model.response.news.NewsApiModelItem;
import com.miami.game.core.local.repository.common.LocalRepository;
import com.miami.game.core.news.data.store.model.NewsPrefModelItem;
import com.miami.game.core.news.data.store.model.NewsPrefModelKt;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
/* compiled from: NewsPrefRepository.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u0011\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007H\u0086@¢\u0006\u0002\u0010\tJ\u001e\u0010\n\u001a\u00020\u000b2\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007H\u0086@¢\u0006\u0002\u0010\rJ\u000e\u0010\u000e\u001a\u00020\u000bH\u0086@¢\u0006\u0002\u0010\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/miami/game/core/news/data/store/NewsPrefRepository;", "", "localRepository", "Lcom/miami/game/core/local/repository/common/LocalRepository;", "<init>", "(Lcom/miami/game/core/local/repository/common/LocalRepository;)V", "getCache", "", "Lcom/miami/game/core/api/model/response/news/NewsApiModelItem;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "saveCache", "", "news", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "remove", "Companion", "news_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class NewsPrefRepository {
    public static final Companion Companion = new Companion(null);
    private static final String NEWS_CACHE_KEY = "NEWS_CACHE_KEY";
    private final LocalRepository localRepository;

    @Inject
    public NewsPrefRepository(LocalRepository localRepository) {
        Intrinsics.checkNotNullParameter(localRepository, "localRepository");
        this.localRepository = localRepository;
    }

    /* compiled from: NewsPrefRepository.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/miami/game/core/news/data/store/NewsPrefRepository$Companion;", "", "<init>", "()V", NewsPrefRepository.NEWS_CACHE_KEY, "", "news_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0080 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object getCache(Continuation<? super List<NewsApiModelItem>> continuation) {
        NewsPrefRepository$getCache$1 newsPrefRepository$getCache$1;
        int i;
        List list;
        if (continuation instanceof NewsPrefRepository$getCache$1) {
            newsPrefRepository$getCache$1 = (NewsPrefRepository$getCache$1) continuation;
            if ((newsPrefRepository$getCache$1.label & Integer.MIN_VALUE) != 0) {
                newsPrefRepository$getCache$1.label -= Integer.MIN_VALUE;
                Object obj = newsPrefRepository$getCache$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = newsPrefRepository$getCache$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    newsPrefRepository$getCache$1.label = 1;
                    obj = BuildersKt.withContext(Dispatchers.getIO(), new NewsPrefRepository$getCache$$inlined$getSuspend$1(this.localRepository, NEWS_CACHE_KEY, null), newsPrefRepository$getCache$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    ResultKt.throwOnFailure(obj);
                }
                list = (List) obj;
                if (list == null) {
                    List<NewsPrefModelItem> list2 = list;
                    ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
                    for (NewsPrefModelItem newsPrefModelItem : list2) {
                        arrayList.add(NewsPrefModelKt.toDomain(newsPrefModelItem));
                    }
                    return arrayList;
                }
                return null;
            }
        }
        newsPrefRepository$getCache$1 = new NewsPrefRepository$getCache$1(this, continuation);
        Object obj2 = newsPrefRepository$getCache$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = newsPrefRepository$getCache$1.label;
        if (i != 0) {
        }
        list = (List) obj2;
        if (list == null) {
        }
    }

    public final Object saveCache(List<NewsApiModelItem> list, Continuation<? super Unit> continuation) {
        ArrayList arrayList;
        if (list != null) {
            List<NewsApiModelItem> list2 = list;
            ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
            for (NewsApiModelItem newsApiModelItem : list2) {
                arrayList2.add(NewsPrefModelKt.toPrefsModel(newsApiModelItem));
            }
            arrayList = arrayList2;
        } else {
            arrayList = null;
        }
        Object save2 = this.localRepository.save2(NEWS_CACHE_KEY, (String) arrayList, continuation);
        return save2 == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? save2 : Unit.INSTANCE;
    }

    public final Object remove(Continuation<? super Unit> continuation) {
        Object remove2 = this.localRepository.remove2(NEWS_CACHE_KEY, continuation);
        return remove2 == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? remove2 : Unit.INSTANCE;
    }
}
