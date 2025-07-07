package androidx.collection;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.sequences.SequenceScope;
/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: Add missing generic type declarations: [E] */
/* compiled from: ScatterSet.kt */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", ExifInterface.LONGITUDE_EAST, "Lkotlin/sequences/SequenceScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "androidx.collection.MutableSetWrapper$iterator$1$iterator$1", f = "ScatterSet.kt", i = {0, 0, 0, 0, 0, 0, 0}, l = {1188}, m = "invokeSuspend", n = {"$this$iterator", "m$iv", "lastIndex$iv", "i$iv", "slot$iv", "bitCount$iv", "j$iv"}, s = {"L$0", "L$3", "I$0", "I$1", "J$0", "I$2", "I$3"})
/* loaded from: classes.dex */
public final class MutableSetWrapper$iterator$1$iterator$1<E> extends RestrictedSuspendLambda implements Function2<SequenceScope<? super E>, Continuation<? super Unit>, Object> {
    int I$0;
    int I$1;
    int I$2;
    int I$3;
    long J$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    final /* synthetic */ MutableSetWrapper<E> this$0;
    final /* synthetic */ MutableSetWrapper$iterator$1 this$1;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MutableSetWrapper$iterator$1$iterator$1(MutableSetWrapper<E> mutableSetWrapper, MutableSetWrapper$iterator$1 mutableSetWrapper$iterator$1, Continuation<? super MutableSetWrapper$iterator$1$iterator$1> continuation) {
        super(2, continuation);
        this.this$0 = mutableSetWrapper;
        this.this$1 = mutableSetWrapper$iterator$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        MutableSetWrapper$iterator$1$iterator$1 mutableSetWrapper$iterator$1$iterator$1 = new MutableSetWrapper$iterator$1$iterator$1(this.this$0, this.this$1, continuation);
        mutableSetWrapper$iterator$1$iterator$1.L$0 = obj;
        return mutableSetWrapper$iterator$1$iterator$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(Object obj, Continuation<? super Unit> continuation) {
        return invoke((SequenceScope) ((SequenceScope) obj), continuation);
    }

    public final Object invoke(SequenceScope<? super E> sequenceScope, Continuation<? super Unit> continuation) {
        return ((MutableSetWrapper$iterator$1$iterator$1) create(sequenceScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00b7  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:12:0x005f -> B:23:0x00b5). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:13:0x0061 -> B:14:0x0075). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x007e -> B:20:0x00a9). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:18:0x00a6 -> B:20:0x00a9). Please submit an issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        SequenceScope sequenceScope;
        MutableScatterSet mutableScatterSet;
        MutableSetWrapper$iterator$1 mutableSetWrapper$iterator$1;
        MutableSetWrapper<E> mutableSetWrapper;
        long[] jArr;
        int length;
        int i;
        long j;
        MutableScatterSet mutableScatterSet2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = this.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            sequenceScope = (SequenceScope) this.L$0;
            mutableScatterSet = ((MutableSetWrapper) this.this$0).parent;
            mutableSetWrapper$iterator$1 = this.this$1;
            mutableSetWrapper = this.this$0;
            jArr = mutableScatterSet.metadata;
            length = jArr.length - 2;
            if (length >= 0) {
                i = 0;
                j = jArr[i];
                if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                }
                if (i != length) {
                }
            }
            return Unit.INSTANCE;
        } else if (i2 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            int i3 = this.I$3;
            int i4 = this.I$2;
            long j2 = this.J$0;
            int i5 = this.I$1;
            int i6 = this.I$0;
            long[] jArr2 = (long[]) this.L$3;
            MutableSetWrapper<E> mutableSetWrapper2 = (MutableSetWrapper) this.L$2;
            MutableSetWrapper$iterator$1 mutableSetWrapper$iterator$12 = (MutableSetWrapper$iterator$1) this.L$1;
            SequenceScope sequenceScope2 = (SequenceScope) this.L$0;
            ResultKt.throwOnFailure(obj);
            j2 >>= 8;
            i3++;
            if (i3 < i4) {
                if (i4 == 8) {
                    int i7 = i6;
                    i = i5;
                    length = i7;
                    jArr = jArr2;
                    mutableSetWrapper = mutableSetWrapper2;
                    mutableSetWrapper$iterator$1 = mutableSetWrapper$iterator$12;
                    sequenceScope = sequenceScope2;
                    if (i != length) {
                        i++;
                        j = jArr[i];
                        if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                            int i8 = i;
                            i6 = length;
                            i5 = i8;
                            sequenceScope2 = sequenceScope;
                            i3 = 0;
                            jArr2 = jArr;
                            mutableSetWrapper2 = mutableSetWrapper;
                            i4 = 8 - ((~(i - length)) >>> 31);
                            mutableSetWrapper$iterator$12 = mutableSetWrapper$iterator$1;
                            j2 = j;
                            if (i3 < i4) {
                                if ((255 & j2) < 128) {
                                    int i9 = (i5 << 3) + i3;
                                    mutableSetWrapper$iterator$12.setCurrent(i9);
                                    mutableScatterSet2 = ((MutableSetWrapper) mutableSetWrapper2).parent;
                                    Object obj2 = mutableScatterSet2.elements[i9];
                                    this.L$0 = sequenceScope2;
                                    this.L$1 = mutableSetWrapper$iterator$12;
                                    this.L$2 = mutableSetWrapper2;
                                    this.L$3 = jArr2;
                                    this.I$0 = i6;
                                    this.I$1 = i5;
                                    this.J$0 = j2;
                                    this.I$2 = i4;
                                    this.I$3 = i3;
                                    this.label = 1;
                                    if (sequenceScope2.yield(obj2, this) == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                }
                                j2 >>= 8;
                                i3++;
                                if (i3 < i4) {
                                }
                            }
                        }
                        if (i != length) {
                        }
                    }
                }
                return Unit.INSTANCE;
            }
        }
    }
}
