package ru.mrlargha.commonui.elements.authorization.presentation.screen;

import android.app.Activity;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.media3.common.MimeTypes;
import com.arizona.game.BuildConfig;
import com.google.common.net.HttpHeaders;
import java.io.File;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import ru.mrlargha.commonui.R;
import ru.mrlargha.commonui.core.SAMPUIElement;
import ru.mrlargha.commonui.core.UIElementAbstractSpawner;
import ru.mrlargha.commonui.databinding.BackgroundVideoBinding;
import ru.mrlargha.commonui.elements.authorization.domain.controller.RegistrationInterfaceType;
import ru.mrlargha.commonui.elements.authorization.domain.controller.RegistrationServerResponse;
import ru.mrlargha.commonui.elements.authorization.domain.controller.RegistrationVideoModeType;
import ru.mrlargha.commonui.elements.authorization.presentation.InterfaceController;
import ru.mrlargha.commonui.elements.authorization.presentation.InterfaceManager;
/* compiled from: RegistrationVideoBackground.kt */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0013\u0018\u00002\u00020\u00012\u00020\u0002:\u0001-B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0013H\u0016J\u000e\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u000eJ\u0018\u0010\u0019\u001a\u00020\u00152\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0006H\u0016J\u0010\u0010\u001d\u001a\u00020\u00152\u0006\u0010\u001e\u001a\u00020\u001bH\u0002J\u0010\u0010\u001f\u001a\u00020\u00152\u0006\u0010 \u001a\u00020\u001bH\u0002J\u0010\u0010!\u001a\u00020\u00152\u0006\u0010\"\u001a\u00020\u001bH\u0002J\u0010\u0010#\u001a\u00020\u00152\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J\b\u0010$\u001a\u00020\u0015H\u0002J\u0010\u0010%\u001a\u00020\u00152\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J\u0018\u0010&\u001a\u00020\u00152\u0006\u0010'\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J\u0010\u0010(\u001a\u00020\u00152\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J\u0010\u0010)\u001a\u00020\u00152\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J\n\u0010*\u001a\u0004\u0018\u00010\u001bH\u0002J\u0006\u0010+\u001a\u00020\fJ\u0010\u0010,\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0013H\u0016R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006."}, d2 = {"Lru/mrlargha/commonui/elements/authorization/presentation/screen/RegistrationVideoBackground;", "Lru/mrlargha/commonui/core/SAMPUIElement;", "Lru/mrlargha/commonui/elements/authorization/presentation/InterfaceController;", "targetActivity", "Landroid/app/Activity;", "backendID", "", "<init>", "(Landroid/app/Activity;I)V", "videoBackground", "Landroidx/constraintlayout/widget/ConstraintLayout;", "videoBackgroundBinding", "Lru/mrlargha/commonui/databinding/BackgroundVideoBinding;", "lastChoseVideo", "Lru/mrlargha/commonui/elements/authorization/domain/controller/RegistrationVideoModeType;", "sharedPref", "Landroid/content/SharedPreferences;", "sharedPreferencesUI", "isVisible", "", "setVisibility", "", "visible", "selectVideoMode", "videoMode", "onBackendMessage", "data", "", "subId", "preload", "flavorType", "gameFlavorType", "type", "setAwaitText", "text", "pushSelectSpawnData", "showAuthInterface", "pushRecoveryResponse", "pushAuthServerInfo", "actionId", "pushRegistrationAccountResponse", "pushPedSettingsResponse", "getSAMPPath", "getMainBinding", "setVisible", "Spawner", "CommonUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class RegistrationVideoBackground extends SAMPUIElement implements InterfaceController {
    private boolean isVisible;
    private RegistrationVideoModeType lastChoseVideo;
    private final SharedPreferences sharedPref;
    private final SharedPreferences sharedPreferencesUI;
    private final ConstraintLayout videoBackground;
    private final BackgroundVideoBinding videoBackgroundBinding;

    /* compiled from: RegistrationVideoBackground.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[RegistrationVideoModeType.values().length];
            try {
                iArr[RegistrationVideoModeType.VIDEO_AUTHORIZATION.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[RegistrationVideoModeType.VIDEO_REGISTRATION.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[RegistrationVideoModeType.VIDEO_HIDE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[RegistrationVideoModeType.STOP_VIDEO.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @Override // ru.mrlargha.commonui.elements.authorization.presentation.InterfaceController
    public void setVisible(boolean z) {
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RegistrationVideoBackground(Activity targetActivity, int i) {
        super(targetActivity, i);
        Intrinsics.checkNotNullParameter(targetActivity, "targetActivity");
        View inflate = targetActivity.getLayoutInflater().inflate(R.layout.background_video, (ViewGroup) null);
        Intrinsics.checkNotNull(inflate, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout");
        ConstraintLayout constraintLayout = (ConstraintLayout) inflate;
        this.videoBackground = constraintLayout;
        BackgroundVideoBinding bind = BackgroundVideoBinding.bind(constraintLayout);
        Intrinsics.checkNotNullExpressionValue(bind, "bind(...)");
        this.videoBackgroundBinding = bind;
        this.lastChoseVideo = RegistrationVideoModeType.VIDEO_HIDE;
        SharedPreferences sharedPreferences = targetActivity.getSharedPreferences("flavorType", 0);
        Intrinsics.checkNotNullExpressionValue(sharedPreferences, "getSharedPreferences(...)");
        this.sharedPref = sharedPreferences;
        SharedPreferences sharedPreferences2 = targetActivity.getSharedPreferences("UI_ELEMENTS_SP", 0);
        Intrinsics.checkNotNullExpressionValue(sharedPreferences2, "getSharedPreferences(...)");
        this.sharedPreferencesUI = sharedPreferences2;
        InterfaceManager.Companion.putInterface(RegistrationInterfaceType.VIDEO_BACKGROUND.getId(), this);
        addViewToConstraintLayout(constraintLayout, -1, -1);
        bind.exitButton.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.authorization.presentation.screen.RegistrationVideoBackground$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RegistrationVideoBackground._init_$lambda$0(RegistrationVideoBackground.this, view);
            }
        });
    }

    @Override // ru.mrlargha.commonui.core.SAMPUIElement
    public void setVisibility(boolean z) {
        super.setVisibility(z);
        this.isVisible = z;
        if (z) {
            return;
        }
        InterfaceController orCreateInterface = InterfaceManager.Companion.getOrCreateInterface(RegistrationInterfaceType.AUTH_INIT.getId(), getTargetActivity(), getBackendID());
        Intrinsics.checkNotNull(orCreateInterface, "null cannot be cast to non-null type ru.mrlargha.commonui.elements.authorization.presentation.screen.Authorization");
        ((Authorization) orCreateInterface).hideLoader();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$0(RegistrationVideoBackground registrationVideoBackground, View view) {
        SAMPUIElement.notifyClick$default(registrationVideoBackground, -1, -1, null, 4, null);
    }

    public final void selectVideoMode(RegistrationVideoModeType videoMode) {
        Intrinsics.checkNotNullParameter(videoMode, "videoMode");
        if (this.lastChoseVideo == videoMode && this.videoBackgroundBinding.videoBg.isPlaying()) {
            return;
        }
        if (getTargetActivity().findViewById(R.id.video) == null) {
            Log.e(MimeTypes.BASE_TYPE_VIDEO, "selectVideoMode: is haven't");
        } else {
            Log.e(MimeTypes.BASE_TYPE_VIDEO, "selectVideoMode: is has " + this.isVisible);
            if (!this.isVisible) {
                setVisibility(true);
                ConstraintLayout video = this.videoBackgroundBinding.video;
                Intrinsics.checkNotNullExpressionValue(video, "video");
                video.setVisibility(0);
            }
        }
        ConstraintLayout root = this.videoBackgroundBinding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        root.setVisibility(0);
        int i = WhenMappings.$EnumSwitchMapping$0[videoMode.ordinal()];
        if (i == 1) {
            this.lastChoseVideo = videoMode;
            MediaController mediaController = new MediaController(getTargetActivity());
            mediaController.setVisibility(8);
            this.videoBackground.setVisibility(0);
            this.videoBackgroundBinding.video.setVisibility(0);
            this.videoBackgroundBinding.videoBg.setVisibility(0);
            VideoView videoView = this.videoBackgroundBinding.videoBg;
            try {
                videoView.setMediaController(mediaController);
                File file = new File(Environment.getExternalStorageDirectory(), getSAMPPath() + "auth_video.mp4");
                if (file.exists()) {
                    Uri parse = Uri.parse(file.getPath());
                    Intrinsics.checkNotNullExpressionValue(parse, "parse(...)");
                    this.videoBackgroundBinding.videoBg.setVideoURI(parse);
                    this.videoBackgroundBinding.videoBg.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: ru.mrlargha.commonui.elements.authorization.presentation.screen.RegistrationVideoBackground$$ExternalSyntheticLambda1
                        @Override // android.media.MediaPlayer.OnErrorListener
                        public final boolean onError(MediaPlayer mediaPlayer, int i2, int i3) {
                            boolean selectVideoMode$lambda$3$lambda$1;
                            selectVideoMode$lambda$3$lambda$1 = RegistrationVideoBackground.selectVideoMode$lambda$3$lambda$1(RegistrationVideoBackground.this, mediaPlayer, i2, i3);
                            return selectVideoMode$lambda$3$lambda$1;
                        }
                    });
                    this.videoBackgroundBinding.videoBg.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: ru.mrlargha.commonui.elements.authorization.presentation.screen.RegistrationVideoBackground$$ExternalSyntheticLambda2
                        @Override // android.media.MediaPlayer.OnPreparedListener
                        public final void onPrepared(MediaPlayer mediaPlayer) {
                            RegistrationVideoBackground.selectVideoMode$lambda$3$lambda$2(mediaPlayer);
                        }
                    });
                } else {
                    Toast.makeText(getTargetActivity(), "Видео файл не найден в памяти устройства. Сбросьте игру!", 1).show();
                }
            } catch (Exception e) {
                Toast.makeText(getTargetActivity(), "Ошибка воспроизведения видео. Сбросьте игру!", 1).show();
                e.printStackTrace();
                Log.e("videoBackgroundBinding", "Can't start video");
            }
            Intrinsics.checkNotNull(videoView);
        } else if (i != 2) {
            if (i != 3) {
                if (i != 4) {
                    throw new NoWhenBranchMatchedException();
                }
                this.videoBackgroundBinding.videoBg.stopPlayback();
                this.videoBackgroundBinding.videoBg.setVisibility(8);
                return;
            }
            this.videoBackgroundBinding.videoBg.stopPlayback();
            this.videoBackground.setVisibility(8);
            this.videoBackgroundBinding.video.setVisibility(8);
            this.videoBackgroundBinding.videoBg.setVisibility(8);
        } else {
            this.lastChoseVideo = videoMode;
            MediaController mediaController2 = new MediaController(getTargetActivity());
            mediaController2.setVisibility(8);
            this.videoBackground.setVisibility(0);
            this.videoBackgroundBinding.video.setVisibility(0);
            this.videoBackgroundBinding.videoBg.setVisibility(0);
            try {
                this.videoBackgroundBinding.videoBg.setMediaController(mediaController2);
                File file2 = new File(Environment.getExternalStorageDirectory(), getSAMPPath() + "registration_video.mp4");
                if (file2.exists()) {
                    Uri parse2 = Uri.parse(file2.getPath());
                    Intrinsics.checkNotNullExpressionValue(parse2, "parse(...)");
                    this.videoBackgroundBinding.videoBg.setVideoURI(parse2);
                    this.videoBackgroundBinding.videoBg.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: ru.mrlargha.commonui.elements.authorization.presentation.screen.RegistrationVideoBackground$$ExternalSyntheticLambda3
                        @Override // android.media.MediaPlayer.OnPreparedListener
                        public final void onPrepared(MediaPlayer mediaPlayer) {
                            RegistrationVideoBackground.selectVideoMode$lambda$4(mediaPlayer);
                        }
                    });
                } else {
                    Toast.makeText(getTargetActivity(), "Видео файл не найден в памяти устройства. Сбросьте игру!", 1).show();
                }
                Unit unit = Unit.INSTANCE;
            } catch (Exception e2) {
                Toast.makeText(getTargetActivity(), "Ошибка воспроизведения видео. Сбросьте игру!", 1).show();
                e2.printStackTrace();
                Integer.valueOf(Log.e("videoBackgroundBinding", "Can't start video step 2"));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean selectVideoMode$lambda$3$lambda$1(RegistrationVideoBackground registrationVideoBackground, MediaPlayer mediaPlayer, int i, int i2) {
        Log.e("VideoPlayer", "Ошибка при воспроизведении видео: what=" + i + ", extra=" + i2);
        Toast.makeText(registrationVideoBackground.getTargetActivity(), "Ошибка загрузки видео", 0).show();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void selectVideoMode$lambda$3$lambda$2(MediaPlayer mediaPlayer) {
        mediaPlayer.setVolume(0.2f, 0.2f);
        mediaPlayer.setLooping(true);
        mediaPlayer.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void selectVideoMode$lambda$4(MediaPlayer mediaPlayer) {
        mediaPlayer.setVolume(0.2f, 0.2f);
        mediaPlayer.setLooping(true);
        mediaPlayer.start();
    }

    @Override // ru.mrlargha.commonui.core.SAMPUIElement
    public void onBackendMessage(String data, int i) {
        Intrinsics.checkNotNullParameter(data, "data");
        if (i == RegistrationServerResponse.AUTH_INIT.getId()) {
            this.sharedPreferencesUI.edit().putString("SERVER_ID", data).apply();
            showAuthInterface();
        } else if (i == RegistrationServerResponse.AUTH_SERVER_ID_INFO.getId()) {
            pushAuthServerInfo(i, data);
        } else if (i == RegistrationServerResponse.AUTH_SERVER_ONLINE_INFO.getId()) {
            pushAuthServerInfo(i, data);
        } else if (i == RegistrationServerResponse.AUTH_SERVER_SUCCESS.getId()) {
            pushAuthServerInfo(i, data);
        } else if (i == RegistrationServerResponse.REGISTRATION_ACCOUNT_RESPONSE.getId()) {
            pushRegistrationAccountResponse(data);
        } else if (i == RegistrationServerResponse.REGISTRATION_PED_SETTINGS_RESPONSE.getId()) {
            pushPedSettingsResponse(data);
        } else if (i == RegistrationServerResponse.RECOVERY_HANDLER_RESPONSE.getId()) {
            pushRecoveryResponse(data);
        } else if (i == RegistrationServerResponse.SELECT_SPAWN_DATA.getId()) {
            pushSelectSpawnData(data);
        } else if (i == RegistrationServerResponse.LOCAL_CHANGE_VIDEO.getId()) {
            preload(data);
        } else if (i == RegistrationServerResponse.AUTH_AWAIT_TEXT.getId()) {
            setAwaitText(data);
        }
    }

    private final void preload(String str) {
        gameFlavorType(str);
        selectVideoMode(RegistrationVideoModeType.VIDEO_AUTHORIZATION);
        BackgroundVideoBinding backgroundVideoBinding = this.videoBackgroundBinding;
        backgroundVideoBinding.loaderBar.setVisibility(0);
        backgroundVideoBinding.loadingText.setVisibility(0);
        backgroundVideoBinding.exitButton.setVisibility(0);
    }

    private final void gameFlavorType(String str) {
        SharedPreferences.Editor edit = this.sharedPref.edit();
        if (Intrinsics.areEqual(str, BuildConfig.FLAVOR)) {
            edit.putBoolean("isArizonaType", true);
        } else if (Intrinsics.areEqual(str, "rodina")) {
            edit.putBoolean("isArizonaType", false);
        }
        edit.apply();
    }

    private final void setAwaitText(String str) {
        this.videoBackgroundBinding.loadingText.setText(str);
    }

    private final void pushSelectSpawnData(String str) {
        InterfaceController orCreateInterface = InterfaceManager.Companion.getOrCreateInterface(RegistrationInterfaceType.SPAWN_SELECTOR.getId(), getTargetActivity(), getBackendID());
        Intrinsics.checkNotNull(orCreateInterface, "null cannot be cast to non-null type ru.mrlargha.commonui.elements.authorization.presentation.screen.SpawnMenu");
        ((SpawnMenu) orCreateInterface).addSpawns(str);
    }

    private final void showAuthInterface() {
        BackgroundVideoBinding backgroundVideoBinding = this.videoBackgroundBinding;
        backgroundVideoBinding.loaderBar.setVisibility(8);
        backgroundVideoBinding.loadingText.setVisibility(8);
        backgroundVideoBinding.exitButton.setVisibility(8);
        selectVideoMode(RegistrationVideoModeType.VIDEO_AUTHORIZATION);
        InterfaceController orCreateInterface = InterfaceManager.Companion.getOrCreateInterface(RegistrationInterfaceType.AUTH_INIT.getId(), getTargetActivity(), getBackendID());
        Intrinsics.checkNotNull(orCreateInterface, "null cannot be cast to non-null type ru.mrlargha.commonui.elements.authorization.presentation.screen.Authorization");
        ((Authorization) orCreateInterface).setVisible(true);
        InterfaceManager.Companion.getOrCreateInterface(RegistrationInterfaceType.AUTHORIZATION_NEWS.getId(), getTargetActivity(), getBackendID()).setVisible(true);
    }

    private final void pushRecoveryResponse(String str) {
        InterfaceController orCreateInterface = InterfaceManager.Companion.getOrCreateInterface(RegistrationInterfaceType.RECOVERY_HANDLER.getId(), getTargetActivity(), getBackendID());
        Intrinsics.checkNotNull(orCreateInterface, "null cannot be cast to non-null type ru.mrlargha.commonui.elements.authorization.presentation.screen.RecoveryHandler");
        ((RecoveryHandler) orCreateInterface).onServerRecoveryResponse(str);
    }

    private final void pushAuthServerInfo(int i, String str) {
        InterfaceController orCreateInterface = InterfaceManager.Companion.getOrCreateInterface(RegistrationInterfaceType.AUTH_INIT.getId(), getTargetActivity(), getBackendID());
        Intrinsics.checkNotNull(orCreateInterface, "null cannot be cast to non-null type ru.mrlargha.commonui.elements.authorization.presentation.screen.Authorization");
        ((Authorization) orCreateInterface).onServerMessage(i, str);
    }

    private final void pushRegistrationAccountResponse(String str) {
        InterfaceController orCreateInterface = InterfaceManager.Companion.getOrCreateInterface(RegistrationInterfaceType.REGISTRATION_INIT.getId(), getTargetActivity(), getBackendID());
        Intrinsics.checkNotNull(orCreateInterface, "null cannot be cast to non-null type ru.mrlargha.commonui.elements.authorization.presentation.screen.RegistrationAccount");
        RegistrationAccount registrationAccount = (RegistrationAccount) orCreateInterface;
        InterfaceManager.Companion.getOrCreateInterface(RegistrationInterfaceType.AUTHORIZATION_NEWS.getId(), getTargetActivity(), getBackendID()).setVisible(false);
        registrationAccount.setVisible(true);
        registrationAccount.onServerAccountResponse(str);
    }

    private final void pushPedSettingsResponse(String str) {
        InterfaceController orCreateInterface = InterfaceManager.Companion.getOrCreateInterface(RegistrationInterfaceType.REGISTRATION_PED_SETTINGS.getId(), getTargetActivity(), getBackendID());
        Intrinsics.checkNotNull(orCreateInterface, "null cannot be cast to non-null type ru.mrlargha.commonui.elements.authorization.presentation.screen.RegistrationPedSettings");
        ((RegistrationPedSettings) orCreateInterface).onServerPedSettingsResponse(str);
    }

    private final String getSAMPPath() {
        String str;
        PackageManager packageManager = getTargetActivity().getPackageManager();
        Intrinsics.checkNotNullExpressionValue(packageManager, "getPackageManager(...)");
        String packageName = getTargetActivity().getPackageName();
        Intrinsics.checkNotNullExpressionValue(packageName, "getPackageName(...)");
        try {
            PackageInfo packageInfo = packageManager.getPackageInfo(packageName, 0);
            Intrinsics.checkNotNullExpressionValue(packageInfo, "getPackageInfo(...)");
            ApplicationInfo applicationInfo = packageInfo.applicationInfo;
            return "Android/data/" + String.valueOf((applicationInfo == null || (str = applicationInfo.dataDir) == null) ? null : StringsKt.substringAfter$default(str, "/0/", (String) null, 2, (Object) null)) + "/files/SAMP/";
        } catch (PackageManager.NameNotFoundException e) {
            Log.w(HttpHeaders.AUTHORIZATION, "Error Package name not found ", e);
            return null;
        }
    }

    public final BackgroundVideoBinding getMainBinding() {
        return this.videoBackgroundBinding;
    }

    /* compiled from: RegistrationVideoBackground.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, d2 = {"Lru/mrlargha/commonui/elements/authorization/presentation/screen/RegistrationVideoBackground$Spawner;", "Lru/mrlargha/commonui/core/UIElementAbstractSpawner;", "<init>", "()V", "create", "Lru/mrlargha/commonui/core/SAMPUIElement;", "targetActivity", "Landroid/app/Activity;", "backendID", "", "CommonUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Spawner extends UIElementAbstractSpawner {
        @Override // ru.mrlargha.commonui.core.UIElementAbstractSpawner
        public SAMPUIElement create(Activity targetActivity, int i) {
            Intrinsics.checkNotNullParameter(targetActivity, "targetActivity");
            return new RegistrationVideoBackground(targetActivity, i);
        }
    }
}
