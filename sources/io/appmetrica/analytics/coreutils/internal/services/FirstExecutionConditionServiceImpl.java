package io.appmetrica.analytics.coreutils.internal.services;

import io.appmetrica.analytics.coreapi.internal.executors.ICommonExecutor;
import io.appmetrica.analytics.coreapi.internal.servicecomponents.FirstExecutionConditionService;
import io.appmetrica.analytics.coreapi.internal.servicecomponents.FirstExecutionDelayedTask;
import io.appmetrica.analytics.coreutils.internal.services.WaitForActivationDelayBarrier;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;
/* loaded from: classes4.dex */
public class FirstExecutionConditionServiceImpl implements FirstExecutionConditionService {

    /* renamed from: a  reason: collision with root package name */
    private final ArrayList f278a = new ArrayList();
    private UtilityServiceConfiguration b;
    final UtilityServiceProvider c;

    /* loaded from: classes4.dex */
    public static class FirstExecutionConditionChecker {

        /* renamed from: a  reason: collision with root package name */
        private boolean f279a = false;
        private long b;
        private long c;
        private long d;
        private final FirstExecutionDelayChecker e;
        public final String tag;

        public FirstExecutionConditionChecker(UtilityServiceConfiguration utilityServiceConfiguration, FirstExecutionDelayChecker firstExecutionDelayChecker, String str) {
            this.e = firstExecutionDelayChecker;
            this.c = utilityServiceConfiguration == null ? 0L : utilityServiceConfiguration.getInitialConfigTime();
            this.b = utilityServiceConfiguration != null ? utilityServiceConfiguration.getLastUpdateConfigTime() : 0L;
            this.d = Long.MAX_VALUE;
            this.tag = str;
        }

        final void a(long j) {
            this.d = TimeUnit.SECONDS.toMillis(j);
        }

        final boolean b() {
            if (this.f279a) {
                return true;
            }
            return this.e.delaySinceFirstStartupWasPassed(this.c, this.b, this.d);
        }

        final void a() {
            this.f279a = true;
        }

        final void a(UtilityServiceConfiguration utilityServiceConfiguration) {
            this.c = utilityServiceConfiguration.getInitialConfigTime();
            this.b = utilityServiceConfiguration.getLastUpdateConfigTime();
        }
    }

    /* loaded from: classes4.dex */
    public static class FirstExecutionDelayChecker {
        public boolean delaySinceFirstStartupWasPassed(long j, long j2, long j3) {
            return j2 - j >= j3;
        }
    }

    /* loaded from: classes4.dex */
    public static class FirstExecutionHandler implements FirstExecutionDelayedTask {

        /* renamed from: a  reason: collision with root package name */
        private final FirstExecutionConditionChecker f280a;
        private final WaitForActivationDelayBarrier.ActivationBarrierHelper b;
        private final ICommonExecutor c;

        /* synthetic */ FirstExecutionHandler(ICommonExecutor iCommonExecutor, WaitForActivationDelayBarrier.ActivationBarrierHelper activationBarrierHelper, FirstExecutionConditionChecker firstExecutionConditionChecker, int i) {
            this(iCommonExecutor, activationBarrierHelper, firstExecutionConditionChecker);
        }

        public boolean canExecute() {
            boolean b = this.f280a.b();
            if (b) {
                this.f280a.a();
            }
            return b;
        }

        @Override // io.appmetrica.analytics.coreapi.internal.servicecomponents.FirstExecutionDelayedTask
        public void setInitialDelaySeconds(long j) {
            this.f280a.a(j);
        }

        @Override // io.appmetrica.analytics.coreapi.internal.servicecomponents.FirstExecutionDelayedTask
        public boolean tryExecute(long j) {
            if (this.f280a.b()) {
                this.b.subscribeIfNeeded(TimeUnit.SECONDS.toMillis(j), this.c);
                this.f280a.a();
                return true;
            }
            return false;
        }

        public void updateConfig(UtilityServiceConfiguration utilityServiceConfiguration) {
            this.f280a.a(utilityServiceConfiguration);
        }

        private FirstExecutionHandler(ICommonExecutor iCommonExecutor, WaitForActivationDelayBarrier.ActivationBarrierHelper activationBarrierHelper, FirstExecutionConditionChecker firstExecutionConditionChecker) {
            this.b = activationBarrierHelper;
            this.f280a = firstExecutionConditionChecker;
            this.c = iCommonExecutor;
        }
    }

    public FirstExecutionConditionServiceImpl(UtilityServiceProvider utilityServiceProvider) {
        this.c = utilityServiceProvider;
    }

    final synchronized FirstExecutionHandler a(ICommonExecutor iCommonExecutor, WaitForActivationDelayBarrier.ActivationBarrierHelper activationBarrierHelper, FirstExecutionConditionChecker firstExecutionConditionChecker) {
        FirstExecutionHandler firstExecutionHandler;
        firstExecutionHandler = new FirstExecutionHandler(iCommonExecutor, activationBarrierHelper, firstExecutionConditionChecker, 0);
        this.f278a.add(firstExecutionHandler);
        return firstExecutionHandler;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.servicecomponents.FirstExecutionConditionService
    public synchronized FirstExecutionDelayedTask createDelayedTask(String str, ICommonExecutor iCommonExecutor, Runnable runnable) {
        return a(iCommonExecutor, new WaitForActivationDelayBarrier.ActivationBarrierHelper(runnable, this.c.getActivationBarrier()), new FirstExecutionConditionChecker(this.b, new FirstExecutionDelayChecker(), str));
    }

    public void updateConfig(UtilityServiceConfiguration utilityServiceConfiguration) {
        ArrayList arrayList;
        synchronized (this) {
            this.b = utilityServiceConfiguration;
            arrayList = new ArrayList(this.f278a);
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((FirstExecutionHandler) it.next()).updateConfig(utilityServiceConfiguration);
        }
    }
}
