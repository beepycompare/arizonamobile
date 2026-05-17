package com.adjust.sdk;

import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class FirstSessionDelayManager {

    /* renamed from: a  reason: collision with root package name */
    public final ActivityHandler f235a;
    public final ArrayList b = new ArrayList();
    public int c = 0;

    public FirstSessionDelayManager(ActivityHandler activityHandler) {
        this.f235a = activityHandler;
    }

    public final void a(Runnable runnable, String str) {
        if (this.c == 3) {
            this.f235a.getAdjustConfig().getLogger().debug("Enqueuing \"" + str + "\" action to be executed after first session delay ends", new Object[0]);
            this.b.add(runnable);
            return;
        }
        runnable.run();
    }

    public final void a(String str, IRunActivityHandler iRunActivityHandler) {
        int i = this.c;
        ActivityHandler activityHandler = this.f235a;
        if (i == 3) {
            activityHandler.getAdjustConfig().getLogger().debug("Enqueuing \"" + str + "\" action to be executed after first session delay ends", new Object[0]);
            this.f235a.getAdjustConfig().preLaunchActions.preLaunchActionsArray.add(iRunActivityHandler);
            return;
        }
        iRunActivityHandler.run(activityHandler);
    }
}
