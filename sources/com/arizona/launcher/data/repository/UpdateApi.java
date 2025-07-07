package com.arizona.launcher.data.repository;

import com.arizona.launcher.model.UpdateStatusData;
import io.reactivex.Single;
import kotlin.Metadata;
import retrofit2.http.GET;
/* compiled from: UpdateApi.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u000e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H'¨\u0006\u0005"}, d2 = {"Lcom/arizona/launcher/data/repository/UpdateApi;", "", "getUpdateStatus", "Lio/reactivex/Single;", "Lcom/arizona/launcher/model/UpdateStatusData;", "app_arizonaRelease_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface UpdateApi {
    @GET("version.json")
    Single<UpdateStatusData> getUpdateStatus();
}
