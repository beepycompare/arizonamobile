package com.adjust.sdk;

import com.adjust.sdk.network.IActivityPackageSender;
import com.adjust.sdk.scheduler.SingleThreadCachedScheduler;
import com.adjust.sdk.scheduler.ThreadScheduler;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes3.dex */
public class PurchaseVerificationHandler implements IPurchaseVerificationHandler {
    private static final double MILLISECONDS_TO_SECONDS_DIVISOR = 1000.0d;
    private static final String SCHEDULED_EXECUTOR_SOURCE = "PurchaseVerificationHandler";
    private WeakReference<IActivityHandler> activityHandlerWeakRef;
    private IActivityPackageSender activityPackageSender;
    private BackoffStrategy backoffStrategy;
    private long lastPackageRetryInMilli = 0;
    private ILogger logger;
    private List<ActivityPackage> packageQueue;
    private boolean paused;
    private ThreadScheduler scheduler;

    public PurchaseVerificationHandler(IActivityHandler iActivityHandler, boolean z, IActivityPackageSender iActivityPackageSender) {
        init(iActivityHandler, z, iActivityPackageSender);
        this.logger = AdjustFactory.getLogger();
        this.backoffStrategy = AdjustFactory.getSdkClickBackoffStrategy();
        this.scheduler = new SingleThreadCachedScheduler(SCHEDULED_EXECUTOR_SOURCE);
    }

    private Map<String, String> generateSendingParametersI() {
        HashMap hashMap = new HashMap();
        int size = this.packageQueue.size() - 1;
        if (size > 0) {
            PackageBuilder.addLong(hashMap, "queue_size", size);
        }
        return hashMap;
    }

    private void retrySendingI(ActivityPackage activityPackage, Long l) {
        if (l != null && l.longValue() > 0) {
            this.lastPackageRetryInMilli = l.longValue();
        } else {
            this.logger.error("Retrying purchase_verification package for the %d time", Integer.valueOf(activityPackage.increaseRetries()));
        }
        sendPurchaseVerificationPackage(activityPackage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendNextPurchaseVerificationPackage() {
        this.scheduler.submit(new Runnable() { // from class: com.adjust.sdk.PurchaseVerificationHandler.2
            @Override // java.lang.Runnable
            public final void run() {
                PurchaseVerificationHandler.this.sendNextPurchaseVerificationPackageI();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendNextPurchaseVerificationPackageI() {
        IActivityHandler iActivityHandler = this.activityHandlerWeakRef.get();
        if (iActivityHandler.getActivityState() == null || iActivityHandler.getActivityState().isGdprForgotten || this.paused || this.packageQueue.isEmpty()) {
            return;
        }
        final ActivityPackage remove = this.packageQueue.remove(0);
        int retries = remove.getRetries();
        Runnable runnable = new Runnable() { // from class: com.adjust.sdk.PurchaseVerificationHandler.3
            @Override // java.lang.Runnable
            public final void run() {
                PurchaseVerificationHandler.this.sendPurchaseVerificationPackageI(remove);
                PurchaseVerificationHandler.this.sendNextPurchaseVerificationPackage();
            }
        };
        long waitTime = waitTime(retries);
        if (waitTime > 0) {
            this.scheduler.schedule(runnable, waitTime);
        } else {
            runnable.run();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendPurchaseVerificationPackageI(ActivityPackage activityPackage) {
        IActivityHandler iActivityHandler = this.activityHandlerWeakRef.get();
        ResponseData sendActivityPackageSync = this.activityPackageSender.sendActivityPackageSync(activityPackage, generateSendingParametersI());
        if (sendActivityPackageSync instanceof PurchaseVerificationResponseData) {
            PurchaseVerificationResponseData purchaseVerificationResponseData = (PurchaseVerificationResponseData) sendActivityPackageSync;
            if (purchaseVerificationResponseData.willRetry) {
                retrySendingI(activityPackage, sendActivityPackageSync.retryIn);
                return;
            }
            this.lastPackageRetryInMilli = 0L;
            if (iActivityHandler == null) {
                return;
            }
            if (purchaseVerificationResponseData.trackingState == TrackingState.OPTED_OUT) {
                iActivityHandler.gotOptOutResponse();
            } else {
                iActivityHandler.finishedTrackingActivity(purchaseVerificationResponseData);
            }
        }
    }

    private long waitTime(int i) {
        long j = this.lastPackageRetryInMilli;
        if (j > 0) {
            return j;
        }
        if (i > 0) {
            long waitingTime = Util.getWaitingTime(i, this.backoffStrategy);
            this.logger.verbose("Waiting for %s seconds before retrying purchase_verification for the %d time", Util.SecondsDisplayFormat.format(waitingTime / 1000.0d), Integer.valueOf(i));
            return waitingTime;
        }
        return 0L;
    }

    @Override // com.adjust.sdk.IPurchaseVerificationHandler
    public void init(IActivityHandler iActivityHandler, boolean z, IActivityPackageSender iActivityPackageSender) {
        this.paused = !z;
        this.packageQueue = new ArrayList();
        this.activityHandlerWeakRef = new WeakReference<>(iActivityHandler);
        this.activityPackageSender = iActivityPackageSender;
    }

    @Override // com.adjust.sdk.IPurchaseVerificationHandler
    public void pauseSending() {
        this.paused = true;
    }

    @Override // com.adjust.sdk.IPurchaseVerificationHandler
    public void resumeSending() {
        this.paused = false;
        sendNextPurchaseVerificationPackage();
    }

    @Override // com.adjust.sdk.IPurchaseVerificationHandler
    public void sendPurchaseVerificationPackage(final ActivityPackage activityPackage) {
        this.scheduler.submit(new Runnable() { // from class: com.adjust.sdk.PurchaseVerificationHandler.1
            @Override // java.lang.Runnable
            public final void run() {
                PurchaseVerificationHandler.this.packageQueue.add(activityPackage);
                PurchaseVerificationHandler.this.logger.debug("Added purchase_verification %d", Integer.valueOf(PurchaseVerificationHandler.this.packageQueue.size()));
                PurchaseVerificationHandler.this.logger.verbose("%s", activityPackage.getExtendedString());
                PurchaseVerificationHandler.this.sendNextPurchaseVerificationPackage();
            }
        });
    }

    @Override // com.adjust.sdk.IPurchaseVerificationHandler
    public void teardown() {
        this.logger.verbose("PurchaseVerificationHandler teardown", new Object[0]);
        ThreadScheduler threadScheduler = this.scheduler;
        if (threadScheduler != null) {
            threadScheduler.teardown();
        }
        List<ActivityPackage> list = this.packageQueue;
        if (list != null) {
            list.clear();
        }
        WeakReference<IActivityHandler> weakReference = this.activityHandlerWeakRef;
        if (weakReference != null) {
            weakReference.clear();
        }
        this.logger = null;
        this.packageQueue = null;
        this.backoffStrategy = null;
        this.scheduler = null;
    }
}
