package ru.mrlargha.feature.mobile.presentation.page.rent_accessory.pages;

import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
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
import ru.mrlargha.commonui.utils.ui.CustomCardView;
import ru.mrlargha.feature.mobile.R;
import ru.mrlargha.feature.mobile.databinding.MobileRentAccessoryMainBinding;
import ru.mrlargha.feature.mobile.presentation.page.rent_accessory.RentAccessoryPage;
/* compiled from: MobileRentAccessoryMainPage.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 4, 0}, xi = 48)
@DebugMetadata(c = "ru.mrlargha.feature.mobile.presentation.page.rent_accessory.pages.MobileRentAccessoryMainPage$checkUpdate$1$1$1$1", f = "MobileRentAccessoryMainPage.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
/* loaded from: classes6.dex */
final class MobileRentAccessoryMainPage$checkUpdate$1$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ MobileRentAccessoryMainPage this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MobileRentAccessoryMainPage$checkUpdate$1$1$1$1(MobileRentAccessoryMainPage mobileRentAccessoryMainPage, Continuation<? super MobileRentAccessoryMainPage$checkUpdate$1$1$1$1> continuation) {
        super(2, continuation);
        this.this$0 = mobileRentAccessoryMainPage;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new MobileRentAccessoryMainPage$checkUpdate$1$1$1$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((MobileRentAccessoryMainPage$checkUpdate$1$1$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        MobileRentAccessoryMainBinding mobileRentAccessoryMainBinding;
        RentAccessoryPage rentAccessoryPage;
        MobileRentAccessoryMainBinding mobileRentAccessoryMainBinding2;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            mobileRentAccessoryMainBinding = this.this$0.bindingPage;
            CustomCardView btnUpdate = mobileRentAccessoryMainBinding.btnUpdate;
            Intrinsics.checkNotNullExpressionValue(btnUpdate, "btnUpdate");
            btnUpdate.setVisibility(0);
            rentAccessoryPage = this.this$0.parentContainer;
            Animation loadAnimation = AnimationUtils.loadAnimation(rentAccessoryPage.getTargetActivity(), R.anim.progress_down);
            mobileRentAccessoryMainBinding2 = this.this$0.bindingPage;
            mobileRentAccessoryMainBinding2.btnUpdate.startAnimation(loadAnimation);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
