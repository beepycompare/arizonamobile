package com.google.android.vending.expansion.downloader.impl;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.os.Handler;
import android.os.IBinder;
import android.os.Messenger;
import android.os.SystemClock;
import android.provider.Settings;
import android.util.Log;
import androidx.core.app.NotificationCompat;
import com.google.android.vending.expansion.downloader.Constants;
import com.google.android.vending.expansion.downloader.DownloadProgressInfo;
import com.google.android.vending.expansion.downloader.DownloaderServiceMarshaller;
import com.google.android.vending.expansion.downloader.Helpers;
import com.google.android.vending.expansion.downloader.IDownloaderService;
import com.google.android.vending.expansion.downloader.IStub;
import com.google.android.vending.licensing.AESObfuscator;
import com.google.android.vending.licensing.APKExpansionPolicy;
import com.google.android.vending.licensing.LicenseChecker;
import com.google.android.vending.licensing.LicenseCheckerCallback;
import java.io.File;
/* loaded from: classes4.dex */
public abstract class DownloaderService extends CustomIntentService implements IDownloaderService {
    public static final String ACTION_DOWNLOADS_CHANGED = "downloadsChanged";
    public static final String ACTION_DOWNLOAD_COMPLETE = "lvldownloader.intent.action.DOWNLOAD_COMPLETE";
    public static final String ACTION_DOWNLOAD_STATUS = "lvldownloader.intent.action.DOWNLOAD_STATUS";
    public static final int CONTROL_PAUSED = 1;
    public static final int CONTROL_RUN = 0;
    public static final int DOWNLOAD_REQUIRED = 2;
    public static final String EXTRA_FILE_NAME = "downloadId";
    public static final String EXTRA_IS_WIFI_REQUIRED = "isWifiRequired";
    public static final String EXTRA_MESSAGE_HANDLER = "EMH";
    public static final String EXTRA_PACKAGE_NAME = "EPN";
    public static final String EXTRA_PENDING_INTENT = "EPI";
    public static final String EXTRA_STATUS_CURRENT_FILE_SIZE = "CFS";
    public static final String EXTRA_STATUS_CURRENT_PROGRESS = "CFP";
    public static final String EXTRA_STATUS_STATE = "ESS";
    public static final String EXTRA_STATUS_TOTAL_PROGRESS = "TFP";
    public static final String EXTRA_STATUS_TOTAL_SIZE = "ETS";
    private static final String LOG_TAG = "LVLDL";
    public static final int LVL_CHECK_REQUIRED = 1;
    public static final int NETWORK_CANNOT_USE_ROAMING = 5;
    public static final int NETWORK_MOBILE = 1;
    public static final int NETWORK_NO_CONNECTION = 2;
    public static final int NETWORK_OK = 1;
    public static final int NETWORK_RECOMMENDED_UNUSABLE_DUE_TO_SIZE = 4;
    public static final int NETWORK_TYPE_DISALLOWED_BY_REQUESTOR = 6;
    public static final int NETWORK_UNUSABLE_DUE_TO_SIZE = 3;
    public static final int NETWORK_WIFI = 2;
    public static final int NO_DOWNLOAD_REQUIRED = 0;
    private static final float SMOOTHING_FACTOR = 0.005f;
    public static final int STATUS_CANCELED = 490;
    public static final int STATUS_CANNOT_RESUME = 489;
    public static final int STATUS_DEVICE_NOT_FOUND_ERROR = 499;
    public static final int STATUS_FILE_ALREADY_EXISTS_ERROR = 488;
    public static final int STATUS_FILE_DELIVERED_INCORRECTLY = 487;
    public static final int STATUS_FILE_ERROR = 492;
    public static final int STATUS_FORBIDDEN = 403;
    public static final int STATUS_HTTP_DATA_ERROR = 495;
    public static final int STATUS_HTTP_EXCEPTION = 496;
    public static final int STATUS_INSUFFICIENT_SPACE_ERROR = 498;
    public static final int STATUS_PAUSED_BY_APP = 193;
    public static final int STATUS_PENDING = 190;
    public static final int STATUS_QUEUED_FOR_WIFI = 197;
    public static final int STATUS_QUEUED_FOR_WIFI_OR_CELLULAR_PERMISSION = 196;
    public static final int STATUS_RUNNING = 192;
    public static final int STATUS_SUCCESS = 200;
    public static final int STATUS_TOO_MANY_REDIRECTS = 497;
    public static final int STATUS_UNHANDLED_HTTP_CODE = 494;
    public static final int STATUS_UNHANDLED_REDIRECT = 493;
    public static final int STATUS_UNKNOWN_ERROR = 491;
    public static final int STATUS_WAITING_FOR_NETWORK = 195;
    public static final int STATUS_WAITING_TO_RETRY = 194;
    private static final String TEMP_EXT = ".tmp";
    public static final int VISIBILITY_HIDDEN = 2;
    public static final int VISIBILITY_VISIBLE = 0;
    public static final int VISIBILITY_VISIBLE_NOTIFY_COMPLETED = 1;
    private static boolean sIsRunning;
    private PendingIntent mAlarmIntent;
    float mAverageDownloadSpeed;
    long mBytesAtSample;
    long mBytesSoFar;
    private Messenger mClientMessenger;
    private BroadcastReceiver mConnReceiver;
    private ConnectivityManager mConnectivityManager;
    private int mControl;
    int mFileCount;
    private boolean mIsAtLeast3G;
    private boolean mIsAtLeast4G;
    private boolean mIsCellularConnection;
    private boolean mIsConnected;
    private boolean mIsFailover;
    private boolean mIsRoaming;
    long mMillisecondsAtSample;
    private DownloadNotification mNotification;
    private PackageInfo mPackageInfo;
    private PendingIntent mPendingIntent;
    private final Messenger mServiceMessenger;
    private final IStub mServiceStub;
    private boolean mStateChanged;
    private int mStatus;
    long mTotalLength;
    private WifiManager mWifiManager;

    /* loaded from: classes4.dex */
    public static class GenerateSaveFileError extends Exception {
        private static final long serialVersionUID = 3465966015408936540L;
        String mMessage;
        int mStatus;

        public GenerateSaveFileError(int i, String str) {
            this.mStatus = i;
            this.mMessage = str;
        }
    }

    /* loaded from: classes4.dex */
    private class InnerBroadcastReceiver extends BroadcastReceiver {
        final Service mService;

        InnerBroadcastReceiver(Service service) {
            this.mService = service;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            DownloaderService.this.pollNetworkState();
            if (!DownloaderService.this.mStateChanged || DownloaderService.access$400()) {
                return;
            }
            Log.d("LVLDL", "InnerBroadcastReceiver Called");
            Intent intent2 = new Intent(context, this.mService.getClass());
            intent2.putExtra(DownloaderService.EXTRA_PENDING_INTENT, DownloaderService.this.mPendingIntent);
            context.startService(intent2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public class LVLRunnable implements Runnable {
        final Context mContext;

        LVLRunnable(Context context, PendingIntent pendingIntent) {
            this.mContext = context;
            DownloaderService.this.mPendingIntent = pendingIntent;
        }

        @Override // java.lang.Runnable
        public void run() {
            DownloaderService.setServiceRunning(true);
            DownloaderService.this.mNotification.onDownloadStateChanged(2);
            final APKExpansionPolicy aPKExpansionPolicy = new APKExpansionPolicy(this.mContext, new AESObfuscator(DownloaderService.this.getSALT(), this.mContext.getPackageName(), Settings.Secure.getString(this.mContext.getContentResolver(), "android_id")));
            aPKExpansionPolicy.resetPolicy();
            new LicenseChecker(this.mContext, aPKExpansionPolicy, DownloaderService.this.getPublicKey()).checkAccess(new LicenseCheckerCallback() { // from class: com.google.android.vending.expansion.downloader.impl.DownloaderService.LVLRunnable.1
                @Override // com.google.android.vending.licensing.LicenseCheckerCallback
                public void allow(int i) {
                    int i2;
                    try {
                        int expansionURLCount = aPKExpansionPolicy.getExpansionURLCount();
                        DownloadsDB db = DownloadsDB.getDB(LVLRunnable.this.mContext);
                        if (expansionURLCount != 0) {
                            i2 = 0;
                            for (int i3 = 0; i3 < expansionURLCount; i3++) {
                                String expansionFileName = aPKExpansionPolicy.getExpansionFileName(i3);
                                if (expansionFileName != null) {
                                    DownloadInfo downloadInfo = new DownloadInfo(i3, expansionFileName, LVLRunnable.this.mContext.getPackageName());
                                    long expansionFileSize = aPKExpansionPolicy.getExpansionFileSize(i3);
                                    if (DownloaderService.this.handleFileUpdated(db, i3, expansionFileName, expansionFileSize)) {
                                        downloadInfo.resetDownload();
                                        downloadInfo.mUri = aPKExpansionPolicy.getExpansionURL(i3);
                                        downloadInfo.mTotalBytes = expansionFileSize;
                                        downloadInfo.mStatus = -1;
                                        db.updateDownload(downloadInfo);
                                    } else {
                                        DownloadInfo downloadInfoByFileName = db.getDownloadInfoByFileName(downloadInfo.mFileName);
                                        if (downloadInfoByFileName == null) {
                                            Log.d("LVLDL", "file " + downloadInfo.mFileName + " found. Not downloading.");
                                            downloadInfo.mStatus = 200;
                                            downloadInfo.mTotalBytes = expansionFileSize;
                                            downloadInfo.mCurrentBytes = expansionFileSize;
                                            downloadInfo.mUri = aPKExpansionPolicy.getExpansionURL(i3);
                                            db.updateDownload(downloadInfo);
                                        } else if (downloadInfoByFileName.mStatus != 200) {
                                            downloadInfoByFileName.mUri = aPKExpansionPolicy.getExpansionURL(i3);
                                            db.updateDownload(downloadInfoByFileName);
                                        }
                                    }
                                    i2 = -1;
                                }
                            }
                        } else {
                            i2 = 0;
                        }
                        try {
                            db.updateMetadata(LVLRunnable.this.mContext.getPackageManager().getPackageInfo(LVLRunnable.this.mContext.getPackageName(), 0).versionCode, i2);
                            int startDownloadServiceIfRequired = DownloaderService.startDownloadServiceIfRequired(LVLRunnable.this.mContext, DownloaderService.this.mPendingIntent, DownloaderService.this.getClass());
                            if (startDownloadServiceIfRequired == 0) {
                                DownloaderService.this.mNotification.onDownloadStateChanged(5);
                            } else if (startDownloadServiceIfRequired == 1) {
                                Log.e("LVLDL", "In LVL checking loop!");
                                DownloaderService.this.mNotification.onDownloadStateChanged(15);
                                throw new RuntimeException("Error with LVL checking and database integrity");
                            }
                        } catch (PackageManager.NameNotFoundException e) {
                            e.printStackTrace();
                            throw new RuntimeException("Error with getting information from package name");
                        }
                    } finally {
                        DownloaderService.setServiceRunning(false);
                    }
                }

                @Override // com.google.android.vending.licensing.LicenseCheckerCallback
                public void applicationError(int i) {
                    try {
                        DownloaderService.this.mNotification.onDownloadStateChanged(16);
                    } finally {
                        DownloaderService.setServiceRunning(false);
                    }
                }

                @Override // com.google.android.vending.licensing.LicenseCheckerCallback
                public void dontAllow(int i) {
                    try {
                        if (i != 291) {
                            if (i == 561) {
                                DownloaderService.this.mNotification.onDownloadStateChanged(15);
                            }
                        }
                        DownloaderService.this.mNotification.onDownloadStateChanged(16);
                    } finally {
                        DownloaderService.setServiceRunning(false);
                    }
                }
            });
        }
    }

    public DownloaderService() {
        super("LVLDownloadService");
        IStub CreateStub = DownloaderServiceMarshaller.CreateStub(this);
        this.mServiceStub = CreateStub;
        this.mServiceMessenger = CreateStub.getMessenger();
    }

    static /* synthetic */ boolean access$400() {
        return isServiceRunning();
    }

    private void cancelAlarms() {
        if (this.mAlarmIntent != null) {
            AlarmManager alarmManager = (AlarmManager) getSystemService(NotificationCompat.CATEGORY_ALARM);
            if (alarmManager == null) {
                Log.e("LVLDL", "couldn't get alarm manager");
                return;
            }
            alarmManager.cancel(this.mAlarmIntent);
            this.mAlarmIntent = null;
        }
    }

    private static boolean isLVLCheckRequired(DownloadsDB downloadsDB, PackageInfo packageInfo) {
        return downloadsDB.mVersionCode != packageInfo.versionCode;
    }

    private static boolean isServiceRunning() {
        boolean z;
        synchronized (DownloaderService.class) {
            try {
                z = sIsRunning;
            } catch (Throwable th) {
                throw th;
            }
        }
        return z;
    }

    public static boolean isStatusClientError(int i) {
        return i >= 400 && i < 500;
    }

    public static boolean isStatusCompleted(int i) {
        if (i < 200 || i >= 300) {
            return i >= 400 && i < 600;
        }
        return true;
    }

    public static boolean isStatusError(int i) {
        return i >= 400 && i < 600;
    }

    public static boolean isStatusInformational(int i) {
        return i >= 100 && i < 200;
    }

    public static boolean isStatusServerError(int i) {
        return i >= 500 && i < 600;
    }

    public static boolean isStatusSuccess(int i) {
        return i >= 200 && i < 300;
    }

    private void scheduleAlarm(long j) {
        AlarmManager alarmManager = (AlarmManager) getSystemService(NotificationCompat.CATEGORY_ALARM);
        if (alarmManager == null) {
            Log.e("LVLDL", "couldn't get alarm manager");
            return;
        }
        String alarmReceiverClassName = getAlarmReceiverClassName();
        Intent intent = new Intent(Constants.ACTION_RETRY);
        intent.putExtra(EXTRA_PENDING_INTENT, this.mPendingIntent);
        intent.setClassName(getPackageName(), alarmReceiverClassName);
        this.mAlarmIntent = PendingIntent.getBroadcast(this, 0, intent, 1073741824);
        alarmManager.set(0, System.currentTimeMillis() + j, this.mAlarmIntent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void setServiceRunning(boolean z) {
        synchronized (DownloaderService.class) {
            try {
                sIsRunning = z;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static int startDownloadServiceIfRequired(Context context, PendingIntent pendingIntent, Class<?> cls) throws PackageManager.NameNotFoundException {
        return startDownloadServiceIfRequired(context, pendingIntent, context.getPackageName(), cls.getName());
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2, types: [boolean] */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    public static int startDownloadServiceIfRequired(Context context, PendingIntent pendingIntent, String str, String str2) throws PackageManager.NameNotFoundException {
        PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
        DownloadsDB db = DownloadsDB.getDB(context);
        ?? isLVLCheckRequired = isLVLCheckRequired(db, packageInfo);
        if (db.mStatus == 0) {
            DownloadInfo[] downloads = db.getDownloads();
            if (downloads != null) {
                for (DownloadInfo downloadInfo : downloads) {
                    if (!Helpers.doesFileExist(context, downloadInfo.mFileName, downloadInfo.mTotalBytes, true)) {
                        db.updateStatus(-1);
                    }
                }
            }
            if (isLVLCheckRequired != 1 || isLVLCheckRequired == 2) {
                Intent intent = new Intent();
                intent.setClassName(str, str2);
                intent.putExtra(EXTRA_PENDING_INTENT, pendingIntent);
                context.startService(intent);
                return isLVLCheckRequired;
            }
            return isLVLCheckRequired;
        }
        isLVLCheckRequired = 2;
        if (isLVLCheckRequired != 1) {
        }
        Intent intent2 = new Intent();
        intent2.setClassName(str, str2);
        intent2.putExtra(EXTRA_PENDING_INTENT, pendingIntent);
        context.startService(intent2);
        return isLVLCheckRequired;
    }

    public static int startDownloadServiceIfRequired(Context context, Intent intent, Class<?> cls) throws PackageManager.NameNotFoundException {
        return startDownloadServiceIfRequired(context, (PendingIntent) intent.getParcelableExtra(EXTRA_PENDING_INTENT), cls);
    }

    private void updateNetworkState(NetworkInfo networkInfo) {
        boolean z = this.mIsConnected;
        boolean z2 = this.mIsFailover;
        boolean z3 = this.mIsCellularConnection;
        boolean z4 = this.mIsRoaming;
        boolean z5 = this.mIsAtLeast3G;
        boolean z6 = false;
        if (networkInfo != null) {
            this.mIsRoaming = networkInfo.isRoaming();
            this.mIsFailover = networkInfo.isFailover();
            this.mIsConnected = networkInfo.isConnected();
            updateNetworkType(networkInfo.getType(), networkInfo.getSubtype());
        } else {
            this.mIsRoaming = false;
            this.mIsFailover = false;
            this.mIsConnected = false;
            updateNetworkType(-1, -1);
        }
        this.mStateChanged = (!this.mStateChanged && z == this.mIsConnected && z2 == this.mIsFailover && z3 == this.mIsCellularConnection && z4 == this.mIsRoaming && z5 == this.mIsAtLeast3G) ? true : true;
    }

    private void updateNetworkType(int i, int i2) {
        if (i != 0) {
            if (i != 1) {
                if (i == 6) {
                    this.mIsCellularConnection = true;
                    this.mIsAtLeast3G = true;
                    this.mIsAtLeast4G = true;
                    return;
                } else if (i != 7 && i != 9) {
                    return;
                }
            }
            this.mIsCellularConnection = false;
            this.mIsAtLeast3G = false;
            this.mIsAtLeast4G = false;
            return;
        }
        this.mIsCellularConnection = true;
        switch (i2) {
            case 1:
            case 2:
            case 4:
            case 7:
            case 11:
                this.mIsAtLeast3G = false;
                this.mIsAtLeast4G = false;
                return;
            case 3:
            case 5:
            case 6:
            case 8:
            case 9:
            case 10:
                this.mIsAtLeast3G = true;
                this.mIsAtLeast4G = false;
                return;
            case 12:
            default:
                this.mIsCellularConnection = false;
                this.mIsAtLeast3G = false;
                this.mIsAtLeast4G = false;
                return;
            case 13:
            case 14:
            case 15:
                this.mIsAtLeast3G = true;
                this.mIsAtLeast4G = true;
                return;
        }
    }

    public String generateSaveFile(String str, long j) throws GenerateSaveFileError {
        String generateTempSaveFileName = generateTempSaveFileName(str);
        File file = new File(generateTempSaveFileName);
        if (!Helpers.isExternalMediaMounted()) {
            Log.d("LVLDL", "External media not mounted: " + generateTempSaveFileName);
            throw new GenerateSaveFileError(499, "external media is not yet mounted");
        } else if (file.exists()) {
            Log.d("LVLDL", "File already exists: " + generateTempSaveFileName);
            throw new GenerateSaveFileError(488, "requested destination file already exists");
        } else if (Helpers.getAvailableBytes(Helpers.getFilesystemRoot(generateTempSaveFileName)) >= j) {
            return generateTempSaveFileName;
        } else {
            throw new GenerateSaveFileError(498, "insufficient space on external storage");
        }
    }

    public String generateTempSaveFileName(String str) {
        return Helpers.getSaveFilePath(this) + File.separator + str + TEMP_EXT;
    }

    public abstract String getAlarmReceiverClassName();

    public int getControl() {
        return this.mControl;
    }

    public String getLogMessageForNetworkError(int i) {
        return i != 2 ? i != 3 ? i != 4 ? i != 5 ? i != 6 ? "unknown error with network connectivity" : "download was requested to not use the current network type" : "download cannot use the current network connection because it is roaming" : "download size exceeds recommended limit for mobile network" : "download size exceeds limit for mobile network" : "no network connection available";
    }

    public int getNetworkAvailabilityState(DownloadsDB downloadsDB) {
        if (this.mIsConnected) {
            if (this.mIsCellularConnection) {
                int i = downloadsDB.mFlags;
                if (this.mIsRoaming) {
                    return 5;
                }
                if ((i & 1) == 0) {
                    return 6;
                }
            }
            return 1;
        }
        return 2;
    }

    public abstract String getPublicKey();

    public abstract byte[] getSALT();

    public int getStatus() {
        return this.mStatus;
    }

    public boolean handleFileUpdated(DownloadsDB downloadsDB, int i, String str, long j) {
        String str2;
        DownloadInfo downloadInfoByFileName = downloadsDB.getDownloadInfoByFileName(str);
        if (downloadInfoByFileName != null && (str2 = downloadInfoByFileName.mFileName) != null) {
            if (str.equals(str2)) {
                return false;
            }
            File file = new File(Helpers.generateSaveFileName(this, str2));
            if (file.exists()) {
                file.delete();
            }
        }
        return true ^ Helpers.doesFileExist(this, str, j, true);
    }

    public boolean isWiFi() {
        return this.mIsConnected && !this.mIsCellularConnection;
    }

    public void notifyUpdateBytes(long j) {
        long j2;
        long uptimeMillis = SystemClock.uptimeMillis();
        long j3 = this.mMillisecondsAtSample;
        if (0 != j3) {
            float f = ((float) (j - this.mBytesAtSample)) / ((float) (uptimeMillis - j3));
            float f2 = this.mAverageDownloadSpeed;
            if (0.0f != f2) {
                f = (f * SMOOTHING_FACTOR) + (f2 * 0.995f);
            }
            this.mAverageDownloadSpeed = f;
            j2 = ((float) (this.mTotalLength - j)) / this.mAverageDownloadSpeed;
        } else {
            j2 = -1;
        }
        this.mMillisecondsAtSample = uptimeMillis;
        this.mBytesAtSample = j;
        this.mNotification.onDownloadProgress(new DownloadProgressInfo(this.mTotalLength, j, j2, this.mAverageDownloadSpeed));
    }

    @Override // com.google.android.vending.expansion.downloader.impl.CustomIntentService, android.app.Service
    public IBinder onBind(Intent intent) {
        Log.d("LVLDL", "Service Bound");
        return this.mServiceMessenger.getBinder();
    }

    @Override // com.google.android.vending.expansion.downloader.IDownloaderService
    public void onClientUpdated(Messenger messenger) {
        this.mClientMessenger = messenger;
        this.mNotification.setMessenger(messenger);
    }

    @Override // com.google.android.vending.expansion.downloader.impl.CustomIntentService, android.app.Service
    public void onCreate() {
        super.onCreate();
        try {
            this.mPackageInfo = getPackageManager().getPackageInfo(getPackageName(), 0);
            this.mNotification = new DownloadNotification(this, getPackageManager().getApplicationLabel(getApplicationInfo()));
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override // com.google.android.vending.expansion.downloader.impl.CustomIntentService, android.app.Service
    public void onDestroy() {
        BroadcastReceiver broadcastReceiver = this.mConnReceiver;
        if (broadcastReceiver != null) {
            unregisterReceiver(broadcastReceiver);
            this.mConnReceiver = null;
        }
        this.mServiceStub.disconnect(this);
        super.onDestroy();
    }

    @Override // com.google.android.vending.expansion.downloader.impl.CustomIntentService
    protected void onHandleIntent(Intent intent) {
        int i;
        int i2;
        boolean z = true;
        setServiceRunning(true);
        try {
            DownloadsDB db = DownloadsDB.getDB(this);
            PendingIntent pendingIntent = (PendingIntent) intent.getParcelableExtra(EXTRA_PENDING_INTENT);
            if (pendingIntent != null) {
                this.mNotification.setClientIntent(pendingIntent);
                this.mPendingIntent = pendingIntent;
            } else {
                PendingIntent pendingIntent2 = this.mPendingIntent;
                if (pendingIntent2 == null) {
                    Log.e("LVLDL", "Downloader started in bad state without notification intent.");
                    return;
                }
                this.mNotification.setClientIntent(pendingIntent2);
            }
            if (isLVLCheckRequired(db, this.mPackageInfo)) {
                updateLVL(this);
                return;
            }
            DownloadInfo[] downloads = db.getDownloads();
            long j = 0;
            this.mBytesSoFar = 0L;
            this.mTotalLength = 0L;
            this.mFileCount = downloads.length;
            for (DownloadInfo downloadInfo : downloads) {
                if (downloadInfo.mStatus == 200 && !Helpers.doesFileExist(this, downloadInfo.mFileName, downloadInfo.mTotalBytes, true)) {
                    downloadInfo.mStatus = 0;
                    downloadInfo.mCurrentBytes = 0L;
                }
                this.mTotalLength += downloadInfo.mTotalBytes;
                this.mBytesSoFar += downloadInfo.mCurrentBytes;
            }
            pollNetworkState();
            if (this.mConnReceiver == null) {
                this.mConnReceiver = new InnerBroadcastReceiver(this);
                IntentFilter intentFilter = new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");
                intentFilter.addAction("android.net.wifi.WIFI_STATE_CHANGED");
                registerReceiver(this.mConnReceiver, intentFilter);
            }
            int length = downloads.length;
            int i3 = 0;
            while (i3 < length) {
                DownloadInfo downloadInfo2 = downloads[i3];
                long j2 = downloadInfo2.mCurrentBytes;
                if (downloadInfo2.mStatus != 200) {
                    DownloadThread downloadThread = new DownloadThread(downloadInfo2, this, this.mNotification);
                    cancelAlarms();
                    scheduleAlarm(5000L);
                    downloadThread.run();
                    cancelAlarms();
                }
                db.updateFromDb(downloadInfo2);
                int i4 = downloadInfo2.mStatus;
                if (i4 != 200) {
                    if (i4 == 403) {
                        updateLVL(this);
                        return;
                    }
                    if (i4 == 487) {
                        downloadInfo2.mCurrentBytes = j;
                        db.updateDownload(downloadInfo2);
                        i = 13;
                    } else if (i4 == 490) {
                        i = 18;
                    } else if (i4 == 498) {
                        i = 17;
                    } else if (i4 != 499) {
                        switch (i4) {
                            case STATUS_PAUSED_BY_APP /* 193 */:
                                i2 = 7;
                                i = i2;
                                z = false;
                                break;
                            case STATUS_WAITING_TO_RETRY /* 194 */:
                            case STATUS_WAITING_FOR_NETWORK /* 195 */:
                                i = 6;
                                break;
                            case STATUS_QUEUED_FOR_WIFI_OR_CELLULAR_PERMISSION /* 196 */:
                            case STATUS_QUEUED_FOR_WIFI /* 197 */:
                                WifiManager wifiManager = this.mWifiManager;
                                if (wifiManager != null && !wifiManager.isWifiEnabled()) {
                                    i = 8;
                                    break;
                                } else {
                                    i = 9;
                                    break;
                                }
                                break;
                            default:
                                i2 = 19;
                                i = i2;
                                z = false;
                                break;
                        }
                    } else {
                        i = 14;
                    }
                    if (z) {
                        scheduleAlarm(60000L);
                    } else {
                        cancelAlarms();
                    }
                    this.mNotification.onDownloadStateChanged(i);
                    return;
                }
                this.mBytesSoFar += downloadInfo2.mCurrentBytes - j2;
                db.updateMetadata(this.mPackageInfo.versionCode, 0);
                i3++;
                j = 0;
            }
            this.mNotification.onDownloadStateChanged(5);
        } finally {
            setServiceRunning(false);
        }
    }

    void pollNetworkState() {
        if (this.mConnectivityManager == null) {
            this.mConnectivityManager = (ConnectivityManager) getSystemService("connectivity");
        }
        if (this.mWifiManager == null) {
            this.mWifiManager = (WifiManager) getSystemService("wifi");
        }
        ConnectivityManager connectivityManager = this.mConnectivityManager;
        if (connectivityManager == null) {
            Log.w("LVLDL", "couldn't get connectivity manager to poll network state");
        } else {
            updateNetworkState(connectivityManager.getActiveNetworkInfo());
        }
    }

    @Override // com.google.android.vending.expansion.downloader.IDownloaderService
    public void requestAbortDownload() {
        this.mControl = 1;
        this.mStatus = 490;
    }

    @Override // com.google.android.vending.expansion.downloader.IDownloaderService
    public void requestContinueDownload() {
        if (this.mControl == 1) {
            this.mControl = 0;
        }
        Intent intent = new Intent(this, getClass());
        intent.putExtra(EXTRA_PENDING_INTENT, this.mPendingIntent);
        startService(intent);
    }

    @Override // com.google.android.vending.expansion.downloader.IDownloaderService
    public void requestDownloadStatus() {
        this.mNotification.resendState();
    }

    @Override // com.google.android.vending.expansion.downloader.IDownloaderService
    public void requestPauseDownload() {
        this.mControl = 1;
        this.mStatus = STATUS_PAUSED_BY_APP;
    }

    @Override // com.google.android.vending.expansion.downloader.IDownloaderService
    public void setDownloadFlags(int i) {
        DownloadsDB.getDB(this).updateFlags(i);
    }

    @Override // com.google.android.vending.expansion.downloader.impl.CustomIntentService
    protected boolean shouldStop() {
        return DownloadsDB.getDB(this).mStatus == 0;
    }

    public void updateLVL(Context context) {
        Context applicationContext = context.getApplicationContext();
        new Handler(applicationContext.getMainLooper()).post(new LVLRunnable(applicationContext, this.mPendingIntent));
    }
}
