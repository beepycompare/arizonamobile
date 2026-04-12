package ru.mrlargha.feature.mobile.data.remote.api_services.rent;

import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import retrofit2.Response;
import retrofit2.http.GET;
import ru.mrlargha.feature.mobile.presentation.page.rent.models.ArizonaRentAdModel;
/* compiled from: MobileRentApiService.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0003H§@¢\u0006\u0002\u0010\u0006¨\u0006\u0007À\u0006\u0003"}, d2 = {"Lru/mrlargha/feature/mobile/data/remote/api_services/rent/MobileRentApiService;", "", "getAds", "Lretrofit2/Response;", "", "Lru/mrlargha/feature/mobile/presentation/page/rent/models/ArizonaRentAdModel;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "mobile"}, k = 1, mv = {2, 3, 0}, xi = 48)
/* loaded from: classes6.dex */
public interface MobileRentApiService {
    @GET("/client/arizona-rent/getList")
    Object getAds(Continuation<? super Response<List<ArizonaRentAdModel>>> continuation);
}
