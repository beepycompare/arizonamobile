package ru.mrlargha.commonui.elements.donate.data.remote.apiservices;

import com.arizona.game.BuildConfig;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Query;
import ru.mrlargha.commonui.elements.donate.domain.models.DonateBoostModel;
import ru.mrlargha.commonui.elements.donate.domain.models.DonateCategoryModel;
import ru.mrlargha.commonui.elements.donate.domain.models.DonateItemModel;
/* compiled from: DonateApiService.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J8\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\b\b\u0003\u0010\u0006\u001a\u00020\u00072\b\b\u0003\u0010\b\u001a\u00020\u00072\b\b\u0003\u0010\t\u001a\u00020\nH§@¢\u0006\u0002\u0010\u000bJ8\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u00040\u00032\b\b\u0003\u0010\u0006\u001a\u00020\u00072\b\b\u0003\u0010\b\u001a\u00020\u00072\b\b\u0003\u0010\t\u001a\u00020\nH§@¢\u0006\u0002\u0010\u000bJ8\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u00040\u00032\b\b\u0003\u0010\u0006\u001a\u00020\u00072\b\b\u0003\u0010\b\u001a\u00020\u00072\b\b\u0003\u0010\t\u001a\u00020\nH§@¢\u0006\u0002\u0010\u000b¨\u0006\u0010À\u0006\u0003"}, d2 = {"Lru/mrlargha/commonui/elements/donate/data/remote/apiservices/DonateApiService;", "", "getCategories", "Lretrofit2/Response;", "", "Lru/mrlargha/commonui/elements/donate/domain/models/DonateCategoryModel;", "project", "", "key", "server", "", "(Ljava/lang/String;Ljava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getItems", "Lru/mrlargha/commonui/elements/donate/domain/models/DonateItemModel;", "getBoost", "Lru/mrlargha/commonui/elements/donate/domain/models/DonateBoostModel;", "CommonUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public interface DonateApiService {
    @GET("client/json/table/get")
    Object getBoost(@Query("project") String str, @Query("key") String str2, @Query("server") int i, Continuation<? super Response<List<DonateBoostModel>>> continuation);

    @GET("client/json/table/get")
    Object getCategories(@Query("project") String str, @Query("key") String str2, @Query("server") int i, Continuation<? super Response<List<DonateCategoryModel>>> continuation);

    @GET("client/json/table/get")
    Object getItems(@Query("project") String str, @Query("key") String str2, @Query("server") int i, Continuation<? super Response<List<DonateItemModel>>> continuation);

    /* compiled from: DonateApiService.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class DefaultImpls {
    }

    static /* synthetic */ Object getCategories$default(DonateApiService donateApiService, String str, String str2, int i, Continuation continuation, int i2, Object obj) {
        if (obj == null) {
            if ((i2 & 1) != 0) {
                str = BuildConfig.FLAVOR;
            }
            if ((i2 & 2) != 0) {
                str2 = "donate_category";
            }
            if ((i2 & 4) != 0) {
                i = 0;
            }
            return donateApiService.getCategories(str, str2, i, continuation);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getCategories");
    }

    static /* synthetic */ Object getItems$default(DonateApiService donateApiService, String str, String str2, int i, Continuation continuation, int i2, Object obj) {
        if (obj == null) {
            if ((i2 & 1) != 0) {
                str = BuildConfig.FLAVOR;
            }
            if ((i2 & 2) != 0) {
                str2 = "donate_items";
            }
            if ((i2 & 4) != 0) {
                i = 0;
            }
            return donateApiService.getItems(str, str2, i, continuation);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getItems");
    }

    static /* synthetic */ Object getBoost$default(DonateApiService donateApiService, String str, String str2, int i, Continuation continuation, int i2, Object obj) {
        if (obj == null) {
            if ((i2 & 1) != 0) {
                str = BuildConfig.FLAVOR;
            }
            if ((i2 & 2) != 0) {
                str2 = "donate_settings";
            }
            if ((i2 & 4) != 0) {
                i = 0;
            }
            return donateApiService.getBoost(str, str2, i, continuation);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getBoost");
    }
}
