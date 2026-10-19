package com.arizona.launcher;

import androidx.media3.extractor.text.ttml.TtmlNode;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: UpdateService.kt */
@Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
@DebugMetadata(c = "com.arizona.launcher.UpdateService", f = "UpdateService.kt", i = {0, 1, 2, 2, 3, 3}, l = {448, 450, 455, 457}, m = "auditArchiveContent", n = {"fullIntegrity", "fullIntegrity", TtmlNode.RUBY_BASE, "fullIntegrity", TtmlNode.RUBY_BASE, "fullIntegrity"}, nl = {450, 447, 457, 454}, s = {"Z$0", "Z$0", "L$0", "Z$0", "L$0", "Z$0"}, v = 2)
/* loaded from: classes3.dex */
public final class UpdateService$auditArchiveContent$1 extends ContinuationImpl {
    Object L$0;
    boolean Z$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ UpdateService this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UpdateService$auditArchiveContent$1(UpdateService updateService, Continuation<? super UpdateService$auditArchiveContent$1> continuation) {
        super(continuation);
        this.this$0 = updateService;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object auditArchiveContent;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        auditArchiveContent = this.this$0.auditArchiveContent(false, this);
        return auditArchiveContent;
    }
}
