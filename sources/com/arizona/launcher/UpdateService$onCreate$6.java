package com.arizona.launcher;

import com.arizona.launcher.updater.archive.orchestrator.ArchiveUpdateCheckDecision;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendFunction;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.FunctionReferenceImpl;
/* compiled from: UpdateService.kt */
@Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
final /* synthetic */ class UpdateService$onCreate$6 extends FunctionReferenceImpl implements Function5<String, String, UpdateOperationKind, Long, Continuation<? super ArchiveUpdateCheckDecision>, Object>, SuspendFunction {
    /* JADX INFO: Access modifiers changed from: package-private */
    public UpdateService$onCreate$6(Object obj) {
        super(5, obj, UpdateService.class, "prepareGameUpdateCheck", "prepareGameUpdateCheck(Ljava/lang/String;Ljava/lang/String;Lcom/arizona/launcher/UpdateOperationKind;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", 0);
    }

    @Override // kotlin.jvm.functions.Function5
    public /* bridge */ /* synthetic */ Object invoke(String str, String str2, UpdateOperationKind updateOperationKind, Long l, Continuation<? super ArchiveUpdateCheckDecision> continuation) {
        return invoke(str, str2, updateOperationKind, l.longValue(), continuation);
    }

    public final Object invoke(String str, String str2, UpdateOperationKind updateOperationKind, long j, Continuation<? super ArchiveUpdateCheckDecision> continuation) {
        Object prepareGameUpdateCheck;
        prepareGameUpdateCheck = ((UpdateService) this.receiver).prepareGameUpdateCheck(str, str2, updateOperationKind, j, continuation);
        return prepareGameUpdateCheck;
    }
}
