package com.google.common.eventbus;

import com.google.common.base.Preconditions;
import com.google.common.collect.Queues;
import java.util.Iterator;
import java.util.Objects;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
/* JADX INFO: Access modifiers changed from: package-private */
@ElementTypesAreNonnullByDefault
/* loaded from: classes4.dex */
public abstract class Dispatcher {
    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void dispatch(Object event, Iterator<Subscriber> subscribers);

    Dispatcher() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Dispatcher perThreadDispatchQueue() {
        return new PerThreadQueuedDispatcher();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Dispatcher legacyAsync() {
        return new LegacyAsyncDispatcher();
    }

    static Dispatcher immediate() {
        return ImmediateDispatcher.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static final class PerThreadQueuedDispatcher extends Dispatcher {
        private final ThreadLocal<Boolean> dispatching;
        private final ThreadLocal<Queue<Event>> queue;

        private PerThreadQueuedDispatcher() {
            this.queue = new ThreadLocal<Queue<Event>>() { // from class: com.google.common.eventbus.Dispatcher.PerThreadQueuedDispatcher.1
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // java.lang.ThreadLocal
                public Queue<Event> initialValue() {
                    return Queues.newArrayDeque();
                }
            };
            this.dispatching = new ThreadLocal<Boolean>() { // from class: com.google.common.eventbus.Dispatcher.PerThreadQueuedDispatcher.2
                /* JADX INFO: Access modifiers changed from: protected */
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // java.lang.ThreadLocal
                public Boolean initialValue() {
                    return false;
                }
            };
        }

        /* JADX WARN: Removed duplicated region for block: B:19:0x0059 A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:7:0x003d A[Catch: all -> 0x0064, LOOP:1: B:7:0x003d->B:9:0x0047, LOOP_START, TryCatch #0 {all -> 0x0064, blocks: (B:5:0x0035, B:7:0x003d, B:9:0x0047), top: B:17:0x0035 }] */
        @Override // com.google.common.eventbus.Dispatcher
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        void dispatch(Object event, Iterator<Subscriber> subscribers) {
            Preconditions.checkNotNull(event);
            Preconditions.checkNotNull(subscribers);
            Queue queue = (Queue) Objects.requireNonNull(this.queue.get());
            queue.offer(new Event(event, subscribers));
            if (this.dispatching.get().booleanValue()) {
                return;
            }
            this.dispatching.set(true);
            while (true) {
                try {
                    Event event2 = (Event) queue.poll();
                    if (event2 == null) {
                        while (true) {
                            if (event2.subscribers.hasNext()) {
                                ((Subscriber) event2.subscribers.next()).dispatchEvent(event2.event);
                            }
                        }
                        Event event22 = (Event) queue.poll();
                        if (event22 == null) {
                            return;
                        }
                    }
                } finally {
                    this.dispatching.remove();
                    this.queue.remove();
                }
            }
        }

        /* loaded from: classes4.dex */
        private static final class Event {
            private final Object event;
            private final Iterator<Subscriber> subscribers;

            private Event(Object event, Iterator<Subscriber> subscribers) {
                this.event = event;
                this.subscribers = subscribers;
            }
        }
    }

    /* loaded from: classes4.dex */
    private static final class LegacyAsyncDispatcher extends Dispatcher {
        private final ConcurrentLinkedQueue<EventWithSubscriber> queue;

        private LegacyAsyncDispatcher() {
            this.queue = Queues.newConcurrentLinkedQueue();
        }

        @Override // com.google.common.eventbus.Dispatcher
        void dispatch(Object event, Iterator<Subscriber> subscribers) {
            Preconditions.checkNotNull(event);
            while (subscribers.hasNext()) {
                this.queue.add(new EventWithSubscriber(event, subscribers.next()));
            }
            while (true) {
                EventWithSubscriber poll = this.queue.poll();
                if (poll == null) {
                    return;
                }
                poll.subscriber.dispatchEvent(poll.event);
            }
        }

        /* loaded from: classes4.dex */
        private static final class EventWithSubscriber {
            private final Object event;
            private final Subscriber subscriber;

            private EventWithSubscriber(Object event, Subscriber subscriber) {
                this.event = event;
                this.subscriber = subscriber;
            }
        }
    }

    /* loaded from: classes4.dex */
    private static final class ImmediateDispatcher extends Dispatcher {
        private static final ImmediateDispatcher INSTANCE = new ImmediateDispatcher();

        private ImmediateDispatcher() {
        }

        @Override // com.google.common.eventbus.Dispatcher
        void dispatch(Object event, Iterator<Subscriber> subscribers) {
            Preconditions.checkNotNull(event);
            while (subscribers.hasNext()) {
                subscribers.next().dispatchEvent(event);
            }
        }
    }
}
