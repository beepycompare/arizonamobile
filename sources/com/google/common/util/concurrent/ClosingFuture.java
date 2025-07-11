package com.google.common.util.concurrent;

import androidx.compose.animation.core.MutatorMutex$$ExternalSyntheticBackportWithForwarding0;
import com.google.common.base.Function;
import com.google.common.base.Functions;
import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.common.collect.FluentIterable;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.common.util.concurrent.Futures;
import com.google.errorprone.annotations.DoNotMock;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import java.io.Closeable;
import java.util.IdentityHashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicReference;
import java.util.logging.Level;
import javax.annotation.CheckForNull;
import kotlin.UByte$$ExternalSyntheticBackport0;
@DoNotMock("Use ClosingFuture.from(Futures.immediate*Future)")
@ElementTypesAreNonnullByDefault
/* loaded from: classes4.dex */
public final class ClosingFuture<V> {
    private static final LazyLogger logger = new LazyLogger(ClosingFuture.class);
    private final CloseableList closeables;
    private final FluentFuture<V> future;
    private final AtomicReference<State> state;

    /* loaded from: classes4.dex */
    public interface AsyncClosingCallable<V> {
        ClosingFuture<V> call(DeferredCloser closer) throws Exception;
    }

    /* loaded from: classes4.dex */
    public interface AsyncClosingFunction<T, U> {
        ClosingFuture<U> apply(DeferredCloser closer, @ParametricNullness T input) throws Exception;
    }

    /* loaded from: classes4.dex */
    public interface ClosingCallable<V> {
        @ParametricNullness
        V call(DeferredCloser closer) throws Exception;
    }

    /* loaded from: classes4.dex */
    public interface ClosingFunction<T, U> {
        @ParametricNullness
        U apply(DeferredCloser closer, @ParametricNullness T input) throws Exception;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public enum State {
        OPEN,
        SUBSUMED,
        WILL_CLOSE,
        CLOSING,
        CLOSED,
        WILL_CREATE_VALUE_AND_CLOSER
    }

    /* loaded from: classes4.dex */
    public interface ValueAndCloserConsumer<V> {
        void accept(ValueAndCloser<V> valueAndCloser);
    }

    /* loaded from: classes4.dex */
    public static final class DeferredCloser {
        private final CloseableList list;

        DeferredCloser(CloseableList list) {
            this.list = list;
        }

        @ParametricNullness
        public <C extends AutoCloseable> C eventuallyClose(@ParametricNullness C closeable, Executor closingExecutor) {
            Preconditions.checkNotNull(closingExecutor);
            if (closeable != null) {
                this.list.add(closeable, closingExecutor);
            }
            return closeable;
        }
    }

    /* loaded from: classes4.dex */
    public static final class ValueAndCloser<V> {
        private final ClosingFuture<? extends V> closingFuture;

        ValueAndCloser(ClosingFuture<? extends V> closingFuture) {
            this.closingFuture = (ClosingFuture) Preconditions.checkNotNull(closingFuture);
        }

        @ParametricNullness
        public V get() throws ExecutionException {
            return (V) Futures.getDone(((ClosingFuture) this.closingFuture).future);
        }

        public void closeAsync() {
            this.closingFuture.close();
        }
    }

    public static <V> ClosingFuture<V> submit(final ClosingCallable<V> callable, Executor executor) {
        Preconditions.checkNotNull(callable);
        final CloseableList closeableList = new CloseableList();
        TrustedListenableFutureTask create = TrustedListenableFutureTask.create(new Callable<V>() { // from class: com.google.common.util.concurrent.ClosingFuture.1
            @Override // java.util.concurrent.Callable
            @ParametricNullness
            public V call() throws Exception {
                return (V) ClosingCallable.this.call(closeableList.closer);
            }

            public String toString() {
                return ClosingCallable.this.toString();
            }
        });
        executor.execute(create);
        return new ClosingFuture<>(create, closeableList);
    }

    public static <V> ClosingFuture<V> submitAsync(final AsyncClosingCallable<V> callable, Executor executor) {
        Preconditions.checkNotNull(callable);
        final CloseableList closeableList = new CloseableList();
        TrustedListenableFutureTask create = TrustedListenableFutureTask.create(new AsyncCallable<V>() { // from class: com.google.common.util.concurrent.ClosingFuture.2
            @Override // com.google.common.util.concurrent.AsyncCallable
            public ListenableFuture<V> call() throws Exception {
                CloseableList closeableList2 = new CloseableList();
                try {
                    ClosingFuture<V> call = AsyncClosingCallable.this.call(closeableList2.closer);
                    call.becomeSubsumedInto(closeableList);
                    return ((ClosingFuture) call).future;
                } finally {
                    closeableList.add(closeableList2, MoreExecutors.directExecutor());
                }
            }

            public String toString() {
                return AsyncClosingCallable.this.toString();
            }
        });
        executor.execute(create);
        return new ClosingFuture<>(create, closeableList);
    }

    public static <V> ClosingFuture<V> from(ListenableFuture<V> future) {
        return new ClosingFuture<>(future);
    }

    @Deprecated
    public static <C extends AutoCloseable> ClosingFuture<C> eventuallyClosing(ListenableFuture<C> future, final Executor closingExecutor) {
        Preconditions.checkNotNull(closingExecutor);
        ClosingFuture<C> closingFuture = new ClosingFuture<>(Futures.nonCancellationPropagating(future));
        Futures.addCallback(future, new FutureCallback<AutoCloseable>() { // from class: com.google.common.util.concurrent.ClosingFuture.3
            @Override // com.google.common.util.concurrent.FutureCallback
            public void onFailure(Throwable t) {
            }

            @Override // com.google.common.util.concurrent.FutureCallback
            public void onSuccess(@CheckForNull AutoCloseable result) {
                ClosingFuture.this.closeables.closer.eventuallyClose(result, closingExecutor);
            }
        }, MoreExecutors.directExecutor());
        return closingFuture;
    }

    public static Combiner whenAllComplete(Iterable<? extends ClosingFuture<?>> futures) {
        return new Combiner(false, futures);
    }

    public static Combiner whenAllComplete(ClosingFuture<?> future1, ClosingFuture<?>... moreFutures) {
        return whenAllComplete(Lists.asList(future1, moreFutures));
    }

    public static Combiner whenAllSucceed(Iterable<? extends ClosingFuture<?>> futures) {
        return new Combiner(true, futures);
    }

    public static <V1, V2> Combiner2<V1, V2> whenAllSucceed(ClosingFuture<V1> future1, ClosingFuture<V2> future2) {
        return new Combiner2<>(future2);
    }

    public static <V1, V2, V3> Combiner3<V1, V2, V3> whenAllSucceed(ClosingFuture<V1> future1, ClosingFuture<V2> future2, ClosingFuture<V3> future3) {
        return new Combiner3<>(future2, future3);
    }

    public static <V1, V2, V3, V4> Combiner4<V1, V2, V3, V4> whenAllSucceed(ClosingFuture<V1> future1, ClosingFuture<V2> future2, ClosingFuture<V3> future3, ClosingFuture<V4> future4) {
        return new Combiner4<>(future2, future3, future4);
    }

    public static <V1, V2, V3, V4, V5> Combiner5<V1, V2, V3, V4, V5> whenAllSucceed(ClosingFuture<V1> future1, ClosingFuture<V2> future2, ClosingFuture<V3> future3, ClosingFuture<V4> future4, ClosingFuture<V5> future5) {
        return new Combiner5<>(future2, future3, future4, future5);
    }

    public static Combiner whenAllSucceed(ClosingFuture<?> future1, ClosingFuture<?> future2, ClosingFuture<?> future3, ClosingFuture<?> future4, ClosingFuture<?> future5, ClosingFuture<?> future6, ClosingFuture<?>... moreFutures) {
        return whenAllSucceed(FluentIterable.of(future1, future2, future3, future4, future5, future6).append(moreFutures));
    }

    private ClosingFuture(ListenableFuture<V> future) {
        this(future, new CloseableList());
    }

    private ClosingFuture(ListenableFuture<V> future, CloseableList closeables) {
        this.state = new AtomicReference<>(State.OPEN);
        this.future = FluentFuture.from(future);
        this.closeables = closeables;
    }

    public ListenableFuture<?> statusFuture() {
        return Futures.nonCancellationPropagating(this.future.transform(Functions.constant(null), MoreExecutors.directExecutor()));
    }

    public <U> ClosingFuture<U> transform(final ClosingFunction<? super V, U> function, Executor executor) {
        Preconditions.checkNotNull(function);
        return derive(this.future.transformAsync(new AsyncFunction<V, U>(this) { // from class: com.google.common.util.concurrent.ClosingFuture.4
            final /* synthetic */ ClosingFuture this$0;

            {
                this.this$0 = this;
            }

            @Override // com.google.common.util.concurrent.AsyncFunction
            public ListenableFuture<U> apply(V input) throws Exception {
                return this.this$0.closeables.applyClosingFunction(function, input);
            }

            public String toString() {
                return function.toString();
            }
        }, executor));
    }

    public <U> ClosingFuture<U> transformAsync(final AsyncClosingFunction<? super V, U> function, Executor executor) {
        Preconditions.checkNotNull(function);
        return derive(this.future.transformAsync(new AsyncFunction<V, U>(this) { // from class: com.google.common.util.concurrent.ClosingFuture.5
            final /* synthetic */ ClosingFuture this$0;

            {
                this.this$0 = this;
            }

            @Override // com.google.common.util.concurrent.AsyncFunction
            public ListenableFuture<U> apply(V input) throws Exception {
                return this.this$0.closeables.applyAsyncClosingFunction(function, input);
            }

            public String toString() {
                return function.toString();
            }
        }, executor));
    }

    public static <V, U> AsyncClosingFunction<V, U> withoutCloser(final AsyncFunction<V, U> function) {
        Preconditions.checkNotNull(function);
        return new AsyncClosingFunction<V, U>() { // from class: com.google.common.util.concurrent.ClosingFuture.6
            @Override // com.google.common.util.concurrent.ClosingFuture.AsyncClosingFunction
            public ClosingFuture<U> apply(DeferredCloser closer, V input) throws Exception {
                return ClosingFuture.from(AsyncFunction.this.apply(input));
            }
        };
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <X extends Throwable> ClosingFuture<V> catching(Class<X> exceptionType, ClosingFunction<? super X, ? extends V> fallback, Executor executor) {
        return catchingMoreGeneric(exceptionType, fallback, executor);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private <X extends Throwable, W extends V> ClosingFuture<V> catchingMoreGeneric(Class<X> exceptionType, final ClosingFunction<? super X, W> fallback, Executor executor) {
        Preconditions.checkNotNull(fallback);
        return (ClosingFuture<V>) derive(this.future.catchingAsync(exceptionType, new AsyncFunction<X, W>(this) { // from class: com.google.common.util.concurrent.ClosingFuture.7
            final /* synthetic */ ClosingFuture this$0;

            {
                this.this$0 = this;
            }

            /* JADX WARN: Incorrect types in method signature: (TX;)Lcom/google/common/util/concurrent/ListenableFuture<TW;>; */
            @Override // com.google.common.util.concurrent.AsyncFunction
            public ListenableFuture apply(Throwable exception) throws Exception {
                return this.this$0.closeables.applyClosingFunction(fallback, exception);
            }

            public String toString() {
                return fallback.toString();
            }
        }, executor));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <X extends Throwable> ClosingFuture<V> catchingAsync(Class<X> exceptionType, AsyncClosingFunction<? super X, ? extends V> fallback, Executor executor) {
        return catchingAsyncMoreGeneric(exceptionType, fallback, executor);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private <X extends Throwable, W extends V> ClosingFuture<V> catchingAsyncMoreGeneric(Class<X> exceptionType, final AsyncClosingFunction<? super X, W> fallback, Executor executor) {
        Preconditions.checkNotNull(fallback);
        return (ClosingFuture<V>) derive(this.future.catchingAsync(exceptionType, new AsyncFunction<X, W>(this) { // from class: com.google.common.util.concurrent.ClosingFuture.8
            final /* synthetic */ ClosingFuture this$0;

            {
                this.this$0 = this;
            }

            /* JADX WARN: Incorrect types in method signature: (TX;)Lcom/google/common/util/concurrent/ListenableFuture<TW;>; */
            @Override // com.google.common.util.concurrent.AsyncFunction
            public ListenableFuture apply(Throwable exception) throws Exception {
                return this.this$0.closeables.applyAsyncClosingFunction(fallback, exception);
            }

            public String toString() {
                return fallback.toString();
            }
        }, executor));
    }

    public FluentFuture<V> finishToFuture() {
        if (compareAndUpdateState(State.OPEN, State.WILL_CLOSE)) {
            logger.get().log(Level.FINER, "will close {0}", this);
            this.future.addListener(new Runnable() { // from class: com.google.common.util.concurrent.ClosingFuture.9
                @Override // java.lang.Runnable
                public void run() {
                    ClosingFuture.this.checkAndUpdateState(State.WILL_CLOSE, State.CLOSING);
                    ClosingFuture.this.close();
                    ClosingFuture.this.checkAndUpdateState(State.CLOSING, State.CLOSED);
                }
            }, MoreExecutors.directExecutor());
        } else {
            int ordinal = this.state.get().ordinal();
            if (ordinal == 0) {
                throw new AssertionError();
            }
            if (ordinal == 1) {
                throw new IllegalStateException("Cannot call finishToFuture() after deriving another step");
            }
            if (ordinal == 2 || ordinal == 3 || ordinal == 4) {
                throw new IllegalStateException("Cannot call finishToFuture() twice");
            }
            if (ordinal == 5) {
                throw new IllegalStateException("Cannot call finishToFuture() after calling finishToValueAndCloser()");
            }
        }
        return this.future;
    }

    public void finishToValueAndCloser(final ValueAndCloserConsumer<? super V> consumer, Executor executor) {
        Preconditions.checkNotNull(consumer);
        if (!compareAndUpdateState(State.OPEN, State.WILL_CREATE_VALUE_AND_CLOSER)) {
            int ordinal = this.state.get().ordinal();
            if (ordinal == 1) {
                throw new IllegalStateException("Cannot call finishToValueAndCloser() after deriving another step");
            }
            if (ordinal == 2 || ordinal == 3 || ordinal == 4) {
                throw new IllegalStateException("Cannot call finishToValueAndCloser() after calling finishToFuture()");
            }
            if (ordinal == 5) {
                throw new IllegalStateException("Cannot call finishToValueAndCloser() twice");
            }
            throw new AssertionError(this.state);
        }
        this.future.addListener(new Runnable(this) { // from class: com.google.common.util.concurrent.ClosingFuture.10
            final /* synthetic */ ClosingFuture this$0;

            {
                this.this$0 = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                ClosingFuture.provideValueAndCloser(consumer, this.this$0);
            }
        }, executor);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <C, V extends C> void provideValueAndCloser(ValueAndCloserConsumer<C> consumer, ClosingFuture<V> closingFuture) {
        consumer.accept(new ValueAndCloser<>(closingFuture));
    }

    public boolean cancel(boolean mayInterruptIfRunning) {
        logger.get().log(Level.FINER, "cancelling {0}", this);
        boolean cancel = this.future.cancel(mayInterruptIfRunning);
        if (cancel) {
            close();
        }
        return cancel;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void close() {
        logger.get().log(Level.FINER, "closing {0}", this);
        this.closeables.close();
    }

    private <U> ClosingFuture<U> derive(FluentFuture<U> future) {
        ClosingFuture<U> closingFuture = new ClosingFuture<>(future);
        becomeSubsumedInto(closingFuture.closeables);
        return closingFuture;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void becomeSubsumedInto(CloseableList otherCloseables) {
        checkAndUpdateState(State.OPEN, State.SUBSUMED);
        otherCloseables.add(this.closeables, MoreExecutors.directExecutor());
    }

    /* loaded from: classes4.dex */
    public static final class Peeker {
        private volatile boolean beingCalled;
        private final ImmutableList<ClosingFuture<?>> futures;

        private Peeker(ImmutableList<ClosingFuture<?>> futures) {
            this.futures = (ImmutableList) Preconditions.checkNotNull(futures);
        }

        @ParametricNullness
        public final <D> D getDone(ClosingFuture<D> closingFuture) throws ExecutionException {
            Preconditions.checkState(this.beingCalled);
            Preconditions.checkArgument(this.futures.contains(closingFuture));
            return (D) Futures.getDone(((ClosingFuture) closingFuture).future);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @ParametricNullness
        public <V> V call(Combiner.CombiningCallable<V> combiner, CloseableList closeables) throws Exception {
            this.beingCalled = true;
            CloseableList closeableList = new CloseableList();
            try {
                return combiner.call(closeableList.closer, this);
            } finally {
                closeables.add(closeableList, MoreExecutors.directExecutor());
                this.beingCalled = false;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public <V> FluentFuture<V> callAsync(Combiner.AsyncCombiningCallable<V> combiner, CloseableList closeables) throws Exception {
            this.beingCalled = true;
            CloseableList closeableList = new CloseableList();
            try {
                ClosingFuture<V> call = combiner.call(closeableList.closer, this);
                call.becomeSubsumedInto(closeables);
                return ((ClosingFuture) call).future;
            } finally {
                closeables.add(closeableList, MoreExecutors.directExecutor());
                this.beingCalled = false;
            }
        }
    }

    @DoNotMock("Use ClosingFuture.whenAllSucceed() or .whenAllComplete() instead.")
    /* loaded from: classes4.dex */
    public static class Combiner {
        private final boolean allMustSucceed;
        private final CloseableList closeables;
        protected final ImmutableList<ClosingFuture<?>> inputs;

        /* loaded from: classes4.dex */
        public interface AsyncCombiningCallable<V> {
            ClosingFuture<V> call(DeferredCloser closer, Peeker peeker) throws Exception;
        }

        /* loaded from: classes4.dex */
        public interface CombiningCallable<V> {
            @ParametricNullness
            V call(DeferredCloser closer, Peeker peeker) throws Exception;
        }

        private Combiner(boolean allMustSucceed, Iterable<? extends ClosingFuture<?>> inputs) {
            this.closeables = new CloseableList();
            this.allMustSucceed = allMustSucceed;
            this.inputs = ImmutableList.copyOf(inputs);
            for (ClosingFuture<?> closingFuture : inputs) {
                closingFuture.becomeSubsumedInto(this.closeables);
            }
        }

        public <V> ClosingFuture<V> call(final CombiningCallable<V> combiningCallable, Executor executor) {
            ClosingFuture<V> closingFuture = new ClosingFuture<>(futureCombiner().call((Callable<V>) new Callable<V>(this) { // from class: com.google.common.util.concurrent.ClosingFuture.Combiner.1
                final /* synthetic */ Combiner this$0;

                {
                    this.this$0 = this;
                }

                @Override // java.util.concurrent.Callable
                @ParametricNullness
                public V call() throws Exception {
                    return (V) new Peeker(this.this$0.inputs).call(combiningCallable, this.this$0.closeables);
                }

                public String toString() {
                    return combiningCallable.toString();
                }
            }, executor));
            ((ClosingFuture) closingFuture).closeables.add(this.closeables, MoreExecutors.directExecutor());
            return closingFuture;
        }

        public <V> ClosingFuture<V> callAsync(final AsyncCombiningCallable<V> combiningCallable, Executor executor) {
            ClosingFuture<V> closingFuture = new ClosingFuture<>(futureCombiner().callAsync((AsyncCallable<V>) new AsyncCallable<V>(this) { // from class: com.google.common.util.concurrent.ClosingFuture.Combiner.2
                final /* synthetic */ Combiner this$0;

                {
                    this.this$0 = this;
                }

                @Override // com.google.common.util.concurrent.AsyncCallable
                public ListenableFuture<V> call() throws Exception {
                    return new Peeker(this.this$0.inputs).callAsync(combiningCallable, this.this$0.closeables);
                }

                public String toString() {
                    return combiningCallable.toString();
                }
            }, executor));
            ((ClosingFuture) closingFuture).closeables.add(this.closeables, MoreExecutors.directExecutor());
            return closingFuture;
        }

        private Futures.FutureCombiner<Object> futureCombiner() {
            if (this.allMustSucceed) {
                return Futures.whenAllSucceed(inputFutures());
            }
            return Futures.whenAllComplete(inputFutures());
        }

        private ImmutableList<FluentFuture<?>> inputFutures() {
            return FluentIterable.from(this.inputs).transform(new Function() { // from class: com.google.common.util.concurrent.ClosingFuture$Combiner$$ExternalSyntheticLambda0
                @Override // com.google.common.base.Function
                public final Object apply(Object obj) {
                    FluentFuture fluentFuture;
                    fluentFuture = ((ClosingFuture) obj).future;
                    return fluentFuture;
                }
            }).toList();
        }
    }

    /* loaded from: classes4.dex */
    public static final class Combiner2<V1, V2> extends Combiner {
        private final ClosingFuture<V1> future1;
        private final ClosingFuture<V2> future2;

        /* loaded from: classes4.dex */
        public interface AsyncClosingFunction2<V1, V2, U> {
            ClosingFuture<U> apply(DeferredCloser closer, @ParametricNullness V1 value1, @ParametricNullness V2 value2) throws Exception;
        }

        /* loaded from: classes4.dex */
        public interface ClosingFunction2<V1, V2, U> {
            @ParametricNullness
            U apply(DeferredCloser closer, @ParametricNullness V1 value1, @ParametricNullness V2 value2) throws Exception;
        }

        private Combiner2(ClosingFuture<V1> future1, ClosingFuture<V2> future2) {
            super(true, ImmutableList.of((ClosingFuture<V2>) future1, future2));
            this.future1 = future1;
            this.future2 = future2;
        }

        public <U> ClosingFuture<U> call(final ClosingFunction2<V1, V2, U> function, Executor executor) {
            return call(new Combiner.CombiningCallable<U>(this) { // from class: com.google.common.util.concurrent.ClosingFuture.Combiner2.1
                final /* synthetic */ Combiner2 this$0;

                {
                    this.this$0 = this;
                }

                /* JADX WARN: Multi-variable type inference failed */
                @Override // com.google.common.util.concurrent.ClosingFuture.Combiner.CombiningCallable
                @ParametricNullness
                public U call(DeferredCloser closer, Peeker peeker) throws Exception {
                    return (U) function.apply(closer, peeker.getDone(this.this$0.future1), peeker.getDone(this.this$0.future2));
                }

                public String toString() {
                    return function.toString();
                }
            }, executor);
        }

        public <U> ClosingFuture<U> callAsync(final AsyncClosingFunction2<V1, V2, U> function, Executor executor) {
            return callAsync(new Combiner.AsyncCombiningCallable<U>(this) { // from class: com.google.common.util.concurrent.ClosingFuture.Combiner2.2
                final /* synthetic */ Combiner2 this$0;

                {
                    this.this$0 = this;
                }

                /* JADX WARN: Multi-variable type inference failed */
                @Override // com.google.common.util.concurrent.ClosingFuture.Combiner.AsyncCombiningCallable
                public ClosingFuture<U> call(DeferredCloser closer, Peeker peeker) throws Exception {
                    return function.apply(closer, peeker.getDone(this.this$0.future1), peeker.getDone(this.this$0.future2));
                }

                public String toString() {
                    return function.toString();
                }
            }, executor);
        }
    }

    /* loaded from: classes4.dex */
    public static final class Combiner3<V1, V2, V3> extends Combiner {
        private final ClosingFuture<V1> future1;
        private final ClosingFuture<V2> future2;
        private final ClosingFuture<V3> future3;

        /* loaded from: classes4.dex */
        public interface AsyncClosingFunction3<V1, V2, V3, U> {
            ClosingFuture<U> apply(DeferredCloser closer, @ParametricNullness V1 value1, @ParametricNullness V2 value2, @ParametricNullness V3 value3) throws Exception;
        }

        /* loaded from: classes4.dex */
        public interface ClosingFunction3<V1, V2, V3, U> {
            @ParametricNullness
            U apply(DeferredCloser closer, @ParametricNullness V1 value1, @ParametricNullness V2 value2, @ParametricNullness V3 value3) throws Exception;
        }

        private Combiner3(ClosingFuture<V1> future1, ClosingFuture<V2> future2, ClosingFuture<V3> future3) {
            super(true, ImmutableList.of((ClosingFuture<V3>) future1, (ClosingFuture<V3>) future2, future3));
            this.future1 = future1;
            this.future2 = future2;
            this.future3 = future3;
        }

        public <U> ClosingFuture<U> call(final ClosingFunction3<V1, V2, V3, U> function, Executor executor) {
            return call(new Combiner.CombiningCallable<U>(this) { // from class: com.google.common.util.concurrent.ClosingFuture.Combiner3.1
                final /* synthetic */ Combiner3 this$0;

                {
                    this.this$0 = this;
                }

                /* JADX WARN: Multi-variable type inference failed */
                @Override // com.google.common.util.concurrent.ClosingFuture.Combiner.CombiningCallable
                @ParametricNullness
                public U call(DeferredCloser closer, Peeker peeker) throws Exception {
                    return (U) function.apply(closer, peeker.getDone(this.this$0.future1), peeker.getDone(this.this$0.future2), peeker.getDone(this.this$0.future3));
                }

                public String toString() {
                    return function.toString();
                }
            }, executor);
        }

        public <U> ClosingFuture<U> callAsync(final AsyncClosingFunction3<V1, V2, V3, U> function, Executor executor) {
            return callAsync(new Combiner.AsyncCombiningCallable<U>(this) { // from class: com.google.common.util.concurrent.ClosingFuture.Combiner3.2
                final /* synthetic */ Combiner3 this$0;

                {
                    this.this$0 = this;
                }

                /* JADX WARN: Multi-variable type inference failed */
                @Override // com.google.common.util.concurrent.ClosingFuture.Combiner.AsyncCombiningCallable
                public ClosingFuture<U> call(DeferredCloser closer, Peeker peeker) throws Exception {
                    return function.apply(closer, peeker.getDone(this.this$0.future1), peeker.getDone(this.this$0.future2), peeker.getDone(this.this$0.future3));
                }

                public String toString() {
                    return function.toString();
                }
            }, executor);
        }
    }

    /* loaded from: classes4.dex */
    public static final class Combiner4<V1, V2, V3, V4> extends Combiner {
        private final ClosingFuture<V1> future1;
        private final ClosingFuture<V2> future2;
        private final ClosingFuture<V3> future3;
        private final ClosingFuture<V4> future4;

        /* loaded from: classes4.dex */
        public interface AsyncClosingFunction4<V1, V2, V3, V4, U> {
            ClosingFuture<U> apply(DeferredCloser closer, @ParametricNullness V1 value1, @ParametricNullness V2 value2, @ParametricNullness V3 value3, @ParametricNullness V4 value4) throws Exception;
        }

        /* loaded from: classes4.dex */
        public interface ClosingFunction4<V1, V2, V3, V4, U> {
            @ParametricNullness
            U apply(DeferredCloser closer, @ParametricNullness V1 value1, @ParametricNullness V2 value2, @ParametricNullness V3 value3, @ParametricNullness V4 value4) throws Exception;
        }

        private Combiner4(ClosingFuture<V1> future1, ClosingFuture<V2> future2, ClosingFuture<V3> future3, ClosingFuture<V4> future4) {
            super(true, ImmutableList.of((ClosingFuture<V4>) future1, (ClosingFuture<V4>) future2, (ClosingFuture<V4>) future3, future4));
            this.future1 = future1;
            this.future2 = future2;
            this.future3 = future3;
            this.future4 = future4;
        }

        public <U> ClosingFuture<U> call(final ClosingFunction4<V1, V2, V3, V4, U> function, Executor executor) {
            return call(new Combiner.CombiningCallable<U>(this) { // from class: com.google.common.util.concurrent.ClosingFuture.Combiner4.1
                final /* synthetic */ Combiner4 this$0;

                {
                    this.this$0 = this;
                }

                /* JADX WARN: Multi-variable type inference failed */
                @Override // com.google.common.util.concurrent.ClosingFuture.Combiner.CombiningCallable
                @ParametricNullness
                public U call(DeferredCloser closer, Peeker peeker) throws Exception {
                    return (U) function.apply(closer, peeker.getDone(this.this$0.future1), peeker.getDone(this.this$0.future2), peeker.getDone(this.this$0.future3), peeker.getDone(this.this$0.future4));
                }

                public String toString() {
                    return function.toString();
                }
            }, executor);
        }

        public <U> ClosingFuture<U> callAsync(final AsyncClosingFunction4<V1, V2, V3, V4, U> function, Executor executor) {
            return callAsync(new Combiner.AsyncCombiningCallable<U>(this) { // from class: com.google.common.util.concurrent.ClosingFuture.Combiner4.2
                final /* synthetic */ Combiner4 this$0;

                {
                    this.this$0 = this;
                }

                /* JADX WARN: Multi-variable type inference failed */
                @Override // com.google.common.util.concurrent.ClosingFuture.Combiner.AsyncCombiningCallable
                public ClosingFuture<U> call(DeferredCloser closer, Peeker peeker) throws Exception {
                    return function.apply(closer, peeker.getDone(this.this$0.future1), peeker.getDone(this.this$0.future2), peeker.getDone(this.this$0.future3), peeker.getDone(this.this$0.future4));
                }

                public String toString() {
                    return function.toString();
                }
            }, executor);
        }
    }

    /* loaded from: classes4.dex */
    public static final class Combiner5<V1, V2, V3, V4, V5> extends Combiner {
        private final ClosingFuture<V1> future1;
        private final ClosingFuture<V2> future2;
        private final ClosingFuture<V3> future3;
        private final ClosingFuture<V4> future4;
        private final ClosingFuture<V5> future5;

        /* loaded from: classes4.dex */
        public interface AsyncClosingFunction5<V1, V2, V3, V4, V5, U> {
            ClosingFuture<U> apply(DeferredCloser closer, @ParametricNullness V1 value1, @ParametricNullness V2 value2, @ParametricNullness V3 value3, @ParametricNullness V4 value4, @ParametricNullness V5 value5) throws Exception;
        }

        /* loaded from: classes4.dex */
        public interface ClosingFunction5<V1, V2, V3, V4, V5, U> {
            @ParametricNullness
            U apply(DeferredCloser closer, @ParametricNullness V1 value1, @ParametricNullness V2 value2, @ParametricNullness V3 value3, @ParametricNullness V4 value4, @ParametricNullness V5 value5) throws Exception;
        }

        private Combiner5(ClosingFuture<V1> future1, ClosingFuture<V2> future2, ClosingFuture<V3> future3, ClosingFuture<V4> future4, ClosingFuture<V5> future5) {
            super(true, ImmutableList.of((ClosingFuture<V5>) future1, (ClosingFuture<V5>) future2, (ClosingFuture<V5>) future3, (ClosingFuture<V5>) future4, future5));
            this.future1 = future1;
            this.future2 = future2;
            this.future3 = future3;
            this.future4 = future4;
            this.future5 = future5;
        }

        public <U> ClosingFuture<U> call(final ClosingFunction5<V1, V2, V3, V4, V5, U> function, Executor executor) {
            return call(new Combiner.CombiningCallable<U>(this) { // from class: com.google.common.util.concurrent.ClosingFuture.Combiner5.1
                final /* synthetic */ Combiner5 this$0;

                {
                    this.this$0 = this;
                }

                /* JADX WARN: Multi-variable type inference failed */
                @Override // com.google.common.util.concurrent.ClosingFuture.Combiner.CombiningCallable
                @ParametricNullness
                public U call(DeferredCloser closer, Peeker peeker) throws Exception {
                    return (U) function.apply(closer, peeker.getDone(this.this$0.future1), peeker.getDone(this.this$0.future2), peeker.getDone(this.this$0.future3), peeker.getDone(this.this$0.future4), peeker.getDone(this.this$0.future5));
                }

                public String toString() {
                    return function.toString();
                }
            }, executor);
        }

        public <U> ClosingFuture<U> callAsync(final AsyncClosingFunction5<V1, V2, V3, V4, V5, U> function, Executor executor) {
            return callAsync(new Combiner.AsyncCombiningCallable<U>(this) { // from class: com.google.common.util.concurrent.ClosingFuture.Combiner5.2
                final /* synthetic */ Combiner5 this$0;

                {
                    this.this$0 = this;
                }

                /* JADX WARN: Multi-variable type inference failed */
                @Override // com.google.common.util.concurrent.ClosingFuture.Combiner.AsyncCombiningCallable
                public ClosingFuture<U> call(DeferredCloser closer, Peeker peeker) throws Exception {
                    return function.apply(closer, peeker.getDone(this.this$0.future1), peeker.getDone(this.this$0.future2), peeker.getDone(this.this$0.future3), peeker.getDone(this.this$0.future4), peeker.getDone(this.this$0.future5));
                }

                public String toString() {
                    return function.toString();
                }
            }, executor);
        }
    }

    public String toString() {
        return MoreObjects.toStringHelper(this).add(RemoteConfigConstants.ResponseFieldKey.STATE, this.state.get()).addValue(this.future).toString();
    }

    protected void finalize() {
        if (this.state.get().equals(State.OPEN)) {
            logger.get().log(Level.SEVERE, "Uh oh! An open ClosingFuture has leaked and will close: {0}", this);
            finishToFuture();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void closeQuietly(@CheckForNull final AutoCloseable closeable, Executor executor) {
        if (closeable == null) {
            return;
        }
        try {
            executor.execute(new Runnable() { // from class: com.google.common.util.concurrent.ClosingFuture$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    ClosingFuture.lambda$closeQuietly$0(closeable);
                }
            });
        } catch (RejectedExecutionException e) {
            LazyLogger lazyLogger = logger;
            if (lazyLogger.get().isLoggable(Level.WARNING)) {
                lazyLogger.get().log(Level.WARNING, String.format("while submitting close to %s; will close inline", executor), (Throwable) e);
            }
            closeQuietly(closeable, MoreExecutors.directExecutor());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$closeQuietly$0(AutoCloseable autoCloseable) {
        try {
            UByte$$ExternalSyntheticBackport0.m8544m((Object) autoCloseable);
        } catch (Exception e) {
            Platform.restoreInterruptIfIsInterruptedException(e);
            logger.get().log(Level.WARNING, "thrown by close()", (Throwable) e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkAndUpdateState(State oldState, State newState) {
        Preconditions.checkState(compareAndUpdateState(oldState, newState), "Expected state to be %s, but it was %s", oldState, newState);
    }

    private boolean compareAndUpdateState(State oldState, State newState) {
        return MutatorMutex$$ExternalSyntheticBackportWithForwarding0.m(this.state, oldState, newState);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static final class CloseableList extends IdentityHashMap<AutoCloseable, Executor> implements Closeable {
        private volatile boolean closed;
        private final DeferredCloser closer;
        @CheckForNull
        private volatile CountDownLatch whenClosed;

        private CloseableList() {
            this.closer = new DeferredCloser(this);
        }

        /* JADX WARN: Multi-variable type inference failed */
        <V, U> ListenableFuture<U> applyClosingFunction(ClosingFunction<? super V, U> transformation, @ParametricNullness V input) throws Exception {
            CloseableList closeableList = new CloseableList();
            try {
                return Futures.immediateFuture(transformation.apply(closeableList.closer, input));
            } finally {
                add(closeableList, MoreExecutors.directExecutor());
            }
        }

        <V, U> FluentFuture<U> applyAsyncClosingFunction(AsyncClosingFunction<V, U> transformation, @ParametricNullness V input) throws Exception {
            CloseableList closeableList = new CloseableList();
            try {
                ClosingFuture<U> apply = transformation.apply(closeableList.closer, input);
                apply.becomeSubsumedInto(closeableList);
                return ((ClosingFuture) apply).future;
            } finally {
                add(closeableList, MoreExecutors.directExecutor());
            }
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (this.closed) {
                return;
            }
            synchronized (this) {
                if (this.closed) {
                    return;
                }
                this.closed = true;
                for (Map.Entry<AutoCloseable, Executor> entry : entrySet()) {
                    ClosingFuture.closeQuietly(entry.getKey(), entry.getValue());
                }
                clear();
                if (this.whenClosed != null) {
                    this.whenClosed.countDown();
                }
            }
        }

        void add(@CheckForNull AutoCloseable closeable, Executor executor) {
            Preconditions.checkNotNull(executor);
            if (closeable == null) {
                return;
            }
            synchronized (this) {
                if (this.closed) {
                    ClosingFuture.closeQuietly(closeable, executor);
                } else {
                    put(closeable, executor);
                }
            }
        }

        CountDownLatch whenClosedCountDown() {
            if (this.closed) {
                return new CountDownLatch(0);
            }
            synchronized (this) {
                if (this.closed) {
                    return new CountDownLatch(0);
                }
                Preconditions.checkState(this.whenClosed == null);
                CountDownLatch countDownLatch = new CountDownLatch(1);
                this.whenClosed = countDownLatch;
                return countDownLatch;
            }
        }
    }

    CountDownLatch whenClosedCountDown() {
        return this.closeables.whenClosedCountDown();
    }
}
