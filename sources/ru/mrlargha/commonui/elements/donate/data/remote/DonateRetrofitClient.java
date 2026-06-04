package ru.mrlargha.commonui.elements.donate.data.remote;

import android.app.Activity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ru.mrlargha.commonui.elements.donate.data.remote.apiservices.DonateApiService;
import ru.mrlargha.commonui.utils.ui.ArizonaRetrofit;
/* compiled from: DonateRetrofitClient.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lru/mrlargha/commonui/elements/donate/data/remote/DonateRetrofitClient;", "", "targetActivity", "Landroid/app/Activity;", "backendID", "", "<init>", "(Landroid/app/Activity;I)V", "client", "Lru/mrlargha/commonui/utils/ui/ArizonaRetrofit;", "getClient", "()Lru/mrlargha/commonui/utils/ui/ArizonaRetrofit;", "donateApiService", "Lru/mrlargha/commonui/elements/donate/data/remote/apiservices/DonateApiService;", "getDonateApiService", "()Lru/mrlargha/commonui/elements/donate/data/remote/apiservices/DonateApiService;", "CommonUI"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class DonateRetrofitClient {
    private final ArizonaRetrofit client;
    private final DonateApiService donateApiService;

    public DonateRetrofitClient(Activity targetActivity, int i) {
        Intrinsics.checkNotNullParameter(targetActivity, "targetActivity");
        ArizonaRetrofit arizonaRetrofit = new ArizonaRetrofit(targetActivity, i);
        this.client = arizonaRetrofit;
        this.donateApiService = (DonateApiService) ArizonaRetrofit.create$default(arizonaRetrofit, DonateApiService.class, false, null, null, 14, null);
    }

    public final ArizonaRetrofit getClient() {
        return this.client;
    }

    public final DonateApiService getDonateApiService() {
        return this.donateApiService;
    }
}
