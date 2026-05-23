package androidx.core.content;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Context.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0001\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "androidx.core.content.ContextKt$receiveBroadcastsAsync$2", f = "Context.kt", i = {}, l = {238}, m = "invokeSuspend", n = {}, s = {}, v = 1)
/* loaded from: classes2.dex */
public final class ContextKt$receiveBroadcastsAsync$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<?>, Object> {
    final /* synthetic */ String $broadcastPermission;
    final /* synthetic */ IntentFilter $filter;
    final /* synthetic */ int $flags;
    final /* synthetic */ Function3<BroadcastReceiver.PendingResult, Intent, Continuation<? super Unit>, Object> $onReceive;
    final /* synthetic */ Handler $scheduler;
    final /* synthetic */ Context $this_receiveBroadcastsAsync;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public ContextKt$receiveBroadcastsAsync$2(Context context, IntentFilter intentFilter, int i, String str, Handler handler, Function3<? super BroadcastReceiver.PendingResult, ? super Intent, ? super Continuation<? super Unit>, ? extends Object> function3, Continuation<? super ContextKt$receiveBroadcastsAsync$2> continuation) {
        super(2, continuation);
        this.$this_receiveBroadcastsAsync = context;
        this.$filter = intentFilter;
        this.$flags = i;
        this.$broadcastPermission = str;
        this.$scheduler = handler;
        this.$onReceive = function3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        ContextKt$receiveBroadcastsAsync$2 contextKt$receiveBroadcastsAsync$2 = new ContextKt$receiveBroadcastsAsync$2(this.$this_receiveBroadcastsAsync, this.$filter, this.$flags, this.$broadcastPermission, this.$scheduler, this.$onReceive, continuation);
        contextKt$receiveBroadcastsAsync$2.L$0 = obj;
        return contextKt$receiveBroadcastsAsync$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<?> continuation) {
        return ((ContextKt$receiveBroadcastsAsync$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            final CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            Context context = this.$this_receiveBroadcastsAsync;
            IntentFilter intentFilter = this.$filter;
            int i2 = this.$flags;
            String str = this.$broadcastPermission;
            Handler handler = this.$scheduler;
            final Function3<BroadcastReceiver.PendingResult, Intent, Continuation<? super Unit>, Object> function3 = this.$onReceive;
            this.label = 1;
            if (ContextKt.receiveBroadcasts(context, intentFilter, i2, str, handler, new Function2() { // from class: androidx.core.content.ContextKt$receiveBroadcastsAsync$2$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj2, Object obj3) {
                    return ContextKt$receiveBroadcastsAsync$2.invokeSuspend$lambda$0(CoroutineScope.this, function3, (BroadcastReceiver) obj2, (Intent) obj3);
                }
            }, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            ResultKt.throwOnFailure(obj);
        }
        throw new KotlinNothingValueException();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit invokeSuspend$lambda$0(CoroutineScope coroutineScope, Function3 function3, BroadcastReceiver broadcastReceiver, Intent intent) {
        BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, CoroutineStart.ATOMIC, new ContextKt$receiveBroadcastsAsync$2$1$1(function3, broadcastReceiver.goAsync(), intent, null), 1, null);
        return Unit.INSTANCE;
    }
}
