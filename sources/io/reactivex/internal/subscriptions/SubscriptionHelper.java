package io.reactivex.internal.subscriptions;

import androidx.compose.animation.core.MutatorMutex$$ExternalSyntheticBackportWithForwarding0;
import io.reactivex.exceptions.ProtocolViolationException;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscription;
/* loaded from: classes3.dex */
public enum SubscriptionHelper implements Subscription {
    CANCELLED;

    @Override // org.reactivestreams.Subscription
    public void cancel() {
    }

    @Override // org.reactivestreams.Subscription
    public void request(long j) {
    }

    public static boolean validate(Subscription subscription, Subscription subscription2) {
        if (subscription2 == null) {
            RxJavaPlugins.onError(new NullPointerException("next is null"));
            return false;
        } else if (subscription != null) {
            subscription2.cancel();
            reportSubscriptionSet();
            return false;
        } else {
            return true;
        }
    }

    public static void reportSubscriptionSet() {
        RxJavaPlugins.onError(new ProtocolViolationException("Subscription already set!"));
    }

    public static boolean validate(long j) {
        if (j <= 0) {
            RxJavaPlugins.onError(new IllegalArgumentException("n > 0 required but it was " + j));
            return false;
        }
        return true;
    }

    public static void reportMoreProduced(long j) {
        RxJavaPlugins.onError(new ProtocolViolationException("More produced than requested: " + j));
    }

    public static boolean set(AtomicReference<Subscription> atomicReference, Subscription subscription) {
        Subscription subscription2;
        do {
            subscription2 = atomicReference.get();
            if (subscription2 == CANCELLED) {
                if (subscription != null) {
                    subscription.cancel();
                    return false;
                }
                return false;
            }
        } while (!MutatorMutex$$ExternalSyntheticBackportWithForwarding0.m(atomicReference, subscription2, subscription));
        if (subscription2 != null) {
            subscription2.cancel();
            return true;
        }
        return true;
    }

    public static boolean setOnce(AtomicReference<Subscription> atomicReference, Subscription subscription) {
        ObjectHelper.requireNonNull(subscription, "s is null");
        if (MutatorMutex$$ExternalSyntheticBackportWithForwarding0.m(atomicReference, null, subscription)) {
            return true;
        }
        subscription.cancel();
        if (atomicReference.get() != CANCELLED) {
            reportSubscriptionSet();
            return false;
        }
        return false;
    }

    public static boolean replace(AtomicReference<Subscription> atomicReference, Subscription subscription) {
        Subscription subscription2;
        do {
            subscription2 = atomicReference.get();
            if (subscription2 == CANCELLED) {
                if (subscription != null) {
                    subscription.cancel();
                    return false;
                }
                return false;
            }
        } while (!MutatorMutex$$ExternalSyntheticBackportWithForwarding0.m(atomicReference, subscription2, subscription));
        return true;
    }

    public static boolean cancel(AtomicReference<Subscription> atomicReference) {
        Subscription andSet;
        Subscription subscription = atomicReference.get();
        SubscriptionHelper subscriptionHelper = CANCELLED;
        if (subscription == subscriptionHelper || (andSet = atomicReference.getAndSet(subscriptionHelper)) == subscriptionHelper) {
            return false;
        }
        if (andSet != null) {
            andSet.cancel();
            return true;
        }
        return true;
    }

    public static boolean deferredSetOnce(AtomicReference<Subscription> atomicReference, AtomicLong atomicLong, Subscription subscription) {
        if (setOnce(atomicReference, subscription)) {
            long andSet = atomicLong.getAndSet(0L);
            if (andSet != 0) {
                subscription.request(andSet);
                return true;
            }
            return true;
        }
        return false;
    }

    public static void deferredRequest(AtomicReference<Subscription> atomicReference, AtomicLong atomicLong, long j) {
        Subscription subscription = atomicReference.get();
        if (subscription != null) {
            subscription.request(j);
        } else if (validate(j)) {
            BackpressureHelper.add(atomicLong, j);
            Subscription subscription2 = atomicReference.get();
            if (subscription2 != null) {
                long andSet = atomicLong.getAndSet(0L);
                if (andSet != 0) {
                    subscription2.request(andSet);
                }
            }
        }
    }

    public static boolean setOnce(AtomicReference<Subscription> atomicReference, Subscription subscription, long j) {
        if (setOnce(atomicReference, subscription)) {
            subscription.request(j);
            return true;
        }
        return false;
    }
}
