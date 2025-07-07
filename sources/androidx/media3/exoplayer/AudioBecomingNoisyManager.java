package androidx.media3.exoplayer;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Looper;
import androidx.media3.common.util.Clock;
import androidx.media3.common.util.HandlerWrapper;
import androidx.media3.exoplayer.AudioBecomingNoisyManager;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class AudioBecomingNoisyManager {
    private final HandlerWrapper backgroundHandler;
    private final Context context;
    private boolean isEnabled;
    private final AudioBecomingNoisyReceiver receiver;

    /* loaded from: classes2.dex */
    public interface EventListener {
        void onAudioBecomingNoisy();
    }

    public AudioBecomingNoisyManager(Context context, Looper looper, Looper looper2, EventListener eventListener, Clock clock) {
        this.context = context.getApplicationContext();
        this.backgroundHandler = clock.createHandler(looper, null);
        this.receiver = new AudioBecomingNoisyReceiver(clock.createHandler(looper2, null), eventListener);
    }

    public void setEnabled(boolean z) {
        if (z == this.isEnabled) {
            return;
        }
        if (z) {
            this.backgroundHandler.post(new Runnable() { // from class: androidx.media3.exoplayer.AudioBecomingNoisyManager$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    AudioBecomingNoisyManager.this.m7307xd3e553();
                }
            });
            this.isEnabled = true;
            return;
        }
        this.backgroundHandler.post(new Runnable() { // from class: androidx.media3.exoplayer.AudioBecomingNoisyManager$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                AudioBecomingNoisyManager.this.m7308x8e0e96d4();
            }
        });
        this.isEnabled = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$setEnabled$0$androidx-media3-exoplayer-AudioBecomingNoisyManager  reason: not valid java name */
    public /* synthetic */ void m7307xd3e553() {
        this.context.registerReceiver(this.receiver, new IntentFilter("android.media.AUDIO_BECOMING_NOISY"));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$setEnabled$1$androidx-media3-exoplayer-AudioBecomingNoisyManager  reason: not valid java name */
    public /* synthetic */ void m7308x8e0e96d4() {
        this.context.unregisterReceiver(this.receiver);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public final class AudioBecomingNoisyReceiver extends BroadcastReceiver {
        private final HandlerWrapper eventHandler;
        private final EventListener listener;

        public AudioBecomingNoisyReceiver(HandlerWrapper handlerWrapper, EventListener eventListener) {
            this.eventHandler = handlerWrapper;
            this.listener = eventListener;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if ("android.media.AUDIO_BECOMING_NOISY".equals(intent.getAction())) {
                this.eventHandler.post(new Runnable() { // from class: androidx.media3.exoplayer.AudioBecomingNoisyManager$AudioBecomingNoisyReceiver$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        AudioBecomingNoisyManager.AudioBecomingNoisyReceiver.this.callListenerIfEnabled();
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void callListenerIfEnabled() {
            if (AudioBecomingNoisyManager.this.isEnabled) {
                this.listener.onAudioBecomingNoisy();
            }
        }
    }
}
