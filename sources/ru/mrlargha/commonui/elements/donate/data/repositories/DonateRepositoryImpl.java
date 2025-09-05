package ru.mrlargha.commonui.elements.donate.data.repositories;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import retrofit2.Response;
import ru.mrlargha.commonui.elements.donate.data.remote.DonateRetrofitClient;
import ru.mrlargha.commonui.elements.donate.data.remote.apiservices.DonateApiService;
import ru.mrlargha.commonui.elements.donate.domain.ResultState;
import ru.mrlargha.commonui.elements.donate.domain.models.DonateBoostModel;
import ru.mrlargha.commonui.elements.donate.domain.models.DonateCategoryModel;
import ru.mrlargha.commonui.elements.donate.domain.models.DonateItemModel;
import ru.mrlargha.commonui.elements.donate.domain.repositories.DonateRepository;
import ru.mrlargha.commonui.utils.ProjectType;
/* compiled from: DonateRepositoryImpl.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010\n\u001a\u00020\u0007H\u0016J\u001a\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0\fH\u0096@¢\u0006\u0002\u0010\u000fJ\u001a\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\r0\fH\u0096@¢\u0006\u0002\u0010\u000fJ\u001a\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\r0\fH\u0096@¢\u0006\u0002\u0010\u000fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lru/mrlargha/commonui/elements/donate/data/repositories/DonateRepositoryImpl;", "Lru/mrlargha/commonui/elements/donate/domain/repositories/DonateRepository;", "retrofitClient", "Lru/mrlargha/commonui/elements/donate/data/remote/DonateRetrofitClient;", "serverId", "", "project", "Lru/mrlargha/commonui/utils/ProjectType;", "<init>", "(Lru/mrlargha/commonui/elements/donate/data/remote/DonateRetrofitClient;ILru/mrlargha/commonui/utils/ProjectType;)V", "getProjectType", "getCategories", "Lru/mrlargha/commonui/elements/donate/domain/ResultState;", "", "Lru/mrlargha/commonui/elements/donate/domain/models/DonateCategoryModel;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getItems", "Lru/mrlargha/commonui/elements/donate/domain/models/DonateItemModel;", "getBoost", "Lru/mrlargha/commonui/elements/donate/domain/models/DonateBoostModel;", "CommonUI_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class DonateRepositoryImpl implements DonateRepository {
    private final ProjectType project;
    private final DonateRetrofitClient retrofitClient;
    private final int serverId;

    public DonateRepositoryImpl(DonateRetrofitClient retrofitClient, int i, ProjectType project) {
        Intrinsics.checkNotNullParameter(retrofitClient, "retrofitClient");
        Intrinsics.checkNotNullParameter(project, "project");
        this.retrofitClient = retrofitClient;
        this.serverId = i;
        this.project = project;
    }

    @Override // ru.mrlargha.commonui.elements.donate.domain.repositories.DonateRepository
    public ProjectType getProjectType() {
        return this.project;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x005c A[Catch: Exception -> 0x002b, TryCatch #0 {Exception -> 0x002b, blocks: (B:11:0x0027, B:21:0x0054, B:23:0x005c, B:25:0x0066, B:26:0x006d, B:28:0x0073, B:18:0x0039), top: B:35:0x0023 }] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0073 A[Catch: Exception -> 0x002b, TRY_LEAVE, TryCatch #0 {Exception -> 0x002b, blocks: (B:11:0x0027, B:21:0x0054, B:23:0x005c, B:25:0x0066, B:26:0x006d, B:28:0x0073, B:18:0x0039), top: B:35:0x0023 }] */
    @Override // ru.mrlargha.commonui.elements.donate.domain.repositories.DonateRepository
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object getCategories(Continuation<? super ResultState<? extends List<DonateCategoryModel>>> continuation) {
        DonateRepositoryImpl$getCategories$1 donateRepositoryImpl$getCategories$1;
        int i;
        Response response;
        try {
            if (continuation instanceof DonateRepositoryImpl$getCategories$1) {
                donateRepositoryImpl$getCategories$1 = (DonateRepositoryImpl$getCategories$1) continuation;
                if ((donateRepositoryImpl$getCategories$1.label & Integer.MIN_VALUE) != 0) {
                    donateRepositoryImpl$getCategories$1.label -= Integer.MIN_VALUE;
                    DonateRepositoryImpl$getCategories$1 donateRepositoryImpl$getCategories$12 = donateRepositoryImpl$getCategories$1;
                    Object obj = donateRepositoryImpl$getCategories$12.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i = donateRepositoryImpl$getCategories$12.label;
                    if (i != 0) {
                        ResultKt.throwOnFailure(obj);
                        DonateApiService donateApiService = this.retrofitClient.getDonateApiService();
                        int i2 = this.serverId;
                        String type = this.project.getType();
                        donateRepositoryImpl$getCategories$12.label = 1;
                        obj = DonateApiService.getCategories$default(donateApiService, type, null, i2, donateRepositoryImpl$getCategories$12, 2, null);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    } else {
                        ResultKt.throwOnFailure(obj);
                    }
                    response = (Response) obj;
                    if (!response.isSuccessful()) {
                        ArrayList arrayList = (List) response.body();
                        if (arrayList == null) {
                            arrayList = new ArrayList();
                        }
                        return new ResultState.Success(arrayList);
                    }
                    String message = response.message();
                    Intrinsics.checkNotNullExpressionValue(message, "message(...)");
                    return new ResultState.Error(message, null, 2, null);
                }
            }
            if (i != 0) {
            }
            response = (Response) obj;
            if (!response.isSuccessful()) {
            }
        } catch (Exception e) {
            String message2 = e.getMessage();
            if (message2 == null) {
                message2 = "";
            }
            return new ResultState.Error(message2, e);
        }
        donateRepositoryImpl$getCategories$1 = new DonateRepositoryImpl$getCategories$1(this, continuation);
        DonateRepositoryImpl$getCategories$1 donateRepositoryImpl$getCategories$122 = donateRepositoryImpl$getCategories$1;
        Object obj2 = donateRepositoryImpl$getCategories$122.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = donateRepositoryImpl$getCategories$122.label;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x005c A[Catch: Exception -> 0x002b, TryCatch #0 {Exception -> 0x002b, blocks: (B:11:0x0027, B:21:0x0054, B:23:0x005c, B:25:0x0066, B:26:0x006d, B:28:0x0073, B:18:0x0039), top: B:35:0x0023 }] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0073 A[Catch: Exception -> 0x002b, TRY_LEAVE, TryCatch #0 {Exception -> 0x002b, blocks: (B:11:0x0027, B:21:0x0054, B:23:0x005c, B:25:0x0066, B:26:0x006d, B:28:0x0073, B:18:0x0039), top: B:35:0x0023 }] */
    @Override // ru.mrlargha.commonui.elements.donate.domain.repositories.DonateRepository
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object getItems(Continuation<? super ResultState<? extends List<DonateItemModel>>> continuation) {
        DonateRepositoryImpl$getItems$1 donateRepositoryImpl$getItems$1;
        int i;
        Response response;
        try {
            if (continuation instanceof DonateRepositoryImpl$getItems$1) {
                donateRepositoryImpl$getItems$1 = (DonateRepositoryImpl$getItems$1) continuation;
                if ((donateRepositoryImpl$getItems$1.label & Integer.MIN_VALUE) != 0) {
                    donateRepositoryImpl$getItems$1.label -= Integer.MIN_VALUE;
                    DonateRepositoryImpl$getItems$1 donateRepositoryImpl$getItems$12 = donateRepositoryImpl$getItems$1;
                    Object obj = donateRepositoryImpl$getItems$12.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i = donateRepositoryImpl$getItems$12.label;
                    if (i != 0) {
                        ResultKt.throwOnFailure(obj);
                        DonateApiService donateApiService = this.retrofitClient.getDonateApiService();
                        int i2 = this.serverId;
                        String type = this.project.getType();
                        donateRepositoryImpl$getItems$12.label = 1;
                        obj = DonateApiService.getItems$default(donateApiService, type, null, i2, donateRepositoryImpl$getItems$12, 2, null);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    } else {
                        ResultKt.throwOnFailure(obj);
                    }
                    response = (Response) obj;
                    if (!response.isSuccessful()) {
                        ArrayList arrayList = (List) response.body();
                        if (arrayList == null) {
                            arrayList = new ArrayList();
                        }
                        return new ResultState.Success(arrayList);
                    }
                    String message = response.message();
                    Intrinsics.checkNotNullExpressionValue(message, "message(...)");
                    return new ResultState.Error(message, null, 2, null);
                }
            }
            if (i != 0) {
            }
            response = (Response) obj;
            if (!response.isSuccessful()) {
            }
        } catch (Exception e) {
            String message2 = e.getMessage();
            if (message2 == null) {
                message2 = "";
            }
            return new ResultState.Error(message2, e);
        }
        donateRepositoryImpl$getItems$1 = new DonateRepositoryImpl$getItems$1(this, continuation);
        DonateRepositoryImpl$getItems$1 donateRepositoryImpl$getItems$122 = donateRepositoryImpl$getItems$1;
        Object obj2 = donateRepositoryImpl$getItems$122.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = donateRepositoryImpl$getItems$122.label;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x005c A[Catch: Exception -> 0x002b, TryCatch #0 {Exception -> 0x002b, blocks: (B:11:0x0027, B:21:0x0054, B:23:0x005c, B:25:0x0066, B:26:0x006d, B:28:0x0073, B:18:0x0039), top: B:35:0x0023 }] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0073 A[Catch: Exception -> 0x002b, TRY_LEAVE, TryCatch #0 {Exception -> 0x002b, blocks: (B:11:0x0027, B:21:0x0054, B:23:0x005c, B:25:0x0066, B:26:0x006d, B:28:0x0073, B:18:0x0039), top: B:35:0x0023 }] */
    @Override // ru.mrlargha.commonui.elements.donate.domain.repositories.DonateRepository
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object getBoost(Continuation<? super ResultState<? extends List<DonateBoostModel>>> continuation) {
        DonateRepositoryImpl$getBoost$1 donateRepositoryImpl$getBoost$1;
        int i;
        Response response;
        try {
            if (continuation instanceof DonateRepositoryImpl$getBoost$1) {
                donateRepositoryImpl$getBoost$1 = (DonateRepositoryImpl$getBoost$1) continuation;
                if ((donateRepositoryImpl$getBoost$1.label & Integer.MIN_VALUE) != 0) {
                    donateRepositoryImpl$getBoost$1.label -= Integer.MIN_VALUE;
                    DonateRepositoryImpl$getBoost$1 donateRepositoryImpl$getBoost$12 = donateRepositoryImpl$getBoost$1;
                    Object obj = donateRepositoryImpl$getBoost$12.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i = donateRepositoryImpl$getBoost$12.label;
                    if (i != 0) {
                        ResultKt.throwOnFailure(obj);
                        DonateApiService donateApiService = this.retrofitClient.getDonateApiService();
                        int i2 = this.serverId;
                        String type = this.project.getType();
                        donateRepositoryImpl$getBoost$12.label = 1;
                        obj = DonateApiService.getBoost$default(donateApiService, type, null, i2, donateRepositoryImpl$getBoost$12, 2, null);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    } else {
                        ResultKt.throwOnFailure(obj);
                    }
                    response = (Response) obj;
                    if (!response.isSuccessful()) {
                        ArrayList arrayList = (List) response.body();
                        if (arrayList == null) {
                            arrayList = new ArrayList();
                        }
                        return new ResultState.Success(arrayList);
                    }
                    String message = response.message();
                    Intrinsics.checkNotNullExpressionValue(message, "message(...)");
                    return new ResultState.Error(message, null, 2, null);
                }
            }
            if (i != 0) {
            }
            response = (Response) obj;
            if (!response.isSuccessful()) {
            }
        } catch (Exception e) {
            String message2 = e.getMessage();
            if (message2 == null) {
                message2 = "";
            }
            return new ResultState.Error(message2, e);
        }
        donateRepositoryImpl$getBoost$1 = new DonateRepositoryImpl$getBoost$1(this, continuation);
        DonateRepositoryImpl$getBoost$1 donateRepositoryImpl$getBoost$122 = donateRepositoryImpl$getBoost$1;
        Object obj2 = donateRepositoryImpl$getBoost$122.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = donateRepositoryImpl$getBoost$122.label;
    }
}
