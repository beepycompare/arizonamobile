package androidx.compose.foundation.gestures;

import androidx.exifinterface.media.ExifInterface;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.channels.Channel;
/* JADX INFO: Add missing generic type declarations: [T] */
/* compiled from: NonTouchScrollingLogic.kt */
@Metadata(d1 = {"\u0000\b\n\u0002\b\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.gestures.NonTouchScrollingLogicKt$busyReceive$2", f = "NonTouchScrollingLogic.kt", i = {0}, l = {80}, m = "invokeSuspend", n = {"job"}, s = {"L$0"}, v = 1)
/* loaded from: classes.dex */
final class NonTouchScrollingLogicKt$busyReceive$2<T> extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super T>, Object> {
    final /* synthetic */ Channel<T> $this_busyReceive;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NonTouchScrollingLogicKt$busyReceive$2(Channel<T> channel, Continuation<? super NonTouchScrollingLogicKt$busyReceive$2> continuation) {
        super(2, continuation);
        this.$this_busyReceive = channel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        NonTouchScrollingLogicKt$busyReceive$2 nonTouchScrollingLogicKt$busyReceive$2 = new NonTouchScrollingLogicKt$busyReceive$2(this.$this_busyReceive, continuation);
        nonTouchScrollingLogicKt$busyReceive$2.L$0 = obj;
        return nonTouchScrollingLogicKt$busyReceive$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Object obj) {
        return invoke(coroutineScope, (Continuation) ((Continuation) obj));
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super T> continuation) {
        return ((NonTouchScrollingLogicKt$busyReceive$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Job launch$default;
        Throwable th;
        Job job;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            launch$default = BuildersKt__Builders_commonKt.launch$default((CoroutineScope) this.L$0, null, null, new NonTouchScrollingLogicKt$busyReceive$2$job$1(null), 3, null);
            try {
                this.L$0 = launch$default;
                this.label = 1;
                Object receive = this.$this_busyReceive.receive(this);
                if (receive == coroutine_suspended) {
                    return coroutine_suspended;
                }
                obj = receive;
                job = launch$default;
            } catch (Throwable th2) {
                th = th2;
                job = launch$default;
                Job.cancel$default(job, (CancellationException) null, 1, (Object) null);
                throw th;
            }
        } else if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            job = (Job) this.L$0;
            try {
                ResultKt.throwOnFailure(obj);
            } catch (Throwable th3) {
                th = th3;
                Job.cancel$default(job, (CancellationException) null, 1, (Object) null);
                throw th;
            }
        }
        Job.cancel$default(job, (CancellationException) null, 1, (Object) null);
        return obj;
    }
}
