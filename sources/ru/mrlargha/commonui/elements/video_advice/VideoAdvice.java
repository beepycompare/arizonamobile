package ru.mrlargha.commonui.elements.video_advice;

import android.app.Activity;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.MediaController;
import android.widget.Toast;
import androidx.media3.common.MediaItem;
import androidx.media3.common.Player;
import androidx.media3.exoplayer.ExoPlayer;
import androidx.media3.ui.PlayerView;
import com.google.common.net.HttpHeaders;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import ru.mrlargha.commonui.R;
import ru.mrlargha.commonui.core.SAMPUIElement;
import ru.mrlargha.commonui.core.UIElementAbstractSpawner;
import ru.mrlargha.commonui.databinding.VideoAdviceBinding;
/* compiled from: VideoAdvice.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\u0018\u00002\u00020\u0001:\u0001\u001bB\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0005H\u0016J\b\u0010\u0013\u001a\u00020\u000fH\u0002J\u0010\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u0011H\u0002J\b\u0010\u0016\u001a\u00020\u000fH\u0002J\u0010\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0018\u001a\u00020\u0005H\u0002J\n\u0010\u0019\u001a\u0004\u0018\u00010\u0011H\u0002J\u0006\u0010\u001a\u001a\u00020\u000bR\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lru/mrlargha/commonui/elements/video_advice/VideoAdvice;", "Lru/mrlargha/commonui/core/SAMPUIElement;", "targetActivity", "Landroid/app/Activity;", "backendID", "", "<init>", "(Landroid/app/Activity;I)V", "videoBackground", "Landroid/widget/FrameLayout;", "videoBackgroundBinding", "Lru/mrlargha/commonui/databinding/VideoAdviceBinding;", "playerItem", "Landroidx/media3/exoplayer/ExoPlayer;", "onBackendMessage", "", "data", "", "subId", "setupListeners", "playVideo", "path", "closeVideo", "showSkipQuest", "isShow", "getSAMPPath", "getMainBinding", "Spawner", "CommonUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class VideoAdvice extends SAMPUIElement {
    private ExoPlayer playerItem;
    private final FrameLayout videoBackground;
    private final VideoAdviceBinding videoBackgroundBinding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VideoAdvice(Activity targetActivity, int i) {
        super(targetActivity, i);
        Intrinsics.checkNotNullParameter(targetActivity, "targetActivity");
        View inflate = targetActivity.getLayoutInflater().inflate(R.layout.video_advice, (ViewGroup) null);
        Intrinsics.checkNotNull(inflate, "null cannot be cast to non-null type android.widget.FrameLayout");
        FrameLayout frameLayout = (FrameLayout) inflate;
        this.videoBackground = frameLayout;
        VideoAdviceBinding bind = VideoAdviceBinding.bind(frameLayout);
        Intrinsics.checkNotNullExpressionValue(bind, "bind(...)");
        this.videoBackgroundBinding = bind;
        ExoPlayer build = new ExoPlayer.Builder(targetActivity).build();
        Intrinsics.checkNotNullExpressionValue(build, "build(...)");
        this.playerItem = build;
        addViewToConstraintLayout(frameLayout, -1, -1);
        setupListeners();
    }

    @Override // ru.mrlargha.commonui.core.SAMPUIElement
    public void onBackendMessage(String data, int i) {
        Intrinsics.checkNotNullParameter(data, "data");
        if (i == VideoAdviceIds.PLAY_VIDEO.getSubId()) {
            playVideo(data);
        } else if (i == VideoAdviceIds.CLOSE_VIDEO.getSubId()) {
            closeVideo();
        } else if (i == VideoAdviceIds.SHOW_SKIP_QUEST.getSubId()) {
            showSkipQuest(Integer.parseInt(data));
        }
    }

    private final void setupListeners() {
        this.videoBackgroundBinding.btnSkip.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.video_advice.VideoAdvice$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VideoAdvice.setupListeners$lambda$0(VideoAdvice.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupListeners$lambda$0(VideoAdvice videoAdvice, View view) {
        SAMPUIElement.notifyClick$default(videoAdvice, 0, VideoAdviceIds.SKIP_QUEST.getSubId(), null, 4, null);
    }

    private final void playVideo(String str) {
        new MediaController(getTargetActivity()).setVisibility(8);
        PlayerView playerView = this.videoBackgroundBinding.videoAdviceBg;
        try {
            this.videoBackground.setVisibility(0);
            this.videoBackgroundBinding.videoAdvice.setVisibility(0);
            this.videoBackgroundBinding.videoAdviceBg.setVisibility(0);
            File file = new File(Environment.getExternalStorageDirectory(), getSAMPPath() + str);
            if (file.exists()) {
                Uri parse = Uri.parse(file.getPath());
                Intrinsics.checkNotNullExpressionValue(parse, "parse(...)");
                ExoPlayer build = new ExoPlayer.Builder(getTargetActivity()).build();
                Intrinsics.checkNotNullExpressionValue(build, "build(...)");
                this.playerItem = build;
                playerView.setPlayer(build);
                MediaItem fromUri = MediaItem.fromUri(parse);
                Intrinsics.checkNotNullExpressionValue(fromUri, "fromUri(...)");
                this.playerItem.setMediaItem(fromUri);
                this.playerItem.addListener(new Player.Listener() { // from class: ru.mrlargha.commonui.elements.video_advice.VideoAdvice$playVideo$1$1
                    @Override // androidx.media3.common.Player.Listener
                    public void onPlaybackStateChanged(int i) {
                        ExoPlayer exoPlayer;
                        ExoPlayer exoPlayer2;
                        if (i == 4) {
                            exoPlayer = VideoAdvice.this.playerItem;
                            exoPlayer.stop();
                            exoPlayer2 = VideoAdvice.this.playerItem;
                            exoPlayer2.release();
                            SAMPUIElement.notifyClick$default(VideoAdvice.this, 0, VideoAdviceIds.STOP_VIDEO.getSubId(), null, 4, null);
                        }
                    }
                });
                this.playerItem.prepare();
                this.playerItem.play();
                return;
            }
            Toast.makeText(getTargetActivity(), "Видео файл не найден в памяти устройства. Сбросьте игру!", 1).show();
        } catch (Exception e) {
            Toast.makeText(getTargetActivity(), "Ошибка воспроизведения видео!", 1).show();
            e.printStackTrace();
            Log.e("videoAdviceBinding", "Can't start video");
        }
    }

    private final void closeVideo() {
        this.playerItem.stop();
        this.playerItem.release();
        this.videoBackground.setVisibility(8);
        this.videoBackgroundBinding.videoAdvice.setVisibility(8);
        this.videoBackgroundBinding.videoAdviceBg.setVisibility(8);
    }

    private final void showSkipQuest(int i) {
        LinearLayout skipQuest = this.videoBackgroundBinding.skipQuest;
        Intrinsics.checkNotNullExpressionValue(skipQuest, "skipQuest");
        skipQuest.setVisibility(i == 0 ? 8 : 0);
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

    public final VideoAdviceBinding getMainBinding() {
        return this.videoBackgroundBinding;
    }

    /* compiled from: VideoAdvice.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, d2 = {"Lru/mrlargha/commonui/elements/video_advice/VideoAdvice$Spawner;", "Lru/mrlargha/commonui/core/UIElementAbstractSpawner;", "<init>", "()V", "create", "Lru/mrlargha/commonui/core/SAMPUIElement;", "targetActivity", "Landroid/app/Activity;", "backendID", "", "CommonUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Spawner extends UIElementAbstractSpawner {
        @Override // ru.mrlargha.commonui.core.UIElementAbstractSpawner
        public SAMPUIElement create(Activity targetActivity, int i) {
            Intrinsics.checkNotNullParameter(targetActivity, "targetActivity");
            return new VideoAdvice(targetActivity, i);
        }
    }
}
