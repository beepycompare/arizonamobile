package com.arizona.game.diagnostics;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import android.os.SystemClock;
import android.system.ErrnoException;
import android.system.Os;
import android.system.OsConstants;
import android.util.Log;
import com.arizona.game.diagnostics.ProcessRestartActivity;
import com.arizona.game.diagnostics.RestartHandoff;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: ProcessRestartActivity.kt */
@Metadata(d1 = {"\u0000G\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000*\u0001\u0010\b\u0007\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0014J\b\u0010\u0016\u001a\u00020\u0013H\u0014J\b\u0010\u0017\u001a\u00020\u0013H\u0014R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0011Ê\u0001\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\u0003\u0010\u0000¨\u0006\u0019"}, d2 = {"Lcom/arizona/game/diagnostics/ProcessRestartActivity;", "Landroid/app/Activity;", "<init>", "()V", "handler", "Landroid/os/Handler;", "resumed", "", "started", "oldPid", "", "deadline", "", "gameIntent", "Landroid/content/Intent;", "waitForExit", "com/arizona/game/diagnostics/ProcessRestartActivity$waitForExit$1", "Lcom/arizona/game/diagnostics/ProcessRestartActivity$waitForExit$1;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onResume", "onPause", "Companion", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ProcessRestartActivity extends Activity {
    private static final String AUTHORIZATION = "reporting_restart.authorization";
    private static final String GAME_ACTIVITY = "com.arizona.game.GTASA";
    private static final String GAME_INTENT = "reporting_restart.game_intent";
    private static final String OLD_PID = "reporting_restart.old_pid";
    private static final String PROCESS_SUFFIX = ":reporting_restart";
    private static final String TAG = "ReportingProcessRestart";
    private long deadline;
    private Intent gameIntent;
    private boolean resumed;
    private boolean started;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    private final Handler handler = new Handler(Looper.getMainLooper());
    private int oldPid = -1;
    private final ProcessRestartActivity$waitForExit$1 waitForExit = new Runnable() { // from class: com.arizona.game.diagnostics.ProcessRestartActivity$waitForExit$1
        @Override // java.lang.Runnable
        public void run() {
            boolean z;
            int i;
            long j;
            Handler handler;
            Intent intent;
            z = ProcessRestartActivity.this.resumed;
            if (!z || ProcessRestartActivity.this.isFinishing()) {
                return;
            }
            ProcessRestartActivity.Companion companion = ProcessRestartActivity.Companion;
            i = ProcessRestartActivity.this.oldPid;
            if (!companion.processExists(i)) {
                intent = ProcessRestartActivity.this.gameIntent;
                ProcessRestartActivity processRestartActivity = ProcessRestartActivity.this;
                if (intent == null) {
                    processRestartActivity.finish();
                    return;
                }
                try {
                    processRestartActivity.startActivity(intent);
                    ProcessRestartActivity.this.finish();
                    Process.killProcess(Process.myPid());
                    return;
                } catch (RuntimeException e) {
                    Log.e("ReportingProcessRestart", "Unable to return to game after process restart", e);
                    ProcessRestartActivity.this.finish();
                    return;
                }
            }
            long elapsedRealtime = SystemClock.elapsedRealtime();
            j = ProcessRestartActivity.this.deadline;
            if (elapsedRealtime < j) {
                handler = ProcessRestartActivity.this.handler;
                handler.postDelayed(this, 25L);
                return;
            }
            Log.e("ReportingProcessRestart", "Old process is still alive; refusing an in-process restart");
            ProcessRestartActivity.this.finish();
        }
    };

    @JvmStatic
    public static final boolean isRestartProcess(Context context) {
        return Companion.isRestartProcess(context);
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        int i;
        super.onCreate(bundle);
        this.oldPid = getIntent().getIntExtra(OLD_PID, -1);
        Intent intent = (Intent) getIntent().getParcelableExtra(GAME_INTENT);
        ProcessRestartActivity processRestartActivity = this;
        if (Companion.isRestartProcess(processRestartActivity) && (i = this.oldPid) > 0 && i != Process.myPid() && intent != null) {
            ComponentName component = intent.getComponent();
            if (Intrinsics.areEqual(component != null ? component.getPackageName() : null, getPackageName())) {
                ComponentName component2 = intent.getComponent();
                if (Intrinsics.areEqual(component2 != null ? component2.getClassName() : null, GAME_ACTIVITY) && CrashReportingPreferences.INSTANCE.isPersistedDisabled(processRestartActivity)) {
                    intent.addFlags(268468224);
                    this.gameIntent = intent;
                    return;
                }
            }
        }
        Log.e(TAG, "Invalid or unpersisted reporting-policy restart");
        finish();
    }

    @Override // android.app.Activity
    protected void onResume() {
        ActivityManager.RunningAppProcessInfo runningAppProcessInfo;
        Object obj;
        super.onResume();
        this.resumed = true;
        if (isFinishing() || this.gameIntent == null) {
            return;
        }
        if (!this.started) {
            List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) getSystemService(ActivityManager.class)).getRunningAppProcesses();
            if (runningAppProcesses != null) {
                Iterator<T> it = runningAppProcesses.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        obj = null;
                        break;
                    }
                    obj = it.next();
                    if (((ActivityManager.RunningAppProcessInfo) obj).pid == this.oldPid) {
                        break;
                    }
                }
                runningAppProcessInfo = (ActivityManager.RunningAppProcessInfo) obj;
            } else {
                runningAppProcessInfo = null;
            }
            if (runningAppProcessInfo != null && (runningAppProcessInfo.uid != Process.myUid() || !Intrinsics.areEqual(runningAppProcessInfo.processName, getPackageName()))) {
                Log.e(TAG, "Refusing to terminate an unrelated process");
                finish();
                return;
            } else if (runningAppProcessInfo == null && Companion.processExists(this.oldPid)) {
                Log.e(TAG, "Unable to verify old process identity");
                finish();
                return;
            } else {
                if (runningAppProcessInfo != null) {
                    RestartHandoff.Companion companion = RestartHandoff.Companion;
                    Bundle extras = getIntent().getExtras();
                    if (!companion.acknowledge(extras != null ? extras.getBinder(AUTHORIZATION) : null)) {
                        Log.w(TAG, "Reporting restart authorization expired or was cancelled");
                        finish();
                        return;
                    }
                }
                this.started = true;
                this.deadline = SystemClock.elapsedRealtime() + 10000;
                if (runningAppProcessInfo != null) {
                    Process.killProcess(this.oldPid);
                }
            }
        }
        this.handler.post(this.waitForExit);
    }

    @Override // android.app.Activity
    protected void onPause() {
        this.resumed = false;
        this.handler.removeCallbacks(this.waitForExit);
        super.onPause();
    }

    /* compiled from: ProcessRestartActivity.kt */
    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001d\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0000¢\u0006\u0002\b\u0011J\u0014\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0007b\u0002\b\u0016J\u0010\u0010\u0017\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\u0019H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/arizona/game/diagnostics/ProcessRestartActivity$Companion;", "", "<init>", "()V", "TAG", "", "PROCESS_SUFFIX", "OLD_PID", "GAME_INTENT", "AUTHORIZATION", "GAME_ACTIVITY", "launch", "", "activity", "Landroid/app/Activity;", "handoff", "Lcom/arizona/game/diagnostics/RestartHandoff;", "launch$app", "isRestartProcess", "", "context", "Landroid/content/Context;", "Lkotlin/jvm/JvmStatic;", "processExists", "pid", "", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final void launch$app(Activity activity, RestartHandoff handoff) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            Intrinsics.checkNotNullParameter(handoff, "handoff");
            Intent intent = new Intent(activity.getIntent());
            intent.setClassName(activity.getPackageName(), ProcessRestartActivity.GAME_ACTIVITY);
            Intent intent2 = new Intent(activity, ProcessRestartActivity.class);
            intent2.putExtra(ProcessRestartActivity.OLD_PID, Process.myPid());
            intent2.putExtra(ProcessRestartActivity.GAME_INTENT, intent);
            Bundle bundle = new Bundle();
            bundle.putBinder(ProcessRestartActivity.AUTHORIZATION, handoff);
            intent2.putExtras(bundle);
            activity.startActivity(intent2);
        }

        @JvmStatic
        public final boolean isRestartProcess(Context context) {
            String str;
            Object obj;
            Intrinsics.checkNotNullParameter(context, "context");
            if (Build.VERSION.SDK_INT >= 28) {
                str = Application.getProcessName();
            } else {
                List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService(ActivityManager.class)).getRunningAppProcesses();
                if (runningAppProcesses != null) {
                    Iterator<T> it = runningAppProcesses.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            obj = null;
                            break;
                        }
                        obj = it.next();
                        if (((ActivityManager.RunningAppProcessInfo) obj).pid == Process.myPid()) {
                            break;
                        }
                    }
                    ActivityManager.RunningAppProcessInfo runningAppProcessInfo = (ActivityManager.RunningAppProcessInfo) obj;
                    if (runningAppProcessInfo != null) {
                        str = runningAppProcessInfo.processName;
                    }
                }
                str = null;
            }
            return Intrinsics.areEqual(str, context.getPackageName() + ProcessRestartActivity.PROCESS_SUFFIX);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean processExists(int i) {
            try {
                Os.kill(i, 0);
                return true;
            } catch (ErrnoException e) {
                return e.errno != OsConstants.ESRCH;
            }
        }
    }
}
