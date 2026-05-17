package ru.mrlargha.commonui.utils.ui;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.widget.Toast;
import kotlin.Metadata;
import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlinx.coroutines.CoroutineExceptionHandler;
import ru.mrlargha.commonui.R;
/* compiled from: CoroutineExceptionHandler.kt */
@Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u00012\u00020\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t¸\u0006\u0000"}, d2 = {"kotlinx/coroutines/CoroutineExceptionHandlerKt$CoroutineExceptionHandler$1", "Lkotlin/coroutines/AbstractCoroutineContextElement;", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "handleException", "", "context", "Lkotlin/coroutines/CoroutineContext;", "exception", "", "kotlinx-coroutines-core"}, k = 1, mv = {2, 3, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class ArizonaRetrofit$special$$inlined$CoroutineExceptionHandler$1 extends AbstractCoroutineContextElement implements CoroutineExceptionHandler {
    final /* synthetic */ int $backendID$inlined;
    final /* synthetic */ Context $targetActivity$inlined;
    final /* synthetic */ ArizonaRetrofit this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ArizonaRetrofit$special$$inlined$CoroutineExceptionHandler$1(CoroutineExceptionHandler.Key key, Context context, int i, ArizonaRetrofit arizonaRetrofit) {
        super(key);
        this.$targetActivity$inlined = context;
        this.$backendID$inlined = i;
        this.this$0 = arizonaRetrofit;
    }

    @Override // kotlinx.coroutines.CoroutineExceptionHandler
    public void handleException(CoroutineContext coroutineContext, Throwable th) {
        System.out.println((Object) ("CoroutineExceptionHandler got " + th));
        th.printStackTrace();
        Handler handler = new Handler(Looper.getMainLooper());
        final Context context = this.$targetActivity$inlined;
        final int i = this.$backendID$inlined;
        final ArizonaRetrofit arizonaRetrofit = this.this$0;
        handler.post(new Runnable() { // from class: ru.mrlargha.commonui.utils.ui.ArizonaRetrofit$handler$1$1
            @Override // java.lang.Runnable
            public final void run() {
                Function0 function0;
                Toast.makeText(context.getApplicationContext(), context.getString(R.string.common_api_error, Integer.valueOf(i)), 1).show();
                function0 = arizonaRetrofit.onError;
                function0.invoke();
            }
        });
    }
}
