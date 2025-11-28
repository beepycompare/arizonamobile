package androidx.activity.compose.internal;

import androidx.activity.BackEventCompat;
import androidx.activity.OnBackPressedCallback;
import androidx.core.app.NotificationCompat;
import androidx.navigationevent.NavigationEvent;
import androidx.navigationevent.NavigationEventHandler;
import androidx.navigationevent.NavigationEventInfo;
import kotlin.Metadata;
/* compiled from: BackHandlerCompat.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b!\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\f\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\r\u001a\u00020\tH&J\b\u0010\u000e\u001a\u00020\tH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R$\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u00108W@WX\u0096\u000e¢\u0006\f\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0015\u001a\u00020\u0016¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0017\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00030\u001a¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001c¨\u0006\u001d"}, d2 = {"Landroidx/activity/compose/internal/BackHandlerCompat;", "", "info", "Landroidx/navigationevent/NavigationEventInfo;", "<init>", "(Landroidx/navigationevent/NavigationEventInfo;)V", "getInfo", "()Landroidx/navigationevent/NavigationEventInfo;", "onBackStarted", "", NotificationCompat.CATEGORY_EVENT, "Landroidx/activity/BackEventCompat;", "onBackProgressed", "onBackCompleted", "onBackCancelled", "value", "", "isBackEnabled", "()Z", "setBackEnabled", "(Z)V", "onBackPressedCallback", "Landroidx/activity/OnBackPressedCallback;", "getOnBackPressedCallback", "()Landroidx/activity/OnBackPressedCallback;", "navigationEventHandler", "Landroidx/navigationevent/NavigationEventHandler;", "getNavigationEventHandler", "()Landroidx/navigationevent/NavigationEventHandler;", "activity-compose"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class BackHandlerCompat {
    public static final int $stable = 8;
    private final NavigationEventInfo info;
    private final NavigationEventHandler<NavigationEventInfo> navigationEventHandler;
    private final OnBackPressedCallback onBackPressedCallback = new OnBackPressedCallback() { // from class: androidx.activity.compose.internal.BackHandlerCompat$onBackPressedCallback$1
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(false);
        }

        @Override // androidx.activity.OnBackPressedCallback
        public void handleOnBackStarted(BackEventCompat backEventCompat) {
            BackHandlerCompat.this.onBackStarted(backEventCompat);
        }

        @Override // androidx.activity.OnBackPressedCallback
        public void handleOnBackProgressed(BackEventCompat backEventCompat) {
            BackHandlerCompat.this.onBackProgressed(backEventCompat);
        }

        @Override // androidx.activity.OnBackPressedCallback
        public void handleOnBackPressed() {
            BackHandlerCompat.this.onBackCompleted();
        }

        @Override // androidx.activity.OnBackPressedCallback
        public void handleOnBackCancelled() {
            BackHandlerCompat.this.onBackCancelled();
        }
    };

    public void onBackCancelled() {
    }

    public abstract void onBackCompleted();

    public void onBackProgressed(BackEventCompat backEventCompat) {
    }

    public void onBackStarted(BackEventCompat backEventCompat) {
    }

    public BackHandlerCompat(final NavigationEventInfo navigationEventInfo) {
        this.info = navigationEventInfo;
        this.navigationEventHandler = new NavigationEventHandler<NavigationEventInfo>(navigationEventInfo) { // from class: androidx.activity.compose.internal.BackHandlerCompat$navigationEventHandler$1
            @Override // androidx.navigationevent.NavigationEventHandler
            protected void onBackStarted(NavigationEvent navigationEvent) {
                BackHandlerCompat.this.onBackStarted(new BackEventCompat(navigationEvent));
            }

            @Override // androidx.navigationevent.NavigationEventHandler
            protected void onBackProgressed(NavigationEvent navigationEvent) {
                BackHandlerCompat.this.onBackProgressed(new BackEventCompat(navigationEvent));
            }

            @Override // androidx.navigationevent.NavigationEventHandler
            protected void onBackCompleted() {
                BackHandlerCompat.this.onBackCompleted();
            }

            @Override // androidx.navigationevent.NavigationEventHandler
            protected void onBackCancelled() {
                BackHandlerCompat.this.onBackCancelled();
            }
        };
    }

    public final NavigationEventInfo getInfo() {
        return this.info;
    }

    public boolean isBackEnabled() {
        return this.onBackPressedCallback.isEnabled() && this.navigationEventHandler.isBackEnabled();
    }

    public void setBackEnabled(boolean z) {
        this.onBackPressedCallback.setEnabled(z);
        this.navigationEventHandler.setBackEnabled(z);
    }

    public final OnBackPressedCallback getOnBackPressedCallback() {
        return this.onBackPressedCallback;
    }

    public final NavigationEventHandler<NavigationEventInfo> getNavigationEventHandler() {
        return this.navigationEventHandler;
    }
}
