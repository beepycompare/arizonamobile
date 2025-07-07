package com.wardrumstudios.utils;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.AlertDialog;
import android.app.KeyguardManager;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.UiModeManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.AssetFileDescriptor;
import android.content.res.Configuration;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.hardware.Camera;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.net.wifi.WifiManager;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Messenger;
import android.os.PowerManager;
import android.os.Process;
import android.os.Vibrator;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.internal.view.SupportMenu;
import androidx.core.view.ViewCompat;
import androidx.media3.common.C;
import androidx.media3.common.MimeTypes;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.google.android.vending.expansion.downloader.DownloadProgressInfo;
import com.google.android.vending.expansion.downloader.DownloaderClientMarshaller;
import com.google.android.vending.expansion.downloader.DownloaderServiceMarshaller;
import com.google.android.vending.expansion.downloader.Helpers;
import com.google.android.vending.expansion.downloader.IDownloaderClient;
import com.google.android.vending.expansion.downloader.IDownloaderService;
import com.google.android.vending.expansion.downloader.IStub;
import com.google.firebase.sessions.settings.RemoteSettings;
import com.nvidia.devtech.NvUtil;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Locale;
import java.util.UUID;
import java.util.regex.Pattern;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
/* loaded from: classes4.dex */
public class WarMedia extends WarGamepad implements MediaPlayer.OnPreparedListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnSeekCompleteListener, MediaPlayer.OnErrorListener, IDownloaderClient {
    static final int REQUEST_READ_EXTERNAL_STORAGE = 8001;
    AudioManager audioManager;
    int audioMax;
    int audioVolume;
    LinearLayout col1;
    LinearLayout col2;
    LinearLayout col3;
    public MediaPlayer dialogPlayer;
    SurfaceHolder downloadHolder;
    SurfaceView downloadView;
    public String localIp;
    int mAscent;
    private TextView mAverageSpeed;
    Camera mCamera;
    private boolean mCancelValidation;
    private View mCellMessage;
    private View mDashboard;
    private IStub mDownloaderClientStub;
    private ProgressBar mPB;
    private Button mPauseButton;
    private TextView mProgressFraction;
    private TextView mProgressPercent;
    private IDownloaderService mRemoteService;
    private int mState;
    private boolean mStatePaused;
    private TextView mStatusText;
    Paint mTextPaint;
    private TextView mTimeRemaining;
    private Button mWiFiSettingsButton;
    protected DisplayMetrics metrics;
    public MediaPlayer musicPlayer;
    private PowerManager.WakeLock myWakeLock;
    protected byte[] privateData;
    protected String[] privateDataFiles;
    LinearLayout row1;
    LinearLayout row2;
    LinearLayout row3;
    TextPaint sTextPaint;
    ArrayList<PoolInfo> sounds;
    Paint tPaint;
    TextPaint textPaint;
    protected String expansionFileName = "";
    protected String patchFileName = "";
    protected String apkFileName = "";
    protected boolean overrideExpansionName = false;
    public XAPKFile[] xAPKS = null;
    public boolean waitForPermissions = false;
    boolean KeepAspectRatio = true;
    boolean ForceSize = false;
    protected boolean UseFTPDownload = false;
    public boolean UseWarDownloader = true;
    public WarDownloader wardown = null;
    private boolean isUserPresent = true;
    private boolean IsScreenPaused = false;
    final boolean DoLog = !this.FinalRelease;
    public MediaPlayer moviePlayer = null;
    boolean skipSound = false;
    boolean skipMovies = false;
    boolean isCompleting = false;
    int bIsPlayingMovie = 0;
    boolean soundLog = false;
    boolean DisplayMovieTextOnTap = false;
    String movieSubtitleText = "";
    boolean movieTextDisplayNow = false;
    protected int SpecialBuildType = 0;
    Activity activity = null;
    protected int HELLO_ID = 12346;
    protected int appStatusIcon = 0;
    protected CharSequence appTickerText = "MyApp";
    protected CharSequence appContentTitle = "MyApp";
    protected CharSequence appContentText = "Running - Return to Game?";
    protected Intent appIntent = null;
    protected boolean UseExpansionFiles = false;
    protected boolean AllowLongPressForExit = false;
    protected boolean hasTouchScreen = true;
    boolean isPhone = false;
    int currentTempID = 100000;
    public String baseDirectory = "/mnt/sdcard/";
    public String baseDirectoryRoot = "/mnt/sdcard/";
    public boolean AddMovieExtension = true;
    int IsShowingBackMessage = 0;
    AlertDialog exitDialog = null;
    protected int cachedSizeRead = 0;
    final boolean UsingSounds = false;
    int memoryThreshold = 0;
    int availableMemory = 0;
    int totalMemory = 0;
    float screenWidthInches = 0.0f;
    protected int baseDisplayWidth = 1920;
    protected int baseDisplayHeight = 1080;
    protected int lastNetworkAvailable = -1;
    protected boolean checkForMaxDisplaySize = false;
    private WifiManager mWifiManager = null;
    boolean downloadViewCreated = false;
    boolean GameIsFocused = false;
    private final BroadcastReceiver mReceiver = new BroadcastReceiver() { // from class: com.wardrumstudios.utils.WarMedia.9
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if (!WarMedia.this.FinalRelease) {
                System.out.println("BroadcastReceiver WarMedia " + action.toString());
            }
            if ("android.intent.action.SCREEN_OFF".equals(action)) {
                if (!WarMedia.this.FinalRelease) {
                    System.out.println("BroadcastReceiver ACTION_SCREEN_OFF");
                }
                WarMedia.this.isUserPresent = false;
            } else if (!"android.intent.action.USER_PRESENT".equals(action) && !"android.intent.action.SCREEN_ON".equals(action)) {
                if (intent.getAction().equals("android.net.conn.CONNECTIVITY_CHANGE")) {
                    WarMedia.this.NetworkChange();
                } else if (WarMedia.this.DoLog) {
                    System.out.println("Received " + action.toString());
                }
            } else {
                if (!WarMedia.this.FinalRelease) {
                    System.out.println("BroadcastReceiver " + action);
                }
                KeyguardManager keyguardManager = (KeyguardManager) WarMedia.this.getSystemService("keyguard");
                if (!WarMedia.this.FinalRelease) {
                    System.out.println("inKeyguardRestrictedInputMode " + keyguardManager.inKeyguardRestrictedInputMode());
                }
                if (keyguardManager.inKeyguardRestrictedInputMode()) {
                    return;
                }
                WarMedia.this.isUserPresent = true;
                if (WarMedia.this.IsScreenPaused) {
                    WarMedia.this.IsScreenPaused = false;
                    if (WarMedia.this.viewIsActive) {
                        WarMedia.this.resumeEvent();
                        if (WarMedia.this.cachedSurfaceHolder != null) {
                            WarMedia.this.cachedSurfaceHolder.setKeepScreenOn(true);
                        }
                    }
                    if (WarMedia.this.paused) {
                        return;
                    }
                    WarMedia.this.PauseMoviePlayer(false);
                }
            }
        }
    };
    boolean bMoviePlayerPaused = false;
    int currentMovieMS = 0;
    String currentMovieFilename = "";
    int currentMovieOffset = 0;
    int currentMovieLength = 0;
    float currentMovieVolume = 0.5f;
    private Vibrator myVib = null;
    long[][] vibrateEffects = {new long[]{0, 100, 100, 100, 100}, new long[]{0, 100, 50, 75, 100, 50, 100}, new long[]{0, 25, 50, 100, 50, 25, 100}, new long[]{0, 25, 50, 25, 100, 100, 100}, new long[]{0, 50, 50, 50, 50, 25, 100}};
    ActivityManager mgr = null;
    ActivityManager.MemoryInfo memInfo = null;
    int[] myPid = null;
    boolean MovieIsSkippable = false;
    long lastMovieStop = 0;
    SurfaceView movieWindowSurface = null;
    SurfaceHolder movieWindowHolder = null;
    SurfaceHolder movieTextHolder = null;
    SurfaceView movieTextSurface = null;
    boolean movieViewIsActive = false;
    boolean movieViewCreated = false;
    SurfaceHolder customMovieHolder = null;
    SurfaceView customMovieSurface = null;
    int movieViewWidth = 0;
    int movieViewHeight = 0;
    int movieViewX = 0;
    int movieViewY = 0;
    int movieLooping = 0;
    LinearLayout movieView = null;
    TextView movieViewText = null;
    public String DeviceLocale = "";
    String DeviceCountry = "";
    private Locale locale = null;
    boolean IsInValidation = false;
    int movieTextScale = 32;
    TextView movieTextView = null;
    boolean MovieTextDisplayed = false;
    public LinearLayout llSplashView = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.wardrumstudios.utils.WarMedia$1  reason: invalid class name */
    /* loaded from: classes4.dex */
    public class AnonymousClass1 implements Runnable {
        final /* synthetic */ Activity val$myActivity;

        AnonymousClass1(Activity activity) {
            this.val$myActivity = activity;
        }

        @Override // java.lang.Runnable
        public void run() {
            WarMedia.this.exitDialog = new AlertDialog.Builder(this.val$myActivity).setTitle("Unknown download error. Please reinstall from Google Play").setPositiveButton("Quit Game", new DialogInterface.OnClickListener() { // from class: com.wardrumstudios.utils.WarMedia.1.2
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    WarMedia.this.finish();
                }
            }).setNegativeButton("Retry", new DialogInterface.OnClickListener() { // from class: com.wardrumstudios.utils.WarMedia.1.1
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    WarMedia.this.runOnUiThread(new Runnable() { // from class: com.wardrumstudios.utils.WarMedia.1.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            WarMedia.this.localHasGameData();
                        }
                    });
                }
            }).setCancelable(false).show();
            WarMedia.this.exitDialog.setCanceledOnTouchOutside(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.wardrumstudios.utils.WarMedia$2  reason: invalid class name */
    /* loaded from: classes4.dex */
    public class AnonymousClass2 implements Runnable {
        final /* synthetic */ Activity val$myActivity;

        AnonymousClass2(Activity activity) {
            this.val$myActivity = activity;
        }

        @Override // java.lang.Runnable
        public void run() {
            WarMedia.this.exitDialog = new AlertDialog.Builder(this.val$myActivity).setTitle("No network connection. Cannot download game data.").setPositiveButton("Quit Game", new DialogInterface.OnClickListener() { // from class: com.wardrumstudios.utils.WarMedia.2.2
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    WarMedia.this.finish();
                }
            }).setNegativeButton("Continue", new DialogInterface.OnClickListener() { // from class: com.wardrumstudios.utils.WarMedia.2.1
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    WarMedia.this.runOnUiThread(new Runnable() { // from class: com.wardrumstudios.utils.WarMedia.2.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            WarMedia.this.localHasGameData();
                        }
                    });
                }
            }).setCancelable(false).show();
            WarMedia.this.exitDialog.setCanceledOnTouchOutside(false);
        }
    }

    /* loaded from: classes4.dex */
    class PoolInfo {
        float duration;
        String filename;
        float lv;
        float rv;
        int soundID;

        PoolInfo() {
        }
    }

    /* loaded from: classes4.dex */
    public static class XAPKFile {
        public final long mFileSize;
        public final int mFileVersion;
        public final boolean mIsMain;

        public XAPKFile(boolean z, int i, long j) {
            this.mIsMain = z;
            this.mFileVersion = i;
            this.mFileSize = j;
        }
    }

    private int getNumberOfProcessors() {
        try {
            return new File("/sys/devices/system/cpu/").listFiles(new FileFilter() { // from class: com.wardrumstudios.utils.WarMedia.1CpuFilter
                @Override // java.io.FileFilter
                public boolean accept(File file) {
                    return Pattern.matches("cpu[0-9]", file.getName());
                }
            }).length;
        } catch (Exception unused) {
            return 1;
        }
    }

    private native void initTouchSense(Context context);

    private void initializeDownloadUI() {
        if (!this.FinalRelease) {
            System.out.println("initializeDownloadUI");
        }
        IStub CreateStub = DownloaderClientMarshaller.CreateStub(this, WarDownloaderService.class);
        this.mDownloaderClientStub = CreateStub;
        CreateStub.connect(this);
        SurfaceView surfaceView = new SurfaceView(this);
        this.downloadView = surfaceView;
        SurfaceHolder holder = surfaceView.getHolder();
        this.downloadHolder = holder;
        holder.addCallback(new SurfaceHolder.Callback() { // from class: com.wardrumstudios.utils.WarMedia.5
            @Override // android.view.SurfaceHolder.Callback
            public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
                if (WarMedia.this.FinalRelease) {
                    return;
                }
                System.out.println("surfaceChanged called - subViewSplash");
            }

            @Override // android.view.SurfaceHolder.Callback
            public final void surfaceCreated(SurfaceHolder surfaceHolder) {
                WarMedia.this.downloadViewCreated = true;
            }

            @Override // android.view.SurfaceHolder.Callback
            public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
                if (WarMedia.this.FinalRelease) {
                    return;
                }
                System.out.println("surfaceDestroyed called - subViewSplash");
            }
        });
        this.downloadHolder.setType(0);
        setContentView(this.downloadView);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        addContentView((LinearLayout) getLayoutInflater().inflate(Helpers.GetResourceIdentifier(getApplicationContext(), "download", TtmlNode.TAG_LAYOUT), (ViewGroup) null), layoutParams);
        this.mPB = (ProgressBar) findViewById(Helpers.GetResourceIdentifier(getApplicationContext(), "progressBar", "id"));
        this.mStatusText = (TextView) findViewById(Helpers.GetResourceIdentifier(getApplicationContext(), "statusText", "id"));
        this.mProgressFraction = (TextView) findViewById(Helpers.GetResourceIdentifier(getApplicationContext(), "progressAsFraction", "id"));
        this.mProgressPercent = (TextView) findViewById(Helpers.GetResourceIdentifier(getApplicationContext(), "progressAsPercentage", "id"));
        this.mAverageSpeed = (TextView) findViewById(Helpers.GetResourceIdentifier(getApplicationContext(), "progressAverageSpeed", "id"));
        this.mTimeRemaining = (TextView) findViewById(Helpers.GetResourceIdentifier(getApplicationContext(), "progressTimeRemaining", "id"));
        this.mDashboard = findViewById(Helpers.GetResourceIdentifier(getApplicationContext(), "downloaderDashboard", "id"));
        this.mCellMessage = findViewById(Helpers.GetResourceIdentifier(getApplicationContext(), "approveCellular", "id"));
        this.mPauseButton = (Button) findViewById(Helpers.GetResourceIdentifier(getApplicationContext(), "pauseButton", "id"));
        this.mWiFiSettingsButton = (Button) findViewById(Helpers.GetResourceIdentifier(getApplicationContext(), "wifiSettingsButton", "id"));
        this.mPauseButton.setOnClickListener(new View.OnClickListener() { // from class: com.wardrumstudios.utils.WarMedia.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                try {
                    if (WarMedia.this.mStatePaused) {
                        WarMedia.this.mRemoteService.requestContinueDownload();
                    } else {
                        WarMedia.this.mRemoteService.requestPauseDownload();
                    }
                    WarMedia warMedia = WarMedia.this;
                    warMedia.setButtonPausedState(!warMedia.mStatePaused);
                } catch (Exception e) {
                    System.out.println("mPauseButton error " + e.getMessage());
                }
            }
        });
        this.mWiFiSettingsButton.setOnClickListener(new View.OnClickListener() { // from class: com.wardrumstudios.utils.WarMedia.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
            }
        });
        ((Button) findViewById(Helpers.GetResourceIdentifier(getApplicationContext(), "resumeOverCellular", "id"))).setOnClickListener(new View.OnClickListener() { // from class: com.wardrumstudios.utils.WarMedia.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                WarMedia.this.mRemoteService.setDownloadFlags(1);
                WarMedia.this.mRemoteService.requestContinueDownload();
                WarMedia.this.mCellMessage.setVisibility(8);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setButtonPausedState(boolean z) {
        Context applicationContext;
        String str;
        this.mStatePaused = z;
        if (z) {
            applicationContext = getApplicationContext();
            str = "text_button_resume";
        } else {
            applicationContext = getApplicationContext();
            str = "text_button_pause";
        }
        this.mPauseButton.setText(Helpers.GetResourceIdentifier(applicationContext, str, TypedValues.Custom.S_STRING));
    }

    private void setState(int i) {
        if (this.mState != i) {
            this.mState = i;
            this.mStatusText.setText(Helpers.getDownloaderStringResourceIDFromState(getApplicationContext(), i));
        }
    }

    public void AfterDownloadFunction() {
        DoResumeEvent();
    }

    void ChangeMovieView(int i, int i2, int i3, int i4) {
        this.row1.setLayoutParams(new LinearLayout.LayoutParams(-2, i2));
        this.row2.setLayoutParams(new LinearLayout.LayoutParams(-2, i4));
        this.col1.setLayoutParams(new LinearLayout.LayoutParams(i, -2));
        this.col2.setLayoutParams(new LinearLayout.LayoutParams(i3, -2));
    }

    public boolean CheckIfNeedsReadPermission(Activity activity) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(getObbDir().getAbsolutePath() + RemoteSettings.FORWARD_SLASH_STRING + Helpers.getExpansionAPKFileName(this, true, this.xAPKS[0].mFileVersion)));
            bufferedReader.read();
            bufferedReader.close();
        } catch (Exception unused) {
            System.out.println("Ask for read permission");
            if (ContextCompat.checkSelfPermission(activity, "android.permission.READ_EXTERNAL_STORAGE") != 0) {
                this.waitForPermissions = true;
                this.delaySetContentView = true;
                if (ActivityCompat.shouldShowRequestPermissionRationale(activity, "android.permission.READ_EXTERNAL_STORAGE")) {
                    ActivityCompat.requestPermissions(activity, new String[]{"android.permission.READ_EXTERNAL_STORAGE"}, REQUEST_READ_EXTERNAL_STORAGE);
                    return true;
                }
                ActivityCompat.requestPermissions(activity, new String[]{"android.permission.READ_EXTERNAL_STORAGE"}, REQUEST_READ_EXTERNAL_STORAGE);
                return true;
            }
        }
        return false;
    }

    void ClearMovieText() {
        runOnUiThread(new Runnable() { // from class: com.wardrumstudios.utils.WarMedia.20
            @Override // java.lang.Runnable
            public void run() {
                Canvas lockCanvas = WarMedia.this.movieTextHolder.lockCanvas();
                lockCanvas.drawColor(0, PorterDuff.Mode.CLEAR);
                WarMedia.this.movieTextHolder.unlockCanvasAndPost(lockCanvas);
            }
        });
    }

    void ClearSplashScreen() {
        runOnUiThread(new Runnable() { // from class: com.wardrumstudios.utils.WarMedia.24
            @Override // java.lang.Runnable
            public void run() {
                if (WarMedia.this.DoLog) {
                    System.out.println("Clearing SplashScreen ");
                }
                if (WarMedia.this.llSplashView != null) {
                    WarMedia.this.llSplashView.setVisibility(8);
                }
                WarMedia.this.llSplashView = null;
            }
        });
    }

    public void ClearSystemNotification() {
        runOnUiThread(new Runnable() { // from class: com.wardrumstudios.utils.WarMedia.12
            @Override // java.lang.Runnable
            public void run() {
                ((NotificationManager) WarMedia.this.getSystemService("notification")).cancelAll();
            }
        });
    }

    public void ClearVidView() {
        runOnUiThread(new Runnable() { // from class: com.wardrumstudios.utils.WarMedia.14
            @Override // java.lang.Runnable
            public void run() {
                if (WarMedia.this.customMovieSurface == null) {
                    if (WarMedia.this.noVidSurface) {
                        return;
                    }
                    WarMedia.this.vidView.setVisibility(8);
                    return;
                }
                WarMedia.this.customMovieSurface.setVisibility(8);
                WarMedia.this.movieView.setVisibility(8);
                WarMedia.this.customMovieSurface = null;
            }
        });
    }

    public boolean ConvertToBitmap(byte[] bArr, int i) {
        return false;
    }

    public boolean CopyFileFromAssets(String str, String str2, boolean z) {
        File file = new File(str2);
        if (!file.exists()) {
            file.getParentFile().mkdirs();
            try {
                InputStream open = getAssets().open(str);
                FileOutputStream fileOutputStream = new FileOutputStream(str2);
                byte[] bArr = new byte[1024];
                while (true) {
                    int read = open.read(bArr);
                    if (read == -1) {
                        open.close();
                        fileOutputStream.flush();
                        fileOutputStream.close();
                        return true;
                    }
                    fileOutputStream.write(bArr, 0, read);
                }
            } catch (Exception unused) {
            }
        }
        return false;
    }

    SurfaceHolder CreatTextSurface(SurfaceView surfaceView) {
        SurfaceHolder holder = surfaceView.getHolder();
        holder.addCallback(new SurfaceHolder.Callback() { // from class: com.wardrumstudios.utils.WarMedia.15
            @Override // android.view.SurfaceHolder.Callback
            public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
                System.out.println("movieTextSurface surfaceChanged width " + i2 + " height " + i3);
            }

            @Override // android.view.SurfaceHolder.Callback
            public void surfaceCreated(SurfaceHolder surfaceHolder) {
                WarMedia.this.movieTextViewIsActive = true;
                Canvas lockCanvas = WarMedia.this.movieTextHolder.lockCanvas();
                lockCanvas.drawColor(0, PorterDuff.Mode.CLEAR);
                WarMedia.this.movieTextHolder.unlockCanvasAndPost(lockCanvas);
                if (WarMedia.this.movieViewCreated) {
                    System.out.println("movieTextSurface surfaceCreated");
                    return;
                }
                System.out.println("movieTextSurface surfaceCreated firsttime");
                WarMedia.this.movieTextViewCreated = true;
            }

            @Override // android.view.SurfaceHolder.Callback
            public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
                System.out.println("movieTextSurface surfaceDestroyed");
                WarMedia.this.movieTextViewIsActive = false;
            }
        });
        System.out.println("movieWindowHolder setType");
        holder.setType(0);
        surfaceView.setZOrderOnTop(true);
        return holder;
    }

    LinearLayout CreateMovieView(int i, int i2, int i3, int i4) {
        LinearLayout linearLayout = new LinearLayout(this.activity);
        linearLayout.setOrientation(1);
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        LinearLayout linearLayout2 = new LinearLayout(this.activity);
        this.row1 = linearLayout2;
        linearLayout2.setOrientation(1);
        this.row1.setLayoutParams(new LinearLayout.LayoutParams(-2, i2));
        linearLayout.addView(this.row1);
        LinearLayout linearLayout3 = new LinearLayout(this.activity);
        this.row2 = linearLayout3;
        linearLayout3.setOrientation(0);
        this.row2.setLayoutParams(new LinearLayout.LayoutParams(-2, i4));
        LinearLayout linearLayout4 = new LinearLayout(this.activity);
        this.col1 = linearLayout4;
        linearLayout4.setOrientation(0);
        this.col1.setLayoutParams(new LinearLayout.LayoutParams(i, -2));
        LinearLayout linearLayout5 = new LinearLayout(this.activity);
        this.col2 = linearLayout5;
        linearLayout5.setOrientation(0);
        this.col2.setLayoutParams(new LinearLayout.LayoutParams(i3, -2));
        SurfaceView surfaceView = new SurfaceView(this.activity);
        this.movieWindowSurface = surfaceView;
        this.col2.addView(surfaceView);
        LinearLayout linearLayout6 = new LinearLayout(this.activity);
        this.col3 = linearLayout6;
        linearLayout6.setOrientation(0);
        this.col3.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        this.row2.addView(this.col1);
        this.row2.addView(this.col2);
        this.row2.addView(this.col3);
        linearLayout.addView(this.row2);
        LinearLayout linearLayout7 = new LinearLayout(this.activity);
        this.row3 = linearLayout7;
        linearLayout7.setOrientation(1);
        this.row3.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        linearLayout.addView(this.row3);
        return linearLayout;
    }

    public void CreateTextBox(int i, int i2, int i3, int i4, int i5) {
    }

    TextView CreateTextView() {
        TextView textView = new TextView(this.activity);
        textView.setLayoutParams(new WindowManager.LayoutParams(-2, -2));
        textView.setTextSize(48.0f);
        textView.setText("Tap to Skip");
        return textView;
    }

    public boolean CustomLoadFunction() {
        return false;
    }

    public void DeleteDirectory(String str, boolean z) {
        File file = new File(str);
        if (file.isDirectory()) {
            String[] list = file.list();
            for (int i = 0; i < list.length; i++) {
                File file2 = new File(file, list[i]);
                if (file2.isDirectory()) {
                    DeleteDirectory(file + RemoteSettings.FORWARD_SLASH_STRING + list[i], z);
                }
                System.out.println("delete " + file + RemoteSettings.FORWARD_SLASH_STRING + list[i]);
                file2.delete();
            }
            file.delete();
        }
    }

    public boolean DeleteFile(String str) {
        String str2 = this.baseDirectory + RemoteSettings.FORWARD_SLASH_STRING + str.replace(AbstractJsonLexerKt.STRING_ESC, '/');
        File file = new File(str2);
        if (this.DoLog) {
            System.out.println("trying to delete file " + str2);
        }
        if (file.exists()) {
            if (this.DoLog) {
                System.out.println("Deleting file " + str2);
            }
            return file.delete();
        }
        return false;
    }

    void DisplayMovieText() {
        System.out.println("DisplayMovieText vidViewIsActive " + this.vidViewIsActive);
        DrawMovieText();
    }

    public void DisplaySplashScreen(final String str, final int i) {
        runOnUiThread(new Runnable() { // from class: com.wardrumstudios.utils.WarMedia.23
            @Override // java.lang.Runnable
            public void run() {
                Drawable createFromStream;
                try {
                    WarMedia.this.handler.postDelayed(new Runnable() { // from class: com.wardrumstudios.utils.WarMedia.23.1
                        @Override // java.lang.Runnable
                        public void run() {
                            WarMedia.this.ClearSplashScreen();
                        }
                    }, i);
                    ImageView imageView = new ImageView(WarMedia.this.getApplicationContext());
                    WarMedia.this.llSplashView = new LinearLayout(WarMedia.this.getApplicationContext());
                    imageView.setImageDrawable(Drawable.createFromStream(WarMedia.this.getAssets().open(str), null));
                    int i2 = WarMedia.this.baseDisplayWidth;
                    int i3 = WarMedia.this.baseDisplayHeight;
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(100, 100);
                    float f = i2;
                    float intrinsicWidth = createFromStream.getIntrinsicWidth() - 40;
                    float f2 = i3;
                    float intrinsicHeight = createFromStream.getIntrinsicHeight() - 40;
                    float f3 = intrinsicWidth / intrinsicHeight;
                    if (f / intrinsicWidth > f2 / intrinsicHeight) {
                        layoutParams.width = (int) (f2 * f3);
                        layoutParams.height = i3;
                    } else {
                        layoutParams.width = i2;
                        layoutParams.height = (int) (f / f3);
                    }
                    int i4 = (i2 - layoutParams.width) / 2;
                    int i5 = (i3 - layoutParams.height) / 2;
                    layoutParams.gravity = 17;
                    WarMedia.this.llSplashView.addView(imageView, layoutParams);
                    LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -1);
                    layoutParams2.gravity = 17;
                    WarMedia warMedia = WarMedia.this;
                    warMedia.addContentView(warMedia.llSplashView, layoutParams2);
                } catch (Exception unused) {
                    WarMedia.this.llSplashView = null;
                    System.out.println("DisplaySplashScreeen Error");
                }
            }
        });
    }

    void DrawMovieText() {
        runOnUiThread(new Runnable() { // from class: com.wardrumstudios.utils.WarMedia.21
            @Override // java.lang.Runnable
            public void run() {
                if (WarMedia.this.movieText.length() <= 0 && WarMedia.this.movieSubtitleText.length() <= 0) {
                    Canvas lockCanvas = WarMedia.this.movieTextHolder.lockCanvas();
                    if (lockCanvas != null) {
                        lockCanvas.drawColor(0, PorterDuff.Mode.CLEAR);
                        WarMedia.this.movieTextHolder.unlockCanvasAndPost(lockCanvas);
                    }
                    WarMedia.this.movieTextSurface.setVisibility(8);
                    return;
                }
                WarMedia.this.movieTextSurface.setVisibility(0);
                String str = WarMedia.this.movieSubtitleText + "\n\n" + (WarMedia.this.movieTextDisplayNow ? WarMedia.this.movieText : "");
                Canvas lockCanvas2 = WarMedia.this.movieTextHolder.lockCanvas();
                if (lockCanvas2 != null) {
                    StaticLayout staticLayout = new StaticLayout(str, WarMedia.this.textPaint, WarMedia.this.surfaceWidth - 100, Layout.Alignment.ALIGN_CENTER, 1.0f, 1.0f, true);
                    StaticLayout staticLayout2 = new StaticLayout(str, WarMedia.this.sTextPaint, WarMedia.this.surfaceWidth - 100, Layout.Alignment.ALIGN_CENTER, 1.0f, 1.0f, true);
                    lockCanvas2.drawColor(0, PorterDuff.Mode.CLEAR);
                    lockCanvas2.translate(52.0f, (WarMedia.this.surfaceHeight - staticLayout2.getHeight()) - 5);
                    staticLayout2.draw(lockCanvas2);
                    lockCanvas2.translate(-2.0f, -2.0f);
                    staticLayout.draw(lockCanvas2);
                    WarMedia.this.movieTextHolder.unlockCanvasAndPost(lockCanvas2);
                }
            }
        });
    }

    public void ExitGame() {
        onDestroy();
        finish();
        Process.killProcess(Process.myPid());
    }

    public String FileGetArchiveName(int i) {
        return i != 0 ? i != 1 ? i != 2 ? "" : this.patchFileName : this.expansionFileName : this.apkFileName;
    }

    public boolean FileRename(String str, String str2, int i) {
        new File(this.baseDirectory + RemoteSettings.FORWARD_SLASH_STRING + str.replace(AbstractJsonLexerKt.STRING_ESC, '/')).renameTo(new File(this.baseDirectory + RemoteSettings.FORWARD_SLASH_STRING + str2.replace(AbstractJsonLexerKt.STRING_ESC, '/')));
        return true;
    }

    public String GetAndroidBuildinfo(int i) {
        return i != 0 ? i != 1 ? i != 2 ? i != 3 ? "UNKNOWN" : Build.HARDWARE : Build.MODEL : Build.PRODUCT : Build.MANUFACTURER;
    }

    public String GetAppId() {
        return getPackageName();
    }

    public int GetAvailableMemory() {
        try {
            Runtime runtime = Runtime.getRuntime();
            long freeMemory = (runtime.freeMemory() / 1024) / 1024;
            runtime.totalMemory();
        } catch (Exception e) {
            e.printStackTrace();
        }
        GetMemoryInfo(false);
        return this.availableMemory;
    }

    public String GetConfigSetting(String str) {
        String string = getPreferences(0).getString(str, "");
        if (this.DoLog) {
            System.out.println("GetConfigSetting " + str + " value " + string);
        }
        return string;
    }

    public int GetDeviceInfo(int i) {
        if (i != 0) {
            if (i != 1) {
                return -1;
            }
            return this.hasTouchScreen ? 1 : 0;
        }
        return getNumberOfProcessors();
    }

    public int GetDeviceLocale() {
        String str = this.DeviceLocale;
        if (str.equals("en")) {
            return 0;
        }
        if (str.equals("fr")) {
            return 1;
        }
        if (str.equals("de")) {
            return 2;
        }
        if (str.equals("it")) {
            return 3;
        }
        if (str.equals("es")) {
            return 4;
        }
        if (str.equals("ja")) {
            return 5;
        }
        if (str.equals("ko")) {
            return 6;
        }
        if (str.equals("sv")) {
            return 7;
        }
        if (str.equals("no") || str.equals("nb") || str.equals("nn")) {
            return 8;
        }
        return str.equals("ru") ? 9 : 0;
    }

    public int GetDeviceType() {
        System.out.println("Build info version device  " + Build.DEVICE);
        System.out.println("Build MANUFACTURER  " + Build.MANUFACTURER);
        System.out.println("Build BOARD  " + Build.BOARD);
        System.out.println("Build DISPLAY  " + Build.DISPLAY);
        System.out.println("Build CPU_ABI  " + Build.CPU_ABI);
        System.out.println("Build CPU_ABI2  " + Build.CPU_ABI2);
        System.out.println("Build HARDWARE  " + Build.HARDWARE);
        System.out.println("Build MODEL  " + Build.MODEL);
        System.out.println("Build PRODUCT  " + Build.PRODUCT);
        int numberOfProcessors = (this.isPhone ? 1 : 0) + (this.glVendor.contains("NVIDIA") ? 2 : 0) + (getNumberOfProcessors() * 4) + (this.availableMemory * 64);
        if (!this.FinalRelease) {
            System.out.println("renderer '" + this.glVendor + "' ret=" + numberOfProcessors);
        }
        return numberOfProcessors;
    }

    public String GetGameBaseDirectory() {
        if (Environment.getExternalStorageState().equals("mounted")) {
            try {
                File externalFilesDir = getExternalFilesDir(null);
                String absolutePath = externalFilesDir.getAbsolutePath();
                this.baseDirectoryRoot = absolutePath.substring(0, absolutePath.indexOf("/Android"));
                return externalFilesDir.getAbsolutePath() + RemoteSettings.FORWARD_SLASH_STRING;
            } catch (NullPointerException | Exception unused) {
            }
        }
        ShowSDErrorDialog();
        return "";
    }

    public String GetLocalIp() {
        return this.localIp;
    }

    public int GetLocale() {
        String GetConfigSetting = GetConfigSetting("currentLanguage");
        if (GetConfigSetting == "en") {
            return 0;
        }
        if (GetConfigSetting == "fr") {
            return 1;
        }
        if (GetConfigSetting == "de") {
            return 2;
        }
        if (GetConfigSetting == "it") {
            return 3;
        }
        if (GetConfigSetting == "es") {
            return 4;
        }
        if (GetConfigSetting == "ja") {
            return 5;
        }
        if (GetConfigSetting.equals("ko")) {
            return 6;
        }
        if (GetConfigSetting.equals("sv")) {
            return 7;
        }
        return (GetConfigSetting.equals("no") || GetConfigSetting.equals("nb") || GetConfigSetting.equals("nn")) ? 8 : 0;
    }

    public int GetLowThreshhold() {
        return this.memoryThreshold;
    }

    void GetMaxDisplaySize() {
        Display defaultDisplay = getWindowManager().getDefaultDisplay();
        Point point = new Point();
        defaultDisplay.getSize(point);
        System.out.println("width=" + point.x + " height=" + point.y);
        if (this.maxDisplayWidth < point.x) {
            this.maxDisplayWidth = point.x;
            this.maxDisplayHeight = point.y;
        }
        Display.Mode[] supportedModes = defaultDisplay.getSupportedModes();
        for (int i = 0; i < supportedModes.length; i++) {
            Display.Mode mode = supportedModes[i];
            if (this.maxDisplayWidth < mode.getPhysicalWidth()) {
                this.maxDisplayWidth = mode.getPhysicalWidth();
                this.maxDisplayHeight = mode.getPhysicalHeight();
            }
            System.out.println("mode " + i + " width=" + mode.getPhysicalWidth() + " height=" + mode.getPhysicalHeight());
        }
    }

    public int GetMemoryInfo(boolean z) {
        if (this.mgr == null) {
            this.mgr = (ActivityManager) super.getSystemService("activity");
            this.memInfo = new ActivityManager.MemoryInfo();
        }
        this.mgr.getMemoryInfo(this.memInfo);
        this.memoryThreshold = (int) (this.memInfo.threshold / 1024);
        this.availableMemory = (int) ((this.memInfo.availMem / 1024) / 1024);
        this.totalMemory = (int) ((this.memInfo.totalMem / 1024) / 1024);
        if (z) {
            this.mgr.getRunningAppProcesses();
            List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = this.mgr.getRunningAppProcesses();
            int[] iArr = new int[runningAppProcesses.size()];
            for (int i = 0; i < runningAppProcesses.size(); i++) {
                iArr[i] = runningAppProcesses.get(i).pid;
            }
        } else {
            int[] iArr2 = this.myPid;
            if (iArr2 != null) {
                this.mgr.getProcessMemoryInfo(iArr2);
            }
        }
        return (int) ((this.memInfo.availMem / 1024) / 1024);
    }

    public String GetPackageName(String str) {
        List<ApplicationInfo> installedApplications = getPackageManager().getInstalledApplications(8192);
        for (int i = 0; i < installedApplications.size(); i++) {
            if (str.compareToIgnoreCase(installedApplications.get(i).packageName.toString()) == 0) {
                return installedApplications.get(i).sourceDir;
            }
        }
        return "";
    }

    public void GetRealLocale() {
        Locale locale = Locale.getDefault();
        String language = Locale.getDefault().getLanguage();
        String displayLanguage = Locale.getDefault().getDisplayLanguage();
        this.DeviceCountry = Locale.getDefault().getCountry();
        if (this.DoLog) {
            System.out.println("SetLocale getDefault " + language + " langLocal " + locale + " locale " + displayLanguage + " DeviceCountry " + this.DeviceCountry);
        }
        this.DeviceLocale = language;
    }

    public float GetScreenWidthInches() {
        return this.screenWidthInches;
    }

    int GetSoundsIndex(String str) {
        for (int i = 0; i < this.sounds.size(); i++) {
            PoolInfo poolInfo = this.sounds.get(i);
            if (poolInfo.filename.equals(str)) {
                return poolInfo.soundID;
            }
        }
        return -1;
    }

    public int GetSpecialBuildType() {
        return this.SpecialBuildType;
    }

    public int GetTotalMemory() {
        return this.totalMemory;
    }

    public boolean IsAppInstalled(String str) {
        List<ApplicationInfo> installedApplications = getPackageManager().getInstalledApplications(8192);
        for (int i = 0; i < installedApplications.size(); i++) {
            System.out.println("app[" + i + "]=" + installedApplications.get(i).packageName + " dir " + installedApplications.get(i).sourceDir);
            if (str.compareToIgnoreCase(installedApplications.get(i).packageName.toString()) == 0) {
                return true;
            }
        }
        return false;
    }

    public boolean IsCloudAvailable() {
        return false;
    }

    public boolean IsKeyboardShown() {
        return this.IsShowingKeyboard;
    }

    public int IsMoviePlaying() {
        MediaPlayer mediaPlayer;
        if (this.bMoviePlayerPaused) {
            return 2;
        }
        int i = this.bIsPlayingMovie;
        if (i == 1) {
            return i;
        }
        if (i == 2 && (mediaPlayer = this.moviePlayer) != null) {
            try {
                if (mediaPlayer.isPlaying()) {
                    return this.bIsPlayingMovie;
                }
            } catch (IllegalStateException unused) {
            }
        }
        return 0;
    }

    public boolean IsMovieViewActive() {
        return this.customMovieSurface == null ? this.vidViewIsActive : this.movieViewIsActive;
    }

    public boolean IsPhone() {
        return (getResources().getConfiguration().screenLayout & 15) < 3;
    }

    public boolean IsTV() {
        return this.IsAndroidTV;
    }

    public void LoadAllGamesFromCloud() {
    }

    public String LoadGameFromCloud(int i, byte[] bArr) {
        return "";
    }

    public void MovieClearText(boolean z) {
        if (z) {
            this.movieSubtitleText = "";
        } else {
            this.movieText = "";
        }
        DrawMovieText();
    }

    public void MovieDisplayText(boolean z) {
        System.out.println("MovieDisplayText " + z);
        if (!z || this.MovieTextDisplayed) {
            return;
        }
        DisplayMovieText();
    }

    public void MovieKeepAspectRatio(boolean z) {
        this.KeepAspectRatio = z;
    }

    public void MovieSetSkippable(boolean z) {
        this.MovieIsSkippable = z;
    }

    public void MovieSetText(String str, boolean z, boolean z2) {
        if (z2) {
            this.movieSubtitleText = str;
        } else {
            this.DisplayMovieTextOnTap = !z;
            this.movieTextDisplayNow = z;
            this.movieText = str;
        }
        if (z) {
            DisplayMovieText();
        } else if (z) {
        } else {
            runOnUiThread(new Runnable() { // from class: com.wardrumstudios.utils.WarMedia.22
                @Override // java.lang.Runnable
                public void run() {
                    System.out.println("MovieSetText create surface");
                    WarMedia.this.movieTextSurface.setVisibility(0);
                }
            });
        }
    }

    void MovieSetTextScale(int i) {
        this.movieTextScale = i;
        SetPaint(-16711936, i);
    }

    public native void NativeNotifyNetworkChange(int i);

    protected void NetworkChange() {
        int i = isWiFiAvailable() ? 2 : isNetworkAvailable() ? 1 : 0;
        if (i != this.lastNetworkAvailable) {
            NativeNotifyNetworkChange(i);
            this.lastNetworkAvailable = i;
        }
    }

    public boolean NewCloudSaveAvailable(int i) {
        return false;
    }

    public String OBFU_GetDeviceID() {
        TelephonyManager telephonyManager = (TelephonyManager) getBaseContext().getSystemService("phone");
        return new UUID(("" + Settings.Secure.getString(getContentResolver(), "android_id")).hashCode(), (("" + telephonyManager.getDeviceId()).hashCode() << 32) | ("" + telephonyManager.getSimSerialNumber()).hashCode()).toString();
    }

    void OpenLink(String str) {
        startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
    }

    void PauseMoviePlayer(final boolean z) {
        if (this.moviePlayer == null) {
            return;
        }
        new Thread(new Runnable() { // from class: com.wardrumstudios.utils.WarMedia.10
            @Override // java.lang.Runnable
            public void run() {
                WarMedia.this.PauseMoviePlayerThread(z);
            }
        }).start();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v10 */
    /* JADX WARN: Type inference failed for: r4v12 */
    /* JADX WARN: Type inference failed for: r4v13 */
    /* JADX WARN: Type inference failed for: r4v14 */
    /* JADX WARN: Type inference failed for: r4v3 */
    /* JADX WARN: Type inference failed for: r4v4 */
    /* JADX WARN: Type inference failed for: r4v5, types: [com.wardrumstudios.utils.WarMedia] */
    /* JADX WARN: Type inference failed for: r4v6, types: [com.wardrumstudios.utils.WarMedia] */
    void PauseMoviePlayerThread(boolean z) {
        WarMedia warMedia;
        if (!this.skipMovies) {
            if (z) {
                try {
                    MediaPlayer mediaPlayer = this.moviePlayer;
                    if (mediaPlayer != null) {
                        if (!mediaPlayer.isPlaying()) {
                            System.out.println("moviePlayer not playing");
                            this.moviePlayer.release();
                            this.moviePlayer = null;
                            this.bMoviePlayerPaused = false;
                            return;
                        }
                        try {
                            this.currentMovieMS = this.moviePlayer.getCurrentPosition();
                            this.moviePlayer.pause();
                            this.bMoviePlayerPaused = true;
                            System.out.println("moviePlayer paused at " + this.currentMovieMS);
                        } catch (Exception e) {
                            System.out.println("moviePlayer pause failed " + e.getMessage());
                            try {
                                MediaPlayer mediaPlayer2 = this.moviePlayer;
                                if (mediaPlayer2 != null) {
                                    mediaPlayer2.release();
                                }
                            } catch (Exception unused) {
                            }
                            this.moviePlayer = null;
                            ClearVidView();
                            this.bMoviePlayerPaused = false;
                        }
                    }
                } catch (IllegalStateException e2) {
                    System.out.println("PauseMoviePlayerThread err " + e2.getMessage());
                    ClearVidView();
                    this.moviePlayer = null;
                    this.bIsPlayingMovie = 0;
                    this.bMoviePlayerPaused = false;
                }
            } else {
                System.out.println("moviePlayer resume bMoviePlayerPaused " + this.bMoviePlayerPaused + " moviePlayer " + this.moviePlayer);
                boolean z2 = this.bMoviePlayerPaused;
                if (z2 && this.moviePlayer == null) {
                    int i = this.currentMovieLength;
                    if (i > 0) {
                        PlayMovieInFile(this.currentMovieFilename, 1.0f, this.currentMovieOffset, i);
                    } else {
                        PlayMovie(this.currentMovieFilename, 1.0f);
                    }
                    this.bMoviePlayerPaused = false;
                } else if (z2 && this.moviePlayer != null) {
                    int i2 = 0;
                    try {
                        do {
                            warMedia = 5;
                            if (IsMovieViewActive()) {
                                break;
                            }
                            if (!this.FinalRelease) {
                                System.out.println("moviePlayer waiting for vidViewIsActive");
                            }
                            mSleep(100L);
                            i2++;
                        } while (i2 <= 5);
                        break;
                        if (i2 <= 5) {
                            try {
                                System.out.println("moviePlayer paused false");
                                int i3 = this.currentMovieLength;
                                if (i3 > 0) {
                                    WarMedia warMedia2 = this;
                                    warMedia2.PlayMovieInFile(this.currentMovieFilename, 1.0f, this.currentMovieOffset, i3, this.movieWindowHolder);
                                    warMedia = warMedia2;
                                } else {
                                    WarMedia warMedia3 = this;
                                    PlayMovie(warMedia3.currentMovieFilename, 1.0f);
                                    warMedia = warMedia3;
                                }
                            } catch (Exception e3) {
                                e = e3;
                                warMedia = this;
                                System.out.println("moviePlayer resume failed " + e.getMessage());
                                warMedia.moviePlayer = null;
                                ClearVidView();
                                warMedia.bMoviePlayerPaused = false;
                            }
                        } else {
                            WarMedia warMedia4 = this;
                            warMedia4.moviePlayer.release();
                            warMedia4.moviePlayer = null;
                            ClearVidView();
                            warMedia = warMedia4;
                        }
                    } catch (Exception e4) {
                        e = e4;
                    }
                    warMedia.bMoviePlayerPaused = false;
                }
            }
        }
    }

    public void PlayMovie(String str, float f) {
        PlayMovie(str, f, this.vidHolder);
    }

    public void PlayMovie(String str, float f, SurfaceHolder surfaceHolder) {
        StringBuilder append;
        String str2;
        this.customMovieHolder = surfaceHolder;
        this.bIsPlayingMovie = 1;
        this.currentMovieFilename = str;
        this.currentMovieOffset = 0;
        this.currentMovieLength = 0;
        this.currentMovieVolume = f;
        if (this.DoLog) {
            System.out.println("PlayMovie " + str);
        }
        final String str3 = this.baseDirectory + RemoteSettings.FORWARD_SLASH_STRING + str.replace("\\", RemoteSettings.FORWARD_SLASH_STRING) + (this.AddMovieExtension ? ".m4v" : "");
        if (this.DoLog) {
            System.out.println("PlayMovie newFile " + str3);
        }
        final AssetFileDescriptor assetFileDescriptor = null;
        if (!new File(str3).exists()) {
            try {
                if (this.AddMovieExtension) {
                    append = new StringBuilder().append(str.replace("\\", RemoteSettings.FORWARD_SLASH_STRING));
                    str2 = ".m4v.mp3";
                } else {
                    append = new StringBuilder().append(str.replace("\\", RemoteSettings.FORWARD_SLASH_STRING));
                    str2 = ".mp3";
                }
                String sb = append.append(str2).toString();
                System.out.println("Looking for  " + sb);
                assetFileDescriptor = getApplicationContext().getAssets().openFd(sb);
            } catch (Exception unused) {
            }
            if (assetFileDescriptor == null) {
                System.out.println("File not found " + str);
                this.bIsPlayingMovie = 0;
                return;
            }
        }
        try {
            MediaPlayer mediaPlayer = this.moviePlayer;
            if (mediaPlayer != null) {
                mediaPlayer.release();
            }
        } catch (Exception unused2) {
        }
        while (this.lastMovieStop > System.currentTimeMillis()) {
            mSleep(100L);
        }
        SetVidView();
        runOnUiThread(new Runnable() { // from class: com.wardrumstudios.utils.WarMedia.18
            @Override // java.lang.Runnable
            public void run() {
                try {
                    WarMedia.this.moviePlayer = new MediaPlayer();
                    if (assetFileDescriptor != null) {
                        WarMedia.this.moviePlayer.setDataSource(assetFileDescriptor.getFileDescriptor(), assetFileDescriptor.getStartOffset(), assetFileDescriptor.getLength());
                    } else {
                        WarMedia.this.moviePlayer.setDataSource(str3);
                    }
                    int i = 0;
                    while (!WarMedia.this.IsMovieViewActive()) {
                        System.out.println("Waiting for video surface PlayMovie");
                        if (i > 5) {
                            try {
                                WarMedia.this.moviePlayer.release();
                            } catch (IllegalStateException unused3) {
                            }
                            WarMedia.this.moviePlayer = null;
                            WarMedia.this.ClearVidView();
                        }
                        WarMedia.this.mSleep(100L);
                        i++;
                    }
                    WarMedia.this.moviePlayer.setDisplay(WarMedia.this.customMovieHolder);
                    WarMedia.this.moviePlayer.setOnPreparedListener(this);
                    WarMedia.this.moviePlayer.setOnErrorListener(this);
                    WarMedia.this.moviePlayer.setOnCompletionListener(this);
                    WarMedia.this.moviePlayer.prepareAsync();
                } catch (Exception unused4) {
                }
            }
        });
    }

    public void PlayMovieInFile(String str, float f, int i, int i2) {
        PlayMovieInFile(str, f, i, i2, this.vidHolder);
    }

    public void PlayMovieInFile(final String str, float f, int i, int i2, SurfaceHolder surfaceHolder) {
        SurfaceView surfaceView = this.customMovieSurface;
        if (surfaceView != null && surfaceView != this.movieWindowSurface) {
            this.customMovieSurface = null;
        }
        this.customMovieHolder = surfaceHolder;
        this.bIsPlayingMovie = 1;
        this.bMoviePlayerPaused = false;
        this.currentMovieFilename = str;
        this.currentMovieOffset = i;
        this.currentMovieLength = i2;
        this.currentMovieVolume = f;
        if (this.DoLog) {
            System.out.println("PlayMovieInFile " + str + " offset " + i + " length " + i2);
        }
        String sb = (str.startsWith(RemoteSettings.FORWARD_SLASH_STRING) ? new StringBuilder().append(Environment.getExternalStorageDirectory().getAbsolutePath()).append(str) : new StringBuilder().append(this.baseDirectory).append(RemoteSettings.FORWARD_SLASH_STRING).append(str.replace("\\", RemoteSettings.FORWARD_SLASH_STRING))).toString();
        if (new File(sb).exists()) {
            str = sb;
        }
        if (this.DoLog) {
            System.out.println("PlayMovieInFile " + str + " offset " + i + " length " + i2);
        }
        try {
            MediaPlayer mediaPlayer = this.moviePlayer;
            if (mediaPlayer != null) {
                mediaPlayer.release();
            }
        } catch (Exception unused) {
        }
        while (this.lastMovieStop > System.currentTimeMillis()) {
            mSleep(100L);
        }
        SetVidView();
        runOnUiThread(new Runnable() { // from class: com.wardrumstudios.utils.WarMedia.17
            @Override // java.lang.Runnable
            public void run() {
                try {
                    WarMedia.this.moviePlayer = new MediaPlayer();
                    WarMedia.this.moviePlayer.setDataSource(new RandomAccessFile(new File(str), "r").getFD(), WarMedia.this.currentMovieOffset, WarMedia.this.currentMovieLength);
                    int i3 = 0;
                    while (!WarMedia.this.IsMovieViewActive()) {
                        System.out.println("Waiting for video surface PlayMovieInFile");
                        WarMedia.this.mSleep(100L);
                        i3++;
                        if (i3 > 5) {
                            break;
                        }
                    }
                    if (i3 <= 5) {
                        WarMedia.this.moviePlayer.setDisplay(WarMedia.this.customMovieHolder);
                        WarMedia.this.moviePlayer.setOnPreparedListener(this);
                        WarMedia.this.moviePlayer.setOnErrorListener(this);
                        WarMedia.this.moviePlayer.setOnCompletionListener(this);
                        WarMedia.this.moviePlayer.prepareAsync();
                        return;
                    }
                    System.out.println("creation failed count " + i3);
                    WarMedia.this.ClearVidView();
                    WarMedia.this.moviePlayer.release();
                    WarMedia.this.moviePlayer = null;
                    WarMedia.this.bIsPlayingMovie = 0;
                } catch (Exception e) {
                    System.out.println("creation failed error  " + e.getMessage());
                    WarMedia.this.moviePlayer = null;
                    WarMedia.this.bIsPlayingMovie = 0;
                }
            }
        });
    }

    public void PlayMovieInWindow(final String str, int i, int i2, int i3, int i4, final float f, final int i5, final int i6, int i7, boolean z) {
        int i8;
        System.out.println("PlayMovieInWindow filename " + str + " movieWindowSurface " + this.movieWindowSurface + " inOffset " + i5 + " inLength " + i6);
        this.MovieIsSkippable = false;
        this.ForceSize = z;
        System.out.println("PlayMovieInWindow ForceSize " + this.ForceSize + " width " + i3 + " height " + i4);
        if (!this.checkForMaxDisplaySize || (i8 = this.baseDisplayHeight) >= (i4 * 2) / 3) {
            this.movieViewWidth = i3;
            this.movieViewHeight = i4;
        } else {
            this.movieViewWidth = this.baseDisplayWidth;
            this.movieViewHeight = i8;
        }
        this.movieViewX = i;
        this.movieViewY = i2;
        this.movieLooping = i7;
        this.bIsPlayingMovie = 1;
        runOnUiThread(new Runnable() { // from class: com.wardrumstudios.utils.WarMedia.16
            @Override // java.lang.Runnable
            public void run() {
                WarMedia warMedia = WarMedia.this;
                warMedia.movieView = warMedia.CreateMovieView(warMedia.movieViewX, WarMedia.this.movieViewY, WarMedia.this.movieViewWidth, WarMedia.this.movieViewHeight);
                WarMedia warMedia2 = WarMedia.this;
                warMedia2.movieWindowHolder = warMedia2.movieWindowSurface.getHolder();
                WarMedia.this.movieWindowHolder.addCallback(new SurfaceHolder.Callback() { // from class: com.wardrumstudios.utils.WarMedia.16.1
                    @Override // android.view.SurfaceHolder.Callback
                    public void surfaceChanged(SurfaceHolder surfaceHolder, int i9, int i10, int i11) {
                        System.out.println("movieView surfaceChanged width " + i10 + " height " + i11);
                        WarMedia.this.movieViewWidth = i10;
                        WarMedia.this.movieViewHeight = i11;
                    }

                    @Override // android.view.SurfaceHolder.Callback
                    public void surfaceCreated(SurfaceHolder surfaceHolder) {
                        WarMedia.this.movieViewIsActive = true;
                        if (WarMedia.this.movieViewCreated) {
                            System.out.println("movieViewCreated surfaceCreated");
                            return;
                        }
                        System.out.println("movieViewCreated surfaceCreated firsttime");
                        WarMedia.this.movieViewCreated = true;
                    }

                    @Override // android.view.SurfaceHolder.Callback
                    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
                        System.out.println("movieViewCreated surfaceDestroyed");
                        if (WarMedia.this.movieTextSurface != null) {
                            WarMedia.this.movieTextSurface.setVisibility(8);
                        }
                        WarMedia.this.movieViewIsActive = false;
                        WarMedia.this.movieIsStopping = false;
                        WarMedia.this.movieSubtitleText = "";
                        WarMedia.this.movieText = "";
                    }
                });
                System.out.println("movieWindowHolder setType");
                WarMedia.this.movieWindowHolder.setType(3);
                WarMedia.this.movieWindowSurface.setZOrderOnTop(true);
                WarMedia.this.movieWindowHolder.setFormat(-3);
                System.out.println("movieView (" + WarMedia.this.movieViewX + StringUtils.COMMA + WarMedia.this.movieViewY + ") (" + WarMedia.this.movieViewWidth + StringUtils.COMMA + WarMedia.this.movieViewHeight + ")");
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                layoutParams.gravity = 17;
                WarMedia warMedia3 = WarMedia.this;
                warMedia3.addContentView(warMedia3.movieView, layoutParams);
                WarMedia.this.movieTextSurface = new SurfaceView(WarMedia.this.activity);
                WarMedia warMedia4 = WarMedia.this;
                warMedia4.movieTextHolder = warMedia4.CreatTextSurface(warMedia4.movieTextSurface);
                WarMedia.this.movieTextHolder.setFormat(-3);
                WarMedia warMedia5 = WarMedia.this;
                warMedia5.addContentView(warMedia5.movieTextSurface, new WindowManager.LayoutParams(-1, -1));
                System.out.println("PlayMovieInFile for inwindow");
                WarMedia warMedia6 = WarMedia.this;
                warMedia6.customMovieSurface = warMedia6.movieWindowSurface;
                new Thread(new Runnable() { // from class: com.wardrumstudios.utils.WarMedia.16.2
                    @Override // java.lang.Runnable
                    public void run() {
                        for (int i9 = 0; !WarMedia.this.movieViewIsActive && i9 < 10; i9++) {
                            System.out.println("wait for create");
                            WarMedia.this.mSleep(1000L);
                        }
                        if (WarMedia.this.movieViewIsActive) {
                            if (i6 > 0) {
                                WarMedia.this.PlayMovieInFile(str, f, i5, i6, WarMedia.this.movieWindowHolder);
                            } else {
                                WarMedia.this.PlayMovie(str, f, WarMedia.this.movieWindowHolder);
                            }
                        }
                    }
                }).start();
            }
        });
    }

    public void RestoreCurrentLanguage() {
        String GetConfigSetting = GetConfigSetting("currentLanguage");
        if ("".equals(GetConfigSetting)) {
            return;
        }
        Locale locale = new Locale(GetConfigSetting, "en".equals(GetConfigSetting) ? this.DeviceCountry.equals("GB") ? "GB" : "US" : "");
        this.locale = locale;
        Locale.setDefault(locale);
    }

    public void SaveGameToCloud(int i, byte[] bArr, int i2) {
    }

    public void ScreenSetWakeLock(boolean z) {
        if (z) {
            this.myWakeLock.acquire();
        } else {
            this.myWakeLock.release();
        }
    }

    public void SendStatEvent(String str, String str2, String str3, boolean z) {
    }

    public void SendStatEvent(String str, boolean z) {
    }

    public void SendTimedStatEventEnd(String str) {
    }

    public boolean ServiceAppCommand(String str, String str2) {
        return false;
    }

    public boolean ServiceAppCommandInt(String str, int i) {
        return false;
    }

    public int ServiceAppCommandValue(String str, String str2) {
        return 0;
    }

    public void SetConfigSetting(String str, String str2) {
        SharedPreferences.Editor edit = getPreferences(0).edit();
        edit.putString(str, str2);
        edit.commit();
        if (this.DoLog) {
            System.out.println("SetConfigSetting " + str + " value " + str2);
        }
    }

    public void SetLocale(int i) {
        String str = "en";
        switch (i) {
            case 1:
                str = "fr";
                break;
            case 2:
                str = "de";
                break;
            case 3:
                str = "it";
                break;
            case 4:
                str = "es";
                break;
            case 5:
                str = "ja";
                break;
            case 6:
                str = "ko";
                break;
            case 7:
                str = "sv";
                break;
            case 8:
                str = "no";
                break;
        }
        if (this.DoLog) {
            System.out.println("SetLocale " + i + " lStr " + str);
        }
        String GetConfigSetting = GetConfigSetting("currentLanguage");
        if (this.DoLog) {
            System.out.println("SetLocale oldlang " + GetConfigSetting);
        }
        Locale locale = new Locale(str);
        this.locale = locale;
        Locale.setDefault(locale);
        SetConfigSetting("currentLanguage", str);
    }

    public void SetLocale(String str) {
        String str2;
        GetRealLocale();
        if (this.DoLog) {
            System.out.println("SetLocale " + str);
        }
        String GetConfigSetting = GetConfigSetting("currentLanguage");
        if (this.DoLog) {
            System.out.println("SetLocale oldlang " + GetConfigSetting);
        }
        if ("en".equals(str)) {
            str2 = "GB";
            if (!this.DeviceCountry.equals("GB")) {
                str2 = "US";
            }
        } else {
            str2 = "";
        }
        Locale locale = new Locale(str, str2);
        this.locale = locale;
        Locale.setDefault(locale);
        SetConfigSetting("currentLanguage", str);
    }

    void SetPaint(int i, int i2) {
        Paint paint = new Paint();
        this.mTextPaint = paint;
        paint.setAntiAlias(true);
        this.mTextPaint.setTextSize(i2);
        this.mTextPaint.setColor(i);
        this.mAscent = (int) this.mTextPaint.ascent();
        Paint paint2 = new Paint();
        this.tPaint = paint2;
        paint2.setColor(SupportMenu.CATEGORY_MASK);
        TextPaint textPaint = new TextPaint();
        this.textPaint = textPaint;
        textPaint.setColor(-1);
        this.textPaint.setTextSize(this.movieTextScale);
        TextPaint textPaint2 = new TextPaint();
        this.sTextPaint = textPaint2;
        textPaint2.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.sTextPaint.setTextSize(this.movieTextScale);
    }

    void SetVidView() {
        runOnUiThread(new Runnable() { // from class: com.wardrumstudios.utils.WarMedia.13
            @Override // java.lang.Runnable
            public void run() {
                SurfaceView surfaceView;
                if (WarMedia.this.customMovieSurface != null) {
                    surfaceView = WarMedia.this.customMovieSurface;
                } else if (WarMedia.this.noVidSurface) {
                    return;
                } else {
                    surfaceView = WarMedia.this.vidView;
                }
                surfaceView.setVisibility(0);
            }
        });
    }

    void SetVideoAspect(MediaPlayer mediaPlayer) {
        if (this.customMovieSurface == null) {
            try {
                int width = this.vidView.getWidth();
                int height = this.vidView.getHeight();
                float videoWidth = mediaPlayer.getVideoWidth();
                float videoHeight = mediaPlayer.getVideoHeight();
                if (videoWidth > 1.0f && videoHeight > 10.0f) {
                    float f = width;
                    float f2 = f / videoWidth;
                    float f3 = height;
                    float f4 = f3 / videoHeight;
                    float f5 = videoWidth / videoHeight;
                    SurfaceView surfaceView = this.customMovieSurface;
                    if (surfaceView == null) {
                        surfaceView = this.vidView;
                    }
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) surfaceView.getLayoutParams();
                    if (this.ForceSize) {
                        layoutParams.width = this.movieViewWidth;
                        layoutParams.height = this.movieViewHeight;
                    } else {
                        if (!this.KeepAspectRatio) {
                            layoutParams.width = width;
                        } else if (f2 > f4) {
                            layoutParams.width = (int) (f3 * f5);
                        } else {
                            layoutParams.width = width;
                            layoutParams.height = (int) (f / f5);
                        }
                        layoutParams.height = height;
                    }
                    layoutParams.gravity = 17;
                    SurfaceView surfaceView2 = this.customMovieSurface;
                    if (surfaceView2 == null) {
                        surfaceView2 = this.vidView;
                    }
                    surfaceView2.setLayoutParams(layoutParams);
                    return;
                }
                System.out.println("videosize error (" + videoWidth + StringUtils.COMMA + videoHeight + ")");
            } catch (IllegalStateException | Exception unused) {
            }
        }
    }

    void ShowDownloadNetworkError() {
        runOnUiThread(new AnonymousClass2(this));
    }

    void ShowExitDialog() {
        this.handler.post(new Runnable() { // from class: com.wardrumstudios.utils.WarMedia.11
            @Override // java.lang.Runnable
            public void run() {
                WarMedia.this.exitDialog = new AlertDialog.Builder(this).setTitle("Press back again to exit").setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.wardrumstudios.utils.WarMedia.11.1
                    @Override // android.content.DialogInterface.OnKeyListener
                    public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                        if (WarMedia.this.DoLog) {
                            System.out.println("ShowExitDialog onKey action " + keyEvent.getAction() + " IsShowingBackMessage " + WarMedia.this.IsShowingBackMessage + " KeyCode " + i);
                        }
                        if (WarMedia.this.IsShowingBackMessage == 2) {
                            WarMedia.this.IsShowingBackMessage = 0;
                            if (i != 4) {
                                dialogInterface.dismiss();
                                return true;
                            }
                            WarMedia.this.finish();
                        } else if (keyEvent.getAction() == 1) {
                            WarMedia.this.IsShowingBackMessage = 2;
                        }
                        return true;
                    }
                }).setCancelable(false).show();
                WarMedia.this.exitDialog.setCanceledOnTouchOutside(true);
            }
        });
    }

    void ShowGPDownloadError() {
        runOnUiThread(new AnonymousClass1(this));
    }

    public void ShowKeyboard(int i) {
        if (getResources().getConfiguration().hardKeyboardHidden == 1) {
            return;
        }
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService("input_method");
        if (i != 0) {
            inputMethodManager.toggleSoftInput(2, 0);
            this.IsShowingKeyboard = true;
            return;
        }
        View currentFocus = getCurrentFocus();
        if (currentFocus != null) {
            ((InputMethodManager) getSystemService("input_method")).hideSoftInputFromWindow(currentFocus.getWindowToken(), 0);
        }
        inputMethodManager.toggleSoftInput(0, 0);
        this.IsShowingKeyboard = false;
        System.out.println("hideSystemUI");
        hideSystemUI();
    }

    void ShowSDErrorDialog() {
        runOnUiThread(new Runnable() { // from class: com.wardrumstudios.utils.WarMedia.4
            @Override // java.lang.Runnable
            public void run() {
                WarMedia.this.exitDialog = new AlertDialog.Builder(this).setTitle("Cannot find storage. Is SDCard mounted?").setPositiveButton("Exit Game", new DialogInterface.OnClickListener() { // from class: com.wardrumstudios.utils.WarMedia.4.1
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i) {
                        WarMedia.this.finish();
                    }
                }).setCancelable(false).show();
                WarMedia.this.exitDialog.setCanceledOnTouchOutside(true);
            }
        });
    }

    public void StopMovie() {
        this.movieLooping = 0;
        this.MovieIsSkippable = false;
        this.MovieTextDisplayed = false;
        if (this.bIsPlayingMovie != 2) {
            if (this.DoLog) {
                System.out.println("MOVIE IS NOT PLAYING bIsPlayingMovie " + this.bIsPlayingMovie);
            }
            this.bIsPlayingMovie = 0;
        }
        try {
            MediaPlayer mediaPlayer = this.moviePlayer;
            if (mediaPlayer != null) {
                mediaPlayer.release();
                this.moviePlayer = null;
            }
        } catch (Exception unused) {
            this.moviePlayer = null;
        }
        this.lastMovieStop = System.currentTimeMillis() + 1000;
        ClearVidView();
        this.bIsPlayingMovie = 0;
        this.bMoviePlayerPaused = false;
    }

    public void VibratePhone(int i) {
        if (!this.FinalRelease) {
            System.out.println("VibratePhone " + i);
        }
        if (this.myVib == null) {
            this.myVib = (Vibrator) getSystemService("vibrator");
        }
        Vibrator vibrator = this.myVib;
        if (vibrator == null) {
            return;
        }
        vibrator.vibrate(i);
    }

    public void VibratePhoneEffect(int i) {
        if (!this.FinalRelease) {
            System.out.println("VibratePhoneEffect " + i);
        }
        if (this.myVib == null) {
            this.myVib = (Vibrator) getSystemService("vibrator");
        }
        Vibrator vibrator = this.myVib;
        if (vibrator == null) {
            return;
        }
        vibrator.vibrate(this.vibrateEffects[i], -1);
    }

    public int downloadFTPFile(String str, int i, boolean z) {
        return 0;
    }

    boolean expansionFilesDelivered() {
        XAPKFile[] xAPKFileArr;
        for (XAPKFile xAPKFile : this.xAPKS) {
            String expansionAPKFileName = Helpers.getExpansionAPKFileName(this, xAPKFile.mIsMain, xAPKFile.mFileVersion);
            if (!this.overrideExpansionName) {
                if (xAPKFile.mIsMain) {
                    this.expansionFileName = Helpers.generateSaveFileName(this, expansionAPKFileName);
                } else {
                    this.patchFileName = Helpers.generateSaveFileName(this, expansionAPKFileName);
                }
                System.out.println("download name " + (xAPKFile.mIsMain ? this.expansionFileName : this.patchFileName));
            }
            if (!Helpers.doesFileExist(this, expansionAPKFileName, xAPKFile.mFileSize, false)) {
                if (!this.FinalRelease) {
                    System.out.println("expansionFilesDelivered not exist " + expansionAPKFileName);
                }
                return false;
            }
        }
        return true;
    }

    @Override // android.app.Activity
    public void finish() {
        onDestroy();
        super.finish();
    }

    public String getLocalIpAddress() {
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                Enumeration<InetAddress> inetAddresses = networkInterfaces.nextElement().getInetAddresses();
                while (inetAddresses.hasMoreElements()) {
                    InetAddress nextElement = inetAddresses.nextElement();
                    if (!nextElement.isLoopbackAddress()) {
                        return nextElement.getHostAddress().toString();
                    }
                }
            }
            return null;
        } catch (SocketException e) {
            System.out.println("Got SocketException " + e);
            return null;
        }
    }

    public boolean isNetworkAvailable() {
        NetworkInfo activeNetworkInfo;
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService("connectivity");
        if (connectivityManager == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null) {
            return false;
        }
        return activeNetworkInfo.isConnected();
    }

    public boolean isTV() {
        return ((UiModeManager) getSystemService("uimode")).getCurrentModeType() == 4;
    }

    public boolean isWiFiAvailable() {
        if (this.mWifiManager == null) {
            this.mWifiManager = (WifiManager) getSystemService("wifi");
        }
        WifiManager wifiManager = this.mWifiManager;
        return wifiManager != null && wifiManager.isWifiEnabled();
    }

    protected boolean localHasGameData() {
        if (!this.FinalRelease) {
            System.out.println("localHasGameData");
        }
        if (this.UseFTPDownload) {
            new Thread(new Runnable() { // from class: com.wardrumstudios.utils.WarMedia.3
                @Override // java.lang.Runnable
                public void run() {
                    WarMedia.this.wardown.ShowEULA();
                }
            }).start();
            return false;
        } else if (this.xAPKS == null || expansionFilesDelivered()) {
            AfterDownloadFunction();
            return true;
        } else {
            Intent intent = new Intent(this, getClass());
            intent.setFlags(335544320);
            try {
                int startDownloadServiceIfRequired = DownloaderClientMarshaller.startDownloadServiceIfRequired(this, PendingIntent.getActivity(this, 0, intent, C.BUFFER_FLAG_FIRST_SAMPLE), WarDownloaderService.class);
                System.out.println("localHasGameData startDownloadServiceIfRequired startResult " + startDownloadServiceIfRequired);
                if (startDownloadServiceIfRequired == 0) {
                    if (expansionFilesDelivered()) {
                        AfterDownloadFunction();
                        return true;
                    }
                    ShowGPDownloadError();
                    return false;
                }
                if (!this.FinalRelease) {
                    System.out.println("localHasGameData != NO_DOWNLOAD_REQUIRED");
                }
                if (isNetworkAvailable()) {
                    initializeDownloadUI();
                    return false;
                }
                ShowDownloadNetworkError();
                return false;
            } catch (PackageManager.NameNotFoundException e) {
                e.printStackTrace();
                return true;
            }
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.SCREEN_OFF");
        intentFilter.addAction("android.intent.action.USER_PRESENT");
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        intentFilter.addAction("android.intent.action.SCREEN_ON");
        if (this.DoLog) {
            System.out.println("registerReceiver");
        }
        registerReceiver(this.mReceiver, intentFilter);
    }

    @Override // android.media.MediaPlayer.OnCompletionListener
    public void onCompletion(MediaPlayer mediaPlayer) {
        if (mediaPlayer.equals(this.moviePlayer)) {
            System.out.println("onCompletion completed moviePlayer");
            this.moviePlayer = null;
            try {
                mediaPlayer.release();
            } catch (IllegalStateException unused) {
            }
            ClearVidView();
            if (this.bIsPlayingMovie == 2) {
                this.bIsPlayingMovie = 0;
            }
            this.lastMovieStop = System.currentTimeMillis() + 1000;
            this.MovieTextDisplayed = false;
            this.movieLooping = 0;
        }
    }

    @Override // com.wardrumstudios.utils.WarGamepad, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        if (this.DoLog) {
            System.out.println("Listener - onConfigurationChanged orient " + configuration.orientation + " " + configuration);
        }
        if (this.IsShowingKeyboard && configuration.keyboard == 2 && 1 == configuration.hardKeyboardHidden) {
            this.IsShowingKeyboard = false;
            imeClosed();
        }
        super.onConfigurationChanged(configuration);
    }

    @Override // com.wardrumstudios.utils.WarGamepad, com.wardrumstudios.utils.WarBilling, com.wardrumstudios.utils.WarBase, com.nvidia.devtech.NvEventQueueActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        if (this.isNativeApp) {
            super.onCreate(bundle);
        }
        if (this.DoLog) {
            System.out.println("****WarMedia onCreate");
        }
        ClearSystemNotification();
        GetGameBaseDirectory();
        this.GetGLExtensions = this.UseFTPDownload;
        setRequestedOrientation(IsPortrait() ? 7 : 6);
        this.metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(this.metrics);
        System.out.println("Display Metrics Info:\n\tdensity:\t\t" + this.metrics.density + "\n\tdensityDPI:\t\t" + this.metrics.densityDpi + "\n\tscaledDensity:\t\t" + this.metrics.scaledDensity + "\n\twidthDPI:\t\t" + this.metrics.xdpi + "\n\theightDPI:\t\t" + this.metrics.ydpi + "\n\twidthPixels:\t\t" + this.metrics.widthPixels + "\n\theightPixels:\t\t" + this.metrics.heightPixels + "\n\tscreenlayout=" + getResources().getConfiguration().screenLayout);
        this.maxDisplayWidth = this.metrics.widthPixels;
        this.maxDisplayHeight = this.metrics.heightPixels;
        this.baseDisplayWidth = this.metrics.widthPixels;
        this.baseDisplayHeight = this.metrics.heightPixels;
        if (!IsPortrait() && this.metrics.widthPixels < this.metrics.heightPixels) {
            this.maxDisplayWidth = this.metrics.heightPixels;
            this.maxDisplayHeight = this.metrics.widthPixels;
            this.baseDisplayWidth = this.metrics.heightPixels;
            this.baseDisplayHeight = this.metrics.widthPixels;
        }
        if (Build.MODEL.startsWith("ADT")) {
            this.IsAndroidTV = true;
        }
        if (Build.MANUFACTURER.startsWith("NVIDIA") && Build.MODEL.startsWith("SHIELD Android TV")) {
            if (this.checkForMaxDisplaySize) {
                GetMaxDisplaySize();
            }
            this.isShieldTV = true;
        }
        NvUtil.getInstance().setActivity(this);
        NvUtil.getInstance().setAppLocalValue("STORAGE_ROOT", this.baseDirectory);
        NvUtil.getInstance().setAppLocalValue("STORAGE_ROOT_BASE", this.baseDirectoryRoot);
        this.hasTouchScreen = getResources().getConfiguration().touchscreen != 1;
        System.out.println("hastouchscreen " + this.hasTouchScreen + " touchscreen " + getResources().getConfiguration().touchscreen);
        this.activity = this;
        GetRealLocale();
        PowerManager.WakeLock newWakeLock = ((PowerManager) getSystemService("power")).newWakeLock(268435482, "WarEngine");
        this.myWakeLock = newWakeLock;
        newWakeLock.setReferenceCounted(false);
        this.isPhone = IsPhone();
        float f = this.metrics.widthPixels / this.metrics.xdpi;
        this.screenWidthInches = f;
        if (this.isPhone) {
            if (f < 3.5f) {
                this.screenWidthInches = 3.5f;
            }
            if (this.screenWidthInches > 6.0f) {
                this.screenWidthInches = 6.0f;
            }
        } else {
            if (f < 6.0f) {
                this.screenWidthInches = 6.0f;
            }
            if (this.screenWidthInches > 10.0f) {
                this.screenWidthInches = 10.0f;
            }
        }
        setVolumeControlStream(3);
        AudioManager audioManager = (AudioManager) getSystemService(MimeTypes.BASE_TYPE_AUDIO);
        this.audioManager = audioManager;
        this.audioMax = audioManager.getStreamMaxVolume(3);
        this.audioVolume = this.audioManager.getStreamVolume(3);
        System.out.println("availableProcessors " + Runtime.getRuntime().availableProcessors() + " cpu " + getNumberOfProcessors());
        GetMemoryInfo(true);
        if (this.UseSubtitles) {
            SetPaint(-16711936, 16);
        }
        this.localIp = getLocalIpAddress();
        if (!this.isNativeApp) {
            super.onCreate(bundle);
        }
        if (!CustomLoadFunction()) {
            localHasGameData();
        }
        NetworkChange();
        try {
            initTouchSense(this);
        } catch (UnsatisfiedLinkError unused) {
        }
    }

    @Override // com.wardrumstudios.utils.WarGamepad, com.wardrumstudios.utils.WarBilling, com.wardrumstudios.utils.WarBase, com.nvidia.devtech.NvEventQueueActivity, android.app.Activity
    public void onDestroy() {
        if (this.DoLog) {
            System.out.println("Listener - onDestroy isFinishing " + isFinishing());
        }
        Process.killProcess(Process.myPid());
        super.onDestroy();
        Process.killProcess(Process.myPid());
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.DoLog) {
            System.out.println("unregisterReceiver");
        }
        unregisterReceiver(this.mReceiver);
    }

    @Override // com.google.android.vending.expansion.downloader.IDownloaderClient
    public void onDownloadProgress(DownloadProgressInfo downloadProgressInfo) {
        this.mAverageSpeed.setText("" + Helpers.getSpeedString(downloadProgressInfo.mCurrentSpeed) + " KB/s");
        this.mTimeRemaining.setText("" + Helpers.getTimeRemaining(downloadProgressInfo.mTimeRemaining) + " seconds");
        downloadProgressInfo.mOverallTotal = downloadProgressInfo.mOverallTotal;
        this.mPB.setMax((int) (downloadProgressInfo.mOverallTotal >> 8));
        this.mPB.setProgress((int) (downloadProgressInfo.mOverallProgress >> 8));
        this.mProgressPercent.setText(Long.toString((downloadProgressInfo.mOverallProgress * 100) / downloadProgressInfo.mOverallTotal) + "%");
        this.mProgressFraction.setText(Helpers.getDownloadProgressString(downloadProgressInfo.mOverallProgress, downloadProgressInfo.mOverallTotal));
    }

    @Override // com.google.android.vending.expansion.downloader.IDownloaderClient
    public void onDownloadStateChanged(int i) {
        boolean z;
        boolean z2;
        boolean z3;
        setState(i);
        boolean z4 = true;
        switch (i) {
            case 1:
            case 2:
            case 3:
                z = true;
                z2 = false;
                z3 = false;
                break;
            case 4:
                z2 = false;
                z = false;
                z3 = false;
                break;
            case 5:
                if (expansionFilesDelivered()) {
                    validateXAPKZipFiles();
                    return;
                }
                return;
            case 6:
            case 10:
            case 11:
            case 13:
            case 17:
            default:
                z = true;
                z3 = true;
                z2 = false;
                break;
            case 7:
            case 12:
            case 14:
            case 15:
            case 16:
            case 18:
            case 19:
                z3 = true;
                z2 = false;
                z = false;
                break;
            case 8:
            case 9:
                z2 = true;
                z3 = true;
                z4 = false;
                z = false;
                break;
        }
        int i2 = z4 ? 0 : 8;
        if (this.mDashboard.getVisibility() != i2) {
            this.mDashboard.setVisibility(i2);
        }
        int i3 = z2 ? 0 : 8;
        if (this.mCellMessage.getVisibility() != i3) {
            this.mCellMessage.setVisibility(i3);
        }
        this.mPB.setIndeterminate(z);
        setButtonPausedState(z3);
    }

    @Override // android.media.MediaPlayer.OnErrorListener
    public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
        System.out.println("onError what " + i + " exra " + i2);
        return true;
    }

    @Override // com.wardrumstudios.utils.WarGamepad, com.nvidia.devtech.NvEventQueueActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.AllowLongPressForExit && i == 4 && !keyEvent.isAltPressed() && keyEvent.isLongPress()) {
            this.IsShowingBackMessage = 1;
            if (this.DoLog) {
                System.out.println("ShowExitDialog KeyDown");
            }
            ShowExitDialog();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onLowMemory() {
        lowMemoryEvent();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.wardrumstudios.utils.WarBase, com.nvidia.devtech.NvEventQueueActivity, android.app.Activity
    public void onPause() {
        if (this.DoLog) {
            System.out.println("Listener -  onPause");
        }
        if (this.cachedSurfaceHolder != null) {
            this.cachedSurfaceHolder.setKeepScreenOn(false);
        }
        for (int i = 0; i < MAX_GAME_PADS; i++) {
            if (this.GamePads[i].active && this.GamePads[i].mogaController != null) {
                this.GamePads[i].mogaController.onPause();
            }
        }
        super.onPause();
        PauseMoviePlayer(true);
        GetMemoryInfo(true);
        this.IsScreenPaused = true;
        this.paused = true;
    }

    @Override // android.media.MediaPlayer.OnPreparedListener
    public void onPrepared(MediaPlayer mediaPlayer) {
        if (mediaPlayer.equals(this.moviePlayer)) {
            if (this.bIsPlayingMovie != 1) {
                System.out.println("trying to start a requested to stop movie");
                try {
                    mediaPlayer.release();
                } catch (IllegalStateException unused) {
                }
                this.moviePlayer = null;
                this.bIsPlayingMovie = 0;
                ClearVidView();
                return;
            }
            MediaPlayer mediaPlayer2 = this.moviePlayer;
            float f = this.currentMovieVolume;
            mediaPlayer2.setVolume(f, f);
            if (this.movieLooping != 0) {
                this.moviePlayer.setLooping(true);
            }
            if (this.currentMovieMS > 0) {
                mediaPlayer.setOnSeekCompleteListener(this);
                mediaPlayer.seekTo(this.currentMovieMS);
            } else {
                SetVideoAspect(mediaPlayer);
                try {
                    mediaPlayer.start();
                    this.bIsPlayingMovie = 2;
                } catch (IllegalStateException e) {
                    System.out.println("onPrepared IllegalStateException " + e.getMessage());
                    this.moviePlayer = null;
                    this.bIsPlayingMovie = 0;
                    ClearVidView();
                }
            }
            this.currentMovieMS = 0;
        }
    }

    @Override // android.app.Activity
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        System.out.println("onRequestPermissionsResult");
        if (i != REQUEST_READ_EXTERNAL_STORAGE) {
            return;
        }
        if (iArr.length <= 0 || iArr[0] != 0) {
            System.out.println("Exiting App");
            finish();
            return;
        }
        this.waitForPermissions = false;
        localHasGameData();
    }

    @Override // com.nvidia.devtech.NvEventQueueActivity, android.app.Activity
    public void onRestart() {
        if (this.DoLog) {
            System.out.println("Listener - onRestart");
        }
        super.onRestart();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.wardrumstudios.utils.WarBase, com.nvidia.devtech.NvEventQueueActivity, android.app.Activity
    public void onResume() {
        if (this.DoLog) {
            System.out.println("WarMedia**** onResume viewIsActive " + this.viewIsActive + " isUserPresent " + this.isUserPresent);
        }
        super.onResume();
        for (int i = 0; i < MAX_GAME_PADS; i++) {
            if (this.GamePads[i].active && this.GamePads[i].mogaController != null) {
                this.GamePads[i].mogaController.onResume();
            }
        }
        while (!isExternalStorageReadable()) {
            System.out.println("Resuming when Media is not mounted, waiting for sdcard mount");
            mSleep(100L);
        }
        if (this.isUserPresent) {
            if (this.viewIsActive && this.ResumeEventDone) {
                resumeEvent();
                if (this.cachedSurfaceHolder != null) {
                    this.cachedSurfaceHolder.setKeepScreenOn(true);
                }
            }
            this.IsScreenPaused = false;
            PauseMoviePlayer(false);
        }
        this.paused = false;
    }

    @Override // android.media.MediaPlayer.OnSeekCompleteListener
    public void onSeekComplete(MediaPlayer mediaPlayer) {
        if (this.soundLog) {
            System.out.println("onSeekComplete");
        }
        if (mediaPlayer == this.moviePlayer) {
            SetVideoAspect(mediaPlayer);
            mediaPlayer.start();
            mediaPlayer.setOnSeekCompleteListener(null);
            this.bIsPlayingMovie = 2;
        }
    }

    @Override // com.google.android.vending.expansion.downloader.IDownloaderClient
    public void onServiceConnected(Messenger messenger) {
        IDownloaderService CreateProxy = DownloaderServiceMarshaller.CreateProxy(messenger);
        this.mRemoteService = CreateProxy;
        CreateProxy.onClientUpdated(this.mDownloaderClientStub.getMessenger());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.wardrumstudios.utils.WarBase, android.app.Activity
    public void onStart() {
        IStub iStub = this.mDownloaderClientStub;
        if (iStub != null) {
            iStub.connect(this);
        }
        super.onStart();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.wardrumstudios.utils.WarBase, com.nvidia.devtech.NvEventQueueActivity, android.app.Activity
    public void onStop() {
        if (this.DoLog) {
            System.out.println("Listener - onStop");
        }
        IStub iStub = this.mDownloaderClientStub;
        if (iStub != null) {
            iStub.disconnect(this);
        }
        super.onStop();
    }

    @Override // com.wardrumstudios.utils.WarGamepad, com.nvidia.devtech.NvEventQueueActivity, android.app.Activity
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.MovieIsSkippable) {
            StopMovie();
        }
        if (this.DisplayMovieTextOnTap && this.movieTextViewIsActive) {
            this.movieTextDisplayNow = true;
            DrawMovieText();
        }
        if (this.IsShowingBackMessage == 2) {
            if (this.DoLog) {
                System.out.println("onTouchEvent exitDialog " + this.exitDialog);
            }
            AlertDialog alertDialog = this.exitDialog;
            if (alertDialog != null) {
                alertDialog.dismiss();
            }
            this.IsShowingBackMessage = 0;
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        if (this.ResumeEventDone && this.isUserPresent && this.viewIsActive && !this.IsScreenPaused && !this.paused) {
            boolean z2 = this.GameIsFocused;
            if (z2 && !z) {
                pauseEvent();
            } else if (!z2 && z) {
                resumeEvent();
            }
            this.GameIsFocused = z;
        }
        super.onWindowFocusChanged(z);
        if (z) {
            hideSystemUI();
        }
    }

    public native void setTouchSenseFilepath(String str);

    void validateXAPKZipFiles() {
        System.out.println("validateXAPKZipFiles IsInValidation " + this.IsInValidation);
        if (this.IsInValidation) {
            return;
        }
        this.IsInValidation = true;
        new AsyncTask<Object, DownloadProgressInfo, Boolean>() { // from class: com.wardrumstudios.utils.WarMedia.19
            /* JADX INFO: Access modifiers changed from: protected */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.AsyncTask
            public Boolean doInBackground(Object... objArr) {
                XAPKFile[] xAPKFileArr;
                for (XAPKFile xAPKFile : WarMedia.this.xAPKS) {
                    String expansionAPKFileName = Helpers.getExpansionAPKFileName(WarMedia.this, xAPKFile.mIsMain, xAPKFile.mFileVersion);
                    System.out.println("Verify " + expansionAPKFileName);
                    if (!Helpers.doesFileExist(WarMedia.this, expansionAPKFileName, xAPKFile.mFileSize, false)) {
                        return false;
                    }
                    if (xAPKFile.mIsMain) {
                        WarMedia warMedia = WarMedia.this;
                        warMedia.expansionFileName = Helpers.generateSaveFileName(warMedia, expansionAPKFileName);
                    } else {
                        WarMedia warMedia2 = WarMedia.this;
                        warMedia2.patchFileName = Helpers.generateSaveFileName(warMedia2, expansionAPKFileName);
                    }
                }
                return true;
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // android.os.AsyncTask
            public void onPostExecute(Boolean bool) {
                WarMedia warMedia;
                View view;
                System.out.println("onPostExecute result " + bool);
                if (bool.booleanValue()) {
                    WarMedia.this.mDashboard.setVisibility(8);
                    WarMedia.this.mCellMessage.setVisibility(8);
                    WarMedia.this.downloadView.setVisibility(8);
                    if (WarMedia.this.view.getParent() != null) {
                        warMedia = WarMedia.this;
                        view = (View) warMedia.view.getParent();
                    } else {
                        warMedia = WarMedia.this;
                        view = warMedia.view;
                    }
                    warMedia.setContentView(view);
                    WarMedia.this.AfterDownloadFunction();
                } else {
                    WarMedia.this.mDashboard.setVisibility(0);
                    WarMedia.this.mCellMessage.setVisibility(8);
                    WarMedia.this.mStatusText.setText(Helpers.GetResourceIdentifier(WarMedia.this.getApplicationContext(), "text_validation_failed", TypedValues.Custom.S_STRING));
                    WarMedia.this.mPauseButton.setOnClickListener(new View.OnClickListener() { // from class: com.wardrumstudios.utils.WarMedia.19.2
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view2) {
                            WarMedia.this.finish();
                        }
                    });
                    WarMedia.this.mPauseButton.setText(17039360);
                }
                super.onPostExecute((AnonymousClass19) bool);
            }

            @Override // android.os.AsyncTask
            protected void onPreExecute() {
                WarMedia.this.mDashboard.setVisibility(0);
                WarMedia.this.mCellMessage.setVisibility(8);
                WarMedia.this.mStatusText.setText(Helpers.GetResourceIdentifier(WarMedia.this.getApplicationContext(), "text_verifying_download", TypedValues.Custom.S_STRING));
                WarMedia.this.mPauseButton.setOnClickListener(new View.OnClickListener() { // from class: com.wardrumstudios.utils.WarMedia.19.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        WarMedia.this.mCancelValidation = true;
                    }
                });
                WarMedia.this.mPauseButton.setText(Helpers.GetResourceIdentifier(WarMedia.this.getApplicationContext(), "text_button_cancel_verify", TypedValues.Custom.S_STRING));
                super.onPreExecute();
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // android.os.AsyncTask
            public void onProgressUpdate(DownloadProgressInfo... downloadProgressInfoArr) {
                WarMedia.this.onDownloadProgress(downloadProgressInfoArr[0]);
                super.onProgressUpdate((Object[]) downloadProgressInfoArr);
            }
        }.execute(new Object());
    }
}
