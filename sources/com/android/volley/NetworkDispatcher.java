package com.android.volley;

import android.net.TrafficStats;
import android.os.Process;
import android.os.SystemClock;
import java.util.concurrent.BlockingQueue;
/* loaded from: classes3.dex */
public class NetworkDispatcher extends Thread {
    private final Cache mCache;
    private final ResponseDelivery mDelivery;
    private final Network mNetwork;
    private final BlockingQueue<Request<?>> mQueue;
    private volatile boolean mQuit = false;

    public NetworkDispatcher(BlockingQueue<Request<?>> blockingQueue, Network network, Cache cache, ResponseDelivery responseDelivery) {
        this.mQueue = blockingQueue;
        this.mNetwork = network;
        this.mCache = cache;
        this.mDelivery = responseDelivery;
    }

    public void quit() {
        this.mQuit = true;
        interrupt();
    }

    private void addTrafficStatsTag(Request<?> request) {
        TrafficStats.setThreadStatsTag(request.getTrafficStatsTag());
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        Process.setThreadPriority(10);
        while (true) {
            try {
                processRequest();
            } catch (InterruptedException unused) {
                if (this.mQuit) {
                    Thread.currentThread().interrupt();
                    return;
                }
                VolleyLog.e("Ignoring spurious interrupt of NetworkDispatcher thread; use quit() to terminate it", new Object[0]);
            }
        }
    }

    private void processRequest() throws InterruptedException {
        processRequest(this.mQueue.take());
    }

    void processRequest(Request<?> request) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        request.sendEvent(3);
        try {
            try {
                try {
                    request.addMarker("network-queue-take");
                    if (request.isCanceled()) {
                        request.finish("network-discard-cancelled");
                        request.notifyListenerResponseNotUsable();
                        return;
                    }
                    addTrafficStatsTag(request);
                    NetworkResponse performRequest = this.mNetwork.performRequest(request);
                    request.addMarker("network-http-complete");
                    if (performRequest.notModified && request.hasHadResponseDelivered()) {
                        request.finish("not-modified");
                        request.notifyListenerResponseNotUsable();
                        return;
                    }
                    Response<?> parseNetworkResponse = request.parseNetworkResponse(performRequest);
                    request.addMarker("network-parse-complete");
                    if (request.shouldCache() && parseNetworkResponse.cacheEntry != null) {
                        this.mCache.put(request.getCacheKey(), parseNetworkResponse.cacheEntry);
                        request.addMarker("network-cache-written");
                    }
                    request.markDelivered();
                    this.mDelivery.postResponse(request, parseNetworkResponse);
                    request.notifyListenerResponseReceived(parseNetworkResponse);
                } catch (Exception e) {
                    VolleyLog.e(e, "Unhandled exception %s", e.toString());
                    VolleyError volleyError = new VolleyError(e);
                    volleyError.setNetworkTimeMs(SystemClock.elapsedRealtime() - elapsedRealtime);
                    this.mDelivery.postError(request, volleyError);
                    request.notifyListenerResponseNotUsable();
                }
            } catch (VolleyError e2) {
                e2.setNetworkTimeMs(SystemClock.elapsedRealtime() - elapsedRealtime);
                parseAndDeliverNetworkError(request, e2);
                request.notifyListenerResponseNotUsable();
            }
        } finally {
            request.sendEvent(4);
        }
    }

    private void parseAndDeliverNetworkError(Request<?> request, VolleyError volleyError) {
        this.mDelivery.postError(request, request.parseNetworkError(volleyError));
    }
}
