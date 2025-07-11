package coil3.compose;

import coil3.Image;
import coil3.ImageLoader;
import coil3.compose.AsyncImagePainter;
import coil3.request.ImageRequest;
import coil3.request.SuccessResult;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
/* compiled from: LocalAsyncImagePreviewHandler.kt */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 176)
/* loaded from: classes3.dex */
public final class LocalAsyncImagePreviewHandlerKt$AsyncImagePreviewHandler$1 implements AsyncImagePreviewHandler {
    final /* synthetic */ Function2<ImageRequest, Continuation<? super Image>, Object> $image;

    /* JADX WARN: Multi-variable type inference failed */
    public LocalAsyncImagePreviewHandlerKt$AsyncImagePreviewHandler$1(Function2<? super ImageRequest, ? super Continuation<? super Image>, ? extends Object> function2) {
        this.$image = function2;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0037  */
    @Override // coil3.compose.AsyncImagePreviewHandler
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object handle(ImageLoader imageLoader, ImageRequest imageRequest, Continuation<? super AsyncImagePainter.State> continuation) {
        LocalAsyncImagePreviewHandlerKt$AsyncImagePreviewHandler$1$handle$1 localAsyncImagePreviewHandlerKt$AsyncImagePreviewHandler$1$handle$1;
        int i;
        if (continuation instanceof LocalAsyncImagePreviewHandlerKt$AsyncImagePreviewHandler$1$handle$1) {
            localAsyncImagePreviewHandlerKt$AsyncImagePreviewHandler$1$handle$1 = (LocalAsyncImagePreviewHandlerKt$AsyncImagePreviewHandler$1$handle$1) continuation;
            if ((localAsyncImagePreviewHandlerKt$AsyncImagePreviewHandler$1$handle$1.label & Integer.MIN_VALUE) != 0) {
                localAsyncImagePreviewHandlerKt$AsyncImagePreviewHandler$1$handle$1.label -= Integer.MIN_VALUE;
                Object obj = localAsyncImagePreviewHandlerKt$AsyncImagePreviewHandler$1$handle$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = localAsyncImagePreviewHandlerKt$AsyncImagePreviewHandler$1$handle$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    Function2<ImageRequest, Continuation<? super Image>, Object> function2 = this.$image;
                    localAsyncImagePreviewHandlerKt$AsyncImagePreviewHandler$1$handle$1.L$0 = imageRequest;
                    localAsyncImagePreviewHandlerKt$AsyncImagePreviewHandler$1$handle$1.label = 1;
                    obj = function2.invoke(imageRequest, localAsyncImagePreviewHandlerKt$AsyncImagePreviewHandler$1$handle$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    imageRequest = (ImageRequest) localAsyncImagePreviewHandlerKt$AsyncImagePreviewHandler$1$handle$1.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                ImageRequest imageRequest2 = imageRequest;
                Image image = (Image) obj;
                return new AsyncImagePainter.State.Success(ImagePainter_androidKt.m7749asPainter55t9rM$default(image, imageRequest2.getContext(), 0, 2, null), new SuccessResult(image, imageRequest2, null, null, null, false, false, 124, null));
            }
        }
        localAsyncImagePreviewHandlerKt$AsyncImagePreviewHandler$1$handle$1 = new LocalAsyncImagePreviewHandlerKt$AsyncImagePreviewHandler$1$handle$1(this, continuation);
        Object obj2 = localAsyncImagePreviewHandlerKt$AsyncImagePreviewHandler$1$handle$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = localAsyncImagePreviewHandlerKt$AsyncImagePreviewHandler$1$handle$1.label;
        if (i != 0) {
        }
        ImageRequest imageRequest22 = imageRequest;
        Image image2 = (Image) obj2;
        return new AsyncImagePainter.State.Success(ImagePainter_androidKt.m7749asPainter55t9rM$default(image2, imageRequest22.getContext(), 0, 2, null), new SuccessResult(image2, imageRequest22, null, null, null, false, false, 124, null));
    }

    public final Object handle$$forInline(ImageLoader imageLoader, ImageRequest imageRequest, Continuation<? super AsyncImagePainter.State> continuation) {
        new LocalAsyncImagePreviewHandlerKt$AsyncImagePreviewHandler$1$handle$1(this, continuation);
        Image image = (Image) this.$image.invoke(imageRequest, continuation);
        return new AsyncImagePainter.State.Success(ImagePainter_androidKt.m7749asPainter55t9rM$default(image, imageRequest.getContext(), 0, 2, null), new SuccessResult(image, imageRequest, null, null, null, false, false, 124, null));
    }
}
