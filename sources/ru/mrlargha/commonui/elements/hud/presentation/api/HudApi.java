package ru.mrlargha.commonui.elements.hud.presentation.api;

import kotlin.Metadata;
import retrofit2.Call;
import retrofit2.http.GET;
import ru.mrlargha.commonui.elements.hud.presentation.api.obj.HudApiRequest;
/* compiled from: HudApi.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u000e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H'J\u000e\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H'J\u000e\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H'J\u000e\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H'¨\u0006\b"}, d2 = {"Lru/mrlargha/commonui/elements/hud/presentation/api/HudApi;", "", "getArizonaPcServerInfo", "Lretrofit2/Call;", "Lru/mrlargha/commonui/elements/hud/presentation/api/obj/HudApiRequest;", "getArizonaMobileServerInfo", "getRodinaMobileServerInfo", "getRodinaServerInfo", "CommonUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public interface HudApi {
    @GET("desktop/ping/Arizona-Mobile/ping.json")
    Call<HudApiRequest> getArizonaMobileServerInfo();

    @GET("desktop/ping/Arizona/ping.json")
    Call<HudApiRequest> getArizonaPcServerInfo();

    @GET("desktop/ping/Rodina-Mobile/ping.json")
    Call<HudApiRequest> getRodinaMobileServerInfo();

    @GET("desktop/ping/Rodina/ping.json")
    Call<HudApiRequest> getRodinaServerInfo();
}
