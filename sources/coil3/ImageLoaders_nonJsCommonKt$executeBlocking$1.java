package coil3;

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
/* compiled from: imageLoaders.nonJsCommon.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcoil3/request/ImageResult;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "coil3.ImageLoaders_nonJsCommonKt$executeBlocking$1", f = "imageLoaders.nonJsCommon.kt", i = {}, l = {15}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes3.dex */
final class ImageLoaders_nonJsCommonKt$executeBlocking$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super ImageResult>, Object> {
    final /* synthetic */ ImageRequest $request;
    final /* synthetic */ ImageLoader $this_executeBlocking;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ImageLoaders_nonJsCommonKt$executeBlocking$1(ImageLoader imageLoader, ImageRequest imageRequest, Continuation<? super ImageLoaders_nonJsCommonKt$executeBlocking$1> continuation) {
        super(2, continuation);
        this.$this_executeBlocking = imageLoader;
        this.$request = imageRequest;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ImageLoaders_nonJsCommonKt$executeBlocking$1(this.$this_executeBlocking, this.$request, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super ImageResult> continuation) {
        return ((ImageLoaders_nonJsCommonKt$executeBlocking$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i != 0) {
            if (i == 1) {
                ResultKt.throwOnFailure(obj);
                return obj;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        this.label = 1;
        Object execute = this.$this_executeBlocking.execute(this.$request, this);
        return execute == coroutine_suspended ? coroutine_suspended : execute;
    }
}
