package coil3.decode;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: BitmapFactoryDecoder.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "coil3.decode.BitmapFactoryDecoder", f = "BitmapFactoryDecoder.kt", i = {0, 0, 1, 1, 1}, l = {212, 40}, m = "decode", n = {"$this$withPermit$iv", "$i$f$withPermit", "$this$withPermit$iv", "$i$f$withPermit", "$i$a$-withPermit-BitmapFactoryDecoder$decode$2"}, s = {"L$0", "I$0", "L$0", "I$0", "I$1"})
/* loaded from: classes3.dex */
public final class BitmapFactoryDecoder$decode$1 extends ContinuationImpl {
    int I$0;
    int I$1;
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ BitmapFactoryDecoder this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BitmapFactoryDecoder$decode$1(BitmapFactoryDecoder bitmapFactoryDecoder, Continuation<? super BitmapFactoryDecoder$decode$1> continuation) {
        super(continuation);
        this.this$0 = bitmapFactoryDecoder;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.decode(this);
    }
}
