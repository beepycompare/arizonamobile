package defpackage;

import android.graphics.Bitmap;
import androidx.compose.ui.graphics.AndroidImageBitmap_androidKt;
import androidx.media3.container.MdtaMetadataEntry;
import java.io.File;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: BackgroundManager.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
@DebugMetadata(c = "LauncherBackgroundWriter$loadLocal$1", f = "BackgroundManager.kt", i = {0, 0, 0, 1, 1, 1}, l = {MdtaMetadataEntry.TYPE_INDICATOR_UNSIGNED_INT64, 81}, m = "invokeSuspend", n = {"$this$launch", "file", "bmp", "$this$launch", "file", "bmp"}, nl = {81, 83}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2"}, v = 2)
/* renamed from: LauncherBackgroundWriter$loadLocal$1  reason: default package */
/* loaded from: classes2.dex */
public final class LauncherBackgroundWriter$loadLocal$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $maxSidePx;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LauncherBackgroundWriter$loadLocal$1(int i, Continuation<? super LauncherBackgroundWriter$loadLocal$1> continuation) {
        super(2, continuation);
        this.$maxSidePx = i;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        LauncherBackgroundWriter$loadLocal$1 launcherBackgroundWriter$loadLocal$1 = new LauncherBackgroundWriter$loadLocal$1(this.$maxSidePx, continuation);
        launcherBackgroundWriter$loadLocal$1.L$0 = obj;
        return launcherBackgroundWriter$loadLocal$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((LauncherBackgroundWriter$loadLocal$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x006f, code lost:
        if (r8 == r1) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0090, code lost:
        if (r8 == r1) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0092, code lost:
        return r1;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        Bitmap decodeBitmapSafe;
        Object emitNew;
        Object emitNew2;
        CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            LauncherBackgroundWriter.INSTANCE.ensureDefaultExists();
            File targetFile = LauncherBackgroundWriter.INSTANCE.targetFile();
            decodeBitmapSafe = LauncherBackgroundWriter.INSTANCE.decodeBitmapSafe(targetFile, this.$maxSidePx);
            if (decodeBitmapSafe == null) {
                int i2 = this.$maxSidePx;
                LauncherBackgroundWriter.INSTANCE.writeAssetToTargetAtomically(targetFile);
                decodeBitmapSafe = LauncherBackgroundWriter.INSTANCE.decodeBitmapSafe(targetFile, i2);
            }
            if (decodeBitmapSafe != null) {
                this.L$0 = SpillingKt.nullOutSpilledVariable(coroutineScope);
                this.L$1 = SpillingKt.nullOutSpilledVariable(targetFile);
                this.L$2 = SpillingKt.nullOutSpilledVariable(decodeBitmapSafe);
                this.label = 1;
                emitNew2 = LauncherBackgroundWriter.INSTANCE.emitNew(targetFile, AndroidImageBitmap_androidKt.asImageBitmap(decodeBitmapSafe), this);
            } else {
                this.L$0 = SpillingKt.nullOutSpilledVariable(coroutineScope);
                this.L$1 = SpillingKt.nullOutSpilledVariable(targetFile);
                this.L$2 = SpillingKt.nullOutSpilledVariable(decodeBitmapSafe);
                this.label = 2;
                emitNew = LauncherBackgroundWriter.INSTANCE.emitNew(targetFile, null, this);
            }
        } else if (i != 1 && i != 2) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            Bitmap bitmap = (Bitmap) this.L$2;
            File file = (File) this.L$1;
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
    }
}
