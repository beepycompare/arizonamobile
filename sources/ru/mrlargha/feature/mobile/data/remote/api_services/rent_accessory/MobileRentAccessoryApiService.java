package ru.mrlargha.feature.mobile.data.remote.api_services.rent_accessory;

import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Query;
import ru.mrlargha.feature.mobile.presentation.page.rent_accessory.models.MobileRentAccessoryCategoryModel;
import ru.mrlargha.feature.mobile.presentation.page.rent_accessory.models.MobileRentAccessoryModel;
/* compiled from: MobileRentAccessoryApiService.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J@\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\u0016\b\u0001\u0010\u0006\u001a\u00020\u0007:\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\nH§@b\f\b\f\u0012\b\b\t\u0012\u0004\b\b(\r¢\u0006\u0002\u0010\u000bJ(\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u00040\u0003H§@b\f\b\f\u0012\b\b\t\u0012\u0004\b\b(\u0011¢\u0006\u0002\u0010\u0010¨\u0006\u0012À\u0006\u0003"}, d2 = {"Lru/mrlargha/feature/mobile/data/remote/api_services/rent_accessory/MobileRentAccessoryApiService;", "", "getAds", "Lretrofit2/Response;", "", "Lru/mrlargha/feature/mobile/presentation/page/rent_accessory/models/MobileRentAccessoryModel;", "accountId", "", "Lretrofit2/http/Query;", "value", "account_id", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lretrofit2/http/GET;", "/client/item-market/getList", "getCategories", "Lru/mrlargha/feature/mobile/presentation/page/rent_accessory/models/MobileRentAccessoryCategoryModel;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "/client/item-market/getCategories", "mobile"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public interface MobileRentAccessoryApiService {
    @GET("/client/item-market/getList")
    Object getAds(@Query("account_id") int i, Continuation<? super Response<List<MobileRentAccessoryModel>>> continuation);

    @GET("/client/item-market/getCategories")
    Object getCategories(Continuation<? super Response<List<MobileRentAccessoryCategoryModel>>> continuation);
}
