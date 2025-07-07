package androidx.profileinstaller;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Process;
import androidx.media3.exoplayer.offline.DefaultDownloaderFactory$$ExternalSyntheticLambda0;
import androidx.profileinstaller.ProfileInstaller;
/* loaded from: classes3.dex */
public class ProfileInstallReceiver extends BroadcastReceiver {
    public static final String ACTION_BENCHMARK_OPERATION = "androidx.profileinstaller.action.BENCHMARK_OPERATION";
    public static final String ACTION_INSTALL_PROFILE = "androidx.profileinstaller.action.INSTALL_PROFILE";
    public static final String ACTION_SAVE_PROFILE = "androidx.profileinstaller.action.SAVE_PROFILE";
    public static final String ACTION_SKIP_FILE = "androidx.profileinstaller.action.SKIP_FILE";
    private static final String EXTRA_BENCHMARK_OPERATION = "EXTRA_BENCHMARK_OPERATION";
    private static final String EXTRA_BENCHMARK_OPERATION_DROP_SHADER_CACHE = "DROP_SHADER_CACHE";
    private static final String EXTRA_BENCHMARK_OPERATION_SAVE_PROFILE = "SAVE_PROFILE";
    private static final String EXTRA_PID = "EXTRA_PID";
    private static final String EXTRA_SKIP_FILE_OPERATION = "EXTRA_SKIP_FILE_OPERATION";
    private static final String EXTRA_SKIP_FILE_OPERATION_DELETE = "DELETE_SKIP_FILE";
    private static final String EXTRA_SKIP_FILE_OPERATION_WRITE = "WRITE_SKIP_FILE";

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        Bundle extras;
        if (intent == null) {
            return;
        }
        String action = intent.getAction();
        if (ACTION_INSTALL_PROFILE.equals(action)) {
            ProfileInstaller.writeProfile(context, new DefaultDownloaderFactory$$ExternalSyntheticLambda0(), new ResultDiagnostics(), true);
        } else if (ACTION_SKIP_FILE.equals(action)) {
            Bundle extras2 = intent.getExtras();
            if (extras2 != null) {
                String string = extras2.getString(EXTRA_SKIP_FILE_OPERATION);
                if (EXTRA_SKIP_FILE_OPERATION_WRITE.equals(string)) {
                    ProfileInstaller.writeSkipFile(context, new DefaultDownloaderFactory$$ExternalSyntheticLambda0(), new ResultDiagnostics());
                } else if (EXTRA_SKIP_FILE_OPERATION_DELETE.equals(string)) {
                    ProfileInstaller.deleteSkipFile(context, new DefaultDownloaderFactory$$ExternalSyntheticLambda0(), new ResultDiagnostics());
                }
            }
        } else if (ACTION_SAVE_PROFILE.equals(action)) {
            saveProfile(new ResultDiagnostics());
        } else if (!ACTION_BENCHMARK_OPERATION.equals(action) || (extras = intent.getExtras()) == null) {
        } else {
            String string2 = extras.getString(EXTRA_BENCHMARK_OPERATION);
            ResultDiagnostics resultDiagnostics = new ResultDiagnostics();
            if (EXTRA_BENCHMARK_OPERATION_DROP_SHADER_CACHE.equals(string2)) {
                BenchmarkOperation.dropShaderCache(context, resultDiagnostics);
            } else if (EXTRA_BENCHMARK_OPERATION_SAVE_PROFILE.equals(string2)) {
                saveProfile(extras.getInt(EXTRA_PID, Process.myPid()), resultDiagnostics);
            } else {
                resultDiagnostics.onResultReceived(16, null);
            }
        }
    }

    static void saveProfile(ProfileInstaller.DiagnosticsCallback diagnosticsCallback) {
        saveProfile(Process.myPid(), diagnosticsCallback);
    }

    static void saveProfile(int i, ProfileInstaller.DiagnosticsCallback diagnosticsCallback) {
        Process.sendSignal(i, 10);
        diagnosticsCallback.onResultReceived(12, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class ResultDiagnostics implements ProfileInstaller.DiagnosticsCallback {
        ResultDiagnostics() {
        }

        @Override // androidx.profileinstaller.ProfileInstaller.DiagnosticsCallback
        public void onDiagnosticReceived(int i, Object obj) {
            ProfileInstaller.LOG_DIAGNOSTICS.onDiagnosticReceived(i, obj);
        }

        @Override // androidx.profileinstaller.ProfileInstaller.DiagnosticsCallback
        public void onResultReceived(int i, Object obj) {
            ProfileInstaller.LOG_DIAGNOSTICS.onResultReceived(i, obj);
            ProfileInstallReceiver.this.setResultCode(i);
        }
    }
}
