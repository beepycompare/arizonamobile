package ru.mrlargha.commonui.elements.inventory.presentation;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import ru.mrlargha.commonui.utils.ArchiveEntryBytes;
import ru.mrlargha.commonui.utils.UtilsKt;
/* compiled from: util.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lru/mrlargha/commonui/utils/ArchiveEntryBytes;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 4, 0}, xi = 48)
@DebugMetadata(c = "ru.mrlargha.commonui.elements.inventory.presentation.UtilKt$loadResolvedEffect$job$1$localAsset$1", f = "util.kt", i = {}, l = {128}, m = "invokeSuspend", n = {}, nl = {-1}, s = {}, v = 2)
/* loaded from: classes6.dex */
final class UtilKt$loadResolvedEffect$job$1$localAsset$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super ArchiveEntryBytes>, Object> {
    final /* synthetic */ ResolvedInventoryEffect $effect;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UtilKt$loadResolvedEffect$job$1$localAsset$1(ResolvedInventoryEffect resolvedInventoryEffect, Continuation<? super UtilKt$loadResolvedEffect$job$1$localAsset$1> continuation) {
        super(2, continuation);
        this.$effect = resolvedInventoryEffect;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new UtilKt$loadResolvedEffect$job$1$localAsset$1(this.$effect, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super ArchiveEntryBytes> continuation) {
        return ((UtilKt$loadResolvedEffect$job$1$localAsset$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i != 0) {
            if (i == 1) {
                ResultKt.throwOnFailure(obj);
                return obj;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        this.label = 1;
        Object archiveEntryBytesWithFormat = UtilsKt.getArchiveEntryBytesWithFormat("effects", this.$effect.getFileName(), this);
        return archiveEntryBytesWithFormat == coroutine_suspended ? coroutine_suspended : archiveEntryBytesWithFormat;
    }
}
