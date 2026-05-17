package com.arizona.launcher.downloader;

import androidx.media3.extractor.ts.TsExtractor;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: FilesChek.kt */
@Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
@DebugMetadata(c = "com.arizona.launcher.downloader.FilesChek", f = "FilesChek.kt", i = {0, 0}, l = {TsExtractor.TS_STREAM_TYPE_HDMV_DTS}, m = "checkGameDataUpdate", n = {"dataInfo", "useManifest"}, nl = {TsExtractor.TS_STREAM_TYPE_AC3}, s = {"L$0", "Z$0"}, v = 2)
/* loaded from: classes3.dex */
public final class FilesChek$checkGameDataUpdate$1 extends ContinuationImpl {
    Object L$0;
    boolean Z$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ FilesChek this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FilesChek$checkGameDataUpdate$1(FilesChek filesChek, Continuation<? super FilesChek$checkGameDataUpdate$1> continuation) {
        super(continuation);
        this.this$0 = filesChek;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.checkGameDataUpdate(null, false, this);
    }
}
