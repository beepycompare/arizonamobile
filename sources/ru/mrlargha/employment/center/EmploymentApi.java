package ru.mrlargha.employment.center;

import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import retrofit2.http.GET;
/* compiled from: EmploymentApi.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H§@b\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b¢\u0006\u0002\u0010\u0005¨\u0006\tÀ\u0006\u0003"}, d2 = {"Lru/mrlargha/employment/center/EmploymentApi;", "", "getAll", "", "Lru/mrlargha/employment/center/Job;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lretrofit2/http/GET;", "value", "client/employment-center/getList", "employment-center"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public interface EmploymentApi {
    @GET("client/employment-center/getList")
    Object getAll(Continuation<? super List<Job>> continuation);
}
