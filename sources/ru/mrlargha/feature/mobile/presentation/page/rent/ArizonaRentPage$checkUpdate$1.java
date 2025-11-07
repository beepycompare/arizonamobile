package ru.mrlargha.feature.mobile.presentation.page.rent;

import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import retrofit2.Response;
import ru.mrlargha.commonui.utils.ui.CustomCardView;
import ru.mrlargha.feature.mobile.data.remote.MobileRetrofitClient;
import ru.mrlargha.feature.mobile.databinding.MpArizonaRentPageBinding;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ArizonaRentPage.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "ru.mrlargha.feature.mobile.presentation.page.rent.ArizonaRentPage$checkUpdate$1", f = "ArizonaRentPage.kt", i = {1}, l = {332, 347}, m = "invokeSuspend", n = {"data"}, s = {"L$0"}, v = 1)
/* loaded from: classes6.dex */
public final class ArizonaRentPage$checkUpdate$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    Object L$0;
    int label;
    final /* synthetic */ ArizonaRentPage this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ArizonaRentPage$checkUpdate$1(ArizonaRentPage arizonaRentPage, Continuation<? super ArizonaRentPage$checkUpdate$1> continuation) {
        super(2, continuation);
        this.this$0 = arizonaRentPage;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ArizonaRentPage$checkUpdate$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ArizonaRentPage$checkUpdate$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0039, code lost:
        if (r6 == r0) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x009a, code lost:
        if (kotlinx.coroutines.DelayKt.delay(5000, r5) == r0) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x009c, code lost:
        return r0;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        MobileRetrofitClient mobileRetrofitClient;
        boolean isOpen;
        List list;
        List list2;
        List list3;
        MpArizonaRentPageBinding mpArizonaRentPageBinding;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            mobileRetrofitClient = this.this$0.retrofitClient;
            this.label = 1;
            obj = mobileRetrofitClient.getRentApiService().getAds(this);
        } else if (i != 1) {
            if (i == 2) {
                Response response = (Response) this.L$0;
                ResultKt.throwOnFailure(obj);
                this.this$0.checkUpdate();
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            ResultKt.throwOnFailure(obj);
        }
        Response response2 = (Response) obj;
        if (response2.isSuccessful() && (list = (List) response2.body()) != null) {
            ArizonaRentPage arizonaRentPage = this.this$0;
            if (!list.isEmpty()) {
                list2 = arizonaRentPage.adList;
                if (list2 == null) {
                    arizonaRentPage.getAds();
                } else {
                    list3 = arizonaRentPage.adList;
                    if (!Intrinsics.areEqual(list, list3)) {
                        arizonaRentPage.hasUpdate();
                    } else {
                        mpArizonaRentPageBinding = arizonaRentPage.binding;
                        CustomCardView btnUpdate = mpArizonaRentPageBinding.btnUpdate;
                        Intrinsics.checkNotNullExpressionValue(btnUpdate, "btnUpdate");
                        btnUpdate.setVisibility(8);
                    }
                }
            }
        }
        isOpen = this.this$0.isOpen();
        if (isOpen) {
            this.L$0 = SpillingKt.nullOutSpilledVariable(response2);
            this.label = 2;
        }
        return Unit.INSTANCE;
    }
}
