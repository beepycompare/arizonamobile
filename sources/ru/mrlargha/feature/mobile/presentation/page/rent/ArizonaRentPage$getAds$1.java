package ru.mrlargha.feature.mobile.presentation.page.rent;

import android.app.Activity;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import retrofit2.Response;
import ru.mrlargha.commonui.utils.UtilsKt;
import ru.mrlargha.feature.mobile.data.remote.rent.api_services.MobileRentApiService;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ArizonaRentPage.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "ru.mrlargha.feature.mobile.presentation.page.rent.ArizonaRentPage$getAds$1", f = "ArizonaRentPage.kt", i = {}, l = {319}, m = "invokeSuspend", n = {}, s = {}, v = 1)
/* loaded from: classes6.dex */
public final class ArizonaRentPage$getAds$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ ArizonaRentPage this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ArizonaRentPage$getAds$1(ArizonaRentPage arizonaRentPage, Continuation<? super ArizonaRentPage$getAds$1> continuation) {
        super(2, continuation);
        this.this$0 = arizonaRentPage;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ArizonaRentPage$getAds$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ArizonaRentPage$getAds$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        MobileRentApiService mobileRentApiService;
        Activity context;
        List list;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            mobileRentApiService = this.this$0.rentApiService;
            Intrinsics.checkNotNullExpressionValue(mobileRentApiService, "access$getRentApiService$p(...)");
            context = this.this$0.getContext();
            this.label = 1;
            obj = MobileRentApiService.getAds$default(mobileRentApiService, null, UtilsKt.getServerId(context).getServer(), this, 1, null);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            ResultKt.throwOnFailure(obj);
        }
        Response response = (Response) obj;
        if (response.isSuccessful() && (list = (List) response.body()) != null) {
            ArizonaRentPage arizonaRentPage = this.this$0;
            if (!list.isEmpty()) {
                arizonaRentPage.adList = list;
            }
            arizonaRentPage.setAdList(list);
        }
        return Unit.INSTANCE;
    }
}
