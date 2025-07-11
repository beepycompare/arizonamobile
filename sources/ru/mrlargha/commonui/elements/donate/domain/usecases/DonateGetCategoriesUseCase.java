package ru.mrlargha.commonui.elements.donate.domain.usecases;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import ru.mrlargha.commonui.elements.donate.domain.ResultState;
import ru.mrlargha.commonui.elements.donate.domain.models.DonateCategoryModel;
import ru.mrlargha.commonui.elements.donate.domain.repositories.DonateRepository;
/* compiled from: DonateGetCategoriesUseCase.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\tH\u0086B¢\u0006\u0002\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\r"}, d2 = {"Lru/mrlargha/commonui/elements/donate/domain/usecases/DonateGetCategoriesUseCase;", "", "repository", "Lru/mrlargha/commonui/elements/donate/domain/repositories/DonateRepository;", "<init>", "(Lru/mrlargha/commonui/elements/donate/domain/repositories/DonateRepository;)V", "getRepository", "()Lru/mrlargha/commonui/elements/donate/domain/repositories/DonateRepository;", "invoke", "Lru/mrlargha/commonui/elements/donate/domain/ResultState;", "", "Lru/mrlargha/commonui/elements/donate/domain/models/DonateCategoryModel;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "CommonUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class DonateGetCategoriesUseCase {
    private final DonateRepository repository;

    public DonateGetCategoriesUseCase(DonateRepository repository) {
        Intrinsics.checkNotNullParameter(repository, "repository");
        this.repository = repository;
    }

    public final DonateRepository getRepository() {
        return this.repository;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:32:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invoke(Continuation<? super ResultState<? extends List<DonateCategoryModel>>> continuation) {
        DonateGetCategoriesUseCase$invoke$1 donateGetCategoriesUseCase$invoke$1;
        int i;
        ResultState resultState;
        if (continuation instanceof DonateGetCategoriesUseCase$invoke$1) {
            donateGetCategoriesUseCase$invoke$1 = (DonateGetCategoriesUseCase$invoke$1) continuation;
            if ((donateGetCategoriesUseCase$invoke$1.label & Integer.MIN_VALUE) != 0) {
                donateGetCategoriesUseCase$invoke$1.label -= Integer.MIN_VALUE;
                Object obj = donateGetCategoriesUseCase$invoke$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = donateGetCategoriesUseCase$invoke$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    DonateRepository donateRepository = this.repository;
                    donateGetCategoriesUseCase$invoke$1.label = 1;
                    obj = donateRepository.getCategories(donateGetCategoriesUseCase$invoke$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    ResultKt.throwOnFailure(obj);
                }
                resultState = (ResultState) obj;
                if (resultState instanceof ResultState.Success) {
                    return resultState;
                }
                ArrayList arrayList = new ArrayList();
                for (Object obj2 : (Iterable) ((ResultState.Success) resultState).getData()) {
                    if (((DonateCategoryModel) obj2).getVisible() == 1) {
                        arrayList.add(obj2);
                    }
                }
                return new ResultState.Success(arrayList);
            }
        }
        donateGetCategoriesUseCase$invoke$1 = new DonateGetCategoriesUseCase$invoke$1(this, continuation);
        Object obj3 = donateGetCategoriesUseCase$invoke$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = donateGetCategoriesUseCase$invoke$1.label;
        if (i != 0) {
        }
        resultState = (ResultState) obj3;
        if (resultState instanceof ResultState.Success) {
        }
    }
}
