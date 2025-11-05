package ru.mrlargha.feature.mobile.data.remote.rent.api_services;

import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Query;
import ru.mrlargha.commonui.utils.ProjectType;
import ru.mrlargha.feature.mobile.presentation.page.rent.models.ArizonaRentAdModel;
/* compiled from: MobileRentApiService.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J.\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\b\b\u0003\u0010\u0006\u001a\u00020\u00072\b\b\u0003\u0010\b\u001a\u00020\tH§@¢\u0006\u0002\u0010\n¨\u0006\u000bÀ\u0006\u0003"}, d2 = {"Lru/mrlargha/feature/mobile/data/remote/rent/api_services/MobileRentApiService;", "", "getAds", "Lretrofit2/Response;", "", "Lru/mrlargha/feature/mobile/presentation/page/rent/models/ArizonaRentAdModel;", "project", "", "serverId", "", "(Ljava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "mobile_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes6.dex */
public interface MobileRentApiService {
    @GET("client/arizona-rent/getList")
    Object getAds(@Query("project") String str, @Query("server") int i, Continuation<? super Response<List<ArizonaRentAdModel>>> continuation);

    /* compiled from: MobileRentApiService.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class DefaultImpls {
    }

    static /* synthetic */ Object getAds$default(MobileRentApiService mobileRentApiService, String str, int i, Continuation continuation, int i2, Object obj) {
        if (obj == null) {
            if ((i2 & 1) != 0) {
                str = ProjectType.ARIZONA.getType();
            }
            if ((i2 & 2) != 0) {
                i = 0;
            }
            return mobileRentApiService.getAds(str, i, continuation);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getAds");
    }
}
