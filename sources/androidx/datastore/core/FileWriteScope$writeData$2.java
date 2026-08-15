package androidx.datastore.core;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
/* compiled from: FileStorage.kt */
@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "androidx.datastore.core.FileWriteScope$writeData$2", f = "FileStorage.kt", i = {0}, l = {206}, m = "invokeSuspend", n = {"stream"}, s = {"L$1"}, v = 1)
/* loaded from: classes2.dex */
final class FileWriteScope$writeData$2 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    final /* synthetic */ T $value;
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ FileWriteScope<T> this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FileWriteScope$writeData$2(FileWriteScope<T> fileWriteScope, T t, Continuation<? super FileWriteScope$writeData$2> continuation) {
        super(1, continuation);
        this.this$0 = fileWriteScope;
        this.$value = t;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new FileWriteScope$writeData$2(this.this$0, this.$value, continuation);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation<? super Unit> continuation) {
        return ((FileWriteScope$writeData$2) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        FileOutputStream fileOutputStream;
        FileOutputStream fileOutputStream2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                fileOutputStream = new FileOutputStream(this.this$0.getFile());
                FileReadScope fileReadScope = this.this$0;
                T t = this.$value;
                FileOutputStream fileOutputStream3 = fileOutputStream;
                this.L$0 = fileOutputStream;
                this.L$1 = fileOutputStream3;
                this.label = 1;
                if (fileReadScope.getSerializer().writeTo(t, new UncloseableOutputStream(fileOutputStream3), this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                fileOutputStream2 = fileOutputStream3;
            } else if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                fileOutputStream2 = (FileOutputStream) this.L$1;
                fileOutputStream = (java.io.Closeable) this.L$0;
                ResultKt.throwOnFailure(obj);
            }
            fileOutputStream2.getFD().sync();
            Unit unit = Unit.INSTANCE;
            kotlin.io.CloseableKt.closeFinally(fileOutputStream, null);
            return Unit.INSTANCE;
        } catch (Exception e) {
            if (e instanceof FileNotFoundException) {
                throw DirectBootExceptionUtilKt.wrapExceptionIfDueToDirectBoot(this.this$0.getFile().getParent(), e);
            }
            throw e;
        }
    }
}
