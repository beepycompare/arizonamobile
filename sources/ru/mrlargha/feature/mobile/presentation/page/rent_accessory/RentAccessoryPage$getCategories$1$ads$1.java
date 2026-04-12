package ru.mrlargha.feature.mobile.presentation.page.rent_accessory;

import androidx.media3.extractor.ts.TsExtractor;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import retrofit2.Response;
import ru.mrlargha.feature.mobile.data.remote.MobileRetrofitClient;
import ru.mrlargha.feature.mobile.presentation.page.rent_accessory.models.MobileRentAccessoryCategoryModel;
/* compiled from: RentAccessoryPage.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001*\u00020\u0004H\n"}, d2 = {"<anonymous>", "Lretrofit2/Response;", "", "Lru/mrlargha/feature/mobile/presentation/page/rent_accessory/models/MobileRentAccessoryCategoryModel;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
@DebugMetadata(c = "ru.mrlargha.feature.mobile.presentation.page.rent_accessory.RentAccessoryPage$getCategories$1$ads$1", f = "RentAccessoryPage.kt", i = {}, l = {TsExtractor.TS_STREAM_TYPE_E_AC3}, m = "invokeSuspend", n = {}, nl = {-1}, s = {}, v = 2)
/* loaded from: classes6.dex */
final class RentAccessoryPage$getCategories$1$ads$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Response<List<? extends MobileRentAccessoryCategoryModel>>>, Object> {
    int label;
    final /* synthetic */ RentAccessoryPage this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RentAccessoryPage$getCategories$1$ads$1(RentAccessoryPage rentAccessoryPage, Continuation<? super RentAccessoryPage$getCategories$1$ads$1> continuation) {
        super(2, continuation);
        this.this$0 = rentAccessoryPage;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new RentAccessoryPage$getCategories$1$ads$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Continuation<? super Response<List<? extends MobileRentAccessoryCategoryModel>>> continuation) {
        return invoke2(coroutineScope, (Continuation<? super Response<List<MobileRentAccessoryCategoryModel>>>) continuation);
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope coroutineScope, Continuation<? super Response<List<MobileRentAccessoryCategoryModel>>> continuation) {
        return ((RentAccessoryPage$getCategories$1$ads$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        MobileRetrofitClient mobileRetrofitClient;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i != 0) {
            if (i == 1) {
                ResultKt.throwOnFailure(obj);
                return obj;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        mobileRetrofitClient = this.this$0.retrofitClient;
        this.label = 1;
        Object categories = mobileRetrofitClient.getRentAccessoryApiService().getCategories(this);
        return categories == coroutine_suspended ? coroutine_suspended : categories;
    }
}
