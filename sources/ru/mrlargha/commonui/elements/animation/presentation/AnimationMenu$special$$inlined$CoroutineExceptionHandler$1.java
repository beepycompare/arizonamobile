package ru.mrlargha.commonui.elements.animation.presentation;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.widget.Toast;
import kotlin.Metadata;
import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.CoroutineExceptionHandler;
/* compiled from: CoroutineExceptionHandler.kt */
@Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u00012\u00020\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t¸\u0006\u0000"}, d2 = {"kotlinx/coroutines/CoroutineExceptionHandlerKt$CoroutineExceptionHandler$1", "Lkotlin/coroutines/AbstractCoroutineContextElement;", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "handleException", "", "context", "Lkotlin/coroutines/CoroutineContext;", "exception", "", "kotlinx-coroutines-core"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class AnimationMenu$special$$inlined$CoroutineExceptionHandler$1 extends AbstractCoroutineContextElement implements CoroutineExceptionHandler {
    final /* synthetic */ Activity $targetActivity$inlined;
    final /* synthetic */ AnimationMenu this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AnimationMenu$special$$inlined$CoroutineExceptionHandler$1(CoroutineExceptionHandler.Key key, Activity activity, AnimationMenu animationMenu) {
        super(key);
        this.$targetActivity$inlined = activity;
        this.this$0 = animationMenu;
    }

    @Override // kotlinx.coroutines.CoroutineExceptionHandler
    public void handleException(CoroutineContext coroutineContext, Throwable th) {
        System.out.println((Object) ("CoroutineExceptionHandler got " + th));
        th.printStackTrace();
        Handler handler = new Handler(Looper.getMainLooper());
        final Activity activity = this.$targetActivity$inlined;
        final AnimationMenu animationMenu = this.this$0;
        handler.post(new Runnable() { // from class: ru.mrlargha.commonui.elements.animation.presentation.AnimationMenu$handler$1$1
            @Override // java.lang.Runnable
            public final void run() {
                Toast.makeText(activity.getApplicationContext(), "Ошибка API : " + animationMenu.getBackendID(), 1).show();
            }
        });
    }
}
