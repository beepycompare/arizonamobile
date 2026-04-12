package com.miami.game.core.design.system.component.background;

import android.graphics.Bitmap;
import android.util.Log;
import androidx.compose.runtime.ComposerImplKt;
import androidx.compose.ui.graphics.AndroidImageBitmap_androidKt;
import androidx.compose.ui.graphics.ImageBitmap;
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
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import okhttp3.internal.ws.WebSocketProtocol;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: BackgroundManager.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
@DebugMetadata(c = "com.miami.game.core.design.system.component.background.LauncherBackgroundWriter$loadLocal$1", f = "BackgroundManager.kt", i = {0, 0, 0}, l = {ComposerImplKt.nodeKey}, m = "invokeSuspend", n = {"$this$launch", "file", "bmp"}, nl = {WebSocketProtocol.PAYLOAD_SHORT}, s = {"L$0", "L$1", "L$2"}, v = 2)
/* loaded from: classes4.dex */
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

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        File ensureDir;
        Bitmap decodeBitmapSafe;
        Object emitNew;
        Bitmap decodeBitmapSafe2;
        CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Log.d("LauncherBgWriter", "loadLocal: start");
                LauncherBackgroundWriter.INSTANCE.ensureDefaultExists();
                File currentTargetFile = LauncherBackgroundWriter.INSTANCE.currentTargetFile();
                if (!currentTargetFile.exists() || currentTargetFile.length() <= 0) {
                    ensureDir = LauncherBackgroundWriter.INSTANCE.ensureDir();
                    currentTargetFile = new File(ensureDir, "background_home.webp");
                    Log.d("LauncherBgWriter", "loadLocal: current file missing/empty, fallback default=" + currentTargetFile.getAbsolutePath());
                    LauncherBackgroundWriter.INSTANCE.ensureDefaultExists();
                } else {
                    Log.d("LauncherBgWriter", "loadLocal: using current file=" + currentTargetFile.getAbsolutePath());
                }
                decodeBitmapSafe = LauncherBackgroundWriter.INSTANCE.decodeBitmapSafe(currentTargetFile, this.$maxSidePx);
                if (decodeBitmapSafe == null) {
                    int i2 = this.$maxSidePx;
                    Log.e("LauncherBgWriter", "loadLocal: decode failed for file=" + currentTargetFile.getAbsolutePath());
                    if (Intrinsics.areEqual(currentTargetFile.getName(), "background_home.webp")) {
                        Log.d("LauncherBgWriter", "loadLocal: restoring default asset to file=" + currentTargetFile.getAbsolutePath());
                        LauncherBackgroundWriter.INSTANCE.writeAssetToFileAtomically(currentTargetFile);
                        decodeBitmapSafe2 = LauncherBackgroundWriter.INSTANCE.decodeBitmapSafe(currentTargetFile, i2);
                        decodeBitmapSafe = decodeBitmapSafe2;
                    } else {
                        decodeBitmapSafe = null;
                    }
                }
                Log.d("LauncherBgWriter", "loadLocal: emit file=" + currentTargetFile.getAbsolutePath() + ", bitmapNull=" + (decodeBitmapSafe == null));
                LauncherBackgroundWriter launcherBackgroundWriter = LauncherBackgroundWriter.INSTANCE;
                ImageBitmap asImageBitmap = decodeBitmapSafe != null ? AndroidImageBitmap_androidKt.asImageBitmap(decodeBitmapSafe) : null;
                this.L$0 = SpillingKt.nullOutSpilledVariable(coroutineScope);
                this.L$1 = SpillingKt.nullOutSpilledVariable(currentTargetFile);
                this.L$2 = SpillingKt.nullOutSpilledVariable(decodeBitmapSafe);
                this.label = 1;
                emitNew = launcherBackgroundWriter.emitNew(currentTargetFile, asImageBitmap, this);
                if (emitNew == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                Bitmap bitmap = (Bitmap) this.L$2;
                File file = (File) this.L$1;
                ResultKt.throwOnFailure(obj);
            }
        } catch (Throwable th) {
            Log.e("LauncherBgWriter", "loadLocal: error", th);
        }
        return Unit.INSTANCE;
    }
}
