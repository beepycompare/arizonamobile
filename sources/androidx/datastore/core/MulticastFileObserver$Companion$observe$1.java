package androidx.datastore.core;

import androidx.datastore.core.MulticastFileObserver;
import androidx.media3.container.MdtaMetadataEntry;
import java.io.File;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.channels.ChannelsKt;
import kotlinx.coroutines.channels.ProducerScope;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MulticastFileObserver.android.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00010\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/channels/ProducerScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "androidx.datastore.core.MulticastFileObserver$Companion$observe$1", f = "MulticastFileObserver.android.kt", i = {0, 0}, l = {MdtaMetadataEntry.TYPE_INDICATOR_UNSIGNED_INT64, 79}, m = "invokeSuspend", n = {"$this$channelFlow", "disposeListener"}, s = {"L$0", "L$1"}, v = 1)
/* loaded from: classes2.dex */
public final class MulticastFileObserver$Companion$observe$1 extends SuspendLambda implements Function2<ProducerScope<? super Unit>, Continuation<? super Unit>, Object> {
    final /* synthetic */ File $file;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MulticastFileObserver$Companion$observe$1(File file, Continuation<? super MulticastFileObserver$Companion$observe$1> continuation) {
        super(2, continuation);
        this.$file = file;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        MulticastFileObserver$Companion$observe$1 multicastFileObserver$Companion$observe$1 = new MulticastFileObserver$Companion$observe$1(this.$file, continuation);
        multicastFileObserver$Companion$observe$1.L$0 = obj;
        return multicastFileObserver$Companion$observe$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(ProducerScope<? super Unit> producerScope, Continuation<? super Unit> continuation) {
        return ((MulticastFileObserver$Companion$observe$1) create(producerScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0069, code lost:
        if (kotlinx.coroutines.channels.ProduceKt.awaitClose(r3, new androidx.datastore.core.MulticastFileObserver$Companion$observe$1$$ExternalSyntheticLambda1(r1), r6) == r0) goto L14;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        final DisposableHandle observe;
        ProducerScope producerScope;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            final ProducerScope producerScope2 = (ProducerScope) this.L$0;
            final File file = this.$file;
            Function1 function1 = new Function1() { // from class: androidx.datastore.core.MulticastFileObserver$Companion$observe$1$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj2) {
                    Unit invokeSuspend$lambda$0;
                    invokeSuspend$lambda$0 = MulticastFileObserver$Companion$observe$1.invokeSuspend$lambda$0(file, producerScope2, (String) obj2);
                    return invokeSuspend$lambda$0;
                }
            };
            MulticastFileObserver.Companion companion = MulticastFileObserver.Companion;
            File parentFile = this.$file.getParentFile();
            Intrinsics.checkNotNull(parentFile);
            observe = companion.observe(parentFile, function1);
            this.L$0 = producerScope2;
            this.L$1 = observe;
            this.label = 1;
            if (producerScope2.send(Unit.INSTANCE, this) != coroutine_suspended) {
                producerScope = producerScope2;
            }
            return coroutine_suspended;
        } else if (i != 1) {
            if (i == 2) {
                ResultKt.throwOnFailure(obj);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            observe = (DisposableHandle) this.L$1;
            producerScope = (ProducerScope) this.L$0;
            ResultKt.throwOnFailure(obj);
        }
        this.L$0 = null;
        this.L$1 = null;
        this.label = 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invokeSuspend$lambda$0(File file, ProducerScope producerScope, String str) {
        if (Intrinsics.areEqual(str, file.getName())) {
            ChannelsKt.trySendBlocking(producerScope, Unit.INSTANCE);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invokeSuspend$lambda$1(DisposableHandle disposableHandle) {
        disposableHandle.dispose();
        return Unit.INSTANCE;
    }
}
