package ru.rustore.sdk.activitylauncher;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Build;
import android.os.Bundle;
import android.os.ResultReceiver;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: RuStoreActivityLauncher.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0005¢\u0006\u0002\u0010\u0002J\"\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0014J\u0012\u0010\f\u001a\u00020\u00062\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0014J\u001a\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\b2\b\u0010\u0011\u001a\u0004\u0018\u00010\u000eH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lru/rustore/sdk/activitylauncher/RuStoreActivityLauncher;", "Landroid/app/Activity;", "()V", "resultReceiver", "Landroid/os/ResultReceiver;", "onActivityResult", "", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "sendResult", "code", "bundle", "Companion", "sdk-public-activitylauncher_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class RuStoreActivityLauncher extends Activity {
    public static final Companion Companion = new Companion(null);
    private static final String KEY_CONFIRMATION_PENDING_INTENT = "CONFIRMATION_PENDING_INTENT";
    private static final String KEY_RESULT_RECEIVER = "RESULT_RECEIVER";
    private static final int RC_CONFIRM = 0;
    private ResultReceiver resultReceiver;

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        Object parcelableExtra;
        Object parcelableExtra2;
        super.onCreate(bundle);
        Intent intent = getIntent();
        Intrinsics.checkNotNullExpressionValue(intent, "intent");
        if (Build.VERSION.SDK_INT >= 33) {
            parcelableExtra = intent.getParcelableExtra(KEY_RESULT_RECEIVER, ResultReceiver.class);
            if (parcelableExtra == null) {
                throw new IllegalArgumentException("Required value was null.".toString());
            }
        } else {
            parcelableExtra = intent.getParcelableExtra(KEY_RESULT_RECEIVER);
            if (parcelableExtra == null) {
                throw new IllegalArgumentException("Required value was null.".toString());
            }
        }
        this.resultReceiver = (ResultReceiver) parcelableExtra;
        if (bundle == null) {
            Intent intent2 = getIntent();
            Intrinsics.checkNotNullExpressionValue(intent2, "intent");
            if (Build.VERSION.SDK_INT >= 33) {
                parcelableExtra2 = intent2.getParcelableExtra(KEY_CONFIRMATION_PENDING_INTENT, PendingIntent.class);
                if (parcelableExtra2 == null) {
                    throw new IllegalArgumentException("Required value was null.".toString());
                }
            } else {
                parcelableExtra2 = intent2.getParcelableExtra(KEY_CONFIRMATION_PENDING_INTENT);
                if (parcelableExtra2 == null) {
                    throw new IllegalArgumentException("Required value was null.".toString());
                }
            }
            try {
                startIntentSenderForResult(((PendingIntent) parcelableExtra2).getIntentSender(), 0, null, 0, 0, 0);
            } catch (ActivityNotFoundException unused) {
                sendResult(2, null);
            } catch (IntentSender.SendIntentException unused2) {
                sendResult(9901, null);
            } catch (Exception unused3) {
                sendResult(9902, null);
            }
        }
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 0) {
            sendResult(i2, intent != null ? intent.getExtras() : null);
        }
    }

    private final void sendResult(int i, Bundle bundle) {
        ResultReceiver resultReceiver = this.resultReceiver;
        if (resultReceiver == null) {
            Intrinsics.throwUninitializedPropertyAccessException("resultReceiver");
            resultReceiver = null;
        }
        resultReceiver.send(i, bundle);
        finish();
    }

    /* compiled from: RuStoreActivityLauncher.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0080\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J%\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\tH\u0000¢\u0006\u0002\b\u000fR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lru/rustore/sdk/activitylauncher/RuStoreActivityLauncher$Companion;", "", "()V", "KEY_CONFIRMATION_PENDING_INTENT", "", "KEY_RESULT_RECEIVER", "RC_CONFIRM", "", "getIntent", "Landroid/content/Intent;", "context", "Landroid/content/Context;", "resultReceiver", "Landroid/os/ResultReceiver;", "confirmationIntent", "getIntent$sdk_public_activitylauncher_release", "sdk-public-activitylauncher_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Intent getIntent$sdk_public_activitylauncher_release(Context context, ResultReceiver resultReceiver, Intent confirmationIntent) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(resultReceiver, "resultReceiver");
            Intrinsics.checkNotNullParameter(confirmationIntent, "confirmationIntent");
            Intent intent = new Intent(context, RuStoreActivityLauncher.class);
            if (!(context instanceof Activity)) {
                intent.setFlags(268435456);
            }
            intent.putExtra(RuStoreActivityLauncher.KEY_RESULT_RECEIVER, resultReceiver);
            intent.putExtra(RuStoreActivityLauncher.KEY_CONFIRMATION_PENDING_INTENT, PendingIntent.getActivity(context, 0, confirmationIntent, 1140850688));
            return intent;
        }
    }
}
