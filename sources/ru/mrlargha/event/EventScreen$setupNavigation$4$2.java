package ru.mrlargha.event;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.widget.FrameLayout;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import ru.mrlargha.feature.event.R;
import ru.mrlargha.feature.event.databinding.EventShopSceenBinding;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: EventScreen.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "ru.mrlargha.event.EventScreen$setupNavigation$4$2", f = "EventScreen.kt", i = {}, l = {645}, m = "invokeSuspend", n = {}, s = {}, v = 1)
/* loaded from: classes3.dex */
public final class EventScreen$setupNavigation$4$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ EventShopSceenBinding $this_apply;
    int label;
    final /* synthetic */ EventScreen this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EventScreen$setupNavigation$4$2(EventShopSceenBinding eventShopSceenBinding, EventScreen eventScreen, Continuation<? super EventScreen$setupNavigation$4$2> continuation) {
        super(2, continuation);
        this.$this_apply = eventShopSceenBinding;
        this.this$0 = eventScreen;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new EventScreen$setupNavigation$4$2(this.$this_apply, this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((EventScreen$setupNavigation$4$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Activity targetActivity;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            obj = BuildersKt.withContext(Dispatchers.getIO(), new EventScreen$setupNavigation$4$2$bitmap$1(null), this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            ResultKt.throwOnFailure(obj);
        }
        Bitmap bitmap = (Bitmap) obj;
        if (bitmap != null) {
            EventShopSceenBinding eventShopSceenBinding = this.$this_apply;
            EventScreen eventScreen = this.this$0;
            FrameLayout frameLayout = eventShopSceenBinding.itemTop1;
            targetActivity = eventScreen.getTargetActivity();
            Resources resources = targetActivity.getResources();
            Intrinsics.checkNotNullExpressionValue(resources, "getResources(...)");
            frameLayout.setBackground(new BitmapDrawable(resources, bitmap));
        }
        if (bitmap == null) {
            this.$this_apply.itemTop1.setBackgroundResource(R.drawable.event_shop_first_place_bg);
        }
        return Unit.INSTANCE;
    }
}
