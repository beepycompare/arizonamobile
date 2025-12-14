package com.adjust.sdk;

import com.adjust.sdk.scheduler.TimerOnce;
/* loaded from: classes3.dex */
public class AdjustTimeoutCallback {
    private OnAdidReadListener onAdidReadListener;
    private OnAttributionReadListener onAttributionReadListener;
    private TimerOnce timeoutTimer;

    public AdjustTimeoutCallback(OnAdidReadListener onAdidReadListener) {
        this.onAdidReadListener = onAdidReadListener;
    }

    public OnAdidReadListener getOnAdidReadListener() {
        return this.onAdidReadListener;
    }

    public OnAttributionReadListener getOnAttributionReadListener() {
        return this.onAttributionReadListener;
    }

    public TimerOnce getTimeoutTimer() {
        return this.timeoutTimer;
    }

    public void setOnAdidReadListener(OnAdidReadListener onAdidReadListener) {
        this.onAdidReadListener = onAdidReadListener;
    }

    public void setOnAttributionReadListener(OnAttributionReadListener onAttributionReadListener) {
        this.onAttributionReadListener = onAttributionReadListener;
    }

    public void setTimer(TimerOnce timerOnce) {
        this.timeoutTimer = timerOnce;
    }

    public AdjustTimeoutCallback(OnAttributionReadListener onAttributionReadListener) {
        this.onAttributionReadListener = onAttributionReadListener;
    }
}
