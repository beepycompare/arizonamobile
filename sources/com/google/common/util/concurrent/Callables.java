package com.google.common.util.concurrent;

import com.google.common.base.Preconditions;
import com.google.common.base.Supplier;
import java.util.concurrent.Callable;
@ElementTypesAreNonnullByDefault
/* loaded from: classes4.dex */
public final class Callables {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Object lambda$returning$0(Object obj) throws Exception {
        return obj;
    }

    private Callables() {
    }

    public static <T> Callable<T> returning(@ParametricNullness final T value) {
        return new Callable() { // from class: com.google.common.util.concurrent.Callables$$ExternalSyntheticLambda2
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return Callables.lambda$returning$0(value);
            }
        };
    }

    public static <T> AsyncCallable<T> asAsyncCallable(final Callable<T> callable, final ListeningExecutorService listeningExecutorService) {
        Preconditions.checkNotNull(callable);
        Preconditions.checkNotNull(listeningExecutorService);
        return new AsyncCallable() { // from class: com.google.common.util.concurrent.Callables$$ExternalSyntheticLambda1
            @Override // com.google.common.util.concurrent.AsyncCallable
            public final ListenableFuture call() {
                ListenableFuture submit;
                submit = ListeningExecutorService.this.submit(callable);
                return submit;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> Callable<T> threadRenaming(final Callable<T> callable, final Supplier<String> nameSupplier) {
        Preconditions.checkNotNull(nameSupplier);
        Preconditions.checkNotNull(callable);
        return new Callable() { // from class: com.google.common.util.concurrent.Callables$$ExternalSyntheticLambda0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return Callables.lambda$threadRenaming$2(Supplier.this, callable);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Object lambda$threadRenaming$2(Supplier supplier, Callable callable) throws Exception {
        Thread currentThread = Thread.currentThread();
        String name = currentThread.getName();
        boolean trySetName = trySetName((String) supplier.get(), currentThread);
        try {
            return callable.call();
        } finally {
            if (trySetName) {
                trySetName(name, currentThread);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Runnable threadRenaming(final Runnable task, final Supplier<String> nameSupplier) {
        Preconditions.checkNotNull(nameSupplier);
        Preconditions.checkNotNull(task);
        return new Runnable() { // from class: com.google.common.util.concurrent.Callables$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                Callables.lambda$threadRenaming$3(Supplier.this, task);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$threadRenaming$3(Supplier supplier, Runnable runnable) {
        Thread currentThread = Thread.currentThread();
        String name = currentThread.getName();
        boolean trySetName = trySetName((String) supplier.get(), currentThread);
        try {
            runnable.run();
        } finally {
            if (trySetName) {
                trySetName(name, currentThread);
            }
        }
    }

    private static boolean trySetName(String threadName, Thread currentThread) {
        try {
            currentThread.setName(threadName);
            return true;
        } catch (SecurityException unused) {
            return false;
        }
    }
}
