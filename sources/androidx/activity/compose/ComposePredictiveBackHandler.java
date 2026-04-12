package androidx.activity.compose;

import androidx.activity.BackEventCompat;
import androidx.activity.compose.internal.BackHandlerCompat;
import androidx.core.app.NotificationCompat;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;
import kotlinx.coroutines.channels.ChannelResult;
import kotlinx.coroutines.channels.SendChannel;
import kotlinx.coroutines.flow.Flow;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: PredictiveBackHandler.kt */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010$\u001a\u00020\u0012H\u0002J\u0010\u0010%\u001a\u00020\u00122\u0006\u0010&\u001a\u00020\rH\u0016J\u0010\u0010'\u001a\u00020\u00122\u0006\u0010&\u001a\u00020\rH\u0016J\b\u0010(\u001a\u00020\u0012H\u0016J\b\u0010)\u001a\u00020\u0012H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tRM\u0010\n\u001a3\b\u0001\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\r0\f¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u0011\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u000bX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0018\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R$\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0019\u001a\u00020\u001a8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u0016\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010 X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010!\u001a\u0004\u0018\u00010\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006*"}, d2 = {"Landroidx/activity/compose/ComposePredictiveBackHandler;", "Landroidx/activity/compose/internal/BackHandlerCompat;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "info", "Landroidx/activity/compose/PredictiveBackHandlerInfo;", "<init>", "(Lkotlinx/coroutines/CoroutineScope;Landroidx/activity/compose/PredictiveBackHandlerInfo;)V", "getScope", "()Lkotlinx/coroutines/CoroutineScope;", "currentOnBack", "Lkotlin/Function2;", "Lkotlinx/coroutines/flow/Flow;", "Landroidx/activity/BackEventCompat;", "Lkotlin/ParameterName;", "name", "progress", "Lkotlin/coroutines/Continuation;", "", "", "getCurrentOnBack", "()Lkotlin/jvm/functions/Function2;", "setCurrentOnBack", "(Lkotlin/jvm/functions/Function2;)V", "Lkotlin/jvm/functions/Function2;", "value", "", "isBackEnabled", "()Z", "setBackEnabled", "(Z)V", "activeChannel", "Lkotlinx/coroutines/channels/Channel;", "activeJob", "Lkotlinx/coroutines/Job;", "isPredictiveBack", "launchNewGesture", "onBackStarted", NotificationCompat.CATEGORY_EVENT, "onBackProgressed", "onBackCompleted", "onBackCancelled", "activity-compose"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ComposePredictiveBackHandler extends BackHandlerCompat {
    private Channel<BackEventCompat> activeChannel;
    private Job activeJob;
    private Function2<? super Flow<BackEventCompat>, ? super Continuation<? super Unit>, ? extends Object> currentOnBack;
    private boolean isPredictiveBack;
    private final CoroutineScope scope;

    public final CoroutineScope getScope() {
        return this.scope;
    }

    public ComposePredictiveBackHandler(CoroutineScope coroutineScope, PredictiveBackHandlerInfo predictiveBackHandlerInfo) {
        super(predictiveBackHandlerInfo);
        this.scope = coroutineScope;
        this.currentOnBack = new ComposePredictiveBackHandler$currentOnBack$1(null);
    }

    public final Function2<Flow<BackEventCompat>, Continuation<? super Unit>, Object> getCurrentOnBack() {
        return this.currentOnBack;
    }

    public final void setCurrentOnBack(Function2<? super Flow<BackEventCompat>, ? super Continuation<? super Unit>, ? extends Object> function2) {
        this.currentOnBack = function2;
    }

    @Override // androidx.activity.compose.internal.BackHandlerCompat
    public boolean isBackEnabled() {
        return super.isBackEnabled();
    }

    @Override // androidx.activity.compose.internal.BackHandlerCompat
    public void setBackEnabled(boolean z) {
        Job job;
        if (!z && super.isBackEnabled() && (job = this.activeJob) != null && !job.isActive()) {
            onBackCancelled();
        }
        super.setBackEnabled(z);
    }

    private final void launchNewGesture() {
        Job launch$default;
        this.activeChannel = ChannelKt.Channel$default(-2, BufferOverflow.SUSPEND, null, 4, null);
        launch$default = BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new ComposePredictiveBackHandler$launchNewGesture$1(this, null), 3, null);
        this.activeJob = launch$default;
    }

    @Override // androidx.activity.compose.internal.BackHandlerCompat
    public void onBackStarted(BackEventCompat backEventCompat) {
        onBackCancelled();
        if (isBackEnabled()) {
            this.isPredictiveBack = true;
            launchNewGesture();
        }
    }

    @Override // androidx.activity.compose.internal.BackHandlerCompat
    public void onBackProgressed(BackEventCompat backEventCompat) {
        Channel<BackEventCompat> channel = this.activeChannel;
        if (channel != null) {
            ChannelResult.m10710boximpl(channel.mo8396trySendJP2dKIU(backEventCompat));
        }
    }

    @Override // androidx.activity.compose.internal.BackHandlerCompat
    public void onBackCompleted() {
        if (this.activeChannel != null && !this.isPredictiveBack) {
            onBackCancelled();
        }
        if (this.activeChannel == null) {
            this.isPredictiveBack = false;
            launchNewGesture();
        }
        Channel<BackEventCompat> channel = this.activeChannel;
        if (channel != null) {
            SendChannel.DefaultImpls.close$default(channel, null, 1, null);
        }
        this.isPredictiveBack = false;
    }

    @Override // androidx.activity.compose.internal.BackHandlerCompat
    public void onBackCancelled() {
        Channel<BackEventCompat> channel = this.activeChannel;
        if (channel != null) {
            channel.cancel(new CancellationException("onBack cancelled"));
        }
        Job job = this.activeJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        this.activeChannel = null;
        this.activeJob = null;
        this.isPredictiveBack = false;
    }
}
