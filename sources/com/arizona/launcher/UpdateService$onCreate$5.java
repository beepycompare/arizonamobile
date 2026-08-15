package com.arizona.launcher;

import com.arizona.launcher.updater.archive.orchestrator.ArchiveUpdateCheckDecision;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendFunction;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
/* compiled from: UpdateService.kt */
@Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
final /* synthetic */ class UpdateService$onCreate$5 extends FunctionReferenceImpl implements Function2<Long, Continuation<? super ArchiveUpdateCheckDecision.Block>, Object>, SuspendFunction {
    /* JADX INFO: Access modifiers changed from: package-private */
    public UpdateService$onCreate$5(Object obj) {
        super(2, obj, UpdateService.class, "runPrimaryGameCheckPreflight", "runPrimaryGameCheckPreflight(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", 0);
    }

    public final Object invoke(long j, Continuation<? super ArchiveUpdateCheckDecision.Block> continuation) {
        Object runPrimaryGameCheckPreflight;
        runPrimaryGameCheckPreflight = ((UpdateService) this.receiver).runPrimaryGameCheckPreflight(j, continuation);
        return runPrimaryGameCheckPreflight;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(Long l, Continuation<? super ArchiveUpdateCheckDecision.Block> continuation) {
        return invoke(l.longValue(), continuation);
    }
}
