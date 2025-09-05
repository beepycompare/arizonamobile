package ru.mrlargha.commonui.elements.employmentNote.presentation;

import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;
import ru.mrlargha.commonui.elements.employmentNote.domain.FractionTasks;
/* compiled from: TaskApi.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J<\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\u00062\b\b\u0001\u0010\b\u001a\u00020\t2\b\b\u0003\u0010\n\u001a\u00020\u0006H§@¢\u0006\u0002\u0010\u000b¨\u0006\fÀ\u0006\u0003"}, d2 = {"Lru/mrlargha/commonui/elements/employmentNote/presentation/TaskApi;", "", "get", "", "Lru/mrlargha/commonui/elements/employmentNote/domain/FractionTasks;", "token", "", "project", "id", "", "key", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "CommonUI_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public interface TaskApi {
    @GET("/client/json/table/get")
    Object get(@Header("Authorization") String str, @Query("project") String str2, @Query("server") int i, @Query("key") String str3, Continuation<? super List<FractionTasks>> continuation);

    /* compiled from: TaskApi.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class DefaultImpls {
    }

    static /* synthetic */ Object get$default(TaskApi taskApi, String str, String str2, int i, String str3, Continuation continuation, int i2, Object obj) {
        if (obj == null) {
            if ((i2 & 8) != 0) {
                str3 = "fraction_tasks";
            }
            return taskApi.get(str, str2, i, str3, continuation);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: get");
    }
}
