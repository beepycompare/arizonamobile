package coil3.compose;

import coil3.compose.AsyncImagePainter;
import coil3.request.ImageRequest;
import coil3.request.ImageResult;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AsyncImagePainter.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "coil3.compose.AsyncImagePainter$launchJob$1", f = "AsyncImagePainter.kt", i = {}, l = {228, 232}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes3.dex */
public final class AsyncImagePainter$launchJob$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ AsyncImagePainter.Input $input;
    Object L$0;
    int label;
    final /* synthetic */ AsyncImagePainter this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AsyncImagePainter$launchJob$1(AsyncImagePainter asyncImagePainter, AsyncImagePainter.Input input, Continuation<? super AsyncImagePainter$launchJob$1> continuation) {
        super(2, continuation);
        this.this$0 = asyncImagePainter;
        this.$input = input;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AsyncImagePainter$launchJob$1(this.this$0, this.$input, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((AsyncImagePainter$launchJob$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0048, code lost:
        if (r6 == r0) goto L18;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        ImageRequest updateRequest;
        AsyncImagePainter asyncImagePainter;
        ImageRequest updateRequest2;
        AsyncImagePainter.State state;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            AsyncImagePreviewHandler previewHandler$coil_compose_core_release = this.this$0.getPreviewHandler$coil_compose_core_release();
            if (previewHandler$coil_compose_core_release != null) {
                updateRequest2 = this.this$0.updateRequest(this.$input.getRequest(), true);
                this.label = 1;
                obj = previewHandler$coil_compose_core_release.handle(this.$input.getImageLoader(), updateRequest2, this);
            } else {
                updateRequest = this.this$0.updateRequest(this.$input.getRequest(), false);
                AsyncImagePainter asyncImagePainter2 = this.this$0;
                this.L$0 = asyncImagePainter2;
                this.label = 2;
                obj = this.$input.getImageLoader().execute(updateRequest, this);
                if (obj != coroutine_suspended) {
                    asyncImagePainter = asyncImagePainter2;
                    state = asyncImagePainter.toState((ImageResult) obj);
                }
            }
            return coroutine_suspended;
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
            state = (AsyncImagePainter.State) obj;
        } else if (i != 2) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            asyncImagePainter = (AsyncImagePainter) this.L$0;
            ResultKt.throwOnFailure(obj);
            state = asyncImagePainter.toState((ImageResult) obj);
        }
        this.this$0.updateState(state);
        return Unit.INSTANCE;
    }
}
