package ru.mrlargha.commonui.elements.hud.presentation.api;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import retrofit2.http.GET;
import ru.mrlargha.commonui.elements.hud.presentation.api.obj.HudApiRequest;
/* compiled from: HudApi.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u000e\u0010\u0002\u001a\u00020\u0003H§@¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0005\u001a\u00020\u0003H§@¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0006\u001a\u00020\u0003H§@¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0007\u001a\u00020\u0003H§@¢\u0006\u0002\u0010\u0004¨\u0006\bÀ\u0006\u0003"}, d2 = {"Lru/mrlargha/commonui/elements/hud/presentation/api/HudApi;", "", "getArizonaPcServerInfo", "Lru/mrlargha/commonui/elements/hud/presentation/api/obj/HudApiRequest;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getArizonaMobileServerInfo", "getRodinaMobileServerInfo", "getRodinaServerInfo", "CommonUI_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes6.dex */
public interface HudApi {
    @GET("desktop/ping/Arizona-Mobile/ping.json")
    Object getArizonaMobileServerInfo(Continuation<? super HudApiRequest> continuation);

    @GET("desktop/ping/Arizona/ping.json")
    Object getArizonaPcServerInfo(Continuation<? super HudApiRequest> continuation);

    @GET("desktop/ping/Rodina-Mobile/ping.json")
    Object getRodinaMobileServerInfo(Continuation<? super HudApiRequest> continuation);

    @GET("desktop/ping/Rodina/ping.json")
    Object getRodinaServerInfo(Continuation<? super HudApiRequest> continuation);
}
