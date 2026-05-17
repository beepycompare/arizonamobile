package ru.mrlargha.arizonaui.mobile.presentation;

import android.view.animation.Animation;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import ru.mrlargha.feature.mobile.domain.enums.MobilePhonePage;
import ru.mrlargha.feature.mobile.presentation.HistoryManager;
import ru.mrlargha.feature.mobile.presentation.MobileController;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MobilePhone.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
@DebugMetadata(c = "ru.mrlargha.arizonaui.mobile.presentation.MobilePhone$setVisibility$1", f = "MobilePhone.kt", i = {}, l = {103}, m = "invokeSuspend", n = {}, nl = {104}, s = {}, v = 2)
/* loaded from: classes6.dex */
public final class MobilePhone$setVisibility$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $visible;
    int label;
    final /* synthetic */ MobilePhone this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MobilePhone$setVisibility$1(MobilePhone mobilePhone, boolean z, Continuation<? super MobilePhone$setVisibility$1> continuation) {
        super(2, continuation);
        this.this$0 = mobilePhone;
        this.$visible = z;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new MobilePhone$setVisibility$1(this.this$0, this.$visible, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((MobilePhone$setVisibility$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        ConstraintLayout constraintLayout;
        Animation animation;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            constraintLayout = this.this$0.mobilePhone;
            animation = this.this$0.animationClose;
            constraintLayout.startAnimation(animation);
            this.label = 1;
            if (DelayKt.delay(250L, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            ResultKt.throwOnFailure(obj);
        }
        if (!HistoryManager.Companion.getHistoryManager().isEmpty()) {
            MobileController pageIfExist = HistoryManager.Companion.getPageIfExist(MobilePhonePage.MESSENGER_CHAT.getId());
            if (pageIfExist != null) {
                pageIfExist.removePage();
            }
            Integer history = HistoryManager.Companion.getHistory();
            if (history != null) {
                MobileController pageIfExist2 = HistoryManager.Companion.getPageIfExist(history.intValue());
                if (pageIfExist2 != null) {
                    pageIfExist2.removePage();
                }
            }
            Integer history2 = HistoryManager.Companion.getHistory();
            if (history2 != null) {
                HistoryManager.Companion.clearHistoryByKey(history2.intValue());
            }
            HistoryManager.Companion.getOrCreatePage(0);
        }
        HistoryManager.Companion.clearAllPage();
        super/*ru.mrlargha.commonui.core.SAMPUIElement*/.setVisibility(this.$visible);
        return Unit.INSTANCE;
    }
}
