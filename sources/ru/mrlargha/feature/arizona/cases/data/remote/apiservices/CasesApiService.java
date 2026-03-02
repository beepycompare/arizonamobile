package ru.mrlargha.feature.arizona.cases.data.remote.apiservices;

import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;
import retrofit2.http.GET;
import retrofit2.http.Query;
import ru.mrlargha.feature.arizona.cases.data.remote.models.CasesModel;
/* compiled from: CasesApiService.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H'J\u001e\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\b2\b\b\u0003\u0010\t\u001a\u00020\u0006H§@¢\u0006\u0002\u0010\n¨\u0006\u000bÀ\u0006\u0003"}, d2 = {"Lru/mrlargha/feature/arizona/cases/data/remote/apiservices/CasesApiService;", "", "getCasesSimilar", "Lkotlinx/coroutines/flow/Flow;", "Lru/mrlargha/feature/arizona/cases/data/remote/models/CasesModel;", "key", "", "getCases", "", "queryKey", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "cases"}, k = 1, mv = {2, 3, 0}, xi = 48)
/* loaded from: classes6.dex */
public interface CasesApiService {
    @GET("client/json/table/get")
    Object getCases(@Query("key") String str, Continuation<? super List<CasesModel>> continuation);

    @GET("client/json/table/get")
    Flow<CasesModel> getCasesSimilar(@Query("key") String str);

    /* compiled from: CasesApiService.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class DefaultImpls {
    }

    static /* synthetic */ Object getCases$default(CasesApiService casesApiService, String str, Continuation continuation, int i, Object obj) {
        if (obj == null) {
            if ((i & 1) != 0) {
                str = "cases";
            }
            return casesApiService.getCases(str, continuation);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getCases");
    }
}
