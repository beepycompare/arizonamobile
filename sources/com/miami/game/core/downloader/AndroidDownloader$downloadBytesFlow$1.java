package com.miami.game.core.downloader;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.FlowCollector;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AndroidDownloader.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", ""}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.miami.game.core.downloader.AndroidDownloader$downloadBytesFlow$1", f = "AndroidDownloader.kt", i = {0, 1}, l = {34, 35}, m = "invokeSuspend", n = {"$this$flow", "$this$flow"}, s = {"L$0", "L$0"})
/* loaded from: classes4.dex */
public final class AndroidDownloader$downloadBytesFlow$1 extends SuspendLambda implements Function2<FlowCollector<? super Long>, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ AndroidDownloader this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AndroidDownloader$downloadBytesFlow$1(AndroidDownloader androidDownloader, Continuation<? super AndroidDownloader$downloadBytesFlow$1> continuation) {
        super(2, continuation);
        this.this$0 = androidDownloader;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        AndroidDownloader$downloadBytesFlow$1 androidDownloader$downloadBytesFlow$1 = new AndroidDownloader$downloadBytesFlow$1(this.this$0, continuation);
        androidDownloader$downloadBytesFlow$1.L$0 = obj;
        return androidDownloader$downloadBytesFlow$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(FlowCollector<? super Long> flowCollector, Continuation<? super Unit> continuation) {
        return ((AndroidDownloader$downloadBytesFlow$1) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0058, code lost:
        if (kotlinx.coroutines.DelayKt.delay(5000, r6) != r0) goto L6;
     */
    /* JADX WARN: Removed duplicated region for block: B:15:0x004a  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x0058 -> B:7:0x0015). Please submit an issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        FlowCollector flowCollector;
        FlowCollector flowCollector2;
        long j;
        long downloadProgress;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            flowCollector = (FlowCollector) this.L$0;
            AndroidDownloader androidDownloader = this.this$0;
            j = androidDownloader.downloadId;
            downloadProgress = androidDownloader.getDownloadProgress(j);
            this.L$0 = flowCollector;
            this.label = 1;
            if (flowCollector.emit(Boxing.boxLong(downloadProgress), this) != coroutine_suspended) {
            }
            return coroutine_suspended;
        } else if (i != 1) {
            if (i == 2) {
                flowCollector2 = (FlowCollector) this.L$0;
                ResultKt.throwOnFailure(obj);
                flowCollector = flowCollector2;
                AndroidDownloader androidDownloader2 = this.this$0;
                j = androidDownloader2.downloadId;
                downloadProgress = androidDownloader2.getDownloadProgress(j);
                this.L$0 = flowCollector;
                this.label = 1;
                if (flowCollector.emit(Boxing.boxLong(downloadProgress), this) != coroutine_suspended) {
                    flowCollector2 = flowCollector;
                    this.L$0 = flowCollector2;
                    this.label = 2;
                }
                return coroutine_suspended;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            flowCollector2 = (FlowCollector) this.L$0;
            ResultKt.throwOnFailure(obj);
            this.L$0 = flowCollector2;
            this.label = 2;
        }
    }
}
