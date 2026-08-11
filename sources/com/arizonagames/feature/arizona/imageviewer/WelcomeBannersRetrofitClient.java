package com.arizonagames.feature.arizona.imageviewer;

import android.content.Context;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ru.mrlargha.commonui.utils.ui.ArizonaRetrofit;
/* compiled from: WelcomeBannersApi.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/arizonagames/feature/arizona/imageviewer/WelcomeBannersRetrofitClient;", "", "context", "Landroid/content/Context;", "backendId", "", "<init>", "(Landroid/content/Context;I)V", "retrofit", "Lru/mrlargha/commonui/utils/ui/ArizonaRetrofit;", "getRetrofit", "()Lru/mrlargha/commonui/utils/ui/ArizonaRetrofit;", "apiService", "Lcom/arizonagames/feature/arizona/imageviewer/WelcomeBannersApi;", "getApiService", "()Lcom/arizonagames/feature/arizona/imageviewer/WelcomeBannersApi;", "image-viewer"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class WelcomeBannersRetrofitClient {
    private final WelcomeBannersApi apiService;
    private final ArizonaRetrofit retrofit;

    public WelcomeBannersRetrofitClient(Context context, int i) {
        Intrinsics.checkNotNullParameter(context, "context");
        ArizonaRetrofit arizonaRetrofit = new ArizonaRetrofit(context, i);
        this.retrofit = arizonaRetrofit;
        this.apiService = (WelcomeBannersApi) ArizonaRetrofit.create$default(arizonaRetrofit, WelcomeBannersApi.class, false, null, null, 14, null);
    }

    public final ArizonaRetrofit getRetrofit() {
        return this.retrofit;
    }

    public final WelcomeBannersApi getApiService() {
        return this.apiService;
    }
}
