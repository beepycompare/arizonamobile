package com.arizona.launcher;

import android.util.Log;
import androidx.compose.runtime.ComposerKt;
import com.arizona.launcher.util.FileServers;
import com.miami.game.core.connection.resolver.FirebaseConfigHelper;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
/* compiled from: MainEntrench.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 4, 0}, xi = 48)
@DebugMetadata(c = "com.arizona.launcher.MainEntrench$onCreate$1", f = "MainEntrench.kt", i = {}, l = {ComposerKt.compositionLocalMapKey}, m = "invokeSuspend", n = {}, nl = {ComposerKt.providerValuesKey}, s = {}, v = 2)
/* loaded from: classes3.dex */
final class MainEntrench$onCreate$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ MainEntrench this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MainEntrench$onCreate$1(MainEntrench mainEntrench, Continuation<? super MainEntrench$onCreate$1> continuation) {
        super(2, continuation);
        this.this$0 = mainEntrench;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new MainEntrench$onCreate$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((MainEntrench$onCreate$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        StartupCheckGate startupCheckGate;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (FirebaseConfigHelper.INSTANCE.bootstrap(this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                ResultKt.throwOnFailure(obj);
            }
            FileServers.INSTANCE.refreshGameServers();
            FileServers.INSTANCE.refreshLauncherServers();
            FileServers.INSTANCE.warmUpAsync();
        } catch (CancellationException e) {
            throw e;
        } catch (Exception e2) {
            Log.w("MainEntrench", "File-server bootstrap failed; using local defaults", e2);
        }
        startupCheckGate = this.this$0.startupCheckGate;
        startupCheckGate.onConfigurationReady();
        return Unit.INSTANCE;
    }
}
