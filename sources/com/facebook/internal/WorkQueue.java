package com.facebook.internal;

import com.facebook.Settings;
import java.util.concurrent.Executor;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class WorkQueue {
    static final /* synthetic */ boolean $assertionsDisabled = true;
    public static final int DEFAULT_MAX_CONCURRENT = 8;
    private final Executor executor;
    private final int maxConcurrent;
    private WorkNode pendingJobs;
    private int runningCount;
    private WorkNode runningJobs;
    private final Object workLock;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public interface WorkItem {
        boolean cancel();

        boolean isRunning();

        void moveToFront();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class WorkNode implements WorkItem {
        static final /* synthetic */ boolean $assertionsDisabled = true;
        private final Runnable callback;
        private boolean isRunning;
        private WorkNode next;
        private WorkNode prev;

        WorkNode(Runnable runnable) {
            this.callback = runnable;
        }

        WorkNode addToList(WorkNode workNode, boolean z) {
            boolean z2 = $assertionsDisabled;
            if (z2 || this.next == null) {
                if (z2 || this.prev == null) {
                    if (workNode == null) {
                        this.prev = this;
                        this.next = this;
                        workNode = this;
                    } else {
                        this.next = workNode;
                        WorkNode workNode2 = workNode.prev;
                        this.prev = workNode2;
                        workNode2.next = this;
                        workNode.prev = this;
                    }
                    return z ? this : workNode;
                }
                throw new AssertionError();
            }
            throw new AssertionError();
        }

        @Override // com.facebook.internal.WorkQueue.WorkItem
        public boolean cancel() {
            synchronized (WorkQueue.this.workLock) {
                if (isRunning()) {
                    return false;
                }
                WorkQueue workQueue = WorkQueue.this;
                workQueue.pendingJobs = removeFromList(workQueue.pendingJobs);
                return true;
            }
        }

        Runnable getCallback() {
            return this.callback;
        }

        WorkNode getNext() {
            return this.next;
        }

        @Override // com.facebook.internal.WorkQueue.WorkItem
        public boolean isRunning() {
            return this.isRunning;
        }

        @Override // com.facebook.internal.WorkQueue.WorkItem
        public void moveToFront() {
            synchronized (WorkQueue.this.workLock) {
                if (!isRunning()) {
                    WorkQueue workQueue = WorkQueue.this;
                    workQueue.pendingJobs = removeFromList(workQueue.pendingJobs);
                    WorkQueue workQueue2 = WorkQueue.this;
                    workQueue2.pendingJobs = addToList(workQueue2.pendingJobs, true);
                }
            }
        }

        WorkNode removeFromList(WorkNode workNode) {
            boolean z = $assertionsDisabled;
            if (z || this.next != null) {
                if (z || this.prev != null) {
                    if (workNode == this && (workNode = this.next) == this) {
                        workNode = null;
                    }
                    WorkNode workNode2 = this.next;
                    workNode2.prev = this.prev;
                    this.prev.next = workNode2;
                    this.prev = null;
                    this.next = null;
                    return workNode;
                }
                throw new AssertionError();
            }
            throw new AssertionError();
        }

        void setIsRunning(boolean z) {
            this.isRunning = z;
        }

        void verify(boolean z) {
            boolean z2 = $assertionsDisabled;
            if (!z2 && this.prev.next != this) {
                throw new AssertionError();
            }
            if (!z2 && this.next.prev != this) {
                throw new AssertionError();
            }
            if (!z2 && isRunning() != z) {
                throw new AssertionError();
            }
        }
    }

    WorkQueue() {
        this(8);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public WorkQueue(int i) {
        this(i, Settings.getExecutor());
    }

    WorkQueue(int i, Executor executor) {
        this.workLock = new Object();
        this.runningJobs = null;
        this.runningCount = 0;
        this.maxConcurrent = i;
        this.executor = executor;
    }

    private void execute(final WorkNode workNode) {
        this.executor.execute(new Runnable() { // from class: com.facebook.internal.WorkQueue.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    workNode.getCallback().run();
                } finally {
                    WorkQueue.this.finishItemAndStartNew(workNode);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void finishItemAndStartNew(WorkNode workNode) {
        WorkNode workNode2;
        synchronized (this.workLock) {
            if (workNode != null) {
                try {
                    this.runningJobs = workNode.removeFromList(this.runningJobs);
                    this.runningCount--;
                } catch (Throwable th) {
                    throw th;
                }
            }
            if (this.runningCount < this.maxConcurrent) {
                workNode2 = this.pendingJobs;
                if (workNode2 != null) {
                    this.pendingJobs = workNode2.removeFromList(workNode2);
                    this.runningJobs = workNode2.addToList(this.runningJobs, false);
                    this.runningCount++;
                    workNode2.setIsRunning(true);
                }
            } else {
                workNode2 = null;
            }
        }
        if (workNode2 != null) {
            execute(workNode2);
        }
    }

    private void startItem() {
        finishItemAndStartNew(null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public WorkItem addActiveWorkItem(Runnable runnable) {
        return addActiveWorkItem(runnable, true);
    }

    WorkItem addActiveWorkItem(Runnable runnable, boolean z) {
        WorkNode workNode = new WorkNode(runnable);
        synchronized (this.workLock) {
            this.pendingJobs = workNode.addToList(this.pendingJobs, z);
        }
        startItem();
        return workNode;
    }

    void validate() {
        synchronized (this.workLock) {
            WorkNode workNode = this.runningJobs;
            int i = 0;
            if (workNode != null) {
                do {
                    workNode.verify(true);
                    i++;
                    workNode = workNode.getNext();
                } while (workNode != this.runningJobs);
                if (!$assertionsDisabled && this.runningCount != i) {
                    throw new AssertionError();
                }
            } else if (!$assertionsDisabled) {
                throw new AssertionError();
            }
        }
    }
}
