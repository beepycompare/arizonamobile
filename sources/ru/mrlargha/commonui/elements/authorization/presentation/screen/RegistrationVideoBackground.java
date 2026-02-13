package ru.mrlargha.commonui.elements.authorization.presentation.screen;

import android.app.Activity;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.media3.common.MediaItem;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.Player;
import androidx.media3.exoplayer.ExoPlayer;
import com.arizona.game.BuildConfig;
import com.google.common.net.HttpHeaders;
import com.liulishuo.okdownload.core.breakpoint.BreakpointSQLiteKey;
import java.io.File;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import ru.mrlargha.commonui.R;
import ru.mrlargha.commonui.core.SAMPUIElement;
import ru.mrlargha.commonui.core.UIElementAbstractSpawner;
import ru.mrlargha.commonui.core.UIElementID;
import ru.mrlargha.commonui.databinding.BackgroundVideoBinding;
import ru.mrlargha.commonui.elements.authorization.domain.controller.RegistrationInterfaceType;
import ru.mrlargha.commonui.elements.authorization.domain.controller.RegistrationServerResponse;
import ru.mrlargha.commonui.elements.authorization.domain.controller.RegistrationVideoModeType;
import ru.mrlargha.commonui.elements.authorization.presentation.InterfaceController;
import ru.mrlargha.commonui.elements.authorization.presentation.InterfaceManager;
/* compiled from: RegistrationVideoBackground.kt */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002:\u00012B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0013H\u0016J\u000e\u0010\u0019\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u000eJ\u0018\u0010\u001b\u001a\u00020\u00172\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0006H\u0016J\u0010\u0010\u001f\u001a\u00020\u00172\u0006\u0010 \u001a\u00020\u001dH\u0002J\u0010\u0010!\u001a\u00020\u00172\u0006\u0010\"\u001a\u00020\u001dH\u0002J\u0010\u0010#\u001a\u00020\u00172\u0006\u0010$\u001a\u00020\u001dH\u0002J\u0010\u0010%\u001a\u00020\u00172\u0006\u0010\u001c\u001a\u00020\u001dH\u0002J\b\u0010&\u001a\u00020\u0017H\u0002J\u0010\u0010'\u001a\u00020\u00172\u0006\u0010\u001c\u001a\u00020\u001dH\u0002J\u0018\u0010(\u001a\u00020\u00172\u0006\u0010)\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u001dH\u0002J\u0010\u0010*\u001a\u00020\u00172\u0006\u0010\u001c\u001a\u00020\u001dH\u0002J\u0010\u0010+\u001a\u00020\u00172\u0006\u0010\u001c\u001a\u00020\u001dH\u0002J\n\u0010,\u001a\u0004\u0018\u00010\u001dH\u0002J\u0006\u0010-\u001a\u00020\fJ\b\u0010.\u001a\u00020\u0017H\u0002J\u0010\u0010/\u001a\u00020\u00172\u0006\u00100\u001a\u00020\u001dH\u0002J\u0010\u00101\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0013H\u0016R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00063"}, d2 = {"Lru/mrlargha/commonui/elements/authorization/presentation/screen/RegistrationVideoBackground;", "Lru/mrlargha/commonui/core/SAMPUIElement;", "Lru/mrlargha/commonui/elements/authorization/presentation/InterfaceController;", "targetActivity", "Landroid/app/Activity;", "backendID", "", "<init>", "(Landroid/app/Activity;I)V", "videoBackground", "Landroidx/constraintlayout/widget/ConstraintLayout;", "videoBackgroundBinding", "Lru/mrlargha/commonui/databinding/BackgroundVideoBinding;", "lastChoseVideo", "Lru/mrlargha/commonui/elements/authorization/domain/controller/RegistrationVideoModeType;", "sharedPref", "Landroid/content/SharedPreferences;", "sharedPreferencesUI", "isVisible", "", "player", "Landroidx/media3/exoplayer/ExoPlayer;", "setVisibility", "", "visible", "selectVideoMode", "videoMode", "onBackendMessage", "data", "", "subId", "preload", "flavorType", "gameFlavorType", "type", "setAwaitText", "text", "pushSelectSpawnData", "showAuthInterface", "pushRecoveryResponse", "pushAuthServerInfo", "actionId", "pushRegistrationAccountResponse", "pushPedSettingsResponse", "getSAMPPath", "getMainBinding", "stopVideo", "setVideo", BreakpointSQLiteKey.FILENAME, "setVisible", "Spawner", "CommonUI_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class RegistrationVideoBackground extends SAMPUIElement implements InterfaceController {
    private boolean isVisible;
    private RegistrationVideoModeType lastChoseVideo;
    private ExoPlayer player;
    private final SharedPreferences sharedPref;
    private final SharedPreferences sharedPreferencesUI;
    private final ConstraintLayout videoBackground;
    private final BackgroundVideoBinding videoBackgroundBinding;

    /* compiled from: RegistrationVideoBackground.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes6.dex */
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
        SharedPreferences sharedPreferences2 = targetActivity.getSharedPreferences(SAMPUIElement.SP_NAME, 0);
        Intrinsics.checkNotNullExpressionValue(sharedPreferences2, "getSharedPreferences(...)");
        this.sharedPreferencesUI = sharedPreferences2;
        ExoPlayer build = new ExoPlayer.Builder(targetActivity).build();
        Intrinsics.checkNotNullExpressionValue(build, "build(...)");
        this.player = build;
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
        if (this.lastChoseVideo == videoMode) {
            Player player = this.videoBackgroundBinding.playerView.getPlayer();
            if (player != null ? player.isPlaying() : false) {
                return;
            }
        }
        if (getTargetActivity().findViewById(R.id.video) != null) {
            Log.e(MimeTypes.BASE_TYPE_VIDEO, "selectVideoMode: is has " + this.isVisible);
            if (!this.isVisible) {
                setVisibility(true);
                ConstraintLayout video = this.videoBackgroundBinding.video;
                Intrinsics.checkNotNullExpressionValue(video, "video");
                video.setVisibility(0);
            }
        } else {
            Log.e(MimeTypes.BASE_TYPE_VIDEO, "selectVideoMode: is haven't");
        }
        ConstraintLayout root = this.videoBackgroundBinding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        root.setVisibility(0);
        int i = WhenMappings.$EnumSwitchMapping$0[videoMode.ordinal()];
        if (i == 1) {
            this.lastChoseVideo = videoMode;
            this.videoBackground.setVisibility(0);
            this.videoBackgroundBinding.video.setVisibility(0);
            this.videoBackgroundBinding.playerView.setVisibility(0);
            setVideo("/SAMP/auth_video.webm");
        } else if (i == 2) {
            this.lastChoseVideo = videoMode;
            this.videoBackground.setVisibility(0);
            this.videoBackgroundBinding.video.setVisibility(0);
            this.videoBackgroundBinding.playerView.setVisibility(0);
            setVideo("/SAMP/registration_video.webm");
        } else if (i != 3) {
            if (i != 4) {
                throw new NoWhenBranchMatchedException();
            }
            stopVideo();
        } else {
            stopVideo();
            if (this.videoBackground.getVisibility() != 8) {
                this.videoBackground.setVisibility(8);
            }
            if (this.videoBackgroundBinding.video.getVisibility() != 8) {
                this.videoBackgroundBinding.video.setVisibility(8);
            }
        }
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

    private final void stopVideo() {
        this.videoBackgroundBinding.playerView.setVisibility(8);
        this.player.stop();
        this.player.release();
    }

    private final void setVideo(String str) {
        try {
            this.player.stop();
            this.player.release();
            this.videoBackgroundBinding.playerView.setVisibility(0);
            File file = new File(getTargetActivity().getExternalFilesDir(null), str);
            if (file.exists()) {
                Uri parse = Uri.parse(file.getPath());
                Intrinsics.checkNotNullExpressionValue(parse, "parse(...)");
                ExoPlayer build = new ExoPlayer.Builder(getTargetActivity()).build();
                Intrinsics.checkNotNullExpressionValue(build, "build(...)");
                this.player = build;
                this.videoBackgroundBinding.playerView.setPlayer(this.player);
                MediaItem fromUri = MediaItem.fromUri(parse);
                Intrinsics.checkNotNullExpressionValue(fromUri, "fromUri(...)");
                this.player.setMediaItem(fromUri);
                this.player.prepare();
                this.player.setRepeatMode(1);
                this.player.play();
                return;
            }
            Toast.makeText(getTargetActivity(), "Видео файл не найден в памяти устройства. Сбросьте игру!", 1).show();
        } catch (Exception e) {
            Toast.makeText(getTargetActivity(), "Ошибка воспроизведения видео. Сбросьте игру!", 1).show();
            e.printStackTrace();
            Log.e("videoEasterBinding", "Can't start video");
        }
    }

    /* compiled from: RegistrationVideoBackground.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016R\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lru/mrlargha/commonui/elements/authorization/presentation/screen/RegistrationVideoBackground$Spawner;", "Lru/mrlargha/commonui/core/UIElementAbstractSpawner;", "<init>", "()V", "create", "Lru/mrlargha/commonui/core/SAMPUIElement;", "targetActivity", "Landroid/app/Activity;", "backendID", "", "correctIds", "", "Lru/mrlargha/commonui/core/UIElementID;", "getCorrectIds", "()Ljava/util/Set;", "CommonUI_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class Spawner extends UIElementAbstractSpawner {
        private final Set<UIElementID> correctIds = SetsKt.setOf(UIElementID.AUTHORIZATION);

        @Override // ru.mrlargha.commonui.core.UIElementAbstractSpawner
        public SAMPUIElement create(Activity targetActivity, int i) {
            Intrinsics.checkNotNullParameter(targetActivity, "targetActivity");
            return new RegistrationVideoBackground(targetActivity, i);
        }

        @Override // ru.mrlargha.commonui.core.UIElementAbstractSpawner
        public Set<UIElementID> getCorrectIds() {
            return this.correctIds;
        }
    }
}
