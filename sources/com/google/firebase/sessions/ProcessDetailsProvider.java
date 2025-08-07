package com.google.firebase.sessions;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import com.google.android.gms.common.util.ProcessUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: ProcessDetailsProvider.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\bJ\u000e\u0010\t\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\b\u0010\n\u001a\u00020\u000bH\u0002¨\u0006\f"}, d2 = {"Lcom/google/firebase/sessions/ProcessDetailsProvider;", "", "<init>", "()V", "getAppProcessDetails", "", "Lcom/google/firebase/sessions/ProcessDetails;", "context", "Landroid/content/Context;", "getMyProcessDetails", "getProcessName", "", "com.google.firebase-firebase-sessions"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ProcessDetailsProvider {
    public static final ProcessDetailsProvider INSTANCE = new ProcessDetailsProvider();

    private ProcessDetailsProvider() {
    }

    public final List<ProcessDetails> getAppProcessDetails(Context context) {
        List<ActivityManager.RunningAppProcessInfo> emptyList;
        Intrinsics.checkNotNullParameter(context, "context");
        int i = context.getApplicationInfo().uid;
        String str = context.getApplicationInfo().processName;
        Object systemService = context.getSystemService("activity");
        ActivityManager activityManager = systemService instanceof ActivityManager ? (ActivityManager) systemService : null;
        if (activityManager == null || (emptyList = activityManager.getRunningAppProcesses()) == null) {
            emptyList = CollectionsKt.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        for (Object obj : CollectionsKt.filterNotNull(emptyList)) {
            if (((ActivityManager.RunningAppProcessInfo) obj).uid == i) {
                arrayList.add(obj);
            }
        }
        ArrayList<ActivityManager.RunningAppProcessInfo> arrayList2 = arrayList;
        ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList2, 10));
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : arrayList2) {
            String processName = runningAppProcessInfo.processName;
            Intrinsics.checkNotNullExpressionValue(processName, "processName");
            arrayList3.add(new ProcessDetails(processName, runningAppProcessInfo.pid, runningAppProcessInfo.importance, Intrinsics.areEqual(runningAppProcessInfo.processName, str)));
        }
        return arrayList3;
    }

    public final ProcessDetails getMyProcessDetails(Context context) {
        Object obj;
        Intrinsics.checkNotNullParameter(context, "context");
        int myPid = Process.myPid();
        Iterator<T> it = getAppProcessDetails(context).iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (((ProcessDetails) obj).getPid() == myPid) {
                break;
            }
        }
        ProcessDetails processDetails = (ProcessDetails) obj;
        return processDetails == null ? new ProcessDetails(getProcessName(), myPid, 0, false) : processDetails;
    }

    private final String getProcessName() {
        String processName;
        if (Build.VERSION.SDK_INT > 33) {
            String myProcessName = Process.myProcessName();
            Intrinsics.checkNotNullExpressionValue(myProcessName, "myProcessName(...)");
            return myProcessName;
        } else if (Build.VERSION.SDK_INT < 28 || (processName = Application.getProcessName()) == null) {
            String myProcessName2 = ProcessUtils.getMyProcessName();
            return myProcessName2 != null ? myProcessName2 : "";
        } else {
            return processName;
        }
    }
}
