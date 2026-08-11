package ru.mrlargha.commonui.elements.inventory.presentation;

import android.widget.ImageView;
import androidx.media3.extractor.ts.TsExtractor;
import com.miami.game.core.connection.resolver.FirebaseConfigHelper;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import ru.mrlargha.commonui.utils.ArchiveEntryBytes;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: util.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 4, 0}, xi = 48)
@DebugMetadata(c = "ru.mrlargha.commonui.elements.inventory.presentation.UtilKt$loadResolvedEffect$job$1", f = "util.kt", i = {0}, l = {127}, m = "invokeSuspend", n = {"$this$launch"}, nl = {TsExtractor.TS_STREAM_TYPE_HDMV_DTS}, s = {"L$0"}, v = 2)
/* loaded from: classes6.dex */
public final class UtilKt$loadResolvedEffect$job$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ResolvedInventoryEffect $effect;
    final /* synthetic */ ImageView $effectImage;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UtilKt$loadResolvedEffect$job$1(ImageView imageView, ResolvedInventoryEffect resolvedInventoryEffect, Continuation<? super UtilKt$loadResolvedEffect$job$1> continuation) {
        super(2, continuation);
        this.$effectImage = imageView;
        this.$effect = resolvedInventoryEffect;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        UtilKt$loadResolvedEffect$job$1 utilKt$loadResolvedEffect$job$1 = new UtilKt$loadResolvedEffect$job$1(this.$effectImage, this.$effect, continuation);
        utilKt$loadResolvedEffect$job$1.L$0 = obj;
        return utilKt$loadResolvedEffect$job$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((UtilKt$loadResolvedEffect$job$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.L$0 = coroutineScope;
            this.label = 1;
            obj = BuildersKt.withContext(Dispatchers.getIO(), new UtilKt$loadResolvedEffect$job$1$localAsset$1(this.$effect, null), this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            ResultKt.throwOnFailure(obj);
        }
        ArchiveEntryBytes archiveEntryBytes = (ArchiveEntryBytes) obj;
        if (CoroutineScopeKt.isActive(coroutineScope)) {
            if (archiveEntryBytes.getBytes() != null) {
                UtilKt.loadEffectModel(this.$effectImage, archiveEntryBytes.getBytes());
            } else if (archiveEntryBytes.getExists()) {
                this.$effectImage.setImageDrawable(null);
                this.$effectImage.setVisibility(8);
            } else {
                UtilKt.loadEffectModel(this.$effectImage, StringsKt.trimEnd(FirebaseConfigHelper.getProjectResourceUrl$default(FirebaseConfigHelper.INSTANCE, false, 1, null), '/') + "/assets/images/inventory/effects/" + this.$effect.getFileName());
            }
            return Unit.INSTANCE;
        }
        return Unit.INSTANCE;
    }
}
