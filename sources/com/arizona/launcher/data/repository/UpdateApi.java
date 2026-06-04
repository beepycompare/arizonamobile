package com.arizona.launcher.data.repository;

import com.arizona.launcher.model.UpdateStatusData;
import io.reactivex.Single;
import kotlin.Metadata;
import retrofit2.http.GET;
/* compiled from: UpdateApi.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H'b\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007¨\u0006\bÀ\u0006\u0003"}, d2 = {"Lcom/arizona/launcher/data/repository/UpdateApi;", "", "getUpdateStatus", "Lio/reactivex/Single;", "Lcom/arizona/launcher/model/UpdateStatusData;", "Lretrofit2/http/GET;", "value", "version.json", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface UpdateApi {
    @GET("version.json")
    Single<UpdateStatusData> getUpdateStatus();
}
