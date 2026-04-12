package ru.mrlargha.feature.mobile.data.remote;

import android.app.Activity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ru.mrlargha.commonui.utils.TokenManagerKt;
import ru.mrlargha.commonui.utils.ui.ArizonaRetrofit;
import ru.mrlargha.feature.mobile.data.remote.api_services.rent.MobileRentApiService;
import ru.mrlargha.feature.mobile.data.remote.api_services.rent_accessory.MobileRentAccessoryApiService;
/* compiled from: MobileRetrofitClient.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lru/mrlargha/feature/mobile/data/remote/MobileRetrofitClient;", "", "targetActivity", "Landroid/app/Activity;", "backendId", "", "<init>", "(Landroid/app/Activity;I)V", "retrofit", "Lru/mrlargha/commonui/utils/ui/ArizonaRetrofit;", "getRetrofit", "()Lru/mrlargha/commonui/utils/ui/ArizonaRetrofit;", "rentApiService", "Lru/mrlargha/feature/mobile/data/remote/api_services/rent/MobileRentApiService;", "getRentApiService", "()Lru/mrlargha/feature/mobile/data/remote/api_services/rent/MobileRentApiService;", "rentAccessoryApiService", "Lru/mrlargha/feature/mobile/data/remote/api_services/rent_accessory/MobileRentAccessoryApiService;", "getRentAccessoryApiService", "()Lru/mrlargha/feature/mobile/data/remote/api_services/rent_accessory/MobileRentAccessoryApiService;", "mobile"}, k = 1, mv = {2, 3, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class MobileRetrofitClient {
    private final MobileRentAccessoryApiService rentAccessoryApiService;
    private final MobileRentApiService rentApiService;
    private final ArizonaRetrofit retrofit;

    public MobileRetrofitClient(Activity targetActivity, int i) {
        Intrinsics.checkNotNullParameter(targetActivity, "targetActivity");
        ArizonaRetrofit arizonaRetrofit = new ArizonaRetrofit(targetActivity, i);
        this.retrofit = arizonaRetrofit;
        this.rentApiService = (MobileRentApiService) ArizonaRetrofit.create$default(arizonaRetrofit, MobileRentApiService.class, TokenManagerKt.getServerId() == 0, null, null, 12, null);
        this.rentAccessoryApiService = (MobileRentAccessoryApiService) ArizonaRetrofit.create$default(arizonaRetrofit, MobileRentAccessoryApiService.class, true, null, null, 12, null);
    }

    public final ArizonaRetrofit getRetrofit() {
        return this.retrofit;
    }

    public final MobileRentApiService getRentApiService() {
        return this.rentApiService;
    }

    public final MobileRentAccessoryApiService getRentAccessoryApiService() {
        return this.rentAccessoryApiService;
    }
}
