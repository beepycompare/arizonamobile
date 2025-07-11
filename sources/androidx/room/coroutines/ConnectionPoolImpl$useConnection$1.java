package androidx.room.coroutines;

import androidx.compose.material3.MenuKt;
import androidx.media3.extractor.metadata.dvbsi.AppInfoTableDecoder;
import androidx.media3.extractor.ts.TsExtractor;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ConnectionPoolImpl.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "androidx.room.coroutines.ConnectionPoolImpl", f = "ConnectionPoolImpl.kt", i = {2, 2, 2, 2, 2, 2, 3, 3}, l = {AppInfoTableDecoder.APPLICATION_INFORMATION_TABLE_ID, MenuKt.InTransitionDuration, TsExtractor.TS_STREAM_TYPE_DTS, 143}, m = "useConnection", n = {"this", "block", "pool", "connection", "currentContext", "isReadOnly", "pool", "connection"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "Z$0", "L$0", "L$1"})
/* loaded from: classes3.dex */
public final class ConnectionPoolImpl$useConnection$1<R> extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    boolean Z$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ConnectionPoolImpl this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConnectionPoolImpl$useConnection$1(ConnectionPoolImpl connectionPoolImpl, Continuation<? super ConnectionPoolImpl$useConnection$1> continuation) {
        super(continuation);
        this.this$0 = connectionPoolImpl;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.useConnection(false, null, this);
    }
}
