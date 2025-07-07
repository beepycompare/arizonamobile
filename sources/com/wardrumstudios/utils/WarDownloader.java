package com.wardrumstudios.utils;

import android.app.AlertDialog;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.PowerManager;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.View;
import android.widget.LinearLayout;
import androidx.core.app.NotificationCompat;
import androidx.media3.common.C;
import com.google.firebase.sessions.settings.RemoteSettings;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.Proxy;
import java.net.URL;
import java.util.Calendar;
import org.apache.commons.net.ftp.FTPClient;
/* loaded from: classes4.dex */
public class WarDownloader {
    public String ACCEPT_EULA_BUTTON;
    public String ADDITIONAL_DATA_NEEDED;
    public String APPLICATION_EXITING_TEXT;
    public String CANCEL_BUTTON;
    public String CANNOT_DOWNLOAD_LL_DATA;
    public String CANNOT_WRITE_DATA;
    public String DATA_ACCESS_ERROR;
    public String DATA_ACCESS_ERROR_MESSAGE;
    public String DATA_INACCESSIBLE;
    public String DECLARE_EULA_BUTTON;
    public String DOWNLOADING_FILES_TEXT;
    public String DOWNLOAD_COMPLETE;
    ProgressDialog DownloadProgress;
    public String ESTIMATED_COMPLETION_TEXT;
    public String EULA1;
    public String EULA2;
    public String EULA3;
    public String EULA4;
    public String EXIT_BUTTON;
    public String EXPANDING_AUDIO_FILES;
    public String FATAL_AUDIO_EXTRACTION;
    public String FILES_TEXT;
    public String LICENSE_ERROR;
    public String LICENSE_ERROR_MESSAGE;
    public String LOADING_MESSAGE;
    public String MINUTES_TEXT;
    public String NEXT_BUTTON;
    public String NO_NETWORK;
    public String NO_WIFI;
    public String PLEASE_WAIT_TEXT;
    public String RETURN_TEXT;
    public String SECONDS_TEXT;
    byte[] buf;
    long[] currentRollingAmount;
    long[] currentRollingStart;
    long[] currentRollingTime;
    CDownloadFileList[] downloadFileList;
    NotificationCompat.Builder mBuilder;
    NotificationManager mNotifyManager;
    SurfaceHolder splashHolder;
    protected boolean UseAPKData = false;
    final String TAG = "DownloadManager";
    public int NumThreadsUnzipping = 0;
    public int filesUnzipped = 0;
    boolean UseLocalData = false;
    WarMedia myWarMedia = null;
    long downloadTime = 0;
    boolean ProgressInited = false;
    boolean BreakOut = false;
    long StartTime = 0;
    String currentDownloadingFile = null;
    public boolean UseFTP = false;
    public boolean UseMediaVault = true;
    boolean DownloadButUseLocalLocation = false;
    public boolean UseWardrumData = false;
    boolean DoDownloadTest = false;
    final boolean DoLog = false;
    final String OldDownloadCheckVersion = "Downloadv8";
    final String DownloadCheckVersion = "Downloadv9";
    final String VerifyCheckVersion = "VerifyV1";
    String baseRootDirectory = "/mnt/sdcard/GTA3/";
    private final String WardrumdownloadLocation = "http://wardrumstudios.com/MobileDownloads/gta3/";
    private final String WardrumFtpdownloadLocation = "MobileDownloads/gta3";
    private String downloadLocation = "";
    private String try1 = "";
    boolean IsDisplayingSpash = false;
    public int SpashIcon = 0;
    public long legalStartTime = 0;
    WarDownloader myWarDownloader = null;
    public int compressionScheme = 0;
    public String downloadTitle = "Vice City";
    boolean checkData = true;
    boolean splashViewCreated = false;
    String[] checkModels = {"models/gta3_unc.img", "models/gta3_dxt.img", "models/gta3_atc.img", "models/gta3_pvr.img"};
    boolean justCheckImg = false;
    boolean IOWriteError = false;
    int DownloadFailedMessage = 1;
    byte[] downloadBuffer = null;
    FTPClient ftpClient = null;
    MediaVault mv = null;
    boolean firstTry = true;
    long amountReallyDownloaded = 0;
    long amountDownloaded = 0;
    long timeToDownload = 0;
    long realTimeToDownload = 0;
    int filesToDownload = 0;
    int filesDownloaded = 0;
    long totalToDownload = 0;
    int lastUpdateBytes = 0;
    int rollIndex = -1;
    String notifyMessage = "";
    int CompressionType = -1;
    int numOfDownloadFiles = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.wardrumstudios.utils.WarDownloader$14  reason: invalid class name */
    /* loaded from: classes4.dex */
    public class AnonymousClass14 implements Runnable {
        final /* synthetic */ String val$mess;

        AnonymousClass14(String str) {
            this.val$mess = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            StringBuilder append;
            String str;
            String str2 = this.val$mess;
            if (str2 != "Done Downloading") {
                if (str2 == "Done Downloading Language") {
                    if (WarDownloader.this.DownloadProgress != null) {
                        WarDownloader.this.DownloadProgress.dismiss();
                    }
                    WarDownloader.this.DownloadProgress = null;
                    return;
                }
                if (WarDownloader.this.DownloadProgress != null) {
                    WarDownloader.this.DownloadProgress.setMessage(this.val$mess);
                }
                if (WarDownloader.this.mBuilder != null) {
                    WarDownloader.this.mBuilder.setContentText(WarDownloader.this.notifyMessage);
                    WarDownloader.this.mNotifyManager.notify(0, WarDownloader.this.mBuilder.build());
                    return;
                }
                return;
            }
            if (WarDownloader.this.DownloadProgress != null) {
                WarDownloader.this.DownloadProgress.dismiss();
            }
            WarDownloader.this.DownloadProgress = null;
            long currentTimeMillis = System.currentTimeMillis() - WarDownloader.this.StartTime;
            if (currentTimeMillis > 300000) {
                append = new StringBuilder("").append(currentTimeMillis / 60000).append(" ");
                str = WarDownloader.this.MINUTES_TEXT;
            } else {
                append = new StringBuilder("").append(currentTimeMillis / 1000).append(" ");
                str = WarDownloader.this.SECONDS_TEXT;
            }
            String sb = append.append(str).toString();
            WarDownloader.this.mBuilder.setContentText(WarDownloader.this.DOWNLOAD_COMPLETE + " (" + sb + ")");
            new AlertDialog.Builder(WarDownloader.this.myWarMedia).setMessage(WarDownloader.this.DOWNLOAD_COMPLETE + " (" + sb + ")").setPositiveButton(WarDownloader.this.NEXT_BUTTON, new DialogInterface.OnClickListener() { // from class: com.wardrumstudios.utils.WarDownloader.14.2
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    WarDownloader.this.myWarMedia.runOnUiThread(new Runnable() { // from class: com.wardrumstudios.utils.WarDownloader.14.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            WarDownloader.this.ClearSplash();
                            WarDownloader.this.myWarMedia.DoResumeEvent();
                        }
                    });
                }
            }).setNegativeButton(WarDownloader.this.EXIT_BUTTON, new DialogInterface.OnClickListener() { // from class: com.wardrumstudios.utils.WarDownloader.14.1
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    WarDownloader.this.myWarMedia.finish();
                }
            }).setCancelable(false).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.wardrumstudios.utils.WarDownloader$7  reason: invalid class name */
    /* loaded from: classes4.dex */
    public class AnonymousClass7 implements Runnable {
        final /* synthetic */ String val$fTitle;

        AnonymousClass7(String str) {
            this.val$fTitle = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            new AlertDialog.Builder(WarDownloader.this.myWarMedia).setTitle(this.val$fTitle).setPositiveButton(WarDownloader.this.EXIT_BUTTON, new DialogInterface.OnClickListener() { // from class: com.wardrumstudios.utils.WarDownloader.7.2
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    WarDownloader.this.myWarMedia.finish();
                }
            }).setNegativeButton(WarDownloader.this.NEXT_BUTTON, new DialogInterface.OnClickListener() { // from class: com.wardrumstudios.utils.WarDownloader.7.1
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    WarDownloader.this.myWarMedia.runOnUiThread(new Runnable() { // from class: com.wardrumstudios.utils.WarDownloader.7.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            WarDownloader.this.DownloadDataCheck();
                        }
                    });
                }
            }).setCancelable(false).show().setCanceledOnTouchOutside(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.wardrumstudios.utils.WarDownloader$8  reason: invalid class name */
    /* loaded from: classes4.dex */
    public class AnonymousClass8 implements Runnable {
        AnonymousClass8() {
        }

        @Override // java.lang.Runnable
        public void run() {
            new AlertDialog.Builder(WarDownloader.this.myWarMedia).setMessage(WarDownloader.this.NO_WIFI).setPositiveButton(WarDownloader.this.NEXT_BUTTON, new DialogInterface.OnClickListener() { // from class: com.wardrumstudios.utils.WarDownloader.8.2
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                    new Thread(new Runnable() { // from class: com.wardrumstudios.utils.WarDownloader.8.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            WarDownloader.this.DownloadData();
                        }
                    }).start();
                }
            }).setNegativeButton(WarDownloader.this.CANCEL_BUTTON, new DialogInterface.OnClickListener() { // from class: com.wardrumstudios.utils.WarDownloader.8.1
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    WarDownloader.this.myWarMedia.finish();
                }
            }).setCancelable(false).create().show();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.wardrumstudios.utils.WarDownloader$9  reason: invalid class name */
    /* loaded from: classes4.dex */
    public class AnonymousClass9 implements Runnable {
        AnonymousClass9() {
        }

        @Override // java.lang.Runnable
        public void run() {
            new AlertDialog.Builder(WarDownloader.this.myWarMedia).setMessage(WarDownloader.this.ADDITIONAL_DATA_NEEDED).setPositiveButton(WarDownloader.this.NEXT_BUTTON, new DialogInterface.OnClickListener() { // from class: com.wardrumstudios.utils.WarDownloader.9.2
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                    new Thread(new Runnable() { // from class: com.wardrumstudios.utils.WarDownloader.9.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            WarDownloader.this.DownloadData();
                        }
                    }).start();
                }
            }).setNegativeButton(WarDownloader.this.CANCEL_BUTTON, new DialogInterface.OnClickListener() { // from class: com.wardrumstudios.utils.WarDownloader.9.1
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    WarDownloader.this.myWarMedia.finish();
                }
            }).setCancelable(false).create().show();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class CDownloadFileList {
        boolean downloaded;
        int downloadsize;
        String filename;
        int size;
        boolean unzipped;

        CDownloadFileList() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public class progressFileOutputStream extends FileOutputStream {
        public boolean doCheck;
        int outputCount;

        public progressFileOutputStream(File file) throws FileNotFoundException {
            super(file);
            this.doCheck = true;
            this.outputCount = 0;
        }

        public void write(byte b) throws IOException {
            synchronized (this) {
                super.write((int) b);
            }
        }

        @Override // java.io.FileOutputStream, java.io.OutputStream
        public void write(byte[] bArr) throws IOException {
            synchronized (this) {
                super.write(bArr);
            }
        }

        @Override // java.io.FileOutputStream, java.io.OutputStream
        public void write(byte[] bArr, int i, int i2) throws IOException {
            synchronized (this) {
                if (WarDownloader.this.BreakOut) {
                    throw new IOException();
                }
                super.write(bArr, i, i2);
                if (this.doCheck) {
                    this.outputCount += i2;
                    WarDownloader.this.updateProgress(i2, 0, true);
                }
            }
        }
    }

    private String GetVal(String str) {
        String str2 = "";
        for (int i = 0; i < str.length(); i += 2) {
            int i2 = i + 1;
            str2 = str2 + ((char) (str.charAt(i2) - Integer.parseInt(str.substring(i, i2))));
        }
        return str2;
    }

    static MediaVaultRequest getTimeParameters(String str) {
        long timeInMillis = Calendar.getInstance().getTimeInMillis() / 1000;
        MediaVaultRequest mediaVaultRequest = new MediaVaultRequest(str);
        mediaVaultRequest.setStartTime(timeInMillis - 3600);
        mediaVaultRequest.setEndTime(timeInMillis - (-3600));
        return mediaVaultRequest;
    }

    void ChangeMessage(String str) {
        if (this.myWarMedia.paused && str == "Done Downloading") {
            this.myWarMedia.runOnUiThread(new Runnable() { // from class: com.wardrumstudios.utils.WarDownloader.13
                @Override // java.lang.Runnable
                public void run() {
                    WarDownloader.this.mBuilder.setContentText(WarDownloader.this.DOWNLOAD_COMPLETE);
                    WarDownloader.this.mBuilder.setProgress(0, 0, false);
                    WarDownloader.this.mNotifyManager.cancel(0);
                    WarDownloader.this.mNotifyManager.notify(0, WarDownloader.this.mBuilder.build());
                }
            });
            while (this.myWarMedia.paused) {
                this.myWarMedia.mSleep(1000L);
            }
        }
        this.myWarMedia.handler.post(new AnonymousClass14(str));
    }

    int CheckAndCreate(String str, int i) {
        File file = new File(str);
        if (file.exists() && (i == 0 || file.length() == i)) {
            return 1;
        }
        new File(str.substring(0, str.lastIndexOf(47))).mkdirs();
        return 0;
    }

    void CheckAndDownload() {
        System.out.println("UseAPKData " + this.UseAPKData);
        if (this.UseAPKData) {
            this.myWarMedia.SetConfigSetting("DownloadCheckVersion", "Downloadv9");
            this.myWarMedia.DoResumeEvent();
            return;
        }
        if (!this.justCheckImg) {
            File file = new File(this.baseRootDirectory + "gta3.set");
            if (file.exists()) {
                file.delete();
            }
        }
        CheckForDrive();
        while (!this.myWarMedia.HasGLExtensions) {
            System.out.println("wait for HasGLExtensions");
            this.myWarMedia.mSleep(10L);
        }
        DownloadDataCheck();
    }

    public boolean CheckCompressionFile() {
        CheckToSkipTexture("");
        System.out.println("Check for compression " + this.CompressionType);
        if (this.CompressionType >= 0) {
            if (new File(this.baseRootDirectory + this.checkModels[this.CompressionType]).exists()) {
                return true;
            }
            System.out.println("File " + this.checkModels[this.CompressionType] + " does not exist for compression type " + this.CompressionType);
            return false;
        } else if (this.myWarMedia.glExtensions == "") {
            for (int i = 0; i < 4; i++) {
                if (!new File(this.baseRootDirectory + this.checkModels[i]).exists()) {
                    System.out.println("File " + this.checkModels[i] + " does not exist for compression type " + this.CompressionType);
                    return false;
                }
            }
            return true;
        } else {
            return true;
        }
    }

    void CheckForDrive() {
        new File(this.baseRootDirectory);
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0042, code lost:
        if (r8.myWarMedia.glExtensions.contains("GL_IMG_texture_compression_pvrtc") != false) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0044, code lost:
        r8.CompressionType = 3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0047, code lost:
        r8.CompressionType = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x006c, code lost:
        if (r8.myWarMedia.glExtensions.contains("GL_IMG_texture_compression_pvrtc") != false) goto L16;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    boolean CheckToSkipTexture(String str) {
        if (this.CompressionType == -1) {
            if (this.myWarMedia.glExtensions == null || this.myWarMedia.glExtensions == "") {
                System.out.println("No glextensions - download all");
                return false;
            }
            int i = this.compressionScheme;
            if (i == 0) {
                if (!this.myWarMedia.glExtensions.contains("GL_EXT_texture_compression_dxt1") && !this.myWarMedia.glExtensions.contains("GL_AMD_compressed_ATC_texture")) {
                }
                this.CompressionType = 1;
            } else if (i == 1) {
                if (!this.myWarMedia.glExtensions.contains("GL_EXT_texture_compression_dxt1")) {
                    if (this.myWarMedia.glExtensions.contains("GL_AMD_compressed_ATC_texture")) {
                        this.CompressionType = 2;
                    }
                }
                this.CompressionType = 1;
            }
        }
        if (str.contains("DXT")) {
            if (this.CompressionType == 1) {
                return false;
            }
        } else if (this.compressionScheme == 1 && str.contains("ATC")) {
            if (this.CompressionType == 2) {
                return false;
            }
        } else if (str.contains("PVR")) {
            if (this.CompressionType == 3) {
                return false;
            }
        } else if (this.compressionScheme == 0 && str.contains("ETC")) {
            if (this.CompressionType == 0) {
                return false;
            }
        } else if (this.compressionScheme != 1 || !str.contains("UNC") || this.CompressionType == 0) {
            return false;
        }
        return true;
    }

    void ClearDownloadVals() {
        this.amountReallyDownloaded = 0L;
        this.amountDownloaded = 0L;
        this.timeToDownload = 0L;
        this.realTimeToDownload = 0L;
        this.filesToDownload = 0;
        this.filesDownloaded = 0;
        this.totalToDownload = 0L;
        this.lastUpdateBytes = 0;
        this.rollIndex = -1;
    }

    void ClearSplash() {
        this.myWarMedia.runOnUiThread(new Runnable() { // from class: com.wardrumstudios.utils.WarDownloader.5
            @Override // java.lang.Runnable
            public void run() {
                if (WarDownloader.this.myWarMedia.splashView != null) {
                    WarDownloader.this.myWarMedia.splashView.setVisibility(8);
                }
                WarDownloader.this.myWarMedia.splashView = null;
            }
        });
    }

    void DisplaySplash() {
        try {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            this.myWarMedia.splashView = new View(this.myWarMedia);
            WarMedia warMedia = this.myWarMedia;
            warMedia.addContentView(warMedia.splashView, layoutParams);
            this.myWarMedia.splashView.setBackgroundDrawable(Drawable.createFromStream(this.myWarMedia.getAssets().open("SPLASH1.PNG"), null));
        } catch (Exception unused) {
            this.myWarMedia.splashView.setBackgroundResource(this.SpashIcon);
        }
        this.IsDisplayingSpash = true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x0122, code lost:
        java.lang.System.out.println("Failed Downloading 3 times read " + r0 + " expected " + r16.downloadFileList[r2].size);
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0148, code lost:
        if (r5 == null) goto L75;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x014a, code lost:
        r5.release();
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x014d, code lost:
        return false;
     */
    /* JADX WARN: Removed duplicated region for block: B:103:0x0258 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:116:0x0230 A[EDGE_INSN: B:116:0x0230->B:70:0x0230 ?: BREAK  , SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:118:0x0224 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0205 A[Catch: all -> 0x0229, Exception -> 0x022b, TryCatch #2 {Exception -> 0x022b, blocks: (B:12:0x0044, B:14:0x0048, B:16:0x006e, B:18:0x00af, B:19:0x00b5, B:21:0x00b9, B:23:0x0101, B:25:0x0105, B:27:0x010d, B:28:0x0113, B:33:0x0122, B:39:0x0152, B:40:0x0186, B:48:0x01d2, B:54:0x01e4, B:57:0x0205, B:60:0x0215, B:61:0x021b, B:55:0x01fa, B:43:0x0195, B:45:0x01a8), top: B:105:0x0044, outer: #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0213  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x024a  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0250  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0262  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    boolean DownloadAllFiles() {
        PowerManager.WakeLock wakeLock;
        PowerManager.WakeLock wakeLock2;
        int i;
        boolean z;
        final WarMedia warMedia = this.myWarMedia;
        warMedia.handler.post(new Runnable() { // from class: com.wardrumstudios.utils.WarDownloader.12
            @Override // java.lang.Runnable
            public void run() {
                WarDownloader warDownloader = WarDownloader.this;
                warDownloader.mNotifyManager = (NotificationManager) warDownloader.myWarMedia.getSystemService("notification");
                WarDownloader.this.mBuilder = new NotificationCompat.Builder(WarDownloader.this.myWarMedia);
                WarDownloader.this.mBuilder.setContentTitle(WarDownloader.this.downloadTitle).setContentText(WarDownloader.this.DOWNLOADING_FILES_TEXT + ", " + WarDownloader.this.PLEASE_WAIT_TEXT).setSmallIcon(WarDownloader.this.myWarMedia.appStatusIcon);
                Intent intent = warMedia.appIntent;
                intent.addFlags(C.BUFFER_FLAG_LAST_SAMPLE);
                WarDownloader.this.mBuilder.setContentIntent(PendingIntent.getActivity(WarDownloader.this.myWarMedia, 0, intent, C.BUFFER_FLAG_FIRST_SAMPLE));
                WarDownloader.this.DownloadProgress = new ProgressDialog(warMedia);
                WarDownloader.this.DownloadProgress.setProgressStyle(1);
                WarDownloader.this.DownloadProgress.setMessage(WarDownloader.this.DOWNLOADING_FILES_TEXT + ", " + WarDownloader.this.PLEASE_WAIT_TEXT);
                WarDownloader.this.DownloadProgress.setButton(-1, WarDownloader.this.CANCEL_BUTTON, new DialogInterface.OnClickListener() { // from class: com.wardrumstudios.utils.WarDownloader.12.1
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i2) {
                        if (WarDownloader.this.currentDownloadingFile != null) {
                            new File(WarDownloader.this.currentDownloadingFile).delete();
                        }
                        WarDownloader.this.myWarMedia.finish();
                    }
                });
                WarDownloader.this.DownloadProgress.setCancelable(false);
                WarDownloader.this.DownloadProgress.setCanceledOnTouchOutside(false);
                WarDownloader.this.DownloadProgress.show();
                WarDownloader.this.ProgressInited = true;
            }
        });
        int i2 = 3;
        boolean z2 = true;
        if (!this.DoDownloadTest) {
            try {
                this.StartTime = System.currentTimeMillis();
                wakeLock2 = ((PowerManager) warMedia.getSystemService("power")).newWakeLock(1, "OSWrapper");
                try {
                    try {
                        wakeLock2.acquire();
                    } catch (Exception e) {
                        e = e;
                        e.printStackTrace();
                        if (wakeLock2 != null) {
                            wakeLock2.release();
                        }
                        i = -1;
                        if (i == -1) {
                        }
                        if (this.UseFTP) {
                        }
                        if (z2) {
                        }
                        this.downloadBuffer = null;
                        return z2;
                    }
                } catch (Throwable th) {
                    th = th;
                    wakeLock = wakeLock2;
                    if (wakeLock != null) {
                        wakeLock.release();
                    }
                    throw th;
                }
            } catch (Exception e2) {
                e = e2;
                wakeLock2 = null;
            } catch (Throwable th2) {
                th = th2;
                wakeLock = null;
                if (wakeLock != null) {
                }
                throw th;
            }
            if (!ReadFilelist()) {
                if (wakeLock2 != null) {
                    wakeLock2.release();
                }
                return false;
            }
            UpdateDownloadList();
            do {
                try {
                } catch (Exception e3) {
                    e3.printStackTrace();
                    i = -1;
                }
            } while (!this.ProgressInited);
            ChangeMessage(this.DOWNLOADING_FILES_TEXT + ". " + this.PLEASE_WAIT_TEXT);
            if (this.totalToDownload > 5) {
                ChangeMessage(this.DOWNLOADING_FILES_TEXT + " (" + this.filesToDownload + " " + this.FILES_TEXT + " / " + (this.totalToDownload / 1024) + " MB). " + this.PLEASE_WAIT_TEXT);
                ProgressDialog progressDialog = this.DownloadProgress;
                if (progressDialog != null) {
                    progressDialog.setMax((int) this.totalToDownload);
                }
                NotificationCompat.Builder builder = this.mBuilder;
                if (builder != null) {
                    builder.setContentText(this.DOWNLOADING_FILES_TEXT + " (" + this.filesToDownload + " " + this.FILES_TEXT + " / " + (this.totalToDownload / 1024) + " MB). " + this.PLEASE_WAIT_TEXT);
                    this.mNotifyManager.notify(0, this.mBuilder.build());
                }
            }
            i = -1;
            int i3 = 0;
            loop1: while (i3 < this.numOfDownloadFiles) {
                if (!this.downloadFileList[i3].downloaded) {
                    long currentTimeMillis = System.currentTimeMillis();
                    i = 0;
                    int i4 = 0;
                    while (true) {
                        if (i == this.downloadFileList[i3].size) {
                            z = true;
                            break;
                        }
                        int i5 = i4 + 1;
                        if (i4 > i2) {
                            break loop1;
                        }
                        if (i5 > 0) {
                            System.out.println("Download " + this.downloadFileList[i3].filename + " failed size " + i + " expected " + this.downloadFileList[i3].size);
                        }
                        if (CheckToSkipTexture(this.downloadFileList[i3].filename)) {
                            z = true;
                            i = -3;
                            break;
                        }
                        i = downloadFile(this.downloadFileList[i3].filename, this.downloadFileList[i3].size, true);
                        if (i == -2) {
                            System.out.println("Download " + this.downloadFileList[i3].filename + " already exists");
                            i = 0;
                            z = false;
                            break;
                        }
                        i4 = i5;
                        i2 = 3;
                    }
                    long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                    if (currentTimeMillis2 == 0) {
                        currentTimeMillis2 = 1;
                    }
                    if (i != 0 && i != -3) {
                        this.realTimeToDownload += currentTimeMillis2;
                        this.timeToDownload += this.downloadTime;
                        this.amountReallyDownloaded += i;
                        updateProgress(0, 1, false);
                        if (i == -3) {
                            this.downloadFileList[i3].unzipped = true;
                            this.downloadFileList[i3].downloaded = true;
                        }
                        if (i != -3) {
                            if (!z) {
                                this.downloadFileList[i3].unzipped = true;
                            }
                            this.downloadFileList[i3].downloaded = true;
                        }
                        if (i != -1) {
                            break;
                        }
                    }
                    i = this.downloadFileList[i3].size;
                    updateProgress(i, 1, false);
                    if (i == -3) {
                    }
                    if (i != -3) {
                    }
                    if (i != -1) {
                    }
                }
                i3++;
                i2 = 3;
            }
            if (wakeLock2 != null) {
                wakeLock2.release();
            }
            if (i == -1) {
                z2 = false;
            }
        }
        if (this.UseFTP) {
            try {
                this.ftpClient.disconnect();
                this.ftpClient = null;
            } catch (Exception unused) {
            }
        }
        if (z2) {
            if (!VerifyData()) {
                this.DownloadFailedMessage = 3;
                return false;
            }
            this.myWarMedia.SetConfigSetting("DownloadCheckVersion", "Downloadv9");
            ChangeMessage("Done Downloading");
        }
        this.downloadBuffer = null;
        return z2;
    }

    boolean DownloadData() {
        boolean DownloadAllFiles = DownloadAllFiles();
        this.buf = null;
        if (!DownloadAllFiles) {
            this.myWarMedia.runOnUiThread(new Runnable() { // from class: com.wardrumstudios.utils.WarDownloader.10
                @Override // java.lang.Runnable
                public void run() {
                    System.out.println("Data download failed");
                    new AlertDialog.Builder(WarDownloader.this.myWarMedia).setMessage(WarDownloader.this.IOWriteError ? WarDownloader.this.CANNOT_WRITE_DATA : WarDownloader.this.DownloadFailedMessage == 1 ? WarDownloader.this.DATA_INACCESSIBLE : WarDownloader.this.DownloadFailedMessage == 2 ? WarDownloader.this.CANNOT_DOWNLOAD_LL_DATA : WarDownloader.this.FATAL_AUDIO_EXTRACTION).setPositiveButton(WarDownloader.this.EXIT_BUTTON, new DialogInterface.OnClickListener() { // from class: com.wardrumstudios.utils.WarDownloader.10.1
                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialogInterface, int i) {
                            WarDownloader.this.myWarMedia.finish();
                        }
                    }).setCancelable(false).show();
                }
            });
        }
        this.myWarMedia.ClearSystemNotification();
        return true;
    }

    void DownloadDataCheck() {
        this.myWarMedia.runOnUiThread(new Runnable() { // from class: com.wardrumstudios.utils.WarDownloader.6
            @Override // java.lang.Runnable
            public void run() {
                WarDownloader.this.DisplaySplash();
                if (!WarDownloader.this.checkData) {
                    WarDownloader.this.myWarMedia.DoResumeEvent();
                } else if (!WarDownloader.this.myWarMedia.isNetworkAvailable()) {
                    WarDownloader.this.ShowDownloadNetworkError();
                } else if (WarDownloader.this.myWarMedia.isWiFiAvailable()) {
                    WarDownloader.this.DownloadDataMessage();
                } else {
                    WarDownloader.this.WiFiMessage();
                }
            }
        });
    }

    void DownloadDataMessage() {
        this.myWarMedia.runOnUiThread(new AnonymousClass9());
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0042, code lost:
        if (r7.myWarMedia.glExtensions.contains("GL_IMG_texture_compression_pvrtc") != false) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0044, code lost:
        r7.CompressionType = 3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0047, code lost:
        r7.CompressionType = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x006d, code lost:
        if (r7.myWarMedia.glExtensions.contains("GL_IMG_texture_compression_pvrtc") != false) goto L17;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    boolean GetCompressionType() {
        if (this.CompressionType == -1) {
            if (this.myWarMedia.glExtensions == "") {
                System.out.println("No glextensions - download all");
                return false;
            }
            int i = this.compressionScheme;
            if (i == 0) {
                if (!this.myWarMedia.glExtensions.contains("GL_EXT_texture_compression_dxt1") && !this.myWarMedia.glExtensions.contains("GL_AMD_compressed_ATC_texture")) {
                }
                this.CompressionType = 1;
            } else if (i == 1) {
                if (!this.myWarMedia.glExtensions.contains("GL_EXT_texture_compression_dxt1")) {
                    if (this.myWarMedia.glExtensions.contains("GL_AMD_compressed_ATC_texture")) {
                        this.CompressionType = 2;
                    }
                }
                this.CompressionType = 1;
            }
        }
        return true;
    }

    ProgressDialog MakeProgressDialog() {
        return ProgressDialog.show(this.myWarMedia, "", this.LOADING_MESSAGE, true);
    }

    boolean ReadFilelist() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(this.myWarMedia.getAssets().open("filelist.txt")));
            int i = 0;
            int i2 = 0;
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                if (i == 0) {
                    this.filesToDownload = Integer.decode(readLine).intValue();
                    int intValue = Integer.decode(readLine).intValue();
                    this.numOfDownloadFiles = intValue;
                    this.downloadFileList = new CDownloadFileList[intValue];
                } else if (i == 1) {
                    this.totalToDownload = Integer.decode(readLine).intValue();
                } else if (i - 2 > this.filesToDownload) {
                    System.out.println("Error lineCount " + i + " filesToDownload " + this.filesToDownload);
                    break;
                } else {
                    this.downloadFileList[i2] = new CDownloadFileList();
                    this.downloadFileList[i2].filename = readLine.substring(11);
                    this.downloadFileList[i2].size = Integer.decode(readLine.substring(0, 10).trim()).intValue();
                    if (CheckToSkipTexture(this.downloadFileList[i2].filename)) {
                        this.numOfDownloadFiles--;
                        this.totalToDownload -= this.downloadFileList[i2].size / 1024;
                    } else {
                        this.downloadFileList[i2].downloaded = false;
                        this.downloadFileList[i2].downloadsize = 0;
                        CDownloadFileList cDownloadFileList = this.downloadFileList[i2];
                        cDownloadFileList.unzipped = true ^ cDownloadFileList.filename.contains(".zip");
                        i2++;
                    }
                }
                i++;
            }
            bufferedReader.close();
            return true;
        } catch (Exception e) {
            System.out.println("ERROR in ReadFilelist " + e.getMessage());
            return false;
        }
    }

    public void SetKey(String str) {
        this.try1 = str;
    }

    public void SetLocation(String str) {
        this.downloadLocation = str;
    }

    public void SetWarMedia(WarMedia warMedia) {
        this.myWarMedia = warMedia;
    }

    void ShowDownloadNetworkError() {
        this.myWarMedia.runOnUiThread(new AnonymousClass7(this.NO_NETWORK));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void ShowEULA() {
        while (!this.myWarMedia.HasGLExtensions) {
            this.myWarMedia.mSleep(100L);
        }
        String GetConfigSetting = this.myWarMedia.GetConfigSetting("DownloadCheckVersion");
        this.myWarMedia.GetConfigSetting("VerifyCheckVersion");
        boolean equalsIgnoreCase = GetConfigSetting.equalsIgnoreCase("Downloadv9");
        if (equalsIgnoreCase) {
            if (VerifyData()) {
                this.myWarMedia.SetConfigSetting("DownloadCheckVersion", "Downloadv9");
                this.myWarMedia.SetConfigSetting("VerifyCheckVersion", "VerifyV1");
            } else {
                equalsIgnoreCase = false;
            }
        }
        if (equalsIgnoreCase) {
            this.myWarMedia.DoResumeEvent();
        } else if (this.myWarMedia.GetConfigSetting("VerifyCheckVersion").equalsIgnoreCase("Yes")) {
            this.myWarMedia.runOnUiThread(new Runnable() { // from class: com.wardrumstudios.utils.WarDownloader.1
                @Override // java.lang.Runnable
                public void run() {
                    WarDownloader.this.CheckAndDownload();
                }
            });
        } else {
            final AlertDialog.Builder cancelable = new AlertDialog.Builder(this.myWarMedia).setMessage(this.EULA2 + "\n\n" + this.EULA4 + "\n\n").setPositiveButton(this.ACCEPT_EULA_BUTTON, new DialogInterface.OnClickListener() { // from class: com.wardrumstudios.utils.WarDownloader.3
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                    WarDownloader.this.myWarMedia.SetConfigSetting("VerifyCheckVersion", "Yes");
                    WarDownloader.this.myWarMedia.runOnUiThread(new Runnable() { // from class: com.wardrumstudios.utils.WarDownloader.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            WarDownloader.this.CheckAndDownload();
                        }
                    });
                }
            }).setNegativeButton(this.DECLARE_EULA_BUTTON, new DialogInterface.OnClickListener() { // from class: com.wardrumstudios.utils.WarDownloader.2
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    WarDownloader.this.myWarMedia.finish();
                }
            }).setCancelable(false);
            cancelable.setTitle("EULA");
            this.myWarMedia.runOnUiThread(new Runnable() { // from class: com.wardrumstudios.utils.WarDownloader.4
                @Override // java.lang.Runnable
                public void run() {
                    cancelable.create().show();
                }
            });
        }
    }

    void ShowErrorMessage(int i) {
        this.myWarMedia.runOnUiThread(new Runnable() { // from class: com.wardrumstudios.utils.WarDownloader.11
            @Override // java.lang.Runnable
            public void run() {
                System.out.println("Data download failed");
                new AlertDialog.Builder(WarDownloader.this.myWarMedia).setMessage(WarDownloader.this.DATA_ACCESS_ERROR_MESSAGE).setPositiveButton(WarDownloader.this.EXIT_BUTTON, new DialogInterface.OnClickListener() { // from class: com.wardrumstudios.utils.WarDownloader.11.1
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i2) {
                        WarDownloader.this.myWarMedia.finish();
                    }
                }).setCancelable(false).show();
            }
        });
    }

    void UpdateDownloadList() {
        int i;
        int i2 = 0;
        int i3 = 0;
        for (int i4 = 0; i4 < this.numOfDownloadFiles; i4++) {
            String str = this.myWarMedia.baseDirectory + RemoteSettings.FORWARD_SLASH_STRING + this.downloadFileList[i4].filename;
            try {
            } catch (Exception unused) {
                i = this.downloadFileList[i4].size;
            }
            if (!CheckToSkipTexture(str)) {
                File file = new File(str);
                if (file.exists() && this.downloadFileList[i4].size == file.length()) {
                    this.downloadFileList[i4].downloaded = true;
                } else {
                    i = this.downloadFileList[i4].size;
                    i3 += i;
                    i2++;
                }
            }
        }
        this.filesToDownload = i2;
        this.totalToDownload = i3 / 1024;
        this.filesDownloaded = 0;
    }

    boolean VerifyData() {
        if (ReadFilelist()) {
            for (int i = 0; i < this.numOfDownloadFiles; i++) {
                String str = this.myWarMedia.baseDirectory + RemoteSettings.FORWARD_SLASH_STRING + this.downloadFileList[i].filename;
                try {
                    if (!CheckToSkipTexture(str)) {
                        File file = new File(str);
                        if (!file.exists() || this.downloadFileList[i].size != file.length()) {
                            return false;
                        }
                    }
                } catch (Exception unused) {
                    return false;
                }
            }
            return true;
        }
        return true;
    }

    void WiFiMessage() {
        this.myWarMedia.runOnUiThread(new AnonymousClass8());
    }

    public int downloadFile(String str, int i, boolean z) {
        HttpURLConnection httpURLConnection;
        int i2;
        if (this.UseFTP) {
            try {
                String sb = (!this.UseWardrumData ? new StringBuilder().append(this.downloadLocation).append(str) : new StringBuilder(RemoteSettings.FORWARD_SLASH_STRING).append(str)).toString();
                String str2 = this.myWarMedia.baseDirectory + RemoteSettings.FORWARD_SLASH_STRING + str;
                System.currentTimeMillis();
                int CheckAndCreate = CheckAndCreate(str2, i);
                if (!z || CheckAndCreate <= 0) {
                    this.currentDownloadingFile = str2;
                    if (this.ftpClient == null) {
                        FTPClient fTPClient = new FTPClient();
                        this.ftpClient = fTPClient;
                        fTPClient.setConnectTimeout(5);
                        this.ftpClient.connect("wardrumstudios.com");
                        System.out.println("ftp login " + this.ftpClient.login("wargtavc", "Gt56kj9Dl4f6B!"));
                        this.ftpClient.setFileType(2);
                        this.ftpClient.enterLocalPassiveMode();
                        this.ftpClient.setKeepAlive(true);
                        this.ftpClient.setBufferSize(1048576);
                    }
                    System.out.println("ftp download " + sb + " to " + str2);
                    progressFileOutputStream progressfileoutputstream = new progressFileOutputStream(new File(str2));
                    System.out.println("fos " + progressfileoutputstream.toString());
                    try {
                        if (!this.ftpClient.retrieveFile(sb, progressfileoutputstream)) {
                            System.out.println("ftpRet failed ");
                        }
                        progressfileoutputstream.close();
                        int i3 = i > 0 ? i : 100;
                        System.out.println("ret " + i3);
                        return i3;
                    } catch (Exception unused) {
                        System.out.println("Canceled Download");
                        progressfileoutputstream.close();
                        return -1;
                    }
                }
                return -2;
            } catch (FileNotFoundException e) {
                System.out.println("FileNotFoundException " + e.getMessage());
                this.IOWriteError = true;
                return -1;
            } catch (Exception e2) {
                System.out.println("ftp error " + e2.getMessage());
                e2.printStackTrace();
                return -1;
            }
        }
        try {
            String sb2 = (!this.UseWardrumData ? new StringBuilder().append(this.downloadLocation).append(str) : new StringBuilder("http://wardrumstudios.com/MobileDownloads/gta3/").append(str).append(";type=i")).toString();
            String str3 = this.myWarMedia.baseDirectory + RemoteSettings.FORWARD_SLASH_STRING + str;
            if (this.mv == null) {
                this.mv = new MediaVault(GetVal(this.try1));
            }
            String compute = this.mv.compute(getTimeParameters(sb2));
            System.currentTimeMillis();
            int CheckAndCreate2 = CheckAndCreate(str3, i);
            if (!z || CheckAndCreate2 <= 0) {
                File file = new File(str3);
                this.currentDownloadingFile = str3;
                URL url = new URL(compute);
                int i4 = 0;
                try {
                    httpURLConnection = (HttpURLConnection) url.openConnection(Proxy.NO_PROXY);
                } catch (Exception unused2) {
                }
                if (httpURLConnection.getResponseCode() != 200) {
                    System.out.println("ERROR Downloading " + httpURLConnection.getResponseCode() + " message " + httpURLConnection.getResponseMessage());
                    if (this.firstTry) {
                        this.firstTry = false;
                    }
                    this.DownloadFailedMessage = 2;
                    return -1;
                }
                InputStream inputStream = httpURLConnection.getInputStream();
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                if (this.downloadBuffer == null) {
                    this.downloadBuffer = new byte[1048576];
                }
                int i5 = 0;
                int i6 = 0;
                loop0: while (true) {
                    i2 = i6;
                    do {
                        try {
                            int read = inputStream.read(this.downloadBuffer, i6, 1048576 - i6);
                            if (read == -1) {
                                break loop0;
                            }
                            i2 += read;
                            i6 += read;
                        } catch (Exception unused3) {
                            i4 = i5;
                        }
                    } while (i2 <= 524288);
                    fileOutputStream.write(this.downloadBuffer, 0, i2);
                    i5 += i2;
                    if (z) {
                        updateProgress(i2, 0, true);
                    }
                    i6 = 0;
                }
                if (i2 > 0) {
                    fileOutputStream.write(this.downloadBuffer, 0, i2);
                    i5 += i2;
                    if (z) {
                        updateProgress(i2, 0, true);
                    }
                }
                i4 = i5;
                fileOutputStream.close();
                this.currentDownloadingFile = null;
                return i4;
            }
            return -2;
        } catch (IOException e3) {
            Log.d("DownloadManager", "Error: " + e3);
            this.currentDownloadingFile = null;
            return -1;
        }
    }

    public boolean downloadFile(String str) {
        return downloadFile(str, 0, true) != 0;
    }

    void downloadHttpFile(String str, String str2) {
        try {
            System.currentTimeMillis();
            if (CheckAndCreate(str2, 0) > 0) {
                return;
            }
            File file = new File(str2);
            this.currentDownloadingFile = str2;
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            if (httpURLConnection.getResponseCode() != 200) {
                System.out.println("ERROR Downloading " + httpURLConnection.getResponseCode());
                this.DownloadFailedMessage = 2;
            }
            InputStream inputStream = httpURLConnection.getInputStream();
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            if (this.downloadBuffer == null) {
                this.downloadBuffer = new byte[65536];
            }
            while (true) {
                int read = inputStream.read(this.downloadBuffer, 0, 65536);
                if (read == -1) {
                    fileOutputStream.close();
                    this.currentDownloadingFile = null;
                    return;
                }
                fileOutputStream.write(this.downloadBuffer, 0, read);
            }
        } catch (IOException e) {
            Log.d("DownloadManager", "Error: " + e);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:45:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    void updateProgress(int i, int i2, boolean z) {
        boolean z2;
        String str;
        int i3;
        int i4;
        if (z) {
            int i5 = this.lastUpdateBytes + i;
            this.lastUpdateBytes = i5;
            if (i5 <= 1000000) {
                z2 = false;
                this.filesDownloaded += i2;
                if (z2) {
                    return;
                }
                if (this.rollIndex == -1) {
                    this.currentRollingAmount = r4;
                    this.currentRollingStart = r7;
                    this.currentRollingTime = r1;
                    long j = this.StartTime;
                    long[] jArr = {0, 0};
                    long[] jArr2 = {j, j};
                    long[] jArr3 = {0, 0};
                    this.rollIndex = 0;
                }
                long j2 = this.amountReallyDownloaded;
                int i6 = this.lastUpdateBytes;
                this.amountReallyDownloaded = j2 + i6;
                this.amountDownloaded += i6;
                long[] jArr4 = this.currentRollingAmount;
                int i7 = this.rollIndex;
                jArr4[i7] = jArr4[i7] + i6;
                long[] jArr5 = this.currentRollingTime;
                jArr5[i7] = jArr5[i7] + this.timeToDownload;
                this.timeToDownload = 0L;
                this.lastUpdateBytes = 0;
                long currentTimeMillis = System.currentTimeMillis() - this.currentRollingStart[1 - this.rollIndex];
                this.timeToDownload = currentTimeMillis;
                long[] jArr6 = this.currentRollingAmount;
                long j3 = jArr6[0];
                long j4 = jArr6[1];
                long j5 = j3 + j4;
                if (currentTimeMillis <= 0 || j3 <= 0 || j4 <= 0 || (i3 = (int) (j5 / currentTimeMillis)) <= 0) {
                    str = "";
                } else {
                    int i8 = (((int) (this.totalToDownload - (this.amountDownloaded / 1024))) / i3) / 60;
                    str = this.ESTIMATED_COMPLETION_TEXT + " " + i8 + " " + this.MINUTES_TEXT + " " + (i8 > 5 ? "" : (i4 - (i8 * 60)) + " " + this.SECONDS_TEXT);
                }
                long[] jArr7 = this.currentRollingAmount;
                int i9 = this.rollIndex;
                if (jArr7[i9] > 50000000) {
                    int i10 = 1 - i9;
                    this.rollIndex = i10;
                    this.currentRollingStart[i10] = System.currentTimeMillis();
                    long[] jArr8 = this.currentRollingAmount;
                    int i11 = this.rollIndex;
                    jArr8[i11] = 0;
                    this.currentRollingTime[i11] = 0;
                }
                String str2 = this.DOWNLOADING_FILES_TEXT + " (" + (this.filesToDownload - this.filesDownloaded) + " " + this.FILES_TEXT + " / " + ((this.totalToDownload - (this.amountDownloaded / 1024)) / 1024) + " MB) \n" + this.PLEASE_WAIT_TEXT;
                if (this.timeToDownload > 0) {
                    str2 = str2 + "" + (j5 / this.timeToDownload) + " KB/s " + str;
                }
                this.notifyMessage = "" + (this.filesToDownload - this.filesDownloaded) + " " + this.FILES_TEXT + " / " + ((this.totalToDownload - (this.amountDownloaded / 1024)) / 1024) + " MB ";
                if (this.timeToDownload > 0) {
                    this.notifyMessage += "" + (j5 / this.timeToDownload) + " KB/s " + str;
                }
                ChangeMessage(str2);
                ProgressDialog progressDialog = this.DownloadProgress;
                if (progressDialog != null) {
                    progressDialog.setProgress(((int) this.amountDownloaded) / 1024);
                }
                NotificationCompat.Builder builder = this.mBuilder;
                if (builder != null) {
                    builder.setProgress((int) this.totalToDownload, ((int) this.amountDownloaded) / 1024, false);
                    this.mNotifyManager.notify(0, this.mBuilder.build());
                    return;
                }
                return;
            }
        } else {
            this.amountDownloaded += i;
        }
        z2 = true;
        this.filesDownloaded += i2;
        if (z2) {
        }
    }
}
