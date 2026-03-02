package ru.mrlargha.feature.mobile.presentation.page.spotify;

import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import androidx.core.app.NotificationCompat;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.Charsets;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import ru.mrlargha.commonui.core.IBackendNotifier;
import ru.mrlargha.commonui.core.UIElementID;
import ru.mrlargha.feature.mobile.R;
import ru.mrlargha.feature.mobile.databinding.MobilePhoneSpotifyPageBinding;
import ru.mrlargha.feature.mobile.presentation.page.spotify.SpotifyPage;
import ru.mrlargha.feature.mobile.presentation.page.spotify.api.obj.ArizonaSpotifyTrackResponse;
/* compiled from: SpotifyPage.kt */
@Metadata(d1 = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001J0\u0010\u0004\u001a\u00020\u00052\u0012\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u00072\u0012\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\tH\u0016J$\u0010\n\u001a\u00020\u00052\u0012\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u00072\u0006\u0010\u000b\u001a\u00020\fH\u0016¨\u0006\r"}, d2 = {"ru/mrlargha/feature/mobile/presentation/page/spotify/SpotifyPage$addPlayedTrack$2", "Lretrofit2/Callback;", "", "Lru/mrlargha/feature/mobile/presentation/page/spotify/api/obj/ArizonaSpotifyTrackResponse;", "onResponse", "", NotificationCompat.CATEGORY_CALL, "Lretrofit2/Call;", "response", "Lretrofit2/Response;", "onFailure", "t", "", "mobile"}, k = 1, mv = {2, 3, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class SpotifyPage$addPlayedTrack$2 implements Callback<List<? extends ArizonaSpotifyTrackResponse>> {
    final /* synthetic */ int $second;
    final /* synthetic */ int $trackId;
    final /* synthetic */ ArrayList<ArizonaSpotifyTrackResponse> $trackList;
    final /* synthetic */ SpotifyPage this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public SpotifyPage$addPlayedTrack$2(SpotifyPage spotifyPage, int i, int i2, ArrayList<ArizonaSpotifyTrackResponse> arrayList) {
        this.this$0 = spotifyPage;
        this.$trackId = i;
        this.$second = i2;
        this.$trackList = arrayList;
    }

    @Override // retrofit2.Callback
    public void onResponse(Call<List<? extends ArizonaSpotifyTrackResponse>> call, Response<List<? extends ArizonaSpotifyTrackResponse>> response) {
        CountDownTimer countDownTimer;
        Object obj;
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(response, "response");
        List<? extends ArizonaSpotifyTrackResponse> body = response.body();
        if (body != null) {
            final SpotifyPage spotifyPage = this.this$0;
            int i = this.$trackId;
            final int i2 = this.$second;
            final ArrayList<ArizonaSpotifyTrackResponse> arrayList = this.$trackList;
            Iterator<T> it = body.iterator();
            while (true) {
                countDownTimer = null;
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                if (((ArizonaSpotifyTrackResponse) obj).getId() == i) {
                    break;
                }
            }
            final ArizonaSpotifyTrackResponse arizonaSpotifyTrackResponse = (ArizonaSpotifyTrackResponse) obj;
            final MobilePhoneSpotifyPageBinding mobilePhoneSpotifyPageBinding = spotifyPage.spotifyPageBinding;
            mobilePhoneSpotifyPageBinding.mpSpotifySingerName.setText(arizonaSpotifyTrackResponse != null ? arizonaSpotifyTrackResponse.getArtistName() : null);
            mobilePhoneSpotifyPageBinding.mpSpotifySongName.setText(arizonaSpotifyTrackResponse != null ? arizonaSpotifyTrackResponse.getSongName() : null);
            final TextView textView = mobilePhoneSpotifyPageBinding.mpSpotifySongName;
            textView.setSelected(true);
            textView.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: ru.mrlargha.feature.mobile.presentation.page.spotify.SpotifyPage$addPlayedTrack$2$$ExternalSyntheticLambda0
                @Override // android.view.View.OnFocusChangeListener
                public final void onFocusChange(View view, boolean z) {
                    textView.setSelected(true);
                }
            });
            mobilePhoneSpotifyPageBinding.mpSpotifySongLive.setVisibility(8);
            Integer valueOf = arizonaSpotifyTrackResponse != null ? Integer.valueOf((arizonaSpotifyTrackResponse.getDuration() - i2) * 1000) : null;
            final double duration = 100.0d / (arizonaSpotifyTrackResponse != null ? arizonaSpotifyTrackResponse.getDuration() : 0);
            spotifyPage.playerInfoVisible(true);
            final Ref.IntRef intRef = new Ref.IntRef();
            mobilePhoneSpotifyPageBinding.mpSpotifySeekBar.setVisibility(0);
            final Ref.DoubleRef doubleRef = new Ref.DoubleRef();
            doubleRef.element = i2 * duration;
            mobilePhoneSpotifyPageBinding.mpSpotifySeekBar.setProgress((int) Math.floor(doubleRef.element));
            spotifyPage.spotifyPageBinding.mpSpotifyPlay.setImageResource(R.drawable.spotify_play_off);
            spotifyPage.currentTrackProgressInSec = i2;
            final long intValue = valueOf != null ? valueOf.intValue() : 0L;
            spotifyPage.timer = new CountDownTimer(intValue) { // from class: ru.mrlargha.feature.mobile.presentation.page.spotify.SpotifyPage$addPlayedTrack$2$onResponse$1$1$2
                @Override // android.os.CountDownTimer
                public void onTick(long j) {
                    SpotifyPage.this.currentTrackProgressInSec++;
                    intRef.element += 1000;
                    doubleRef.element += duration;
                    mobilePhoneSpotifyPageBinding.mpSpotifySongTime.setText(((((i2 * 1000) + intRef.element) / 1000) / 60) + StringUtils.PROCESS_POSTFIX_DELIMITER + ((((i2 * 1000) + intRef.element) / 1000) % 60));
                    mobilePhoneSpotifyPageBinding.mpSpotifySeekBar.setProgress((int) Math.floor(doubleRef.element));
                }

                @Override // android.os.CountDownTimer
                public void onFinish() {
                    SpotifyPage.this.playerInfoVisible(false);
                    int indexOf = CollectionsKt.indexOf((List<? extends ArizonaSpotifyTrackResponse>) arrayList, arizonaSpotifyTrackResponse) + 1;
                    if (indexOf < arrayList.size()) {
                        mobilePhoneSpotifyPageBinding.mpSpotifySeekBar.setProgress(0);
                        IBackendNotifier iBackendNotifier = SpotifyPage.this.sendFrontedMessage;
                        int id = UIElementID.ARIZONA_MOBILE_PHONE.getId();
                        int id2 = arrayList.get(indexOf).getId();
                        int id3 = arrayList.get(indexOf).getId();
                        byte[] bytes = (id3 + ",0," + SpotifyPage.this.currentCategoryId).getBytes(Charsets.UTF_8);
                        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
                        iBackendNotifier.clickedWrapper(id, id2, 17, bytes);
                        SpotifyPage.Companion companion = SpotifyPage.Companion;
                        SpotifyPage.isTrackPlaying = true;
                        SpotifyPage.this.playingTrackId = Integer.valueOf(arrayList.get(indexOf).getId());
                        SpotifyPage.this.addPlayedTrack(arrayList.get(indexOf).getId(), 0);
                    }
                }
            };
            CountDownTimer countDownTimer2 = spotifyPage.timer;
            if (countDownTimer2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("timer");
            } else {
                countDownTimer = countDownTimer2;
            }
            countDownTimer.start();
        }
    }

    @Override // retrofit2.Callback
    public void onFailure(Call<List<? extends ArizonaSpotifyTrackResponse>> call, Throwable t) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(t, "t");
        Log.d("SpotifyPage", "error get track by id");
    }
}
