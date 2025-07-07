package com.arizona.launcher;

import android.util.Log;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
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
/* compiled from: MainEntrench.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.arizona.launcher.MainEntrench$sendRequests$1", f = "MainEntrench.kt", i = {}, l = {1084}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes3.dex */
final class MainEntrench$sendRequests$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $iterations;
    final /* synthetic */ RequestQueue $queue;
    final /* synthetic */ String $url;
    int I$0;
    int I$1;
    Object L$0;
    Object L$1;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MainEntrench$sendRequests$1(int i, String str, RequestQueue requestQueue, Continuation<? super MainEntrench$sendRequests$1> continuation) {
        super(2, continuation);
        this.$iterations = i;
        this.$url = str;
        this.$queue = requestQueue;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new MainEntrench$sendRequests$1(this.$iterations, this.$url, this.$queue, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((MainEntrench$sendRequests$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x005c  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:11:0x0057 -> B:13:0x005a). Please submit an issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        String str;
        int i;
        RequestQueue requestQueue;
        int i2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            int i4 = this.$iterations;
            str = this.$url;
            i = 0;
            requestQueue = this.$queue;
            i2 = i4;
            if (i < i2) {
            }
        } else if (i3 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            i = this.I$1;
            i2 = this.I$0;
            requestQueue = (RequestQueue) this.L$1;
            str = (String) this.L$0;
            ResultKt.throwOnFailure(obj);
            i++;
            if (i < i2) {
                requestQueue.add(new StringRequest(0, str, new Response.Listener() { // from class: com.arizona.launcher.MainEntrench$sendRequests$1$$ExternalSyntheticLambda0
                    @Override // com.android.volley.Response.Listener
                    public final void onResponse(Object obj2) {
                        String str2 = (String) obj2;
                        Log.d("MainEntrench", "PRE-Check LOG – OK");
                    }
                }, new Response.ErrorListener() { // from class: com.arizona.launcher.MainEntrench$sendRequests$1$$ExternalSyntheticLambda1
                    @Override // com.android.volley.Response.ErrorListener
                    public final void onErrorResponse(VolleyError volleyError) {
                        Log.w("MainEntrench", "PRE-Check LOG – NOT OK");
                    }
                }));
                this.L$0 = str;
                this.L$1 = requestQueue;
                this.I$0 = i2;
                this.I$1 = i;
                this.label = 1;
                if (DelayKt.delay(300L, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                i++;
                if (i < i2) {
                    return Unit.INSTANCE;
                }
            }
        }
    }
}
