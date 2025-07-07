package ru.mrlargha.arizonaui.donate.presentation.api;

import java.util.List;
import kotlin.Metadata;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;
import ru.mrlargha.arizonaui.donate.domain.obj.DonateItem;
/* compiled from: DonateApi.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\u001e\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\b\b\u0001\u0010\u0006\u001a\u00020\u0007H'¨\u0006\b"}, d2 = {"Lru/mrlargha/arizonaui/donate/presentation/api/DonateApi;", "", "getDonateItems", "Lretrofit2/Call;", "", "Lru/mrlargha/arizonaui/donate/domain/obj/DonateItem;", "url", "", "ArizonaUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public interface DonateApi {
    @Headers({"Content-Type: application/json"})
    @GET("{url}")
    Call<List<DonateItem>> getDonateItems(@Path("url") String str);
}
