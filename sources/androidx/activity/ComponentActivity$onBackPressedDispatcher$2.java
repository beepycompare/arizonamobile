package androidx.activity;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ComponentActivity.kt */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroidx/activity/OnBackPressedDispatcher;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ComponentActivity$onBackPressedDispatcher$2 extends Lambda implements Function0<OnBackPressedDispatcher> {
    final /* synthetic */ ComponentActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ComponentActivity$onBackPressedDispatcher$2(ComponentActivity componentActivity) {
        super(0);
        this.this$0 = componentActivity;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final OnBackPressedDispatcher invoke() {
        final ComponentActivity componentActivity = this.this$0;
        final OnBackPressedDispatcher onBackPressedDispatcher = new OnBackPressedDispatcher(new Runnable() { // from class: androidx.activity.ComponentActivity$onBackPressedDispatcher$2$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                ComponentActivity$onBackPressedDispatcher$2.invoke$lambda$0(ComponentActivity.this);
            }
        });
        final ComponentActivity componentActivity2 = this.this$0;
        if (Build.VERSION.SDK_INT >= 33) {
            if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) {
                componentActivity2.addObserverForBackInvoker(onBackPressedDispatcher);
            } else {
                new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: androidx.activity.ComponentActivity$onBackPressedDispatcher$2$$ExternalSyntheticLambda1
                    @Override // java.lang.Runnable
                    public final void run() {
                        ComponentActivity.access$addObserverForBackInvoker(ComponentActivity.this, onBackPressedDispatcher);
                    }
                });
                return onBackPressedDispatcher;
            }
        }
        return onBackPressedDispatcher;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invoke$lambda$0(ComponentActivity componentActivity) {
        try {
            super/*androidx.core.app.ComponentActivity*/.onBackPressed();
        } catch (IllegalStateException e) {
            if (!Intrinsics.areEqual(e.getMessage(), "Can not perform this action after onSaveInstanceState")) {
                throw e;
            }
        } catch (NullPointerException e2) {
            if (!Intrinsics.areEqual(e2.getMessage(), "Attempt to invoke virtual method 'android.os.Handler android.app.FragmentHostCallback.getHandler()' on a null object reference")) {
                throw e2;
            }
        }
    }
}
