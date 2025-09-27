package androidx.room;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: RoomDatabase.kt */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "androidx.room.RoomDatabaseKt__RoomDatabaseKt", f = "RoomDatabase.kt", i = {0, 0, 1}, l = {TypedValues.PositionType.TYPE_TRANSITION_EASING, TypedValues.PositionType.TYPE_TRANSITION_EASING}, m = "useWriterConnection", n = {"$this$useWriterConnection", "block", "$this$useWriterConnection"}, s = {"L$0", "L$1", "L$0"})
/* loaded from: classes3.dex */
public final class RoomDatabaseKt__RoomDatabaseKt$useWriterConnection$1<R> extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RoomDatabaseKt__RoomDatabaseKt$useWriterConnection$1(Continuation<? super RoomDatabaseKt__RoomDatabaseKt$useWriterConnection$1> continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return RoomDatabaseKt.useWriterConnection(null, null, this);
    }
}
