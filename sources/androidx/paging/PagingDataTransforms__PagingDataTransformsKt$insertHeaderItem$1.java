package androidx.paging;

import androidx.exifinterface.media.ExifInterface;
import androidx.media3.extractor.text.ttml.TtmlNode;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
/* JADX INFO: Add missing generic type declarations: [T] */
/* compiled from: PagingDataTransforms.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u0001H\u00012\b\u0010\u0004\u001a\u0004\u0018\u0001H\u0001H\u008a@"}, d2 = {"<anonymous>", ExifInterface.GPS_DIRECTION_TRUE, "", TtmlNode.ANNOTATION_POSITION_BEFORE, "<anonymous parameter 1>"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.paging.PagingDataTransforms__PagingDataTransformsKt$insertHeaderItem$1", f = "PagingDataTransforms.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes3.dex */
final class PagingDataTransforms__PagingDataTransformsKt$insertHeaderItem$1<T> extends SuspendLambda implements Function3<T, T, Continuation<? super T>, Object> {
    final /* synthetic */ T $item;
    /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PagingDataTransforms__PagingDataTransformsKt$insertHeaderItem$1(T t, Continuation<? super PagingDataTransforms__PagingDataTransformsKt$insertHeaderItem$1> continuation) {
        super(3, continuation);
        this.$item = t;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        return invoke(obj, obj2, (Continuation<? super Object>) obj3);
    }

    public final Object invoke(T t, T t2, Continuation<? super T> continuation) {
        PagingDataTransforms__PagingDataTransformsKt$insertHeaderItem$1 pagingDataTransforms__PagingDataTransformsKt$insertHeaderItem$1 = new PagingDataTransforms__PagingDataTransformsKt$insertHeaderItem$1(this.$item, continuation);
        pagingDataTransforms__PagingDataTransformsKt$insertHeaderItem$1.L$0 = t;
        return pagingDataTransforms__PagingDataTransformsKt$insertHeaderItem$1.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            if (this.L$0 == null) {
                return this.$item;
            }
            return null;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
