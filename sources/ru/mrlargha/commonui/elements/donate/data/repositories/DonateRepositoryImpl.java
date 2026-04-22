package ru.mrlargha.commonui.elements.donate.data.repositories;

import android.app.Activity;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
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
/* compiled from: DonateRepositoryImpl.kt */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012J\u001a\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0014H\u0096@¢\u0006\u0002\u0010\u0015J\u001a\u0010\u0016\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u00070\u0014H\u0096@¢\u0006\u0002\u0010\u0015J\u001a\u0010\u0017\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u00070\u0014H\u0096@¢\u0006\u0002\u0010\u0015R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lru/mrlargha/commonui/elements/donate/data/repositories/DonateRepositoryImpl;", "Lru/mrlargha/commonui/elements/donate/domain/repositories/DonateRepository;", "<init>", "()V", "retrofitClient", "Lru/mrlargha/commonui/elements/donate/data/remote/DonateRetrofitClient;", "categoryList", "", "Lru/mrlargha/commonui/elements/donate/domain/models/DonateCategoryModel;", "itemsList", "Lru/mrlargha/commonui/elements/donate/domain/models/DonateItemModel;", "boostList", "Lru/mrlargha/commonui/elements/donate/domain/models/DonateBoostModel;", "setParams", "", "targetActivity", "Landroid/app/Activity;", "backendId", "", "getCategories", "Lru/mrlargha/commonui/elements/donate/domain/ResultState;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getItems", "getBoost", "CommonUI"}, k = 1, mv = {2, 3, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class DonateRepositoryImpl implements DonateRepository {
    private static DonateRetrofitClient retrofitClient;
    public static final DonateRepositoryImpl INSTANCE = new DonateRepositoryImpl();
    private static List<DonateCategoryModel> categoryList = CollectionsKt.emptyList();
    private static List<DonateItemModel> itemsList = CollectionsKt.emptyList();
    private static List<DonateBoostModel> boostList = CollectionsKt.emptyList();

    private DonateRepositoryImpl() {
    }

    public final void setParams(Activity targetActivity, int i) {
        Intrinsics.checkNotNullParameter(targetActivity, "targetActivity");
        retrofitClient = new DonateRetrofitClient(targetActivity, i);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0067 A[Catch: Exception -> 0x0091, TryCatch #0 {Exception -> 0x0091, blocks: (B:11:0x0027, B:25:0x005f, B:27:0x0067, B:29:0x006f, B:30:0x0073, B:32:0x007f, B:19:0x0048, B:21:0x004c, B:22:0x0052), top: B:40:0x0023 }] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x007f A[Catch: Exception -> 0x0091, TRY_LEAVE, TryCatch #0 {Exception -> 0x0091, blocks: (B:11:0x0027, B:25:0x005f, B:27:0x0067, B:29:0x006f, B:30:0x0073, B:32:0x007f, B:19:0x0048, B:21:0x004c, B:22:0x0052), top: B:40:0x0023 }] */
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
                    Object obj = donateRepositoryImpl$getCategories$1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i = donateRepositoryImpl$getCategories$1.label;
                    if (i != 0) {
                        ResultKt.throwOnFailure(obj);
                        if (!categoryList.isEmpty()) {
                            return new ResultState.Success(categoryList);
                        }
                        DonateRetrofitClient donateRetrofitClient = retrofitClient;
                        if (donateRetrofitClient == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("retrofitClient");
                            donateRetrofitClient = null;
                        }
                        DonateApiService donateApiService = donateRetrofitClient.getDonateApiService();
                        donateRepositoryImpl$getCategories$1.label = 1;
                        obj = DonateApiService.getCategories$default(donateApiService, null, donateRepositoryImpl$getCategories$1, 1, null);
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
                        List<DonateCategoryModel> list = (List) response.body();
                        if (list == null) {
                            list = CollectionsKt.emptyList();
                        }
                        categoryList = list;
                        return new ResultState.Success(categoryList);
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
        Object obj2 = donateRepositoryImpl$getCategories$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = donateRepositoryImpl$getCategories$1.label;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0067 A[Catch: Exception -> 0x0091, TryCatch #0 {Exception -> 0x0091, blocks: (B:11:0x0027, B:25:0x005f, B:27:0x0067, B:29:0x006f, B:30:0x0073, B:32:0x007f, B:19:0x0048, B:21:0x004c, B:22:0x0052), top: B:40:0x0023 }] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x007f A[Catch: Exception -> 0x0091, TRY_LEAVE, TryCatch #0 {Exception -> 0x0091, blocks: (B:11:0x0027, B:25:0x005f, B:27:0x0067, B:29:0x006f, B:30:0x0073, B:32:0x007f, B:19:0x0048, B:21:0x004c, B:22:0x0052), top: B:40:0x0023 }] */
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
                    Object obj = donateRepositoryImpl$getItems$1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i = donateRepositoryImpl$getItems$1.label;
                    if (i != 0) {
                        ResultKt.throwOnFailure(obj);
                        if (!itemsList.isEmpty()) {
                            return new ResultState.Success(itemsList);
                        }
                        DonateRetrofitClient donateRetrofitClient = retrofitClient;
                        if (donateRetrofitClient == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("retrofitClient");
                            donateRetrofitClient = null;
                        }
                        DonateApiService donateApiService = donateRetrofitClient.getDonateApiService();
                        donateRepositoryImpl$getItems$1.label = 1;
                        obj = DonateApiService.getItems$default(donateApiService, null, donateRepositoryImpl$getItems$1, 1, null);
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
                        List<DonateItemModel> list = (List) response.body();
                        if (list == null) {
                            list = CollectionsKt.emptyList();
                        }
                        itemsList = list;
                        return new ResultState.Success(itemsList);
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
        Object obj2 = donateRepositoryImpl$getItems$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = donateRepositoryImpl$getItems$1.label;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0067 A[Catch: Exception -> 0x0091, TryCatch #0 {Exception -> 0x0091, blocks: (B:11:0x0027, B:25:0x005f, B:27:0x0067, B:29:0x006f, B:30:0x0073, B:32:0x007f, B:19:0x0048, B:21:0x004c, B:22:0x0052), top: B:40:0x0023 }] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x007f A[Catch: Exception -> 0x0091, TRY_LEAVE, TryCatch #0 {Exception -> 0x0091, blocks: (B:11:0x0027, B:25:0x005f, B:27:0x0067, B:29:0x006f, B:30:0x0073, B:32:0x007f, B:19:0x0048, B:21:0x004c, B:22:0x0052), top: B:40:0x0023 }] */
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
                    Object obj = donateRepositoryImpl$getBoost$1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i = donateRepositoryImpl$getBoost$1.label;
                    if (i != 0) {
                        ResultKt.throwOnFailure(obj);
                        if (!boostList.isEmpty()) {
                            return new ResultState.Success(boostList);
                        }
                        DonateRetrofitClient donateRetrofitClient = retrofitClient;
                        if (donateRetrofitClient == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("retrofitClient");
                            donateRetrofitClient = null;
                        }
                        DonateApiService donateApiService = donateRetrofitClient.getDonateApiService();
                        donateRepositoryImpl$getBoost$1.label = 1;
                        obj = DonateApiService.getBoost$default(donateApiService, null, donateRepositoryImpl$getBoost$1, 1, null);
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
                        List<DonateBoostModel> list = (List) response.body();
                        if (list == null) {
                            list = CollectionsKt.emptyList();
                        }
                        boostList = list;
                        return new ResultState.Success(boostList);
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
        Object obj2 = donateRepositoryImpl$getBoost$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = donateRepositoryImpl$getBoost$1.label;
    }
}
