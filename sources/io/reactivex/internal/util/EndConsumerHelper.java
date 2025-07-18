package io.reactivex.internal.util;

import androidx.compose.animation.core.MutatorMutex$$ExternalSyntheticBackportWithForwarding0;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.ProtocolViolationException;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscription;
/* loaded from: classes3.dex */
public final class EndConsumerHelper {
    private EndConsumerHelper() {
        throw new IllegalStateException("No instances!");
    }

    public static boolean validate(Disposable disposable, Disposable disposable2, Class<?> cls) {
        ObjectHelper.requireNonNull(disposable2, "next is null");
        if (disposable != null) {
            disposable2.dispose();
            if (disposable != DisposableHelper.DISPOSED) {
                reportDoubleSubscription(cls);
                return false;
            }
            return false;
        }
        return true;
    }

    public static boolean setOnce(AtomicReference<Disposable> atomicReference, Disposable disposable, Class<?> cls) {
        ObjectHelper.requireNonNull(disposable, "next is null");
        if (MutatorMutex$$ExternalSyntheticBackportWithForwarding0.m(atomicReference, null, disposable)) {
            return true;
        }
        disposable.dispose();
        if (atomicReference.get() != DisposableHelper.DISPOSED) {
            reportDoubleSubscription(cls);
            return false;
        }
        return false;
    }

    public static boolean validate(Subscription subscription, Subscription subscription2, Class<?> cls) {
        ObjectHelper.requireNonNull(subscription2, "next is null");
        if (subscription != null) {
            subscription2.cancel();
            if (subscription != SubscriptionHelper.CANCELLED) {
                reportDoubleSubscription(cls);
                return false;
            }
            return false;
        }
        return true;
    }

    public static boolean setOnce(AtomicReference<Subscription> atomicReference, Subscription subscription, Class<?> cls) {
        ObjectHelper.requireNonNull(subscription, "next is null");
        if (MutatorMutex$$ExternalSyntheticBackportWithForwarding0.m(atomicReference, null, subscription)) {
            return true;
        }
        subscription.cancel();
        if (atomicReference.get() != SubscriptionHelper.CANCELLED) {
            reportDoubleSubscription(cls);
            return false;
        }
        return false;
    }

    public static String composeMessage(String str) {
        return "It is not allowed to subscribe with a(n) " + str + " multiple times. Please create a fresh instance of " + str + " and subscribe that to the target source instead.";
    }

    public static void reportDoubleSubscription(Class<?> cls) {
        RxJavaPlugins.onError(new ProtocolViolationException(composeMessage(cls.getName())));
    }
}
