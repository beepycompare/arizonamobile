package ru.mrlargha.feature.mobile.presentation.page.rent_accessory.pages;

import android.widget.LinearLayout;
import android.widget.ProgressBar;
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
import ru.mrlargha.feature.mobile.databinding.MobileRentAccessoryMainBinding;
import ru.mrlargha.feature.mobile.presentation.page.rent_accessory.RentAccessoryPage;
import ru.mrlargha.feature.mobile.presentation.page.rent_accessory.pages.MobileRentAccessoryMainPage;
/* compiled from: MobileRentAccessoryMainPage.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 4, 0}, xi = 48)
@DebugMetadata(c = "ru.mrlargha.feature.mobile.presentation.page.rent_accessory.pages.MobileRentAccessoryMainPage$getAds$1$1$1", f = "MobileRentAccessoryMainPage.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
/* loaded from: classes6.dex */
final class MobileRentAccessoryMainPage$getAds$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ MobileRentAccessoryMainPage this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MobileRentAccessoryMainPage$getAds$1$1$1(MobileRentAccessoryMainPage mobileRentAccessoryMainPage, Continuation<? super MobileRentAccessoryMainPage$getAds$1$1$1> continuation) {
        super(2, continuation);
        this.this$0 = mobileRentAccessoryMainPage;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new MobileRentAccessoryMainPage$getAds$1$1$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((MobileRentAccessoryMainPage$getAds$1$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        MobileRentAccessoryMainPage.Companion.TopBar topBar;
        List list;
        MobileRentAccessoryMainBinding mobileRentAccessoryMainBinding;
        MobileRentAccessoryMainBinding mobileRentAccessoryMainBinding2;
        RentAccessoryPage rentAccessoryPage;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        MobileRentAccessoryMainPage mobileRentAccessoryMainPage = this.this$0;
        topBar = mobileRentAccessoryMainPage.currentBar;
        mobileRentAccessoryMainPage.selectTopBar(topBar);
        list = this.this$0.currentAddsList;
        if (list.isEmpty()) {
            rentAccessoryPage = this.this$0.parentContainer;
            rentAccessoryPage.navigatePage(RentAccessoryPage.Companion.RentAccessoryPages.NOT_DATA);
        }
        mobileRentAccessoryMainBinding = this.this$0.bindingPage;
        LinearLayout mainContainer = mobileRentAccessoryMainBinding.mainContainer;
        Intrinsics.checkNotNullExpressionValue(mainContainer, "mainContainer");
        mainContainer.setVisibility(0);
        mobileRentAccessoryMainBinding2 = this.this$0.bindingPage;
        ProgressBar progressBar = mobileRentAccessoryMainBinding2.progressBar;
        Intrinsics.checkNotNullExpressionValue(progressBar, "progressBar");
        progressBar.setVisibility(8);
        return Unit.INSTANCE;
    }
}
