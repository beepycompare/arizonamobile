package ru.mrlargha.commonui.elements.authorization.presentation.api;

import java.util.List;
import kotlin.Metadata;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import ru.mrlargha.commonui.elements.authorization.presentation.api.obj.ProjectData;
/* compiled from: NewsApi.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0014\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0003H'¨\u0006\u0006À\u0006\u0003"}, d2 = {"Lru/mrlargha/commonui/elements/authorization/presentation/api/NewsApi;", "", "getNews", "Lretrofit2/Call;", "", "Lru/mrlargha/commonui/elements/authorization/presentation/api/obj/ProjectData;", "CommonUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public interface NewsApi {
    @Headers({"Content-Type: application/json"})
    @GET("launcher/projects-data")
    Call<List<ProjectData>> getNews();
}
